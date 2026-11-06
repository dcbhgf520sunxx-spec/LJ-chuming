package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.artifactWarehouse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class TonVO {
   @ApiModelProperty(name = "date", value = "日期")
   private String dateValue;
   @ApiModelProperty(name = "ton", value = "吨数")
   private BigDecimal ton;
   @ApiModelProperty(name = "key", value = "key名称")
   private String key;

   public String getDateValue() {
      return this.dateValue;
   }

   public BigDecimal getTon() {
      return this.ton;
   }

   public String getKey() {
      return this.key;
   }

   public void setDateValue(final String dateValue) {
      this.dateValue = dateValue;
   }

   public void setTon(final BigDecimal ton) {
      this.ton = ton;
   }

   public void setKey(final String key) {
      this.key = key;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TonVO)) {
         return false;
      }

      TonVO other = (TonVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$dateValue = this.getDateValue();
      Object other$dateValue = other.getDateValue();
      if (this$dateValue == null ? other$dateValue == null : this$dateValue.equals(other$dateValue)) {
         Object this$ton = this.getTon();
         Object other$ton = other.getTon();
         if (this$ton == null ? other$ton == null : this$ton.equals(other$ton)) {
            Object this$key = this.getKey();
            Object other$key = other.getKey();
            return this$key == null ? other$key == null : this$key.equals(other$key);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TonVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dateValue = this.getDateValue();
      result = result * 59 + ($dateValue == null ? 43 : $dateValue.hashCode());
      Object $ton = this.getTon();
      result = result * 59 + ($ton == null ? 43 : $ton.hashCode());
      Object $key = this.getKey();
      return result * 59 + ($key == null ? 43 : $key.hashCode());
   }

   @Override
   public String toString() {
      return "TonVO(dateValue=" + this.getDateValue() + ", ton=" + this.getTon() + ", key=" + this.getKey() + ")";
   }
}
