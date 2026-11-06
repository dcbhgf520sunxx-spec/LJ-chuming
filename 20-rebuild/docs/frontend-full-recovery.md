# 完整前端源码恢复与独立构建

目标是取得能修改并重新构建的前端业务实现。这里恢复的是发布物中的 JavaScript `setup/render` 与 Options API 实现，不是原始 Vue 模板、TypeScript、注释或原开发工程。不能用源码文件覆盖与编译通过代替逐项业务验收。

## 当前可验证成果

- 原 `static/js` 的 4,089 个文件中，1 个是集中 vendor；其余 **4,088 个 JS 模块**全部通过 Babel AST 解析，静态导入缺失 0。包含业务代码，也包含图表/PDF等第三方模块，不能称 4,088 个业务页面。
- 原组件映射 **3,850 项**：3,601 个动态导入组件、249 个主包内联组件。按组件回调 AST 精确映射，未从相邻文本猜测。
- `frontend-recovered/src/views/<原组件路径>.vue.js` 按原路径定位。3,601 个文件包含实际恢复实现；249 个内联入口导向共享模块中的原组件定义，对应片段、符号、原始范围在 `frontend-recovered/inline-components.json`。
- 共享主包的 74 个源码片段保留原语句顺序；Vuex、CRUD、公共组件、权限、枚举、动态路由均在其中。`createApp/mount` 尾部启动抽为 `startRecoveredApplication()`。737 条启动前表达式/循环/条件包括枚举初始化、路由守卫与浏览器能力初始化，不能当作 737 个网络请求，也不能宣称共享模块完全无副作用。
- 原 vendor 的 **251 个导出**已映射到真实 npm 依赖或 4 个新构建兼容 helper；新工程没有复制或导入原 `vendor-7ae57976.js`。每个恢复模块直接导入真实依赖，原短绑定名保留，导入行可见 Vue/Element Plus 等真实 API 名。
- 原 CSS、图片、字体与 PDF/BIM 等第三方静态资源保留为可编辑/可替换素材；未复制原 `static/js` 发布目录。部分第三方独立 chunk 的实现暂作为有来源的 JS 模块保留，并不是这些第三方库的原始开发源码。

## 源码、构建与恢复命令的边界

常规开发只改 `frontend-recovered/src` 与 `public`，`npm run build` 只编译现有源码，不调用原材料恢复，不覆盖源码。共享主包由 Vite 插件在内存读取已有片段和路径索引拼接；`src/shared/runtime.js` 是虚拟加载入口提示文件，修改具体片段即可生效。

在本机固定使用 Codex bundled ARM64 Node，避免 PATH 中 Intel Homebrew Node 与 ARM npm 依赖混用（已回读 v24.19.0 arm64）：

```sh
cd /Users/sunxinxin/Documents/Project/LJ-APS/20-rebuild/frontend-recovered
/Users/sunxinxin/.cache/codex-runtimes/codex-primary-runtime/dependencies/node/bin/node --max-old-space-size=8192 ./node_modules/vite/bin/vite.js build
/Users/sunxinxin/.cache/codex-runtimes/codex-primary-runtime/dependencies/node/bin/node ./tools/test.mjs
```

完整 Vite 构建默认 Node 4 GB 堆曾耗尽；已用 8 GB 堆构建成功，脚本固定该构建额度。源码恢复的显式工具是 `recovery-tools/recover-frontend.mjs`、`map-original-components.mjs`、`create-independent-project.mjs`、`finalize-independent-project.mjs`。它们用于重新提取证据，会覆写恢复输出，**不在普通 build 中运行**，已有人工业务修改后不应直接重跑 materialize。

## 原路径与证据索引

- `docs/frontend-component-source-map.json`：全部 3,850 条精确组件映射、动态 chunk/内联符号与原映射范围。
- `frontend-recovered/source-map.json`：全部 4,088 个原 chunk → 当前实际源码路径及原 SHA-256。
- `frontend-recovered/inline-components.json`：249 个内联入口 → 共享源码片段/命名空间/原定义范围。
- `frontend-recovered/src/shared/assembly.json`：74 个有序片段 → 原范围与启动前表达式清单。
- `recovery-tools/generated/module-graph.json`：静态/动态导入、导出、props/emits、4,207 个含 method/url 的请求配置表达式。请求表达式不是去重后的服务端端点数。
- `recovery-tools/generated/vendor-symbol-map.json`：251 个 vendor 导出的 npm 替换依据与边界。

