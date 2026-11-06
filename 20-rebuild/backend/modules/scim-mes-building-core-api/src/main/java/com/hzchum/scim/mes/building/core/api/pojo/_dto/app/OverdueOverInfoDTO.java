package com.hzchum.scim.mes.building.core.api.pojo._dto.app;

import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "app工序看板-基础信息类")
public class OverdueOverInfoDTO extends AppTaskOrderSummaryDTO {
   @ApiModelProperty(name = "inCompleteQuantity", value = "未完成", notes = "未完成")
   private Integer inCompleteQuantity;
   @ApiModelProperty(name = "overdueDay", value = "逾期天数", notes = "逾期天数")
   private Integer overdueDay;

   public OverdueOverInfoDTO(final Integer inCompleteQuantity, final Integer overdueDay) {
      this.inCompleteQuantity = inCompleteQuantity;
      this.overdueDay = overdueDay;
   }

   public OverdueOverInfoDTO() {
   }

   public Integer getInCompleteQuantity() {
      return this.inCompleteQuantity;
   }

   public Integer getOverdueDay() {
      return this.overdueDay;
   }

   public OverdueOverInfoDTO setInCompleteQuantity(final Integer inCompleteQuantity) {
      this.inCompleteQuantity = inCompleteQuantity;
      return this;
   }

   public OverdueOverInfoDTO setOverdueDay(final Integer overdueDay) {
      this.overdueDay = overdueDay;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof OverdueOverInfoDTO)) {
         return false;
      } else {
         OverdueOverInfoDTO other = (OverdueOverInfoDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$inCompleteQuantity = this.getInCompleteQuantity();
            Object other$inCompleteQuantity = other.getInCompleteQuantity();
            if (this$inCompleteQuantity == null ? other$inCompleteQuantity == null : this$inCompleteQuantity.equals(other$inCompleteQuantity)) {
               Object this$overdueDay = this.getOverdueDay();
               Object other$overdueDay = other.getOverdueDay();
               return this$overdueDay == null ? other$overdueDay == null : this$overdueDay.equals(other$overdueDay);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof OverdueOverInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inCompleteQuantity = this.getInCompleteQuantity();
      result = result * 59 + ($inCompleteQuantity == null ? 43 : $inCompleteQuantity.hashCode());
      Object $overdueDay = this.getOverdueDay();
      return result * 59 + ($overdueDay == null ? 43 : $overdueDay.hashCode());
   }

   @Override
   public String toString() {
      return "OverdueOverInfoDTO(inCompleteQuantity=" + this.getInCompleteQuantity() + ", overdueDay=" + this.getOverdueDay() + ")";
   }
}
