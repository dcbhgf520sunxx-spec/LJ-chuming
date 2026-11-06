package com.hzchum.scim.wms.core.api.pojo.dto.common;

import java.math.BigDecimal;

public class MeteAndQuantity {
   private BigDecimal sendQuantity;
   private BigDecimal sendMete;

   public static MeteAndQuantity.MeteAndQuantityBuilder builder() {
      return new MeteAndQuantity.MeteAndQuantityBuilder();
   }

   public BigDecimal getSendQuantity() {
      return this.sendQuantity;
   }

   public BigDecimal getSendMete() {
      return this.sendMete;
   }

   public void setSendQuantity(final BigDecimal sendQuantity) {
      this.sendQuantity = sendQuantity;
   }

   public void setSendMete(final BigDecimal sendMete) {
      this.sendMete = sendMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MeteAndQuantity)) {
         return false;
      } else {
         MeteAndQuantity other = (MeteAndQuantity)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$sendQuantity = this.getSendQuantity();
            Object other$sendQuantity = other.getSendQuantity();
            if (this$sendQuantity == null ? other$sendQuantity == null : this$sendQuantity.equals(other$sendQuantity)) {
               Object this$sendMete = this.getSendMete();
               Object other$sendMete = other.getSendMete();
               return this$sendMete == null ? other$sendMete == null : this$sendMete.equals(other$sendMete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MeteAndQuantity;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sendQuantity = this.getSendQuantity();
      result = result * 59 + ($sendQuantity == null ? 43 : $sendQuantity.hashCode());
      Object $sendMete = this.getSendMete();
      return result * 59 + ($sendMete == null ? 43 : $sendMete.hashCode());
   }

   @Override
   public String toString() {
      return "MeteAndQuantity(sendQuantity=" + this.getSendQuantity() + ", sendMete=" + this.getSendMete() + ")";
   }

   public MeteAndQuantity(final BigDecimal sendQuantity, final BigDecimal sendMete) {
      this.sendQuantity = sendQuantity;
      this.sendMete = sendMete;
   }

   public MeteAndQuantity() {
   }

   public static class MeteAndQuantityBuilder {
      private BigDecimal sendQuantity;
      private BigDecimal sendMete;

      MeteAndQuantityBuilder() {
      }

      public MeteAndQuantity.MeteAndQuantityBuilder sendQuantity(final BigDecimal sendQuantity) {
         this.sendQuantity = sendQuantity;
         return this;
      }

      public MeteAndQuantity.MeteAndQuantityBuilder sendMete(final BigDecimal sendMete) {
         this.sendMete = sendMete;
         return this;
      }

      public MeteAndQuantity build() {
         return new MeteAndQuantity(this.sendQuantity, this.sendMete);
      }

      @Override
      public String toString() {
         return "MeteAndQuantity.MeteAndQuantityBuilder(sendQuantity=" + this.sendQuantity + ", sendMete=" + this.sendMete + ")";
      }
   }
}
