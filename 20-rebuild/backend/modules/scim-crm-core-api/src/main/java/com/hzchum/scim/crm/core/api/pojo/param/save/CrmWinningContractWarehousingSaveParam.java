package com.hzchum.scim.crm.core.api.pojo.param.save;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CrmWinningContractWarehousingSaveParam {
   @ApiModelProperty(name = "informantUserId", value = "填报人", notes = "填报人")
   private Long informantUserId;
   @ApiModelProperty(name = "departmentId", value = "所属部门", notes = "所属部门")
   private Long departmentId;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "amount", value = "合同额", notes = "合同额")
   private BigDecimal amount;
   @ApiModelProperty(name = "structureTypeConfigurationId", value = "结构类型id", notes = "结构类型id")
   private Long structureTypeConfigurationId;
   @ApiModelProperty(name = "areaOfStructure", value = "建筑面积", notes = "建筑面积")
   private BigDecimal areaOfStructure;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "shortName", notes = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "quantityWork", value = "工程量", notes = "工程量")
   private BigDecimal quantityWork;
   @ApiModelProperty(name = "structuralRemark", value = "结构备注", notes = "结构备注")
   private String structuralRemark;
   @ApiModelProperty(name = "startDate", value = "开始时间", notes = "开始时间")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "结束时间", notes = "结束时间")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "qualityGuaranteeDeposit", value = "质保金比例", notes = "质保金比例")
   private BigDecimal qualityGuaranteeDeposit;
   @ApiModelProperty(name = "qualityGuaranteeDepositRemark", value = "质保金备注", notes = "质保金备注")
   private String qualityGuaranteeDepositRemark;
   @ApiModelProperty(name = "estimatedWorks", value = "用钢量", notes = "用钢量")
   private BigDecimal estimatedWorks;
   @ApiModelProperty(name = "partyAName", value = "甲方名称", notes = "甲方名称")
   private String partyAName;
   @ApiModelProperty(name = "partyAPersonName", value = "甲方联系人名称", notes = "甲方联系人名称")
   private String partyAPersonName;
   @ApiModelProperty(name = "partyAPhone", value = "甲方联系人电话", notes = "甲方联系人电话")
   private String partyAPhone;
   @ApiModelProperty(name = "partyBName", value = "乙方名称", notes = "乙方名称")
   private String partyBName;
   @ApiModelProperty(name = "partyBPersonName", value = "乙方联系人", notes = "乙方联系人")
   private String partyBPersonName;
   @ApiModelProperty(name = "partyBPhone", value = "乙方联系人电话", notes = "乙方联系人电话")
   private String partyBPhone;
   @ApiModelProperty(name = "partyCName", value = "丙方名称", notes = "丙方名称")
   private String partyCName;
   @ApiModelProperty(name = "partyCPersonName", value = "丙方联系人", notes = "丙方联系人")
   private String partyCPersonName;
   @ApiModelProperty(name = "partyCPhone", value = "丙方联系人电话", notes = "丙方联系人电话")
   private String partyCPhone;
   @ApiModelProperty(name = "paymentMethod", value = "付款方式描述", notes = "付款方式描述")
   private String paymentMethod;
   @ApiModelProperty(name = "attachmentIds", value = "附件", notes = "附件")
   private List<Long> attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "crmProjectScheduleTypeEnum", value = "中标状态", notes = "中标状态")
   private Integer crmProjectScheduleTypeEnum;
   @ApiModelProperty(name = "causeAnalysis", value = "原因分析", notes = "原因分析")
   private String causeAnalysis;
   @ApiModelProperty(name = "reasonsForBidFail", value = "失败原因(引用字典值)", notes = "失败原因(引用字典值)")
   private String reasonsForBidFail;
   @ApiModelProperty(name = "numberOfBidsParticipated", value = "参与竞标人数", notes = "参与竞标人数")
   private Integer numberOfBidsParticipated;
   @ApiModelProperty(name = "bidRanking", value = "投标排名", notes = "投标排名")
   private Integer bidRanking;

   public CrmWinningContractWarehousingSaveParam(
      final Long informantUserId,
      final Long departmentId,
      final LocalDateTime informantDateTime,
      final String projectName,
      final Long crmProjectInformationWarehousingId,
      final BigDecimal amount,
      final Long structureTypeConfigurationId,
      final BigDecimal areaOfStructure,
      final BigDecimal taxRate,
      final String shortName,
      final BigDecimal quantityWork,
      final String structuralRemark,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final BigDecimal qualityGuaranteeDeposit,
      final String qualityGuaranteeDepositRemark,
      final BigDecimal estimatedWorks,
      final String partyAName,
      final String partyAPersonName,
      final String partyAPhone,
      final String partyBName,
      final String partyBPersonName,
      final String partyBPhone,
      final String partyCName,
      final String partyCPersonName,
      final String partyCPhone,
      final String paymentMethod,
      final List<Long> attachmentIds,
      final String remark,
      final Integer crmProjectScheduleTypeEnum,
      final String causeAnalysis,
      final String reasonsForBidFail,
      final Integer numberOfBidsParticipated,
      final Integer bidRanking
   ) {
      this.informantUserId = informantUserId;
      this.departmentId = departmentId;
      this.informantDateTime = informantDateTime;
      this.projectName = projectName;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.amount = amount;
      this.structureTypeConfigurationId = structureTypeConfigurationId;
      this.areaOfStructure = areaOfStructure;
      this.taxRate = taxRate;
      this.shortName = shortName;
      this.quantityWork = quantityWork;
      this.structuralRemark = structuralRemark;
      this.startDate = startDate;
      this.endDate = endDate;
      this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
      this.qualityGuaranteeDepositRemark = qualityGuaranteeDepositRemark;
      this.estimatedWorks = estimatedWorks;
      this.partyAName = partyAName;
      this.partyAPersonName = partyAPersonName;
      this.partyAPhone = partyAPhone;
      this.partyBName = partyBName;
      this.partyBPersonName = partyBPersonName;
      this.partyBPhone = partyBPhone;
      this.partyCName = partyCName;
      this.partyCPersonName = partyCPersonName;
      this.partyCPhone = partyCPhone;
      this.paymentMethod = paymentMethod;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
      this.causeAnalysis = causeAnalysis;
      this.reasonsForBidFail = reasonsForBidFail;
      this.numberOfBidsParticipated = numberOfBidsParticipated;
      this.bidRanking = bidRanking;
   }

   public CrmWinningContractWarehousingSaveParam() {
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Long getStructureTypeConfigurationId() {
      return this.structureTypeConfigurationId;
   }

   public BigDecimal getAreaOfStructure() {
      return this.areaOfStructure;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getShortName() {
      return this.shortName;
   }

   public BigDecimal getQuantityWork() {
      return this.quantityWork;
   }

   public String getStructuralRemark() {
      return this.structuralRemark;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public BigDecimal getQualityGuaranteeDeposit() {
      return this.qualityGuaranteeDeposit;
   }

   public String getQualityGuaranteeDepositRemark() {
      return this.qualityGuaranteeDepositRemark;
   }

   public BigDecimal getEstimatedWorks() {
      return this.estimatedWorks;
   }

   public String getPartyAName() {
      return this.partyAName;
   }

   public String getPartyAPersonName() {
      return this.partyAPersonName;
   }

   public String getPartyAPhone() {
      return this.partyAPhone;
   }

   public String getPartyBName() {
      return this.partyBName;
   }

   public String getPartyBPersonName() {
      return this.partyBPersonName;
   }

   public String getPartyBPhone() {
      return this.partyBPhone;
   }

   public String getPartyCName() {
      return this.partyCName;
   }

   public String getPartyCPersonName() {
      return this.partyCPersonName;
   }

   public String getPartyCPhone() {
      return this.partyCPhone;
   }

   public String getPaymentMethod() {
      return this.paymentMethod;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getCrmProjectScheduleTypeEnum() {
      return this.crmProjectScheduleTypeEnum;
   }

   public String getCauseAnalysis() {
      return this.causeAnalysis;
   }

   public String getReasonsForBidFail() {
      return this.reasonsForBidFail;
   }

   public Integer getNumberOfBidsParticipated() {
      return this.numberOfBidsParticipated;
   }

   public Integer getBidRanking() {
      return this.bidRanking;
   }

   public void setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
   }

   public void setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
   }

   public void setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setStructureTypeConfigurationId(final Long structureTypeConfigurationId) {
      this.structureTypeConfigurationId = structureTypeConfigurationId;
   }

   public void setAreaOfStructure(final BigDecimal areaOfStructure) {
      this.areaOfStructure = areaOfStructure;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setQuantityWork(final BigDecimal quantityWork) {
      this.quantityWork = quantityWork;
   }

   public void setStructuralRemark(final String structuralRemark) {
      this.structuralRemark = structuralRemark;
   }

   public void setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
   }

   public void setQualityGuaranteeDeposit(final BigDecimal qualityGuaranteeDeposit) {
      this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
   }

   public void setQualityGuaranteeDepositRemark(final String qualityGuaranteeDepositRemark) {
      this.qualityGuaranteeDepositRemark = qualityGuaranteeDepositRemark;
   }

   public void setEstimatedWorks(final BigDecimal estimatedWorks) {
      this.estimatedWorks = estimatedWorks;
   }

   public void setPartyAName(final String partyAName) {
      this.partyAName = partyAName;
   }

   public void setPartyAPersonName(final String partyAPersonName) {
      this.partyAPersonName = partyAPersonName;
   }

   public void setPartyAPhone(final String partyAPhone) {
      this.partyAPhone = partyAPhone;
   }

   public void setPartyBName(final String partyBName) {
      this.partyBName = partyBName;
   }

   public void setPartyBPersonName(final String partyBPersonName) {
      this.partyBPersonName = partyBPersonName;
   }

   public void setPartyBPhone(final String partyBPhone) {
      this.partyBPhone = partyBPhone;
   }

   public void setPartyCName(final String partyCName) {
      this.partyCName = partyCName;
   }

   public void setPartyCPersonName(final String partyCPersonName) {
      this.partyCPersonName = partyCPersonName;
   }

   public void setPartyCPhone(final String partyCPhone) {
      this.partyCPhone = partyCPhone;
   }

   public void setPaymentMethod(final String paymentMethod) {
      this.paymentMethod = paymentMethod;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCrmProjectScheduleTypeEnum(final Integer crmProjectScheduleTypeEnum) {
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
   }

   public void setCauseAnalysis(final String causeAnalysis) {
      this.causeAnalysis = causeAnalysis;
   }

   public void setReasonsForBidFail(final String reasonsForBidFail) {
      this.reasonsForBidFail = reasonsForBidFail;
   }

   public void setNumberOfBidsParticipated(final Integer numberOfBidsParticipated) {
      this.numberOfBidsParticipated = numberOfBidsParticipated;
   }

   public void setBidRanking(final Integer bidRanking) {
      this.bidRanking = bidRanking;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmWinningContractWarehousingSaveParam)) {
         return false;
      }

      CrmWinningContractWarehousingSaveParam other = (CrmWinningContractWarehousingSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$informantUserId = this.getInformantUserId();
      Object other$informantUserId = other.getInformantUserId();
      if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
         Object this$departmentId = this.getDepartmentId();
         Object other$departmentId = other.getDepartmentId();
         if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
            Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
            Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
            if (this$crmProjectInformationWarehousingId == null
               ? other$crmProjectInformationWarehousingId == null
               : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
               Object this$structureTypeConfigurationId = this.getStructureTypeConfigurationId();
               Object other$structureTypeConfigurationId = other.getStructureTypeConfigurationId();
               if (this$structureTypeConfigurationId == null
                  ? other$structureTypeConfigurationId == null
                  : this$structureTypeConfigurationId.equals(other$structureTypeConfigurationId)) {
                  Object this$crmProjectScheduleTypeEnum = this.getCrmProjectScheduleTypeEnum();
                  Object other$crmProjectScheduleTypeEnum = other.getCrmProjectScheduleTypeEnum();
                  if (this$crmProjectScheduleTypeEnum == null
                     ? other$crmProjectScheduleTypeEnum == null
                     : this$crmProjectScheduleTypeEnum.equals(other$crmProjectScheduleTypeEnum)) {
                     Object this$numberOfBidsParticipated = this.getNumberOfBidsParticipated();
                     Object other$numberOfBidsParticipated = other.getNumberOfBidsParticipated();
                     if (this$numberOfBidsParticipated == null
                        ? other$numberOfBidsParticipated == null
                        : this$numberOfBidsParticipated.equals(other$numberOfBidsParticipated)) {
                        Object this$bidRanking = this.getBidRanking();
                        Object other$bidRanking = other.getBidRanking();
                        if (this$bidRanking == null ? other$bidRanking == null : this$bidRanking.equals(other$bidRanking)) {
                           Object this$informantDateTime = this.getInformantDateTime();
                           Object other$informantDateTime = other.getInformantDateTime();
                           if (this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime)) {
                              Object this$projectName = this.getProjectName();
                              Object other$projectName = other.getProjectName();
                              if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                 Object this$amount = this.getAmount();
                                 Object other$amount = other.getAmount();
                                 if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                    Object this$areaOfStructure = this.getAreaOfStructure();
                                    Object other$areaOfStructure = other.getAreaOfStructure();
                                    if (this$areaOfStructure == null ? other$areaOfStructure == null : this$areaOfStructure.equals(other$areaOfStructure)) {
                                       Object this$taxRate = this.getTaxRate();
                                       Object other$taxRate = other.getTaxRate();
                                       if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                          Object this$shortName = this.getShortName();
                                          Object other$shortName = other.getShortName();
                                          if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                                             Object this$quantityWork = this.getQuantityWork();
                                             Object other$quantityWork = other.getQuantityWork();
                                             if (this$quantityWork == null ? other$quantityWork == null : this$quantityWork.equals(other$quantityWork)) {
                                                Object this$structuralRemark = this.getStructuralRemark();
                                                Object other$structuralRemark = other.getStructuralRemark();
                                                if (this$structuralRemark == null
                                                   ? other$structuralRemark == null
                                                   : this$structuralRemark.equals(other$structuralRemark)) {
                                                   Object this$startDate = this.getStartDate();
                                                   Object other$startDate = other.getStartDate();
                                                   if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                                      Object this$endDate = this.getEndDate();
                                                      Object other$endDate = other.getEndDate();
                                                      if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                                         Object this$qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
                                                         Object other$qualityGuaranteeDeposit = other.getQualityGuaranteeDeposit();
                                                         if (this$qualityGuaranteeDeposit == null
                                                            ? other$qualityGuaranteeDeposit == null
                                                            : this$qualityGuaranteeDeposit.equals(other$qualityGuaranteeDeposit)) {
                                                            Object this$qualityGuaranteeDepositRemark = this.getQualityGuaranteeDepositRemark();
                                                            Object other$qualityGuaranteeDepositRemark = other.getQualityGuaranteeDepositRemark();
                                                            if (this$qualityGuaranteeDepositRemark == null
                                                               ? other$qualityGuaranteeDepositRemark == null
                                                               : this$qualityGuaranteeDepositRemark.equals(other$qualityGuaranteeDepositRemark)) {
                                                               Object this$estimatedWorks = this.getEstimatedWorks();
                                                               Object other$estimatedWorks = other.getEstimatedWorks();
                                                               if (this$estimatedWorks == null
                                                                  ? other$estimatedWorks == null
                                                                  : this$estimatedWorks.equals(other$estimatedWorks)) {
                                                                  Object this$partyAName = this.getPartyAName();
                                                                  Object other$partyAName = other.getPartyAName();
                                                                  if (this$partyAName == null
                                                                     ? other$partyAName == null
                                                                     : this$partyAName.equals(other$partyAName)) {
                                                                     Object this$partyAPersonName = this.getPartyAPersonName();
                                                                     Object other$partyAPersonName = other.getPartyAPersonName();
                                                                     if (this$partyAPersonName == null
                                                                        ? other$partyAPersonName == null
                                                                        : this$partyAPersonName.equals(other$partyAPersonName)) {
                                                                        Object this$partyAPhone = this.getPartyAPhone();
                                                                        Object other$partyAPhone = other.getPartyAPhone();
                                                                        if (this$partyAPhone == null
                                                                           ? other$partyAPhone == null
                                                                           : this$partyAPhone.equals(other$partyAPhone)) {
                                                                           Object this$partyBName = this.getPartyBName();
                                                                           Object other$partyBName = other.getPartyBName();
                                                                           if (this$partyBName == null
                                                                              ? other$partyBName == null
                                                                              : this$partyBName.equals(other$partyBName)) {
                                                                              Object this$partyBPersonName = this.getPartyBPersonName();
                                                                              Object other$partyBPersonName = other.getPartyBPersonName();
                                                                              if (this$partyBPersonName == null
                                                                                 ? other$partyBPersonName == null
                                                                                 : this$partyBPersonName.equals(other$partyBPersonName)) {
                                                                                 Object this$partyBPhone = this.getPartyBPhone();
                                                                                 Object other$partyBPhone = other.getPartyBPhone();
                                                                                 if (this$partyBPhone == null
                                                                                    ? other$partyBPhone == null
                                                                                    : this$partyBPhone.equals(other$partyBPhone)) {
                                                                                    Object this$partyCName = this.getPartyCName();
                                                                                    Object other$partyCName = other.getPartyCName();
                                                                                    if (this$partyCName == null
                                                                                       ? other$partyCName == null
                                                                                       : this$partyCName.equals(other$partyCName)) {
                                                                                       Object this$partyCPersonName = this.getPartyCPersonName();
                                                                                       Object other$partyCPersonName = other.getPartyCPersonName();
                                                                                       if (this$partyCPersonName == null
                                                                                          ? other$partyCPersonName == null
                                                                                          : this$partyCPersonName.equals(other$partyCPersonName)) {
                                                                                          Object this$partyCPhone = this.getPartyCPhone();
                                                                                          Object other$partyCPhone = other.getPartyCPhone();
                                                                                          if (this$partyCPhone == null
                                                                                             ? other$partyCPhone == null
                                                                                             : this$partyCPhone.equals(other$partyCPhone)) {
                                                                                             Object this$paymentMethod = this.getPaymentMethod();
                                                                                             Object other$paymentMethod = other.getPaymentMethod();
                                                                                             if (this$paymentMethod == null
                                                                                                ? other$paymentMethod == null
                                                                                                : this$paymentMethod.equals(other$paymentMethod)) {
                                                                                                Object this$attachmentIds = this.getAttachmentIds();
                                                                                                Object other$attachmentIds = other.getAttachmentIds();
                                                                                                if (this$attachmentIds == null
                                                                                                   ? other$attachmentIds == null
                                                                                                   : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                                   Object this$remark = this.getRemark();
                                                                                                   Object other$remark = other.getRemark();
                                                                                                   if (this$remark == null
                                                                                                      ? other$remark == null
                                                                                                      : this$remark.equals(other$remark)) {
                                                                                                      Object this$causeAnalysis = this.getCauseAnalysis();
                                                                                                      Object other$causeAnalysis = other.getCauseAnalysis();
                                                                                                      if (this$causeAnalysis == null
                                                                                                         ? other$causeAnalysis == null
                                                                                                         : this$causeAnalysis.equals(other$causeAnalysis)) {
                                                                                                         Object this$reasonsForBidFail = this.getReasonsForBidFail();
                                                                                                         Object other$reasonsForBidFail = other.getReasonsForBidFail();
                                                                                                         return this$reasonsForBidFail == null
                                                                                                            ? other$reasonsForBidFail == null
                                                                                                            : this$reasonsForBidFail.equals(
                                                                                                               other$reasonsForBidFail
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmWinningContractWarehousingSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $structureTypeConfigurationId = this.getStructureTypeConfigurationId();
      result = result * 59 + ($structureTypeConfigurationId == null ? 43 : $structureTypeConfigurationId.hashCode());
      Object $crmProjectScheduleTypeEnum = this.getCrmProjectScheduleTypeEnum();
      result = result * 59 + ($crmProjectScheduleTypeEnum == null ? 43 : $crmProjectScheduleTypeEnum.hashCode());
      Object $numberOfBidsParticipated = this.getNumberOfBidsParticipated();
      result = result * 59 + ($numberOfBidsParticipated == null ? 43 : $numberOfBidsParticipated.hashCode());
      Object $bidRanking = this.getBidRanking();
      result = result * 59 + ($bidRanking == null ? 43 : $bidRanking.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $areaOfStructure = this.getAreaOfStructure();
      result = result * 59 + ($areaOfStructure == null ? 43 : $areaOfStructure.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $quantityWork = this.getQuantityWork();
      result = result * 59 + ($quantityWork == null ? 43 : $quantityWork.hashCode());
      Object $structuralRemark = this.getStructuralRemark();
      result = result * 59 + ($structuralRemark == null ? 43 : $structuralRemark.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
      result = result * 59 + ($qualityGuaranteeDeposit == null ? 43 : $qualityGuaranteeDeposit.hashCode());
      Object $qualityGuaranteeDepositRemark = this.getQualityGuaranteeDepositRemark();
      result = result * 59 + ($qualityGuaranteeDepositRemark == null ? 43 : $qualityGuaranteeDepositRemark.hashCode());
      Object $estimatedWorks = this.getEstimatedWorks();
      result = result * 59 + ($estimatedWorks == null ? 43 : $estimatedWorks.hashCode());
      Object $partyAName = this.getPartyAName();
      result = result * 59 + ($partyAName == null ? 43 : $partyAName.hashCode());
      Object $partyAPersonName = this.getPartyAPersonName();
      result = result * 59 + ($partyAPersonName == null ? 43 : $partyAPersonName.hashCode());
      Object $partyAPhone = this.getPartyAPhone();
      result = result * 59 + ($partyAPhone == null ? 43 : $partyAPhone.hashCode());
      Object $partyBName = this.getPartyBName();
      result = result * 59 + ($partyBName == null ? 43 : $partyBName.hashCode());
      Object $partyBPersonName = this.getPartyBPersonName();
      result = result * 59 + ($partyBPersonName == null ? 43 : $partyBPersonName.hashCode());
      Object $partyBPhone = this.getPartyBPhone();
      result = result * 59 + ($partyBPhone == null ? 43 : $partyBPhone.hashCode());
      Object $partyCName = this.getPartyCName();
      result = result * 59 + ($partyCName == null ? 43 : $partyCName.hashCode());
      Object $partyCPersonName = this.getPartyCPersonName();
      result = result * 59 + ($partyCPersonName == null ? 43 : $partyCPersonName.hashCode());
      Object $partyCPhone = this.getPartyCPhone();
      result = result * 59 + ($partyCPhone == null ? 43 : $partyCPhone.hashCode());
      Object $paymentMethod = this.getPaymentMethod();
      result = result * 59 + ($paymentMethod == null ? 43 : $paymentMethod.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $causeAnalysis = this.getCauseAnalysis();
      result = result * 59 + ($causeAnalysis == null ? 43 : $causeAnalysis.hashCode());
      Object $reasonsForBidFail = this.getReasonsForBidFail();
      return result * 59 + ($reasonsForBidFail == null ? 43 : $reasonsForBidFail.hashCode());
   }

   @Override
   public String toString() {
      return "CrmWinningContractWarehousingSaveParam(informantUserId="
         + this.getInformantUserId()
         + ", departmentId="
         + this.getDepartmentId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", projectName="
         + this.getProjectName()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", amount="
         + this.getAmount()
         + ", structureTypeConfigurationId="
         + this.getStructureTypeConfigurationId()
         + ", areaOfStructure="
         + this.getAreaOfStructure()
         + ", taxRate="
         + this.getTaxRate()
         + ", shortName="
         + this.getShortName()
         + ", quantityWork="
         + this.getQuantityWork()
         + ", structuralRemark="
         + this.getStructuralRemark()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", qualityGuaranteeDeposit="
         + this.getQualityGuaranteeDeposit()
         + ", qualityGuaranteeDepositRemark="
         + this.getQualityGuaranteeDepositRemark()
         + ", estimatedWorks="
         + this.getEstimatedWorks()
         + ", partyAName="
         + this.getPartyAName()
         + ", partyAPersonName="
         + this.getPartyAPersonName()
         + ", partyAPhone="
         + this.getPartyAPhone()
         + ", partyBName="
         + this.getPartyBName()
         + ", partyBPersonName="
         + this.getPartyBPersonName()
         + ", partyBPhone="
         + this.getPartyBPhone()
         + ", partyCName="
         + this.getPartyCName()
         + ", partyCPersonName="
         + this.getPartyCPersonName()
         + ", partyCPhone="
         + this.getPartyCPhone()
         + ", paymentMethod="
         + this.getPaymentMethod()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", crmProjectScheduleTypeEnum="
         + this.getCrmProjectScheduleTypeEnum()
         + ", causeAnalysis="
         + this.getCauseAnalysis()
         + ", reasonsForBidFail="
         + this.getReasonsForBidFail()
         + ", numberOfBidsParticipated="
         + this.getNumberOfBidsParticipated()
         + ", bidRanking="
         + this.getBidRanking()
         + ")";
   }
}
