# 完整业务后端接入记录

目标：由 `20-rebuild/backend` 的已恢复业务源码独立编译，恢复业务资源并实际注册业务接口。原业务 JAR 不进入编译或运行依赖。

## 接入边界

- 已恢复 936 份有来源和 SHA-256 的运行资源，其中 Mapper XML 626 份，报表/导出模板及图片 310 份；清单在 `backend/resource-provenance.json`。
- 使用已锁定的 306 个第三方依赖支持完整业务类型加载，不含 `com.hzchum` 原业务字节码。
- 新鉴权继续验证新 RSA/JWT、数据库当前账号状态及持久化撤销记录；业务调用桥接原 `SecurityUser`，保留原角色、部门、菜单及权限语义。
- 原 `PermissionCheck.check()` 的反编译实现直接返回 true。重建服务不沿用此放行行为，而按原 `@PreAuthorize` 指定的权限名称检查当前数据库角色菜单授权，admin 仅按原 role.permission=admin 判断。**这是有意收紧的兼容差异，不能宣称此处与原程序完全等价。** 原证据：`backend/modules/scim-system-core/src/main/java/com/hzchum/scim/system/core/security/PermissionCheck.java` 的 `check` 方法。
- 原 `ScimApplication`、历史数据迁移 Runner、全局定时扫描、旧安全过滤器及日志参数输出 Aspect 不启用。必要本地默认值、缓存初始化和业务调度按显式清单运行；供应商分类初始化改为显式事务，不依赖 Bean 创建副作用。原源端数据和外部服务不受操作。
- 主服务仅使用独立数据库 `plm7_rebuild` 和新 Redis；另有明确受限的可弃置 QA 库。原参考文件和数据保留，3117 已因内存不足退出，不重启其历史初始化。原版对照使用已保存响应基线，不能冒充实时响应。新容器内部网络禁止外部出口。
- 旧认证入口的 login/info/menu/logout 映射由新鉴权实现接管；原 UserApi 其余业务接口仍按源码注册。

## 已观察到的运行证据

- 原部署历史静态候选 4,799 条中，4,795 条原业务映射实际恢复，另 4 条认证入口由新鉴权接管。最终实际注册总计 4,810 条，业务映射 4,801 条（原业务 4,795 + 6 条有原完整服务依据的受控恢复）；额外旧工资打印不在当前菜单，不计为 363 菜单点验缺口。
- 最终实际 MyBatis statement 名称 15,765 个，Spring Bean 2,904 个。statement 数包括完整名与短名，不当作独立 SQL 数量。
- 最终启动实时读回 `command_line_runners=[]`、`application_runners=[localBusinessLifecycle]`、`scheduled_processor_present=false`；25 项必要初始化成功，14 项本地任务按原 cron/zone 显式注册，lifecycle ready。未打开原全局外部任务扫描。
- 全量资源来源及包内 SHA-256 一致；运行目录 37 个新业务 JAR 和新应用 JAR 的 SHA 与已验证构建一致。无原业务 JAR 回退。
- 实际 RSA/JWT、37 字段用户信息、3 根完整菜单树、匿名/错误密码/禁用/重置密码/退出撤销回归通过。新用户信息与菜单原样本逐值 JSON 相同。
- 专用无角色用户对真实工厂 GET 分页、POST、PUT、DELETE 均被原权限注解拦截，返回“无权限访问”；测试用户结束后删除。另有 7 条权限单元检查，覆盖匿名、角色显示名称、读写区分、多权限命中和显式管理员。
- 只读契约对照、模板与附件验收由 acceptance 维护，已扩展到 113 项读取。原始逐值匹配、声明的业务拒绝、原缺陷修复分别统计；不把相同 500、404/502 或非明确鉴权错误当成功。原服务退出后的复验明确绑定冻结响应基线。
- 附件原 28 个文件复制到独立可写 `local/runtime/files` 并逐个校验，不写原证据。新 `/files/**` 静态路径与 Nginx 同源代理接入。上传/下载/删除验收由独立文件报告脚本记录。
- 模板响应使用原 Jackson 主链与末位 FastJSON 全媒体兜底。原用户模板控制器写 Excel 后仍返回 ResultVO；若缺兜底会导致已提交响应上的 No converter / Chunked IncompleteRead，已恢复原转换链，不在验收脚本吞掉中断。
- 原 Tomcat 数组查询字符配置已按源码恢复，避免 Axios/qs 的 `?probe[0]=1` 在进入 Controller 前被 400 拒绝；纳入最终真实 HTTP 验收。

