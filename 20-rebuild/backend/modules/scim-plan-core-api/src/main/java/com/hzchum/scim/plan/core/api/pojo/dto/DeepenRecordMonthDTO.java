package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("月度深化量")
public class DeepenRecordMonthDTO {
   @ApiModelProperty("月份")
   private Integer month;
   @ApiModelProperty("总量")
   private BigDecimal mete;

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof DeepenRecordMonthDTO)) {
         return false;
      } else {
         DeepenRecordMonthDTO other = (DeepenRecordMonthDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DeepenRecordMonthDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "DeepenRecordMonthDTO(month=" + this.getMonth() + ", mete=" + this.getMete() + ")";
   }

   public DeepenRecordMonthDTO() {
   }

   public DeepenRecordMonthDTO(final Integer month, final BigDecimal mete) {
      this.month = month;
      this.mete = mete;
   }
}
