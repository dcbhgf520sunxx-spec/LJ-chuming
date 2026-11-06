# 独立数据库恢复验收

`database_snapshot.py` 导出当前本地 `plm7_rebuild`，在一次性 MySQL 8.2 中恢复并核对每张业务表的记录数、MySQL CHECKSUM TABLE 结果和完整列定义。目标容器没有网络、没有发布端口，不导入任何现有数据库。

```bash
python3 -m unittest discover -s 20-rebuild/portability -p 'test_*.py' -v
python3 20-rebuild/portability/database_snapshot.py
```

脚本仅允许新重建库，不导出或覆盖 `plm7`。SQL 快照及完整表清单保存在本目录的私有 `runtime/`，目录权限 700、快照与清单 600，已加入忽略。临时容器和数据卷使用本次随机名称，结束后清理；失败也保留私有快照与失败记录便于排查。

若导出前后源库有变化，则本次不报告通过，等当前业务写入结束后重新执行。运行凭据只写入临时私有文件，随后删除，不输出到报告。公开验证记录为 `../docs/database-portability-verification.json`。

这证明保存的数据库快照可独立恢复；完整应用跨机器部署、应用配置、附件、Redis 和业务验证另行验收。MySQL 表校验值是恢复一致性检查，并非每一行内容的密码学摘要。
