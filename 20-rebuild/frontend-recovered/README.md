# LJ-APS 完整前端恢复工程

此工程从原发布物恢复可编辑 JavaScript setup/render 与 Options API，使用真实 npm 依赖独立构建。原始 Vue 模板、类型和注释没有恢复。完整业务等价尚未验收。

在原 `views` 路径寻找页面：`src/views/原路径.vue.js`；共享 CRUD、权限、枚举、Store 与公共组件在 `src/shared/segments`。249 个原主包内联组件的定义位置由 `inline-components.json` 精确索引，视图目录入口负责引出组件。`src/shared/runtime.js` 是 Vite 虚拟加载入口，真实构建来源是已有的74个片段，按 `assembly.json` 保留顺序。

```sh
npm ci
npm run build
npm test
```

本机固定使用 bundled ARM64 Node：`/Users/sunxinxin/.cache/codex-runtimes/codex-primary-runtime/dependencies/node/bin/node --max-old-space-size=8192 ./node_modules/vite/bin/vite.js build`；测试用同一 Node 执行 `./tools/test.mjs`。已回读该二进制为 v24.19.0 arm64，避免执行 PATH 中 Intel Homebrew Node。构建默认最多8 GB Node堆。构建不恢复或覆写 src，也不依赖10-reverse；对照测试使用本地10-reverse原始证据。

`npm run dev` 配置已登记3120，仅在主任务已释放此端口后使用；不要另开新端口。生产 dist API 请求同源，部署代理 `/api` 到新后端，不能打开 file:// 运行。

启动先读取新后端同源RSA公钥，再加载业务源码；raw JWT保存在新的sessionStorage键，旧硬编码公钥/私钥和旧私钥解密不再使用。密码策略改读受权限约束的editable接口，仅取规则及已设置标记；现有默认密码不返回，留空保留，主动输入新密码才加密提交。原默认密码明文显示作为安全差异取消，完整业务验收仍由主流程继续。访问地址固定当前origin，CSP限制外联。OA、BIM外部服务、打印插件需后续集成。

全量映射与边界见 `../docs/frontend-full-recovery.md`。普通开发不要运行 recovery-tools 的重新恢复/物化工具，以免覆盖人工改动。原6个SFC基础工程 `../frontend` 保留未动。

构建与发布分开：Vite 的 `dist` 是临时产物，不直接挂载到正在使用的网页。构建并测试后，用 bundled Node 执行 `tools/record-build.mjs`，生成源码、package-lock 和全部 dist 文件的 SHA-256 清单，再执行 `../local/activate-frontend.py` 发布到 `../local/runtime/web`。发布器校验全部清单、保留旧 hash 资源，最后原子切换 index，避免已打开页面的懒加载 chunk 在下次 build 时丢失。详见该脚本；不要直接清空正在服务的 web 目录。

刷新会话先完成用户信息与菜单的单次初始化；可选配置读取失败不退出登录。公司信息只用当前用户或本地公司配置的真实名称、Logo，原中央客户编码/版本/授权到期时间未知则显示待确认。打印默认不探测驱动；仅在明确打印时读取宿主提供的 `globalThis.LJAPS_PRINT_ADAPTER.getPrinter()`。未配置、驱动拒绝或报错均明确失败，不将失败写为打印成功；物理设备与外部系统仍未接入验收。
