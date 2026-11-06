-- Local/owned QA only. Preserve the two original nullability and comment contracts.
-- Widening is idempotent; do not narrow these columns when large user IDs exist.
ALTER TABLE project_inspection_user MODIFY COLUMN user_id BIGINT NOT NULL COMMENT '巡检人员id';
ALTER TABLE project_inspection_task_record MODIFY COLUMN user_id BIGINT NULL DEFAULT NULL COMMENT '缺卡用户id';
