# 新平台前端源码

独立 Vue 工程，登录、首页和权限菜单由新源码实现。原发布物仅用于静态/运行对照；构建与运行不引用 `10-reverse` 或原业务编译 JS。只复制了三张品牌静态图片，来源和 SHA-256 见 `asset-provenance.json`。

```sh
npm ci
npm test
npm run build
```

需要 Node `^20.19.0 || >=22.12.0`。本机使用已提供的 bundled Node 24；该运行时目录仅包含 `node`，npm 由本机已有 npm CLI 执行。开发地址 `http://127.0.0.1:3120`，`/api` 默认代理 `http://127.0.0.1:3119`。可用 `LJAPS_API_TARGET` 指定独立 API 地址。生产部署需要将 `/api` 转发到新 API，并将页面路由回退到 `index.html`；Vite preview 仅预览静态包，不是生产反向代理。

当前本地验收由同一个 Nginx 服务提供 3120 页面与 3119 接口网关；修改前端后执行 `npm run build` 再刷新即可验证。可选的 `npm run dev` 要求先释放 3120，并另外保持独立 API 网关可达，不能与当前静态服务同时占用同一端口；默认交付流程不依赖 Vite 开发服务器。

锁定 Vue 3.5.17、Vue Router 4.5.1；Element Plus 2.14.7、JSEncrypt 3.5.4、Vite 7.3.1、Vue 插件 6.0.2 的版本已在官方 npm registry 核对。原 Element Plus 精确版本仍未知，不能宣称相同依赖版本。

登录先读取新后端公钥，以 JSEncrypt 执行 RSA PKCS#1 v1.5 加密后提交密码。仅将当前会话 token 保存至本 origin 的 `sessionStorage`，不保存账号或密码；HTTP Authorization 使用原始 token。退出先携带 raw Authorization 请求 `POST /api/user/logout {}`，确认 `code:20000` 后清除前端会话并跳转登录；网络或业务失败明确提示未确认服务端撤销，保留会话供重试。

菜单来自 `/api/user/menu` 的原结构，不把 `component` 字段当可执行代码。已识别的“工厂与车间”和“生产线”菜单进入新源码资源维护页，其它业务菜单叶子仍明确显示“重建中”。资源页的原字段/API/单位与约束依据见 `../docs/resource-business-ui.md`；真实业务闭环验收与全部平台等价验收仍待完成。首页统计显示“待接入”，不填入虚构数量。密码找回、域名切换、外部应用和展示配置尚未重建。业务功能、权限拒绝、统计、设备及外部集成的等价验收不在本登录外壳完成范围。

会话失效按新后端实际契约识别 HTTP 200 的 `40001/40002/40003/40004/40005/40103`，并兼容 HTTP 401 和原约定的失效码。清理 token、用户及菜单后进入登录页，避免旧 token 阻挡重新登录。`40000` 密码错误、HTTP 403 权限不足、网络或普通业务失败不触发失效清理。

分公司菜单通过 `branchCompanyId:id` 组合标识区分重复 ID（普通菜单仍用原 ID），此标识同时用于树节点 key、父菜单 index、页面路由、标题查找和模块高亮。首页按原发布物规则保留四个固定入口（数字化系统、柏楚云排样、科创在线、OA协同），设备管理等系统 iframe 与第三方 iframe 从 `user/info.data.menus` 按 `iframe/isTripartite` 派生；无角色菜单不会显示设备管理或初鸣云招采。
