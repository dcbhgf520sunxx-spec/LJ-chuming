package com.hzchum.scim.mes.building.core.api.pojo._doParam.qhse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingQhseFormParam", description = "问题报表报表 ")
public class MesBuildingQhseFormParam {
   @ApiModelProperty(name = "startDate", value = "开始时间")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "结束时间")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "specifyTheDate", value = "指定日期")
   private LocalDate specifyTheDate;
   @ApiModelProperty(name = "userId", value = "用户id")
   private Long userId;
   @ApiModelProperty(name = "status", value = "处理状态", notes = "处理状态")
   private Integer status;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   private Long processId;
   @ApiModelProperty(name = "levelOneType", value = "问题一级分类")
   private Long levelOneType;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "inspectionUserName", value = "质检人")
   private String inspectionUserName;
   @ApiModelProperty(name = "teamLeaderName", value = "班组长")
   private String teamLeaderName;

   public static MesBuildingQhseFormParam.MesBuildingQhseFormParamBuilder builder() {
      return new MesBuildingQhseFormParam.MesBuildingQhseFormParamBuilder();
   }

   public MesBuildingQhseFormParam() {
   }

   public MesBuildingQhseFormParam(
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final LocalDate specifyTheDate,
      final Long userId,
      final Integer status,
      final Long processId,
      final Long levelOneType,
      final String projectName,
      final String serialNumber,
      final String inspectionUserName,
      final String teamLeaderName
   ) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.specifyTheDate = specifyTheDate;
      this.userId = userId;
      this.status = status;
      this.processId = processId;
      this.levelOneType = levelOneType;
      this.projectName = projectName;
      this.serialNumber = serialNumber;
      this.inspectionUserName = inspectionUserName;
      this.teamLeaderName = teamLeaderName;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public LocalDate getSpecifyTheDate() {
      return this.specifyTheDate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getLevelOneType() {
      return this.levelOneType;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getInspectionUserName() {
      return this.inspectionUserName;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public MesBuildingQhseFormParam setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   public MesBuildingQhseFormParam setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   public MesBuildingQhseFormParam setSpecifyTheDate(final LocalDate specifyTheDate) {
      this.specifyTheDate = specifyTheDate;
      return this;
   }

   public MesBuildingQhseFormParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public MesBuildingQhseFormParam setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public MesBuildingQhseFormParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesBuildingQhseFormParam setLevelOneType(final Long levelOneType) {
      this.levelOneType = levelOneType;
      return this;
   }

   public MesBuildingQhseFormParam setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public MesBuildingQhseFormParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesBuildingQhseFormParam setInspectionUserName(final String inspectionUserName) {
      this.inspectionUserName = inspectionUserName;
      return this;
   }

   public MesBuildingQhseFormParam setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQhseFormParam)) {
         return false;
      }

      MesBuildingQhseFormParam other = (MesBuildingQhseFormParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$levelOneType = this.getLevelOneType();
               Object other$levelOneType = other.getLevelOneType();
               if (this$levelOneType == null ? other$levelOneType == null : this$levelOneType.equals(other$levelOneType)) {
                  Object this$startDate = this.getStartDate();
                  Object other$startDate = other.getStartDate();
                  if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                     Object this$endDate = this.getEndDate();
                     Object other$endDate = other.getEndDate();
                     if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                        Object this$specifyTheDate = this.getSpecifyTheDate();
                        Object other$specifyTheDate = other.getSpecifyTheDate();
                        if (this$specifyTheDate == null ? other$specifyTheDate == null : this$specifyTheDate.equals(other$specifyTheDate)) {
                           Object this$projectName = this.getProjectName();
                           Object other$projectName = other.getProjectName();
                           if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$inspectionUserName = this.getInspectionUserName();
                                 Object other$inspectionUserName = other.getInspectionUserName();
                                 if (this$inspectionUserName == null
                                    ? other$inspectionUserName == null
                                    : this$inspectionUserName.equals(other$inspectionUserName)) {
                                    Object this$teamLeaderName = this.getTeamLeaderName();
                                    Object other$teamLeaderName = other.getTeamLeaderName();
                                    return this$teamLeaderName == null ? other$teamLeaderName == null : this$teamLeaderName.equals(other$teamLeaderName);
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesBuildingQhseFormParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $levelOneType = this.getLevelOneType();
      result = result * 59 + ($levelOneType == null ? 43 : $levelOneType.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $specifyTheDate = this.getSpecifyTheDate();
      result = result * 59 + ($specifyTheDate == null ? 43 : $specifyTheDate.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $inspectionUserName = this.getInspectionUserName();
      result = result * 59 + ($inspectionUserName == null ? 43 : $inspectionUserName.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      return result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingQhseFormParam(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", specifyTheDate="
         + this.getSpecifyTheDate()
         + ", userId="
         + this.getUserId()
         + ", status="
         + this.getStatus()
         + ", processId="
         + this.getProcessId()
         + ", levelOneType="
         + this.getLevelOneType()
         + ", projectName="
         + this.getProjectName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", inspectionUserName="
         + this.getInspectionUserName()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ")";
   }

   public static class MesBuildingQhseFormParamBuilder {
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private LocalDate specifyTheDate;
      private Long userId;
      private Integer status;
      private Long processId;
      private Long levelOneType;
      private String projectName;
      private String serialNumber;
      private String inspectionUserName;
      private String teamLeaderName;

      MesBuildingQhseFormParamBuilder() {
      }

      public MesBuildingQhseFormParam.MesBuildingQhseFormParamBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public MesBuildingQhseFormParam.MesBuildingQhseFormParamBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public MesBuildingQhseFormParam.MesBuildingQhseFormParamBuilder specifyTheDate(final LocalDate specifyTheDate) {
         this.specifyTheDate = specifyTheDate;
         return this;
      }

      public MesBuildingQhseFormParam.MesBuildingQhseFormParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingQhseFormParam.MesBuildingQhseFormParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public MesBuildingQhseFormParam.MesBuildingQhseFormParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBuildingQhseFormParam.MesBuildingQhseFormParamBuilder levelOneType(final Long levelOneType) {
         this.levelOneType = levelOneType;
         return this;
      }

      public MesBuildingQhseFormParam.MesBuildingQhseFormParamBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public MesBuildingQhseFormParam.MesBuildingQhseFormParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesBuildingQhseFormParam.MesBuildingQhseFormParamBuilder inspectionUserName(final String inspectionUserName) {
         this.inspectionUserName = inspectionUserName;
         return this;
      }

      public MesBuildingQhseFormParam.MesBuildingQhseFormParamBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      public MesBuildingQhseFormParam build() {
         return new MesBuildingQhseFormParam(
            this.startDate,
            this.endDate,
            this.specifyTheDate,
            this.userId,
            this.status,
            this.processId,
            this.levelOneType,
            this.projectName,
            this.serialNumber,
            this.inspectionUserName,
            this.teamLeaderName
         );
      }

      @Override
      public String toString() {
         return "MesBuildingQhseFormParam.MesBuildingQhseFormParamBuilder(startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", specifyTheDate="
            + this.specifyTheDate
            + ", userId="
            + this.userId
            + ", status="
            + this.status
            + ", processId="
            + this.processId
            + ", levelOneType="
            + this.levelOneType
            + ", projectName="
            + this.projectName
            + ", serialNumber="
            + this.serialNumber
            + ", inspectionUserName="
            + this.inspectionUserName
            + ", teamLeaderName="
            + this.teamLeaderName
            + ")";
      }
   }
}
