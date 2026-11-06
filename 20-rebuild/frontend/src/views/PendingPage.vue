<script setup>
import { computed } from 'vue'
import { useRoute } from 'vue-router'
import { session } from '../session.js'
import { findMenu, menuTitle } from '../menu.js'
const route = useRoute()
const title = computed(() => { const menu = findMenu(session.menus, route.params.id); return menu ? menuTitle(menu) : route.meta.title || '当前页面' })
</script>
<template><section class="pending-page"><el-result icon="info" :title="`${title}：重建中`" sub-title="该功能正在重建，暂不可用。"><template #extra><el-button type="primary" @click="$router.push('/home-page')">返回首页</el-button></template></el-result></section></template>
