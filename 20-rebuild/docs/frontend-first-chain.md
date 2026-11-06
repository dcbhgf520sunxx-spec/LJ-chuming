# 新前端首段：登录、首页和权限菜单

当前范围是独立可构建的 Vue 源码外壳。工厂、车间、产线资源维护仍是下一条业务闭环；本轮没有实现或宣称这些业务已可用。

## 原版依据

- 原发布目录：`10-reverse/private/server/home/plm7/dist`，只读，业务编译 JS 未复制到新工程。
- 静态视图、框架与接口边界：`frontend-reconstruction-inventory.json`。
- REA directory summary 本轮返回保留证据 `ev_a6c758d9a20d9bb5210305379c935130189cc2fb34453b7a95507aaa08328149`，完整响应超出 10 MiB 传输限制，没有从未读完整图推导运行行为。
- 使用 CUA 实际观察 `http://127.0.0.1:3118/login`、`/home-page`、`/crm/crm-office` 和 `/mes-project/projects`。登录：35% 品牌背景、65% 白色表单区、中文标题和版本尾注；首页：蓝色集团标语栏、应用面板、三张统计卡与展示区；应用内：230px 深灰侧栏、绿色品牌区、白色顶部模块栏。
- `local-user_info.json` 仅核对响应字段名，`local-menu.json` 仅核对菜单层级；身份信息与实际 token 没有写入新工程或此文档。

## 实现与契约

工程在 `20-rebuild/frontend`，入口为 `src/main.js`。使用 Vue 3.5.17、Vue Router 4.5.1、Element Plus 2.14.7、JSEncrypt 3.5.4、Vite 7.3.1、Vue 插件 6.0.2；新增依赖版本从官方 npm registry 查询并由 package-lock 锁定。Element Plus 原版本未知，现版本是新工程选用版本。

| 操作 | 新前端行为 |
| --- | --- |
| 登录 | `GET /api/user/public-key` 读取 `{code:20000,data:{publicKey:PEM}}`，以 RSA PKCS#1 v1.5 Base64 密文 `POST /api/user/login {username,password}` |
| 会话 | 读取 `data.token`，以 raw `Authorization` 请求 `/api/user/info` 和 `/api/user/menu`；token 仅存于 `sessionStorage`，不保存账号或密码 |
| 权限菜单 | 从服务端 `boolMainSystem/children/meta/hidden` 构建模块和多级菜单，业务 `component` 字段不被执行 |
| 未登录/失效 | 未登录访问业务路由回到登录页；失效会话清除 token，保留安全的站内 redirect |
| 失败/等待 | 表单必填、重复提交保护、公钥/登录/会话加载错误、20 秒超时、整体加载遮罩、失败重试 |
| 退出 | raw Authorization 请求 `POST /api/user/logout {}`，确认 code 20000 后清会话并进入登录；网络/普通业务失败保留重试，已经失效的会话直接清理并进入登录 |
| 未重建页面 | 叶子菜单打开 `/rebuild/menu/:id`（分公司节点以 `branchCompanyId:id` 为标识），显示真实菜单标题与“重建中”，不跳回原应用、不显示虚构业务数据 |
| 首页 | 保留原布局；统计接口未接入，使用时长、项目数量、我的审批显示“待接入” |

本机开发前端 3120，`/api` 代理新独立 API 3119。没有修改原服务或原材料。静态图片复用记录在 `frontend/asset-provenance.json`。

## 验证边界

- `npm test` 覆盖菜单层级、隐藏节点、原始 Authorization、失效清除会话、403 不清除有效会话、异常 JSON、站内跳转限制，并用合成 RSA 密钥验证实际 PKCS#1 v1.5 填充及密文解密。
- 安装、构建、浏览器联调的实际结果在本节后续记录；测试代码中的合成输入不是 mock 服务，也不作为业务数据。
- 原页面观察不能证明新页面已验收；构建通过不能证明真实登录和权限接口已通过。完整业务、移动端、浏览器兼容与生产部署待确认。

### 本轮已执行结果（2026-10-15）

- 官方 npm 依赖安装成功，新增 58 个包；`package-lock.json` 已生成。
- `npm test`：5 项通过，0 项失败。RSA 测试采用合成临时密钥及密码，没有加载真实身份信息。
- `npm run build`：成功，产物独立输出 `frontend/dist`；新应用 JS 387.08 kB（gzip 138.11 kB）、CSS 369.38 kB（gzip 50.23 kB）。Element Plus 仅注册本外壳使用的组件，未引入新业务框架。
- 新前端源码不引用原业务 bundle 或 `10-reverse`；三张静态品牌图片有独立 provenance 清单。
- 真实新 API 登录与最终新页面浏览器验收由主代理继续执行。此记录仅确认独立安装、单元检查和生产构建，不代替真实接口/页面验收。
- CUA 新页面初检：`http://127.0.0.1:3120/` 正确跳转 `/login?redirect=/home-page`；标题“中南绿建”，实际登录表单和品牌图片可见，无框架报错遮罩，浏览器 error/warn 日志为空。空表单点击“登录”分别出现“请输入账号”“请输入密码”。初次截图发现表单标签换行和品牌图偏低，已按原页修正。


### 审查回归修复（2026-10-15）

1. **会话失效循环**：核对新 `AuthService.authenticate` 第 82–94 行，HTTP 200 业务码 `40001/40002/40003/40004/40005/40103` 分别对应缺 token、过期、解析/格式错误、撤销/密码版本不符及账号禁用。请求层统一清会话并触发登录导航；HTTP 401 的异常 JSON 也由统一错误分支处理。`40000` 密码错误、HTTP 403、网络和普通业务失败保留会话。真实请求分支、会话状态与实际 Vue Router memory history 联合回归已覆盖过期后刷新、持已撤销 token 退出，以及网络失败继续重试，没有 guard 登录死循环。
2. **分公司重复菜单 ID**：原后端按分公司展开计价模板，保留 `6000201/6000202/6000208` 等原 ID，同时添加 `branchCompanyId`。后端 JSON 不变；新前端通过组合标识区分节点 key、父菜单 index、路由、标题查找与模块高亮，普通菜单仍使用原 ID。合成的两个分公司同 ID 用例验证路由不同且查找/祖先归属正确。
3. **首页权限入口**：原 `system-app-94508909.js` 固定显示“数字化系统”和“柏楚云排样”，其余系统应用取 Vuex menus 的 `iframe && !isTripartite`；原 `third-app-9e3bc5aa.js` 固定“科创在线”和“OA协同”，追加 `iframe && isTripartite`。主包 `setInfo` 将 `/api/user/info.data.menus` 写入该 Vuex menus。已按此证据恢复规则：无角色菜单保留原四个固定入口，不显示无授权的设备管理/初鸣云招采。外部应用实际跳转仍未重建，点击明确提示当前状态。

最新自动检查：`npm test` 14 项通过、0 失败；包含前述三个回归范围。此前 5 项和 7 项是较早阶段记录，以本段最新结果为准。原页面观察、逻辑回归与新页面真实浏览器验收仍分别记录；最终新 API 页面验收由主代理执行。
