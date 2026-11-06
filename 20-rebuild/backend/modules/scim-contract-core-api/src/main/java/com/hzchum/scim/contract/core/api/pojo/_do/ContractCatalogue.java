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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractCatalogue对象", description = "合同目录")
@Entity
@TableName("contract_catalogue")
@Table(name = "contract_catalogue")
public class ContractCatalogue extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "contractNumber", value = "合同目录编号", notes = "合同目录编号")
   @JsonProperty("contractNumber")
   @JSONField(name = "contractNumber")
   @TableField("contract_number")
   @Column(name = "contract_number", columnDefinition = "varchar(255) comment '合同目录编号'")
   private String contractNumber;
   @ApiModelProperty(name = "registerDate", value = "登记日期", notes = "登记日期")
   @JsonProperty("registerDate")
   @JSONField(name = "registerDate")
   @TableField("register_date")
   @Column(name = "register_date", columnDefinition = "datetime comment '登记日期'")
   private LocalDateTime registerDate;
   @ApiModelProperty(name = "transferDate", value = "移交日期", notes = "移交日期")
   @JsonProperty("transferDate")
   @JSONField(name = "transferDate")
   @TableField("transfer_date")
   @Column(name = "transfer_date", columnDefinition = "datetime comment '移交日期'")
   private LocalDateTime transferDate;
   @ApiModelProperty(name = "signStatus", value = "签订情况", notes = "签订情况")
   @JsonProperty("signStatus")
   @JSONField(name = "signStatus")
   @TableField("sign_status")
   @Column(name = "sign_status", columnDefinition = "tinyint(1) default'0' comment '签订情况'")
   private Boolean signStatus;
   @ApiModelProperty(name = "signDate", value = "签订日期", notes = "签订日期")
   @JsonProperty("signDate")
   @JSONField(name = "signDate")
   @TableField("sign_date")
   @Column(name = "sign_date", columnDefinition = "datetime comment '签订日期'")
   private LocalDateTime signDate;
   @ApiModelProperty(name = "issueTime", value = "下发时间 IssueTimeEnum", notes = "下发时间 IssueTimeEnum")
   @JsonProperty("issueTime")
   @JSONField(name = "issueTime")
   @TableField("issue_time")
   @Column(name = "issue_time", columnDefinition = "int default'0' comment '下发时间'")
   private Integer issueTime;
   @ApiModelProperty(name = "partyA", value = "甲方", notes = "甲方")
   @JsonProperty("partyA")
   @JSONField(name = "partyA")
   @TableField("party_a")
   @Column(name = "party_a", columnDefinition = "varchar(255) comment '甲方'")
   private String partyA;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   @TableField("project_name")
   @Column(name = "project_name", columnDefinition = "varchar(255) comment '项目名称'")
   private String projectName;
   @ApiModelProperty(name = "contractAmount", value = "合同金额（元）", notes = "合同金额（元）")
   @JsonProperty("contractAmount")
   @JSONField(name = "contractAmount")
   @TableField("contract_amount")
   @Column(name = "contract_amount", columnDefinition = "decimal(19,2) comment '合同金额（元）'")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "originalContractAmount", value = "原备案合同额", notes = "原备案合同额")
   @JsonProperty("originalContractAmount")
   @JSONField(name = "originalContractAmount")
   @TableField("original_contract_amount")
   @Column(name = "original_contract_amount", columnDefinition = "decimal(19,2) comment '原备案合同额'")
   private BigDecimal originalContractAmount;
   @ApiModelProperty(name = "signerId", value = "签订人ID", notes = "签订人ID")
   @JsonProperty("signerId")
   @JSONField(name = "signerId")
   @TableField("signer_id")
   @Column(name = "signer_id", columnDefinition = "bigint comment '签订人ID'")
   private Long signerId;
   @ApiModelProperty(name = "signerName", value = "签订人姓名", notes = "签订人姓名")
   @JsonProperty("signerName")
   @JSONField(name = "signerName")
   @TableField("signer_name")
   @Column(name = "signer_name", columnDefinition = "varchar(255) comment '签订人姓名'")
   private String signerName;
   @ApiModelProperty(name = "firstLevelDept", value = "所属一级部门", notes = "所属一级部门")
   @JsonProperty("firstLevelDept")
   @JSONField(name = "firstLevelDept")
   @TableField("first_level_dept")
   @Column(name = "first_level_dept", columnDefinition = "bigint(20) comment '所属一级部门'")
   private Long firstLevelDept;
   @ApiModelProperty(name = "secondLevelDept", value = "所属二级部门", notes = "所属二级部门")
   @JsonProperty("secondLevelDept")
   @JSONField(name = "secondLevelDept")
   @TableField("second_level_dept")
   @Column(name = "second_level_dept", columnDefinition = "bigint(20) comment '所属二级部门'")
   private Long secondLevelDept;
   @ApiModelProperty(name = "infoSource", value = "信息来源", notes = "信息来源")
   @JsonProperty("infoSource")
   @JSONField(name = "infoSource")
   @TableField("info_source")
   @Column(name = "info_source", columnDefinition = "bigint comment '信息来源'")
   private Integer infoSource;
   @ApiModelProperty(name = "boolCoordinate", value = "销售员是否配合", notes = "销售员是否配合")
   @JsonProperty("boolCoordinate")
   @JSONField(name = "boolCoordinate")
   @TableField("bool_coordinate")
   @Column(name = "bool_coordinate", columnDefinition = "tinyint(1) comment '销售员是否配合'")
   private Boolean boolCoordinate;
   @ApiModelProperty(name = "projectManager", value = "项目经理", notes = "项目经理")
   @JsonProperty("projectManager")
   @JSONField(name = "projectManager")
   @TableField("project_manager")
   @Column(name = "project_manager", columnDefinition = "varchar(255) comment '项目经理'")
   private String projectManager;
   @ApiModelProperty(name = "structureType", value = "结构类型", notes = "结构类型")
   @JsonProperty("structureType")
   @JSONField(name = "structureType")
   @TableField("structure_type")
   @Column(name = "structure_type", columnDefinition = "bigint(20) comment '结构类型'")
   private Long structureType;
   @ApiModelProperty(name = "structureArea", value = "建筑面积（平方米）", notes = "建筑面积（平方米）")
   @JsonProperty("structureArea")
   @JSONField(name = "structureArea")
   @TableField("structure_area")
   @Column(name = "structure_area", columnDefinition = "decimal(32,8) comment '建筑面积（平方米）'")
   private BigDecimal structureArea;
   @ApiModelProperty(name = "mainStructureSteelMete", value = "主结构用钢量(吨)", notes = "主结构用钢量(吨)")
   @JsonProperty("mainStructureSteelMete")
   @JSONField(name = "mainStructureSteelMete")
   @TableField("main_structure_steel_mete")
   @Column(name = "main_structure_steel_mete", columnDefinition = "decimal(32,8) comment '主结构用钢量(吨)'")
   private BigDecimal mainStructureSteelMete;
   @ApiModelProperty(name = "subfabricSteelMete", value = "次结构用钢量(吨)", notes = "次结构用钢量(吨)")
   @JsonProperty("subfabricSteelMete")
   @JSONField(name = "subfabricSteelMete")
   @TableField("subfabric_steel_mete")
   @Column(name = "subfabric_steel_mete", columnDefinition = "decimal(32,8) comment '次结构用钢量(吨)'")
   private BigDecimal subfabricSteelMete;
   @ApiModelProperty(name = "maximumSpan", value = "最大跨度/高度", notes = "最大跨度/高度")
   @JsonProperty("maximumSpan")
   @JSONField(name = "maximumSpan")
   @TableField("maximum_span")
   @Column(name = "maximum_span", columnDefinition = "decimal(32,8) comment '最大跨度/高度'")
   private BigDecimal maximumSpan;
   @ApiModelProperty(name = "locationId", value = "区域Id", notes = "区域Id")
   @JsonProperty("locationId")
   @JSONField(name = "locationId")
   @TableField("location_id")
   @Column(name = "location_id", columnDefinition = "bigint comment '区域Id'")
   private Long locationId;
   @ApiModelProperty(name = "countryId", value = "国家ID", notes = "国家ID")
   @JsonProperty("countryId")
   @JSONField(name = "countryId")
   @TableField("country_id")
   @Column(name = "country_id", columnDefinition = "bigint comment '国家ID'")
   private Long countryId;
   @ApiModelProperty(name = "provinceId", value = "省份ID", notes = "省份ID")
   @JsonProperty("provinceId")
   @JSONField(name = "provinceId")
   @TableField("province_id")
   @Column(name = "province_id", columnDefinition = "bigint comment '省份ID'")
   private Long provinceId;
   @ApiModelProperty(name = "cityId", value = "城市ID", notes = "城市ID")
   @JsonProperty("cityId")
   @JSONField(name = "cityId")
   @TableField("city_id")
   @Column(name = "city_id", columnDefinition = "bigint comment '城市ID'")
   private Long cityId;
   @ApiModelProperty(name = "regionId", value = "区ID", notes = "区ID")
   @JsonProperty("regionId")
   @JSONField(name = "regionId")
   @TableField("region_id")
   @Column(name = "region_id", columnDefinition = "bigint comment '区ID'")
   private Long regionId;
   @ApiModelProperty(name = "address", value = "详细地址", notes = "详细地址")
   @JsonProperty("address")
   @JSONField(name = "address")
   @TableField("address")
   @Column(name = "address", columnDefinition = "varchar(1000) comment '详细地址'")
   private String address;
   @ApiModelProperty(name = "contractStartDate", value = "开工时间", notes = "开工时间")
   @JsonProperty("contractStartDate")
   @JSONField(name = "contractStartDate")
   @TableField("contract_start_date")
   @Column(name = "contract_start_date", columnDefinition = "datetime comment '开工时间'")
   private LocalDateTime contractStartDate;
   @ApiModelProperty(name = "contractEndDate", value = "竣工时间", notes = "竣工时间")
   @JsonProperty("contractEndDate")
   @JSONField(name = "contractEndDate")
   @TableField("contract_end_date")
   @Column(name = "contract_end_date", columnDefinition = "datetime comment '竣工时间'")
   private LocalDateTime contractEndDate;
   @ApiModelProperty(name = "contractualNature", value = "承包性质", notes = "承包性质")
   @JsonProperty("contractualNature")
   @JSONField(name = "contractualNature")
   @TableField("contractual_nature")
   @Column(name = "contractual_nature", columnDefinition = "bigint(20) comment '承包性质'")
   private Long contractualNature;
   @ApiModelProperty(name = "biddingMethod", value = "招标方式", notes = "招标方式")
   @JsonProperty("biddingMethod")
   @JSONField(name = "biddingMethod")
   @TableField("bidding_method")
   @Column(name = "bidding_method", columnDefinition = "bigint(20) comment '招标方式'")
   private Long biddingMethod;
   @ApiModelProperty(name = "partyType", value = "甲方类别", notes = "甲方类别")
   @JsonProperty("partyType")
   @JSONField(name = "partyType")
   @TableField("party_type")
   @Column(name = "party_type", columnDefinition = "bigint(20) comment '甲方类别'")
   private Long partyType;
   @ApiModelProperty(name = "contractType", value = "合同类型", notes = "合同类型")
   @JsonProperty("contractType")
   @JSONField(name = "contractType")
   @TableField("contract_type")
   @Column(name = "contract_type", columnDefinition = "bigint(20) comment '合同类型'")
   private Long contractType;
   @ApiModelProperty(name = "boolFabricatedStructure", value = "是否装配式建筑", notes = "是否装配式建筑")
   @JsonProperty("boolFabricatedStructure")
   @JSONField(name = "boolFabricatedStructure")
   @TableField("bool_fabricated_structure")
   @Column(name = "bool_fabricated_structure", columnDefinition = "tinyint(1) comment '是否装配式建筑'")
   private Boolean boolFabricatedStructure;
   @ApiModelProperty(name = "boolModelContract", value = "是否示范合同", notes = "是否示范合同")
   @JsonProperty("boolModelContract")
   @JSONField(name = "boolModelContract")
   @TableField("bool_model_contract")
   @Column(name = "bool_model_contract", columnDefinition = "tinyint(1) comment '是否示范合同'")
   private Boolean boolModelContract;
   @ApiModelProperty(name = "attachments", value = "合同附件ID集")
   @JsonProperty("attachments")
   @JSONField(name = "attachments")
   @TableField(value = "attachments", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "attachments", columnDefinition = "varchar(255) comment '合同附件ID集'")
   private String attachments;
   @ApiModelProperty(name = "preRegistrationId", value = "预登记ID")
   @JsonProperty("preRegistrationId")
   @JSONField(name = "preRegistrationId")
   @TableField("pre_registration_id")
   @Column(name = "pre_registration_id", columnDefinition = "bigint(20) comment '预登记ID'")
   private Long preRegistrationId;
   @ApiModelProperty(name = "registrationId", value = "合同登记ID")
   @JsonProperty("registrationId")
   @JSONField(name = "registrationId")
   @TableField("registration_id")
   @Column(name = "registration_id", columnDefinition = "bigint(20) comment '合同登记ID'")
   private Long registrationId;
   @ApiModelProperty(name = "createSource", value = "创建来源 0预登记 1评审登记 2直接登记", notes = "创建来源 0预登记 1评审登记 2直接登记")
   @JsonProperty("createSource")
   @JSONField(name = "createSource")
   @TableField("create_source")
   @Column(name = "create_source", columnDefinition = "tinyint(1) comment '创建来源'")
   private Integer createSource;
   @ApiModelProperty(name = "contractVersion", value = "合同版本", notes = "合同版本")
   @JsonProperty("contractVersion")
   @JSONField(name = "contractVersion")
   @TableField("contract_version")
   @Column(name = "contract_version", columnDefinition = "varchar(255) comment '合同版本'")
   private String contractVersion;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint comment '申请人ID'")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255) comment '申请人名称'")
   private String applicantName;
   @ApiModelProperty(name = "applicantDeptId", value = "申请人部门Id", notes = "申请人部门Id")
   @JsonProperty("applicantDeptId")
   @JSONField(name = "applicantDeptId")
   @TableField("applicant_dept_id")
   @Column(name = "applicant_dept_id", columnDefinition = "bigint comment '申请人部门Id'")
   private Long applicantDeptId;
   @ApiModelProperty(name = "applicationDate", value = "申请时间", notes = "申请时间")
   @JsonProperty("applicationDate")
   @JSONField(name = "applicationDate")
   @TableField("application_date")
   @Column(name = "application_date", columnDefinition = "datetime comment '申请时间'")
   private LocalDateTime applicationDate;
   @ApiModelProperty(name = "lastEditTime", value = "最后编辑时间", notes = "最后编辑时间")
   @JsonProperty("lastEditTime")
   @JSONField(name = "lastEditTime")
   @TableField("last_edit_time")
   @Column(name = "last_edit_time", columnDefinition = "datetime comment '最后编辑时间'")
   private LocalDateTime lastEditTime;
   @ApiModelProperty(name = "lastEditUserId", value = "最后编辑人ID", notes = "最后编辑人ID")
   @JsonProperty("lastEditUserId")
   @JSONField(name = "lastEditUserId")
   @TableField("last_edit_user_id")
   @Column(name = "last_edit_user_id", columnDefinition = "bigint comment '最后编辑人ID'")
   private Long lastEditUserId;
   @ApiModelProperty(name = "lastEditUserName", value = "最后编辑人名称", notes = "最后编辑人名称")
   @JsonProperty("lastEditUserName")
   @JSONField(name = "lastEditUserName")
   @TableField("last_edit_user_name")
   @Column(name = "last_edit_user_name", columnDefinition = "varchar(255) comment '最后编辑人名称'")
   private String lastEditUserName;
   @ApiModelProperty(name = "initDataId", value = "初始数据ID", notes = "初始数据ID")
   @JsonProperty("initDataId")
   @JSONField(name = "initDataId")
   @TableField("init_data_id")
   @Column(name = "init_data_id", columnDefinition = "bigint comment '初始数据ID'")
   private Long initDataId;
   @ApiModelProperty(name = "boolSupplement", value = "是否增补合同", notes = "是否增补合同")
   @JsonProperty("boolSupplement")
   @JSONField(name = "boolSupplement")
   @TableField("bool_supplement")
   @Column(name = "bool_supplement", columnDefinition = "tinyint(1) DEFAULT 0 comment '是否增补合同'")
   private Boolean boolSupplement;
   @ApiModelProperty(name = "parentId", value = "父级合同目录ID", notes = "父级合同目录ID")
   @JsonProperty("parentId")
   @JSONField(name = "parentId")
   @TableField("parent_id")
   @Column(name = "parent_id", columnDefinition = "bigint comment '父级合同目录ID'")
   private Long parentId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1000) comment '备注'")
   private String remark;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态，默认审核通过", notes = "审核状态，默认审核通过")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int DEFAULT 2  COMMENT '审核状态，默认审核通过'", nullable = true)
   private Integer reviewStatus;

   public static ContractCatalogue.ContractCatalogueBuilder builder() {
      return new ContractCatalogue.ContractCatalogueBuilder();
   }

   public ContractCatalogue() {
   }

   public ContractCatalogue(
      final Long id,
      final String contractNumber,
      final LocalDateTime registerDate,
      final LocalDateTime transferDate,
      final Boolean signStatus,
      final LocalDateTime signDate,
      final Integer issueTime,
      final String partyA,
      final String projectName,
      final BigDecimal contractAmount,
      final BigDecimal originalContractAmount,
      final Long signerId,
      final String signerName,
      final Long firstLevelDept,
      final Long secondLevelDept,
      final Integer infoSource,
      final Boolean boolCoordinate,
      final String projectManager,
      final Long structureType,
      final BigDecimal structureArea,
      final BigDecimal mainStructureSteelMete,
      final BigDecimal subfabricSteelMete,
      final BigDecimal maximumSpan,
      final Long locationId,
      final Long countryId,
      final Long provinceId,
      final Long cityId,
      final Long regionId,
      final String address,
      final LocalDateTime contractStartDate,
      final LocalDateTime contractEndDate,
      final Long contractualNature,
      final Long biddingMethod,
      final Long partyType,
      final Long contractType,
      final Boolean boolFabricatedStructure,
      final Boolean boolModelContract,
      final String attachments,
      final Long preRegistrationId,
      final Long registrationId,
      final Integer createSource,
      final String contractVersion,
      final Long applicantId,
      final String applicantName,
      final Long applicantDeptId,
      final LocalDateTime applicationDate,
      final LocalDateTime lastEditTime,
      final Long lastEditUserId,
      final String lastEditUserName,
      final Long initDataId,
      final Boolean boolSupplement,
      final Long parentId,
      final String remark,
      final Integer reviewStatus
   ) {
      this.id = id;
      this.contractNumber = contractNumber;
      this.registerDate = registerDate;
      this.transferDate = transferDate;
      this.signStatus = signStatus;
      this.signDate = signDate;
      this.issueTime = issueTime;
      this.partyA = partyA;
      this.projectName = projectName;
      this.contractAmount = contractAmount;
      this.originalContractAmount = originalContractAmount;
      this.signerId = signerId;
      this.signerName = signerName;
      this.firstLevelDept = firstLevelDept;
      this.secondLevelDept = secondLevelDept;
      this.infoSource = infoSource;
      this.boolCoordinate = boolCoordinate;
      this.projectManager = projectManager;
      this.structureType = structureType;
      this.structureArea = structureArea;
      this.mainStructureSteelMete = mainStructureSteelMete;
      this.subfabricSteelMete = subfabricSteelMete;
      this.maximumSpan = maximumSpan;
      this.locationId = locationId;
      this.countryId = countryId;
      this.provinceId = provinceId;
      this.cityId = cityId;
      this.regionId = regionId;
      this.address = address;
      this.contractStartDate = contractStartDate;
      this.contractEndDate = contractEndDate;
      this.contractualNature = contractualNature;
      this.biddingMethod = biddingMethod;
      this.partyType = partyType;
      this.contractType = contractType;
      this.boolFabricatedStructure = boolFabricatedStructure;
      this.boolModelContract = boolModelContract;
      this.attachments = attachments;
      this.preRegistrationId = preRegistrationId;
      this.registrationId = registrationId;
      this.createSource = createSource;
      this.contractVersion = contractVersion;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.applicantDeptId = applicantDeptId;
      this.applicationDate = applicationDate;
      this.lastEditTime = lastEditTime;
      this.lastEditUserId = lastEditUserId;
      this.lastEditUserName = lastEditUserName;
      this.initDataId = initDataId;
      this.boolSupplement = boolSupplement;
      this.parentId = parentId;
      this.remark = remark;
      this.reviewStatus = reviewStatus;
   }

   public Long getId() {
      return this.id;
   }

   public String getContractNumber() {
      return this.contractNumber;
   }

   public LocalDateTime getRegisterDate() {
      return this.registerDate;
   }

   public LocalDateTime getTransferDate() {
      return this.transferDate;
   }

   public Boolean getSignStatus() {
      return this.signStatus;
   }

   public LocalDateTime getSignDate() {
      return this.signDate;
   }

   public Integer getIssueTime() {
      return this.issueTime;
   }

   public String getPartyA() {
      return this.partyA;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getOriginalContractAmount() {
      return this.originalContractAmount;
   }

   public Long getSignerId() {
      return this.signerId;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public Long getFirstLevelDept() {
      return this.firstLevelDept;
   }

   public Long getSecondLevelDept() {
      return this.secondLevelDept;
   }

   public Integer getInfoSource() {
      return this.infoSource;
   }

   public Boolean getBoolCoordinate() {
      return this.boolCoordinate;
   }

   public String getProjectManager() {
      return this.projectManager;
   }

   public Long getStructureType() {
      return this.structureType;
   }

   public BigDecimal getStructureArea() {
      return this.structureArea;
   }

   public BigDecimal getMainStructureSteelMete() {
      return this.mainStructureSteelMete;
   }

   public BigDecimal getSubfabricSteelMete() {
      return this.subfabricSteelMete;
   }

   public BigDecimal getMaximumSpan() {
      return this.maximumSpan;
   }

   public Long getLocationId() {
      return this.locationId;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public String getAddress() {
      return this.address;
   }

   public LocalDateTime getContractStartDate() {
      return this.contractStartDate;
   }

   public LocalDateTime getContractEndDate() {
      return this.contractEndDate;
   }

   public Long getContractualNature() {
      return this.contractualNature;
   }

   public Long getBiddingMethod() {
      return this.biddingMethod;
   }

   public Long getPartyType() {
      return this.partyType;
   }

   public Long getContractType() {
      return this.contractType;
   }

   public Boolean getBoolFabricatedStructure() {
      return this.boolFabricatedStructure;
   }

   public Boolean getBoolModelContract() {
      return this.boolModelContract;
   }

   public String getAttachments() {
      return this.attachments;
   }

   public Long getPreRegistrationId() {
      return this.preRegistrationId;
   }

   public Long getRegistrationId() {
      return this.registrationId;
   }

   public Integer getCreateSource() {
      return this.createSource;
   }

   public String getContractVersion() {
      return this.contractVersion;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getApplicantDeptId() {
      return this.applicantDeptId;
   }

   public LocalDateTime getApplicationDate() {
      return this.applicationDate;
   }

   public LocalDateTime getLastEditTime() {
      return this.lastEditTime;
   }

   public Long getLastEditUserId() {
      return this.lastEditUserId;
   }

   public String getLastEditUserName() {
      return this.lastEditUserName;
   }

   public Long getInitDataId() {
      return this.initDataId;
   }

   public Boolean getBoolSupplement() {
      return this.boolSupplement;
   }

   public Long getParentId() {
      return this.parentId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   @JsonProperty("id")
   public ContractCatalogue setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("contractNumber")
   public ContractCatalogue setContractNumber(final String contractNumber) {
      this.contractNumber = contractNumber;
      return this;
   }

   @JsonProperty("registerDate")
   public ContractCatalogue setRegisterDate(final LocalDateTime registerDate) {
      this.registerDate = registerDate;
      return this;
   }

   @JsonProperty("transferDate")
   public ContractCatalogue setTransferDate(final LocalDateTime transferDate) {
      this.transferDate = transferDate;
      return this;
   }

   @JsonProperty("signStatus")
   public ContractCatalogue setSignStatus(final Boolean signStatus) {
      this.signStatus = signStatus;
      return this;
   }

   @JsonProperty("signDate")
   public ContractCatalogue setSignDate(final LocalDateTime signDate) {
      this.signDate = signDate;
      return this;
   }

   @JsonProperty("issueTime")
   public ContractCatalogue setIssueTime(final Integer issueTime) {
      this.issueTime = issueTime;
      return this;
   }

   @JsonProperty("partyA")
   public ContractCatalogue setPartyA(final String partyA) {
      this.partyA = partyA;
      return this;
   }

   @JsonProperty("projectName")
   public ContractCatalogue setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("contractAmount")
   public ContractCatalogue setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   @JsonProperty("originalContractAmount")
   public ContractCatalogue setOriginalContractAmount(final BigDecimal originalContractAmount) {
      this.originalContractAmount = originalContractAmount;
      return this;
   }

   @JsonProperty("signerId")
   public ContractCatalogue setSignerId(final Long signerId) {
      this.signerId = signerId;
      return this;
   }

   @JsonProperty("signerName")
   public ContractCatalogue setSignerName(final String signerName) {
      this.signerName = signerName;
      return this;
   }

   @JsonProperty("firstLevelDept")
   public ContractCatalogue setFirstLevelDept(final Long firstLevelDept) {
      this.firstLevelDept = firstLevelDept;
      return this;
   }

   @JsonProperty("secondLevelDept")
   public ContractCatalogue setSecondLevelDept(final Long secondLevelDept) {
      this.secondLevelDept = secondLevelDept;
      return this;
   }

   @JsonProperty("infoSource")
   public ContractCatalogue setInfoSource(final Integer infoSource) {
      this.infoSource = infoSource;
      return this;
   }

   @JsonProperty("boolCoordinate")
   public ContractCatalogue setBoolCoordinate(final Boolean boolCoordinate) {
      this.boolCoordinate = boolCoordinate;
      return this;
   }

   @JsonProperty("projectManager")
   public ContractCatalogue setProjectManager(final String projectManager) {
      this.projectManager = projectManager;
      return this;
   }

   @JsonProperty("structureType")
   public ContractCatalogue setStructureType(final Long structureType) {
      this.structureType = structureType;
      return this;
   }

   @JsonProperty("structureArea")
   public ContractCatalogue setStructureArea(final BigDecimal structureArea) {
      this.structureArea = structureArea;
      return this;
   }

   @JsonProperty("mainStructureSteelMete")
   public ContractCatalogue setMainStructureSteelMete(final BigDecimal mainStructureSteelMete) {
      this.mainStructureSteelMete = mainStructureSteelMete;
      return this;
   }

   @JsonProperty("subfabricSteelMete")
   public ContractCatalogue setSubfabricSteelMete(final BigDecimal subfabricSteelMete) {
      this.subfabricSteelMete = subfabricSteelMete;
      return this;
   }

   @JsonProperty("maximumSpan")
   public ContractCatalogue setMaximumSpan(final BigDecimal maximumSpan) {
      this.maximumSpan = maximumSpan;
      return this;
   }

   @JsonProperty("locationId")
   public ContractCatalogue setLocationId(final Long locationId) {
      this.locationId = locationId;
      return this;
   }

   @JsonProperty("countryId")
   public ContractCatalogue setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   @JsonProperty("provinceId")
   public ContractCatalogue setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   @JsonProperty("cityId")
   public ContractCatalogue setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   @JsonProperty("regionId")
   public ContractCatalogue setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   @JsonProperty("address")
   public ContractCatalogue setAddress(final String address) {
      this.address = address;
      return this;
   }

   @JsonProperty("contractStartDate")
   public ContractCatalogue setContractStartDate(final LocalDateTime contractStartDate) {
      this.contractStartDate = contractStartDate;
      return this;
   }

   @JsonProperty("contractEndDate")
   public ContractCatalogue setContractEndDate(final LocalDateTime contractEndDate) {
      this.contractEndDate = contractEndDate;
      return this;
   }

   @JsonProperty("contractualNature")
   public ContractCatalogue setContractualNature(final Long contractualNature) {
      this.contractualNature = contractualNature;
      return this;
   }

   @JsonProperty("biddingMethod")
   public ContractCatalogue setBiddingMethod(final Long biddingMethod) {
      this.biddingMethod = biddingMethod;
      return this;
   }

   @JsonProperty("partyType")
   public ContractCatalogue setPartyType(final Long partyType) {
      this.partyType = partyType;
      return this;
   }

   @JsonProperty("contractType")
   public ContractCatalogue setContractType(final Long contractType) {
      this.contractType = contractType;
      return this;
   }

   @JsonProperty("boolFabricatedStructure")
   public ContractCatalogue setBoolFabricatedStructure(final Boolean boolFabricatedStructure) {
      this.boolFabricatedStructure = boolFabricatedStructure;
      return this;
   }

   @JsonProperty("boolModelContract")
   public ContractCatalogue setBoolModelContract(final Boolean boolModelContract) {
      this.boolModelContract = boolModelContract;
      return this;
   }

   @JsonProperty("attachments")
   public ContractCatalogue setAttachments(final String attachments) {
      this.attachments = attachments;
      return this;
   }

   @JsonProperty("preRegistrationId")
   public ContractCatalogue setPreRegistrationId(final Long preRegistrationId) {
      this.preRegistrationId = preRegistrationId;
      return this;
   }

   @JsonProperty("registrationId")
   public ContractCatalogue setRegistrationId(final Long registrationId) {
      this.registrationId = registrationId;
      return this;
   }

   @JsonProperty("createSource")
   public ContractCatalogue setCreateSource(final Integer createSource) {
      this.createSource = createSource;
      return this;
   }

   @JsonProperty("contractVersion")
   public ContractCatalogue setContractVersion(final String contractVersion) {
      this.contractVersion = contractVersion;
      return this;
   }

   @JsonProperty("applicantId")
   public ContractCatalogue setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public ContractCatalogue setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("applicantDeptId")
   public ContractCatalogue setApplicantDeptId(final Long applicantDeptId) {
      this.applicantDeptId = applicantDeptId;
      return this;
   }

   @JsonProperty("applicationDate")
   public ContractCatalogue setApplicationDate(final LocalDateTime applicationDate) {
      this.applicationDate = applicationDate;
      return this;
   }

   @JsonProperty("lastEditTime")
   public ContractCatalogue setLastEditTime(final LocalDateTime lastEditTime) {
      this.lastEditTime = lastEditTime;
      return this;
   }

   @JsonProperty("lastEditUserId")
   public ContractCatalogue setLastEditUserId(final Long lastEditUserId) {
      this.lastEditUserId = lastEditUserId;
      return this;
   }

   @JsonProperty("lastEditUserName")
   public ContractCatalogue setLastEditUserName(final String lastEditUserName) {
      this.lastEditUserName = lastEditUserName;
      return this;
   }

   @JsonProperty("initDataId")
   public ContractCatalogue setInitDataId(final Long initDataId) {
      this.initDataId = initDataId;
      return this;
   }

   @JsonProperty("boolSupplement")
   public ContractCatalogue setBoolSupplement(final Boolean boolSupplement) {
      this.boolSupplement = boolSupplement;
      return this;
   }

   @JsonProperty("parentId")
   public ContractCatalogue setParentId(final Long parentId) {
      this.parentId = parentId;
      return this;
   }

   @JsonProperty("remark")
   public ContractCatalogue setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("reviewStatus")
   public ContractCatalogue setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ContractCatalogue(id="
         + this.getId()
         + ", contractNumber="
         + this.getContractNumber()
         + ", registerDate="
         + this.getRegisterDate()
         + ", transferDate="
         + this.getTransferDate()
         + ", signStatus="
         + this.getSignStatus()
         + ", signDate="
         + this.getSignDate()
         + ", issueTime="
         + this.getIssueTime()
         + ", partyA="
         + this.getPartyA()
         + ", projectName="
         + this.getProjectName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", originalContractAmount="
         + this.getOriginalContractAmount()
         + ", signerId="
         + this.getSignerId()
         + ", signerName="
         + this.getSignerName()
         + ", firstLevelDept="
         + this.getFirstLevelDept()
         + ", secondLevelDept="
         + this.getSecondLevelDept()
         + ", infoSource="
         + this.getInfoSource()
         + ", boolCoordinate="
         + this.getBoolCoordinate()
         + ", projectManager="
         + this.getProjectManager()
         + ", structureType="
         + this.getStructureType()
         + ", structureArea="
         + this.getStructureArea()
         + ", mainStructureSteelMete="
         + this.getMainStructureSteelMete()
         + ", subfabricSteelMete="
         + this.getSubfabricSteelMete()
         + ", maximumSpan="
         + this.getMaximumSpan()
         + ", locationId="
         + this.getLocationId()
         + ", countryId="
         + this.getCountryId()
         + ", provinceId="
         + this.getProvinceId()
         + ", cityId="
         + this.getCityId()
         + ", regionId="
         + this.getRegionId()
         + ", address="
         + this.getAddress()
         + ", contractStartDate="
         + this.getContractStartDate()
         + ", contractEndDate="
         + this.getContractEndDate()
         + ", contractualNature="
         + this.getContractualNature()
         + ", biddingMethod="
         + this.getBiddingMethod()
         + ", partyType="
         + this.getPartyType()
         + ", contractType="
         + this.getContractType()
         + ", boolFabricatedStructure="
         + this.getBoolFabricatedStructure()
         + ", boolModelContract="
         + this.getBoolModelContract()
         + ", attachments="
         + this.getAttachments()
         + ", preRegistrationId="
         + this.getPreRegistrationId()
         + ", registrationId="
         + this.getRegistrationId()
         + ", createSource="
         + this.getCreateSource()
         + ", contractVersion="
         + this.getContractVersion()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", applicantDeptId="
         + this.getApplicantDeptId()
         + ", applicationDate="
         + this.getApplicationDate()
         + ", lastEditTime="
         + this.getLastEditTime()
         + ", lastEditUserId="
         + this.getLastEditUserId()
         + ", lastEditUserName="
         + this.getLastEditUserName()
         + ", initDataId="
         + this.getInitDataId()
         + ", boolSupplement="
         + this.getBoolSupplement()
         + ", parentId="
         + this.getParentId()
         + ", remark="
         + this.getRemark()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractCatalogue)) {
         return false;
      }

      ContractCatalogue other = (ContractCatalogue)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$signStatus = this.getSignStatus();
         Object other$signStatus = other.getSignStatus();
         if (this$signStatus == null ? other$signStatus == null : this$signStatus.equals(other$signStatus)) {
            Object this$issueTime = this.getIssueTime();
            Object other$issueTime = other.getIssueTime();
            if (this$issueTime == null ? other$issueTime == null : this$issueTime.equals(other$issueTime)) {
               Object this$signerId = this.getSignerId();
               Object other$signerId = other.getSignerId();
               if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
                  Object this$firstLevelDept = this.getFirstLevelDept();
                  Object other$firstLevelDept = other.getFirstLevelDept();
                  if (this$firstLevelDept == null ? other$firstLevelDept == null : this$firstLevelDept.equals(other$firstLevelDept)) {
                     Object this$secondLevelDept = this.getSecondLevelDept();
                     Object other$secondLevelDept = other.getSecondLevelDept();
                     if (this$secondLevelDept == null ? other$secondLevelDept == null : this$secondLevelDept.equals(other$secondLevelDept)) {
                        Object this$infoSource = this.getInfoSource();
                        Object other$infoSource = other.getInfoSource();
                        if (this$infoSource == null ? other$infoSource == null : this$infoSource.equals(other$infoSource)) {
                           Object this$boolCoordinate = this.getBoolCoordinate();
                           Object other$boolCoordinate = other.getBoolCoordinate();
                           if (this$boolCoordinate == null ? other$boolCoordinate == null : this$boolCoordinate.equals(other$boolCoordinate)) {
                              Object this$structureType = this.getStructureType();
                              Object other$structureType = other.getStructureType();
                              if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                                 Object this$locationId = this.getLocationId();
                                 Object other$locationId = other.getLocationId();
                                 if (this$locationId == null ? other$locationId == null : this$locationId.equals(other$locationId)) {
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
                                                Object this$contractualNature = this.getContractualNature();
                                                Object other$contractualNature = other.getContractualNature();
                                                if (this$contractualNature == null
                                                   ? other$contractualNature == null
                                                   : this$contractualNature.equals(other$contractualNature)) {
                                                   Object this$biddingMethod = this.getBiddingMethod();
                                                   Object other$biddingMethod = other.getBiddingMethod();
                                                   if (this$biddingMethod == null
                                                      ? other$biddingMethod == null
                                                      : this$biddingMethod.equals(other$biddingMethod)) {
                                                      Object this$partyType = this.getPartyType();
                                                      Object other$partyType = other.getPartyType();
                                                      if (this$partyType == null ? other$partyType == null : this$partyType.equals(other$partyType)) {
                                                         Object this$contractType = this.getContractType();
                                                         Object other$contractType = other.getContractType();
                                                         if (this$contractType == null
                                                            ? other$contractType == null
                                                            : this$contractType.equals(other$contractType)) {
                                                            Object this$boolFabricatedStructure = this.getBoolFabricatedStructure();
                                                            Object other$boolFabricatedStructure = other.getBoolFabricatedStructure();
                                                            if (this$boolFabricatedStructure == null
                                                               ? other$boolFabricatedStructure == null
                                                               : this$boolFabricatedStructure.equals(other$boolFabricatedStructure)) {
                                                               Object this$boolModelContract = this.getBoolModelContract();
                                                               Object other$boolModelContract = other.getBoolModelContract();
                                                               if (this$boolModelContract == null
                                                                  ? other$boolModelContract == null
                                                                  : this$boolModelContract.equals(other$boolModelContract)) {
                                                                  Object this$preRegistrationId = this.getPreRegistrationId();
                                                                  Object other$preRegistrationId = other.getPreRegistrationId();
                                                                  if (this$preRegistrationId == null
                                                                     ? other$preRegistrationId == null
                                                                     : this$preRegistrationId.equals(other$preRegistrationId)) {
                                                                     Object this$registrationId = this.getRegistrationId();
                                                                     Object other$registrationId = other.getRegistrationId();
                                                                     if (this$registrationId == null
                                                                        ? other$registrationId == null
                                                                        : this$registrationId.equals(other$registrationId)) {
                                                                        Object this$createSource = this.getCreateSource();
                                                                        Object other$createSource = other.getCreateSource();
                                                                        if (this$createSource == null
                                                                           ? other$createSource == null
                                                                           : this$createSource.equals(other$createSource)) {
                                                                           Object this$applicantId = this.getApplicantId();
                                                                           Object other$applicantId = other.getApplicantId();
                                                                           if (this$applicantId == null
                                                                              ? other$applicantId == null
                                                                              : this$applicantId.equals(other$applicantId)) {
                                                                              Object this$applicantDeptId = this.getApplicantDeptId();
                                                                              Object other$applicantDeptId = other.getApplicantDeptId();
                                                                              if (this$applicantDeptId == null
                                                                                 ? other$applicantDeptId == null
                                                                                 : this$applicantDeptId.equals(other$applicantDeptId)) {
                                                                                 Object this$lastEditUserId = this.getLastEditUserId();
                                                                                 Object other$lastEditUserId = other.getLastEditUserId();
                                                                                 if (this$lastEditUserId == null
                                                                                    ? other$lastEditUserId == null
                                                                                    : this$lastEditUserId.equals(other$lastEditUserId)) {
                                                                                    Object this$initDataId = this.getInitDataId();
                                                                                    Object other$initDataId = other.getInitDataId();
                                                                                    if (this$initDataId == null
                                                                                       ? other$initDataId == null
                                                                                       : this$initDataId.equals(other$initDataId)) {
                                                                                       Object this$boolSupplement = this.getBoolSupplement();
                                                                                       Object other$boolSupplement = other.getBoolSupplement();
                                                                                       if (this$boolSupplement == null
                                                                                          ? other$boolSupplement == null
                                                                                          : this$boolSupplement.equals(other$boolSupplement)) {
                                                                                          Object this$parentId = this.getParentId();
                                                                                          Object other$parentId = other.getParentId();
                                                                                          if (this$parentId == null
                                                                                             ? other$parentId == null
                                                                                             : this$parentId.equals(other$parentId)) {
                                                                                             Object this$reviewStatus = this.getReviewStatus();
                                                                                             Object other$reviewStatus = other.getReviewStatus();
                                                                                             if (this$reviewStatus == null
                                                                                                ? other$reviewStatus == null
                                                                                                : this$reviewStatus.equals(other$reviewStatus)) {
                                                                                                Object this$contractNumber = this.getContractNumber();
                                                                                                Object other$contractNumber = other.getContractNumber();
                                                                                                if (this$contractNumber == null
                                                                                                   ? other$contractNumber == null
                                                                                                   : this$contractNumber.equals(other$contractNumber)) {
                                                                                                   Object this$registerDate = this.getRegisterDate();
                                                                                                   Object other$registerDate = other.getRegisterDate();
                                                                                                   if (this$registerDate == null
                                                                                                      ? other$registerDate == null
                                                                                                      : this$registerDate.equals(other$registerDate)) {
                                                                                                      Object this$transferDate = this.getTransferDate();
                                                                                                      Object other$transferDate = other.getTransferDate();
                                                                                                      if (this$transferDate == null
                                                                                                         ? other$transferDate == null
                                                                                                         : this$transferDate.equals(other$transferDate)) {
                                                                                                         Object this$signDate = this.getSignDate();
                                                                                                         Object other$signDate = other.getSignDate();
                                                                                                         if (this$signDate == null
                                                                                                            ? other$signDate == null
                                                                                                            : this$signDate.equals(other$signDate)) {
                                                                                                            Object this$partyA = this.getPartyA();
                                                                                                            Object other$partyA = other.getPartyA();
                                                                                                            if (this$partyA == null
                                                                                                               ? other$partyA == null
                                                                                                               : this$partyA.equals(other$partyA)) {
                                                                                                               Object this$projectName = this.getProjectName();
                                                                                                               Object other$projectName = other.getProjectName();
                                                                                                               if (this$projectName == null
                                                                                                                  ? other$projectName == null
                                                                                                                  : this$projectName.equals(other$projectName)) {
                                                                                                                  Object this$contractAmount = this.getContractAmount();
                                                                                                                  Object other$contractAmount = other.getContractAmount();
                                                                                                                  if (this$contractAmount == null
                                                                                                                     ? other$contractAmount == null
                                                                                                                     : this$contractAmount.equals(
                                                                                                                        other$contractAmount
                                                                                                                     )) {
                                                                                                                     Object this$originalContractAmount = this.getOriginalContractAmount();
                                                                                                                     Object other$originalContractAmount = other.getOriginalContractAmount();
                                                                                                                     if (this$originalContractAmount == null
                                                                                                                        ? other$originalContractAmount == null
                                                                                                                        : this$originalContractAmount.equals(
                                                                                                                           other$originalContractAmount
                                                                                                                        )) {
                                                                                                                        Object this$signerName = this.getSignerName();
                                                                                                                        Object other$signerName = other.getSignerName();
                                                                                                                        if (this$signerName == null
                                                                                                                           ? other$signerName == null
                                                                                                                           : this$signerName.equals(
                                                                                                                              other$signerName
                                                                                                                           )) {
                                                                                                                           Object this$projectManager = this.getProjectManager();
                                                                                                                           Object other$projectManager = other.getProjectManager();
                                                                                                                           if (this$projectManager == null
                                                                                                                              ? other$projectManager == null
                                                                                                                              : this$projectManager.equals(
                                                                                                                                 other$projectManager
                                                                                                                              )) {
                                                                                                                              Object this$structureArea = this.getStructureArea();
                                                                                                                              Object other$structureArea = other.getStructureArea();
                                                                                                                              if (this$structureArea == null
                                                                                                                                 ? other$structureArea == null
                                                                                                                                 : this$structureArea.equals(
                                                                                                                                    other$structureArea
                                                                                                                                 )) {
                                                                                                                                 Object this$mainStructureSteelMete = this.getMainStructureSteelMete();
                                                                                                                                 Object other$mainStructureSteelMete = other.getMainStructureSteelMete();
                                                                                                                                 if (this$mainStructureSteelMete
                                                                                                                                       == null
                                                                                                                                    ? other$mainStructureSteelMete
                                                                                                                                       == null
                                                                                                                                    : this$mainStructureSteelMete.equals(
                                                                                                                                       other$mainStructureSteelMete
                                                                                                                                    )) {
                                                                                                                                    Object this$subfabricSteelMete = this.getSubfabricSteelMete();
                                                                                                                                    Object other$subfabricSteelMete = other.getSubfabricSteelMete();
                                                                                                                                    if (this$subfabricSteelMete
                                                                                                                                          == null
                                                                                                                                       ? other$subfabricSteelMete
                                                                                                                                          == null
                                                                                                                                       : this$subfabricSteelMete.equals(
                                                                                                                                          other$subfabricSteelMete
                                                                                                                                       )) {
                                                                                                                                       Object this$maximumSpan = this.getMaximumSpan();
                                                                                                                                       Object other$maximumSpan = other.getMaximumSpan();
                                                                                                                                       if (this$maximumSpan
                                                                                                                                             == null
                                                                                                                                          ? other$maximumSpan
                                                                                                                                             == null
                                                                                                                                          : this$maximumSpan.equals(
                                                                                                                                             other$maximumSpan
                                                                                                                                          )) {
                                                                                                                                          Object this$address = this.getAddress();
                                                                                                                                          Object other$address = other.getAddress();
                                                                                                                                          if (this$address
                                                                                                                                                == null
                                                                                                                                             ? other$address
                                                                                                                                                == null
                                                                                                                                             : this$address.equals(
                                                                                                                                                other$address
                                                                                                                                             )) {
                                                                                                                                             Object this$contractStartDate = this.getContractStartDate();
                                                                                                                                             Object other$contractStartDate = other.getContractStartDate();
                                                                                                                                             if (this$contractStartDate
                                                                                                                                                   == null
                                                                                                                                                ? other$contractStartDate
                                                                                                                                                   == null
                                                                                                                                                : this$contractStartDate.equals(
                                                                                                                                                   other$contractStartDate
                                                                                                                                                )) {
                                                                                                                                                Object this$contractEndDate = this.getContractEndDate();
                                                                                                                                                Object other$contractEndDate = other.getContractEndDate();
                                                                                                                                                if (this$contractEndDate
                                                                                                                                                      == null
                                                                                                                                                   ? other$contractEndDate
                                                                                                                                                      == null
                                                                                                                                                   : this$contractEndDate.equals(
                                                                                                                                                      other$contractEndDate
                                                                                                                                                   )) {
                                                                                                                                                   Object this$attachments = this.getAttachments();
                                                                                                                                                   Object other$attachments = other.getAttachments();
                                                                                                                                                   if (this$attachments
                                                                                                                                                         == null
                                                                                                                                                      ? other$attachments
                                                                                                                                                         == null
                                                                                                                                                      : this$attachments.equals(
                                                                                                                                                         other$attachments
                                                                                                                                                      )) {
                                                                                                                                                      Object this$contractVersion = this.getContractVersion();
                                                                                                                                                      Object other$contractVersion = other.getContractVersion();
                                                                                                                                                      if (this$contractVersion
                                                                                                                                                            == null
                                                                                                                                                         ? other$contractVersion
                                                                                                                                                            == null
                                                                                                                                                         : this$contractVersion.equals(
                                                                                                                                                            other$contractVersion
                                                                                                                                                         )) {
                                                                                                                                                         Object this$applicantName = this.getApplicantName();
                                                                                                                                                         Object other$applicantName = other.getApplicantName();
                                                                                                                                                         if (this$applicantName
                                                                                                                                                               == null
                                                                                                                                                            ? other$applicantName
                                                                                                                                                               == null
                                                                                                                                                            : this$applicantName.equals(
                                                                                                                                                               other$applicantName
                                                                                                                                                            )) {
                                                                                                                                                            Object this$applicationDate = this.getApplicationDate();
                                                                                                                                                            Object other$applicationDate = other.getApplicationDate();
                                                                                                                                                            if (this$applicationDate
                                                                                                                                                                  == null
                                                                                                                                                               ? other$applicationDate
                                                                                                                                                                  == null
                                                                                                                                                               : this$applicationDate.equals(
                                                                                                                                                                  other$applicationDate
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$lastEditTime = this.getLastEditTime();
                                                                                                                                                               Object other$lastEditTime = other.getLastEditTime();
                                                                                                                                                               if (this$lastEditTime
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$lastEditTime
                                                                                                                                                                     == null
                                                                                                                                                                  : this$lastEditTime.equals(
                                                                                                                                                                     other$lastEditTime
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$lastEditUserName = this.getLastEditUserName();
                                                                                                                                                                  Object other$lastEditUserName = other.getLastEditUserName();
                                                                                                                                                                  if (this$lastEditUserName
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$lastEditUserName
                                                                                                                                                                        == null
                                                                                                                                                                     : this$lastEditUserName.equals(
                                                                                                                                                                        other$lastEditUserName
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$remark = this.getRemark();
                                                                                                                                                                     Object other$remark = other.getRemark();
                                                                                                                                                                     return this$remark
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$remark
                                                                                                                                                                           == null
                                                                                                                                                                        : this$remark.equals(
                                                                                                                                                                           other$remark
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractCatalogue;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $signStatus = this.getSignStatus();
      result = result * 59 + ($signStatus == null ? 43 : $signStatus.hashCode());
      Object $issueTime = this.getIssueTime();
      result = result * 59 + ($issueTime == null ? 43 : $issueTime.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
      Object $firstLevelDept = this.getFirstLevelDept();
      result = result * 59 + ($firstLevelDept == null ? 43 : $firstLevelDept.hashCode());
      Object $secondLevelDept = this.getSecondLevelDept();
      result = result * 59 + ($secondLevelDept == null ? 43 : $secondLevelDept.hashCode());
      Object $infoSource = this.getInfoSource();
      result = result * 59 + ($infoSource == null ? 43 : $infoSource.hashCode());
      Object $boolCoordinate = this.getBoolCoordinate();
      result = result * 59 + ($boolCoordinate == null ? 43 : $boolCoordinate.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $locationId = this.getLocationId();
      result = result * 59 + ($locationId == null ? 43 : $locationId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $contractualNature = this.getContractualNature();
      result = result * 59 + ($contractualNature == null ? 43 : $contractualNature.hashCode());
      Object $biddingMethod = this.getBiddingMethod();
      result = result * 59 + ($biddingMethod == null ? 43 : $biddingMethod.hashCode());
      Object $partyType = this.getPartyType();
      result = result * 59 + ($partyType == null ? 43 : $partyType.hashCode());
      Object $contractType = this.getContractType();
      result = result * 59 + ($contractType == null ? 43 : $contractType.hashCode());
      Object $boolFabricatedStructure = this.getBoolFabricatedStructure();
      result = result * 59 + ($boolFabricatedStructure == null ? 43 : $boolFabricatedStructure.hashCode());
      Object $boolModelContract = this.getBoolModelContract();
      result = result * 59 + ($boolModelContract == null ? 43 : $boolModelContract.hashCode());
      Object $preRegistrationId = this.getPreRegistrationId();
      result = result * 59 + ($preRegistrationId == null ? 43 : $preRegistrationId.hashCode());
      Object $registrationId = this.getRegistrationId();
      result = result * 59 + ($registrationId == null ? 43 : $registrationId.hashCode());
      Object $createSource = this.getCreateSource();
      result = result * 59 + ($createSource == null ? 43 : $createSource.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $applicantDeptId = this.getApplicantDeptId();
      result = result * 59 + ($applicantDeptId == null ? 43 : $applicantDeptId.hashCode());
      Object $lastEditUserId = this.getLastEditUserId();
      result = result * 59 + ($lastEditUserId == null ? 43 : $lastEditUserId.hashCode());
      Object $initDataId = this.getInitDataId();
      result = result * 59 + ($initDataId == null ? 43 : $initDataId.hashCode());
      Object $boolSupplement = this.getBoolSupplement();
      result = result * 59 + ($boolSupplement == null ? 43 : $boolSupplement.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $contractNumber = this.getContractNumber();
      result = result * 59 + ($contractNumber == null ? 43 : $contractNumber.hashCode());
      Object $registerDate = this.getRegisterDate();
      result = result * 59 + ($registerDate == null ? 43 : $registerDate.hashCode());
      Object $transferDate = this.getTransferDate();
      result = result * 59 + ($transferDate == null ? 43 : $transferDate.hashCode());
      Object $signDate = this.getSignDate();
      result = result * 59 + ($signDate == null ? 43 : $signDate.hashCode());
      Object $partyA = this.getPartyA();
      result = result * 59 + ($partyA == null ? 43 : $partyA.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $originalContractAmount = this.getOriginalContractAmount();
      result = result * 59 + ($originalContractAmount == null ? 43 : $originalContractAmount.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $projectManager = this.getProjectManager();
      result = result * 59 + ($projectManager == null ? 43 : $projectManager.hashCode());
      Object $structureArea = this.getStructureArea();
      result = result * 59 + ($structureArea == null ? 43 : $structureArea.hashCode());
      Object $mainStructureSteelMete = this.getMainStructureSteelMete();
      result = result * 59 + ($mainStructureSteelMete == null ? 43 : $mainStructureSteelMete.hashCode());
      Object $subfabricSteelMete = this.getSubfabricSteelMete();
      result = result * 59 + ($subfabricSteelMete == null ? 43 : $subfabricSteelMete.hashCode());
      Object $maximumSpan = this.getMaximumSpan();
      result = result * 59 + ($maximumSpan == null ? 43 : $maximumSpan.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $contractStartDate = this.getContractStartDate();
      result = result * 59 + ($contractStartDate == null ? 43 : $contractStartDate.hashCode());
      Object $contractEndDate = this.getContractEndDate();
      result = result * 59 + ($contractEndDate == null ? 43 : $contractEndDate.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $contractVersion = this.getContractVersion();
      result = result * 59 + ($contractVersion == null ? 43 : $contractVersion.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $applicationDate = this.getApplicationDate();
      result = result * 59 + ($applicationDate == null ? 43 : $applicationDate.hashCode());
      Object $lastEditTime = this.getLastEditTime();
      result = result * 59 + ($lastEditTime == null ? 43 : $lastEditTime.hashCode());
      Object $lastEditUserName = this.getLastEditUserName();
      result = result * 59 + ($lastEditUserName == null ? 43 : $lastEditUserName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ContractCatalogueBuilder {
      private Long id;
      private String contractNumber;
      private LocalDateTime registerDate;
      private LocalDateTime transferDate;
      private Boolean signStatus;
      private LocalDateTime signDate;
      private Integer issueTime;
      private String partyA;
      private String projectName;
      private BigDecimal contractAmount;
      private BigDecimal originalContractAmount;
      private Long signerId;
      private String signerName;
      private Long firstLevelDept;
      private Long secondLevelDept;
      private Integer infoSource;
      private Boolean boolCoordinate;
      private String projectManager;
      private Long structureType;
      private BigDecimal structureArea;
      private BigDecimal mainStructureSteelMete;
      private BigDecimal subfabricSteelMete;
      private BigDecimal maximumSpan;
      private Long locationId;
      private Long countryId;
      private Long provinceId;
      private Long cityId;
      private Long regionId;
      private String address;
      private LocalDateTime contractStartDate;
      private LocalDateTime contractEndDate;
      private Long contractualNature;
      private Long biddingMethod;
      private Long partyType;
      private Long contractType;
      private Boolean boolFabricatedStructure;
      private Boolean boolModelContract;
      private String attachments;
      private Long preRegistrationId;
      private Long registrationId;
      private Integer createSource;
      private String contractVersion;
      private Long applicantId;
      private String applicantName;
      private Long applicantDeptId;
      private LocalDateTime applicationDate;
      private LocalDateTime lastEditTime;
      private Long lastEditUserId;
      private String lastEditUserName;
      private Long initDataId;
      private Boolean boolSupplement;
      private Long parentId;
      private String remark;
      private Integer reviewStatus;

      ContractCatalogueBuilder() {
      }

      @JsonProperty("id")
      public ContractCatalogue.ContractCatalogueBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("contractNumber")
      public ContractCatalogue.ContractCatalogueBuilder contractNumber(final String contractNumber) {
         this.contractNumber = contractNumber;
         return this;
      }

      @JsonProperty("registerDate")
      public ContractCatalogue.ContractCatalogueBuilder registerDate(final LocalDateTime registerDate) {
         this.registerDate = registerDate;
         return this;
      }

      @JsonProperty("transferDate")
      public ContractCatalogue.ContractCatalogueBuilder transferDate(final LocalDateTime transferDate) {
         this.transferDate = transferDate;
         return this;
      }

      @JsonProperty("signStatus")
      public ContractCatalogue.ContractCatalogueBuilder signStatus(final Boolean signStatus) {
         this.signStatus = signStatus;
         return this;
      }

      @JsonProperty("signDate")
      public ContractCatalogue.ContractCatalogueBuilder signDate(final LocalDateTime signDate) {
         this.signDate = signDate;
         return this;
      }

      @JsonProperty("issueTime")
      public ContractCatalogue.ContractCatalogueBuilder issueTime(final Integer issueTime) {
         this.issueTime = issueTime;
         return this;
      }

      @JsonProperty("partyA")
      public ContractCatalogue.ContractCatalogueBuilder partyA(final String partyA) {
         this.partyA = partyA;
         return this;
      }

      @JsonProperty("projectName")
      public ContractCatalogue.ContractCatalogueBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("contractAmount")
      public ContractCatalogue.ContractCatalogueBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      @JsonProperty("originalContractAmount")
      public ContractCatalogue.ContractCatalogueBuilder originalContractAmount(final BigDecimal originalContractAmount) {
         this.originalContractAmount = originalContractAmount;
         return this;
      }

      @JsonProperty("signerId")
      public ContractCatalogue.ContractCatalogueBuilder signerId(final Long signerId) {
         this.signerId = signerId;
         return this;
      }

      @JsonProperty("signerName")
      public ContractCatalogue.ContractCatalogueBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      @JsonProperty("firstLevelDept")
      public ContractCatalogue.ContractCatalogueBuilder firstLevelDept(final Long firstLevelDept) {
         this.firstLevelDept = firstLevelDept;
         return this;
      }

      @JsonProperty("secondLevelDept")
      public ContractCatalogue.ContractCatalogueBuilder secondLevelDept(final Long secondLevelDept) {
         this.secondLevelDept = secondLevelDept;
         return this;
      }

      @JsonProperty("infoSource")
      public ContractCatalogue.ContractCatalogueBuilder infoSource(final Integer infoSource) {
         this.infoSource = infoSource;
         return this;
      }

      @JsonProperty("boolCoordinate")
      public ContractCatalogue.ContractCatalogueBuilder boolCoordinate(final Boolean boolCoordinate) {
         this.boolCoordinate = boolCoordinate;
         return this;
      }

      @JsonProperty("projectManager")
      public ContractCatalogue.ContractCatalogueBuilder projectManager(final String projectManager) {
         this.projectManager = projectManager;
         return this;
      }

      @JsonProperty("structureType")
      public ContractCatalogue.ContractCatalogueBuilder structureType(final Long structureType) {
         this.structureType = structureType;
         return this;
      }

      @JsonProperty("structureArea")
      public ContractCatalogue.ContractCatalogueBuilder structureArea(final BigDecimal structureArea) {
         this.structureArea = structureArea;
         return this;
      }

      @JsonProperty("mainStructureSteelMete")
      public ContractCatalogue.ContractCatalogueBuilder mainStructureSteelMete(final BigDecimal mainStructureSteelMete) {
         this.mainStructureSteelMete = mainStructureSteelMete;
         return this;
      }

      @JsonProperty("subfabricSteelMete")
      public ContractCatalogue.ContractCatalogueBuilder subfabricSteelMete(final BigDecimal subfabricSteelMete) {
         this.subfabricSteelMete = subfabricSteelMete;
         return this;
      }

      @JsonProperty("maximumSpan")
      public ContractCatalogue.ContractCatalogueBuilder maximumSpan(final BigDecimal maximumSpan) {
         this.maximumSpan = maximumSpan;
         return this;
      }

      @JsonProperty("locationId")
      public ContractCatalogue.ContractCatalogueBuilder locationId(final Long locationId) {
         this.locationId = locationId;
         return this;
      }

      @JsonProperty("countryId")
      public ContractCatalogue.ContractCatalogueBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      @JsonProperty("provinceId")
      public ContractCatalogue.ContractCatalogueBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      @JsonProperty("cityId")
      public ContractCatalogue.ContractCatalogueBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      @JsonProperty("regionId")
      public ContractCatalogue.ContractCatalogueBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      @JsonProperty("address")
      public ContractCatalogue.ContractCatalogueBuilder address(final String address) {
         this.address = address;
         return this;
      }

      @JsonProperty("contractStartDate")
      public ContractCatalogue.ContractCatalogueBuilder contractStartDate(final LocalDateTime contractStartDate) {
         this.contractStartDate = contractStartDate;
         return this;
      }

      @JsonProperty("contractEndDate")
      public ContractCatalogue.ContractCatalogueBuilder contractEndDate(final LocalDateTime contractEndDate) {
         this.contractEndDate = contractEndDate;
         return this;
      }

      @JsonProperty("contractualNature")
      public ContractCatalogue.ContractCatalogueBuilder contractualNature(final Long contractualNature) {
         this.contractualNature = contractualNature;
         return this;
      }

      @JsonProperty("biddingMethod")
      public ContractCatalogue.ContractCatalogueBuilder biddingMethod(final Long biddingMethod) {
         this.biddingMethod = biddingMethod;
         return this;
      }

      @JsonProperty("partyType")
      public ContractCatalogue.ContractCatalogueBuilder partyType(final Long partyType) {
         this.partyType = partyType;
         return this;
      }

      @JsonProperty("contractType")
      public ContractCatalogue.ContractCatalogueBuilder contractType(final Long contractType) {
         this.contractType = contractType;
         return this;
      }

      @JsonProperty("boolFabricatedStructure")
      public ContractCatalogue.ContractCatalogueBuilder boolFabricatedStructure(final Boolean boolFabricatedStructure) {
         this.boolFabricatedStructure = boolFabricatedStructure;
         return this;
      }

      @JsonProperty("boolModelContract")
      public ContractCatalogue.ContractCatalogueBuilder boolModelContract(final Boolean boolModelContract) {
         this.boolModelContract = boolModelContract;
         return this;
      }

      @JsonProperty("attachments")
      public ContractCatalogue.ContractCatalogueBuilder attachments(final String attachments) {
         this.attachments = attachments;
         return this;
      }

      @JsonProperty("preRegistrationId")
      public ContractCatalogue.ContractCatalogueBuilder preRegistrationId(final Long preRegistrationId) {
         this.preRegistrationId = preRegistrationId;
         return this;
      }

      @JsonProperty("registrationId")
      public ContractCatalogue.ContractCatalogueBuilder registrationId(final Long registrationId) {
         this.registrationId = registrationId;
         return this;
      }

      @JsonProperty("createSource")
      public ContractCatalogue.ContractCatalogueBuilder createSource(final Integer createSource) {
         this.createSource = createSource;
         return this;
      }

      @JsonProperty("contractVersion")
      public ContractCatalogue.ContractCatalogueBuilder contractVersion(final String contractVersion) {
         this.contractVersion = contractVersion;
         return this;
      }

      @JsonProperty("applicantId")
      public ContractCatalogue.ContractCatalogueBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public ContractCatalogue.ContractCatalogueBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("applicantDeptId")
      public ContractCatalogue.ContractCatalogueBuilder applicantDeptId(final Long applicantDeptId) {
         this.applicantDeptId = applicantDeptId;
         return this;
      }

      @JsonProperty("applicationDate")
      public ContractCatalogue.ContractCatalogueBuilder applicationDate(final LocalDateTime applicationDate) {
         this.applicationDate = applicationDate;
         return this;
      }

      @JsonProperty("lastEditTime")
      public ContractCatalogue.ContractCatalogueBuilder lastEditTime(final LocalDateTime lastEditTime) {
         this.lastEditTime = lastEditTime;
         return this;
      }

      @JsonProperty("lastEditUserId")
      public ContractCatalogue.ContractCatalogueBuilder lastEditUserId(final Long lastEditUserId) {
         this.lastEditUserId = lastEditUserId;
         return this;
      }

      @JsonProperty("lastEditUserName")
      public ContractCatalogue.ContractCatalogueBuilder lastEditUserName(final String lastEditUserName) {
         this.lastEditUserName = lastEditUserName;
         return this;
      }

      @JsonProperty("initDataId")
      public ContractCatalogue.ContractCatalogueBuilder initDataId(final Long initDataId) {
         this.initDataId = initDataId;
         return this;
      }

      @JsonProperty("boolSupplement")
      public ContractCatalogue.ContractCatalogueBuilder boolSupplement(final Boolean boolSupplement) {
         this.boolSupplement = boolSupplement;
         return this;
      }

      @JsonProperty("parentId")
      public ContractCatalogue.ContractCatalogueBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      @JsonProperty("remark")
      public ContractCatalogue.ContractCatalogueBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("reviewStatus")
      public ContractCatalogue.ContractCatalogueBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ContractCatalogue build() {
         return new ContractCatalogue(
            this.id,
            this.contractNumber,
            this.registerDate,
            this.transferDate,
            this.signStatus,
            this.signDate,
            this.issueTime,
            this.partyA,
            this.projectName,
            this.contractAmount,
            this.originalContractAmount,
            this.signerId,
            this.signerName,
            this.firstLevelDept,
            this.secondLevelDept,
            this.infoSource,
            this.boolCoordinate,
            this.projectManager,
            this.structureType,
            this.structureArea,
            this.mainStructureSteelMete,
            this.subfabricSteelMete,
            this.maximumSpan,
            this.locationId,
            this.countryId,
            this.provinceId,
            this.cityId,
            this.regionId,
            this.address,
            this.contractStartDate,
            this.contractEndDate,
            this.contractualNature,
            this.biddingMethod,
            this.partyType,
            this.contractType,
            this.boolFabricatedStructure,
            this.boolModelContract,
            this.attachments,
            this.preRegistrationId,
            this.registrationId,
            this.createSource,
            this.contractVersion,
            this.applicantId,
            this.applicantName,
            this.applicantDeptId,
            this.applicationDate,
            this.lastEditTime,
            this.lastEditUserId,
            this.lastEditUserName,
            this.initDataId,
            this.boolSupplement,
            this.parentId,
            this.remark,
            this.reviewStatus
         );
      }

      @Override
      public String toString() {
         return "ContractCatalogue.ContractCatalogueBuilder(id="
            + this.id
            + ", contractNumber="
            + this.contractNumber
            + ", registerDate="
            + this.registerDate
            + ", transferDate="
            + this.transferDate
            + ", signStatus="
            + this.signStatus
            + ", signDate="
            + this.signDate
            + ", issueTime="
            + this.issueTime
            + ", partyA="
            + this.partyA
            + ", projectName="
            + this.projectName
            + ", contractAmount="
            + this.contractAmount
            + ", originalContractAmount="
            + this.originalContractAmount
            + ", signerId="
            + this.signerId
            + ", signerName="
            + this.signerName
            + ", firstLevelDept="
            + this.firstLevelDept
            + ", secondLevelDept="
            + this.secondLevelDept
            + ", infoSource="
            + this.infoSource
            + ", boolCoordinate="
            + this.boolCoordinate
            + ", projectManager="
            + this.projectManager
            + ", structureType="
            + this.structureType
            + ", structureArea="
            + this.structureArea
            + ", mainStructureSteelMete="
            + this.mainStructureSteelMete
            + ", subfabricSteelMete="
            + this.subfabricSteelMete
            + ", maximumSpan="
            + this.maximumSpan
            + ", locationId="
            + this.locationId
            + ", countryId="
            + this.countryId
            + ", provinceId="
            + this.provinceId
            + ", cityId="
            + this.cityId
            + ", regionId="
            + this.regionId
            + ", address="
            + this.address
            + ", contractStartDate="
            + this.contractStartDate
            + ", contractEndDate="
            + this.contractEndDate
            + ", contractualNature="
            + this.contractualNature
            + ", biddingMethod="
            + this.biddingMethod
            + ", partyType="
            + this.partyType
            + ", contractType="
            + this.contractType
            + ", boolFabricatedStructure="
            + this.boolFabricatedStructure
            + ", boolModelContract="
            + this.boolModelContract
            + ", attachments="
            + this.attachments
            + ", preRegistrationId="
            + this.preRegistrationId
            + ", registrationId="
            + this.registrationId
            + ", createSource="
            + this.createSource
            + ", contractVersion="
            + this.contractVersion
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", applicantDeptId="
            + this.applicantDeptId
            + ", applicationDate="
            + this.applicationDate
            + ", lastEditTime="
            + this.lastEditTime
            + ", lastEditUserId="
            + this.lastEditUserId
            + ", lastEditUserName="
            + this.lastEditUserName
            + ", initDataId="
            + this.initDataId
            + ", boolSupplement="
            + this.boolSupplement
            + ", parentId="
            + this.parentId
            + ", remark="
            + this.remark
            + ", reviewStatus="
            + this.reviewStatus
            + ")";
      }
   }
}
