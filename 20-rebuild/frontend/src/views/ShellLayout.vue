<script setup>
import { computed, onMounted, ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
import { session, loadSession, logoutSession } from '../session.js'
import { getToken } from '../api.js'
import { modulesFrom, menuKey, menuTitle, visibleChildren, containsMenu, firstLeaf, menuTarget, findMenu } from '../menu.js'
import MenuBranch from '../components/MenuBranch.vue'
const route = useRoute(), router = useRouter()
const error = ref(''), activeModuleId = ref(null), collapsed = ref(false), loggingOut = ref(false)
const home = computed(() => route.path === '/home-page')
const modules = computed(() => modulesFrom(session.menus))
const activeModule = computed(() => modules.value.find(m => containsMenu(m, route.params.id)) || modules.value.find(m => menuKey(m) === activeModuleId.value) || modules.value[0])
const title = computed(() => { const node = findMenu(session.menus, route.params.id); return node ? menuTitle(node) : route.meta.title || '数字化系统' })
async function refresh() {
  error.value = ''
  try { await loadSession() } catch (e) { error.value = e.message }
}
function switchModule(module) { activeModuleId.value = menuKey(module); router.push(menuTarget(firstLeaf(module))) }
async function logout() {
  if (loggingOut.value) return
  loggingOut.value = true
  try {
    await logoutSession()
    await router.replace('/login')
  } catch (e) {
    if (!getToken()) return
    ElMessage.error(`${e.message}；尚未确认服务端会话已撤销，请重试`)
  } finally { loggingOut.value = false }
}
const pending = name => ElMessage.info(`${name}尚未接入新平台`)
onMounted(refresh)
</script>
<template>
  <div v-loading="session.loading" class="platform" :class="{ 'is-home': home, 'is-collapsed': collapsed }">
    <template v-if="!error && session.user">
      <aside v-if="!home" class="sidebar"><RouterLink to="/home-page" class="sidebar-brand"><img src="/assets/zhongnan-logo-white.png" alt="中南绿建"></RouterLink><el-menu class="side-menu" :default-active="route.path" :collapse="collapsed" background-color="#4b5058" text-color="#e1e3e6" active-text-color="#e6c65c"><MenuBranch v-for="node in visibleChildren(activeModule || {})" :key="menuKey(node)" :node="node" @navigate="router.push" /></el-menu></aside>
      <div class="platform-main">
        <header :class="['platform-header', { 'home-header': home }]">
          <template v-if="home"><img class="home-mark" src="/assets/zhongnan-logo.png" alt="中南绿建"><span class="company-title">浙江中南绿建科技集团有限公司 —— 赋能 | 赋智 | 赋值</span><span class="header-spacer"/><button class="header-link" @click="pending('操作手册')">▤ 操作手册</button><button class="header-link" @click="pending('APP下载')">♧ APP下载</button></template>
          <template v-else><button class="collapse-button" :aria-label="collapsed ? '展开菜单' : '收起菜单'" @click="collapsed = !collapsed">☰</button><nav class="module-nav" aria-label="系统模块"><button v-for="module in modules.slice(0, 5)" :key="menuKey(module)" :class="{ active: activeModule && menuKey(activeModule) === menuKey(module) }" @click="switchModule(module)">{{ menuTitle(module) }}</button><el-dropdown v-if="modules.length > 5" @command="switchModule"><button aria-label="更多模块" class="more-modules">•••</button><template #dropdown><el-dropdown-menu><el-dropdown-item v-for="module in modules.slice(5)" :key="menuKey(module)" :command="module">{{ menuTitle(module) }}</el-dropdown-item></el-dropdown-menu></template></el-dropdown></nav><span class="header-spacer"/></template>
          <el-dropdown :disabled="loggingOut" @command="logout"><button class="user-button" :disabled="loggingOut" :aria-label="loggingOut ? '正在退出' : '用户菜单'"><span class="avatar">{{ (session.user.name || session.user.username || '用').slice(0,1) }}</span><span class="username">{{ session.user.name || session.user.username }}</span><span>⌄</span></button><template #dropdown><el-dropdown-menu><el-dropdown-item command="logout" :disabled="loggingOut">{{ loggingOut ? '正在退出…' : '退出登录' }}</el-dropdown-item></el-dropdown-menu></template></el-dropdown>
        </header>
        <div v-if="!home" class="page-tabs"><RouterLink to="/home-page">首页</RouterLink><span class="current-tab">{{ title }}</span><span class="source-status">新平台重建中</span></div>
        <main :class="['platform-body', { 'home-body': home }]"><RouterView :key="route.fullPath" /></main>
      </div>
    </template>
    <el-result v-else-if="error" icon="error" title="暂时无法加载平台" :sub-title="error"><template #extra><el-button type="primary" @click="refresh">重试</el-button><el-button :loading="loggingOut" @click="logout">退出登录</el-button></template></el-result>
  </div>
</template>
