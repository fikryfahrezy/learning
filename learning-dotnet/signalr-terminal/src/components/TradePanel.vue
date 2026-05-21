<script setup lang="ts">
import { ref } from 'vue'

const props = defineProps<{
  symbol: string
  price: number
  isOpen: boolean
}>()

const emit = defineEmits<{ trade: [type: 'BUY' | 'SELL', quantity: number] }>()

const quantity = ref(10)
const quickQtys = [1, 5, 10, 50, 100]

function trade(type: 'BUY' | 'SELL') {
  if (quantity.value > 0 && props.isOpen) emit('trade', type, quantity.value)
}
</script>

<template>
  <div class="trade-panel">
    <div class="tp-header">TRADE {{ symbol }}</div>
    <div class="tp-price">Market: <strong>${{ price.toFixed(2) }}</strong></div>

    <div class="tp-qty">
      <label>Quantity</label>
      <div class="tp-quick">
        <button
          v-for="q in quickQtys"
          :key="q"
          class="q-btn"
          :class="{ active: quantity === q }"
          @click="quantity = q"
        >
          {{ q }}
        </button>
      </div>
      <input v-model.number="quantity" type="number" min="1" max="99999" class="q-input" />
    </div>

    <div class="tp-actions">
      <button class="btn-buy" :disabled="!isOpen" @click="trade('BUY')">BUY {{ symbol }}</button>
      <button class="btn-sell" :disabled="!isOpen" @click="trade('SELL')">SELL {{ symbol }}</button>
    </div>

    <div v-if="!isOpen" class="tp-closed">Market is closed</div>
  </div>
</template>
