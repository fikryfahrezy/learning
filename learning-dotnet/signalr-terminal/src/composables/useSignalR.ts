import * as signalR from '@microsoft/signalr'
import { reactive, ref, computed } from 'vue'
import type { MarketState, PriceUpdate, Transaction } from '../types/trading'

const INITIAL_CASH = 10_000

const state = reactive<MarketState>({
  isOpen: false,
  stocks: [],
  recentTransactions: [],
})

const wallet = reactive({
  cash: INITIAL_CASH,
  holdings: {} as Record<string, number>,
})

const portfolioValue = computed(() =>
  Object.entries(wallet.holdings).reduce((sum, [sym, qty]) => {
    const stock = state.stocks.find((s) => s.symbol === sym)
    return sum + (stock ? stock.price * qty : 0)
  }, 0),
)

const totalEquity = computed(() => wallet.cash + portfolioValue.value)
const pnl = computed(() => totalEquity.value - INITIAL_CASH)
const pnlPercent = computed(() => (pnl.value / INITIAL_CASH) * 100)

const isConnected = ref(false)
const tradeMessage = ref<{ text: string; type: 'success' | 'error' } | null>(null)

const connection = new signalR.HubConnectionBuilder()
  .withUrl('/hub')
  .withAutomaticReconnect()
  .build()

connection.on('priceUpdates', (updates: PriceUpdate[]) => {
  for (const u of updates) {
    const stock = state.stocks.find((s) => s.symbol === u.symbol)
    if (!stock) continue
    stock.price = u.price
    stock.change = u.change
    stock.changePercent = u.changePercent
    stock.history.push({ timestamp: u.timestamp, price: u.price })
    if (stock.history.length > 300) stock.history.shift()
  }
})

connection.on('transactionOccurred', (tx: Transaction) => {
  state.recentTransactions.unshift(tx)
  if (state.recentTransactions.length > 50) state.recentTransactions.pop()

  if (tx.trader === 'You') {
    const total = tx.price * tx.quantity
    if (tx.type === 'BUY') {
      wallet.cash -= total
      wallet.holdings[tx.symbol] = (wallet.holdings[tx.symbol] ?? 0) + tx.quantity
    } else {
      wallet.cash += total
      const remaining = (wallet.holdings[tx.symbol] ?? 0) - tx.quantity
      if (remaining <= 0) delete wallet.holdings[tx.symbol]
      else wallet.holdings[tx.symbol] = remaining
    }
  }
})

connection.on('marketStatusChanged', (isOpen: boolean) => {
  state.isOpen = isOpen
})

connection.on('tradeError', (msg: string) => {
  showMessage(msg, 'error')
})

connection.onreconnecting(() => {
  isConnected.value = false
})
connection.onreconnected(() => {
  isConnected.value = true
})
connection.onclose(() => {
  isConnected.value = false
})

async function connect() {
  try {
    await connection.start()
    isConnected.value = true
    const snapshot = await connection.invoke<MarketState>('GetMarketState')
    state.isOpen = snapshot.isOpen
    state.stocks = snapshot.stocks
    state.recentTransactions = snapshot.recentTransactions
  } catch (e) {
    console.error('SignalR connection failed:', e)
  }
}

function showMessage(text: string, type: 'success' | 'error') {
  tradeMessage.value = { text, type }
  setTimeout(() => (tradeMessage.value = null), 3000)
}

connect()

export { wallet, portfolioValue, totalEquity, pnl, pnlPercent, INITIAL_CASH }

export function useTrading() {
  async function toggleMarket() {
    await connection.invoke('ToggleMarket')
  }

  async function trade(symbol: string, type: 'BUY' | 'SELL', quantity: number) {
    const stock = state.stocks.find((s) => s.symbol === symbol)
    if (!stock) return

    if (type === 'BUY') {
      const cost = stock.price * quantity
      if (wallet.cash < cost) {
        showMessage(
          `Not enough cash — need $${cost.toFixed(2)}, have $${wallet.cash.toFixed(2)}`,
          'error',
        )
        return
      }
    } else {
      const held = wallet.holdings[symbol] ?? 0
      if (held < quantity) {
        showMessage(`Not enough shares — have ${held} ${symbol}, need ${quantity}`, 'error')
        return
      }
    }

    const method = type === 'BUY' ? 'BuyStock' : 'SellStock'
    await connection.invoke(method, { symbol, quantity })
  }

  function resetWallet() {
    wallet.cash = INITIAL_CASH
    Object.keys(wallet.holdings).forEach((k) => delete wallet.holdings[k])
    showMessage('Wallet reset to $10,000', 'success')
  }

  return { state, isConnected, tradeMessage, toggleMarket, trade, resetWallet }
}