## 仍需区分的边界

路由注册、源码编译和样本验收不能代替每条业务分支、每套租户/分公司数据范围的穷举证明。当前实际通过的跨模块写入、生产、报表与鉴权证据分项记录；不把未配置扩展、外部服务或真空报表当成已完成非空流程。

必要本地业务任务已经显式恢复。首批 13 项在独立 QA 真实运行成功、重复及重启跳过；原月结 31 分钟等待真实完成，没有延时绕过。第 14 项生产 carry 以原公式和 cron 经过真实周期 ledger、合并、失败回滚、重试和重复验证。外部同步、历史修复和运维任务仍排除，不宣称这些行为等价运行。

原招采模块含 `@DS("bidding")`，但有效 company 配置仅有 master=127.0.0.1:3306/plm7，未发现启用的 bidding 数据源。local 模板中注释的 bidding 地址为127.0.0.1:3306/bim，不能据此推断公司环境存在独立招采库。本环境仅运行 `plm7_rebuild` 单库，不向其他主机探测，招采业务仍须按原接口和数据验证。

短信、邮件、OA、BIM、设备、OSS 等外部集成默认离线；固定外部凭据与原硬编码服务器地址不作为新运行配置。Docker 新后端连接的网络均为内部网络，没有外部出口。

完整构建、受影响模块增量构建及激活都有独立回读证据，见 `full-runtime-verification.json`。37 个业务模块及新接入层源码指纹与相应构建对应，38 个运行 JAR 与构建报告一致。之后继续补齐真实生产、发运、生命周期和当前菜单漏映射；最终冻结摘要不能用首次集成结果代替。

## 默认密码编辑与审批边界

自动审批拒绝了最初“向浏览器返回明文默认密码”的新增接口构建，理由是本地重建/敏感备份授权不等于新增明文凭据接口授权，存在更安全替代。该方案已彻底移除，未绕过拒绝执行。

最终 `GET /api/config/passwordPolicy/editable` 仅返回策略规则、真实 `defaultPasswordConfigured` 和 `passwordEncoding=preserved`，没有 password 字段。读取要求原菜单 `user:getPasswordPolicy` 或原 admin；编辑要求 `user:editPasswordPolicy`。仅编辑权限不能读取编辑元数据。旧 GET 密文契约保留。

编辑时缺失/空 password 保留原密文，仍在服务器解密校验全部密码规则。用户输入新默认密码后用新公钥提交。原快照密文仅在 `plm7_rebuild` 中离线重加密，新旧明文值在内存核对，原行保存在私有目录，原库和原备份不变；原私钥不进入新源码或浏览器。

真实专用用户改密码回归已通过：错旧密码拒绝、旧 token 立即失效、旧密码拒绝、新密码重新登录及夹具清理。策略回归已通过：无角色拒读写、仅编辑权限拒读、新公钥密文保存、缺失和空值保留、非法规则拒绝，以及最终精确恢复迁移后的策略原行。

后续改代码、增加类、修改 XML、删除文件的显式登记与构建流程见 `development-maintenance.md`；不会把首次恢复清单当作永远不可修改的源码锁。

## 最终配置回读与命名数据源

有效 company 配置逐键审计见 `effective-company-config-audit.json`，非敏感业务常量与运行隔离差异分开列出。companyName、companyNo、yuanDecimal、projectNameShowMode、showContractNo、showProjectFullName、backupsNumber、weightTimeOut 八项均已从实际启动后的 Spring Bean 逐值回读；特别是金额精度恢复为原值 2，不能把“Bean 能启动”当作可选业务属性已经齐全。

原配置 strict=true 且仅有 master。新 `StrictDataSourceGuard` 保留这一边界，`@DS(master)` 正常运行，未配置命名源在进入该业务方法的 JDBC 操作前明确拒绝。原/新只读 `/api/bidding/subject/tree` 均返回 HTTP 200、code 50000、完全相同的错误响应。原现场先触发 MyBatis BindingException，未到取连接；新运行更早由缺命名源守卫拒绝，这一内部触发点差异明确保留，不宣称原现场观察到缺数据源异常。后端模块与原界面链接到的独立招采 iframe 也不能混为一个已验收系统。

最终策略验收恢复的是包含 value、update_time、version 的整行校验值，并删除全部专用用户、角色和关联，不只恢复默认密码密文。


## 本地业务生命周期补齐（2026-10-15）

