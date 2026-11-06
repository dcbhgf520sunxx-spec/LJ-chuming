package com.hzchum.scim.contract.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ApiModel(value = "ContractProject对象", description = "合同主体表")
@TableName("contract_project")
@Table(name = "contract_project")
public class ContractProject extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serial_number", notes = "合同编号")
   @JsonProperty("serial_number")
   @JSONField(name = "serial_number")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255) comment '合同编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "name", notes = "项目名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) comment '项目名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "short_name", notes = "项目简称")
   @JsonProperty("short_name")
   @JSONField(name = "short_name")
   @TableField("short_name")
   @Column(name = "short_name", columnDefinition = "varchar(255) comment '项目简称'", nullable = false)
   private String shortName;
   @ApiModelProperty(name = "start_date", notes = "约定开工日期")
   @JsonProperty("start_date")
   @JSONField(name = "start_date")
   @TableField("start_date")
   @Column(name = "start_date", columnDefinition = "date comment '计划开工日期'", nullable = false)
   private LocalDate startDate;
   @ApiModelProperty(name = "end_date", notes = "约定完工时期")
   @JsonProperty("end_date")
   @JSONField(name = "end_date")
   @TableField("end_date")
   @Column(name = "end_date", columnDefinition = "date comment '计划完工时期'")
   private LocalDate endDate;
   @ApiModelProperty(name = "complete_date", notes = "实际完工时期")
   @JsonProperty("complete_date")
   @JSONField(name = "complete_date")
   @TableField(value = "complete_date", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "complete_date", columnDefinition = "date comment '实际完工时期'")
   private LocalDate completeDate;
   @ApiModelProperty(name = "address", notes = "项目详细地址")
   @JsonProperty("address")
   @JSONField(name = "address")
   @TableField(value = "address", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "address")
   private String address;
   @ApiModelProperty(name = "project_manager_id", notes = "项目经理")
   @JsonProperty("project_manager_id")
   @JSONField(name = "project_manager_id")
   @TableField(value = "project_manager_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "project_manager_id", columnDefinition = "bigint(20) comment '项目经理id' ")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerName", value = "项目经理名称")
   @TableField(value = "project_manager_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "project_manager_name", columnDefinition = "varchar(32) comment '项目经理名称'")
   private String projectManagerName;
   @ApiModelProperty(name = "projectManagerPhone", value = "项目经理电话")
   @TableField(value = "project_manager_phone", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "project_manager_phone", columnDefinition = "varchar(16) comment '项目经理电话'")
   private String projectManagerPhone;
   @ApiModelProperty(name = "salesLeaderId", value = "销售负责人id")
   @JsonProperty("salesLeaderId")
   @JSONField(name = "salesLeaderId")
   @TableField(value = "sales_leader_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "sales_leader_id", columnDefinition = "bigint(20) comment '销售负责人id'")
   private Long salesLeaderId;
   @ApiModelProperty(name = "business_leader_id", notes = "业务负责人1")
   @JsonProperty("business_leader_id")
   @JSONField(name = "business_leader_id")
   @TableField(value = "business_leader_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "business_leader_id", columnDefinition = "bigint(20) comment '业务负责人1 id'")
   private Long businessLeaderId;
   @ApiModelProperty(name = "business_leader_two_id", notes = "业务负责人2")
   @JsonProperty("business_leader_two_id")
   @JSONField(name = "business_leader_two_id")
   @TableField(value = "business_leader_two_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "business_leader_two_id", columnDefinition = "bigint(20) comment '业务负责人1 id'")
   private Long businessLeaderTwoId;
   @ApiModelProperty(name = "attachments", notes = "项目的附件id集合(字符串 格式为 1,2,3)")
   @JsonProperty("attachments")
   @JSONField(name = "attachments")
   @TableField(value = "attachments", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "attachments", columnDefinition = "varchar(255) comment '项目的附件id集合(字符串 格式为 1,2,3)'")
   private String attachments;
   @ApiModelProperty(name = "archives", notes = "项目档案附件id集合(字符串 格式为 1,2,3)")
   @JsonProperty("archives")
   @JSONField(name = "archives")
   @TableField(value = "archives", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "archives", columnDefinition = "varchar(255) comment '项目档案附件id集合(字符串 格式为 1,2,3)'")
   private String archives;
   @ApiModelProperty(name = "city_id")
   @JsonProperty("city_id")
   @JSONField(name = "city_id")
   @TableField(value = "city_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "city_id", columnDefinition = "int(11) comment '城市id'")
   private Long cityId;
   @ApiModelProperty(name = "city_name")
   @JsonProperty("city_name")
   @JSONField(name = "city_name")
   @TableField(value = "city_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "city_name", columnDefinition = "varchar(255) comment '城市名称'")
   private String cityName;
   @ApiModelProperty(name = "country_id")
   @JsonProperty("country_id")
   @JSONField(name = "country_id")
   @TableField(value = "country_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "country_id", columnDefinition = "int(11) comment '国家id' ")
   private Long countryId;
   @ApiModelProperty(name = "country_name")
   @JsonProperty("country_name")
   @JSONField(name = "country_name")
   @TableField(value = "country_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "country_name", columnDefinition = "varchar(255) comment '国家名字'")
   private String countryName;
   @ApiModelProperty(name = "contract_amount", notes = "合同金额（元）")
   @JsonProperty("contract_amount")
   @JSONField(name = "contract_amount")
   @TableField("contract_amount")
   @Column(name = "contract_amount", columnDefinition = "decimal(32,8) default 0.0 comment '合同金额(元)'", nullable = false)
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "prepayments", notes = "预付款（元）")
   @JsonProperty("prepayments")
   @JSONField(name = "prepayments")
   @TableField("prepayments")
   @Column(name = "prepayments", columnDefinition = "decimal(32,4) default 0 comment '预付款(元)'", nullable = false)
   private BigDecimal prepayments;
   @ApiModelProperty(name = "management_fee_rate", notes = "管理费")
   @JsonProperty("management_fee_rate")
   @JSONField(name = "management_fee_rate")
   @TableField("management_fee_rate")
   @Column(name = "management_fee_rate", columnDefinition = "decimal(18,4) default 0 comment '管理费'", nullable = true)
   private BigDecimal managementFeeRate;
   @ApiModelProperty(name = "managementCostId", notes = "管理费配置表id")
   @JsonProperty("management_cost_id")
   @JSONField(name = "management_cost_id")
   @TableField("management_cost_id")
   @Column(name = "management_cost_id", columnDefinition = "bigint(20) comment '管理费配置表id'", nullable = true)
   private Long managementCostId;
   @ApiModelProperty(name = "margin_amount", notes = "保证金（元）")
   @JsonProperty("margin_amount")
   @JSONField(name = "margin_amount")
   @TableField("margin_amount")
   @Column(name = "margin_amount", columnDefinition = "decimal(32,4) default 0.0 comment '保证金(元)'", nullable = false)
   private BigDecimal marginAmount;
   @ApiModelProperty(name = "collectionMarginAmount", notes = "已收取保证金额（元）")
   @TableField("collection_margin_amount")
   @Column(name = "collection_margin_amount", columnDefinition = "decimal(32,4) default 0.0 comment '已收取保证金(元)'", nullable = false)
   private BigDecimal collectionMarginAmount;
   @ApiModelProperty(name = "margin_type", notes = "保证金类型 字典获取")
   @JsonProperty("margin_type")
   @JSONField(name = "margin_type")
   @TableField(value = "margin_type", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "margin_type")
   private Long marginType;
   @ApiModelProperty(name = "margin_type_id", notes = "保证金类型字典id")
   @JsonProperty("margin_type_id")
   @JSONField(name = "margin_type_id")
   @TableField(value = "margin_type_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "margin_type_id", columnDefinition = "int(11) comment '保证金类型字典id'")
   private Long marginTypeId;
   @ApiModelProperty(name = "currency_type", notes = "合同币种 (暂时先固定几种) RMB,EUR,USD,JPY")
   @JsonProperty("currency_type")
   @JSONField(name = "currency_type")
   @TableField(value = "currency_type", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "currency_type", columnDefinition = "varchar(255) comment '合同币种 (暂时先固定几种) RMB,EUR,USD,JPY'")
   private String currencyType;
   @ApiModelProperty(name = "qualityGuaranteeDeposit", notes = "质保金(%)")
   @TableField(value = "quality_guarantee_deposit", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "quality_guarantee_deposit", columnDefinition = "decimal(8,4) comment '质保金(%)'")
   private BigDecimal qualityGuaranteeDeposit;
   @ApiModelProperty(name = "settlement_status", notes = "结算状态 0 未结算 1已结算")
   @JsonProperty("settlement_status")
   @JSONField(name = "settlement_status")
   @TableField("settlement_status")
   @Column(name = "settlement_status", columnDefinition = "int(11) default 0 COMMENT '结算状态 0 未结算 1已结算' ", nullable = false)
   private Integer settlementStatus;
   @ApiModelProperty(name = "settlement_amount", notes = "结算额(元)")
   @JsonProperty("settlement_amount")
   @JSONField(name = "settlement_amount")
   @TableField("settlement_amount")
   @Column(name = "settlement_amount", columnDefinition = "decimal(32,8) default 0.0 COMMENT '结算结算金额'")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "settlementAttachmentId", notes = "结算附件")
   @TableField("settlement_attachment_id")
   @Column(name = "settlement_attachment_id", columnDefinition = "bigint(20) COMMENT '结算附件'")
   private Long settlementAttachmentId;
   @ApiModelProperty(name = "province_id")
   @JsonProperty("province_id")
   @JSONField(name = "province_id")
   @TableField(value = "province_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "province_id", columnDefinition = "int(11) comment '省id'")
   private Long provinceId;
   @ApiModelProperty(name = "province_name")
   @JsonProperty("province_name")
   @JSONField(name = "province_name")
   @TableField(value = "province_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "province_name", columnDefinition = "varchar(255) comment '省名称'")
   private String provinceName;
   @ApiModelProperty(name = "region_id", notes = "区ID")
   @JsonProperty("region_id")
   @JSONField(name = "region_id")
   @TableField(value = "region_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "region_id", columnDefinition = "int(11) comment '省名称'")
   private Long regionId;
   @ApiModelProperty(name = "region_name", notes = "区名称")
   @JsonProperty("region_name")
   @JSONField(name = "region_name")
   @TableField(value = "region_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "region_name", columnDefinition = "varchar(255) comment '区名称'")
   private String regionName;
   @ApiModelProperty(name = "contract_sign_body_id", notes = "合同签订主体id(公司,单位...)")
   @JsonProperty("contract_sign_body_id")
   @JSONField(name = "contract_sign_body_id")
   @TableField("contract_sign_body_id")
   @Column(name = "contract_sign_body_id", columnDefinition = "bigint(20) comment '合同签订主体id'", nullable = false)
   private Long contractSignBodyId;
   @ApiModelProperty(name = "business_type", notes = "业务类型 1.加工承揽  2.项目承包")
   @JsonProperty("business_type")
   @JSONField(name = "business_type")
   @TableField("business_type")
   @Column(name = "business_type", columnDefinition = "int(11) default 1 comment '业务类型 1.加工承揽  2.项目承包'", nullable = false)
   private Integer businessType;
   @ApiModelProperty(name = "project_type", notes = "项目类型   1建筑钢结构 2桥梁钢结构  4立体停车库")
   @JsonProperty("project_type")
   @JSONField(name = "project_type")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11) default '0' comment '项目类型  1建筑钢结构 2桥梁钢结构  4立体停车库'")
   private Integer projectType;
   @ApiModelProperty(name = "project_content", notes = "项目内容")
   @JsonProperty("project_content")
   @JSONField(name = "project_content")
   @TableField("project_content")
   @Column(name = "project_content", columnDefinition = "varchar(255) comment '项目内容ID字符串'")
   private String projectContent;
   @Deprecated
   @ApiModelProperty(name = "structureStatus", value = "结构类型 参考枚举 structureStatusEnum：1.厂房 2.框架类 4.空间结构 8.梁式 16.拱式 32.钢架")
   @TableField("structure_status")
   @Column(name = "structure_status", columnDefinition = "int(11) comment '结构类型 参考枚举 structureStatusEnum：1.厂房 2.框架类 4.空间结构 8.梁式 16.拱式 32.钢架'")
   private Long structureStatus;
   @ApiModelProperty(name = "structureTypeId", value = "结构类型id")
   @TableField(value = "structure_type_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "structure_type_id", columnDefinition = "bigint(20) comment '结构类型id'")
   private Long structureTypeId;
   @ApiModelProperty(name = "productCategory", notes = "项目产品类型")
   @JsonProperty("productCategory")
   @JSONField(name = "productCategory")
   @TableField("product_category")
   @Column(name = "product_category", columnDefinition = "int(11) default 0 comment '项目产品类型'")
   private Integer productCategory;
   @ApiModelProperty(name = "transportMode", notes = "运输方式 1运送到场 2客户自提")
   @JsonProperty("transportMode")
   @JSONField(name = "transportMode")
   @TableField("transport_mode")
   @Column(name = "transport_mode", columnDefinition = "int(11) comment '运输方式 1运送到场 2客户自提' ")
   private Integer transportMode;
   @ApiModelProperty(name = "enclosureTransportMode", notes = "围护运输方式 1运送到场 2客户自提")
   @JsonProperty("enclosureTransportMode")
   @JSONField(name = "enclosureTransportMode")
   @TableField("enclosure_transport_mode")
   @Column(name = "enclosure_transport_mode", columnDefinition = "int(11) comment '围护运输方式 1运送到场 2客户自提' ")
   private Integer enclosureTransportMode;
   @ApiModelProperty(name = "structureMeasureMode", notes = "结构计量方式  1理论计算 2磅记")
   @JsonProperty("structureMeasureMode")
   @JSONField(name = "structureMeasureMode")
   @TableField(value = "structure_measure_mode", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "structure_measure_mode", columnDefinition = "int(11) comment '结构计量方式  1理论计算 2磅记'")
   private Integer structureMeasureMode;
   @ApiModelProperty(name = "enclosureMeasureMode", notes = "围护计量方式 1 长度计量 2 面积计量")
   @JsonProperty("enclosureMeasureMode")
   @JSONField(name = "enclosureMeasureMode")
   @TableField(value = "enclosure_measure_mode", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "enclosure_measure_mode", columnDefinition = "int(11) comment '(字段已废弃)围护计量方式 1 长度计量 2 面积计量'")
   private Integer enclosureMeasureMode;
   @ApiModelProperty(name = "signing_address", notes = "签约地址")
   @JsonProperty("signing_address")
   @JSONField(name = "signing_address")
   @TableField(value = "signing_address", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "signing_address")
   private String signingAddress;
   @ApiModelProperty(name = "signing_date", notes = "签订日期")
   @JsonProperty("signing_date")
   @JSONField(name = "signing_date")
   @TableField(value = "signing_date", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "signing_date")
   private LocalDate signingDate;
   @ApiModelProperty(name = "signer_id", notes = "签约人id")
   @JsonProperty("signer_id")
   @JSONField(name = "signer_id")
   @TableField(value = "signer_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "signer_id")
   private Long signerId;
   @ApiModelProperty(name = "signer_name", notes = "签约人姓名")
   @JsonProperty("signer_name")
   @JSONField(name = "signer_name")
   @TableField(value = "signer_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "signer_name")
   private String signerName;
   @ApiModelProperty(name = "signerPhone", notes = "签约人电话")
   @TableField(value = "signer_phone", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "signer_phone", columnDefinition = "varchar(16) comment '签约人(销售负责人)电话'")
   private String signerPhone;
   @ApiModelProperty(name = "is_tax", notes = "合同额是否含税 1是 0否")
   @JsonProperty("is_tax")
   @JSONField(name = "is_tax")
   @TableField("is_tax")
   @Column(name = "is_tax", columnDefinition = "int(11) default 1 comment '是否含税 1是 0否'")
   private Integer isTax;
   @ApiModelProperty(name = "invoice_type", notes = "发票类型 1 增值税专用发票  2普通发票 4收据")
   @JsonProperty("invoice_type")
   @JSONField(name = "invoice_type")
   @TableField(value = "invoice_type", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "invoice_type", columnDefinition = "int(11) comment '发票类型 1 增值税专用发票  2普通发票 4收据'")
   private Integer invoiceType;
   @ApiModelProperty(name = "tax_rate", notes = "税率")
   @JsonProperty("tax_rate")
   @JSONField(name = "tax_rate")
   @TableField(value = "tax_rate", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "tax_rate", columnDefinition = "decimal(16,5) comment '税率'")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "pay_type", notes = "支付方式  1.对公转账 2对私转账 4承兑汇票 8转账支票 ")
   @JsonProperty("pay_type")
   @JSONField(name = "pay_type")
   @TableField(value = "pay_type", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "pay_type", columnDefinition = "int(11) default 1 comment '支付方式  1.对公转账 2对私转账 4承兑汇票 8转账支票'")
   private Integer payType;
   @ApiModelProperty(name = "pay_type_desc", notes = "支付方式描述")
   @JsonProperty("pay_type_desc")
   @JSONField(name = "pay_type_desc")
   @TableField(value = "pay_type_desc", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "pay_type_desc", columnDefinition = "varchar(255) comment '支付方式描述'")
   private String payTypeDesc;
   @ApiModelProperty(name = "technologyRemark", value = "技术要求描述")
   @JsonProperty("technologyRemark")
   @JSONField(name = "technologyRemark")
   @TableField("technology_remark")
   @Column(name = "technology_remark", columnDefinition = "varchar(255) comment '技术要求描述'")
   private String technologyRemark;
   @ApiModelProperty(name = "customer_unit", notes = "客户单位名称")
   @JsonProperty("customer_unit")
   @JSONField(name = "customer_unit")
   @TableField("customer_unit")
   @Column(name = "customer_unit")
   private String customerUnit;
   @ApiModelProperty(name = "social_code", notes = "客户统一社会信用代码")
   @JsonProperty("social_code")
   @JSONField(name = "social_code")
   @TableField(value = "social_code", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "social_code")
   private String socialCode;
   @ApiModelProperty(name = "customer_unit_phone", notes = "客户单位电话")
   @JsonProperty("customer_unit_phone")
   @JSONField(name = "customer_unit_phone")
   @TableField(value = "customer_unit_phone", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_unit_phone")
   private String customerUnitPhone;
   @ApiModelProperty(name = "customer_email", notes = "客户负邮箱")
   @JsonProperty("customer_email")
   @JSONField(name = "customer_email")
   @TableField(value = "customer_email", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_email")
   private String customerEmail;
   @ApiModelProperty(name = "user_id", notes = "创建项目的用户id")
   @JsonProperty("user_id")
   @JSONField(name = "user_id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) comment '创建人ID'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "status", notes = "项目状态  1：进行中，2：已暂停，4：已完工 ")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default 1 comment '项目状态  1：进行中，2：已暂停，4：已完工'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "customer_province_id", notes = "客户省id")
   @JsonProperty("customer_province_id")
   @JSONField(name = "customer_province_id")
   @TableField(value = "customer_province_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_province_id")
   private Long customerProvinceId;
   @ApiModelProperty(name = "customer_province_name", notes = "客户省名称")
   @JsonProperty("customer_province_name")
   @JSONField(name = "customer_province_name")
   @TableField(value = "customer_province_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_province_name")
   private String customerProvinceName;
   @ApiModelProperty(name = "customer_city_id", notes = "客户单位城市id")
   @JsonProperty("customer_city_id")
   @JSONField(name = "customer_city_id")
   @TableField(value = "customer_city_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_city_id")
   private Long customerCityId;
   @ApiModelProperty(name = "customer_city_name", notes = "客户单位城市名称")
   @JsonProperty("customer_city_name")
   @JSONField(name = "customer_city_name")
   @TableField(value = "customer_city_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_city_name")
   private String customerCityName;
   @ApiModelProperty(name = "customer_region_id", notes = "客户单位区ID")
   @JsonProperty("customer_region_id")
   @JSONField(name = "customer_region_id")
   @TableField(value = "customer_region_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_region_id")
   private Long customerRegionId;
   @ApiModelProperty(name = "customer_region_name", notes = "客户单位区名称")
   @JsonProperty("customer_region_name")
   @JSONField(name = "customer_region_name")
   @TableField(value = "customer_region_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_region_name")
   private String customerRegionName;
   @ApiModelProperty(name = "customer_country_id", notes = "客户单位国家id")
   @JsonProperty("customer_country_id")
   @JSONField(name = "customer_country_id")
   @TableField(value = "customer_country_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_country_id")
   private Long customerCountryId;
   @ApiModelProperty(name = "customer_country_name", notes = "客户单位国家名称")
   @JsonProperty("customer_country_name")
   @JSONField(name = "customer_country_name")
   @TableField(value = "customer_country_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_country_name")
   private String customerCountryName;
   @ApiModelProperty(name = "customer_address", notes = "客户单位详细地址")
   @JsonProperty("customer_address")
   @JSONField(name = "customer_address")
   @TableField(value = "customer_address", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_address")
   private String customerAddress;
   @ApiModelProperty(name = "customer_bank_user_name", notes = "客户银行账户户名")
   @JsonProperty("customer_bank_user_name")
   @JSONField(name = "customer_bank_user_name")
   @TableField(value = "customer_bank_user_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_bank_user_name")
   private String customerBankUserName;
   @ApiModelProperty(name = "customer_bank_code", notes = "客户银行账户账号")
   @JsonProperty("customer_bank_code")
   @JSONField(name = "customer_bank_code")
   @TableField(value = "customer_bank_code", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_bank_code")
   private String customerBankCode;
   @ApiModelProperty(name = "customer_bank_name", notes = "客户开户行   (中国工商银行...)")
   @JsonProperty("customer_bank_name")
   @JSONField(name = "customer_bank_name")
   @TableField(value = "customer_bank_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_bank_name")
   private String customerBankName;
   @ApiModelProperty(name = "customer_manager_one", notes = "客户负责人1姓名")
   @JsonProperty("customer_manager_one")
   @JSONField(name = "customer_manager_one")
   @TableField(value = "customer_manager_one", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_manager_one")
   private String customerManagerOne;
   @ApiModelProperty(name = "customer_manager_one_phone", notes = "客户负责人1电话")
   @JsonProperty("customer_manager_one_phone")
   @JSONField(name = "customer_manager_one_phone")
   @TableField(value = "customer_manager_one_phone", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_manager_one_phone")
   private String customerManagerOnePhone;
   @ApiModelProperty(name = "customer_manager_two", notes = "客户负责人2姓名")
   @JsonProperty("customer_manager_two")
   @JSONField(name = "customer_manager_two")
   @TableField(value = "customer_manager_two", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_manager_two")
   private String customerManagerTwo;
   @ApiModelProperty(name = "customer_manager_two_phone", notes = "客户负责人2电话")
   @JsonProperty("customer_manager_two_phone")
   @JSONField(name = "customer_manager_two_phone")
   @TableField(value = "customer_manager_two_phone", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "customer_manager_two_phone")
   private String customerManagerTwoPhone;
   @ApiModelProperty(name = "receivingManager", notes = "收货负责人")
   @TableField("receiving_manager")
   @Column(name = "receiving_manager", columnDefinition = "varchar(32) comment '收货负责人'")
   private String receivingManager;
   @ApiModelProperty(name = "receivingManagerPhone", notes = "收货负责人电话")
   @TableField("receiving_manager_phone")
   @Column(name = "receiving_manager_phone", columnDefinition = "varchar(32) comment '收货负责人电话'")
   private String receivingManagerPhone;
   @ApiModelProperty(name = "settleManager", notes = "结算负责人")
   @TableField(value = "settle_manager", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "settle_manager", columnDefinition = "varchar(32) comment '结算负责人'")
   private String settleManager;
   @ApiModelProperty(name = "settleManagerPhone", notes = "结算负责人电话")
   @TableField(value = "settle_manager_phone", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "settle_manager_phone", columnDefinition = "varchar(32) comment '结算负责人电话'")
   private String settleManagerPhone;
   @ApiModelProperty(name = "financeManager", notes = "财务负责人")
   @TableField(value = "finance_manager", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "finance_manager", columnDefinition = "varchar(32) comment '财务负责人'")
   private String financeManager;
   @ApiModelProperty(name = "financeManagerPhone", notes = "财务负责人电话")
   @TableField(value = "finance_manager_phone", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "finance_manager_phone", columnDefinition = "varchar(32) comment '财务负责人电话'")
   private String financeManagerPhone;
   @ApiModelProperty(name = "auditManager", notes = "审核负责人")
   @TableField(value = "audit_manager", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "audit_manager", columnDefinition = "varchar(32) comment '审核负责人'")
   private String auditManager;
   @ApiModelProperty(name = "auditManagerPhone", notes = "审核负责人电话")
   @TableField(value = "audit_manager_phone", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "audit_manager_phone", columnDefinition = "varchar(32) comment '审核负责人电话'")
   private String auditManagerPhone;
   @ApiModelProperty(name = "designManager", notes = "设计负责人")
   @TableField(value = "design_manager", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "design_manager", columnDefinition = "varchar(32) comment '设计负责人'")
   private String designManager;
   @ApiModelProperty(name = "designManagerPhone", notes = "设计负责人电话")
   @TableField(value = "design_manager_phone", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "design_manager_phone", columnDefinition = "varchar(32) comment '设计负责人电话'")
   private String designManagerPhone;
   @ApiModelProperty(name = "mode", notes = "项目模式 1简约模式 2 标准模式")
   @JsonProperty("mode")
   @JSONField(name = "mode")
   @TableField("mode")
   @Column(name = "mode", columnDefinition = "int(11) default 1 comment '项目模式 1简约模式 2 标准模式 '", nullable = false)
   private Integer mode;
   @ApiModelProperty(name = "boolRequiredWarehouse", value = "是否必选库位 true必选 false非必选")
   @TableField("bool_required_warehouse")
   @Column(name = "bool_required_warehouse", columnDefinition = "tinyint(1) default 0 comment '是否必选库位 1必选 0非必选'", nullable = false)
   private Boolean boolRequiredWarehouse;
   @ApiModelProperty(name = "mesStartDate", notes = "mes开始日期")
   @JsonProperty("mesStartDate")
   @JSONField(name = "mesStartDate")
   @TableField("mes_start_date")
   @Column(name = "mes_start_date")
   private LocalDateTime mesStartDate;
   @ApiModelProperty(name = "mesEndDate", notes = "mes结束日期")
   @JsonProperty("mesEndDate")
   @JSONField(name = "mesEndDate")
   @TableField("mes_end_date")
   @Column(name = "mes_end_date")
   private LocalDateTime mesEndDate;
   @ApiModelProperty(name = "happenedAmount", notes = "已发生额(发运额或者安装额)")
   @JsonProperty("happenedAmount")
   @JSONField(name = "happenedAmount")
   @TableField("happened_amount")
   @Column(name = "happened_amount", columnDefinition = "decimal(32,8) default 0.0 comment '已发生额(发运额或者安装额)'")
   private BigDecimal happenedAmount;
   @ApiModelProperty(name = "outFinishStatus", notes = "项目(出库/安装)完成状态 1已完成 0未完成")
   @JsonProperty("outFinishStatus")
   @JSONField(name = "outFinishStatus")
   @TableField("out_finish_status")
   @Column(name = "out_finish_status", nullable = false, columnDefinition = "tinyint(1) DEFAULT 0 comment '项目(出库/安装)完成状态 1已完成 0未完成' ")
   private Boolean outFinishStatus;
   @ApiModelProperty(name = "boolArrears", notes = "项目是否欠款 1欠款 0不欠款, 枚举: ProjectBoolArrearsEnum ")
   @JsonProperty("boolArrears")
   @JSONField(name = "boolArrears")
   @TableField("bool_arrears")
   @Column(name = "bool_arrears", nullable = false, columnDefinition = "tinyint(1) DEFAULT 0 comment '项目是否欠款 1欠款 0不欠款'")
   private Boolean boolArrears;
   @ApiModelProperty(name = "collection_amount", notes = "项目已收款额")
   @TableField("collection_amount")
   @Column(name = "collection_amount", nullable = false, columnDefinition = "decimal(19,2) DEFAULT 0.00 comment '项目已收款额' ")
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "collection_summary", notes = "项目总结余")
   @TableField("collection_summary")
   @Column(name = "collection_summary", nullable = false, columnDefinition = "decimal(19,2) DEFAULT 0.00 comment '项目总结余' ")
   private BigDecimal collectionSummary;
   @ApiModelProperty(name = "invoice_amount", notes = "项目已开票额")
   @TableField("invoice_amount")
   @Column(name = "invoice_amount", nullable = false, columnDefinition = "decimal(19,2) DEFAULT 0.00 comment '项目已开票额' ")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "installReportMethod", notes = "项目安装填报方式")
   @TableField("install_report_method")
   @Column(name = "install_report_method", columnDefinition = "int(11) DEFAULT 0 comment '项目安装填报方式 1:app端 0:pc端' ")
   private Integer installReportMethod;
   @ApiModelProperty(name = "orderSourceType", value = "项目订单来源类型 1内部 2外部 枚举:OrderSourceTypeEnum")
   @TableField("order_source_type")
   @Column(name = "order_source_type", columnDefinition = "int(11) DEFAULT 2 comment '项目订单来源类型 1内部 2外部'")
   private Integer orderSourceType;
   @ApiModelProperty(name = "customerRemark", notes = "客户信息备注")
   @TableField("customer_remark")
   @Column(name = "customer_remark", columnDefinition = "text comment '客户信息备注'")
   private String customerRemark;
   @ApiModelProperty(name = "isEffective", notes = "合同是否有效 1.有效 0.无效")
   @TableField("is_effective")
   @Column(name = "is_effective", columnDefinition = "int(11) comment '合同是否有效 1.有效 0.无效'")
   private Integer isEffective;
   @ApiModelProperty(name = "commercialClause", value = "商务条款")
   @JsonProperty("commercialClause")
   @JSONField(name = "commercialClause")
   @TableField("commercial_clause")
   @Column(name = "commercial_clause", columnDefinition = "text comment '商务条款'")
   private String commercialClause;
   @ApiModelProperty(name = "technologyClause", value = "技术条款")
   @JsonProperty("technologyClause")
   @JSONField(name = "technologyClause")
   @TableField("technology_clause")
   @Column(name = "technology_clause", columnDefinition = "text comment '技术条款'")
   private String technologyClause;
   @ApiModelProperty(name = "otherRemarks", value = "其他备注条款")
   @JsonProperty("otherRemarks")
   @JSONField(name = "otherRemarks")
   @TableField("other_remarks")
   @Column(name = "other_remarks", columnDefinition = "text comment '其他备注条款'")
   private String otherRemarks;
   @ApiModelProperty(name = "pId", notes = "父合同id")
   @TableField("p_id")
   @Column(name = "p_id", columnDefinition = "int(11) comment '父合同id'")
   private Long pId;
   @ApiModelProperty(name = "sendingMode", value = "发包方式 1.业主直接发包 2.专业分包 3.总承包 参考枚举SendingModeEnum")
   @JsonProperty("sendingMode")
   @JSONField(name = "sendingMode")
   @TableField(value = "sending_mode", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "sending_mode", columnDefinition = " int(11) comment'发包方式'")
   private Long sendingMode;
   @ApiModelProperty(name = "infoSource", value = "信息来源 参考枚举:InfoSourceEnum 1.销售与经理 2.经理与销售 3.销售 ")
   @JsonProperty("infoSource")
   @JSONField(name = "infoSource")
   @TableField(value = "info_source", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "info_source", columnDefinition = "int(11) comment'信息来源'")
   private Long infoSource;
   @ApiModelProperty(name = "isBuilding", value = "装配式建筑 1.是  0.否")
   @JsonProperty("isBuilding")
   @JSONField(name = "isBuilding")
   @TableField(value = "is_building", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "is_building", columnDefinition = "int(11) comment'装配式建筑 1.是  0.否'")
   private Integer isBuilding;
   @ApiModelProperty(name = "deptId", value = "承接部门id")
   @TableField("dept_id")
   @Column(name = "dept_id", columnDefinition = "int(11)  comment '承接部门id' ")
   private Long deptId;
   @ApiModelProperty(name = "allDays", value = "项目总天数")
   @JsonProperty("allDays")
   @JSONField(name = "allDays")
   @TableField(value = "all_days", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "all_days", columnDefinition = "int(11) comment '项目总天数'")
   private Integer allDays;
   @ApiModelProperty(name = "partyType", value = "甲方类型 参考枚举:PartyTypeEnum 1.民企 2.国企 3.央企 4.民企上市公司 5.国企上市公司 6.央企上市公司")
   @JsonProperty("partyType")
   @JSONField(name = "partyType")
   @TableField(value = "party_type", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "party_type", columnDefinition = "int(11) comment '甲方类型'")
   private Long partyType;
   @ApiModelProperty(name = "structureArea", value = "建筑面积")
   @JsonProperty("structureArea")
   @JSONField(name = "structureArea")
   @TableField("structure_area")
   @Column(name = "structure_area", columnDefinition = "decimal(32,8) comment '建筑面积'")
   private BigDecimal structureArea;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性: 1.自营 2.合营 3.包干制 参考枚举：ProjectAttributeEnum")
   @JsonProperty("projectAttribute")
   @JSONField(name = "projectAttribute")
   @TableField("project_attribute")
   @Column(name = "project_attribute", columnDefinition = "int(11) DEFAULT 1 comment '项目属性: 1.自营 2.合营 3.包干制'", nullable = false)
   private Integer projectAttribute;
   @ApiModelProperty(name = "contractType", value = "选择类型 1.主合同 2.工程量增补合同 3.补充合同 参考枚举：ContractTypeEnum")
   @JsonProperty("contractType")
   @JSONField(name = "contractType")
   @TableField("contract_type")
   @Column(name = "contract_type", columnDefinition = "int(11) comment '选择类型 1.主合同 2.工程量增补合同 3.补充合同'")
   private Integer contractType;
   @ApiModelProperty(name = "lumpSumSystemType", notes = "包干制项目管理选项 参考枚举：LumpSumSystemEnum 1.无管控，需加工 2.无管控，无加工 3.需加工，需管控 4.需加工，无需管控")
   @JsonProperty("lumpSumSystemType")
   @JSONField(name = "lumpSumSystemType")
   @TableField("lump_sum_system_type")
   @Column(name = "lump_sum_system_type", columnDefinition = "int(11) default 1 comment '项目包干制项目管理选项'")
   private Integer lumpSumSystemType;
   @ApiModelProperty(name = "isArchive", value = "是否归档 1.归档 0.未归档")
   @JsonProperty("isArchive")
   @JSONField(name = "isArchive")
   @TableField("is_archive")
   @Column(name = "is_archive", columnDefinition = "int(11) comment '是否归档 1.归档 0.未归档'")
   private Integer isArchive;
   @ApiModelProperty(name = "unitType", value = "单位类型 1.吨 2.平方米")
   @JsonProperty("unitType")
   @JSONField(name = "unitType")
   @TableField("unit_type")
   @Column(name = "unit_type", columnDefinition = "int(11) comment '单位类型 1.吨 2.平方米'")
   private Integer unitType;
   @ApiModelProperty(name = "isDeposit", value = "保证金是否缴过")
   @JsonProperty("isDeposit")
   @JSONField(name = "isDeposit")
   @TableField("is_deposit")
   @Column(name = "is_deposit", columnDefinition = "tinyint(1) default '0' comment  '保证金是否缴过(0、未缴过，1、缴过费)'")
   private Boolean isDeposit;
   @ApiModelProperty(name = "contract_sign_body_scale", notes = "合同签订主体占比(0~100)")
   @JsonProperty("contract_sign_body_scale")
   @JSONField(name = "contract_sign_body_scale")
   @TableField("contract_sign_body_scale")
   @Column(name = "contract_sign_body_scale", columnDefinition = "decimal(32,2) DEFAULT 0 comment '合同签订主体占比(0~100)'", nullable = false)
   private BigDecimal contractSignBodyScale;
   @ApiModelProperty(name = "contract_sign_body_amount", notes = "合同签订主体结余")
   @JsonProperty("contract_sign_body_amount")
   @JSONField(name = "contract_sign_body_amount")
   @TableField("contract_sign_body_amount")
   @Column(name = "contract_sign_body_amount", columnDefinition = "decimal(32,2) DEFAULT 0.00 comment '合同签订主体结余'", nullable = false)
   private BigDecimal contractSignBodyAmount;
   @ApiModelProperty(name = "project_manager_scale", notes = "项目经理占比(0~100)")
   @JsonProperty("project_manager_scale")
   @JSONField(name = "project_manager_scale")
   @TableField("project_manager_scale")
   @Column(name = "project_manager_scale", columnDefinition = "decimal(32,2) DEFAULT 0 comment '项目经理占比(0~100)'", nullable = false)
   private BigDecimal projectManagerScale;
   @ApiModelProperty(name = "project_manager_amount", notes = "项目经理结余")
   @JsonProperty("project_manager_amount")
   @JSONField(name = "project_manager_amount")
   @TableField("project_manager_amount")
   @Column(name = "project_manager_amount", columnDefinition = "decimal(32,2) DEFAULT 0.00 comment '项目经理结余'", nullable = false)
   private BigDecimal projectManagerAmount;
   @ApiModelProperty(name = "contractSignBodyCollectBalance", notes = "签订主体收款结余")
   @TableField("contract_sign_body_collect_balance")
   @Column(name = "contract_sign_body_collect_balance", columnDefinition = "decimal(32,2) DEFAULT 0.00 comment '签订主体收款结余'", nullable = false)
   private BigDecimal contractSignBodyCollectBalance;
   @ApiModelProperty(name = "contractSignBodyInjectionBalance", notes = "签订主体注资结余")
   @TableField("contract_sign_body_injection_balance")
   @Column(name = "contract_sign_body_injection_balance", columnDefinition = "decimal(32,2) DEFAULT 0.00 comment '签订主体注资结余'", nullable = false)
   private BigDecimal contractSignBodyInjectionBalance;
   @ApiModelProperty(name = "projectManagerCollectBalance", notes = "项目经理收款结余")
   @TableField("project_manager_collect_balance")
   @Column(name = "project_manager_collect_balance", columnDefinition = "decimal(32,2) DEFAULT 0.00 comment '项目经理收款结余'", nullable = false)
   private BigDecimal projectManagerCollectBalance;
   @ApiModelProperty(name = "projectManagerInjectionBalance", notes = "项目经理注资结余")
   @TableField("project_manager_injection_balance")
   @Column(name = "project_manager_injection_balance", columnDefinition = "decimal(32,2) DEFAULT 0.00 comment '项目经理注资结余'", nullable = false)
   private BigDecimal projectManagerInjectionBalance;
   @ApiModelProperty(name = "level")
   @JsonProperty("level")
   @JSONField(name = "level")
   @TableField("level")
   @Column(name = "level", columnDefinition = "bigint(20) COMMENT '单位层级 1:一级单位 2:二级单位'")
   private Integer level;
   @ApiModelProperty(name = "installDivideMethod", notes = "项目安装内容划分方式")
   @TableField("install_divide_method")
   @Column(name = "install_divide_method", columnDefinition = "int(11) comment '项目安装内容划分方式 1:按清单划分 0:按区域划分' ")
   private Integer installDivideMethod;
   @ApiModelProperty(name = "lastUpdateTime", notes = "最后编辑时间")
   @JsonProperty("lastUpdateTime")
   @JSONField(name = "lastUpdateTime")
   @TableField("last_update_time")
   @Column(name = "last_update_time", columnDefinition = "datetime comment '最后编辑时间'")
   private LocalDateTime lastUpdateTime;
   @ApiModelProperty(name = "lastUpdateUserId", notes = "最后编辑人")
   @JsonProperty("lastUpdateUserId")
   @JSONField(name = "lastUpdateUserId")
   @TableField("last_update_user_id")
   @Column(name = "last_update_user_id", columnDefinition = "bigint(20) comment '最后编辑人'")
   private Long lastUpdateUserId;

   public static ContractProject.ContractProjectBuilder builder() {
      return new ContractProject.ContractProjectBuilder();
   }

   public ContractProject() {
   }

   public ContractProject(
      final Long id,
      final String serialNumber,
      final String name,
      final String shortName,
      final LocalDate startDate,
      final LocalDate endDate,
      final LocalDate completeDate,
      final String address,
      final Long projectManagerId,
      final String projectManagerName,
      final String projectManagerPhone,
      final Long salesLeaderId,
      final Long businessLeaderId,
      final Long businessLeaderTwoId,
      final String attachments,
      final String archives,
      final Long cityId,
      final String cityName,
      final Long countryId,
      final String countryName,
      final BigDecimal contractAmount,
      final BigDecimal prepayments,
      final BigDecimal managementFeeRate,
      final Long managementCostId,
      final BigDecimal marginAmount,
      final BigDecimal collectionMarginAmount,
      final Long marginType,
      final Long marginTypeId,
      final String currencyType,
      final BigDecimal qualityGuaranteeDeposit,
      final Integer settlementStatus,
      final BigDecimal settlementAmount,
      final Long settlementAttachmentId,
      final Long provinceId,
      final String provinceName,
      final Long regionId,
      final String regionName,
      final Long contractSignBodyId,
      final Integer businessType,
      final Integer projectType,
      final String projectContent,
      final Long structureStatus,
      final Long structureTypeId,
      final Integer productCategory,
      final Integer transportMode,
      final Integer enclosureTransportMode,
      final Integer structureMeasureMode,
      final Integer enclosureMeasureMode,
      final String signingAddress,
      final LocalDate signingDate,
      final Long signerId,
      final String signerName,
      final String signerPhone,
      final Integer isTax,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final Integer payType,
      final String payTypeDesc,
      final String technologyRemark,
      final String customerUnit,
      final String socialCode,
      final String customerUnitPhone,
      final String customerEmail,
      final Long userId,
      final Integer status,
      final Long customerProvinceId,
      final String customerProvinceName,
      final Long customerCityId,
      final String customerCityName,
      final Long customerRegionId,
      final String customerRegionName,
      final Long customerCountryId,
      final String customerCountryName,
      final String customerAddress,
      final String customerBankUserName,
      final String customerBankCode,
      final String customerBankName,
      final String customerManagerOne,
      final String customerManagerOnePhone,
      final String customerManagerTwo,
      final String customerManagerTwoPhone,
      final String receivingManager,
      final String receivingManagerPhone,
      final String settleManager,
      final String settleManagerPhone,
      final String financeManager,
      final String financeManagerPhone,
      final String auditManager,
      final String auditManagerPhone,
      final String designManager,
      final String designManagerPhone,
      final Integer mode,
      final Boolean boolRequiredWarehouse,
      final LocalDateTime mesStartDate,
      final LocalDateTime mesEndDate,
      final BigDecimal happenedAmount,
      final Boolean outFinishStatus,
      final Boolean boolArrears,
      final BigDecimal collectionAmount,
      final BigDecimal collectionSummary,
      final BigDecimal invoiceAmount,
      final Integer installReportMethod,
      final Integer orderSourceType,
      final String customerRemark,
      final Integer isEffective,
      final String commercialClause,
      final String technologyClause,
      final String otherRemarks,
      final Long pId,
      final Long sendingMode,
      final Long infoSource,
      final Integer isBuilding,
      final Long deptId,
      final Integer allDays,
      final Long partyType,
      final BigDecimal structureArea,
      final Integer projectAttribute,
      final Integer contractType,
      final Integer lumpSumSystemType,
      final Integer isArchive,
      final Integer unitType,
      final Boolean isDeposit,
      final BigDecimal contractSignBodyScale,
      final BigDecimal contractSignBodyAmount,
      final BigDecimal projectManagerScale,
      final BigDecimal projectManagerAmount,
      final BigDecimal contractSignBodyCollectBalance,
      final BigDecimal contractSignBodyInjectionBalance,
      final BigDecimal projectManagerCollectBalance,
      final BigDecimal projectManagerInjectionBalance,
      final Integer level,
      final Integer installDivideMethod,
      final LocalDateTime lastUpdateTime,
      final Long lastUpdateUserId
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.name = name;
      this.shortName = shortName;
      this.startDate = startDate;
      this.endDate = endDate;
      this.completeDate = completeDate;
      this.address = address;
      this.projectManagerId = projectManagerId;
      this.projectManagerName = projectManagerName;
      this.projectManagerPhone = projectManagerPhone;
      this.salesLeaderId = salesLeaderId;
      this.businessLeaderId = businessLeaderId;
      this.businessLeaderTwoId = businessLeaderTwoId;
      this.attachments = attachments;
      this.archives = archives;
      this.cityId = cityId;
      this.cityName = cityName;
      this.countryId = countryId;
      this.countryName = countryName;
      this.contractAmount = contractAmount;
      this.prepayments = prepayments;
      this.managementFeeRate = managementFeeRate;
      this.managementCostId = managementCostId;
      this.marginAmount = marginAmount;
      this.collectionMarginAmount = collectionMarginAmount;
      this.marginType = marginType;
      this.marginTypeId = marginTypeId;
      this.currencyType = currencyType;
      this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
      this.settlementStatus = settlementStatus;
      this.settlementAmount = settlementAmount;
      this.settlementAttachmentId = settlementAttachmentId;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.contractSignBodyId = contractSignBodyId;
      this.businessType = businessType;
      this.projectType = projectType;
      this.projectContent = projectContent;
      this.structureStatus = structureStatus;
      this.structureTypeId = structureTypeId;
      this.productCategory = productCategory;
      this.transportMode = transportMode;
      this.enclosureTransportMode = enclosureTransportMode;
      this.structureMeasureMode = structureMeasureMode;
      this.enclosureMeasureMode = enclosureMeasureMode;
      this.signingAddress = signingAddress;
      this.signingDate = signingDate;
      this.signerId = signerId;
      this.signerName = signerName;
      this.signerPhone = signerPhone;
      this.isTax = isTax;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.payType = payType;
      this.payTypeDesc = payTypeDesc;
      this.technologyRemark = technologyRemark;
      this.customerUnit = customerUnit;
      this.socialCode = socialCode;
      this.customerUnitPhone = customerUnitPhone;
      this.customerEmail = customerEmail;
      this.userId = userId;
      this.status = status;
      this.customerProvinceId = customerProvinceId;
      this.customerProvinceName = customerProvinceName;
      this.customerCityId = customerCityId;
      this.customerCityName = customerCityName;
      this.customerRegionId = customerRegionId;
      this.customerRegionName = customerRegionName;
      this.customerCountryId = customerCountryId;
      this.customerCountryName = customerCountryName;
      this.customerAddress = customerAddress;
      this.customerBankUserName = customerBankUserName;
      this.customerBankCode = customerBankCode;
      this.customerBankName = customerBankName;
      this.customerManagerOne = customerManagerOne;
      this.customerManagerOnePhone = customerManagerOnePhone;
      this.customerManagerTwo = customerManagerTwo;
      this.customerManagerTwoPhone = customerManagerTwoPhone;
      this.receivingManager = receivingManager;
      this.receivingManagerPhone = receivingManagerPhone;
      this.settleManager = settleManager;
      this.settleManagerPhone = settleManagerPhone;
      this.financeManager = financeManager;
      this.financeManagerPhone = financeManagerPhone;
      this.auditManager = auditManager;
      this.auditManagerPhone = auditManagerPhone;
      this.designManager = designManager;
      this.designManagerPhone = designManagerPhone;
      this.mode = mode;
      this.boolRequiredWarehouse = boolRequiredWarehouse;
      this.mesStartDate = mesStartDate;
      this.mesEndDate = mesEndDate;
      this.happenedAmount = happenedAmount;
      this.outFinishStatus = outFinishStatus;
      this.boolArrears = boolArrears;
      this.collectionAmount = collectionAmount;
      this.collectionSummary = collectionSummary;
      this.invoiceAmount = invoiceAmount;
      this.installReportMethod = installReportMethod;
      this.orderSourceType = orderSourceType;
      this.customerRemark = customerRemark;
      this.isEffective = isEffective;
      this.commercialClause = commercialClause;
      this.technologyClause = technologyClause;
      this.otherRemarks = otherRemarks;
      this.pId = pId;
      this.sendingMode = sendingMode;
      this.infoSource = infoSource;
      this.isBuilding = isBuilding;
      this.deptId = deptId;
      this.allDays = allDays;
      this.partyType = partyType;
      this.structureArea = structureArea;
      this.projectAttribute = projectAttribute;
      this.contractType = contractType;
      this.lumpSumSystemType = lumpSumSystemType;
      this.isArchive = isArchive;
      this.unitType = unitType;
      this.isDeposit = isDeposit;
      this.contractSignBodyScale = contractSignBodyScale;
      this.contractSignBodyAmount = contractSignBodyAmount;
      this.projectManagerScale = projectManagerScale;
      this.projectManagerAmount = projectManagerAmount;
      this.contractSignBodyCollectBalance = contractSignBodyCollectBalance;
      this.contractSignBodyInjectionBalance = contractSignBodyInjectionBalance;
      this.projectManagerCollectBalance = projectManagerCollectBalance;
      this.projectManagerInjectionBalance = projectManagerInjectionBalance;
      this.level = level;
      this.installDivideMethod = installDivideMethod;
      this.lastUpdateTime = lastUpdateTime;
      this.lastUpdateUserId = lastUpdateUserId;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public LocalDate getCompleteDate() {
      return this.completeDate;
   }

   public String getAddress() {
      return this.address;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public String getProjectManagerPhone() {
      return this.projectManagerPhone;
   }

   public Long getSalesLeaderId() {
      return this.salesLeaderId;
   }

   public Long getBusinessLeaderId() {
      return this.businessLeaderId;
   }

   public Long getBusinessLeaderTwoId() {
      return this.businessLeaderTwoId;
   }

   public String getAttachments() {
      return this.attachments;
   }

   public String getArchives() {
      return this.archives;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public String getCityName() {
      return this.cityName;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public String getCountryName() {
      return this.countryName;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getPrepayments() {
      return this.prepayments;
   }

   public BigDecimal getManagementFeeRate() {
      return this.managementFeeRate;
   }

   public Long getManagementCostId() {
      return this.managementCostId;
   }

   public BigDecimal getMarginAmount() {
      return this.marginAmount;
   }

   public BigDecimal getCollectionMarginAmount() {
      return this.collectionMarginAmount;
   }

   public Long getMarginType() {
      return this.marginType;
   }

   public Long getMarginTypeId() {
      return this.marginTypeId;
   }

   public String getCurrencyType() {
      return this.currencyType;
   }

   public BigDecimal getQualityGuaranteeDeposit() {
      return this.qualityGuaranteeDeposit;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public Long getSettlementAttachmentId() {
      return this.settlementAttachmentId;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public String getProvinceName() {
      return this.provinceName;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public String getRegionName() {
      return this.regionName;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public String getProjectContent() {
      return this.projectContent;
   }

   @Deprecated
   public Long getStructureStatus() {
      return this.structureStatus;
   }

   public Long getStructureTypeId() {
      return this.structureTypeId;
   }

   public Integer getProductCategory() {
      return this.productCategory;
   }

   public Integer getTransportMode() {
      return this.transportMode;
   }

   public Integer getEnclosureTransportMode() {
      return this.enclosureTransportMode;
   }

   public Integer getStructureMeasureMode() {
      return this.structureMeasureMode;
   }

   public Integer getEnclosureMeasureMode() {
      return this.enclosureMeasureMode;
   }

   public String getSigningAddress() {
      return this.signingAddress;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
   }

   public Long getSignerId() {
      return this.signerId;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public String getSignerPhone() {
      return this.signerPhone;
   }

   public Integer getIsTax() {
      return this.isTax;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getPayType() {
      return this.payType;
   }

   public String getPayTypeDesc() {
      return this.payTypeDesc;
   }

   public String getTechnologyRemark() {
      return this.technologyRemark;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public String getSocialCode() {
      return this.socialCode;
   }

   public String getCustomerUnitPhone() {
      return this.customerUnitPhone;
   }

   public String getCustomerEmail() {
      return this.customerEmail;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getCustomerProvinceId() {
      return this.customerProvinceId;
   }

   public String getCustomerProvinceName() {
      return this.customerProvinceName;
   }

   public Long getCustomerCityId() {
      return this.customerCityId;
   }

   public String getCustomerCityName() {
      return this.customerCityName;
   }

   public Long getCustomerRegionId() {
      return this.customerRegionId;
   }

   public String getCustomerRegionName() {
      return this.customerRegionName;
   }

   public Long getCustomerCountryId() {
      return this.customerCountryId;
   }

   public String getCustomerCountryName() {
      return this.customerCountryName;
   }

   public String getCustomerAddress() {
      return this.customerAddress;
   }

   public String getCustomerBankUserName() {
      return this.customerBankUserName;
   }

   public String getCustomerBankCode() {
      return this.customerBankCode;
   }

   public String getCustomerBankName() {
      return this.customerBankName;
   }

   public String getCustomerManagerOne() {
      return this.customerManagerOne;
   }

   public String getCustomerManagerOnePhone() {
      return this.customerManagerOnePhone;
   }

   public String getCustomerManagerTwo() {
      return this.customerManagerTwo;
   }

   public String getCustomerManagerTwoPhone() {
      return this.customerManagerTwoPhone;
   }

   public String getReceivingManager() {
      return this.receivingManager;
   }

   public String getReceivingManagerPhone() {
      return this.receivingManagerPhone;
   }

   public String getSettleManager() {
      return this.settleManager;
   }

   public String getSettleManagerPhone() {
      return this.settleManagerPhone;
   }

   public String getFinanceManager() {
      return this.financeManager;
   }

   public String getFinanceManagerPhone() {
      return this.financeManagerPhone;
   }

   public String getAuditManager() {
      return this.auditManager;
   }

   public String getAuditManagerPhone() {
      return this.auditManagerPhone;
   }

   public String getDesignManager() {
      return this.designManager;
   }

   public String getDesignManagerPhone() {
      return this.designManagerPhone;
   }

   public Integer getMode() {
      return this.mode;
   }

   public Boolean getBoolRequiredWarehouse() {
      return this.boolRequiredWarehouse;
   }

   public LocalDateTime getMesStartDate() {
      return this.mesStartDate;
   }

   public LocalDateTime getMesEndDate() {
      return this.mesEndDate;
   }

   public BigDecimal getHappenedAmount() {
      return this.happenedAmount;
   }

   public Boolean getOutFinishStatus() {
      return this.outFinishStatus;
   }

   public Boolean getBoolArrears() {
      return this.boolArrears;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public BigDecimal getCollectionSummary() {
      return this.collectionSummary;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public Integer getInstallReportMethod() {
      return this.installReportMethod;
   }

   public Integer getOrderSourceType() {
      return this.orderSourceType;
   }

   public String getCustomerRemark() {
      return this.customerRemark;
   }

   public Integer getIsEffective() {
      return this.isEffective;
   }

   public String getCommercialClause() {
      return this.commercialClause;
   }

   public String getTechnologyClause() {
      return this.technologyClause;
   }

   public String getOtherRemarks() {
      return this.otherRemarks;
   }

   public Long getPId() {
      return this.pId;
   }

   public Long getSendingMode() {
      return this.sendingMode;
   }

   public Long getInfoSource() {
      return this.infoSource;
   }

   public Integer getIsBuilding() {
      return this.isBuilding;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public Integer getAllDays() {
      return this.allDays;
   }

   public Long getPartyType() {
      return this.partyType;
   }

   public BigDecimal getStructureArea() {
      return this.structureArea;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Integer getContractType() {
      return this.contractType;
   }

   public Integer getLumpSumSystemType() {
      return this.lumpSumSystemType;
   }

   public Integer getIsArchive() {
      return this.isArchive;
   }

   public Integer getUnitType() {
      return this.unitType;
   }

   public Boolean getIsDeposit() {
      return this.isDeposit;
   }

   public BigDecimal getContractSignBodyScale() {
      return this.contractSignBodyScale;
   }

   public BigDecimal getContractSignBodyAmount() {
      return this.contractSignBodyAmount;
   }

   public BigDecimal getProjectManagerScale() {
      return this.projectManagerScale;
   }

   public BigDecimal getProjectManagerAmount() {
      return this.projectManagerAmount;
   }

   public BigDecimal getContractSignBodyCollectBalance() {
      return this.contractSignBodyCollectBalance;
   }

   public BigDecimal getContractSignBodyInjectionBalance() {
      return this.contractSignBodyInjectionBalance;
   }

   public BigDecimal getProjectManagerCollectBalance() {
      return this.projectManagerCollectBalance;
   }

   public BigDecimal getProjectManagerInjectionBalance() {
      return this.projectManagerInjectionBalance;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Integer getInstallDivideMethod() {
      return this.installDivideMethod;
   }

   public LocalDateTime getLastUpdateTime() {
      return this.lastUpdateTime;
   }

   public Long getLastUpdateUserId() {
      return this.lastUpdateUserId;
   }

   @JsonProperty("id")
   public ContractProject setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serial_number")
   public ContractProject setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("name")
   public ContractProject setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("short_name")
   public ContractProject setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("start_date")
   public ContractProject setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("end_date")
   public ContractProject setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
      return this;
   }

   @JsonProperty("complete_date")
   public ContractProject setCompleteDate(final LocalDate completeDate) {
      this.completeDate = completeDate;
      return this;
   }

   @JsonProperty("address")
   public ContractProject setAddress(final String address) {
      this.address = address;
      return this;
   }

   @JsonProperty("project_manager_id")
   public ContractProject setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public ContractProject setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
      return this;
   }

   public ContractProject setProjectManagerPhone(final String projectManagerPhone) {
      this.projectManagerPhone = projectManagerPhone;
      return this;
   }

   @JsonProperty("salesLeaderId")
   public ContractProject setSalesLeaderId(final Long salesLeaderId) {
      this.salesLeaderId = salesLeaderId;
      return this;
   }

   @JsonProperty("business_leader_id")
   public ContractProject setBusinessLeaderId(final Long businessLeaderId) {
      this.businessLeaderId = businessLeaderId;
      return this;
   }

   @JsonProperty("business_leader_two_id")
   public ContractProject setBusinessLeaderTwoId(final Long businessLeaderTwoId) {
      this.businessLeaderTwoId = businessLeaderTwoId;
      return this;
   }

   @JsonProperty("attachments")
   public ContractProject setAttachments(final String attachments) {
      this.attachments = attachments;
      return this;
   }

   @JsonProperty("archives")
   public ContractProject setArchives(final String archives) {
      this.archives = archives;
      return this;
   }

   @JsonProperty("city_id")
   public ContractProject setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   @JsonProperty("city_name")
   public ContractProject setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   @JsonProperty("country_id")
   public ContractProject setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   @JsonProperty("country_name")
   public ContractProject setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   @JsonProperty("contract_amount")
   public ContractProject setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   @JsonProperty("prepayments")
   public ContractProject setPrepayments(final BigDecimal prepayments) {
      this.prepayments = prepayments;
      return this;
   }

   @JsonProperty("management_fee_rate")
   public ContractProject setManagementFeeRate(final BigDecimal managementFeeRate) {
      this.managementFeeRate = managementFeeRate;
      return this;
   }

   @JsonProperty("management_cost_id")
   public ContractProject setManagementCostId(final Long managementCostId) {
      this.managementCostId = managementCostId;
      return this;
   }

   @JsonProperty("margin_amount")
   public ContractProject setMarginAmount(final BigDecimal marginAmount) {
      this.marginAmount = marginAmount;
      return this;
   }

   public ContractProject setCollectionMarginAmount(final BigDecimal collectionMarginAmount) {
      this.collectionMarginAmount = collectionMarginAmount;
      return this;
   }

   @JsonProperty("margin_type")
   public ContractProject setMarginType(final Long marginType) {
      this.marginType = marginType;
      return this;
   }

   @JsonProperty("margin_type_id")
   public ContractProject setMarginTypeId(final Long marginTypeId) {
      this.marginTypeId = marginTypeId;
      return this;
   }

   @JsonProperty("currency_type")
   public ContractProject setCurrencyType(final String currencyType) {
      this.currencyType = currencyType;
      return this;
   }

   public ContractProject setQualityGuaranteeDeposit(final BigDecimal qualityGuaranteeDeposit) {
      this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
      return this;
   }

   @JsonProperty("settlement_status")
   public ContractProject setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
      return this;
   }

   @JsonProperty("settlement_amount")
   public ContractProject setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
      return this;
   }

   public ContractProject setSettlementAttachmentId(final Long settlementAttachmentId) {
      this.settlementAttachmentId = settlementAttachmentId;
      return this;
   }

   @JsonProperty("province_id")
   public ContractProject setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   @JsonProperty("province_name")
   public ContractProject setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   @JsonProperty("region_id")
   public ContractProject setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   @JsonProperty("region_name")
   public ContractProject setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   @JsonProperty("contract_sign_body_id")
   public ContractProject setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
      return this;
   }

   @JsonProperty("business_type")
   public ContractProject setBusinessType(final Integer businessType) {
      this.businessType = businessType;
      return this;
   }

   @JsonProperty("project_type")
   public ContractProject setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   @JsonProperty("project_content")
   public ContractProject setProjectContent(final String projectContent) {
      this.projectContent = projectContent;
      return this;
   }

   @Deprecated
   public ContractProject setStructureStatus(final Long structureStatus) {
      this.structureStatus = structureStatus;
      return this;
   }

   public ContractProject setStructureTypeId(final Long structureTypeId) {
      this.structureTypeId = structureTypeId;
      return this;
   }

   @JsonProperty("productCategory")
   public ContractProject setProductCategory(final Integer productCategory) {
      this.productCategory = productCategory;
      return this;
   }

   @JsonProperty("transportMode")
   public ContractProject setTransportMode(final Integer transportMode) {
      this.transportMode = transportMode;
      return this;
   }

   @JsonProperty("enclosureTransportMode")
   public ContractProject setEnclosureTransportMode(final Integer enclosureTransportMode) {
      this.enclosureTransportMode = enclosureTransportMode;
      return this;
   }

   @JsonProperty("structureMeasureMode")
   public ContractProject setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
      return this;
   }

   @JsonProperty("enclosureMeasureMode")
   public ContractProject setEnclosureMeasureMode(final Integer enclosureMeasureMode) {
      this.enclosureMeasureMode = enclosureMeasureMode;
      return this;
   }

   @JsonProperty("signing_address")
   public ContractProject setSigningAddress(final String signingAddress) {
      this.signingAddress = signingAddress;
      return this;
   }

   @JsonProperty("signing_date")
   public ContractProject setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
      return this;
   }

   @JsonProperty("signer_id")
   public ContractProject setSignerId(final Long signerId) {
      this.signerId = signerId;
      return this;
   }

   @JsonProperty("signer_name")
   public ContractProject setSignerName(final String signerName) {
      this.signerName = signerName;
      return this;
   }

   public ContractProject setSignerPhone(final String signerPhone) {
      this.signerPhone = signerPhone;
      return this;
   }

   @JsonProperty("is_tax")
   public ContractProject setIsTax(final Integer isTax) {
      this.isTax = isTax;
      return this;
   }

   @JsonProperty("invoice_type")
   public ContractProject setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("tax_rate")
   public ContractProject setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("pay_type")
   public ContractProject setPayType(final Integer payType) {
      this.payType = payType;
      return this;
   }

   @JsonProperty("pay_type_desc")
   public ContractProject setPayTypeDesc(final String payTypeDesc) {
      this.payTypeDesc = payTypeDesc;
      return this;
   }

   @JsonProperty("technologyRemark")
   public ContractProject setTechnologyRemark(final String technologyRemark) {
      this.technologyRemark = technologyRemark;
      return this;
   }

   @JsonProperty("customer_unit")
   public ContractProject setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
      return this;
   }

   @JsonProperty("social_code")
   public ContractProject setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
      return this;
   }

   @JsonProperty("customer_unit_phone")
   public ContractProject setCustomerUnitPhone(final String customerUnitPhone) {
      this.customerUnitPhone = customerUnitPhone;
      return this;
   }

   @JsonProperty("customer_email")
   public ContractProject setCustomerEmail(final String customerEmail) {
      this.customerEmail = customerEmail;
      return this;
   }

   @JsonProperty("user_id")
   public ContractProject setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("status")
   public ContractProject setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("customer_province_id")
   public ContractProject setCustomerProvinceId(final Long customerProvinceId) {
      this.customerProvinceId = customerProvinceId;
      return this;
   }

   @JsonProperty("customer_province_name")
   public ContractProject setCustomerProvinceName(final String customerProvinceName) {
      this.customerProvinceName = customerProvinceName;
      return this;
   }

   @JsonProperty("customer_city_id")
   public ContractProject setCustomerCityId(final Long customerCityId) {
      this.customerCityId = customerCityId;
      return this;
   }

   @JsonProperty("customer_city_name")
   public ContractProject setCustomerCityName(final String customerCityName) {
      this.customerCityName = customerCityName;
      return this;
   }

   @JsonProperty("customer_region_id")
   public ContractProject setCustomerRegionId(final Long customerRegionId) {
      this.customerRegionId = customerRegionId;
      return this;
   }

   @JsonProperty("customer_region_name")
   public ContractProject setCustomerRegionName(final String customerRegionName) {
      this.customerRegionName = customerRegionName;
      return this;
   }

   @JsonProperty("customer_country_id")
   public ContractProject setCustomerCountryId(final Long customerCountryId) {
      this.customerCountryId = customerCountryId;
      return this;
   }

   @JsonProperty("customer_country_name")
   public ContractProject setCustomerCountryName(final String customerCountryName) {
      this.customerCountryName = customerCountryName;
      return this;
   }

   @JsonProperty("customer_address")
   public ContractProject setCustomerAddress(final String customerAddress) {
      this.customerAddress = customerAddress;
      return this;
   }

   @JsonProperty("customer_bank_user_name")
   public ContractProject setCustomerBankUserName(final String customerBankUserName) {
      this.customerBankUserName = customerBankUserName;
      return this;
   }

   @JsonProperty("customer_bank_code")
   public ContractProject setCustomerBankCode(final String customerBankCode) {
      this.customerBankCode = customerBankCode;
      return this;
   }

   @JsonProperty("customer_bank_name")
   public ContractProject setCustomerBankName(final String customerBankName) {
      this.customerBankName = customerBankName;
      return this;
   }

   @JsonProperty("customer_manager_one")
   public ContractProject setCustomerManagerOne(final String customerManagerOne) {
      this.customerManagerOne = customerManagerOne;
      return this;
   }

   @JsonProperty("customer_manager_one_phone")
   public ContractProject setCustomerManagerOnePhone(final String customerManagerOnePhone) {
      this.customerManagerOnePhone = customerManagerOnePhone;
      return this;
   }

   @JsonProperty("customer_manager_two")
   public ContractProject setCustomerManagerTwo(final String customerManagerTwo) {
      this.customerManagerTwo = customerManagerTwo;
      return this;
   }

   @JsonProperty("customer_manager_two_phone")
   public ContractProject setCustomerManagerTwoPhone(final String customerManagerTwoPhone) {
      this.customerManagerTwoPhone = customerManagerTwoPhone;
      return this;
   }

   public ContractProject setReceivingManager(final String receivingManager) {
      this.receivingManager = receivingManager;
      return this;
   }

   public ContractProject setReceivingManagerPhone(final String receivingManagerPhone) {
      this.receivingManagerPhone = receivingManagerPhone;
      return this;
   }

   public ContractProject setSettleManager(final String settleManager) {
      this.settleManager = settleManager;
      return this;
   }

   public ContractProject setSettleManagerPhone(final String settleManagerPhone) {
      this.settleManagerPhone = settleManagerPhone;
      return this;
   }

   public ContractProject setFinanceManager(final String financeManager) {
      this.financeManager = financeManager;
      return this;
   }

   public ContractProject setFinanceManagerPhone(final String financeManagerPhone) {
      this.financeManagerPhone = financeManagerPhone;
      return this;
   }

   public ContractProject setAuditManager(final String auditManager) {
      this.auditManager = auditManager;
      return this;
   }

   public ContractProject setAuditManagerPhone(final String auditManagerPhone) {
      this.auditManagerPhone = auditManagerPhone;
      return this;
   }

   public ContractProject setDesignManager(final String designManager) {
      this.designManager = designManager;
      return this;
   }

   public ContractProject setDesignManagerPhone(final String designManagerPhone) {
      this.designManagerPhone = designManagerPhone;
      return this;
   }

   @JsonProperty("mode")
   public ContractProject setMode(final Integer mode) {
      this.mode = mode;
      return this;
   }

   public ContractProject setBoolRequiredWarehouse(final Boolean boolRequiredWarehouse) {
      this.boolRequiredWarehouse = boolRequiredWarehouse;
      return this;
   }

   @JsonProperty("mesStartDate")
   public ContractProject setMesStartDate(final LocalDateTime mesStartDate) {
      this.mesStartDate = mesStartDate;
      return this;
   }

   @JsonProperty("mesEndDate")
   public ContractProject setMesEndDate(final LocalDateTime mesEndDate) {
      this.mesEndDate = mesEndDate;
      return this;
   }

   @JsonProperty("happenedAmount")
   public ContractProject setHappenedAmount(final BigDecimal happenedAmount) {
      this.happenedAmount = happenedAmount;
      return this;
   }

   @JsonProperty("outFinishStatus")
   public ContractProject setOutFinishStatus(final Boolean outFinishStatus) {
      this.outFinishStatus = outFinishStatus;
      return this;
   }

   @JsonProperty("boolArrears")
   public ContractProject setBoolArrears(final Boolean boolArrears) {
      this.boolArrears = boolArrears;
      return this;
   }

   public ContractProject setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
      return this;
   }

   public ContractProject setCollectionSummary(final BigDecimal collectionSummary) {
      this.collectionSummary = collectionSummary;
      return this;
   }

   public ContractProject setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
      return this;
   }

   public ContractProject setInstallReportMethod(final Integer installReportMethod) {
      this.installReportMethod = installReportMethod;
      return this;
   }

   public ContractProject setOrderSourceType(final Integer orderSourceType) {
      this.orderSourceType = orderSourceType;
      return this;
   }

   public ContractProject setCustomerRemark(final String customerRemark) {
      this.customerRemark = customerRemark;
      return this;
   }

   public ContractProject setIsEffective(final Integer isEffective) {
      this.isEffective = isEffective;
      return this;
   }

   @JsonProperty("commercialClause")
   public ContractProject setCommercialClause(final String commercialClause) {
      this.commercialClause = commercialClause;
      return this;
   }

   @JsonProperty("technologyClause")
   public ContractProject setTechnologyClause(final String technologyClause) {
      this.technologyClause = technologyClause;
      return this;
   }

   @JsonProperty("otherRemarks")
   public ContractProject setOtherRemarks(final String otherRemarks) {
      this.otherRemarks = otherRemarks;
      return this;
   }

   public ContractProject setPId(final Long pId) {
      this.pId = pId;
      return this;
   }

   @JsonProperty("sendingMode")
   public ContractProject setSendingMode(final Long sendingMode) {
      this.sendingMode = sendingMode;
      return this;
   }

   @JsonProperty("infoSource")
   public ContractProject setInfoSource(final Long infoSource) {
      this.infoSource = infoSource;
      return this;
   }

   @JsonProperty("isBuilding")
   public ContractProject setIsBuilding(final Integer isBuilding) {
      this.isBuilding = isBuilding;
      return this;
   }

   public ContractProject setDeptId(final Long deptId) {
      this.deptId = deptId;
      return this;
   }

   @JsonProperty("allDays")
   public ContractProject setAllDays(final Integer allDays) {
      this.allDays = allDays;
      return this;
   }

   @JsonProperty("partyType")
   public ContractProject setPartyType(final Long partyType) {
      this.partyType = partyType;
      return this;
   }

   @JsonProperty("structureArea")
   public ContractProject setStructureArea(final BigDecimal structureArea) {
      this.structureArea = structureArea;
      return this;
   }

   @JsonProperty("projectAttribute")
   public ContractProject setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   @JsonProperty("contractType")
   public ContractProject setContractType(final Integer contractType) {
      this.contractType = contractType;
      return this;
   }

   @JsonProperty("lumpSumSystemType")
   public ContractProject setLumpSumSystemType(final Integer lumpSumSystemType) {
      this.lumpSumSystemType = lumpSumSystemType;
      return this;
   }

   @JsonProperty("isArchive")
   public ContractProject setIsArchive(final Integer isArchive) {
      this.isArchive = isArchive;
      return this;
   }

   @JsonProperty("unitType")
   public ContractProject setUnitType(final Integer unitType) {
      this.unitType = unitType;
      return this;
   }

   @JsonProperty("isDeposit")
   public ContractProject setIsDeposit(final Boolean isDeposit) {
      this.isDeposit = isDeposit;
      return this;
   }

   @JsonProperty("contract_sign_body_scale")
   public ContractProject setContractSignBodyScale(final BigDecimal contractSignBodyScale) {
      this.contractSignBodyScale = contractSignBodyScale;
      return this;
   }

   @JsonProperty("contract_sign_body_amount")
   public ContractProject setContractSignBodyAmount(final BigDecimal contractSignBodyAmount) {
      this.contractSignBodyAmount = contractSignBodyAmount;
      return this;
   }

   @JsonProperty("project_manager_scale")
   public ContractProject setProjectManagerScale(final BigDecimal projectManagerScale) {
      this.projectManagerScale = projectManagerScale;
      return this;
   }

   @JsonProperty("project_manager_amount")
   public ContractProject setProjectManagerAmount(final BigDecimal projectManagerAmount) {
      this.projectManagerAmount = projectManagerAmount;
      return this;
   }

   public ContractProject setContractSignBodyCollectBalance(final BigDecimal contractSignBodyCollectBalance) {
      this.contractSignBodyCollectBalance = contractSignBodyCollectBalance;
      return this;
   }

   public ContractProject setContractSignBodyInjectionBalance(final BigDecimal contractSignBodyInjectionBalance) {
      this.contractSignBodyInjectionBalance = contractSignBodyInjectionBalance;
      return this;
   }

   public ContractProject setProjectManagerCollectBalance(final BigDecimal projectManagerCollectBalance) {
      this.projectManagerCollectBalance = projectManagerCollectBalance;
      return this;
   }

   public ContractProject setProjectManagerInjectionBalance(final BigDecimal projectManagerInjectionBalance) {
      this.projectManagerInjectionBalance = projectManagerInjectionBalance;
      return this;
   }

   @JsonProperty("level")
   public ContractProject setLevel(final Integer level) {
      this.level = level;
      return this;
   }

   public ContractProject setInstallDivideMethod(final Integer installDivideMethod) {
      this.installDivideMethod = installDivideMethod;
      return this;
   }

   @JsonProperty("lastUpdateTime")
   public ContractProject setLastUpdateTime(final LocalDateTime lastUpdateTime) {
      this.lastUpdateTime = lastUpdateTime;
      return this;
   }

   @JsonProperty("lastUpdateUserId")
   public ContractProject setLastUpdateUserId(final Long lastUpdateUserId) {
      this.lastUpdateUserId = lastUpdateUserId;
      return this;
   }

   @Override
   public String toString() {
      return "ContractProject(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", completeDate="
         + this.getCompleteDate()
         + ", address="
         + this.getAddress()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", projectManagerPhone="
         + this.getProjectManagerPhone()
         + ", salesLeaderId="
         + this.getSalesLeaderId()
         + ", businessLeaderId="
         + this.getBusinessLeaderId()
         + ", businessLeaderTwoId="
         + this.getBusinessLeaderTwoId()
         + ", attachments="
         + this.getAttachments()
         + ", archives="
         + this.getArchives()
         + ", cityId="
         + this.getCityId()
         + ", cityName="
         + this.getCityName()
         + ", countryId="
         + this.getCountryId()
         + ", countryName="
         + this.getCountryName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", prepayments="
         + this.getPrepayments()
         + ", managementFeeRate="
         + this.getManagementFeeRate()
         + ", managementCostId="
         + this.getManagementCostId()
         + ", marginAmount="
         + this.getMarginAmount()
         + ", collectionMarginAmount="
         + this.getCollectionMarginAmount()
         + ", marginType="
         + this.getMarginType()
         + ", marginTypeId="
         + this.getMarginTypeId()
         + ", currencyType="
         + this.getCurrencyType()
         + ", qualityGuaranteeDeposit="
         + this.getQualityGuaranteeDeposit()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", settlementAttachmentId="
         + this.getSettlementAttachmentId()
         + ", provinceId="
         + this.getProvinceId()
         + ", provinceName="
         + this.getProvinceName()
         + ", regionId="
         + this.getRegionId()
         + ", regionName="
         + this.getRegionName()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", businessType="
         + this.getBusinessType()
         + ", projectType="
         + this.getProjectType()
         + ", projectContent="
         + this.getProjectContent()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", structureTypeId="
         + this.getStructureTypeId()
         + ", productCategory="
         + this.getProductCategory()
         + ", transportMode="
         + this.getTransportMode()
         + ", enclosureTransportMode="
         + this.getEnclosureTransportMode()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", enclosureMeasureMode="
         + this.getEnclosureMeasureMode()
         + ", signingAddress="
         + this.getSigningAddress()
         + ", signingDate="
         + this.getSigningDate()
         + ", signerId="
         + this.getSignerId()
         + ", signerName="
         + this.getSignerName()
         + ", signerPhone="
         + this.getSignerPhone()
         + ", isTax="
         + this.getIsTax()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", payType="
         + this.getPayType()
         + ", payTypeDesc="
         + this.getPayTypeDesc()
         + ", technologyRemark="
         + this.getTechnologyRemark()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", socialCode="
         + this.getSocialCode()
         + ", customerUnitPhone="
         + this.getCustomerUnitPhone()
         + ", customerEmail="
         + this.getCustomerEmail()
         + ", userId="
         + this.getUserId()
         + ", status="
         + this.getStatus()
         + ", customerProvinceId="
         + this.getCustomerProvinceId()
         + ", customerProvinceName="
         + this.getCustomerProvinceName()
         + ", customerCityId="
         + this.getCustomerCityId()
         + ", customerCityName="
         + this.getCustomerCityName()
         + ", customerRegionId="
         + this.getCustomerRegionId()
         + ", customerRegionName="
         + this.getCustomerRegionName()
         + ", customerCountryId="
         + this.getCustomerCountryId()
         + ", customerCountryName="
         + this.getCustomerCountryName()
         + ", customerAddress="
         + this.getCustomerAddress()
         + ", customerBankUserName="
         + this.getCustomerBankUserName()
         + ", customerBankCode="
         + this.getCustomerBankCode()
         + ", customerBankName="
         + this.getCustomerBankName()
         + ", customerManagerOne="
         + this.getCustomerManagerOne()
         + ", customerManagerOnePhone="
         + this.getCustomerManagerOnePhone()
         + ", customerManagerTwo="
         + this.getCustomerManagerTwo()
         + ", customerManagerTwoPhone="
         + this.getCustomerManagerTwoPhone()
         + ", receivingManager="
         + this.getReceivingManager()
         + ", receivingManagerPhone="
         + this.getReceivingManagerPhone()
         + ", settleManager="
         + this.getSettleManager()
         + ", settleManagerPhone="
         + this.getSettleManagerPhone()
         + ", financeManager="
         + this.getFinanceManager()
         + ", financeManagerPhone="
         + this.getFinanceManagerPhone()
         + ", auditManager="
         + this.getAuditManager()
         + ", auditManagerPhone="
         + this.getAuditManagerPhone()
         + ", designManager="
         + this.getDesignManager()
         + ", designManagerPhone="
         + this.getDesignManagerPhone()
         + ", mode="
         + this.getMode()
         + ", boolRequiredWarehouse="
         + this.getBoolRequiredWarehouse()
         + ", mesStartDate="
         + this.getMesStartDate()
         + ", mesEndDate="
         + this.getMesEndDate()
         + ", happenedAmount="
         + this.getHappenedAmount()
         + ", outFinishStatus="
         + this.getOutFinishStatus()
         + ", boolArrears="
         + this.getBoolArrears()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", collectionSummary="
         + this.getCollectionSummary()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", installReportMethod="
         + this.getInstallReportMethod()
         + ", orderSourceType="
         + this.getOrderSourceType()
         + ", customerRemark="
         + this.getCustomerRemark()
         + ", isEffective="
         + this.getIsEffective()
         + ", commercialClause="
         + this.getCommercialClause()
         + ", technologyClause="
         + this.getTechnologyClause()
         + ", otherRemarks="
         + this.getOtherRemarks()
         + ", pId="
         + this.getPId()
         + ", sendingMode="
         + this.getSendingMode()
         + ", infoSource="
         + this.getInfoSource()
         + ", isBuilding="
         + this.getIsBuilding()
         + ", deptId="
         + this.getDeptId()
         + ", allDays="
         + this.getAllDays()
         + ", partyType="
         + this.getPartyType()
         + ", structureArea="
         + this.getStructureArea()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", contractType="
         + this.getContractType()
         + ", lumpSumSystemType="
         + this.getLumpSumSystemType()
         + ", isArchive="
         + this.getIsArchive()
         + ", unitType="
         + this.getUnitType()
         + ", isDeposit="
         + this.getIsDeposit()
         + ", contractSignBodyScale="
         + this.getContractSignBodyScale()
         + ", contractSignBodyAmount="
         + this.getContractSignBodyAmount()
         + ", projectManagerScale="
         + this.getProjectManagerScale()
         + ", projectManagerAmount="
         + this.getProjectManagerAmount()
         + ", contractSignBodyCollectBalance="
         + this.getContractSignBodyCollectBalance()
         + ", contractSignBodyInjectionBalance="
         + this.getContractSignBodyInjectionBalance()
         + ", projectManagerCollectBalance="
         + this.getProjectManagerCollectBalance()
         + ", projectManagerInjectionBalance="
         + this.getProjectManagerInjectionBalance()
         + ", level="
         + this.getLevel()
         + ", installDivideMethod="
         + this.getInstallDivideMethod()
         + ", lastUpdateTime="
         + this.getLastUpdateTime()
         + ", lastUpdateUserId="
         + this.getLastUpdateUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProject)) {
         return false;
      }

      ContractProject other = (ContractProject)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectManagerId = this.getProjectManagerId();
         Object other$projectManagerId = other.getProjectManagerId();
         if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
            Object this$salesLeaderId = this.getSalesLeaderId();
            Object other$salesLeaderId = other.getSalesLeaderId();
            if (this$salesLeaderId == null ? other$salesLeaderId == null : this$salesLeaderId.equals(other$salesLeaderId)) {
               Object this$businessLeaderId = this.getBusinessLeaderId();
               Object other$businessLeaderId = other.getBusinessLeaderId();
               if (this$businessLeaderId == null ? other$businessLeaderId == null : this$businessLeaderId.equals(other$businessLeaderId)) {
                  Object this$businessLeaderTwoId = this.getBusinessLeaderTwoId();
                  Object other$businessLeaderTwoId = other.getBusinessLeaderTwoId();
                  if (this$businessLeaderTwoId == null ? other$businessLeaderTwoId == null : this$businessLeaderTwoId.equals(other$businessLeaderTwoId)) {
                     Object this$cityId = this.getCityId();
                     Object other$cityId = other.getCityId();
                     if (this$cityId == null ? other$cityId == null : this$cityId.equals(other$cityId)) {
                        Object this$countryId = this.getCountryId();
                        Object other$countryId = other.getCountryId();
                        if (this$countryId == null ? other$countryId == null : this$countryId.equals(other$countryId)) {
                           Object this$managementCostId = this.getManagementCostId();
                           Object other$managementCostId = other.getManagementCostId();
                           if (this$managementCostId == null ? other$managementCostId == null : this$managementCostId.equals(other$managementCostId)) {
                              Object this$marginType = this.getMarginType();
                              Object other$marginType = other.getMarginType();
                              if (this$marginType == null ? other$marginType == null : this$marginType.equals(other$marginType)) {
                                 Object this$marginTypeId = this.getMarginTypeId();
                                 Object other$marginTypeId = other.getMarginTypeId();
                                 if (this$marginTypeId == null ? other$marginTypeId == null : this$marginTypeId.equals(other$marginTypeId)) {
                                    Object this$settlementStatus = this.getSettlementStatus();
                                    Object other$settlementStatus = other.getSettlementStatus();
                                    if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
                                       Object this$settlementAttachmentId = this.getSettlementAttachmentId();
                                       Object other$settlementAttachmentId = other.getSettlementAttachmentId();
                                       if (this$settlementAttachmentId == null
                                          ? other$settlementAttachmentId == null
                                          : this$settlementAttachmentId.equals(other$settlementAttachmentId)) {
                                          Object this$provinceId = this.getProvinceId();
                                          Object other$provinceId = other.getProvinceId();
                                          if (this$provinceId == null ? other$provinceId == null : this$provinceId.equals(other$provinceId)) {
                                             Object this$regionId = this.getRegionId();
                                             Object other$regionId = other.getRegionId();
                                             if (this$regionId == null ? other$regionId == null : this$regionId.equals(other$regionId)) {
                                                Object this$contractSignBodyId = this.getContractSignBodyId();
                                                Object other$contractSignBodyId = other.getContractSignBodyId();
                                                if (this$contractSignBodyId == null
                                                   ? other$contractSignBodyId == null
                                                   : this$contractSignBodyId.equals(other$contractSignBodyId)) {
                                                   Object this$businessType = this.getBusinessType();
                                                   Object other$businessType = other.getBusinessType();
                                                   if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
                                                      Object this$projectType = this.getProjectType();
                                                      Object other$projectType = other.getProjectType();
                                                      if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                                                         Object this$structureStatus = this.getStructureStatus();
                                                         Object other$structureStatus = other.getStructureStatus();
                                                         if (this$structureStatus == null
                                                            ? other$structureStatus == null
                                                            : this$structureStatus.equals(other$structureStatus)) {
                                                            Object this$structureTypeId = this.getStructureTypeId();
                                                            Object other$structureTypeId = other.getStructureTypeId();
                                                            if (this$structureTypeId == null
                                                               ? other$structureTypeId == null
                                                               : this$structureTypeId.equals(other$structureTypeId)) {
                                                               Object this$productCategory = this.getProductCategory();
                                                               Object other$productCategory = other.getProductCategory();
                                                               if (this$productCategory == null
                                                                  ? other$productCategory == null
                                                                  : this$productCategory.equals(other$productCategory)) {
                                                                  Object this$transportMode = this.getTransportMode();
                                                                  Object other$transportMode = other.getTransportMode();
                                                                  if (this$transportMode == null
                                                                     ? other$transportMode == null
                                                                     : this$transportMode.equals(other$transportMode)) {
                                                                     Object this$enclosureTransportMode = this.getEnclosureTransportMode();
                                                                     Object other$enclosureTransportMode = other.getEnclosureTransportMode();
                                                                     if (this$enclosureTransportMode == null
                                                                        ? other$enclosureTransportMode == null
                                                                        : this$enclosureTransportMode.equals(other$enclosureTransportMode)) {
                                                                        Object this$structureMeasureMode = this.getStructureMeasureMode();
                                                                        Object other$structureMeasureMode = other.getStructureMeasureMode();
                                                                        if (this$structureMeasureMode == null
                                                                           ? other$structureMeasureMode == null
                                                                           : this$structureMeasureMode.equals(other$structureMeasureMode)) {
                                                                           Object this$enclosureMeasureMode = this.getEnclosureMeasureMode();
                                                                           Object other$enclosureMeasureMode = other.getEnclosureMeasureMode();
                                                                           if (this$enclosureMeasureMode == null
                                                                              ? other$enclosureMeasureMode == null
                                                                              : this$enclosureMeasureMode.equals(other$enclosureMeasureMode)) {
                                                                              Object this$signerId = this.getSignerId();
                                                                              Object other$signerId = other.getSignerId();
                                                                              if (this$signerId == null
                                                                                 ? other$signerId == null
                                                                                 : this$signerId.equals(other$signerId)) {
                                                                                 Object this$isTax = this.getIsTax();
                                                                                 Object other$isTax = other.getIsTax();
                                                                                 if (this$isTax == null ? other$isTax == null : this$isTax.equals(other$isTax)) {
                                                                                    Object this$invoiceType = this.getInvoiceType();
                                                                                    Object other$invoiceType = other.getInvoiceType();
                                                                                    if (this$invoiceType == null
                                                                                       ? other$invoiceType == null
                                                                                       : this$invoiceType.equals(other$invoiceType)) {
                                                                                       Object this$payType = this.getPayType();
                                                                                       Object other$payType = other.getPayType();
                                                                                       if (this$payType == null
                                                                                          ? other$payType == null
                                                                                          : this$payType.equals(other$payType)) {
                                                                                          Object this$userId = this.getUserId();
                                                                                          Object other$userId = other.getUserId();
                                                                                          if (this$userId == null
                                                                                             ? other$userId == null
                                                                                             : this$userId.equals(other$userId)) {
                                                                                             Object this$status = this.getStatus();
                                                                                             Object other$status = other.getStatus();
                                                                                             if (this$status == null
                                                                                                ? other$status == null
                                                                                                : this$status.equals(other$status)) {
                                                                                                Object this$customerProvinceId = this.getCustomerProvinceId();
                                                                                                Object other$customerProvinceId = other.getCustomerProvinceId();
                                                                                                if (this$customerProvinceId == null
                                                                                                   ? other$customerProvinceId == null
                                                                                                   : this$customerProvinceId.equals(other$customerProvinceId)) {
                                                                                                   Object this$customerCityId = this.getCustomerCityId();
                                                                                                   Object other$customerCityId = other.getCustomerCityId();
                                                                                                   if (this$customerCityId == null
                                                                                                      ? other$customerCityId == null
                                                                                                      : this$customerCityId.equals(other$customerCityId)) {
                                                                                                      Object this$customerRegionId = this.getCustomerRegionId();
                                                                                                      Object other$customerRegionId = other.getCustomerRegionId();
                                                                                                      if (this$customerRegionId == null
                                                                                                         ? other$customerRegionId == null
                                                                                                         : this$customerRegionId.equals(other$customerRegionId)
                                                                                                         )
                                                                                                       {
                                                                                                         Object this$customerCountryId = this.getCustomerCountryId();
                                                                                                         Object other$customerCountryId = other.getCustomerCountryId();
                                                                                                         if (this$customerCountryId == null
                                                                                                            ? other$customerCountryId == null
                                                                                                            : this$customerCountryId.equals(
                                                                                                               other$customerCountryId
                                                                                                            )) {
                                                                                                            Object this$mode = this.getMode();
                                                                                                            Object other$mode = other.getMode();
                                                                                                            if (this$mode == null
                                                                                                               ? other$mode == null
                                                                                                               : this$mode.equals(other$mode)) {
                                                                                                               Object this$boolRequiredWarehouse = this.getBoolRequiredWarehouse();
                                                                                                               Object other$boolRequiredWarehouse = other.getBoolRequiredWarehouse();
                                                                                                               if (this$boolRequiredWarehouse == null
                                                                                                                  ? other$boolRequiredWarehouse == null
                                                                                                                  : this$boolRequiredWarehouse.equals(
                                                                                                                     other$boolRequiredWarehouse
                                                                                                                  )) {
                                                                                                                  Object this$outFinishStatus = this.getOutFinishStatus();
                                                                                                                  Object other$outFinishStatus = other.getOutFinishStatus();
                                                                                                                  if (this$outFinishStatus == null
                                                                                                                     ? other$outFinishStatus == null
                                                                                                                     : this$outFinishStatus.equals(
                                                                                                                        other$outFinishStatus
                                                                                                                     )) {
                                                                                                                     Object this$boolArrears = this.getBoolArrears();
                                                                                                                     Object other$boolArrears = other.getBoolArrears();
                                                                                                                     if (this$boolArrears == null
                                                                                                                        ? other$boolArrears == null
                                                                                                                        : this$boolArrears.equals(
                                                                                                                           other$boolArrears
                                                                                                                        )) {
                                                                                                                        Object this$installReportMethod = this.getInstallReportMethod();
                                                                                                                        Object other$installReportMethod = other.getInstallReportMethod();
                                                                                                                        if (this$installReportMethod == null
                                                                                                                           ? other$installReportMethod == null
                                                                                                                           : this$installReportMethod.equals(
                                                                                                                              other$installReportMethod
                                                                                                                           )) {
                                                                                                                           Object this$orderSourceType = this.getOrderSourceType();
                                                                                                                           Object other$orderSourceType = other.getOrderSourceType();
                                                                                                                           if (this$orderSourceType == null
                                                                                                                              ? other$orderSourceType == null
                                                                                                                              : this$orderSourceType.equals(
                                                                                                                                 other$orderSourceType
                                                                                                                              )) {
                                                                                                                              Object this$isEffective = this.getIsEffective();
                                                                                                                              Object other$isEffective = other.getIsEffective();
                                                                                                                              if (this$isEffective == null
                                                                                                                                 ? other$isEffective == null
                                                                                                                                 : this$isEffective.equals(
                                                                                                                                    other$isEffective
                                                                                                                                 )) {
                                                                                                                                 Object this$pId = this.getPId();
                                                                                                                                 Object other$pId = other.getPId();
                                                                                                                                 if (this$pId == null
                                                                                                                                    ? other$pId == null
                                                                                                                                    : this$pId.equals(other$pId)
                                                                                                                                    )
                                                                                                                                  {
                                                                                                                                    Object this$sendingMode = this.getSendingMode();
                                                                                                                                    Object other$sendingMode = other.getSendingMode();
                                                                                                                                    if (this$sendingMode
                                                                                                                                          == null
                                                                                                                                       ? other$sendingMode
                                                                                                                                          == null
                                                                                                                                       : this$sendingMode.equals(
                                                                                                                                          other$sendingMode
                                                                                                                                       )) {
                                                                                                                                       Object this$infoSource = this.getInfoSource();
                                                                                                                                       Object other$infoSource = other.getInfoSource();
                                                                                                                                       if (this$infoSource
                                                                                                                                             == null
                                                                                                                                          ? other$infoSource
                                                                                                                                             == null
                                                                                                                                          : this$infoSource.equals(
                                                                                                                                             other$infoSource
                                                                                                                                          )) {
                                                                                                                                          Object this$isBuilding = this.getIsBuilding();
                                                                                                                                          Object other$isBuilding = other.getIsBuilding();
                                                                                                                                          if (this$isBuilding
                                                                                                                                                == null
                                                                                                                                             ? other$isBuilding
                                                                                                                                                == null
                                                                                                                                             : this$isBuilding.equals(
                                                                                                                                                other$isBuilding
                                                                                                                                             )) {
                                                                                                                                             Object this$deptId = this.getDeptId();
                                                                                                                                             Object other$deptId = other.getDeptId();
                                                                                                                                             if (this$deptId
                                                                                                                                                   == null
                                                                                                                                                ? other$deptId
                                                                                                                                                   == null
                                                                                                                                                : this$deptId.equals(
                                                                                                                                                   other$deptId
                                                                                                                                                )) {
                                                                                                                                                Object this$allDays = this.getAllDays();
                                                                                                                                                Object other$allDays = other.getAllDays();
                                                                                                                                                if (this$allDays
                                                                                                                                                      == null
                                                                                                                                                   ? other$allDays
                                                                                                                                                      == null
                                                                                                                                                   : this$allDays.equals(
                                                                                                                                                      other$allDays
                                                                                                                                                   )) {
                                                                                                                                                   Object this$partyType = this.getPartyType();
                                                                                                                                                   Object other$partyType = other.getPartyType();
                                                                                                                                                   if (this$partyType
                                                                                                                                                         == null
                                                                                                                                                      ? other$partyType
                                                                                                                                                         == null
                                                                                                                                                      : this$partyType.equals(
                                                                                                                                                         other$partyType
                                                                                                                                                      )) {
                                                                                                                                                      Object this$projectAttribute = this.getProjectAttribute();
                                                                                                                                                      Object other$projectAttribute = other.getProjectAttribute();
                                                                                                                                                      if (this$projectAttribute
                                                                                                                                                            == null
                                                                                                                                                         ? other$projectAttribute
                                                                                                                                                            == null
                                                                                                                                                         : this$projectAttribute.equals(
                                                                                                                                                            other$projectAttribute
                                                                                                                                                         )) {
                                                                                                                                                         Object this$contractType = this.getContractType();
                                                                                                                                                         Object other$contractType = other.getContractType();
                                                                                                                                                         if (this$contractType
                                                                                                                                                               == null
                                                                                                                                                            ? other$contractType
                                                                                                                                                               == null
                                                                                                                                                            : this$contractType.equals(
                                                                                                                                                               other$contractType
                                                                                                                                                            )) {
                                                                                                                                                            Object this$lumpSumSystemType = this.getLumpSumSystemType();
                                                                                                                                                            Object other$lumpSumSystemType = other.getLumpSumSystemType();
                                                                                                                                                            if (this$lumpSumSystemType
                                                                                                                                                                  == null
                                                                                                                                                               ? other$lumpSumSystemType
                                                                                                                                                                  == null
                                                                                                                                                               : this$lumpSumSystemType.equals(
                                                                                                                                                                  other$lumpSumSystemType
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$isArchive = this.getIsArchive();
                                                                                                                                                               Object other$isArchive = other.getIsArchive();
                                                                                                                                                               if (this$isArchive
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$isArchive
                                                                                                                                                                     == null
                                                                                                                                                                  : this$isArchive.equals(
                                                                                                                                                                     other$isArchive
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$unitType = this.getUnitType();
                                                                                                                                                                  Object other$unitType = other.getUnitType();
                                                                                                                                                                  if (this$unitType
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$unitType
                                                                                                                                                                        == null
                                                                                                                                                                     : this$unitType.equals(
                                                                                                                                                                        other$unitType
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$isDeposit = this.getIsDeposit();
                                                                                                                                                                     Object other$isDeposit = other.getIsDeposit();
                                                                                                                                                                     if (this$isDeposit
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$isDeposit
                                                                                                                                                                           == null
                                                                                                                                                                        : this$isDeposit.equals(
                                                                                                                                                                           other$isDeposit
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$level = this.getLevel();
                                                                                                                                                                        Object other$level = other.getLevel();
                                                                                                                                                                        if (this$level
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$level
                                                                                                                                                                              == null
                                                                                                                                                                           : this$level.equals(
                                                                                                                                                                              other$level
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$installDivideMethod = this.getInstallDivideMethod();
                                                                                                                                                                           Object other$installDivideMethod = other.getInstallDivideMethod();
                                                                                                                                                                           if (this$installDivideMethod
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$installDivideMethod
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$installDivideMethod.equals(
                                                                                                                                                                                 other$installDivideMethod
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$lastUpdateUserId = this.getLastUpdateUserId();
                                                                                                                                                                              Object other$lastUpdateUserId = other.getLastUpdateUserId();
                                                                                                                                                                              if (this$lastUpdateUserId
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$lastUpdateUserId
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$lastUpdateUserId.equals(
                                                                                                                                                                                    other$lastUpdateUserId
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$serialNumber = this.getSerialNumber();
                                                                                                                                                                                 Object other$serialNumber = other.getSerialNumber();
                                                                                                                                                                                 if (this$serialNumber
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$serialNumber
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$serialNumber.equals(
                                                                                                                                                                                       other$serialNumber
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$name = this.getName();
                                                                                                                                                                                    Object other$name = other.getName();
                                                                                                                                                                                    if (this$name
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$name
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$name.equals(
                                                                                                                                                                                          other$name
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$shortName = this.getShortName();
                                                                                                                                                                                       Object other$shortName = other.getShortName();
                                                                                                                                                                                       if (this$shortName
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$shortName
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$shortName.equals(
                                                                                                                                                                                             other$shortName
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Object this$startDate = this.getStartDate();
                                                                                                                                                                                          Object other$startDate = other.getStartDate();
                                                                                                                                                                                          if (this$startDate
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$startDate
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$startDate.equals(
                                                                                                                                                                                                other$startDate
                                                                                                                                                                                             )
                                                                                                                                                                                             )
                                                                                                                                                                                           {
                                                                                                                                                                                             Object this$endDate = this.getEndDate();
                                                                                                                                                                                             Object other$endDate = other.getEndDate();
                                                                                                                                                                                             if (this$endDate
                                                                                                                                                                                                   == null
                                                                                                                                                                                                ? other$endDate
                                                                                                                                                                                                   == null
                                                                                                                                                                                                : this$endDate.equals(
                                                                                                                                                                                                   other$endDate
                                                                                                                                                                                                )
                                                                                                                                                                                                )
                                                                                                                                                                                              {
                                                                                                                                                                                                Object this$completeDate = this.getCompleteDate();
                                                                                                                                                                                                Object other$completeDate = other.getCompleteDate();
                                                                                                                                                                                                if (this$completeDate
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   ? other$completeDate
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   : this$completeDate.equals(
                                                                                                                                                                                                      other$completeDate
                                                                                                                                                                                                   )
                                                                                                                                                                                                   )
                                                                                                                                                                                                 {
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
                                                                                                                                                                                                         Object this$projectManagerPhone = this.getProjectManagerPhone();
                                                                                                                                                                                                         Object other$projectManagerPhone = other.getProjectManagerPhone();
                                                                                                                                                                                                         if (this$projectManagerPhone
                                                                                                                                                                                                               == null
                                                                                                                                                                                                            ? other$projectManagerPhone
                                                                                                                                                                                                               == null
                                                                                                                                                                                                            : this$projectManagerPhone.equals(
                                                                                                                                                                                                               other$projectManagerPhone
                                                                                                                                                                                                            )
                                                                                                                                                                                                            )
                                                                                                                                                                                                          {
                                                                                                                                                                                                            Object this$attachments = this.getAttachments();
                                                                                                                                                                                                            Object other$attachments = other.getAttachments();
                                                                                                                                                                                                            if (this$attachments
                                                                                                                                                                                                                  == null
                                                                                                                                                                                                               ? other$attachments
                                                                                                                                                                                                                  == null
                                                                                                                                                                                                               : this$attachments.equals(
                                                                                                                                                                                                                  other$attachments
                                                                                                                                                                                                               )
                                                                                                                                                                                                               )
                                                                                                                                                                                                             {
                                                                                                                                                                                                               Object this$archives = this.getArchives();
                                                                                                                                                                                                               Object other$archives = other.getArchives();
                                                                                                                                                                                                               if (this$archives
                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                  ? other$archives
                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                  : this$archives.equals(
                                                                                                                                                                                                                     other$archives
                                                                                                                                                                                                                  )
                                                                                                                                                                                                                  )
                                                                                                                                                                                                                {
                                                                                                                                                                                                                  Object this$cityName = this.getCityName();
                                                                                                                                                                                                                  Object other$cityName = other.getCityName();
                                                                                                                                                                                                                  if (this$cityName
                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                     ? other$cityName
                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                     : this$cityName.equals(
                                                                                                                                                                                                                        other$cityName
                                                                                                                                                                                                                     )
                                                                                                                                                                                                                     )
                                                                                                                                                                                                                   {
                                                                                                                                                                                                                     Object this$countryName = this.getCountryName();
                                                                                                                                                                                                                     Object other$countryName = other.getCountryName();
                                                                                                                                                                                                                     if (this$countryName
                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                        ? other$countryName
                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                        : this$countryName.equals(
                                                                                                                                                                                                                           other$countryName
                                                                                                                                                                                                                        )
                                                                                                                                                                                                                        )
                                                                                                                                                                                                                      {
                                                                                                                                                                                                                        Object this$contractAmount = this.getContractAmount();
                                                                                                                                                                                                                        Object other$contractAmount = other.getContractAmount();
                                                                                                                                                                                                                        if (this$contractAmount
                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                           ? other$contractAmount
                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                           : this$contractAmount.equals(
                                                                                                                                                                                                                              other$contractAmount
                                                                                                                                                                                                                           )
                                                                                                                                                                                                                           )
                                                                                                                                                                                                                         {
                                                                                                                                                                                                                           Object this$prepayments = this.getPrepayments();
                                                                                                                                                                                                                           Object other$prepayments = other.getPrepayments();
                                                                                                                                                                                                                           if (this$prepayments
                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                              ? other$prepayments
                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                              : this$prepayments.equals(
                                                                                                                                                                                                                                 other$prepayments
                                                                                                                                                                                                                              )
                                                                                                                                                                                                                              )
                                                                                                                                                                                                                            {
                                                                                                                                                                                                                              Object this$managementFeeRate = this.getManagementFeeRate();
                                                                                                                                                                                                                              Object other$managementFeeRate = other.getManagementFeeRate();
                                                                                                                                                                                                                              if (this$managementFeeRate
                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                 ? other$managementFeeRate
                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                 : this$managementFeeRate.equals(
                                                                                                                                                                                                                                    other$managementFeeRate
                                                                                                                                                                                                                                 )
                                                                                                                                                                                                                                 )
                                                                                                                                                                                                                               {
                                                                                                                                                                                                                                 Object this$marginAmount = this.getMarginAmount();
                                                                                                                                                                                                                                 Object other$marginAmount = other.getMarginAmount();
                                                                                                                                                                                                                                 if (this$marginAmount
                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                    ? other$marginAmount
                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                    : this$marginAmount.equals(
                                                                                                                                                                                                                                       other$marginAmount
                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                  {
                                                                                                                                                                                                                                    Object this$collectionMarginAmount = this.getCollectionMarginAmount();
                                                                                                                                                                                                                                    Object other$collectionMarginAmount = other.getCollectionMarginAmount();
                                                                                                                                                                                                                                    if (this$collectionMarginAmount
                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                       ? other$collectionMarginAmount
                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                       : this$collectionMarginAmount.equals(
                                                                                                                                                                                                                                          other$collectionMarginAmount
                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                     {
                                                                                                                                                                                                                                       Object this$currencyType = this.getCurrencyType();
                                                                                                                                                                                                                                       Object other$currencyType = other.getCurrencyType();
                                                                                                                                                                                                                                       if (this$currencyType
                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                          ? other$currencyType
                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                          : this$currencyType.equals(
                                                                                                                                                                                                                                             other$currencyType
                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                        {
                                                                                                                                                                                                                                          Object this$qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
                                                                                                                                                                                                                                          Object other$qualityGuaranteeDeposit = other.getQualityGuaranteeDeposit();
                                                                                                                                                                                                                                          if (this$qualityGuaranteeDeposit
                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                             ? other$qualityGuaranteeDeposit
                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                             : this$qualityGuaranteeDeposit.equals(
                                                                                                                                                                                                                                                other$qualityGuaranteeDeposit
                                                                                                                                                                                                                                             )
                                                                                                                                                                                                                                             )
                                                                                                                                                                                                                                           {
                                                                                                                                                                                                                                             Object this$settlementAmount = this.getSettlementAmount();
                                                                                                                                                                                                                                             Object other$settlementAmount = other.getSettlementAmount();
                                                                                                                                                                                                                                             if (this$settlementAmount
                                                                                                                                                                                                                                                   == null
                                                                                                                                                                                                                                                ? other$settlementAmount
                                                                                                                                                                                                                                                   == null
                                                                                                                                                                                                                                                : this$settlementAmount.equals(
                                                                                                                                                                                                                                                   other$settlementAmount
                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                              {
                                                                                                                                                                                                                                                Object this$provinceName = this.getProvinceName();
                                                                                                                                                                                                                                                Object other$provinceName = other.getProvinceName();
                                                                                                                                                                                                                                                if (this$provinceName
                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                   ? other$provinceName
                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                   : this$provinceName.equals(
                                                                                                                                                                                                                                                      other$provinceName
                                                                                                                                                                                                                                                   )
                                                                                                                                                                                                                                                   )
                                                                                                                                                                                                                                                 {
                                                                                                                                                                                                                                                   Object this$regionName = this.getRegionName();
                                                                                                                                                                                                                                                   Object other$regionName = other.getRegionName();
                                                                                                                                                                                                                                                   if (this$regionName
                                                                                                                                                                                                                                                         == null
                                                                                                                                                                                                                                                      ? other$regionName
                                                                                                                                                                                                                                                         == null
                                                                                                                                                                                                                                                      : this$regionName.equals(
                                                                                                                                                                                                                                                         other$regionName
                                                                                                                                                                                                                                                      )
                                                                                                                                                                                                                                                      )
                                                                                                                                                                                                                                                    {
                                                                                                                                                                                                                                                      Object this$projectContent = this.getProjectContent();
                                                                                                                                                                                                                                                      Object other$projectContent = other.getProjectContent();
                                                                                                                                                                                                                                                      if (this$projectContent
                                                                                                                                                                                                                                                            == null
                                                                                                                                                                                                                                                         ? other$projectContent
                                                                                                                                                                                                                                                            == null
                                                                                                                                                                                                                                                         : this$projectContent.equals(
                                                                                                                                                                                                                                                            other$projectContent
                                                                                                                                                                                                                                                         )
                                                                                                                                                                                                                                                         )
                                                                                                                                                                                                                                                       {
                                                                                                                                                                                                                                                         Object this$signingAddress = this.getSigningAddress();
                                                                                                                                                                                                                                                         Object other$signingAddress = other.getSigningAddress();
                                                                                                                                                                                                                                                         if (this$signingAddress
                                                                                                                                                                                                                                                               == null
                                                                                                                                                                                                                                                            ? other$signingAddress
                                                                                                                                                                                                                                                               == null
                                                                                                                                                                                                                                                            : this$signingAddress.equals(
                                                                                                                                                                                                                                                               other$signingAddress
                                                                                                                                                                                                                                                            )
                                                                                                                                                                                                                                                            )
                                                                                                                                                                                                                                                          {
                                                                                                                                                                                                                                                            Object this$signingDate = this.getSigningDate();
                                                                                                                                                                                                                                                            Object other$signingDate = other.getSigningDate();
                                                                                                                                                                                                                                                            if (this$signingDate
                                                                                                                                                                                                                                                                  == null
                                                                                                                                                                                                                                                               ? other$signingDate
                                                                                                                                                                                                                                                                  == null
                                                                                                                                                                                                                                                               : this$signingDate.equals(
                                                                                                                                                                                                                                                                  other$signingDate
                                                                                                                                                                                                                                                               )
                                                                                                                                                                                                                                                               )
                                                                                                                                                                                                                                                             {
                                                                                                                                                                                                                                                               Object this$signerName = this.getSignerName();
                                                                                                                                                                                                                                                               Object other$signerName = other.getSignerName();
                                                                                                                                                                                                                                                               if (this$signerName
                                                                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                                                                  ? other$signerName
                                                                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                                                                  : this$signerName.equals(
                                                                                                                                                                                                                                                                     other$signerName
                                                                                                                                                                                                                                                                  )
                                                                                                                                                                                                                                                                  )
                                                                                                                                                                                                                                                                {
                                                                                                                                                                                                                                                                  Object this$signerPhone = this.getSignerPhone();
                                                                                                                                                                                                                                                                  Object other$signerPhone = other.getSignerPhone();
                                                                                                                                                                                                                                                                  if (this$signerPhone
                                                                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                                                                     ? other$signerPhone
                                                                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                                                                     : this$signerPhone.equals(
                                                                                                                                                                                                                                                                        other$signerPhone
                                                                                                                                                                                                                                                                     )
                                                                                                                                                                                                                                                                     )
                                                                                                                                                                                                                                                                   {
                                                                                                                                                                                                                                                                     Object this$taxRate = this.getTaxRate();
                                                                                                                                                                                                                                                                     Object other$taxRate = other.getTaxRate();
                                                                                                                                                                                                                                                                     if (this$taxRate
                                                                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                                                                        ? other$taxRate
                                                                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                                                                        : this$taxRate.equals(
                                                                                                                                                                                                                                                                           other$taxRate
                                                                                                                                                                                                                                                                        )
                                                                                                                                                                                                                                                                        )
                                                                                                                                                                                                                                                                      {
                                                                                                                                                                                                                                                                        Object this$payTypeDesc = this.getPayTypeDesc();
                                                                                                                                                                                                                                                                        Object other$payTypeDesc = other.getPayTypeDesc();
                                                                                                                                                                                                                                                                        if (this$payTypeDesc
                                                                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                                                                           ? other$payTypeDesc
                                                                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                                                                           : this$payTypeDesc.equals(
                                                                                                                                                                                                                                                                              other$payTypeDesc
                                                                                                                                                                                                                                                                           )
                                                                                                                                                                                                                                                                           )
                                                                                                                                                                                                                                                                         {
                                                                                                                                                                                                                                                                           Object this$technologyRemark = this.getTechnologyRemark();
                                                                                                                                                                                                                                                                           Object other$technologyRemark = other.getTechnologyRemark();
                                                                                                                                                                                                                                                                           if (this$technologyRemark
                                                                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                                                                              ? other$technologyRemark
                                                                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                                                                              : this$technologyRemark.equals(
                                                                                                                                                                                                                                                                                 other$technologyRemark
                                                                                                                                                                                                                                                                              )
                                                                                                                                                                                                                                                                              )
                                                                                                                                                                                                                                                                            {
                                                                                                                                                                                                                                                                              Object this$customerUnit = this.getCustomerUnit();
                                                                                                                                                                                                                                                                              Object other$customerUnit = other.getCustomerUnit();
                                                                                                                                                                                                                                                                              if (this$customerUnit
                                                                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                                                                 ? other$customerUnit
                                                                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                                                                 : this$customerUnit.equals(
                                                                                                                                                                                                                                                                                    other$customerUnit
                                                                                                                                                                                                                                                                                 )
                                                                                                                                                                                                                                                                                 )
                                                                                                                                                                                                                                                                               {
                                                                                                                                                                                                                                                                                 Object this$socialCode = this.getSocialCode();
                                                                                                                                                                                                                                                                                 Object other$socialCode = other.getSocialCode();
                                                                                                                                                                                                                                                                                 if (this$socialCode
                                                                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                                                                    ? other$socialCode
                                                                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                                                                    : this$socialCode.equals(
                                                                                                                                                                                                                                                                                       other$socialCode
                                                                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                                                                  {
                                                                                                                                                                                                                                                                                    Object this$customerUnitPhone = this.getCustomerUnitPhone();
                                                                                                                                                                                                                                                                                    Object other$customerUnitPhone = other.getCustomerUnitPhone();
                                                                                                                                                                                                                                                                                    if (this$customerUnitPhone
                                                                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                                                                       ? other$customerUnitPhone
                                                                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                                                                       : this$customerUnitPhone.equals(
                                                                                                                                                                                                                                                                                          other$customerUnitPhone
                                                                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                                                                     {
                                                                                                                                                                                                                                                                                       Object this$customerEmail = this.getCustomerEmail();
                                                                                                                                                                                                                                                                                       Object other$customerEmail = other.getCustomerEmail();
                                                                                                                                                                                                                                                                                       if (this$customerEmail
                                                                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                                                                          ? other$customerEmail
                                                                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                                                                          : this$customerEmail.equals(
                                                                                                                                                                                                                                                                                             other$customerEmail
                                                                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                                                                        {
                                                                                                                                                                                                                                                                                          Object this$customerProvinceName = this.getCustomerProvinceName();
                                                                                                                                                                                                                                                                                          Object other$customerProvinceName = other.getCustomerProvinceName();
                                                                                                                                                                                                                                                                                          if (this$customerProvinceName
                                                                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                                                                             ? other$customerProvinceName
                                                                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                                                                             : this$customerProvinceName.equals(
                                                                                                                                                                                                                                                                                                other$customerProvinceName
                                                                                                                                                                                                                                                                                             )
                                                                                                                                                                                                                                                                                             )
                                                                                                                                                                                                                                                                                           {
                                                                                                                                                                                                                                                                                             Object this$customerCityName = this.getCustomerCityName();
                                                                                                                                                                                                                                                                                             Object other$customerCityName = other.getCustomerCityName();
                                                                                                                                                                                                                                                                                             if (this$customerCityName
                                                                                                                                                                                                                                                                                                   == null
                                                                                                                                                                                                                                                                                                ? other$customerCityName
                                                                                                                                                                                                                                                                                                   == null
                                                                                                                                                                                                                                                                                                : this$customerCityName.equals(
                                                                                                                                                                                                                                                                                                   other$customerCityName
                                                                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                                                              {
                                                                                                                                                                                                                                                                                                Object this$customerRegionName = this.getCustomerRegionName();
                                                                                                                                                                                                                                                                                                Object other$customerRegionName = other.getCustomerRegionName();
                                                                                                                                                                                                                                                                                                if (this$customerRegionName
                                                                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                                                                   ? other$customerRegionName
                                                                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                                                                   : this$customerRegionName.equals(
                                                                                                                                                                                                                                                                                                      other$customerRegionName
                                                                                                                                                                                                                                                                                                   )
                                                                                                                                                                                                                                                                                                   )
                                                                                                                                                                                                                                                                                                 {
                                                                                                                                                                                                                                                                                                   Object this$customerCountryName = this.getCustomerCountryName();
                                                                                                                                                                                                                                                                                                   Object other$customerCountryName = other.getCustomerCountryName();
                                                                                                                                                                                                                                                                                                   if (this$customerCountryName
                                                                                                                                                                                                                                                                                                         == null
                                                                                                                                                                                                                                                                                                      ? other$customerCountryName
                                                                                                                                                                                                                                                                                                         == null
                                                                                                                                                                                                                                                                                                      : this$customerCountryName.equals(
                                                                                                                                                                                                                                                                                                         other$customerCountryName
                                                                                                                                                                                                                                                                                                      )
                                                                                                                                                                                                                                                                                                      )
                                                                                                                                                                                                                                                                                                    {
                                                                                                                                                                                                                                                                                                      Object this$customerAddress = this.getCustomerAddress();
                                                                                                                                                                                                                                                                                                      Object other$customerAddress = other.getCustomerAddress();
                                                                                                                                                                                                                                                                                                      if (this$customerAddress
                                                                                                                                                                                                                                                                                                            == null
                                                                                                                                                                                                                                                                                                         ? other$customerAddress
                                                                                                                                                                                                                                                                                                            == null
                                                                                                                                                                                                                                                                                                         : this$customerAddress.equals(
                                                                                                                                                                                                                                                                                                            other$customerAddress
                                                                                                                                                                                                                                                                                                         )
                                                                                                                                                                                                                                                                                                         )
                                                                                                                                                                                                                                                                                                       {
                                                                                                                                                                                                                                                                                                         Object this$customerBankUserName = this.getCustomerBankUserName();
                                                                                                                                                                                                                                                                                                         Object other$customerBankUserName = other.getCustomerBankUserName();
                                                                                                                                                                                                                                                                                                         if (this$customerBankUserName
                                                                                                                                                                                                                                                                                                               == null
                                                                                                                                                                                                                                                                                                            ? other$customerBankUserName
                                                                                                                                                                                                                                                                                                               == null
                                                                                                                                                                                                                                                                                                            : this$customerBankUserName.equals(
                                                                                                                                                                                                                                                                                                               other$customerBankUserName
                                                                                                                                                                                                                                                                                                            )
                                                                                                                                                                                                                                                                                                            )
                                                                                                                                                                                                                                                                                                          {
                                                                                                                                                                                                                                                                                                            Object this$customerBankCode = this.getCustomerBankCode();
                                                                                                                                                                                                                                                                                                            Object other$customerBankCode = other.getCustomerBankCode();
                                                                                                                                                                                                                                                                                                            if (this$customerBankCode
                                                                                                                                                                                                                                                                                                                  == null
                                                                                                                                                                                                                                                                                                               ? other$customerBankCode
                                                                                                                                                                                                                                                                                                                  == null
                                                                                                                                                                                                                                                                                                               : this$customerBankCode.equals(
                                                                                                                                                                                                                                                                                                                  other$customerBankCode
                                                                                                                                                                                                                                                                                                               )
                                                                                                                                                                                                                                                                                                               )
                                                                                                                                                                                                                                                                                                             {
                                                                                                                                                                                                                                                                                                               Object this$customerBankName = this.getCustomerBankName();
                                                                                                                                                                                                                                                                                                               Object other$customerBankName = other.getCustomerBankName();
                                                                                                                                                                                                                                                                                                               if (this$customerBankName
                                                                                                                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                                                                                                                  ? other$customerBankName
                                                                                                                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                                                                                                                  : this$customerBankName.equals(
                                                                                                                                                                                                                                                                                                                     other$customerBankName
                                                                                                                                                                                                                                                                                                                  )
                                                                                                                                                                                                                                                                                                                  )
                                                                                                                                                                                                                                                                                                                {
                                                                                                                                                                                                                                                                                                                  Object this$customerManagerOne = this.getCustomerManagerOne();
                                                                                                                                                                                                                                                                                                                  Object other$customerManagerOne = other.getCustomerManagerOne();
                                                                                                                                                                                                                                                                                                                  if (this$customerManagerOne
                                                                                                                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                                                                                                                     ? other$customerManagerOne
                                                                                                                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                                                                                                                     : this$customerManagerOne.equals(
                                                                                                                                                                                                                                                                                                                        other$customerManagerOne
                                                                                                                                                                                                                                                                                                                     )
                                                                                                                                                                                                                                                                                                                     )
                                                                                                                                                                                                                                                                                                                   {
                                                                                                                                                                                                                                                                                                                     Object this$customerManagerOnePhone = this.getCustomerManagerOnePhone();
                                                                                                                                                                                                                                                                                                                     Object other$customerManagerOnePhone = other.getCustomerManagerOnePhone();
                                                                                                                                                                                                                                                                                                                     if (this$customerManagerOnePhone
                                                                                                                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                                                                                                                        ? other$customerManagerOnePhone
                                                                                                                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                                                                                                                        : this$customerManagerOnePhone.equals(
                                                                                                                                                                                                                                                                                                                           other$customerManagerOnePhone
                                                                                                                                                                                                                                                                                                                        )
                                                                                                                                                                                                                                                                                                                        )
                                                                                                                                                                                                                                                                                                                      {
                                                                                                                                                                                                                                                                                                                        Object this$customerManagerTwo = this.getCustomerManagerTwo();
                                                                                                                                                                                                                                                                                                                        Object other$customerManagerTwo = other.getCustomerManagerTwo();
                                                                                                                                                                                                                                                                                                                        if (this$customerManagerTwo
                                                                                                                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                                                                                                                           ? other$customerManagerTwo
                                                                                                                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                                                                                                                           : this$customerManagerTwo.equals(
                                                                                                                                                                                                                                                                                                                              other$customerManagerTwo
                                                                                                                                                                                                                                                                                                                           )
                                                                                                                                                                                                                                                                                                                           )
                                                                                                                                                                                                                                                                                                                         {
                                                                                                                                                                                                                                                                                                                           Object this$customerManagerTwoPhone = this.getCustomerManagerTwoPhone();
                                                                                                                                                                                                                                                                                                                           Object other$customerManagerTwoPhone = other.getCustomerManagerTwoPhone();
                                                                                                                                                                                                                                                                                                                           if (this$customerManagerTwoPhone
                                                                                                                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                                                                                                                              ? other$customerManagerTwoPhone
                                                                                                                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                                                                                                                              : this$customerManagerTwoPhone.equals(
                                                                                                                                                                                                                                                                                                                                 other$customerManagerTwoPhone
                                                                                                                                                                                                                                                                                                                              )
                                                                                                                                                                                                                                                                                                                              )
                                                                                                                                                                                                                                                                                                                            {
                                                                                                                                                                                                                                                                                                                              Object this$receivingManager = this.getReceivingManager();
                                                                                                                                                                                                                                                                                                                              Object other$receivingManager = other.getReceivingManager();
                                                                                                                                                                                                                                                                                                                              if (this$receivingManager
                                                                                                                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                                                                                                                 ? other$receivingManager
                                                                                                                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                                                                                                                 : this$receivingManager.equals(
                                                                                                                                                                                                                                                                                                                                    other$receivingManager
                                                                                                                                                                                                                                                                                                                                 )
                                                                                                                                                                                                                                                                                                                                 )
                                                                                                                                                                                                                                                                                                                               {
                                                                                                                                                                                                                                                                                                                                 Object this$receivingManagerPhone = this.getReceivingManagerPhone();
                                                                                                                                                                                                                                                                                                                                 Object other$receivingManagerPhone = other.getReceivingManagerPhone();
                                                                                                                                                                                                                                                                                                                                 if (this$receivingManagerPhone
                                                                                                                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                                                                                                                    ? other$receivingManagerPhone
                                                                                                                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                                                                                                                    : this$receivingManagerPhone.equals(
                                                                                                                                                                                                                                                                                                                                       other$receivingManagerPhone
                                                                                                                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                                                                                                                  {
                                                                                                                                                                                                                                                                                                                                    Object this$settleManager = this.getSettleManager();
                                                                                                                                                                                                                                                                                                                                    Object other$settleManager = other.getSettleManager();
                                                                                                                                                                                                                                                                                                                                    if (this$settleManager
                                                                                                                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                                                                                                                       ? other$settleManager
                                                                                                                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                                                                                                                       : this$settleManager.equals(
                                                                                                                                                                                                                                                                                                                                          other$settleManager
                                                                                                                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                                                                                                                     {
                                                                                                                                                                                                                                                                                                                                       Object this$settleManagerPhone = this.getSettleManagerPhone();
                                                                                                                                                                                                                                                                                                                                       Object other$settleManagerPhone = other.getSettleManagerPhone();
                                                                                                                                                                                                                                                                                                                                       if (this$settleManagerPhone
                                                                                                                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                                                                                                                          ? other$settleManagerPhone
                                                                                                                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                                                                                                                          : this$settleManagerPhone.equals(
                                                                                                                                                                                                                                                                                                                                             other$settleManagerPhone
                                                                                                                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                                                                                                                        {
                                                                                                                                                                                                                                                                                                                                          Object this$financeManager = this.getFinanceManager();
                                                                                                                                                                                                                                                                                                                                          Object other$financeManager = other.getFinanceManager();
                                                                                                                                                                                                                                                                                                                                          if (this$financeManager
                                                                                                                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                                                                                                                             ? other$financeManager
                                                                                                                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                                                                                                                             : this$financeManager.equals(
                                                                                                                                                                                                                                                                                                                                                other$financeManager
                                                                                                                                                                                                                                                                                                                                             )
                                                                                                                                                                                                                                                                                                                                             )
                                                                                                                                                                                                                                                                                                                                           {
                                                                                                                                                                                                                                                                                                                                             Object this$financeManagerPhone = this.getFinanceManagerPhone();
                                                                                                                                                                                                                                                                                                                                             Object other$financeManagerPhone = other.getFinanceManagerPhone();
                                                                                                                                                                                                                                                                                                                                             if (this$financeManagerPhone
                                                                                                                                                                                                                                                                                                                                                   == null
                                                                                                                                                                                                                                                                                                                                                ? other$financeManagerPhone
                                                                                                                                                                                                                                                                                                                                                   == null
                                                                                                                                                                                                                                                                                                                                                : this$financeManagerPhone.equals(
                                                                                                                                                                                                                                                                                                                                                   other$financeManagerPhone
                                                                                                                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                                                                                                              {
                                                                                                                                                                                                                                                                                                                                                Object this$auditManager = this.getAuditManager();
                                                                                                                                                                                                                                                                                                                                                Object other$auditManager = other.getAuditManager();
                                                                                                                                                                                                                                                                                                                                                if (this$auditManager
                                                                                                                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                                                                                                                   ? other$auditManager
                                                                                                                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                                                                                                                   : this$auditManager.equals(
                                                                                                                                                                                                                                                                                                                                                      other$auditManager
                                                                                                                                                                                                                                                                                                                                                   )
                                                                                                                                                                                                                                                                                                                                                   )
                                                                                                                                                                                                                                                                                                                                                 {
                                                                                                                                                                                                                                                                                                                                                   Object this$auditManagerPhone = this.getAuditManagerPhone();
                                                                                                                                                                                                                                                                                                                                                   Object other$auditManagerPhone = other.getAuditManagerPhone();
                                                                                                                                                                                                                                                                                                                                                   if (this$auditManagerPhone
                                                                                                                                                                                                                                                                                                                                                         == null
                                                                                                                                                                                                                                                                                                                                                      ? other$auditManagerPhone
                                                                                                                                                                                                                                                                                                                                                         == null
                                                                                                                                                                                                                                                                                                                                                      : this$auditManagerPhone.equals(
                                                                                                                                                                                                                                                                                                                                                         other$auditManagerPhone
                                                                                                                                                                                                                                                                                                                                                      )
                                                                                                                                                                                                                                                                                                                                                      )
                                                                                                                                                                                                                                                                                                                                                    {
                                                                                                                                                                                                                                                                                                                                                      Object this$designManager = this.getDesignManager();
                                                                                                                                                                                                                                                                                                                                                      Object other$designManager = other.getDesignManager();
                                                                                                                                                                                                                                                                                                                                                      if (this$designManager
                                                                                                                                                                                                                                                                                                                                                            == null
                                                                                                                                                                                                                                                                                                                                                         ? other$designManager
                                                                                                                                                                                                                                                                                                                                                            == null
                                                                                                                                                                                                                                                                                                                                                         : this$designManager.equals(
                                                                                                                                                                                                                                                                                                                                                            other$designManager
                                                                                                                                                                                                                                                                                                                                                         )
                                                                                                                                                                                                                                                                                                                                                         )
                                                                                                                                                                                                                                                                                                                                                       {
                                                                                                                                                                                                                                                                                                                                                         Object this$designManagerPhone = this.getDesignManagerPhone();
                                                                                                                                                                                                                                                                                                                                                         Object other$designManagerPhone = other.getDesignManagerPhone();
                                                                                                                                                                                                                                                                                                                                                         if (this$designManagerPhone
                                                                                                                                                                                                                                                                                                                                                               == null
                                                                                                                                                                                                                                                                                                                                                            ? other$designManagerPhone
                                                                                                                                                                                                                                                                                                                                                               == null
                                                                                                                                                                                                                                                                                                                                                            : this$designManagerPhone.equals(
                                                                                                                                                                                                                                                                                                                                                               other$designManagerPhone
                                                                                                                                                                                                                                                                                                                                                            )
                                                                                                                                                                                                                                                                                                                                                            )
                                                                                                                                                                                                                                                                                                                                                          {
                                                                                                                                                                                                                                                                                                                                                            Object this$mesStartDate = this.getMesStartDate();
                                                                                                                                                                                                                                                                                                                                                            Object other$mesStartDate = other.getMesStartDate();
                                                                                                                                                                                                                                                                                                                                                            if (this$mesStartDate
                                                                                                                                                                                                                                                                                                                                                                  == null
                                                                                                                                                                                                                                                                                                                                                               ? other$mesStartDate
                                                                                                                                                                                                                                                                                                                                                                  == null
                                                                                                                                                                                                                                                                                                                                                               : this$mesStartDate.equals(
                                                                                                                                                                                                                                                                                                                                                                  other$mesStartDate
                                                                                                                                                                                                                                                                                                                                                               )
                                                                                                                                                                                                                                                                                                                                                               )
                                                                                                                                                                                                                                                                                                                                                             {
                                                                                                                                                                                                                                                                                                                                                               Object this$mesEndDate = this.getMesEndDate();
                                                                                                                                                                                                                                                                                                                                                               Object other$mesEndDate = other.getMesEndDate();
                                                                                                                                                                                                                                                                                                                                                               if (this$mesEndDate
                                                                                                                                                                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                                                                                                                                                                  ? other$mesEndDate
                                                                                                                                                                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                                                                                                                                                                  : this$mesEndDate.equals(
                                                                                                                                                                                                                                                                                                                                                                     other$mesEndDate
                                                                                                                                                                                                                                                                                                                                                                  )
                                                                                                                                                                                                                                                                                                                                                                  )
                                                                                                                                                                                                                                                                                                                                                                {
                                                                                                                                                                                                                                                                                                                                                                  Object this$happenedAmount = this.getHappenedAmount();
                                                                                                                                                                                                                                                                                                                                                                  Object other$happenedAmount = other.getHappenedAmount();
                                                                                                                                                                                                                                                                                                                                                                  if (this$happenedAmount
                                                                                                                                                                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                                                                                                                                                                     ? other$happenedAmount
                                                                                                                                                                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                                                                                                                                                                     : this$happenedAmount.equals(
                                                                                                                                                                                                                                                                                                                                                                        other$happenedAmount
                                                                                                                                                                                                                                                                                                                                                                     )
                                                                                                                                                                                                                                                                                                                                                                     )
                                                                                                                                                                                                                                                                                                                                                                   {
                                                                                                                                                                                                                                                                                                                                                                     Object this$collectionAmount = this.getCollectionAmount();
                                                                                                                                                                                                                                                                                                                                                                     Object other$collectionAmount = other.getCollectionAmount();
                                                                                                                                                                                                                                                                                                                                                                     if (this$collectionAmount
                                                                                                                                                                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                                                                                                                                                                        ? other$collectionAmount
                                                                                                                                                                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                                                                                                                                                                        : this$collectionAmount.equals(
                                                                                                                                                                                                                                                                                                                                                                           other$collectionAmount
                                                                                                                                                                                                                                                                                                                                                                        )
                                                                                                                                                                                                                                                                                                                                                                        )
                                                                                                                                                                                                                                                                                                                                                                      {
                                                                                                                                                                                                                                                                                                                                                                        Object this$collectionSummary = this.getCollectionSummary();
                                                                                                                                                                                                                                                                                                                                                                        Object other$collectionSummary = other.getCollectionSummary();
                                                                                                                                                                                                                                                                                                                                                                        if (this$collectionSummary
                                                                                                                                                                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                                                                                                                                                                           ? other$collectionSummary
                                                                                                                                                                                                                                                                                                                                                                              == null
                                                                                                                                                                                                                                                                                                                                                                           : this$collectionSummary.equals(
                                                                                                                                                                                                                                                                                                                                                                              other$collectionSummary
                                                                                                                                                                                                                                                                                                                                                                           )
                                                                                                                                                                                                                                                                                                                                                                           )
                                                                                                                                                                                                                                                                                                                                                                         {
                                                                                                                                                                                                                                                                                                                                                                           Object this$invoiceAmount = this.getInvoiceAmount();
                                                                                                                                                                                                                                                                                                                                                                           Object other$invoiceAmount = other.getInvoiceAmount();
                                                                                                                                                                                                                                                                                                                                                                           if (this$invoiceAmount
                                                                                                                                                                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                                                                                                                                                                              ? other$invoiceAmount
                                                                                                                                                                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                                                                                                                                                                              : this$invoiceAmount.equals(
                                                                                                                                                                                                                                                                                                                                                                                 other$invoiceAmount
                                                                                                                                                                                                                                                                                                                                                                              )
                                                                                                                                                                                                                                                                                                                                                                              )
                                                                                                                                                                                                                                                                                                                                                                            {
                                                                                                                                                                                                                                                                                                                                                                              Object this$customerRemark = this.getCustomerRemark();
                                                                                                                                                                                                                                                                                                                                                                              Object other$customerRemark = other.getCustomerRemark();
                                                                                                                                                                                                                                                                                                                                                                              if (this$customerRemark
                                                                                                                                                                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                                                                                                                                                                 ? other$customerRemark
                                                                                                                                                                                                                                                                                                                                                                                    == null
                                                                                                                                                                                                                                                                                                                                                                                 : this$customerRemark.equals(
                                                                                                                                                                                                                                                                                                                                                                                    other$customerRemark
                                                                                                                                                                                                                                                                                                                                                                                 )
                                                                                                                                                                                                                                                                                                                                                                                 )
                                                                                                                                                                                                                                                                                                                                                                               {
                                                                                                                                                                                                                                                                                                                                                                                 Object this$commercialClause = this.getCommercialClause();
                                                                                                                                                                                                                                                                                                                                                                                 Object other$commercialClause = other.getCommercialClause();
                                                                                                                                                                                                                                                                                                                                                                                 if (this$commercialClause
                                                                                                                                                                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                                                                                                                                                                    ? other$commercialClause
                                                                                                                                                                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                                                                                                                                                                    : this$commercialClause.equals(
                                                                                                                                                                                                                                                                                                                                                                                       other$commercialClause
                                                                                                                                                                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                                                                                                                                                                  {
                                                                                                                                                                                                                                                                                                                                                                                    Object this$technologyClause = this.getTechnologyClause();
                                                                                                                                                                                                                                                                                                                                                                                    Object other$technologyClause = other.getTechnologyClause();
                                                                                                                                                                                                                                                                                                                                                                                    if (this$technologyClause
                                                                                                                                                                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                                                                                                                                                                       ? other$technologyClause
                                                                                                                                                                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                                                                                                                                                                       : this$technologyClause.equals(
                                                                                                                                                                                                                                                                                                                                                                                          other$technologyClause
                                                                                                                                                                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                                                                                                                                                                     {
                                                                                                                                                                                                                                                                                                                                                                                       Object this$otherRemarks = this.getOtherRemarks();
                                                                                                                                                                                                                                                                                                                                                                                       Object other$otherRemarks = other.getOtherRemarks();
                                                                                                                                                                                                                                                                                                                                                                                       if (this$otherRemarks
                                                                                                                                                                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                                                                                                                                                                          ? other$otherRemarks
                                                                                                                                                                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                                                                                                                                                                          : this$otherRemarks.equals(
                                                                                                                                                                                                                                                                                                                                                                                             other$otherRemarks
                                                                                                                                                                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                                                                                                                                                                        {
                                                                                                                                                                                                                                                                                                                                                                                          Object this$structureArea = this.getStructureArea();
                                                                                                                                                                                                                                                                                                                                                                                          Object other$structureArea = other.getStructureArea();
                                                                                                                                                                                                                                                                                                                                                                                          if (this$structureArea
                                                                                                                                                                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                                                                                                                                                                             ? other$structureArea
                                                                                                                                                                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                                                                                                                                                                             : this$structureArea.equals(
                                                                                                                                                                                                                                                                                                                                                                                                other$structureArea
                                                                                                                                                                                                                                                                                                                                                                                             )
                                                                                                                                                                                                                                                                                                                                                                                             )
                                                                                                                                                                                                                                                                                                                                                                                           {
                                                                                                                                                                                                                                                                                                                                                                                             Object this$contractSignBodyScale = this.getContractSignBodyScale();
                                                                                                                                                                                                                                                                                                                                                                                             Object other$contractSignBodyScale = other.getContractSignBodyScale();
                                                                                                                                                                                                                                                                                                                                                                                             if (this$contractSignBodyScale
                                                                                                                                                                                                                                                                                                                                                                                                   == null
                                                                                                                                                                                                                                                                                                                                                                                                ? other$contractSignBodyScale
                                                                                                                                                                                                                                                                                                                                                                                                   == null
                                                                                                                                                                                                                                                                                                                                                                                                : this$contractSignBodyScale.equals(
                                                                                                                                                                                                                                                                                                                                                                                                   other$contractSignBodyScale
                                                                                                                                                                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                                                                                                                                                              {
                                                                                                                                                                                                                                                                                                                                                                                                Object this$contractSignBodyAmount = this.getContractSignBodyAmount();
                                                                                                                                                                                                                                                                                                                                                                                                Object other$contractSignBodyAmount = other.getContractSignBodyAmount();
                                                                                                                                                                                                                                                                                                                                                                                                if (this$contractSignBodyAmount
                                                                                                                                                                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                                                                                                                                                                   ? other$contractSignBodyAmount
                                                                                                                                                                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                                                                                                                                                                   : this$contractSignBodyAmount.equals(
                                                                                                                                                                                                                                                                                                                                                                                                      other$contractSignBodyAmount
                                                                                                                                                                                                                                                                                                                                                                                                   )
                                                                                                                                                                                                                                                                                                                                                                                                   )
                                                                                                                                                                                                                                                                                                                                                                                                 {
                                                                                                                                                                                                                                                                                                                                                                                                   Object this$projectManagerScale = this.getProjectManagerScale();
                                                                                                                                                                                                                                                                                                                                                                                                   Object other$projectManagerScale = other.getProjectManagerScale();
                                                                                                                                                                                                                                                                                                                                                                                                   if (this$projectManagerScale
                                                                                                                                                                                                                                                                                                                                                                                                         == null
                                                                                                                                                                                                                                                                                                                                                                                                      ? other$projectManagerScale
                                                                                                                                                                                                                                                                                                                                                                                                         == null
                                                                                                                                                                                                                                                                                                                                                                                                      : this$projectManagerScale.equals(
                                                                                                                                                                                                                                                                                                                                                                                                         other$projectManagerScale
                                                                                                                                                                                                                                                                                                                                                                                                      )
                                                                                                                                                                                                                                                                                                                                                                                                      )
                                                                                                                                                                                                                                                                                                                                                                                                    {
                                                                                                                                                                                                                                                                                                                                                                                                      Object this$projectManagerAmount = this.getProjectManagerAmount();
                                                                                                                                                                                                                                                                                                                                                                                                      Object other$projectManagerAmount = other.getProjectManagerAmount();
                                                                                                                                                                                                                                                                                                                                                                                                      if (this$projectManagerAmount
                                                                                                                                                                                                                                                                                                                                                                                                            == null
                                                                                                                                                                                                                                                                                                                                                                                                         ? other$projectManagerAmount
                                                                                                                                                                                                                                                                                                                                                                                                            == null
                                                                                                                                                                                                                                                                                                                                                                                                         : this$projectManagerAmount.equals(
                                                                                                                                                                                                                                                                                                                                                                                                            other$projectManagerAmount
                                                                                                                                                                                                                                                                                                                                                                                                         )
                                                                                                                                                                                                                                                                                                                                                                                                         )
                                                                                                                                                                                                                                                                                                                                                                                                       {
                                                                                                                                                                                                                                                                                                                                                                                                         Object this$contractSignBodyCollectBalance = this.getContractSignBodyCollectBalance();
                                                                                                                                                                                                                                                                                                                                                                                                         Object other$contractSignBodyCollectBalance = other.getContractSignBodyCollectBalance();
                                                                                                                                                                                                                                                                                                                                                                                                         if (this$contractSignBodyCollectBalance
                                                                                                                                                                                                                                                                                                                                                                                                               == null
                                                                                                                                                                                                                                                                                                                                                                                                            ? other$contractSignBodyCollectBalance
                                                                                                                                                                                                                                                                                                                                                                                                               == null
                                                                                                                                                                                                                                                                                                                                                                                                            : this$contractSignBodyCollectBalance.equals(
                                                                                                                                                                                                                                                                                                                                                                                                               other$contractSignBodyCollectBalance
                                                                                                                                                                                                                                                                                                                                                                                                            )
                                                                                                                                                                                                                                                                                                                                                                                                            )
                                                                                                                                                                                                                                                                                                                                                                                                          {
                                                                                                                                                                                                                                                                                                                                                                                                            Object this$contractSignBodyInjectionBalance = this.getContractSignBodyInjectionBalance();
                                                                                                                                                                                                                                                                                                                                                                                                            Object other$contractSignBodyInjectionBalance = other.getContractSignBodyInjectionBalance();
                                                                                                                                                                                                                                                                                                                                                                                                            if (this$contractSignBodyInjectionBalance
                                                                                                                                                                                                                                                                                                                                                                                                                  == null
                                                                                                                                                                                                                                                                                                                                                                                                               ? other$contractSignBodyInjectionBalance
                                                                                                                                                                                                                                                                                                                                                                                                                  == null
                                                                                                                                                                                                                                                                                                                                                                                                               : this$contractSignBodyInjectionBalance.equals(
                                                                                                                                                                                                                                                                                                                                                                                                                  other$contractSignBodyInjectionBalance
                                                                                                                                                                                                                                                                                                                                                                                                               )
                                                                                                                                                                                                                                                                                                                                                                                                               )
                                                                                                                                                                                                                                                                                                                                                                                                             {
                                                                                                                                                                                                                                                                                                                                                                                                               Object this$projectManagerCollectBalance = this.getProjectManagerCollectBalance();
                                                                                                                                                                                                                                                                                                                                                                                                               Object other$projectManagerCollectBalance = other.getProjectManagerCollectBalance();
                                                                                                                                                                                                                                                                                                                                                                                                               if (this$projectManagerCollectBalance
                                                                                                                                                                                                                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                                                                                                                                                                                                                  ? other$projectManagerCollectBalance
                                                                                                                                                                                                                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                                                                                                                                                                                                                  : this$projectManagerCollectBalance.equals(
                                                                                                                                                                                                                                                                                                                                                                                                                     other$projectManagerCollectBalance
                                                                                                                                                                                                                                                                                                                                                                                                                  )
                                                                                                                                                                                                                                                                                                                                                                                                                  )
                                                                                                                                                                                                                                                                                                                                                                                                                {
                                                                                                                                                                                                                                                                                                                                                                                                                  Object this$projectManagerInjectionBalance = this.getProjectManagerInjectionBalance();
                                                                                                                                                                                                                                                                                                                                                                                                                  Object other$projectManagerInjectionBalance = other.getProjectManagerInjectionBalance();
                                                                                                                                                                                                                                                                                                                                                                                                                  if (this$projectManagerInjectionBalance
                                                                                                                                                                                                                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                                                                                                                                                                                                                     ? other$projectManagerInjectionBalance
                                                                                                                                                                                                                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                                                                                                                                                                                                                     : this$projectManagerInjectionBalance.equals(
                                                                                                                                                                                                                                                                                                                                                                                                                        other$projectManagerInjectionBalance
                                                                                                                                                                                                                                                                                                                                                                                                                     )
                                                                                                                                                                                                                                                                                                                                                                                                                     )
                                                                                                                                                                                                                                                                                                                                                                                                                   {
                                                                                                                                                                                                                                                                                                                                                                                                                     Object this$lastUpdateTime = this.getLastUpdateTime();
                                                                                                                                                                                                                                                                                                                                                                                                                     Object other$lastUpdateTime = other.getLastUpdateTime();
                                                                                                                                                                                                                                                                                                                                                                                                                     return this$lastUpdateTime
                                                                                                                                                                                                                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                                                                                                                                                                                                                        ? other$lastUpdateTime
                                                                                                                                                                                                                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                                                                                                                                                                                                                        : this$lastUpdateTime.equals(
                                                                                                                                                                                                                                                                                                                                                                                                                           other$lastUpdateTime
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
      return other instanceof ContractProject;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $salesLeaderId = this.getSalesLeaderId();
      result = result * 59 + ($salesLeaderId == null ? 43 : $salesLeaderId.hashCode());
      Object $businessLeaderId = this.getBusinessLeaderId();
      result = result * 59 + ($businessLeaderId == null ? 43 : $businessLeaderId.hashCode());
      Object $businessLeaderTwoId = this.getBusinessLeaderTwoId();
      result = result * 59 + ($businessLeaderTwoId == null ? 43 : $businessLeaderTwoId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $managementCostId = this.getManagementCostId();
      result = result * 59 + ($managementCostId == null ? 43 : $managementCostId.hashCode());
      Object $marginType = this.getMarginType();
      result = result * 59 + ($marginType == null ? 43 : $marginType.hashCode());
      Object $marginTypeId = this.getMarginTypeId();
      result = result * 59 + ($marginTypeId == null ? 43 : $marginTypeId.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $settlementAttachmentId = this.getSettlementAttachmentId();
      result = result * 59 + ($settlementAttachmentId == null ? 43 : $settlementAttachmentId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $structureTypeId = this.getStructureTypeId();
      result = result * 59 + ($structureTypeId == null ? 43 : $structureTypeId.hashCode());
      Object $productCategory = this.getProductCategory();
      result = result * 59 + ($productCategory == null ? 43 : $productCategory.hashCode());
      Object $transportMode = this.getTransportMode();
      result = result * 59 + ($transportMode == null ? 43 : $transportMode.hashCode());
      Object $enclosureTransportMode = this.getEnclosureTransportMode();
      result = result * 59 + ($enclosureTransportMode == null ? 43 : $enclosureTransportMode.hashCode());
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $enclosureMeasureMode = this.getEnclosureMeasureMode();
      result = result * 59 + ($enclosureMeasureMode == null ? 43 : $enclosureMeasureMode.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
      Object $isTax = this.getIsTax();
      result = result * 59 + ($isTax == null ? 43 : $isTax.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $payType = this.getPayType();
      result = result * 59 + ($payType == null ? 43 : $payType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $customerProvinceId = this.getCustomerProvinceId();
      result = result * 59 + ($customerProvinceId == null ? 43 : $customerProvinceId.hashCode());
      Object $customerCityId = this.getCustomerCityId();
      result = result * 59 + ($customerCityId == null ? 43 : $customerCityId.hashCode());
      Object $customerRegionId = this.getCustomerRegionId();
      result = result * 59 + ($customerRegionId == null ? 43 : $customerRegionId.hashCode());
      Object $customerCountryId = this.getCustomerCountryId();
      result = result * 59 + ($customerCountryId == null ? 43 : $customerCountryId.hashCode());
      Object $mode = this.getMode();
      result = result * 59 + ($mode == null ? 43 : $mode.hashCode());
      Object $boolRequiredWarehouse = this.getBoolRequiredWarehouse();
      result = result * 59 + ($boolRequiredWarehouse == null ? 43 : $boolRequiredWarehouse.hashCode());
      Object $outFinishStatus = this.getOutFinishStatus();
      result = result * 59 + ($outFinishStatus == null ? 43 : $outFinishStatus.hashCode());
      Object $boolArrears = this.getBoolArrears();
      result = result * 59 + ($boolArrears == null ? 43 : $boolArrears.hashCode());
      Object $installReportMethod = this.getInstallReportMethod();
      result = result * 59 + ($installReportMethod == null ? 43 : $installReportMethod.hashCode());
      Object $orderSourceType = this.getOrderSourceType();
      result = result * 59 + ($orderSourceType == null ? 43 : $orderSourceType.hashCode());
      Object $isEffective = this.getIsEffective();
      result = result * 59 + ($isEffective == null ? 43 : $isEffective.hashCode());
      Object $pId = this.getPId();
      result = result * 59 + ($pId == null ? 43 : $pId.hashCode());
      Object $sendingMode = this.getSendingMode();
      result = result * 59 + ($sendingMode == null ? 43 : $sendingMode.hashCode());
      Object $infoSource = this.getInfoSource();
      result = result * 59 + ($infoSource == null ? 43 : $infoSource.hashCode());
      Object $isBuilding = this.getIsBuilding();
      result = result * 59 + ($isBuilding == null ? 43 : $isBuilding.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $allDays = this.getAllDays();
      result = result * 59 + ($allDays == null ? 43 : $allDays.hashCode());
      Object $partyType = this.getPartyType();
      result = result * 59 + ($partyType == null ? 43 : $partyType.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $contractType = this.getContractType();
      result = result * 59 + ($contractType == null ? 43 : $contractType.hashCode());
      Object $lumpSumSystemType = this.getLumpSumSystemType();
      result = result * 59 + ($lumpSumSystemType == null ? 43 : $lumpSumSystemType.hashCode());
      Object $isArchive = this.getIsArchive();
      result = result * 59 + ($isArchive == null ? 43 : $isArchive.hashCode());
      Object $unitType = this.getUnitType();
      result = result * 59 + ($unitType == null ? 43 : $unitType.hashCode());
      Object $isDeposit = this.getIsDeposit();
      result = result * 59 + ($isDeposit == null ? 43 : $isDeposit.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $installDivideMethod = this.getInstallDivideMethod();
      result = result * 59 + ($installDivideMethod == null ? 43 : $installDivideMethod.hashCode());
      Object $lastUpdateUserId = this.getLastUpdateUserId();
      result = result * 59 + ($lastUpdateUserId == null ? 43 : $lastUpdateUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $completeDate = this.getCompleteDate();
      result = result * 59 + ($completeDate == null ? 43 : $completeDate.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $projectManagerPhone = this.getProjectManagerPhone();
      result = result * 59 + ($projectManagerPhone == null ? 43 : $projectManagerPhone.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $archives = this.getArchives();
      result = result * 59 + ($archives == null ? 43 : $archives.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $prepayments = this.getPrepayments();
      result = result * 59 + ($prepayments == null ? 43 : $prepayments.hashCode());
      Object $managementFeeRate = this.getManagementFeeRate();
      result = result * 59 + ($managementFeeRate == null ? 43 : $managementFeeRate.hashCode());
      Object $marginAmount = this.getMarginAmount();
      result = result * 59 + ($marginAmount == null ? 43 : $marginAmount.hashCode());
      Object $collectionMarginAmount = this.getCollectionMarginAmount();
      result = result * 59 + ($collectionMarginAmount == null ? 43 : $collectionMarginAmount.hashCode());
      Object $currencyType = this.getCurrencyType();
      result = result * 59 + ($currencyType == null ? 43 : $currencyType.hashCode());
      Object $qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
      result = result * 59 + ($qualityGuaranteeDeposit == null ? 43 : $qualityGuaranteeDeposit.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $projectContent = this.getProjectContent();
      result = result * 59 + ($projectContent == null ? 43 : $projectContent.hashCode());
      Object $signingAddress = this.getSigningAddress();
      result = result * 59 + ($signingAddress == null ? 43 : $signingAddress.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $signerPhone = this.getSignerPhone();
      result = result * 59 + ($signerPhone == null ? 43 : $signerPhone.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $payTypeDesc = this.getPayTypeDesc();
      result = result * 59 + ($payTypeDesc == null ? 43 : $payTypeDesc.hashCode());
      Object $technologyRemark = this.getTechnologyRemark();
      result = result * 59 + ($technologyRemark == null ? 43 : $technologyRemark.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $socialCode = this.getSocialCode();
      result = result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
      Object $customerUnitPhone = this.getCustomerUnitPhone();
      result = result * 59 + ($customerUnitPhone == null ? 43 : $customerUnitPhone.hashCode());
      Object $customerEmail = this.getCustomerEmail();
      result = result * 59 + ($customerEmail == null ? 43 : $customerEmail.hashCode());
      Object $customerProvinceName = this.getCustomerProvinceName();
      result = result * 59 + ($customerProvinceName == null ? 43 : $customerProvinceName.hashCode());
      Object $customerCityName = this.getCustomerCityName();
      result = result * 59 + ($customerCityName == null ? 43 : $customerCityName.hashCode());
      Object $customerRegionName = this.getCustomerRegionName();
      result = result * 59 + ($customerRegionName == null ? 43 : $customerRegionName.hashCode());
      Object $customerCountryName = this.getCustomerCountryName();
      result = result * 59 + ($customerCountryName == null ? 43 : $customerCountryName.hashCode());
      Object $customerAddress = this.getCustomerAddress();
      result = result * 59 + ($customerAddress == null ? 43 : $customerAddress.hashCode());
      Object $customerBankUserName = this.getCustomerBankUserName();
      result = result * 59 + ($customerBankUserName == null ? 43 : $customerBankUserName.hashCode());
      Object $customerBankCode = this.getCustomerBankCode();
      result = result * 59 + ($customerBankCode == null ? 43 : $customerBankCode.hashCode());
      Object $customerBankName = this.getCustomerBankName();
      result = result * 59 + ($customerBankName == null ? 43 : $customerBankName.hashCode());
      Object $customerManagerOne = this.getCustomerManagerOne();
      result = result * 59 + ($customerManagerOne == null ? 43 : $customerManagerOne.hashCode());
      Object $customerManagerOnePhone = this.getCustomerManagerOnePhone();
      result = result * 59 + ($customerManagerOnePhone == null ? 43 : $customerManagerOnePhone.hashCode());
      Object $customerManagerTwo = this.getCustomerManagerTwo();
      result = result * 59 + ($customerManagerTwo == null ? 43 : $customerManagerTwo.hashCode());
      Object $customerManagerTwoPhone = this.getCustomerManagerTwoPhone();
      result = result * 59 + ($customerManagerTwoPhone == null ? 43 : $customerManagerTwoPhone.hashCode());
      Object $receivingManager = this.getReceivingManager();
      result = result * 59 + ($receivingManager == null ? 43 : $receivingManager.hashCode());
      Object $receivingManagerPhone = this.getReceivingManagerPhone();
      result = result * 59 + ($receivingManagerPhone == null ? 43 : $receivingManagerPhone.hashCode());
      Object $settleManager = this.getSettleManager();
      result = result * 59 + ($settleManager == null ? 43 : $settleManager.hashCode());
      Object $settleManagerPhone = this.getSettleManagerPhone();
      result = result * 59 + ($settleManagerPhone == null ? 43 : $settleManagerPhone.hashCode());
      Object $financeManager = this.getFinanceManager();
      result = result * 59 + ($financeManager == null ? 43 : $financeManager.hashCode());
      Object $financeManagerPhone = this.getFinanceManagerPhone();
      result = result * 59 + ($financeManagerPhone == null ? 43 : $financeManagerPhone.hashCode());
      Object $auditManager = this.getAuditManager();
      result = result * 59 + ($auditManager == null ? 43 : $auditManager.hashCode());
      Object $auditManagerPhone = this.getAuditManagerPhone();
      result = result * 59 + ($auditManagerPhone == null ? 43 : $auditManagerPhone.hashCode());
      Object $designManager = this.getDesignManager();
      result = result * 59 + ($designManager == null ? 43 : $designManager.hashCode());
      Object $designManagerPhone = this.getDesignManagerPhone();
      result = result * 59 + ($designManagerPhone == null ? 43 : $designManagerPhone.hashCode());
      Object $mesStartDate = this.getMesStartDate();
      result = result * 59 + ($mesStartDate == null ? 43 : $mesStartDate.hashCode());
      Object $mesEndDate = this.getMesEndDate();
      result = result * 59 + ($mesEndDate == null ? 43 : $mesEndDate.hashCode());
      Object $happenedAmount = this.getHappenedAmount();
      result = result * 59 + ($happenedAmount == null ? 43 : $happenedAmount.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $collectionSummary = this.getCollectionSummary();
      result = result * 59 + ($collectionSummary == null ? 43 : $collectionSummary.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $customerRemark = this.getCustomerRemark();
      result = result * 59 + ($customerRemark == null ? 43 : $customerRemark.hashCode());
      Object $commercialClause = this.getCommercialClause();
      result = result * 59 + ($commercialClause == null ? 43 : $commercialClause.hashCode());
      Object $technologyClause = this.getTechnologyClause();
      result = result * 59 + ($technologyClause == null ? 43 : $technologyClause.hashCode());
      Object $otherRemarks = this.getOtherRemarks();
      result = result * 59 + ($otherRemarks == null ? 43 : $otherRemarks.hashCode());
      Object $structureArea = this.getStructureArea();
      result = result * 59 + ($structureArea == null ? 43 : $structureArea.hashCode());
      Object $contractSignBodyScale = this.getContractSignBodyScale();
      result = result * 59 + ($contractSignBodyScale == null ? 43 : $contractSignBodyScale.hashCode());
      Object $contractSignBodyAmount = this.getContractSignBodyAmount();
      result = result * 59 + ($contractSignBodyAmount == null ? 43 : $contractSignBodyAmount.hashCode());
      Object $projectManagerScale = this.getProjectManagerScale();
      result = result * 59 + ($projectManagerScale == null ? 43 : $projectManagerScale.hashCode());
      Object $projectManagerAmount = this.getProjectManagerAmount();
      result = result * 59 + ($projectManagerAmount == null ? 43 : $projectManagerAmount.hashCode());
      Object $contractSignBodyCollectBalance = this.getContractSignBodyCollectBalance();
      result = result * 59 + ($contractSignBodyCollectBalance == null ? 43 : $contractSignBodyCollectBalance.hashCode());
      Object $contractSignBodyInjectionBalance = this.getContractSignBodyInjectionBalance();
      result = result * 59 + ($contractSignBodyInjectionBalance == null ? 43 : $contractSignBodyInjectionBalance.hashCode());
      Object $projectManagerCollectBalance = this.getProjectManagerCollectBalance();
      result = result * 59 + ($projectManagerCollectBalance == null ? 43 : $projectManagerCollectBalance.hashCode());
      Object $projectManagerInjectionBalance = this.getProjectManagerInjectionBalance();
      result = result * 59 + ($projectManagerInjectionBalance == null ? 43 : $projectManagerInjectionBalance.hashCode());
      Object $lastUpdateTime = this.getLastUpdateTime();
      return result * 59 + ($lastUpdateTime == null ? 43 : $lastUpdateTime.hashCode());
   }

   public static class ContractProjectBuilder {
      private Long id;
      private String serialNumber;
      private String name;
      private String shortName;
      private LocalDate startDate;
      private LocalDate endDate;
      private LocalDate completeDate;
      private String address;
      private Long projectManagerId;
      private String projectManagerName;
      private String projectManagerPhone;
      private Long salesLeaderId;
      private Long businessLeaderId;
      private Long businessLeaderTwoId;
      private String attachments;
      private String archives;
      private Long cityId;
      private String cityName;
      private Long countryId;
      private String countryName;
      private BigDecimal contractAmount;
      private BigDecimal prepayments;
      private BigDecimal managementFeeRate;
      private Long managementCostId;
      private BigDecimal marginAmount;
      private BigDecimal collectionMarginAmount;
      private Long marginType;
      private Long marginTypeId;
      private String currencyType;
      private BigDecimal qualityGuaranteeDeposit;
      private Integer settlementStatus;
      private BigDecimal settlementAmount;
      private Long settlementAttachmentId;
      private Long provinceId;
      private String provinceName;
      private Long regionId;
      private String regionName;
      private Long contractSignBodyId;
      private Integer businessType;
      private Integer projectType;
      private String projectContent;
      private Long structureStatus;
      private Long structureTypeId;
      private Integer productCategory;
      private Integer transportMode;
      private Integer enclosureTransportMode;
      private Integer structureMeasureMode;
      private Integer enclosureMeasureMode;
      private String signingAddress;
      private LocalDate signingDate;
      private Long signerId;
      private String signerName;
      private String signerPhone;
      private Integer isTax;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private Integer payType;
      private String payTypeDesc;
      private String technologyRemark;
      private String customerUnit;
      private String socialCode;
      private String customerUnitPhone;
      private String customerEmail;
      private Long userId;
      private Integer status;
      private Long customerProvinceId;
      private String customerProvinceName;
      private Long customerCityId;
      private String customerCityName;
      private Long customerRegionId;
      private String customerRegionName;
      private Long customerCountryId;
      private String customerCountryName;
      private String customerAddress;
      private String customerBankUserName;
      private String customerBankCode;
      private String customerBankName;
      private String customerManagerOne;
      private String customerManagerOnePhone;
      private String customerManagerTwo;
      private String customerManagerTwoPhone;
      private String receivingManager;
      private String receivingManagerPhone;
      private String settleManager;
      private String settleManagerPhone;
      private String financeManager;
      private String financeManagerPhone;
      private String auditManager;
      private String auditManagerPhone;
      private String designManager;
      private String designManagerPhone;
      private Integer mode;
      private Boolean boolRequiredWarehouse;
      private LocalDateTime mesStartDate;
      private LocalDateTime mesEndDate;
      private BigDecimal happenedAmount;
      private Boolean outFinishStatus;
      private Boolean boolArrears;
      private BigDecimal collectionAmount;
      private BigDecimal collectionSummary;
      private BigDecimal invoiceAmount;
      private Integer installReportMethod;
      private Integer orderSourceType;
      private String customerRemark;
      private Integer isEffective;
      private String commercialClause;
      private String technologyClause;
      private String otherRemarks;
      private Long pId;
      private Long sendingMode;
      private Long infoSource;
      private Integer isBuilding;
      private Long deptId;
      private Integer allDays;
      private Long partyType;
      private BigDecimal structureArea;
      private Integer projectAttribute;
      private Integer contractType;
      private Integer lumpSumSystemType;
      private Integer isArchive;
      private Integer unitType;
      private Boolean isDeposit;
      private BigDecimal contractSignBodyScale;
      private BigDecimal contractSignBodyAmount;
      private BigDecimal projectManagerScale;
      private BigDecimal projectManagerAmount;
      private BigDecimal contractSignBodyCollectBalance;
      private BigDecimal contractSignBodyInjectionBalance;
      private BigDecimal projectManagerCollectBalance;
      private BigDecimal projectManagerInjectionBalance;
      private Integer level;
      private Integer installDivideMethod;
      private LocalDateTime lastUpdateTime;
      private Long lastUpdateUserId;

      ContractProjectBuilder() {
      }

      @JsonProperty("id")
      public ContractProject.ContractProjectBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serial_number")
      public ContractProject.ContractProjectBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("name")
      public ContractProject.ContractProjectBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("short_name")
      public ContractProject.ContractProjectBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("start_date")
      public ContractProject.ContractProjectBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("end_date")
      public ContractProject.ContractProjectBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      @JsonProperty("complete_date")
      public ContractProject.ContractProjectBuilder completeDate(final LocalDate completeDate) {
         this.completeDate = completeDate;
         return this;
      }

      @JsonProperty("address")
      public ContractProject.ContractProjectBuilder address(final String address) {
         this.address = address;
         return this;
      }

      @JsonProperty("project_manager_id")
      public ContractProject.ContractProjectBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractProject.ContractProjectBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public ContractProject.ContractProjectBuilder projectManagerPhone(final String projectManagerPhone) {
         this.projectManagerPhone = projectManagerPhone;
         return this;
      }

      @JsonProperty("salesLeaderId")
      public ContractProject.ContractProjectBuilder salesLeaderId(final Long salesLeaderId) {
         this.salesLeaderId = salesLeaderId;
         return this;
      }

      @JsonProperty("business_leader_id")
      public ContractProject.ContractProjectBuilder businessLeaderId(final Long businessLeaderId) {
         this.businessLeaderId = businessLeaderId;
         return this;
      }

      @JsonProperty("business_leader_two_id")
      public ContractProject.ContractProjectBuilder businessLeaderTwoId(final Long businessLeaderTwoId) {
         this.businessLeaderTwoId = businessLeaderTwoId;
         return this;
      }

      @JsonProperty("attachments")
      public ContractProject.ContractProjectBuilder attachments(final String attachments) {
         this.attachments = attachments;
         return this;
      }

      @JsonProperty("archives")
      public ContractProject.ContractProjectBuilder archives(final String archives) {
         this.archives = archives;
         return this;
      }

      @JsonProperty("city_id")
      public ContractProject.ContractProjectBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      @JsonProperty("city_name")
      public ContractProject.ContractProjectBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      @JsonProperty("country_id")
      public ContractProject.ContractProjectBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      @JsonProperty("country_name")
      public ContractProject.ContractProjectBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      @JsonProperty("contract_amount")
      public ContractProject.ContractProjectBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      @JsonProperty("prepayments")
      public ContractProject.ContractProjectBuilder prepayments(final BigDecimal prepayments) {
         this.prepayments = prepayments;
         return this;
      }

      @JsonProperty("management_fee_rate")
      public ContractProject.ContractProjectBuilder managementFeeRate(final BigDecimal managementFeeRate) {
         this.managementFeeRate = managementFeeRate;
         return this;
      }

      @JsonProperty("management_cost_id")
      public ContractProject.ContractProjectBuilder managementCostId(final Long managementCostId) {
         this.managementCostId = managementCostId;
         return this;
      }

      @JsonProperty("margin_amount")
      public ContractProject.ContractProjectBuilder marginAmount(final BigDecimal marginAmount) {
         this.marginAmount = marginAmount;
         return this;
      }

      public ContractProject.ContractProjectBuilder collectionMarginAmount(final BigDecimal collectionMarginAmount) {
         this.collectionMarginAmount = collectionMarginAmount;
         return this;
      }

      @JsonProperty("margin_type")
      public ContractProject.ContractProjectBuilder marginType(final Long marginType) {
         this.marginType = marginType;
         return this;
      }

      @JsonProperty("margin_type_id")
      public ContractProject.ContractProjectBuilder marginTypeId(final Long marginTypeId) {
         this.marginTypeId = marginTypeId;
         return this;
      }

      @JsonProperty("currency_type")
      public ContractProject.ContractProjectBuilder currencyType(final String currencyType) {
         this.currencyType = currencyType;
         return this;
      }

      public ContractProject.ContractProjectBuilder qualityGuaranteeDeposit(final BigDecimal qualityGuaranteeDeposit) {
         this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
         return this;
      }

      @JsonProperty("settlement_status")
      public ContractProject.ContractProjectBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      @JsonProperty("settlement_amount")
      public ContractProject.ContractProjectBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public ContractProject.ContractProjectBuilder settlementAttachmentId(final Long settlementAttachmentId) {
         this.settlementAttachmentId = settlementAttachmentId;
         return this;
      }

      @JsonProperty("province_id")
      public ContractProject.ContractProjectBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      @JsonProperty("province_name")
      public ContractProject.ContractProjectBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      @JsonProperty("region_id")
      public ContractProject.ContractProjectBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      @JsonProperty("region_name")
      public ContractProject.ContractProjectBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      @JsonProperty("contract_sign_body_id")
      public ContractProject.ContractProjectBuilder contractSignBodyId(final Long contractSignBodyId) {
         this.contractSignBodyId = contractSignBodyId;
         return this;
      }

      @JsonProperty("business_type")
      public ContractProject.ContractProjectBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      @JsonProperty("project_type")
      public ContractProject.ContractProjectBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      @JsonProperty("project_content")
      public ContractProject.ContractProjectBuilder projectContent(final String projectContent) {
         this.projectContent = projectContent;
         return this;
      }

      @Deprecated
      public ContractProject.ContractProjectBuilder structureStatus(final Long structureStatus) {
         this.structureStatus = structureStatus;
         return this;
      }

      public ContractProject.ContractProjectBuilder structureTypeId(final Long structureTypeId) {
         this.structureTypeId = structureTypeId;
         return this;
      }

      @JsonProperty("productCategory")
      public ContractProject.ContractProjectBuilder productCategory(final Integer productCategory) {
         this.productCategory = productCategory;
         return this;
      }

      @JsonProperty("transportMode")
      public ContractProject.ContractProjectBuilder transportMode(final Integer transportMode) {
         this.transportMode = transportMode;
         return this;
      }

      @JsonProperty("enclosureTransportMode")
      public ContractProject.ContractProjectBuilder enclosureTransportMode(final Integer enclosureTransportMode) {
         this.enclosureTransportMode = enclosureTransportMode;
         return this;
      }

      @JsonProperty("structureMeasureMode")
      public ContractProject.ContractProjectBuilder structureMeasureMode(final Integer structureMeasureMode) {
         this.structureMeasureMode = structureMeasureMode;
         return this;
      }

      @JsonProperty("enclosureMeasureMode")
      public ContractProject.ContractProjectBuilder enclosureMeasureMode(final Integer enclosureMeasureMode) {
         this.enclosureMeasureMode = enclosureMeasureMode;
         return this;
      }

      @JsonProperty("signing_address")
      public ContractProject.ContractProjectBuilder signingAddress(final String signingAddress) {
         this.signingAddress = signingAddress;
         return this;
      }

      @JsonProperty("signing_date")
      public ContractProject.ContractProjectBuilder signingDate(final LocalDate signingDate) {
         this.signingDate = signingDate;
         return this;
      }

      @JsonProperty("signer_id")
      public ContractProject.ContractProjectBuilder signerId(final Long signerId) {
         this.signerId = signerId;
         return this;
      }

      @JsonProperty("signer_name")
      public ContractProject.ContractProjectBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      public ContractProject.ContractProjectBuilder signerPhone(final String signerPhone) {
         this.signerPhone = signerPhone;
         return this;
      }

      @JsonProperty("is_tax")
      public ContractProject.ContractProjectBuilder isTax(final Integer isTax) {
         this.isTax = isTax;
         return this;
      }

      @JsonProperty("invoice_type")
      public ContractProject.ContractProjectBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("tax_rate")
      public ContractProject.ContractProjectBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("pay_type")
      public ContractProject.ContractProjectBuilder payType(final Integer payType) {
         this.payType = payType;
         return this;
      }

      @JsonProperty("pay_type_desc")
      public ContractProject.ContractProjectBuilder payTypeDesc(final String payTypeDesc) {
         this.payTypeDesc = payTypeDesc;
         return this;
      }

      @JsonProperty("technologyRemark")
      public ContractProject.ContractProjectBuilder technologyRemark(final String technologyRemark) {
         this.technologyRemark = technologyRemark;
         return this;
      }

      @JsonProperty("customer_unit")
      public ContractProject.ContractProjectBuilder customerUnit(final String customerUnit) {
         this.customerUnit = customerUnit;
         return this;
      }

      @JsonProperty("social_code")
      public ContractProject.ContractProjectBuilder socialCode(final String socialCode) {
         this.socialCode = socialCode;
         return this;
      }

      @JsonProperty("customer_unit_phone")
      public ContractProject.ContractProjectBuilder customerUnitPhone(final String customerUnitPhone) {
         this.customerUnitPhone = customerUnitPhone;
         return this;
      }

      @JsonProperty("customer_email")
      public ContractProject.ContractProjectBuilder customerEmail(final String customerEmail) {
         this.customerEmail = customerEmail;
         return this;
      }

      @JsonProperty("user_id")
      public ContractProject.ContractProjectBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("status")
      public ContractProject.ContractProjectBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("customer_province_id")
      public ContractProject.ContractProjectBuilder customerProvinceId(final Long customerProvinceId) {
         this.customerProvinceId = customerProvinceId;
         return this;
      }

      @JsonProperty("customer_province_name")
      public ContractProject.ContractProjectBuilder customerProvinceName(final String customerProvinceName) {
         this.customerProvinceName = customerProvinceName;
         return this;
      }

      @JsonProperty("customer_city_id")
      public ContractProject.ContractProjectBuilder customerCityId(final Long customerCityId) {
         this.customerCityId = customerCityId;
         return this;
      }

      @JsonProperty("customer_city_name")
      public ContractProject.ContractProjectBuilder customerCityName(final String customerCityName) {
         this.customerCityName = customerCityName;
         return this;
      }

      @JsonProperty("customer_region_id")
      public ContractProject.ContractProjectBuilder customerRegionId(final Long customerRegionId) {
         this.customerRegionId = customerRegionId;
         return this;
      }

      @JsonProperty("customer_region_name")
      public ContractProject.ContractProjectBuilder customerRegionName(final String customerRegionName) {
         this.customerRegionName = customerRegionName;
         return this;
      }

      @JsonProperty("customer_country_id")
      public ContractProject.ContractProjectBuilder customerCountryId(final Long customerCountryId) {
         this.customerCountryId = customerCountryId;
         return this;
      }

      @JsonProperty("customer_country_name")
      public ContractProject.ContractProjectBuilder customerCountryName(final String customerCountryName) {
         this.customerCountryName = customerCountryName;
         return this;
      }

      @JsonProperty("customer_address")
      public ContractProject.ContractProjectBuilder customerAddress(final String customerAddress) {
         this.customerAddress = customerAddress;
         return this;
      }

      @JsonProperty("customer_bank_user_name")
      public ContractProject.ContractProjectBuilder customerBankUserName(final String customerBankUserName) {
         this.customerBankUserName = customerBankUserName;
         return this;
      }

      @JsonProperty("customer_bank_code")
      public ContractProject.ContractProjectBuilder customerBankCode(final String customerBankCode) {
         this.customerBankCode = customerBankCode;
         return this;
      }

      @JsonProperty("customer_bank_name")
      public ContractProject.ContractProjectBuilder customerBankName(final String customerBankName) {
         this.customerBankName = customerBankName;
         return this;
      }

      @JsonProperty("customer_manager_one")
      public ContractProject.ContractProjectBuilder customerManagerOne(final String customerManagerOne) {
         this.customerManagerOne = customerManagerOne;
         return this;
      }

      @JsonProperty("customer_manager_one_phone")
      public ContractProject.ContractProjectBuilder customerManagerOnePhone(final String customerManagerOnePhone) {
         this.customerManagerOnePhone = customerManagerOnePhone;
         return this;
      }

      @JsonProperty("customer_manager_two")
      public ContractProject.ContractProjectBuilder customerManagerTwo(final String customerManagerTwo) {
         this.customerManagerTwo = customerManagerTwo;
         return this;
      }

      @JsonProperty("customer_manager_two_phone")
      public ContractProject.ContractProjectBuilder customerManagerTwoPhone(final String customerManagerTwoPhone) {
         this.customerManagerTwoPhone = customerManagerTwoPhone;
         return this;
      }

      public ContractProject.ContractProjectBuilder receivingManager(final String receivingManager) {
         this.receivingManager = receivingManager;
         return this;
      }

      public ContractProject.ContractProjectBuilder receivingManagerPhone(final String receivingManagerPhone) {
         this.receivingManagerPhone = receivingManagerPhone;
         return this;
      }

      public ContractProject.ContractProjectBuilder settleManager(final String settleManager) {
         this.settleManager = settleManager;
         return this;
      }

      public ContractProject.ContractProjectBuilder settleManagerPhone(final String settleManagerPhone) {
         this.settleManagerPhone = settleManagerPhone;
         return this;
      }

      public ContractProject.ContractProjectBuilder financeManager(final String financeManager) {
         this.financeManager = financeManager;
         return this;
      }

      public ContractProject.ContractProjectBuilder financeManagerPhone(final String financeManagerPhone) {
         this.financeManagerPhone = financeManagerPhone;
         return this;
      }

      public ContractProject.ContractProjectBuilder auditManager(final String auditManager) {
         this.auditManager = auditManager;
         return this;
      }

      public ContractProject.ContractProjectBuilder auditManagerPhone(final String auditManagerPhone) {
         this.auditManagerPhone = auditManagerPhone;
         return this;
      }

      public ContractProject.ContractProjectBuilder designManager(final String designManager) {
         this.designManager = designManager;
         return this;
      }

      public ContractProject.ContractProjectBuilder designManagerPhone(final String designManagerPhone) {
         this.designManagerPhone = designManagerPhone;
         return this;
      }

      @JsonProperty("mode")
      public ContractProject.ContractProjectBuilder mode(final Integer mode) {
         this.mode = mode;
         return this;
      }

      public ContractProject.ContractProjectBuilder boolRequiredWarehouse(final Boolean boolRequiredWarehouse) {
         this.boolRequiredWarehouse = boolRequiredWarehouse;
         return this;
      }

      @JsonProperty("mesStartDate")
      public ContractProject.ContractProjectBuilder mesStartDate(final LocalDateTime mesStartDate) {
         this.mesStartDate = mesStartDate;
         return this;
      }

      @JsonProperty("mesEndDate")
      public ContractProject.ContractProjectBuilder mesEndDate(final LocalDateTime mesEndDate) {
         this.mesEndDate = mesEndDate;
         return this;
      }

      @JsonProperty("happenedAmount")
      public ContractProject.ContractProjectBuilder happenedAmount(final BigDecimal happenedAmount) {
         this.happenedAmount = happenedAmount;
         return this;
      }

      @JsonProperty("outFinishStatus")
      public ContractProject.ContractProjectBuilder outFinishStatus(final Boolean outFinishStatus) {
         this.outFinishStatus = outFinishStatus;
         return this;
      }

      @JsonProperty("boolArrears")
      public ContractProject.ContractProjectBuilder boolArrears(final Boolean boolArrears) {
         this.boolArrears = boolArrears;
         return this;
      }

      public ContractProject.ContractProjectBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      public ContractProject.ContractProjectBuilder collectionSummary(final BigDecimal collectionSummary) {
         this.collectionSummary = collectionSummary;
         return this;
      }

      public ContractProject.ContractProjectBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ContractProject.ContractProjectBuilder installReportMethod(final Integer installReportMethod) {
         this.installReportMethod = installReportMethod;
         return this;
      }

      public ContractProject.ContractProjectBuilder orderSourceType(final Integer orderSourceType) {
         this.orderSourceType = orderSourceType;
         return this;
      }

      public ContractProject.ContractProjectBuilder customerRemark(final String customerRemark) {
         this.customerRemark = customerRemark;
         return this;
      }

      public ContractProject.ContractProjectBuilder isEffective(final Integer isEffective) {
         this.isEffective = isEffective;
         return this;
      }

      @JsonProperty("commercialClause")
      public ContractProject.ContractProjectBuilder commercialClause(final String commercialClause) {
         this.commercialClause = commercialClause;
         return this;
      }

      @JsonProperty("technologyClause")
      public ContractProject.ContractProjectBuilder technologyClause(final String technologyClause) {
         this.technologyClause = technologyClause;
         return this;
      }

      @JsonProperty("otherRemarks")
      public ContractProject.ContractProjectBuilder otherRemarks(final String otherRemarks) {
         this.otherRemarks = otherRemarks;
         return this;
      }

      public ContractProject.ContractProjectBuilder pId(final Long pId) {
         this.pId = pId;
         return this;
      }

      @JsonProperty("sendingMode")
      public ContractProject.ContractProjectBuilder sendingMode(final Long sendingMode) {
         this.sendingMode = sendingMode;
         return this;
      }

      @JsonProperty("infoSource")
      public ContractProject.ContractProjectBuilder infoSource(final Long infoSource) {
         this.infoSource = infoSource;
         return this;
      }

      @JsonProperty("isBuilding")
      public ContractProject.ContractProjectBuilder isBuilding(final Integer isBuilding) {
         this.isBuilding = isBuilding;
         return this;
      }

      public ContractProject.ContractProjectBuilder deptId(final Long deptId) {
         this.deptId = deptId;
         return this;
      }

      @JsonProperty("allDays")
      public ContractProject.ContractProjectBuilder allDays(final Integer allDays) {
         this.allDays = allDays;
         return this;
      }

      @JsonProperty("partyType")
      public ContractProject.ContractProjectBuilder partyType(final Long partyType) {
         this.partyType = partyType;
         return this;
      }

      @JsonProperty("structureArea")
      public ContractProject.ContractProjectBuilder structureArea(final BigDecimal structureArea) {
         this.structureArea = structureArea;
         return this;
      }

      @JsonProperty("projectAttribute")
      public ContractProject.ContractProjectBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      @JsonProperty("contractType")
      public ContractProject.ContractProjectBuilder contractType(final Integer contractType) {
         this.contractType = contractType;
         return this;
      }

      @JsonProperty("lumpSumSystemType")
      public ContractProject.ContractProjectBuilder lumpSumSystemType(final Integer lumpSumSystemType) {
         this.lumpSumSystemType = lumpSumSystemType;
         return this;
      }

      @JsonProperty("isArchive")
      public ContractProject.ContractProjectBuilder isArchive(final Integer isArchive) {
         this.isArchive = isArchive;
         return this;
      }

      @JsonProperty("unitType")
      public ContractProject.ContractProjectBuilder unitType(final Integer unitType) {
         this.unitType = unitType;
         return this;
      }

      @JsonProperty("isDeposit")
      public ContractProject.ContractProjectBuilder isDeposit(final Boolean isDeposit) {
         this.isDeposit = isDeposit;
         return this;
      }

      @JsonProperty("contract_sign_body_scale")
      public ContractProject.ContractProjectBuilder contractSignBodyScale(final BigDecimal contractSignBodyScale) {
         this.contractSignBodyScale = contractSignBodyScale;
         return this;
      }

      @JsonProperty("contract_sign_body_amount")
      public ContractProject.ContractProjectBuilder contractSignBodyAmount(final BigDecimal contractSignBodyAmount) {
         this.contractSignBodyAmount = contractSignBodyAmount;
         return this;
      }

      @JsonProperty("project_manager_scale")
      public ContractProject.ContractProjectBuilder projectManagerScale(final BigDecimal projectManagerScale) {
         this.projectManagerScale = projectManagerScale;
         return this;
      }

      @JsonProperty("project_manager_amount")
      public ContractProject.ContractProjectBuilder projectManagerAmount(final BigDecimal projectManagerAmount) {
         this.projectManagerAmount = projectManagerAmount;
         return this;
      }

      public ContractProject.ContractProjectBuilder contractSignBodyCollectBalance(final BigDecimal contractSignBodyCollectBalance) {
         this.contractSignBodyCollectBalance = contractSignBodyCollectBalance;
         return this;
      }

      public ContractProject.ContractProjectBuilder contractSignBodyInjectionBalance(final BigDecimal contractSignBodyInjectionBalance) {
         this.contractSignBodyInjectionBalance = contractSignBodyInjectionBalance;
         return this;
      }

      public ContractProject.ContractProjectBuilder projectManagerCollectBalance(final BigDecimal projectManagerCollectBalance) {
         this.projectManagerCollectBalance = projectManagerCollectBalance;
         return this;
      }

      public ContractProject.ContractProjectBuilder projectManagerInjectionBalance(final BigDecimal projectManagerInjectionBalance) {
         this.projectManagerInjectionBalance = projectManagerInjectionBalance;
         return this;
      }

      @JsonProperty("level")
      public ContractProject.ContractProjectBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public ContractProject.ContractProjectBuilder installDivideMethod(final Integer installDivideMethod) {
         this.installDivideMethod = installDivideMethod;
         return this;
      }

      @JsonProperty("lastUpdateTime")
      public ContractProject.ContractProjectBuilder lastUpdateTime(final LocalDateTime lastUpdateTime) {
         this.lastUpdateTime = lastUpdateTime;
         return this;
      }

      @JsonProperty("lastUpdateUserId")
      public ContractProject.ContractProjectBuilder lastUpdateUserId(final Long lastUpdateUserId) {
         this.lastUpdateUserId = lastUpdateUserId;
         return this;
      }

      public ContractProject build() {
         return new ContractProject(
            this.id,
            this.serialNumber,
            this.name,
            this.shortName,
            this.startDate,
            this.endDate,
            this.completeDate,
            this.address,
            this.projectManagerId,
            this.projectManagerName,
            this.projectManagerPhone,
            this.salesLeaderId,
            this.businessLeaderId,
            this.businessLeaderTwoId,
            this.attachments,
            this.archives,
            this.cityId,
            this.cityName,
            this.countryId,
            this.countryName,
            this.contractAmount,
            this.prepayments,
            this.managementFeeRate,
            this.managementCostId,
            this.marginAmount,
            this.collectionMarginAmount,
            this.marginType,
            this.marginTypeId,
            this.currencyType,
            this.qualityGuaranteeDeposit,
            this.settlementStatus,
            this.settlementAmount,
            this.settlementAttachmentId,
            this.provinceId,
            this.provinceName,
            this.regionId,
            this.regionName,
            this.contractSignBodyId,
            this.businessType,
            this.projectType,
            this.projectContent,
            this.structureStatus,
            this.structureTypeId,
            this.productCategory,
            this.transportMode,
            this.enclosureTransportMode,
            this.structureMeasureMode,
            this.enclosureMeasureMode,
            this.signingAddress,
            this.signingDate,
            this.signerId,
            this.signerName,
            this.signerPhone,
            this.isTax,
            this.invoiceType,
            this.taxRate,
            this.payType,
            this.payTypeDesc,
            this.technologyRemark,
            this.customerUnit,
            this.socialCode,
            this.customerUnitPhone,
            this.customerEmail,
            this.userId,
            this.status,
            this.customerProvinceId,
            this.customerProvinceName,
            this.customerCityId,
            this.customerCityName,
            this.customerRegionId,
            this.customerRegionName,
            this.customerCountryId,
            this.customerCountryName,
            this.customerAddress,
            this.customerBankUserName,
            this.customerBankCode,
            this.customerBankName,
            this.customerManagerOne,
            this.customerManagerOnePhone,
            this.customerManagerTwo,
            this.customerManagerTwoPhone,
            this.receivingManager,
            this.receivingManagerPhone,
            this.settleManager,
            this.settleManagerPhone,
            this.financeManager,
            this.financeManagerPhone,
            this.auditManager,
            this.auditManagerPhone,
            this.designManager,
            this.designManagerPhone,
            this.mode,
            this.boolRequiredWarehouse,
            this.mesStartDate,
            this.mesEndDate,
            this.happenedAmount,
            this.outFinishStatus,
            this.boolArrears,
            this.collectionAmount,
            this.collectionSummary,
            this.invoiceAmount,
            this.installReportMethod,
            this.orderSourceType,
            this.customerRemark,
            this.isEffective,
            this.commercialClause,
            this.technologyClause,
            this.otherRemarks,
            this.pId,
            this.sendingMode,
            this.infoSource,
            this.isBuilding,
            this.deptId,
            this.allDays,
            this.partyType,
            this.structureArea,
            this.projectAttribute,
            this.contractType,
            this.lumpSumSystemType,
            this.isArchive,
            this.unitType,
            this.isDeposit,
            this.contractSignBodyScale,
            this.contractSignBodyAmount,
            this.projectManagerScale,
            this.projectManagerAmount,
            this.contractSignBodyCollectBalance,
            this.contractSignBodyInjectionBalance,
            this.projectManagerCollectBalance,
            this.projectManagerInjectionBalance,
            this.level,
            this.installDivideMethod,
            this.lastUpdateTime,
            this.lastUpdateUserId
         );
      }

      @Override
      public String toString() {
         return "ContractProject.ContractProjectBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", completeDate="
            + this.completeDate
            + ", address="
            + this.address
            + ", projectManagerId="
            + this.projectManagerId
            + ", projectManagerName="
            + this.projectManagerName
            + ", projectManagerPhone="
            + this.projectManagerPhone
            + ", salesLeaderId="
            + this.salesLeaderId
            + ", businessLeaderId="
            + this.businessLeaderId
            + ", businessLeaderTwoId="
            + this.businessLeaderTwoId
            + ", attachments="
            + this.attachments
            + ", archives="
            + this.archives
            + ", cityId="
            + this.cityId
            + ", cityName="
            + this.cityName
            + ", countryId="
            + this.countryId
            + ", countryName="
            + this.countryName
            + ", contractAmount="
            + this.contractAmount
            + ", prepayments="
            + this.prepayments
            + ", managementFeeRate="
            + this.managementFeeRate
            + ", managementCostId="
            + this.managementCostId
            + ", marginAmount="
            + this.marginAmount
            + ", collectionMarginAmount="
            + this.collectionMarginAmount
            + ", marginType="
            + this.marginType
            + ", marginTypeId="
            + this.marginTypeId
            + ", currencyType="
            + this.currencyType
            + ", qualityGuaranteeDeposit="
            + this.qualityGuaranteeDeposit
            + ", settlementStatus="
            + this.settlementStatus
            + ", settlementAmount="
            + this.settlementAmount
            + ", settlementAttachmentId="
            + this.settlementAttachmentId
            + ", provinceId="
            + this.provinceId
            + ", provinceName="
            + this.provinceName
            + ", regionId="
            + this.regionId
            + ", regionName="
            + this.regionName
            + ", contractSignBodyId="
            + this.contractSignBodyId
            + ", businessType="
            + this.businessType
            + ", projectType="
            + this.projectType
            + ", projectContent="
            + this.projectContent
            + ", structureStatus="
            + this.structureStatus
            + ", structureTypeId="
            + this.structureTypeId
            + ", productCategory="
            + this.productCategory
            + ", transportMode="
            + this.transportMode
            + ", enclosureTransportMode="
            + this.enclosureTransportMode
            + ", structureMeasureMode="
            + this.structureMeasureMode
            + ", enclosureMeasureMode="
            + this.enclosureMeasureMode
            + ", signingAddress="
            + this.signingAddress
            + ", signingDate="
            + this.signingDate
            + ", signerId="
            + this.signerId
            + ", signerName="
            + this.signerName
            + ", signerPhone="
            + this.signerPhone
            + ", isTax="
            + this.isTax
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", payType="
            + this.payType
            + ", payTypeDesc="
            + this.payTypeDesc
            + ", technologyRemark="
            + this.technologyRemark
            + ", customerUnit="
            + this.customerUnit
            + ", socialCode="
            + this.socialCode
            + ", customerUnitPhone="
            + this.customerUnitPhone
            + ", customerEmail="
            + this.customerEmail
            + ", userId="
            + this.userId
            + ", status="
            + this.status
            + ", customerProvinceId="
            + this.customerProvinceId
            + ", customerProvinceName="
            + this.customerProvinceName
            + ", customerCityId="
            + this.customerCityId
            + ", customerCityName="
            + this.customerCityName
            + ", customerRegionId="
            + this.customerRegionId
            + ", customerRegionName="
            + this.customerRegionName
            + ", customerCountryId="
            + this.customerCountryId
            + ", customerCountryName="
            + this.customerCountryName
            + ", customerAddress="
            + this.customerAddress
            + ", customerBankUserName="
            + this.customerBankUserName
            + ", customerBankCode="
            + this.customerBankCode
            + ", customerBankName="
            + this.customerBankName
            + ", customerManagerOne="
            + this.customerManagerOne
            + ", customerManagerOnePhone="
            + this.customerManagerOnePhone
            + ", customerManagerTwo="
            + this.customerManagerTwo
            + ", customerManagerTwoPhone="
            + this.customerManagerTwoPhone
            + ", receivingManager="
            + this.receivingManager
            + ", receivingManagerPhone="
            + this.receivingManagerPhone
            + ", settleManager="
            + this.settleManager
            + ", settleManagerPhone="
            + this.settleManagerPhone
            + ", financeManager="
            + this.financeManager
            + ", financeManagerPhone="
            + this.financeManagerPhone
            + ", auditManager="
            + this.auditManager
            + ", auditManagerPhone="
            + this.auditManagerPhone
            + ", designManager="
            + this.designManager
            + ", designManagerPhone="
            + this.designManagerPhone
            + ", mode="
            + this.mode
            + ", boolRequiredWarehouse="
            + this.boolRequiredWarehouse
            + ", mesStartDate="
            + this.mesStartDate
            + ", mesEndDate="
            + this.mesEndDate
            + ", happenedAmount="
            + this.happenedAmount
            + ", outFinishStatus="
            + this.outFinishStatus
            + ", boolArrears="
            + this.boolArrears
            + ", collectionAmount="
            + this.collectionAmount
            + ", collectionSummary="
            + this.collectionSummary
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", installReportMethod="
            + this.installReportMethod
            + ", orderSourceType="
            + this.orderSourceType
            + ", customerRemark="
            + this.customerRemark
            + ", isEffective="
            + this.isEffective
            + ", commercialClause="
            + this.commercialClause
            + ", technologyClause="
            + this.technologyClause
            + ", otherRemarks="
            + this.otherRemarks
            + ", pId="
            + this.pId
            + ", sendingMode="
            + this.sendingMode
            + ", infoSource="
            + this.infoSource
            + ", isBuilding="
            + this.isBuilding
            + ", deptId="
            + this.deptId
            + ", allDays="
            + this.allDays
            + ", partyType="
            + this.partyType
            + ", structureArea="
            + this.structureArea
            + ", projectAttribute="
            + this.projectAttribute
            + ", contractType="
            + this.contractType
            + ", lumpSumSystemType="
            + this.lumpSumSystemType
            + ", isArchive="
            + this.isArchive
            + ", unitType="
            + this.unitType
            + ", isDeposit="
            + this.isDeposit
            + ", contractSignBodyScale="
            + this.contractSignBodyScale
            + ", contractSignBodyAmount="
            + this.contractSignBodyAmount
            + ", projectManagerScale="
            + this.projectManagerScale
            + ", projectManagerAmount="
            + this.projectManagerAmount
            + ", contractSignBodyCollectBalance="
            + this.contractSignBodyCollectBalance
            + ", contractSignBodyInjectionBalance="
            + this.contractSignBodyInjectionBalance
            + ", projectManagerCollectBalance="
            + this.projectManagerCollectBalance
            + ", projectManagerInjectionBalance="
            + this.projectManagerInjectionBalance
            + ", level="
            + this.level
            + ", installDivideMethod="
            + this.installDivideMethod
            + ", lastUpdateTime="
            + this.lastUpdateTime
            + ", lastUpdateUserId="
            + this.lastUpdateUserId
            + ")";
      }
   }
}