旧 `frontend-component-ledger.json` 的正则窗口提取在 81 组相邻映射上把内联与动态 chunk 配错，精确 AST 清单修正了 **162 条分配**，3,850/3,601/249 的数量未改变。后续按新的 `frontend-component-source-map.json` 寻找文件，旧 ledger 的“pending”是旧阶段状态。

## 本地鉴权与网络适配

启动先从同源 `GET /api/user/public-key` 取新服务公钥，再加载业务共享模块；`dr` 同步加密使用该公钥，未继续使用原硬编码公钥。原发布物包含的私钥已从活动源码删除，旧私钥解密函数 `grt` 禁用。进一步按导出 xh 追踪确认，其唯一业务使用者是用户管理的密码策略表单，用于解密 GET 返回的默认密码；已按新受限接口契约适配该表单：只读规则与defaultPasswordConfigured标记，不读取/显示现有默认密码；输入留空保留原密码，主动输入新密码才使用dr加密提交。这是明确保留的安全差异，不能声称现有默认密码明文显示仍与原客户端相同。

- `s9`：登录；`r9`：用户信息；`u9`：DELETE 退出；`lS`：菜单。
- `or/JV/bA`：本地新命名的 sessionStorage token，离开会话不会保留；Authorization 仍为 raw JWT。
- `yn/XV/VA`：访问地址固定当前 origin；不读取旧公司地址或源服务地址。
- 原 module → API prefix 表保留，例如 MES `/api/mes/building/`、WMS `/api/wms/`。
- 原动态预加载器只加载 CSS，忽略旧发布 JS 列表；真正业务 JS 由新构建图加载。
- HTML CSP 的 connect/script/frame 来源限制为当前 origin，阻止原外部 API、打印服务、OA、BIM 远程脚本自动联出。此限制意味着外部系统、客户端打印插件仍需显式集成与验收，不能算已恢复联通。

没有启动新端口。开发脚本只配置已登记的 3120，当前未启动；部署应由主任务协调切换 3120 的本地静态产物，API 仍同源反向代理。原 `frontend` 新 Vue 工程未修改。

## 依赖版本与验证边界

直接从发布物验证的版本包括 Vue 3.5.17、Vue Router 4.5.1、Vuex 4.1.0、Icons 2.3.1、Moment 2.30.1、Axios 0.22.0、SheetJS 0.16.8/0.17.5（用 npm alias 分开）、JSZip 3.10.1、NProgress 0.2.0、VXE Core 4.1.5/xe-utils 3.7.4/UI 4.6.41/Table 4.13.50、tree-org 4.2.2。Element Plus 2.14.7、Qrcode.vue 3.6.0、JSEncrypt 3.5.4、qs 6.10.1 等目前是新工程试配锁定值，不能声称原版本一致。

`tools/verify-recovery.mjs` 已通过 **24 个来源对照用例**：4 个 helper 合计15种输入/错误/对象契约，与原函数/浏览器外部模块行为对照；1 个真实业务格式化组件的3种 SSR 输入用真实 npm Vue/Element Plus 对照发布物对应业务表达式；工厂API6种调用的参数结构。没有执行原 vendor；这些用例不覆盖整个平台。

完整构建证明完整动态路由图及其可达依赖能够进入新构建图，不能证明 3,850 个组件的交互、权限、报表、写操作、审批、外部系统与数据结果已经验收。浏览器联调、后端接口逐项对照、数据写入回读、导出与打印、异常态和权限负例仍由完整重建主流程继续完成。

静态原导入图从入口可达4,087个JS模块；剩余1个PDF Worker由原硬编码URL引用，已改为源码new URL(..., import.meta.url)作为构建资产。全量源码静态检查覆盖4,088模块、3,850组件路径；无源码/组件/相对导入缺失。原4,207个请求配置中4,206个module/url/method/载荷键保持一致，另1个原中央公司查询按批准的本地适配替换为同源公司配置接口，再增加1个密码策略editable请求，当前总表达式4,208。该静态不变量不等于接口运行结果一致。

另有11个新鉴权适配测试：退出请求完成前保留token、请求失败保留会话、空token退出，以及6种失效错误码/成功/错误密码。恢复工程退出改为等待后端撤销成功再清会话，失效token统一回登录。它们是新鉴权所需改动，不宣称与原客户端退出时序完全相同。合计35个用例通过。

