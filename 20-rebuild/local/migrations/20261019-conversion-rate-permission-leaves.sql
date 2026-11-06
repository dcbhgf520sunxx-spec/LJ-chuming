
-- Local compatibility: the conversion-rate edit/delete leaves were bound to inventory-error permissions.
-- Preserve menu IDs and role-menu links; only the exact known old values may change.
UPDATE `sys_menu` SET `permission`='conversion_rate_config:edit'
WHERE `id`=6000056 AND `pid`=6000053 AND `permission`='inventory_error_config:edit';
UPDATE `sys_menu` SET `permission`='conversion_rate_config:del'
WHERE `id`=6000057 AND `pid`=6000053 AND `permission`='inventory_error_config:del';
