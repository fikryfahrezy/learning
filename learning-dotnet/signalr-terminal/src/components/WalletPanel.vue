<script setup lang="ts">
import { useTrading, wallet, portfolioValue, totalEquity, pnl, pnlPercent, INITIAL_CASH } from '../composables/useSignalR'

const { state, resetWallet } = useTrading()

function fmt(n: number): string {
  return n.toLocaleString('en-US', { minimumFractionDigits: 2, maximumFractionDigits: 2 })
}

function sign(n: number): string {
  return n >= 0 ? '+' : ''
}

function getPrice(symbol: string): number {
  return state.stocks.find((s) => s.symbol === symbol)?.price ?? 0
}
</script>

<template>
  <div class="wallet-panel">
    <div class="wp-header">
      <span>WALLET</span>
      <button class="wp-reset" @click="resetWallet">RESET</button>
    </div>

    <div class="wp-body">
      <div class="wp-row">
        <span class="wp-label">Cash</span>
        <span class="wp-val">${{ fmt(wallet.cash) }}</span>
      </div>
      <div class="wp-row">
        <span class="wp-label">Portfolio</span>
        <span class="wp-val">${{ fmt(portfolioValue) }}</span>
      </div>

      <div class="wp-divider"></div>

      <div class="wp-row wp-equity">
        <span class="wp-label">Equity</span>
        <span class="wp-val">${{ fmt(totalEquity) }}</span>
      </div>
      <div class="wp-row" :class="pnl >= 0 ? 'positive' : 'negative'">
        <span class="wp-label">P&amp;L</span>
        <span class="wp-val wp-pnl">
          {{ sign(pnl) }}${{ fmt(Math.abs(pnl)) }}
          <span class="wp-pct">({{ sign(pnlPercent) }}{{ pnlPercent.toFixed(2) }}%)</span>
        </span>
      </div>
    </div>

    <div v-if="Object.keys(wallet.holdings).length" class="wp-holdings">
      <div class="wp-holdings-title">HOLDINGS</div>
      <div v-for="(qty, sym) in wallet.holdings" :key="sym" class="wp-holding">
        <span class="wh-sym">{{ sym }}</span>
        <span class="wh-qty">{{ qty }} sh</span>
        <span class="wh-val">${{ fmt(getPrice(sym as string) * qty) }}</span>
      </div>
    </div>

    <div class="wp-footer">
      Initial: ${{ fmt(INITIAL_CASH) }}
    </div>
  </div>
</template>