密码策略最终契约：GET /api/config/passwordPolicy/editable 由后端要求admin或user:getPasswordPolicy，只返回规则与defaultPasswordConfigured，不返回password。页面留空显示“已设置，留空保留”，加载失败禁用确认；POST原edit接口在空/缺失password时不调用dr、不发送password字段，由服务端保留现有值并校验规则。主动输入新密码时仍用同源新公钥加密。该适配有16个测试。

## 刷新、公司信息与打印修复

`src/runtime/session-bootstrap.js` 将刷新用户信息、菜单生成与路由安装做成同token的单次初始化；公司与关账配置是可选读取，网络失败不等于鉴权失败。全局守卫每个分支只调用一次next；主页开关在userinfo读取后判断，移除了较早的未初始化开关守卫。第一次安装路由后重新进入当前地址，不误进“全外链”iframe。新的sessionStorage token在刷新时保留，服务端失效才清除。

企业信息改用真实userinfo的companyName/companyLogo，必要时读取原同源GET /api/config/company/name。原中央客户编码、产品版本、授权到期时间没有本地已验证来源，保持null并显示待确认；没有使用companyNo或swagger版本替代。企业信息弹层不再请求外部中央服务。原SVG图标全靠path显示，未使用的ali字体定义已移除，571条主包path及6份独立SVG的图形保持原样；未放宽CSP。

打印模块导入不再探测Lodop、注入脚本或尝试下载驱动。真正点击打印时才读取显式配置的`globalThis.LJAPS_PRINT_ADAPTER.getPrinter()`；没有配置时显示不可用并reject。原NORMAL和打印设计分支忽略驱动false后返回true，已改为真实失败；队列回调false与驱动throw同样reject，真实任务标识原样返回；预览/自定义打印取消返回false。外层打印函数改为await内部打印，防止嵌套异步失败造成Promise悬挂。物理设备成功、打印内容与纸张效果尚未验收，不能把驱动接受任务等同打印出纸。

本地运行适配现有40个测试：刷新新Vuex/原sessionStorage、并发初始化、配置/菜单失败、真实守卫分支、同源公司事实与未知授权字段、未配置打印、实际NORMAL/设计/队列/预览函数及外层失败传播等。另有17个真实Vue自定义renderer测试，挂载恢复的common-button、人员header、密码策略及原useDialog；用明确的UI宿主/CRUD/HTTP测试双隔离外部依赖，覆盖深层鼠标target、Enter、null/undefined、closest/blur抛错、两次开关重读策略、加载失败禁用确认。common-button现在用currentTarget/closest定位按钮，失焦失败不会阻断业务click；未冒称自定义renderer证明原生Element Plus或真实浏览器鼠标已验收。加上24个来源对照、11个鉴权、16个密码策略测试，加上22个请求/附件/打印项目监听测试和12个实际新版审批handler/冻结空记录测试，当前合计**142个**通过。它们仍不是全平台业务验收。

主线程后续用浏览器click事件断点查明：此前“鼠标点击密码策略无响应”的真实目标是员工表格单元格，不是按钮，应用header处理器并未进入；浏览器缩放/自动化坐标偏差是该现象的测试环境线索。改用原生AX鼠标点击真实“密码策略”按钮，已观察到dialog=1及“已设置，留空保留”可见，Enter同样能打开并读取接口；临时Debugger断点已清理。上面的common-button补丁是独立防御改动，不能写成本次真实鼠标故障根因。该验收对应稳定index SHA-256 `421a4ad9fea983aec39be134a6711829b4456497b8159eadcff6a28909c34282`，不是全平台交互验收。

## 源码空实现与请求路径审计

`tools/audit-recovered-source.mjs`逐模块比较原发布物与恢复源码函数形态、占位文案、字面成功响应，并检查全部组件路径和内联定义。原有空函数1,714个，恢复后仍1,714个；未新增占位文案或字面`code:20000,data:...`响应对象。2个a→a3空构造器是第三方polyfill/路径变换原函数的局部绑定改名；VA固定同源后不再重置公司地址、grt禁用浏览器私钥解密，是两项明确本地适配。此启发式审计不证明原发布物本身不存在未完成函数，也不证明每个工作流完整。

