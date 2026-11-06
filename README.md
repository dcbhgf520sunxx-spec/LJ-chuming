# LJ-chuming

初鸣平台的可维护源码工程及第三方对接准备材料。

- 完整后端：`20-rebuild/backend/`，37个Java业务模块及新的运行适配层。
- 当前完整前端：`20-rebuild/frontend-recovered/`。`20-rebuild/frontend/`是保留参考的早期工程。
- 本地运行与独立迁移工具：`20-rebuild/local/`、`20-rebuild/standalone/`。
- 第三方对接：`20-rebuild/integrations/`，含17项配置/资料清单和待执行测试场景。
- 业务梳理页面：根目录HTML及`business-summary/`服务。已保存的SQLite数据保留在本地。

构建、私有依赖和验收边界见[源码基线说明](20-rebuild/docs/source-baseline.md)，维护方式见[开发维护说明](20-rebuild/docs/development-maintenance.md)。

数据库、附件备份、密钥、真实配置、原发布程序、历史验收响应和本机运行制品不随Git提交。第三方对接仍需测试身份、协议、映射和设备资料，当前源码准备不代表真实联调通过。Git提交不更新正在运行的本地服务，也不执行生产发布。
