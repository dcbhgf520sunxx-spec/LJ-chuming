# 源码基线说明

日期：2026-11-06。仓库：`dcbhgf520sunxx-spec/LJ-chuming`，分支`main`。

## 2026-11-11 更新

本轮增加独立 IFC 模型展示、区域与业务进度关联、构件详情和浮动工作区，完善 BIMFACE 转换回调、模型状态查询、复刻版标识与退出登录。测试发布目标为现有 `172.16.0.176:3120` 环境；发布沿用该环境的数据库、附件和私有配置，通过新版本目录与部署清单保留回退入口。下面的 app90/web93 和第三方准备描述为 2026-11-06 初始基线记录。

设计效果图、包含真实项目数据的界面验收截图仍留在本地，不随源码提交。IFC 转换工具纳入源码，模型几何、索引和区域版本指针作为私有测试发布数据单独同步。

## 提交内容

本基线收录重建后的37个Java业务模块、运行适配层、完整恢复前端、依赖锁与来源清单、本地维护/迁移工具，以及17项第三方准备包。源码中的原作者注释、原Vue模板和原类型信息未凭空恢复；恢复方式和维护约定见现有说明。

当前本地运行版本为app90/web93。第三方准备源码及本轮公开前脱敏尚未替换当前运行制品。第三方17项均已盘点，仍缺已审核真实测试资料，其中10项有待按对端协议解决的适配边界，尚未执行真实联调。后续状态以`integrations/catalog.json`和实际验收记录为准。

## 保留在本地的材料

数据库快照、真实附件、密钥、业务配置、原发布程序、历史修复/验收实验、真实请求响应和设备身份不纳入公开仓库。它们保留在原本地目录，没有因为提交Git而删除。历史原始证据链接在公开checkout中可能不可用。

完整源码与可直接运行的含数据迁移包是两份交付物。Git不包含`backend/.deps`、`target`、前端`node_modules/dist`和私有独立运行包。

## 构建与检查条件

- 后端：Java 8、Docker，以及`backend/thirdparty-lock.json`锁定的306个第三方JAR。将授权依赖缓存放回`backend/.deps`后，构建工具校验文件集合与每个摘要。原业务JAR不允许作为依赖。`rebuild-app.py`还需要已有模块构建结果；全量构建入口是`tools/build.py`。
- 前端：使用锁定的npm依赖。普通构建读取可编辑源码、`source-map.json`和`src/shared/assembly.json`。静态恢复对照还使用已纳入的`recovery-tools/generated/module-graph.json`和`docs/frontend-component-source-map.json`。
- `npm test`保留历史恢复对照检查，其中`verify-recovery.mjs`需要本地私有原版对照。公开checkout不具备这些材料时，不能把该项宣称为已通过，也不应上传私有原程序来满足它。
- `standalone/bootstrap.py prepare`需要本地数据库/附件/配置/密钥，以及私有验收响应和模板基线。已准备的私有bundle可按原工具验证、启动；仅clone源码不能凭空生成这些数据。
- 历史一次性`local/migrate-*.py`和整套`acceptance/`实验保留在本地。7个已存在的迁移SQL和本地表结构SQL作为维护资料保留；提交SQL本身不执行迁移。

## 公开前脱敏

历史固定应用密钥、OA演示令牌和登录账号改为显式私有环境配置，旧人员初始化中的档案和排除名单不再写死在源码。招采模板的银行/联系人/举报联系方式改为私有配置，缺省为空。旧OSS导入辅助方法改读已有的`LJAPS_OSS_ACCESS_KEY_ID`和`LJAPS_OSS_ACCESS_KEY_SECRET`。原始文件均保留在本地私有备份，不上传。

相关变量仅在明确使用相应历史工具或配置时读取，不自动启用旧初始化：

- `LJAPS_COMMON_IOT_APP_KEY` / `LJAPS_COMMON_IOT_APP_SECRET`
- `LJAPS_COMMON_OA_APP_KEY` / `LJAPS_COMMON_OA_APP_SECRET`
- `LJAPS_LEGACY_USER_IMPORT_BATCH_A` / `LJAPS_LEGACY_USER_IMPORT_BATCH_B` / `LJAPS_LEGACY_USER_IMPORT_EXCLUDED_NAMES`
- `LJAPS_OA_DEMO_AUTHORIZATION` / `LJAPS_SHR_TOKEN_USERNAME`
- `LJAPS_BIDDING_DEPOSIT_TEXT` / `LJAPS_BIDDING_CONTACT_TEXT` / `LJAPS_BIDDING_REPORT_CONTACT_TEXT`

导入模板保留原表头、格式和填写说明，清除嵌入的人员/工程样本；Office临时锁文件不作为程序资源。当前服务仍使用原已验收运行制品，本轮没有运行人员导入、组织同步、对端回调注册或消息发送。

源代码提交、离线检查、真实业务验收、Git远端一致和生产发布分别记录。第三方资料及适配全部准备完备后，再执行统一测试清单。