`tools/audit-request-routes.mjs`抽取当前4,208个url/method配置，按原实际API module表与后端4,799条静态候选比较。标准URL解析会移除换行/制表符并裁剪首尾空格；审计同样处理，保留原表达式供追溯。3,215个字面表达式及387个参数表达式匹配候选；523个未匹配，57个模块动态、26个URL全动态。它们是请求表达式数量，不能当成缺失服务端端点数量，更不能把静态匹配当作调用成功。

`tools/audit-menu-reachability.mjs`使用私有local-menu基线，实际主系统含13模块、363个具体页面组件，全部映射存在。初鸣云招采与设备管理是另外2个外部系统链接，本平台备份没有其源码。按组件→非共享import闭包以及保守共享符号引用分类请求；禁止从中央路由的完整组件目录直接推导“所有可选产品模块都是当前菜单”。共享打印目录包含桥梁报表，仍须按业务入口判断；桥梁无当前菜单且原备份未含其控制器，不能换前缀或造返回声称恢复。完整分类见`frontend-recovered/menu-request-reachability.json`和`request-route-audit.json`，实际接口回读与剩余功能缺口由主任务继续核实。

当前非共享菜单import闭包2,061个模块。首次审计523个未匹配表达式中385个属于桥梁路径；非共享菜单闭包中31个非桥梁表达式待核实，保守共享引用还有22个，合计48个去重method/path模式。`current-menu-route-review.json`保留菜单源文件SHA和每项菜单→chunk→共享符号见证链。该清单是静态候选差异，仍可能属于原代理分流、参数化URL取值、原前后端版本差异或通用报表目录未使用分支，不能直接宣布48个功能缺失。4个原始空URL请求来自共享报表目录；它们在发布物中就存在，不能把继承发布物等同这些报表已经实现。

随后按`local/runtime/verification/runtime-registration.json`的实际4,804条注册映射再次比较，3,215个字面+387个参数表达式匹配，523个不匹配，与静态对照数量及集合一致；没有因实际注册多方法而消除差异。报告保留运行注册快照SHA、启动时刻、controller/java_method/pre_authorize；最终运行快照已补params/headers/consumes/produces条件，报告保留完整条件；仍需按具体请求实参校验。这是运行路由注册证据，不是4,208个请求都已调用的证据。

4,208个请求表达式均已索引到真实可编辑源码文件/片段和行号；189项在共享片段中有多处完全相同表达式，保留全部候选位置而不伪造唯一匹配。`inherited-unwired-print-catalog.json`逐项证明原项目管理费/内结材料/内结其他/内结管理4个报表目录函数URL原本为空；另一个v2 cost-report模块存在但未接到这4个key，未据此擅自替换业务。`inherited-empty-menu-reachability.json`给后端原空实现提供当前菜单范围：所查6组中，人工填报unfinished-list的2个批量报工POST当前可达，其余cost-report、simple-change-record、structure-70e27af9、wage-adjust、common-b3e76e54在当前菜单import闭包外。接口已注册与实现完整是不同证据，后端原空汇总方法仍需单独核实。

## 稳定构建发布

Vite会清理dist，直接挂载它会导致已打开页面引用的旧hash懒加载资源404。现在运行网页使用`local/runtime/web`稳定副本。构建、测试完成后，用同一bundled Node执行`tools/record-build.mjs`，生成现有源码、package-lock和dist全部文件的path/SHA-256/bytes清单；再由`local/activate-frontend.py`验证并发布。发布保留旧hash资源，最后原子替换index，构建不影响正在使用的页面。主线程已验证发布清单及篡改拦截/旧chunk保留；具体发布状态以`local/runtime/frontend-activation.json`为准。正常构建仍只编译已有可编辑源码。

## 菜单实际加载问题与历史接口逐项核查

`docs/menu-page-smoke-cases.json`用恢复的sc/ds/im菜单组装函数生成363个真实页面path，而非拼接旧redirect。主线程已在稳定旧版本逐页加载363页并重验16页，发现2处实际400与11张缺失旧域图片；该记录仅证明页面初始加载，未覆盖全部条件按钮或写入。

已按原后端契约修复：工艺文件分类listAll默认传MesProductEnum.BUILDING=1，调用者可覆盖；返厂维修隐藏抽屉不再带空项目读打印配置，而由真实detailInfo.projectId提供项目。对应实际请求函数与Vue setup/watch测试已通过，等待新版本主线程浏览器复验。

