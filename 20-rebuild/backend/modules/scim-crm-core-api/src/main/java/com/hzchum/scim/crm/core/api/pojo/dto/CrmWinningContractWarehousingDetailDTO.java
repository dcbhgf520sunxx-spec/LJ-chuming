package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CrmWinningContractWarehousingDetailDTO {
   @ApiModelProperty(name = "informantUserId", value = "填报人id", notes = "填报人id")
   private Long informantUserId;
   @ApiModelProperty(name = "informantUserName", value = "填报人名称", notes = "填报人名称")
   private String informantUserName;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "企业备案名称", notes = "企业备案名称")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "departmentId", value = "部门id", notes = "部门id")
   private Long departmentId;
   @ApiModelProperty(name = "departmentName", value = "所属部门名称", notes = "所属部门名称")
   private String departmentName;
   @ApiModelProperty(name = "regionNameList", value = "地区名称列表", notes = "地区名称列表")
   private String regionNameList;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "industryConfigurationName", value = "单位所属行业名称  参考 crm_basice_config", notes = "单位所属行业名称  参考 crm_basice_config")
   private String industryConfigurationName;
   @ApiModelProperty(name = "shortName", notes = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "amount", value = "合同额", notes = "合同额")
   private BigDecimal amount;
   @ApiModelProperty(name = "structureTypeConfigurationId", value = "结构类型id", notes = "结构类型id")
   private Long structureTypeConfigurationId;
   @ApiModelProperty(name = "structureTypeConfigurationName", value = "结构类型名称", notes = "结构类型名称")
   private String structureTypeConfigurationName;
   @ApiModelProperty(name = "areaOfStructure", value = "建筑面积", notes = "建筑面积")
   private BigDecimal areaOfStructure;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "quantityWork", value = "工程量", notes = "工程量")
   private BigDecimal quantityWork;
   @ApiModelProperty(name = "structuralRemark", value = "结构备注", notes = "结构备注")
   private String structuralRemark;
   @ApiModelProperty(name = "startDate", value = "开始时间", notes = "开始时间")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "结束时间", notes = "结束时间")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "allDateCount", value = "工期", notes = "工期")
   private String allDateCount;
   @ApiModelProperty(name = "qualityGuaranteeDeposit", value = "质保金比例", notes = "质保金比例")
   private BigDecimal qualityGuaranteeDeposit;
   @ApiModelProperty(name = "qualityGuaranteeDepositRemark", value = "质保金备注", notes = "质保金备注")
   private String qualityGuaranteeDepositRemark;
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
   @ApiModelProperty(name = "attachmentIds", value = "附件列表", notes = "附件列表")
   private List<AttachmentDTO> attachmentList;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "sealContractAttachmentList", value = "盖章合同附件列表", notes = "盖章合同附件列表")
   private List<AttachmentDTO> sealContractAttachmentList;
   @ApiModelProperty(name = "crmProjectScheduleTypeEnum", value = "当前状态", notes = "当前状态")
   private Integer crmProjectScheduleTypeEnum;
   @ApiModelProperty(name = "crmProjectScheduleTypeEnumName", value = "当前状态名称", notes = "当前状态名称")
   private String crmProjectScheduleTypeEnumName;
   @ApiModelProperty(name = "causeAnalysis", value = "原因分析", notes = "原因分析")
   private String causeAnalysis;
   @ApiModelProperty(name = "numberOfBidsParticipated", value = "参与竞标人数", notes = "参与竞标人数")
   private Integer numberOfBidsParticipated;
   @ApiModelProperty(name = "reasonsForBidFailName", value = "失败原因(引用字典值)", notes = "失败原因(引用字典值)")
   private String reasonsForBidFailName;
   @ApiModelProperty(name = "reasonsForBidFail", value = "失败原因(字典值)", notes = "失败原因(字典值)")
   private String reasonsForBidFail;
   @ApiModelProperty(name = "bidRanking", value = "投标排名", notes = "投标排名")
   private Integer bidRanking;

   public static CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder builder() {
      return new CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder();
   }

   public CrmWinningContractWarehousingDetailDTO() {
   }

   public CrmWinningContractWarehousingDetailDTO(
      final Long informantUserId,
      final String informantUserName,
      final String crmEnterpriseWarehousingName,
      final Long departmentId,
      final String departmentName,
      final String regionNameList,
      final LocalDateTime informantDateTime,
      final Long crmProjectInformationWarehousingId,
      final String projectName,
      final String industryConfigurationName,
      final String shortName,
      final BigDecimal amount,
      final Long structureTypeConfigurationId,
      final String structureTypeConfigurationName,
      final BigDecimal areaOfStructure,
      final BigDecimal taxRate,
      final BigDecimal quantityWork,
      final String structuralRemark,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final String allDateCount,
      final BigDecimal qualityGuaranteeDeposit,
      final String qualityGuaranteeDepositRemark,
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
      final List<AttachmentDTO> attachmentList,
      final String remark,
      final List<AttachmentDTO> sealContractAttachmentList,
      final Integer crmProjectScheduleTypeEnum,
      final String crmProjectScheduleTypeEnumName,
      final String causeAnalysis,
      final Integer numberOfBidsParticipated,
      final String reasonsForBidFailName,
      final String reasonsForBidFail,
      final Integer bidRanking
   ) {
      this.informantUserId = informantUserId;
      this.informantUserName = informantUserName;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.departmentId = departmentId;
      this.departmentName = departmentName;
      this.regionNameList = regionNameList;
      this.informantDateTime = informantDateTime;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.projectName = projectName;
      this.industryConfigurationName = industryConfigurationName;
      this.shortName = shortName;
      this.amount = amount;
      this.structureTypeConfigurationId = structureTypeConfigurationId;
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      this.areaOfStructure = areaOfStructure;
      this.taxRate = taxRate;
      this.quantityWork = quantityWork;
      this.structuralRemark = structuralRemark;
      this.startDate = startDate;
      this.endDate = endDate;
      this.allDateCount = allDateCount;
      this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
      this.qualityGuaranteeDepositRemark = qualityGuaranteeDepositRemark;
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
      this.attachmentList = attachmentList;
      this.remark = remark;
      this.sealContractAttachmentList = sealContractAttachmentList;
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
      this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
      this.causeAnalysis = causeAnalysis;
      this.numberOfBidsParticipated = numberOfBidsParticipated;
      this.reasonsForBidFailName = reasonsForBidFailName;
      this.reasonsForBidFail = reasonsForBidFail;
      this.bidRanking = bidRanking;
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public String getRegionNameList() {
      return this.regionNameList;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getIndustryConfigurationName() {
      return this.industryConfigurationName;
   }

   public String getShortName() {
      return this.shortName;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Long getStructureTypeConfigurationId() {
      return this.structureTypeConfigurationId;
   }

   public String getStructureTypeConfigurationName() {
      return this.structureTypeConfigurationName;
   }

   public BigDecimal getAreaOfStructure() {
      return this.areaOfStructure;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
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

   public String getAllDateCount() {
      return this.allDateCount;
   }

   public BigDecimal getQualityGuaranteeDeposit() {
      return this.qualityGuaranteeDeposit;
   }

   public String getQualityGuaranteeDepositRemark() {
      return this.qualityGuaranteeDepositRemark;
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

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<AttachmentDTO> getSealContractAttachmentList() {
      return this.sealContractAttachmentList;
   }

   public Integer getCrmProjectScheduleTypeEnum() {
      return this.crmProjectScheduleTypeEnum;
   }

   public String getCrmProjectScheduleTypeEnumName() {
      return this.crmProjectScheduleTypeEnumName;
   }

   public String getCauseAnalysis() {
      return this.causeAnalysis;
   }

   public Integer getNumberOfBidsParticipated() {
      return this.numberOfBidsParticipated;
   }

   public String getReasonsForBidFailName() {
      return this.reasonsForBidFailName;
   }

   public String getReasonsForBidFail() {
      return this.reasonsForBidFail;
   }

   public Integer getBidRanking() {
      return this.bidRanking;
   }

   public CrmWinningContractWarehousingDetailDTO setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setRegionNameList(final String regionNameList) {
      this.regionNameList = regionNameList;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setIndustryConfigurationName(final String industryConfigurationName) {
      this.industryConfigurationName = industryConfigurationName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setStructureTypeConfigurationId(final Long structureTypeConfigurationId) {
      this.structureTypeConfigurationId = structureTypeConfigurationId;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setStructureTypeConfigurationName(final String structureTypeConfigurationName) {
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setAreaOfStructure(final BigDecimal areaOfStructure) {
      this.areaOfStructure = areaOfStructure;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setQuantityWork(final BigDecimal quantityWork) {
      this.quantityWork = quantityWork;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setStructuralRemark(final String structuralRemark) {
      this.structuralRemark = structuralRemark;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setAllDateCount(final String allDateCount) {
      this.allDateCount = allDateCount;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setQualityGuaranteeDeposit(final BigDecimal qualityGuaranteeDeposit) {
      this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setQualityGuaranteeDepositRemark(final String qualityGuaranteeDepositRemark) {
      this.qualityGuaranteeDepositRemark = qualityGuaranteeDepositRemark;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setPartyAName(final String partyAName) {
      this.partyAName = partyAName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setPartyAPersonName(final String partyAPersonName) {
      this.partyAPersonName = partyAPersonName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setPartyAPhone(final String partyAPhone) {
      this.partyAPhone = partyAPhone;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setPartyBName(final String partyBName) {
      this.partyBName = partyBName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setPartyBPersonName(final String partyBPersonName) {
      this.partyBPersonName = partyBPersonName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setPartyBPhone(final String partyBPhone) {
      this.partyBPhone = partyBPhone;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setPartyCName(final String partyCName) {
      this.partyCName = partyCName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setPartyCPersonName(final String partyCPersonName) {
      this.partyCPersonName = partyCPersonName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setPartyCPhone(final String partyCPhone) {
      this.partyCPhone = partyCPhone;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setPaymentMethod(final String paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setSealContractAttachmentList(final List<AttachmentDTO> sealContractAttachmentList) {
      this.sealContractAttachmentList = sealContractAttachmentList;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setCrmProjectScheduleTypeEnum(final Integer crmProjectScheduleTypeEnum) {
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setCrmProjectScheduleTypeEnumName(final String crmProjectScheduleTypeEnumName) {
      this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setCauseAnalysis(final String causeAnalysis) {
      this.causeAnalysis = causeAnalysis;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setNumberOfBidsParticipated(final Integer numberOfBidsParticipated) {
      this.numberOfBidsParticipated = numberOfBidsParticipated;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setReasonsForBidFailName(final String reasonsForBidFailName) {
      this.reasonsForBidFailName = reasonsForBidFailName;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setReasonsForBidFail(final String reasonsForBidFail) {
      this.reasonsForBidFail = reasonsForBidFail;
      return this;
   }

   public CrmWinningContractWarehousingDetailDTO setBidRanking(final Integer bidRanking) {
      this.bidRanking = bidRanking;
      return this;
   }

   @Override
   public String toString() {
      return "CrmWinningContractWarehousingDetailDTO(informantUserId="
         + this.getInformantUserId()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", departmentId="
         + this.getDepartmentId()
         + ", departmentName="
         + this.getDepartmentName()
         + ", regionNameList="
         + this.getRegionNameList()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", projectName="
         + this.getProjectName()
         + ", industryConfigurationName="
         + this.getIndustryConfigurationName()
         + ", shortName="
         + this.getShortName()
         + ", amount="
         + this.getAmount()
         + ", structureTypeConfigurationId="
         + this.getStructureTypeConfigurationId()
         + ", structureTypeConfigurationName="
         + this.getStructureTypeConfigurationName()
         + ", areaOfStructure="
         + this.getAreaOfStructure()
         + ", taxRate="
         + this.getTaxRate()
         + ", quantityWork="
         + this.getQuantityWork()
         + ", structuralRemark="
         + this.getStructuralRemark()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", allDateCount="
         + this.getAllDateCount()
         + ", qualityGuaranteeDeposit="
         + this.getQualityGuaranteeDeposit()
         + ", qualityGuaranteeDepositRemark="
         + this.getQualityGuaranteeDepositRemark()
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
         + ", attachmentList="
         + this.getAttachmentList()
         + ", remark="
         + this.getRemark()
         + ", sealContractAttachmentList="
         + this.getSealContractAttachmentList()
         + ", crmProjectScheduleTypeEnum="
         + this.getCrmProjectScheduleTypeEnum()
         + ", crmProjectScheduleTypeEnumName="
         + this.getCrmProjectScheduleTypeEnumName()
         + ", causeAnalysis="
         + this.getCauseAnalysis()
         + ", numberOfBidsParticipated="
         + this.getNumberOfBidsParticipated()
         + ", reasonsForBidFailName="
         + this.getReasonsForBidFailName()
         + ", reasonsForBidFail="
         + this.getReasonsForBidFail()
         + ", bidRanking="
         + this.getBidRanking()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmWinningContractWarehousingDetailDTO)) {
         return false;
      }

      CrmWinningContractWarehousingDetailDTO other = (CrmWinningContractWarehousingDetailDTO)o;
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
                           Object this$informantUserName = this.getInformantUserName();
                           Object other$informantUserName = other.getInformantUserName();
                           if (this$informantUserName == null ? other$informantUserName == null : this$informantUserName.equals(other$informantUserName)) {
                              Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
                              Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
                              if (this$crmEnterpriseWarehousingName == null
                                 ? other$crmEnterpriseWarehousingName == null
                                 : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                                 Object this$departmentName = this.getDepartmentName();
                                 Object other$departmentName = other.getDepartmentName();
                                 if (this$departmentName == null ? other$departmentName == null : this$departmentName.equals(other$departmentName)) {
                                    Object this$regionNameList = this.getRegionNameList();
                                    Object other$regionNameList = other.getRegionNameList();
                                    if (this$regionNameList == null ? other$regionNameList == null : this$regionNameList.equals(other$regionNameList)) {
                                       Object this$informantDateTime = this.getInformantDateTime();
                                       Object other$informantDateTime = other.getInformantDateTime();
                                       if (this$informantDateTime == null
                                          ? other$informantDateTime == null
                                          : this$informantDateTime.equals(other$informantDateTime)) {
                                          Object this$projectName = this.getProjectName();
                                          Object other$projectName = other.getProjectName();
                                          if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                             Object this$industryConfigurationName = this.getIndustryConfigurationName();
                                             Object other$industryConfigurationName = other.getIndustryConfigurationName();
                                             if (this$industryConfigurationName == null
                                                ? other$industryConfigurationName == null
                                                : this$industryConfigurationName.equals(other$industryConfigurationName)) {
                                                Object this$shortName = this.getShortName();
                                                Object other$shortName = other.getShortName();
                                                if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                                                   Object this$amount = this.getAmount();
                                                   Object other$amount = other.getAmount();
                                                   if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                      Object this$structureTypeConfigurationName = this.getStructureTypeConfigurationName();
                                                      Object other$structureTypeConfigurationName = other.getStructureTypeConfigurationName();
                                                      if (this$structureTypeConfigurationName == null
                                                         ? other$structureTypeConfigurationName == null
                                                         : this$structureTypeConfigurationName.equals(other$structureTypeConfigurationName)) {
                                                         Object this$areaOfStructure = this.getAreaOfStructure();
                                                         Object other$areaOfStructure = other.getAreaOfStructure();
                                                         if (this$areaOfStructure == null
                                                            ? other$areaOfStructure == null
                                                            : this$areaOfStructure.equals(other$areaOfStructure)) {
                                                            Object this$taxRate = this.getTaxRate();
                                                            Object other$taxRate = other.getTaxRate();
                                                            if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                               Object this$quantityWork = this.getQuantityWork();
                                                               Object other$quantityWork = other.getQuantityWork();
                                                               if (this$quantityWork == null
                                                                  ? other$quantityWork == null
                                                                  : this$quantityWork.equals(other$quantityWork)) {
                                                                  Object this$structuralRemark = this.getStructuralRemark();
                                                                  Object other$structuralRemark = other.getStructuralRemark();
                                                                  if (this$structuralRemark == null
                                                                     ? other$structuralRemark == null
                                                                     : this$structuralRemark.equals(other$structuralRemark)) {
                                                                     Object this$startDate = this.getStartDate();
                                                                     Object other$startDate = other.getStartDate();
                                                                     if (this$startDate == null
                                                                        ? other$startDate == null
                                                                        : this$startDate.equals(other$startDate)) {
                                                                        Object this$endDate = this.getEndDate();
                                                                        Object other$endDate = other.getEndDate();
                                                                        if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                                                           Object this$allDateCount = this.getAllDateCount();
                                                                           Object other$allDateCount = other.getAllDateCount();
                                                                           if (this$allDateCount == null
                                                                              ? other$allDateCount == null
                                                                              : this$allDateCount.equals(other$allDateCount)) {
                                                                              Object this$qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
                                                                              Object other$qualityGuaranteeDeposit = other.getQualityGuaranteeDeposit();
                                                                              if (this$qualityGuaranteeDeposit == null
                                                                                 ? other$qualityGuaranteeDeposit == null
                                                                                 : this$qualityGuaranteeDeposit.equals(other$qualityGuaranteeDeposit)) {
                                                                                 Object this$qualityGuaranteeDepositRemark = this.getQualityGuaranteeDepositRemark();
                                                                                 Object other$qualityGuaranteeDepositRemark = other.getQualityGuaranteeDepositRemark();
                                                                                 if (this$qualityGuaranteeDepositRemark == null
                                                                                    ? other$qualityGuaranteeDepositRemark == null
                                                                                    : this$qualityGuaranteeDepositRemark.equals(
                                                                                       other$qualityGuaranteeDepositRemark
                                                                                    )) {
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
                                                                                                            : this$partyCPersonName.equals(
                                                                                                               other$partyCPersonName
                                                                                                            )) {
                                                                                                            Object this$partyCPhone = this.getPartyCPhone();
                                                                                                            Object other$partyCPhone = other.getPartyCPhone();
                                                                                                            if (this$partyCPhone == null
                                                                                                               ? other$partyCPhone == null
                                                                                                               : this$partyCPhone.equals(other$partyCPhone)) {
                                                                                                               Object this$paymentMethod = this.getPaymentMethod();
                                                                                                               Object other$paymentMethod = other.getPaymentMethod();
                                                                                                               if (this$paymentMethod == null
                                                                                                                  ? other$paymentMethod == null
                                                                                                                  : this$paymentMethod.equals(
                                                                                                                     other$paymentMethod
                                                                                                                  )) {
                                                                                                                  Object this$attachmentList = this.getAttachmentList();
                                                                                                                  Object other$attachmentList = other.getAttachmentList();
                                                                                                                  if (this$attachmentList == null
                                                                                                                     ? other$attachmentList == null
                                                                                                                     : this$attachmentList.equals(
                                                                                                                        other$attachmentList
                                                                                                                     )) {
                                                                                                                     Object this$remark = this.getRemark();
                                                                                                                     Object other$remark = other.getRemark();
                                                                                                                     if (this$remark == null
                                                                                                                        ? other$remark == null
                                                                                                                        : this$remark.equals(other$remark)) {
                                                                                                                        Object this$sealContractAttachmentList = this.getSealContractAttachmentList();
                                                                                                                        Object other$sealContractAttachmentList = other.getSealContractAttachmentList();
                                                                                                                        if (this$sealContractAttachmentList
                                                                                                                              == null
                                                                                                                           ? other$sealContractAttachmentList
                                                                                                                              == null
                                                                                                                           : this$sealContractAttachmentList.equals(
                                                                                                                              other$sealContractAttachmentList
                                                                                                                           )) {
                                                                                                                           Object this$crmProjectScheduleTypeEnumName = this.getCrmProjectScheduleTypeEnumName();
                                                                                                                           Object other$crmProjectScheduleTypeEnumName = other.getCrmProjectScheduleTypeEnumName();
                                                                                                                           if (this$crmProjectScheduleTypeEnumName
                                                                                                                                 == null
                                                                                                                              ? other$crmProjectScheduleTypeEnumName
                                                                                                                                 == null
                                                                                                                              : this$crmProjectScheduleTypeEnumName.equals(
                                                                                                                                 other$crmProjectScheduleTypeEnumName
                                                                                                                              )) {
                                                                                                                              Object this$causeAnalysis = this.getCauseAnalysis();
                                                                                                                              Object other$causeAnalysis = other.getCauseAnalysis();
                                                                                                                              if (this$causeAnalysis == null
                                                                                                                                 ? other$causeAnalysis == null
                                                                                                                                 : this$causeAnalysis.equals(
                                                                                                                                    other$causeAnalysis
                                                                                                                                 )) {
                                                                                                                                 Object this$reasonsForBidFailName = this.getReasonsForBidFailName();
                                                                                                                                 Object other$reasonsForBidFailName = other.getReasonsForBidFailName();
                                                                                                                                 if (this$reasonsForBidFailName
                                                                                                                                       == null
                                                                                                                                    ? other$reasonsForBidFailName
                                                                                                                                       == null
                                                                                                                                    : this$reasonsForBidFailName.equals(
                                                                                                                                       other$reasonsForBidFailName
                                                                                                                                    )) {
                                                                                                                                    Object this$reasonsForBidFail = this.getReasonsForBidFail();
                                                                                                                                    Object other$reasonsForBidFail = other.getReasonsForBidFail();
                                                                                                                                    return this$reasonsForBidFail
                                                                                                                                          == null
                                                                                                                                       ? other$reasonsForBidFail
                                                                                                                                          == null
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
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof CrmWinningContractWarehousingDetailDTO;
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
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $regionNameList = this.getRegionNameList();
      result = result * 59 + ($regionNameList == null ? 43 : $regionNameList.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $industryConfigurationName = this.getIndustryConfigurationName();
      result = result * 59 + ($industryConfigurationName == null ? 43 : $industryConfigurationName.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $structureTypeConfigurationName = this.getStructureTypeConfigurationName();
      result = result * 59 + ($structureTypeConfigurationName == null ? 43 : $structureTypeConfigurationName.hashCode());
      Object $areaOfStructure = this.getAreaOfStructure();
      result = result * 59 + ($areaOfStructure == null ? 43 : $areaOfStructure.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $quantityWork = this.getQuantityWork();
      result = result * 59 + ($quantityWork == null ? 43 : $quantityWork.hashCode());
      Object $structuralRemark = this.getStructuralRemark();
      result = result * 59 + ($structuralRemark == null ? 43 : $structuralRemark.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $allDateCount = this.getAllDateCount();
      result = result * 59 + ($allDateCount == null ? 43 : $allDateCount.hashCode());
      Object $qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
      result = result * 59 + ($qualityGuaranteeDeposit == null ? 43 : $qualityGuaranteeDeposit.hashCode());
      Object $qualityGuaranteeDepositRemark = this.getQualityGuaranteeDepositRemark();
      result = result * 59 + ($qualityGuaranteeDepositRemark == null ? 43 : $qualityGuaranteeDepositRemark.hashCode());
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
      Object $attachmentList = this.getAttachmentList();
      result = result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $sealContractAttachmentList = this.getSealContractAttachmentList();
      result = result * 59 + ($sealContractAttachmentList == null ? 43 : $sealContractAttachmentList.hashCode());
      Object $crmProjectScheduleTypeEnumName = this.getCrmProjectScheduleTypeEnumName();
      result = result * 59 + ($crmProjectScheduleTypeEnumName == null ? 43 : $crmProjectScheduleTypeEnumName.hashCode());
      Object $causeAnalysis = this.getCauseAnalysis();
      result = result * 59 + ($causeAnalysis == null ? 43 : $causeAnalysis.hashCode());
      Object $reasonsForBidFailName = this.getReasonsForBidFailName();
      result = result * 59 + ($reasonsForBidFailName == null ? 43 : $reasonsForBidFailName.hashCode());
      Object $reasonsForBidFail = this.getReasonsForBidFail();
      return result * 59 + ($reasonsForBidFail == null ? 43 : $reasonsForBidFail.hashCode());
   }

   public static class CrmWinningContractWarehousingDetailDTOBuilder {
      private Long informantUserId;
      private String informantUserName;
      private String crmEnterpriseWarehousingName;
      private Long departmentId;
      private String departmentName;
      private String regionNameList;
      private LocalDateTime informantDateTime;
      private Long crmProjectInformationWarehousingId;
      private String projectName;
      private String industryConfigurationName;
      private String shortName;
      private BigDecimal amount;
      private Long structureTypeConfigurationId;
      private String structureTypeConfigurationName;
      private BigDecimal areaOfStructure;
      private BigDecimal taxRate;
      private BigDecimal quantityWork;
      private String structuralRemark;
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private String allDateCount;
      private BigDecimal qualityGuaranteeDeposit;
      private String qualityGuaranteeDepositRemark;
      private String partyAName;
      private String partyAPersonName;
      private String partyAPhone;
      private String partyBName;
      private String partyBPersonName;
      private String partyBPhone;
      private String partyCName;
      private String partyCPersonName;
      private String partyCPhone;
      private String paymentMethod;
      private List<AttachmentDTO> attachmentList;
      private String remark;
      private List<AttachmentDTO> sealContractAttachmentList;
      private Integer crmProjectScheduleTypeEnum;
      private String crmProjectScheduleTypeEnumName;
      private String causeAnalysis;
      private Integer numberOfBidsParticipated;
      private String reasonsForBidFailName;
      private String reasonsForBidFail;
      private Integer bidRanking;

      CrmWinningContractWarehousingDetailDTOBuilder() {
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder informantUserId(final Long informantUserId) {
         this.informantUserId = informantUserId;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder crmEnterpriseWarehousingName(
         final String crmEnterpriseWarehousingName
      ) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder regionNameList(final String regionNameList) {
         this.regionNameList = regionNameList;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder crmProjectInformationWarehousingId(
         final Long crmProjectInformationWarehousingId
      ) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder industryConfigurationName(
         final String industryConfigurationName
      ) {
         this.industryConfigurationName = industryConfigurationName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder structureTypeConfigurationId(
         final Long structureTypeConfigurationId
      ) {
         this.structureTypeConfigurationId = structureTypeConfigurationId;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder structureTypeConfigurationName(
         final String structureTypeConfigurationName
      ) {
         this.structureTypeConfigurationName = structureTypeConfigurationName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder areaOfStructure(final BigDecimal areaOfStructure) {
         this.areaOfStructure = areaOfStructure;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder quantityWork(final BigDecimal quantityWork) {
         this.quantityWork = quantityWork;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder structuralRemark(final String structuralRemark) {
         this.structuralRemark = structuralRemark;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder allDateCount(final String allDateCount) {
         this.allDateCount = allDateCount;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder qualityGuaranteeDeposit(
         final BigDecimal qualityGuaranteeDeposit
      ) {
         this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder qualityGuaranteeDepositRemark(
         final String qualityGuaranteeDepositRemark
      ) {
         this.qualityGuaranteeDepositRemark = qualityGuaranteeDepositRemark;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder partyAName(final String partyAName) {
         this.partyAName = partyAName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder partyAPersonName(final String partyAPersonName) {
         this.partyAPersonName = partyAPersonName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder partyAPhone(final String partyAPhone) {
         this.partyAPhone = partyAPhone;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder partyBName(final String partyBName) {
         this.partyBName = partyBName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder partyBPersonName(final String partyBPersonName) {
         this.partyBPersonName = partyBPersonName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder partyBPhone(final String partyBPhone) {
         this.partyBPhone = partyBPhone;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder partyCName(final String partyCName) {
         this.partyCName = partyCName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder partyCPersonName(final String partyCPersonName) {
         this.partyCPersonName = partyCPersonName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder partyCPhone(final String partyCPhone) {
         this.partyCPhone = partyCPhone;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder paymentMethod(final String paymentMethod) {
         this.paymentMethod = paymentMethod;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder attachmentList(final List<AttachmentDTO> attachmentList) {
         this.attachmentList = attachmentList;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder sealContractAttachmentList(
         final List<AttachmentDTO> sealContractAttachmentList
      ) {
         this.sealContractAttachmentList = sealContractAttachmentList;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder crmProjectScheduleTypeEnum(
         final Integer crmProjectScheduleTypeEnum
      ) {
         this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder crmProjectScheduleTypeEnumName(
         final String crmProjectScheduleTypeEnumName
      ) {
         this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder causeAnalysis(final String causeAnalysis) {
         this.causeAnalysis = causeAnalysis;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder numberOfBidsParticipated(
         final Integer numberOfBidsParticipated
      ) {
         this.numberOfBidsParticipated = numberOfBidsParticipated;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder reasonsForBidFailName(final String reasonsForBidFailName) {
         this.reasonsForBidFailName = reasonsForBidFailName;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder reasonsForBidFail(final String reasonsForBidFail) {
         this.reasonsForBidFail = reasonsForBidFail;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder bidRanking(final Integer bidRanking) {
         this.bidRanking = bidRanking;
         return this;
      }

      public CrmWinningContractWarehousingDetailDTO build() {
         return new CrmWinningContractWarehousingDetailDTO(
            this.informantUserId,
            this.informantUserName,
            this.crmEnterpriseWarehousingName,
            this.departmentId,
            this.departmentName,
            this.regionNameList,
            this.informantDateTime,
            this.crmProjectInformationWarehousingId,
            this.projectName,
            this.industryConfigurationName,
            this.shortName,
            this.amount,
            this.structureTypeConfigurationId,
            this.structureTypeConfigurationName,
            this.areaOfStructure,
            this.taxRate,
            this.quantityWork,
            this.structuralRemark,
            this.startDate,
            this.endDate,
            this.allDateCount,
            this.qualityGuaranteeDeposit,
            this.qualityGuaranteeDepositRemark,
            this.partyAName,
            this.partyAPersonName,
            this.partyAPhone,
            this.partyBName,
            this.partyBPersonName,
            this.partyBPhone,
            this.partyCName,
            this.partyCPersonName,
            this.partyCPhone,
            this.paymentMethod,
            this.attachmentList,
            this.remark,
            this.sealContractAttachmentList,
            this.crmProjectScheduleTypeEnum,
            this.crmProjectScheduleTypeEnumName,
            this.causeAnalysis,
            this.numberOfBidsParticipated,
            this.reasonsForBidFailName,
            this.reasonsForBidFail,
            this.bidRanking
         );
      }

      @Override
      public String toString() {
         return "CrmWinningContractWarehousingDetailDTO.CrmWinningContractWarehousingDetailDTOBuilder(informantUserId="
            + this.informantUserId
            + ", informantUserName="
            + this.informantUserName
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", departmentId="
            + this.departmentId
            + ", departmentName="
            + this.departmentName
            + ", regionNameList="
            + this.regionNameList
            + ", informantDateTime="
            + this.informantDateTime
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", projectName="
            + this.projectName
            + ", industryConfigurationName="
            + this.industryConfigurationName
            + ", shortName="
            + this.shortName
            + ", amount="
            + this.amount
            + ", structureTypeConfigurationId="
            + this.structureTypeConfigurationId
            + ", structureTypeConfigurationName="
            + this.structureTypeConfigurationName
            + ", areaOfStructure="
            + this.areaOfStructure
            + ", taxRate="
            + this.taxRate
            + ", quantityWork="
            + this.quantityWork
            + ", structuralRemark="
            + this.structuralRemark
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", allDateCount="
            + this.allDateCount
            + ", qualityGuaranteeDeposit="
            + this.qualityGuaranteeDeposit
            + ", qualityGuaranteeDepositRemark="
            + this.qualityGuaranteeDepositRemark
            + ", partyAName="
            + this.partyAName
            + ", partyAPersonName="
            + this.partyAPersonName
            + ", partyAPhone="
            + this.partyAPhone
            + ", partyBName="
            + this.partyBName
            + ", partyBPersonName="
            + this.partyBPersonName
            + ", partyBPhone="
            + this.partyBPhone
            + ", partyCName="
            + this.partyCName
            + ", partyCPersonName="
            + this.partyCPersonName
            + ", partyCPhone="
            + this.partyCPhone
            + ", paymentMethod="
            + this.paymentMethod
            + ", attachmentList="
            + this.attachmentList
            + ", remark="
            + this.remark
            + ", sealContractAttachmentList="
            + this.sealContractAttachmentList
            + ", crmProjectScheduleTypeEnum="
            + this.crmProjectScheduleTypeEnum
            + ", crmProjectScheduleTypeEnumName="
            + this.crmProjectScheduleTypeEnumName
            + ", causeAnalysis="
            + this.causeAnalysis
            + ", numberOfBidsParticipated="
            + this.numberOfBidsParticipated
            + ", reasonsForBidFailName="
            + this.reasonsForBidFailName
            + ", reasonsForBidFail="
            + this.reasonsForBidFail
            + ", bidRanking="
            + this.bidRanking
            + ")";
      }
   }
}
