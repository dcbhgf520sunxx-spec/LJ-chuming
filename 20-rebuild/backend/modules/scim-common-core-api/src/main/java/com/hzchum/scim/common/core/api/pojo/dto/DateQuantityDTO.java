package com.hzchum.scim.common.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "DateQuantityDTO", description = "日期数量")
public class DateQuantityDTO {
   private String date;
   private Long workShopId;
   private String workShopName;
   private BigDecimal oneQuantity;
   private BigDecimal twoQuantity;

   public String getDate() {
      return this.date;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public BigDecimal getOneQuantity() {
      return this.oneQuantity;
   }

   public BigDecimal getTwoQuantity() {
      return this.twoQuantity;
   }

   public void setDate(final String date) {
      this.date = date;
   }

   public void setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
   }

   public void setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
   }

   public void setOneQuantity(final BigDecimal oneQuantity) {
      this.oneQuantity = oneQuantity;
   }

   public void setTwoQuantity(final BigDecimal twoQuantity) {
      this.twoQuantity = twoQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DateQuantityDTO)) {
         return false;
      }

      DateQuantityDTO other = (DateQuantityDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workShopId = this.getWorkShopId();
      Object other$workShopId = other.getWorkShopId();
      if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
         Object this$date = this.getDate();
         Object other$date = other.getDate();
         if (this$date == null ? other$date == null : this$date.equals(other$date)) {
            Object this$workShopName = this.getWorkShopName();
            Object other$workShopName = other.getWorkShopName();
            if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
               Object this$oneQuantity = this.getOneQuantity();
               Object other$oneQuantity = other.getOneQuantity();
               if (this$oneQuantity == null ? other$oneQuantity == null : this$oneQuantity.equals(other$oneQuantity)) {
                  Object this$twoQuantity = this.getTwoQuantity();
                  Object other$twoQuantity = other.getTwoQuantity();
                  return this$twoQuantity == null ? other$twoQuantity == null : this$twoQuantity.equals(other$twoQuantity);
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
      return other instanceof DateQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $oneQuantity = this.getOneQuantity();
      result = result * 59 + ($oneQuantity == null ? 43 : $oneQuantity.hashCode());
      Object $twoQuantity = this.getTwoQuantity();
      return result * 59 + ($twoQuantity == null ? 43 : $twoQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "DateQuantityDTO(date="
         + this.getDate()
         + ", workShopId="
         + this.getWorkShopId()
         + ", workShopName="
         + this.getWorkShopName()
         + ", oneQuantity="
         + this.getOneQuantity()
         + ", twoQuantity="
         + this.getTwoQuantity()
         + ")";
   }
}
