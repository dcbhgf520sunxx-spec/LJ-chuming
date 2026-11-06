<script setup>
import { menuKey, menuTitle, visibleChildren, menuTarget } from '../menu.js'
defineProps({ node: { type: Object, required: true } })
defineEmits(['navigate'])
</script>
<template>
  <el-sub-menu v-if="visibleChildren(node).length" :index="menuKey(node)">
    <template #title><span class="menu-symbol">◫</span><span>{{ menuTitle(node) }}</span></template>
    <MenuBranch v-for="child in visibleChildren(node)" :key="menuKey(child)" :node="child" @navigate="$emit('navigate', $event)" />
  </el-sub-menu>
  <el-menu-item v-else :index="menuTarget(node)" @click="$emit('navigate', menuTarget(node))"><span class="menu-symbol">◫</span><span>{{ menuTitle(node) }}</span></el-menu-item>
</template>
