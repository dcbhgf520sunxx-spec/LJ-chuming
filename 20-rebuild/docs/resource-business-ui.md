# 工厂、车间、生产线资源维护前端

2026-10-15。状态：新源码已实现、构建及 20 条前端测试通过；真实独立新后端 HTTP 资源生命周期 13 项检查通过，专用资源清理回读通过。浏览器页面交互验收待执行，不能据此称完整平台已验收。

## 原始依据

复用已有 REA 静态目录分析 `ev_c1171ca390d68b537119cfdc3406ce9189c714f3bdcbc174c074d362e2689e2b` 的目录身份及此前提取清单，针对具体打包 JS 与反编译源码重新逐项阅读。没有将 REA 图摘要当作运行证据。

原发布目录 `10-reverse/private/server/home/plm7/dist/static/js/`：

- `factory-7a1d88b2.js`、`workshop-e9af8725.js`、`production-line-c52339bd.js`：原 API 方法及请求体。
- `index-9a0e59b9.js`、`index-709b5122.js`、`index-5b36e0a4.js`、`form-3a71e4a2.js`、`form-c72ad198.js`：工厂与车间双卡片、点击工厂查看车间、输入字段/限制/权限、原新增工厂已有一行即禁用。
- `index-54c6c52a.js`、`index-253b480b.js`、`form-44ea4551.js`、`header-fd8c3399.js`：生产线表格与筛选、产品选项、编辑车间锁定、目标吨/月乘 1000 提交并除 1000 显示。
- `index-50216080.js`：`fa` 出口车间类型 1/2/4/8，`a3` 产品类型原 UI 排除 4/8 后仅 1 零件、16 部件、2 构件。后端枚举虽含 19，但原 UI 不列出，不自行添加。`b8` 默认标签颜色 `#1682e6`。
- 原前端权限字典 `b7/oP/p5`：factory/workshop/productionLine 对应 get/add/edit/del/editStatus。

恢复后的 `backend/modules/scim-rest/.../controller/mes/building/factory/` 三个 Controller，以及 `scim-mes-building-core` 的 WorkshopServiceImpl/WorkshopBizImpl/ProductionLineBizImpl，逐项核对 HTTP 参数、请求对象和约束。此处原业务类保持未修改。

## 实现范围

- `frontend/src/resource-business.js`：显式 API/请求字段/权限、精确原 component 映射、单位换算。生产线编辑保留原 `typeList` 对应 `linkIdList` 与 `productionLineTypeEnum`，避免无关关联被后台清空。
- `frontend/src/views/ResourceBusinessPage.vue`：工厂/车间列表与分页、筛选、增改、状态切换、删除、生产线下钻；生产线列表与分页、构件/工厂/车间/产品筛选、增改、目标产量、状态和删除。编辑对话框保留用户失败输入，显示真实服务端业务错误。
- `BusinessMenuPage.vue`：只有已核实的原 component 进入新业务页，其余仍明确待重建，不加载原编译 JS 或未知组件。
- `router.js`：原菜单路径入口和可直达的 `mes/production-config/factory-and-workshop/index`、`mes/production-config/production-line/index`。
- 延用既有 Shell、当前会话与 raw Authorization，未修改鉴权规则。

保留原字段限制：名称 1–32；简称最大 32（工厂必填）；备注最多 500；排序 1–999；车间 ton 为吨直接提交；生产线 targetProduction 为吨/月乘 1000；目标产量允许 0、最大 999999999。车间类型从当前用户 factoryProductEnum 派生，生产类型从 mesProductEnum 派生，未硬编码模拟账号权限。

## 真实接口契约及原规则

分页为 `pageNumber=1&pageSize=10`，不是 page/size。响应 data 为 `{content,totalElements,...}`。状态筛选 false 必须传递，不能当空值遗漏。

| 资源 | 列表 | 写入 | 状态 |
|---|---|---|---|
| 工厂 | GET `/api/mes/building/factory/page` | POST/PUT 同 base；DELETE `{ids}` | PUT `/changeState` `{id,boolEnabledEnum}` |
| 车间 | GET `/api/mes/building/workshop/page`，factoryId/name/boolEnabledEnum | POST/PUT 同 base，name/shortName/type/sort/factoryId/ton/remark；DELETE `{ids}` | 同上 |
| 产线 | GET `/api/mes/building/productionLine/page`，factoryId/workshopId/name/boolEnabledEnum/productType/mesProductEnum | POST/PUT 同 base，workshopId/name/productType/targetProduction/remark，编辑保留 linkIdList；DELETE `{ids}` | 同上 |

