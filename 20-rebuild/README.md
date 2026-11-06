# 平台源码重建

已将保存的发布程序恢复为可编辑、可编译、可独立部署的本地平台。原证据与原版对照留在 `10-reverse`；新工程全部位于本目录。完整源码和运行模块已接回，最终独立迁移包已重装验证。**全部已识别源码恢复、页面加载、代表业务流转是不同证据项；尚不能宣称每个业务变体和外部集成都已逐项验收。**

## 当前工程与页面

- 页面：[http://127.0.0.1:3120/](http://127.0.0.1:3120/)，接口健康：[http://127.0.0.1:3119/actuator/health](http://127.0.0.1:3119/actuator/health)。
- `backend/modules`：37 个业务模块、9,639 个顶层 Java 文件，当前编译 13,453 个业务类（包括新增兼容 DTO，原 13,452 个类均有覆盖）；Mapper XML 和模板等 936 项资源已接入。
- `backend/app`：新的鉴权、密钥、运行适配与本地生命周期接入。原登录、用户、菜单与权限上下文已和业务服务连接。
- `frontend-recovered`：当前完整前端工程。4,088 个模块、3,850 条原组件路径（3,601 个独立组件及 249 个内联组件；组件数不是页面数），使用真实 npm 框架构建。
- `frontend`：先前手写的 Vue SFC 基础工程和资源闭环，保留作参考；3120 当前运行完整的 `frontend-recovered`，不再以该基础工程代替全平台。
- `local`：本机运行环境；新库 `plm7_rebuild`、独立 Redis、新应用密钥、可写附件及稳定运行副本。原对照库 `plm7` 保留；原 3117 后端因内存不足退出，没有重启其历史初始化和任务。当前原/新读取与模板复验使用已保存、带来源摘要的基线，详见 `acceptance/README.md`。
- `standalone`：脱离原项目和原对照容器的私有离线运行迁移包与无端口恢复验收工具。
- `acceptance`：明确接口契约、文件/模板、资源与跨模块业务闭环；深层写入使用独立一次性数据库组。

恢复的是可维护的工程，不是原作者的 Git 仓库。Java 的原注释及部分命名不能从字节码恢复；完整前端是整理后的 JS setup/render/Options API 源码，原 Vue SFC 模板、类型及注释没有凭空恢复。正常构建读取这些编辑文件，不从旧发布包重新生成并覆盖它们。没有执行原 vendor，也不把原业务 JAR 混进新后端依赖。

## 构建与本机启动

后端使用 Java 8，306 个第三方 JAR 由 `backend/thirdparty-lock.json` 锁定，离线缓存位于 `.deps`。离线编译和来源登记入口见 [后续维护说明](docs/development-maintenance.md)。前端依赖由 `frontend-recovered/package-lock.json` 锁定。Node 架构必须与本机依赖一致；当前 Apple Silicon 的完整构建使用 arm64 Node，最大堆 8 GB。

在项目根目录执行后端构建：

```sh
python3 -m unittest discover -s 20-rebuild/backend/tests -p 'test_*.py' -v
python3 20-rebuild/backend/tools/build.py
```

在 `frontend-recovered` 中执行前端构建：

```sh
npm ci
npm test
npm run verify:static
npm run build
node tools/record-build.mjs
```

回到项目根目录，发布稳定前端副本并激活本地服务：

```sh
python3 20-rebuild/local/activate-frontend.py
python3 20-rebuild/local/init-config.py
python3 20-rebuild/local/provision.py
python3 20-rebuild/local/activate.py
python3 20-rebuild/local/check-runtime.py
```

`init-config.py` 只生成缺失配置和新密钥。`provision.py` 只在新库为空时初始化，不覆盖已有业务数据；本机方式仍使用已恢复的本地 MySQL。新业务账号只授权新库，原参考库不用于新服务写入。跨机器运行使用下述独立部署包。

后端激活前核对源码指纹、模块、资源及产物摘要，复制到稳定 `local/runtime/app`。前端激活核对完整源码、依赖锁及每个构建文件摘要，复制到稳定 `local/runtime/web`，最后原子替换入口并保留已打开页面引用的旧哈希资源。正常源码构建不会删除正在使用的运行副本；不能直接把临时 `target` 或 `dist` 挂成正式运行目录。

## 独立备份与迁移

新库备份与恢复入口：

```sh
python3 20-rebuild/portability/database_snapshot.py
```

完整部署包的准备、离线镜像、私有文件、无端口验收和另一台机器启动见 [独立部署说明](standalone/README.md)。它包含源码新编译产物、完整前端构建、新库、附件、应用配置及新密钥，不依赖 `10-reverse` 或原数据库容器；运行迁移包与源码工程分别保留。

最终包为 `standalone/runtime/bundle-20261015-194624-ec597c`，不是阶段包。它在全新 MySQL/Redis 卷、唯一 internal 网络及无主机端口的 backend/web 中重装，685 表、569,000 行记录的数量/校验和/列定义在应用启动前全部匹配；完整身份和菜单、112 条业务读取及匿名拒绝、附件字节和 5 个 XLSX 模板工作簿对照全部通过。测试组结束后已清理。源码、包及运行版本摘要分别保存，不能用旧阶段包代替当前版本。

数据库、配置、附件、原始响应和密钥只保存在被忽略的本地私有目录，不上传外部服务，不复制原 Nginx TLS 私钥。保留当前完整快照及最近历史备份；历史 SQL 备份是否可完整恢复与当前新库可恢复是两个证据项。

## 当前验收与真实边界

[最终后端运行证据](docs/backend-final-runtime-verification.json)记录实际注册的 4,810 个总映射、其中 4,801 个业务映射，以及 15,765 个 Mapper 语句。原静态 4,799 条候选中的 4,795 条业务映射保持，原 4 条登录/退出/身份/菜单映射由新鉴权替换；另接回 6 条有原完整服务来源的受控映射。原用户资料 PUT 保留。映射注册证明接入，不等于每个业务流程已经验收。

当前实测包括新 RSA 登录、37 字段身份和完整菜单对照，无角色、禁用、密码重置与退出撤销；车间/产线的真实增改、重名、单位、启停和删除约束；完整源码前端的供应商新增、地区级联、修改、回读、删除；模板下载、附件上传/读取/删除；合同、计划、采购、库存、生产和经营分析读取。最新数量、失败和有意差异以 [业务读取记录](docs/business-read-contract-verification.json)、[资源闭环](docs/resource-lifecycle-verification.json)、[报表文件记录](docs/file-report-verification.json)及 [独立部署记录](standalone/verification.json)为准。

已补齐真实核查发现的本地缺口：25 项必要初始化、14 项按原周期执行的业务任务、旧工单查询字段失配、打印失败语义、生产月度汇总与跨月结转、原服务漏映射、采购详情导出和结算草稿回显。合同→计划→制造→手工发运签收、采购→仓储领用、其它材料批量调拨和型材人工审批均有独立组实际读写证据。原鼠标弹窗曾因测试浏览器缩放命中错误单元格误判，已用原生鼠标和键盘核实，不能记为业务缺陷修复。原源码本身的空实现、固定返回值和未开放分支有字节码及调用证据，不将它们算成已实现的新功能。

有意差异和外部边界：

- 原权限检查无条件返回 true；新服务按当前用户角色和业务权限执行鉴权。
- 默认密码策略不再向浏览器提供私钥或已保存的明文密码；留空保留现有加密密码，实际修改使用新公钥。
- 本地必要业务任务逐项接入；历史一次性数据修补、无条件改写设置、用户密码初始化、原备份删除及外部设备同步不会整包自动重放。
- 当前13个内部模块的实际菜单与共享前端附带的未开通产品模块分开核查。初鸣云招采、设备管理是独立外链系统；BIM 模型服务、OA、设备、短信、邮件、对象存储和实体打印等需真实对端及数据，离线恢复不等于对端联调通过。未配置能力必须明确失败，不返回假成功。
- 源码仓库为 `LJ-chuming`，本次公开源码基线与本地私有验收材料的边界见 [源码基线说明](docs/source-baseline.md)。Git提交不代表生产发布。

## 证据入口

- [完整实施与验收清单](docs/2026-10-15-full-platform-plan.md)
- [按实际菜单模块划分的功能与验收矩阵](docs/functional-acceptance-matrix.md)
- [后端运行接入说明](docs/full-runtime-integration.md)
- [完整前端恢复说明](docs/frontend-full-recovery.md)
- [前端准确组件来源映射](docs/frontend-component-source-map.json)
- [源码类覆盖](docs/backend-class-coverage.json)与[实际接口覆盖](docs/backend-runtime-route-coverage.json)
- [有效公司配置审计](docs/effective-company-config-audit.json)
- [原空实现和调用审计](docs/inherited-empty-methods-audit.json)
- [新库独立恢复证据](docs/database-portability-verification.json)

完整验收前，各汇总中的 `delivery_complete` 保持 false；已验证样本不冒充全部业务等价。
