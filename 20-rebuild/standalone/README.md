# 独立离线部署包

本目录将新源码编译产物、恢复后的前端构建、新重建库快照、应用配置、新应用 RSA/JWT、附件和本地 Docker 镜像打包。准备阶段明确读取当前项目材料；准备完成后，部署与验收只读取本目录，不挂载 `10-reverse`、`local`、`backend/target` 或原对照容器。

`runtime/` 为私有目录（700），配置、数据库快照、密码、密钥及日志为 600，已由本目录 `.gitignore` 排除。这里包含新应用私钥和验收账号凭据，整目录按私有备份管理，不上传外部服务；不包含原 Nginx TLS 私钥。

## 准备

先完成 `../backend` 和 `../frontend-recovered` 的源码构建，以及 `../portability/database_snapshot.py` 的当前新库导出/恢复验收。准备会核对构建报告、全部业务 Java 源码指纹、37 个新模块 JAR、第三方锁定摘要、前端源码指纹与构建入口，再检查新数据库快照的已验证摘要。

从项目根目录运行（快照路径替换为当前验收通过的新快照）：

```sh
python3 20-rebuild/standalone/bootstrap.py self-check
python3 20-rebuild/standalone/bootstrap.py prepare \
  --snapshot 20-rebuild/portability/runtime/20261015-174204-7ed59a75d0e8/plm7-rebuild.sql.gz \
  --fixture-env 10-reverse/local/.env
```

`--config-dir` 默认 `20-rebuild/local`，仅准备时读取。`--fixture-env` 只取网页账号密码，用于容器内真实 RSA 登录验收，保存在包内私有 `verification-input.json`，不传入服务容器环境或命令参数。准备时对当前新本地服务抓取用户/菜单基线，业务基线选自已完成的原/新对照，包内保存当时全部成功读取的接口响应；实际数量见验证报告。不会连接原远程服务器。

每次生成新的 `runtime/bundle-日期时间-随机标识/`，不覆盖已有目录。包内包含：

- `app/`：新 app、37 个源码模块、锁定的第三方依赖，不含原业务 JAR。
- `web/`：`frontend-recovered/dist` 完整构建。
- `database.sql.gz`：只导入新库 `plm7_rebuild` 的快照，以及已验证表清单。
- `files/`：独立可写附件目录。
- 新应用 RSA、公私有业务配置、独立数据库随机凭据和新应用 JWT 配置。
- `images.tar`：MySQL 8.2、Redis、Java 8、Nginx 四个已缓存镜像，缺少镜像时直接离线载入。
- `manifest.json`：包内初始文件的 SHA-256 清单。

## 无端口验收

```sh
python3 20-rebuild/standalone/bootstrap.py verify \
  --bundle 20-rebuild/standalone/runtime/bundle-日期时间-随机标识
```

该命令只启用 Compose 的 `verification` profile：新随机项目、新 MySQL/Redis 卷、自己的 backend/web，单一 `internal` 网络，**没有发布主机端口**，不连接任何对照服务网络。恢复只发生于新建的空卷，不导入现有数据库。MySQL 不向主机开放端口。

验收从独立容器内真实请求 Web/API：数据库健康、源码前端入口、新 RSA 登录、用户与菜单逐值比较、包内全部成功业务查询及匿名拒绝、已复制附件逐字节读取、5 个真实 XLSX 模板下载并比较工作簿各部分、退出后 token 失效。先只启动自己的 MySQL/Redis，对恢复后的全部表（数量取该快照清单）逐一核对记录数、MySQL CHECKSUM 和列定义；确认后才启动后端/页面，以区分精确恢复与应用业务初始化。网络与挂载检查确认容器只加入本次私有网络，文件挂载只来自 `standalone/`。

默认结束后清理本次随机容器、网络和数据卷；`verify --keep` 在隔离边界和数据库恢复已确认后保留本次无端口组，供后续更深业务写入验收或诊断；业务验收失败仍返回失败。隔离或恢复检查未通过时清理。保留私有 `runtime/check-*/` 证据。公开状态写入本目录 `verification.json`。不会停用或覆盖目前的 3119/3120 本地服务。

## 正式在另一台本地机器启动

复制整个 `standalone/` 目录（包含选定的私有 bundle 与 `compose.json`、`nginx.conf`、脚本）；目标机器安装 Docker Compose，使用已有或包内离线镜像。启动不需要原项目、原服务器或原对照数据库。

释放目标机器的 3119/3120 后运行：

```sh
python3 bootstrap.py up --bundle runtime/bundle-日期时间-随机标识
```

该命令启用 `delivery` profile，创建独立随机项目及新卷，只发布 `127.0.0.1:3120` 页面和 `127.0.0.1:3119` 接口。该 profile 本轮没有启动，以免占用当前服务。项目私有网络仍为 internal，应用不能直接连接外部集成。

启动输出专用 `deployment_env` 路径，之后通过该文件管理同一个部署（下例替换实际路径）：

新增人员、项目花名册和重置密码依赖 `LJAPS_INITIAL_USER_PASSWORD`。打包时沿用私有配置中的值，未配置时生成随机值，保存于权限为600的私有环境文件；旧包通过当前启动器部署时也会补齐。需要分发新账号时，从对应部署的私有 `deployment.env` 读取初始密码。

```sh
docker compose --env-file runtime/deployment-标识/deployment.env -f compose.json --profile delivery ps
docker compose --env-file runtime/deployment-标识/deployment.env -f compose.json --profile delivery stop
docker compose --env-file runtime/deployment-标识/deployment.env -f compose.json --profile delivery up -d --pull never
```

