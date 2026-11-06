import { request } from './api.js'

export const workshopTypes = [{ value: 1, label: '建钢车间' }, { value: 2, label: '桥梁车间' }, { value: 4, label: '围护车间' }, { value: 8, label: '网架车间' }]
export const productTypes = [{ value: 1, label: '零件' }, { value: 16, label: '部件' }, { value: 2, label: '构件' }]
const resourceViews = new Map([
  ['mes/production-config/factory-and-workshop/index', 'factories'],
  ['mes/production-config/production-line/index', 'lines'],
  ['mes/production-config/production-line/line/index', 'lines'],
])
export function resourceView(component) {
  return resourceViews.get(String(component || '').replace(/^\/+/, '').replace(/\.vue$/, ''))
}
export function canResource(user, resource, operation) {
  const permissions = user?.permissions || []
  return user?.roles?.includes('admin') || permissions.includes(`${resource}:${operation}`)
}
export function resourcePayload(kind, form) {
  if (kind === 'factory') return { ...(form.id == null ? {} : { id: form.id }), branchCompanyId: form.branchCompanyId, name: form.name.trim(), shortName: typeof form.shortName === 'string' ? form.shortName.trim() : form.shortName, sort: form.sort, tagColor: form.tagColor, remark: form.remark }
  if (kind === 'workshop') return { ...(form.id == null ? {} : { id: form.id }), factoryId: form.factoryId, name: form.name.trim(), shortName: typeof form.shortName === 'string' ? form.shortName.trim() : form.shortName, type: form.type, sort: form.sort, ton: form.ton, remark: form.remark }
  return { ...(form.id == null ? {} : { id: form.id }), workshopId: form.workshopId, name: form.name, productType: form.productType, targetProduction: form.ton * 1000, mesProductEnum: form.mesProductEnum, productionLineTypeEnum: form.productionLineTypeEnum, linkIdList: form.linkIdList, remark: form.remark }
}
export function fromProductionLine(row, mesProductEnum) {
  return { ...row, ton: Number(row.targetProduction || 0) / 1000, linkIdList: row.typeList?.map(item => item.id) || [], mesProductEnum }
}
export function resourceQuery(params) {
  const query = new URLSearchParams()
  for (const [key, value] of Object.entries(params)) if (value != null && value !== '') query.set(key, String(value))
  return query.toString()
}
const base = kind => `/api/mes/building/${kind}`
export const resourceApi = {
  page: (kind, params) => request(`${base(kind)}/page?${resourceQuery(params)}`),
  list: (kind, params) => request(`${base(kind)}?${resourceQuery(params)}`),
  branches: () => request('/api/branchCompany/all/simple'),
  save: (kind, form) => request(base(kind), { method: form.id == null ? 'POST' : 'PUT', body: JSON.stringify(resourcePayload(kind, form)) }),
  remove: (kind, id) => request(base(kind), { method: 'DELETE', body: JSON.stringify({ ids: [id] }) }),
  state: (kind, id, enabled) => request(`${base(kind)}/changeState`, { method: 'PUT', body: JSON.stringify({ id, boolEnabledEnum: enabled }) }),
}
