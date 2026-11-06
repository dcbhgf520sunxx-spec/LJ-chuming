-- Local/owned QA only. Preserve nullability, default, comment and every business row.
ALTER TABLE project_inspection_task_absences_record MODIFY COLUMN user_id BIGINT NULL DEFAULT NULL COMMENT '缺卡用户id';
