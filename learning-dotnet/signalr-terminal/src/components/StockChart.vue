<script setup lang="ts">
import { ref, onMounted, onUnmounted, watch } from 'vue'
import { createChart, ColorType } from 'lightweight-charts'
import type { IChartApi, ISeriesApi, UTCTimestamp } from 'lightweight-charts'
import type { StockSnapshot } from '../types/trading'
import { isDark } from '../composables/useTheme'

const props = defineProps<{ stock: StockSnapshot | null }>()

const container = ref<HTMLElement | null>(null)
let chart: IChartApi | null = null
let series: ISeriesApi<'Line'> | null = null

function chartColors() {
  return isDark.value
    ? { bg: '#161b22', text: '#8b949e', border: '#21262d', line: '#58a6ff' }
    : { bg: '#f6f8fa', text: '#656d76', border: '#d0d7de', line: '#0969da' }
}

function initChart() {
  if (!container.value) return
  const c = chartColors()
  chart = createChart(container.value, {
    layout: { background: { type: ColorType.Solid, color: c.bg }, textColor: c.text },
    grid: { vertLines: { color: c.border }, horzLines: { color: c.border } },
    timeScale: { timeVisible: true, secondsVisible: true },
    crosshair: { mode: 1 },
    width: container.value.clientWidth,
    height: container.value.clientHeight,
  })
  series = chart.addLineSeries({ color: c.line, lineWidth: 2, crosshairMarkerRadius: 4 })
  if (props.stock) loadData()
}

function loadData() {
  if (!series || !props.stock) return
  const map = new Map<number, number>()
  for (const p of props.stock.history) map.set(Math.floor(p.timestamp / 1000), p.price)
  const data = [...map.entries()]
    .sort((a, b) => a[0] - b[0])
    .map(([time, value]) => ({ time: time as UTCTimestamp, value }))
  series.setData(data)
  chart?.timeScale().fitContent()
}

watch(() => props.stock?.symbol, loadData)

watch(
  () => props.stock?.history.at(-1),
  (latest) => {
    if (!series || !latest) return
    series.update({ time: Math.floor(latest.timestamp / 1000) as UTCTimestamp, value: latest.price })
  },
)

watch(isDark, () => {
  const c = chartColors()
  chart?.applyOptions({
    layout: { background: { type: ColorType.Solid, color: c.bg }, textColor: c.text },
    grid: { vertLines: { color: c.border }, horzLines: { color: c.border } },
  })
  series?.applyOptions({ color: c.line })
})

const ro = new ResizeObserver(() => {
  if (container.value && chart) {
    chart.applyOptions({ width: container.value.clientWidth, height: container.value.clientHeight })
  }
})

onMounted(() => {
  initChart()
  if (container.value) ro.observe(container.value)
})

onUnmounted(() => {
  ro.disconnect()
  chart?.remove()
})
</script>

<template>
  <div class="chart-wrapper">
    <div v-if="stock" class="chart-info">
      <span class="ci-name">{{ stock.name }}</span>
      <span class="ci-price">${{ stock.price.toFixed(2) }}</span>
      <span class="ci-change" :class="stock.change >= 0 ? 'positive' : 'negative'">
        {{ stock.change >= 0 ? '▲' : '▼' }}
        {{ Math.abs(stock.change).toFixed(2) }}
        ({{ stock.changePercent.toFixed(2) }}%)
      </span>
      <span class="ci-ohlc">
        O:{{ stock.open.toFixed(2) }} H:{{ stock.high.toFixed(2) }} L:{{ stock.low.toFixed(2) }}
      </span>
    </div>
    <div ref="container" class="chart-container"></div>
    <div v-if="!stock" class="chart-placeholder">Select a stock to view the chart</div>
  </div>
</template>
