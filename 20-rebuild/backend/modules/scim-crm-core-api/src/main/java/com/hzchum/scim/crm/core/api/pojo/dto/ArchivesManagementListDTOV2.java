package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class ArchivesManagementListDTOV2 {
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "crmTenderRequirementTypeEnum", notes = "投类型")
   private Integer crmTenderRequirementTypeEnum;
   @ApiModelProperty(name = "createTime", notes = "项目创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "departmentName", notes = "部门名称")
   private String departmentName;
   @ApiModelProperty(name = "projectName", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "applyForBidReporterName", notes = "投标人")
   private String applyForBidReporterName;
   @ApiModelProperty(name = "applyForBidReporterId", notes = "投标人id")
   private String applyForBidReporterId;
   @ApiModelProperty(name = "headOfCommerceIds", notes = "商务负责人Id")
   private String headOfCommerceIds;
   @ApiModelProperty(name = "headOfCommerceName", notes = "商务负责人")
   private String headOfCommerceName;
   @ApiModelProperty(name = "projectBidManagerFinishDate", notes = "投标完成日期")
   private LocalDateTime projectBidManagerFinishDate;
   @ApiModelProperty(name = "serialNumber", notes = "项目备案号")
   private String serialNumber;
   private Integer crmSpecialBubmissionStatusEnum;
   private Integer crmSettlementBusinessTypeEnum;
   private Long crmApplyTechnologyBiddingRecordId;

   public static ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder builder() {
      return new ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder();
   }

   public ArchivesManagementListDTOV2() {
   }

   public ArchivesManagementListDTOV2(
      final Long crmProjectInformationWarehousingId,
      final Integer crmTenderRequirementTypeEnum,
      final LocalDateTime createTime,
      final String departmentName,
      final String projectName,
      final String applyForBidReporterName,
      final String applyForBidReporterId,
      final String headOfCommerceIds,
      final String headOfCommerceName,
      final LocalDateTime projectBidManagerFinishDate,
      final String serialNumber,
      final Integer crmSpecialBubmissionStatusEnum,
      final Integer crmSettlementBusinessTypeEnum,
      final Long crmApplyTechnologyBiddingRecordId
   ) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
      this.createTime = createTime;
      this.departmentName = departmentName;
      this.projectName = projectName;
      this.applyForBidReporterName = applyForBidReporterName;
      this.applyForBidReporterId = applyForBidReporterId;
      this.headOfCommerceIds = headOfCommerceIds;
      this.headOfCommerceName = headOfCommerceName;
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
      this.serialNumber = serialNumber;
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
      this.crmApplyTechnologyBiddingRecordId = crmApplyTechnologyBiddingRecordId;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public Integer getCrmTenderRequirementTypeEnum() {
      return this.crmTenderRequirementTypeEnum;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getApplyForBidReporterName() {
      return this.applyForBidReporterName;
   }

   public String getApplyForBidReporterId() {
      return this.applyForBidReporterId;
   }

   public String getHeadOfCommerceIds() {
      return this.headOfCommerceIds;
   }

   public String getHeadOfCommerceName() {
      return this.headOfCommerceName;
   }

   public LocalDateTime getProjectBidManagerFinishDate() {
      return this.projectBidManagerFinishDate;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getCrmSpecialBubmissionStatusEnum() {
      return this.crmSpecialBubmissionStatusEnum;
   }

   public Integer getCrmSettlementBusinessTypeEnum() {
      return this.crmSettlementBusinessTypeEnum;
   }

   public Long getCrmApplyTechnologyBiddingRecordId() {
      return this.crmApplyTechnologyBiddingRecordId;
   }

   public ArchivesManagementListDTOV2 setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public ArchivesManagementListDTOV2 setCrmTenderRequirementTypeEnum(final Integer crmTenderRequirementTypeEnum) {
      this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
      return this;
   }

   public ArchivesManagementListDTOV2 setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public ArchivesManagementListDTOV2 setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   public ArchivesManagementListDTOV2 setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ArchivesManagementListDTOV2 setApplyForBidReporterName(final String applyForBidReporterName) {
      this.applyForBidReporterName = applyForBidReporterName;
      return this;
   }

   public ArchivesManagementListDTOV2 setApplyForBidReporterId(final String applyForBidReporterId) {
      this.applyForBidReporterId = applyForBidReporterId;
      return this;
   }

   public ArchivesManagementListDTOV2 setHeadOfCommerceIds(final String headOfCommerceIds) {
      this.headOfCommerceIds = headOfCommerceIds;
      return this;
   }

   public ArchivesManagementListDTOV2 setHeadOfCommerceName(final String headOfCommerceName) {
      this.headOfCommerceName = headOfCommerceName;
      return this;
   }

   public ArchivesManagementListDTOV2 setProjectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
      return this;
   }

   public ArchivesManagementListDTOV2 setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ArchivesManagementListDTOV2 setCrmSpecialBubmissionStatusEnum(final Integer crmSpecialBubmissionStatusEnum) {
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
      return this;
   }

   public ArchivesManagementListDTOV2 setCrmSettlementBusinessTypeEnum(final Integer crmSettlementBusinessTypeEnum) {
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
      return this;
   }

   public ArchivesManagementListDTOV2 setCrmApplyTechnologyBiddingRecordId(final Long crmApplyTechnologyBiddingRecordId) {
      this.crmApplyTechnologyBiddingRecordId = crmApplyTechnologyBiddingRecordId;
      return this;
   }

   @Override
   public String toString() {
      return "ArchivesManagementListDTOV2(crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", crmTenderRequirementTypeEnum="
         + this.getCrmTenderRequirementTypeEnum()
         + ", createTime="
         + this.getCreateTime()
         + ", departmentName="
         + this.getDepartmentName()
         + ", projectName="
         + this.getProjectName()
         + ", applyForBidReporterName="
         + this.getApplyForBidReporterName()
         + ", applyForBidReporterId="
         + this.getApplyForBidReporterId()
         + ", headOfCommerceIds="
         + this.getHeadOfCommerceIds()
         + ", headOfCommerceName="
         + this.getHeadOfCommerceName()
         + ", projectBidManagerFinishDate="
         + this.getProjectBidManagerFinishDate()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", crmSpecialBubmissionStatusEnum="
         + this.getCrmSpecialBubmissionStatusEnum()
         + ", crmSettlementBusinessTypeEnum="
         + this.getCrmSettlementBusinessTypeEnum()
         + ", crmApplyTechnologyBiddingRecordId="
         + this.getCrmApplyTechnologyBiddingRecordId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArchivesManagementListDTOV2)) {
         return false;
      }

      ArchivesManagementListDTOV2 other = (ArchivesManagementListDTOV2)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
      if (this$crmProjectInformationWarehousingId == null
         ? other$crmProjectInformationWarehousingId == null
         : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
         Object this$crmTenderRequirementTypeEnum = this.getCrmTenderRequirementTypeEnum();
         Object other$crmTenderRequirementTypeEnum = other.getCrmTenderRequirementTypeEnum();
         if (this$crmTenderRequirementTypeEnum == null
            ? other$crmTenderRequirementTypeEnum == null
            : this$crmTenderRequirementTypeEnum.equals(other$crmTenderRequirementTypeEnum)) {
            Object this$crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
            Object other$crmSpecialBubmissionStatusEnum = other.getCrmSpecialBubmissionStatusEnum();
            if (this$crmSpecialBubmissionStatusEnum == null
               ? other$crmSpecialBubmissionStatusEnum == null
               : this$crmSpecialBubmissionStatusEnum.equals(other$crmSpecialBubmissionStatusEnum)) {
               Object this$crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
               Object other$crmSettlementBusinessTypeEnum = other.getCrmSettlementBusinessTypeEnum();
               if (this$crmSettlementBusinessTypeEnum == null
                  ? other$crmSettlementBusinessTypeEnum == null
                  : this$crmSettlementBusinessTypeEnum.equals(other$crmSettlementBusinessTypeEnum)) {
                  Object this$crmApplyTechnologyBiddingRecordId = this.getCrmApplyTechnologyBiddingRecordId();
                  Object other$crmApplyTechnologyBiddingRecordId = other.getCrmApplyTechnologyBiddingRecordId();
                  if (this$crmApplyTechnologyBiddingRecordId == null
                     ? other$crmApplyTechnologyBiddingRecordId == null
                     : this$crmApplyTechnologyBiddingRecordId.equals(other$crmApplyTechnologyBiddingRecordId)) {
                     Object this$createTime = this.getCreateTime();
                     Object other$createTime = other.getCreateTime();
                     if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                        Object this$departmentName = this.getDepartmentName();
                        Object other$departmentName = other.getDepartmentName();
                        if (this$departmentName == null ? other$departmentName == null : this$departmentName.equals(other$departmentName)) {
                           Object this$projectName = this.getProjectName();
                           Object other$projectName = other.getProjectName();
                           if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                              Object this$applyForBidReporterName = this.getApplyForBidReporterName();
                              Object other$applyForBidReporterName = other.getApplyForBidReporterName();
                              if (this$applyForBidReporterName == null
                                 ? other$applyForBidReporterName == null
                                 : this$applyForBidReporterName.equals(other$applyForBidReporterName)) {
                                 Object this$applyForBidReporterId = this.getApplyForBidReporterId();
                                 Object other$applyForBidReporterId = other.getApplyForBidReporterId();
                                 if (this$applyForBidReporterId == null
                                    ? other$applyForBidReporterId == null
                                    : this$applyForBidReporterId.equals(other$applyForBidReporterId)) {
                                    Object this$headOfCommerceIds = this.getHeadOfCommerceIds();
                                    Object other$headOfCommerceIds = other.getHeadOfCommerceIds();
                                    if (this$headOfCommerceIds == null
                                       ? other$headOfCommerceIds == null
                                       : this$headOfCommerceIds.equals(other$headOfCommerceIds)) {
                                       Object this$headOfCommerceName = this.getHeadOfCommerceName();
                                       Object other$headOfCommerceName = other.getHeadOfCommerceName();
                                       if (this$headOfCommerceName == null
                                          ? other$headOfCommerceName == null
                                          : this$headOfCommerceName.equals(other$headOfCommerceName)) {
                                          Object this$projectBidManagerFinishDate = this.getProjectBidManagerFinishDate();
                                          Object other$projectBidManagerFinishDate = other.getProjectBidManagerFinishDate();
                                          if (this$projectBidManagerFinishDate == null
                                             ? other$projectBidManagerFinishDate == null
                                             : this$projectBidManagerFinishDate.equals(other$projectBidManagerFinishDate)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof ArchivesManagementListDTOV2;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $crmTenderRequirementTypeEnum = this.getCrmTenderRequirementTypeEnum();
      result = result * 59 + ($crmTenderRequirementTypeEnum == null ? 43 : $crmTenderRequirementTypeEnum.hashCode());
      Object $crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
      result = result * 59 + ($crmSpecialBubmissionStatusEnum == null ? 43 : $crmSpecialBubmissionStatusEnum.hashCode());
      Object $crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
      result = result * 59 + ($crmSettlementBusinessTypeEnum == null ? 43 : $crmSettlementBusinessTypeEnum.hashCode());
      Object $crmApplyTechnologyBiddingRecordId = this.getCrmApplyTechnologyBiddingRecordId();
      result = result * 59 + ($crmApplyTechnologyBiddingRecordId == null ? 43 : $crmApplyTechnologyBiddingRecordId.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $applyForBidReporterName = this.getApplyForBidReporterName();
      result = result * 59 + ($applyForBidReporterName == null ? 43 : $applyForBidReporterName.hashCode());
      Object $applyForBidReporterId = this.getApplyForBidReporterId();
      result = result * 59 + ($applyForBidReporterId == null ? 43 : $applyForBidReporterId.hashCode());
      Object $headOfCommerceIds = this.getHeadOfCommerceIds();
      result = result * 59 + ($headOfCommerceIds == null ? 43 : $headOfCommerceIds.hashCode());
      Object $headOfCommerceName = this.getHeadOfCommerceName();
      result = result * 59 + ($headOfCommerceName == null ? 43 : $headOfCommerceName.hashCode());
      Object $projectBidManagerFinishDate = this.getProjectBidManagerFinishDate();
      result = result * 59 + ($projectBidManagerFinishDate == null ? 43 : $projectBidManagerFinishDate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   public static class ArchivesManagementListDTOV2Builder {
      private Long crmProjectInformationWarehousingId;
      private Integer crmTenderRequirementTypeEnum;
      private LocalDateTime createTime;
      private String departmentName;
      private String projectName;
      private String applyForBidReporterName;
      private String applyForBidReporterId;
      private String headOfCommerceIds;
      private String headOfCommerceName;
      private LocalDateTime projectBidManagerFinishDate;
      private String serialNumber;
      private Integer crmSpecialBubmissionStatusEnum;
      private Integer crmSettlementBusinessTypeEnum;
      private Long crmApplyTechnologyBiddingRecordId;

      ArchivesManagementListDTOV2Builder() {
      }

      public ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder crmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder crmTenderRequirementTypeEnum(final Integer crmTenderRequirementTypeEnum) {
         this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
         return this;
      }

      public ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder applyForBidReporterName(final String applyForBidReporterName) {
         this.applyForBidReporterName = applyForBidReporterName;
         return this;
      }

      public ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder applyForBidReporterId(final String applyForBidReporterId) {
         this.applyForBidReporterId = applyForBidReporterId;
         return this;
      }

      public ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder headOfCommerceIds(final String headOfCommerceIds) {
         this.headOfCommerceIds = headOfCommerceIds;
         return this;
      }

      public ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder headOfCommerceName(final String headOfCommerceName) {
         this.headOfCommerceName = headOfCommerceName;
         return this;
      }

      public ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder projectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
         this.projectBidManagerFinishDate = projectBidManagerFinishDate;
         return this;
      }

      public ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder crmSpecialBubmissionStatusEnum(final Integer crmSpecialBubmissionStatusEnum) {
         this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
         return this;
      }

      public ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder crmSettlementBusinessTypeEnum(final Integer crmSettlementBusinessTypeEnum) {
         this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
         return this;
      }

      public ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder crmApplyTechnologyBiddingRecordId(final Long crmApplyTechnologyBiddingRecordId) {
         this.crmApplyTechnologyBiddingRecordId = crmApplyTechnologyBiddingRecordId;
         return this;
      }

      public ArchivesManagementListDTOV2 build() {
         return new ArchivesManagementListDTOV2(
            this.crmProjectInformationWarehousingId,
            this.crmTenderRequirementTypeEnum,
            this.createTime,
            this.departmentName,
            this.projectName,
            this.applyForBidReporterName,
            this.applyForBidReporterId,
            this.headOfCommerceIds,
            this.headOfCommerceName,
            this.projectBidManagerFinishDate,
            this.serialNumber,
            this.crmSpecialBubmissionStatusEnum,
            this.crmSettlementBusinessTypeEnum,
            this.crmApplyTechnologyBiddingRecordId
         );
      }

      @Override
      public String toString() {
         return "ArchivesManagementListDTOV2.ArchivesManagementListDTOV2Builder(crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", crmTenderRequirementTypeEnum="
            + this.crmTenderRequirementTypeEnum
            + ", createTime="
            + this.createTime
            + ", departmentName="
            + this.departmentName
            + ", projectName="
            + this.projectName
            + ", applyForBidReporterName="
            + this.applyForBidReporterName
            + ", applyForBidReporterId="
            + this.applyForBidReporterId
            + ", headOfCommerceIds="
            + this.headOfCommerceIds
            + ", headOfCommerceName="
            + this.headOfCommerceName
            + ", projectBidManagerFinishDate="
            + this.projectBidManagerFinishDate
            + ", serialNumber="
            + this.serialNumber
            + ", crmSpecialBubmissionStatusEnum="
            + this.crmSpecialBubmissionStatusEnum
            + ", crmSettlementBusinessTypeEnum="
            + this.crmSettlementBusinessTypeEnum
            + ", crmApplyTechnologyBiddingRecordId="
            + this.crmApplyTechnologyBiddingRecordId
            + ")";
      }
   }
}
