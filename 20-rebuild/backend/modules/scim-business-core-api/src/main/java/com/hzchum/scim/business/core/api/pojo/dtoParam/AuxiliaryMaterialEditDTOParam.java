package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class AuxiliaryMaterialEditDTOParam {
   @ApiModelProperty(name = "businessId", value = "商务id")
   private Long businessId;
   @ApiModelProperty(name = "quantity", value = "量")
   private BigDecimal mete;

   AuxiliaryMaterialEditDTOParam(final Long businessId, final BigDecimal mete) {
      this.businessId = businessId;
      this.mete = mete;
   }

   public static AuxiliaryMaterialEditDTOParam.AuxiliaryMaterialEditDTOParamBuilder builder() {
      return new AuxiliaryMaterialEditDTOParam.AuxiliaryMaterialEditDTOParamBuilder();
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setBusinessId(final Long businessId) {
      this.businessId = businessId;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AuxiliaryMaterialEditDTOParam)) {
         return false;
      } else {
         AuxiliaryMaterialEditDTOParam other = (AuxiliaryMaterialEditDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$businessId = this.getBusinessId();
            Object other$businessId = other.getBusinessId();
            if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
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
      return other instanceof AuxiliaryMaterialEditDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "AuxiliaryMaterialEditDTOParam(businessId=" + this.getBusinessId() + ", mete=" + this.getMete() + ")";
   }

   public static class AuxiliaryMaterialEditDTOParamBuilder {
      private Long businessId;
      private BigDecimal mete;

      AuxiliaryMaterialEditDTOParamBuilder() {
      }

      public AuxiliaryMaterialEditDTOParam.AuxiliaryMaterialEditDTOParamBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public AuxiliaryMaterialEditDTOParam.AuxiliaryMaterialEditDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public AuxiliaryMaterialEditDTOParam build() {
         return new AuxiliaryMaterialEditDTOParam(this.businessId, this.mete);
      }

      @Override
      public String toString() {
         return "AuxiliaryMaterialEditDTOParam.AuxiliaryMaterialEditDTOParamBuilder(businessId=" + this.businessId + ", mete=" + this.mete + ")";
      }
   }
}
