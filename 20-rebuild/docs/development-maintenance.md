# 后续源码开发与构建

`backend/modules/<模块>/src/main/java` 是可以继续修改的源码，不要求永远保持与原发布包相同。Mapper XML、模板和图片位于同模块 `src/main/resources`。

修改、增加或删除已有模块中的 Java/资源后，用显式登记工具更新“当前实现”清单，同时保留原始证据摘要和修改原因：

```bash
python3 20-rebuild/backend/tools/record-source-change.py --module scim-system-core --note '补充本次业务规则及修改原因' --dry-run
python3 20-rebuild/backend/tools/record-source-change.py --module scim-system-core --note '补充本次业务规则及修改原因'
python3 20-rebuild/backend/tools/build.py
python3 20-rebuild/local/activate.py
```

先查看 dry-run，再执行登记。工具只扫描指定模块的源码/资源目录，不改业务文件。原 Java 的 `original_source_sha256` 不变；原资源第一次修改时将旧摘要保存在 `original_sha256`，当前摘要继续用于构建校验。新文件标明 `origin=new-development`，原始摘要为空；删除记录保留为 `deleted=true`，不会丢掉历史来源。恢复同路径文件后可再次登记。每次登记附加明确说明。

构建会编译当前有效清单，因此增加类、修改 Mapper SQL、替换导出模板和删除旧文件均有正常路径。编译仍检查缺失类型、接口依赖及产物。若新增一个模块而非已有模块中的类，还需在 `source-modules.json` 按依赖顺序加入该模块，并登记它的文件。新应用接入层 `app/src/main/java` 自动参与编译，无需伪造原始来源。

只修改接入层或少数模块时，也可使用增量编译：

```bash
python3 20-rebuild/backend/tools/rebuild-app.py scim-system-core
```

该命令只允许未重编模块的源文件指纹保持原样，并检查原验证模块 JAR 摘要。失败会使成功报告无效；下一次重试可以读取仅供重试的 `last-verified-build-report.json`，`activate.py` 不接受该重试记录。最终集成交付优先运行全量构建。

修改或删除 Mapper XML、模板等资源时，必须在增量命令中列出所属模块。全量构建、增量构建和激活都会核对包内资源文件清单及逐文件字节摘要；只登记新 XML 却未重新编译该模块，或删除资源后仍使用旧 JAR，均明确拒绝。当前工具测试覆盖这两种旧产物误用。

禁止把原业务 `.class`/`.jar` 放进资源目录或依赖来绕过源码编译。依赖仍须由锁定清单批准，构建不自动联网拉取库。启动前核对完整源码/资源覆盖、9 项基础对照、18 项鉴权和7项权限检查，再核对当前源码指纹与构建报告，防止“源码改了却激活旧包”。运行副本与临时编译目录分开，重新构建不会停止当前服务。

鉴权、密码修改和策略编辑有真实本地回归脚本：`local/check-runtime.py`、`local/check-password.py`、`local/check-policy.py`。后两者只使用专用临时用户/角色，并清理夹具；密码策略测试结束后精确恢复已迁移行。它们不改源账号或真实本地账号密码。

默认密码不会回显给浏览器，编辑页面留空表示保留现有默认密码；输入新密码后用新公钥提交。服务器保留私钥并校验密码规则。该行为与原页面内置私钥的做法有意不同。

## 完整前端的正常开发

当前 3120 使用 `frontend-recovered`。页面、弹窗及页面组件主要在其 `src/views`，原公共模块在 `src/modules`，内联组件及其导入关系在 `src/shared`，运行适配在 `src/runtime`。先从 `docs/frontend-component-source-map.json` 或 `docs/menu-page-smoke-cases.json` 查实际组件路径，不要在早期参考工程 `frontend` 中修改后误以为已影响完整平台。

直接编辑已恢复的 JS setup/render/Options API 源码。正常构建不会从原发布 JS 再次生成并覆盖它们；原始 Vue 单文件模板、TypeScript 类型和注释没有恢复。依赖使用锁定的真实 npm 包，不能重新放入原 vendor。

在 `20-rebuild/frontend-recovered` 中依次运行：

```sh
npm test
npm run verify:static
npm run build
node tools/record-build.mjs
```

当前依赖安装为 Apple Silicon arm64，须使用同架构 Node；使用另一架构机器时在该架构下按 `package-lock.json` 重新安装依赖。完整构建最大堆为 8 GB。构建成功后，`record-build.mjs` 记录全部源文件、构建文件及依赖锁摘要；如果源码在记录后变化，激活会拒绝。不要省略前三步，也不要把旧产物配上新摘要当作已重新构建。

回到项目根目录运行 `python3 20-rebuild/local/activate-frontend.py`，再打开真实页面验证。本地 Nginx 挂载稳定的 `local/runtime/web`，不是会被 Vite 清理的 `dist`。激活最后才切换 `index.html`，并保留旧哈希文件供已打开的页面加载。不要手工覆盖构建报告来绕过源码校验。

## 原版对照与最终迁移

原版 3117 后端因内存不足退出，未重新启动其历史初始化和定时任务。当前读取和模板复验使用已保存的本地基线，并在报告中写明基线来源、保存时间及摘要，不冒充原版实时响应。用法和边界见 `acceptance/README.md`。

初始化和定时任务有独立台账；需要本地业务的任务按原周期、时区和公式接入，每个任务/周期记录成功、失败与重试，防止重启重复结转。不要通过重新启用全部原始 Runner 重放历史清表、改密码、删除备份或外部同步。

最终部署包必须在源码、构建、运行版本一致后，以当前新库快照重新执行 `standalone/bootstrap.py prepare`（不带 `--stage`），并通过全新独立组验证。详细命令见 `standalone/README.md`。修改源码后旧部署包仍是旧版本，必须重新构建、准备和验收；源码工程与私有运行迁移包都要保留。
