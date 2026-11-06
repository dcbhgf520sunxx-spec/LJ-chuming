package com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectProductionStatisticsProcessDTO", description = "获取项目生产统计工序详情")
public class ProjectProductionStatisticsProcessDTO {
   @ApiModelProperty(name = "processId", notes = "工序Id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "taskTotalQuantity", notes = "任务总数")
   @JsonProperty("taskTotalQuantity")
   @JSONField(name = "taskTotalQuantity")
   private Integer taskTotalQuantity;
   @ApiModelProperty(name = "taskTotalNetWeight", notes = "任务总净重(吨)")
   @JsonProperty("taskTotalNetWeight")
   @JSONField(name = "taskTotalNetWeight")
   private BigDecimal taskTotalNetWeight;
   @ApiModelProperty(name = "taskTotalGrossWeight", notes = "任务总毛重(吨)")
   @JsonProperty("taskTotalGrossWeight")
   @JSONField(name = "taskTotalGrossWeight")
   private BigDecimal taskTotalGrossWeight;
   @ApiModelProperty(name = "taskCompanyTotalQuantity", notes = "任务完成总数")
   @JsonProperty("taskCompanyTotalQuantity")
   @JSONField(name = "taskCompanyTotalQuantity")
   private Integer taskCompanyTotalQuantity;
   @ApiModelProperty(name = "taskCompanyTotalNetWeight", notes = "任务完成总净重(吨)")
   @JsonProperty("taskCompanyTotalNetWeight")
   @JSONField(name = "taskCompanyTotalNetWeight")
   private BigDecimal taskCompanyTotalNetWeight;
   @ApiModelProperty(name = "taskCompanyTotalGrossWeight", notes = "任务完成总毛重(吨)")
   @JsonProperty("taskCompanyTotalGrossWeight")
   @JSONField(name = "taskCompanyTotalGrossWeight")
   private BigDecimal taskCompanyTotalGrossWeight;

   public static ProjectProductionStatisticsProcessDTO.ProjectProductionStatisticsProcessDTOBuilder builder() {
      return new ProjectProductionStatisticsProcessDTO.ProjectProductionStatisticsProcessDTOBuilder();
   }

   public ProjectProductionStatisticsProcessDTO() {
   }

   public ProjectProductionStatisticsProcessDTO(
      final Long processId,
      final String processName,
      final Integer taskTotalQuantity,
      final BigDecimal taskTotalNetWeight,
      final BigDecimal taskTotalGrossWeight,
      final Integer taskCompanyTotalQuantity,
      final BigDecimal taskCompanyTotalNetWeight,
      final BigDecimal taskCompanyTotalGrossWeight
   ) {
      this.processId = processId;
      this.processName = processName;
      this.taskTotalQuantity = taskTotalQuantity;
      this.taskTotalNetWeight = taskTotalNetWeight;
      this.taskTotalGrossWeight = taskTotalGrossWeight;
      this.taskCompanyTotalQuantity = taskCompanyTotalQuantity;
      this.taskCompanyTotalNetWeight = taskCompanyTotalNetWeight;
      this.taskCompanyTotalGrossWeight = taskCompanyTotalGrossWeight;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getTaskTotalQuantity() {
      return this.taskTotalQuantity;
   }

   public BigDecimal getTaskTotalNetWeight() {
      return this.taskTotalNetWeight;
   }

   public BigDecimal getTaskTotalGrossWeight() {
      return this.taskTotalGrossWeight;
   }

   public Integer getTaskCompanyTotalQuantity() {
      return this.taskCompanyTotalQuantity;
   }

   public BigDecimal getTaskCompanyTotalNetWeight() {
      return this.taskCompanyTotalNetWeight;
   }

   public BigDecimal getTaskCompanyTotalGrossWeight() {
      return this.taskCompanyTotalGrossWeight;
   }

   @JsonProperty("processId")
   public ProjectProductionStatisticsProcessDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public ProjectProductionStatisticsProcessDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("taskTotalQuantity")
   public ProjectProductionStatisticsProcessDTO setTaskTotalQuantity(final Integer taskTotalQuantity) {
      this.taskTotalQuantity = taskTotalQuantity;
      return this;
   }

   @JsonProperty("taskTotalNetWeight")
   public ProjectProductionStatisticsProcessDTO setTaskTotalNetWeight(final BigDecimal taskTotalNetWeight) {
      this.taskTotalNetWeight = taskTotalNetWeight;
      return this;
   }

   @JsonProperty("taskTotalGrossWeight")
   public ProjectProductionStatisticsProcessDTO setTaskTotalGrossWeight(final BigDecimal taskTotalGrossWeight) {
      this.taskTotalGrossWeight = taskTotalGrossWeight;
      return this;
   }

   @JsonProperty("taskCompanyTotalQuantity")
   public ProjectProductionStatisticsProcessDTO setTaskCompanyTotalQuantity(final Integer taskCompanyTotalQuantity) {
      this.taskCompanyTotalQuantity = taskCompanyTotalQuantity;
      return this;
   }

   @JsonProperty("taskCompanyTotalNetWeight")
   public ProjectProductionStatisticsProcessDTO setTaskCompanyTotalNetWeight(final BigDecimal taskCompanyTotalNetWeight) {
      this.taskCompanyTotalNetWeight = taskCompanyTotalNetWeight;
      return this;
   }

   @JsonProperty("taskCompanyTotalGrossWeight")
   public ProjectProductionStatisticsProcessDTO setTaskCompanyTotalGrossWeight(final BigDecimal taskCompanyTotalGrossWeight) {
      this.taskCompanyTotalGrossWeight = taskCompanyTotalGrossWeight;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectProductionStatisticsProcessDTO(processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", taskTotalQuantity="
         + this.getTaskTotalQuantity()
         + ", taskTotalNetWeight="
         + this.getTaskTotalNetWeight()
         + ", taskTotalGrossWeight="
         + this.getTaskTotalGrossWeight()
         + ", taskCompanyTotalQuantity="
         + this.getTaskCompanyTotalQuantity()
         + ", taskCompanyTotalNetWeight="
         + this.getTaskCompanyTotalNetWeight()
         + ", taskCompanyTotalGrossWeight="
         + this.getTaskCompanyTotalGrossWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionStatisticsProcessDTO)) {
         return false;
      }

      ProjectProductionStatisticsProcessDTO other = (ProjectProductionStatisticsProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processId = this.getProcessId();
      Object other$processId = other.getProcessId();
      if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
         Object this$taskTotalQuantity = this.getTaskTotalQuantity();
         Object other$taskTotalQuantity = other.getTaskTotalQuantity();
         if (this$taskTotalQuantity == null ? other$taskTotalQuantity == null : this$taskTotalQuantity.equals(other$taskTotalQuantity)) {
            Object this$taskCompanyTotalQuantity = this.getTaskCompanyTotalQuantity();
            Object other$taskCompanyTotalQuantity = other.getTaskCompanyTotalQuantity();
            if (this$taskCompanyTotalQuantity == null
               ? other$taskCompanyTotalQuantity == null
               : this$taskCompanyTotalQuantity.equals(other$taskCompanyTotalQuantity)) {
               Object this$processName = this.getProcessName();
               Object other$processName = other.getProcessName();
               if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                  Object this$taskTotalNetWeight = this.getTaskTotalNetWeight();
                  Object other$taskTotalNetWeight = other.getTaskTotalNetWeight();
                  if (this$taskTotalNetWeight == null ? other$taskTotalNetWeight == null : this$taskTotalNetWeight.equals(other$taskTotalNetWeight)) {
                     Object this$taskTotalGrossWeight = this.getTaskTotalGrossWeight();
                     Object other$taskTotalGrossWeight = other.getTaskTotalGrossWeight();
                     if (this$taskTotalGrossWeight == null ? other$taskTotalGrossWeight == null : this$taskTotalGrossWeight.equals(other$taskTotalGrossWeight)) {
                        Object this$taskCompanyTotalNetWeight = this.getTaskCompanyTotalNetWeight();
                        Object other$taskCompanyTotalNetWeight = other.getTaskCompanyTotalNetWeight();
                        if (this$taskCompanyTotalNetWeight == null
                           ? other$taskCompanyTotalNetWeight == null
                           : this$taskCompanyTotalNetWeight.equals(other$taskCompanyTotalNetWeight)) {
                           Object this$taskCompanyTotalGrossWeight = this.getTaskCompanyTotalGrossWeight();
                           Object other$taskCompanyTotalGrossWeight = other.getTaskCompanyTotalGrossWeight();
                           return this$taskCompanyTotalGrossWeight == null
                              ? other$taskCompanyTotalGrossWeight == null
                              : this$taskCompanyTotalGrossWeight.equals(other$taskCompanyTotalGrossWeight);
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
      return other instanceof ProjectProductionStatisticsProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskTotalQuantity = this.getTaskTotalQuantity();
      result = result * 59 + ($taskTotalQuantity == null ? 43 : $taskTotalQuantity.hashCode());
      Object $taskCompanyTotalQuantity = this.getTaskCompanyTotalQuantity();
      result = result * 59 + ($taskCompanyTotalQuantity == null ? 43 : $taskCompanyTotalQuantity.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $taskTotalNetWeight = this.getTaskTotalNetWeight();
      result = result * 59 + ($taskTotalNetWeight == null ? 43 : $taskTotalNetWeight.hashCode());
      Object $taskTotalGrossWeight = this.getTaskTotalGrossWeight();
      result = result * 59 + ($taskTotalGrossWeight == null ? 43 : $taskTotalGrossWeight.hashCode());
      Object $taskCompanyTotalNetWeight = this.getTaskCompanyTotalNetWeight();
      result = result * 59 + ($taskCompanyTotalNetWeight == null ? 43 : $taskCompanyTotalNetWeight.hashCode());
      Object $taskCompanyTotalGrossWeight = this.getTaskCompanyTotalGrossWeight();
      return result * 59 + ($taskCompanyTotalGrossWeight == null ? 43 : $taskCompanyTotalGrossWeight.hashCode());
   }

   public static class ProjectProductionStatisticsProcessDTOBuilder {
      private Long processId;
      private String processName;
      private Integer taskTotalQuantity;
      private BigDecimal taskTotalNetWeight;
      private BigDecimal taskTotalGrossWeight;
      private Integer taskCompanyTotalQuantity;
      private BigDecimal taskCompanyTotalNetWeight;
      private BigDecimal taskCompanyTotalGrossWeight;

      ProjectProductionStatisticsProcessDTOBuilder() {
      }

      @JsonProperty("processId")
      public ProjectProductionStatisticsProcessDTO.ProjectProductionStatisticsProcessDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public ProjectProductionStatisticsProcessDTO.ProjectProductionStatisticsProcessDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("taskTotalQuantity")
      public ProjectProductionStatisticsProcessDTO.ProjectProductionStatisticsProcessDTOBuilder taskTotalQuantity(final Integer taskTotalQuantity) {
         this.taskTotalQuantity = taskTotalQuantity;
         return this;
      }

      @JsonProperty("taskTotalNetWeight")
      public ProjectProductionStatisticsProcessDTO.ProjectProductionStatisticsProcessDTOBuilder taskTotalNetWeight(final BigDecimal taskTotalNetWeight) {
         this.taskTotalNetWeight = taskTotalNetWeight;
         return this;
      }

      @JsonProperty("taskTotalGrossWeight")
      public ProjectProductionStatisticsProcessDTO.ProjectProductionStatisticsProcessDTOBuilder taskTotalGrossWeight(final BigDecimal taskTotalGrossWeight) {
         this.taskTotalGrossWeight = taskTotalGrossWeight;
         return this;
      }

      @JsonProperty("taskCompanyTotalQuantity")
      public ProjectProductionStatisticsProcessDTO.ProjectProductionStatisticsProcessDTOBuilder taskCompanyTotalQuantity(final Integer taskCompanyTotalQuantity) {
         this.taskCompanyTotalQuantity = taskCompanyTotalQuantity;
         return this;
      }

      @JsonProperty("taskCompanyTotalNetWeight")
      public ProjectProductionStatisticsProcessDTO.ProjectProductionStatisticsProcessDTOBuilder taskCompanyTotalNetWeight(
         final BigDecimal taskCompanyTotalNetWeight
      ) {
         this.taskCompanyTotalNetWeight = taskCompanyTotalNetWeight;
         return this;
      }

      @JsonProperty("taskCompanyTotalGrossWeight")
      public ProjectProductionStatisticsProcessDTO.ProjectProductionStatisticsProcessDTOBuilder taskCompanyTotalGrossWeight(
         final BigDecimal taskCompanyTotalGrossWeight
      ) {
         this.taskCompanyTotalGrossWeight = taskCompanyTotalGrossWeight;
         return this;
      }

      public ProjectProductionStatisticsProcessDTO build() {
         return new ProjectProductionStatisticsProcessDTO(
            this.processId,
            this.processName,
            this.taskTotalQuantity,
            this.taskTotalNetWeight,
            this.taskTotalGrossWeight,
            this.taskCompanyTotalQuantity,
            this.taskCompanyTotalNetWeight,
            this.taskCompanyTotalGrossWeight
         );
      }

      @Override
      public String toString() {
         return "ProjectProductionStatisticsProcessDTO.ProjectProductionStatisticsProcessDTOBuilder(processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", taskTotalQuantity="
            + this.taskTotalQuantity
            + ", taskTotalNetWeight="
            + this.taskTotalNetWeight
            + ", taskTotalGrossWeight="
            + this.taskTotalGrossWeight
            + ", taskCompanyTotalQuantity="
            + this.taskCompanyTotalQuantity
            + ", taskCompanyTotalNetWeight="
            + this.taskCompanyTotalNetWeight
            + ", taskCompanyTotalGrossWeight="
            + this.taskCompanyTotalGrossWeight
            + ")";
      }
   }
}
