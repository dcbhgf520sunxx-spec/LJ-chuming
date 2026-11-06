package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.math.BigDecimal;

public class PickingOutMsg {
   private String pickingId;
   private BigDecimal pickingOutSumQuantity;
   private BigDecimal pickingOutSumMete;
   private BigDecimal pickingOutSumArea;
   private BigDecimal pickingOutSumLength;

   public static PickingOutMsg.PickingOutMsgBuilder builder() {
      return new PickingOutMsg.PickingOutMsgBuilder();
   }

   public String getPickingId() {
      return this.pickingId;
   }

   public BigDecimal getPickingOutSumQuantity() {
      return this.pickingOutSumQuantity;
   }

   public BigDecimal getPickingOutSumMete() {
      return this.pickingOutSumMete;
   }

   public BigDecimal getPickingOutSumArea() {
      return this.pickingOutSumArea;
   }

   public BigDecimal getPickingOutSumLength() {
      return this.pickingOutSumLength;
   }

   public void setPickingId(final String pickingId) {
      this.pickingId = pickingId;
   }

   public void setPickingOutSumQuantity(final BigDecimal pickingOutSumQuantity) {
      this.pickingOutSumQuantity = pickingOutSumQuantity;
   }

   public void setPickingOutSumMete(final BigDecimal pickingOutSumMete) {
      this.pickingOutSumMete = pickingOutSumMete;
   }

   public void setPickingOutSumArea(final BigDecimal pickingOutSumArea) {
      this.pickingOutSumArea = pickingOutSumArea;
   }

   public void setPickingOutSumLength(final BigDecimal pickingOutSumLength) {
      this.pickingOutSumLength = pickingOutSumLength;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PickingOutMsg)) {
         return false;
      }

      PickingOutMsg other = (PickingOutMsg)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pickingId = this.getPickingId();
      Object other$pickingId = other.getPickingId();
      if (this$pickingId == null ? other$pickingId == null : this$pickingId.equals(other$pickingId)) {
         Object this$pickingOutSumQuantity = this.getPickingOutSumQuantity();
         Object other$pickingOutSumQuantity = other.getPickingOutSumQuantity();
         if (this$pickingOutSumQuantity == null ? other$pickingOutSumQuantity == null : this$pickingOutSumQuantity.equals(other$pickingOutSumQuantity)) {
            Object this$pickingOutSumMete = this.getPickingOutSumMete();
            Object other$pickingOutSumMete = other.getPickingOutSumMete();
            if (this$pickingOutSumMete == null ? other$pickingOutSumMete == null : this$pickingOutSumMete.equals(other$pickingOutSumMete)) {
               Object this$pickingOutSumArea = this.getPickingOutSumArea();
               Object other$pickingOutSumArea = other.getPickingOutSumArea();
               if (this$pickingOutSumArea == null ? other$pickingOutSumArea == null : this$pickingOutSumArea.equals(other$pickingOutSumArea)) {
                  Object this$pickingOutSumLength = this.getPickingOutSumLength();
                  Object other$pickingOutSumLength = other.getPickingOutSumLength();
                  return this$pickingOutSumLength == null ? other$pickingOutSumLength == null : this$pickingOutSumLength.equals(other$pickingOutSumLength);
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
      return other instanceof PickingOutMsg;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pickingId = this.getPickingId();
      result = result * 59 + ($pickingId == null ? 43 : $pickingId.hashCode());
      Object $pickingOutSumQuantity = this.getPickingOutSumQuantity();
      result = result * 59 + ($pickingOutSumQuantity == null ? 43 : $pickingOutSumQuantity.hashCode());
      Object $pickingOutSumMete = this.getPickingOutSumMete();
      result = result * 59 + ($pickingOutSumMete == null ? 43 : $pickingOutSumMete.hashCode());
      Object $pickingOutSumArea = this.getPickingOutSumArea();
      result = result * 59 + ($pickingOutSumArea == null ? 43 : $pickingOutSumArea.hashCode());
      Object $pickingOutSumLength = this.getPickingOutSumLength();
      return result * 59 + ($pickingOutSumLength == null ? 43 : $pickingOutSumLength.hashCode());
   }

   @Override
   public String toString() {
      return "PickingOutMsg(pickingId="
         + this.getPickingId()
         + ", pickingOutSumQuantity="
         + this.getPickingOutSumQuantity()
         + ", pickingOutSumMete="
         + this.getPickingOutSumMete()
         + ", pickingOutSumArea="
         + this.getPickingOutSumArea()
         + ", pickingOutSumLength="
         + this.getPickingOutSumLength()
         + ")";
   }

   public PickingOutMsg(
      final String pickingId,
      final BigDecimal pickingOutSumQuantity,
      final BigDecimal pickingOutSumMete,
      final BigDecimal pickingOutSumArea,
      final BigDecimal pickingOutSumLength
   ) {
      this.pickingId = pickingId;
      this.pickingOutSumQuantity = pickingOutSumQuantity;
      this.pickingOutSumMete = pickingOutSumMete;
      this.pickingOutSumArea = pickingOutSumArea;
      this.pickingOutSumLength = pickingOutSumLength;
   }

   public PickingOutMsg() {
   }

   public static class PickingOutMsgBuilder {
      private String pickingId;
      private BigDecimal pickingOutSumQuantity;
      private BigDecimal pickingOutSumMete;
      private BigDecimal pickingOutSumArea;
      private BigDecimal pickingOutSumLength;

      PickingOutMsgBuilder() {
      }

      public PickingOutMsg.PickingOutMsgBuilder pickingId(final String pickingId) {
         this.pickingId = pickingId;
         return this;
      }

      public PickingOutMsg.PickingOutMsgBuilder pickingOutSumQuantity(final BigDecimal pickingOutSumQuantity) {
         this.pickingOutSumQuantity = pickingOutSumQuantity;
         return this;
      }

      public PickingOutMsg.PickingOutMsgBuilder pickingOutSumMete(final BigDecimal pickingOutSumMete) {
         this.pickingOutSumMete = pickingOutSumMete;
         return this;
      }

      public PickingOutMsg.PickingOutMsgBuilder pickingOutSumArea(final BigDecimal pickingOutSumArea) {
         this.pickingOutSumArea = pickingOutSumArea;
         return this;
      }

      public PickingOutMsg.PickingOutMsgBuilder pickingOutSumLength(final BigDecimal pickingOutSumLength) {
         this.pickingOutSumLength = pickingOutSumLength;
         return this;
      }

      public PickingOutMsg build() {
         return new PickingOutMsg(this.pickingId, this.pickingOutSumQuantity, this.pickingOutSumMete, this.pickingOutSumArea, this.pickingOutSumLength);
      }

      @Override
      public String toString() {
         return "PickingOutMsg.PickingOutMsgBuilder(pickingId="
            + this.pickingId
            + ", pickingOutSumQuantity="
            + this.pickingOutSumQuantity
            + ", pickingOutSumMete="
            + this.pickingOutSumMete
            + ", pickingOutSumArea="
            + this.pickingOutSumArea
            + ", pickingOutSumLength="
            + this.pickingOutSumLength
            + ")";
      }
   }
}
