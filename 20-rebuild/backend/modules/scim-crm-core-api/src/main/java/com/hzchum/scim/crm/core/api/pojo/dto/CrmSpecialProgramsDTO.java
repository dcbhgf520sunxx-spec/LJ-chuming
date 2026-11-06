package com.hzchum.scim.crm.core.api.pojo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CrmSpecialProgramsDTO {
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "serialNumber", value = "备案号", notes = "备案号")
   private String serialNumber;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "企业备案Name", notes = "企业备案Name")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "regionNames", value = "区域名称", notes = "区域名称")
   private String regionNames;
   @ApiModelProperty(name = "structureTypeConfigurationName", value = "结构类型Name", notes = "结构类型Name")
   private String structureTypeConfigurationName;
   @ApiModelProperty(name = "estimatedCost", value = "预估造价", notes = "预估造价")
   private BigDecimal estimatedCost;
   @ApiModelProperty(name = "projectLevelConfigId", value = "项目级别 CrmProjectInformationConfig", notes = "项目级别 CrmProjectInformationConfig")
   private String projectLevelConfigName;
   @ApiModelProperty(name = "departmentName", value = "所属部门", notes = "所属部门")
   private String departmentName;
   @ApiModelProperty(name = "informantUserName", value = "填报人", notes = "填报人")
   private String informantUserName;
   @ApiModelProperty(name = "isUploadStampedContract", value = "是否上传盖章合同", notes = "是否上传盖章合同")
   private String isUploadStampedContract;
   @ApiModelProperty(name = "crmProjectScheduleTypeEnumName", value = "当前状态", notes = "当前状态")
   private String crmProjectScheduleTypeEnumName;
   @ApiModelProperty(name = "sealContractAttachmentList", value = "盖章合同附件列表", notes = "盖章合同附件列表")
   private List<AttachmentDTO> sealContractAttachmentList;
   @ApiModelProperty(name = "reportingStatus", value = "专项方案是否提报人员", notes = "专项方案是否提报人员")
   private Boolean reportingStatus;
   @ApiModelProperty(name = "reportingTime", value = "专项方案提报时间", notes = "专项方案提报时间")
   private LocalDateTime reportingTime;
   @ApiModelProperty(name = "reportingUserId", value = "专项方案提报人员id", notes = "专项方案提报人员id")
   private Long reportingUserId;
   @ApiModelProperty(name = "constructionOrganizationReportingStatus", value = "施工组织是否提报人员", notes = "施工组织是否提报人员")
   private Boolean constructionOrganizationReportingStatus;
   @ApiModelProperty(name = "constructionOrganizationReportingTime", value = "施工组织专项方案提报时间", notes = "施工组织专项方案提报时间")
   private LocalDateTime constructionOrganizationReportingTime;
   @ApiModelProperty(name = "constructionOrganizationReportingUserId", value = "施工组织专项方案提报人员id", notes = "施工组织专项方案提报人员id")
   private Long constructionOrganizationReportingUserId;
   @ApiModelProperty(name = "constructionSupportServiceReportingStatus", value = "现场支持服务是否提报人员", notes = "现场支持服务是否提报人员")
   private Boolean constructionSupportServiceReportingStatus;
   @ApiModelProperty(name = "constructionSupportServiceReportingTime", value = "现场支持服务专项方案提报时间", notes = "现场支持服务专项方案提报时间")
   private LocalDateTime constructionSupportServiceReportingTime;
   @ApiModelProperty(name = "constructionSupportServiceReportingUserId", value = "现场支持服务专项方案提报人员id", notes = "现场支持服务专项方案提报人员id")
   private Long constructionSupportServiceReportingUserId;
   @ApiModelProperty(name = "constructionCalculationReportingStatus", value = "施工验算是否提报人员", notes = "施工验算是否提报人员")
   private Boolean constructionCalculationReportingStatus;
   @ApiModelProperty(name = "constructionCalculationReportingTime", value = "施工验算专项方案提报时间", notes = "施工验算专项方案提报时间")
   private LocalDateTime constructionCalculationReportingTime;
   @ApiModelProperty(name = "constructionCalculationReportingUserId", value = "施工验算专项方案提报人员id", notes = "施工验算专项方案提报人员id")
   private Long constructionCalculationReportingUserId;
   @ApiModelProperty(name = "animationReportingStatus", value = "动画集效果是否提报人员", notes = "动画集效果是否提报人员")
   private Boolean animationReportingStatus;
   @ApiModelProperty(name = "animationReportingTime", value = "动画集效果专项方案提报时间", notes = "动画集效果专项方案提报时间")
   private LocalDateTime animationReportingTime;
   @ApiModelProperty(name = "animationReportingUserId", value = "动画集效果专项方案提报人员id", notes = "动画集效果专项方案提报人员id")
   private Long animationReportingUserId;
   @ApiModelProperty(name = "innovationReportingStatus", value = "科技创新是否提报人员", notes = "科技创新是否提报人员")
   private Boolean innovationReportingStatus;
   @ApiModelProperty(name = "innovationReportingTime", value = "科技创新专项方案提报时间", notes = "科技创新专项方案提报时间")
   private LocalDateTime innovationReportingTime;
   @ApiModelProperty(name = "innovationReportingUserId", value = "科技创新专项方案提报人员id", notes = "科技创新专项方案提报人员id")
   private Long innovationReportingUserId;
   @ApiModelProperty(name = "crmSubmissionStatusEnum", value = "提报状态", notes = "提报状态")
   private Integer crmSubmissionStatusEnum;

   public static CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder builder() {
      return new CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder();
   }

   public CrmSpecialProgramsDTO() {
   }

   public CrmSpecialProgramsDTO(
      final Long id,
      final LocalDateTime informantDateTime,
      final String serialNumber,
      final String projectName,
      final String crmEnterpriseWarehousingName,
      final Long crmProjectInformationWarehousingId,
      final String regionNames,
      final String structureTypeConfigurationName,
      final BigDecimal estimatedCost,
      final String projectLevelConfigName,
      final String departmentName,
      final String informantUserName,
      final String isUploadStampedContract,
      final String crmProjectScheduleTypeEnumName,
      final List<AttachmentDTO> sealContractAttachmentList,
      final Boolean reportingStatus,
      final LocalDateTime reportingTime,
      final Long reportingUserId,
      final Boolean constructionOrganizationReportingStatus,
      final LocalDateTime constructionOrganizationReportingTime,
      final Long constructionOrganizationReportingUserId,
      final Boolean constructionSupportServiceReportingStatus,
      final LocalDateTime constructionSupportServiceReportingTime,
      final Long constructionSupportServiceReportingUserId,
      final Boolean constructionCalculationReportingStatus,
      final LocalDateTime constructionCalculationReportingTime,
      final Long constructionCalculationReportingUserId,
      final Boolean animationReportingStatus,
      final LocalDateTime animationReportingTime,
      final Long animationReportingUserId,
      final Boolean innovationReportingStatus,
      final LocalDateTime innovationReportingTime,
      final Long innovationReportingUserId,
      final Integer crmSubmissionStatusEnum
   ) {
      this.id = id;
      this.informantDateTime = informantDateTime;
      this.serialNumber = serialNumber;
      this.projectName = projectName;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.regionNames = regionNames;
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      this.estimatedCost = estimatedCost;
      this.projectLevelConfigName = projectLevelConfigName;
      this.departmentName = departmentName;
      this.informantUserName = informantUserName;
      this.isUploadStampedContract = isUploadStampedContract;
      this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
      this.sealContractAttachmentList = sealContractAttachmentList;
      this.reportingStatus = reportingStatus;
      this.reportingTime = reportingTime;
      this.reportingUserId = reportingUserId;
      this.constructionOrganizationReportingStatus = constructionOrganizationReportingStatus;
      this.constructionOrganizationReportingTime = constructionOrganizationReportingTime;
      this.constructionOrganizationReportingUserId = constructionOrganizationReportingUserId;
      this.constructionSupportServiceReportingStatus = constructionSupportServiceReportingStatus;
      this.constructionSupportServiceReportingTime = constructionSupportServiceReportingTime;
      this.constructionSupportServiceReportingUserId = constructionSupportServiceReportingUserId;
      this.constructionCalculationReportingStatus = constructionCalculationReportingStatus;
      this.constructionCalculationReportingTime = constructionCalculationReportingTime;
      this.constructionCalculationReportingUserId = constructionCalculationReportingUserId;
      this.animationReportingStatus = animationReportingStatus;
      this.animationReportingTime = animationReportingTime;
      this.animationReportingUserId = animationReportingUserId;
      this.innovationReportingStatus = innovationReportingStatus;
      this.innovationReportingTime = innovationReportingTime;
      this.innovationReportingUserId = innovationReportingUserId;
      this.crmSubmissionStatusEnum = crmSubmissionStatusEnum;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public String getRegionNames() {
      return this.regionNames;
   }

   public String getStructureTypeConfigurationName() {
      return this.structureTypeConfigurationName;
   }

   public BigDecimal getEstimatedCost() {
      return this.estimatedCost;
   }

   public String getProjectLevelConfigName() {
      return this.projectLevelConfigName;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public String getIsUploadStampedContract() {
      return this.isUploadStampedContract;
   }

   public String getCrmProjectScheduleTypeEnumName() {
      return this.crmProjectScheduleTypeEnumName;
   }

   public List<AttachmentDTO> getSealContractAttachmentList() {
      return this.sealContractAttachmentList;
   }

   public Boolean getReportingStatus() {
      return this.reportingStatus;
   }

   public LocalDateTime getReportingTime() {
      return this.reportingTime;
   }

   public Long getReportingUserId() {
      return this.reportingUserId;
   }

   public Boolean getConstructionOrganizationReportingStatus() {
      return this.constructionOrganizationReportingStatus;
   }

   public LocalDateTime getConstructionOrganizationReportingTime() {
      return this.constructionOrganizationReportingTime;
   }

   public Long getConstructionOrganizationReportingUserId() {
      return this.constructionOrganizationReportingUserId;
   }

   public Boolean getConstructionSupportServiceReportingStatus() {
      return this.constructionSupportServiceReportingStatus;
   }

   public LocalDateTime getConstructionSupportServiceReportingTime() {
      return this.constructionSupportServiceReportingTime;
   }

   public Long getConstructionSupportServiceReportingUserId() {
      return this.constructionSupportServiceReportingUserId;
   }

   public Boolean getConstructionCalculationReportingStatus() {
      return this.constructionCalculationReportingStatus;
   }

   public LocalDateTime getConstructionCalculationReportingTime() {
      return this.constructionCalculationReportingTime;
   }

   public Long getConstructionCalculationReportingUserId() {
      return this.constructionCalculationReportingUserId;
   }

   public Boolean getAnimationReportingStatus() {
      return this.animationReportingStatus;
   }

   public LocalDateTime getAnimationReportingTime() {
      return this.animationReportingTime;
   }

   public Long getAnimationReportingUserId() {
      return this.animationReportingUserId;
   }

   public Boolean getInnovationReportingStatus() {
      return this.innovationReportingStatus;
   }

   public LocalDateTime getInnovationReportingTime() {
      return this.innovationReportingTime;
   }

   public Long getInnovationReportingUserId() {
      return this.innovationReportingUserId;
   }

   public Integer getCrmSubmissionStatusEnum() {
      return this.crmSubmissionStatusEnum;
   }

   public CrmSpecialProgramsDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmSpecialProgramsDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmSpecialProgramsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmSpecialProgramsDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public CrmSpecialProgramsDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmSpecialProgramsDTO setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmSpecialProgramsDTO setRegionNames(final String regionNames) {
      this.regionNames = regionNames;
      return this;
   }

   public CrmSpecialProgramsDTO setStructureTypeConfigurationName(final String structureTypeConfigurationName) {
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      return this;
   }

   public CrmSpecialProgramsDTO setEstimatedCost(final BigDecimal estimatedCost) {
      this.estimatedCost = estimatedCost;
      return this;
   }

   public CrmSpecialProgramsDTO setProjectLevelConfigName(final String projectLevelConfigName) {
      this.projectLevelConfigName = projectLevelConfigName;
      return this;
   }

   public CrmSpecialProgramsDTO setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   public CrmSpecialProgramsDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmSpecialProgramsDTO setIsUploadStampedContract(final String isUploadStampedContract) {
      this.isUploadStampedContract = isUploadStampedContract;
      return this;
   }

   public CrmSpecialProgramsDTO setCrmProjectScheduleTypeEnumName(final String crmProjectScheduleTypeEnumName) {
      this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
      return this;
   }

   public CrmSpecialProgramsDTO setSealContractAttachmentList(final List<AttachmentDTO> sealContractAttachmentList) {
      this.sealContractAttachmentList = sealContractAttachmentList;
      return this;
   }

   public CrmSpecialProgramsDTO setReportingStatus(final Boolean reportingStatus) {
      this.reportingStatus = reportingStatus;
      return this;
   }

   public CrmSpecialProgramsDTO setReportingTime(final LocalDateTime reportingTime) {
      this.reportingTime = reportingTime;
      return this;
   }

   public CrmSpecialProgramsDTO setReportingUserId(final Long reportingUserId) {
      this.reportingUserId = reportingUserId;
      return this;
   }

   public CrmSpecialProgramsDTO setConstructionOrganizationReportingStatus(final Boolean constructionOrganizationReportingStatus) {
      this.constructionOrganizationReportingStatus = constructionOrganizationReportingStatus;
      return this;
   }

   public CrmSpecialProgramsDTO setConstructionOrganizationReportingTime(final LocalDateTime constructionOrganizationReportingTime) {
      this.constructionOrganizationReportingTime = constructionOrganizationReportingTime;
      return this;
   }

   public CrmSpecialProgramsDTO setConstructionOrganizationReportingUserId(final Long constructionOrganizationReportingUserId) {
      this.constructionOrganizationReportingUserId = constructionOrganizationReportingUserId;
      return this;
   }

   public CrmSpecialProgramsDTO setConstructionSupportServiceReportingStatus(final Boolean constructionSupportServiceReportingStatus) {
      this.constructionSupportServiceReportingStatus = constructionSupportServiceReportingStatus;
      return this;
   }

   public CrmSpecialProgramsDTO setConstructionSupportServiceReportingTime(final LocalDateTime constructionSupportServiceReportingTime) {
      this.constructionSupportServiceReportingTime = constructionSupportServiceReportingTime;
      return this;
   }

   public CrmSpecialProgramsDTO setConstructionSupportServiceReportingUserId(final Long constructionSupportServiceReportingUserId) {
      this.constructionSupportServiceReportingUserId = constructionSupportServiceReportingUserId;
      return this;
   }

   public CrmSpecialProgramsDTO setConstructionCalculationReportingStatus(final Boolean constructionCalculationReportingStatus) {
      this.constructionCalculationReportingStatus = constructionCalculationReportingStatus;
      return this;
   }

   public CrmSpecialProgramsDTO setConstructionCalculationReportingTime(final LocalDateTime constructionCalculationReportingTime) {
      this.constructionCalculationReportingTime = constructionCalculationReportingTime;
      return this;
   }

   public CrmSpecialProgramsDTO setConstructionCalculationReportingUserId(final Long constructionCalculationReportingUserId) {
      this.constructionCalculationReportingUserId = constructionCalculationReportingUserId;
      return this;
   }

   public CrmSpecialProgramsDTO setAnimationReportingStatus(final Boolean animationReportingStatus) {
      this.animationReportingStatus = animationReportingStatus;
      return this;
   }

   public CrmSpecialProgramsDTO setAnimationReportingTime(final LocalDateTime animationReportingTime) {
      this.animationReportingTime = animationReportingTime;
      return this;
   }

   public CrmSpecialProgramsDTO setAnimationReportingUserId(final Long animationReportingUserId) {
      this.animationReportingUserId = animationReportingUserId;
      return this;
   }

   public CrmSpecialProgramsDTO setInnovationReportingStatus(final Boolean innovationReportingStatus) {
      this.innovationReportingStatus = innovationReportingStatus;
      return this;
   }

   public CrmSpecialProgramsDTO setInnovationReportingTime(final LocalDateTime innovationReportingTime) {
      this.innovationReportingTime = innovationReportingTime;
      return this;
   }

   public CrmSpecialProgramsDTO setInnovationReportingUserId(final Long innovationReportingUserId) {
      this.innovationReportingUserId = innovationReportingUserId;
      return this;
   }

   public CrmSpecialProgramsDTO setCrmSubmissionStatusEnum(final Integer crmSubmissionStatusEnum) {
      this.crmSubmissionStatusEnum = crmSubmissionStatusEnum;
      return this;
   }

   @Override
   public String toString() {
      return "CrmSpecialProgramsDTO(id="
         + this.getId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectName="
         + this.getProjectName()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", regionNames="
         + this.getRegionNames()
         + ", structureTypeConfigurationName="
         + this.getStructureTypeConfigurationName()
         + ", estimatedCost="
         + this.getEstimatedCost()
         + ", projectLevelConfigName="
         + this.getProjectLevelConfigName()
         + ", departmentName="
         + this.getDepartmentName()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", isUploadStampedContract="
         + this.getIsUploadStampedContract()
         + ", crmProjectScheduleTypeEnumName="
         + this.getCrmProjectScheduleTypeEnumName()
         + ", sealContractAttachmentList="
         + this.getSealContractAttachmentList()
         + ", reportingStatus="
         + this.getReportingStatus()
         + ", reportingTime="
         + this.getReportingTime()
         + ", reportingUserId="
         + this.getReportingUserId()
         + ", constructionOrganizationReportingStatus="
         + this.getConstructionOrganizationReportingStatus()
         + ", constructionOrganizationReportingTime="
         + this.getConstructionOrganizationReportingTime()
         + ", constructionOrganizationReportingUserId="
         + this.getConstructionOrganizationReportingUserId()
         + ", constructionSupportServiceReportingStatus="
         + this.getConstructionSupportServiceReportingStatus()
         + ", constructionSupportServiceReportingTime="
         + this.getConstructionSupportServiceReportingTime()
         + ", constructionSupportServiceReportingUserId="
         + this.getConstructionSupportServiceReportingUserId()
         + ", constructionCalculationReportingStatus="
         + this.getConstructionCalculationReportingStatus()
         + ", constructionCalculationReportingTime="
         + this.getConstructionCalculationReportingTime()
         + ", constructionCalculationReportingUserId="
         + this.getConstructionCalculationReportingUserId()
         + ", animationReportingStatus="
         + this.getAnimationReportingStatus()
         + ", animationReportingTime="
         + this.getAnimationReportingTime()
         + ", animationReportingUserId="
         + this.getAnimationReportingUserId()
         + ", innovationReportingStatus="
         + this.getInnovationReportingStatus()
         + ", innovationReportingTime="
         + this.getInnovationReportingTime()
         + ", innovationReportingUserId="
         + this.getInnovationReportingUserId()
         + ", crmSubmissionStatusEnum="
         + this.getCrmSubmissionStatusEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmSpecialProgramsDTO)) {
         return false;
      }

      CrmSpecialProgramsDTO other = (CrmSpecialProgramsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
         Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
         if (this$crmProjectInformationWarehousingId == null
            ? other$crmProjectInformationWarehousingId == null
            : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
            Object this$reportingStatus = this.getReportingStatus();
            Object other$reportingStatus = other.getReportingStatus();
            if (this$reportingStatus == null ? other$reportingStatus == null : this$reportingStatus.equals(other$reportingStatus)) {
               Object this$reportingUserId = this.getReportingUserId();
               Object other$reportingUserId = other.getReportingUserId();
               if (this$reportingUserId == null ? other$reportingUserId == null : this$reportingUserId.equals(other$reportingUserId)) {
                  Object this$constructionOrganizationReportingStatus = this.getConstructionOrganizationReportingStatus();
                  Object other$constructionOrganizationReportingStatus = other.getConstructionOrganizationReportingStatus();
                  if (this$constructionOrganizationReportingStatus == null
                     ? other$constructionOrganizationReportingStatus == null
                     : this$constructionOrganizationReportingStatus.equals(other$constructionOrganizationReportingStatus)) {
                     Object this$constructionOrganizationReportingUserId = this.getConstructionOrganizationReportingUserId();
                     Object other$constructionOrganizationReportingUserId = other.getConstructionOrganizationReportingUserId();
                     if (this$constructionOrganizationReportingUserId == null
                        ? other$constructionOrganizationReportingUserId == null
                        : this$constructionOrganizationReportingUserId.equals(other$constructionOrganizationReportingUserId)) {
                        Object this$constructionSupportServiceReportingStatus = this.getConstructionSupportServiceReportingStatus();
                        Object other$constructionSupportServiceReportingStatus = other.getConstructionSupportServiceReportingStatus();
                        if (this$constructionSupportServiceReportingStatus == null
                           ? other$constructionSupportServiceReportingStatus == null
                           : this$constructionSupportServiceReportingStatus.equals(other$constructionSupportServiceReportingStatus)) {
                           Object this$constructionSupportServiceReportingUserId = this.getConstructionSupportServiceReportingUserId();
                           Object other$constructionSupportServiceReportingUserId = other.getConstructionSupportServiceReportingUserId();
                           if (this$constructionSupportServiceReportingUserId == null
                              ? other$constructionSupportServiceReportingUserId == null
                              : this$constructionSupportServiceReportingUserId.equals(other$constructionSupportServiceReportingUserId)) {
                              Object this$constructionCalculationReportingStatus = this.getConstructionCalculationReportingStatus();
                              Object other$constructionCalculationReportingStatus = other.getConstructionCalculationReportingStatus();
                              if (this$constructionCalculationReportingStatus == null
                                 ? other$constructionCalculationReportingStatus == null
                                 : this$constructionCalculationReportingStatus.equals(other$constructionCalculationReportingStatus)) {
                                 Object this$constructionCalculationReportingUserId = this.getConstructionCalculationReportingUserId();
                                 Object other$constructionCalculationReportingUserId = other.getConstructionCalculationReportingUserId();
                                 if (this$constructionCalculationReportingUserId == null
                                    ? other$constructionCalculationReportingUserId == null
                                    : this$constructionCalculationReportingUserId.equals(other$constructionCalculationReportingUserId)) {
                                    Object this$animationReportingStatus = this.getAnimationReportingStatus();
                                    Object other$animationReportingStatus = other.getAnimationReportingStatus();
                                    if (this$animationReportingStatus == null
                                       ? other$animationReportingStatus == null
                                       : this$animationReportingStatus.equals(other$animationReportingStatus)) {
                                       Object this$animationReportingUserId = this.getAnimationReportingUserId();
                                       Object other$animationReportingUserId = other.getAnimationReportingUserId();
                                       if (this$animationReportingUserId == null
                                          ? other$animationReportingUserId == null
                                          : this$animationReportingUserId.equals(other$animationReportingUserId)) {
                                          Object this$innovationReportingStatus = this.getInnovationReportingStatus();
                                          Object other$innovationReportingStatus = other.getInnovationReportingStatus();
                                          if (this$innovationReportingStatus == null
                                             ? other$innovationReportingStatus == null
                                             : this$innovationReportingStatus.equals(other$innovationReportingStatus)) {
                                             Object this$innovationReportingUserId = this.getInnovationReportingUserId();
                                             Object other$innovationReportingUserId = other.getInnovationReportingUserId();
                                             if (this$innovationReportingUserId == null
                                                ? other$innovationReportingUserId == null
                                                : this$innovationReportingUserId.equals(other$innovationReportingUserId)) {
                                                Object this$crmSubmissionStatusEnum = this.getCrmSubmissionStatusEnum();
                                                Object other$crmSubmissionStatusEnum = other.getCrmSubmissionStatusEnum();
                                                if (this$crmSubmissionStatusEnum == null
                                                   ? other$crmSubmissionStatusEnum == null
                                                   : this$crmSubmissionStatusEnum.equals(other$crmSubmissionStatusEnum)) {
                                                   Object this$informantDateTime = this.getInformantDateTime();
                                                   Object other$informantDateTime = other.getInformantDateTime();
                                                   if (this$informantDateTime == null
                                                      ? other$informantDateTime == null
                                                      : this$informantDateTime.equals(other$informantDateTime)) {
                                                      Object this$serialNumber = this.getSerialNumber();
                                                      Object other$serialNumber = other.getSerialNumber();
                                                      if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)
                                                         )
                                                       {
                                                         Object this$projectName = this.getProjectName();
                                                         Object other$projectName = other.getProjectName();
                                                         if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                            Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
                                                            Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
                                                            if (this$crmEnterpriseWarehousingName == null
                                                               ? other$crmEnterpriseWarehousingName == null
                                                               : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                                                               Object this$regionNames = this.getRegionNames();
                                                               Object other$regionNames = other.getRegionNames();
                                                               if (this$regionNames == null
                                                                  ? other$regionNames == null
                                                                  : this$regionNames.equals(other$regionNames)) {
                                                                  Object this$structureTypeConfigurationName = this.getStructureTypeConfigurationName();
                                                                  Object other$structureTypeConfigurationName = other.getStructureTypeConfigurationName();
                                                                  if (this$structureTypeConfigurationName == null
                                                                     ? other$structureTypeConfigurationName == null
                                                                     : this$structureTypeConfigurationName.equals(other$structureTypeConfigurationName)) {
                                                                     Object this$estimatedCost = this.getEstimatedCost();
                                                                     Object other$estimatedCost = other.getEstimatedCost();
                                                                     if (this$estimatedCost == null
                                                                        ? other$estimatedCost == null
                                                                        : this$estimatedCost.equals(other$estimatedCost)) {
                                                                        Object this$projectLevelConfigName = this.getProjectLevelConfigName();
                                                                        Object other$projectLevelConfigName = other.getProjectLevelConfigName();
                                                                        if (this$projectLevelConfigName == null
                                                                           ? other$projectLevelConfigName == null
                                                                           : this$projectLevelConfigName.equals(other$projectLevelConfigName)) {
                                                                           Object this$departmentName = this.getDepartmentName();
                                                                           Object other$departmentName = other.getDepartmentName();
                                                                           if (this$departmentName == null
                                                                              ? other$departmentName == null
                                                                              : this$departmentName.equals(other$departmentName)) {
                                                                              Object this$informantUserName = this.getInformantUserName();
                                                                              Object other$informantUserName = other.getInformantUserName();
                                                                              if (this$informantUserName == null
                                                                                 ? other$informantUserName == null
                                                                                 : this$informantUserName.equals(other$informantUserName)) {
                                                                                 Object this$isUploadStampedContract = this.getIsUploadStampedContract();
                                                                                 Object other$isUploadStampedContract = other.getIsUploadStampedContract();
                                                                                 if (this$isUploadStampedContract == null
                                                                                    ? other$isUploadStampedContract == null
                                                                                    : this$isUploadStampedContract.equals(other$isUploadStampedContract)) {
                                                                                    Object this$crmProjectScheduleTypeEnumName = this.getCrmProjectScheduleTypeEnumName();
                                                                                    Object other$crmProjectScheduleTypeEnumName = other.getCrmProjectScheduleTypeEnumName();
                                                                                    if (this$crmProjectScheduleTypeEnumName == null
                                                                                       ? other$crmProjectScheduleTypeEnumName == null
                                                                                       : this$crmProjectScheduleTypeEnumName.equals(
                                                                                          other$crmProjectScheduleTypeEnumName
                                                                                       )) {
                                                                                       Object this$sealContractAttachmentList = this.getSealContractAttachmentList();
                                                                                       Object other$sealContractAttachmentList = other.getSealContractAttachmentList();
                                                                                       if (this$sealContractAttachmentList == null
                                                                                          ? other$sealContractAttachmentList == null
                                                                                          : this$sealContractAttachmentList.equals(
                                                                                             other$sealContractAttachmentList
                                                                                          )) {
                                                                                          Object this$reportingTime = this.getReportingTime();
                                                                                          Object other$reportingTime = other.getReportingTime();
                                                                                          if (this$reportingTime == null
                                                                                             ? other$reportingTime == null
                                                                                             : this$reportingTime.equals(other$reportingTime)) {
                                                                                             Object this$constructionOrganizationReportingTime = this.getConstructionOrganizationReportingTime();
                                                                                             Object other$constructionOrganizationReportingTime = other.getConstructionOrganizationReportingTime();
                                                                                             if (this$constructionOrganizationReportingTime == null
                                                                                                ? other$constructionOrganizationReportingTime == null
                                                                                                : this$constructionOrganizationReportingTime.equals(
                                                                                                   other$constructionOrganizationReportingTime
                                                                                                )) {
                                                                                                Object this$constructionSupportServiceReportingTime = this.getConstructionSupportServiceReportingTime();
                                                                                                Object other$constructionSupportServiceReportingTime = other.getConstructionSupportServiceReportingTime();
                                                                                                if (this$constructionSupportServiceReportingTime == null
                                                                                                   ? other$constructionSupportServiceReportingTime == null
                                                                                                   : this$constructionSupportServiceReportingTime.equals(
                                                                                                      other$constructionSupportServiceReportingTime
                                                                                                   )) {
                                                                                                   Object this$constructionCalculationReportingTime = this.getConstructionCalculationReportingTime();
                                                                                                   Object other$constructionCalculationReportingTime = other.getConstructionCalculationReportingTime();
                                                                                                   if (this$constructionCalculationReportingTime == null
                                                                                                      ? other$constructionCalculationReportingTime == null
                                                                                                      : this$constructionCalculationReportingTime.equals(
                                                                                                         other$constructionCalculationReportingTime
                                                                                                      )) {
                                                                                                      Object this$animationReportingTime = this.getAnimationReportingTime();
                                                                                                      Object other$animationReportingTime = other.getAnimationReportingTime();
                                                                                                      if (this$animationReportingTime == null
                                                                                                         ? other$animationReportingTime == null
                                                                                                         : this$animationReportingTime.equals(
                                                                                                            other$animationReportingTime
                                                                                                         )) {
                                                                                                         Object this$innovationReportingTime = this.getInnovationReportingTime();
                                                                                                         Object other$innovationReportingTime = other.getInnovationReportingTime();
                                                                                                         return this$innovationReportingTime == null
                                                                                                            ? other$innovationReportingTime == null
                                                                                                            : this$innovationReportingTime.equals(
                                                                                                               other$innovationReportingTime
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
      return other instanceof CrmSpecialProgramsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $reportingStatus = this.getReportingStatus();
      result = result * 59 + ($reportingStatus == null ? 43 : $reportingStatus.hashCode());
      Object $reportingUserId = this.getReportingUserId();
      result = result * 59 + ($reportingUserId == null ? 43 : $reportingUserId.hashCode());
      Object $constructionOrganizationReportingStatus = this.getConstructionOrganizationReportingStatus();
      result = result * 59 + ($constructionOrganizationReportingStatus == null ? 43 : $constructionOrganizationReportingStatus.hashCode());
      Object $constructionOrganizationReportingUserId = this.getConstructionOrganizationReportingUserId();
      result = result * 59 + ($constructionOrganizationReportingUserId == null ? 43 : $constructionOrganizationReportingUserId.hashCode());
      Object $constructionSupportServiceReportingStatus = this.getConstructionSupportServiceReportingStatus();
      result = result * 59 + ($constructionSupportServiceReportingStatus == null ? 43 : $constructionSupportServiceReportingStatus.hashCode());
      Object $constructionSupportServiceReportingUserId = this.getConstructionSupportServiceReportingUserId();
      result = result * 59 + ($constructionSupportServiceReportingUserId == null ? 43 : $constructionSupportServiceReportingUserId.hashCode());
      Object $constructionCalculationReportingStatus = this.getConstructionCalculationReportingStatus();
      result = result * 59 + ($constructionCalculationReportingStatus == null ? 43 : $constructionCalculationReportingStatus.hashCode());
      Object $constructionCalculationReportingUserId = this.getConstructionCalculationReportingUserId();
      result = result * 59 + ($constructionCalculationReportingUserId == null ? 43 : $constructionCalculationReportingUserId.hashCode());
      Object $animationReportingStatus = this.getAnimationReportingStatus();
      result = result * 59 + ($animationReportingStatus == null ? 43 : $animationReportingStatus.hashCode());
      Object $animationReportingUserId = this.getAnimationReportingUserId();
      result = result * 59 + ($animationReportingUserId == null ? 43 : $animationReportingUserId.hashCode());
      Object $innovationReportingStatus = this.getInnovationReportingStatus();
      result = result * 59 + ($innovationReportingStatus == null ? 43 : $innovationReportingStatus.hashCode());
      Object $innovationReportingUserId = this.getInnovationReportingUserId();
      result = result * 59 + ($innovationReportingUserId == null ? 43 : $innovationReportingUserId.hashCode());
      Object $crmSubmissionStatusEnum = this.getCrmSubmissionStatusEnum();
      result = result * 59 + ($crmSubmissionStatusEnum == null ? 43 : $crmSubmissionStatusEnum.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $regionNames = this.getRegionNames();
      result = result * 59 + ($regionNames == null ? 43 : $regionNames.hashCode());
      Object $structureTypeConfigurationName = this.getStructureTypeConfigurationName();
      result = result * 59 + ($structureTypeConfigurationName == null ? 43 : $structureTypeConfigurationName.hashCode());
      Object $estimatedCost = this.getEstimatedCost();
      result = result * 59 + ($estimatedCost == null ? 43 : $estimatedCost.hashCode());
      Object $projectLevelConfigName = this.getProjectLevelConfigName();
      result = result * 59 + ($projectLevelConfigName == null ? 43 : $projectLevelConfigName.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $isUploadStampedContract = this.getIsUploadStampedContract();
      result = result * 59 + ($isUploadStampedContract == null ? 43 : $isUploadStampedContract.hashCode());
      Object $crmProjectScheduleTypeEnumName = this.getCrmProjectScheduleTypeEnumName();
      result = result * 59 + ($crmProjectScheduleTypeEnumName == null ? 43 : $crmProjectScheduleTypeEnumName.hashCode());
      Object $sealContractAttachmentList = this.getSealContractAttachmentList();
      result = result * 59 + ($sealContractAttachmentList == null ? 43 : $sealContractAttachmentList.hashCode());
      Object $reportingTime = this.getReportingTime();
      result = result * 59 + ($reportingTime == null ? 43 : $reportingTime.hashCode());
      Object $constructionOrganizationReportingTime = this.getConstructionOrganizationReportingTime();
      result = result * 59 + ($constructionOrganizationReportingTime == null ? 43 : $constructionOrganizationReportingTime.hashCode());
      Object $constructionSupportServiceReportingTime = this.getConstructionSupportServiceReportingTime();
      result = result * 59 + ($constructionSupportServiceReportingTime == null ? 43 : $constructionSupportServiceReportingTime.hashCode());
      Object $constructionCalculationReportingTime = this.getConstructionCalculationReportingTime();
      result = result * 59 + ($constructionCalculationReportingTime == null ? 43 : $constructionCalculationReportingTime.hashCode());
      Object $animationReportingTime = this.getAnimationReportingTime();
      result = result * 59 + ($animationReportingTime == null ? 43 : $animationReportingTime.hashCode());
      Object $innovationReportingTime = this.getInnovationReportingTime();
      return result * 59 + ($innovationReportingTime == null ? 43 : $innovationReportingTime.hashCode());
   }

   public static class CrmSpecialProgramsDTOBuilder {
      private Long id;
      private LocalDateTime informantDateTime;
      private String serialNumber;
      private String projectName;
      private String crmEnterpriseWarehousingName;
      private Long crmProjectInformationWarehousingId;
      private String regionNames;
      private String structureTypeConfigurationName;
      private BigDecimal estimatedCost;
      private String projectLevelConfigName;
      private String departmentName;
      private String informantUserName;
      private String isUploadStampedContract;
      private String crmProjectScheduleTypeEnumName;
      private List<AttachmentDTO> sealContractAttachmentList;
      private Boolean reportingStatus;
      private LocalDateTime reportingTime;
      private Long reportingUserId;
      private Boolean constructionOrganizationReportingStatus;
      private LocalDateTime constructionOrganizationReportingTime;
      private Long constructionOrganizationReportingUserId;
      private Boolean constructionSupportServiceReportingStatus;
      private LocalDateTime constructionSupportServiceReportingTime;
      private Long constructionSupportServiceReportingUserId;
      private Boolean constructionCalculationReportingStatus;
      private LocalDateTime constructionCalculationReportingTime;
      private Long constructionCalculationReportingUserId;
      private Boolean animationReportingStatus;
      private LocalDateTime animationReportingTime;
      private Long animationReportingUserId;
      private Boolean innovationReportingStatus;
      private LocalDateTime innovationReportingTime;
      private Long innovationReportingUserId;
      private Integer crmSubmissionStatusEnum;

      CrmSpecialProgramsDTOBuilder() {
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder crmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder crmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder regionNames(final String regionNames) {
         this.regionNames = regionNames;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder structureTypeConfigurationName(final String structureTypeConfigurationName) {
         this.structureTypeConfigurationName = structureTypeConfigurationName;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder estimatedCost(final BigDecimal estimatedCost) {
         this.estimatedCost = estimatedCost;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder projectLevelConfigName(final String projectLevelConfigName) {
         this.projectLevelConfigName = projectLevelConfigName;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder isUploadStampedContract(final String isUploadStampedContract) {
         this.isUploadStampedContract = isUploadStampedContract;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder crmProjectScheduleTypeEnumName(final String crmProjectScheduleTypeEnumName) {
         this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder sealContractAttachmentList(final List<AttachmentDTO> sealContractAttachmentList) {
         this.sealContractAttachmentList = sealContractAttachmentList;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder reportingStatus(final Boolean reportingStatus) {
         this.reportingStatus = reportingStatus;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder reportingTime(final LocalDateTime reportingTime) {
         this.reportingTime = reportingTime;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder reportingUserId(final Long reportingUserId) {
         this.reportingUserId = reportingUserId;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder constructionOrganizationReportingStatus(final Boolean constructionOrganizationReportingStatus) {
         this.constructionOrganizationReportingStatus = constructionOrganizationReportingStatus;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder constructionOrganizationReportingTime(final LocalDateTime constructionOrganizationReportingTime) {
         this.constructionOrganizationReportingTime = constructionOrganizationReportingTime;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder constructionOrganizationReportingUserId(final Long constructionOrganizationReportingUserId) {
         this.constructionOrganizationReportingUserId = constructionOrganizationReportingUserId;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder constructionSupportServiceReportingStatus(
         final Boolean constructionSupportServiceReportingStatus
      ) {
         this.constructionSupportServiceReportingStatus = constructionSupportServiceReportingStatus;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder constructionSupportServiceReportingTime(
         final LocalDateTime constructionSupportServiceReportingTime
      ) {
         this.constructionSupportServiceReportingTime = constructionSupportServiceReportingTime;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder constructionSupportServiceReportingUserId(final Long constructionSupportServiceReportingUserId) {
         this.constructionSupportServiceReportingUserId = constructionSupportServiceReportingUserId;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder constructionCalculationReportingStatus(final Boolean constructionCalculationReportingStatus) {
         this.constructionCalculationReportingStatus = constructionCalculationReportingStatus;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder constructionCalculationReportingTime(final LocalDateTime constructionCalculationReportingTime) {
         this.constructionCalculationReportingTime = constructionCalculationReportingTime;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder constructionCalculationReportingUserId(final Long constructionCalculationReportingUserId) {
         this.constructionCalculationReportingUserId = constructionCalculationReportingUserId;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder animationReportingStatus(final Boolean animationReportingStatus) {
         this.animationReportingStatus = animationReportingStatus;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder animationReportingTime(final LocalDateTime animationReportingTime) {
         this.animationReportingTime = animationReportingTime;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder animationReportingUserId(final Long animationReportingUserId) {
         this.animationReportingUserId = animationReportingUserId;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder innovationReportingStatus(final Boolean innovationReportingStatus) {
         this.innovationReportingStatus = innovationReportingStatus;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder innovationReportingTime(final LocalDateTime innovationReportingTime) {
         this.innovationReportingTime = innovationReportingTime;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder innovationReportingUserId(final Long innovationReportingUserId) {
         this.innovationReportingUserId = innovationReportingUserId;
         return this;
      }

      public CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder crmSubmissionStatusEnum(final Integer crmSubmissionStatusEnum) {
         this.crmSubmissionStatusEnum = crmSubmissionStatusEnum;
         return this;
      }

      public CrmSpecialProgramsDTO build() {
         return new CrmSpecialProgramsDTO(
            this.id,
            this.informantDateTime,
            this.serialNumber,
            this.projectName,
            this.crmEnterpriseWarehousingName,
            this.crmProjectInformationWarehousingId,
            this.regionNames,
            this.structureTypeConfigurationName,
            this.estimatedCost,
            this.projectLevelConfigName,
            this.departmentName,
            this.informantUserName,
            this.isUploadStampedContract,
            this.crmProjectScheduleTypeEnumName,
            this.sealContractAttachmentList,
            this.reportingStatus,
            this.reportingTime,
            this.reportingUserId,
            this.constructionOrganizationReportingStatus,
            this.constructionOrganizationReportingTime,
            this.constructionOrganizationReportingUserId,
            this.constructionSupportServiceReportingStatus,
            this.constructionSupportServiceReportingTime,
            this.constructionSupportServiceReportingUserId,
            this.constructionCalculationReportingStatus,
            this.constructionCalculationReportingTime,
            this.constructionCalculationReportingUserId,
            this.animationReportingStatus,
            this.animationReportingTime,
            this.animationReportingUserId,
            this.innovationReportingStatus,
            this.innovationReportingTime,
            this.innovationReportingUserId,
            this.crmSubmissionStatusEnum
         );
      }

      @Override
      public String toString() {
         return "CrmSpecialProgramsDTO.CrmSpecialProgramsDTOBuilder(id="
            + this.id
            + ", informantDateTime="
            + this.informantDateTime
            + ", serialNumber="
            + this.serialNumber
            + ", projectName="
            + this.projectName
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", regionNames="
            + this.regionNames
            + ", structureTypeConfigurationName="
            + this.structureTypeConfigurationName
            + ", estimatedCost="
            + this.estimatedCost
            + ", projectLevelConfigName="
            + this.projectLevelConfigName
            + ", departmentName="
            + this.departmentName
            + ", informantUserName="
            + this.informantUserName
            + ", isUploadStampedContract="
            + this.isUploadStampedContract
            + ", crmProjectScheduleTypeEnumName="
            + this.crmProjectScheduleTypeEnumName
            + ", sealContractAttachmentList="
            + this.sealContractAttachmentList
            + ", reportingStatus="
            + this.reportingStatus
            + ", reportingTime="
            + this.reportingTime
            + ", reportingUserId="
            + this.reportingUserId
            + ", constructionOrganizationReportingStatus="
            + this.constructionOrganizationReportingStatus
            + ", constructionOrganizationReportingTime="
            + this.constructionOrganizationReportingTime
            + ", constructionOrganizationReportingUserId="
            + this.constructionOrganizationReportingUserId
            + ", constructionSupportServiceReportingStatus="
            + this.constructionSupportServiceReportingStatus
            + ", constructionSupportServiceReportingTime="
            + this.constructionSupportServiceReportingTime
            + ", constructionSupportServiceReportingUserId="
            + this.constructionSupportServiceReportingUserId
            + ", constructionCalculationReportingStatus="
            + this.constructionCalculationReportingStatus
            + ", constructionCalculationReportingTime="
            + this.constructionCalculationReportingTime
            + ", constructionCalculationReportingUserId="
            + this.constructionCalculationReportingUserId
            + ", animationReportingStatus="
            + this.animationReportingStatus
            + ", animationReportingTime="
            + this.animationReportingTime
            + ", animationReportingUserId="
            + this.animationReportingUserId
            + ", innovationReportingStatus="
            + this.innovationReportingStatus
            + ", innovationReportingTime="
            + this.innovationReportingTime
            + ", innovationReportingUserId="
            + this.innovationReportingUserId
            + ", crmSubmissionStatusEnum="
            + this.crmSubmissionStatusEnum
            + ")";
      }
   }
}
