package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PartyAReturnDetailDTOParam {
   private Long id;
   private String outboundUnit;
   private Integer outboundUnitType;
   private BigDecimal quantity;
   private LocalDateTime realTime;

   public static PartyAReturnDetailDTOParam.PartyAReturnDetailDTOParamBuilder builder() {
      return new PartyAReturnDetailDTOParam.PartyAReturnDetailDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getOutboundUnit() {
      return this.outboundUnit;
   }

   public Integer getOutboundUnitType() {
      return this.outboundUnitType;
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

   public void setOutboundUnit(final String outboundUnit) {
      this.outboundUnit = outboundUnit;
   }

   public void setOutboundUnitType(final Integer outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
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

      if (!(o instanceof PartyAReturnDetailDTOParam)) {
         return false;
      }

      PartyAReturnDetailDTOParam other = (PartyAReturnDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$outboundUnitType = this.getOutboundUnitType();
         Object other$outboundUnitType = other.getOutboundUnitType();
         if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
            Object this$outboundUnit = this.getOutboundUnit();
            Object other$outboundUnit = other.getOutboundUnit();
            if (this$outboundUnit == null ? other$outboundUnit == null : this$outboundUnit.equals(other$outboundUnit)) {
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
      return other instanceof PartyAReturnDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $outboundUnit = this.getOutboundUnit();
      result = result * 59 + ($outboundUnit == null ? 43 : $outboundUnit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $realTime = this.getRealTime();
      return result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
   }

   @Override
   public String toString() {
      return "PartyAReturnDetailDTOParam(id="
         + this.getId()
         + ", outboundUnit="
         + this.getOutboundUnit()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
         + ", quantity="
         + this.getQuantity()
         + ", realTime="
         + this.getRealTime()
         + ")";
   }

   public PartyAReturnDetailDTOParam(
      final Long id, final String outboundUnit, final Integer outboundUnitType, final BigDecimal quantity, final LocalDateTime realTime
   ) {
      this.id = id;
      this.outboundUnit = outboundUnit;
      this.outboundUnitType = outboundUnitType;
      this.quantity = quantity;
      this.realTime = realTime;
   }

   public PartyAReturnDetailDTOParam() {
   }

   public static class PartyAReturnDetailDTOParamBuilder {
      private Long id;
      private String outboundUnit;
      private Integer outboundUnitType;
      private BigDecimal quantity;
      private LocalDateTime realTime;

      PartyAReturnDetailDTOParamBuilder() {
      }

      public PartyAReturnDetailDTOParam.PartyAReturnDetailDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PartyAReturnDetailDTOParam.PartyAReturnDetailDTOParamBuilder outboundUnit(final String outboundUnit) {
         this.outboundUnit = outboundUnit;
         return this;
      }

      public PartyAReturnDetailDTOParam.PartyAReturnDetailDTOParamBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      public PartyAReturnDetailDTOParam.PartyAReturnDetailDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public PartyAReturnDetailDTOParam.PartyAReturnDetailDTOParamBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      public PartyAReturnDetailDTOParam build() {
         return new PartyAReturnDetailDTOParam(this.id, this.outboundUnit, this.outboundUnitType, this.quantity, this.realTime);
      }

      @Override
      public String toString() {
         return "PartyAReturnDetailDTOParam.PartyAReturnDetailDTOParamBuilder(id="
            + this.id
            + ", outboundUnit="
            + this.outboundUnit
            + ", outboundUnitType="
            + this.outboundUnitType
            + ", quantity="
            + this.quantity
            + ", realTime="
            + this.realTime
            + ")";
      }
   }
}
