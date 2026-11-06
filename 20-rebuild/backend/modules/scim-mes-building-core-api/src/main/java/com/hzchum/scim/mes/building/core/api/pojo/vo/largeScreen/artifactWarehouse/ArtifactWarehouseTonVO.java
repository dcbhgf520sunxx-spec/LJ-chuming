package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.artifactWarehouse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ArtifactWarehouseTonVO {
   @ApiModelProperty(name = "key", value = "key名称")
   private String key;
   @ApiModelProperty(name = "ton", value = "吨数")
   private BigDecimal ton;

   public String getKey() {
      return this.key;
   }

   public BigDecimal getTon() {
      return this.ton;
   }

   public void setKey(final String key) {
      this.key = key;
   }

   public void setTon(final BigDecimal ton) {
      this.ton = ton;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ArtifactWarehouseTonVO)) {
         return false;
      } else {
         ArtifactWarehouseTonVO other = (ArtifactWarehouseTonVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$key = this.getKey();
            Object other$key = other.getKey();
            if (this$key == null ? other$key == null : this$key.equals(other$key)) {
               Object this$ton = this.getTon();
               Object other$ton = other.getTon();
               return this$ton == null ? other$ton == null : this$ton.equals(other$ton);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactWarehouseTonVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $key = this.getKey();
      result = result * 59 + ($key == null ? 43 : $key.hashCode());
      Object $ton = this.getTon();
      return result * 59 + ($ton == null ? 43 : $ton.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactWarehouseTonVO(key=" + this.getKey() + ", ton=" + this.getTon() + ")";
   }
}
