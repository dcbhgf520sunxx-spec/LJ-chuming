package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectStatusSummaryDTO", description = "项目进度状态汇总")
public class ProjectStatusSummaryDTO {
   @ApiModelProperty(name = "projectCount", notes = "全部项目数", value = "全部项目数")
   @JsonProperty("projectCount")
   @JSONField(name = "projectCount")
   private Integer projectCount;
   @ApiModelProperty(name = "processingCount", notes = "进行中项目数", value = "进行中项目数")
   @JsonProperty("processingCount")
   @JSONField(name = "processingCount")
   private Integer processingCount;
   @ApiModelProperty(name = "completedCount", notes = "已完工项目数", value = "已完工项目数")
   @JsonProperty("completedCount")
   @JSONField(name = "completedCount")
   private Integer completedCount;

   public Integer getProjectCount() {
      return this.projectCount;
   }

   public Integer getProcessingCount() {
      return this.processingCount;
   }

   public Integer getCompletedCount() {
      return this.completedCount;
   }

   @JsonProperty("projectCount")
   public void setProjectCount(final Integer projectCount) {
      this.projectCount = projectCount;
   }

   @JsonProperty("processingCount")
   public void setProcessingCount(final Integer processingCount) {
      this.processingCount = processingCount;
   }

   @JsonProperty("completedCount")
   public void setCompletedCount(final Integer completedCount) {
      this.completedCount = completedCount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectStatusSummaryDTO)) {
         return false;
      }

      ProjectStatusSummaryDTO other = (ProjectStatusSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectCount = this.getProjectCount();
      Object other$projectCount = other.getProjectCount();
      if (this$projectCount == null ? other$projectCount == null : this$projectCount.equals(other$projectCount)) {
         Object this$processingCount = this.getProcessingCount();
         Object other$processingCount = other.getProcessingCount();
         if (this$processingCount == null ? other$processingCount == null : this$processingCount.equals(other$processingCount)) {
            Object this$completedCount = this.getCompletedCount();
            Object other$completedCount = other.getCompletedCount();
            return this$completedCount == null ? other$completedCount == null : this$completedCount.equals(other$completedCount);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectStatusSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectCount = this.getProjectCount();
      result = result * 59 + ($projectCount == null ? 43 : $projectCount.hashCode());
      Object $processingCount = this.getProcessingCount();
      result = result * 59 + ($processingCount == null ? 43 : $processingCount.hashCode());
      Object $completedCount = this.getCompletedCount();
      return result * 59 + ($completedCount == null ? 43 : $completedCount.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectStatusSummaryDTO(projectCount="
         + this.getProjectCount()
         + ", processingCount="
         + this.getProcessingCount()
         + ", completedCount="
         + this.getCompletedCount()
         + ")";
   }
}
