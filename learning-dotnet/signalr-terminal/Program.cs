using SignalRWebpack.Hubs;
using SignalRWebpack.Services;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddSignalR();
builder.Services.AddSingleton<MarketSimulatorService>();
builder.Services.AddHostedService(sp => sp.GetRequiredService<MarketSimulatorService>());

var app = builder.Build();
app.UseDefaultFiles();
app.UseStaticFiles();
app.MapHub<TradingHub>("/hub");
app.Run();
