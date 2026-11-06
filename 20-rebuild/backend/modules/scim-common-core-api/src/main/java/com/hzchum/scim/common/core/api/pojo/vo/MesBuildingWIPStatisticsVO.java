package com.hzchum.scim.common.core.api.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel(value = "MesBuildingWIPStatisticsVO", description = "在制品vo ")
public class MesBuildingWIPStatisticsVO {
   @ApiModelProperty(name = "workshopId", notes = "车间Id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workShopId;
   @ApiModelProperty(name = "projectId", notes = "项目Id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "branchCompanyId", notes = "分支机构")
   @JsonProperty("branchCompanyId")
   @JSONField(name = "branchCompanyId")
   private Long branchCompanyId;
   @ApiModelProperty(name = "projectSerialNumber", notes = "项目编号或名称")
   @JsonProperty("projectSerialNumber")
   @JSONField(name = "projectSerialNumber")
   private String projectSerialNumber;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "processId", notes = "工序Id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "date", notes = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private LocalDate date;

   public static MesBuildingWIPStatisticsVO.MesBuildingWIPStatisticsVOBuilder builder() {
      return new MesBuildingWIPStatisticsVO.MesBuildingWIPStatisticsVOBuilder();
   }

   public MesBuildingWIPStatisticsVO() {
   }

   public MesBuildingWIPStatisticsVO(
      final Long workShopId,
      final Long projectId,
      final Long branchCompanyId,
      final String projectSerialNumber,
      final Integer taskTypeEnum,
      final Long processId,
      final LocalDate date
   ) {
      this.workShopId = workShopId;
      this.projectId = projectId;
      this.branchCompanyId = branchCompanyId;
      this.projectSerialNumber = projectSerialNumber;
      this.taskTypeEnum = taskTypeEnum;
      this.processId = processId;
      this.date = date;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public LocalDate getDate() {
      return this.date;
   }

   @JsonProperty("workshopId")
   public MesBuildingWIPStatisticsVO setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingWIPStatisticsVO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("branchCompanyId")
   public MesBuildingWIPStatisticsVO setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   @JsonProperty("projectSerialNumber")
   public MesBuildingWIPStatisticsVO setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingWIPStatisticsVO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingWIPStatisticsVO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("date")
   public MesBuildingWIPStatisticsVO setDate(final LocalDate date) {
      this.date = date;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWIPStatisticsVO)) {
         return false;
      }

      MesBuildingWIPStatisticsVO other = (MesBuildingWIPStatisticsVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workShopId = this.getWorkShopId();
      Object other$workShopId = other.getWorkShopId();
      if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$branchCompanyId = this.getBranchCompanyId();
            Object other$branchCompanyId = other.getBranchCompanyId();
            if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
               Object this$taskTypeEnum = this.getTaskTypeEnum();
               Object other$taskTypeEnum = other.getTaskTypeEnum();
               if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$projectSerialNumber = this.getProjectSerialNumber();
                     Object other$projectSerialNumber = other.getProjectSerialNumber();
                     if (this$projectSerialNumber == null ? other$projectSerialNumber == null : this$projectSerialNumber.equals(other$projectSerialNumber)) {
                        Object this$date = this.getDate();
                        Object other$date = other.getDate();
                        return this$date == null ? other$date == null : this$date.equals(other$date);
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesBuildingWIPStatisticsVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingWIPStatisticsVO(workShopId="
         + this.getWorkShopId()
         + ", projectId="
         + this.getProjectId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", processId="
         + this.getProcessId()
         + ", date="
         + this.getDate()
         + ")";
   }

   public static class MesBuildingWIPStatisticsVOBuilder {
      private Long workShopId;
      private Long projectId;
      private Long branchCompanyId;
      private String projectSerialNumber;
      private Integer taskTypeEnum;
      private Long processId;
      private LocalDate date;

      MesBuildingWIPStatisticsVOBuilder() {
      }

      @JsonProperty("workshopId")
      public MesBuildingWIPStatisticsVO.MesBuildingWIPStatisticsVOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingWIPStatisticsVO.MesBuildingWIPStatisticsVOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("branchCompanyId")
      public MesBuildingWIPStatisticsVO.MesBuildingWIPStatisticsVOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      @JsonProperty("projectSerialNumber")
      public MesBuildingWIPStatisticsVO.MesBuildingWIPStatisticsVOBuilder projectSerialNumber(final String projectSerialNumber) {
         this.projectSerialNumber = projectSerialNumber;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingWIPStatisticsVO.MesBuildingWIPStatisticsVOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingWIPStatisticsVO.MesBuildingWIPStatisticsVOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("date")
      public MesBuildingWIPStatisticsVO.MesBuildingWIPStatisticsVOBuilder date(final LocalDate date) {
         this.date = date;
         return this;
      }

      public MesBuildingWIPStatisticsVO build() {
         return new MesBuildingWIPStatisticsVO(
            this.workShopId, this.projectId, this.branchCompanyId, this.projectSerialNumber, this.taskTypeEnum, this.processId, this.date
         );
      }

      @Override
      public String toString() {
         return "MesBuildingWIPStatisticsVO.MesBuildingWIPStatisticsVOBuilder(workShopId="
            + this.workShopId
            + ", projectId="
            + this.projectId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", projectSerialNumber="
            + this.projectSerialNumber
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", processId="
            + this.processId
            + ", date="
            + this.date
            + ")";
      }
   }
}
