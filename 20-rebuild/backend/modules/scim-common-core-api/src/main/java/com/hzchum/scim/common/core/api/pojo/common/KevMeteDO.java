package com.hzchum.scim.common.core.api.pojo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("键-量")
public class KevMeteDO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("键")
   private String groupKey;
   @ApiModelProperty("量")
   private BigDecimal mete;

   KevMeteDO(final String groupKey, final BigDecimal mete) {
      this.groupKey = groupKey;
      this.mete = mete;
   }

   public static KevMeteDO.KevMeteDOBuilder builder() {
      return new KevMeteDO.KevMeteDOBuilder();
   }

   public String getGroupKey() {
      return this.groupKey;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setGroupKey(final String groupKey) {
      this.groupKey = groupKey;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof KevMeteDO)) {
         return false;
      } else {
         KevMeteDO other = (KevMeteDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$groupKey = this.getGroupKey();
            Object other$groupKey = other.getGroupKey();
            if (this$groupKey == null ? other$groupKey == null : this$groupKey.equals(other$groupKey)) {
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
      return other instanceof KevMeteDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $groupKey = this.getGroupKey();
      result = result * 59 + ($groupKey == null ? 43 : $groupKey.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "KevMeteDO(groupKey=" + this.getGroupKey() + ", mete=" + this.getMete() + ")";
   }

   public static class KevMeteDOBuilder {
      private String groupKey;
      private BigDecimal mete;

      KevMeteDOBuilder() {
      }

      public KevMeteDO.KevMeteDOBuilder groupKey(final String groupKey) {
         this.groupKey = groupKey;
         return this;
      }

      public KevMeteDO.KevMeteDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public KevMeteDO build() {
         return new KevMeteDO(this.groupKey, this.mete);
      }

      @Override
      public String toString() {
         return "KevMeteDO.KevMeteDOBuilder(groupKey=" + this.groupKey + ", mete=" + this.mete + ")";
      }
   }
}