首次集成整体排除原 Runner/Schedule 是避免历史迁移和外部副作用的临时隔离，不能据此宣称功能已全部运行。当前已逐项登记 118 个 Runner 与 24 个 `@Scheduled` 方法，见 `lifecycle-source-audit.json`；采用显式类/方法清单，不恢复整包扫描或全局 `@EnableScheduling`。

本地清单包含 24 个原缺失默认行/缓存初始化，加供应商评价分类初始化，共 25 项；13 个本地业务任务保留原 cron 和 zone。原调度线程数为 5，新显式调度器沿用 5；任务间不加全局串行锁。月结原 `ReportServiceImpl` 两分支均有 31 分钟等待，保留真实等待，不添加测试绕过。QA 库为 `plm7_rebuild_qa_lifecycle`，独立受限用户、Redis、内部网络，无宿主端口；只从本地重建库只读复制，未修改原参考库。第一遍初始化后，重复第二遍的全业务表 `CHECKSUM TABLE` 完全一致；13 项真实运行、同周期重复跳过及重启幂等均已通过，原 31 分钟月结延时真实完成，见 lifecycle-qa-first-execution.json 和 lifecycle-qa-restart-verification.json。

新增 `rebuild_job_execution` 以原任务方法名和本地日/月/年为主键。单任务数据库操作与成功状态在同一事务提交；重复成功周期跳过；异常回滚并单独记录异常类名，不保存敏感异常内容。原部分任务吞异常仅打日志，已改为上抛，不能把失败登记为成功。缓存写入本身不参与数据库事务，失败重试可重建缓存。当前部署只有一个调度实例；数据库行锁同时保护同周期。启动期间 API/健康返回 503，待必要初始化完成才放行。

有意修正原缺陷：`ConfigRunner` 不在每次重启删除/重置 VEHICLE 偏好，不重放历史短信迁移或重新创建 BIM 许可证密文；年度行为分配置复制清空主键与创建/更新时间，保留前一年记录；缺前一年配置明确失败；空用户集合不会导致无条件更新全体用户。考勤任务仅保留源代码的两个本地生成调用，两个外部微信消息定时器明确排除。

自动审批拒绝把 `InitInventoryUseRunner` 提升为正常启动初始化：它会把既有库存多个字段置空并写回，属于历史库存修复，无法用“缺默认值”解释。已撤回该接入，保留恢复源码、原库存与历史快照；没有采用间接执行或测试开关绕过拒绝。

旧 `/api/mes/building/task/order/page` 原服务也因 `product_type` 已不存在而报 50000，前端当前未查到调用。现显式把 `taskTypeEnum` 映射为 DTO `productType`，XML 按真实 `task_type_enum` 查询并 alias 回 DTO，保留原 `16|32` 位逻辑，不追加无证据的业务过滤；无效任务类型明确拒绝。独立 QA 28 条专用工单覆盖六种合法类型、两页分页和五种非法类型拒绝，夹具清理为零，见 `task-order-query-verification.json`。

### 原空实现的当前菜单归因

原 27 个空返回/常量返回方法已经逐个读取原业务 JAR 的 Code 属性验证，27/27 本来如此，包括四个 `Boolean.valueOf(true)` 常量方法。报告 `inherited-empty-methods-audit.json` 记录字节码、原方法描述符、类型化反向调用路径和前端请求引用；它不把静态引用当作真实菜单点验。

前端恢复代理按当前 13 模块/363 菜单原依赖闭包复核（`frontend-recovered/inherited-empty-menu-reachability.json`）：六组前端源中只有“MES → 人工填报”（menu1100039）的未完成清单当前可达；旧 cost-report、simple-change-record、商务structure、wage-adjust、common异常页不在该闭包。旧 V1 变更导入 `/import/v1` 空实现有已实现 `/import` V2 替代。无调用者的旧 WMS 常量成功方法没有被冒充为已运行审批/出库流程。

人工填报会调用 `MesBuildingProductProductionSummaryServiceImpl.updateRecord`，该方法的原 false 空实现会漏写月度汇总。恢复依据不是新造业务规则：原 `MesBuildingTaskFastBizImpl.updateRecordFast` 629–673 已完整定义按 productId/productType/当前month 新增或增量累加 task/inProduction/complete 的算法，使用同一个 DTO。现单条方法复用其规则，正负增量均保留，成功返回实际落库结果，失败抛异常触发外层回滚；不会把无落库当成功。原 `updateTaskQuantity` 涉及历史任务月份，仍缺精确规则，单列风险，不自行发明跨月扣回口径。独立 QA 真实 MySQL 探针已验证同月增量、正负变化、产品类型隔离、历史月不变及外层事务回滚，见 summary-persistence-verification.json。