成功JSON响应中的附件URL仅在已知原部署origin且路径为`/files/`时转成相同本地路径。28个备份附件逐一核对源/副本SHA-256通过；公司logo JPG及10个MemberSectionImg JPG原备份缺失，保留真实本地404并明确提示补齐/重新上传，未下载原生产域、未用相似PNG替代、未放宽CSP。审计见`frontend-local-attachment-audit.json`。

`current-menu-route-resolution.md`与`frontend-recovered/route-resolution-ledger.json`逐项核查原48个模式，48项全部能回溯原请求表达式和原chunk SHA。多数属于禁用CRUD、被覆盖方法、始终关闭的旧对话框或当前菜单未打开的BIM集成分支。移库/退货当前真正detail组件已经使用approveRecordId、decision及审批意见，执行测试覆盖通过、无意见拒绝、请求失败不触发成功，不接回绕过审批的旧passed。

已修两处精确前端契约：kit配置删除GET→原DELETE；注资明细supplierId由query补到原路径第二段。后端另外补接冻结明细/办公用品批量调拨的原有服务及原权限；更新运行注册4806条后，3217字面+389参数表达式匹配，519未匹配（包括385桥梁扩展），比原523减少4。初始48项是保留的历史复核基线，不能将其全部当成当前真实缺口。采购get-inner/save-inner历史版本原实现正在由主线程按旧JAR恢复，前端没有擅改为自营结算协议。

最新待发布构建：index SHA-256 `9b7c32719b4523d60452f5911edcb598f59f79a31ec6bc8082f7d6ceb707871b`；runtime `assets/runtime-Cy-Ukxa1.js` SHA-256 `b9a2a7d63bef64ef4295f6d20f6a63fafe1e5f7bd6ccc5404222fa519b0c66bb`。142项测试、4421份源码、10411份产物已记录完整SHA清单。构建完成后已冻结，不自动发布；发布和浏览器复验由主线程执行。

## 内包结算草稿与审批预览

行级结算原本把`save-inner`的草稿响应直接提示为“发起审批成功”。现校验内部ResultVO.code=20000及有效ledgerId后，复用既有OA预览（common.dataId、radioType=1），仅提示草稿待核对提交；未自动发起OA。取消保留该订单的草稿，重新打开复用已有草稿，不再次POST。付款/发票按原Boolean协议检查true，失败保留表单；combined C和独立发票入口同步处理。

既有OA组件只在用户明确点击提交且权限/表单校验通过后调用原OA API。缺少/非法requestid、错误内部响应、关联失败均不会显示提交成功；关联失败保留已经真实生成的OA id，重试只关联，避免重复建流程。成功提示在关联原审批记录后出现；这不代表审批已批准或财务已完成。52项新增测试执行实际行级Vue组件、combined/发票handler与既有OA submit handler，HTTP/UI宿主为明确测试替身，未向外部OA发送请求；总计194项测试通过。真实浏览器和外部OA完成状态仍由主线程分别验收，不能以单测替代。

结算修复最新待发布构建：index SHA-256 `6c72791f3a1eb1fabd9969fc99890a38f84ea9fc12765cae341eb6679b859d0b`；runtime `assets/runtime-Ds25wXXu.js` SHA-256 `cae12889c2b30bc7ece185f25bd815c26d69d4f07342baca3ec2faf69e8f3cfd`。194项测试、4422份源码、10413份产物全SHA已记录。本次构建已冻结，未由子任务发布。


### 维护构建与发布命令

普通 `npm run build` 只执行 Vite；没有自动生成源码/发布证据的插件。以下命令在 `20-rebuild/frontend-recovered` 执行，使用同一个已锁定 arm64 Node，不要混用系统 x64 Node。`tools/record-build.mjs` 必须在成功测试、静态审计、构建之后显式执行；激活脚本再验证所有源码、lock 和 dist 指纹。

```sh
TASK_NODE=/Users/sunxinxin/.cache/codex-runtimes/codex-primary-runtime/dependencies/node/bin/node
"$TASK_NODE" tools/test.mjs
"$TASK_NODE" tools/verify-static-coverage.mjs
"$TASK_NODE" tools/audit-recovered-source.mjs
"$TASK_NODE" --max-old-space-size=8192 node_modules/vite/bin/vite.js build
"$TASK_NODE" tools/record-build.mjs
python3 ../local/activate-frontend.py
```

