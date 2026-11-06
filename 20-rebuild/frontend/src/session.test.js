import test from 'node:test'
import assert from 'node:assert/strict'
import { createRouter, createMemoryHistory } from 'vue-router'
import { getToken, saveToken } from './api.js'
import { sessionRedirect } from './menu.js'

const storage = new Map()
globalThis.sessionStorage = { getItem: key => storage.get(key), setItem: (key, value) => storage.set(key, value), removeItem: key => storage.delete(key) }
globalThis.window = new EventTarget()
const { session, loadSession, resetSession, logoutSession, installSessionExpiryNavigation } = await import('./session.js')
const router = createRouter({ history: createMemoryHistory(), routes: [{ path: '/home-page', component: {} }, { path: '/login', component: {} }] })
router.beforeEach(to => sessionRedirect(to, getToken()))
installSessionExpiryNavigation(router)

async function loggedInPage() {
  resetSession()
  saveToken('synthetic-session-token')
  await router.push('/home-page')
}
function nextLogin() {
  return new Promise(resolve => { const remove = router.afterEach(to => { if (to.path === '/login') { remove(); resolve(to) } }) })
}

test('refresh with expired HTTP 200 token clears session and reaches login without a guard loop', async () => {
  await loggedInPage()
  globalThis.fetch = async () => ({ ok: true, status: 200, json: async () => ({ code: 40002, message: 'token过期，请重新登录' }) })
  const navigation = nextLogin()
  await assert.rejects(loadSession(), /token过期/)
  const login = await navigation
  assert.equal(getToken(), '')
  assert.equal(session.user, null)
  assert.deepEqual(session.menus, [])
  assert.equal(session.loading, false)
  assert.equal(login.query.reason, 'expired')
  assert.equal(login.query.redirect, '/home-page')
  await router.push('/login')
  assert.equal(router.currentRoute.value.path, '/login')
})
test('logout with an already revoked token clears stale user/menu and returns to login', async () => {
  await loggedInPage()
  session.user = { name: '合成用户' }
  session.menus = [{ id: 7 }]
  globalThis.fetch = async () => ({ ok: true, status: 200, json: async () => ({ code: 40005, message: 'token已失效，请重新登录' }) })
  const navigation = nextLogin()
  await assert.rejects(logoutSession(), /token已失效/)
  await navigation
  assert.equal(getToken(), '')
  assert.equal(session.user, null)
  assert.deepEqual(session.menus, [])
  assert.equal(router.currentRoute.value.path, '/login')
})
test('network failure on refresh and logout keeps the valid session available to retry', async () => {
  await loggedInPage()
  globalThis.fetch = async () => { throw new Error('offline') }
  await assert.rejects(loadSession(), /无法连接服务/)
  session.user = { name: '合成用户' }
  session.menus = [{ id: 7 }]
  await assert.rejects(logoutSession(), /无法连接服务/)
  assert.equal(getToken(), 'synthetic-session-token')
  assert.equal(session.user.name, '合成用户')
  assert.equal(router.currentRoute.value.path, '/home-page')
})
