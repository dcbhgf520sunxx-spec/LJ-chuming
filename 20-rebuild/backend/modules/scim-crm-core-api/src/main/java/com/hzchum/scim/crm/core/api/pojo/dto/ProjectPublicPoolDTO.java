package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class ProjectPublicPoolDTO {
   @ApiModelProperty(name = "id", value = "项目备案id", notes = "项目备案id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "备案号", notes = "备案号")
   private String serialNumber;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "projectLevelConfigName", value = "项目级别 CrmProjectInformationConfig", notes = "项目级别 CrmProjectInformationConfig")
   private String projectLevelConfigName;
   @ApiModelProperty(name = "FollowUpTimes", value = "项目跟进次数", notes = "项目跟进次数")
   private Integer followUpTimes;
   @ApiModelProperty(name = "crmProjectScheduleTypeEnum", value = "当前状态", notes = "当前状态")
   private Integer crmProjectScheduleTypeEnum;
   @ApiModelProperty(name = "crmProjectScheduleTypeEnumName", value = "当前状态名称", notes = "当前状态名称")
   private String crmProjectScheduleTypeEnumName;

   public static ProjectPublicPoolDTO.ProjectPublicPoolDTOBuilder builder() {
      return new ProjectPublicPoolDTO.ProjectPublicPoolDTOBuilder();
   }

   public ProjectPublicPoolDTO() {
   }

   public ProjectPublicPoolDTO(
      final Long id,
      final String serialNumber,
      final LocalDateTime informantDateTime,
      final String projectName,
      final String projectLevelConfigName,
      final Integer followUpTimes,
      final Integer crmProjectScheduleTypeEnum,
      final String crmProjectScheduleTypeEnumName
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.informantDateTime = informantDateTime;
      this.projectName = projectName;
      this.projectLevelConfigName = projectLevelConfigName;
      this.followUpTimes = followUpTimes;
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
      this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectLevelConfigName() {
      return this.projectLevelConfigName;
   }

   public Integer getFollowUpTimes() {
      return this.followUpTimes;
   }

   public Integer getCrmProjectScheduleTypeEnum() {
      return this.crmProjectScheduleTypeEnum;
   }

   public String getCrmProjectScheduleTypeEnumName() {
      return this.crmProjectScheduleTypeEnumName;
   }

   public ProjectPublicPoolDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectPublicPoolDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ProjectPublicPoolDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public ProjectPublicPoolDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ProjectPublicPoolDTO setProjectLevelConfigName(final String projectLevelConfigName) {
      this.projectLevelConfigName = projectLevelConfigName;
      return this;
   }

   public ProjectPublicPoolDTO setFollowUpTimes(final Integer followUpTimes) {
      this.followUpTimes = followUpTimes;
      return this;
   }

   public ProjectPublicPoolDTO setCrmProjectScheduleTypeEnum(final Integer crmProjectScheduleTypeEnum) {
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
      return this;
   }

   public ProjectPublicPoolDTO setCrmProjectScheduleTypeEnumName(final String crmProjectScheduleTypeEnumName) {
      this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectPublicPoolDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", projectName="
         + this.getProjectName()
         + ", projectLevelConfigName="
         + this.getProjectLevelConfigName()
         + ", followUpTimes="
         + this.getFollowUpTimes()
         + ", crmProjectScheduleTypeEnum="
         + this.getCrmProjectScheduleTypeEnum()
         + ", crmProjectScheduleTypeEnumName="
         + this.getCrmProjectScheduleTypeEnumName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPublicPoolDTO)) {
         return false;
      }

      ProjectPublicPoolDTO other = (ProjectPublicPoolDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$followUpTimes = this.getFollowUpTimes();
         Object other$followUpTimes = other.getFollowUpTimes();
         if (this$followUpTimes == null ? other$followUpTimes == null : this$followUpTimes.equals(other$followUpTimes)) {
            Object this$crmProjectScheduleTypeEnum = this.getCrmProjectScheduleTypeEnum();
            Object other$crmProjectScheduleTypeEnum = other.getCrmProjectScheduleTypeEnum();
            if (this$crmProjectScheduleTypeEnum == null
               ? other$crmProjectScheduleTypeEnum == null
               : this$crmProjectScheduleTypeEnum.equals(other$crmProjectScheduleTypeEnum)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$informantDateTime = this.getInformantDateTime();
                  Object other$informantDateTime = other.getInformantDateTime();
                  if (this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime)) {
                     Object this$projectName = this.getProjectName();
                     Object other$projectName = other.getProjectName();
                     if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                        Object this$projectLevelConfigName = this.getProjectLevelConfigName();
                        Object other$projectLevelConfigName = other.getProjectLevelConfigName();
                        if (this$projectLevelConfigName == null
                           ? other$projectLevelConfigName == null
                           : this$projectLevelConfigName.equals(other$projectLevelConfigName)) {
                           Object this$crmProjectScheduleTypeEnumName = this.getCrmProjectScheduleTypeEnumName();
                           Object other$crmProjectScheduleTypeEnumName = other.getCrmProjectScheduleTypeEnumName();
                           return this$crmProjectScheduleTypeEnumName == null
                              ? other$crmProjectScheduleTypeEnumName == null
                              : this$crmProjectScheduleTypeEnumName.equals(other$crmProjectScheduleTypeEnumName);
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof ProjectPublicPoolDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $followUpTimes = this.getFollowUpTimes();
      result = result * 59 + ($followUpTimes == null ? 43 : $followUpTimes.hashCode());
      Object $crmProjectScheduleTypeEnum = this.getCrmProjectScheduleTypeEnum();
      result = result * 59 + ($crmProjectScheduleTypeEnum == null ? 43 : $crmProjectScheduleTypeEnum.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectLevelConfigName = this.getProjectLevelConfigName();
      result = result * 59 + ($projectLevelConfigName == null ? 43 : $projectLevelConfigName.hashCode());
      Object $crmProjectScheduleTypeEnumName = this.getCrmProjectScheduleTypeEnumName();
      return result * 59 + ($crmProjectScheduleTypeEnumName == null ? 43 : $crmProjectScheduleTypeEnumName.hashCode());
   }

   public static class ProjectPublicPoolDTOBuilder {
      private Long id;
      private String serialNumber;
      private LocalDateTime informantDateTime;
      private String projectName;
      private String projectLevelConfigName;
      private Integer followUpTimes;
      private Integer crmProjectScheduleTypeEnum;
      private String crmProjectScheduleTypeEnumName;

      ProjectPublicPoolDTOBuilder() {
      }

      public ProjectPublicPoolDTO.ProjectPublicPoolDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectPublicPoolDTO.ProjectPublicPoolDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectPublicPoolDTO.ProjectPublicPoolDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public ProjectPublicPoolDTO.ProjectPublicPoolDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ProjectPublicPoolDTO.ProjectPublicPoolDTOBuilder projectLevelConfigName(final String projectLevelConfigName) {
         this.projectLevelConfigName = projectLevelConfigName;
         return this;
      }

      public ProjectPublicPoolDTO.ProjectPublicPoolDTOBuilder followUpTimes(final Integer followUpTimes) {
         this.followUpTimes = followUpTimes;
         return this;
      }

      public ProjectPublicPoolDTO.ProjectPublicPoolDTOBuilder crmProjectScheduleTypeEnum(final Integer crmProjectScheduleTypeEnum) {
         this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
         return this;
      }

      public ProjectPublicPoolDTO.ProjectPublicPoolDTOBuilder crmProjectScheduleTypeEnumName(final String crmProjectScheduleTypeEnumName) {
         this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
         return this;
      }

      public ProjectPublicPoolDTO build() {
         return new ProjectPublicPoolDTO(
            this.id,
            this.serialNumber,
            this.informantDateTime,
            this.projectName,
            this.projectLevelConfigName,
            this.followUpTimes,
            this.crmProjectScheduleTypeEnum,
            this.crmProjectScheduleTypeEnumName
         );
      }

      @Override
      public String toString() {
         return "ProjectPublicPoolDTO.ProjectPublicPoolDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", informantDateTime="
            + this.informantDateTime
            + ", projectName="
            + this.projectName
            + ", projectLevelConfigName="
            + this.projectLevelConfigName
            + ", followUpTimes="
            + this.followUpTimes
            + ", crmProjectScheduleTypeEnum="
            + this.crmProjectScheduleTypeEnum
            + ", crmProjectScheduleTypeEnumName="
            + this.crmProjectScheduleTypeEnumName
            + ")";
      }
   }
}