BG采购详情的旧I5下载现复用原K5：当前 `PurchaseOrderControllerV2.PurchaseExcel` 明确为自合营单据详情，按同一 `PurchaseOrder` 主键和 `PurchaseOrderDetail.purchaseId` 全量读取，保留物料/制成品模板、单位转换、金额及合计；不传现代订单ID给历史LumpSum实体。旧请求配置被显式退役合并至原K5，静态覆盖台账单列1项合并。下载仍需原 `scm_purchaseOrder_v2:download`，服务端权限及项目边界以对应后端验收证据为准。

结算草稿复用按最终实际POST的完整序列化payload指纹，先执行原表单校验与保存回调。取消预览不激活/删除草稿；相同payload可恢复预览，修改金额、订单、日期、人员或附件会新建hidden草稿。hidden不等于已提交OA/正式结算，最终激活仍沿原getRequestid/updateRequestId流程。

最终源码修订构建（205项测试，静态审计pass）：入口 `/assets/index-Qj6jHTJs.js`，index SHA256 `c82bc31e891eebe264c2430b2bb4b7eb00b472c179ea55f646d2cadb2a87d69a`；共享runtime `assets/runtime-CSf2FX1C.js` SHA256 `9c2eb824d5d66d369b5926f09999fb28a4426d4db09918c8feffa2d0a32d3a55`；10,413个dist文件及4,422个src文件均在source-build-verification.json逐文件登记。此条为构建证据；发布及真实浏览器/工作簿验收由各自运行报告证明。


### 原打印catalog与当前菜单范围再核

`frontend-recovered/tools/audit-print-route-bindings.mjs` 解析组装源码的实际 `WNe` 字段，经中间变量及 `mt`/`yt` 定位原handler，避免只搜旧叶子key而漏掉 `mes` 前缀。输出 `frontend-recovered/print-route-bindings.json` 保留具体字面/动态key来源、77处动态api-key表达式供针对性核验，当前菜单闭包由已备份实际菜单及原chunk图判断；这不是浏览器点击证明。

四个空URL最终key `projectManagementFee`、`innerCostMaterials`、`innerCostOther`、`innerCostManage` 无当前按钮绑定。旧班组工资最终key `mesStructureTeamWage`/`mesEnclosureTeamWage`（含Detail）只在未进入当前菜单闭包的旧team-report组件。`mesSchedulingDetail` 无业务调用；现计划详情是不同的有效 `schedulingDetailPrint`。`mesWipStatisticsList` 和 `wagesReport` 仅旧未配置页面；后者原完整只读Biz被后端作为额外受控映射恢复，不计为363菜单必要修复。`selfCollectionAndInvoiceInfo` 位于fundAccount旧弹窗，当前父组件实际按钮均选择record。工单 `mesAssembleNestingOrder` 仍被原固定TASK_LIST模式挡住，不新增套料Tab。

48模式台账每项附原artifact SHA/表达式offset和当前源文件path/SHA，已纠正仅搜Controller/Biz/大小写漏查造成的判断：getCountLength与getSupplierSettlementInner/addOaSupplierSettlement均为既有完整Service，原映射恢复沿现实体协议。套料看板也按Service→Mapper固定16 productType→前端32条件证明不可达，不再用“缺Controller”代替业务证据。仍需实际动作验收/外部BIM转换依赖的项目保持独立状态，不能把页面加载或构建通过表述为同等业务验收。

最终后端运行快照已只读对齐：app SHA256 `570265f8e06d39b8537accd6d11e955df0146f0ca664dcd668da28bdc6f1393a`，4810运行映射/4801业务映射、15765 Mapper语句、2904 Spring Bean、25初始化器、14本地任务。来源 `docs/backend-final-runtime-verification.json` 及 `local/runtime/verification/runtime-registration.json`，前端汇总内保留两份SHA。48台账恢复/修复的9项均精确命中1条实际注册映射；原48请求表达式与原chunk SHA/offset仍全部吻合。4,422源码文件重新核对冻结构建清单零变化，dist/index保持c82bc31e；无重新构建/发布。本轮为来源及覆盖证据刷新，不替代主线程363页真实验收及独立写入/权限验收。
