package com.hzchum.scim.crm.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CrmProjectInformationWarehousing对象", description = "项目信息备案")
@Entity
@TableName("crm_project_information_warehousing")
@Table(name = "crm_project_information_warehousing")
@org.hibernate.annotations.Table(appliesTo = "crm_project_information_warehousing", comment = "项目信息备案")
public class CrmProjectInformationWarehousing extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "informantUserId", value = "填报人", notes = "填报人")
   @TableField("informant_user_id")
   @Column(name = "informant_user_id", columnDefinition = "bigint(20)  COMMENT '填报人'", nullable = true)
   private Long informantUserId;
   @ApiModelProperty(name = "informantUserName", value = "填报人名称", notes = "填报人名称")
   @TableField("informant_user_name")
   @Column(name = "informant_user_name", columnDefinition = "varchar(255)  COMMENT '填报人名称'", nullable = true)
   private String informantUserName;
   @ApiModelProperty(name = "departmentId", value = "所属部门", notes = "所属部门")
   @TableField("department_id")
   @Column(name = "department_id", columnDefinition = "bigint(20)  COMMENT '所属部门'", nullable = true)
   private Long departmentId;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   @TableField("informant_date_time")
   @Column(name = "informant_date_time", columnDefinition = "datetime  COMMENT '填报日期'", nullable = true)
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人'", nullable = true)
   private Long createUserId;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态 参考枚举 CrmCheckStatusEnum", notes = "审核状态 参考枚举 CrmCheckStatusEnum")
   @TableField("crm_check_status_enum")
   @Column(name = "crm_check_status_enum", columnDefinition = "int(11)  COMMENT '审核状态 参考枚举 CrmCheckStatusEnum'", nullable = true)
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint(20)  COMMENT '审批id'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   @TableField("project_name")
   @Column(name = "project_name", columnDefinition = "varchar(255)  COMMENT '项目名称'", nullable = true)
   private String projectName;
   @ApiModelProperty(name = "serialNumber", value = "备案号", notes = "备案号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '备案号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "projectSerialNumber", value = "项目编号", notes = "项目编号")
   @TableField("project_serial_number")
   @Column(name = "project_serial_number", columnDefinition = "varchar(255)  COMMENT '项目编号'", nullable = true)
   private String projectSerialNumber;
   @ApiModelProperty(name = "typeOfContractorId", value = "承建类别 CrmProjectInformationConfig", notes = "承建类别 CrmProjectInformationConfig")
   @TableField("type_of_contractor_id")
   @Column(name = "type_of_contractor_id", columnDefinition = "bigint(20)  COMMENT '承建类别 CrmProjectInformationConfig'", nullable = true)
   private Long typeOfContractorId;
   @ApiModelProperty(name = "keyProjectId", value = "重点项目CrmProjectInformationConfig", notes = "重点项目CrmProjectInformationConfig")
   @TableField("key_project_id")
   @Column(name = "key_project_id", columnDefinition = "bigint(20)  COMMENT '重点项目CrmProjectInformationConfig'", nullable = true)
   private Long keyProjectId;
   @ApiModelProperty(name = "itemCategoryId", value = "项目类别 CrmProjectInformationConfig", notes = "项目类别 CrmProjectInformationConfig")
   @TableField("item_category_id")
   @Column(name = "item_category_id", columnDefinition = "bigint(20)  COMMENT '项目类别 CrmProjectInformationConfig'", nullable = true)
   private Long itemCategoryId;
   @ApiModelProperty(name = "configurationOfArchitecturalFormId", value = "建筑形式 CrmProjectInformationConfig", notes = "建筑形式 CrmProjectInformationConfig")
   @TableField("configuration_of_architectural_form_id")
   @Column(name = "configuration_of_architectural_form_id", columnDefinition = "bigint(20)  COMMENT '建筑形式 CrmProjectInformationConfig'", nullable = true)
   private Long configurationOfArchitecturalFormId;
   @ApiModelProperty(name = "structureTypeConfigurationId", value = "结构类型 CrmProjectInformationConfig", notes = "结构类型 CrmProjectInformationConfig")
   @TableField("structure_type_configuration_id")
   @Column(name = "structure_type_configuration_id", columnDefinition = "bigint(20)  COMMENT '结构类型 CrmProjectInformationConfig'", nullable = true)
   private Long structureTypeConfigurationId;
   @ApiModelProperty(name = "industryConfigurationId", value = "所属行业 CrmBasicsConfig", notes = "所属行业 CrmBasicsConfig")
   @TableField("industry_configuration_id")
   @Column(name = "industry_configuration_id", columnDefinition = "bigint(20)  COMMENT '所属行业 CrmBasicsConfig'", nullable = true)
   private Long industryConfigurationId;
   @ApiModelProperty(name = "countryId", value = "国家id", notes = "国家id")
   @TableField("country_id")
   @Column(name = "country_id", columnDefinition = "bigint(20)  COMMENT '国家id'", nullable = true)
   private Long countryId;
   @ApiModelProperty(name = "countryName", value = "国家名称", notes = "国家名称")
   @TableField("country_name")
   @Column(name = "country_name", columnDefinition = "varchar(255) DEFAULT '' COMMENT '国家名称'", nullable = true)
   private String countryName;
   @ApiModelProperty(name = "provinceId", value = "省份id", notes = "省份id")
   @TableField("province_id")
   @Column(name = "province_id", columnDefinition = "bigint(20)  COMMENT '省份id'", nullable = true)
   private Long provinceId;
   @ApiModelProperty(name = "provinceName", value = "省份名称", notes = "省份名称")
   @TableField("province_name")
   @Column(name = "province_name", columnDefinition = "varchar(255) DEFAULT '' COMMENT '省份名称'", nullable = true)
   private String provinceName;
   @ApiModelProperty(name = "cityId", value = "城市id", notes = "城市id")
   @TableField("city_id")
   @Column(name = "city_id", columnDefinition = "bigint(20)  COMMENT '城市id'", nullable = true)
   private Long cityId;
   @ApiModelProperty(name = "cityName", value = "城市名称", notes = "城市名称")
   @TableField("city_name")
   @Column(name = "city_name", columnDefinition = "varchar(255) DEFAULT '' COMMENT '城市名称'", nullable = true)
   private String cityName;
   @ApiModelProperty(name = "regionId", value = "地区id", notes = "地区id")
   @TableField("region_id")
   @Column(name = "region_id", columnDefinition = "bigint(20)  COMMENT '地区id'", nullable = true)
   private Long regionId;
   @ApiModelProperty(name = "regionName", value = "地区名称", notes = "地区名称")
   @TableField("region_name")
   @Column(name = "region_name", columnDefinition = "varchar(255) DEFAULT '' COMMENT '地区名称'", nullable = true)
   private String regionName;
   @ApiModelProperty(name = "address", value = "详细地址", notes = "详细地址")
   @TableField("address")
   @Column(name = "address", columnDefinition = "varchar(255)  COMMENT '详细地址'", nullable = true)
   private String address;
   @ApiModelProperty(name = "projectOverview", value = "项目概况", notes = "项目概况")
   @TableField("project_overview")
   @Column(name = "project_overview", columnDefinition = "varchar(255)  COMMENT '项目概况'", nullable = true)
   private String projectOverview;
   @ApiModelProperty(name = "estimatedWorks", value = "预估工程量", notes = "预估工程量")
   @TableField("estimated_works")
   @Column(name = "estimated_works", columnDefinition = "decimal(20,2)  COMMENT '预估工程量'", nullable = true)
   private BigDecimal estimatedWorks;
   @ApiModelProperty(name = "estimatedCost", value = "预估造价", notes = "预估造价")
   @TableField("estimated_cost")
   @Column(name = "estimated_cost", columnDefinition = "decimal(20,2)  COMMENT '预估造价'", nullable = true)
   private BigDecimal estimatedCost;
   @ApiModelProperty(name = "areaOfStructure", value = "建筑面积", notes = "建筑面积")
   @TableField("area_of_structure")
   @Column(name = "area_of_structure", columnDefinition = "decimal(20,2)  COMMENT '建筑面积'", nullable = true)
   private BigDecimal areaOfStructure;
   @ApiModelProperty(name = "biddingMethodId", value = "招标方式  CrmTenderRequestConfig", notes = "招标方式  CrmTenderRequestConfig")
   @TableField("bidding_method_id")
   @Column(name = "bidding_method_id", columnDefinition = "bigint(20)  COMMENT '招标方式  CrmTenderRequestConfig'", nullable = true)
   private Long biddingMethodId;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   @TableField("crm_enterprise_warehousing_id")
   @Column(name = "crm_enterprise_warehousing_id", columnDefinition = "bigint(20)  COMMENT '企业备案id'", nullable = true)
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "projectLevelConfigId", value = "项目级别 CrmProjectInformationConfig", notes = "项目级别 CrmProjectInformationConfig")
   @TableField("project_level_config_id")
   @Column(name = "project_level_config_id", columnDefinition = "bigint(20)  COMMENT '项目级别 CrmProjectInformationConfig'", nullable = true)
   private Long projectLevelConfigId;
   @ApiModelProperty(name = "projectAttachments", value = "项目附件", notes = "项目附件")
   @TableField("project_attachments")
   @Column(name = "project_attachments", columnDefinition = "varchar(255)  COMMENT '项目附件'", nullable = true)
   private String projectAttachments;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "crmProjectScheduleTypeEnum", value = "当前状态", notes = "当前状态")
   @TableField("crm_project_schedule_type_enum")
   @Column(name = "crm_project_schedule_type_enum", columnDefinition = "int(11)  COMMENT '当前状态'", nullable = true)
   private Integer crmProjectScheduleTypeEnum;
   @ApiModelProperty(name = "validityOfRegistration", value = "项目信息登记有效期", notes = "项目信息登记有效期")
   @TableField("validity_of_registration")
   @Column(name = "validity_of_registration", columnDefinition = "int(11) default 0  COMMENT '项目信息登记有效期'", nullable = true)
   private Integer validityOfRegistration;
   @ApiModelProperty(name = "informationOperatorUserId", value = "项目信息可操作人", notes = "项目信息可操作人")
   @TableField("information_operator_user_id")
   @Column(name = "information_operator_user_id", columnDefinition = "bigint(20)  COMMENT '项目信息可操作人'", nullable = true)
   private Long informationOperatorUserId;
   @ApiModelProperty(name = "informationOperatorDeptId", value = "项目信息可操作人部门id", notes = "项目信息可操作人部门id")
   @TableField("information_operator_dept_id")
   @Column(name = "information_operator_dept_id", columnDefinition = "bigint(20)  COMMENT '项目信息可操作人部门id'", nullable = true)
   private Long informationOperatorDeptId;
   @ApiModelProperty(name = "isBiddingMethod", value = "是否商务标", notes = "是否商务标")
   @TableField("is_bidding_method")
   @Column(name = "is_bidding_method", columnDefinition = "tinyint(1) default 0  COMMENT '是否商务标'", nullable = true)
   private Boolean isBiddingMethod;
   @ApiModelProperty(name = "isSettlementMethod", value = "是否技术标", notes = "是否技术标")
   @TableField("is_settlement_method")
   @Column(name = "is_settlement_method", columnDefinition = "tinyint(1) default 0  COMMENT '是否技术标'", nullable = true)
   private Boolean isSettlementMethod;
   @ApiModelProperty(name = "isTypeOfPerformanceBond", value = "是否设计标", notes = "是否设计标")
   @TableField("is_type_of_performance_bond")
   @Column(name = "is_type_of_performance_bond", columnDefinition = "tinyint(1) default 0  COMMENT '是否设计标'", nullable = true)
   private Boolean isTypeOfPerformanceBond;
   @ApiModelProperty(name = "businessProjectBidManagerUserId", value = "商务项目投标负责人", notes = "商务项目投标负责人")
   @TableField("business_project_bid_manager_user_id")
   @Column(name = "business_project_bid_manager_user_id", columnDefinition = "varchar(255)  COMMENT '商务项目投标负责人'", nullable = true)
   private String businessProjectBidManagerUserId;
   @ApiModelProperty(name = "businessProjectBidManagerFinishDate", value = "商务投标完成时间", notes = "商务投标完成时间")
   @TableField("business_project_bid_manager_finish_date")
   @Column(name = "business_project_bid_manager_finish_date", columnDefinition = "datetime  COMMENT '商务投标完成时间'", nullable = true)
   private LocalDateTime businessProjectBidManagerFinishDate;
   @ApiModelProperty(name = "businessProjectBidManagerActualFinishDate", value = "商务投标实际完成时间", notes = "商务投标实际完成时间")
   @TableField("business_project_bid_manager_actual_finish_date")
   @Column(name = "business_project_bid_manager_actual_finish_date", columnDefinition = "datetime  COMMENT '商务投标实际完成时间'", nullable = true)
   private LocalDateTime businessProjectBidManagerActualFinishDate;
   @ApiModelProperty(name = "businessProjectBidManagerQuote", value = "商务投标报价", notes = "商务投标报价")
   @TableField("business_project_bid_manager_quote")
   @Column(name = "business_project_bid_manager_quote", columnDefinition = "decimal(10,2)  COMMENT '商务投标报价'", nullable = true)
   private BigDecimal businessProjectBidManagerQuote;
   @ApiModelProperty(name = "businessProjectBidManagerEstimatedWorks", value = "商务工程量", notes = "商务工程量")
   @TableField("business_project_bid_manager_estimated_works")
   @Column(name = "business_project_bid_manager_estimated_works", columnDefinition = "decimal(10,2)  COMMENT '商务工程量'", nullable = true)
   private BigDecimal businessProjectBidManagerEstimatedWorks;
   @ApiModelProperty(name = "businessProjectBidManagerCost", value = "商务成本", notes = "商务成本")
   @TableField("business_project_bid_manager_cost")
   @Column(name = "business_project_bid_manager_cost", columnDefinition = "decimal(10,2)  COMMENT '商务成本'", nullable = true)
   private BigDecimal businessProjectBidManagerCost;
   @ApiModelProperty(name = "businessProjectBidManagerGrossProfit", value = "商务毛利", notes = "商务毛利")
   @TableField("business_project_bid_manager_gross_profit")
   @Column(name = "business_project_bid_manager_gross_profit", columnDefinition = "decimal(10,2)  COMMENT '商务毛利'", nullable = true)
   private BigDecimal businessProjectBidManagerGrossProfit;
   @ApiModelProperty(name = "businessProjectBidManagerRemark", value = "商务投标备注", notes = "商务投标备注")
   @TableField("business_project_bid_manager_remark")
   @Column(name = "business_project_bid_manager_remark", columnDefinition = "varchar(1024)  COMMENT '商务投标备注'", nullable = true)
   private String businessProjectBidManagerRemark;
   @ApiModelProperty(name = "businessDifficultyFactorId", value = "商务投标难度系数", notes = "商务投标难度系数")
   @TableField("business_difficulty_factor_id")
   @Column(name = "business_difficulty_factor_id", columnDefinition = "bigint(20)  COMMENT '商务投标难度系数'", nullable = true)
   private Long businessDifficultyFactorId;
   @ApiModelProperty(name = "businessBidManagerAttachmentIds", value = "商务投标附件", notes = "商务投标附件")
   @TableField("business_bid_manager_attachment_ids")
   @Column(name = "business_bid_manager_attachment_ids", columnDefinition = "varchar(255)  COMMENT '商务投标附件'", nullable = true)
   private String businessBidManagerAttachmentIds;
   @ApiModelProperty(name = "businessCrmProjectBidStatus", value = "投标状态", notes = "投标状态")
   @TableField("business_crm_project_bid_status")
   @Column(name = "business_crm_project_bid_status", columnDefinition = "int(11) default '1' COMMENT '投标状态'", nullable = true)
   private Integer businessCrmProjectBidStatus;
   @ApiModelProperty(name = "deviseProjectBidManagerUserId", value = "设计项目投标负责人", notes = "设计项目投标负责人")
   @TableField("devise_project_bid_manager_user_id")
   @Column(name = "devise_project_bid_manager_user_id", columnDefinition = "varchar(255)  COMMENT '设计项目投标负责人'", nullable = true)
   private String deviseProjectBidManagerUserId;
   @ApiModelProperty(name = "deviseProjectBidManagerFinishDate", value = "设计投标sh'ji完成时间", notes = "设计投标完成时间")
   @TableField("devise_project_bid_manager_finish_date")
   @Column(name = "devise_project_bid_manager_finish_date", columnDefinition = "datetime  COMMENT '设计投标完成时间'", nullable = true)
   private LocalDateTime deviseProjectBidManagerFinishDate;
   @ApiModelProperty(name = "deviseProjectBidManagerActualFinishDate", value = "设计投标实际完成时间", notes = "设计投标实际完成时间")
   @TableField("devise_project_bid_manager_actual_finish_date")
   @Column(name = "devise_project_bid_manager_actual_finish_date", columnDefinition = "datetime  COMMENT '设计投标实际完成时间'", nullable = true)
   private LocalDateTime deviseProjectBidManagerActualFinishDate;
   @ApiModelProperty(name = "deviseDifficultyFactorId", value = "设计难度系数", notes = "设计难度系数")
   @TableField("devise_difficulty_factor_id")
   @Column(name = "devise_difficulty_factor_id", columnDefinition = "bigint(20)  COMMENT '设计难度系数'", nullable = true)
   private Long deviseDifficultyFactorId;
   @ApiModelProperty(name = "deviseBidManagerAttachmentIds", value = "设计投标附件", notes = "设计投标附件")
   @TableField("devise_bid_manager_attachment_ids")
   @Column(name = "devise_bid_manager_attachment_ids", columnDefinition = "varchar(255)  COMMENT '设计投标附件'", nullable = true)
   private String deviseBidManagerAttachmentIds;
   @ApiModelProperty(name = "deviseCrmProjectBidStatus", value = "设计投标状态", notes = "设计投标状态")
   @TableField("devise_crm_project_bid_status")
   @Column(name = "devise_crm_project_bid_status", columnDefinition = "int(11) default '1' COMMENT '设计投标状态'", nullable = true)
   private Integer deviseCrmProjectBidStatus;
   @ApiModelProperty(name = "technologyProjectBidManagerUserId", value = "技术项目投标负责人", notes = "技术项目投标负责人")
   @TableField("technology_project_bid_manager_user_id")
   @Column(name = "technology_project_bid_manager_user_id", columnDefinition = "varchar(255)  COMMENT '技术项目投标负责人'", nullable = true)
   private String technologyProjectBidManagerUserId;
   @ApiModelProperty(name = "technologyProjectBidManagerFinishDate", value = "技术投标完成时间", notes = "技术投标完成时间")
   @TableField("technology_project_bid_manager_finish_date")
   @Column(name = "technology_project_bid_manager_finish_date", columnDefinition = "datetime  COMMENT '技术投标完成时间'", nullable = true)
   private LocalDateTime technologyProjectBidManagerFinishDate;
   @ApiModelProperty(name = "technologyProjectBidManagerActualFinishDate", value = "技术投标实际完成时间", notes = "技术投标实际完成时间")
   @TableField("technology_project_bid_manager_actual_finish_date")
   @Column(name = "technology_project_bid_manager_actual_finish_date", columnDefinition = "datetime  COMMENT '技术投标实际完成时间'", nullable = true)
   private LocalDateTime technologyProjectBidManagerActualFinishDate;
   @ApiModelProperty(name = "technologyDifficultyFactorId", value = "技术难度系数", notes = "技术难度系数")
   @TableField("technology_difficulty_factor_id")
   @Column(name = "technology_difficulty_factor_id", columnDefinition = "bigint(20)  COMMENT '技术难度系数'", nullable = true)
   private Long technologyDifficultyFactorId;
   @ApiModelProperty(name = "technologyBidManagerAttachmentIds", value = "技术投标附件", notes = "技术投标附件")
   @TableField("technology_bid_manager_attachment_ids")
   @Column(name = "technology_bid_manager_attachment_ids", columnDefinition = "varchar(255)  COMMENT '技术投标附件'", nullable = true)
   private String technologyBidManagerAttachmentIds;
   @ApiModelProperty(name = "technologyBidManagerJobDescriptionId", value = "技术投标工作内容", notes = "技术投标工作内容")
   @TableField("technology_bid_manager_job_description_id")
   @Column(name = "technology_bid_manager_job_description_id", columnDefinition = "bigint(20)  COMMENT '技术投标工作内容 参考投标申请配置'", nullable = true)
   private Long technologyBidManagerJobDescriptionId;
   @ApiModelProperty(name = "technologyBidManagerRenderings", value = "技术投标效果图", notes = "技术投标效果图")
   @TableField("technology_bid_manager_renderings")
   @Column(name = "technology_bid_manager_renderings", columnDefinition = "varchar(255)  COMMENT '技术投标效果图'", nullable = true)
   private String technologyBidManagerRenderings;
   @ApiModelProperty(name = "technologyBidManagerStructureName", value = "技术投标结构名称", notes = "技术投标结构名称")
   @TableField("technology_bid_manager_structure_name")
   @Column(name = "technology_bid_manager_structure_name", columnDefinition = "varchar(255)  COMMENT '技术投标结构名称'", nullable = true)
   private String technologyBidManagerStructureName;
   @ApiModelProperty(name = "technologyBidManagerCompletion", value = "技术投标完成情况", notes = "技术投标完成情况")
   @TableField("technology_bid_manager_completion")
   @Column(name = "technology_bid_manager_completion", columnDefinition = "varchar(255)  COMMENT '技术投标完成情况'", nullable = true)
   private String technologyBidManagerCompletion;
   @ApiModelProperty(name = "technologyBidManagerBusinessTrip", value = "技术投标出差", notes = "技术投标出差")
   @TableField("technology_bid_manager_business_trip")
   @Column(name = "technology_bid_manager_business_trip", columnDefinition = "varchar(255)  COMMENT '技术投标出差'", nullable = true)
   private String technologyBidManagerBusinessTrip;
   @ApiModelProperty(name = "technologyBidManagerCustomerReception", value = "技术投标客户接待", notes = "技术投标客户接待")
   @TableField("technology_bid_manager_customer_reception")
   @Column(name = "technology_bid_manager_customer_reception", columnDefinition = "varchar(255)  COMMENT '技术投标客户接待'", nullable = true)
   private String technologyBidManagerCustomerReception;
   @ApiModelProperty(name = "technologyBidManagerRemarks", value = "技术投标备注", notes = "技术投标备注")
   @TableField("technology_bid_manager_remarks")
   @Column(name = "technology_bid_manager_remarks", columnDefinition = "varchar(255)  COMMENT '技术投标备注'", nullable = true)
   private String technologyBidManagerRemarks;
   @ApiModelProperty(name = "technologyCrmProjectBidStatus", value = "技术投标状态", notes = "技术投标状态")
   @TableField("technology_crm_project_bid_status")
   @Column(name = "technology_crm_project_bid_status", columnDefinition = "int(11) default '1' COMMENT '技术投标状态'", nullable = true)
   private Integer technologyCrmProjectBidStatus;
   @ApiModelProperty(name = "sealContractAttachmentIds", value = "盖章合同附件id集合", notes = "盖章合同附件id集合")
   @TableField("seal_contract_attachment_ids")
   @Column(name = "seal_contract_attachment_ids", columnDefinition = "varchar(255)  COMMENT '盖章合同附件id集合'", nullable = true)
   private String sealContractAttachmentIds;
   @ApiModelProperty(name = "crmCountryTypeEnum", value = "国家类型枚举（CrmCountryTypeEnum）", notes = "国家类型枚举（CrmCountryTypeEnum）")
   @TableField("crm_country_type_enum")
   @Column(name = "crm_country_type_enum", columnDefinition = "int(11)  COMMENT '国家类型枚举（CrmCountryTypeEnum）'", nullable = true)
   private Integer crmCountryTypeEnum;
   @ApiModelProperty(name = "aUnitClassConfigurationId", value = "建设单位", notes = "建设单位")
   @TableField("a_unit_class_configuration_id")
   @Column(name = "a_unit_class_configuration_id", columnDefinition = "int(11)  COMMENT '建设单位  参考crm_basics_config'", nullable = true)
   private Long aUnitClassConfigurationId;
   @ApiModelProperty(name = "aUnitClassConfigurationContactName", value = "联系人名称", notes = "联系人名称")
   @TableField("a_unit_class_configuration_contact_name")
   @Column(name = "a_unit_class_configuration_contact_name", columnDefinition = "varchar(255)  COMMENT '联系人名称'", nullable = true)
   private String aUnitClassConfigurationContactName;
   @ApiModelProperty(name = "aUnitClassConfigurationOffice", value = "联系人职务", notes = "联系人职务")
   @TableField("a_unit_class_configuration_office")
   @Column(name = "a_unit_class_configuration_office", columnDefinition = "varchar(255)  COMMENT '联系人职务'", nullable = true)
   private String aUnitClassConfigurationOffice;
   @ApiModelProperty(name = "aUnitClassConfigurationPhone", value = "联系人电话", notes = "联系人电话")
   @TableField("a_unit_class_configuration_phone")
   @Column(name = "a_unit_class_configuration_phone", columnDefinition = "varchar(255)  COMMENT '联系人电话'", nullable = true)
   private String aUnitClassConfigurationPhone;
   @ApiModelProperty(name = "bUnitClassConfigurationId", value = "代建单位", notes = "代建单位")
   @TableField("b_unit_class_configuration_id")
   @Column(name = "b_unit_class_configuration_id", columnDefinition = "int(11)  COMMENT '代建单位  参考crm_basics_config'", nullable = true)
   private Long bUnitClassConfigurationId;
   @ApiModelProperty(name = "bUnitClassConfigurationContactName", value = "联系人名称", notes = "联系人名称")
   @TableField("b_unit_class_configuration_contact_name")
   @Column(name = "b_unit_class_configuration_contact_name", columnDefinition = "varchar(255)  COMMENT '联系人名称'", nullable = true)
   private String bUnitClassConfigurationContactName;
   @ApiModelProperty(name = "bUnitClassConfigurationOffice", value = "联系人职务", notes = "联系人职务")
   @TableField("b_unit_class_configuration_office")
   @Column(name = "b_unit_class_configuration_office", columnDefinition = "varchar(255)  COMMENT '联系人职务'", nullable = true)
   private String bUnitClassConfigurationOffice;
   @ApiModelProperty(name = "bUnitClassConfigurationPhone", value = "联系人电话", notes = "联系人电话")
   @TableField("b_unit_class_configuration_phone")
   @Column(name = "b_unit_class_configuration_phone", columnDefinition = "varchar(255)  COMMENT '联系人电话'", nullable = true)
   private String bUnitClassConfigurationPhone;
   @ApiModelProperty(name = "cUnitClassConfigurationId", value = "EPC单位", notes = "EPC单位")
   @TableField("c_unit_class_configuration_id")
   @Column(name = "c_unit_class_configuration_id", columnDefinition = "int(11)  COMMENT 'EPC单位  参考crm_basics_config'", nullable = true)
   private Long cUnitClassConfigurationId;
   @ApiModelProperty(name = "cUnitClassConfigurationContactName", value = "联系人名称", notes = "联系人名称")
   @TableField("c_unit_class_configuration_contact_name")
   @Column(name = "c_unit_class_configuration_contact_name", columnDefinition = "varchar(255)  COMMENT '联系人名称'", nullable = true)
   private String cUnitClassConfigurationContactName;
   @ApiModelProperty(name = "cUnitClassConfigurationOffice", value = "联系人职务", notes = "联系人职务")
   @TableField("c_unit_class_configuration_office")
   @Column(name = "c_unit_class_configuration_office", columnDefinition = "varchar(255)  COMMENT '联系人职务'", nullable = true)
   private String cUnitClassConfigurationOffice;
   @ApiModelProperty(name = "cUnitClassConfigurationPhone", value = "联系人电话", notes = "联系人电话")
   @TableField("c_unit_class_configuration_phone")
   @Column(name = "c_unit_class_configuration_phone", columnDefinition = "varchar(255)  COMMENT '联系人电话'", nullable = true)
   private String cUnitClassConfigurationPhone;
   @ApiModelProperty(name = "dUnitClassConfigurationId", value = "设计单位", notes = "设计单位")
   @TableField("d_unit_class_configuration_id")
   @Column(name = "d_unit_class_configuration_id", columnDefinition = "int(11)  COMMENT '设计单位  参考crm_basics_config'", nullable = true)
   private Long dUnitClassConfigurationId;
   @ApiModelProperty(name = "dUnitClassConfigurationContactName", value = "联系人名称", notes = "联系人名称")
   @TableField("d_unit_class_configuration_contact_name")
   @Column(name = "d_unit_class_configuration_contact_name", columnDefinition = "varchar(255)  COMMENT '联系人名称'", nullable = true)
   private String dUnitClassConfigurationContactName;
   @ApiModelProperty(name = "dUnitClassConfigurationOffice", value = "联系人职务", notes = "联系人职务")
   @TableField("d_unit_class_configuration_office")
   @Column(name = "d_unit_class_configuration_office", columnDefinition = "varchar(255)  COMMENT '联系人职务'", nullable = true)
   private String dUnitClassConfigurationOffice;
   @ApiModelProperty(name = "dUnitClassConfigurationPhone", value = "联系人电话", notes = "联系人电话")
   @TableField("d_unit_class_configuration_phone")
   @Column(name = "d_unit_class_configuration_phone", columnDefinition = "varchar(255)  COMMENT '联系人电话'", nullable = true)
   private String dUnitClassConfigurationPhone;
   @ApiModelProperty(name = "eUnitClassConfigurationId", value = "总包单位", notes = "总包单位")
   @TableField("e_unit_class_configuration_id")
   @Column(name = "e_unit_class_configuration_id", columnDefinition = "int(11)  COMMENT '总包单位  参考crm_basics_config'", nullable = true)
   private Long eUnitClassConfigurationId;
   @ApiModelProperty(name = "eUnitClassConfigurationContactName", value = "联系人名称", notes = "联系人名称")
   @TableField("e_unit_class_configuration_contact_name")
   @Column(name = "e_unit_class_configuration_contact_name", columnDefinition = "varchar(255)  COMMENT '联系人名称'", nullable = true)
   private String eUnitClassConfigurationContactName;
   @ApiModelProperty(name = "eUnitClassConfigurationOffice", value = "联系人职务", notes = "联系人职务")
   @TableField("e_unit_class_configuration_office")
   @Column(name = "e_unit_class_configuration_office", columnDefinition = "varchar(255)  COMMENT '联系人职务'", nullable = true)
   private String eUnitClassConfigurationOffice;
   @ApiModelProperty(name = "eUnitClassConfigurationPhone", value = "联系人电话", notes = "联系人电话")
   @TableField("e_unit_class_configuration_phone")
   @Column(name = "e_unit_class_configuration_phone", columnDefinition = "varchar(255)  COMMENT '联系人电话'", nullable = true)
   private String eUnitClassConfigurationPhone;
   @ApiModelProperty(name = "infoSource", value = "信息来源 参考字典 ")
   @TableField("info_source")
   @Column(name = "info_source", columnDefinition = "varchar(255) comment'信息来源'")
   private String infoSource;
   @ApiModelProperty(name = "projectManagerName", notes = "项目经理")
   @TableField("project_manager_name")
   @Column(name = "project_manager_name", columnDefinition = "varchar(255) comment'项目经理'")
   private String projectManagerName;
   @ApiModelProperty(name = "isProjectManagerCoordinate", value = "是否项目经理配合", notes = "是否项目经理配合")
   @TableField("is_project_manager_coordinate")
   @Column(name = "is_project_manager_coordinate", columnDefinition = "varchar(255) comment'是否项目经理配合'")
   private Boolean isProjectManagerCoordinate;
   @ApiModelProperty(name = "crmSettlementBusinessTypeEnum", value = "(直营非直营)", notes = "(直营非直营)")
   @TableField("crm_settlement_business_type_enum")
   @Column(
      name = "crm_settlement_business_type_enum",
      columnDefinition = "int(11) default '1'  COMMENT '结算业务类型  参考枚举 CrmSettlementBusinessTypeEnum (直营非直营)'",
      nullable = false
   )
   private Integer crmSettlementBusinessTypeEnum;
   @ApiModelProperty(name = "lastDistributionTime", value = "最后分配时间", notes = "最后分配时间")
   @TableField("last_distribution_time")
   @Column(name = "last_distribution_time", columnDefinition = "datetime  COMMENT '最后分配时间'", nullable = true)
   private LocalDateTime lastDistributionTime;

   public static CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder builder() {
      return new CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder();
   }

   public CrmProjectInformationWarehousing() {
   }

   public CrmProjectInformationWarehousing(
      final Long id,
      final Long informantUserId,
      final String informantUserName,
      final Long departmentId,
      final LocalDateTime informantDateTime,
      final Long createUserId,
      final Integer crmCheckStatusEnum,
      final Long approveRecordId,
      final String projectName,
      final String serialNumber,
      final String projectSerialNumber,
      final Long typeOfContractorId,
      final Long keyProjectId,
      final Long itemCategoryId,
      final Long configurationOfArchitecturalFormId,
      final Long structureTypeConfigurationId,
      final Long industryConfigurationId,
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final String regionName,
      final String address,
      final String projectOverview,
      final BigDecimal estimatedWorks,
      final BigDecimal estimatedCost,
      final BigDecimal areaOfStructure,
      final Long biddingMethodId,
      final Long crmEnterpriseWarehousingId,
      final Long projectLevelConfigId,
      final String projectAttachments,
      final String remark,
      final Integer crmProjectScheduleTypeEnum,
      final Integer validityOfRegistration,
      final Long informationOperatorUserId,
      final Long informationOperatorDeptId,
      final Boolean isBiddingMethod,
      final Boolean isSettlementMethod,
      final Boolean isTypeOfPerformanceBond,
      final String businessProjectBidManagerUserId,
      final LocalDateTime businessProjectBidManagerFinishDate,
      final LocalDateTime businessProjectBidManagerActualFinishDate,
      final BigDecimal businessProjectBidManagerQuote,
      final BigDecimal businessProjectBidManagerEstimatedWorks,
      final BigDecimal businessProjectBidManagerCost,
      final BigDecimal businessProjectBidManagerGrossProfit,
      final String businessProjectBidManagerRemark,
      final Long businessDifficultyFactorId,
      final String businessBidManagerAttachmentIds,
      final Integer businessCrmProjectBidStatus,
      final String deviseProjectBidManagerUserId,
      final LocalDateTime deviseProjectBidManagerFinishDate,
      final LocalDateTime deviseProjectBidManagerActualFinishDate,
      final Long deviseDifficultyFactorId,
      final String deviseBidManagerAttachmentIds,
      final Integer deviseCrmProjectBidStatus,
      final String technologyProjectBidManagerUserId,
      final LocalDateTime technologyProjectBidManagerFinishDate,
      final LocalDateTime technologyProjectBidManagerActualFinishDate,
      final Long technologyDifficultyFactorId,
      final String technologyBidManagerAttachmentIds,
      final Long technologyBidManagerJobDescriptionId,
      final String technologyBidManagerRenderings,
      final String technologyBidManagerStructureName,
      final String technologyBidManagerCompletion,
      final String technologyBidManagerBusinessTrip,
      final String technologyBidManagerCustomerReception,
      final String technologyBidManagerRemarks,
      final Integer technologyCrmProjectBidStatus,
      final String sealContractAttachmentIds,
      final Integer crmCountryTypeEnum,
      final Long aUnitClassConfigurationId,
      final String aUnitClassConfigurationContactName,
      final String aUnitClassConfigurationOffice,
      final String aUnitClassConfigurationPhone,
      final Long bUnitClassConfigurationId,
      final String bUnitClassConfigurationContactName,
      final String bUnitClassConfigurationOffice,
      final String bUnitClassConfigurationPhone,
      final Long cUnitClassConfigurationId,
      final String cUnitClassConfigurationContactName,
      final String cUnitClassConfigurationOffice,
      final String cUnitClassConfigurationPhone,
      final Long dUnitClassConfigurationId,
      final String dUnitClassConfigurationContactName,
      final String dUnitClassConfigurationOffice,
      final String dUnitClassConfigurationPhone,
      final Long eUnitClassConfigurationId,
      final String eUnitClassConfigurationContactName,
      final String eUnitClassConfigurationOffice,
      final String eUnitClassConfigurationPhone,
      final String infoSource,
      final String projectManagerName,
      final Boolean isProjectManagerCoordinate,
      final Integer crmSettlementBusinessTypeEnum,
      final LocalDateTime lastDistributionTime
   ) {
      this.id = id;
      this.informantUserId = informantUserId;
      this.informantUserName = informantUserName;
      this.departmentId = departmentId;
      this.informantDateTime = informantDateTime;
      this.createUserId = createUserId;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.approveRecordId = approveRecordId;
      this.projectName = projectName;
      this.serialNumber = serialNumber;
      this.projectSerialNumber = projectSerialNumber;
      this.typeOfContractorId = typeOfContractorId;
      this.keyProjectId = keyProjectId;
      this.itemCategoryId = itemCategoryId;
      this.configurationOfArchitecturalFormId = configurationOfArchitecturalFormId;
      this.structureTypeConfigurationId = structureTypeConfigurationId;
      this.industryConfigurationId = industryConfigurationId;
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.address = address;
      this.projectOverview = projectOverview;
      this.estimatedWorks = estimatedWorks;
      this.estimatedCost = estimatedCost;
      this.areaOfStructure = areaOfStructure;
      this.biddingMethodId = biddingMethodId;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.projectLevelConfigId = projectLevelConfigId;
      this.projectAttachments = projectAttachments;
      this.remark = remark;
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
      this.validityOfRegistration = validityOfRegistration;
      this.informationOperatorUserId = informationOperatorUserId;
      this.informationOperatorDeptId = informationOperatorDeptId;
      this.isBiddingMethod = isBiddingMethod;
      this.isSettlementMethod = isSettlementMethod;
      this.isTypeOfPerformanceBond = isTypeOfPerformanceBond;
      this.businessProjectBidManagerUserId = businessProjectBidManagerUserId;
      this.businessProjectBidManagerFinishDate = businessProjectBidManagerFinishDate;
      this.businessProjectBidManagerActualFinishDate = businessProjectBidManagerActualFinishDate;
      this.businessProjectBidManagerQuote = businessProjectBidManagerQuote;
      this.businessProjectBidManagerEstimatedWorks = businessProjectBidManagerEstimatedWorks;
      this.businessProjectBidManagerCost = businessProjectBidManagerCost;
      this.businessProjectBidManagerGrossProfit = businessProjectBidManagerGrossProfit;
      this.businessProjectBidManagerRemark = businessProjectBidManagerRemark;
      this.businessDifficultyFactorId = businessDifficultyFactorId;
      this.businessBidManagerAttachmentIds = businessBidManagerAttachmentIds;
      this.businessCrmProjectBidStatus = businessCrmProjectBidStatus;
      this.deviseProjectBidManagerUserId = deviseProjectBidManagerUserId;
      this.deviseProjectBidManagerFinishDate = deviseProjectBidManagerFinishDate;
      this.deviseProjectBidManagerActualFinishDate = deviseProjectBidManagerActualFinishDate;
      this.deviseDifficultyFactorId = deviseDifficultyFactorId;
      this.deviseBidManagerAttachmentIds = deviseBidManagerAttachmentIds;
      this.deviseCrmProjectBidStatus = deviseCrmProjectBidStatus;
      this.technologyProjectBidManagerUserId = technologyProjectBidManagerUserId;
      this.technologyProjectBidManagerFinishDate = technologyProjectBidManagerFinishDate;
      this.technologyProjectBidManagerActualFinishDate = technologyProjectBidManagerActualFinishDate;
      this.technologyDifficultyFactorId = technologyDifficultyFactorId;
      this.technologyBidManagerAttachmentIds = technologyBidManagerAttachmentIds;
      this.technologyBidManagerJobDescriptionId = technologyBidManagerJobDescriptionId;
      this.technologyBidManagerRenderings = technologyBidManagerRenderings;
      this.technologyBidManagerStructureName = technologyBidManagerStructureName;
      this.technologyBidManagerCompletion = technologyBidManagerCompletion;
      this.technologyBidManagerBusinessTrip = technologyBidManagerBusinessTrip;
      this.technologyBidManagerCustomerReception = technologyBidManagerCustomerReception;
      this.technologyBidManagerRemarks = technologyBidManagerRemarks;
      this.technologyCrmProjectBidStatus = technologyCrmProjectBidStatus;
      this.sealContractAttachmentIds = sealContractAttachmentIds;
      this.crmCountryTypeEnum = crmCountryTypeEnum;
      this.aUnitClassConfigurationId = aUnitClassConfigurationId;
      this.aUnitClassConfigurationContactName = aUnitClassConfigurationContactName;
      this.aUnitClassConfigurationOffice = aUnitClassConfigurationOffice;
      this.aUnitClassConfigurationPhone = aUnitClassConfigurationPhone;
      this.bUnitClassConfigurationId = bUnitClassConfigurationId;
      this.bUnitClassConfigurationContactName = bUnitClassConfigurationContactName;
      this.bUnitClassConfigurationOffice = bUnitClassConfigurationOffice;
      this.bUnitClassConfigurationPhone = bUnitClassConfigurationPhone;
      this.cUnitClassConfigurationId = cUnitClassConfigurationId;
      this.cUnitClassConfigurationContactName = cUnitClassConfigurationContactName;
      this.cUnitClassConfigurationOffice = cUnitClassConfigurationOffice;
      this.cUnitClassConfigurationPhone = cUnitClassConfigurationPhone;
      this.dUnitClassConfigurationId = dUnitClassConfigurationId;
      this.dUnitClassConfigurationContactName = dUnitClassConfigurationContactName;
      this.dUnitClassConfigurationOffice = dUnitClassConfigurationOffice;
      this.dUnitClassConfigurationPhone = dUnitClassConfigurationPhone;
      this.eUnitClassConfigurationId = eUnitClassConfigurationId;
      this.eUnitClassConfigurationContactName = eUnitClassConfigurationContactName;
      this.eUnitClassConfigurationOffice = eUnitClassConfigurationOffice;
      this.eUnitClassConfigurationPhone = eUnitClassConfigurationPhone;
      this.infoSource = infoSource;
      this.projectManagerName = projectManagerName;
      this.isProjectManagerCoordinate = isProjectManagerCoordinate;
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
      this.lastDistributionTime = lastDistributionTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public Long getTypeOfContractorId() {
      return this.typeOfContractorId;
   }

   public Long getKeyProjectId() {
      return this.keyProjectId;
   }

   public Long getItemCategoryId() {
      return this.itemCategoryId;
   }

   public Long getConfigurationOfArchitecturalFormId() {
      return this.configurationOfArchitecturalFormId;
   }

   public Long getStructureTypeConfigurationId() {
      return this.structureTypeConfigurationId;
   }

   public Long getIndustryConfigurationId() {
      return this.industryConfigurationId;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public String getCountryName() {
      return this.countryName;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public String getProvinceName() {
      return this.provinceName;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public String getCityName() {
      return this.cityName;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public String getRegionName() {
      return this.regionName;
   }

   public String getAddress() {
      return this.address;
   }

   public String getProjectOverview() {
      return this.projectOverview;
   }

   public BigDecimal getEstimatedWorks() {
      return this.estimatedWorks;
   }

   public BigDecimal getEstimatedCost() {
      return this.estimatedCost;
   }

   public BigDecimal getAreaOfStructure() {
      return this.areaOfStructure;
   }

   public Long getBiddingMethodId() {
      return this.biddingMethodId;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public Long getProjectLevelConfigId() {
      return this.projectLevelConfigId;
   }

   public String getProjectAttachments() {
      return this.projectAttachments;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getCrmProjectScheduleTypeEnum() {
      return this.crmProjectScheduleTypeEnum;
   }

   public Integer getValidityOfRegistration() {
      return this.validityOfRegistration;
   }

   public Long getInformationOperatorUserId() {
      return this.informationOperatorUserId;
   }

   public Long getInformationOperatorDeptId() {
      return this.informationOperatorDeptId;
   }

   public Boolean getIsBiddingMethod() {
      return this.isBiddingMethod;
   }

   public Boolean getIsSettlementMethod() {
      return this.isSettlementMethod;
   }

   public Boolean getIsTypeOfPerformanceBond() {
      return this.isTypeOfPerformanceBond;
   }

   public String getBusinessProjectBidManagerUserId() {
      return this.businessProjectBidManagerUserId;
   }

   public LocalDateTime getBusinessProjectBidManagerFinishDate() {
      return this.businessProjectBidManagerFinishDate;
   }

   public LocalDateTime getBusinessProjectBidManagerActualFinishDate() {
      return this.businessProjectBidManagerActualFinishDate;
   }

   public BigDecimal getBusinessProjectBidManagerQuote() {
      return this.businessProjectBidManagerQuote;
   }

   public BigDecimal getBusinessProjectBidManagerEstimatedWorks() {
      return this.businessProjectBidManagerEstimatedWorks;
   }

   public BigDecimal getBusinessProjectBidManagerCost() {
      return this.businessProjectBidManagerCost;
   }

   public BigDecimal getBusinessProjectBidManagerGrossProfit() {
      return this.businessProjectBidManagerGrossProfit;
   }

   public String getBusinessProjectBidManagerRemark() {
      return this.businessProjectBidManagerRemark;
   }

   public Long getBusinessDifficultyFactorId() {
      return this.businessDifficultyFactorId;
   }

   public String getBusinessBidManagerAttachmentIds() {
      return this.businessBidManagerAttachmentIds;
   }

   public Integer getBusinessCrmProjectBidStatus() {
      return this.businessCrmProjectBidStatus;
   }

   public String getDeviseProjectBidManagerUserId() {
      return this.deviseProjectBidManagerUserId;
   }

   public LocalDateTime getDeviseProjectBidManagerFinishDate() {
      return this.deviseProjectBidManagerFinishDate;
   }

   public LocalDateTime getDeviseProjectBidManagerActualFinishDate() {
      return this.deviseProjectBidManagerActualFinishDate;
   }

   public Long getDeviseDifficultyFactorId() {
      return this.deviseDifficultyFactorId;
   }

   public String getDeviseBidManagerAttachmentIds() {
      return this.deviseBidManagerAttachmentIds;
   }

   public Integer getDeviseCrmProjectBidStatus() {
      return this.deviseCrmProjectBidStatus;
   }

   public String getTechnologyProjectBidManagerUserId() {
      return this.technologyProjectBidManagerUserId;
   }

   public LocalDateTime getTechnologyProjectBidManagerFinishDate() {
      return this.technologyProjectBidManagerFinishDate;
   }

   public LocalDateTime getTechnologyProjectBidManagerActualFinishDate() {
      return this.technologyProjectBidManagerActualFinishDate;
   }

   public Long getTechnologyDifficultyFactorId() {
      return this.technologyDifficultyFactorId;
   }

   public String getTechnologyBidManagerAttachmentIds() {
      return this.technologyBidManagerAttachmentIds;
   }

   public Long getTechnologyBidManagerJobDescriptionId() {
      return this.technologyBidManagerJobDescriptionId;
   }

   public String getTechnologyBidManagerRenderings() {
      return this.technologyBidManagerRenderings;
   }

   public String getTechnologyBidManagerStructureName() {
      return this.technologyBidManagerStructureName;
   }

   public String getTechnologyBidManagerCompletion() {
      return this.technologyBidManagerCompletion;
   }

   public String getTechnologyBidManagerBusinessTrip() {
      return this.technologyBidManagerBusinessTrip;
   }

   public String getTechnologyBidManagerCustomerReception() {
      return this.technologyBidManagerCustomerReception;
   }

   public String getTechnologyBidManagerRemarks() {
      return this.technologyBidManagerRemarks;
   }

   public Integer getTechnologyCrmProjectBidStatus() {
      return this.technologyCrmProjectBidStatus;
   }

   public String getSealContractAttachmentIds() {
      return this.sealContractAttachmentIds;
   }

   public Integer getCrmCountryTypeEnum() {
      return this.crmCountryTypeEnum;
   }

   public Long getAUnitClassConfigurationId() {
      return this.aUnitClassConfigurationId;
   }

   public String getAUnitClassConfigurationContactName() {
      return this.aUnitClassConfigurationContactName;
   }

   public String getAUnitClassConfigurationOffice() {
      return this.aUnitClassConfigurationOffice;
   }

   public String getAUnitClassConfigurationPhone() {
      return this.aUnitClassConfigurationPhone;
   }

   public Long getBUnitClassConfigurationId() {
      return this.bUnitClassConfigurationId;
   }

   public String getBUnitClassConfigurationContactName() {
      return this.bUnitClassConfigurationContactName;
   }

   public String getBUnitClassConfigurationOffice() {
      return this.bUnitClassConfigurationOffice;
   }

   public String getBUnitClassConfigurationPhone() {
      return this.bUnitClassConfigurationPhone;
   }

   public Long getCUnitClassConfigurationId() {
      return this.cUnitClassConfigurationId;
   }

   public String getCUnitClassConfigurationContactName() {
      return this.cUnitClassConfigurationContactName;
   }

   public String getCUnitClassConfigurationOffice() {
      return this.cUnitClassConfigurationOffice;
   }

   public String getCUnitClassConfigurationPhone() {
      return this.cUnitClassConfigurationPhone;
   }

   public Long getDUnitClassConfigurationId() {
      return this.dUnitClassConfigurationId;
   }

   public String getDUnitClassConfigurationContactName() {
      return this.dUnitClassConfigurationContactName;
   }

   public String getDUnitClassConfigurationOffice() {
      return this.dUnitClassConfigurationOffice;
   }

   public String getDUnitClassConfigurationPhone() {
      return this.dUnitClassConfigurationPhone;
   }

   public Long getEUnitClassConfigurationId() {
      return this.eUnitClassConfigurationId;
   }

   public String getEUnitClassConfigurationContactName() {
      return this.eUnitClassConfigurationContactName;
   }

   public String getEUnitClassConfigurationOffice() {
      return this.eUnitClassConfigurationOffice;
   }

   public String getEUnitClassConfigurationPhone() {
      return this.eUnitClassConfigurationPhone;
   }

   public String getInfoSource() {
      return this.infoSource;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public Boolean getIsProjectManagerCoordinate() {
      return this.isProjectManagerCoordinate;
   }

   public Integer getCrmSettlementBusinessTypeEnum() {
      return this.crmSettlementBusinessTypeEnum;
   }

   public LocalDateTime getLastDistributionTime() {
      return this.lastDistributionTime;
   }

   public CrmProjectInformationWarehousing setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmProjectInformationWarehousing setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
      return this;
   }

   public CrmProjectInformationWarehousing setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmProjectInformationWarehousing setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public CrmProjectInformationWarehousing setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmProjectInformationWarehousing setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public CrmProjectInformationWarehousing setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmProjectInformationWarehousing setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmProjectInformationWarehousing setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public CrmProjectInformationWarehousing setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmProjectInformationWarehousing setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
      return this;
   }

   public CrmProjectInformationWarehousing setTypeOfContractorId(final Long typeOfContractorId) {
      this.typeOfContractorId = typeOfContractorId;
      return this;
   }

   public CrmProjectInformationWarehousing setKeyProjectId(final Long keyProjectId) {
      this.keyProjectId = keyProjectId;
      return this;
   }

   public CrmProjectInformationWarehousing setItemCategoryId(final Long itemCategoryId) {
      this.itemCategoryId = itemCategoryId;
      return this;
   }

   public CrmProjectInformationWarehousing setConfigurationOfArchitecturalFormId(final Long configurationOfArchitecturalFormId) {
      this.configurationOfArchitecturalFormId = configurationOfArchitecturalFormId;
      return this;
   }

   public CrmProjectInformationWarehousing setStructureTypeConfigurationId(final Long structureTypeConfigurationId) {
      this.structureTypeConfigurationId = structureTypeConfigurationId;
      return this;
   }

   public CrmProjectInformationWarehousing setIndustryConfigurationId(final Long industryConfigurationId) {
      this.industryConfigurationId = industryConfigurationId;
      return this;
   }

   public CrmProjectInformationWarehousing setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   public CrmProjectInformationWarehousing setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmProjectInformationWarehousing setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   public CrmProjectInformationWarehousing setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   public CrmProjectInformationWarehousing setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   public CrmProjectInformationWarehousing setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   public CrmProjectInformationWarehousing setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   public CrmProjectInformationWarehousing setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   public CrmProjectInformationWarehousing setAddress(final String address) {
      this.address = address;
      return this;
   }

   public CrmProjectInformationWarehousing setProjectOverview(final String projectOverview) {
      this.projectOverview = projectOverview;
      return this;
   }

   public CrmProjectInformationWarehousing setEstimatedWorks(final BigDecimal estimatedWorks) {
      this.estimatedWorks = estimatedWorks;
      return this;
   }

   public CrmProjectInformationWarehousing setEstimatedCost(final BigDecimal estimatedCost) {
      this.estimatedCost = estimatedCost;
      return this;
   }

   public CrmProjectInformationWarehousing setAreaOfStructure(final BigDecimal areaOfStructure) {
      this.areaOfStructure = areaOfStructure;
      return this;
   }

   public CrmProjectInformationWarehousing setBiddingMethodId(final Long biddingMethodId) {
      this.biddingMethodId = biddingMethodId;
      return this;
   }

   public CrmProjectInformationWarehousing setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      return this;
   }

   public CrmProjectInformationWarehousing setProjectLevelConfigId(final Long projectLevelConfigId) {
      this.projectLevelConfigId = projectLevelConfigId;
      return this;
   }

   public CrmProjectInformationWarehousing setProjectAttachments(final String projectAttachments) {
      this.projectAttachments = projectAttachments;
      return this;
   }

   public CrmProjectInformationWarehousing setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmProjectInformationWarehousing setCrmProjectScheduleTypeEnum(final Integer crmProjectScheduleTypeEnum) {
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
      return this;
   }

   public CrmProjectInformationWarehousing setValidityOfRegistration(final Integer validityOfRegistration) {
      this.validityOfRegistration = validityOfRegistration;
      return this;
   }

   public CrmProjectInformationWarehousing setInformationOperatorUserId(final Long informationOperatorUserId) {
      this.informationOperatorUserId = informationOperatorUserId;
      return this;
   }

   public CrmProjectInformationWarehousing setInformationOperatorDeptId(final Long informationOperatorDeptId) {
      this.informationOperatorDeptId = informationOperatorDeptId;
      return this;
   }

   public CrmProjectInformationWarehousing setIsBiddingMethod(final Boolean isBiddingMethod) {
      this.isBiddingMethod = isBiddingMethod;
      return this;
   }

   public CrmProjectInformationWarehousing setIsSettlementMethod(final Boolean isSettlementMethod) {
      this.isSettlementMethod = isSettlementMethod;
      return this;
   }

   public CrmProjectInformationWarehousing setIsTypeOfPerformanceBond(final Boolean isTypeOfPerformanceBond) {
      this.isTypeOfPerformanceBond = isTypeOfPerformanceBond;
      return this;
   }

   public CrmProjectInformationWarehousing setBusinessProjectBidManagerUserId(final String businessProjectBidManagerUserId) {
      this.businessProjectBidManagerUserId = businessProjectBidManagerUserId;
      return this;
   }

   public CrmProjectInformationWarehousing setBusinessProjectBidManagerFinishDate(final LocalDateTime businessProjectBidManagerFinishDate) {
      this.businessProjectBidManagerFinishDate = businessProjectBidManagerFinishDate;
      return this;
   }

   public CrmProjectInformationWarehousing setBusinessProjectBidManagerActualFinishDate(final LocalDateTime businessProjectBidManagerActualFinishDate) {
      this.businessProjectBidManagerActualFinishDate = businessProjectBidManagerActualFinishDate;
      return this;
   }

   public CrmProjectInformationWarehousing setBusinessProjectBidManagerQuote(final BigDecimal businessProjectBidManagerQuote) {
      this.businessProjectBidManagerQuote = businessProjectBidManagerQuote;
      return this;
   }

   public CrmProjectInformationWarehousing setBusinessProjectBidManagerEstimatedWorks(final BigDecimal businessProjectBidManagerEstimatedWorks) {
      this.businessProjectBidManagerEstimatedWorks = businessProjectBidManagerEstimatedWorks;
      return this;
   }

   public CrmProjectInformationWarehousing setBusinessProjectBidManagerCost(final BigDecimal businessProjectBidManagerCost) {
      this.businessProjectBidManagerCost = businessProjectBidManagerCost;
      return this;
   }

   public CrmProjectInformationWarehousing setBusinessProjectBidManagerGrossProfit(final BigDecimal businessProjectBidManagerGrossProfit) {
      this.businessProjectBidManagerGrossProfit = businessProjectBidManagerGrossProfit;
      return this;
   }

   public CrmProjectInformationWarehousing setBusinessProjectBidManagerRemark(final String businessProjectBidManagerRemark) {
      this.businessProjectBidManagerRemark = businessProjectBidManagerRemark;
      return this;
   }

   public CrmProjectInformationWarehousing setBusinessDifficultyFactorId(final Long businessDifficultyFactorId) {
      this.businessDifficultyFactorId = businessDifficultyFactorId;
      return this;
   }

   public CrmProjectInformationWarehousing setBusinessBidManagerAttachmentIds(final String businessBidManagerAttachmentIds) {
      this.businessBidManagerAttachmentIds = businessBidManagerAttachmentIds;
      return this;
   }

   public CrmProjectInformationWarehousing setBusinessCrmProjectBidStatus(final Integer businessCrmProjectBidStatus) {
      this.businessCrmProjectBidStatus = businessCrmProjectBidStatus;
      return this;
   }

   public CrmProjectInformationWarehousing setDeviseProjectBidManagerUserId(final String deviseProjectBidManagerUserId) {
      this.deviseProjectBidManagerUserId = deviseProjectBidManagerUserId;
      return this;
   }

   public CrmProjectInformationWarehousing setDeviseProjectBidManagerFinishDate(final LocalDateTime deviseProjectBidManagerFinishDate) {
      this.deviseProjectBidManagerFinishDate = deviseProjectBidManagerFinishDate;
      return this;
   }

   public CrmProjectInformationWarehousing setDeviseProjectBidManagerActualFinishDate(final LocalDateTime deviseProjectBidManagerActualFinishDate) {
      this.deviseProjectBidManagerActualFinishDate = deviseProjectBidManagerActualFinishDate;
      return this;
   }

   public CrmProjectInformationWarehousing setDeviseDifficultyFactorId(final Long deviseDifficultyFactorId) {
      this.deviseDifficultyFactorId = deviseDifficultyFactorId;
      return this;
   }

   public CrmProjectInformationWarehousing setDeviseBidManagerAttachmentIds(final String deviseBidManagerAttachmentIds) {
      this.deviseBidManagerAttachmentIds = deviseBidManagerAttachmentIds;
      return this;
   }

   public CrmProjectInformationWarehousing setDeviseCrmProjectBidStatus(final Integer deviseCrmProjectBidStatus) {
      this.deviseCrmProjectBidStatus = deviseCrmProjectBidStatus;
      return this;
   }

   public CrmProjectInformationWarehousing setTechnologyProjectBidManagerUserId(final String technologyProjectBidManagerUserId) {
      this.technologyProjectBidManagerUserId = technologyProjectBidManagerUserId;
      return this;
   }

   public CrmProjectInformationWarehousing setTechnologyProjectBidManagerFinishDate(final LocalDateTime technologyProjectBidManagerFinishDate) {
      this.technologyProjectBidManagerFinishDate = technologyProjectBidManagerFinishDate;
      return this;
   }

   public CrmProjectInformationWarehousing setTechnologyProjectBidManagerActualFinishDate(final LocalDateTime technologyProjectBidManagerActualFinishDate) {
      this.technologyProjectBidManagerActualFinishDate = technologyProjectBidManagerActualFinishDate;
      return this;
   }

   public CrmProjectInformationWarehousing setTechnologyDifficultyFactorId(final Long technologyDifficultyFactorId) {
      this.technologyDifficultyFactorId = technologyDifficultyFactorId;
      return this;
   }

   public CrmProjectInformationWarehousing setTechnologyBidManagerAttachmentIds(final String technologyBidManagerAttachmentIds) {
      this.technologyBidManagerAttachmentIds = technologyBidManagerAttachmentIds;
      return this;
   }

   public CrmProjectInformationWarehousing setTechnologyBidManagerJobDescriptionId(final Long technologyBidManagerJobDescriptionId) {
      this.technologyBidManagerJobDescriptionId = technologyBidManagerJobDescriptionId;
      return this;
   }

   public CrmProjectInformationWarehousing setTechnologyBidManagerRenderings(final String technologyBidManagerRenderings) {
      this.technologyBidManagerRenderings = technologyBidManagerRenderings;
      return this;
   }

   public CrmProjectInformationWarehousing setTechnologyBidManagerStructureName(final String technologyBidManagerStructureName) {
      this.technologyBidManagerStructureName = technologyBidManagerStructureName;
      return this;
   }

   public CrmProjectInformationWarehousing setTechnologyBidManagerCompletion(final String technologyBidManagerCompletion) {
      this.technologyBidManagerCompletion = technologyBidManagerCompletion;
      return this;
   }

   public CrmProjectInformationWarehousing setTechnologyBidManagerBusinessTrip(final String technologyBidManagerBusinessTrip) {
      this.technologyBidManagerBusinessTrip = technologyBidManagerBusinessTrip;
      return this;
   }

   public CrmProjectInformationWarehousing setTechnologyBidManagerCustomerReception(final String technologyBidManagerCustomerReception) {
      this.technologyBidManagerCustomerReception = technologyBidManagerCustomerReception;
      return this;
   }

   public CrmProjectInformationWarehousing setTechnologyBidManagerRemarks(final String technologyBidManagerRemarks) {
      this.technologyBidManagerRemarks = technologyBidManagerRemarks;
      return this;
   }

   public CrmProjectInformationWarehousing setTechnologyCrmProjectBidStatus(final Integer technologyCrmProjectBidStatus) {
      this.technologyCrmProjectBidStatus = technologyCrmProjectBidStatus;
      return this;
   }

   public CrmProjectInformationWarehousing setSealContractAttachmentIds(final String sealContractAttachmentIds) {
      this.sealContractAttachmentIds = sealContractAttachmentIds;
      return this;
   }

   public CrmProjectInformationWarehousing setCrmCountryTypeEnum(final Integer crmCountryTypeEnum) {
      this.crmCountryTypeEnum = crmCountryTypeEnum;
      return this;
   }

   public CrmProjectInformationWarehousing setAUnitClassConfigurationId(final Long aUnitClassConfigurationId) {
      this.aUnitClassConfigurationId = aUnitClassConfigurationId;
      return this;
   }

   public CrmProjectInformationWarehousing setAUnitClassConfigurationContactName(final String aUnitClassConfigurationContactName) {
      this.aUnitClassConfigurationContactName = aUnitClassConfigurationContactName;
      return this;
   }

   public CrmProjectInformationWarehousing setAUnitClassConfigurationOffice(final String aUnitClassConfigurationOffice) {
      this.aUnitClassConfigurationOffice = aUnitClassConfigurationOffice;
      return this;
   }

   public CrmProjectInformationWarehousing setAUnitClassConfigurationPhone(final String aUnitClassConfigurationPhone) {
      this.aUnitClassConfigurationPhone = aUnitClassConfigurationPhone;
      return this;
   }

   public CrmProjectInformationWarehousing setBUnitClassConfigurationId(final Long bUnitClassConfigurationId) {
      this.bUnitClassConfigurationId = bUnitClassConfigurationId;
      return this;
   }

   public CrmProjectInformationWarehousing setBUnitClassConfigurationContactName(final String bUnitClassConfigurationContactName) {
      this.bUnitClassConfigurationContactName = bUnitClassConfigurationContactName;
      return this;
   }

   public CrmProjectInformationWarehousing setBUnitClassConfigurationOffice(final String bUnitClassConfigurationOffice) {
      this.bUnitClassConfigurationOffice = bUnitClassConfigurationOffice;
      return this;
   }

   public CrmProjectInformationWarehousing setBUnitClassConfigurationPhone(final String bUnitClassConfigurationPhone) {
      this.bUnitClassConfigurationPhone = bUnitClassConfigurationPhone;
      return this;
   }

   public CrmProjectInformationWarehousing setCUnitClassConfigurationId(final Long cUnitClassConfigurationId) {
      this.cUnitClassConfigurationId = cUnitClassConfigurationId;
      return this;
   }

   public CrmProjectInformationWarehousing setCUnitClassConfigurationContactName(final String cUnitClassConfigurationContactName) {
      this.cUnitClassConfigurationContactName = cUnitClassConfigurationContactName;
      return this;
   }

   public CrmProjectInformationWarehousing setCUnitClassConfigurationOffice(final String cUnitClassConfigurationOffice) {
      this.cUnitClassConfigurationOffice = cUnitClassConfigurationOffice;
      return this;
   }

   public CrmProjectInformationWarehousing setCUnitClassConfigurationPhone(final String cUnitClassConfigurationPhone) {
      this.cUnitClassConfigurationPhone = cUnitClassConfigurationPhone;
      return this;
   }

   public CrmProjectInformationWarehousing setDUnitClassConfigurationId(final Long dUnitClassConfigurationId) {
      this.dUnitClassConfigurationId = dUnitClassConfigurationId;
      return this;
   }

   public CrmProjectInformationWarehousing setDUnitClassConfigurationContactName(final String dUnitClassConfigurationContactName) {
      this.dUnitClassConfigurationContactName = dUnitClassConfigurationContactName;
      return this;
   }

   public CrmProjectInformationWarehousing setDUnitClassConfigurationOffice(final String dUnitClassConfigurationOffice) {
      this.dUnitClassConfigurationOffice = dUnitClassConfigurationOffice;
      return this;
   }

   public CrmProjectInformationWarehousing setDUnitClassConfigurationPhone(final String dUnitClassConfigurationPhone) {
      this.dUnitClassConfigurationPhone = dUnitClassConfigurationPhone;
      return this;
   }

   public CrmProjectInformationWarehousing setEUnitClassConfigurationId(final Long eUnitClassConfigurationId) {
      this.eUnitClassConfigurationId = eUnitClassConfigurationId;
      return this;
   }

   public CrmProjectInformationWarehousing setEUnitClassConfigurationContactName(final String eUnitClassConfigurationContactName) {
      this.eUnitClassConfigurationContactName = eUnitClassConfigurationContactName;
      return this;
   }

   public CrmProjectInformationWarehousing setEUnitClassConfigurationOffice(final String eUnitClassConfigurationOffice) {
      this.eUnitClassConfigurationOffice = eUnitClassConfigurationOffice;
      return this;
   }

   public CrmProjectInformationWarehousing setEUnitClassConfigurationPhone(final String eUnitClassConfigurationPhone) {
      this.eUnitClassConfigurationPhone = eUnitClassConfigurationPhone;
      return this;
   }

   public CrmProjectInformationWarehousing setInfoSource(final String infoSource) {
      this.infoSource = infoSource;
      return this;
   }

   public CrmProjectInformationWarehousing setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
      return this;
   }

   public CrmProjectInformationWarehousing setIsProjectManagerCoordinate(final Boolean isProjectManagerCoordinate) {
      this.isProjectManagerCoordinate = isProjectManagerCoordinate;
      return this;
   }

   public CrmProjectInformationWarehousing setCrmSettlementBusinessTypeEnum(final Integer crmSettlementBusinessTypeEnum) {
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
      return this;
   }

   public CrmProjectInformationWarehousing setLastDistributionTime(final LocalDateTime lastDistributionTime) {
      this.lastDistributionTime = lastDistributionTime;
      return this;
   }

   @Override
   public String toString() {
      return "CrmProjectInformationWarehousing(id="
         + this.getId()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", departmentId="
         + this.getDepartmentId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", createUserId="
         + this.getCreateUserId()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", projectName="
         + this.getProjectName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", typeOfContractorId="
         + this.getTypeOfContractorId()
         + ", keyProjectId="
         + this.getKeyProjectId()
         + ", itemCategoryId="
         + this.getItemCategoryId()
         + ", configurationOfArchitecturalFormId="
         + this.getConfigurationOfArchitecturalFormId()
         + ", structureTypeConfigurationId="
         + this.getStructureTypeConfigurationId()
         + ", industryConfigurationId="
         + this.getIndustryConfigurationId()
         + ", countryId="
         + this.getCountryId()
         + ", countryName="
         + this.getCountryName()
         + ", provinceId="
         + this.getProvinceId()
         + ", provinceName="
         + this.getProvinceName()
         + ", cityId="
         + this.getCityId()
         + ", cityName="
         + this.getCityName()
         + ", regionId="
         + this.getRegionId()
         + ", regionName="
         + this.getRegionName()
         + ", address="
         + this.getAddress()
         + ", projectOverview="
         + this.getProjectOverview()
         + ", estimatedWorks="
         + this.getEstimatedWorks()
         + ", estimatedCost="
         + this.getEstimatedCost()
         + ", areaOfStructure="
         + this.getAreaOfStructure()
         + ", biddingMethodId="
         + this.getBiddingMethodId()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", projectLevelConfigId="
         + this.getProjectLevelConfigId()
         + ", projectAttachments="
         + this.getProjectAttachments()
         + ", remark="
         + this.getRemark()
         + ", crmProjectScheduleTypeEnum="
         + this.getCrmProjectScheduleTypeEnum()
         + ", validityOfRegistration="
         + this.getValidityOfRegistration()
         + ", informationOperatorUserId="
         + this.getInformationOperatorUserId()
         + ", informationOperatorDeptId="
         + this.getInformationOperatorDeptId()
         + ", isBiddingMethod="
         + this.getIsBiddingMethod()
         + ", isSettlementMethod="
         + this.getIsSettlementMethod()
         + ", isTypeOfPerformanceBond="
         + this.getIsTypeOfPerformanceBond()
         + ", businessProjectBidManagerUserId="
         + this.getBusinessProjectBidManagerUserId()
         + ", businessProjectBidManagerFinishDate="
         + this.getBusinessProjectBidManagerFinishDate()
         + ", businessProjectBidManagerActualFinishDate="
         + this.getBusinessProjectBidManagerActualFinishDate()
         + ", businessProjectBidManagerQuote="
         + this.getBusinessProjectBidManagerQuote()
         + ", businessProjectBidManagerEstimatedWorks="
         + this.getBusinessProjectBidManagerEstimatedWorks()
         + ", businessProjectBidManagerCost="
         + this.getBusinessProjectBidManagerCost()
         + ", businessProjectBidManagerGrossProfit="
         + this.getBusinessProjectBidManagerGrossProfit()
         + ", businessProjectBidManagerRemark="
         + this.getBusinessProjectBidManagerRemark()
         + ", businessDifficultyFactorId="
         + this.getBusinessDifficultyFactorId()
         + ", businessBidManagerAttachmentIds="
         + this.getBusinessBidManagerAttachmentIds()
         + ", businessCrmProjectBidStatus="
         + this.getBusinessCrmProjectBidStatus()
         + ", deviseProjectBidManagerUserId="
         + this.getDeviseProjectBidManagerUserId()
         + ", deviseProjectBidManagerFinishDate="
         + this.getDeviseProjectBidManagerFinishDate()
         + ", deviseProjectBidManagerActualFinishDate="
         + this.getDeviseProjectBidManagerActualFinishDate()
         + ", deviseDifficultyFactorId="
         + this.getDeviseDifficultyFactorId()
         + ", deviseBidManagerAttachmentIds="
         + this.getDeviseBidManagerAttachmentIds()
         + ", deviseCrmProjectBidStatus="
         + this.getDeviseCrmProjectBidStatus()
         + ", technologyProjectBidManagerUserId="
         + this.getTechnologyProjectBidManagerUserId()
         + ", technologyProjectBidManagerFinishDate="
         + this.getTechnologyProjectBidManagerFinishDate()
         + ", technologyProjectBidManagerActualFinishDate="
         + this.getTechnologyProjectBidManagerActualFinishDate()
         + ", technologyDifficultyFactorId="
         + this.getTechnologyDifficultyFactorId()
         + ", technologyBidManagerAttachmentIds="
         + this.getTechnologyBidManagerAttachmentIds()
         + ", technologyBidManagerJobDescriptionId="
         + this.getTechnologyBidManagerJobDescriptionId()
         + ", technologyBidManagerRenderings="
         + this.getTechnologyBidManagerRenderings()
         + ", technologyBidManagerStructureName="
         + this.getTechnologyBidManagerStructureName()
         + ", technologyBidManagerCompletion="
         + this.getTechnologyBidManagerCompletion()
         + ", technologyBidManagerBusinessTrip="
         + this.getTechnologyBidManagerBusinessTrip()
         + ", technologyBidManagerCustomerReception="
         + this.getTechnologyBidManagerCustomerReception()
         + ", technologyBidManagerRemarks="
         + this.getTechnologyBidManagerRemarks()
         + ", technologyCrmProjectBidStatus="
         + this.getTechnologyCrmProjectBidStatus()
         + ", sealContractAttachmentIds="
         + this.getSealContractAttachmentIds()
         + ", crmCountryTypeEnum="
         + this.getCrmCountryTypeEnum()
         + ", aUnitClassConfigurationId="
         + this.getAUnitClassConfigurationId()
         + ", aUnitClassConfigurationContactName="
         + this.getAUnitClassConfigurationContactName()
         + ", aUnitClassConfigurationOffice="
         + this.getAUnitClassConfigurationOffice()
         + ", aUnitClassConfigurationPhone="
         + this.getAUnitClassConfigurationPhone()
         + ", bUnitClassConfigurationId="
         + this.getBUnitClassConfigurationId()
         + ", bUnitClassConfigurationContactName="
         + this.getBUnitClassConfigurationContactName()
         + ", bUnitClassConfigurationOffice="
         + this.getBUnitClassConfigurationOffice()
         + ", bUnitClassConfigurationPhone="
         + this.getBUnitClassConfigurationPhone()
         + ", cUnitClassConfigurationId="
         + this.getCUnitClassConfigurationId()
         + ", cUnitClassConfigurationContactName="
         + this.getCUnitClassConfigurationContactName()
         + ", cUnitClassConfigurationOffice="
         + this.getCUnitClassConfigurationOffice()
         + ", cUnitClassConfigurationPhone="
         + this.getCUnitClassConfigurationPhone()
         + ", dUnitClassConfigurationId="
         + this.getDUnitClassConfigurationId()
         + ", dUnitClassConfigurationContactName="
         + this.getDUnitClassConfigurationContactName()
         + ", dUnitClassConfigurationOffice="
         + this.getDUnitClassConfigurationOffice()
         + ", dUnitClassConfigurationPhone="
         + this.getDUnitClassConfigurationPhone()
         + ", eUnitClassConfigurationId="
         + this.getEUnitClassConfigurationId()
         + ", eUnitClassConfigurationContactName="
         + this.getEUnitClassConfigurationContactName()
         + ", eUnitClassConfigurationOffice="
         + this.getEUnitClassConfigurationOffice()
         + ", eUnitClassConfigurationPhone="
         + this.getEUnitClassConfigurationPhone()
         + ", infoSource="
         + this.getInfoSource()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", isProjectManagerCoordinate="
         + this.getIsProjectManagerCoordinate()
         + ", crmSettlementBusinessTypeEnum="
         + this.getCrmSettlementBusinessTypeEnum()
         + ", lastDistributionTime="
         + this.getLastDistributionTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectInformationWarehousing)) {
         return false;
      }

      CrmProjectInformationWarehousing other = (CrmProjectInformationWarehousing)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$informantUserId = this.getInformantUserId();
         Object other$informantUserId = other.getInformantUserId();
         if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
            Object this$departmentId = this.getDepartmentId();
            Object other$departmentId = other.getDepartmentId();
            if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
               Object this$createUserId = this.getCreateUserId();
               Object other$createUserId = other.getCreateUserId();
               if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                  Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
                  Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
                  if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
                     Object this$approveRecordId = this.getApproveRecordId();
                     Object other$approveRecordId = other.getApproveRecordId();
                     if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                        Object this$typeOfContractorId = this.getTypeOfContractorId();
                        Object other$typeOfContractorId = other.getTypeOfContractorId();
                        if (this$typeOfContractorId == null ? other$typeOfContractorId == null : this$typeOfContractorId.equals(other$typeOfContractorId)) {
                           Object this$keyProjectId = this.getKeyProjectId();
                           Object other$keyProjectId = other.getKeyProjectId();
                           if (this$keyProjectId == null ? other$keyProjectId == null : this$keyProjectId.equals(other$keyProjectId)) {
                              Object this$itemCategoryId = this.getItemCategoryId();
                              Object other$itemCategoryId = other.getItemCategoryId();
                              if (this$itemCategoryId == null ? other$itemCategoryId == null : this$itemCategoryId.equals(other$itemCategoryId)) {
                                 Object this$configurationOfArchitecturalFormId = this.getConfigurationOfArchitecturalFormId();
                                 Object other$configurationOfArchitecturalFormId = other.getConfigurationOfArchitecturalFormId();
                                 if (this$configurationOfArchitecturalFormId == null
                                    ? other$configurationOfArchitecturalFormId == null
                                    : this$configurationOfArchitecturalFormId.equals(other$configurationOfArchitecturalFormId)) {
                                    Object this$structureTypeConfigurationId = this.getStructureTypeConfigurationId();
                                    Object other$structureTypeConfigurationId = other.getStructureTypeConfigurationId();
                                    if (this$structureTypeConfigurationId == null
                                       ? other$structureTypeConfigurationId == null
                                       : this$structureTypeConfigurationId.equals(other$structureTypeConfigurationId)) {
                                       Object this$industryConfigurationId = this.getIndustryConfigurationId();
                                       Object other$industryConfigurationId = other.getIndustryConfigurationId();
                                       if (this$industryConfigurationId == null
                                          ? other$industryConfigurationId == null
                                          : this$industryConfigurationId.equals(other$industryConfigurationId)) {
                                          Object this$countryId = this.getCountryId();
                                          Object other$countryId = other.getCountryId();
                                          if (this$countryId == null ? other$countryId == null : this$countryId.equals(other$countryId)) {
                                             Object this$provinceId = this.getProvinceId();
                                             Object other$provinceId = other.getProvinceId();
                                             if (this$provinceId == null ? other$provinceId == null : this$provinceId.equals(other$provinceId)) {
                                                Object this$cityId = this.getCityId();
                                                Object other$cityId = other.getCityId();
                                                if (this$cityId == null ? other$cityId == null : this$cityId.equals(other$cityId)) {
                                                   Object this$regionId = this.getRegionId();
                                                   Object other$regionId = other.getRegionId();
                                                   if (this$regionId == null ? other$regionId == null : this$regionId.equals(other$regionId)) {
                                                      Object this$biddingMethodId = this.getBiddingMethodId();
                                                      Object other$biddingMethodId = other.getBiddingMethodId();
                                                      if (this$biddingMethodId == null
                                                         ? other$biddingMethodId == null
                                                         : this$biddingMethodId.equals(other$biddingMethodId)) {
                                                         Object this$crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
                                                         Object other$crmEnterpriseWarehousingId = other.getCrmEnterpriseWarehousingId();
                                                         if (this$crmEnterpriseWarehousingId == null
                                                            ? other$crmEnterpriseWarehousingId == null
                                                            : this$crmEnterpriseWarehousingId.equals(other$crmEnterpriseWarehousingId)) {
                                                            Object this$projectLevelConfigId = this.getProjectLevelConfigId();
                                                            Object other$projectLevelConfigId = other.getProjectLevelConfigId();
                                                            if (this$projectLevelConfigId == null
                                                               ? other$projectLevelConfigId == null
                                                               : this$projectLevelConfigId.equals(other$projectLevelConfigId)) {
                                                               Object this$crmProjectScheduleTypeEnum = this.getCrmProjectScheduleTypeEnum();
                                                               Object other$crmProjectScheduleTypeEnum = other.getCrmProjectScheduleTypeEnum();
                                                               if (this$crmProjectScheduleTypeEnum == null
                                                                  ? other$crmProjectScheduleTypeEnum == null
                                                                  : this$crmProjectScheduleTypeEnum.equals(other$crmProjectScheduleTypeEnum)) {
                                                                  Object this$validityOfRegistration = this.getValidityOfRegistration();
                                                                  Object other$validityOfRegistration = other.getValidityOfRegistration();
                                                                  if (this$validityOfRegistration == null
                                                                     ? other$validityOfRegistration == null
                                                                     : this$validityOfRegistration.equals(other$validityOfRegistration)) {
                                                                     Object this$informationOperatorUserId = this.getInformationOperatorUserId();
                                                                     Object other$informationOperatorUserId = other.getInformationOperatorUserId();
                                                                     if (this$informationOperatorUserId == null
                                                                        ? other$informationOperatorUserId == null
                                                                        : this$informationOperatorUserId.equals(other$informationOperatorUserId)) {
                                                                        Object this$informationOperatorDeptId = this.getInformationOperatorDeptId();
                                                                        Object other$informationOperatorDeptId = other.getInformationOperatorDeptId();
                                                                        if (this$informationOperatorDeptId == null
                                                                           ? other$informationOperatorDeptId == null
                                                                           : this$informationOperatorDeptId.equals(other$informationOperatorDeptId)) {
                                                                           Object this$isBiddingMethod = this.getIsBiddingMethod();
                                                                           Object other$isBiddingMethod = other.getIsBiddingMethod();
                                                                           if (this$isBiddingMethod == null
                                                                              ? other$isBiddingMethod == null
                                                                              : this$isBiddingMethod.equals(other$isBiddingMethod)) {
                                                                              Object this$isSettlementMethod = this.getIsSettlementMethod();
                                                                              Object other$isSettlementMethod = other.getIsSettlementMethod();
                                                                              if (this$isSettlementMethod == null
                                                                                 ? other$isSettlementMethod == null
                                                                                 : this$isSettlementMethod.equals(other$isSettlementMethod)) {
                                                                                 Object this$isTypeOfPerformanceBond = this.getIsTypeOfPerformanceBond();
                                                                                 Object other$isTypeOfPerformanceBond = other.getIsTypeOfPerformanceBond();
                                                                                 if (this$isTypeOfPerformanceBond == null
                                                                                    ? other$isTypeOfPerformanceBond == null
                                                                                    : this$isTypeOfPerformanceBond.equals(other$isTypeOfPerformanceBond)) {
                                                                                    Object this$businessDifficultyFactorId = this.getBusinessDifficultyFactorId();
                                                                                    Object other$businessDifficultyFactorId = other.getBusinessDifficultyFactorId();
                                                                                    if (this$businessDifficultyFactorId == null
                                                                                       ? other$businessDifficultyFactorId == null
                                                                                       : this$businessDifficultyFactorId.equals(
                                                                                          other$businessDifficultyFactorId
                                                                                       )) {
                                                                                       Object this$businessCrmProjectBidStatus = this.getBusinessCrmProjectBidStatus();
                                                                                       Object other$businessCrmProjectBidStatus = other.getBusinessCrmProjectBidStatus();
                                                                                       if (this$businessCrmProjectBidStatus == null
                                                                                          ? other$businessCrmProjectBidStatus == null
                                                                                          : this$businessCrmProjectBidStatus.equals(
                                                                                             other$businessCrmProjectBidStatus
                                                                                          )) {
                                                                                          Object this$deviseDifficultyFactorId = this.getDeviseDifficultyFactorId();
                                                                                          Object other$deviseDifficultyFactorId = other.getDeviseDifficultyFactorId();
                                                                                          if (this$deviseDifficultyFactorId == null
                                                                                             ? other$deviseDifficultyFactorId == null
                                                                                             : this$deviseDifficultyFactorId.equals(
                                                                                                other$deviseDifficultyFactorId
                                                                                             )) {
                                                                                             Object this$deviseCrmProjectBidStatus = this.getDeviseCrmProjectBidStatus();
                                                                                             Object other$deviseCrmProjectBidStatus = other.getDeviseCrmProjectBidStatus();
                                                                                             if (this$deviseCrmProjectBidStatus == null
                                                                                                ? other$deviseCrmProjectBidStatus == null
                                                                                                : this$deviseCrmProjectBidStatus.equals(
                                                                                                   other$deviseCrmProjectBidStatus
                                                                                                )) {
                                                                                                Object this$technologyDifficultyFactorId = this.getTechnologyDifficultyFactorId();
                                                                                                Object other$technologyDifficultyFactorId = other.getTechnologyDifficultyFactorId();
                                                                                                if (this$technologyDifficultyFactorId == null
                                                                                                   ? other$technologyDifficultyFactorId == null
                                                                                                   : this$technologyDifficultyFactorId.equals(
                                                                                                      other$technologyDifficultyFactorId
                                                                                                   )) {
                                                                                                   Object this$technologyBidManagerJobDescriptionId = this.getTechnologyBidManagerJobDescriptionId();
                                                                                                   Object other$technologyBidManagerJobDescriptionId = other.getTechnologyBidManagerJobDescriptionId();
                                                                                                   if (this$technologyBidManagerJobDescriptionId == null
                                                                                                      ? other$technologyBidManagerJobDescriptionId == null
                                                                                                      : this$technologyBidManagerJobDescriptionId.equals(
                                                                                                         other$technologyBidManagerJobDescriptionId
                                                                                                      )) {
                                                                                                      Object this$technologyCrmProjectBidStatus = this.getTechnologyCrmProjectBidStatus();
                                                                                                      Object other$technologyCrmProjectBidStatus = other.getTechnologyCrmProjectBidStatus();
                                                                                                      if (this$technologyCrmProjectBidStatus == null
                                                                                                         ? other$technologyCrmProjectBidStatus == null
                                                                                                         : this$technologyCrmProjectBidStatus.equals(
                                                                                                            other$technologyCrmProjectBidStatus
                                                                                                         )) {
                                                                                                         Object this$crmCountryTypeEnum = this.getCrmCountryTypeEnum();
                                                                                                         Object other$crmCountryTypeEnum = other.getCrmCountryTypeEnum();
                                                                                                         if (this$crmCountryTypeEnum == null
                                                                                                            ? other$crmCountryTypeEnum == null
                                                                                                            : this$crmCountryTypeEnum.equals(
                                                                                                               other$crmCountryTypeEnum
                                                                                                            )) {
                                                                                                            Object this$aUnitClassConfigurationId = this.getAUnitClassConfigurationId();
                                                                                                            Object other$aUnitClassConfigurationId = other.getAUnitClassConfigurationId();
                                                                                                            if (this$aUnitClassConfigurationId == null
                                                                                                               ? other$aUnitClassConfigurationId == null
                                                                                                               : this$aUnitClassConfigurationId.equals(
                                                                                                                  other$aUnitClassConfigurationId
                                                                                                               )) {
                                                                                                               Object this$bUnitClassConfigurationId = this.getBUnitClassConfigurationId();
                                                                                                               Object other$bUnitClassConfigurationId = other.getBUnitClassConfigurationId();
                                                                                                               if (this$bUnitClassConfigurationId == null
                                                                                                                  ? other$bUnitClassConfigurationId == null
                                                                                                                  : this$bUnitClassConfigurationId.equals(
                                                                                                                     other$bUnitClassConfigurationId
                                                                                                                  )) {
                                                                                                                  Object this$cUnitClassConfigurationId = this.getCUnitClassConfigurationId();
                                                                                                                  Object other$cUnitClassConfigurationId = other.getCUnitClassConfigurationId();
                                                                                                                  if (this$cUnitClassConfigurationId == null
                                                                                                                     ? other$cUnitClassConfigurationId == null
                                                                                                                     : this$cUnitClassConfigurationId.equals(
                                                                                                                        other$cUnitClassConfigurationId
                                                                                                                     )) {
                                                                                                                     Object this$dUnitClassConfigurationId = this.getDUnitClassConfigurationId();
                                                                                                                     Object other$dUnitClassConfigurationId = other.getDUnitClassConfigurationId();
                                                                                                                     if (this$dUnitClassConfigurationId == null
                                                                                                                        ? other$dUnitClassConfigurationId
                                                                                                                           == null
                                                                                                                        : this$dUnitClassConfigurationId.equals(
                                                                                                                           other$dUnitClassConfigurationId
                                                                                                                        )) {
                                                                                                                        Object this$eUnitClassConfigurationId = this.getEUnitClassConfigurationId();
                                                                                                                        Object other$eUnitClassConfigurationId = other.getEUnitClassConfigurationId();
                                                                                                                        if (this$eUnitClassConfigurationId
                                                                                                                              == null
                                                                                                                           ? other$eUnitClassConfigurationId
                                                                                                                              == null
                                                                                                                           : this$eUnitClassConfigurationId.equals(
                                                                                                                              other$eUnitClassConfigurationId
                                                                                                                           )) {
                                                                                                                           Object this$isProjectManagerCoordinate = this.getIsProjectManagerCoordinate();
                                                                                                                           Object other$isProjectManagerCoordinate = other.getIsProjectManagerCoordinate();
                                                                                                                           if (this$isProjectManagerCoordinate
                                                                                                                                 == null
                                                                                                                              ? other$isProjectManagerCoordinate
                                                                                                                                 == null
                                                                                                                              : this$isProjectManagerCoordinate.equals(
                                                                                                                                 other$isProjectManagerCoordinate
                                                                                                                              )) {
                                                                                                                              Object this$crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
                                                                                                                              Object other$crmSettlementBusinessTypeEnum = other.getCrmSettlementBusinessTypeEnum();
                                                                                                                              if (this$crmSettlementBusinessTypeEnum
                                                                                                                                    == null
                                                                                                                                 ? other$crmSettlementBusinessTypeEnum
                                                                                                                                    == null
                                                                                                                                 : this$crmSettlementBusinessTypeEnum.equals(
                                                                                                                                    other$crmSettlementBusinessTypeEnum
                                                                                                                                 )) {
                                                                                                                                 Object this$informantUserName = this.getInformantUserName();
                                                                                                                                 Object other$informantUserName = other.getInformantUserName();
                                                                                                                                 if (this$informantUserName
                                                                                                                                       == null
                                                                                                                                    ? other$informantUserName
                                                                                                                                       == null
                                                                                                                                    : this$informantUserName.equals(
                                                                                                                                       other$informantUserName
                                                                                                                                    )) {
                                                                                                                                    Object this$informantDateTime = this.getInformantDateTime();
                                                                                                                                    Object other$informantDateTime = other.getInformantDateTime();
                                                                                                                                    if (this$informantDateTime
                                                                                                                                          == null
                                                                                                                                       ? other$informantDateTime
                                                                                                                                          == null
                                                                                                                                       : this$informantDateTime.equals(
                                                                                                                                          other$informantDateTime
                                                                                                                                       )) {
                                                                                                                                       Object this$projectName = this.getProjectName();
                                                                                                                                       Object other$projectName = other.getProjectName();
                                                                                                                                       if (this$projectName
                                                                                                                                             == null
                                                                                                                                          ? other$projectName
                                                                                                                                             == null
                                                                                                                                          : this$projectName.equals(
                                                                                                                                             other$projectName
                                                                                                                                          )) {
                                                                                                                                          Object this$serialNumber = this.getSerialNumber();
                                                                                                                                          Object other$serialNumber = other.getSerialNumber();
                                                                                                                                          if (this$serialNumber
                                                                                                                                                == null
                                                                                                                                             ? other$serialNumber
                                                                                                                                                == null
                                                                                                                                             : this$serialNumber.equals(
                                                                                                                                                other$serialNumber
                                                                                                                                             )) {
                                                                                                                                             Object this$projectSerialNumber = this.getProjectSerialNumber();
                                                                                                                                             Object other$projectSerialNumber = other.getProjectSerialNumber();
                                                                                                                                             if (this$projectSerialNumber
                                                                                                                                                   == null
                                                                                                                                                ? other$projectSerialNumber
                                                                                                                                                   == null
                                                                                                                                                : this$projectSerialNumber.equals(
                                                                                                                                                   other$projectSerialNumber
                                                                                                                                                )) {
                                                                                                                                                Object this$countryName = this.getCountryName();
                                                                                                                                                Object other$countryName = other.getCountryName();
                                                                                                                                                if (this$countryName
                                                                                                                                                      == null
                                                                                                                                                   ? other$countryName
                                                                                                                                                      == null
                                                                                                                                                   : this$countryName.equals(
                                                                                                                                                      other$countryName
                                                                                                                                                   )) {
                                                                                                                                                   Object this$provinceName = this.getProvinceName();
                                                                                                                                                   Object other$provinceName = other.getProvinceName();
                                                                                                                                                   if (this$provinceName
                                                                                                                                                         == null
                                                                                                                                                      ? other$provinceName
                                                                                                                                                         == null
                                                                                                                                                      : this$provinceName.equals(
                                                                                                                                                         other$provinceName
                                                                                                                                                      )) {
                                                                                                                                                      Object this$cityName = this.getCityName();
                                                                                                                                                      Object other$cityName = other.getCityName();
                                                                                                                                                      if (this$cityName
                                                                                                                                                            == null
                                                                                                                                                         ? other$cityName
                                                                                                                                                            == null
                                                                                                                                                         : this$cityName.equals(
                                                                                                                                                            other$cityName
                                                                                                                                                         )) {
                                                                                                                                                         Object this$regionName = this.getRegionName();
                                                                                                                                                         Object other$regionName = other.getRegionName();
                                                                                                                                                         if (this$regionName
                                                                                                                                                               == null
                                                                                                                                                            ? other$regionName
                                                                                                                                                               == null
                                                                                                                                                            : this$regionName.equals(
                                                                                                                                                               other$regionName
                                                                                                                                                            )) {
                                                                                                                                                            Object this$address = this.getAddress();
                                                                                                                                                            Object other$address = other.getAddress();
                                                                                                                                                            if (this$address
                                                                                                                                                                  == null
                                                                                                                                                               ? other$address
                                                                                                                                                                  == null
                                                                                                                                                               : this$address.equals(
                                                                                                                                                                  other$address
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$projectOverview = this.getProjectOverview();
                                                                                                                                                               Object other$projectOverview = other.getProjectOverview();
                                                                                                                                                               if (this$projectOverview
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$projectOverview
                                                                                                                                                                     == null
                                                                                                                                                                  : this$projectOverview.equals(
                                                                                                                                                                     other$projectOverview
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$estimatedWorks = this.getEstimatedWorks();
                                                                                                                                                                  Object other$estimatedWorks = other.getEstimatedWorks();
                                                                                                                                                                  if (this$estimatedWorks
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$estimatedWorks
                                                                                                                                                                        == null
                                                                                                                                                                     : this$estimatedWorks.equals(
                                                                                                                                                                        other$estimatedWorks
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$estimatedCost = this.getEstimatedCost();
                                                                                                                                                                     Object other$estimatedCost = other.getEstimatedCost();
                                                                                                                                                                     if (this$estimatedCost
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$estimatedCost
                                                                                                                                                                           == null
                                                                                                                                                                        : this$estimatedCost.equals(
                                                                                                                                                                           other$estimatedCost
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$areaOfStructure = this.getAreaOfStructure();
                                                                                                                                                                        Object other$areaOfStructure = other.getAreaOfStructure();
                                                                                                                                                                        if (this$areaOfStructure
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$areaOfStructure
                                                                                                                                                                              == null
                                                                                                                                                                           : this$areaOfStructure.equals(
                                                                                                                                                                              other$areaOfStructure
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$projectAttachments = this.getProjectAttachments();
                                                                                                                                                                           Object other$projectAttachments = other.getProjectAttachments();
                                                                                                                                                                           if (this$projectAttachments
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$projectAttachments
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$projectAttachments.equals(
                                                                                                                                                                                 other$projectAttachments
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$remark = this.getRemark();
                                                                                                                                                                              Object other$remark = other.getRemark();
                                                                                                                                                                              if (this$remark
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$remark
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$remark.equals(
                                                                                                                                                                                    other$remark
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$businessProjectBidManagerUserId = this.getBusinessProjectBidManagerUserId();
                                                                                                                                                                                 Object other$businessProjectBidManagerUserId = other.getBusinessProjectBidManagerUserId();
                                                                                                                                                                                 if (this$businessProjectBidManagerUserId
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$businessProjectBidManagerUserId
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$businessProjectBidManagerUserId.equals(
                                                                                                                                                                                       other$businessProjectBidManagerUserId
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$businessProjectBidManagerFinishDate = this.getBusinessProjectBidManagerFinishDate();
                                                                                                                                                                                    Object other$businessProjectBidManagerFinishDate = other.getBusinessProjectBidManagerFinishDate();
                                                                                                                                                                                    if (this$businessProjectBidManagerFinishDate
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$businessProjectBidManagerFinishDate
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$businessProjectBidManagerFinishDate.equals(
                                                                                                                                                                                          other$businessProjectBidManagerFinishDate
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$businessProjectBidManagerActualFinishDate = this.getBusinessProjectBidManagerActualFinishDate();
                                                                                                                                                                                       Object other$businessProjectBidManagerActualFinishDate = other.getBusinessProjectBidManagerActualFinishDate();
                                                                                                                                                                                       if (this$businessProjectBidManagerActualFinishDate
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$businessProjectBidManagerActualFinishDate
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$businessProjectBidManagerActualFinishDate.equals(
                                                                                                                                                                                             other$businessProjectBidManagerActualFinishDate
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Object this$businessProjectBidManagerQuote = this.getBusinessProjectBidManagerQuote();
                                                                                                                                                                                          Object other$businessProjectBidManagerQuote = other.getBusinessProjectBidManagerQuote();
                                                                                                                                                                                          if (this$businessProjectBidManagerQuote
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$businessProjectBidManagerQuote
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$businessProjectBidManagerQuote.equals(
                                                                                                                                                                                                other$businessProjectBidManagerQuote
                                                                                                                                                                                             )
                                                                                                                                                                                             )
                                                                                                                                                                                           {
                                                                                                                                                                                             Object this$businessProjectBidManagerEstimatedWorks = this.getBusinessProjectBidManagerEstimatedWorks();
                                                                                                                                                                                             Object other$businessProjectBidManagerEstimatedWorks = other.getBusinessProjectBidManagerEstimatedWorks();
                                                                                                                                                                                             if (this$businessProjectBidManagerEstimatedWorks
                                                                                                                                                                                                   == null
                                                                                                                                                                                                ? other$businessProjectBidManagerEstimatedWorks
                                                                                                                                                                                                   == null
                                                                                                                                                                                                : this$businessProjectBidManagerEstimatedWorks.equals(
                                                                                                                                                                                                   other$businessProjectBidManagerEstimatedWorks
                                                                                                                                                                                                )
                                                                                                                                                                                                )
                                                                                                                                                                                              {
                                                                                                                                                                                                Object this$businessProjectBidManagerCost = this.getBusinessProjectBidManagerCost();
                                                                                                                                                                                                Object other$businessProjectBidManagerCost = other.getBusinessProjectBidManagerCost();
                                                                                                                                                                                                if (this$businessProjectBidManagerCost
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   ? other$businessProjectBidManagerCost
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   : this$businessProjectBidManagerCost.equals(
                                                                                                                                                                                                      other$businessProjectBidManagerCost
                                                                                                                                                                                                   )
                                                                                                                                                                                                   )
                                                                                                                                                                                                 {
                                                                                                                                                                                                   Object this$businessProjectBidManagerGrossProfit = this.getBusinessProjectBidManagerGrossProfit();
                                                                                                                                                                                                   Object other$businessProjectBidManagerGrossProfit = other.getBusinessProjectBidManagerGrossProfit();
                                                                                                                                                                                                   if (this$businessProjectBidManagerGrossProfit
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      ? other$businessProjectBidManagerGrossProfit
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      : this$businessProjectBidManagerGrossProfit.equals(
                                                                                                                                                                                                         other$businessProjectBidManagerGrossProfit
                                                                                                                                                                                                      )
                                                                                                                                                                                                      )
                                                                                                                                                                                                    {
                                                                                                                                                                                                      Object this$businessProjectBidManagerRemark = this.getBusinessProjectBidManagerRemark();
                                                                                                                                                                                                      Object other$businessProjectBidManagerRemark = other.getBusinessProjectBidManagerRemark();
                                                                                                                                                                                                      if (this$businessProjectBidManagerRemark
                                                                                                                                                                                                            == null
                                                                                                                                                                                                         ? other$businessProjectBidManagerRemark
                                                                                                                                                                                                            == null
                                                                                                                                                                                                         : this$businessProjectBidManagerRemark.equals(
                                                                                                                                                                                                            other$businessProjectBidManagerRemark
                                                                                                                                                                                                         )
                                                                                                                                                                                                         )
                                                                                                                                                                                                       {
                                                                                                                                                                                                         Object this$businessBidManagerAttachmentIds = this.getBusinessBidManagerAttachmentIds();
                                                                                                                                                                                                         Object other$businessBidManagerAttachmentIds = other.getBusinessBidManagerAttachmentIds();
                                                                                                                                                                                                         if (this$businessBidManagerAttachmentIds
                                                                                                                                                                                                               == null
                                                                                                                                                                                                            ? other$businessBidManagerAttachmentIds
                                                                                                                                                                                                               == null
                                                                                                                                                                                                            : this$businessBidManagerAttachmentIds.equals(
                                                                                                                                                                                                               other$businessBidManagerAttachmentIds
                                                                                                                                                                                                            )
                                                                                                                                                                                                            )
                                                                                                                                                                                                          {
                                                                                                                                                                                                            Object this$deviseProjectBidManagerUserId = this.getDeviseProjectBidManagerUserId();
                                                                                                                                                                                                            Object other$deviseProjectBidManagerUserId = other.getDeviseProjectBidManagerUserId();
                                                                                                                                                                                                            if (this$deviseProjectBidManagerUserId
                                                                                                                                                                                                                  == null
                                                                                                                                                                                                               ? other$deviseProjectBidManagerUserId
                                                                                                                                                                                                                  == null
                                                                                                                                                                                                               : this$deviseProjectBidManagerUserId.equals(
                                                                                                                                                                                                                  other$deviseProjectBidManagerUserId
                                                                                                                                                                                                               )
                                                                                                                                                                                                               )
                                                                                                                                                                                                             {
                                                                                                                                                                                                               Object this$deviseProjectBidManagerFinishDate = this.getDeviseProjectBidManagerFinishDate();
                                                                                                                                                                                                               Object other$deviseProjectBidManagerFinishDate = other.getDeviseProjectBidManagerFinishDate();
                                                                                                                                                                                                               if (this$deviseProjectBidManagerFinishDate
                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                  ? other$deviseProjectBidManagerFinishDate
                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                  : this$deviseProjectBidManagerFinishDate.equals(
                                                                                                                                                                                                                     other$deviseProjectBidManagerFinishDate
                                                                                                                                                                                                                  )
                                                                                                                                                                                                                  )
                                                                                                                                                                                                                {
                                                                                                                                                                                                                  Object this$deviseProjectBidManagerActualFinishDate = this.getDeviseProjectBidManagerActualFinishDate();
                                                                                                                                                                                                                  Object other$deviseProjectBidManagerActualFinishDate = other.getDeviseProjectBidManagerActualFinishDate();
                                                                                                                                                                                                                  if (this$deviseProjectBidManagerActualFinishDate
                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                     ? other$deviseProjectBidManagerActualFinishDate
                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                     : this$deviseProjectBidManagerActualFinishDate.equals(
                                                                                                                                                                                                                        other$deviseProjectBidManagerActualFinishDate
                                                                                                                                                                                                                     )
                                                                                                                                                                                                                     )
                                                                                                                                                                                                                   {
                                                                                                                                                                                                                     Object this$deviseBidManagerAttachmentIds = this.getDeviseBidManagerAttachmentIds();
                                                                                                                                                                                                                     Object other$deviseBidManagerAttachmentIds = other.getDeviseBidManagerAttachmentIds();
                                                                                                                                                                                                                     if (this$deviseBidManagerAttachmentIds
                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                        ? other$deviseBidManagerAttachmentIds
                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                        : this$deviseBidManagerAttachmentIds.equals(
                                                                                                                                                                                                                           other$deviseBidManagerAttachmentIds
                                                                                                                                                                                                                        )
                                                                                                                                                                                                                        )
                                                                                                                                                                                                                      {
                                                                                                                                                                                                                        Object this$technologyProjectBidManagerUserId = this.getTechnologyProjectBidManagerUserId();
                                                                                                                                                                                                                        Object other$technologyProjectBidManagerUserId = other.getTechnologyProjectBidManagerUserId();
                                                                                                                                                                                                                        if (this$technologyProjectBidManagerUserId
                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                           ? other$technologyProjectBidManagerUserId
                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                           : this$technologyProjectBidManagerUserId.equals(
                                                                                                                                                                                                                              other$technologyProjectBidManagerUserId
                                                                                                                                                                                                                           )
                                                                                                                                                                                                                           )
                                                                                                                                                                                                                         {
                                                                                                                                                                                                                           Object this$technologyProjectBidManagerFinishDate = this.getTechnologyProjectBidManagerFinishDate();
                                                                                                                                                                                                                           Object other$technologyProjectBidManagerFinishDate = other.getTechnologyProjectBidManagerFinishDate();
                                                                                                                                                                                                                           if (this$technologyProjectBidManagerFinishDate
                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                              ? other$technologyProjectBidManagerFinishDate
                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                              : this$technologyProjectBidManagerFinishDate.equals(
                                                                                                                                                                                                                                 other$technologyProjectBidManagerFinishDate
                                                                                                                                                                                                                              )
                                                                                                                                                                                                                              )
                                                                                                                                                                                                                            {
                                                                                                                                                                                                                              Object this$technologyProjectBidManagerActualFinishDate = this.getTechnologyProjectBidManagerActualFinishDate();
                                                                                                                                                                                                                              Object other$technologyProjectBidManagerActualFinishDate = other.getTechnologyProjectBidManagerActualFinishDate();
                                                                                                                                                                                                                              if (this$technologyProjectBidManagerActualFinishDate
                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                 ? other$technologyProjectBidManagerActualFinishDate
                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                 : this$technologyProjectBidManagerActualFinishDate.equals(
                                                                                                                                                                                                                                    other$technologyProjectBidManagerActualFinishDate
                                                                                                                                                                                                                                 )
                                                                                                                                                                                                                                 )
                                                                                                                                                                                                                               {
                                                                                                                                                                                                                                 Object this$technologyBidManagerAttachmentIds = this.getTechnologyBidManagerAttachmentIds();
                                                                                                                                                                                                                                 Object other$technologyBidManagerAttachmentIds = other.getTechnologyBidManagerAttachmentIds();
                                                                                                                                                                                                                                 if (this$technologyBidManagerAttachmentIds
                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                    ? other$technologyBidManagerAttachmentIds
                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                    : this$technologyBidManagerAttachmentIds.equals(
                                                                                                                                                                                                                                       other$technologyBidManagerAttachmentIds
                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                  {
                                                                                                                                                                                                                                    Object this$technologyBidManagerRenderings = this.getTechnologyBidManagerRenderings();
                                                                                                                                                                                                                                    Object other$technologyBidManagerRenderings = other.getTechnologyBidManagerRenderings();
                                                                                                                                                                                                                                    if (this$technologyBidManagerRenderings
                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                       ? other$technologyBidManagerRenderings
                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                       : this$technologyBidManagerRenderings.equals(
                                                                                                                                                                                                                                          other$technologyBidManagerRenderings
                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                     {
                                                                                                                                                                                                                                       Object this$technologyBidManagerStructureName = this.getTechnologyBidManagerStructureName();
                                                                                                                                                                                                                                       Object other$technologyBidManagerStructureName = other.getTechnologyBidManagerStructureName();
                                                                                                                                                                                                                                       if (this$technologyBidManagerStructureName
                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                          ? other$technologyBidManagerStructureName
                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                          : this$technologyBidManagerStructureName.equals(
                                                                                                                                                                                                                                             other$technologyBidManagerStructureName
                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                        {
                                                                                                                                                                                                                                          Object this$technologyBidManagerCompletion = this.getTechnologyBidManagerCompletion();
                                                                                                                                                                                                                                          Object other$technologyBidManagerCompletion = other.getTechnologyBidManagerCompletion();
                                                                                                                                                                                                                                          if (this$technologyBidManagerCompletion
                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                             ? other$technologyBidManagerCompletion
                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                             : this$technologyBidManagerCompletion.equals(
                                                                                                                                                                                                                                                other$technologyBidManagerCompletion
                                                                                                                                                                                                                                             )
                                                                                                                                                                                                                                             )
                                                                                                                                                                                                                                           {
                                                                                                                                                                                                                                             Object this$technologyBidManagerBusinessTrip = this.getTechnologyBidManagerBusinessTrip();
                                                                                                                                                                                                                                             Object other$technologyBidManagerBusinessTrip = other.getTechnologyBidManagerBusinessTrip();
                                                                                                                                                                                                                                             if (this$technologyBidManagerBusinessTrip
                                                                                                                                                                                                                                                   == null
                                                                                                                                                                                                                                                ? other$technologyBidManagerBusinessTrip
                                                                                                                                                                                                                                                   == null
                                                                                                                                                                                                                                                : this$technologyBidManagerBusinessTrip.equals(
                                                                                                                                                                                                                                                   other$technologyBidManagerBusinessTrip
                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                              {
                                                                                                                                                                                                                                                Object this$technologyBidManagerCustomerReception = this.getTechnologyBidManagerCustomerReception();
                                                                                                                                                                                                                                                Object other$technologyBidManagerCustomerReception = other.getTechnologyBidManagerCustomerReception();
                                                                                                                                                                                                                                                if (this$technologyBidManagerCustomerReception
                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                   ? other$technologyBidManagerCustomerReception
                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                   : this$technologyBidManagerCustomerReception.equals(
                                                                                                                                                                                                                                                      other$technologyBidManagerCustomerReception
                                                                                                                                                                                                                                                   )
                                                                                                                                                                                                                                                   )
                                                                                                                                                                                                                                                 {
                                                                                                                                                                                                                                                   Object this$technologyBidManagerRemarks = this.getTechnologyBidManagerRemarks();
                                                                                                                                                                                                                                                   Object other$technologyBidManagerRemarks = other.getTechnologyBidManagerRemarks();
                                                                                                                                                                                                                                                   if (this$technologyBidManagerRemarks
                                                                                                                                                                                                                                                         == null
                                                                                                                                                                                                                                                      ? other$technologyBidManagerRemarks
                                                                                                                                                                                                                                                         == null
                                                                                                                                                                                                                                                      : this$technologyBidManagerRemarks.equals(
                                                                                                                                                                                                                                                         other$technologyBidManagerRemarks
                                                                                                                                                                                                                                                      )
                                                                                                                                                                                                                                                      )
                                                                                                                                                                                                                                                    {
                                                                                                                                                                                                                                                      Object this$sealContractAttachmentIds = this.getSealContractAttachmentIds();
                                                                                                                                                                                                                                                      Object other$sealContractAttachmentIds = other.getSealContractAttachmentIds();
                                                                                                                                                                                                                                                      if (this$sealContractAttachmentIds
                                                                                                                                                                                                                                                            == null
                                                                                                                                                                                                                                                         ? other$sealContractAttachmentIds
                                                                                                                                                                                                                                                            == null
                                                                                                                                                                                                                                                         : this$sealContractAttachmentIds.equals(
                                                                                                                                                                                                                                                            other$sealContractAttachmentIds
                                                                                                                                                                                                                                                         )
                                                                                                                                                                                                                                                         )
                                                                                                                                                                                                                                                       {
                                                                                                                                                                                                                                                         Object this$aUnitClassConfigurationContactName = this.getAUnitClassConfigurationContactName();
                                                                                                                                                                                                                                                         Object other$aUnitClassConfigurationContactName = other.getAUnitClassConfigurationContactName();
                                                                                                                                                                                                                                                         if (this$aUnitClassConfigurationContactName
                                                                                                                                                                                                                                                               == null
                                                                                                                                                                                                                                                            ? other$aUnitClassConfigurationContactName
                                                                                                                                                                                                                                                               == null
                                                                                                                                                                                                                                                            : this$aUnitClassConfigurationContactName.equals(
                                                                                                                                                                                                                                                               other$aUnitClassConfigurationContactName
                                                                                                                                                                                                                                                            )
                                                                                                                                                                                                                                                            )
                                                                                                                                                                                                                                                          {
                                                                                                                                                                                                                                                            Object this$aUnitClassConfigurationOffice = this.getAUnitClassConfigurationOffice();
                                                                                                                                                                                                                                                            Object other$aUnitClassConfigurationOffice = other.getAUnitClassConfigurationOffice();
                                                                                                                                                                                                                                                            if (this$aUnitClassConfigurationOffice
                                                                                                                                                                                                                                                                  == null
                                                                                                                                                                                                                                                               ? other$aUnitClassConfigurationOffice
                                                                                                                                                                                                                                                                  == null
                                                                                                                                                                                                                                                               : this$aUnitClassConfigurationOffice.equals(
                                                                                                                                                                                                                                                                  other$aUnitClassConfigurationOffice
                                                                                                                                                                                                                                                               )
                                                                                                                                                                                                                                                               )
                                                                                                                                                                                                                                                             {
                                                                                                                                                                                                                                                               Object this$aUnitClassConfigurationPhone = this.getAUnitClassConfigurationPhone();
                                                                                                                                                                                                                                                               Object other$aUnitClassConfigurationPhone = other.getAUnitClassConfigurationPhone();
                                                                                                                                                                                                                                                               if (this$aUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                                                                  ? other$aUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                                                                  : this$aUnitClassConfigurationPhone.equals(
                                                                                                                                                                                                                                                                     other$aUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                  )
                                                                                                                                                                                                                                                                  )
                                                                                                                                                                                                                                                                {
                                                                                                                                                                                                                                                                  Object this$bUnitClassConfigurationContactName = this.getBUnitClassConfigurationContactName();
                                                                                                                                                                                                                                                                  Object other$bUnitClassConfigurationContactName = other.getBUnitClassConfigurationContactName();
                                                                                                                                                                                                                                                                  if (this$bUnitClassConfigurationContactName
                                                                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                                                                     ? other$bUnitClassConfigurationContactName
                                                                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                                                                     : this$bUnitClassConfigurationContactName.equals(
                                                                                                                                                                                                                                                                        other$bUnitClassConfigurationContactName
                                                                                                                                                                                                                                                                     )
                                                                                                                                                                                                                                                                     )
                                                                                                                                                                                                                                                                   {
                                                                                                                                                                                                                                                                     Object this$bUnitClassConfigurationOffice = this.getBUnitClassConfigurationOffice();
                                                                                                                                                                                                                                                                     Object other$bUnitClassConfigurationOffice = other.getBUnitClassConfigurationOffice();
                                                                                                                                                                                                                                                                     if (this$bUnitClassConfigurationOffice
                                                                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                                                                        ? other$bUnitClassConfigurationOffice
                                                                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                                                                        : this$bUnitClassConfigurationOffice.equals(
                                                                                                                                                                                                                                                                           other$bUnitClassConfigurationOffice
                                                                                                                                                                                                                                                                        )
                                                                                                                                                                                                                                                                        )
                                                                                                                                                                                                                                                                      {
                                                                                                                                                                                                                                                                        Object this$bUnitClassConfigurationPhone = this.getBUnitClassConfigurationPhone();
                                                                                                                                                                                                                                                                        Object other$bUnitClassConfigurationPhone = other.getBUnitClassConfigurationPhone();
                                                                                                                                                                                                                                                                        if (this$bUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                                                                           ? other$bUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                                                                           : this$bUnitClassConfigurationPhone.equals(
                                                                                                                                                                                                                                                                              other$bUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                           )
                                                                                                                                                                                                                                                                           )
                                                                                                                                                                                                                                                                         {
                                                                                                                                                                                                                                                                           Object this$cUnitClassConfigurationContactName = this.getCUnitClassConfigurationContactName();
                                                                                                                                                                                                                                                                           Object other$cUnitClassConfigurationContactName = other.getCUnitClassConfigurationContactName();
                                                                                                                                                                                                                                                                           if (this$cUnitClassConfigurationContactName
                                                                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                                                                              ? other$cUnitClassConfigurationContactName
                                                                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                                                                              : this$cUnitClassConfigurationContactName.equals(
                                                                                                                                                                                                                                                                                 other$cUnitClassConfigurationContactName
                                                                                                                                                                                                                                                                              )
                                                                                                                                                                                                                                                                              )
                                                                                                                                                                                                                                                                            {
                                                                                                                                                                                                                                                                              Object this$cUnitClassConfigurationOffice = this.getCUnitClassConfigurationOffice();
                                                                                                                                                                                                                                                                              Object other$cUnitClassConfigurationOffice = other.getCUnitClassConfigurationOffice();
                                                                                                                                                                                                                                                                              if (this$cUnitClassConfigurationOffice
                                                                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                                                                 ? other$cUnitClassConfigurationOffice
                                                                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                                                                 : this$cUnitClassConfigurationOffice.equals(
                                                                                                                                                                                                                                                                                    other$cUnitClassConfigurationOffice
                                                                                                                                                                                                                                                                                 )
                                                                                                                                                                                                                                                                                 )
                                                                                                                                                                                                                                                                               {
                                                                                                                                                                                                                                                                                 Object this$cUnitClassConfigurationPhone = this.getCUnitClassConfigurationPhone();
                                                                                                                                                                                                                                                                                 Object other$cUnitClassConfigurationPhone = other.getCUnitClassConfigurationPhone();
                                                                                                                                                                                                                                                                                 if (this$cUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                                                                    ? other$cUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                                                                    : this$cUnitClassConfigurationPhone.equals(
                                                                                                                                                                                                                                                                                       other$cUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                                                                  {
                                                                                                                                                                                                                                                                                    Object this$dUnitClassConfigurationContactName = this.getDUnitClassConfigurationContactName();
                                                                                                                                                                                                                                                                                    Object other$dUnitClassConfigurationContactName = other.getDUnitClassConfigurationContactName();
                                                                                                                                                                                                                                                                                    if (this$dUnitClassConfigurationContactName
                                                                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                                                                       ? other$dUnitClassConfigurationContactName
                                                                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                                                                       : this$dUnitClassConfigurationContactName.equals(
                                                                                                                                                                                                                                                                                          other$dUnitClassConfigurationContactName
                                                                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                                                                     {
                                                                                                                                                                                                                                                                                       Object this$dUnitClassConfigurationOffice = this.getDUnitClassConfigurationOffice();
                                                                                                                                                                                                                                                                                       Object other$dUnitClassConfigurationOffice = other.getDUnitClassConfigurationOffice();
                                                                                                                                                                                                                                                                                       if (this$dUnitClassConfigurationOffice
                                                                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                                                                          ? other$dUnitClassConfigurationOffice
                                                                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                                                                          : this$dUnitClassConfigurationOffice.equals(
                                                                                                                                                                                                                                                                                             other$dUnitClassConfigurationOffice
                                                                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                                                                        {
                                                                                                                                                                                                                                                                                          Object this$dUnitClassConfigurationPhone = this.getDUnitClassConfigurationPhone();
                                                                                                                                                                                                                                                                                          Object other$dUnitClassConfigurationPhone = other.getDUnitClassConfigurationPhone();
                                                                                                                                                                                                                                                                                          if (this$dUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                                                                             ? other$dUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                                                                             : this$dUnitClassConfigurationPhone.equals(
                                                                                                                                                                                                                                                                                                other$dUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                                             )
                                                                                                                                                                                                                                                                                             )
                                                                                                                                                                                                                                                                                           {
                                                                                                                                                                                                                                                                                             Object this$eUnitClassConfigurationContactName = this.getEUnitClassConfigurationContactName();
                                                                                                                                                                                                                                                                                             Object other$eUnitClassConfigurationContactName = other.getEUnitClassConfigurationContactName();
                                                                                                                                                                                                                                                                                             if (this$eUnitClassConfigurationContactName
                                                                                                                                                                                                                                                                                                   == null
                                                                                                                                                                                                                                                                                                ? other$eUnitClassConfigurationContactName
                                                                                                                                                                                                                                                                                                   == null
                                                                                                                                                                                                                                                                                                : this$eUnitClassConfigurationContactName.equals(
                                                                                                                                                                                                                                                                                                   other$eUnitClassConfigurationContactName
                                                                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                                                              {
                                                                                                                                                                                                                                                                                                Object this$eUnitClassConfigurationOffice = this.getEUnitClassConfigurationOffice();
                                                                                                                                                                                                                                                                                                Object other$eUnitClassConfigurationOffice = other.getEUnitClassConfigurationOffice();
                                                                                                                                                                                                                                                                                                if (this$eUnitClassConfigurationOffice
                                                                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                                                                   ? other$eUnitClassConfigurationOffice
                                                                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                                                                   : this$eUnitClassConfigurationOffice.equals(
                                                                                                                                                                                                                                                                                                      other$eUnitClassConfigurationOffice
                                                                                                                                                                                                                                                                                                   )
                                                                                                                                                                                                                                                                                                   )
                                                                                                                                                                                                                                                                                                 {
                                                                                                                                                                                                                                                                                                   Object this$eUnitClassConfigurationPhone = this.getEUnitClassConfigurationPhone();
                                                                                                                                                                                                                                                                                                   Object other$eUnitClassConfigurationPhone = other.getEUnitClassConfigurationPhone();
                                                                                                                                                                                                                                                                                                   if (this$eUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                                                         == null
                                                                                                                                                                                                                                                                                                      ? other$eUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                                                         == null
                                                                                                                                                                                                                                                                                                      : this$eUnitClassConfigurationPhone.equals(
                                                                                                                                                                                                                                                                                                         other$eUnitClassConfigurationPhone
                                                                                                                                                                                                                                                                                                      )
                                                                                                                                                                                                                                                                                                      )
                                                                                                                                                                                                                                                                                                    {
                                                                                                                                                                                                                                                                                                      Object this$infoSource = this.getInfoSource();
                                                                                                                                                                                                                                                                                                      Object other$infoSource = other.getInfoSource();
                                                                                                                                                                                                                                                                                                      if (this$infoSource
                                                                                                                                                                                                                                                                                                            == null
                                                                                                                                                                                                                                                                                                         ? other$infoSource
                                                                                                                                                                                                                                                                                                            == null
                                                                                                                                                                                                                                                                                                         : this$infoSource.equals(
                                                                                                                                                                                                                                                                                                            other$infoSource
                                                                                                                                                                                                                                                                                                         )
                                                                                                                                                                                                                                                                                                         )
                                                                                                                                                                                                                                                                                                       {
                                                                                                                                                                                                                                                                                                         Object this$projectManagerName = this.getProjectManagerName();
                                                                                                                                                                                                                                                                                                         Object other$projectManagerName = other.getProjectManagerName();
                                                                                                                                                                                                                                                                                                         if (this$projectManagerName
                                                                                                                                                                                                                                                                                                               == null
                                                                                                                                                                                                                                                                                                            ? other$projectManagerName
                                                                                                                                                                                                                                                                                                               == null
                                                                                                                                                                                                                                                                                                            : this$projectManagerName.equals(
                                                                                                                                                                                                                                                                                                               other$projectManagerName
                                                                                                                                                                                                                                                                                                            )
                                                                                                                                                                                                                                                                                                            )
                                                                                                                                                                                                                                                                                                          {
                                                                                                                                                                                                                                                                                                            Object this$lastDistributionTime = this.getLastDistributionTime();
                                                                                                                                                                                                                                                                                                            Object other$lastDistributionTime = other.getLastDistributionTime();
                                                                                                                                                                                                                                                                                                            return this$lastDistributionTime
                                                                                                                                                                                                                                                                                                                  == null
                                                                                                                                                                                                                                                                                                               ? other$lastDistributionTime
                                                                                                                                                                                                                                                                                                                  == null
                                                                                                                                                                                                                                                                                                               : this$lastDistributionTime.equals(
                                                                                                                                                                                                                                                                                                                  other$lastDistributionTime
                                                                                                                                                                                                                                                                                                               );
                                                                                                                                                                                                                                                                                                         } else {
                                                                                                                                                                                                                                                                                                            return false;
                                                                                                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                                                                                      } else {
                                                                                                                                                                                                                                                                                                         return false;
                                                                                                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                                                                                   } else {
                                                                                                                                                                                                                                                                                                      return false;
                                                                                                                                                                                                                                                                                                   }
                                                                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                                                                   return false;
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                             } else {
                                                                                                                                                                                                                                                                                                return false;
                                                                                                                                                                                                                                                                                             }
                                                                                                                                                                                                                                                                                          } else {
                                                                                                                                                                                                                                                                                             return false;
                                                                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                                                                       } else {
                                                                                                                                                                                                                                                                                          return false;
                                                                                                                                                                                                                                                                                       }
                                                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                                                       return false;
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                 } else {
                                                                                                                                                                                                                                                                                    return false;
                                                                                                                                                                                                                                                                                 }
                                                                                                                                                                                                                                                                              } else {
                                                                                                                                                                                                                                                                                 return false;
                                                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                                           } else {
                                                                                                                                                                                                                                                                              return false;
                                                                                                                                                                                                                                                                           }
                                                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                                                           return false;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                     } else {
                                                                                                                                                                                                                                                                        return false;
                                                                                                                                                                                                                                                                     }
                                                                                                                                                                                                                                                                  } else {
                                                                                                                                                                                                                                                                     return false;
                                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                               } else {
                                                                                                                                                                                                                                                                  return false;
                                                                                                                                                                                                                                                               }
                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                               return false;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                         } else {
                                                                                                                                                                                                                                                            return false;
                                                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                                      } else {
                                                                                                                                                                                                                                                         return false;
                                                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                                   } else {
                                                                                                                                                                                                                                                      return false;
                                                                                                                                                                                                                                                   }
                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                   return false;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                             } else {
                                                                                                                                                                                                                                                return false;
                                                                                                                                                                                                                                             }
                                                                                                                                                                                                                                          } else {
                                                                                                                                                                                                                                             return false;
                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                       } else {
                                                                                                                                                                                                                                          return false;
                                                                                                                                                                                                                                       }
                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                       return false;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                 } else {
                                                                                                                                                                                                                                    return false;
                                                                                                                                                                                                                                 }
                                                                                                                                                                                                                              } else {
                                                                                                                                                                                                                                 return false;
                                                                                                                                                                                                                              }
                                                                                                                                                                                                                           } else {
                                                                                                                                                                                                                              return false;
                                                                                                                                                                                                                           }
                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                           return false;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                     } else {
                                                                                                                                                                                                                        return false;
                                                                                                                                                                                                                     }
                                                                                                                                                                                                                  } else {
                                                                                                                                                                                                                     return false;
                                                                                                                                                                                                                  }
                                                                                                                                                                                                               } else {
                                                                                                                                                                                                                  return false;
                                                                                                                                                                                                               }
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                               return false;
                                                                                                                                                                                                            }
                                                                                                                                                                                                         } else {
                                                                                                                                                                                                            return false;
                                                                                                                                                                                                         }
                                                                                                                                                                                                      } else {
                                                                                                                                                                                                         return false;
                                                                                                                                                                                                      }
                                                                                                                                                                                                   } else {
                                                                                                                                                                                                      return false;
                                                                                                                                                                                                   }
                                                                                                                                                                                                } else {
                                                                                                                                                                                                   return false;
                                                                                                                                                                                                }
                                                                                                                                                                                             } else {
                                                                                                                                                                                                return false;
                                                                                                                                                                                             }
                                                                                                                                                                                          } else {
                                                                                                                                                                                             return false;
                                                                                                                                                                                          }
                                                                                                                                                                                       } else {
                                                                                                                                                                                          return false;
                                                                                                                                                                                       }
                                                                                                                                                                                    } else {
                                                                                                                                                                                       return false;
                                                                                                                                                                                    }
                                                                                                                                                                                 } else {
                                                                                                                                                                                    return false;
                                                                                                                                                                                 }
                                                                                                                                                                              } else {
                                                                                                                                                                                 return false;
                                                                                                                                                                              }
                                                                                                                                                                           } else {
                                                                                                                                                                              return false;
                                                                                                                                                                           }
                                                                                                                                                                        } else {
                                                                                                                                                                           return false;
                                                                                                                                                                        }
                                                                                                                                                                     } else {
                                                                                                                                                                        return false;
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     return false;
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  return false;
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               return false;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            return false;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         return false;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      return false;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   return false;
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                return false;
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             return false;
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          return false;
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       return false;
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    return false;
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 return false;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              return false;
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           return false;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        return false;
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     return false;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  return false;
                                                                                                               }
                                                                                                            } else {
                                                                                                               return false;
                                                                                                            }
                                                                                                         } else {
                                                                                                            return false;
                                                                                                         }
                                                                                                      } else {
                                                                                                         return false;
                                                                                                      }
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmProjectInformationWarehousing;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $typeOfContractorId = this.getTypeOfContractorId();
      result = result * 59 + ($typeOfContractorId == null ? 43 : $typeOfContractorId.hashCode());
      Object $keyProjectId = this.getKeyProjectId();
      result = result * 59 + ($keyProjectId == null ? 43 : $keyProjectId.hashCode());
      Object $itemCategoryId = this.getItemCategoryId();
      result = result * 59 + ($itemCategoryId == null ? 43 : $itemCategoryId.hashCode());
      Object $configurationOfArchitecturalFormId = this.getConfigurationOfArchitecturalFormId();
      result = result * 59 + ($configurationOfArchitecturalFormId == null ? 43 : $configurationOfArchitecturalFormId.hashCode());
      Object $structureTypeConfigurationId = this.getStructureTypeConfigurationId();
      result = result * 59 + ($structureTypeConfigurationId == null ? 43 : $structureTypeConfigurationId.hashCode());
      Object $industryConfigurationId = this.getIndustryConfigurationId();
      result = result * 59 + ($industryConfigurationId == null ? 43 : $industryConfigurationId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $biddingMethodId = this.getBiddingMethodId();
      result = result * 59 + ($biddingMethodId == null ? 43 : $biddingMethodId.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
      Object $projectLevelConfigId = this.getProjectLevelConfigId();
      result = result * 59 + ($projectLevelConfigId == null ? 43 : $projectLevelConfigId.hashCode());
      Object $crmProjectScheduleTypeEnum = this.getCrmProjectScheduleTypeEnum();
      result = result * 59 + ($crmProjectScheduleTypeEnum == null ? 43 : $crmProjectScheduleTypeEnum.hashCode());
      Object $validityOfRegistration = this.getValidityOfRegistration();
      result = result * 59 + ($validityOfRegistration == null ? 43 : $validityOfRegistration.hashCode());
      Object $informationOperatorUserId = this.getInformationOperatorUserId();
      result = result * 59 + ($informationOperatorUserId == null ? 43 : $informationOperatorUserId.hashCode());
      Object $informationOperatorDeptId = this.getInformationOperatorDeptId();
      result = result * 59 + ($informationOperatorDeptId == null ? 43 : $informationOperatorDeptId.hashCode());
      Object $isBiddingMethod = this.getIsBiddingMethod();
      result = result * 59 + ($isBiddingMethod == null ? 43 : $isBiddingMethod.hashCode());
      Object $isSettlementMethod = this.getIsSettlementMethod();
      result = result * 59 + ($isSettlementMethod == null ? 43 : $isSettlementMethod.hashCode());
      Object $isTypeOfPerformanceBond = this.getIsTypeOfPerformanceBond();
      result = result * 59 + ($isTypeOfPerformanceBond == null ? 43 : $isTypeOfPerformanceBond.hashCode());
      Object $businessDifficultyFactorId = this.getBusinessDifficultyFactorId();
      result = result * 59 + ($businessDifficultyFactorId == null ? 43 : $businessDifficultyFactorId.hashCode());
      Object $businessCrmProjectBidStatus = this.getBusinessCrmProjectBidStatus();
      result = result * 59 + ($businessCrmProjectBidStatus == null ? 43 : $businessCrmProjectBidStatus.hashCode());
      Object $deviseDifficultyFactorId = this.getDeviseDifficultyFactorId();
      result = result * 59 + ($deviseDifficultyFactorId == null ? 43 : $deviseDifficultyFactorId.hashCode());
      Object $deviseCrmProjectBidStatus = this.getDeviseCrmProjectBidStatus();
      result = result * 59 + ($deviseCrmProjectBidStatus == null ? 43 : $deviseCrmProjectBidStatus.hashCode());
      Object $technologyDifficultyFactorId = this.getTechnologyDifficultyFactorId();
      result = result * 59 + ($technologyDifficultyFactorId == null ? 43 : $technologyDifficultyFactorId.hashCode());
      Object $technologyBidManagerJobDescriptionId = this.getTechnologyBidManagerJobDescriptionId();
      result = result * 59 + ($technologyBidManagerJobDescriptionId == null ? 43 : $technologyBidManagerJobDescriptionId.hashCode());
      Object $technologyCrmProjectBidStatus = this.getTechnologyCrmProjectBidStatus();
      result = result * 59 + ($technologyCrmProjectBidStatus == null ? 43 : $technologyCrmProjectBidStatus.hashCode());
      Object $crmCountryTypeEnum = this.getCrmCountryTypeEnum();
      result = result * 59 + ($crmCountryTypeEnum == null ? 43 : $crmCountryTypeEnum.hashCode());
      Object $aUnitClassConfigurationId = this.getAUnitClassConfigurationId();
      result = result * 59 + ($aUnitClassConfigurationId == null ? 43 : $aUnitClassConfigurationId.hashCode());
      Object $bUnitClassConfigurationId = this.getBUnitClassConfigurationId();
      result = result * 59 + ($bUnitClassConfigurationId == null ? 43 : $bUnitClassConfigurationId.hashCode());
      Object $cUnitClassConfigurationId = this.getCUnitClassConfigurationId();
      result = result * 59 + ($cUnitClassConfigurationId == null ? 43 : $cUnitClassConfigurationId.hashCode());
      Object $dUnitClassConfigurationId = this.getDUnitClassConfigurationId();
      result = result * 59 + ($dUnitClassConfigurationId == null ? 43 : $dUnitClassConfigurationId.hashCode());
      Object $eUnitClassConfigurationId = this.getEUnitClassConfigurationId();
      result = result * 59 + ($eUnitClassConfigurationId == null ? 43 : $eUnitClassConfigurationId.hashCode());
      Object $isProjectManagerCoordinate = this.getIsProjectManagerCoordinate();
      result = result * 59 + ($isProjectManagerCoordinate == null ? 43 : $isProjectManagerCoordinate.hashCode());
      Object $crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
      result = result * 59 + ($crmSettlementBusinessTypeEnum == null ? 43 : $crmSettlementBusinessTypeEnum.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $projectOverview = this.getProjectOverview();
      result = result * 59 + ($projectOverview == null ? 43 : $projectOverview.hashCode());
      Object $estimatedWorks = this.getEstimatedWorks();
      result = result * 59 + ($estimatedWorks == null ? 43 : $estimatedWorks.hashCode());
      Object $estimatedCost = this.getEstimatedCost();
      result = result * 59 + ($estimatedCost == null ? 43 : $estimatedCost.hashCode());
      Object $areaOfStructure = this.getAreaOfStructure();
      result = result * 59 + ($areaOfStructure == null ? 43 : $areaOfStructure.hashCode());
      Object $projectAttachments = this.getProjectAttachments();
      result = result * 59 + ($projectAttachments == null ? 43 : $projectAttachments.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $businessProjectBidManagerUserId = this.getBusinessProjectBidManagerUserId();
      result = result * 59 + ($businessProjectBidManagerUserId == null ? 43 : $businessProjectBidManagerUserId.hashCode());
      Object $businessProjectBidManagerFinishDate = this.getBusinessProjectBidManagerFinishDate();
      result = result * 59 + ($businessProjectBidManagerFinishDate == null ? 43 : $businessProjectBidManagerFinishDate.hashCode());
      Object $businessProjectBidManagerActualFinishDate = this.getBusinessProjectBidManagerActualFinishDate();
      result = result * 59 + ($businessProjectBidManagerActualFinishDate == null ? 43 : $businessProjectBidManagerActualFinishDate.hashCode());
      Object $businessProjectBidManagerQuote = this.getBusinessProjectBidManagerQuote();
      result = result * 59 + ($businessProjectBidManagerQuote == null ? 43 : $businessProjectBidManagerQuote.hashCode());
      Object $businessProjectBidManagerEstimatedWorks = this.getBusinessProjectBidManagerEstimatedWorks();
      result = result * 59 + ($businessProjectBidManagerEstimatedWorks == null ? 43 : $businessProjectBidManagerEstimatedWorks.hashCode());
      Object $businessProjectBidManagerCost = this.getBusinessProjectBidManagerCost();
      result = result * 59 + ($businessProjectBidManagerCost == null ? 43 : $businessProjectBidManagerCost.hashCode());
      Object $businessProjectBidManagerGrossProfit = this.getBusinessProjectBidManagerGrossProfit();
      result = result * 59 + ($businessProjectBidManagerGrossProfit == null ? 43 : $businessProjectBidManagerGrossProfit.hashCode());
      Object $businessProjectBidManagerRemark = this.getBusinessProjectBidManagerRemark();
      result = result * 59 + ($businessProjectBidManagerRemark == null ? 43 : $businessProjectBidManagerRemark.hashCode());
      Object $businessBidManagerAttachmentIds = this.getBusinessBidManagerAttachmentIds();
      result = result * 59 + ($businessBidManagerAttachmentIds == null ? 43 : $businessBidManagerAttachmentIds.hashCode());
      Object $deviseProjectBidManagerUserId = this.getDeviseProjectBidManagerUserId();
      result = result * 59 + ($deviseProjectBidManagerUserId == null ? 43 : $deviseProjectBidManagerUserId.hashCode());
      Object $deviseProjectBidManagerFinishDate = this.getDeviseProjectBidManagerFinishDate();
      result = result * 59 + ($deviseProjectBidManagerFinishDate == null ? 43 : $deviseProjectBidManagerFinishDate.hashCode());
      Object $deviseProjectBidManagerActualFinishDate = this.getDeviseProjectBidManagerActualFinishDate();
      result = result * 59 + ($deviseProjectBidManagerActualFinishDate == null ? 43 : $deviseProjectBidManagerActualFinishDate.hashCode());
      Object $deviseBidManagerAttachmentIds = this.getDeviseBidManagerAttachmentIds();
      result = result * 59 + ($deviseBidManagerAttachmentIds == null ? 43 : $deviseBidManagerAttachmentIds.hashCode());
      Object $technologyProjectBidManagerUserId = this.getTechnologyProjectBidManagerUserId();
      result = result * 59 + ($technologyProjectBidManagerUserId == null ? 43 : $technologyProjectBidManagerUserId.hashCode());
      Object $technologyProjectBidManagerFinishDate = this.getTechnologyProjectBidManagerFinishDate();
      result = result * 59 + ($technologyProjectBidManagerFinishDate == null ? 43 : $technologyProjectBidManagerFinishDate.hashCode());
      Object $technologyProjectBidManagerActualFinishDate = this.getTechnologyProjectBidManagerActualFinishDate();
      result = result * 59 + ($technologyProjectBidManagerActualFinishDate == null ? 43 : $technologyProjectBidManagerActualFinishDate.hashCode());
      Object $technologyBidManagerAttachmentIds = this.getTechnologyBidManagerAttachmentIds();
      result = result * 59 + ($technologyBidManagerAttachmentIds == null ? 43 : $technologyBidManagerAttachmentIds.hashCode());
      Object $technologyBidManagerRenderings = this.getTechnologyBidManagerRenderings();
      result = result * 59 + ($technologyBidManagerRenderings == null ? 43 : $technologyBidManagerRenderings.hashCode());
      Object $technologyBidManagerStructureName = this.getTechnologyBidManagerStructureName();
      result = result * 59 + ($technologyBidManagerStructureName == null ? 43 : $technologyBidManagerStructureName.hashCode());
      Object $technologyBidManagerCompletion = this.getTechnologyBidManagerCompletion();
      result = result * 59 + ($technologyBidManagerCompletion == null ? 43 : $technologyBidManagerCompletion.hashCode());
      Object $technologyBidManagerBusinessTrip = this.getTechnologyBidManagerBusinessTrip();
      result = result * 59 + ($technologyBidManagerBusinessTrip == null ? 43 : $technologyBidManagerBusinessTrip.hashCode());
      Object $technologyBidManagerCustomerReception = this.getTechnologyBidManagerCustomerReception();
      result = result * 59 + ($technologyBidManagerCustomerReception == null ? 43 : $technologyBidManagerCustomerReception.hashCode());
      Object $technologyBidManagerRemarks = this.getTechnologyBidManagerRemarks();
      result = result * 59 + ($technologyBidManagerRemarks == null ? 43 : $technologyBidManagerRemarks.hashCode());
      Object $sealContractAttachmentIds = this.getSealContractAttachmentIds();
      result = result * 59 + ($sealContractAttachmentIds == null ? 43 : $sealContractAttachmentIds.hashCode());
      Object $aUnitClassConfigurationContactName = this.getAUnitClassConfigurationContactName();
      result = result * 59 + ($aUnitClassConfigurationContactName == null ? 43 : $aUnitClassConfigurationContactName.hashCode());
      Object $aUnitClassConfigurationOffice = this.getAUnitClassConfigurationOffice();
      result = result * 59 + ($aUnitClassConfigurationOffice == null ? 43 : $aUnitClassConfigurationOffice.hashCode());
      Object $aUnitClassConfigurationPhone = this.getAUnitClassConfigurationPhone();
      result = result * 59 + ($aUnitClassConfigurationPhone == null ? 43 : $aUnitClassConfigurationPhone.hashCode());
      Object $bUnitClassConfigurationContactName = this.getBUnitClassConfigurationContactName();
      result = result * 59 + ($bUnitClassConfigurationContactName == null ? 43 : $bUnitClassConfigurationContactName.hashCode());
      Object $bUnitClassConfigurationOffice = this.getBUnitClassConfigurationOffice();
      result = result * 59 + ($bUnitClassConfigurationOffice == null ? 43 : $bUnitClassConfigurationOffice.hashCode());
      Object $bUnitClassConfigurationPhone = this.getBUnitClassConfigurationPhone();
      result = result * 59 + ($bUnitClassConfigurationPhone == null ? 43 : $bUnitClassConfigurationPhone.hashCode());
      Object $cUnitClassConfigurationContactName = this.getCUnitClassConfigurationContactName();
      result = result * 59 + ($cUnitClassConfigurationContactName == null ? 43 : $cUnitClassConfigurationContactName.hashCode());
      Object $cUnitClassConfigurationOffice = this.getCUnitClassConfigurationOffice();
      result = result * 59 + ($cUnitClassConfigurationOffice == null ? 43 : $cUnitClassConfigurationOffice.hashCode());
      Object $cUnitClassConfigurationPhone = this.getCUnitClassConfigurationPhone();
      result = result * 59 + ($cUnitClassConfigurationPhone == null ? 43 : $cUnitClassConfigurationPhone.hashCode());
      Object $dUnitClassConfigurationContactName = this.getDUnitClassConfigurationContactName();
      result = result * 59 + ($dUnitClassConfigurationContactName == null ? 43 : $dUnitClassConfigurationContactName.hashCode());
      Object $dUnitClassConfigurationOffice = this.getDUnitClassConfigurationOffice();
      result = result * 59 + ($dUnitClassConfigurationOffice == null ? 43 : $dUnitClassConfigurationOffice.hashCode());
      Object $dUnitClassConfigurationPhone = this.getDUnitClassConfigurationPhone();
      result = result * 59 + ($dUnitClassConfigurationPhone == null ? 43 : $dUnitClassConfigurationPhone.hashCode());
      Object $eUnitClassConfigurationContactName = this.getEUnitClassConfigurationContactName();
      result = result * 59 + ($eUnitClassConfigurationContactName == null ? 43 : $eUnitClassConfigurationContactName.hashCode());
      Object $eUnitClassConfigurationOffice = this.getEUnitClassConfigurationOffice();
      result = result * 59 + ($eUnitClassConfigurationOffice == null ? 43 : $eUnitClassConfigurationOffice.hashCode());
      Object $eUnitClassConfigurationPhone = this.getEUnitClassConfigurationPhone();
      result = result * 59 + ($eUnitClassConfigurationPhone == null ? 43 : $eUnitClassConfigurationPhone.hashCode());
      Object $infoSource = this.getInfoSource();
      result = result * 59 + ($infoSource == null ? 43 : $infoSource.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $lastDistributionTime = this.getLastDistributionTime();
      return result * 59 + ($lastDistributionTime == null ? 43 : $lastDistributionTime.hashCode());
   }

   public static class CrmProjectInformationWarehousingBuilder {
      private Long id;
      private Long informantUserId;
      private String informantUserName;
      private Long departmentId;
      private LocalDateTime informantDateTime;
      private Long createUserId;
      private Integer crmCheckStatusEnum;
      private Long approveRecordId;
      private String projectName;
      private String serialNumber;
      private String projectSerialNumber;
      private Long typeOfContractorId;
      private Long keyProjectId;
      private Long itemCategoryId;
      private Long configurationOfArchitecturalFormId;
      private Long structureTypeConfigurationId;
      private Long industryConfigurationId;
      private Long countryId;
      private String countryName;
      private Long provinceId;
      private String provinceName;
      private Long cityId;
      private String cityName;
      private Long regionId;
      private String regionName;
      private String address;
      private String projectOverview;
      private BigDecimal estimatedWorks;
      private BigDecimal estimatedCost;
      private BigDecimal areaOfStructure;
      private Long biddingMethodId;
      private Long crmEnterpriseWarehousingId;
      private Long projectLevelConfigId;
      private String projectAttachments;
      private String remark;
      private Integer crmProjectScheduleTypeEnum;
      private Integer validityOfRegistration;
      private Long informationOperatorUserId;
      private Long informationOperatorDeptId;
      private Boolean isBiddingMethod;
      private Boolean isSettlementMethod;
      private Boolean isTypeOfPerformanceBond;
      private String businessProjectBidManagerUserId;
      private LocalDateTime businessProjectBidManagerFinishDate;
      private LocalDateTime businessProjectBidManagerActualFinishDate;
      private BigDecimal businessProjectBidManagerQuote;
      private BigDecimal businessProjectBidManagerEstimatedWorks;
      private BigDecimal businessProjectBidManagerCost;
      private BigDecimal businessProjectBidManagerGrossProfit;
      private String businessProjectBidManagerRemark;
      private Long businessDifficultyFactorId;
      private String businessBidManagerAttachmentIds;
      private Integer businessCrmProjectBidStatus;
      private String deviseProjectBidManagerUserId;
      private LocalDateTime deviseProjectBidManagerFinishDate;
      private LocalDateTime deviseProjectBidManagerActualFinishDate;
      private Long deviseDifficultyFactorId;
      private String deviseBidManagerAttachmentIds;
      private Integer deviseCrmProjectBidStatus;
      private String technologyProjectBidManagerUserId;
      private LocalDateTime technologyProjectBidManagerFinishDate;
      private LocalDateTime technologyProjectBidManagerActualFinishDate;
      private Long technologyDifficultyFactorId;
      private String technologyBidManagerAttachmentIds;
      private Long technologyBidManagerJobDescriptionId;
      private String technologyBidManagerRenderings;
      private String technologyBidManagerStructureName;
      private String technologyBidManagerCompletion;
      private String technologyBidManagerBusinessTrip;
      private String technologyBidManagerCustomerReception;
      private String technologyBidManagerRemarks;
      private Integer technologyCrmProjectBidStatus;
      private String sealContractAttachmentIds;
      private Integer crmCountryTypeEnum;
      private Long aUnitClassConfigurationId;
      private String aUnitClassConfigurationContactName;
      private String aUnitClassConfigurationOffice;
      private String aUnitClassConfigurationPhone;
      private Long bUnitClassConfigurationId;
      private String bUnitClassConfigurationContactName;
      private String bUnitClassConfigurationOffice;
      private String bUnitClassConfigurationPhone;
      private Long cUnitClassConfigurationId;
      private String cUnitClassConfigurationContactName;
      private String cUnitClassConfigurationOffice;
      private String cUnitClassConfigurationPhone;
      private Long dUnitClassConfigurationId;
      private String dUnitClassConfigurationContactName;
      private String dUnitClassConfigurationOffice;
      private String dUnitClassConfigurationPhone;
      private Long eUnitClassConfigurationId;
      private String eUnitClassConfigurationContactName;
      private String eUnitClassConfigurationOffice;
      private String eUnitClassConfigurationPhone;
      private String infoSource;
      private String projectManagerName;
      private Boolean isProjectManagerCoordinate;
      private Integer crmSettlementBusinessTypeEnum;
      private LocalDateTime lastDistributionTime;

      CrmProjectInformationWarehousingBuilder() {
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder informantUserId(final Long informantUserId) {
         this.informantUserId = informantUserId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder projectSerialNumber(final String projectSerialNumber) {
         this.projectSerialNumber = projectSerialNumber;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder typeOfContractorId(final Long typeOfContractorId) {
         this.typeOfContractorId = typeOfContractorId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder keyProjectId(final Long keyProjectId) {
         this.keyProjectId = keyProjectId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder itemCategoryId(final Long itemCategoryId) {
         this.itemCategoryId = itemCategoryId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder configurationOfArchitecturalFormId(
         final Long configurationOfArchitecturalFormId
      ) {
         this.configurationOfArchitecturalFormId = configurationOfArchitecturalFormId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder structureTypeConfigurationId(final Long structureTypeConfigurationId) {
         this.structureTypeConfigurationId = structureTypeConfigurationId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder industryConfigurationId(final Long industryConfigurationId) {
         this.industryConfigurationId = industryConfigurationId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder projectOverview(final String projectOverview) {
         this.projectOverview = projectOverview;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder estimatedWorks(final BigDecimal estimatedWorks) {
         this.estimatedWorks = estimatedWorks;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder estimatedCost(final BigDecimal estimatedCost) {
         this.estimatedCost = estimatedCost;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder areaOfStructure(final BigDecimal areaOfStructure) {
         this.areaOfStructure = areaOfStructure;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder biddingMethodId(final Long biddingMethodId) {
         this.biddingMethodId = biddingMethodId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder crmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
         this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder projectLevelConfigId(final Long projectLevelConfigId) {
         this.projectLevelConfigId = projectLevelConfigId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder projectAttachments(final String projectAttachments) {
         this.projectAttachments = projectAttachments;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder crmProjectScheduleTypeEnum(final Integer crmProjectScheduleTypeEnum) {
         this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder validityOfRegistration(final Integer validityOfRegistration) {
         this.validityOfRegistration = validityOfRegistration;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder informationOperatorUserId(final Long informationOperatorUserId) {
         this.informationOperatorUserId = informationOperatorUserId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder informationOperatorDeptId(final Long informationOperatorDeptId) {
         this.informationOperatorDeptId = informationOperatorDeptId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder isBiddingMethod(final Boolean isBiddingMethod) {
         this.isBiddingMethod = isBiddingMethod;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder isSettlementMethod(final Boolean isSettlementMethod) {
         this.isSettlementMethod = isSettlementMethod;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder isTypeOfPerformanceBond(final Boolean isTypeOfPerformanceBond) {
         this.isTypeOfPerformanceBond = isTypeOfPerformanceBond;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder businessProjectBidManagerUserId(
         final String businessProjectBidManagerUserId
      ) {
         this.businessProjectBidManagerUserId = businessProjectBidManagerUserId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder businessProjectBidManagerFinishDate(
         final LocalDateTime businessProjectBidManagerFinishDate
      ) {
         this.businessProjectBidManagerFinishDate = businessProjectBidManagerFinishDate;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder businessProjectBidManagerActualFinishDate(
         final LocalDateTime businessProjectBidManagerActualFinishDate
      ) {
         this.businessProjectBidManagerActualFinishDate = businessProjectBidManagerActualFinishDate;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder businessProjectBidManagerQuote(
         final BigDecimal businessProjectBidManagerQuote
      ) {
         this.businessProjectBidManagerQuote = businessProjectBidManagerQuote;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder businessProjectBidManagerEstimatedWorks(
         final BigDecimal businessProjectBidManagerEstimatedWorks
      ) {
         this.businessProjectBidManagerEstimatedWorks = businessProjectBidManagerEstimatedWorks;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder businessProjectBidManagerCost(
         final BigDecimal businessProjectBidManagerCost
      ) {
         this.businessProjectBidManagerCost = businessProjectBidManagerCost;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder businessProjectBidManagerGrossProfit(
         final BigDecimal businessProjectBidManagerGrossProfit
      ) {
         this.businessProjectBidManagerGrossProfit = businessProjectBidManagerGrossProfit;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder businessProjectBidManagerRemark(
         final String businessProjectBidManagerRemark
      ) {
         this.businessProjectBidManagerRemark = businessProjectBidManagerRemark;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder businessDifficultyFactorId(final Long businessDifficultyFactorId) {
         this.businessDifficultyFactorId = businessDifficultyFactorId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder businessBidManagerAttachmentIds(
         final String businessBidManagerAttachmentIds
      ) {
         this.businessBidManagerAttachmentIds = businessBidManagerAttachmentIds;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder businessCrmProjectBidStatus(final Integer businessCrmProjectBidStatus) {
         this.businessCrmProjectBidStatus = businessCrmProjectBidStatus;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder deviseProjectBidManagerUserId(final String deviseProjectBidManagerUserId) {
         this.deviseProjectBidManagerUserId = deviseProjectBidManagerUserId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder deviseProjectBidManagerFinishDate(
         final LocalDateTime deviseProjectBidManagerFinishDate
      ) {
         this.deviseProjectBidManagerFinishDate = deviseProjectBidManagerFinishDate;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder deviseProjectBidManagerActualFinishDate(
         final LocalDateTime deviseProjectBidManagerActualFinishDate
      ) {
         this.deviseProjectBidManagerActualFinishDate = deviseProjectBidManagerActualFinishDate;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder deviseDifficultyFactorId(final Long deviseDifficultyFactorId) {
         this.deviseDifficultyFactorId = deviseDifficultyFactorId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder deviseBidManagerAttachmentIds(final String deviseBidManagerAttachmentIds) {
         this.deviseBidManagerAttachmentIds = deviseBidManagerAttachmentIds;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder deviseCrmProjectBidStatus(final Integer deviseCrmProjectBidStatus) {
         this.deviseCrmProjectBidStatus = deviseCrmProjectBidStatus;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder technologyProjectBidManagerUserId(
         final String technologyProjectBidManagerUserId
      ) {
         this.technologyProjectBidManagerUserId = technologyProjectBidManagerUserId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder technologyProjectBidManagerFinishDate(
         final LocalDateTime technologyProjectBidManagerFinishDate
      ) {
         this.technologyProjectBidManagerFinishDate = technologyProjectBidManagerFinishDate;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder technologyProjectBidManagerActualFinishDate(
         final LocalDateTime technologyProjectBidManagerActualFinishDate
      ) {
         this.technologyProjectBidManagerActualFinishDate = technologyProjectBidManagerActualFinishDate;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder technologyDifficultyFactorId(final Long technologyDifficultyFactorId) {
         this.technologyDifficultyFactorId = technologyDifficultyFactorId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder technologyBidManagerAttachmentIds(
         final String technologyBidManagerAttachmentIds
      ) {
         this.technologyBidManagerAttachmentIds = technologyBidManagerAttachmentIds;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder technologyBidManagerJobDescriptionId(
         final Long technologyBidManagerJobDescriptionId
      ) {
         this.technologyBidManagerJobDescriptionId = technologyBidManagerJobDescriptionId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder technologyBidManagerRenderings(
         final String technologyBidManagerRenderings
      ) {
         this.technologyBidManagerRenderings = technologyBidManagerRenderings;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder technologyBidManagerStructureName(
         final String technologyBidManagerStructureName
      ) {
         this.technologyBidManagerStructureName = technologyBidManagerStructureName;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder technologyBidManagerCompletion(
         final String technologyBidManagerCompletion
      ) {
         this.technologyBidManagerCompletion = technologyBidManagerCompletion;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder technologyBidManagerBusinessTrip(
         final String technologyBidManagerBusinessTrip
      ) {
         this.technologyBidManagerBusinessTrip = technologyBidManagerBusinessTrip;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder technologyBidManagerCustomerReception(
         final String technologyBidManagerCustomerReception
      ) {
         this.technologyBidManagerCustomerReception = technologyBidManagerCustomerReception;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder technologyBidManagerRemarks(final String technologyBidManagerRemarks) {
         this.technologyBidManagerRemarks = technologyBidManagerRemarks;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder technologyCrmProjectBidStatus(final Integer technologyCrmProjectBidStatus) {
         this.technologyCrmProjectBidStatus = technologyCrmProjectBidStatus;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder sealContractAttachmentIds(final String sealContractAttachmentIds) {
         this.sealContractAttachmentIds = sealContractAttachmentIds;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder crmCountryTypeEnum(final Integer crmCountryTypeEnum) {
         this.crmCountryTypeEnum = crmCountryTypeEnum;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder aUnitClassConfigurationId(final Long aUnitClassConfigurationId) {
         this.aUnitClassConfigurationId = aUnitClassConfigurationId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder aUnitClassConfigurationContactName(
         final String aUnitClassConfigurationContactName
      ) {
         this.aUnitClassConfigurationContactName = aUnitClassConfigurationContactName;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder aUnitClassConfigurationOffice(final String aUnitClassConfigurationOffice) {
         this.aUnitClassConfigurationOffice = aUnitClassConfigurationOffice;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder aUnitClassConfigurationPhone(final String aUnitClassConfigurationPhone) {
         this.aUnitClassConfigurationPhone = aUnitClassConfigurationPhone;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder bUnitClassConfigurationId(final Long bUnitClassConfigurationId) {
         this.bUnitClassConfigurationId = bUnitClassConfigurationId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder bUnitClassConfigurationContactName(
         final String bUnitClassConfigurationContactName
      ) {
         this.bUnitClassConfigurationContactName = bUnitClassConfigurationContactName;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder bUnitClassConfigurationOffice(final String bUnitClassConfigurationOffice) {
         this.bUnitClassConfigurationOffice = bUnitClassConfigurationOffice;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder bUnitClassConfigurationPhone(final String bUnitClassConfigurationPhone) {
         this.bUnitClassConfigurationPhone = bUnitClassConfigurationPhone;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder cUnitClassConfigurationId(final Long cUnitClassConfigurationId) {
         this.cUnitClassConfigurationId = cUnitClassConfigurationId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder cUnitClassConfigurationContactName(
         final String cUnitClassConfigurationContactName
      ) {
         this.cUnitClassConfigurationContactName = cUnitClassConfigurationContactName;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder cUnitClassConfigurationOffice(final String cUnitClassConfigurationOffice) {
         this.cUnitClassConfigurationOffice = cUnitClassConfigurationOffice;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder cUnitClassConfigurationPhone(final String cUnitClassConfigurationPhone) {
         this.cUnitClassConfigurationPhone = cUnitClassConfigurationPhone;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder dUnitClassConfigurationId(final Long dUnitClassConfigurationId) {
         this.dUnitClassConfigurationId = dUnitClassConfigurationId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder dUnitClassConfigurationContactName(
         final String dUnitClassConfigurationContactName
      ) {
         this.dUnitClassConfigurationContactName = dUnitClassConfigurationContactName;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder dUnitClassConfigurationOffice(final String dUnitClassConfigurationOffice) {
         this.dUnitClassConfigurationOffice = dUnitClassConfigurationOffice;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder dUnitClassConfigurationPhone(final String dUnitClassConfigurationPhone) {
         this.dUnitClassConfigurationPhone = dUnitClassConfigurationPhone;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder eUnitClassConfigurationId(final Long eUnitClassConfigurationId) {
         this.eUnitClassConfigurationId = eUnitClassConfigurationId;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder eUnitClassConfigurationContactName(
         final String eUnitClassConfigurationContactName
      ) {
         this.eUnitClassConfigurationContactName = eUnitClassConfigurationContactName;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder eUnitClassConfigurationOffice(final String eUnitClassConfigurationOffice) {
         this.eUnitClassConfigurationOffice = eUnitClassConfigurationOffice;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder eUnitClassConfigurationPhone(final String eUnitClassConfigurationPhone) {
         this.eUnitClassConfigurationPhone = eUnitClassConfigurationPhone;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder infoSource(final String infoSource) {
         this.infoSource = infoSource;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder isProjectManagerCoordinate(final Boolean isProjectManagerCoordinate) {
         this.isProjectManagerCoordinate = isProjectManagerCoordinate;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder crmSettlementBusinessTypeEnum(final Integer crmSettlementBusinessTypeEnum) {
         this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
         return this;
      }

      public CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder lastDistributionTime(final LocalDateTime lastDistributionTime) {
         this.lastDistributionTime = lastDistributionTime;
         return this;
      }

      public CrmProjectInformationWarehousing build() {
         return new CrmProjectInformationWarehousing(
            this.id,
            this.informantUserId,
            this.informantUserName,
            this.departmentId,
            this.informantDateTime,
            this.createUserId,
            this.crmCheckStatusEnum,
            this.approveRecordId,
            this.projectName,
            this.serialNumber,
            this.projectSerialNumber,
            this.typeOfContractorId,
            this.keyProjectId,
            this.itemCategoryId,
            this.configurationOfArchitecturalFormId,
            this.structureTypeConfigurationId,
            this.industryConfigurationId,
            this.countryId,
            this.countryName,
            this.provinceId,
            this.provinceName,
            this.cityId,
            this.cityName,
            this.regionId,
            this.regionName,
            this.address,
            this.projectOverview,
            this.estimatedWorks,
            this.estimatedCost,
            this.areaOfStructure,
            this.biddingMethodId,
            this.crmEnterpriseWarehousingId,
            this.projectLevelConfigId,
            this.projectAttachments,
            this.remark,
            this.crmProjectScheduleTypeEnum,
            this.validityOfRegistration,
            this.informationOperatorUserId,
            this.informationOperatorDeptId,
            this.isBiddingMethod,
            this.isSettlementMethod,
            this.isTypeOfPerformanceBond,
            this.businessProjectBidManagerUserId,
            this.businessProjectBidManagerFinishDate,
            this.businessProjectBidManagerActualFinishDate,
            this.businessProjectBidManagerQuote,
            this.businessProjectBidManagerEstimatedWorks,
            this.businessProjectBidManagerCost,
            this.businessProjectBidManagerGrossProfit,
            this.businessProjectBidManagerRemark,
            this.businessDifficultyFactorId,
            this.businessBidManagerAttachmentIds,
            this.businessCrmProjectBidStatus,
            this.deviseProjectBidManagerUserId,
            this.deviseProjectBidManagerFinishDate,
            this.deviseProjectBidManagerActualFinishDate,
            this.deviseDifficultyFactorId,
            this.deviseBidManagerAttachmentIds,
            this.deviseCrmProjectBidStatus,
            this.technologyProjectBidManagerUserId,
            this.technologyProjectBidManagerFinishDate,
            this.technologyProjectBidManagerActualFinishDate,
            this.technologyDifficultyFactorId,
            this.technologyBidManagerAttachmentIds,
            this.technologyBidManagerJobDescriptionId,
            this.technologyBidManagerRenderings,
            this.technologyBidManagerStructureName,
            this.technologyBidManagerCompletion,
            this.technologyBidManagerBusinessTrip,
            this.technologyBidManagerCustomerReception,
            this.technologyBidManagerRemarks,
            this.technologyCrmProjectBidStatus,
            this.sealContractAttachmentIds,
            this.crmCountryTypeEnum,
            this.aUnitClassConfigurationId,
            this.aUnitClassConfigurationContactName,
            this.aUnitClassConfigurationOffice,
            this.aUnitClassConfigurationPhone,
            this.bUnitClassConfigurationId,
            this.bUnitClassConfigurationContactName,
            this.bUnitClassConfigurationOffice,
            this.bUnitClassConfigurationPhone,
            this.cUnitClassConfigurationId,
            this.cUnitClassConfigurationContactName,
            this.cUnitClassConfigurationOffice,
            this.cUnitClassConfigurationPhone,
            this.dUnitClassConfigurationId,
            this.dUnitClassConfigurationContactName,
            this.dUnitClassConfigurationOffice,
            this.dUnitClassConfigurationPhone,
            this.eUnitClassConfigurationId,
            this.eUnitClassConfigurationContactName,
            this.eUnitClassConfigurationOffice,
            this.eUnitClassConfigurationPhone,
            this.infoSource,
            this.projectManagerName,
            this.isProjectManagerCoordinate,
            this.crmSettlementBusinessTypeEnum,
            this.lastDistributionTime
         );
      }

      @Override
      public String toString() {
         return "CrmProjectInformationWarehousing.CrmProjectInformationWarehousingBuilder(id="
            + this.id
            + ", informantUserId="
            + this.informantUserId
            + ", informantUserName="
            + this.informantUserName
            + ", departmentId="
            + this.departmentId
            + ", informantDateTime="
            + this.informantDateTime
            + ", createUserId="
            + this.createUserId
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ", approveRecordId="
            + this.approveRecordId
            + ", projectName="
            + this.projectName
            + ", serialNumber="
            + this.serialNumber
            + ", projectSerialNumber="
            + this.projectSerialNumber
            + ", typeOfContractorId="
            + this.typeOfContractorId
            + ", keyProjectId="
            + this.keyProjectId
            + ", itemCategoryId="
            + this.itemCategoryId
            + ", configurationOfArchitecturalFormId="
            + this.configurationOfArchitecturalFormId
            + ", structureTypeConfigurationId="
            + this.structureTypeConfigurationId
            + ", industryConfigurationId="
            + this.industryConfigurationId
            + ", countryId="
            + this.countryId
            + ", countryName="
            + this.countryName
            + ", provinceId="
            + this.provinceId
            + ", provinceName="
            + this.provinceName
            + ", cityId="
            + this.cityId
            + ", cityName="
            + this.cityName
            + ", regionId="
            + this.regionId
            + ", regionName="
            + this.regionName
            + ", address="
            + this.address
            + ", projectOverview="
            + this.projectOverview
            + ", estimatedWorks="
            + this.estimatedWorks
            + ", estimatedCost="
            + this.estimatedCost
            + ", areaOfStructure="
            + this.areaOfStructure
            + ", biddingMethodId="
            + this.biddingMethodId
            + ", crmEnterpriseWarehousingId="
            + this.crmEnterpriseWarehousingId
            + ", projectLevelConfigId="
            + this.projectLevelConfigId
            + ", projectAttachments="
            + this.projectAttachments
            + ", remark="
            + this.remark
            + ", crmProjectScheduleTypeEnum="
            + this.crmProjectScheduleTypeEnum
            + ", validityOfRegistration="
            + this.validityOfRegistration
            + ", informationOperatorUserId="
            + this.informationOperatorUserId
            + ", informationOperatorDeptId="
            + this.informationOperatorDeptId
            + ", isBiddingMethod="
            + this.isBiddingMethod
            + ", isSettlementMethod="
            + this.isSettlementMethod
            + ", isTypeOfPerformanceBond="
            + this.isTypeOfPerformanceBond
            + ", businessProjectBidManagerUserId="
            + this.businessProjectBidManagerUserId
            + ", businessProjectBidManagerFinishDate="
            + this.businessProjectBidManagerFinishDate
            + ", businessProjectBidManagerActualFinishDate="
            + this.businessProjectBidManagerActualFinishDate
            + ", businessProjectBidManagerQuote="
            + this.businessProjectBidManagerQuote
            + ", businessProjectBidManagerEstimatedWorks="
            + this.businessProjectBidManagerEstimatedWorks
            + ", businessProjectBidManagerCost="
            + this.businessProjectBidManagerCost
            + ", businessProjectBidManagerGrossProfit="
            + this.businessProjectBidManagerGrossProfit
            + ", businessProjectBidManagerRemark="
            + this.businessProjectBidManagerRemark
            + ", businessDifficultyFactorId="
            + this.businessDifficultyFactorId
            + ", businessBidManagerAttachmentIds="
            + this.businessBidManagerAttachmentIds
            + ", businessCrmProjectBidStatus="
            + this.businessCrmProjectBidStatus
            + ", deviseProjectBidManagerUserId="
            + this.deviseProjectBidManagerUserId
            + ", deviseProjectBidManagerFinishDate="
            + this.deviseProjectBidManagerFinishDate
            + ", deviseProjectBidManagerActualFinishDate="
            + this.deviseProjectBidManagerActualFinishDate
            + ", deviseDifficultyFactorId="
            + this.deviseDifficultyFactorId
            + ", deviseBidManagerAttachmentIds="
            + this.deviseBidManagerAttachmentIds
            + ", deviseCrmProjectBidStatus="
            + this.deviseCrmProjectBidStatus
            + ", technologyProjectBidManagerUserId="
            + this.technologyProjectBidManagerUserId
            + ", technologyProjectBidManagerFinishDate="
            + this.technologyProjectBidManagerFinishDate
            + ", technologyProjectBidManagerActualFinishDate="
            + this.technologyProjectBidManagerActualFinishDate
            + ", technologyDifficultyFactorId="
            + this.technologyDifficultyFactorId
            + ", technologyBidManagerAttachmentIds="
            + this.technologyBidManagerAttachmentIds
            + ", technologyBidManagerJobDescriptionId="
            + this.technologyBidManagerJobDescriptionId
            + ", technologyBidManagerRenderings="
            + this.technologyBidManagerRenderings
            + ", technologyBidManagerStructureName="
            + this.technologyBidManagerStructureName
            + ", technologyBidManagerCompletion="
            + this.technologyBidManagerCompletion
            + ", technologyBidManagerBusinessTrip="
            + this.technologyBidManagerBusinessTrip
            + ", technologyBidManagerCustomerReception="
            + this.technologyBidManagerCustomerReception
            + ", technologyBidManagerRemarks="
            + this.technologyBidManagerRemarks
            + ", technologyCrmProjectBidStatus="
            + this.technologyCrmProjectBidStatus
            + ", sealContractAttachmentIds="
            + this.sealContractAttachmentIds
            + ", crmCountryTypeEnum="
            + this.crmCountryTypeEnum
            + ", aUnitClassConfigurationId="
            + this.aUnitClassConfigurationId
            + ", aUnitClassConfigurationContactName="
            + this.aUnitClassConfigurationContactName
            + ", aUnitClassConfigurationOffice="
            + this.aUnitClassConfigurationOffice
            + ", aUnitClassConfigurationPhone="
            + this.aUnitClassConfigurationPhone
            + ", bUnitClassConfigurationId="
            + this.bUnitClassConfigurationId
            + ", bUnitClassConfigurationContactName="
            + this.bUnitClassConfigurationContactName
            + ", bUnitClassConfigurationOffice="
            + this.bUnitClassConfigurationOffice
            + ", bUnitClassConfigurationPhone="
            + this.bUnitClassConfigurationPhone
            + ", cUnitClassConfigurationId="
            + this.cUnitClassConfigurationId
            + ", cUnitClassConfigurationContactName="
            + this.cUnitClassConfigurationContactName
            + ", cUnitClassConfigurationOffice="
            + this.cUnitClassConfigurationOffice
            + ", cUnitClassConfigurationPhone="
            + this.cUnitClassConfigurationPhone
            + ", dUnitClassConfigurationId="
            + this.dUnitClassConfigurationId
            + ", dUnitClassConfigurationContactName="
            + this.dUnitClassConfigurationContactName
            + ", dUnitClassConfigurationOffice="
            + this.dUnitClassConfigurationOffice
            + ", dUnitClassConfigurationPhone="
            + this.dUnitClassConfigurationPhone
            + ", eUnitClassConfigurationId="
            + this.eUnitClassConfigurationId
            + ", eUnitClassConfigurationContactName="
            + this.eUnitClassConfigurationContactName
            + ", eUnitClassConfigurationOffice="
            + this.eUnitClassConfigurationOffice
            + ", eUnitClassConfigurationPhone="
            + this.eUnitClassConfigurationPhone
            + ", infoSource="
            + this.infoSource
            + ", projectManagerName="
            + this.projectManagerName
            + ", isProjectManagerCoordinate="
            + this.isProjectManagerCoordinate
            + ", crmSettlementBusinessTypeEnum="
            + this.crmSettlementBusinessTypeEnum
            + ", lastDistributionTime="
            + this.lastDistributionTime
            + ")";
      }
   }
}
