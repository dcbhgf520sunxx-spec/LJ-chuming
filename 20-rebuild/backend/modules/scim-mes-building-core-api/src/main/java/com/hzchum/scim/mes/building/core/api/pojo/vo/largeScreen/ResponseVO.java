package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ResponseVO {
   @ApiModelProperty(name = "key", value = "key名称")
   private String key;
   @ApiModelProperty(name = "key2", value = "key2名称")
   private String key2;
   @ApiModelProperty(name = "val", value = "val值")
   private BigDecimal val;
   @ApiModelProperty(name = "val2", value = "val2值")
   private BigDecimal val2;

   public String getKey() {
      return this.key;
   }

   public String getKey2() {
      return this.key2;
   }

   public BigDecimal getVal() {
      return this.val;
   }

   public BigDecimal getVal2() {
      return this.val2;
   }

   public void setKey(final String key) {
      this.key = key;
   }

   public void setKey2(final String key2) {
      this.key2 = key2;
   }

   public void setVal(final BigDecimal val) {
      this.val = val;
   }

   public void setVal2(final BigDecimal val2) {
      this.val2 = val2;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ResponseVO)) {
         return false;
      }

      ResponseVO other = (ResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$key = this.getKey();
      Object other$key = other.getKey();
      if (this$key == null ? other$key == null : this$key.equals(other$key)) {
         Object this$key2 = this.getKey2();
         Object other$key2 = other.getKey2();
         if (this$key2 == null ? other$key2 == null : this$key2.equals(other$key2)) {
            Object this$val = this.getVal();
            Object other$val = other.getVal();
            if (this$val == null ? other$val == null : this$val.equals(other$val)) {
               Object this$val2 = this.getVal2();
               Object other$val2 = other.getVal2();
               return this$val2 == null ? other$val2 == null : this$val2.equals(other$val2);
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
      return other instanceof ResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $key = this.getKey();
      result = result * 59 + ($key == null ? 43 : $key.hashCode());
      Object $key2 = this.getKey2();
      result = result * 59 + ($key2 == null ? 43 : $key2.hashCode());
      Object $val = this.getVal();
      result = result * 59 + ($val == null ? 43 : $val.hashCode());
      Object $val2 = this.getVal2();
      return result * 59 + ($val2 == null ? 43 : $val2.hashCode());
   }

   @Override
   public String toString() {
      return "ResponseVO(key=" + this.getKey() + ", key2=" + this.getKey2() + ", val=" + this.getVal() + ", val2=" + this.getVal2() + ")";
   }
}
