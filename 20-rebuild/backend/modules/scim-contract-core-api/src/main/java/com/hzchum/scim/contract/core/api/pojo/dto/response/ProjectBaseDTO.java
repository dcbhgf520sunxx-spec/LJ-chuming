package com.hzchum.scim.contract.core.api.pojo.dto.response;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("项目基本信息返回类")
public class ProjectBaseDTO {
   @ApiModelProperty(name = "id", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "项目名称")
   private String name;
   @ApiModelProperty(name = "shortName", value = "项目的简称")
   private String shortName;
   @ApiModelProperty(name = "countryId", value = "项目所在地的国家id")
   private Long countryId;
   @ApiModelProperty(name = "countryName", value = "项目所在国家名字")
   private String countryName;
   @ApiModelProperty(name = "provinceId", value = "所在省/洲id")
   private Long provinceId;
   @ApiModelProperty(name = "provinceName", value = "所在省名字")
   private String provinceName;
   @ApiModelProperty(name = "cityId", value = "所在市id")
   private Long cityId;
   @ApiModelProperty(name = "cityName", value = "所在市名字")
   private String cityName;
   @ApiModelProperty(name = "regionId", value = "所在区id")
   private Long regionId;
   @ApiModelProperty(name = "regionName", value = "所在区名字")
   private String regionName;
   @ApiModelProperty(name = "regionalFullName", value = "省市区")
   private String regionalFullName;
   @ApiModelProperty(name = "address", value = "详细地址")
   private String address;
   @ApiModelProperty(name = "startDate", value = "合同约定开始时间")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "合同约定结束时间")
   private LocalDate endDate;
   @ApiModelProperty(name = "orderSourceType", value = "项目订单来源类型 1内部 2外部 枚举:OrderSourceTypeEnum")
   private Integer orderSourceType;
   @ApiModelProperty(name = "contractAmount", value = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "prepayments", value = "预付款（元）")
   private BigDecimal prepayments;
   @ApiModelProperty(name = "managementFeeRate", value = "管理费")
   private BigDecimal managementFeeRate;
   @ApiModelProperty(name = "marginAmount", value = "保证金金额（元）")
   private BigDecimal marginAmount;
   @ApiModelProperty(name = "marginType", value = "保证金类型")
   private String marginType;
   @ApiModelProperty(name = "currencyType", value = "币种 (暂时先固定几种) RMB,EUR,USD,JPY")
   private Long currencyType;
   @ApiModelProperty(name = "currencyTypeName", value = "币种名称")
   private String currencyTypeName;
   @ApiModelProperty(name = "qualityGuaranteeDeposit", notes = "质保金(%)")
   private BigDecimal qualityGuaranteeDeposit;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerName", value = "项目经理名称")
   private String projectManagerName;
   private String projectManagerPhone;
   @ApiModelProperty(name = "attachments", value = "附件信息")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "salesLeaderId", value = "销售负责人id")
   private Long salesLeaderId;
   @ApiModelProperty(name = "salesLeaderName", value = "销售负责人名称")
   private String salesLeaderName;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性: 1.自营 2.合营 3.包干制 枚举:ProjectAttributeEnum")
   private Integer projectAttribute;
   @ApiModelProperty(name = "deptId", value = "承接部门id")
   private Long deptId;
   @ApiModelProperty(name = "deptName", value = "承接部门名称")
   private String deptName;
   @ApiModelProperty(name = "structureArea", value = "建筑面积")
   private BigDecimal structureArea;
   @ApiModelProperty(name = "structureStatus", value = "结构类型")
   private Long structureStatus;
   @ApiModelProperty(name = "structureStatusName", value = "结构类型美称")
   private String structureStatusName;
   @ApiModelProperty(name = "partyType", value = "甲方类型")
   private Long partyType;
   @ApiModelProperty(name = "partyTypeName", value = "甲方类型名称")
   private String partyTypeName;
   @ApiModelProperty(name = "sendingMode", value = "发包方式")
   private Long sendingMode;
   @ApiModelProperty(name = "sendingModeName", value = "发包方式")
   private String sendingModeName;
   @ApiModelProperty(name = "isBuilding", value = "是否装配式建筑1.是  0.否")
   private Integer isBuilding;
   @ApiModelProperty(name = "infoSource", value = "信息来源")
   private Long infoSource;
   @ApiModelProperty(name = "infoSourceName", value = "信息来源名称")
   private String infoSourceName;
   @ApiModelProperty(name = "taxRate", value = "税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "allDays", value = "项目总工期")
   private Integer allDays;
   @ApiModelProperty(name = "customerUnit", value = "发包单位")
   private String customerUnit;
   @ApiModelProperty(name = "commercialClause", value = "商务条款（付款方式）")
   private String commercialClause;
   @ApiModelProperty(name = "technologyClause", value = "技术条款")
   private String technologyClause;
   @ApiModelProperty(name = "otherRemarks", value = "其他说明")
   private String otherRemarks;
   @ApiModelProperty(name = "businessType", value = "业务类型 1.加工承揽  2.项目承包")
   private Integer businessType;
   private String signerPhone;
   @ApiModelProperty(name = "unitType", value = "单位类型 1.吨 2.平方米")
   private Integer unitType;
   @ApiModelProperty(name = "projectManagerScale", notes = "合同签订主体占比")
   private BigDecimal contractSignBodyScale;
   @ApiModelProperty(name = "projectManagerScale", notes = "项目经理占比")
   private BigDecimal projectManagerScale;

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

   public String getAddress() {
      return this.address;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getOrderSourceType() {
      return this.orderSourceType;
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

   public Long getCurrencyType() {
      return this.currencyType;
   }

   public String getCurrencyTypeName() {
      return this.currencyTypeName;
   }

   public BigDecimal getQualityGuaranteeDeposit() {
      return this.qualityGuaranteeDeposit;
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

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Long getSalesLeaderId() {
      return this.salesLeaderId;
   }

   public String getSalesLeaderName() {
      return this.salesLeaderName;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public BigDecimal getStructureArea() {
      return this.structureArea;
   }

   public Long getStructureStatus() {
      return this.structureStatus;
   }

   public String getStructureStatusName() {
      return this.structureStatusName;
   }

   public Long getPartyType() {
      return this.partyType;
   }

   public String getPartyTypeName() {
      return this.partyTypeName;
   }

   public Long getSendingMode() {
      return this.sendingMode;
   }

   public String getSendingModeName() {
      return this.sendingModeName;
   }

   public Integer getIsBuilding() {
      return this.isBuilding;
   }

   public Long getInfoSource() {
      return this.infoSource;
   }

   public String getInfoSourceName() {
      return this.infoSourceName;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getAllDays() {
      return this.allDays;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
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

   public Integer getBusinessType() {
      return this.businessType;
   }

   public String getSignerPhone() {
      return this.signerPhone;
   }

   public Integer getUnitType() {
      return this.unitType;
   }

   public BigDecimal getContractSignBodyScale() {
      return this.contractSignBodyScale;
   }

   public BigDecimal getProjectManagerScale() {
      return this.projectManagerScale;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setAddress(final String address) {
      this.address = address;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setOrderSourceType(final Integer orderSourceType) {
      this.orderSourceType = orderSourceType;
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

   public void setCurrencyType(final Long currencyType) {
      this.currencyType = currencyType;
   }

   public void setCurrencyTypeName(final String currencyTypeName) {
      this.currencyTypeName = currencyTypeName;
   }

   public void setQualityGuaranteeDeposit(final BigDecimal qualityGuaranteeDeposit) {
      this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
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

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setSalesLeaderId(final Long salesLeaderId) {
      this.salesLeaderId = salesLeaderId;
   }

   public void setSalesLeaderName(final String salesLeaderName) {
      this.salesLeaderName = salesLeaderName;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setDeptName(final String deptName) {
      this.deptName = deptName;
   }

   public void setStructureArea(final BigDecimal structureArea) {
      this.structureArea = structureArea;
   }

   public void setStructureStatus(final Long structureStatus) {
      this.structureStatus = structureStatus;
   }

   public void setStructureStatusName(final String structureStatusName) {
      this.structureStatusName = structureStatusName;
   }

   public void setPartyType(final Long partyType) {
      this.partyType = partyType;
   }

   public void setPartyTypeName(final String partyTypeName) {
      this.partyTypeName = partyTypeName;
   }

   public void setSendingMode(final Long sendingMode) {
      this.sendingMode = sendingMode;
   }

   public void setSendingModeName(final String sendingModeName) {
      this.sendingModeName = sendingModeName;
   }

   public void setIsBuilding(final Integer isBuilding) {
      this.isBuilding = isBuilding;
   }

   public void setInfoSource(final Long infoSource) {
      this.infoSource = infoSource;
   }

   public void setInfoSourceName(final String infoSourceName) {
      this.infoSourceName = infoSourceName;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setAllDays(final Integer allDays) {
      this.allDays = allDays;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setCommercialClause(final String commercialClause) {
      this.commercialClause = commercialClause;
   }

   public void setTechnologyClause(final String technologyClause) {
      this.technologyClause = technologyClause;
   }

   public void setOtherRemarks(final String otherRemarks) {
      this.otherRemarks = otherRemarks;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setSignerPhone(final String signerPhone) {
      this.signerPhone = signerPhone;
   }

   public void setUnitType(final Integer unitType) {
      this.unitType = unitType;
   }

   public void setContractSignBodyScale(final BigDecimal contractSignBodyScale) {
      this.contractSignBodyScale = contractSignBodyScale;
   }

   public void setProjectManagerScale(final BigDecimal projectManagerScale) {
      this.projectManagerScale = projectManagerScale;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectBaseDTO)) {
         return false;
      }

      ProjectBaseDTO other = (ProjectBaseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
                     Object this$orderSourceType = this.getOrderSourceType();
                     Object other$orderSourceType = other.getOrderSourceType();
                     if (this$orderSourceType == null ? other$orderSourceType == null : this$orderSourceType.equals(other$orderSourceType)) {
                        Object this$currencyType = this.getCurrencyType();
                        Object other$currencyType = other.getCurrencyType();
                        if (this$currencyType == null ? other$currencyType == null : this$currencyType.equals(other$currencyType)) {
                           Object this$projectManagerId = this.getProjectManagerId();
                           Object other$projectManagerId = other.getProjectManagerId();
                           if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                              Object this$salesLeaderId = this.getSalesLeaderId();
                              Object other$salesLeaderId = other.getSalesLeaderId();
                              if (this$salesLeaderId == null ? other$salesLeaderId == null : this$salesLeaderId.equals(other$salesLeaderId)) {
                                 Object this$projectAttribute = this.getProjectAttribute();
                                 Object other$projectAttribute = other.getProjectAttribute();
                                 if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                                    Object this$deptId = this.getDeptId();
                                    Object other$deptId = other.getDeptId();
                                    if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
                                       Object this$structureStatus = this.getStructureStatus();
                                       Object other$structureStatus = other.getStructureStatus();
                                       if (this$structureStatus == null ? other$structureStatus == null : this$structureStatus.equals(other$structureStatus)) {
                                          Object this$partyType = this.getPartyType();
                                          Object other$partyType = other.getPartyType();
                                          if (this$partyType == null ? other$partyType == null : this$partyType.equals(other$partyType)) {
                                             Object this$sendingMode = this.getSendingMode();
                                             Object other$sendingMode = other.getSendingMode();
                                             if (this$sendingMode == null ? other$sendingMode == null : this$sendingMode.equals(other$sendingMode)) {
                                                Object this$isBuilding = this.getIsBuilding();
                                                Object other$isBuilding = other.getIsBuilding();
                                                if (this$isBuilding == null ? other$isBuilding == null : this$isBuilding.equals(other$isBuilding)) {
                                                   Object this$infoSource = this.getInfoSource();
                                                   Object other$infoSource = other.getInfoSource();
                                                   if (this$infoSource == null ? other$infoSource == null : this$infoSource.equals(other$infoSource)) {
                                                      Object this$allDays = this.getAllDays();
                                                      Object other$allDays = other.getAllDays();
                                                      if (this$allDays == null ? other$allDays == null : this$allDays.equals(other$allDays)) {
                                                         Object this$businessType = this.getBusinessType();
                                                         Object other$businessType = other.getBusinessType();
                                                         if (this$businessType == null
                                                            ? other$businessType == null
                                                            : this$businessType.equals(other$businessType)) {
                                                            Object this$unitType = this.getUnitType();
                                                            Object other$unitType = other.getUnitType();
                                                            if (this$unitType == null ? other$unitType == null : this$unitType.equals(other$unitType)) {
                                                               Object this$serialNumber = this.getSerialNumber();
                                                               Object other$serialNumber = other.getSerialNumber();
                                                               if (this$serialNumber == null
                                                                  ? other$serialNumber == null
                                                                  : this$serialNumber.equals(other$serialNumber)) {
                                                                  Object this$name = this.getName();
                                                                  Object other$name = other.getName();
                                                                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                                     Object this$shortName = this.getShortName();
                                                                     Object other$shortName = other.getShortName();
                                                                     if (this$shortName == null
                                                                        ? other$shortName == null
                                                                        : this$shortName.equals(other$shortName)) {
                                                                        Object this$countryName = this.getCountryName();
                                                                        Object other$countryName = other.getCountryName();
                                                                        if (this$countryName == null
                                                                           ? other$countryName == null
                                                                           : this$countryName.equals(other$countryName)) {
                                                                           Object this$provinceName = this.getProvinceName();
                                                                           Object other$provinceName = other.getProvinceName();
                                                                           if (this$provinceName == null
                                                                              ? other$provinceName == null
                                                                              : this$provinceName.equals(other$provinceName)) {
                                                                              Object this$cityName = this.getCityName();
                                                                              Object other$cityName = other.getCityName();
                                                                              if (this$cityName == null
                                                                                 ? other$cityName == null
                                                                                 : this$cityName.equals(other$cityName)) {
                                                                                 Object this$regionName = this.getRegionName();
                                                                                 Object other$regionName = other.getRegionName();
                                                                                 if (this$regionName == null
                                                                                    ? other$regionName == null
                                                                                    : this$regionName.equals(other$regionName)) {
                                                                                    Object this$regionalFullName = this.getRegionalFullName();
                                                                                    Object other$regionalFullName = other.getRegionalFullName();
                                                                                    if (this$regionalFullName == null
                                                                                       ? other$regionalFullName == null
                                                                                       : this$regionalFullName.equals(other$regionalFullName)) {
                                                                                       Object this$address = this.getAddress();
                                                                                       Object other$address = other.getAddress();
                                                                                       if (this$address == null
                                                                                          ? other$address == null
                                                                                          : this$address.equals(other$address)) {
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
                                                                                                Object this$contractAmount = this.getContractAmount();
                                                                                                Object other$contractAmount = other.getContractAmount();
                                                                                                if (this$contractAmount == null
                                                                                                   ? other$contractAmount == null
                                                                                                   : this$contractAmount.equals(other$contractAmount)) {
                                                                                                   Object this$prepayments = this.getPrepayments();
                                                                                                   Object other$prepayments = other.getPrepayments();
                                                                                                   if (this$prepayments == null
                                                                                                      ? other$prepayments == null
                                                                                                      : this$prepayments.equals(other$prepayments)) {
                                                                                                      Object this$managementFeeRate = this.getManagementFeeRate();
                                                                                                      Object other$managementFeeRate = other.getManagementFeeRate();
                                                                                                      if (this$managementFeeRate == null
                                                                                                         ? other$managementFeeRate == null
                                                                                                         : this$managementFeeRate.equals(
                                                                                                            other$managementFeeRate
                                                                                                         )) {
                                                                                                         Object this$marginAmount = this.getMarginAmount();
                                                                                                         Object other$marginAmount = other.getMarginAmount();
                                                                                                         if (this$marginAmount == null
                                                                                                            ? other$marginAmount == null
                                                                                                            : this$marginAmount.equals(other$marginAmount)) {
                                                                                                            Object this$marginType = this.getMarginType();
                                                                                                            Object other$marginType = other.getMarginType();
                                                                                                            if (this$marginType == null
                                                                                                               ? other$marginType == null
                                                                                                               : this$marginType.equals(other$marginType)) {
                                                                                                               Object this$currencyTypeName = this.getCurrencyTypeName();
                                                                                                               Object other$currencyTypeName = other.getCurrencyTypeName();
                                                                                                               if (this$currencyTypeName == null
                                                                                                                  ? other$currencyTypeName == null
                                                                                                                  : this$currencyTypeName.equals(
                                                                                                                     other$currencyTypeName
                                                                                                                  )) {
                                                                                                                  Object this$qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
                                                                                                                  Object other$qualityGuaranteeDeposit = other.getQualityGuaranteeDeposit();
                                                                                                                  if (this$qualityGuaranteeDeposit == null
                                                                                                                     ? other$qualityGuaranteeDeposit == null
                                                                                                                     : this$qualityGuaranteeDeposit.equals(
                                                                                                                        other$qualityGuaranteeDeposit
                                                                                                                     )) {
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
                                                                                                                              Object this$createTime = this.getCreateTime();
                                                                                                                              Object other$createTime = other.getCreateTime();
                                                                                                                              if (this$createTime == null
                                                                                                                                 ? other$createTime == null
                                                                                                                                 : this$createTime.equals(
                                                                                                                                    other$createTime
                                                                                                                                 )) {
                                                                                                                                 Object this$salesLeaderName = this.getSalesLeaderName();
                                                                                                                                 Object other$salesLeaderName = other.getSalesLeaderName();
                                                                                                                                 if (this$salesLeaderName
                                                                                                                                       == null
                                                                                                                                    ? other$salesLeaderName
                                                                                                                                       == null
                                                                                                                                    : this$salesLeaderName.equals(
                                                                                                                                       other$salesLeaderName
                                                                                                                                    )) {
                                                                                                                                    Object this$deptName = this.getDeptName();
                                                                                                                                    Object other$deptName = other.getDeptName();
                                                                                                                                    if (this$deptName == null
                                                                                                                                       ? other$deptName == null
                                                                                                                                       : this$deptName.equals(
                                                                                                                                          other$deptName
                                                                                                                                       )) {
                                                                                                                                       Object this$structureArea = this.getStructureArea();
                                                                                                                                       Object other$structureArea = other.getStructureArea();
                                                                                                                                       if (this$structureArea
                                                                                                                                             == null
                                                                                                                                          ? other$structureArea
                                                                                                                                             == null
                                                                                                                                          : this$structureArea.equals(
                                                                                                                                             other$structureArea
                                                                                                                                          )) {
                                                                                                                                          Object this$structureStatusName = this.getStructureStatusName();
                                                                                                                                          Object other$structureStatusName = other.getStructureStatusName();
                                                                                                                                          if (this$structureStatusName
                                                                                                                                                == null
                                                                                                                                             ? other$structureStatusName
                                                                                                                                                == null
                                                                                                                                             : this$structureStatusName.equals(
                                                                                                                                                other$structureStatusName
                                                                                                                                             )) {
                                                                                                                                             Object this$partyTypeName = this.getPartyTypeName();
                                                                                                                                             Object other$partyTypeName = other.getPartyTypeName();
                                                                                                                                             if (this$partyTypeName
                                                                                                                                                   == null
                                                                                                                                                ? other$partyTypeName
                                                                                                                                                   == null
                                                                                                                                                : this$partyTypeName.equals(
                                                                                                                                                   other$partyTypeName
                                                                                                                                                )) {
                                                                                                                                                Object this$sendingModeName = this.getSendingModeName();
                                                                                                                                                Object other$sendingModeName = other.getSendingModeName();
                                                                                                                                                if (this$sendingModeName
                                                                                                                                                      == null
                                                                                                                                                   ? other$sendingModeName
                                                                                                                                                      == null
                                                                                                                                                   : this$sendingModeName.equals(
                                                                                                                                                      other$sendingModeName
                                                                                                                                                   )) {
                                                                                                                                                   Object this$infoSourceName = this.getInfoSourceName();
                                                                                                                                                   Object other$infoSourceName = other.getInfoSourceName();
                                                                                                                                                   if (this$infoSourceName
                                                                                                                                                         == null
                                                                                                                                                      ? other$infoSourceName
                                                                                                                                                         == null
                                                                                                                                                      : this$infoSourceName.equals(
                                                                                                                                                         other$infoSourceName
                                                                                                                                                      )) {
                                                                                                                                                      Object this$taxRate = this.getTaxRate();
                                                                                                                                                      Object other$taxRate = other.getTaxRate();
                                                                                                                                                      if (this$taxRate
                                                                                                                                                            == null
                                                                                                                                                         ? other$taxRate
                                                                                                                                                            == null
                                                                                                                                                         : this$taxRate.equals(
                                                                                                                                                            other$taxRate
                                                                                                                                                         )) {
                                                                                                                                                         Object this$customerUnit = this.getCustomerUnit();
                                                                                                                                                         Object other$customerUnit = other.getCustomerUnit();
                                                                                                                                                         if (this$customerUnit
                                                                                                                                                               == null
                                                                                                                                                            ? other$customerUnit
                                                                                                                                                               == null
                                                                                                                                                            : this$customerUnit.equals(
                                                                                                                                                               other$customerUnit
                                                                                                                                                            )) {
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
                                                                                                                                                                           Object this$projectManagerScale = this.getProjectManagerScale();
                                                                                                                                                                           Object other$projectManagerScale = other.getProjectManagerScale();
                                                                                                                                                                           return this$projectManagerScale
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$projectManagerScale
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$projectManagerScale.equals(
                                                                                                                                                                                 other$projectManagerScale
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectBaseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $orderSourceType = this.getOrderSourceType();
      result = result * 59 + ($orderSourceType == null ? 43 : $orderSourceType.hashCode());
      Object $currencyType = this.getCurrencyType();
      result = result * 59 + ($currencyType == null ? 43 : $currencyType.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $salesLeaderId = this.getSalesLeaderId();
      result = result * 59 + ($salesLeaderId == null ? 43 : $salesLeaderId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $partyType = this.getPartyType();
      result = result * 59 + ($partyType == null ? 43 : $partyType.hashCode());
      Object $sendingMode = this.getSendingMode();
      result = result * 59 + ($sendingMode == null ? 43 : $sendingMode.hashCode());
      Object $isBuilding = this.getIsBuilding();
      result = result * 59 + ($isBuilding == null ? 43 : $isBuilding.hashCode());
      Object $infoSource = this.getInfoSource();
      result = result * 59 + ($infoSource == null ? 43 : $infoSource.hashCode());
      Object $allDays = this.getAllDays();
      result = result * 59 + ($allDays == null ? 43 : $allDays.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $unitType = this.getUnitType();
      result = result * 59 + ($unitType == null ? 43 : $unitType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
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
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
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
      Object $currencyTypeName = this.getCurrencyTypeName();
      result = result * 59 + ($currencyTypeName == null ? 43 : $currencyTypeName.hashCode());
      Object $qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
      result = result * 59 + ($qualityGuaranteeDeposit == null ? 43 : $qualityGuaranteeDeposit.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $projectManagerPhone = this.getProjectManagerPhone();
      result = result * 59 + ($projectManagerPhone == null ? 43 : $projectManagerPhone.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $salesLeaderName = this.getSalesLeaderName();
      result = result * 59 + ($salesLeaderName == null ? 43 : $salesLeaderName.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $structureArea = this.getStructureArea();
      result = result * 59 + ($structureArea == null ? 43 : $structureArea.hashCode());
      Object $structureStatusName = this.getStructureStatusName();
      result = result * 59 + ($structureStatusName == null ? 43 : $structureStatusName.hashCode());
      Object $partyTypeName = this.getPartyTypeName();
      result = result * 59 + ($partyTypeName == null ? 43 : $partyTypeName.hashCode());
      Object $sendingModeName = this.getSendingModeName();
      result = result * 59 + ($sendingModeName == null ? 43 : $sendingModeName.hashCode());
      Object $infoSourceName = this.getInfoSourceName();
      result = result * 59 + ($infoSourceName == null ? 43 : $infoSourceName.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $commercialClause = this.getCommercialClause();
      result = result * 59 + ($commercialClause == null ? 43 : $commercialClause.hashCode());
      Object $technologyClause = this.getTechnologyClause();
      result = result * 59 + ($technologyClause == null ? 43 : $technologyClause.hashCode());
      Object $otherRemarks = this.getOtherRemarks();
      result = result * 59 + ($otherRemarks == null ? 43 : $otherRemarks.hashCode());
      Object $signerPhone = this.getSignerPhone();
      result = result * 59 + ($signerPhone == null ? 43 : $signerPhone.hashCode());
      Object $contractSignBodyScale = this.getContractSignBodyScale();
      result = result * 59 + ($contractSignBodyScale == null ? 43 : $contractSignBodyScale.hashCode());
      Object $projectManagerScale = this.getProjectManagerScale();
      return result * 59 + ($projectManagerScale == null ? 43 : $projectManagerScale.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectBaseDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
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
         + ", address="
         + this.getAddress()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", orderSourceType="
         + this.getOrderSourceType()
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
         + ", currencyTypeName="
         + this.getCurrencyTypeName()
         + ", qualityGuaranteeDeposit="
         + this.getQualityGuaranteeDeposit()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", projectManagerPhone="
         + this.getProjectManagerPhone()
         + ", attachments="
         + this.getAttachments()
         + ", createTime="
         + this.getCreateTime()
         + ", salesLeaderId="
         + this.getSalesLeaderId()
         + ", salesLeaderName="
         + this.getSalesLeaderName()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", deptId="
         + this.getDeptId()
         + ", deptName="
         + this.getDeptName()
         + ", structureArea="
         + this.getStructureArea()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", structureStatusName="
         + this.getStructureStatusName()
         + ", partyType="
         + this.getPartyType()
         + ", partyTypeName="
         + this.getPartyTypeName()
         + ", sendingMode="
         + this.getSendingMode()
         + ", sendingModeName="
         + this.getSendingModeName()
         + ", isBuilding="
         + this.getIsBuilding()
         + ", infoSource="
         + this.getInfoSource()
         + ", infoSourceName="
         + this.getInfoSourceName()
         + ", taxRate="
         + this.getTaxRate()
         + ", allDays="
         + this.getAllDays()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", commercialClause="
         + this.getCommercialClause()
         + ", technologyClause="
         + this.getTechnologyClause()
         + ", otherRemarks="
         + this.getOtherRemarks()
         + ", businessType="
         + this.getBusinessType()
         + ", signerPhone="
         + this.getSignerPhone()
         + ", unitType="
         + this.getUnitType()
         + ", contractSignBodyScale="
         + this.getContractSignBodyScale()
         + ", projectManagerScale="
         + this.getProjectManagerScale()
         + ")";
   }
}
