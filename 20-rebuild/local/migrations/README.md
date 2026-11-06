# 本地兼容迁移

## 用户部门/岗位变更记录（20261023）

原生合法长部门名称变更已实测失败：原名称与新名称各28字，`old->new`共58字，超过原日志列50字。`20261023-user-change-record-names-width.sql`仅将`shr_user_change_record.dept_name/job_name`扩为512字，容纳两个原生255字名称和分隔符，不截断历史或新记录。Java列声明及新库`schema.sql`同步；已有库明确迁移，不依赖启动自动改表。

一次性内部QA使用`migrate-user-change-record-names-20261023.py --project <owned-QA> --part <unique-evidence-name> --apply`：校验归属/内网/无端口，持HTTP helper锁，先备份原表，仅允许两列宽度变化，并核对全部既有行摘要。普通本地重建库由`migrate-main-compatibility-20261023.py --apply`在backend停止、全库备份后统一执行；不会修改源服务器、截断内容或缩窄回滚。

`20261019-inspection-user-id-bigint.sql` 只扩宽两张巡检表的 `user_id`，使其与 `sys_user.id` 和 Java `Long` 一致，保留原可空性、默认值和注释，不回写业务行。两处 Java `@Column` 与新本地初始化 `local/schema.sql` 同步为 BIGINT。

已有本地库不会因为重新运行 `provision.py` 自动迁移：其已有表检测会提前返回。对原始恢复后的一次性无端口内部 QA，先预览，再显式执行：

```sh
python3 20-rebuild/local/migrate-inspection-user-id.py --project ljaps-standalone-check-<本次12位ID>
python3 20-rebuild/local/migrate-inspection-user-id.py --project ljaps-standalone-check-<本次12位ID> --apply
```

脚本复用验收组所有权、内部网络、无主机端口和新库名称校验，固定连接该组的 `plm7_rebuild`，拒绝原环境及普通本地容器。它锁定本组 HTTP helper 窗口，对比迁移前后全部字段定义和两表逐行摘要；只允许两列类型变化。报告留在该组私有 runtime。重复执行不重复改变定义。已有常规本地 `plm7_rebuild` 应在其已确认的本地数据库连接中显式执行上述 SQL 文件，而不是等待 `provision.py`；本轮没有执行该普通本地库入口。

独立包先按原快照核对数据及列定义，再将已授权迁移单独记录。旧快照的原列哈希不会与迁移后哈希相同；不得把差异伪报为原恢复一致。新独立包须从已迁移的新库重新导出并验证快照后再准备，保留其自己的列定义哈希。不要修改源数据库或历史冻结快照，不提供向 INT 缩窄回滚（新大 ID 已写入后不可安全缩窄）。

`20261019-conversion-rate-permission-leaves.sql` 仅更正构件类别及折合率菜单下 ID 6000056/6000057 的两个错误权限码，带父菜单 ID 和旧权限值 guard，保留原 ID 与全部角色菜单关联。新本地 `schema.sql` 包含同样更正。已有一次性 QA 通过原菜单维护 API 执行（自动使用原服务的 Redis/User 缓存失效逻辑），而非直接业务 SQL：

```sh
python3 20-rebuild/acceptance/project-mes-extended.py --project ljaps-standalone-check-<本次12位ID> --case correct_conversion_permission_leaves
```

该用例先回读并验证精确旧值，仅修改 permission，随后核对其余菜单字段与所有角色关联。最终新快照须包含更正后菜单；已有普通本地库需明确执行该兼容 SQL 并重登录，不会由已存在库的 provision 提前返回逻辑自动处理。本轮仅在指定 QA 执行原 API，不修改原服务器。

## Current V2 plan delivery dates

`migrate-plan-delivery-dates.py --project <owned internal QA> --apply` adds only two nullable date columns to `plan_area`. It verifies unpublished ports, isolated internal ownership, existing-column row hashes, the exact two schema additions, historical NULL values, and idempotent reruns. The source environment and business row values remain untouched. The explicit migrated schema is distinct from the original restored schema baseline.

### PlanV2 budget precision (20261019)

`migrate-plan-budget-precision.py --project <owned-internal-QA> --apply` permits only the exact `plan_area.mete` DECIMAL(19,0) to DECIMAL(21,2) expansion (or idempotent 21,2). It preserves 19 integer digits, NULLs and existing numeric values; compares all other plan_area columns and full schema definitions under the QA helper lock. It never infers historical fractions. The same DDL is appended to local/schema.sql for newly restored local groups. This explicit compatibility change is separate from original snapshot equality.

### MES 基础卡片按钮权限（20261019）

`20261019-mes-base-permission-leaves.sql` 只处理当前 PC 基础配置父菜单1176下的四组既有前端权限：恢复涂装计量原按钮32514/32515，补齐 APP 仓库重量、零件排产展示层级、原料损耗公式六个缺失按钮6001001..6001006。保留所有原菜单 ID 与角色绑定，不自动授权任何普通角色。

新本地初始化的 `schema.sql` 包含带精确父菜单、组件、分类与旧值 guard 的同样兼容。已存在的重建库由 `LocalMesBasePermissionInitializer` 在生命周期启用时事务执行：检查数据库名、父菜单和已占用ID，遇到冲突失败，不覆盖其它菜单；不增删角色链接，变更后沿原服务方式清除菜单/用户缓存。已有库不依赖 provision 的提前返回逻辑。

本轮仅在指定一次性 QA 先通过原菜单 POST 补齐六叶，再由下一候选本地初始化恢复两张软删原叶（原 Menu API 不提供软删恢复方法）。运行 `project-mes-extended.py --case mes_base_permission_leaf_compatibility` 核对前后每个原菜单字段、原角色链接及恰好六张新增按钮；之后以真实 RSA 普通 full/read/no-role 角色验证每卡读写。不修改源服务器或原始冻结快照；最终新快照必须含明确迁移后的菜单。

### 巡检缺勤用户ID（20261020）

自然 23:55:59 巡检缺勤任务实证发现第三张表 `project_inspection_task_absences_record.user_id` 仍为 INT，而 Java 字段为 Long、真实巡检受派账号已超过 INT 上限。新增独立 `20261020-inspection-absence-user-id-bigint.sql` 仅扩宽该列，保留 NULL、默认值、注释和原业务数据；不修改此前两列迁移的文件与证据语义。Java `@Column` 与新本地 `schema.sql` 同步。

已有一次性内部 QA 先预览再执行：

```sh
python3 20-rebuild/local/migrate-inspection-absence-user-id.py --project ljaps-standalone-check-<本次12位ID>
python3 20-rebuild/local/migrate-inspection-absence-user-id.py --project ljaps-standalone-check-<本次12位ID> --apply
```

执行器沿用既有容器所有权、无端口、内部网络和数据库守卫，持本组 HTTP helper 锁；只接受原 INT 或已迁移 BIGINT，逐项核对可空性、默认值和注释，比较前后全部列定义及该表全部行摘要。只允许此列类型变化，重复执行留独立 rerun 证据。`provision.py` 对已有库提前返回，因此已有常规本地库须在已确认连接中显式执行上述 SQL；本轮只修改指定 QA，不修改源数据库，也不向 INT 回滚。新导出快照必须保留这一明确迁移后的列哈希，不冒充原快照一致。

原业务方法始终取 `LocalDate.now()`，即使指定单条路线也会计算当日缺勤。凌晨手动调用会提前生成今日缺勤，本次不会重跑、修改时钟或 SQL 写缺勤业务行；schema/JDBC 与真实原服务类内存验证分别留证，不把内存探针称作原自然定时任务已恢复成功。
