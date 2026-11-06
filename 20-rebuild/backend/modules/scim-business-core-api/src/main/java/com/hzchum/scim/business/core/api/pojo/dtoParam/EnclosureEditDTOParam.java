package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class EnclosureEditDTOParam {
   @ApiModelProperty(name = "businessId", value = "商务id")
   private Long businessId;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "totalLength", value = "总长度(m)")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "总面积(m²)")
   private BigDecimal totalArea;

   EnclosureEditDTOParam(final Long businessId, final Integer quantity, final BigDecimal totalLength, final BigDecimal totalArea) {
      this.businessId = businessId;
      this.quantity = quantity;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
   }

   public static EnclosureEditDTOParam.EnclosureEditDTOParamBuilder builder() {
      return new EnclosureEditDTOParam.EnclosureEditDTOParamBuilder();
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public void setBusinessId(final Long businessId) {
      this.businessId = businessId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureEditDTOParam)) {
         return false;
      }

      EnclosureEditDTOParam other = (EnclosureEditDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$businessId = this.getBusinessId();
      Object other$businessId = other.getBusinessId();
      if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$totalLength = this.getTotalLength();
            Object other$totalLength = other.getTotalLength();
            if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
               Object this$totalArea = this.getTotalArea();
               Object other$totalArea = other.getTotalArea();
               return this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea);
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
      return other instanceof EnclosureEditDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureEditDTOParam(businessId="
         + this.getBusinessId()
         + ", quantity="
         + this.getQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ")";
   }

   public static class EnclosureEditDTOParamBuilder {
      private Long businessId;
      private Integer quantity;
      private BigDecimal totalLength;
      private BigDecimal totalArea;

      EnclosureEditDTOParamBuilder() {
      }

      public EnclosureEditDTOParam.EnclosureEditDTOParamBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public EnclosureEditDTOParam.EnclosureEditDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public EnclosureEditDTOParam.EnclosureEditDTOParamBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public EnclosureEditDTOParam.EnclosureEditDTOParamBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public EnclosureEditDTOParam build() {
         return new EnclosureEditDTOParam(this.businessId, this.quantity, this.totalLength, this.totalArea);
      }

      @Override
      public String toString() {
         return "EnclosureEditDTOParam.EnclosureEditDTOParamBuilder(businessId="
            + this.businessId
            + ", quantity="
            + this.quantity
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ")";
      }
   }
}
