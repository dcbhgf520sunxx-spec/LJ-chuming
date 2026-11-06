package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RejectDetailDTOParam {
   private Long id;
   private Long inboundMaterialId;
   private BigDecimal Mete;
   private BigDecimal quantity;
   private LocalDateTime realTime;

   public static RejectDetailDTOParam.RejectDetailDTOParamBuilder builder() {
      return new RejectDetailDTOParam.RejectDetailDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getInboundMaterialId() {
      return this.inboundMaterialId;
   }

   public BigDecimal getMete() {
      return this.Mete;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInboundMaterialId(final Long inboundMaterialId) {
      this.inboundMaterialId = inboundMaterialId;
   }

   public void setMete(final BigDecimal Mete) {
      this.Mete = Mete;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RejectDetailDTOParam)) {
         return false;
      }

      RejectDetailDTOParam other = (RejectDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inboundMaterialId = this.getInboundMaterialId();
         Object other$inboundMaterialId = other.getInboundMaterialId();
         if (this$inboundMaterialId == null ? other$inboundMaterialId == null : this$inboundMaterialId.equals(other$inboundMaterialId)) {
            Object this$Mete = this.getMete();
            Object other$Mete = other.getMete();
            if (this$Mete == null ? other$Mete == null : this$Mete.equals(other$Mete)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$realTime = this.getRealTime();
                  Object other$realTime = other.getRealTime();
                  return this$realTime == null ? other$realTime == null : this$realTime.equals(other$realTime);
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
      return other instanceof RejectDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inboundMaterialId = this.getInboundMaterialId();
      result = result * 59 + ($inboundMaterialId == null ? 43 : $inboundMaterialId.hashCode());
      Object $Mete = this.getMete();
      result = result * 59 + ($Mete == null ? 43 : $Mete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $realTime = this.getRealTime();
      return result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
   }

   @Override
   public String toString() {
      return "RejectDetailDTOParam(id="
         + this.getId()
         + ", inboundMaterialId="
         + this.getInboundMaterialId()
         + ", Mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", realTime="
         + this.getRealTime()
         + ")";
   }

   public RejectDetailDTOParam(final Long id, final Long inboundMaterialId, final BigDecimal Mete, final BigDecimal quantity, final LocalDateTime realTime) {
      this.id = id;
      this.inboundMaterialId = inboundMaterialId;
      this.Mete = Mete;
      this.quantity = quantity;
      this.realTime = realTime;
   }

   public RejectDetailDTOParam() {
   }

   public static class RejectDetailDTOParamBuilder {
      private Long id;
      private Long inboundMaterialId;
      private BigDecimal Mete;
      private BigDecimal quantity;
      private LocalDateTime realTime;

      RejectDetailDTOParamBuilder() {
      }

      public RejectDetailDTOParam.RejectDetailDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public RejectDetailDTOParam.RejectDetailDTOParamBuilder inboundMaterialId(final Long inboundMaterialId) {
         this.inboundMaterialId = inboundMaterialId;
         return this;
      }

      public RejectDetailDTOParam.RejectDetailDTOParamBuilder Mete(final BigDecimal Mete) {
         this.Mete = Mete;
         return this;
      }

      public RejectDetailDTOParam.RejectDetailDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public RejectDetailDTOParam.RejectDetailDTOParamBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      public RejectDetailDTOParam build() {
         return new RejectDetailDTOParam(this.id, this.inboundMaterialId, this.Mete, this.quantity, this.realTime);
      }

      @Override
      public String toString() {
         return "RejectDetailDTOParam.RejectDetailDTOParamBuilder(id="
            + this.id
            + ", inboundMaterialId="
            + this.inboundMaterialId
            + ", Mete="
            + this.Mete
            + ", quantity="
            + this.quantity
            + ", realTime="
            + this.realTime
            + ")";
      }
   }
}
