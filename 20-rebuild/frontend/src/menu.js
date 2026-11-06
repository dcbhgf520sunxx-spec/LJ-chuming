export const menuKey = node => node.branchCompanyId == null ? String(node.id) : `${node.branchCompanyId}:${node.id}`
export const menuTitle = node => node.meta?.title || node.name || '未命名菜单'
export const visibleChildren = node => (node.children || []).filter(child => !child.hidden)
export function modulesFrom(menus) {
  const main = menus.find(menu => menu.boolMainSystem) || menus[0]
  return visibleChildren(main || {}).filter(menu => menuTitle(menu) !== '首页')
}
export function findMenu(nodes, id) {
  for (const node of nodes) {
    if (menuKey(node) === String(id)) return node
    const found = findMenu(node.children || [], id)
    if (found) return found
  }
}
export function menuTarget(node) {
  return `/rebuild/menu/${encodeURIComponent(menuKey(node))}`
}
export function firstLeaf(node) {
  const children = visibleChildren(node)
  return children.length ? firstLeaf(children[0]) : node
}
export function containsMenu(node, id) {
  return menuKey(node) === String(id) || visibleChildren(node).some(child => containsMenu(child, id))
}
export function safeRedirect(value) {
  return typeof value === 'string' && value.startsWith('/') && !value.startsWith('//') && !value.startsWith('/login') && !value.includes('\\') ? value : '/home-page'
}

export function sessionRedirect(to, token) {
  if (!token && to.path !== '/login') return { path: '/login', query: { redirect: to.fullPath } }
  if (token && to.path === '/login') return safeRedirect(to.query.redirect)
}

export function homeApplications(menus = []) {
  const systemColors = ['#B79DF9', '#F49CD4', '#C18E36', '#F79C85']
  const thirdColors = ['#2cc1ae', '#FAB973', '#B79DF9', '#F49CD4']
  const dynamicApps = (tripartite, colors) => menus.filter(menu => menu.iframe && Boolean(menu.isTripartite) === tripartite).map((menu, index) => ({ key: `menu:${menuKey(menu)}`, name: menu.name, symbol: tripartite ? '◉' : '▥', background: colors[index] || '#4d93d7' }))
  return {
    system: [{ key: 'digital', name: '数字化系统', symbol: '▦', currentSystem: true }, ...dynamicApps(false, systemColors), { key: 'nest', name: '柏楚云排样', symbol: '⬡' }],
    third: [{ key: 'innovation', name: '科创在线', symbol: '♧' }, { key: 'oa', name: 'OA协同', symbol: '♙', background: '#5d9bdc' }, ...dynamicApps(true, thirdColors)],
  }
}
