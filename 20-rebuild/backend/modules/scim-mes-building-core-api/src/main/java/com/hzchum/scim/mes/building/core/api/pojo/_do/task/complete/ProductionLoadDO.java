package com.hzchum.scim.mes.building.core.api.pojo._do.task.complete;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("每月完成量")
public class ProductionLoadDO {
   @ApiModelProperty("日期")
   private Integer month;
   @ApiModelProperty("完成量")
   private BigDecimal complete;

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getComplete() {
      return this.complete;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setComplete(final BigDecimal complete) {
      this.complete = complete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductionLoadDO)) {
         return false;
      } else {
         ProductionLoadDO other = (ProductionLoadDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$complete = this.getComplete();
               Object other$complete = other.getComplete();
               return this$complete == null ? other$complete == null : this$complete.equals(other$complete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductionLoadDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $complete = this.getComplete();
      return result * 59 + ($complete == null ? 43 : $complete.hashCode());
   }

   @Override
   public String toString() {
      return "ProductionLoadDO(month=" + this.getMonth() + ", complete=" + this.getComplete() + ")";
   }
}