分支机构选项 GET `/api/branchCompany/all/simple`；启用工厂/车间选项使用各自 base GET，data.content。

以下是原后端静态规则，交由真实业务服务校验，不在前端复制猜测：

- 新增车间同工厂名称不重复；编辑车间名称查重跨工厂。
- 车间启用先检查工厂；禁用需该车间钢构产线都禁用。原状态方法成功可返回 data:null，前端按 code20000 后重新查询。
- 产线新增按工厂+车间+产品类型+名称查重，自动由车间回填工厂和 mesProductEnum，默认启用。
- 产线编辑没有与新增相同的查重；改变产品类型时已有工序/班组则拒绝。
- 产线状态切换检查未完成任务，启用检查车间，联动班组。
- 删除车间受钢构/围护产线、出库、班组、工序、质检配置约束。删除产线受工序和班组约束，删除自身后移除关联类型。
- 原车间 listByCondition 无视 type 请求与方法 type 参数，固定 SQL IN(1,2)。UI 允许4/8而列表不返回的差异保留，不宣称围护/网架页已重建。

## 验证与待办

已验证：`npm test` 20/20，包括现有登录/会话回归及 6 条新资源测试（原 component 边界、权限、目标产量和大 ID/类型关联保留、车间吨、false/分页参数、mutation 方法/请求体/raw token/null 成功）。`npm run build` 成功，新工程不引用 10-reverse 的业务 JS。

浏览器待验收：页面走工厂→新增专用车间(type1)→新增产线(产品2,target=12.5吨/月)→刷新回读12500存储及12.50展示→编辑→重名负例→启停顺序与删除约束→重新登录回读→删除专用资源。测试只能操作独立本地数据库，不改变源服务器。当前没有伪造 API 返回或用前端 mock 当作业务验收。

未完成：工序、班组、排程及全平台其它页面。本文件只报告本条资源维护页面，不扩大成全平台完成声明。

真实验收脚本已准备：`acceptance/resource-lifecycle.py`。`--self-check` 离线自检通过，Python 编译通过。执行前核验 Docker 新 backend 的实际 datasource 必须为 plm7_rebuild、账户为 local/.env 对应新账户、公钥为新本地生成 RSA；固定只请求 127.0.0.1:3119，不接收外部目标参数。脚本 SQL 能力只允许 SELECT（包括隔离库fixture回读和参考库三张资源表计数/摘要对照），所有新增/编辑/启停/删除均经真实 API。

专用 UUID 前缀在创建前进行包含软删除记录的碰撞检测，发生碰撞即停止。finally 只发现并按产线→车间顺序清理本次前缀资源，回读无活跃残留；不会为了让验收通过而直改数据库。证据输出 `docs/resource-lifecycle-verification.json` 不含密码或 token。现有工厂只读选取，不改其启停或信息。真实 HTTP 联调已执行，结果如下。

## 真实 HTTP 生命周期验收结果

2026-10-15 09:00 UTC 运行 `python3 20-rebuild/acceptance/resource-lifecycle.py`，`docs/resource-lifecycle-verification.json` 回读 `status:passed`。使用真实 RSA 登录与专用随机前缀资源，13 项检查通过：车间新增字段回读、同工厂新增重名拒绝、编辑重名拒绝、目标/简称/排序修改回读；产线同车间同产品重名拒绝、12.5 吨/月对应 12500 实际数据库值、修改目标/备注回读；带产线车间删除拒绝、启用产线下禁用车间拒绝、先停产线再停车间并在禁用筛选回读、禁用车间下启用产线拒绝、先启车间再启产线、退出后重新登录回读。负例还对照专用资源字段/版本快照，未发生隐藏写入。

finally 清理产线与车间后，两类专用资源活跃记录残留均 0；原 plm7 三张资源表计数与字段 CRC 摘要未变化。清理沿用原软删除规则，不强制物理清除历史。没有为了验收放宽任何原业务规则，也未直接 SQL 写入资源。

未执行现有工厂启停、任务/班组/工序引用的专用写入 fixture，以及浏览器 UI 流程；不能把 HTTP 验收扩大为这些路径的验收。

## 浏览器实测补充

新SFC资源界面已经过真实浏览器创建车间、跳转产线、创建12.50吨/月、编辑25.75吨/月及依次删除回读；专用前缀在新库两表活跃残留均为0。修复实际验收暴露的缺少El组件注册、同组件路由切换未重新加载、URL字符串ID无法回填数值选项的问题。新增实际SFC SSR渲染回归曾复现同一个row解构错误，修复后合计21测试通过。截图及范围见 resource-browser-verification.json；该证据只覆盖此新SFC界面，完整恢复前端另行验收。