日常停止保留数据库卷。不要将另一个部署的卷挂到本项目，也不要用 `down --volumes` 清除需要保留的数据。新快照只由 MySQL 首次初始化空卷时导入；后续正常重启不重新导入。

## 验收边界

独立启动证明应用、数据库、配置、资源与附件能够脱离原对照环境运行。代表接口、附件和模板通过，不等于全部业务流程、外部集成、所有报表及跨机器浏览器交互已经逐项验收。Redis 作为新的独立缓存启动，未迁移旧缓存内容；持久化业务数据与会话撤销记录来自新数据库快照。


源码仍在补齐时可用 `prepare --stage` 准备明确的阶段 QA 包：它只接收已激活运行产物与预先保存的构建摘要，不宣称与当前正在修改的源码一致，且 `up` 禁止该包进入交付 profile。最终交付必须不带 `--stage` 重新准备并重新验收。

保留组内已编译 `/evidence/ContainerHttp.class`，可通过该组 backend 容器执行 `java -cp '/evidence:/app/lib/*' ContainerHttp`：stdin 为 JSON `{path,method,data,token}`（或二进制 bodyBase64/contentType），stdout 为 `{status,bodyBase64,headers}`。HTTP 目标固定为同网络的 `http://web`，不接收任意外部地址。账号密码与 token 通过 stdin，不放入命令参数。

本包是运行迁移包，源码维护与重新编译仍在 `20-rebuild/backend` 和 `20-rebuild/frontend-recovered` 工程中进行。跨 CPU 架构的镜像与跨机器浏览器验收仍需另行核对，不能由本机无端口验证推定。


当前 `verification.json` 已是最终非阶段包 `runtime/bundle-20261015-194624-ec597c` 的全新独立恢复与接口验收：源码构建 app `570265f8…`、前端入口哈希 `c82bc31e…`、685张表569000行恢复时行数/CHECKSUM/列定义完全一致，112项查询契约及112项匿名拒绝、完整用户菜单、附件逐字节、5个模板工作簿均通过。全新临时组验收后已清理，未发布端口、未替换主服务；本轮没有启动 delivery profile，也没有跨机器或外部集成验收。准备后的包约1.20GB，包含离线镜像和28份附件，摘要见 `delivery-bundle.json`。

`scm-wms-verification.json` 记录先前保留组中实际供应商→申购→采购→入库→领用出库的读写证据。它验证了自动完成审批的辅材路径、库存1000→997、超库存拒绝、引用删除拒绝、重复提交拒绝，以及入库采购差额开关启用/禁用两分支。原配置字段和值已恢复，专用 QA 行版本与更新时间由正常配置操作更新；报告明确记录。这些专用业务夹具未进入交付快照。

`production-verification.json` 单独记录技术清单→审核→排程→四道人工报工→撤销/补报的阶段验证。真实记录与工序汇总已回读；原阶段包曾发现生产记录列表 SQL 缺列和月度生产汇总缺失；新候选已用全新夹具通过真实HTTP复验、月统计2/2/2和撤销/补报2→1→2。报告保留旧失败证据与新候选摘要，不用于宣称最终部署已冻结或全平台业务等价。

`shipment-verification.json` 记录专用成品的手工打包、装车、录重、发运审核和签收。e33 候选已用全新两件夹具完整复验，成品入库2、出库2、余额0；发运汇总件数增加2、重量增加6.28kg，并通过重复签收拒绝。硬件回执和外部短信未联调；原审核逻辑曾尝试发送短信，但独立内部网络阻止了外部连接，不宣称外发成功。

`other-transfer-verification.json` 记录真实 OTHER128 类别的专用科目、计量、仓位和期初入库，通过原人工审核后库存10→源仓7+项目目标仓3。批次中第二条不存在或错用 AUX8 类别均被拒绝，调拨头、详情、冻结、冻结记录及库存逐行回滚一致。专用配置与库存只保留在 QA 组，交付快照不包含这些夹具。

`settlement-inner-verification.json` 记录独立合营项目的旧结算协议：项目、经理、供应商、订单和编号关联校验，50元隐藏待审草稿，以及原 OA 固定信息预览。原预览可生成多份隐藏草稿，报告按事实记录，正式结算、付款、发票及审批关联均未产生，不等同外部 OA 已提交或财务审批已完成。

`section-length-verification.json` 记录三条按原期初钢材入库和真实审批形成的型材库存。长度汇总39000mm、仓位/材质/规格过滤及分页不截断已核。临时个人审批模板通过 API 删除，原模板读回一致；新增模板历史与撤销测试单仍保留在 QA，未直接 SQL 制造库存。

`permission-http-verification.json` 记录通过原 API 注册的专用无角色用户真实 RSA 登录后，对采购导出、长度统计、工资打印和隐藏结算预览的拒绝结果，最后按 API 退出并删除测试用户。没有修改原人员密码或策略。`wage-print-verification.json` 只验证原页面统计模式2的 PrintVO、缺参和鉴权；实际返回0行，没有把空工资表声明为工资确认/支付验收。

`purchase-export-verification.json` 记录真实合营采购 Excel 的 ZIP/XML 单元格回读：编号、50元、10只和 M56 均匹配专用订单；原 BG 表单合法空的订单付款模式保持为空，不虚填到货模式。匿名和真实无角色账号均被拒绝。

打包前核对完整前端源码清单、依赖锁、请求契约和全部构建文件；复制后再次核对完整构建清单与哈希。`python3 -m unittest discover -s 20-rebuild/standalone -p test_bootstrap.py -v` 包含正常清单、额外源码、同长度构建文件篡改，以及准备后的包不读取原源码/本地配置目录四个检查。
