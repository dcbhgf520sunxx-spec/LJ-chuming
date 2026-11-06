-- Local compatibility only. Each legal source name is VARCHAR(255).
-- Preserve the complete old-name + '->' + new-name audit value (255+2+255).
ALTER TABLE shr_user_change_record
  MODIFY COLUMN dept_name VARCHAR(512) NULL DEFAULT NULL COMMENT '部门名称',
  MODIFY COLUMN job_name VARCHAR(512) NULL DEFAULT NULL COMMENT '岗位名称';
