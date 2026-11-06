import { reactive } from 'vue'
import { request, saveToken, clearToken, revokeSessionToken } from './api.js'

export const session = reactive({ user: null, menus: [], loading: false })
let pending
export function resetSession() {
  clearToken()
  session.user = null
  session.menus = []
}
export function loadSession() {
  if (session.user) return Promise.resolve()
  if (pending) return pending
  session.loading = true
  pending = Promise.all([request('/api/user/info'), request('/api/user/menu')])
    .then(([user, menus]) => {
      if (!user || !Array.isArray(menus)) throw new Error('用户或菜单数据格式异常')
      session.user = user
      session.menus = menus
    }).finally(() => { session.loading = false; pending = null })
  return pending
}
export async function login(username, password) {
  const { publicKey } = await request('/api/user/public-key')
  if (!publicKey) throw new Error('登录公钥尚未就绪，请联系管理员')
  const { JSEncrypt } = await import('jsencrypt')
  const rsa = new JSEncrypt()
  rsa.setPublicKey(publicKey)
  const encrypted = rsa.encrypt(password)
  if (!encrypted) throw new Error('密码加密失败，请检查密码长度或服务公钥')
  const data = await request('/api/user/login', { method: 'POST', body: JSON.stringify({ username, password: encrypted }) })
  if (!data?.token || typeof data.token !== 'string') throw new Error('登录响应缺少有效会话')
  saveToken(data.token)
  try { await loadSession() } catch (error) { resetSession(); throw error }
}
window.addEventListener('ljaps:session-expired', resetSession)

export async function logoutSession() {
  await revokeSessionToken()
  resetSession()
}

export function installSessionExpiryNavigation(router) {
  window.addEventListener('ljaps:session-expired', () => {
    if (router.currentRoute.value.path !== '/login') router.replace({ path: '/login', query: { redirect: router.currentRoute.value.fullPath, reason: 'expired' } })
  })
}
