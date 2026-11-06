package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("行为总分新增修改Param类")
public class ProjectManageBehaviorTotalScoreParam {
   @ApiModelProperty("总分")
   @NotNull(message = "总分不能为空")
   @Min(value = 0L, message = "总分不能小于0")
   private Integer totalScore;
   @ApiModelProperty("是否扣减总分")
   @NotNull(message = "是否扣减不能为空")
   private Boolean boolDeduction;
   @ApiModelProperty("项目id不能为空")
   @NotNull(message = "项目id不能为空")
   private Long projectId;

   public Integer getTotalScore() {
      return this.totalScore;
   }

   public Boolean getBoolDeduction() {
      return this.boolDeduction;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public void setTotalScore(final Integer totalScore) {
      this.totalScore = totalScore;
   }

   public void setBoolDeduction(final Boolean boolDeduction) {
      this.boolDeduction = boolDeduction;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageBehaviorTotalScoreParam)) {
         return false;
      }

      ProjectManageBehaviorTotalScoreParam other = (ProjectManageBehaviorTotalScoreParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalScore = this.getTotalScore();
      Object other$totalScore = other.getTotalScore();
      if (this$totalScore == null ? other$totalScore == null : this$totalScore.equals(other$totalScore)) {
         Object this$boolDeduction = this.getBoolDeduction();
         Object other$boolDeduction = other.getBoolDeduction();
         if (this$boolDeduction == null ? other$boolDeduction == null : this$boolDeduction.equals(other$boolDeduction)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            return this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectManageBehaviorTotalScoreParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalScore = this.getTotalScore();
      result = result * 59 + ($totalScore == null ? 43 : $totalScore.hashCode());
      Object $boolDeduction = this.getBoolDeduction();
      result = result * 59 + ($boolDeduction == null ? 43 : $boolDeduction.hashCode());
      Object $projectId = this.getProjectId();
      return result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectManageBehaviorTotalScoreParam(totalScore="
         + this.getTotalScore()
         + ", boolDeduction="
         + this.getBoolDeduction()
         + ", projectId="
         + this.getProjectId()
         + ")";
   }
}
