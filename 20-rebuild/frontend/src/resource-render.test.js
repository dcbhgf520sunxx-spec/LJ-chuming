import assert from 'node:assert/strict'
import test from 'node:test'
import { createSSRApp } from 'vue'
import { renderToString } from '@vue/server-renderer'
import { createMemoryHistory, createRouter } from 'vue-router'
import { createServer } from 'vite'
import { ID_INJECTION_KEY, ZINDEX_INJECTION_KEY } from 'element-plus'

// Compile the actual SFC, so missing table registrations cannot pass helper-only tests.
test('resource page renders actual Element Plus table slots without a browser', async () => {
  globalThis.window ??= new EventTarget()
  const server = await createServer({ server: { middlewareMode: true, hmr: false }, optimizeDeps: { noDiscovery: true }, logLevel: 'silent' })
  try {
    const { default: Page } = await server.ssrLoadModule('/src/views/ResourceBusinessPage.vue')
    const router = createRouter({ history: createMemoryHistory(), routes: [{ path: '/', component: { render: () => null } }] })
    await router.push('/')
    await router.isReady()
    const app = createSSRApp(Page, { mode: 'factories' }).use(router)
    app.provide(ID_INJECTION_KEY, { prefix: 1, current: 0 })
    app.provide(ZINDEX_INJECTION_KEY, { current: 0 })
    const warnings = []
    app.config.warnHandler = message => warnings.push(message)
    const html = await renderToString(app)
    assert.match(html, /工厂列表/)
    assert.match(html, /点击工厂查看详情/)
    assert.equal(warnings.some(message => /Failed to resolve component/.test(message)), false, warnings.join('\n'))
    assert.doesNotMatch(html, /<el-table(?:\s|>)/)
  } finally { await server.close() }
})
