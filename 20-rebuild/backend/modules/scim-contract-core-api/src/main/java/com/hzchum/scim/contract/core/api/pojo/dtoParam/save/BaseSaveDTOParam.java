package com.hzchum.scim.contract.core.api.pojo.dtoParam.save;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@ApiModel("基本信息 新增类")
public class BaseSaveDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @NotBlank(message = "合同编号不能为空")
   @Length(max = 64, message = "合同编号最大长度为64个字")
   @ApiModelProperty(name = "serialNumber", value = "合同编号")
   private String serialNumber;
   @NotBlank(message = "项目名称不能为空")
   @Length(max = 64, message = "项目名称最大长度为64个字")
   @ApiModelProperty(name = "name", value = "项目名称")
   private String name;
   @NotBlank(message = "项目简称不能为空")
   @Length(max = 32, message = "项目简称最大长度为32个字")
   @ApiModelProperty(name = "shortName", value = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "countryId", value = "国家id")
   private Long countryId;
   @ApiModelProperty(name = "provinceId", value = "省id")
   private Long provinceId;
   @ApiModelProperty(name = "cityId", value = "所在市id")
   private Long cityId;
   @ApiModelProperty(name = "regionId", value = "区id")
   private Long regionId;
   @ApiModelProperty(name = "address", value = "详细地址")
   private String address;
   @NotNull(message = "项目开始日期不能为空")
   @ApiModelProperty(name = "startDate", value = "开始日期")
   private LocalDate startDate;
   @NotNull(message = "项目结束日期不能为空")
   @ApiModelProperty(name = "endDate", value = "结束日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理id")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerName", value = "项目经理名称")
   private String projectManagerName;
   @ApiModelProperty(name = "projectManagerPhone", value = "项目经理电话")
   private String projectManagerPhone;
   @ApiModelProperty(name = "signerName", notes = "签约人姓名")
   private String signerName;
   @ApiModelProperty(name = "signerPhone", notes = "签约人电话")
   private String signerPhone;
   @ApiModelProperty(name = "salesLeaderId", value = "销售负责人id")
   private Long salesLeaderId;
   @NotNull(message = "合同金额不能为空")
   @ApiModelProperty(name = "contractAmount", value = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "managementFeeRate", value = "管理费 (%)")
   private BigDecimal managementFeeRate;
   @ApiModelProperty(name = "managementCostId", value = "管理费id")
   private BigDecimal managementCostId;
   @ApiModelProperty(name = "marginAmount", value = "保证金金额（元）")
   private BigDecimal marginAmount;
   @ApiModelProperty(name = "marginType", value = "保证金类型 1.现金 2保函")
   private String marginType;
   @ApiModelProperty(name = "currencyType", value = "币种 (暂时先固定几种) RMB,EUR,USD,JPY")
   private String currencyType;
   @ApiModelProperty(name = "qualityGuaranteeDeposit", value = "质保金(%)")
   private BigDecimal qualityGuaranteeDeposit;
   @ApiModelProperty(name = "attachments", value = "项目的附件id数组")
   private List<Long> attachments;
   @ApiModelProperty(name = "attachments", value = "附件信息")
   private List<AttachmentDTO> AttachmentDTOList;
   @ApiModelProperty(name = "projectAttribute", notes = "项目属性: 1.自营 2.合营 3.包干制 枚举:ProjectAttributeEnum")
   @NotNull(message = "项目属性不能为空")
   private Integer projectAttribute;
   @ApiModelProperty(name = "orderSourceType", value = "项目订单来源类型 1内部 2外部 枚举:OrderSourceTypeEnum")
   private Integer orderSourceType;
   @NotNull(message = "承接部门不能为空")
   @ApiModelProperty(name = "deptId", value = "承接部门id")
   private Long deptId;
   @ApiModelProperty(name = "deptName", value = "部门名称")
   private String deptName;
   @NotNull(message = "建筑面积不能为空")
   @ApiModelProperty(name = "structureArea", value = "建筑面积 平方米")
   private BigDecimal structureArea;
   @ApiModelProperty(name = "allDays", value = "项目总工期")
   private Integer allDays;
   @ApiModelProperty(name = "partyType", value = "甲方类型 参考枚举:PartyTypeEnum 1.民企 2.国企 3.央企 4.民企上市公司 5.国企上市公司 6.央企上市公司")
   private Long partyType;
   @ApiModelProperty(name = "contractSignBodyId", value = "合同签订主体id")
   private Long contractSignBodyId;
   @ApiModelProperty(name = "businessType", value = "业务类型 1.加工承揽  2.项目承包")
   private Integer businessType;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建筑钢结构 2桥梁钢结构  4立体停车库")
   private Integer projectType;
   @ApiModelProperty(name = "projectContent", value = "项目内容列表")
   private List<Long> projectContent;
   @ApiModelProperty(name = "transportMode", notes = "运输方式 1运送到场 2客户自提")
   private Integer transportMode;
   @ApiModelProperty(name = "signerId", value = "签约人id")
   private Long signerId;
   @ApiModelProperty(name = "signingDate", value = "签约日期")
   private LocalDate signingDate;
   @ApiModelProperty(name = "signingAddress", value = "签约地址")
   private String signingAddress;
   @ApiModelProperty(name = "sendingMode", value = "发包方式 1.业主直接发包 2.专业分包 3.总承包 参考枚举SendingModeEnum")
   private Long sendingMode;
   @NotNull(message = "信息来源不能为空")
   @ApiModelProperty(name = "infoSource", value = "信息来源 参考枚举:InfoSourceEnum 1.销售与经理 2.经理与销售 3.销售")
   private Long infoSource;
   @NotNull(message = "装配式建筑不能为空")
   @ApiModelProperty(name = "isBuilding", value = "装配式建筑 1.是  0.否")
   private Integer isBuilding;
   @ApiModelProperty(name = "taxRate", notes = "发票税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "technologyRemark", value = "技术要求描述")
   private String technologyRemark;
   @ApiModelProperty(name = "structureStatus", value = "结构类型 参考枚举 structureStatusEnum：1.厂房 2.框架类 4.空间结构 8.梁式 16.拱式 32.钢架")
   private Long structureStatus;
   @ApiModelProperty(name = "pId", value = "父合同id")
   private Long pId;
   @ApiModelProperty(name = "haveMonomer", value = "是否有单体存在 1.有 0.没有")
   private Integer haveMonomer;
   @ApiModelProperty(name = "commercialClause", value = "商务条款")
   private String commercialClause;
   @ApiModelProperty(name = "technologyClause", value = "技术条款")
   private String technologyClause;
   @ApiModelProperty(name = "otherRemarks", value = "其他备注条款")
   private String otherRemarks;
   @ApiModelProperty(name = "contractType", value = "选择类型 1.创建主合同 2.工程量增补合同 3.其他补充协议 参考枚举：ContractTypeEnum")
   @NotNull(message = "项目类型不能为空")
   private Integer contractType;
   @ApiModelProperty(name = "unitType", value = "单位类型 1.吨 2.平方米")
   @NotNull(message = "单位类型不能为空")
   private Integer unitType;
   @ApiModelProperty(name = "infoSourceName", value = "信息来源名称")
   private String infoSourceName;
   @ApiModelProperty(name = "sendingModeName", value = "发包方式")
   private String sendingModeName;
   @ApiModelProperty(name = "partyTypeName", value = "甲方类型名称")
   private String partyTypeName;
   @ApiModelProperty(name = "structureStatusName", value = "结构类型美称")
   private String structureStatusName;
   @ApiModelProperty(name = "projectManagerScale", notes = "合同签订主体占比")
   private BigDecimal contractSignBodyScale;
   @ApiModelProperty(name = "projectManagerScale", notes = "项目经理占比")
   private BigDecimal projectManagerScale;

   public Long getProjectId() {
      return this.projectId;
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

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
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

   public String getSignerName() {
      return this.signerName;
   }

   public String getSignerPhone() {
      return this.signerPhone;
   }

   public Long getSalesLeaderId() {
      return this.salesLeaderId;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getManagementFeeRate() {
      return this.managementFeeRate;
   }

   public BigDecimal getManagementCostId() {
      return this.managementCostId;
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

   public List<Long> getAttachments() {
      return this.attachments;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.AttachmentDTOList;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Integer getOrderSourceType() {
      return this.orderSourceType;
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

   public Integer getAllDays() {
      return this.allDays;
   }

   public Long getPartyType() {
      return this.partyType;
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

   public List<Long> getProjectContent() {
      return this.projectContent;
   }

   public Integer getTransportMode() {
      return this.transportMode;
   }

   public Long getSignerId() {
      return this.signerId;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
   }

   public String getSigningAddress() {
      return this.signingAddress;
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

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getTechnologyRemark() {
      return this.technologyRemark;
   }

   public Long getStructureStatus() {
      return this.structureStatus;
   }

   public Long getPId() {
      return this.pId;
   }

   public Integer getHaveMonomer() {
      return this.haveMonomer;
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

   public Integer getContractType() {
      return this.contractType;
   }

   public Integer getUnitType() {
      return this.unitType;
   }

   public String getInfoSourceName() {
      return this.infoSourceName;
   }

   public String getSendingModeName() {
      return this.sendingModeName;
   }

   public String getPartyTypeName() {
      return this.partyTypeName;
   }

   public String getStructureStatusName() {
      return this.structureStatusName;
   }

   public BigDecimal getContractSignBodyScale() {
      return this.contractSignBodyScale;
   }

   public BigDecimal getProjectManagerScale() {
      return this.projectManagerScale;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
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

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setCityId(final Long cityId) {
      this.cityId = cityId;
   }

   public void setRegionId(final Long regionId) {
      this.regionId = regionId;
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

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setProjectManagerPhone(final String projectManagerPhone) {
      this.projectManagerPhone = projectManagerPhone;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setSignerPhone(final String signerPhone) {
      this.signerPhone = signerPhone;
   }

   public void setSalesLeaderId(final Long salesLeaderId) {
      this.salesLeaderId = salesLeaderId;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setManagementFeeRate(final BigDecimal managementFeeRate) {
      this.managementFeeRate = managementFeeRate;
   }

   public void setManagementCostId(final BigDecimal managementCostId) {
      this.managementCostId = managementCostId;
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

   public void setAttachments(final List<Long> attachments) {
      this.attachments = attachments;
   }

   public void setAttachmentDTOList(final List<AttachmentDTO> AttachmentDTOList) {
      this.AttachmentDTOList = AttachmentDTOList;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setOrderSourceType(final Integer orderSourceType) {
      this.orderSourceType = orderSourceType;
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

   public void setAllDays(final Integer allDays) {
      this.allDays = allDays;
   }

   public void setPartyType(final Long partyType) {
      this.partyType = partyType;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setProjectContent(final List<Long> projectContent) {
      this.projectContent = projectContent;
   }

   public void setTransportMode(final Integer transportMode) {
      this.transportMode = transportMode;
   }

   public void setSignerId(final Long signerId) {
      this.signerId = signerId;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
   }

   public void setSigningAddress(final String signingAddress) {
      this.signingAddress = signingAddress;
   }

   public void setSendingMode(final Long sendingMode) {
      this.sendingMode = sendingMode;
   }

   public void setInfoSource(final Long infoSource) {
      this.infoSource = infoSource;
   }

   public void setIsBuilding(final Integer isBuilding) {
      this.isBuilding = isBuilding;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setTechnologyRemark(final String technologyRemark) {
      this.technologyRemark = technologyRemark;
   }

   public void setStructureStatus(final Long structureStatus) {
      this.structureStatus = structureStatus;
   }

   public void setPId(final Long pId) {
      this.pId = pId;
   }

   public void setHaveMonomer(final Integer haveMonomer) {
      this.haveMonomer = haveMonomer;
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

   public void setContractType(final Integer contractType) {
      this.contractType = contractType;
   }

   public void setUnitType(final Integer unitType) {
      this.unitType = unitType;
   }

   public void setInfoSourceName(final String infoSourceName) {
      this.infoSourceName = infoSourceName;
   }

   public void setSendingModeName(final String sendingModeName) {
      this.sendingModeName = sendingModeName;
   }

   public void setPartyTypeName(final String partyTypeName) {
      this.partyTypeName = partyTypeName;
   }

   public void setStructureStatusName(final String structureStatusName) {
      this.structureStatusName = structureStatusName;
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

      if (!(o instanceof BaseSaveDTOParam)) {
         return false;
      }

      BaseSaveDTOParam other = (BaseSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
                     Object this$projectManagerId = this.getProjectManagerId();
                     Object other$projectManagerId = other.getProjectManagerId();
                     if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                        Object this$salesLeaderId = this.getSalesLeaderId();
                        Object other$salesLeaderId = other.getSalesLeaderId();
                        if (this$salesLeaderId == null ? other$salesLeaderId == null : this$salesLeaderId.equals(other$salesLeaderId)) {
                           Object this$projectAttribute = this.getProjectAttribute();
                           Object other$projectAttribute = other.getProjectAttribute();
                           if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                              Object this$orderSourceType = this.getOrderSourceType();
                              Object other$orderSourceType = other.getOrderSourceType();
                              if (this$orderSourceType == null ? other$orderSourceType == null : this$orderSourceType.equals(other$orderSourceType)) {
                                 Object this$deptId = this.getDeptId();
                                 Object other$deptId = other.getDeptId();
                                 if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
                                    Object this$allDays = this.getAllDays();
                                    Object other$allDays = other.getAllDays();
                                    if (this$allDays == null ? other$allDays == null : this$allDays.equals(other$allDays)) {
                                       Object this$partyType = this.getPartyType();
                                       Object other$partyType = other.getPartyType();
                                       if (this$partyType == null ? other$partyType == null : this$partyType.equals(other$partyType)) {
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
                                                      Object this$signerId = this.getSignerId();
                                                      Object other$signerId = other.getSignerId();
                                                      if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
                                                         Object this$sendingMode = this.getSendingMode();
                                                         Object other$sendingMode = other.getSendingMode();
                                                         if (this$sendingMode == null ? other$sendingMode == null : this$sendingMode.equals(other$sendingMode)) {
                                                            Object this$infoSource = this.getInfoSource();
                                                            Object other$infoSource = other.getInfoSource();
                                                            if (this$infoSource == null ? other$infoSource == null : this$infoSource.equals(other$infoSource)) {
                                                               Object this$isBuilding = this.getIsBuilding();
                                                               Object other$isBuilding = other.getIsBuilding();
                                                               if (this$isBuilding == null
                                                                  ? other$isBuilding == null
                                                                  : this$isBuilding.equals(other$isBuilding)) {
                                                                  Object this$structureStatus = this.getStructureStatus();
                                                                  Object other$structureStatus = other.getStructureStatus();
                                                                  if (this$structureStatus == null
                                                                     ? other$structureStatus == null
                                                                     : this$structureStatus.equals(other$structureStatus)) {
                                                                     Object this$pId = this.getPId();
                                                                     Object other$pId = other.getPId();
                                                                     if (this$pId == null ? other$pId == null : this$pId.equals(other$pId)) {
                                                                        Object this$haveMonomer = this.getHaveMonomer();
                                                                        Object other$haveMonomer = other.getHaveMonomer();
                                                                        if (this$haveMonomer == null
                                                                           ? other$haveMonomer == null
                                                                           : this$haveMonomer.equals(other$haveMonomer)) {
                                                                           Object this$contractType = this.getContractType();
                                                                           Object other$contractType = other.getContractType();
                                                                           if (this$contractType == null
                                                                              ? other$contractType == null
                                                                              : this$contractType.equals(other$contractType)) {
                                                                              Object this$unitType = this.getUnitType();
                                                                              Object other$unitType = other.getUnitType();
                                                                              if (this$unitType == null
                                                                                 ? other$unitType == null
                                                                                 : this$unitType.equals(other$unitType)) {
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
                                                                                                   Object this$projectManagerName = this.getProjectManagerName();
                                                                                                   Object other$projectManagerName = other.getProjectManagerName();
                                                                                                   if (this$projectManagerName == null
                                                                                                      ? other$projectManagerName == null
                                                                                                      : this$projectManagerName.equals(other$projectManagerName)
                                                                                                      )
                                                                                                    {
                                                                                                      Object this$projectManagerPhone = this.getProjectManagerPhone();
                                                                                                      Object other$projectManagerPhone = other.getProjectManagerPhone();
                                                                                                      if (this$projectManagerPhone == null
                                                                                                         ? other$projectManagerPhone == null
                                                                                                         : this$projectManagerPhone.equals(
                                                                                                            other$projectManagerPhone
                                                                                                         )) {
                                                                                                         Object this$signerName = this.getSignerName();
                                                                                                         Object other$signerName = other.getSignerName();
                                                                                                         if (this$signerName == null
                                                                                                            ? other$signerName == null
                                                                                                            : this$signerName.equals(other$signerName)) {
                                                                                                            Object this$signerPhone = this.getSignerPhone();
                                                                                                            Object other$signerPhone = other.getSignerPhone();
                                                                                                            if (this$signerPhone == null
                                                                                                               ? other$signerPhone == null
                                                                                                               : this$signerPhone.equals(other$signerPhone)) {
                                                                                                               Object this$contractAmount = this.getContractAmount();
                                                                                                               Object other$contractAmount = other.getContractAmount();
                                                                                                               if (this$contractAmount == null
                                                                                                                  ? other$contractAmount == null
                                                                                                                  : this$contractAmount.equals(
                                                                                                                     other$contractAmount
                                                                                                                  )) {
                                                                                                                  Object this$managementFeeRate = this.getManagementFeeRate();
                                                                                                                  Object other$managementFeeRate = other.getManagementFeeRate();
                                                                                                                  if (this$managementFeeRate == null
                                                                                                                     ? other$managementFeeRate == null
                                                                                                                     : this$managementFeeRate.equals(
                                                                                                                        other$managementFeeRate
                                                                                                                     )) {
                                                                                                                     Object this$managementCostId = this.getManagementCostId();
                                                                                                                     Object other$managementCostId = other.getManagementCostId();
                                                                                                                     if (this$managementCostId == null
                                                                                                                        ? other$managementCostId == null
                                                                                                                        : this$managementCostId.equals(
                                                                                                                           other$managementCostId
                                                                                                                        )) {
                                                                                                                        Object this$marginAmount = this.getMarginAmount();
                                                                                                                        Object other$marginAmount = other.getMarginAmount();
                                                                                                                        if (this$marginAmount == null
                                                                                                                           ? other$marginAmount == null
                                                                                                                           : this$marginAmount.equals(
                                                                                                                              other$marginAmount
                                                                                                                           )) {
                                                                                                                           Object this$marginType = this.getMarginType();
                                                                                                                           Object other$marginType = other.getMarginType();
                                                                                                                           if (this$marginType == null
                                                                                                                              ? other$marginType == null
                                                                                                                              : this$marginType.equals(
                                                                                                                                 other$marginType
                                                                                                                              )) {
                                                                                                                              Object this$currencyType = this.getCurrencyType();
                                                                                                                              Object other$currencyType = other.getCurrencyType();
                                                                                                                              if (this$currencyType == null
                                                                                                                                 ? other$currencyType == null
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
                                                                                                                                    Object this$attachments = this.getAttachments();
                                                                                                                                    Object other$attachments = other.getAttachments();
                                                                                                                                    if (this$attachments
                                                                                                                                          == null
                                                                                                                                       ? other$attachments
                                                                                                                                          == null
                                                                                                                                       : this$attachments.equals(
                                                                                                                                          other$attachments
                                                                                                                                       )) {
                                                                                                                                       Object this$AttachmentDTOList = this.getAttachmentDTOList();
                                                                                                                                       Object other$AttachmentDTOList = other.getAttachmentDTOList();
                                                                                                                                       if (this$AttachmentDTOList
                                                                                                                                             == null
                                                                                                                                          ? other$AttachmentDTOList
                                                                                                                                             == null
                                                                                                                                          : this$AttachmentDTOList.equals(
                                                                                                                                             other$AttachmentDTOList
                                                                                                                                          )) {
                                                                                                                                          Object this$deptName = this.getDeptName();
                                                                                                                                          Object other$deptName = other.getDeptName();
                                                                                                                                          if (this$deptName
                                                                                                                                                == null
                                                                                                                                             ? other$deptName
                                                                                                                                                == null
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
                                                                                                                                                Object this$projectContent = this.getProjectContent();
                                                                                                                                                Object other$projectContent = other.getProjectContent();
                                                                                                                                                if (this$projectContent
                                                                                                                                                      == null
                                                                                                                                                   ? other$projectContent
                                                                                                                                                      == null
                                                                                                                                                   : this$projectContent.equals(
                                                                                                                                                      other$projectContent
                                                                                                                                                   )) {
                                                                                                                                                   Object this$signingDate = this.getSigningDate();
                                                                                                                                                   Object other$signingDate = other.getSigningDate();
                                                                                                                                                   if (this$signingDate
                                                                                                                                                         == null
                                                                                                                                                      ? other$signingDate
                                                                                                                                                         == null
                                                                                                                                                      : this$signingDate.equals(
                                                                                                                                                         other$signingDate
                                                                                                                                                      )) {
                                                                                                                                                      Object this$signingAddress = this.getSigningAddress();
                                                                                                                                                      Object other$signingAddress = other.getSigningAddress();
                                                                                                                                                      if (this$signingAddress
                                                                                                                                                            == null
                                                                                                                                                         ? other$signingAddress
                                                                                                                                                            == null
                                                                                                                                                         : this$signingAddress.equals(
                                                                                                                                                            other$signingAddress
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
                                                                                                                                                                        Object this$infoSourceName = this.getInfoSourceName();
                                                                                                                                                                        Object other$infoSourceName = other.getInfoSourceName();
                                                                                                                                                                        if (this$infoSourceName
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$infoSourceName
                                                                                                                                                                              == null
                                                                                                                                                                           : this$infoSourceName.equals(
                                                                                                                                                                              other$infoSourceName
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$sendingModeName = this.getSendingModeName();
                                                                                                                                                                           Object other$sendingModeName = other.getSendingModeName();
                                                                                                                                                                           if (this$sendingModeName
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$sendingModeName
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$sendingModeName.equals(
                                                                                                                                                                                 other$sendingModeName
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$partyTypeName = this.getPartyTypeName();
                                                                                                                                                                              Object other$partyTypeName = other.getPartyTypeName();
                                                                                                                                                                              if (this$partyTypeName
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$partyTypeName
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$partyTypeName.equals(
                                                                                                                                                                                    other$partyTypeName
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$structureStatusName = this.getStructureStatusName();
                                                                                                                                                                                 Object other$structureStatusName = other.getStructureStatusName();
                                                                                                                                                                                 if (this$structureStatusName
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$structureStatusName
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$structureStatusName.equals(
                                                                                                                                                                                       other$structureStatusName
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
               } else {
                  return false;
               }
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
      return other instanceof BaseSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $salesLeaderId = this.getSalesLeaderId();
      result = result * 59 + ($salesLeaderId == null ? 43 : $salesLeaderId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $orderSourceType = this.getOrderSourceType();
      result = result * 59 + ($orderSourceType == null ? 43 : $orderSourceType.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $allDays = this.getAllDays();
      result = result * 59 + ($allDays == null ? 43 : $allDays.hashCode());
      Object $partyType = this.getPartyType();
      result = result * 59 + ($partyType == null ? 43 : $partyType.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $transportMode = this.getTransportMode();
      result = result * 59 + ($transportMode == null ? 43 : $transportMode.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
      Object $sendingMode = this.getSendingMode();
      result = result * 59 + ($sendingMode == null ? 43 : $sendingMode.hashCode());
      Object $infoSource = this.getInfoSource();
      result = result * 59 + ($infoSource == null ? 43 : $infoSource.hashCode());
      Object $isBuilding = this.getIsBuilding();
      result = result * 59 + ($isBuilding == null ? 43 : $isBuilding.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $pId = this.getPId();
      result = result * 59 + ($pId == null ? 43 : $pId.hashCode());
      Object $haveMonomer = this.getHaveMonomer();
      result = result * 59 + ($haveMonomer == null ? 43 : $haveMonomer.hashCode());
      Object $contractType = this.getContractType();
      result = result * 59 + ($contractType == null ? 43 : $contractType.hashCode());
      Object $unitType = this.getUnitType();
      result = result * 59 + ($unitType == null ? 43 : $unitType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $projectManagerPhone = this.getProjectManagerPhone();
      result = result * 59 + ($projectManagerPhone == null ? 43 : $projectManagerPhone.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $signerPhone = this.getSignerPhone();
      result = result * 59 + ($signerPhone == null ? 43 : $signerPhone.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $managementFeeRate = this.getManagementFeeRate();
      result = result * 59 + ($managementFeeRate == null ? 43 : $managementFeeRate.hashCode());
      Object $managementCostId = this.getManagementCostId();
      result = result * 59 + ($managementCostId == null ? 43 : $managementCostId.hashCode());
      Object $marginAmount = this.getMarginAmount();
      result = result * 59 + ($marginAmount == null ? 43 : $marginAmount.hashCode());
      Object $marginType = this.getMarginType();
      result = result * 59 + ($marginType == null ? 43 : $marginType.hashCode());
      Object $currencyType = this.getCurrencyType();
      result = result * 59 + ($currencyType == null ? 43 : $currencyType.hashCode());
      Object $qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
      result = result * 59 + ($qualityGuaranteeDeposit == null ? 43 : $qualityGuaranteeDeposit.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $AttachmentDTOList = this.getAttachmentDTOList();
      result = result * 59 + ($AttachmentDTOList == null ? 43 : $AttachmentDTOList.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $structureArea = this.getStructureArea();
      result = result * 59 + ($structureArea == null ? 43 : $structureArea.hashCode());
      Object $projectContent = this.getProjectContent();
      result = result * 59 + ($projectContent == null ? 43 : $projectContent.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $signingAddress = this.getSigningAddress();
      result = result * 59 + ($signingAddress == null ? 43 : $signingAddress.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $technologyRemark = this.getTechnologyRemark();
      result = result * 59 + ($technologyRemark == null ? 43 : $technologyRemark.hashCode());
      Object $commercialClause = this.getCommercialClause();
      result = result * 59 + ($commercialClause == null ? 43 : $commercialClause.hashCode());
      Object $technologyClause = this.getTechnologyClause();
      result = result * 59 + ($technologyClause == null ? 43 : $technologyClause.hashCode());
      Object $otherRemarks = this.getOtherRemarks();
      result = result * 59 + ($otherRemarks == null ? 43 : $otherRemarks.hashCode());
      Object $infoSourceName = this.getInfoSourceName();
      result = result * 59 + ($infoSourceName == null ? 43 : $infoSourceName.hashCode());
      Object $sendingModeName = this.getSendingModeName();
      result = result * 59 + ($sendingModeName == null ? 43 : $sendingModeName.hashCode());
      Object $partyTypeName = this.getPartyTypeName();
      result = result * 59 + ($partyTypeName == null ? 43 : $partyTypeName.hashCode());
      Object $structureStatusName = this.getStructureStatusName();
      result = result * 59 + ($structureStatusName == null ? 43 : $structureStatusName.hashCode());
      Object $contractSignBodyScale = this.getContractSignBodyScale();
      result = result * 59 + ($contractSignBodyScale == null ? 43 : $contractSignBodyScale.hashCode());
      Object $projectManagerScale = this.getProjectManagerScale();
      return result * 59 + ($projectManagerScale == null ? 43 : $projectManagerScale.hashCode());
   }

   @Override
   public String toString() {
      return "BaseSaveDTOParam(projectId="
         + this.getProjectId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
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
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", projectManagerPhone="
         + this.getProjectManagerPhone()
         + ", signerName="
         + this.getSignerName()
         + ", signerPhone="
         + this.getSignerPhone()
         + ", salesLeaderId="
         + this.getSalesLeaderId()
         + ", contractAmount="
         + this.getContractAmount()
         + ", managementFeeRate="
         + this.getManagementFeeRate()
         + ", managementCostId="
         + this.getManagementCostId()
         + ", marginAmount="
         + this.getMarginAmount()
         + ", marginType="
         + this.getMarginType()
         + ", currencyType="
         + this.getCurrencyType()
         + ", qualityGuaranteeDeposit="
         + this.getQualityGuaranteeDeposit()
         + ", attachments="
         + this.getAttachments()
         + ", AttachmentDTOList="
         + this.getAttachmentDTOList()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", orderSourceType="
         + this.getOrderSourceType()
         + ", deptId="
         + this.getDeptId()
         + ", deptName="
         + this.getDeptName()
         + ", structureArea="
         + this.getStructureArea()
         + ", allDays="
         + this.getAllDays()
         + ", partyType="
         + this.getPartyType()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", businessType="
         + this.getBusinessType()
         + ", projectType="
         + this.getProjectType()
         + ", projectContent="
         + this.getProjectContent()
         + ", transportMode="
         + this.getTransportMode()
         + ", signerId="
         + this.getSignerId()
         + ", signingDate="
         + this.getSigningDate()
         + ", signingAddress="
         + this.getSigningAddress()
         + ", sendingMode="
         + this.getSendingMode()
         + ", infoSource="
         + this.getInfoSource()
         + ", isBuilding="
         + this.getIsBuilding()
         + ", taxRate="
         + this.getTaxRate()
         + ", technologyRemark="
         + this.getTechnologyRemark()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", pId="
         + this.getPId()
         + ", haveMonomer="
         + this.getHaveMonomer()
         + ", commercialClause="
         + this.getCommercialClause()
         + ", technologyClause="
         + this.getTechnologyClause()
         + ", otherRemarks="
         + this.getOtherRemarks()
         + ", contractType="
         + this.getContractType()
         + ", unitType="
         + this.getUnitType()
         + ", infoSourceName="
         + this.getInfoSourceName()
         + ", sendingModeName="
         + this.getSendingModeName()
         + ", partyTypeName="
         + this.getPartyTypeName()
         + ", structureStatusName="
         + this.getStructureStatusName()
         + ", contractSignBodyScale="
         + this.getContractSignBodyScale()
         + ", projectManagerScale="
         + this.getProjectManagerScale()
         + ")";
   }
}
