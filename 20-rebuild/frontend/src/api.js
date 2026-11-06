const TOKEN_KEY = 'ljaps.rebuild.session'
const SESSION_ERROR_CODES = new Set([401, 40001, 40002, 40003, 40004, 40005, 40103, 50008, 50012, 50014])
export const getToken = () => sessionStorage.getItem(TOKEN_KEY) || ''
export const saveToken = token => sessionStorage.setItem(TOKEN_KEY, token)
export const clearToken = () => sessionStorage.removeItem(TOKEN_KEY)

export class ApiError extends Error {
  constructor(message, code) { super(message); this.code = code }
}

export async function request(path, options = {}) {
  const controller = new AbortController()
  const timeout = setTimeout(() => controller.abort(), 20000)
  const token = getToken()
  try {
    const response = await fetch(path, {
      ...options,
      signal: controller.signal,
      headers: { 'Content-Type': 'application/json', ...(token ? { Authorization: token } : {}), ...options.headers },
    })
    let payload
    try { payload = await response.json() } catch { throw new ApiError('服务返回格式异常，请稍后重试', response.status) }
    if (!response.ok || payload.code !== 20000) {
      const code = response.ok ? payload.code : response.status
      throw new ApiError(payload.message || payload.msg || `请求失败（${code}）`, code)
    }
    return payload.data
  } catch (error) {
    if (error instanceof ApiError) {
      if (SESSION_ERROR_CODES.has(error.code)) {
        clearToken()
        window.dispatchEvent(new Event('ljaps:session-expired'))
      }
      throw error
    }
    throw new ApiError(error.name === 'AbortError' ? '请求超时，请检查本地服务后重试' : '无法连接服务，请检查本地服务后重试', 0)
  } finally { clearTimeout(timeout) }
}

export async function revokeSessionToken() {
  await request('/api/user/logout', { method: 'POST', body: '{}' })
  clearToken()
}
