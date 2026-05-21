using Microsoft.AspNetCore.SignalR;
using SignalRWebpack.Hubs;
using SignalRWebpack.Models;

namespace SignalRWebpack.Services;

public class MarketSimulatorService : BackgroundService
{
    private readonly IHubContext<TradingHub> _hub;
    private bool _isMarketOpen = false;
    private readonly object _lock = new();
    private readonly Random _random = new();

    private const int MaxHistory = 300;
    private const int MaxTransactions = 50;

    private static readonly string[] FakeTraders =
        ["AlgoBot_X", "QuickTrade", "MarketMaker", "HFT_Alpha", "RetailTrader", "SmartMoney", "DayTrader99", "WallStWolf", "QuantFund", "MomentumAce"];

    private readonly Dictionary<string, StockData> _stocks = new()
    {
        ["AAPL"] = new("AAPL", "Apple Inc.", 195.50, 0.004),
        ["GOOGL"] = new("GOOGL", "Alphabet Inc.", 175.30, 0.005),
        ["MSFT"] = new("MSFT", "Microsoft Corp.", 415.80, 0.003),
        ["TSLA"] = new("TSLA", "Tesla Inc.", 248.60, 0.012),
        ["AMZN"] = new("AMZN", "Amazon.com Inc.", 198.20, 0.006),
    };

    private readonly List<Transaction> _transactions = [];

    public MarketSimulatorService(IHubContext<TradingHub> hub) => _hub = hub;

    public bool ToggleMarket()
    {
        lock (_lock)
        {
            _isMarketOpen = !_isMarketOpen;
            if (_isMarketOpen)
                foreach (var s in _stocks.Values) s.OpenSession();
            return _isMarketOpen;
        }
    }

    public MarketStateSnapshot GetSnapshot()
    {
        lock (_lock)
        {
            return new(
                _isMarketOpen,
                [.. _stocks.Values.Select(s => s.ToSnapshot())],
                [.. _transactions.TakeLast(20)]);
        }
    }

    public (Transaction? Tx, bool MarketClosed, bool UnknownSymbol) ExecuteTrade(
        string symbol, string type, int qty, string trader)
    {
        lock (_lock)
        {
            if (!_isMarketOpen) return (null, true, false);
            if (!_stocks.TryGetValue(symbol, out var stock)) return (null, false, true);
            var tx = AddTransaction(symbol, type, stock.Price, qty, trader);
            return (tx, false, false);
        }
    }

    private Transaction AddTransaction(string symbol, string type, double price, int qty, string trader)
    {
        var tx = new Transaction(
            Guid.NewGuid().ToString("N")[..8].ToUpper(),
            symbol, type,
            Math.Round(price, 2), qty,
            DateTimeOffset.UtcNow.ToUnixTimeMilliseconds(),
            trader);
        _transactions.Add(tx);
        if (_transactions.Count > MaxTransactions) _transactions.RemoveAt(0);
        return tx;
    }

    protected override async Task ExecuteAsync(CancellationToken ct)
    {
        long lastTxMs = 0;

        while (!ct.IsCancellationRequested)
        {
            await Task.Delay(800, ct);

            List<object>? priceUpdates = null;
            Transaction? autoTx = null;
            var now = DateTimeOffset.UtcNow.ToUnixTimeMilliseconds();

            lock (_lock)
            {
                if (_isMarketOpen)
                {
                    priceUpdates = [.. _stocks.Values.Select(s =>
                    {
                        TickPrice(s, now);
                        return (object)new
                        {
                            symbol = s.Symbol,
                            price = Math.Round(s.Price, 2),
                            change = Math.Round(s.Price - s.Open, 2),
                            changePercent = Math.Round((s.Price - s.Open) / s.Open * 100, 2),
                            timestamp = now,
                        };
                    })];

                    if (now - lastTxMs > 1200 + _random.Next(1000))
                    {
                        lastTxMs = now;
                        var symbols = _stocks.Keys.ToArray();
                        var sym = symbols[_random.Next(symbols.Length)];
                        var type = _random.NextDouble() > 0.5 ? "BUY" : "SELL";
                        var qty = _random.Next(1, 250);
                        var trader = FakeTraders[_random.Next(FakeTraders.Length)];
                        autoTx = AddTransaction(sym, type, _stocks[sym].Price, qty, trader);
                    }
                }
            }

            if (priceUpdates is not null)
                await _hub.Clients.All.SendAsync("priceUpdates", priceUpdates, ct);
            if (autoTx is not null)
                await _hub.Clients.All.SendAsync("transactionOccurred", autoTx, ct);
        }
    }

    private void TickPrice(StockData s, long timestamp)
    {
        var meanReversion = (s.BasePrice - s.Price) / s.BasePrice * 0.3;
        var noise = (_random.NextDouble() * 2 - 1) * s.Volatility;
        s.Price = Math.Max(s.Price * (1 + meanReversion * 0.003 + noise), 0.01);

        if (s.Price > s.High) s.High = s.Price;
        if (s.Price < s.Low) s.Low = s.Price;

        s.History.Add(new PricePoint(timestamp, Math.Round(s.Price, 2)));
        if (s.History.Count > MaxHistory) s.History.RemoveAt(0);
    }
}

public class StockData(string symbol, string name, double basePrice, double volatility)
{
    public string Symbol { get; } = symbol;
    public string Name { get; } = name;
    public double BasePrice { get; } = basePrice;
    public double Volatility { get; } = volatility;
    public double Price { get; set; } = basePrice;
    public double Open { get; set; } = basePrice;
    public double High { get; set; } = basePrice;
    public double Low { get; set; } = basePrice;
    public List<PricePoint> History { get; } = [];

    public void OpenSession()
    {
        Open = Price;
        High = Price;
        Low = Price;
        History.Clear();
    }

    public StockSnapshot ToSnapshot() => new(
        Symbol, Name,
        Math.Round(Price, 2), Math.Round(Open, 2),
        Math.Round(High, 2), Math.Round(Low, 2),
        Math.Round(Price - Open, 2),
        Open > 0 ? Math.Round((Price - Open) / Open * 100, 2) : 0,
        [.. History]);
}
