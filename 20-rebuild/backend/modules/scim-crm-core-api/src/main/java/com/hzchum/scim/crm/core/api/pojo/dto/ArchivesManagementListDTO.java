package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class ArchivesManagementListDTO {
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
   @ApiModelProperty(name = "headOfCommerceName", notes = "商务负责人")
   private String headOfCommerceName;
   @ApiModelProperty(name = "projectBidManagerFinishDate", notes = "投标完成日期")
   private LocalDateTime projectBidManagerFinishDate;
   @ApiModelProperty(name = "serialNumber", notes = "项目备案号")
   private String serialNumber;

   public static ArchivesManagementListDTO.ArchivesManagementListDTOBuilder builder() {
      return new ArchivesManagementListDTO.ArchivesManagementListDTOBuilder();
   }

   public ArchivesManagementListDTO() {
   }

   public ArchivesManagementListDTO(
      final Long crmProjectInformationWarehousingId,
      final Integer crmTenderRequirementTypeEnum,
      final LocalDateTime createTime,
      final String departmentName,
      final String projectName,
      final String applyForBidReporterName,
      final String headOfCommerceName,
      final LocalDateTime projectBidManagerFinishDate,
      final String serialNumber
   ) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
      this.createTime = createTime;
      this.departmentName = departmentName;
      this.projectName = projectName;
      this.applyForBidReporterName = applyForBidReporterName;
      this.headOfCommerceName = headOfCommerceName;
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
      this.serialNumber = serialNumber;
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

   public String getHeadOfCommerceName() {
      return this.headOfCommerceName;
   }

   public LocalDateTime getProjectBidManagerFinishDate() {
      return this.projectBidManagerFinishDate;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public ArchivesManagementListDTO setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public ArchivesManagementListDTO setCrmTenderRequirementTypeEnum(final Integer crmTenderRequirementTypeEnum) {
      this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
      return this;
   }

   public ArchivesManagementListDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public ArchivesManagementListDTO setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   public ArchivesManagementListDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ArchivesManagementListDTO setApplyForBidReporterName(final String applyForBidReporterName) {
      this.applyForBidReporterName = applyForBidReporterName;
      return this;
   }

   public ArchivesManagementListDTO setHeadOfCommerceName(final String headOfCommerceName) {
      this.headOfCommerceName = headOfCommerceName;
      return this;
   }

   public ArchivesManagementListDTO setProjectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
      return this;
   }

   public ArchivesManagementListDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "ArchivesManagementListDTO(crmProjectInformationWarehousingId="
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
         + ", headOfCommerceName="
         + this.getHeadOfCommerceName()
         + ", projectBidManagerFinishDate="
         + this.getProjectBidManagerFinishDate()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArchivesManagementListDTO)) {
         return false;
      }

      ArchivesManagementListDTO other = (ArchivesManagementListDTO)o;
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
                        Object this$headOfCommerceName = this.getHeadOfCommerceName();
                        Object other$headOfCommerceName = other.getHeadOfCommerceName();
                        if (this$headOfCommerceName == null ? other$headOfCommerceName == null : this$headOfCommerceName.equals(other$headOfCommerceName)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArchivesManagementListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $crmTenderRequirementTypeEnum = this.getCrmTenderRequirementTypeEnum();
      result = result * 59 + ($crmTenderRequirementTypeEnum == null ? 43 : $crmTenderRequirementTypeEnum.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $applyForBidReporterName = this.getApplyForBidReporterName();
      result = result * 59 + ($applyForBidReporterName == null ? 43 : $applyForBidReporterName.hashCode());
      Object $headOfCommerceName = this.getHeadOfCommerceName();
      result = result * 59 + ($headOfCommerceName == null ? 43 : $headOfCommerceName.hashCode());
      Object $projectBidManagerFinishDate = this.getProjectBidManagerFinishDate();
      result = result * 59 + ($projectBidManagerFinishDate == null ? 43 : $projectBidManagerFinishDate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   public static class ArchivesManagementListDTOBuilder {
      private Long crmProjectInformationWarehousingId;
      private Integer crmTenderRequirementTypeEnum;
      private LocalDateTime createTime;
      private String departmentName;
      private String projectName;
      private String applyForBidReporterName;
      private String headOfCommerceName;
      private LocalDateTime projectBidManagerFinishDate;
      private String serialNumber;

      ArchivesManagementListDTOBuilder() {
      }

      public ArchivesManagementListDTO.ArchivesManagementListDTOBuilder crmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public ArchivesManagementListDTO.ArchivesManagementListDTOBuilder crmTenderRequirementTypeEnum(final Integer crmTenderRequirementTypeEnum) {
         this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
         return this;
      }

      public ArchivesManagementListDTO.ArchivesManagementListDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ArchivesManagementListDTO.ArchivesManagementListDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public ArchivesManagementListDTO.ArchivesManagementListDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ArchivesManagementListDTO.ArchivesManagementListDTOBuilder applyForBidReporterName(final String applyForBidReporterName) {
         this.applyForBidReporterName = applyForBidReporterName;
         return this;
      }

      public ArchivesManagementListDTO.ArchivesManagementListDTOBuilder headOfCommerceName(final String headOfCommerceName) {
         this.headOfCommerceName = headOfCommerceName;
         return this;
      }

      public ArchivesManagementListDTO.ArchivesManagementListDTOBuilder projectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
         this.projectBidManagerFinishDate = projectBidManagerFinishDate;
         return this;
      }

      public ArchivesManagementListDTO.ArchivesManagementListDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ArchivesManagementListDTO build() {
         return new ArchivesManagementListDTO(
            this.crmProjectInformationWarehousingId,
            this.crmTenderRequirementTypeEnum,
            this.createTime,
            this.departmentName,
            this.projectName,
            this.applyForBidReporterName,
            this.headOfCommerceName,
            this.projectBidManagerFinishDate,
            this.serialNumber
         );
      }

      @Override
      public String toString() {
         return "ArchivesManagementListDTO.ArchivesManagementListDTOBuilder(crmProjectInformationWarehousingId="
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
            + ", headOfCommerceName="
            + this.headOfCommerceName
            + ", projectBidManagerFinishDate="
            + this.projectBidManagerFinishDate
            + ", serialNumber="
            + this.serialNumber
            + ")";
      }
   }
}
