namespace SignalRWebpack.Models;

public record PricePoint(long Timestamp, double Price);

public record StockSnapshot(
    string Symbol,
    string Name,
    double Price,
    double Open,
    double High,
    double Low,
    double Change,
    double ChangePercent,
    List<PricePoint> History);

public record Transaction(
    string Id,
    string Symbol,
    string Type,
    double Price,
    int Quantity,
    long Timestamp,
    string Trader);

public record MarketStateSnapshot(
    bool IsOpen,
    List<StockSnapshot> Stocks,
    List<Transaction> RecentTransactions);

public record TradeRequest(string Symbol, int Quantity);
