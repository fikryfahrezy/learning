<script setup lang="ts">
import { computed, ref } from 'vue'
import { useTrading } from './composables/useSignalR'
import { useTheme } from './composables/useTheme'
import StockList from './components/StockList.vue'
import StockChart from './components/StockChart.vue'
import TransactionFeed from './components/TransactionFeed.vue'
import TradePanel from './components/TradePanel.vue'
import WalletPanel from './components/WalletPanel.vue'

const { state, isConnected, tradeMessage, toggleMarket, trade } = useTrading()
const { mode, setMode } = useTheme()

const selectedSymbol = ref('AAPL')
const selectedStock = computed(() => state.stocks.find((s) => s.symbol === selectedSymbol.value) ?? null)

function handleTrade(type: 'BUY' | 'SELL', quantity: number) {
  trade(selectedSymbol.value, type, quantity)
}
</script>

<template>
  <div class="terminal">
    <!-- Header -->
    <header class="header">
      <div class="h-left">
        <span class="brand">▶ TRADING TERMINAL</span>
        <span class="conn-dot" :class="{ live: isConnected }">
          {{ isConnected ? '● LIVE' : '○ CONNECTING' }}
        </span>
      </div>

      <div class="h-center">
        <span class="mkt-status" :class="state.isOpen ? 'open' : 'closed'">
          {{ state.isOpen ? '● MARKET OPEN' : '● MARKET CLOSED' }}
        </span>
        <button class="btn-mkt" @click="toggleMarket">
          {{ state.isOpen ? 'CLOSE MARKET' : 'OPEN MARKET' }}
        </button>
      </div>

      <div class="h-right">
        <button
          v-for="m in (['light', 'dark', 'system'] as const)"
          :key="m"
          class="theme-btn"
          :class="{ active: mode === m }"
          :title="m"
          @click="setMode(m)"
        >
          {{ m === 'light' ? '☀' : m === 'dark' ? '🌙' : '⚙' }}
        </button>
      </div>
    </header>

    <!-- Toast -->
    <Transition name="toast">
      <div v-if="tradeMessage" class="toast" :class="tradeMessage.type">
        {{ tradeMessage.text }}
      </div>
    </Transition>

    <!-- Ticker Bar -->
    <StockList :stocks="state.stocks" :selected="selectedSymbol" @select="selectedSymbol = $event" />

    <!-- Main -->
    <div class="main">
      <div class="left-panel">
        <StockChart :stock="selectedStock" />
        <TradePanel
          v-if="selectedStock"
          :symbol="selectedStock.symbol"
          :price="selectedStock.price"
          :is-open="state.isOpen"
          @trade="handleTrade"
        />
      </div>
      <div class="right-panel">
        <WalletPanel />
        <TransactionFeed :transactions="state.recentTransactions" />
      </div>
    </div>
  </div>
</template>
