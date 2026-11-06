import test from 'node:test'
import assert from 'node:assert/strict'
import { generateKeyPairSync, privateDecrypt, constants } from 'node:crypto'
import { createRequire } from 'node:module'
const JSEncrypt = createRequire(import.meta.url)('jsencrypt')
import { request, saveToken, getToken, revokeSessionToken } from './api.js'

const storage = new Map()
globalThis.sessionStorage = { getItem: key => storage.get(key), setItem: (key, value) => storage.set(key, value), removeItem: key => storage.delete(key) }
globalThis.window = { dispatchEvent: () => {} }

test('API sends raw authorization and clears an expired session', async () => {
  saveToken('synthetic-test-token')
  globalThis.fetch = async (path, options) => {
    assert.equal(path, '/api/user/info')
    assert.equal(options.headers.Authorization, 'synthetic-test-token')
    return { ok: true, status: 200, json: async () => ({ code: 20000, data: { name: '测试' } }) }
  }
  assert.deepEqual(await request('/api/user/info'), { name: '测试' })
  globalThis.fetch = async () => ({ ok: false, status: 401, json: async () => ({ code: 401, message: '会话已失效' }) })
  await assert.rejects(request('/api/user/info'), /会话已失效/)
  assert.equal(getToken(), '')
})
test('API retains a valid session on permission denial and rejects invalid JSON', async () => {
  saveToken('synthetic-test-token')
  globalThis.fetch = async () => ({ ok: false, status: 403, json: async () => ({ code: 403, message: '无权限' }) })
  await assert.rejects(request('/api/protected'), /无权限/)
  assert.equal(getToken(), 'synthetic-test-token')
  globalThis.fetch = async () => ({ ok: true, status: 200, json: async () => { throw new Error('invalid JSON') } })
  await assert.rejects(request('/api/protected'), /格式异常/)
})
test('JSEncrypt encrypts with RSA PKCS1 v1.5 and returns Base64', () => {
  const { publicKey, privateKey } = generateKeyPairSync('rsa', { modulusLength: 2048, publicKeyEncoding: { type: 'spki', format: 'pem' }, privateKeyEncoding: { type: 'pkcs8', format: 'pem' } })
  const rsa = new JSEncrypt()
  rsa.setPublicKey(publicKey)
  const encrypted = rsa.encrypt('synthetic-password')
  const padded = privateDecrypt({ key: privateKey, padding: constants.RSA_NO_PADDING }, Buffer.from(encrypted, 'base64'))
  assert.equal(padded[0], 0)
  assert.equal(padded[1], 2)
  const separator = padded.indexOf(0, 2)
  assert.ok(separator >= 10)
  assert.equal(padded.subarray(separator + 1).toString(), 'synthetic-password')
})


test('logout posts the raw token and clears it only after confirmed revocation', async () => {
  saveToken('synthetic-logout-token')
  let complete
  globalThis.fetch = (path, options) => {
    assert.equal(path, '/api/user/logout')
    assert.equal(options.method, 'POST')
    assert.equal(options.headers.Authorization, 'synthetic-logout-token')
    assert.equal(options.body, '{}')
    return new Promise(resolve => { complete = resolve })
  }
  const logout = revokeSessionToken()
  assert.equal(getToken(), 'synthetic-logout-token')
  complete({ ok: true, status: 200, json: async () => ({ code: 20000, data: null }) })
  await logout
  assert.equal(getToken(), '')
})
test('logout keeps the local token when network or business rejection leaves revocation unconfirmed', async () => {
  saveToken('synthetic-logout-token')
  globalThis.fetch = async () => { throw new Error('offline') }
  await assert.rejects(revokeSessionToken(), /无法连接服务/)
  assert.equal(getToken(), 'synthetic-logout-token')
  globalThis.fetch = async () => ({ ok: true, status: 200, json: async () => ({ code: 50000, message: '撤销失败' }) })
  await assert.rejects(revokeSessionToken(), /撤销失败/)
  assert.equal(getToken(), 'synthetic-logout-token')
})

test('HTTP 200 authentication codes clear the token and emit session expiration', async () => {
  for (const code of [40001, 40002, 40003, 40004, 40005, 40103]) {
    saveToken('synthetic-expired-token')
    let notified = false
    globalThis.window = { dispatchEvent: event => { notified = event.type === 'ljaps:session-expired' } }
    globalThis.fetch = async () => ({ ok: true, status: 200, json: async () => ({ code, message: '会话不可用' }) })
    await assert.rejects(request('/api/user/info'), /会话不可用/)
    assert.equal(getToken(), '', `authentication code ${code} must clear token`)
    assert.equal(notified, true)
  }
})
test('ordinary password failure does not expire a session', async () => {
  saveToken('synthetic-existing-token')
  globalThis.fetch = async () => ({ ok: true, status: 200, json: async () => ({ code: 40000, message: '账号密码错误' }) })
  await assert.rejects(request('/api/user/login'), /账号密码错误/)
  assert.equal(getToken(), 'synthetic-existing-token')
})
