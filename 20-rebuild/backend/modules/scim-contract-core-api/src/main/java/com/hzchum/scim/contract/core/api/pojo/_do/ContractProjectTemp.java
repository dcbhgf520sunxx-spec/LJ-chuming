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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractProjectTemp对象", description = "合同主体表")
@Entity
@TableName("contract_project_temp")
@Table(name = "contract_project_temp")
public class ContractProjectTemp extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "changeId", value = "变更表id")
   @JsonProperty("changeId")
   @JSONField(name = "changeId")
   @TableField("change_id")
   @Column(name = "change_id")
   private Long changeId;
   @ApiModelProperty(name = "serial_number", notes = "合同编号")
   @JsonProperty("serial_number")
   @JSONField(name = "serial_number")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "项目名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "shortName", value = "项目简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   @TableField("short_name")
   @Column(name = "short_name")
   private String shortName;
   @ApiModelProperty(name = "startDate", value = "约定开工日期")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   @TableField("start_date")
   @Column(name = "start_date")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "约定完工时期")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   @TableField("end_date")
   @Column(name = "end_date")
   private LocalDate endDate;
   @ApiModelProperty(name = "address", value = "项目详细地址")
   @JsonProperty("address")
   @JSONField(name = "address")
   @TableField("address")
   @Column(name = "address")
   private String address;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理")
   @JsonProperty("projectManagerId")
   @JSONField(name = "projectManagerId")
   @TableField("project_manager_id")
   @Column(name = "project_manager_id")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerName", value = "项目经理名称")
   @TableField(value = "project_manager_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "project_manager_name", columnDefinition = "varchar(16) comment '项目经理名称'")
   private String projectManagerName;
   @ApiModelProperty(name = "projectManagerPhone", value = "项目经理电话")
   @TableField(value = "project_manager_phone", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "project_manager_phone", columnDefinition = "varchar(16) comment '项目经理电话'")
   private String projectManagerPhone;
   @ApiModelProperty(name = "businessLeaderId", value = "业务负责人1")
   @JsonProperty("businessLeaderId")
   @JSONField(name = "businessLeaderId")
   @TableField("business_leader_id")
   @Column(name = "business_leader_id")
   private Long businessLeaderId;
   @ApiModelProperty(name = "businessLeaderTwoId", value = "业务负责人2")
   @JsonProperty("businessLeaderTwoId")
   @JSONField(name = "businessLeaderTwoId")
   @TableField("business_leader_two_id")
   @Column(name = "business_leader_two_id")
   private Long businessLeaderTwoId;
   @ApiModelProperty(name = "attachments", value = "项目的附件id集合(字符串 格式为 \"1,2,3\")")
   @JsonProperty("attachments")
   @JSONField(name = "attachments")
   @TableField("attachments")
   @Column(name = "attachments")
   private String attachments;
   @ApiModelProperty(name = "cityId")
   @JsonProperty("cityId")
   @JSONField(name = "cityId")
   @TableField("city_id")
   @Column(name = "city_id")
   private Long cityId;
   @ApiModelProperty(name = "cityName")
   @JsonProperty("cityName")
   @JSONField(name = "cityName")
   @TableField("city_name")
   @Column(name = "city_name")
   private String cityName;
   @ApiModelProperty(name = "countryId")
   @JsonProperty("countryId")
   @JSONField(name = "countryId")
   @TableField("country_id")
   @Column(name = "country_id")
   private Long countryId;
   @ApiModelProperty(name = "countryName")
   @JsonProperty("countryName")
   @JSONField(name = "countryName")
   @TableField("country_name")
   @Column(name = "country_name")
   private String countryName;
   @ApiModelProperty(name = "contractAmount", value = "合同金额（元）")
   @JsonProperty("contractAmount")
   @JSONField(name = "contractAmount")
   @TableField("contract_amount")
   @Column(name = "contract_amount")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "prepayments", notes = "预付款（元）")
   @JsonProperty("prepayments")
   @JSONField(name = "prepayments")
   @TableField("prepayments")
   @Column(name = "prepayments", columnDefinition = "decimal(32,4) default 0 comment '预付款(元)'", nullable = false)
   private BigDecimal prepayments;
   @ApiModelProperty(name = "management_fee_rate", notes = "管理费率（%）")
   @JsonProperty("management_fee_rate")
   @JSONField(name = "management_fee_rate")
   @TableField("management_fee_rate")
   @Column(name = "management_fee_rate", columnDefinition = "decimal(18,4) default 0 comment '管理费率(%)'", nullable = false)
   private BigDecimal managementFeeRate;
   @ApiModelProperty(name = "margin_amount", notes = "保证金（元）")
   @JsonProperty("margin_amount")
   @JSONField(name = "margin_amount")
   @TableField("margin_amount")
   @Column(name = "margin_amount", columnDefinition = "decimal(32,4) default 0 comment '保证金(元)'", nullable = false)
   private BigDecimal marginAmount;
   @ApiModelProperty(name = "marginType", value = "保证金类型 1.现金 2.. ")
   @JsonProperty("marginType")
   @JSONField(name = "marginType")
   @TableField("margin_type")
   @Column(name = "margin_type")
   private String marginType;
   @ApiModelProperty(name = "currencyType", value = "合同币种类型 (暂时先固定几种) RMB,EUR,USD,JPY")
   @JsonProperty("currencyType")
   @JSONField(name = "currencyType")
   @TableField("currency_type")
   @Column(name = "currency_type")
   private String currencyType;
   @ApiModelProperty(name = "qualityGuaranteeDeposit", notes = "质保金(%)")
   @TableField("quality_guarantee_deposit")
   @Column(name = "quality_guarantee_deposit", columnDefinition = "decimal(8,4) comment '质保金(%)'")
   private BigDecimal qualityGuaranteeDeposit;
   @ApiModelProperty(name = "provinceId")
   @JsonProperty("provinceId")
   @JSONField(name = "provinceId")
   @TableField("province_id")
   @Column(name = "province_id")
   private Long provinceId;
   @ApiModelProperty(name = "provinceName")
   @JsonProperty("provinceName")
   @JSONField(name = "provinceName")
   @TableField("province_name")
   @Column(name = "province_name")
   private String provinceName;
   @ApiModelProperty(name = "regionId", value = "区ID")
   @JsonProperty("regionId")
   @JSONField(name = "regionId")
   @TableField("region_id")
   @Column(name = "region_id")
   private Long regionId;
   @ApiModelProperty(name = "regionName", value = "区名称")
   @JsonProperty("regionName")
   @JSONField(name = "regionName")
   @TableField("region_name")
   @Column(name = "region_name")
   private String regionName;
   @ApiModelProperty(name = "contractSignBodyId", value = "合同签订主体id(公司id,单位...)")
   @JsonProperty("contractSignBodyId")
   @JSONField(name = "contractSignBodyId")
   @TableField("contract_sign_body_id")
   @Column(name = "contract_sign_body_id")
   private Long contractSignBodyId;
   @ApiModelProperty(name = "businessType", value = "业务类型 1.加工承揽  2.项目承包")
   @JsonProperty("businessType")
   @JSONField(name = "businessType")
   @TableField("business_type")
   @Column(name = "business_type")
   private Integer businessType;
   @ApiModelProperty(name = "projectType", value = "项目类型   1建筑钢结构 2桥梁钢结构  4立体停车库")
   @JsonProperty("projectType")
   @JSONField(name = "projectType")
   @TableField("project_type")
   @Column(name = "project_type")
   private Integer projectType;
   @ApiModelProperty(name = "projectContent", value = "项目内容")
   @JsonProperty("projectContent")
   @JSONField(name = "projectContent")
   @TableField("project_content")
   @Column(name = "project_content")
   private String projectContent;
   @ApiModelProperty(name = "productCategory", notes = "项目产品类型")
   @JsonProperty("productCategory")
   @JSONField(name = "productCategory")
   @TableField("product_category")
   @Column(name = "product_category")
   private Integer productCategory;
   @ApiModelProperty(name = "transportMode", notes = "运输方式 1运送到场 2客户自提")
   @JsonProperty("transportMode")
   @JSONField(name = "transportMode")
   @TableField("transport_mode")
   @Column(name = "transport_mode")
   private Integer transportMode;
   @ApiModelProperty(name = "enclosureTransportMode", notes = "运输方式 1运送到场 2客户自提")
   @JsonProperty("enclosureTransportMode")
   @JSONField(name = "enclosureTransportMode")
   @TableField("enclosure_transport_mode")
   @Column(name = "enclosure_transport_mode", columnDefinition = "int(11) comment '围护运输方式 1运送到场 2客户自提' ")
   private Integer enclosureTransportMode;
   @ApiModelProperty(name = "structureMeasureMode", notes = "结构计量方式  1理论计算 2磅记")
   @JsonProperty("structureMeasureMode")
   @JSONField(name = "structureMeasureMode")
   @TableField("structure_measure_mode")
   @Column(name = "structure_measure_mode")
   private Integer structureMeasureMode;
   @ApiModelProperty(name = "enclosureMeasureMode", notes = "围护计量方式 1 长度计量 2 面积计量")
   @JsonProperty("enclosureMeasureMode")
   @JSONField(name = "enclosureMeasureMode")
   @TableField("enclosure_measure_mode")
   @Column(name = "enclosure_measure_mode")
   private Integer enclosureMeasureMode;
   @ApiModelProperty(name = "signingAddress", value = "签约地址")
   @JsonProperty("signingAddress")
   @JSONField(name = "signingAddress")
   @TableField("signing_address")
   @Column(name = "signing_address")
   private String signingAddress;
   @ApiModelProperty(name = "signingDate", value = "签订日期")
   @JsonProperty("signingDate")
   @JSONField(name = "signingDate")
   @TableField("signing_date")
   @Column(name = "signing_date")
   private LocalDate signingDate;
   @ApiModelProperty(name = "signerId", value = "签约人id")
   @JsonProperty("signerId")
   @JSONField(name = "signerId")
   @TableField("signer_id")
   @Column(name = "signer_id")
   private Long signerId;
   @ApiModelProperty(name = "signerName", value = "签约人名字")
   @JsonProperty("signerName")
   @JSONField(name = "signerName")
   @TableField("signer_name")
   @Column(name = "signer_name")
   private String signerName;
   @ApiModelProperty(name = "signerPhone", value = "签约人电话")
   @TableField("signer_phone")
   @Column(name = "signer_phone")
   private String signerPhone;
   @ApiModelProperty(name = "isTax", value = "合同额是否含税 1是 0否")
   @JsonProperty("isTax")
   @JSONField(name = "isTax")
   @TableField("is_tax")
   @Column(name = "is_tax")
   private Integer isTax;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1 增值税专用发票  2普通发票 4收据")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type")
   private Integer invoiceType;
   @ApiModelProperty(name = "tax_rate", value = "发票税率")
   @JsonProperty("tax_rate")
   @JSONField(name = "tax_rate")
   @TableField("tax_rate")
   @Column(name = "tax_rate")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "payType", value = "支付方式 1.对公转账 2对私转账 4承兑汇票 8转账支票")
   @JsonProperty("payType")
   @JSONField(name = "payType")
   @TableField("pay_type")
   @Column(name = "pay_type")
   private Integer payType;
   @ApiModelProperty(name = "payTypeDesc", value = "支付方式描述")
   @JsonProperty("payTypeDesc")
   @JSONField(name = "payTypeDesc")
   @TableField("pay_type_desc")
   @Column(name = "pay_type_desc", columnDefinition = "text comment '支付方式描述'")
   private String payTypeDesc;
   @ApiModelProperty(name = "technologyRemark", value = "技术要求描述")
   @JsonProperty("technologyRemark")
   @JSONField(name = "technologyRemark")
   @TableField("technology_remark")
   @Column(name = "technology_remark", columnDefinition = "text comment '技术要求描述'")
   private String technologyRemark;
   @ApiModelProperty(name = "customerUnit", value = "客户单位名称")
   @JsonProperty("customerUnit")
   @JSONField(name = "customerUnit")
   @TableField("customer_unit")
   @Column(name = "customer_unit")
   private String customerUnit;
   @ApiModelProperty(name = "socialCode", value = "客户统一社会信用代码")
   @JsonProperty("socialCode")
   @JSONField(name = "socialCode")
   @TableField("social_code")
   @Column(name = "social_code")
   private String socialCode;
   @ApiModelProperty(name = "customerUnitPhone", value = "客户单位电话")
   @JsonProperty("customerUnitPhone")
   @JSONField(name = "customerUnitPhone")
   @TableField("customer_unit_phone")
   @Column(name = "customer_unit_phone")
   private String customerUnitPhone;
   @ApiModelProperty(name = "customerEmail", value = "客户邮箱")
   @JsonProperty("customerEmail")
   @JSONField(name = "customerEmail")
   @TableField("customer_email")
   @Column(name = "customer_email")
   private String customerEmail;
   @ApiModelProperty(name = "userId", value = "创建项目的用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id")
   private Long userId;
   @ApiModelProperty(name = "customerProvinceId", value = "客户省id")
   @JsonProperty("customerProvinceId")
   @JSONField(name = "customerProvinceId")
   @TableField("customer_province_id")
   @Column(name = "customer_province_id")
   private Long customerProvinceId;
   @ApiModelProperty(name = "customerProvinceName", value = "客户省名称")
   @JsonProperty("customerProvinceName")
   @JSONField(name = "customerProvinceName")
   @TableField("customer_province_name")
   @Column(name = "customer_province_name")
   private String customerProvinceName;
   @ApiModelProperty(name = "customerCityId", value = "客户单位城市id")
   @JsonProperty("customerCityId")
   @JSONField(name = "customerCityId")
   @TableField("customer_city_id")
   @Column(name = "customer_city_id")
   private Long customerCityId;
   @ApiModelProperty(name = "customerCityName", value = "客户单位名称")
   @JsonProperty("customerCityName")
   @JSONField(name = "customerCityName")
   @TableField("customer_city_name")
   @Column(name = "customer_city_name")
   private String customerCityName;
   @ApiModelProperty(name = "customerRegionId", value = "客户单位区ID")
   @JsonProperty("customerRegionId")
   @JSONField(name = "customerRegionId")
   @TableField("customer_region_id")
   @Column(name = "customer_region_id")
   private Long customerRegionId;
   @ApiModelProperty(name = "customerRegionName", value = "客户单位区名称")
   @JsonProperty("customerRegionName")
   @JSONField(name = "customerRegionName")
   @TableField("customer_region_name")
   @Column(name = "customer_region_name")
   private String customerRegionName;
   @ApiModelProperty(name = "customerCountryId", value = "客户单位国家id")
   @JsonProperty("customerCountryId")
   @JSONField(name = "customerCountryId")
   @TableField("customer_country_id")
   @Column(name = "customer_country_id")
   private Long customerCountryId;
   @ApiModelProperty(name = "customerCountryName", value = "客户单位国家名称")
   @JsonProperty("customerCountryName")
   @JSONField(name = "customerCountryName")
   @TableField("customer_country_name")
   @Column(name = "customer_country_name")
   private String customerCountryName;
   @ApiModelProperty(name = "customerAddress", value = "客户单位详细地址")
   @JsonProperty("customerAddress")
   @JSONField(name = "customerAddress")
   @TableField("customer_address")
   @Column(name = "customer_address")
   private String customerAddress;
   @ApiModelProperty(name = "customerBankUserName", value = "银行账户户名")
   @JsonProperty("customerBankUserName")
   @JSONField(name = "customerBankUserName")
   @TableField("customer_bank_user_name")
   @Column(name = "customer_bank_user_name")
   private String customerBankUserName;
   @ApiModelProperty(name = "customerBankCode", value = "银行账户账号")
   @JsonProperty("customerBankCode")
   @JSONField(name = "customerBankCode")
   @TableField("customer_bank_code")
   @Column(name = "customer_bank_code")
   private String customerBankCode;
   @ApiModelProperty(name = "customerBankName", value = "开户行   (中国工商银行...)")
   @JsonProperty("customerBankName")
   @JSONField(name = "customerBankName")
   @TableField("customer_bank_name")
   @Column(name = "customer_bank_name")
   private String customerBankName;
   @ApiModelProperty(name = "customerManagerOne", value = "客户负责人1姓名")
   @JsonProperty("customerManagerOne")
   @JSONField(name = "customerManagerOne")
   @TableField("customer_manager_one")
   @Column(name = "customer_manager_one")
   private String customerManagerOne;
   @ApiModelProperty(name = "customerManagerOnePhone", value = "客户负责人1电话")
   @JsonProperty("customerManagerOnePhone")
   @JSONField(name = "customerManagerOnePhone")
   @TableField("customer_manager_one_phone")
   @Column(name = "customer_manager_one_phone")
   private String customerManagerOnePhone;
   @ApiModelProperty(name = "customerManagerTwo", value = "客户负责人2姓名")
   @JsonProperty("customerManagerTwo")
   @JSONField(name = "customerManagerTwo")
   @TableField("customer_manager_two")
   @Column(name = "customer_manager_two")
   private String customerManagerTwo;
   @ApiModelProperty(name = "customerManagerTwoPhone", value = "客户负责人2电话")
   @JsonProperty("customerManagerTwoPhone")
   @JSONField(name = "customerManagerTwoPhone")
   @TableField("customer_manager_two_phone")
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
   @TableField("settle_manager")
   @Column(name = "settle_manager", columnDefinition = "varchar(32) comment '结算负责人'")
   private String settleManager;
   @ApiModelProperty(name = "settleManagerPhone", notes = "结算负责人电话")
   @TableField("settle_manager_phone")
   @Column(name = "settle_manager_phone", columnDefinition = "varchar(32) comment '结算负责人电话'")
   private String settleManagerPhone;
   @ApiModelProperty(name = "financeManager", notes = "财务负责人")
   @TableField("finance_manager")
   @Column(name = "finance_manager", columnDefinition = "varchar(32) comment '财务负责人'")
   private String financeManager;
   @ApiModelProperty(name = "financeManagerPhone", notes = "财务负责人电话")
   @TableField("finance_manager_phone")
   @Column(name = "finance_manager_phone", columnDefinition = "varchar(32) comment '财务负责人电话'")
   private String financeManagerPhone;
   @ApiModelProperty(name = "auditManager", notes = "审核负责人")
   @TableField("audit_manager")
   @Column(name = "audit_manager", columnDefinition = "varchar(32) comment '审核负责人'")
   private String auditManager;
   @ApiModelProperty(name = "auditManagerPhone", notes = "审核负责人电话")
   @TableField("audit_manager_phone")
   @Column(name = "audit_manager_phone", columnDefinition = "varchar(32) comment '审核负责人电话'")
   private String auditManagerPhone;
   @ApiModelProperty(name = "designManager", notes = "设计负责人")
   @TableField("design_manager")
   @Column(name = "design_manager", columnDefinition = "varchar(32) comment '设计负责人'")
   private String designManager;
   @ApiModelProperty(name = "designManagerPhone", notes = "设计负责人电话")
   @TableField("design_manager_phone")
   @Column(name = "design_manager_phone", columnDefinition = "varchar(32) comment '设计负责人电话'")
   private String designManagerPhone;
   @ApiModelProperty(name = "relationUserIds", value = "项目关联用户id字符串")
   @JsonProperty("relationUserIds")
   @JSONField(name = "relationUserIds")
   @TableField("relation_user_ids")
   @Column(name = "relation_user_ids", columnDefinition = "text comment '项目关联用户id字符串'")
   private String relationUserIds;
   @ApiModelProperty(name = "orderSourceType", value = "项目订单来源类型 1内部 2外部 枚举:OrderSourceTypeEnum")
   @TableField("order_source_type")
   @Column(name = "order_source_type", columnDefinition = "int(11) comment '项目订单来源类型 1内部 2外部'")
   private Integer orderSourceType;
   @Deprecated
   @ApiModelProperty(name = "structureStatus", value = "结构类型")
   @JsonProperty("structureStatus")
   @JSONField(name = "structureStatus")
   @TableField("structure_status")
   @Column(name = "structure_status", columnDefinition = "int(11) comment '结构类型'")
   private Integer structureStatus;
   @ApiModelProperty(name = "structureTypeId", value = "结构类型id")
   @TableField("structure_type_id")
   @Column(name = "structure_type_id", columnDefinition = "bigint(20) comment '结构类型id'")
   private Long structureTypeId;
   @ApiModelProperty(name = "customerRemark", notes = "客户信息备注")
   @TableField("customer_remark")
   @Column(name = "customer_remark", columnDefinition = "text comment '客户信息备注'")
   private String customerRemark;

   public static ContractProjectTemp.ContractProjectTempBuilder builder() {
      return new ContractProjectTemp.ContractProjectTempBuilder();
   }

   public ContractProjectTemp() {
   }

   public ContractProjectTemp(
      final Long id,
      final Long projectId,
      final Long changeId,
      final String serialNumber,
      final String name,
      final String shortName,
      final LocalDate startDate,
      final LocalDate endDate,
      final String address,
      final Long projectManagerId,
      final String projectManagerName,
      final String projectManagerPhone,
      final Long businessLeaderId,
      final Long businessLeaderTwoId,
      final String attachments,
      final Long cityId,
      final String cityName,
      final Long countryId,
      final String countryName,
      final BigDecimal contractAmount,
      final BigDecimal prepayments,
      final BigDecimal managementFeeRate,
      final BigDecimal marginAmount,
      final String marginType,
      final String currencyType,
      final BigDecimal qualityGuaranteeDeposit,
      final Long provinceId,
      final String provinceName,
      final Long regionId,
      final String regionName,
      final Long contractSignBodyId,
      final Integer businessType,
      final Integer projectType,
      final String projectContent,
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
      final String relationUserIds,
      final Integer orderSourceType,
      final Integer structureStatus,
      final Long structureTypeId,
      final String customerRemark
   ) {
      this.id = id;
      this.projectId = projectId;
      this.changeId = changeId;
      this.serialNumber = serialNumber;
      this.name = name;
      this.shortName = shortName;
      this.startDate = startDate;
      this.endDate = endDate;
      this.address = address;
      this.projectManagerId = projectManagerId;
      this.projectManagerName = projectManagerName;
      this.projectManagerPhone = projectManagerPhone;
      this.businessLeaderId = businessLeaderId;
      this.businessLeaderTwoId = businessLeaderTwoId;
      this.attachments = attachments;
      this.cityId = cityId;
      this.cityName = cityName;
      this.countryId = countryId;
      this.countryName = countryName;
      this.contractAmount = contractAmount;
      this.prepayments = prepayments;
      this.managementFeeRate = managementFeeRate;
      this.marginAmount = marginAmount;
      this.marginType = marginType;
      this.currencyType = currencyType;
      this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.contractSignBodyId = contractSignBodyId;
      this.businessType = businessType;
      this.projectType = projectType;
      this.projectContent = projectContent;
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
      this.relationUserIds = relationUserIds;
      this.orderSourceType = orderSourceType;
      this.structureStatus = structureStatus;
      this.structureTypeId = structureTypeId;
      this.customerRemark = customerRemark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getChangeId() {
      return this.changeId;
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

   public Long getBusinessLeaderId() {
      return this.businessLeaderId;
   }

   public Long getBusinessLeaderTwoId() {
      return this.businessLeaderTwoId;
   }

   public String getAttachments() {
      return this.attachments;
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

   public BigDecimal getMarginAmount() {
      return this.marginAmount;
   }

   public String getMarginType() {
      return this.marginType;
   }

   public String getCurrencyType() {
      return this.currencyType;
   }

   public BigDecimal getQualityGuaranteeDeposit() {
      return this.qualityGuaranteeDeposit;
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

   public String getRelationUserIds() {
      return this.relationUserIds;
   }

   public Integer getOrderSourceType() {
      return this.orderSourceType;
   }

   @Deprecated
   public Integer getStructureStatus() {
      return this.structureStatus;
   }

   public Long getStructureTypeId() {
      return this.structureTypeId;
   }

   public String getCustomerRemark() {
      return this.customerRemark;
   }

   @JsonProperty("id")
   public ContractProjectTemp setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ContractProjectTemp setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("changeId")
   public ContractProjectTemp setChangeId(final Long changeId) {
      this.changeId = changeId;
      return this;
   }

   @JsonProperty("serial_number")
   public ContractProjectTemp setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("name")
   public ContractProjectTemp setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("shortName")
   public ContractProjectTemp setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("startDate")
   public ContractProjectTemp setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("endDate")
   public ContractProjectTemp setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
      return this;
   }

   @JsonProperty("address")
   public ContractProjectTemp setAddress(final String address) {
      this.address = address;
      return this;
   }

   @JsonProperty("projectManagerId")
   public ContractProjectTemp setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public ContractProjectTemp setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
      return this;
   }

   public ContractProjectTemp setProjectManagerPhone(final String projectManagerPhone) {
      this.projectManagerPhone = projectManagerPhone;
      return this;
   }

   @JsonProperty("businessLeaderId")
   public ContractProjectTemp setBusinessLeaderId(final Long businessLeaderId) {
      this.businessLeaderId = businessLeaderId;
      return this;
   }

   @JsonProperty("businessLeaderTwoId")
   public ContractProjectTemp setBusinessLeaderTwoId(final Long businessLeaderTwoId) {
      this.businessLeaderTwoId = businessLeaderTwoId;
      return this;
   }

   @JsonProperty("attachments")
   public ContractProjectTemp setAttachments(final String attachments) {
      this.attachments = attachments;
      return this;
   }

   @JsonProperty("cityId")
   public ContractProjectTemp setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   @JsonProperty("cityName")
   public ContractProjectTemp setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   @JsonProperty("countryId")
   public ContractProjectTemp setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   @JsonProperty("countryName")
   public ContractProjectTemp setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   @JsonProperty("contractAmount")
   public ContractProjectTemp setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   @JsonProperty("prepayments")
   public ContractProjectTemp setPrepayments(final BigDecimal prepayments) {
      this.prepayments = prepayments;
      return this;
   }

   @JsonProperty("management_fee_rate")
   public ContractProjectTemp setManagementFeeRate(final BigDecimal managementFeeRate) {
      this.managementFeeRate = managementFeeRate;
      return this;
   }

   @JsonProperty("margin_amount")
   public ContractProjectTemp setMarginAmount(final BigDecimal marginAmount) {
      this.marginAmount = marginAmount;
      return this;
   }

   @JsonProperty("marginType")
   public ContractProjectTemp setMarginType(final String marginType) {
      this.marginType = marginType;
      return this;
   }

   @JsonProperty("currencyType")
   public ContractProjectTemp setCurrencyType(final String currencyType) {
      this.currencyType = currencyType;
      return this;
   }

   public ContractProjectTemp setQualityGuaranteeDeposit(final BigDecimal qualityGuaranteeDeposit) {
      this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
      return this;
   }

   @JsonProperty("provinceId")
   public ContractProjectTemp setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   @JsonProperty("provinceName")
   public ContractProjectTemp setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   @JsonProperty("regionId")
   public ContractProjectTemp setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   @JsonProperty("regionName")
   public ContractProjectTemp setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   @JsonProperty("contractSignBodyId")
   public ContractProjectTemp setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
      return this;
   }

   @JsonProperty("businessType")
   public ContractProjectTemp setBusinessType(final Integer businessType) {
      this.businessType = businessType;
      return this;
   }

   @JsonProperty("projectType")
   public ContractProjectTemp setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   @JsonProperty("projectContent")
   public ContractProjectTemp setProjectContent(final String projectContent) {
      this.projectContent = projectContent;
      return this;
   }

   @JsonProperty("productCategory")
   public ContractProjectTemp setProductCategory(final Integer productCategory) {
      this.productCategory = productCategory;
      return this;
   }

   @JsonProperty("transportMode")
   public ContractProjectTemp setTransportMode(final Integer transportMode) {
      this.transportMode = transportMode;
      return this;
   }

   @JsonProperty("enclosureTransportMode")
   public ContractProjectTemp setEnclosureTransportMode(final Integer enclosureTransportMode) {
      this.enclosureTransportMode = enclosureTransportMode;
      return this;
   }

   @JsonProperty("structureMeasureMode")
   public ContractProjectTemp setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
      return this;
   }

   @JsonProperty("enclosureMeasureMode")
   public ContractProjectTemp setEnclosureMeasureMode(final Integer enclosureMeasureMode) {
      this.enclosureMeasureMode = enclosureMeasureMode;
      return this;
   }

   @JsonProperty("signingAddress")
   public ContractProjectTemp setSigningAddress(final String signingAddress) {
      this.signingAddress = signingAddress;
      return this;
   }

   @JsonProperty("signingDate")
   public ContractProjectTemp setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
      return this;
   }

   @JsonProperty("signerId")
   public ContractProjectTemp setSignerId(final Long signerId) {
      this.signerId = signerId;
      return this;
   }

   @JsonProperty("signerName")
   public ContractProjectTemp setSignerName(final String signerName) {
      this.signerName = signerName;
      return this;
   }

   public ContractProjectTemp setSignerPhone(final String signerPhone) {
      this.signerPhone = signerPhone;
      return this;
   }

   @JsonProperty("isTax")
   public ContractProjectTemp setIsTax(final Integer isTax) {
      this.isTax = isTax;
      return this;
   }

   @JsonProperty("invoiceType")
   public ContractProjectTemp setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("tax_rate")
   public ContractProjectTemp setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("payType")
   public ContractProjectTemp setPayType(final Integer payType) {
      this.payType = payType;
      return this;
   }

   @JsonProperty("payTypeDesc")
   public ContractProjectTemp setPayTypeDesc(final String payTypeDesc) {
      this.payTypeDesc = payTypeDesc;
      return this;
   }

   @JsonProperty("technologyRemark")
   public ContractProjectTemp setTechnologyRemark(final String technologyRemark) {
      this.technologyRemark = technologyRemark;
      return this;
   }

   @JsonProperty("customerUnit")
   public ContractProjectTemp setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
      return this;
   }

   @JsonProperty("socialCode")
   public ContractProjectTemp setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
      return this;
   }

   @JsonProperty("customerUnitPhone")
   public ContractProjectTemp setCustomerUnitPhone(final String customerUnitPhone) {
      this.customerUnitPhone = customerUnitPhone;
      return this;
   }

   @JsonProperty("customerEmail")
   public ContractProjectTemp setCustomerEmail(final String customerEmail) {
      this.customerEmail = customerEmail;
      return this;
   }

   @JsonProperty("userId")
   public ContractProjectTemp setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("customerProvinceId")
   public ContractProjectTemp setCustomerProvinceId(final Long customerProvinceId) {
      this.customerProvinceId = customerProvinceId;
      return this;
   }

   @JsonProperty("customerProvinceName")
   public ContractProjectTemp setCustomerProvinceName(final String customerProvinceName) {
      this.customerProvinceName = customerProvinceName;
      return this;
   }

   @JsonProperty("customerCityId")
   public ContractProjectTemp setCustomerCityId(final Long customerCityId) {
      this.customerCityId = customerCityId;
      return this;
   }

   @JsonProperty("customerCityName")
   public ContractProjectTemp setCustomerCityName(final String customerCityName) {
      this.customerCityName = customerCityName;
      return this;
   }

   @JsonProperty("customerRegionId")
   public ContractProjectTemp setCustomerRegionId(final Long customerRegionId) {
      this.customerRegionId = customerRegionId;
      return this;
   }

   @JsonProperty("customerRegionName")
   public ContractProjectTemp setCustomerRegionName(final String customerRegionName) {
      this.customerRegionName = customerRegionName;
      return this;
   }

   @JsonProperty("customerCountryId")
   public ContractProjectTemp setCustomerCountryId(final Long customerCountryId) {
      this.customerCountryId = customerCountryId;
      return this;
   }

   @JsonProperty("customerCountryName")
   public ContractProjectTemp setCustomerCountryName(final String customerCountryName) {
      this.customerCountryName = customerCountryName;
      return this;
   }

   @JsonProperty("customerAddress")
   public ContractProjectTemp setCustomerAddress(final String customerAddress) {
      this.customerAddress = customerAddress;
      return this;
   }

   @JsonProperty("customerBankUserName")
   public ContractProjectTemp setCustomerBankUserName(final String customerBankUserName) {
      this.customerBankUserName = customerBankUserName;
      return this;
   }

   @JsonProperty("customerBankCode")
   public ContractProjectTemp setCustomerBankCode(final String customerBankCode) {
      this.customerBankCode = customerBankCode;
      return this;
   }

   @JsonProperty("customerBankName")
   public ContractProjectTemp setCustomerBankName(final String customerBankName) {
      this.customerBankName = customerBankName;
      return this;
   }

   @JsonProperty("customerManagerOne")
   public ContractProjectTemp setCustomerManagerOne(final String customerManagerOne) {
      this.customerManagerOne = customerManagerOne;
      return this;
   }

   @JsonProperty("customerManagerOnePhone")
   public ContractProjectTemp setCustomerManagerOnePhone(final String customerManagerOnePhone) {
      this.customerManagerOnePhone = customerManagerOnePhone;
      return this;
   }

   @JsonProperty("customerManagerTwo")
   public ContractProjectTemp setCustomerManagerTwo(final String customerManagerTwo) {
      this.customerManagerTwo = customerManagerTwo;
      return this;
   }

   @JsonProperty("customerManagerTwoPhone")
   public ContractProjectTemp setCustomerManagerTwoPhone(final String customerManagerTwoPhone) {
      this.customerManagerTwoPhone = customerManagerTwoPhone;
      return this;
   }

   public ContractProjectTemp setReceivingManager(final String receivingManager) {
      this.receivingManager = receivingManager;
      return this;
   }

   public ContractProjectTemp setReceivingManagerPhone(final String receivingManagerPhone) {
      this.receivingManagerPhone = receivingManagerPhone;
      return this;
   }

   public ContractProjectTemp setSettleManager(final String settleManager) {
      this.settleManager = settleManager;
      return this;
   }

   public ContractProjectTemp setSettleManagerPhone(final String settleManagerPhone) {
      this.settleManagerPhone = settleManagerPhone;
      return this;
   }

   public ContractProjectTemp setFinanceManager(final String financeManager) {
      this.financeManager = financeManager;
      return this;
   }

   public ContractProjectTemp setFinanceManagerPhone(final String financeManagerPhone) {
      this.financeManagerPhone = financeManagerPhone;
      return this;
   }

   public ContractProjectTemp setAuditManager(final String auditManager) {
      this.auditManager = auditManager;
      return this;
   }

   public ContractProjectTemp setAuditManagerPhone(final String auditManagerPhone) {
      this.auditManagerPhone = auditManagerPhone;
      return this;
   }

   public ContractProjectTemp setDesignManager(final String designManager) {
      this.designManager = designManager;
      return this;
   }

   public ContractProjectTemp setDesignManagerPhone(final String designManagerPhone) {
      this.designManagerPhone = designManagerPhone;
      return this;
   }

   @JsonProperty("relationUserIds")
   public ContractProjectTemp setRelationUserIds(final String relationUserIds) {
      this.relationUserIds = relationUserIds;
      return this;
   }

   public ContractProjectTemp setOrderSourceType(final Integer orderSourceType) {
      this.orderSourceType = orderSourceType;
      return this;
   }

   @Deprecated
   @JsonProperty("structureStatus")
   public ContractProjectTemp setStructureStatus(final Integer structureStatus) {
      this.structureStatus = structureStatus;
      return this;
   }

   public ContractProjectTemp setStructureTypeId(final Long structureTypeId) {
      this.structureTypeId = structureTypeId;
      return this;
   }

   public ContractProjectTemp setCustomerRemark(final String customerRemark) {
      this.customerRemark = customerRemark;
      return this;
   }

   @Override
   public String toString() {
      return "ContractProjectTemp(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", changeId="
         + this.getChangeId()
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
         + ", address="
         + this.getAddress()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", projectManagerPhone="
         + this.getProjectManagerPhone()
         + ", businessLeaderId="
         + this.getBusinessLeaderId()
         + ", businessLeaderTwoId="
         + this.getBusinessLeaderTwoId()
         + ", attachments="
         + this.getAttachments()
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
         + ", marginAmount="
         + this.getMarginAmount()
         + ", marginType="
         + this.getMarginType()
         + ", currencyType="
         + this.getCurrencyType()
         + ", qualityGuaranteeDeposit="
         + this.getQualityGuaranteeDeposit()
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
         + ", relationUserIds="
         + this.getRelationUserIds()
         + ", orderSourceType="
         + this.getOrderSourceType()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", structureTypeId="
         + this.getStructureTypeId()
         + ", customerRemark="
         + this.getCustomerRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectTemp)) {
         return false;
      }

      ContractProjectTemp other = (ContractProjectTemp)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$changeId = this.getChangeId();
            Object other$changeId = other.getChangeId();
            if (this$changeId == null ? other$changeId == null : this$changeId.equals(other$changeId)) {
               Object this$projectManagerId = this.getProjectManagerId();
               Object other$projectManagerId = other.getProjectManagerId();
               if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
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
                                             Object this$productCategory = this.getProductCategory();
                                             Object other$productCategory = other.getProductCategory();
                                             if (this$productCategory == null
                                                ? other$productCategory == null
                                                : this$productCategory.equals(other$productCategory)) {
                                                Object this$transportMode = this.getTransportMode();
                                                Object other$transportMode = other.getTransportMode();
                                                if (this$transportMode == null ? other$transportMode == null : this$transportMode.equals(other$transportMode)) {
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
                                                            if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
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
                                                                     if (this$payType == null ? other$payType == null : this$payType.equals(other$payType)) {
                                                                        Object this$userId = this.getUserId();
                                                                        Object other$userId = other.getUserId();
                                                                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
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
                                                                                    : this$customerRegionId.equals(other$customerRegionId)) {
                                                                                    Object this$customerCountryId = this.getCustomerCountryId();
                                                                                    Object other$customerCountryId = other.getCustomerCountryId();
                                                                                    if (this$customerCountryId == null
                                                                                       ? other$customerCountryId == null
                                                                                       : this$customerCountryId.equals(other$customerCountryId)) {
                                                                                       Object this$orderSourceType = this.getOrderSourceType();
                                                                                       Object other$orderSourceType = other.getOrderSourceType();
                                                                                       if (this$orderSourceType == null
                                                                                          ? other$orderSourceType == null
                                                                                          : this$orderSourceType.equals(other$orderSourceType)) {
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
                                                                                                Object this$serialNumber = this.getSerialNumber();
                                                                                                Object other$serialNumber = other.getSerialNumber();
                                                                                                if (this$serialNumber == null
                                                                                                   ? other$serialNumber == null
                                                                                                   : this$serialNumber.equals(other$serialNumber)) {
                                                                                                   Object this$name = this.getName();
                                                                                                   Object other$name = other.getName();
                                                                                                   if (this$name == null
                                                                                                      ? other$name == null
                                                                                                      : this$name.equals(other$name)) {
                                                                                                      Object this$shortName = this.getShortName();
                                                                                                      Object other$shortName = other.getShortName();
                                                                                                      if (this$shortName == null
                                                                                                         ? other$shortName == null
                                                                                                         : this$shortName.equals(other$shortName)) {
                                                                                                         Object this$startDate = this.getStartDate();
                                                                                                         Object other$startDate = other.getStartDate();
                                                                                                         if (this$startDate == null
                                                                                                            ? other$startDate == null
                                                                                                            : this$startDate.equals(other$startDate)) {
                                                                                                            Object this$endDate = this.getEndDate();
                                                                                                            Object other$endDate = other.getEndDate();
                                                                                                            if (this$endDate == null
                                                                                                               ? other$endDate == null
                                                                                                               : this$endDate.equals(other$endDate)) {
                                                                                                               Object this$address = this.getAddress();
                                                                                                               Object other$address = other.getAddress();
                                                                                                               if (this$address == null
                                                                                                                  ? other$address == null
                                                                                                                  : this$address.equals(other$address)) {
                                                                                                                  Object this$projectManagerName = this.getProjectManagerName();
                                                                                                                  Object other$projectManagerName = other.getProjectManagerName();
                                                                                                                  if (this$projectManagerName == null
                                                                                                                     ? other$projectManagerName == null
                                                                                                                     : this$projectManagerName.equals(
                                                                                                                        other$projectManagerName
                                                                                                                     )) {
                                                                                                                     Object this$projectManagerPhone = this.getProjectManagerPhone();
                                                                                                                     Object other$projectManagerPhone = other.getProjectManagerPhone();
                                                                                                                     if (this$projectManagerPhone == null
                                                                                                                        ? other$projectManagerPhone == null
                                                                                                                        : this$projectManagerPhone.equals(
                                                                                                                           other$projectManagerPhone
                                                                                                                        )) {
                                                                                                                        Object this$attachments = this.getAttachments();
                                                                                                                        Object other$attachments = other.getAttachments();
                                                                                                                        if (this$attachments == null
                                                                                                                           ? other$attachments == null
                                                                                                                           : this$attachments.equals(
                                                                                                                              other$attachments
                                                                                                                           )) {
                                                                                                                           Object this$cityName = this.getCityName();
                                                                                                                           Object other$cityName = other.getCityName();
                                                                                                                           if (this$cityName == null
                                                                                                                              ? other$cityName == null
                                                                                                                              : this$cityName.equals(
                                                                                                                                 other$cityName
                                                                                                                              )) {
                                                                                                                              Object this$countryName = this.getCountryName();
                                                                                                                              Object other$countryName = other.getCountryName();
                                                                                                                              if (this$countryName == null
                                                                                                                                 ? other$countryName == null
                                                                                                                                 : this$countryName.equals(
                                                                                                                                    other$countryName
                                                                                                                                 )) {
                                                                                                                                 Object this$contractAmount = this.getContractAmount();
                                                                                                                                 Object other$contractAmount = other.getContractAmount();
                                                                                                                                 if (this$contractAmount
                                                                                                                                       == null
                                                                                                                                    ? other$contractAmount
                                                                                                                                       == null
                                                                                                                                    : this$contractAmount.equals(
                                                                                                                                       other$contractAmount
                                                                                                                                    )) {
                                                                                                                                    Object this$prepayments = this.getPrepayments();
                                                                                                                                    Object other$prepayments = other.getPrepayments();
                                                                                                                                    if (this$prepayments
                                                                                                                                          == null
                                                                                                                                       ? other$prepayments
                                                                                                                                          == null
                                                                                                                                       : this$prepayments.equals(
                                                                                                                                          other$prepayments
                                                                                                                                       )) {
                                                                                                                                       Object this$managementFeeRate = this.getManagementFeeRate();
                                                                                                                                       Object other$managementFeeRate = other.getManagementFeeRate();
                                                                                                                                       if (this$managementFeeRate
                                                                                                                                             == null
                                                                                                                                          ? other$managementFeeRate
                                                                                                                                             == null
                                                                                                                                          : this$managementFeeRate.equals(
                                                                                                                                             other$managementFeeRate
                                                                                                                                          )) {
                                                                                                                                          Object this$marginAmount = this.getMarginAmount();
                                                                                                                                          Object other$marginAmount = other.getMarginAmount();
                                                                                                                                          if (this$marginAmount
                                                                                                                                                == null
                                                                                                                                             ? other$marginAmount
                                                                                                                                                == null
                                                                                                                                             : this$marginAmount.equals(
                                                                                                                                                other$marginAmount
                                                                                                                                             )) {
                                                                                                                                             Object this$marginType = this.getMarginType();
                                                                                                                                             Object other$marginType = other.getMarginType();
                                                                                                                                             if (this$marginType
                                                                                                                                                   == null
                                                                                                                                                ? other$marginType
                                                                                                                                                   == null
                                                                                                                                                : this$marginType.equals(
                                                                                                                                                   other$marginType
                                                                                                                                                )) {
                                                                                                                                                Object this$currencyType = this.getCurrencyType();
                                                                                                                                                Object other$currencyType = other.getCurrencyType();
                                                                                                                                                if (this$currencyType
                                                                                                                                                      == null
                                                                                                                                                   ? other$currencyType
                                                                                                                                                      == null
                                                                                                                                                   : this$currencyType.equals(
                                                                                                                                                      other$currencyType
                                                                                                                                                   )) {
                                                                                                                                                   Object this$qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
                                                                                                                                                   Object other$qualityGuaranteeDeposit = other.getQualityGuaranteeDeposit();
                                                                                                                                                   if (this$qualityGuaranteeDeposit
                                                                                                                                                         == null
                                                                                                                                                      ? other$qualityGuaranteeDeposit
                                                                                                                                                         == null
                                                                                                                                                      : this$qualityGuaranteeDeposit.equals(
                                                                                                                                                         other$qualityGuaranteeDeposit
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
                                                                                                                                                         Object this$regionName = this.getRegionName();
                                                                                                                                                         Object other$regionName = other.getRegionName();
                                                                                                                                                         if (this$regionName
                                                                                                                                                               == null
                                                                                                                                                            ? other$regionName
                                                                                                                                                               == null
                                                                                                                                                            : this$regionName.equals(
                                                                                                                                                               other$regionName
                                                                                                                                                            )) {
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
                                                                                                                                                                                                                                                                  Object this$relationUserIds = this.getRelationUserIds();
                                                                                                                                                                                                                                                                  Object other$relationUserIds = other.getRelationUserIds();
                                                                                                                                                                                                                                                                  if (this$relationUserIds
                                                                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                                                                     ? other$relationUserIds
                                                                                                                                                                                                                                                                        == null
                                                                                                                                                                                                                                                                     : this$relationUserIds.equals(
                                                                                                                                                                                                                                                                        other$relationUserIds
                                                                                                                                                                                                                                                                     )
                                                                                                                                                                                                                                                                     )
                                                                                                                                                                                                                                                                   {
                                                                                                                                                                                                                                                                     Object this$customerRemark = this.getCustomerRemark();
                                                                                                                                                                                                                                                                     Object other$customerRemark = other.getCustomerRemark();
                                                                                                                                                                                                                                                                     return this$customerRemark
                                                                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                                                                        ? other$customerRemark
                                                                                                                                                                                                                                                                           == null
                                                                                                                                                                                                                                                                        : this$customerRemark.equals(
                                                                                                                                                                                                                                                                           other$customerRemark
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractProjectTemp;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $changeId = this.getChangeId();
      result = result * 59 + ($changeId == null ? 43 : $changeId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $businessLeaderId = this.getBusinessLeaderId();
      result = result * 59 + ($businessLeaderId == null ? 43 : $businessLeaderId.hashCode());
      Object $businessLeaderTwoId = this.getBusinessLeaderTwoId();
      result = result * 59 + ($businessLeaderTwoId == null ? 43 : $businessLeaderTwoId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
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
      Object $customerProvinceId = this.getCustomerProvinceId();
      result = result * 59 + ($customerProvinceId == null ? 43 : $customerProvinceId.hashCode());
      Object $customerCityId = this.getCustomerCityId();
      result = result * 59 + ($customerCityId == null ? 43 : $customerCityId.hashCode());
      Object $customerRegionId = this.getCustomerRegionId();
      result = result * 59 + ($customerRegionId == null ? 43 : $customerRegionId.hashCode());
      Object $customerCountryId = this.getCustomerCountryId();
      result = result * 59 + ($customerCountryId == null ? 43 : $customerCountryId.hashCode());
      Object $orderSourceType = this.getOrderSourceType();
      result = result * 59 + ($orderSourceType == null ? 43 : $orderSourceType.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $structureTypeId = this.getStructureTypeId();
      result = result * 59 + ($structureTypeId == null ? 43 : $structureTypeId.hashCode());
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
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $projectManagerPhone = this.getProjectManagerPhone();
      result = result * 59 + ($projectManagerPhone == null ? 43 : $projectManagerPhone.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
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
      Object $marginType = this.getMarginType();
      result = result * 59 + ($marginType == null ? 43 : $marginType.hashCode());
      Object $currencyType = this.getCurrencyType();
      result = result * 59 + ($currencyType == null ? 43 : $currencyType.hashCode());
      Object $qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
      result = result * 59 + ($qualityGuaranteeDeposit == null ? 43 : $qualityGuaranteeDeposit.hashCode());
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
      Object $relationUserIds = this.getRelationUserIds();
      result = result * 59 + ($relationUserIds == null ? 43 : $relationUserIds.hashCode());
      Object $customerRemark = this.getCustomerRemark();
      return result * 59 + ($customerRemark == null ? 43 : $customerRemark.hashCode());
   }

   public static class ContractProjectTempBuilder {
      private Long id;
      private Long projectId;
      private Long changeId;
      private String serialNumber;
      private String name;
      private String shortName;
      private LocalDate startDate;
      private LocalDate endDate;
      private String address;
      private Long projectManagerId;
      private String projectManagerName;
      private String projectManagerPhone;
      private Long businessLeaderId;
      private Long businessLeaderTwoId;
      private String attachments;
      private Long cityId;
      private String cityName;
      private Long countryId;
      private String countryName;
      private BigDecimal contractAmount;
      private BigDecimal prepayments;
      private BigDecimal managementFeeRate;
      private BigDecimal marginAmount;
      private String marginType;
      private String currencyType;
      private BigDecimal qualityGuaranteeDeposit;
      private Long provinceId;
      private String provinceName;
      private Long regionId;
      private String regionName;
      private Long contractSignBodyId;
      private Integer businessType;
      private Integer projectType;
      private String projectContent;
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
      private String relationUserIds;
      private Integer orderSourceType;
      private Integer structureStatus;
      private Long structureTypeId;
      private String customerRemark;

      ContractProjectTempBuilder() {
      }

      @JsonProperty("id")
      public ContractProjectTemp.ContractProjectTempBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ContractProjectTemp.ContractProjectTempBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("changeId")
      public ContractProjectTemp.ContractProjectTempBuilder changeId(final Long changeId) {
         this.changeId = changeId;
         return this;
      }

      @JsonProperty("serial_number")
      public ContractProjectTemp.ContractProjectTempBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("name")
      public ContractProjectTemp.ContractProjectTempBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("shortName")
      public ContractProjectTemp.ContractProjectTempBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("startDate")
      public ContractProjectTemp.ContractProjectTempBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("endDate")
      public ContractProjectTemp.ContractProjectTempBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      @JsonProperty("address")
      public ContractProjectTemp.ContractProjectTempBuilder address(final String address) {
         this.address = address;
         return this;
      }

      @JsonProperty("projectManagerId")
      public ContractProjectTemp.ContractProjectTempBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder projectManagerPhone(final String projectManagerPhone) {
         this.projectManagerPhone = projectManagerPhone;
         return this;
      }

      @JsonProperty("businessLeaderId")
      public ContractProjectTemp.ContractProjectTempBuilder businessLeaderId(final Long businessLeaderId) {
         this.businessLeaderId = businessLeaderId;
         return this;
      }

      @JsonProperty("businessLeaderTwoId")
      public ContractProjectTemp.ContractProjectTempBuilder businessLeaderTwoId(final Long businessLeaderTwoId) {
         this.businessLeaderTwoId = businessLeaderTwoId;
         return this;
      }

      @JsonProperty("attachments")
      public ContractProjectTemp.ContractProjectTempBuilder attachments(final String attachments) {
         this.attachments = attachments;
         return this;
      }

      @JsonProperty("cityId")
      public ContractProjectTemp.ContractProjectTempBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      @JsonProperty("cityName")
      public ContractProjectTemp.ContractProjectTempBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      @JsonProperty("countryId")
      public ContractProjectTemp.ContractProjectTempBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      @JsonProperty("countryName")
      public ContractProjectTemp.ContractProjectTempBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      @JsonProperty("contractAmount")
      public ContractProjectTemp.ContractProjectTempBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      @JsonProperty("prepayments")
      public ContractProjectTemp.ContractProjectTempBuilder prepayments(final BigDecimal prepayments) {
         this.prepayments = prepayments;
         return this;
      }

      @JsonProperty("management_fee_rate")
      public ContractProjectTemp.ContractProjectTempBuilder managementFeeRate(final BigDecimal managementFeeRate) {
         this.managementFeeRate = managementFeeRate;
         return this;
      }

      @JsonProperty("margin_amount")
      public ContractProjectTemp.ContractProjectTempBuilder marginAmount(final BigDecimal marginAmount) {
         this.marginAmount = marginAmount;
         return this;
      }

      @JsonProperty("marginType")
      public ContractProjectTemp.ContractProjectTempBuilder marginType(final String marginType) {
         this.marginType = marginType;
         return this;
      }

      @JsonProperty("currencyType")
      public ContractProjectTemp.ContractProjectTempBuilder currencyType(final String currencyType) {
         this.currencyType = currencyType;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder qualityGuaranteeDeposit(final BigDecimal qualityGuaranteeDeposit) {
         this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
         return this;
      }

      @JsonProperty("provinceId")
      public ContractProjectTemp.ContractProjectTempBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      @JsonProperty("provinceName")
      public ContractProjectTemp.ContractProjectTempBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      @JsonProperty("regionId")
      public ContractProjectTemp.ContractProjectTempBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      @JsonProperty("regionName")
      public ContractProjectTemp.ContractProjectTempBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      @JsonProperty("contractSignBodyId")
      public ContractProjectTemp.ContractProjectTempBuilder contractSignBodyId(final Long contractSignBodyId) {
         this.contractSignBodyId = contractSignBodyId;
         return this;
      }

      @JsonProperty("businessType")
      public ContractProjectTemp.ContractProjectTempBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      @JsonProperty("projectType")
      public ContractProjectTemp.ContractProjectTempBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      @JsonProperty("projectContent")
      public ContractProjectTemp.ContractProjectTempBuilder projectContent(final String projectContent) {
         this.projectContent = projectContent;
         return this;
      }

      @JsonProperty("productCategory")
      public ContractProjectTemp.ContractProjectTempBuilder productCategory(final Integer productCategory) {
         this.productCategory = productCategory;
         return this;
      }

      @JsonProperty("transportMode")
      public ContractProjectTemp.ContractProjectTempBuilder transportMode(final Integer transportMode) {
         this.transportMode = transportMode;
         return this;
      }

      @JsonProperty("enclosureTransportMode")
      public ContractProjectTemp.ContractProjectTempBuilder enclosureTransportMode(final Integer enclosureTransportMode) {
         this.enclosureTransportMode = enclosureTransportMode;
         return this;
      }

      @JsonProperty("structureMeasureMode")
      public ContractProjectTemp.ContractProjectTempBuilder structureMeasureMode(final Integer structureMeasureMode) {
         this.structureMeasureMode = structureMeasureMode;
         return this;
      }

      @JsonProperty("enclosureMeasureMode")
      public ContractProjectTemp.ContractProjectTempBuilder enclosureMeasureMode(final Integer enclosureMeasureMode) {
         this.enclosureMeasureMode = enclosureMeasureMode;
         return this;
      }

      @JsonProperty("signingAddress")
      public ContractProjectTemp.ContractProjectTempBuilder signingAddress(final String signingAddress) {
         this.signingAddress = signingAddress;
         return this;
      }

      @JsonProperty("signingDate")
      public ContractProjectTemp.ContractProjectTempBuilder signingDate(final LocalDate signingDate) {
         this.signingDate = signingDate;
         return this;
      }

      @JsonProperty("signerId")
      public ContractProjectTemp.ContractProjectTempBuilder signerId(final Long signerId) {
         this.signerId = signerId;
         return this;
      }

      @JsonProperty("signerName")
      public ContractProjectTemp.ContractProjectTempBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder signerPhone(final String signerPhone) {
         this.signerPhone = signerPhone;
         return this;
      }

      @JsonProperty("isTax")
      public ContractProjectTemp.ContractProjectTempBuilder isTax(final Integer isTax) {
         this.isTax = isTax;
         return this;
      }

      @JsonProperty("invoiceType")
      public ContractProjectTemp.ContractProjectTempBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("tax_rate")
      public ContractProjectTemp.ContractProjectTempBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("payType")
      public ContractProjectTemp.ContractProjectTempBuilder payType(final Integer payType) {
         this.payType = payType;
         return this;
      }

      @JsonProperty("payTypeDesc")
      public ContractProjectTemp.ContractProjectTempBuilder payTypeDesc(final String payTypeDesc) {
         this.payTypeDesc = payTypeDesc;
         return this;
      }

      @JsonProperty("technologyRemark")
      public ContractProjectTemp.ContractProjectTempBuilder technologyRemark(final String technologyRemark) {
         this.technologyRemark = technologyRemark;
         return this;
      }

      @JsonProperty("customerUnit")
      public ContractProjectTemp.ContractProjectTempBuilder customerUnit(final String customerUnit) {
         this.customerUnit = customerUnit;
         return this;
      }

      @JsonProperty("socialCode")
      public ContractProjectTemp.ContractProjectTempBuilder socialCode(final String socialCode) {
         this.socialCode = socialCode;
         return this;
      }

      @JsonProperty("customerUnitPhone")
      public ContractProjectTemp.ContractProjectTempBuilder customerUnitPhone(final String customerUnitPhone) {
         this.customerUnitPhone = customerUnitPhone;
         return this;
      }

      @JsonProperty("customerEmail")
      public ContractProjectTemp.ContractProjectTempBuilder customerEmail(final String customerEmail) {
         this.customerEmail = customerEmail;
         return this;
      }

      @JsonProperty("userId")
      public ContractProjectTemp.ContractProjectTempBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("customerProvinceId")
      public ContractProjectTemp.ContractProjectTempBuilder customerProvinceId(final Long customerProvinceId) {
         this.customerProvinceId = customerProvinceId;
         return this;
      }

      @JsonProperty("customerProvinceName")
      public ContractProjectTemp.ContractProjectTempBuilder customerProvinceName(final String customerProvinceName) {
         this.customerProvinceName = customerProvinceName;
         return this;
      }

      @JsonProperty("customerCityId")
      public ContractProjectTemp.ContractProjectTempBuilder customerCityId(final Long customerCityId) {
         this.customerCityId = customerCityId;
         return this;
      }

      @JsonProperty("customerCityName")
      public ContractProjectTemp.ContractProjectTempBuilder customerCityName(final String customerCityName) {
         this.customerCityName = customerCityName;
         return this;
      }

      @JsonProperty("customerRegionId")
      public ContractProjectTemp.ContractProjectTempBuilder customerRegionId(final Long customerRegionId) {
         this.customerRegionId = customerRegionId;
         return this;
      }

      @JsonProperty("customerRegionName")
      public ContractProjectTemp.ContractProjectTempBuilder customerRegionName(final String customerRegionName) {
         this.customerRegionName = customerRegionName;
         return this;
      }

      @JsonProperty("customerCountryId")
      public ContractProjectTemp.ContractProjectTempBuilder customerCountryId(final Long customerCountryId) {
         this.customerCountryId = customerCountryId;
         return this;
      }

      @JsonProperty("customerCountryName")
      public ContractProjectTemp.ContractProjectTempBuilder customerCountryName(final String customerCountryName) {
         this.customerCountryName = customerCountryName;
         return this;
      }

      @JsonProperty("customerAddress")
      public ContractProjectTemp.ContractProjectTempBuilder customerAddress(final String customerAddress) {
         this.customerAddress = customerAddress;
         return this;
      }

      @JsonProperty("customerBankUserName")
      public ContractProjectTemp.ContractProjectTempBuilder customerBankUserName(final String customerBankUserName) {
         this.customerBankUserName = customerBankUserName;
         return this;
      }

      @JsonProperty("customerBankCode")
      public ContractProjectTemp.ContractProjectTempBuilder customerBankCode(final String customerBankCode) {
         this.customerBankCode = customerBankCode;
         return this;
      }

      @JsonProperty("customerBankName")
      public ContractProjectTemp.ContractProjectTempBuilder customerBankName(final String customerBankName) {
         this.customerBankName = customerBankName;
         return this;
      }

      @JsonProperty("customerManagerOne")
      public ContractProjectTemp.ContractProjectTempBuilder customerManagerOne(final String customerManagerOne) {
         this.customerManagerOne = customerManagerOne;
         return this;
      }

      @JsonProperty("customerManagerOnePhone")
      public ContractProjectTemp.ContractProjectTempBuilder customerManagerOnePhone(final String customerManagerOnePhone) {
         this.customerManagerOnePhone = customerManagerOnePhone;
         return this;
      }

      @JsonProperty("customerManagerTwo")
      public ContractProjectTemp.ContractProjectTempBuilder customerManagerTwo(final String customerManagerTwo) {
         this.customerManagerTwo = customerManagerTwo;
         return this;
      }

      @JsonProperty("customerManagerTwoPhone")
      public ContractProjectTemp.ContractProjectTempBuilder customerManagerTwoPhone(final String customerManagerTwoPhone) {
         this.customerManagerTwoPhone = customerManagerTwoPhone;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder receivingManager(final String receivingManager) {
         this.receivingManager = receivingManager;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder receivingManagerPhone(final String receivingManagerPhone) {
         this.receivingManagerPhone = receivingManagerPhone;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder settleManager(final String settleManager) {
         this.settleManager = settleManager;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder settleManagerPhone(final String settleManagerPhone) {
         this.settleManagerPhone = settleManagerPhone;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder financeManager(final String financeManager) {
         this.financeManager = financeManager;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder financeManagerPhone(final String financeManagerPhone) {
         this.financeManagerPhone = financeManagerPhone;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder auditManager(final String auditManager) {
         this.auditManager = auditManager;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder auditManagerPhone(final String auditManagerPhone) {
         this.auditManagerPhone = auditManagerPhone;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder designManager(final String designManager) {
         this.designManager = designManager;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder designManagerPhone(final String designManagerPhone) {
         this.designManagerPhone = designManagerPhone;
         return this;
      }

      @JsonProperty("relationUserIds")
      public ContractProjectTemp.ContractProjectTempBuilder relationUserIds(final String relationUserIds) {
         this.relationUserIds = relationUserIds;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder orderSourceType(final Integer orderSourceType) {
         this.orderSourceType = orderSourceType;
         return this;
      }

      @Deprecated
      @JsonProperty("structureStatus")
      public ContractProjectTemp.ContractProjectTempBuilder structureStatus(final Integer structureStatus) {
         this.structureStatus = structureStatus;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder structureTypeId(final Long structureTypeId) {
         this.structureTypeId = structureTypeId;
         return this;
      }

      public ContractProjectTemp.ContractProjectTempBuilder customerRemark(final String customerRemark) {
         this.customerRemark = customerRemark;
         return this;
      }

      public ContractProjectTemp build() {
         return new ContractProjectTemp(
            this.id,
            this.projectId,
            this.changeId,
            this.serialNumber,
            this.name,
            this.shortName,
            this.startDate,
            this.endDate,
            this.address,
            this.projectManagerId,
            this.projectManagerName,
            this.projectManagerPhone,
            this.businessLeaderId,
            this.businessLeaderTwoId,
            this.attachments,
            this.cityId,
            this.cityName,
            this.countryId,
            this.countryName,
            this.contractAmount,
            this.prepayments,
            this.managementFeeRate,
            this.marginAmount,
            this.marginType,
            this.currencyType,
            this.qualityGuaranteeDeposit,
            this.provinceId,
            this.provinceName,
            this.regionId,
            this.regionName,
            this.contractSignBodyId,
            this.businessType,
            this.projectType,
            this.projectContent,
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
            this.relationUserIds,
            this.orderSourceType,
            this.structureStatus,
            this.structureTypeId,
            this.customerRemark
         );
      }

      @Override
      public String toString() {
         return "ContractProjectTemp.ContractProjectTempBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", changeId="
            + this.changeId
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
            + ", address="
            + this.address
            + ", projectManagerId="
            + this.projectManagerId
            + ", projectManagerName="
            + this.projectManagerName
            + ", projectManagerPhone="
            + this.projectManagerPhone
            + ", businessLeaderId="
            + this.businessLeaderId
            + ", businessLeaderTwoId="
            + this.businessLeaderTwoId
            + ", attachments="
            + this.attachments
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
            + ", marginAmount="
            + this.marginAmount
            + ", marginType="
            + this.marginType
            + ", currencyType="
            + this.currencyType
            + ", qualityGuaranteeDeposit="
            + this.qualityGuaranteeDeposit
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
            + ", relationUserIds="
            + this.relationUserIds
            + ", orderSourceType="
            + this.orderSourceType
            + ", structureStatus="
            + this.structureStatus
            + ", structureTypeId="
            + this.structureTypeId
            + ", customerRemark="
            + this.customerRemark
            + ")";
      }
   }
}
