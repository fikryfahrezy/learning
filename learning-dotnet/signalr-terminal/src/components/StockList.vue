<script setup lang="ts">
import type { StockSnapshot } from '../types/trading'

defineProps<{
  stocks: StockSnapshot[]
  selected: string
}>()

const emit = defineEmits<{ select: [symbol: string] }>()
</script>

<template>
  <div class="ticker-bar">
    <button
      v-for="s in stocks"
      :key="s.symbol"
      class="ticker-item"
      :class="{ active: s.symbol === selected, positive: s.change >= 0, negative: s.change < 0 }"
      @click="emit('select', s.symbol)"
    >
      <span class="ti-symbol">{{ s.symbol }}</span>
      <span class="ti-price">${{ s.price.toFixed(2) }}</span>
      <span class="ti-change">
        {{ s.change >= 0 ? '▲' : '▼' }}{{ Math.abs(s.changePercent).toFixed(2) }}%
      </span>
    </button>
  </div>
</template>
