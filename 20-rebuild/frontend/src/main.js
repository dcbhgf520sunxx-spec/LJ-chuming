import { createApp } from 'vue'
import { ElConfigProvider, ElForm, ElFormItem, ElInput, ElButton, ElAlert, ElResult, ElTag, ElDropdown, ElDropdownMenu, ElDropdownItem, ElMenu, ElSubMenu, ElMenuItem, ElLoading } from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import { router } from './router.js'
import './style.css'

const app = createApp(App).use(router)
for (const component of [ElConfigProvider, ElForm, ElFormItem, ElInput, ElButton, ElAlert, ElResult, ElTag, ElDropdown, ElDropdownMenu, ElDropdownItem, ElMenu, ElSubMenu, ElMenuItem, ElLoading]) app.use(component)
app.mount('#app')
