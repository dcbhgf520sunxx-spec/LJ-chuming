package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;

public class WmsPickingDetailDTOParam {
   private Long pickingId;
   private String pickingType;
   private String specification;
   private String material;
   private BigDecimal thick;
   private String unit;
   private BigDecimal quantity;
   private BigDecimal pickingAmount;
   private BigDecimal volume;
   private BigDecimal pickingArea;
   private BigDecimal handlingArea;
   private BigDecimal pickingLength;
   private BigDecimal handlingLength;
   private Long taskOrderId;

   public static WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder builder() {
      return new WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder();
   }

   public Long getPickingId() {
      return this.pickingId;
   }

   public String getPickingType() {
      return this.pickingType;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getThick() {
      return this.thick;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getPickingAmount() {
      return this.pickingAmount;
   }

   public BigDecimal getVolume() {
      return this.volume;
   }

   public BigDecimal getPickingArea() {
      return this.pickingArea;
   }

   public BigDecimal getHandlingArea() {
      return this.handlingArea;
   }

   public BigDecimal getPickingLength() {
      return this.pickingLength;
   }

   public BigDecimal getHandlingLength() {
      return this.handlingLength;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public void setPickingId(final Long pickingId) {
      this.pickingId = pickingId;
   }

   public void setPickingType(final String pickingType) {
      this.pickingType = pickingType;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setThick(final BigDecimal thick) {
      this.thick = thick;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setPickingAmount(final BigDecimal pickingAmount) {
      this.pickingAmount = pickingAmount;
   }

   public void setVolume(final BigDecimal volume) {
      this.volume = volume;
   }

   public void setPickingArea(final BigDecimal pickingArea) {
      this.pickingArea = pickingArea;
   }

   public void setHandlingArea(final BigDecimal handlingArea) {
      this.handlingArea = handlingArea;
   }

   public void setPickingLength(final BigDecimal pickingLength) {
      this.pickingLength = pickingLength;
   }

   public void setHandlingLength(final BigDecimal handlingLength) {
      this.handlingLength = handlingLength;
   }

   public void setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsPickingDetailDTOParam)) {
         return false;
      }

      WmsPickingDetailDTOParam other = (WmsPickingDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pickingId = this.getPickingId();
      Object other$pickingId = other.getPickingId();
      if (this$pickingId == null ? other$pickingId == null : this$pickingId.equals(other$pickingId)) {
         Object this$taskOrderId = this.getTaskOrderId();
         Object other$taskOrderId = other.getTaskOrderId();
         if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
            Object this$pickingType = this.getPickingType();
            Object other$pickingType = other.getPickingType();
            if (this$pickingType == null ? other$pickingType == null : this$pickingType.equals(other$pickingType)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$material = this.getMaterial();
                  Object other$material = other.getMaterial();
                  if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                     Object this$thick = this.getThick();
                     Object other$thick = other.getThick();
                     if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                        Object this$unit = this.getUnit();
                        Object other$unit = other.getUnit();
                        if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$pickingAmount = this.getPickingAmount();
                              Object other$pickingAmount = other.getPickingAmount();
                              if (this$pickingAmount == null ? other$pickingAmount == null : this$pickingAmount.equals(other$pickingAmount)) {
                                 Object this$volume = this.getVolume();
                                 Object other$volume = other.getVolume();
                                 if (this$volume == null ? other$volume == null : this$volume.equals(other$volume)) {
                                    Object this$pickingArea = this.getPickingArea();
                                    Object other$pickingArea = other.getPickingArea();
                                    if (this$pickingArea == null ? other$pickingArea == null : this$pickingArea.equals(other$pickingArea)) {
                                       Object this$handlingArea = this.getHandlingArea();
                                       Object other$handlingArea = other.getHandlingArea();
                                       if (this$handlingArea == null ? other$handlingArea == null : this$handlingArea.equals(other$handlingArea)) {
                                          Object this$pickingLength = this.getPickingLength();
                                          Object other$pickingLength = other.getPickingLength();
                                          if (this$pickingLength == null ? other$pickingLength == null : this$pickingLength.equals(other$pickingLength)) {
                                             Object this$handlingLength = this.getHandlingLength();
                                             Object other$handlingLength = other.getHandlingLength();
                                             return this$handlingLength == null
                                                ? other$handlingLength == null
                                                : this$handlingLength.equals(other$handlingLength);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WmsPickingDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pickingId = this.getPickingId();
      result = result * 59 + ($pickingId == null ? 43 : $pickingId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $pickingType = this.getPickingType();
      result = result * 59 + ($pickingType == null ? 43 : $pickingType.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $pickingAmount = this.getPickingAmount();
      result = result * 59 + ($pickingAmount == null ? 43 : $pickingAmount.hashCode());
      Object $volume = this.getVolume();
      result = result * 59 + ($volume == null ? 43 : $volume.hashCode());
      Object $pickingArea = this.getPickingArea();
      result = result * 59 + ($pickingArea == null ? 43 : $pickingArea.hashCode());
      Object $handlingArea = this.getHandlingArea();
      result = result * 59 + ($handlingArea == null ? 43 : $handlingArea.hashCode());
      Object $pickingLength = this.getPickingLength();
      result = result * 59 + ($pickingLength == null ? 43 : $pickingLength.hashCode());
      Object $handlingLength = this.getHandlingLength();
      return result * 59 + ($handlingLength == null ? 43 : $handlingLength.hashCode());
   }

   @Override
   public String toString() {
      return "WmsPickingDetailDTOParam(pickingId="
         + this.getPickingId()
         + ", pickingType="
         + this.getPickingType()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", thick="
         + this.getThick()
         + ", unit="
         + this.getUnit()
         + ", quantity="
         + this.getQuantity()
         + ", pickingAmount="
         + this.getPickingAmount()
         + ", volume="
         + this.getVolume()
         + ", pickingArea="
         + this.getPickingArea()
         + ", handlingArea="
         + this.getHandlingArea()
         + ", pickingLength="
         + this.getPickingLength()
         + ", handlingLength="
         + this.getHandlingLength()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ")";
   }

   public WmsPickingDetailDTOParam(
      final Long pickingId,
      final String pickingType,
      final String specification,
      final String material,
      final BigDecimal thick,
      final String unit,
      final BigDecimal quantity,
      final BigDecimal pickingAmount,
      final BigDecimal volume,
      final BigDecimal pickingArea,
      final BigDecimal handlingArea,
      final BigDecimal pickingLength,
      final BigDecimal handlingLength,
      final Long taskOrderId
   ) {
      this.pickingId = pickingId;
      this.pickingType = pickingType;
      this.specification = specification;
      this.material = material;
      this.thick = thick;
      this.unit = unit;
      this.quantity = quantity;
      this.pickingAmount = pickingAmount;
      this.volume = volume;
      this.pickingArea = pickingArea;
      this.handlingArea = handlingArea;
      this.pickingLength = pickingLength;
      this.handlingLength = handlingLength;
      this.taskOrderId = taskOrderId;
   }

   public WmsPickingDetailDTOParam() {
   }

   public static class WmsPickingDetailDTOParamBuilder {
      private Long pickingId;
      private String pickingType;
      private String specification;
      private String material;
      private BigDecimal thick;
      private String unit;
      private BigDecimal quantity;
      private BigDecimal pickingAmount;
      private BigDecimal volume;
      private BigDecimal pickingArea;
      private BigDecimal handlingArea;
      private BigDecimal pickingLength;
      private BigDecimal handlingLength;
      private Long taskOrderId;

      WmsPickingDetailDTOParamBuilder() {
      }

      public WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder pickingId(final Long pickingId) {
         this.pickingId = pickingId;
         return this;
      }

      public WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder pickingType(final String pickingType) {
         this.pickingType = pickingType;
         return this;
      }

      public WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder thick(final BigDecimal thick) {
         this.thick = thick;
         return this;
      }

      public WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder pickingAmount(final BigDecimal pickingAmount) {
         this.pickingAmount = pickingAmount;
         return this;
      }

      public WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder volume(final BigDecimal volume) {
         this.volume = volume;
         return this;
      }

      public WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder pickingArea(final BigDecimal pickingArea) {
         this.pickingArea = pickingArea;
         return this;
      }

      public WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder handlingArea(final BigDecimal handlingArea) {
         this.handlingArea = handlingArea;
         return this;
      }

      public WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder pickingLength(final BigDecimal pickingLength) {
         this.pickingLength = pickingLength;
         return this;
      }

      public WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder handlingLength(final BigDecimal handlingLength) {
         this.handlingLength = handlingLength;
         return this;
      }

      public WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public WmsPickingDetailDTOParam build() {
         return new WmsPickingDetailDTOParam(
            this.pickingId,
            this.pickingType,
            this.specification,
            this.material,
            this.thick,
            this.unit,
            this.quantity,
            this.pickingAmount,
            this.volume,
            this.pickingArea,
            this.handlingArea,
            this.pickingLength,
            this.handlingLength,
            this.taskOrderId
         );
      }

      @Override
      public String toString() {
         return "WmsPickingDetailDTOParam.WmsPickingDetailDTOParamBuilder(pickingId="
            + this.pickingId
            + ", pickingType="
            + this.pickingType
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", thick="
            + this.thick
            + ", unit="
            + this.unit
            + ", quantity="
            + this.quantity
            + ", pickingAmount="
            + this.pickingAmount
            + ", volume="
            + this.volume
            + ", pickingArea="
            + this.pickingArea
            + ", handlingArea="
            + this.handlingArea
            + ", pickingLength="
            + this.pickingLength
            + ", handlingLength="
            + this.handlingLength
            + ", taskOrderId="
            + this.taskOrderId
            + ")";
      }
   }
}
