<script setup lang="ts">
import { ref, watch } from 'vue'
import type { Transaction } from '../types/trading'

const props = defineProps<{ transactions: Transaction[] }>()

const newId = ref<string | null>(null)

watch(
  () => props.transactions[0]?.id,
  (id) => {
    if (!id) return
    newId.value = id
    setTimeout(() => (newId.value = null), 700)
  },
)

function fmt(ts: number) {
  return new Date(ts).toLocaleTimeString([], {
    hour: '2-digit',
    minute: '2-digit',
    second: '2-digit',
  })
}
</script>

<template>
  <div class="tx-feed">
    <div class="tx-header">TRANSACTIONS</div>
    <div class="tx-list">
      <div
        v-for="tx in transactions"
        :key="tx.id"
        class="tx-item"
        :class="[tx.type === 'BUY' ? 'buy' : 'sell', tx.id === newId ? 'flash' : '']"
      >
        <span class="tx-badge">{{ tx.type }}</span>
        <span class="tx-sym">{{ tx.symbol }}</span>
        <span class="tx-qty">{{ tx.quantity }}</span>
        <span class="tx-price">@${{ tx.price.toFixed(2) }}</span>
        <div class="tx-meta">
          <span class="tx-trader">{{ tx.trader }}</span>
          <span class="tx-time">{{ fmt(tx.timestamp) }}</span>
        </div>
      </div>
      <div v-if="!transactions.length" class="tx-empty">No transactions yet — open the market!</div>
    </div>
  </div>
</template>
