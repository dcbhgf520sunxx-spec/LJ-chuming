-- New-platform session revocation only; original business tables are unchanged.
CREATE TABLE IF NOT EXISTS rebuild_auth_revoked_token (
    jti VARCHAR(36) CHARACTER SET ascii COLLATE ascii_bin NOT NULL PRIMARY KEY,
    expires_at_epoch_ms BIGINT NOT NULL
) ENGINE=InnoDB;

-- Rebuilt-platform compatibility: sys_user.id and its Java references are Long.
-- Existing databases use the explicit migration documented in migrations/README.md.
ALTER TABLE project_inspection_user MODIFY COLUMN user_id BIGINT NOT NULL COMMENT '巡检人员id';
ALTER TABLE project_inspection_task_record MODIFY COLUMN user_id BIGINT NULL DEFAULT NULL COMMENT '缺卡用户id';

-- Local compatibility: the conversion-rate edit/delete leaves were bound to inventory-error permissions.
-- Preserve menu IDs and role-menu links; only the exact known old values may change.
UPDATE `sys_menu` SET `permission`='conversion_rate_config:edit'
WHERE `id`=6000056 AND `pid`=6000053 AND `permission`='inventory_error_config:edit';
UPDATE `sys_menu` SET `permission`='conversion_rate_config:del'
WHERE `id`=6000057 AND `pid`=6000053 AND `permission`='inventory_error_config:del';

-- Current V2 plan editor nullable delivery dates (20261019)
-- Additive local compatibility for the current V2 plan editor. Historical values stay NULL.
ALTER TABLE plan_area
  ADD COLUMN delivery_start_date date NULL DEFAULT NULL COMMENT 'V2交货开始日期',
  ADD COLUMN delivery_end_date date NULL DEFAULT NULL COMMENT 'V2交货结束日期';

-- Current V2 budget input uses two fractional digits; retain original 19 integer digits.
ALTER TABLE plan_area MODIFY COLUMN mete DECIMAL(21,2) NULL DEFAULT NULL COMMENT '工程量';

-- Local-only compatibility for current MES base cards. No role-menu links are added.
-- The known current parent is ID1176, PC/category0 menu/type1.
UPDATE sys_menu SET bool_delete_enum=0 WHERE id=32514 AND pid=1176 AND category=0 AND type=2 AND permission='coating_create_type_config:get' AND bool_delete_enum=1 AND EXISTS (SELECT 1 FROM (SELECT id FROM sys_menu WHERE id=1176 AND category=0 AND type=1 AND component='/config-manage/mes/base/index' AND bool_delete_enum=0) AS expected_parent);
UPDATE sys_menu SET bool_delete_enum=0 WHERE id=32515 AND pid=1176 AND category=0 AND type=2 AND permission='coating_create_type_config:edit' AND bool_delete_enum=1 AND EXISTS (SELECT 1 FROM (SELECT id FROM sys_menu WHERE id=1176 AND category=0 AND type=1 AND component='/config-manage/mes/base/index' AND bool_delete_enum=0) AS expected_parent);
INSERT INTO sys_menu (id,pid,category,type,name,permission,sort) SELECT 6001001,1176,0,2,'查看APP仓库重量配置','app_show_weight_config:get',1 FROM sys_menu parent WHERE parent.id=1176 AND parent.category=0 AND parent.type=1 AND parent.component='/config-manage/mes/base/index' AND parent.bool_delete_enum=0 AND NOT EXISTS (SELECT 1 FROM (SELECT id FROM sys_menu WHERE permission='app_show_weight_config:get' OR id=6001001) AS existing_leaf);
INSERT INTO sys_menu (id,pid,category,type,name,permission,sort) SELECT 6001002,1176,0,2,'编辑APP仓库重量配置','app_show_weight_config:edit',1 FROM sys_menu parent WHERE parent.id=1176 AND parent.category=0 AND parent.type=1 AND parent.component='/config-manage/mes/base/index' AND parent.bool_delete_enum=0 AND NOT EXISTS (SELECT 1 FROM (SELECT id FROM sys_menu WHERE permission='app_show_weight_config:edit' OR id=6001002) AS existing_leaf);
INSERT INTO sys_menu (id,pid,category,type,name,permission,sort) SELECT 6001003,1176,0,2,'查看零件排产展示层级','machine_part_scheduling:get',1 FROM sys_menu parent WHERE parent.id=1176 AND parent.category=0 AND parent.type=1 AND parent.component='/config-manage/mes/base/index' AND parent.bool_delete_enum=0 AND NOT EXISTS (SELECT 1 FROM (SELECT id FROM sys_menu WHERE permission='machine_part_scheduling:get' OR id=6001003) AS existing_leaf);
INSERT INTO sys_menu (id,pid,category,type,name,permission,sort) SELECT 6001004,1176,0,2,'编辑零件排产展示层级','machine_part_scheduling:edit',1 FROM sys_menu parent WHERE parent.id=1176 AND parent.category=0 AND parent.type=1 AND parent.component='/config-manage/mes/base/index' AND parent.bool_delete_enum=0 AND NOT EXISTS (SELECT 1 FROM (SELECT id FROM sys_menu WHERE permission='machine_part_scheduling:edit' OR id=6001004) AS existing_leaf);
INSERT INTO sys_menu (id,pid,category,type,name,permission,sort) SELECT 6001005,1176,0,2,'查看原料损耗计算公式','raw_material_loss_formula:get',1 FROM sys_menu parent WHERE parent.id=1176 AND parent.category=0 AND parent.type=1 AND parent.component='/config-manage/mes/base/index' AND parent.bool_delete_enum=0 AND NOT EXISTS (SELECT 1 FROM (SELECT id FROM sys_menu WHERE permission='raw_material_loss_formula:get' OR id=6001005) AS existing_leaf);
INSERT INTO sys_menu (id,pid,category,type,name,permission,sort) SELECT 6001006,1176,0,2,'编辑原料损耗计算公式','raw_material_loss_formula:edit',1 FROM sys_menu parent WHERE parent.id=1176 AND parent.category=0 AND parent.type=1 AND parent.component='/config-manage/mes/base/index' AND parent.bool_delete_enum=0 AND NOT EXISTS (SELECT 1 FROM (SELECT id FROM sys_menu WHERE permission='raw_material_loss_formula:edit' OR id=6001006) AS existing_leaf);

-- Native inspection-absence scheduler uses the same Long user IDs (20261020).
-- Local/owned QA only. Preserve nullability, default, comment and every business row.
ALTER TABLE project_inspection_task_absences_record MODIFY COLUMN user_id BIGINT NULL DEFAULT NULL COMMENT '缺卡用户id';

-- Complete legal department/job change audit strings: 255 + '->' + 255 characters.
ALTER TABLE shr_user_change_record
  MODIFY COLUMN dept_name VARCHAR(512) NULL DEFAULT NULL COMMENT '部门名称',
  MODIFY COLUMN job_name VARCHAR(512) NULL DEFAULT NULL COMMENT '岗位名称';