历史导出的 `PlanAreaServiceImpl.listAreaByMonomerId` 用同一源码已有 `listProductTypeByMonomerId` 的 exact monomerId 查询修复，保留 MyBatis 逻辑删除。它是有明确证据的小修复；未由此任意填补其它空方法。

## 生产、撤销与发运的实际数据验证

原派工和人工填报链漏接月统计。现只维护本次新建任务及本次报工/撤销的增量，不重放历史任务。派工记录当月 taskQuantity，首道维护 inProduction，末道维护 complete；撤销按原报工 createTime 月份反扣，原可撤销、防重复和外层事务继续生效。

项目统计直接接入原 updateProjectMeteSummary 的工序类型/序号规则：倒数第二组铆焊、涂装和最终完工分别计量，项目与全局各一份。原方法错误地从 paining 字段读取组铆焊/最终计数，现改为各自字段，撤销镜像相同。独立 HTTP 四工序两件净重 6.28kg 已通过：task/inProduction/complete=2/2/2；首道撤销一件为 1，补报回 2；项目及全局三类分别 2/6.28kg。独立 MySQL 探针另测末道撤销补报、非倒数第二铆焊不误计和外层事务全部回滚，见 production-monthly-database-verification.json。

班组报表派生子查询原来漏选 task_type_enum/report_type，外层却引用两列，另有 report_ype 拼写错误。按原 task/report 分组补齐两列并修正拼写后，真实 8 条报工记录已从 HTTP 列表回读。

发运实体 quantity 是 BigDecimal，原 DTO 是 Integer，原 BeanUtil 不做转换，造成真实发运后的 summary 空指针。两处列表/分页显式转换原件数 DTO，重量、金额不变。独立已签收两件数据下列表、分页、汇总读回 quantity=2、netWeight=6.28、actualWeight=6.28；独立事务探针同时验证金额汇总且全部回滚。

生产 carry 原类没有 Component，所以源部署未调度；在恢复活跃月统计后，它是必要跨月任务，现按原 cron `0 10 0 1 1/1 *` 显式启用。这是有意补齐的差异。采用原 begin+task-complete、inProduction-complete 公式；当月已先有新派工/报工时保留当前 task/complete，合并在制 carry，避免覆盖 00:00–00:10 的业务。已有非零期初且无作业事实时明确失败，不推测历史已结转状态。原月与当前行加事务锁，同事务月度 ledger 防重复。真实 QA 覆盖无当前行、有当前报工、同产品不同类型、失败全部回滚并登记 FAILED、修正专用夹具后重试成功、重复周期跳过，全部清理，见 production-carry-database-verification.json。

## 有来源的接口恢复与受控额外映射

GET `/api/wms/nesting-docking/getNestingFreezeDetail?id` 直接调用原完整服务，严格要求原页面 `wms_mes_receipt_review:detail` 权限；缺 id 是明确参数错误，不存在工单明确拒绝，无套料/冻结返回空。PUT `/api/wms/transfer/application/other-material/batch` 直接调用原 batchTransfer(...OTHER=128)，沿用原其他单条的三个调拨权限，保持批量事务/审核配置；拒绝空明细和用 OTHER 权限操作其他库存类别。独立 HTTP 权限、未冻结正例、缺参/无工单及全夹具清理通过，见 wms-source-mapping-verification.json。独立业务 QA 又以专用 OTHER 期初入库 10→审核调拨 3，读回源 7+目标 3 守恒；第二条错误库存使整批头、详情、冻结和库存原样回滚，没有用 AUX 库存代替。

旧内结算 GET/POST 协议由本地历史 plm6-test-bak.jar 的 Controller/DTO/Service 证据恢复，连接当前仍完整的原服务，绝不改走自营协议或直接批准。POST 只允许原 pay_application 权限，GET 允许 pay_application 或 invoice_entry；项目可见范围复用原 listSimpleProject。旧协议仅接受单项目，并核实实际订单的项目、供应商、经理和合同号，拒绝 CSV 子串和浏览器伪造关联。草稿供应商/订单类别来自实际订单，ledger 保留申请 filingDate，发起人为当前认证用户。订单类别和非空 audit_type=PAYMENT_APPROVE 补齐来自当前同采购实体的既有结算规则；旧草稿方法缺这两项，作为有意缺陷修复记录。返回原嵌套 ResultVO/ledgerId，草稿仍软隐藏、待审核；没有审批或付款。

