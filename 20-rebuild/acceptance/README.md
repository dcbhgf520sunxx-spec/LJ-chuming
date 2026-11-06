# 本地业务验收

本目录的业务验收仅访问本地服务或本次专用独立容器组，不请求源服务器。所有原始响应、账号和令牌保留在被忽略的私有 `runtime/` 或既有本地夹具中，公开报告只保留状态、差异字段路径和计数。

```bash
python3 -m unittest discover -s 20-rebuild/acceptance -p 'test_*.py' -v
python3 20-rebuild/acceptance/read_contracts.py --reference-only
python3 20-rebuild/acceptance/read_contracts.py
python3 20-rebuild/acceptance/resource-lifecycle.py --self-check
python3 20-rebuild/acceptance/resource-lifecycle.py
```

原版 3117 后端已因内存不足退出。没有为刷新对照而重启其可能写入原库的旧 Runner。当前复验使用保存的基线：

```bash
python3 20-rebuild/acceptance/read_contracts.py --reference-baseline 20-rebuild/acceptance/runtime/frozen-reference-baseline.json
python3 20-rebuild/acceptance/file-report-contracts.py --reference-baseline 20-rebuild/acceptance/runtime/frozen-template-baseline/manifest.json
```

读取基线明确是由此前已通过原/新逐值对照的阶段包响应推导，并补入此前观察到的两个原版业务错误响应；报告保留阶段包、原运行包和基线的摘要及推导说明，不能视为新采集的原版响应。5 个模板基线则保存原版退出前实际下载的字节，并核对此前通过记录中的摘要。脚本校验私有基线的位置、接口清单和文件摘要。旧实时模式仍保留，但原版预检或传输失败会直接失败，不会以“两边同为 502”算对照通过，也不会覆盖此前有效基线。

`read-contract-cases.json` 是经过源码定位的明确 GET 样本，不自动扫描运行全部静态路由。覆盖工厂/车间/产线、部门/分公司、字典、供应商、工艺、仓储配置，以及 CRM、合同台账、申购采购、项目计划、排程、库存、生产任务、报工和经营分析。部分原配置读取方法在缺省时会写入默认值，只在本地测试数据库执行，不宣称仅由 GET 方法即可证明无副作用。日期参数按原 `JacksonCustomizerConfig` 使用毫秒时间戳；任务类型来自原枚举；仓库分页显式按排序号和 ID 排序，避免相同排序号的数据库未定义顺序影响对照。

返回状态、JSON 字段、数组顺序和值逐项比较。唯一的无序树契约是 `classification/tree/all`：原实现从 Redis `HVALS` 取值且不保证节点顺序，因此只按 ID 对根节点及 `children` 排序后比较，节点内容、层级、其它数组、缺失/null/空子节点仍严格比较；报告同时保留原始是否相等及差异路径。当前管理员没有分包商身份时，`project/sub/task-quantity` 的指定业务拒绝作为独立负例统计，要求 HTTP、完整响应、错误码和消息全部匹配，不计入业务成功。其它两边都报错仍然失败；404/502/500 不计入鉴权拒绝。任一未接受契约或匿名未拒绝都会使脚本非零退出。

旧工单查询另记为有证据的原缺陷修复：必须匹配声明的原 50000 错误响应和新 20000 正常分页，并且已有非空工单、筛选、分页、负例和清理证据通过。它计入修复项，不混入原/新成功读取完全相等的数量。

公开结果在 `../docs/business-read-contract-verification.json`。这是有边界的样本对照，不替代所有业务流程验收，空列表对照也不证明新增、审批和跨模块流转。

`resource-lifecycle.py` 使用新库中的随机专用前缀，验证真实车间/产线创建、编辑、单位、重名、启停、引用删除约束与会话重登回读。碰撞时不继续，通过业务接口清理本次夹具，不修改现有工厂状态或原版本地数据。

跨模块写入脚本通过 `independent_business.py` 校验专用 Compose 标签、内部网络、无主机端口及新库名称，再在该组中执行。包括 `contract-plan-lifecycle.py`、`scm-wms-lifecycle.py`、`production-lifecycle.py`、`shipment-lifecycle.py` 及其专用补验脚本。不能将这些脚本改指源库，也不能把隔离组夹具混入交付快照。SQL诊断仅允许 SELECT，实际创建和流转走业务接口。
