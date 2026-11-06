package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProcessReportSummaryDTO", description = "工序报工汇总DTO")
public class ProcessReportSummaryDTO {
   @ApiModelProperty(name = "projectCount", value = "在手项目数")
   private Integer projectCount;
   @ApiModelProperty(name = "taskCount", value = "实时任务总数")
   private Integer taskCount;
   @ApiModelProperty(name = "completeCount", value = "今日完成数")
   private Integer completeCount;
   @ApiModelProperty(name = "incompleteCount", value = "未完成数")
   private Integer incompleteCount;

   public static ProcessReportSummaryDTO.ProcessReportSummaryDTOBuilder builder() {
      return new ProcessReportSummaryDTO.ProcessReportSummaryDTOBuilder();
   }

   public ProcessReportSummaryDTO() {
   }

   public ProcessReportSummaryDTO(final Integer projectCount, final Integer taskCount, final Integer completeCount, final Integer incompleteCount) {
      this.projectCount = projectCount;
      this.taskCount = taskCount;
      this.completeCount = completeCount;
      this.incompleteCount = incompleteCount;
   }

   public Integer getProjectCount() {
      return this.projectCount;
   }

   public Integer getTaskCount() {
      return this.taskCount;
   }

   public Integer getCompleteCount() {
      return this.completeCount;
   }

   public Integer getIncompleteCount() {
      return this.incompleteCount;
   }

   public ProcessReportSummaryDTO setProjectCount(final Integer projectCount) {
      this.projectCount = projectCount;
      return this;
   }

   public ProcessReportSummaryDTO setTaskCount(final Integer taskCount) {
      this.taskCount = taskCount;
      return this;
   }

   public ProcessReportSummaryDTO setCompleteCount(final Integer completeCount) {
      this.completeCount = completeCount;
      return this;
   }

   public ProcessReportSummaryDTO setIncompleteCount(final Integer incompleteCount) {
      this.incompleteCount = incompleteCount;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessReportSummaryDTO(projectCount="
         + this.getProjectCount()
         + ", taskCount="
         + this.getTaskCount()
         + ", completeCount="
         + this.getCompleteCount()
         + ", incompleteCount="
         + this.getIncompleteCount()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessReportSummaryDTO)) {
         return false;
      }

      ProcessReportSummaryDTO other = (ProcessReportSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectCount = this.getProjectCount();
      Object other$projectCount = other.getProjectCount();
      if (this$projectCount == null ? other$projectCount == null : this$projectCount.equals(other$projectCount)) {
         Object this$taskCount = this.getTaskCount();
         Object other$taskCount = other.getTaskCount();
         if (this$taskCount == null ? other$taskCount == null : this$taskCount.equals(other$taskCount)) {
            Object this$completeCount = this.getCompleteCount();
            Object other$completeCount = other.getCompleteCount();
            if (this$completeCount == null ? other$completeCount == null : this$completeCount.equals(other$completeCount)) {
               Object this$incompleteCount = this.getIncompleteCount();
               Object other$incompleteCount = other.getIncompleteCount();
               return this$incompleteCount == null ? other$incompleteCount == null : this$incompleteCount.equals(other$incompleteCount);
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
      return other instanceof ProcessReportSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectCount = this.getProjectCount();
      result = result * 59 + ($projectCount == null ? 43 : $projectCount.hashCode());
      Object $taskCount = this.getTaskCount();
      result = result * 59 + ($taskCount == null ? 43 : $taskCount.hashCode());
      Object $completeCount = this.getCompleteCount();
      result = result * 59 + ($completeCount == null ? 43 : $completeCount.hashCode());
      Object $incompleteCount = this.getIncompleteCount();
      return result * 59 + ($incompleteCount == null ? 43 : $incompleteCount.hashCode());
   }

   public static class ProcessReportSummaryDTOBuilder {
      private Integer projectCount;
      private Integer taskCount;
      private Integer completeCount;
      private Integer incompleteCount;

      ProcessReportSummaryDTOBuilder() {
      }

      public ProcessReportSummaryDTO.ProcessReportSummaryDTOBuilder projectCount(final Integer projectCount) {
         this.projectCount = projectCount;
         return this;
      }

      public ProcessReportSummaryDTO.ProcessReportSummaryDTOBuilder taskCount(final Integer taskCount) {
         this.taskCount = taskCount;
         return this;
      }

      public ProcessReportSummaryDTO.ProcessReportSummaryDTOBuilder completeCount(final Integer completeCount) {
         this.completeCount = completeCount;
         return this;
      }

      public ProcessReportSummaryDTO.ProcessReportSummaryDTOBuilder incompleteCount(final Integer incompleteCount) {
         this.incompleteCount = incompleteCount;
         return this;
      }

      public ProcessReportSummaryDTO build() {
         return new ProcessReportSummaryDTO(this.projectCount, this.taskCount, this.completeCount, this.incompleteCount);
      }

      @Override
      public String toString() {
         return "ProcessReportSummaryDTO.ProcessReportSummaryDTOBuilder(projectCount="
            + this.projectCount
            + ", taskCount="
            + this.taskCount
            + ", completeCount="
            + this.completeCount
            + ", incompleteCount="
            + this.incompleteCount
            + ")";
      }
   }
}