真实 OA 预览是 getFixedData(dataId=ledgerId,businessType=3)，不经过 settlementAuditDetail。原 ContractAuditLedgerService.getById(Long) 重载与 getAount 专用 XML 已能读取隐藏草稿，不新增全局逻辑删除绕过。只在实际 SETTLE 隐藏草稿调用点增加原付款申请权限/管理员、当前创建者、待审核采购结算/预结算和原项目可见范围校验。独立真实 MySQL 已验证正确草稿及原 DTO 预览、无权限/非本人拒绝、伪造关联/CSV 拒绝、金额/申请时间/身份、外层整体回滚，见 inner-settlement-database-verification.json。

型材库存总长度 GET countLength 直接接原 getCountLength，不重写算法：同原截面规格误差、材质、仓库等库存筛选，未分页遍历 length×quantity，总长保持毫米供原前端换算。权限取实际排产预览库存按钮的 mes_scheduling_section_machine_part:noNestingSave，未凭菜单 get 放宽。独立 QA 已按原钢材期初人工审批真实创建三条库存，17 项总长度、分页无关、规格/材质/仓库筛选、空零和权限回归通过，审批模板已恢复。

主库激活前后 683 个原业务表列定义相同，682 表 checksum 相同。唯一差异是父代理真实浏览器专用车间 id13 软删除记录，原有 8 行逐字段摘要一致；报告保留 raw_all_checksums_match=false 并单列 verify_expected_changes=true，不伪称全部原表无变化，不物理删除该夹具。当前总表数 685（683 原业务、新认证撤销、新作业登记）。

受控额外工资打印使用原 auditedWorkshopProcessTeamListPrint 和精确 mes_yield_confirm_audited_list:print。原独立 wages-report 页面不在当前 363 菜单闭包，不能说它是当前菜单缺口。此方法仅本地 header Map 与原 SELECT/DTO 转表，无写库或外部调用；真实 PrintVO header 三项/table 空数组、缺模式和匿名/无角色负例通过。本 QA 没有已确认工资行，不宣称工资打印非空验收。

旧隐藏内结算草稿允许重复预览，取消只关闭界面而不删除；修改真实表单内容可以新建草稿。这是原机制，不将两条隐藏待审草稿误判为两笔正式结算，也不自行拒绝而造成取消后死单。真实 OA 外部提交/正式激活仍须与本地草稿预览区分。

现采购详情 PurchaseExcel 直接使用真实订单及 purchaseId 明细和原模板，补原页面精确下载权限：自营项目属性 1 为 self download，合营/内包 2/3 为 DS download，且订单项目须在原 listSimpleProject 可见范围。无权限/无可见项目/不存在订单在输出流前拒绝。BG 原表单合法缺失付款模式，导出显示“-”而不伪填到货模式 4；其余合法 nullable 头信息同样明确未知，数量、金额和非空原映射不变。独立真实 XLSX 已重新打开 ZIP/XML，订单编号、50 元、10 只、M56 逐项匹配。

## 最终构建与运行冻结

完整 37 模块已从空目录离线构建：9,639 份业务 Java、13,453 个业务 class、13 份新接入层 Java。9 项基础对照、18 项鉴权、7 项权限、14 项构建/来源工具测试通过；936 个包内资源与当前登记字节一致，306 个第三方 JAR 锁与运行副本一致，不含原业务二进制回退。全量产物 38 个 JAR 的每个非目录条目均与实际业务 QA 的 1aac 候选逐字节相同，SHA 差异仅来自 ZIP 时间元数据。

最终已激活 app SHA-256 为 `570265f8e06d39b8537accd6d11e955df0146f0ca664dcd668da28bdc6f1393a`，business.properties 为 `47d50e83407ddd7e4788363bdd6ad9636b0be3500bbaceb6940a21fb00589793`。真实健康 200 UP、持久退出跨重启、37 字段用户信息/3 根菜单与原样本、错误 token/密码、无角色 CRUD、数组查询、专用改密、策略权限/空保留/整行恢复均通过，主库专用夹具全部清理。见 backend-final-runtime-verification.json 和 final-clean-build-verification.json。当前无 Git，不宣称提交或发布；最终迁移包仍由独立新环境按其实际摘要验收。
