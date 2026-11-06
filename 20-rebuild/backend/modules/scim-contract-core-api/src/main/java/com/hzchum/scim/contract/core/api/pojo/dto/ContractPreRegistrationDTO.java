package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContractPreRegistrationDTO {
   private Long id;
   @ApiModelProperty(name = "applicantId", value = "申请人ID")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称")
   private String applicantName;
   @ApiModelProperty(name = "applicantDeptId", value = "申请人部门Id")
   private Long applicantDeptId;
   @ApiModelProperty(name = "applicantDeptName", value = "申请人部门")
   private String applicantDeptName;
   @ApiModelProperty(name = "applicationDate", value = "申请日期")
   private LocalDateTime applicationDate;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态")
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewPassTime", value = "审核通过时间")
   private LocalDateTime reviewPassTime;
   @ApiModelProperty(name = "preRegistrationNo", value = "合同预登记编号")
   private String preRegistrationNo;
   @ApiModelProperty(name = "contractNumber", value = "合同目录编号")
   private String contractNumber;
   @ApiModelProperty(name = "partyType", value = "甲方类别")
   private Long partyType;
   @ApiModelProperty(name = "partyTypeValue", value = "甲方类别值")
   private String partyTypeValue;
   @ApiModelProperty(name = "partyName", value = "甲方或业主名称")
   private String partyName;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "contractAmount", value = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "boolBidWinningNotice", value = "是否存在中标通知书")
   private Boolean boolBidWinningNotice;
   @ApiModelProperty(name = "structureType", value = "结构类型")
   private Long structureType;
   @ApiModelProperty(name = "structureTypeValue", value = "结构类型值")
   private String structureTypeValue;
   @ApiModelProperty(name = "contractualNature", value = "承包性质")
   private Long contractualNature;
   @ApiModelProperty(name = "contractualNatureValue", value = "承包性质值")
   private String contractualNatureValue;
   @ApiModelProperty(name = "signerId", value = "签订人ID")
   private Long signerId;
   @ApiModelProperty(name = "signerName", value = "签订人姓名")
   private String signerName;
   @ApiModelProperty(name = "locationId", value = "区域Id")
   private Long locationId;
   @ApiModelProperty(name = "locationValue", value = "区域值")
   private String locationValue;
   @ApiModelProperty(name = "countryId", value = "国家ID")
   private Long countryId;
   @ApiModelProperty(name = "countryValue", value = "国家值")
   private String countryValue;
   @ApiModelProperty(name = "provinceId", value = "省份ID")
   private Long provinceId;
   @ApiModelProperty(name = "provinceValue", value = "省份值")
   private String provinceValue;
   @ApiModelProperty(name = "cityId", value = "城市ID")
   private Long cityId;
   @ApiModelProperty(name = "cityValue", value = "城市值")
   private String cityValue;
   @ApiModelProperty(name = "regionId", value = "区ID")
   private Long regionId;
   @ApiModelProperty(name = "regionValue", value = "区值")
   private String regionValue;
   @ApiModelProperty(name = "structureArea", value = "建筑面积（平方米）")
   private BigDecimal structureArea;
   @ApiModelProperty(name = "infoSource", value = "信息来源")
   private Integer infoSource;
   @ApiModelProperty(name = "boolQuote", value = "是否引用")
   private Boolean boolQuote;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO;
   @ApiModelProperty(name = "contractCatalogueId", value = "合同目录ID")
   private Long contractCatalogueId;
   @ApiModelProperty(name = "contractCatalogueDTO", value = "合同目录信息")
   private ContractCatalogueDTO contractCatalogueDTO;
   @ApiModelProperty(name = "contractCatalogueStatus", value = "合同目录状态")
   private Integer contractCatalogueStatus;

   ContractPreRegistrationDTO(
      final Long id,
      final Long applicantId,
      final String applicantName,
      final Long applicantDeptId,
      final String applicantDeptName,
      final LocalDateTime applicationDate,
      final Integer reviewStatus,
      final LocalDateTime reviewPassTime,
      final String preRegistrationNo,
      final String contractNumber,
      final Long partyType,
      final String partyTypeValue,
      final String partyName,
      final String projectName,
      final BigDecimal contractAmount,
      final Boolean boolBidWinningNotice,
      final Long structureType,
      final String structureTypeValue,
      final Long contractualNature,
      final String contractualNatureValue,
      final Long signerId,
      final String signerName,
      final Long locationId,
      final String locationValue,
      final Long countryId,
      final String countryValue,
      final Long provinceId,
      final String provinceValue,
      final Long cityId,
      final String cityValue,
      final Long regionId,
      final String regionValue,
      final BigDecimal structureArea,
      final Integer infoSource,
      final Boolean boolQuote,
      final String remark,
      final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO,
      final Long contractCatalogueId,
      final ContractCatalogueDTO contractCatalogueDTO,
      final Integer contractCatalogueStatus
   ) {
      this.id = id;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.applicantDeptId = applicantDeptId;
      this.applicantDeptName = applicantDeptName;
      this.applicationDate = applicationDate;
      this.reviewStatus = reviewStatus;
      this.reviewPassTime = reviewPassTime;
      this.preRegistrationNo = preRegistrationNo;
      this.contractNumber = contractNumber;
      this.partyType = partyType;
      this.partyTypeValue = partyTypeValue;
      this.partyName = partyName;
      this.projectName = projectName;
      this.contractAmount = contractAmount;
      this.boolBidWinningNotice = boolBidWinningNotice;
      this.structureType = structureType;
      this.structureTypeValue = structureTypeValue;
      this.contractualNature = contractualNature;
      this.contractualNatureValue = contractualNatureValue;
      this.signerId = signerId;
      this.signerName = signerName;
      this.locationId = locationId;
      this.locationValue = locationValue;
      this.countryId = countryId;
      this.countryValue = countryValue;
      this.provinceId = provinceId;
      this.provinceValue = provinceValue;
      this.cityId = cityId;
      this.cityValue = cityValue;
      this.regionId = regionId;
      this.regionValue = regionValue;
      this.structureArea = structureArea;
      this.infoSource = infoSource;
      this.boolQuote = boolQuote;
      this.remark = remark;
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
      this.contractCatalogueId = contractCatalogueId;
      this.contractCatalogueDTO = contractCatalogueDTO;
      this.contractCatalogueStatus = contractCatalogueStatus;
   }

   public static ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder builder() {
      return new ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder();
   }

   public Long getId() {
      return this.id;
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

   public String getApplicantDeptName() {
      return this.applicantDeptName;
   }

   public LocalDateTime getApplicationDate() {
      return this.applicationDate;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public LocalDateTime getReviewPassTime() {
      return this.reviewPassTime;
   }

   public String getPreRegistrationNo() {
      return this.preRegistrationNo;
   }

   public String getContractNumber() {
      return this.contractNumber;
   }

   public Long getPartyType() {
      return this.partyType;
   }

   public String getPartyTypeValue() {
      return this.partyTypeValue;
   }

   public String getPartyName() {
      return this.partyName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public Boolean getBoolBidWinningNotice() {
      return this.boolBidWinningNotice;
   }

   public Long getStructureType() {
      return this.structureType;
   }

   public String getStructureTypeValue() {
      return this.structureTypeValue;
   }

   public Long getContractualNature() {
      return this.contractualNature;
   }

   public String getContractualNatureValue() {
      return this.contractualNatureValue;
   }

   public Long getSignerId() {
      return this.signerId;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public Long getLocationId() {
      return this.locationId;
   }

   public String getLocationValue() {
      return this.locationValue;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public String getCountryValue() {
      return this.countryValue;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public String getProvinceValue() {
      return this.provinceValue;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public String getCityValue() {
      return this.cityValue;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public String getRegionValue() {
      return this.regionValue;
   }

   public BigDecimal getStructureArea() {
      return this.structureArea;
   }

   public Integer getInfoSource() {
      return this.infoSource;
   }

   public Boolean getBoolQuote() {
      return this.boolQuote;
   }

   public String getRemark() {
      return this.remark;
   }

   public WmsApproveRecordFlowDTO getWmsApproveRecordFlowDTO() {
      return this.wmsApproveRecordFlowDTO;
   }

   public Long getContractCatalogueId() {
      return this.contractCatalogueId;
   }

   public ContractCatalogueDTO getContractCatalogueDTO() {
      return this.contractCatalogueDTO;
   }

   public Integer getContractCatalogueStatus() {
      return this.contractCatalogueStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setApplicantDeptId(final Long applicantDeptId) {
      this.applicantDeptId = applicantDeptId;
   }

   public void setApplicantDeptName(final String applicantDeptName) {
      this.applicantDeptName = applicantDeptName;
   }

   public void setApplicationDate(final LocalDateTime applicationDate) {
      this.applicationDate = applicationDate;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setReviewPassTime(final LocalDateTime reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
   }

   public void setPreRegistrationNo(final String preRegistrationNo) {
      this.preRegistrationNo = preRegistrationNo;
   }

   public void setContractNumber(final String contractNumber) {
      this.contractNumber = contractNumber;
   }

   public void setPartyType(final Long partyType) {
      this.partyType = partyType;
   }

   public void setPartyTypeValue(final String partyTypeValue) {
      this.partyTypeValue = partyTypeValue;
   }

   public void setPartyName(final String partyName) {
      this.partyName = partyName;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setBoolBidWinningNotice(final Boolean boolBidWinningNotice) {
      this.boolBidWinningNotice = boolBidWinningNotice;
   }

   public void setStructureType(final Long structureType) {
      this.structureType = structureType;
   }

   public void setStructureTypeValue(final String structureTypeValue) {
      this.structureTypeValue = structureTypeValue;
   }

   public void setContractualNature(final Long contractualNature) {
      this.contractualNature = contractualNature;
   }

   public void setContractualNatureValue(final String contractualNatureValue) {
      this.contractualNatureValue = contractualNatureValue;
   }

   public void setSignerId(final Long signerId) {
      this.signerId = signerId;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setLocationId(final Long locationId) {
      this.locationId = locationId;
   }

   public void setLocationValue(final String locationValue) {
      this.locationValue = locationValue;
   }

   public void setCountryId(final Long countryId) {
      this.countryId = countryId;
   }

   public void setCountryValue(final String countryValue) {
      this.countryValue = countryValue;
   }

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setProvinceValue(final String provinceValue) {
      this.provinceValue = provinceValue;
   }

   public void setCityId(final Long cityId) {
      this.cityId = cityId;
   }

   public void setCityValue(final String cityValue) {
      this.cityValue = cityValue;
   }

   public void setRegionId(final Long regionId) {
      this.regionId = regionId;
   }

   public void setRegionValue(final String regionValue) {
      this.regionValue = regionValue;
   }

   public void setStructureArea(final BigDecimal structureArea) {
      this.structureArea = structureArea;
   }

   public void setInfoSource(final Integer infoSource) {
      this.infoSource = infoSource;
   }

   public void setBoolQuote(final Boolean boolQuote) {
      this.boolQuote = boolQuote;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setWmsApproveRecordFlowDTO(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO) {
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
   }

   public void setContractCatalogueId(final Long contractCatalogueId) {
      this.contractCatalogueId = contractCatalogueId;
   }

   public void setContractCatalogueDTO(final ContractCatalogueDTO contractCatalogueDTO) {
      this.contractCatalogueDTO = contractCatalogueDTO;
   }

   public void setContractCatalogueStatus(final Integer contractCatalogueStatus) {
      this.contractCatalogueStatus = contractCatalogueStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractPreRegistrationDTO)) {
         return false;
      }

      ContractPreRegistrationDTO other = (ContractPreRegistrationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$applicantId = this.getApplicantId();
         Object other$applicantId = other.getApplicantId();
         if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
            Object this$applicantDeptId = this.getApplicantDeptId();
            Object other$applicantDeptId = other.getApplicantDeptId();
            if (this$applicantDeptId == null ? other$applicantDeptId == null : this$applicantDeptId.equals(other$applicantDeptId)) {
               Object this$reviewStatus = this.getReviewStatus();
               Object other$reviewStatus = other.getReviewStatus();
               if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                  Object this$partyType = this.getPartyType();
                  Object other$partyType = other.getPartyType();
                  if (this$partyType == null ? other$partyType == null : this$partyType.equals(other$partyType)) {
                     Object this$boolBidWinningNotice = this.getBoolBidWinningNotice();
                     Object other$boolBidWinningNotice = other.getBoolBidWinningNotice();
                     if (this$boolBidWinningNotice == null ? other$boolBidWinningNotice == null : this$boolBidWinningNotice.equals(other$boolBidWinningNotice)) {
                        Object this$structureType = this.getStructureType();
                        Object other$structureType = other.getStructureType();
                        if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                           Object this$contractualNature = this.getContractualNature();
                           Object other$contractualNature = other.getContractualNature();
                           if (this$contractualNature == null ? other$contractualNature == null : this$contractualNature.equals(other$contractualNature)) {
                              Object this$signerId = this.getSignerId();
                              Object other$signerId = other.getSignerId();
                              if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
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
                                                Object this$infoSource = this.getInfoSource();
                                                Object other$infoSource = other.getInfoSource();
                                                if (this$infoSource == null ? other$infoSource == null : this$infoSource.equals(other$infoSource)) {
                                                   Object this$boolQuote = this.getBoolQuote();
                                                   Object other$boolQuote = other.getBoolQuote();
                                                   if (this$boolQuote == null ? other$boolQuote == null : this$boolQuote.equals(other$boolQuote)) {
                                                      Object this$contractCatalogueId = this.getContractCatalogueId();
                                                      Object other$contractCatalogueId = other.getContractCatalogueId();
                                                      if (this$contractCatalogueId == null
                                                         ? other$contractCatalogueId == null
                                                         : this$contractCatalogueId.equals(other$contractCatalogueId)) {
                                                         Object this$contractCatalogueStatus = this.getContractCatalogueStatus();
                                                         Object other$contractCatalogueStatus = other.getContractCatalogueStatus();
                                                         if (this$contractCatalogueStatus == null
                                                            ? other$contractCatalogueStatus == null
                                                            : this$contractCatalogueStatus.equals(other$contractCatalogueStatus)) {
                                                            Object this$applicantName = this.getApplicantName();
                                                            Object other$applicantName = other.getApplicantName();
                                                            if (this$applicantName == null
                                                               ? other$applicantName == null
                                                               : this$applicantName.equals(other$applicantName)) {
                                                               Object this$applicantDeptName = this.getApplicantDeptName();
                                                               Object other$applicantDeptName = other.getApplicantDeptName();
                                                               if (this$applicantDeptName == null
                                                                  ? other$applicantDeptName == null
                                                                  : this$applicantDeptName.equals(other$applicantDeptName)) {
                                                                  Object this$applicationDate = this.getApplicationDate();
                                                                  Object other$applicationDate = other.getApplicationDate();
                                                                  if (this$applicationDate == null
                                                                     ? other$applicationDate == null
                                                                     : this$applicationDate.equals(other$applicationDate)) {
                                                                     Object this$reviewPassTime = this.getReviewPassTime();
                                                                     Object other$reviewPassTime = other.getReviewPassTime();
                                                                     if (this$reviewPassTime == null
                                                                        ? other$reviewPassTime == null
                                                                        : this$reviewPassTime.equals(other$reviewPassTime)) {
                                                                        Object this$preRegistrationNo = this.getPreRegistrationNo();
                                                                        Object other$preRegistrationNo = other.getPreRegistrationNo();
                                                                        if (this$preRegistrationNo == null
                                                                           ? other$preRegistrationNo == null
                                                                           : this$preRegistrationNo.equals(other$preRegistrationNo)) {
                                                                           Object this$contractNumber = this.getContractNumber();
                                                                           Object other$contractNumber = other.getContractNumber();
                                                                           if (this$contractNumber == null
                                                                              ? other$contractNumber == null
                                                                              : this$contractNumber.equals(other$contractNumber)) {
                                                                              Object this$partyTypeValue = this.getPartyTypeValue();
                                                                              Object other$partyTypeValue = other.getPartyTypeValue();
                                                                              if (this$partyTypeValue == null
                                                                                 ? other$partyTypeValue == null
                                                                                 : this$partyTypeValue.equals(other$partyTypeValue)) {
                                                                                 Object this$partyName = this.getPartyName();
                                                                                 Object other$partyName = other.getPartyName();
                                                                                 if (this$partyName == null
                                                                                    ? other$partyName == null
                                                                                    : this$partyName.equals(other$partyName)) {
                                                                                    Object this$projectName = this.getProjectName();
                                                                                    Object other$projectName = other.getProjectName();
                                                                                    if (this$projectName == null
                                                                                       ? other$projectName == null
                                                                                       : this$projectName.equals(other$projectName)) {
                                                                                       Object this$contractAmount = this.getContractAmount();
                                                                                       Object other$contractAmount = other.getContractAmount();
                                                                                       if (this$contractAmount == null
                                                                                          ? other$contractAmount == null
                                                                                          : this$contractAmount.equals(other$contractAmount)) {
                                                                                          Object this$structureTypeValue = this.getStructureTypeValue();
                                                                                          Object other$structureTypeValue = other.getStructureTypeValue();
                                                                                          if (this$structureTypeValue == null
                                                                                             ? other$structureTypeValue == null
                                                                                             : this$structureTypeValue.equals(other$structureTypeValue)) {
                                                                                             Object this$contractualNatureValue = this.getContractualNatureValue();
                                                                                             Object other$contractualNatureValue = other.getContractualNatureValue();
                                                                                             if (this$contractualNatureValue == null
                                                                                                ? other$contractualNatureValue == null
                                                                                                : this$contractualNatureValue.equals(
                                                                                                   other$contractualNatureValue
                                                                                                )) {
                                                                                                Object this$signerName = this.getSignerName();
                                                                                                Object other$signerName = other.getSignerName();
                                                                                                if (this$signerName == null
                                                                                                   ? other$signerName == null
                                                                                                   : this$signerName.equals(other$signerName)) {
                                                                                                   Object this$locationValue = this.getLocationValue();
                                                                                                   Object other$locationValue = other.getLocationValue();
                                                                                                   if (this$locationValue == null
                                                                                                      ? other$locationValue == null
                                                                                                      : this$locationValue.equals(other$locationValue)) {
                                                                                                      Object this$countryValue = this.getCountryValue();
                                                                                                      Object other$countryValue = other.getCountryValue();
                                                                                                      if (this$countryValue == null
                                                                                                         ? other$countryValue == null
                                                                                                         : this$countryValue.equals(other$countryValue)) {
                                                                                                         Object this$provinceValue = this.getProvinceValue();
                                                                                                         Object other$provinceValue = other.getProvinceValue();
                                                                                                         if (this$provinceValue == null
                                                                                                            ? other$provinceValue == null
                                                                                                            : this$provinceValue.equals(other$provinceValue)) {
                                                                                                            Object this$cityValue = this.getCityValue();
                                                                                                            Object other$cityValue = other.getCityValue();
                                                                                                            if (this$cityValue == null
                                                                                                               ? other$cityValue == null
                                                                                                               : this$cityValue.equals(other$cityValue)) {
                                                                                                               Object this$regionValue = this.getRegionValue();
                                                                                                               Object other$regionValue = other.getRegionValue();
                                                                                                               if (this$regionValue == null
                                                                                                                  ? other$regionValue == null
                                                                                                                  : this$regionValue.equals(other$regionValue)) {
                                                                                                                  Object this$structureArea = this.getStructureArea();
                                                                                                                  Object other$structureArea = other.getStructureArea();
                                                                                                                  if (this$structureArea == null
                                                                                                                     ? other$structureArea == null
                                                                                                                     : this$structureArea.equals(
                                                                                                                        other$structureArea
                                                                                                                     )) {
                                                                                                                     Object this$remark = this.getRemark();
                                                                                                                     Object other$remark = other.getRemark();
                                                                                                                     if (this$remark == null
                                                                                                                        ? other$remark == null
                                                                                                                        : this$remark.equals(other$remark)) {
                                                                                                                        Object this$wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
                                                                                                                        Object other$wmsApproveRecordFlowDTO = other.getWmsApproveRecordFlowDTO();
                                                                                                                        if (this$wmsApproveRecordFlowDTO
                                                                                                                              == null
                                                                                                                           ? other$wmsApproveRecordFlowDTO
                                                                                                                              == null
                                                                                                                           : this$wmsApproveRecordFlowDTO.equals(
                                                                                                                              other$wmsApproveRecordFlowDTO
                                                                                                                           )) {
                                                                                                                           Object this$contractCatalogueDTO = this.getContractCatalogueDTO();
                                                                                                                           Object other$contractCatalogueDTO = other.getContractCatalogueDTO();
                                                                                                                           return this$contractCatalogueDTO
                                                                                                                                 == null
                                                                                                                              ? other$contractCatalogueDTO
                                                                                                                                 == null
                                                                                                                              : this$contractCatalogueDTO.equals(
                                                                                                                                 other$contractCatalogueDTO
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractPreRegistrationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $applicantDeptId = this.getApplicantDeptId();
      result = result * 59 + ($applicantDeptId == null ? 43 : $applicantDeptId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $partyType = this.getPartyType();
      result = result * 59 + ($partyType == null ? 43 : $partyType.hashCode());
      Object $boolBidWinningNotice = this.getBoolBidWinningNotice();
      result = result * 59 + ($boolBidWinningNotice == null ? 43 : $boolBidWinningNotice.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $contractualNature = this.getContractualNature();
      result = result * 59 + ($contractualNature == null ? 43 : $contractualNature.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
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
      Object $infoSource = this.getInfoSource();
      result = result * 59 + ($infoSource == null ? 43 : $infoSource.hashCode());
      Object $boolQuote = this.getBoolQuote();
      result = result * 59 + ($boolQuote == null ? 43 : $boolQuote.hashCode());
      Object $contractCatalogueId = this.getContractCatalogueId();
      result = result * 59 + ($contractCatalogueId == null ? 43 : $contractCatalogueId.hashCode());
      Object $contractCatalogueStatus = this.getContractCatalogueStatus();
      result = result * 59 + ($contractCatalogueStatus == null ? 43 : $contractCatalogueStatus.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $applicantDeptName = this.getApplicantDeptName();
      result = result * 59 + ($applicantDeptName == null ? 43 : $applicantDeptName.hashCode());
      Object $applicationDate = this.getApplicationDate();
      result = result * 59 + ($applicationDate == null ? 43 : $applicationDate.hashCode());
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $preRegistrationNo = this.getPreRegistrationNo();
      result = result * 59 + ($preRegistrationNo == null ? 43 : $preRegistrationNo.hashCode());
      Object $contractNumber = this.getContractNumber();
      result = result * 59 + ($contractNumber == null ? 43 : $contractNumber.hashCode());
      Object $partyTypeValue = this.getPartyTypeValue();
      result = result * 59 + ($partyTypeValue == null ? 43 : $partyTypeValue.hashCode());
      Object $partyName = this.getPartyName();
      result = result * 59 + ($partyName == null ? 43 : $partyName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $structureTypeValue = this.getStructureTypeValue();
      result = result * 59 + ($structureTypeValue == null ? 43 : $structureTypeValue.hashCode());
      Object $contractualNatureValue = this.getContractualNatureValue();
      result = result * 59 + ($contractualNatureValue == null ? 43 : $contractualNatureValue.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $locationValue = this.getLocationValue();
      result = result * 59 + ($locationValue == null ? 43 : $locationValue.hashCode());
      Object $countryValue = this.getCountryValue();
      result = result * 59 + ($countryValue == null ? 43 : $countryValue.hashCode());
      Object $provinceValue = this.getProvinceValue();
      result = result * 59 + ($provinceValue == null ? 43 : $provinceValue.hashCode());
      Object $cityValue = this.getCityValue();
      result = result * 59 + ($cityValue == null ? 43 : $cityValue.hashCode());
      Object $regionValue = this.getRegionValue();
      result = result * 59 + ($regionValue == null ? 43 : $regionValue.hashCode());
      Object $structureArea = this.getStructureArea();
      result = result * 59 + ($structureArea == null ? 43 : $structureArea.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
      result = result * 59 + ($wmsApproveRecordFlowDTO == null ? 43 : $wmsApproveRecordFlowDTO.hashCode());
      Object $contractCatalogueDTO = this.getContractCatalogueDTO();
      return result * 59 + ($contractCatalogueDTO == null ? 43 : $contractCatalogueDTO.hashCode());
   }

   @Override
   public String toString() {
      return "ContractPreRegistrationDTO(id="
         + this.getId()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", applicantDeptId="
         + this.getApplicantDeptId()
         + ", applicantDeptName="
         + this.getApplicantDeptName()
         + ", applicationDate="
         + this.getApplicationDate()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", preRegistrationNo="
         + this.getPreRegistrationNo()
         + ", contractNumber="
         + this.getContractNumber()
         + ", partyType="
         + this.getPartyType()
         + ", partyTypeValue="
         + this.getPartyTypeValue()
         + ", partyName="
         + this.getPartyName()
         + ", projectName="
         + this.getProjectName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", boolBidWinningNotice="
         + this.getBoolBidWinningNotice()
         + ", structureType="
         + this.getStructureType()
         + ", structureTypeValue="
         + this.getStructureTypeValue()
         + ", contractualNature="
         + this.getContractualNature()
         + ", contractualNatureValue="
         + this.getContractualNatureValue()
         + ", signerId="
         + this.getSignerId()
         + ", signerName="
         + this.getSignerName()
         + ", locationId="
         + this.getLocationId()
         + ", locationValue="
         + this.getLocationValue()
         + ", countryId="
         + this.getCountryId()
         + ", countryValue="
         + this.getCountryValue()
         + ", provinceId="
         + this.getProvinceId()
         + ", provinceValue="
         + this.getProvinceValue()
         + ", cityId="
         + this.getCityId()
         + ", cityValue="
         + this.getCityValue()
         + ", regionId="
         + this.getRegionId()
         + ", regionValue="
         + this.getRegionValue()
         + ", structureArea="
         + this.getStructureArea()
         + ", infoSource="
         + this.getInfoSource()
         + ", boolQuote="
         + this.getBoolQuote()
         + ", remark="
         + this.getRemark()
         + ", wmsApproveRecordFlowDTO="
         + this.getWmsApproveRecordFlowDTO()
         + ", contractCatalogueId="
         + this.getContractCatalogueId()
         + ", contractCatalogueDTO="
         + this.getContractCatalogueDTO()
         + ", contractCatalogueStatus="
         + this.getContractCatalogueStatus()
         + ")";
   }

   public static class ContractPreRegistrationDTOBuilder {
      private Long id;
      private Long applicantId;
      private String applicantName;
      private Long applicantDeptId;
      private String applicantDeptName;
      private LocalDateTime applicationDate;
      private Integer reviewStatus;
      private LocalDateTime reviewPassTime;
      private String preRegistrationNo;
      private String contractNumber;
      private Long partyType;
      private String partyTypeValue;
      private String partyName;
      private String projectName;
      private BigDecimal contractAmount;
      private Boolean boolBidWinningNotice;
      private Long structureType;
      private String structureTypeValue;
      private Long contractualNature;
      private String contractualNatureValue;
      private Long signerId;
      private String signerName;
      private Long locationId;
      private String locationValue;
      private Long countryId;
      private String countryValue;
      private Long provinceId;
      private String provinceValue;
      private Long cityId;
      private String cityValue;
      private Long regionId;
      private String regionValue;
      private BigDecimal structureArea;
      private Integer infoSource;
      private Boolean boolQuote;
      private String remark;
      private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO;
      private Long contractCatalogueId;
      private ContractCatalogueDTO contractCatalogueDTO;
      private Integer contractCatalogueStatus;

      ContractPreRegistrationDTOBuilder() {
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder applicantDeptId(final Long applicantDeptId) {
         this.applicantDeptId = applicantDeptId;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder applicantDeptName(final String applicantDeptName) {
         this.applicantDeptName = applicantDeptName;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder applicationDate(final LocalDateTime applicationDate) {
         this.applicationDate = applicationDate;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder reviewPassTime(final LocalDateTime reviewPassTime) {
         this.reviewPassTime = reviewPassTime;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder preRegistrationNo(final String preRegistrationNo) {
         this.preRegistrationNo = preRegistrationNo;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder contractNumber(final String contractNumber) {
         this.contractNumber = contractNumber;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder partyType(final Long partyType) {
         this.partyType = partyType;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder partyTypeValue(final String partyTypeValue) {
         this.partyTypeValue = partyTypeValue;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder partyName(final String partyName) {
         this.partyName = partyName;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder boolBidWinningNotice(final Boolean boolBidWinningNotice) {
         this.boolBidWinningNotice = boolBidWinningNotice;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder structureType(final Long structureType) {
         this.structureType = structureType;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder structureTypeValue(final String structureTypeValue) {
         this.structureTypeValue = structureTypeValue;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder contractualNature(final Long contractualNature) {
         this.contractualNature = contractualNature;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder contractualNatureValue(final String contractualNatureValue) {
         this.contractualNatureValue = contractualNatureValue;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder signerId(final Long signerId) {
         this.signerId = signerId;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder locationId(final Long locationId) {
         this.locationId = locationId;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder locationValue(final String locationValue) {
         this.locationValue = locationValue;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder countryValue(final String countryValue) {
         this.countryValue = countryValue;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder provinceValue(final String provinceValue) {
         this.provinceValue = provinceValue;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder cityValue(final String cityValue) {
         this.cityValue = cityValue;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder regionValue(final String regionValue) {
         this.regionValue = regionValue;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder structureArea(final BigDecimal structureArea) {
         this.structureArea = structureArea;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder infoSource(final Integer infoSource) {
         this.infoSource = infoSource;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder boolQuote(final Boolean boolQuote) {
         this.boolQuote = boolQuote;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder wmsApproveRecordFlowDTO(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO) {
         this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder contractCatalogueId(final Long contractCatalogueId) {
         this.contractCatalogueId = contractCatalogueId;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder contractCatalogueDTO(final ContractCatalogueDTO contractCatalogueDTO) {
         this.contractCatalogueDTO = contractCatalogueDTO;
         return this;
      }

      public ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder contractCatalogueStatus(final Integer contractCatalogueStatus) {
         this.contractCatalogueStatus = contractCatalogueStatus;
         return this;
      }

      public ContractPreRegistrationDTO build() {
         return new ContractPreRegistrationDTO(
            this.id,
            this.applicantId,
            this.applicantName,
            this.applicantDeptId,
            this.applicantDeptName,
            this.applicationDate,
            this.reviewStatus,
            this.reviewPassTime,
            this.preRegistrationNo,
            this.contractNumber,
            this.partyType,
            this.partyTypeValue,
            this.partyName,
            this.projectName,
            this.contractAmount,
            this.boolBidWinningNotice,
            this.structureType,
            this.structureTypeValue,
            this.contractualNature,
            this.contractualNatureValue,
            this.signerId,
            this.signerName,
            this.locationId,
            this.locationValue,
            this.countryId,
            this.countryValue,
            this.provinceId,
            this.provinceValue,
            this.cityId,
            this.cityValue,
            this.regionId,
            this.regionValue,
            this.structureArea,
            this.infoSource,
            this.boolQuote,
            this.remark,
            this.wmsApproveRecordFlowDTO,
            this.contractCatalogueId,
            this.contractCatalogueDTO,
            this.contractCatalogueStatus
         );
      }

      @Override
      public String toString() {
         return "ContractPreRegistrationDTO.ContractPreRegistrationDTOBuilder(id="
            + this.id
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", applicantDeptId="
            + this.applicantDeptId
            + ", applicantDeptName="
            + this.applicantDeptName
            + ", applicationDate="
            + this.applicationDate
            + ", reviewStatus="
            + this.reviewStatus
            + ", reviewPassTime="
            + this.reviewPassTime
            + ", preRegistrationNo="
            + this.preRegistrationNo
            + ", contractNumber="
            + this.contractNumber
            + ", partyType="
            + this.partyType
            + ", partyTypeValue="
            + this.partyTypeValue
            + ", partyName="
            + this.partyName
            + ", projectName="
            + this.projectName
            + ", contractAmount="
            + this.contractAmount
            + ", boolBidWinningNotice="
            + this.boolBidWinningNotice
            + ", structureType="
            + this.structureType
            + ", structureTypeValue="
            + this.structureTypeValue
            + ", contractualNature="
            + this.contractualNature
            + ", contractualNatureValue="
            + this.contractualNatureValue
            + ", signerId="
            + this.signerId
            + ", signerName="
            + this.signerName
            + ", locationId="
            + this.locationId
            + ", locationValue="
            + this.locationValue
            + ", countryId="
            + this.countryId
            + ", countryValue="
            + this.countryValue
            + ", provinceId="
            + this.provinceId
            + ", provinceValue="
            + this.provinceValue
            + ", cityId="
            + this.cityId
            + ", cityValue="
            + this.cityValue
            + ", regionId="
            + this.regionId
            + ", regionValue="
            + this.regionValue
            + ", structureArea="
            + this.structureArea
            + ", infoSource="
            + this.infoSource
            + ", boolQuote="
            + this.boolQuote
            + ", remark="
            + this.remark
            + ", wmsApproveRecordFlowDTO="
            + this.wmsApproveRecordFlowDTO
            + ", contractCatalogueId="
            + this.contractCatalogueId
            + ", contractCatalogueDTO="
            + this.contractCatalogueDTO
            + ", contractCatalogueStatus="
            + this.contractCatalogueStatus
            + ")";
      }
   }
}
