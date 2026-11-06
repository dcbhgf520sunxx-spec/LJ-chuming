<script setup>
import { computed } from 'vue'
import { ElMessage } from 'element-plus'
import { session } from '../session.js'
import { modulesFrom, firstLeaf, menuTarget, homeApplications } from '../menu.js'
import { useRouter } from 'vue-router'
const router = useRouter()
const applications = computed(() => homeApplications(session.user?.menus || []))
function openSystem() {
 const module = modulesFrom(session.menus)[0]
 if (module) router.push(menuTarget(firstLeaf(module)))
 else ElMessage.warning('当前账号没有可用菜单，请联系管理员')
}
const pending = name => ElMessage.info(`${name}尚未重建，当前未连接外部应用`)
</script>
<template>
  <div class="home-grid">
    <div class="application-panels">
      <section class="application-card"><h2>▦ 系统应用</h2><div class="application-list"><button v-for="app in applications.system" :key="app.key" class="app-tile" :style="app.background ? { background: app.background } : {}" @click="app.currentSystem ? openSystem() : pending(app.name)"><b>{{ app.symbol }}</b>{{ app.name }}</button></div></section>
      <section class="application-card"><h2>♧ 第三方应用</h2><div class="application-list"><button v-for="app in applications.third" :key="app.key" class="app-tile" :style="app.background ? { background: app.background } : {}" @click="pending(app.name)"><b>{{ app.symbol }}</b>{{ app.name }}</button></div></section>
    </div>
    <div class="home-content"><div class="summary-cards"><article><span class="summary-icon">▱</span><div><strong>待接入</strong><span>使用时长</span></div></article><article><span class="summary-icon">▤</span><div><strong>待接入</strong><span>项目数量</span></div></article><article><span class="summary-icon">▧</span><div><strong>待接入</strong><span>我的审批</span></div></article></div><section class="home-display"><el-tag class="rebuild-tag" type="info">新平台重建中</el-tag><div><p>暂未配置展示图片</p><small>首页统计与展示配置尚未接入</small></div></section></div>
  </div>
</template>
