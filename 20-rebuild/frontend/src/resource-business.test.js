import test from 'node:test'
import assert from 'node:assert/strict'
import { canResource, fromProductionLine, productTypes, resourceApi, resourcePayload, resourceQuery, resourceView } from './resource-business.js'

test('resource routing recognizes exact shipped components only', () => {
  assert.equal(resourceView('/mes/production-config/factory-and-workshop/index'), 'factories')
  assert.equal(resourceView('mes/production-config/production-line/index.vue'), 'lines')
  assert.equal(resourceView('/bridge/bridge-production-config/workshop/index'), undefined)
  assert.equal(resourceView('/unknown/factory-and-workshop/index'), undefined)
})
test('original frontend permission buttons require exact permission or admin role', () => {
  assert.equal(canResource({ roles: ['admin'] }, 'workshop', 'del'), true)
  assert.equal(canResource({ permissions: ['workshop:edit'] }, 'workshop', 'edit'), true)
  assert.equal(canResource({ permissions: ['factorySummary'] }, 'workshop', 'del'), false)
  assert.equal(canResource({ permissions: ['productionLine:editStatus'] }, 'workshop', 'editStatus'), false)
  assert.equal(Boolean(canResource({}, 'factory', 'get')), false)
})
test('production line tons round trip and hidden type links survive editing', () => {
  const form = fromProductionLine({ id: '9007199254740993', workshopId: '2', name: '一号线', productType: 2, targetProduction: 12500, typeList: [{ id: '33', name: 'A' }], productionLineTypeEnum: 1, remark: '' }, 1)
  assert.equal(form.ton, 12.5)
  const payload = resourcePayload('productionLine', form)
  assert.equal(payload.targetProduction, 12500)
  assert.equal(payload.id, '9007199254740993')
  assert.deepEqual(payload.linkIdList, ['33'])
  assert.equal(payload.productionLineTypeEnum, 1)
  assert.equal('targetProductionShow' in payload, false)
  assert.deepEqual(productTypes.map(t => t.value), [1, 16, 2])
})
test('workshop target stays in tons and payload excludes response metadata', () => {
  const payload = resourcePayload('workshop', { factoryId: '3', name: '  测试车间  ', shortName: ' 测试 ', type: 1, ton: 12.5, sort: 1, remark: '', boolEnabledEnum: true, createTime: 'x' })
  assert.equal(payload.ton, 12.5)
  assert.equal(payload.name, '测试车间')
  assert.equal('boolEnabledEnum' in payload, false)
  assert.equal('createTime' in payload, false)
  assert.equal(resourcePayload('workshop', { ...payload, shortName: null }).shortName, null)
})
test('query preserves false disabled filter, uses original pageNumber/pageSize', () => {
  assert.equal(resourceQuery({ boolEnabledEnum: false, name: '', workshopId: undefined, pageNumber: 1, pageSize: 10 }), 'boolEnabledEnum=false&pageNumber=1&pageSize=10')
})
test('resource requests use original mutation methods, raw auth, body contracts and null success', async () => {
  const previousFetch = globalThis.fetch, previousStorage = globalThis.sessionStorage
  const calls = []
  globalThis.sessionStorage = { getItem: () => 'raw-token' }
  globalThis.fetch = async (url, options) => { calls.push({ url, options }); return { ok: true, json: async () => ({ code: 20000, data: null }) } }
  try {
    await resourceApi.save('workshop', { name: 'A', shortName: '', factoryId: '1', type: 1, ton: 0, sort: 1, remark: '' })
    await resourceApi.save('workshop', { id: '2', name: 'B', shortName: '', factoryId: '1', type: 1, ton: 0, sort: 1, remark: '' })
    await resourceApi.state('workshop', '2', false)
    await resourceApi.remove('productionLine', '3')
    await resourceApi.page('factory', { pageNumber: 2, pageSize: 10, boolEnabledEnum: false })
    assert.deepEqual(calls.map(c => c.options.method), ['POST', 'PUT', 'PUT', 'DELETE', undefined])
    assert.deepEqual(JSON.parse(calls[2].options.body), { id: '2', boolEnabledEnum: false })
    assert.deepEqual(JSON.parse(calls[3].options.body), { ids: ['3'] })
    assert.equal(calls[4].url, '/api/mes/building/factory/page?pageNumber=2&pageSize=10&boolEnabledEnum=false')
    assert.ok(calls.every(c => c.options.headers.Authorization === 'raw-token'))
  } finally { globalThis.fetch = previousFetch; globalThis.sessionStorage = previousStorage }
})
