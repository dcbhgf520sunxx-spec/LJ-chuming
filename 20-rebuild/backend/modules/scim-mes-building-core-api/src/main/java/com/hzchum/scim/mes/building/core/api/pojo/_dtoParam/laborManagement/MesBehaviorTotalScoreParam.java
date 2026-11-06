package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("行为总分新增修改Param类")
public class MesBehaviorTotalScoreParam {
   @ApiModelProperty("总分")
   @NotNull(message = "总分不能为空")
   @Min(value = 0L, message = "总分不能小于0")
   private Integer totalScore;
   @ApiModelProperty("是否扣减总分")
   @NotNull(message = "是否扣减不能为空")
   private Boolean boolDeduction;

   public Integer getTotalScore() {
      return this.totalScore;
   }

   public Boolean getBoolDeduction() {
      return this.boolDeduction;
   }

   public void setTotalScore(final Integer totalScore) {
      this.totalScore = totalScore;
   }

   public void setBoolDeduction(final Boolean boolDeduction) {
      this.boolDeduction = boolDeduction;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBehaviorTotalScoreParam)) {
         return false;
      } else {
         MesBehaviorTotalScoreParam other = (MesBehaviorTotalScoreParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$totalScore = this.getTotalScore();
            Object other$totalScore = other.getTotalScore();
            if (this$totalScore == null ? other$totalScore == null : this$totalScore.equals(other$totalScore)) {
               Object this$boolDeduction = this.getBoolDeduction();
               Object other$boolDeduction = other.getBoolDeduction();
               return this$boolDeduction == null ? other$boolDeduction == null : this$boolDeduction.equals(other$boolDeduction);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBehaviorTotalScoreParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalScore = this.getTotalScore();
      result = result * 59 + ($totalScore == null ? 43 : $totalScore.hashCode());
      Object $boolDeduction = this.getBoolDeduction();
      return result * 59 + ($boolDeduction == null ? 43 : $boolDeduction.hashCode());
   }

   @Override
   public String toString() {
      return "MesBehaviorTotalScoreParam(totalScore=" + this.getTotalScore() + ", boolDeduction=" + this.getBoolDeduction() + ")";
   }
}
