<script setup>
import { reactive, ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
import { login } from '../session.js'
import { safeRedirect } from '../menu.js'
const route = useRoute(), router = useRouter()
const form = reactive({ username: '', password: '' })
const formRef = ref(), busy = ref(false), error = ref('')
const rules = { username: [{ required: true, message: '请输入账号', trigger: 'blur' }], password: [{ required: true, message: '请输入密码', trigger: 'blur' }] }
async function submit() {
  if (busy.value || !await formRef.value.validate().catch(() => false)) return
  busy.value = true
  error.value = ''
  try { await login(form.username.trim(), form.password); form.password = ''; await router.replace(safeRedirect(route.query.redirect)) }
  catch (e) { error.value = e.message }
  finally { busy.value = false }
}
const explain = name => ElMessage.info(`${name}尚未重建，请联系管理员处理`)
</script>
<template>
  <main class="login-page">
    <section class="login-art" aria-label="中南绿建品牌"><img class="login-backdrop" src="/assets/login-background.jpg" alt=""><img class="login-logo" src="/assets/zhongnan-logo.png" alt="中南绿建"></section>
    <section class="login-panel">
      <div class="login-title"><h1>钢结构工业互联网平台</h1><span>集团联营版</span></div>
      <el-form ref="formRef" class="login-form" :model="form" :rules="rules" label-width="54px" :disabled="busy" @submit.prevent="submit">
        <el-form-item label="账号：" prop="username"><el-input v-model="form.username" name="username" autocomplete="username" aria-label="账号" /></el-form-item>
        <el-form-item label="密码：" prop="password"><el-input v-model="form.password" name="password" type="password" show-password autocomplete="current-password" aria-label="密码" @keyup.enter="submit" /></el-form-item>
        <div class="login-links"><button type="button" @click="explain('更换域名')">更换域名</button><button type="button" @click="explain('密码找回')">忘记密码？</button></div>
        <el-alert v-if="error" class="login-error" :title="error" type="error" :closable="false" show-icon role="alert" />
        <el-alert v-else-if="route.query.reason === 'expired'" class="login-error" title="会话已失效，请重新登录" type="warning" :closable="false" show-icon />
        <el-button class="login-submit" type="primary" native-type="submit" :loading="busy">{{ busy ? '认证中，请稍后' : '登录' }}</el-button>
      </el-form>
      <footer>© 初鸣数智V7.0</footer>
    </section>
  </main>
</template>
