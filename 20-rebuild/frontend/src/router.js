import { createRouter, createWebHistory } from 'vue-router'
import { getToken } from './api.js'
import { sessionRedirect } from './menu.js'
import { installSessionExpiryNavigation } from './session.js'
import LoginPage from './views/LoginPage.vue'
import ShellLayout from './views/ShellLayout.vue'
import HomePage from './views/HomePage.vue'
import PendingPage from './views/PendingPage.vue'
import BusinessMenuPage from './views/BusinessMenuPage.vue'
import ResourceBusinessPage from './views/ResourceBusinessPage.vue'

export const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/login', component: LoginPage },
    { path: '/', component: ShellLayout, children: [
      { path: '', redirect: '/home-page' },
      { path: 'home-page', component: HomePage, meta: { title: '首页' } },
      { path: 'rebuild/menu/:id', component: BusinessMenuPage },
      { path: 'mes/production-config/factory-and-workshop/index', component: ResourceBusinessPage, props: { mode: 'factories' }, meta: { title: '工厂与车间' } },
      { path: 'mes/production-config/production-line/index', component: ResourceBusinessPage, props: { mode: 'lines' }, meta: { title: '生产线' } },
      { path: ':pathMatch(.*)*', component: PendingPage },
    ] },
  ],
})
router.beforeEach(to => sessionRedirect(to, getToken()))
router.afterEach(to => { document.title = `${to.meta.title ? `${to.meta.title} - ` : ''}中南绿建` })
installSessionExpiryNavigation(router)
