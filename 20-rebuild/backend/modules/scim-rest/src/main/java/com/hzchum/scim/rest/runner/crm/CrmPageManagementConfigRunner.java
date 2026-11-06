package com.hzchum.scim.rest.runner.crm;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPageManagementConfig;
import com.hzchum.scim.crm.core.api.service.CrmPageManagementConfigService;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(99)
@Component
public class CrmPageManagementConfigRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(CrmPageManagementConfigRunner.class);
   @Resource
   private CrmPageManagementConfigService crmPageManagementConfigService;
   @Resource
   private InitializationService service;

   @Override
   public void run(String... args) throws Exception {
      List<CrmPageManagementConfig> crmPageManagementConfigs = this.crmPageManagementConfigService.list();
      if (CollectionUtils.isEmpty(crmPageManagementConfigs)) {
         List<String> saveSqlList = new ArrayList<>();
         String datasource = this.service.selectSql("SELECT DATABASE()").get(0);
         if (Objects.nonNull(datasource)) {
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1, '2024-09-10 17:05:00.905656', '2024-12-18 09:18:04.061000', 0, 1, '填报人', 'informantUserId', 'informantUserName', 1, 1, 1, 1, 1, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (2, '2024-09-11 11:43:30.490496', '2024-12-18 09:18:04.061000', 0, 1, '所属部门', 'departmentId', 'departmentName', 1, 1, 1, 1, 2, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (3, '2024-09-11 11:43:42.097679', '2024-12-18 09:18:04.061000', 0, 1, '填报日期', 'informantDateTime', 'informantDateTime', 1, 1, 1, 1, 3, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (4, '2024-09-11 11:43:51.729700', '2024-12-18 09:18:04.061000', 0, 1, '企业名称', 'businessName', 'businessName', 1, 1, 1, 1, 4, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (5, '2024-09-11 11:44:08.203711', '2024-12-18 09:18:04.061000', 0, 1, '企业类别', 'unitPropertyAllocationConfigId', 'unitPropertyAllocationConfigName', 1, 1, 1, 1, 5, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (6, '2024-09-11 11:44:13.131562', '2024-12-18 09:18:04.061000', 0, 1, '企业性质', 'unitClassConfigurationId', 'unitClassConfigurationName', 1, 1, 1, 1, 6, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (7, '2024-09-11 11:44:47.793794', '2024-12-18 09:18:04.061000', 0, 1, '国省市区', 'regionList', 'regionNameList', 1, 1, 1, 1, 7, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (8, '2024-09-11 11:44:59.946320', '2024-12-18 09:18:04.062000', 0, 1, '详细地址', 'address', 'address', 1, 1, 1, 1, 8, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (9, '2024-09-11 11:45:17.124948', '2024-12-18 09:18:04.062000', 0, 1, '社会统一信用代码', 'creditCode', 'creditCode', 1, 1, 1, 1, 9, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (10, '2024-09-11 11:45:25.749069', '2024-12-18 09:18:04.062000', 0, 1, '所属行业', 'industryConfigurationId', 'industryConfigurationName', 1, 1, 1, 1, 10, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (11, '2024-09-11 11:45:35.548136', '2024-12-18 09:18:04.062000', 0, 1, '资质能力', 'qualificationAndAbility', 'qualificationAndAbility', 1, 0, 1, 1, 11, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (12, '2024-09-11 11:45:43.959239', '2024-12-18 09:18:04.062000', 0, 1, '单位电话', 'businessPhone', 'businessPhone', 1, 1, 1, 1, 12, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (13, '2024-09-11 11:46:14.606285', '2024-12-18 09:18:04.062000', 0, 1, '单位邮箱', 'businessEmail', 'businessEmail', 1, 0, 1, 1, 13, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (14, '2024-09-11 11:46:23.118547', '2024-12-18 09:18:04.062000', 0, 1, '联系人', 'liaisons', 'liaisons', 1, 0, 1, 1, 14, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (15, '2024-09-11 11:46:33.374164', '2024-12-18 09:18:04.062000', 0, 1, '企业信誉', 'unitReputationAllocationConfigId', 'unitReputationAllocationConfigName', 1, 1, 1, 1, 15, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (16, '2024-09-11 11:46:39.646537', '2024-12-18 09:18:04.062000', 0, 1, '附件', 'attachmentIds', 'attachmentDTOList', 1, 0, 1, 1, 16, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (17, '2024-09-11 11:46:47.853942', '2024-12-18 09:18:04.062000', 0, 1, '备注', 'remark', 'remark', 1, 0, 1, 1, 17, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (18, '2024-09-11 11:47:57.049690', '2024-12-18 09:18:49.452000', 0, 1, '填报人', 'informantUserId', 'informantUserName', 1, 1, 1, 2, 2, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (19, '2024-09-11 11:48:08.219449', '2024-12-18 09:18:49.452000', 0, 1, '所属部门', 'departmentId', 'departmentName', 1, 1, 1, 2, 3, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (20, '2024-09-11 11:48:19.063618', '2024-12-18 09:18:49.452000', 0, 1, '填报日期', 'informantDateTime', 'informantDateTime', 1, 1, 1, 2, 4, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (21, '2024-09-11 11:48:29.283865', '2024-12-18 09:18:49.452000', 0, 1, '政府名称', 'crmEnterpriseWarehousingId', 'crmEnterpriseWarehousingName', 1, 1, 1, 2, 5, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (22, '2024-09-11 11:48:36.871407', '2024-12-18 09:18:49.452000', 0, 1, '企业类别', 'unitPropertyAllocationConfigId', 'unitPropertyAllocationConfigName', 1, 0, 1, 2, 6, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (23, '2024-09-11 11:48:44.661257', '2024-12-18 09:18:49.452000', 0, 1, '企业性质', 'unitClassConfigurationId', 'unitClassConfigurationName', 1, 0, 1, 2, 7, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (24, '2024-09-11 11:49:10.999214', '2024-12-18 09:18:49.452000', 0, 1, '国省市区', 'regionList', 'regionNameList', 1, 1, 1, 2, 8, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (25, '2024-09-11 11:49:18.950056', '2024-12-18 09:18:49.452000', 0, 1, '详细地址', 'address', 'address', 1, 0, 1, 2, 9, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (32, '2024-09-11 11:50:26.281965', '2024-12-18 09:18:49.452000', 0, 1, '附件', 'attachmentIds', 'attachmentDTOList', 1, 0, 1, 2, 10, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (34, '2024-09-11 11:50:40.463191', '2024-12-18 09:18:49.452000', 0, 1, '受理截止日', 'deadlineForAcceptanceTime', 'deadlineForAcceptanceTime', 1, 1, 1, 2, 11, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (35, '2024-09-11 11:50:47.553172', '2024-12-18 09:18:49.453000', 0, 1, '受理地址', 'acceptanceAddress', 'acceptanceAddress', 1, 0, 1, 2, 12, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (36, '2024-09-11 11:50:52.815279', '2024-12-18 09:18:49.453000', 0, 1, '费用(万元)', 'cost', 'cost', 1, 0, 1, 2, 13, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (37, '2024-09-11 11:50:57.540793', '2024-12-18 09:18:49.453000', 0, 1, '其他说明', 'remark', 'remark', 1, 0, 1, 2, 14, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (38, '2024-09-23 10:06:39.382829', '2024-11-18 17:57:11.812000', 0, 1, '填报人', 'informantUserId', 'informantUserName', 1, 0, 1, 3, 1, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (39, '2024-09-23 10:07:14.088719', '2024-11-18 17:57:11.860000', 0, 1, '所属部门', 'departmentId', 'departmentName', 1, 0, 1, 3, 2, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (40, '2024-09-23 10:07:42.074482', '2024-11-18 17:57:11.891000', 0, 1, '填报日期', 'informantDateTime', 'informantDateTime', 1, 0, 1, 3, 3, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (41, '2024-09-23 10:08:03.354652', '2024-11-18 17:57:11.924000', 0, 1, '企业名称', 'crmEnterpriseWarehousingId', 'crmEnterpriseWarehousingName', 1, 0, 1, 3, 4, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (42, '2024-10-09 18:14:16.553735', '2024-11-18 17:57:11.944000', 0, 1, '企业类别', 'unitPropertyAllocationConfigId', 'unitPropertyAllocationConfigName', 1, 0, 1, 3, 5, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (43, '2024-10-09 18:14:19.076197', '2024-11-18 17:57:11.975000', 0, 1, '企业性质', 'unitClassConfigurationId', 'unitClassConfigurationName', 1, 0, 1, 3, 6, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (44, '2024-10-09 18:14:43.481299', '2024-11-18 17:57:12.007000', 0, 1, '国省市区', 'regionList', 'regionNameList', 1, 0, 1, 3, 7, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (45, '2024-10-09 18:15:02.906641', '2024-11-18 17:57:12.038000', 0, 1, '详细地址', 'address', 'address', 1, 0, 1, 3, 8, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (46, '2024-10-09 18:15:10.691643', '2024-11-18 17:57:12.069000', 0, 1, '社会统一信用代码', 'creditCode', 'creditCode', 1, 0, 1, 3, 9, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (47, '2024-10-09 18:15:12.568805', '2024-11-18 17:57:12.116000', 0, 1, '所属行业', 'industryConfigurationId', 'industryConfigurationName', 1, 0, 1, 3, 10, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (48, '2024-10-09 18:15:15.402222', '2024-11-18 17:57:12.153000', 0, 1, '资质能力', 'qualificationAndAbility', 'qualificationAndAbility', 1, 0, 1, 3, 11, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (49, '2024-10-09 18:15:16.835390', '2024-11-18 17:57:12.181000', 0, 1, '单位电话', 'businessPhone', 'businessPhone', 1, 0, 1, 3, 12, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (50, '2024-10-09 18:15:24.481256', '2024-11-18 17:57:12.234000', 0, 1, '单位邮箱', 'businessEmail', 'businessEmail', 1, 0, 1, 3, 13, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (51, '2024-10-09 18:15:27.554068', '2024-11-18 17:57:12.281000', 0, 1, '联系人', 'liaisons', 'liaisons', 1, 0, 1, 3, 14, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (52, '2024-09-23 10:09:01.779496', '2024-11-18 17:57:12.330000', 0, 1, '附件', 'attachmentIds', 'attachmentDTOList', 1, 0, 1, 3, 15, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (54, '2024-09-23 10:09:27.642147', '2024-11-18 17:57:12.349000', 0, 1, '受理截止日', 'deadlineForAcceptanceTime', 'deadlineForAcceptanceTime', 1, 0, 1, 3, 16, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (55, '2024-09-23 10:09:41.086184', '2024-11-18 17:57:12.381000', 0, 1, '受理地址', 'acceptanceAddress', 'acceptanceAddress', 1, 0, 1, 3, 17, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (56, '2024-09-23 10:09:53.144040', '2024-11-18 17:57:12.396000', 0, 1, '费用(万元)', 'cost', 'cost', 1, 0, 1, 3, 18, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (57, '2024-09-23 10:10:36.249229', '2024-11-18 17:57:12.434000', 0, 1, '备注', 'remark', 'remark', 1, 0, 1, 3, 19, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (58, '2024-09-11 11:51:12.610550', '2024-12-18 09:19:18.686000', 0, 1, '填报人', 'informantUserId', 'informantUserName', 1, 1, 1, 4, 1, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (59, '2024-09-11 11:51:22.374008', '2024-12-18 09:19:18.686000', 0, 1, '所属部门', 'departmentId', 'departmentName', 1, 1, 1, 4, 2, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (60, '2024-09-11 11:51:31.043422', '2024-12-18 09:19:18.686000', 0, 1, '填报日期', 'informantDateTime', 'informantDateTime', 1, 1, 1, 4, 3, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (61, '2024-10-09 18:26:26.350955', '2024-12-18 09:19:18.687000', 0, 1, '招标平台名称', 'biddingPlatformName', 'biddingPlatformName', 1, 1, 1, 4, 4, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (62, '2024-10-09 18:26:31.647892', '2024-12-18 09:19:18.687000', 0, 1, '报名事由', 'reasonForRegistration', 'reasonForRegistration', 1, 1, 1, 4, 5, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (63, '2024-10-09 18:26:38.165794', '2024-12-18 09:19:18.687000', 0, 1, '国省市区', 'regionList', 'regionNameList', 1, 0, 1, 4, 6, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (64, '2024-10-09 18:26:41.877978', '2024-12-18 09:19:18.687000', 0, 1, '详细地址', 'address', 'address', 1, 0, 1, 4, 7, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (65, '2024-10-09 18:26:47.270363', '2024-12-18 09:19:18.687000', 0, 1, '附件', 'attachmentIds', 'attachmentDTOList', 1, 1, 1, 4, 8, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (67, '2024-10-09 18:26:53.875925', '2024-12-18 09:19:18.687000', 0, 1, '受理地址', 'acceptanceAddress', 'acceptanceAddress', 1, 0, 1, 4, 9, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (68, '2024-10-09 18:27:00.343681', '2024-12-18 09:19:18.687000', 0, 1, '受理截止日', 'deadlineForAcceptanceTime', 'deadlineForAcceptanceTime', 1, 1, 1, 4, 10, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (69, '2024-10-09 18:27:02.182892', '2024-12-18 09:19:18.687000', 0, 1, '费用(万元)', 'cost', 'cost', 1, 0, 1, 4, 11, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (70, '2024-10-09 18:27:05.979608', '2024-12-18 09:19:18.687000', 0, 1, '备注', 'remark', 'remark', 1, 0, 1, 4, 12, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (71, '2024-10-09 18:32:01.455720', '2024-12-18 09:21:31.763000', 0, 1, '填报人', 'informantUserId', 'informantUserName', 1, 1, 1, 5, 2, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (72, '2024-10-09 18:32:04.136807', '2024-12-18 09:21:31.763000', 0, 1, '所属部门', 'departmentId', 'departmentName', 1, 1, 1, 5, 1, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (73, '2024-10-09 18:32:06.349497', '2024-12-18 09:21:31.763000', 0, 1, '填报日期', 'informantDateTime', 'informantDateTime', 1, 1, 1, 5, 3, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (74, '2024-09-12 09:25:17.000000', '2024-12-18 09:21:31.763000', 0, 1, '项目名称', 'projectName', 'projectName', 1, 1, 1, 5, 4, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (75, '2024-09-12 09:26:00.646472', '2024-12-18 09:21:31.763000', 0, 1, '项目类别', 'itemCategoryId', 'itemCategoryName', 1, 1, 1, 5, 5, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (76, '2024-10-09 18:33:56.325473', '2024-12-18 09:21:31.763000', 0, 1, '重点项目', 'keyProjectId', 'keyProjectName', 1, 1, 1, 5, 6, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (77, '2024-10-09 18:35:22.923297', '2024-12-18 09:21:31.765000', 0, 1, '招标方式', 'biddingMethodId', 'biddingMethodName', 1, 1, 4, 5, 18, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (80, '2024-10-09 18:35:33.165777', '2024-12-18 09:21:31.765000', 0, 1, '项目级别', 'projectLevelConfigId', 'projectLevelConfigName', 1, 0, 4, 5, 19, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (83, '2024-10-09 18:36:07.176808', '2024-12-18 09:21:31.767000', 0, 1, '附件', 'projectAttachments', 'projectAttachments', 1, 0, 7, 5, 40, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (84, '2024-10-09 18:36:11.387868', '2024-12-18 09:21:31.767000', 0, 1, '备注', 'remark', 'remark', 1, 0, 7, 5, 41, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (85, '2024-10-09 18:40:24.570578', '2024-12-18 09:22:00.834000', 0, 1, '项目名称', 'projectName', 'projectName', 1, 0, 1, 6, 2, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (86, '2024-10-09 18:40:35.099747', '2024-12-18 09:22:00.833000', 0, 1, '项目备案号', 'projectSerialNumber', 'projectSerialNumber', 1, 0, 1, 6, 1, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (87, '2024-10-09 18:40:44.817280', '2024-12-18 09:22:00.834000', 0, 1, '有效期剩余（天）', 'effectiveRemainingTime', 'effectiveRemainingTime', 1, 0, 1, 6, 3, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (88, '2024-10-09 18:40:48.946939', '2024-12-18 09:22:00.834000', 0, 1, '上次跟进日期', 'lastFollowUpDate', 'lastFollowUpDate', 1, 0, 1, 6, 4, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (89, '2024-10-09 18:40:52.414618', '2024-12-18 09:22:00.834000', 0, 1, '已跟进次数', 'followUpTimes', 'followUpTimes', 1, 0, 1, 6, 5, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (90, '2024-10-09 18:40:55.008621', '2024-12-18 09:22:00.834000', 0, 1, '本次跟进日期', 'followUpDate', 'followUpDate', 1, 1, 1, 6, 6, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (91, '2024-10-09 18:41:08.513446', '2024-12-18 09:22:00.834000', 0, 1, '跟进方式', 'followUpMethods', 'followUpMethods', 1, 1, 1, 6, 7, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (92, '2024-10-09 18:41:12.006798', '2024-12-18 09:22:00.834000', 0, 1, '跟进证明', 'followUpAttachment', 'followUpAttachment', 1, 1, 1, 6, 8, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (93, '2024-10-09 18:41:14.918638', '2024-12-18 09:22:00.834000', 0, 1, '备注', 'remark', 'remark', 1, 1, 1, 6, 9, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (94, '2024-10-09 18:45:01.702472', '2024-12-18 09:22:19.361000', 0, 1, '项目名称', 'projectName', 'projectName', 1, 0, 1, 7, 2, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (96, '2024-10-09 18:45:04.782789', '2024-12-18 09:22:19.361000', 0, 1, '项目备案号', 'projectSerialNumber', 'projectSerialNumber', 1, 0, 1, 7, 1, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (97, '2024-10-09 18:45:14.485247', '2024-12-18 09:22:19.361000', 0, 1, '有效期剩余（天）', 'effectiveRemainingTime', 'effectiveRemainingTime', 1, 0, 1, 7, 3, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (98, '2024-10-09 18:45:20.037511', '2024-12-18 09:22:19.361000', 0, 1, '上次跟进日期', 'lastFollowUpDate', 'lastFollowUpDate', 1, 0, 1, 7, 4, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (99, '2024-10-09 18:45:24.441050', '2024-12-18 09:22:19.361000', 0, 1, '已跟进次数', 'followUpTimes', 'followUpTimes', 1, 0, 1, 7, 5, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (101, '2024-10-09 18:45:30.333401', '2024-12-18 09:22:19.361000', 0, 1, '受理截止日', 'deadlineForAcceptanceTime', 'deadlineForAcceptanceTime', 1, 1, 1, 7, 6, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (102, '2024-10-09 18:45:33.469322', '2024-12-18 09:22:19.362000', 0, 1, '受理地点', 'address', 'address', 1, 1, 1, 7, 7, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (103, '2024-10-09 18:45:36.391552', '2024-12-18 09:22:19.362000', 0, 1, '受理邮箱', 'email', 'email', 1, 0, 1, 7, 8, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (104, '2024-10-09 18:45:50.762406', '2024-12-18 09:22:19.362000', 0, 1, '资格预审费（元）', 'cost', 'cost', 1, 1, 1, 7, 9, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (105, '2024-10-09 18:45:57.670401', '2024-12-18 09:22:19.362000', 0, 1, '资格预审通知文件', 'attachmentIds', 'attachmentIds', 1, 1, 1, 7, 10, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (106, '2024-10-09 18:46:00.328612', '2024-12-18 09:22:19.362000', 0, 1, '备注', 'remark', 'remark', 1, 0, 1, 7, 11, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (139, '2024-10-09 18:53:58.940501', '2024-12-06 11:05:36.868000', 0, 1, '项目名称', 'projectName', 'projectName', 1, 0, 1, 9, 2, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (140, '2024-10-09 18:54:19.083967', '2024-12-06 11:05:36.868000', 0, 1, '上次跟进日期', 'lastFollowUpDate', 'lastFollowUpDate', 1, 0, 1, 9, 1, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (141, '2024-10-09 18:54:23.681951', '2024-12-06 11:05:36.868000', 0, 1, '已跟进次数', 'followUpTimes', 'followUpTimes', 1, 0, 1, 9, 3, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (142, '2024-10-09 18:54:25.263219', '2024-12-06 11:05:36.868000', 0, 1, '附件', 'abandonAttachment', 'abandonAttachment', 1, 1, 1, 9, 5, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (143, '2024-10-09 18:54:27.787153', '2024-12-06 11:05:36.868000', 0, 1, '放弃说明', 'remark', 'remark', 1, 1, 1, 9, 4, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1034, '2024-10-09 19:53:16.221270', '2024-12-18 09:24:22.930000', 0, 1, '填报人', 'informantUserId', 'informantUserName', 1, 1, 1, 8, 2, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1035, '2024-10-09 19:53:18.722675', '2024-12-18 09:24:22.930000', 0, 1, '所属部门', 'departmentId', 'departmentName', 1, 1, 1, 8, 1, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1036, '2024-10-09 19:53:25.146997', '2024-12-18 09:24:22.930000', 0, 1, '填报日期', 'informantDateTime', 'informantDateTime', 1, 1, 1, 8, 3, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1037, '2024-10-09 19:53:28.366783', '2024-12-18 09:24:22.930000', 0, 1, '项目名称', 'projectName', 'projectName', 1, 1, 1, 8, 4, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1038, '2024-10-09 19:53:33.770175', '2024-12-18 09:24:22.930000', 0, 1, '项目备案号', 'projectSerialNumber', 'projectSerialNumber', 1, 0, 1, 8, 5, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1039, '2024-10-09 19:53:36.165797', '2024-12-18 09:24:22.930000', 0, 1, '招标单位', 'crmEnterpriseWarehousingId', 'crmEnterpriseWarehousingName', 1, 1, 1, 8, 6, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1040, '2024-10-09 19:53:40.158893', '2024-12-18 09:24:22.930000', 0, 1, '招标方式', 'biddingMethodId', 'biddingMethodName', 1, 1, 1, 8, 7, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1041, '2024-10-09 19:53:42.732425', '2024-12-18 09:24:22.930000', 0, 1, '招标规定', 'crmBiddingRegulationsTypeEnum', 'crmBiddingRegulationsTypeEnum', 1, 1, 1, 8, 8, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1042, '2024-10-09 19:53:46.751485', '2024-12-18 09:24:22.931000', 0, 1, '标书提交方式', 'tenderSubmissionMethodId', 'tenderSubmissionMethodName', 1, 1, 1, 8, 9, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1043, '2024-10-09 19:53:50.472114', '2024-12-18 09:24:22.931000', 0, 1, '投标截止日', 'bidExpirationDate', 'bidExpirationDate', 1, 1, 1, 8, 10, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1044, '2024-10-09 19:53:53.383622', '2024-12-18 09:24:22.931000', 0, 1, '开标时间', 'bidOpeningDate', 'bidOpeningDate', 1, 1, 1, 8, 11, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1045, '2024-10-09 19:54:00.522491', '2024-12-18 09:24:22.931000', 0, 1, '评标方式', 'bidEvaluationMethodId', 'bidEvaluationMethodName', 1, 1, 1, 8, 12, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1047, '2024-10-09 19:54:21.290587', '2024-12-18 09:24:22.931000', 0, 1, '招标控制价(万元)', 'controlledBiddingPrice', 'controlledBiddingPrice', 1, 1, 1, 8, 13, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1048, '2024-10-09 19:54:25.046941', '2024-12-18 09:24:22.931000', 0, 1, '结算方式', 'settlementMethodId', 'settlementMethodName', 1, 0, 1, 8, 14, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1050, '2024-10-09 19:54:40.423259', '2024-12-18 09:24:22.931000', 0, 1, '投标保证金额(万元)', 'tenderBond', 'tenderBond', 1, 1, 1, 8, 15, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1051, '2024-10-09 19:54:48.182535', '2024-12-18 09:24:22.931000', 0, 1, '投标保证金截止日', 'tenderBondDeadline', 'tenderBondDeadline', 1, 1, 1, 8, 16, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1052, '2024-10-09 19:54:50.583161', '2024-12-18 09:24:22.931000', 0, 1, '单位名称', 'companyName', 'companyName', 1, 0, 1, 8, 17, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1053, '2024-10-09 19:54:52.927204', '2024-12-18 09:24:22.931000', 0, 1, '开户行', 'depositBank', 'depositBank', 1, 0, 1, 8, 18, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1054, '2024-10-09 19:54:56.070190', '2024-12-18 09:24:22.931000', 0, 1, '银行账号', 'account', 'account', 1, 0, 1, 8, 19, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1056, '2024-10-09 19:55:02.287160', '2024-12-18 09:24:22.931000', 0, 1, '履约保证金额(万元)', 'cashDeposit', 'cashDeposit', 1, 0, 1, 8, 20, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1057, '2024-10-09 19:55:09.231844', '2024-12-18 09:24:22.932000', 0, 1, '履约保证金类型', 'typeOfPerformanceBondId', 'typeOfPerformanceBondName', 1, 0, 1, 8, 21, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1058, '2024-10-09 19:55:12.160096', '2024-12-18 09:24:22.932000', 0, 1, '保修比例', 'warrantyRatio', 'warrantyRatio', 1, 0, 1, 8, 22, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1059, '2024-10-09 19:55:24.087019', '2024-12-18 09:24:22.932000', 0, 1, '保修期限', 'warrantyDate', 'warrantyDate', 1, 0, 1, 8, 23, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1060, '2024-10-09 19:55:30.657256', '2024-12-18 09:24:22.932000', 0, 1, '计划开工日期', 'startDate', 'startDate', 1, 0, 1, 8, 24, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1061, '2024-10-09 19:55:35.407785', '2024-12-18 09:24:22.932000', 0, 1, '计划完工日期', 'endDate', 'endDate', 1, 0, 1, 8, 25, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1062, '2024-10-09 19:55:37.703362', '2024-12-18 09:24:22.932000', 0, 1, '总工期', 'allDate', 'allDate', 1, 0, 1, 8, 26, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1064, '2024-10-09 19:55:52.154490', '2024-12-18 09:24:22.932000', 0, 1, '材料调差', 'materialAdjustment', 'materialAdjustment', 1, 1, 1, 8, 27, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1066, '2024-10-09 19:56:05.543962', '2024-12-18 09:24:22.932000', 0, 1, '材料品牌规定', 'materialBrandRegulations', 'materialBrandRegulations', 1, 0, 1, 8, 28, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1068, '2024-10-09 19:56:15.350707', '2024-12-18 09:24:22.932000', 0, 1, '材料特殊规定', 'specialRulesForMaterials', 'specialRulesForMaterials', 1, 0, 1, 8, 29, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1070, '2024-10-09 19:56:26.481046', '2024-12-18 09:24:22.932000', 0, 1, '提供样品', 'offerSample', 'offerSample', 1, 0, 1, 8, 30, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1071, '2024-10-09 19:56:30.367907', '2024-12-18 09:24:22.932000', 0, 1, '付款方式', 'paymentMethod', 'paymentMethod', 1, 1, 1, 8, 31, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1072, '2024-10-09 19:56:33.736267', '2024-12-18 09:24:22.932000', 0, 1, '标书需求', 'tenderRequirement', 'tenderRequirement', 1, 1, 1, 8, 32, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1073, '2024-10-09 19:56:35.545244', '2024-12-18 09:24:22.932000', 0, 1, '附件', 'attachmentIds', 'attachmentDTOList', 1, 1, 1, 8, 33, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1074, '2024-10-09 19:56:38.512131', '2024-12-18 09:24:22.933000', 0, 1, '备注', 'remark', 'remark', 1, 0, 1, 8, 34, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1075, '2024-10-11 16:39:11.066844', '2024-12-10 10:27:42.545000', 1, 1, '企业性质', 'unitClassConfigurationId', 'unitPropertyAllocationConfigName', 1, 0, 6, 5, 21, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1076, '2024-10-11 16:39:16.960948', '2024-12-18 09:21:31.765000', 0, 1, '相关单位', 'crmEnterpriseWarehousingId', 'crmEnterpriseWarehousingName', 1, 1, 1, 5, 17, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1077, '2024-10-11 16:39:19.469201', '2024-12-10 10:27:42.545000', 1, 1, '姓名', 'name', 'name', 1, 0, 6, 5, 23, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1078, '2024-10-11 16:39:22.003173', '2024-12-10 10:27:42.545000', 1, 1, '职务', 'position', 'position', 1, 0, 6, 5, 24, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1079, '2024-10-11 16:39:25.421189', '2024-12-10 10:27:42.545000', 1, 1, '联系电话', 'phone', 'phone', 1, 0, 6, 5, 25, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1080, '2024-10-16 13:44:29.198496', '2024-12-18 09:18:49.451000', 0, 1, '所属项目', 'crmProjectInformationWarehousingId', 'crmProjectInformationWarehousingName', 1, 1, 1, 2, 1, NULL)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1081, '2024-10-16 19:56:57.357898', '2024-12-18 09:21:31.764000', 0, 1, '国省市区', 'regionList', 'regionList', 1, 1, 1, 5, 7, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1082, '2024-10-16 19:57:23.674505', '2024-12-18 09:21:31.764000', 0, 1, '详细地址', 'address', 'address', 1, 1, 1, 5, 8, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1083, '2024-10-16 19:57:25.491646', '2024-12-18 09:21:31.764000', 0, 1, '项目概况', 'projectOverview', 'projectOverview', 1, 1, 1, 5, 9, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1084, '2024-10-16 19:57:36.539549', '2024-12-18 09:21:31.764000', 0, 1, '预估工程量(吨)', 'estimatedWorks', 'estimatedWorks', 1, 1, 1, 5, 10, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1085, '2024-10-16 19:57:39.333955', '2024-12-18 09:21:31.764000', 0, 1, '预估造价(万元)', 'estimatedCost', 'estimatedCost', 1, 1, 1, 5, 11, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1086, '2024-10-16 19:57:52.744232', '2024-12-18 09:21:31.764000', 0, 1, '建筑面积(平方米)', 'areaOfStructure', 'areaOfStructure', 1, 1, 1, 5, 12, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1087, '2024-11-19 15:45:42.393416', '2024-12-18 09:21:31.764000', 0, 1, '结构类型', 'structureTypeConfigurationId', 'structureTypeConfigurationName', 1, 1, 1, 5, 13, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1088, '2024-11-19 15:46:35.208394', '2024-12-18 09:21:31.764000', 0, 1, '承建类别', 'typeOfContractorId', 'typeOfContractorName', 1, 1, 1, 5, 14, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1089, '2024-11-19 15:47:04.841154', '2024-12-18 09:21:31.764000', 0, 1, '所属行业', 'industryConfigurationId', 'industryConfigurationName', 1, 1, 1, 5, 15, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1090, '2024-11-19 15:47:38.142749', '2024-12-18 09:21:31.765000', 0, 1, '建筑形式', 'configurationOfArchitecturalFormId', 'configurationOfArchitecturalFormName', 1, 1, 1, 5, 16, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1091, '2024-09-10 17:05:00.905656', '2024-12-09 10:06:17.249000', 0, 1, '填报人', 'informantUserId', 'informantUserName', 1, 1, 1, 1, 1, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1092, '2024-09-11 11:43:30.490496', '2024-12-09 10:06:17.249000', 0, 1, '所属部门', 'departmentId', 'departmentName', 1, 0, 1, 1, 2, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1093, '2024-09-11 11:43:42.097679', '2024-12-09 10:06:17.249000', 0, 1, '填报日期', 'informantDateTime', 'informantDateTime', 1, 0, 1, 1, 3, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1094, '2024-09-11 11:43:51.729700', '2024-12-09 10:06:17.249000', 0, 1, '企业名称', 'businessName', 'businessName', 1, 0, 1, 1, 4, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1095, '2024-09-11 11:44:08.203711', '2024-12-09 10:06:17.249000', 0, 1, '企业类别', 'unitPropertyAllocationConfigId', 'unitPropertyAllocationConfigName', 1, 1, 1, 1, 5, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1096, '2024-09-11 11:44:13.131562', '2024-12-09 10:06:17.249000', 0, 1, '企业性质', 'unitClassConfigurationId', 'unitClassConfigurationName', 1, 1, 1, 1, 6, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1097, '2024-09-11 11:44:47.793794', '2024-12-09 10:06:17.249000', 0, 1, '国省市区', 'regionList', 'regionNameList', 1, 1, 1, 1, 7, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1098, '2024-09-11 11:44:59.946320', '2024-12-09 10:06:17.249000', 0, 1, '详细地址', 'address', 'address', 1, 1, 1, 1, 8, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1099, '2024-09-11 11:45:17.124948', '2024-12-09 10:06:17.249000', 0, 1, '社会统一信用代码', 'creditCode', 'creditCode', 1, 1, 1, 1, 9, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1100, '2024-09-11 11:45:25.749069', '2024-12-09 10:06:17.249000', 0, 1, '所属行业', 'industryConfigurationId', 'industryConfigurationName', 1, 1, 1, 1, 10, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1101, '2024-09-11 11:45:35.548136', '2024-12-09 10:06:17.249000', 0, 1, '资质能力', 'qualificationAndAbility', 'qualificationAndAbility', 1, 0, 1, 1, 11, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1102, '2024-09-11 11:45:43.959239', '2024-12-09 10:06:17.249000', 0, 1, '单位电话', 'businessPhone', 'businessPhone', 1, 1, 1, 1, 12, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1103, '2024-09-11 11:46:14.606285', '2024-12-09 10:06:17.249000', 0, 1, '单位邮箱', 'businessEmail', 'businessEmail', 1, 0, 1, 1, 13, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1104, '2024-09-11 11:46:23.118547', '2024-12-09 10:06:17.264000', 0, 1, '联系人', 'liaisons', 'liaisons', 1, 0, 1, 1, 14, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1105, '2024-09-11 11:46:33.374164', '2024-12-09 10:06:17.264000', 0, 1, '企业信誉', 'unitReputationAllocationConfigId', 'unitReputationAllocationConfigName', 1, 1, 1, 1, 15, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1106, '2024-09-11 11:46:39.646537', '2024-12-09 10:06:17.264000', 0, 1, '附件', 'attachmentIds', 'attachmentDTOList', 1, 1, 1, 1, 16, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1107, '2024-09-11 11:46:47.853942', '2024-12-09 10:06:17.264000', 0, 1, '备注', 'remark', 'remark', 1, 1, 1, 1, 17, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1108, '2024-11-19 15:47:04.841154', '2024-12-06 15:07:50.244000', 0, 1, '所属行业', 'industryConfigurationId', 'industryConfigurationName', 1, 1, 1, 5, 24, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1109, '2024-11-19 15:46:35.208394', '2024-12-06 15:07:50.244000', 0, 1, '承建类别', 'typeOfContractorId', 'typeOfContractorName', 1, 1, 1, 5, 22, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1110, '2024-11-19 15:45:42.393416', '2024-12-06 15:07:50.244000', 0, 1, '结构类型', 'structureTypeConfigurationId', 'structureTypeConfigurationName', 1, 1, 1, 5, 20, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1111, '2024-10-16 19:57:52.744232', '2024-12-06 15:07:50.244000', 0, 1, '建筑面积(平方米)', 'areaOfStructure', 'areaOfStructure', 1, 1, 1, 5, 18, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1112, '2024-10-16 19:57:39.333955', '2024-12-06 15:07:50.244000', 0, 1, '预估造价(万元)', 'estimatedCost', 'estimatedCost', 1, 1, 1, 5, 16, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1113, '2024-10-16 19:57:36.539549', '2024-12-06 15:07:50.244000', 0, 1, '预估工程量(吨)', 'estimatedWorks', 'estimatedWorks', 1, 1, 1, 5, 14, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1114, '2024-10-16 19:57:25.491646', '2024-12-06 15:07:50.244000', 0, 1, '项目概况', 'projectOverview', 'projectOverview', 1, 1, 1, 5, 12, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1115, '2024-10-16 19:57:23.674505', '2024-12-06 15:07:50.244000', 0, 1, '详细地址', 'address', 'address', 1, 1, 1, 5, 10, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1116, '2024-10-16 19:56:57.357898', '2024-12-06 15:07:50.244000', 0, 1, '国省市区', 'regionList', 'regionList', 1, 1, 1, 5, 8, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1117, '2024-10-11 16:39:25.421189', '2024-12-06 15:07:50.244000', 1, 1, '联系电话', 'phone', 'phone', 1, 0, 6, 5, 44, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1118, '2024-10-11 16:39:22.003173', '2024-12-06 15:07:50.244000', 1, 1, '职务', 'position', 'position', 1, 0, 6, 5, 42, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1119, '2024-10-11 16:39:19.469201', '2024-12-06 15:07:50.244000', 1, 1, '姓名', 'name', 'name', 1, 0, 6, 5, 40, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1120, '2024-10-11 16:39:16.960948', '2024-12-06 15:07:50.244000', 0, 1, '相关单位', 'crmEnterpriseWarehousingId', 'crmEnterpriseWarehousingName', 1, 0, 1, 5, 38, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1121, '2024-10-11 16:39:11.066844', '2024-12-06 15:07:50.244000', 1, 1, '企业性质', 'unitClassConfigurationId', 'unitPropertyAllocationConfigName', 1, 0, 6, 5, 36, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1122, '2024-10-09 18:36:11.387868', '2024-12-06 15:07:50.244000', 0, 1, '备注', 'remark', 'remark', 1, 1, 7, 5, 34, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1123, '2024-10-09 18:36:07.176808', '2024-12-06 15:07:50.244000', 0, 1, '附件', 'projectAttachments', 'projectAttachments', 1, 1, 7, 5, 32, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1124, '2024-10-09 18:35:33.165777', '2024-12-06 15:07:50.244000', 0, 1, '项目级别', 'projectLevelConfigId', 'projectLevelConfigName', 1, 1, 4, 5, 30, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1125, '2024-10-09 18:35:22.923297', '2024-12-06 15:07:50.244000', 0, 1, '招标方式', 'biddingMethodId', 'biddingMethodName', 1, 1, 4, 5, 28, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1131, '2024-11-19 15:47:38.142749', '2024-12-06 15:07:50.244000', 0, 1, '建筑形式', 'configurationOfArchitecturalFormId', 'configurationOfArchitecturalFormName', 1, 1, 1, 5, 26, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1132, '2024-10-09 18:32:01.455720', '2024-12-06 15:07:50.244000', 0, 1, '填报人', 'informantUserId', 'informantUserName', 1, 1, 1, 5, 2, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1133, '2024-10-09 18:32:06.349497', '2024-12-06 15:07:50.244000', 0, 1, '填报日期', 'informantDateTime', 'informantDateTime', 1, 1, 1, 5, 3, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1134, '2024-09-12 09:25:17.000000', '2024-12-06 15:07:50.244000', 0, 1, '项目名称', 'projectName', 'projectName', 1, 1, 1, 5, 4, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1135, '2024-09-12 09:26:00.646472', '2024-12-06 15:07:50.244000', 0, 1, '项目类别', 'itemCategoryId', 'itemCategoryName', 1, 1, 1, 5, 5, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1136, '2024-10-09 18:33:56.325473', '2024-12-06 15:07:50.244000', 0, 1, '重点项目', 'keyProjectId', 'keyProjectName', 1, 1, 1, 5, 6, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1200, '2024-12-10 11:46:45.392174', '2024-12-18 09:21:31.765000', 0, 1, '建设单位', 'aUnitClassConfigurationId', 'aUnitClassConfigurationName', 1, 0, 6, 5, 20, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1201, '2024-12-10 11:48:08.772928', '2024-12-18 09:21:31.765000', 0, 1, '联系人名称', 'aUnitClassConfigurationContactName', 'aUnitClassConfigurationContactName', 1, 0, 6, 5, 21, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1202, '2024-12-10 11:48:46.924901', '2024-12-18 09:21:31.765000', 0, 1, '联系人职务', 'aUnitClassConfigurationOffice', 'aUnitClassConfigurationOffice', 1, 0, 6, 5, 22, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1203, '2024-12-10 11:49:14.712355', '2024-12-18 09:21:31.765000', 0, 1, '联系人电话', 'aUnitClassConfigurationPhone', 'aUnitClassConfigurationPhone', 1, 0, 6, 5, 23, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1204, '2024-12-10 11:51:26.158107', '2024-12-18 09:21:31.765000', 0, 1, '代建单位', 'bUnitClassConfigurationId', 'bUnitClassConfigurationName', 1, 0, 6, 5, 24, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1205, '2024-12-10 11:52:06.363368', '2024-12-18 09:21:31.765000', 0, 1, '联系人名称', 'bUnitClassConfigurationContactName', 'bUnitClassConfigurationContactName', 1, 0, 6, 5, 25, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1206, '2024-12-10 11:52:40.627614', '2024-12-18 09:21:31.766000', 0, 1, '联系人职务', 'bUnitClassConfigurationOffice', 'bUnitClassConfigurationOffice', 1, 0, 6, 5, 26, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1207, '2024-12-10 11:53:50.556107', '2024-12-18 09:21:31.766000', 0, 1, '联系人电话', 'bUnitClassConfigurationPhone', 'bUnitClassConfigurationPhone', 1, 0, 6, 5, 27, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1208, '2024-12-10 11:54:51.539577', '2024-12-18 09:21:31.766000', 0, 1, 'EPC单位', 'cUnitClassConfigurationId', 'cUnitClassConfigurationName', 1, 0, 6, 5, 28, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1209, '2024-12-10 11:55:13.488060', '2024-12-18 09:21:31.766000', 0, 1, '联系人名称', 'cUnitClassConfigurationContactName', 'cUnitClassConfigurationContactName', 1, 0, 6, 5, 29, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1210, '2024-12-10 11:55:30.081328', '2024-12-18 09:21:31.766000', 0, 1, '联系人职务', 'cUnitClassConfigurationOffice', 'cUnitClassConfigurationOffice', 1, 0, 6, 5, 30, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1211, '2024-12-10 11:55:57.681156', '2024-12-18 09:21:31.766000', 0, 1, '联系人电话', 'cUnitClassConfigurationPhone', 'cUnitClassConfigurationPhone', 1, 0, 6, 5, 31, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1212, '2024-12-10 11:56:45.157080', '2024-12-18 09:21:31.766000', 0, 1, '设计单位', 'dUnitClassConfigurationId', 'dUnitClassConfigurationName', 1, 0, 6, 5, 32, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1213, '2024-12-10 11:57:08.528083', '2024-12-18 09:21:31.766000', 0, 1, '联系人名称', 'dUnitClassConfigurationContactName', 'dUnitClassConfigurationContactName', 1, 0, 6, 5, 33, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1214, '2024-12-10 11:57:24.046052', '2024-12-18 09:21:31.766000', 0, 1, '联系人职务', 'dUnitClassConfigurationOffice', 'dUnitClassConfigurationOffice', 1, 0, 6, 5, 34, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1215, '2024-12-10 11:57:42.556271', '2024-12-18 09:21:31.766000', 0, 1, '联系人电话', 'dUnitClassConfigurationPhone', 'dUnitClassConfigurationPhone', 1, 0, 6, 5, 35, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1216, '2024-12-10 11:58:36.731351', '2024-12-18 09:21:31.766000', 0, 1, '总包单位', 'eUnitClassConfigurationId', 'eUnitClassConfigurationName', 1, 0, 6, 5, 36, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1217, '2024-12-10 11:58:54.688504', '2024-12-18 09:21:31.767000', 0, 1, '联系人名称', 'eUnitClassConfigurationContactName', 'eUnitClassConfigurationContactName', 1, 0, 6, 5, 37, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1218, '2024-12-10 11:59:22.696640', '2024-12-18 09:21:31.767000', 0, 1, '联系人职务', 'eUnitClassConfigurationOffice', 'eUnitClassConfigurationOffice', 1, 0, 6, 5, 38, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1219, '2024-12-10 11:59:41.063457', '2024-12-18 09:21:31.767000', 0, 1, '联系人电话', 'eUnitClassConfigurationPhone', 'eUnitClassConfigurationPhone', 1, 0, 6, 5, 39, 1)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1220, '2024-12-10 11:46:45.392174', NULL, 0, 1, '建设单位', 'aUnitClassConfigurationId', 'aUnitClassConfigurationName', 1, 0, 6, 5, 1, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1221, '2024-12-10 11:48:08.772928', NULL, 0, 1, '联系人名称', 'aUnitClassConfigurationContactName', 'aUnitClassConfigurationContactName', 1, 0, 6, 5, 2, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1222, '2024-12-10 11:48:46.924901', NULL, 0, 1, '联系人职务', 'aUnitClassConfigurationOffice', 'aUnitClassConfigurationOffice', 1, 0, 6, 5, 3, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1223, '2024-12-10 11:49:14.712355', NULL, 0, 1, '联系人电话', 'aUnitClassConfigurationPhone', 'aUnitClassConfigurationPhone', 1, 0, 6, 5, 4, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1224, '2024-12-10 11:51:26.158107', NULL, 0, 1, '代建单位', 'bUnitClassConfigurationId', 'bUnitClassConfigurationName', 1, 0, 6, 5, 5, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1225, '2024-12-10 11:52:06.363368', NULL, 0, 1, '联系人名称', 'bUnitClassConfigurationContactName', 'bUnitClassConfigurationContactName', 1, 0, 6, 5, 6, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1226, '2024-12-10 11:52:40.627614', NULL, 0, 1, '联系人职务', 'bUnitClassConfigurationOffice', 'bUnitClassConfigurationOffice', 1, 0, 6, 5, 7, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1227, '2024-12-10 11:53:50.556107', NULL, 0, 1, '联系人电话', 'bUnitClassConfigurationPhone', 'bUnitClassConfigurationPhone', 1, 0, 6, 5, 8, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1228, '2024-12-10 11:54:51.539577', NULL, 0, 1, 'EPC单位', 'cUnitClassConfigurationId', 'cUnitClassConfigurationName', 1, 0, 6, 5, 9, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1229, '2024-12-10 11:55:13.488060', NULL, 0, 1, '联系人名称', 'cUnitClassConfigurationContactName', 'cUnitClassConfigurationContactName', 1, 0, 6, 5, 10, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1230, '2024-12-10 11:55:30.081328', NULL, 0, 1, '联系人职务', 'cUnitClassConfigurationOffice', 'cUnitClassConfigurationOffice', 1, 0, 6, 5, 11, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1231, '2024-12-10 11:55:57.681156', NULL, 0, 1, '联系人电话', 'cUnitClassConfigurationPhone', 'cUnitClassConfigurationPhone', 1, 0, 6, 5, 12, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1232, '2024-12-10 11:56:45.157080', NULL, 0, 1, '设计单位', 'dUnitClassConfigurationId', 'dUnitClassConfigurationName', 1, 0, 6, 5, 13, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1233, '2024-12-10 11:57:08.528083', NULL, 0, 1, '联系人名称', 'dUnitClassConfigurationContactName', 'dUnitClassConfigurationContactName', 1, 0, 6, 5, 14, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1234, '2024-12-10 11:57:24.046052', NULL, 0, 1, '联系人职务', 'dUnitClassConfigurationOffice', 'dUnitClassConfigurationOffice', 1, 0, 6, 5, 15, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1235, '2024-12-10 11:57:42.556271', NULL, 0, 1, '联系人电话', 'dUnitClassConfigurationPhone', 'dUnitClassConfigurationPhone', 1, 0, 6, 5, 16, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1236, '2024-12-10 11:58:36.731351', NULL, 0, 1, '总包单位', 'eUnitClassConfigurationId', 'eUnitClassConfigurationName', 1, 0, 6, 5, 17, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1237, '2024-12-10 11:58:54.688504', NULL, 0, 1, '联系人名称', 'eUnitClassConfigurationContactName', 'eUnitClassConfigurationContactName', 1, 0, 6, 5, 18, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1238, '2024-12-10 11:59:22.696640', NULL, 0, 1, '联系人职务', 'eUnitClassConfigurationOffice', 'eUnitClassConfigurationOffice', 1, 0, 6, 5, 19, 2)"
            );
            saveSqlList.add(
               "INSERT INTO `"
                  + datasource
                  + "`.`crm_page_management_config` (`id`, `create_time`, `update_time`, `bool_delete_enum`, `version`, `field_name`, `argument_name`, `argument_show_name`, `is_show`, `is_write`, `crm_field_parent_type_enum`, `crm_page_management_config_enum`, `sort`, `crm_country_type_enum`) VALUES (1239, '2024-12-10 11:59:41.063457', NULL, 0, 1, '联系人电话', 'eUnitClassConfigurationPhone', 'eUnitClassConfigurationPhone', 1, 0, 6, 5, 20, 2)"
            );
         }

         if (CollectionUtils.isNotEmpty(saveSqlList)) {
            saveSqlList.forEach(this.service::updateSql);
         }
      }
   }

   public CrmPageManagementConfigRunner(final CrmPageManagementConfigService crmPageManagementConfigService, final InitializationService service) {
      this.crmPageManagementConfigService = crmPageManagementConfigService;
      this.service = service;
   }
}
