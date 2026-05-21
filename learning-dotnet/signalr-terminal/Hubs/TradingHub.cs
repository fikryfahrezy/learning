using Microsoft.AspNetCore.SignalR;
using SignalRWebpack.Models;
using SignalRWebpack.Services;

namespace SignalRWebpack.Hubs;

public class TradingHub(MarketSimulatorService market) : Hub
{
    public MarketStateSnapshot GetMarketState() => market.GetSnapshot();

    public async Task ToggleMarket()
    {
        var isOpen = market.ToggleMarket();
        await Clients.All.SendAsync("marketStatusChanged", isOpen);
    }

    public async Task BuyStock(TradeRequest req)
    {
        var (tx, marketClosed, _) = market.ExecuteTrade(req.Symbol, "BUY", req.Quantity, "You");
        if (tx is not null)
            await Clients.All.SendAsync("transactionOccurred", tx);
        else if (marketClosed)
            await Clients.Caller.SendAsync("tradeError", "Market is closed");
    }

    public async Task SellStock(TradeRequest req)
    {
        var (tx, marketClosed, _) = market.ExecuteTrade(req.Symbol, "SELL", req.Quantity, "You");
        if (tx is not null)
            await Clients.All.SendAsync("transactionOccurred", tx);
        else if (marketClosed)
            await Clients.Caller.SendAsync("tradeError", "Market is closed");
    }
}
