package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectProductTaskSummaryDTO", description = "零构部件任务汇总")
public class ProjectProductTaskSummaryDTO {
   @ApiModelProperty(name = "partTaskCount", notes = "零件总任务数", value = "进行中项目数")
   @JsonProperty("partTaskCount")
   @JSONField(name = "partTaskCount")
   private Integer partTaskCount;
   @ApiModelProperty(name = "partCompletedCount", notes = "零件任务完成数", value = "进行中项目数")
   @JsonProperty("partCompletedCount")
   @JSONField(name = "partCompletedCount")
   private Integer partCompletedCount;
   @ApiModelProperty(name = "artifactTaskCount", notes = "构件总任务数", value = "进行中项目数")
   @JsonProperty("artifactTaskCount")
   @JSONField(name = "artifactTaskCount")
   private Integer artifactTaskCount;
   @ApiModelProperty(name = "artifactCompletedCount", notes = "构件任务完成数", value = "进行中项目数")
   @JsonProperty("artifactCompletedCount")
   @JSONField(name = "artifactCompletedCount")
   private Integer artifactCompletedCount;
   @ApiModelProperty(name = "assembleTaskCount", notes = "部件总任务数", value = "部件总任务数")
   @JsonProperty("assembleTaskCount")
   @JSONField(name = "assembleTaskCount")
   private Integer assembleTaskCount;
   @ApiModelProperty(name = "assembleCompletedCount", notes = "部件任务完成数", value = "部件任务完成数")
   @JsonProperty("assembleCompletedCount")
   @JSONField(name = "assembleCompletedCount")
   private Integer assembleCompletedCount;

   public Integer getPartTaskCount() {
      return this.partTaskCount;
   }

   public Integer getPartCompletedCount() {
      return this.partCompletedCount;
   }

   public Integer getArtifactTaskCount() {
      return this.artifactTaskCount;
   }

   public Integer getArtifactCompletedCount() {
      return this.artifactCompletedCount;
   }

   public Integer getAssembleTaskCount() {
      return this.assembleTaskCount;
   }

   public Integer getAssembleCompletedCount() {
      return this.assembleCompletedCount;
   }

   @JsonProperty("partTaskCount")
   public void setPartTaskCount(final Integer partTaskCount) {
      this.partTaskCount = partTaskCount;
   }

   @JsonProperty("partCompletedCount")
   public void setPartCompletedCount(final Integer partCompletedCount) {
      this.partCompletedCount = partCompletedCount;
   }

   @JsonProperty("artifactTaskCount")
   public void setArtifactTaskCount(final Integer artifactTaskCount) {
      this.artifactTaskCount = artifactTaskCount;
   }

   @JsonProperty("artifactCompletedCount")
   public void setArtifactCompletedCount(final Integer artifactCompletedCount) {
      this.artifactCompletedCount = artifactCompletedCount;
   }

   @JsonProperty("assembleTaskCount")
   public void setAssembleTaskCount(final Integer assembleTaskCount) {
      this.assembleTaskCount = assembleTaskCount;
   }

   @JsonProperty("assembleCompletedCount")
   public void setAssembleCompletedCount(final Integer assembleCompletedCount) {
      this.assembleCompletedCount = assembleCompletedCount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductTaskSummaryDTO)) {
         return false;
      }

      ProjectProductTaskSummaryDTO other = (ProjectProductTaskSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$partTaskCount = this.getPartTaskCount();
      Object other$partTaskCount = other.getPartTaskCount();
      if (this$partTaskCount == null ? other$partTaskCount == null : this$partTaskCount.equals(other$partTaskCount)) {
         Object this$partCompletedCount = this.getPartCompletedCount();
         Object other$partCompletedCount = other.getPartCompletedCount();
         if (this$partCompletedCount == null ? other$partCompletedCount == null : this$partCompletedCount.equals(other$partCompletedCount)) {
            Object this$artifactTaskCount = this.getArtifactTaskCount();
            Object other$artifactTaskCount = other.getArtifactTaskCount();
            if (this$artifactTaskCount == null ? other$artifactTaskCount == null : this$artifactTaskCount.equals(other$artifactTaskCount)) {
               Object this$artifactCompletedCount = this.getArtifactCompletedCount();
               Object other$artifactCompletedCount = other.getArtifactCompletedCount();
               if (this$artifactCompletedCount == null
                  ? other$artifactCompletedCount == null
                  : this$artifactCompletedCount.equals(other$artifactCompletedCount)) {
                  Object this$assembleTaskCount = this.getAssembleTaskCount();
                  Object other$assembleTaskCount = other.getAssembleTaskCount();
                  if (this$assembleTaskCount == null ? other$assembleTaskCount == null : this$assembleTaskCount.equals(other$assembleTaskCount)) {
                     Object this$assembleCompletedCount = this.getAssembleCompletedCount();
                     Object other$assembleCompletedCount = other.getAssembleCompletedCount();
                     return this$assembleCompletedCount == null
                        ? other$assembleCompletedCount == null
                        : this$assembleCompletedCount.equals(other$assembleCompletedCount);
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
      return other instanceof ProjectProductTaskSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $partTaskCount = this.getPartTaskCount();
      result = result * 59 + ($partTaskCount == null ? 43 : $partTaskCount.hashCode());
      Object $partCompletedCount = this.getPartCompletedCount();
      result = result * 59 + ($partCompletedCount == null ? 43 : $partCompletedCount.hashCode());
      Object $artifactTaskCount = this.getArtifactTaskCount();
      result = result * 59 + ($artifactTaskCount == null ? 43 : $artifactTaskCount.hashCode());
      Object $artifactCompletedCount = this.getArtifactCompletedCount();
      result = result * 59 + ($artifactCompletedCount == null ? 43 : $artifactCompletedCount.hashCode());
      Object $assembleTaskCount = this.getAssembleTaskCount();
      result = result * 59 + ($assembleTaskCount == null ? 43 : $assembleTaskCount.hashCode());
      Object $assembleCompletedCount = this.getAssembleCompletedCount();
      return result * 59 + ($assembleCompletedCount == null ? 43 : $assembleCompletedCount.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductTaskSummaryDTO(partTaskCount="
         + this.getPartTaskCount()
         + ", partCompletedCount="
         + this.getPartCompletedCount()
         + ", artifactTaskCount="
         + this.getArtifactTaskCount()
         + ", artifactCompletedCount="
         + this.getArtifactCompletedCount()
         + ", assembleTaskCount="
         + this.getAssembleTaskCount()
         + ", assembleCompletedCount="
         + this.getAssembleCompletedCount()
         + ")";
   }
}
