package com.hzchum.scim.project.core.api.pojo.dtoParam;

import java.math.BigDecimal;

public class SubBusinessDeleteDTOParam {
   private Long businessId;
   private Integer quantity;
   private BigDecimal totalMete;
   private BigDecimal totalArea;

   SubBusinessDeleteDTOParam(final Long businessId, final Integer quantity, final BigDecimal totalMete, final BigDecimal totalArea) {
      this.businessId = businessId;
      this.quantity = quantity;
      this.totalMete = totalMete;
      this.totalArea = totalArea;
   }

   public static SubBusinessDeleteDTOParam.SubBusinessDeleteDTOParamBuilder builder() {
      return new SubBusinessDeleteDTOParam.SubBusinessDeleteDTOParamBuilder();
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalMete() {
      return this.totalMete;
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

   public void setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubBusinessDeleteDTOParam)) {
         return false;
      }

      SubBusinessDeleteDTOParam other = (SubBusinessDeleteDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$businessId = this.getBusinessId();
      Object other$businessId = other.getBusinessId();
      if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$totalMete = this.getTotalMete();
            Object other$totalMete = other.getTotalMete();
            if (this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete)) {
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
      return other instanceof SubBusinessDeleteDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   @Override
   public String toString() {
      return "SubBusinessDeleteDTOParam(businessId="
         + this.getBusinessId()
         + ", quantity="
         + this.getQuantity()
         + ", totalMete="
         + this.getTotalMete()
         + ", totalArea="
         + this.getTotalArea()
         + ")";
   }

   public static class SubBusinessDeleteDTOParamBuilder {
      private Long businessId;
      private Integer quantity;
      private BigDecimal totalMete;
      private BigDecimal totalArea;

      SubBusinessDeleteDTOParamBuilder() {
      }

      public SubBusinessDeleteDTOParam.SubBusinessDeleteDTOParamBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public SubBusinessDeleteDTOParam.SubBusinessDeleteDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public SubBusinessDeleteDTOParam.SubBusinessDeleteDTOParamBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      public SubBusinessDeleteDTOParam.SubBusinessDeleteDTOParamBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public SubBusinessDeleteDTOParam build() {
         return new SubBusinessDeleteDTOParam(this.businessId, this.quantity, this.totalMete, this.totalArea);
      }

      @Override
      public String toString() {
         return "SubBusinessDeleteDTOParam.SubBusinessDeleteDTOParamBuilder(businessId="
            + this.businessId
            + ", quantity="
            + this.quantity
            + ", totalMete="
            + this.totalMete
            + ", totalArea="
            + this.totalArea
            + ")";
      }
   }
}
