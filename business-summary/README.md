# 业务梳理页面

访问 http://127.0.0.1:3121/。节点业务结果和页面末尾的部门主要职责均可编辑，点“保存”直接写入 SQLite，打开页面自动回读；原 HTML 仍是唯一页面模板。每次编辑一个板块，保存或取消后可编辑另一板块。

启动：双击 `start.command`，或在项目根目录运行 `python3 business-summary/server.py`。仅监听本机，不接入重建平台。

数据库为 `business-summary/data/summary.sqlite3`，表为 `pms_business_summary`，保存 156 个节点字段及 52 个部门职责字段。数据目录不纳入 Git；备份时应停止服务后复制整个 `data` 目录。

后续修改 HTML 样式不影响已保存内容。补充业务资料时，保持 `data-field` 标识不变：未手工编辑的字段会跟随源文档更新，手工改过的结果保留。编辑期间遇到其他页面保存或业务资料更新，旧页面会拒绝覆盖并保留当前修改。

检查：`python3 -m unittest discover -s business-summary -p 'test_*.py' -v`。测试使用临时数据库，不改正式梳理结果。

## 外网浏览版

https://aps.iamvertex.com 由阿里云服务器 Nginx 独立托管，本机关闭后仍可访问。外网是完整内容的只读快照，编辑仍在本机页面保存，后续更新需重新发布。部署文件和更新说明见 `deploy/README.md`。
