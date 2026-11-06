import test from 'node:test'
import assert from 'node:assert/strict'
import { menuTarget, firstLeaf, findMenu, modulesFrom, safeRedirect, menuKey, containsMenu } from './menu.js'

test('menu derives visible modules and first accessible leaf without executing server components', () => {
  const leaf = { id: 5, component: '/mes/production-config/factory-and-workshop/index', meta: { title: '工厂与车间' } }
  const module = { id: 2, children: [{ id: 3, hidden: true }, { id: 4, children: [leaf] }] }
  const menus = [{ boolMainSystem: true, children: [module, { id: 6, meta: { title: '首页' } }] }]
  assert.deepEqual(modulesFrom(menus), [module])
  assert.equal(firstLeaf(module), leaf)
  assert.equal(findMenu(menus, '5'), leaf)
  assert.equal(menuTarget(leaf), '/rebuild/menu/5')
  assert.equal(menuTarget({ id: 99, component: '/unknown/index' }), '/rebuild/menu/99')
})
test('redirect remains local and does not return to login', () => {
  for (const value of ['https://example.com', '//example.com', '/\\example.com', '/login?redirect=/home-page', undefined, ['/home-page']]) assert.equal(safeRedirect(value), '/home-page')
  assert.equal(safeRedirect('/rebuild/menu/5?tab=1'), '/rebuild/menu/5?tab=1')
})

test('identical menu IDs in separate branch companies keep distinct routes and lookup', () => {
  const first = { id: 6000201, branchCompanyId: 71, children: [{ id: 6000202, branchCompanyId: 71, meta: { title: '甲计价' } }] }
  const second = { id: 6000201, branchCompanyId: 72, children: [{ id: 6000202, branchCompanyId: 72, meta: { title: '乙计价' } }] }
  assert.notEqual(menuTarget(first), menuTarget(second))
  assert.notEqual(menuTarget(first.children[0]), menuTarget(second.children[0]))
  assert.notEqual(menuKey(first), menuKey(second))
  assert.notEqual(menuKey(first.children[0]), menuKey(second.children[0]))
  assert.equal(menuKey({ id: 6000202 }), '6000202')
  assert.equal(findMenu([first, second], '72:6000202'), second.children[0])
  assert.equal(findMenu([first, second], '71:6000202'), first.children[0])
  assert.equal(containsMenu(first, '72:6000202'), false)
  assert.equal(containsMenu(second, '72:6000202'), true)
})

test('home keeps four fixed original apps and adds only authorized iframe applications', async () => {
  const { homeApplications } = await import('./menu.js')
  const empty = homeApplications([])
  assert.deepEqual(empty.system.map(app => app.name), ['数字化系统', '柏楚云排样'])
  assert.deepEqual(empty.third.map(app => app.name), ['科创在线', 'OA协同'])
  const authorized = homeApplications([{ id: 1, name: '设备管理', iframe: true, isTripartite: false }, { id: 2, name: '初鸣云招采', iframe: true, isTripartite: true }, { id: 3, name: '普通业务模块', iframe: false }])
  assert.deepEqual(authorized.system.map(app => app.name), ['数字化系统', '设备管理', '柏楚云排样'])
  assert.deepEqual(authorized.third.map(app => app.name), ['科创在线', 'OA协同', '初鸣云招采'])
})
