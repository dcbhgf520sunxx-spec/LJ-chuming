package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@ApiModel("MES工价配置DTO")
public class MesWageConfigDTO {
   @NotNull(message = "工价统计截止日不能为空")
   @Min(1L)
   @Max(31L)
   @ApiModelProperty("工价统计截止日")
   private Integer wageStatisticsDeadline;
   @NotNull(message = "工价显示精度不能为空")
   @PositiveOrZero(message = "工价显示精度不能小于0")
   @ApiModelProperty("工价显示精度")
   private Integer wageDisplayPrecision;

   public Integer getWageStatisticsDeadline() {
      return this.wageStatisticsDeadline;
   }

   public Integer getWageDisplayPrecision() {
      return this.wageDisplayPrecision;
   }

   public void setWageStatisticsDeadline(final Integer wageStatisticsDeadline) {
      this.wageStatisticsDeadline = wageStatisticsDeadline;
   }

   public void setWageDisplayPrecision(final Integer wageDisplayPrecision) {
      this.wageDisplayPrecision = wageDisplayPrecision;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesWageConfigDTO)) {
         return false;
      } else {
         MesWageConfigDTO other = (MesWageConfigDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$wageStatisticsDeadline = this.getWageStatisticsDeadline();
            Object other$wageStatisticsDeadline = other.getWageStatisticsDeadline();
            if (this$wageStatisticsDeadline == null ? other$wageStatisticsDeadline == null : this$wageStatisticsDeadline.equals(other$wageStatisticsDeadline)) {
               Object this$wageDisplayPrecision = this.getWageDisplayPrecision();
               Object other$wageDisplayPrecision = other.getWageDisplayPrecision();
               return this$wageDisplayPrecision == null ? other$wageDisplayPrecision == null : this$wageDisplayPrecision.equals(other$wageDisplayPrecision);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesWageConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $wageStatisticsDeadline = this.getWageStatisticsDeadline();
      result = result * 59 + ($wageStatisticsDeadline == null ? 43 : $wageStatisticsDeadline.hashCode());
      Object $wageDisplayPrecision = this.getWageDisplayPrecision();
      return result * 59 + ($wageDisplayPrecision == null ? 43 : $wageDisplayPrecision.hashCode());
   }

   @Override
   public String toString() {
      return "MesWageConfigDTO(wageStatisticsDeadline=" + this.getWageStatisticsDeadline() + ", wageDisplayPrecision=" + this.getWageDisplayPrecision() + ")";
   }
}
