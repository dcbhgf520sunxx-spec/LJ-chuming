<script setup>
import { computed } from 'vue'
import { useRoute } from 'vue-router'
import { findMenu } from '../menu.js'
import { session } from '../session.js'
import { resourceView } from '../resource-business.js'
import ResourceBusinessPage from './ResourceBusinessPage.vue'
import PendingPage from './PendingPage.vue'
const route = useRoute()
const mode = computed(() => resourceView(findMenu(session.menus, route.params.id)?.component))
</script>
<template><ResourceBusinessPage v-if="mode" :key="mode" :mode="mode" /><PendingPage v-else /></template>
