export interface PricePoint {
  timestamp: number
  price: number
}

export interface StockSnapshot {
  symbol: string
  name: string
  price: number
  open: number
  high: number
  low: number
  change: number
  changePercent: number
  history: PricePoint[]
}

export interface Transaction {
  id: string
  symbol: string
  type: 'BUY' | 'SELL'
  price: number
  quantity: number
  timestamp: number
  trader: string
}

export interface MarketState {
  isOpen: boolean
  stocks: StockSnapshot[]
  recentTransactions: Transaction[]
}

export interface PriceUpdate {
  symbol: string
  price: number
  change: number
  changePercent: number
  timestamp: number
}
