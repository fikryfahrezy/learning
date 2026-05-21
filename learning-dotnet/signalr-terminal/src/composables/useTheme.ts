import { ref, computed, watchEffect } from 'vue'

type ThemeMode = 'light' | 'dark' | 'system'

const mode = ref<ThemeMode>((localStorage.getItem('theme') as ThemeMode) ?? 'system')
const systemDark = ref(window.matchMedia('(prefers-color-scheme: dark)').matches)

window.matchMedia('(prefers-color-scheme: dark)').addEventListener('change', (e) => {
  systemDark.value = e.matches
})

export const isDark = computed(() =>
  mode.value === 'system' ? systemDark.value : mode.value === 'dark',
)

watchEffect(() => {
  document.documentElement.setAttribute('data-theme', isDark.value ? 'dark' : 'light')
  localStorage.setItem('theme', mode.value)
})

export function useTheme() {
  function setMode(m: ThemeMode) {
    mode.value = m
  }
  return { mode, isDark, setMode }
}
