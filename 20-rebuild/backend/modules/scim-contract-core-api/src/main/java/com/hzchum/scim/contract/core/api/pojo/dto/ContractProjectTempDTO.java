package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectContentDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.MeasureModeDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.PressureBearingPlateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ProfiledPlateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.SandwichBoardDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.TrussFloorPlateDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApiModel("项目变更临时信息响应类")
public class ContractProjectTempDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "changeId", value = "变更表id")
   private Long changeId;
   @ApiModelProperty(name = "serial_number", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "项目名称")
   private String name;
   @ApiModelProperty(name = "shortName", value = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "startDate", value = "约定开工日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "约定完工时期")
   private LocalDate endDate;
   @ApiModelProperty(name = "address", value = "项目详细地址")
   private String address;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理id")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerName", value = "项目经理名称")
   private String projectManagerName;
   @ApiModelProperty(name = "projectManagerPhone", value = "项目经理电话")
   private String projectManagerPhone;
   @ApiModelProperty(name = "businessLeaderId", value = "业务负责人1")
   private Long businessLeaderId;
   @ApiModelProperty(name = "businessLeaderTwoId", value = "业务负责人2")
   private Long businessLeaderTwoId;
   @ApiModelProperty(name = "orderSourceType", value = "项目订单来源类型 1内部 2外部 枚举:OrderSourceTypeEnum")
   private Integer orderSourceType;
   @ApiModelProperty("附件列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "countryId")
   private Long countryId;
   @ApiModelProperty(name = "countryName")
   private String countryName;
   @ApiModelProperty(name = "provinceId")
   private Long provinceId;
   @ApiModelProperty(name = "provinceName")
   private String provinceName;
   @ApiModelProperty(name = "cityId")
   private Long cityId;
   @ApiModelProperty(name = "cityName")
   private String cityName;
   @ApiModelProperty(name = "regionId", value = "区ID")
   private Long regionId;
   @ApiModelProperty(name = "regionName", value = "区名称")
   private String regionName;
   @ApiModelProperty(name = "regionalFullName", value = "省市区信息")
   private String regionalFullName;
   @ApiModelProperty(name = "contractAmount", value = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "prepayments", value = "预付款（元）")
   private BigDecimal prepayments;
   @ApiModelProperty(name = "managementFeeRate", value = "管理费率（%）")
   private BigDecimal managementFeeRate;
   @ApiModelProperty(name = "marginAmount", value = "保证金（元）")
   private BigDecimal marginAmount;
   @ApiModelProperty(name = "marginType", value = "保证金类型 1.现金 2保函")
   private String marginType;
   @ApiModelProperty(name = "currencyType", value = "合同币种类型 (暂时先固定几种) RMB,EUR,USD,JPY")
   private String currencyType;
   @ApiModelProperty(name = "qualityGuaranteeDeposit", notes = "质保金(%)")
   private BigDecimal qualityGuaranteeDeposit;
   @ApiModelProperty(name = "settlementStatus", value = "结算状态 0 未结算 1结算中 2已结算")
   private Integer settlementStatus;
   @ApiModelProperty(name = "settlementAmount", value = "已结算金额(元)")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "contractSignBodyId", value = "合同签订主体id(公司id,单位...)")
   private Long contractSignBodyId;
   @ApiModelProperty(name = "contractSignBodyName", value = "合同签订主体名称")
   private String contractSignBodyName;
   @ApiModelProperty(name = "businessType", value = "业务类型 1.加工承揽  2.项目承包")
   private Integer businessType;
   @ApiModelProperty(name = "projectType", value = "项目类型   1建筑钢结构 2桥梁钢结构  3立体停车库  4围护材料")
   private Integer projectType;
   @ApiModelProperty(name = "projectContent", value = "项目内容")
   private String projectContent;
   @ApiModelProperty(name = "projectContentList", notes = "项目内容列表")
   private List<ProjectContentDTO> projectContentList;
   @ApiModelProperty(name = "transportMode", notes = "运输方式 1运送到场 2客户自提")
   private Integer transportMode;
   @ApiModelProperty(name = "enclosureTransportMode", notes = "围护运输方式 1运送到场 2客户自提")
   private Integer enclosureTransportMode;
   @ApiModelProperty(name = "structureMeasureMode", notes = "结构计量方式  1理论计算 2磅记")
   private Integer structureMeasureMode;
   @ApiModelProperty(name = "enclosureMeasureMode", notes = "围护计量方式 1 长度计量 2 面积计量")
   private Integer enclosureMeasureMode;
   @ApiModelProperty(name = "enclosureMeasureModeList", notes = "围护计量方式列表 1 长度计量 2 面积计量")
   private List<MeasureModeDTOParam> measureModeList;
   @ApiModelProperty(name = "signingAddress", value = "签约地址")
   private String signingAddress;
   @ApiModelProperty(name = "signingDate", value = "签订日期")
   private LocalDate signingDate;
   @ApiModelProperty(name = "signerId", value = "签约人id")
   private Long signerId;
   @ApiModelProperty(name = "signerName", value = "签约人名字")
   private String signerName;
   @ApiModelProperty(name = "signerPhone", value = "签约人电话")
   private String signerPhone;
   @ApiModelProperty(name = "isTax", value = "合同额是否含税 1是 0否")
   private Integer isTax;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1 增值税专用发票  2普通发票 4收据")
   private Integer invoiceType;
   @ApiModelProperty(name = "tax_rate", notes = "发票税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "payType", value = "支付方式 1.对公转账 2对私转账 4承兑汇票 8转账支票")
   private Integer payType;
   @ApiModelProperty(name = "payTypeDesc", value = "支付方式描述")
   private String payTypeDesc;
   @ApiModelProperty(name = "customerUnit", value = "客户单位名称")
   private String customerUnit;
   @ApiModelProperty(name = "socialCode", value = "客户统一社会信用代码")
   private String socialCode;
   @ApiModelProperty(name = "customerUnitPhone", value = "客户单位电话")
   private String customerUnitPhone;
   @ApiModelProperty(name = "customerEmail", value = "客户邮箱")
   private String customerEmail;
   @ApiModelProperty(name = "userId", value = "创建项目的用户id")
   private Long userId;
   @ApiModelProperty(name = "customerProvinceId", value = "客户省id")
   private Long customerProvinceId;
   @ApiModelProperty(name = "customerProvinceName", value = "客户省名称")
   private String customerProvinceName;
   @ApiModelProperty(name = "customerCityId", value = "客户单位城市id")
   private Long customerCityId;
   @ApiModelProperty(name = "customerCityName", value = "客户单位名称")
   private String customerCityName;
   @ApiModelProperty(name = "customerRegionId", value = "客户单位区ID")
   private Long customerRegionId;
   @ApiModelProperty(name = "customerRegionName", value = "客户单位区名称")
   private String customerRegionName;
   @ApiModelProperty(name = "customerCountryId", value = "客户单位国家id")
   private Long customerCountryId;
   @ApiModelProperty(name = "customerCountryName", value = "客户单位国家名称")
   private String customerCountryName;
   @ApiModelProperty(name = "customerAddress", value = "客户单位详细地址")
   private String customerAddress;
   @ApiModelProperty(name = "customerBankUserName", value = "银行账户户名")
   private String customerBankUserName;
   @ApiModelProperty(name = "customerBankCode", value = "银行账户账号")
   private String customerBankCode;
   @ApiModelProperty(name = "customerBankName", value = "开户行   (中国工商银行...)")
   private String customerBankName;
   @ApiModelProperty(name = "customerManagerOne", value = "客户负责人1姓名")
   private String customerManagerOne;
   @ApiModelProperty(name = "customerManagerOnePhone", value = "客户负责人1电话")
   private String customerManagerOnePhone;
   @ApiModelProperty(name = "customerManagerTwo", value = "客户负责人2姓名")
   private String customerManagerTwo;
   @ApiModelProperty(name = "customerManagerTwoPhone", value = "客户负责人2电话")
   private String customerManagerTwoPhone;
   @ApiModelProperty(name = "receivingManager", notes = "收货负责人")
   private String receivingManager;
   @ApiModelProperty(name = "receivingManagerPhone", notes = "收货负责人电话")
   private String receivingManagerPhone;
   @ApiModelProperty(name = "settleManager", notes = "结算负责人")
   private String settleManager;
   @ApiModelProperty(name = "settleManagerPhone", notes = "结算负责人电话")
   private String settleManagerPhone;
   @ApiModelProperty(name = "financeManager", notes = "财务负责人")
   private String financeManager;
   @ApiModelProperty(name = "financeManagerPhone", notes = "财务负责人电话")
   private String financeManagerPhone;
   @ApiModelProperty(name = "auditManager", notes = "审核负责人")
   private String auditManager;
   @ApiModelProperty(name = "auditManagerPhone", notes = "审核负责人电话")
   private String auditManagerPhone;
   @ApiModelProperty(name = "designManager", notes = "设计负责人")
   private String designManager;
   @ApiModelProperty(name = "designManagerPhone", notes = "设计负责人电话")
   private String designManagerPhone;
   @ApiModelProperty(name = "relationUserIds", value = "项目关联用户id字符串")
   private String relationUserIds;
   @ApiModelProperty(name = "relationUserList", value = "项目关联用户列表")
   private List<NameInfo> relationUserList;
   @ApiModelProperty(name = "structureList", value = "结构列表")
   private List<StructureTypeDTO> structureList;
   @ApiModelProperty(name = "profiledPlateList", value = "压型(彩)板列表")
   private List<ProfiledPlateDTOParam> profiledPlateList;
   @ApiModelProperty(name = "sandwichBoardList", value = "夹芯板列表")
   private List<SandwichBoardDTOParam> sandwichBoardList;
   @ApiModelProperty(name = "trussFloorPlateList", value = "桁架楼承板列表")
   private List<TrussFloorPlateDTOParam> trussFloorPlateList;
   @ApiModelProperty(name = "pressureBearingPlateList", value = "压型楼承板列表")
   private List<PressureBearingPlateDTOParam> pressureBearingPlateList;
   @ApiModelProperty(name = "technologyRemark", value = "技术要求描述")
   private String technologyRemark;
   @ApiModelProperty(name = "structureStatus", value = "结构类型")
   private Integer structureStatus;
   @ApiModelProperty(name = "structureTypeId", value = "结构类型id")
   private Long structureTypeId;
   @ApiModelProperty(name = "structureTypeName", value = "结构类型名称")
   private String structureTypeName;
   @ApiModelProperty(name = "quantityWork", value = "工程量")
   private BigDecimal quantityWork;
   @ApiModelProperty(name = "customerRemark", notes = "客户信息备注")
   private String customerRemark;

   public static ContractProjectTempDTO.ContractProjectTempDTOBuilder builder() {
      return new ContractProjectTempDTO.ContractProjectTempDTOBuilder();
   }

   public ContractProjectTempDTO() {
   }

   public ContractProjectTempDTO(
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
      final Integer orderSourceType,
      final List<AttachmentDTO> attachments,
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final String regionName,
      final String regionalFullName,
      final BigDecimal contractAmount,
      final BigDecimal prepayments,
      final BigDecimal managementFeeRate,
      final BigDecimal marginAmount,
      final String marginType,
      final String currencyType,
      final BigDecimal qualityGuaranteeDeposit,
      final Integer settlementStatus,
      final BigDecimal settlementAmount,
      final Long contractSignBodyId,
      final String contractSignBodyName,
      final Integer businessType,
      final Integer projectType,
      final String projectContent,
      final List<ProjectContentDTO> projectContentList,
      final Integer transportMode,
      final Integer enclosureTransportMode,
      final Integer structureMeasureMode,
      final Integer enclosureMeasureMode,
      final List<MeasureModeDTOParam> measureModeList,
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
      final List<NameInfo> relationUserList,
      final List<StructureTypeDTO> structureList,
      final List<ProfiledPlateDTOParam> profiledPlateList,
      final List<SandwichBoardDTOParam> sandwichBoardList,
      final List<TrussFloorPlateDTOParam> trussFloorPlateList,
      final List<PressureBearingPlateDTOParam> pressureBearingPlateList,
      final String technologyRemark,
      final Integer structureStatus,
      final Long structureTypeId,
      final String structureTypeName,
      final BigDecimal quantityWork,
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
      this.orderSourceType = orderSourceType;
      this.attachments = attachments;
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.regionalFullName = regionalFullName;
      this.contractAmount = contractAmount;
      this.prepayments = prepayments;
      this.managementFeeRate = managementFeeRate;
      this.marginAmount = marginAmount;
      this.marginType = marginType;
      this.currencyType = currencyType;
      this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
      this.settlementStatus = settlementStatus;
      this.settlementAmount = settlementAmount;
      this.contractSignBodyId = contractSignBodyId;
      this.contractSignBodyName = contractSignBodyName;
      this.businessType = businessType;
      this.projectType = projectType;
      this.projectContent = projectContent;
      this.projectContentList = projectContentList;
      this.transportMode = transportMode;
      this.enclosureTransportMode = enclosureTransportMode;
      this.structureMeasureMode = structureMeasureMode;
      this.enclosureMeasureMode = enclosureMeasureMode;
      this.measureModeList = measureModeList;
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
      this.relationUserList = relationUserList;
      this.structureList = structureList;
      this.profiledPlateList = profiledPlateList;
      this.sandwichBoardList = sandwichBoardList;
      this.trussFloorPlateList = trussFloorPlateList;
      this.pressureBearingPlateList = pressureBearingPlateList;
      this.technologyRemark = technologyRemark;
      this.structureStatus = structureStatus;
      this.structureTypeId = structureTypeId;
      this.structureTypeName = structureTypeName;
      this.quantityWork = quantityWork;
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

   public Integer getOrderSourceType() {
      return this.orderSourceType;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
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

   public String getRegionalFullName() {
      return this.regionalFullName;
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

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public String getContractSignBodyName() {
      return this.contractSignBodyName;
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

   public List<ProjectContentDTO> getProjectContentList() {
      return this.projectContentList;
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

   public List<MeasureModeDTOParam> getMeasureModeList() {
      return this.measureModeList;
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

   public List<NameInfo> getRelationUserList() {
      return this.relationUserList;
   }

   public List<StructureTypeDTO> getStructureList() {
      return this.structureList;
   }

   public List<ProfiledPlateDTOParam> getProfiledPlateList() {
      return this.profiledPlateList;
   }

   public List<SandwichBoardDTOParam> getSandwichBoardList() {
      return this.sandwichBoardList;
   }

   public List<TrussFloorPlateDTOParam> getTrussFloorPlateList() {
      return this.trussFloorPlateList;
   }

   public List<PressureBearingPlateDTOParam> getPressureBearingPlateList() {
      return this.pressureBearingPlateList;
   }

   public String getTechnologyRemark() {
      return this.technologyRemark;
   }

   public Integer getStructureStatus() {
      return this.structureStatus;
   }

   public Long getStructureTypeId() {
      return this.structureTypeId;
   }

   public String getStructureTypeName() {
      return this.structureTypeName;
   }

   public BigDecimal getQuantityWork() {
      return this.quantityWork;
   }

   public String getCustomerRemark() {
      return this.customerRemark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setChangeId(final Long changeId) {
      this.changeId = changeId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setAddress(final String address) {
      this.address = address;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setProjectManagerPhone(final String projectManagerPhone) {
      this.projectManagerPhone = projectManagerPhone;
   }

   public void setBusinessLeaderId(final Long businessLeaderId) {
      this.businessLeaderId = businessLeaderId;
   }

   public void setBusinessLeaderTwoId(final Long businessLeaderTwoId) {
      this.businessLeaderTwoId = businessLeaderTwoId;
   }

   public void setOrderSourceType(final Integer orderSourceType) {
      this.orderSourceType = orderSourceType;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setCountryId(final Long countryId) {
      this.countryId = countryId;
   }

   public void setCountryName(final String countryName) {
      this.countryName = countryName;
   }

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
   }

   public void setCityId(final Long cityId) {
      this.cityId = cityId;
   }

   public void setCityName(final String cityName) {
      this.cityName = cityName;
   }

   public void setRegionId(final Long regionId) {
      this.regionId = regionId;
   }

   public void setRegionName(final String regionName) {
      this.regionName = regionName;
   }

   public void setRegionalFullName(final String regionalFullName) {
      this.regionalFullName = regionalFullName;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setPrepayments(final BigDecimal prepayments) {
      this.prepayments = prepayments;
   }

   public void setManagementFeeRate(final BigDecimal managementFeeRate) {
      this.managementFeeRate = managementFeeRate;
   }

   public void setMarginAmount(final BigDecimal marginAmount) {
      this.marginAmount = marginAmount;
   }

   public void setMarginType(final String marginType) {
      this.marginType = marginType;
   }

   public void setCurrencyType(final String currencyType) {
      this.currencyType = currencyType;
   }

   public void setQualityGuaranteeDeposit(final BigDecimal qualityGuaranteeDeposit) {
      this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setContractSignBodyName(final String contractSignBodyName) {
      this.contractSignBodyName = contractSignBodyName;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setProjectContent(final String projectContent) {
      this.projectContent = projectContent;
   }

   public void setProjectContentList(final List<ProjectContentDTO> projectContentList) {
      this.projectContentList = projectContentList;
   }

   public void setTransportMode(final Integer transportMode) {
      this.transportMode = transportMode;
   }

   public void setEnclosureTransportMode(final Integer enclosureTransportMode) {
      this.enclosureTransportMode = enclosureTransportMode;
   }

   public void setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
   }

   public void setEnclosureMeasureMode(final Integer enclosureMeasureMode) {
      this.enclosureMeasureMode = enclosureMeasureMode;
   }

   public void setMeasureModeList(final List<MeasureModeDTOParam> measureModeList) {
      this.measureModeList = measureModeList;
   }

   public void setSigningAddress(final String signingAddress) {
      this.signingAddress = signingAddress;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
   }

   public void setSignerId(final Long signerId) {
      this.signerId = signerId;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setSignerPhone(final String signerPhone) {
      this.signerPhone = signerPhone;
   }

   public void setIsTax(final Integer isTax) {
      this.isTax = isTax;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setPayType(final Integer payType) {
      this.payType = payType;
   }

   public void setPayTypeDesc(final String payTypeDesc) {
      this.payTypeDesc = payTypeDesc;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
   }

   public void setCustomerUnitPhone(final String customerUnitPhone) {
      this.customerUnitPhone = customerUnitPhone;
   }

   public void setCustomerEmail(final String customerEmail) {
      this.customerEmail = customerEmail;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setCustomerProvinceId(final Long customerProvinceId) {
      this.customerProvinceId = customerProvinceId;
   }

   public void setCustomerProvinceName(final String customerProvinceName) {
      this.customerProvinceName = customerProvinceName;
   }

   public void setCustomerCityId(final Long customerCityId) {
      this.customerCityId = customerCityId;
   }

   public void setCustomerCityName(final String customerCityName) {
      this.customerCityName = customerCityName;
   }

   public void setCustomerRegionId(final Long customerRegionId) {
      this.customerRegionId = customerRegionId;
   }

   public void setCustomerRegionName(final String customerRegionName) {
      this.customerRegionName = customerRegionName;
   }

   public void setCustomerCountryId(final Long customerCountryId) {
      this.customerCountryId = customerCountryId;
   }

   public void setCustomerCountryName(final String customerCountryName) {
      this.customerCountryName = customerCountryName;
   }

   public void setCustomerAddress(final String customerAddress) {
      this.customerAddress = customerAddress;
   }

   public void setCustomerBankUserName(final String customerBankUserName) {
      this.customerBankUserName = customerBankUserName;
   }

   public void setCustomerBankCode(final String customerBankCode) {
      this.customerBankCode = customerBankCode;
   }

   public void setCustomerBankName(final String customerBankName) {
      this.customerBankName = customerBankName;
   }

   public void setCustomerManagerOne(final String customerManagerOne) {
      this.customerManagerOne = customerManagerOne;
   }

   public void setCustomerManagerOnePhone(final String customerManagerOnePhone) {
      this.customerManagerOnePhone = customerManagerOnePhone;
   }

   public void setCustomerManagerTwo(final String customerManagerTwo) {
      this.customerManagerTwo = customerManagerTwo;
   }

   public void setCustomerManagerTwoPhone(final String customerManagerTwoPhone) {
      this.customerManagerTwoPhone = customerManagerTwoPhone;
   }

   public void setReceivingManager(final String receivingManager) {
      this.receivingManager = receivingManager;
   }

   public void setReceivingManagerPhone(final String receivingManagerPhone) {
      this.receivingManagerPhone = receivingManagerPhone;
   }

   public void setSettleManager(final String settleManager) {
      this.settleManager = settleManager;
   }

   public void setSettleManagerPhone(final String settleManagerPhone) {
      this.settleManagerPhone = settleManagerPhone;
   }

   public void setFinanceManager(final String financeManager) {
      this.financeManager = financeManager;
   }

   public void setFinanceManagerPhone(final String financeManagerPhone) {
      this.financeManagerPhone = financeManagerPhone;
   }

   public void setAuditManager(final String auditManager) {
      this.auditManager = auditManager;
   }

   public void setAuditManagerPhone(final String auditManagerPhone) {
      this.auditManagerPhone = auditManagerPhone;
   }

   public void setDesignManager(final String designManager) {
      this.designManager = designManager;
   }

   public void setDesignManagerPhone(final String designManagerPhone) {
      this.designManagerPhone = designManagerPhone;
   }

   public void setRelationUserIds(final String relationUserIds) {
      this.relationUserIds = relationUserIds;
   }

   public void setRelationUserList(final List<NameInfo> relationUserList) {
      this.relationUserList = relationUserList;
   }

   public void setStructureList(final List<StructureTypeDTO> structureList) {
      this.structureList = structureList;
   }

   public void setProfiledPlateList(final List<ProfiledPlateDTOParam> profiledPlateList) {
      this.profiledPlateList = profiledPlateList;
   }

   public void setSandwichBoardList(final List<SandwichBoardDTOParam> sandwichBoardList) {
      this.sandwichBoardList = sandwichBoardList;
   }

   public void setTrussFloorPlateList(final List<TrussFloorPlateDTOParam> trussFloorPlateList) {
      this.trussFloorPlateList = trussFloorPlateList;
   }

   public void setPressureBearingPlateList(final List<PressureBearingPlateDTOParam> pressureBearingPlateList) {
      this.pressureBearingPlateList = pressureBearingPlateList;
   }

   public void setTechnologyRemark(final String technologyRemark) {
      this.technologyRemark = technologyRemark;
   }

   public void setStructureStatus(final Integer structureStatus) {
      this.structureStatus = structureStatus;
   }

   public void setStructureTypeId(final Long structureTypeId) {
      this.structureTypeId = structureTypeId;
   }

   public void setStructureTypeName(final String structureTypeName) {
      this.structureTypeName = structureTypeName;
   }

   public void setQuantityWork(final BigDecimal quantityWork) {
      this.quantityWork = quantityWork;
   }

   public void setCustomerRemark(final String customerRemark) {
      this.customerRemark = customerRemark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectTempDTO)) {
         return false;
      }

      ContractProjectTempDTO other = (ContractProjectTempDTO)o;
      if (!other.canEqual(this)) {
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
                        Object this$orderSourceType = this.getOrderSourceType();
                        Object other$orderSourceType = other.getOrderSourceType();
                        if (this$orderSourceType == null ? other$orderSourceType == null : this$orderSourceType.equals(other$orderSourceType)) {
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
                                       Object this$settlementStatus = this.getSettlementStatus();
                                       Object other$settlementStatus = other.getSettlementStatus();
                                       if (this$settlementStatus == null
                                          ? other$settlementStatus == null
                                          : this$settlementStatus.equals(other$settlementStatus)) {
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
                                                                                                                           Object this$countryName = this.getCountryName();
                                                                                                                           Object other$countryName = other.getCountryName();
                                                                                                                           if (this$countryName == null
                                                                                                                              ? other$countryName == null
                                                                                                                              : this$countryName.equals(
                                                                                                                                 other$countryName
                                                                                                                              )) {
                                                                                                                              Object this$provinceName = this.getProvinceName();
                                                                                                                              Object other$provinceName = other.getProvinceName();
                                                                                                                              if (this$provinceName == null
                                                                                                                                 ? other$provinceName == null
                                                                                                                                 : this$provinceName.equals(
                                                                                                                                    other$provinceName
                                                                                                                                 )) {
                                                                                                                                 Object this$cityName = this.getCityName();
                                                                                                                                 Object other$cityName = other.getCityName();
                                                                                                                                 if (this$cityName == null
                                                                                                                                    ? other$cityName == null
                                                                                                                                    : this$cityName.equals(
                                                                                                                                       other$cityName
                                                                                                                                    )) {
                                                                                                                                    Object this$regionName = this.getRegionName();
                                                                                                                                    Object other$regionName = other.getRegionName();
                                                                                                                                    if (this$regionName == null
                                                                                                                                       ? other$regionName
                                                                                                                                          == null
                                                                                                                                       : this$regionName.equals(
                                                                                                                                          other$regionName
                                                                                                                                       )) {
                                                                                                                                       Object this$regionalFullName = this.getRegionalFullName();
                                                                                                                                       Object other$regionalFullName = other.getRegionalFullName();
                                                                                                                                       if (this$regionalFullName
                                                                                                                                             == null
                                                                                                                                          ? other$regionalFullName
                                                                                                                                             == null
                                                                                                                                          : this$regionalFullName.equals(
                                                                                                                                             other$regionalFullName
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
                                                                                                                                                                  Object this$contractSignBodyName = this.getContractSignBodyName();
                                                                                                                                                                  Object other$contractSignBodyName = other.getContractSignBodyName();
                                                                                                                                                                  if (this$contractSignBodyName
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$contractSignBodyName
                                                                                                                                                                        == null
                                                                                                                                                                     : this$contractSignBodyName.equals(
                                                                                                                                                                        other$contractSignBodyName
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
                                                                                                                                                                        Object this$projectContentList = this.getProjectContentList();
                                                                                                                                                                        Object other$projectContentList = other.getProjectContentList();
                                                                                                                                                                        if (this$projectContentList
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$projectContentList
                                                                                                                                                                              == null
                                                                                                                                                                           : this$projectContentList.equals(
                                                                                                                                                                              other$projectContentList
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$measureModeList = this.getMeasureModeList();
                                                                                                                                                                           Object other$measureModeList = other.getMeasureModeList();
                                                                                                                                                                           if (this$measureModeList
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$measureModeList
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$measureModeList.equals(
                                                                                                                                                                                 other$measureModeList
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
                                                                                                                                                                                                                                                                                 Object this$relationUserList = this.getRelationUserList();
                                                                                                                                                                                                                                                                                 Object other$relationUserList = other.getRelationUserList();
                                                                                                                                                                                                                                                                                 if (this$relationUserList
                                                                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                                                                    ? other$relationUserList
                                                                                                                                                                                                                                                                                       == null
                                                                                                                                                                                                                                                                                    : this$relationUserList.equals(
                                                                                                                                                                                                                                                                                       other$relationUserList
                                                                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                                                                  {
                                                                                                                                                                                                                                                                                    Object this$structureList = this.getStructureList();
                                                                                                                                                                                                                                                                                    Object other$structureList = other.getStructureList();
                                                                                                                                                                                                                                                                                    if (this$structureList
                                                                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                                                                       ? other$structureList
                                                                                                                                                                                                                                                                                          == null
                                                                                                                                                                                                                                                                                       : this$structureList.equals(
                                                                                                                                                                                                                                                                                          other$structureList
                                                                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                                                                       )
                                                                                                                                                                                                                                                                                     {
                                                                                                                                                                                                                                                                                       Object this$profiledPlateList = this.getProfiledPlateList();
                                                                                                                                                                                                                                                                                       Object other$profiledPlateList = other.getProfiledPlateList();
                                                                                                                                                                                                                                                                                       if (this$profiledPlateList
                                                                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                                                                          ? other$profiledPlateList
                                                                                                                                                                                                                                                                                             == null
                                                                                                                                                                                                                                                                                          : this$profiledPlateList.equals(
                                                                                                                                                                                                                                                                                             other$profiledPlateList
                                                                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                                                                          )
                                                                                                                                                                                                                                                                                        {
                                                                                                                                                                                                                                                                                          Object this$sandwichBoardList = this.getSandwichBoardList();
                                                                                                                                                                                                                                                                                          Object other$sandwichBoardList = other.getSandwichBoardList();
                                                                                                                                                                                                                                                                                          if (this$sandwichBoardList
                                                                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                                                                             ? other$sandwichBoardList
                                                                                                                                                                                                                                                                                                == null
                                                                                                                                                                                                                                                                                             : this$sandwichBoardList.equals(
                                                                                                                                                                                                                                                                                                other$sandwichBoardList
                                                                                                                                                                                                                                                                                             )
                                                                                                                                                                                                                                                                                             )
                                                                                                                                                                                                                                                                                           {
                                                                                                                                                                                                                                                                                             Object this$trussFloorPlateList = this.getTrussFloorPlateList();
                                                                                                                                                                                                                                                                                             Object other$trussFloorPlateList = other.getTrussFloorPlateList();
                                                                                                                                                                                                                                                                                             if (this$trussFloorPlateList
                                                                                                                                                                                                                                                                                                   == null
                                                                                                                                                                                                                                                                                                ? other$trussFloorPlateList
                                                                                                                                                                                                                                                                                                   == null
                                                                                                                                                                                                                                                                                                : this$trussFloorPlateList.equals(
                                                                                                                                                                                                                                                                                                   other$trussFloorPlateList
                                                                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                                                              {
                                                                                                                                                                                                                                                                                                Object this$pressureBearingPlateList = this.getPressureBearingPlateList();
                                                                                                                                                                                                                                                                                                Object other$pressureBearingPlateList = other.getPressureBearingPlateList();
                                                                                                                                                                                                                                                                                                if (this$pressureBearingPlateList
                                                                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                                                                   ? other$pressureBearingPlateList
                                                                                                                                                                                                                                                                                                      == null
                                                                                                                                                                                                                                                                                                   : this$pressureBearingPlateList.equals(
                                                                                                                                                                                                                                                                                                      other$pressureBearingPlateList
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
                                                                                                                                                                                                                                                                                                      Object this$structureTypeName = this.getStructureTypeName();
                                                                                                                                                                                                                                                                                                      Object other$structureTypeName = other.getStructureTypeName();
                                                                                                                                                                                                                                                                                                      if (this$structureTypeName
                                                                                                                                                                                                                                                                                                            == null
                                                                                                                                                                                                                                                                                                         ? other$structureTypeName
                                                                                                                                                                                                                                                                                                            == null
                                                                                                                                                                                                                                                                                                         : this$structureTypeName.equals(
                                                                                                                                                                                                                                                                                                            other$structureTypeName
                                                                                                                                                                                                                                                                                                         )
                                                                                                                                                                                                                                                                                                         )
                                                                                                                                                                                                                                                                                                       {
                                                                                                                                                                                                                                                                                                         Object this$quantityWork = this.getQuantityWork();
                                                                                                                                                                                                                                                                                                         Object other$quantityWork = other.getQuantityWork();
                                                                                                                                                                                                                                                                                                         if (this$quantityWork
                                                                                                                                                                                                                                                                                                               == null
                                                                                                                                                                                                                                                                                                            ? other$quantityWork
                                                                                                                                                                                                                                                                                                               == null
                                                                                                                                                                                                                                                                                                            : this$quantityWork.equals(
                                                                                                                                                                                                                                                                                                               other$quantityWork
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
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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

   protected boolean canEqual(final Object other) {
      return other instanceof ContractProjectTempDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
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
      Object $orderSourceType = this.getOrderSourceType();
      result = result * 59 + ($orderSourceType == null ? 43 : $orderSourceType.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
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
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $regionalFullName = this.getRegionalFullName();
      result = result * 59 + ($regionalFullName == null ? 43 : $regionalFullName.hashCode());
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
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $contractSignBodyName = this.getContractSignBodyName();
      result = result * 59 + ($contractSignBodyName == null ? 43 : $contractSignBodyName.hashCode());
      Object $projectContent = this.getProjectContent();
      result = result * 59 + ($projectContent == null ? 43 : $projectContent.hashCode());
      Object $projectContentList = this.getProjectContentList();
      result = result * 59 + ($projectContentList == null ? 43 : $projectContentList.hashCode());
      Object $measureModeList = this.getMeasureModeList();
      result = result * 59 + ($measureModeList == null ? 43 : $measureModeList.hashCode());
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
      Object $relationUserList = this.getRelationUserList();
      result = result * 59 + ($relationUserList == null ? 43 : $relationUserList.hashCode());
      Object $structureList = this.getStructureList();
      result = result * 59 + ($structureList == null ? 43 : $structureList.hashCode());
      Object $profiledPlateList = this.getProfiledPlateList();
      result = result * 59 + ($profiledPlateList == null ? 43 : $profiledPlateList.hashCode());
      Object $sandwichBoardList = this.getSandwichBoardList();
      result = result * 59 + ($sandwichBoardList == null ? 43 : $sandwichBoardList.hashCode());
      Object $trussFloorPlateList = this.getTrussFloorPlateList();
      result = result * 59 + ($trussFloorPlateList == null ? 43 : $trussFloorPlateList.hashCode());
      Object $pressureBearingPlateList = this.getPressureBearingPlateList();
      result = result * 59 + ($pressureBearingPlateList == null ? 43 : $pressureBearingPlateList.hashCode());
      Object $technologyRemark = this.getTechnologyRemark();
      result = result * 59 + ($technologyRemark == null ? 43 : $technologyRemark.hashCode());
      Object $structureTypeName = this.getStructureTypeName();
      result = result * 59 + ($structureTypeName == null ? 43 : $structureTypeName.hashCode());
      Object $quantityWork = this.getQuantityWork();
      result = result * 59 + ($quantityWork == null ? 43 : $quantityWork.hashCode());
      Object $customerRemark = this.getCustomerRemark();
      return result * 59 + ($customerRemark == null ? 43 : $customerRemark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectTempDTO(id="
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
         + ", orderSourceType="
         + this.getOrderSourceType()
         + ", attachments="
         + this.getAttachments()
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
         + ", regionalFullName="
         + this.getRegionalFullName()
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
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", contractSignBodyName="
         + this.getContractSignBodyName()
         + ", businessType="
         + this.getBusinessType()
         + ", projectType="
         + this.getProjectType()
         + ", projectContent="
         + this.getProjectContent()
         + ", projectContentList="
         + this.getProjectContentList()
         + ", transportMode="
         + this.getTransportMode()
         + ", enclosureTransportMode="
         + this.getEnclosureTransportMode()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", enclosureMeasureMode="
         + this.getEnclosureMeasureMode()
         + ", measureModeList="
         + this.getMeasureModeList()
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
         + ", relationUserList="
         + this.getRelationUserList()
         + ", structureList="
         + this.getStructureList()
         + ", profiledPlateList="
         + this.getProfiledPlateList()
         + ", sandwichBoardList="
         + this.getSandwichBoardList()
         + ", trussFloorPlateList="
         + this.getTrussFloorPlateList()
         + ", pressureBearingPlateList="
         + this.getPressureBearingPlateList()
         + ", technologyRemark="
         + this.getTechnologyRemark()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", structureTypeId="
         + this.getStructureTypeId()
         + ", structureTypeName="
         + this.getStructureTypeName()
         + ", quantityWork="
         + this.getQuantityWork()
         + ", customerRemark="
         + this.getCustomerRemark()
         + ")";
   }

   public static class ContractProjectTempDTOBuilder {
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
      private Integer orderSourceType;
      private List<AttachmentDTO> attachments;
      private Long countryId;
      private String countryName;
      private Long provinceId;
      private String provinceName;
      private Long cityId;
      private String cityName;
      private Long regionId;
      private String regionName;
      private String regionalFullName;
      private BigDecimal contractAmount;
      private BigDecimal prepayments;
      private BigDecimal managementFeeRate;
      private BigDecimal marginAmount;
      private String marginType;
      private String currencyType;
      private BigDecimal qualityGuaranteeDeposit;
      private Integer settlementStatus;
      private BigDecimal settlementAmount;
      private Long contractSignBodyId;
      private String contractSignBodyName;
      private Integer businessType;
      private Integer projectType;
      private String projectContent;
      private List<ProjectContentDTO> projectContentList;
      private Integer transportMode;
      private Integer enclosureTransportMode;
      private Integer structureMeasureMode;
      private Integer enclosureMeasureMode;
      private List<MeasureModeDTOParam> measureModeList;
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
      private List<NameInfo> relationUserList;
      private List<StructureTypeDTO> structureList;
      private List<ProfiledPlateDTOParam> profiledPlateList;
      private List<SandwichBoardDTOParam> sandwichBoardList;
      private List<TrussFloorPlateDTOParam> trussFloorPlateList;
      private List<PressureBearingPlateDTOParam> pressureBearingPlateList;
      private String technologyRemark;
      private Integer structureStatus;
      private Long structureTypeId;
      private String structureTypeName;
      private BigDecimal quantityWork;
      private String customerRemark;

      ContractProjectTempDTOBuilder() {
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder changeId(final Long changeId) {
         this.changeId = changeId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder projectManagerPhone(final String projectManagerPhone) {
         this.projectManagerPhone = projectManagerPhone;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder businessLeaderId(final Long businessLeaderId) {
         this.businessLeaderId = businessLeaderId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder businessLeaderTwoId(final Long businessLeaderTwoId) {
         this.businessLeaderTwoId = businessLeaderTwoId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder orderSourceType(final Integer orderSourceType) {
         this.orderSourceType = orderSourceType;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder regionalFullName(final String regionalFullName) {
         this.regionalFullName = regionalFullName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder prepayments(final BigDecimal prepayments) {
         this.prepayments = prepayments;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder managementFeeRate(final BigDecimal managementFeeRate) {
         this.managementFeeRate = managementFeeRate;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder marginAmount(final BigDecimal marginAmount) {
         this.marginAmount = marginAmount;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder marginType(final String marginType) {
         this.marginType = marginType;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder currencyType(final String currencyType) {
         this.currencyType = currencyType;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder qualityGuaranteeDeposit(final BigDecimal qualityGuaranteeDeposit) {
         this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder contractSignBodyId(final Long contractSignBodyId) {
         this.contractSignBodyId = contractSignBodyId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder contractSignBodyName(final String contractSignBodyName) {
         this.contractSignBodyName = contractSignBodyName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder projectContent(final String projectContent) {
         this.projectContent = projectContent;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder projectContentList(final List<ProjectContentDTO> projectContentList) {
         this.projectContentList = projectContentList;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder transportMode(final Integer transportMode) {
         this.transportMode = transportMode;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder enclosureTransportMode(final Integer enclosureTransportMode) {
         this.enclosureTransportMode = enclosureTransportMode;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder structureMeasureMode(final Integer structureMeasureMode) {
         this.structureMeasureMode = structureMeasureMode;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder enclosureMeasureMode(final Integer enclosureMeasureMode) {
         this.enclosureMeasureMode = enclosureMeasureMode;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder measureModeList(final List<MeasureModeDTOParam> measureModeList) {
         this.measureModeList = measureModeList;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder signingAddress(final String signingAddress) {
         this.signingAddress = signingAddress;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder signingDate(final LocalDate signingDate) {
         this.signingDate = signingDate;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder signerId(final Long signerId) {
         this.signerId = signerId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder signerPhone(final String signerPhone) {
         this.signerPhone = signerPhone;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder isTax(final Integer isTax) {
         this.isTax = isTax;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder payType(final Integer payType) {
         this.payType = payType;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder payTypeDesc(final String payTypeDesc) {
         this.payTypeDesc = payTypeDesc;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerUnit(final String customerUnit) {
         this.customerUnit = customerUnit;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder socialCode(final String socialCode) {
         this.socialCode = socialCode;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerUnitPhone(final String customerUnitPhone) {
         this.customerUnitPhone = customerUnitPhone;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerEmail(final String customerEmail) {
         this.customerEmail = customerEmail;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerProvinceId(final Long customerProvinceId) {
         this.customerProvinceId = customerProvinceId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerProvinceName(final String customerProvinceName) {
         this.customerProvinceName = customerProvinceName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerCityId(final Long customerCityId) {
         this.customerCityId = customerCityId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerCityName(final String customerCityName) {
         this.customerCityName = customerCityName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerRegionId(final Long customerRegionId) {
         this.customerRegionId = customerRegionId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerRegionName(final String customerRegionName) {
         this.customerRegionName = customerRegionName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerCountryId(final Long customerCountryId) {
         this.customerCountryId = customerCountryId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerCountryName(final String customerCountryName) {
         this.customerCountryName = customerCountryName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerAddress(final String customerAddress) {
         this.customerAddress = customerAddress;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerBankUserName(final String customerBankUserName) {
         this.customerBankUserName = customerBankUserName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerBankCode(final String customerBankCode) {
         this.customerBankCode = customerBankCode;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerBankName(final String customerBankName) {
         this.customerBankName = customerBankName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerManagerOne(final String customerManagerOne) {
         this.customerManagerOne = customerManagerOne;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerManagerOnePhone(final String customerManagerOnePhone) {
         this.customerManagerOnePhone = customerManagerOnePhone;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerManagerTwo(final String customerManagerTwo) {
         this.customerManagerTwo = customerManagerTwo;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerManagerTwoPhone(final String customerManagerTwoPhone) {
         this.customerManagerTwoPhone = customerManagerTwoPhone;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder receivingManager(final String receivingManager) {
         this.receivingManager = receivingManager;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder receivingManagerPhone(final String receivingManagerPhone) {
         this.receivingManagerPhone = receivingManagerPhone;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder settleManager(final String settleManager) {
         this.settleManager = settleManager;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder settleManagerPhone(final String settleManagerPhone) {
         this.settleManagerPhone = settleManagerPhone;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder financeManager(final String financeManager) {
         this.financeManager = financeManager;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder financeManagerPhone(final String financeManagerPhone) {
         this.financeManagerPhone = financeManagerPhone;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder auditManager(final String auditManager) {
         this.auditManager = auditManager;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder auditManagerPhone(final String auditManagerPhone) {
         this.auditManagerPhone = auditManagerPhone;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder designManager(final String designManager) {
         this.designManager = designManager;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder designManagerPhone(final String designManagerPhone) {
         this.designManagerPhone = designManagerPhone;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder relationUserIds(final String relationUserIds) {
         this.relationUserIds = relationUserIds;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder relationUserList(final List<NameInfo> relationUserList) {
         this.relationUserList = relationUserList;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder structureList(final List<StructureTypeDTO> structureList) {
         this.structureList = structureList;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder profiledPlateList(final List<ProfiledPlateDTOParam> profiledPlateList) {
         this.profiledPlateList = profiledPlateList;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder sandwichBoardList(final List<SandwichBoardDTOParam> sandwichBoardList) {
         this.sandwichBoardList = sandwichBoardList;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder trussFloorPlateList(final List<TrussFloorPlateDTOParam> trussFloorPlateList) {
         this.trussFloorPlateList = trussFloorPlateList;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder pressureBearingPlateList(final List<PressureBearingPlateDTOParam> pressureBearingPlateList) {
         this.pressureBearingPlateList = pressureBearingPlateList;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder technologyRemark(final String technologyRemark) {
         this.technologyRemark = technologyRemark;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder structureStatus(final Integer structureStatus) {
         this.structureStatus = structureStatus;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder structureTypeId(final Long structureTypeId) {
         this.structureTypeId = structureTypeId;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder structureTypeName(final String structureTypeName) {
         this.structureTypeName = structureTypeName;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder quantityWork(final BigDecimal quantityWork) {
         this.quantityWork = quantityWork;
         return this;
      }

      public ContractProjectTempDTO.ContractProjectTempDTOBuilder customerRemark(final String customerRemark) {
         this.customerRemark = customerRemark;
         return this;
      }

      public ContractProjectTempDTO build() {
         return new ContractProjectTempDTO(
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
            this.orderSourceType,
            this.attachments,
            this.countryId,
            this.countryName,
            this.provinceId,
            this.provinceName,
            this.cityId,
            this.cityName,
            this.regionId,
            this.regionName,
            this.regionalFullName,
            this.contractAmount,
            this.prepayments,
            this.managementFeeRate,
            this.marginAmount,
            this.marginType,
            this.currencyType,
            this.qualityGuaranteeDeposit,
            this.settlementStatus,
            this.settlementAmount,
            this.contractSignBodyId,
            this.contractSignBodyName,
            this.businessType,
            this.projectType,
            this.projectContent,
            this.projectContentList,
            this.transportMode,
            this.enclosureTransportMode,
            this.structureMeasureMode,
            this.enclosureMeasureMode,
            this.measureModeList,
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
            this.relationUserList,
            this.structureList,
            this.profiledPlateList,
            this.sandwichBoardList,
            this.trussFloorPlateList,
            this.pressureBearingPlateList,
            this.technologyRemark,
            this.structureStatus,
            this.structureTypeId,
            this.structureTypeName,
            this.quantityWork,
            this.customerRemark
         );
      }

      @Override
      public String toString() {
         return "ContractProjectTempDTO.ContractProjectTempDTOBuilder(id="
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
            + ", orderSourceType="
            + this.orderSourceType
            + ", attachments="
            + this.attachments
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
            + ", regionalFullName="
            + this.regionalFullName
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
            + ", settlementStatus="
            + this.settlementStatus
            + ", settlementAmount="
            + this.settlementAmount
            + ", contractSignBodyId="
            + this.contractSignBodyId
            + ", contractSignBodyName="
            + this.contractSignBodyName
            + ", businessType="
            + this.businessType
            + ", projectType="
            + this.projectType
            + ", projectContent="
            + this.projectContent
            + ", projectContentList="
            + this.projectContentList
            + ", transportMode="
            + this.transportMode
            + ", enclosureTransportMode="
            + this.enclosureTransportMode
            + ", structureMeasureMode="
            + this.structureMeasureMode
            + ", enclosureMeasureMode="
            + this.enclosureMeasureMode
            + ", measureModeList="
            + this.measureModeList
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
            + ", relationUserList="
            + this.relationUserList
            + ", structureList="
            + this.structureList
            + ", profiledPlateList="
            + this.profiledPlateList
            + ", sandwichBoardList="
            + this.sandwichBoardList
            + ", trussFloorPlateList="
            + this.trussFloorPlateList
            + ", pressureBearingPlateList="
            + this.pressureBearingPlateList
            + ", technologyRemark="
            + this.technologyRemark
            + ", structureStatus="
            + this.structureStatus
            + ", structureTypeId="
            + this.structureTypeId
            + ", structureTypeName="
            + this.structureTypeName
            + ", quantityWork="
            + this.quantityWork
            + ", customerRemark="
            + this.customerRemark
            + ")";
      }
   }
}
