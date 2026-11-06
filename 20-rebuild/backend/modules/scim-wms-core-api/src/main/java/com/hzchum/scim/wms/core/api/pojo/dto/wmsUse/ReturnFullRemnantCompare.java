package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.math.BigDecimal;

public class ReturnFullRemnantCompare {
   private Long returnDetailWholeId;
   private Integer basicClass;
   private BigDecimal remnantMete;
   private Long materialReturnableId;

   public static ReturnFullRemnantCompare.ReturnFullRemnantCompareBuilder builder() {
      return new ReturnFullRemnantCompare.ReturnFullRemnantCompareBuilder();
   }

   public Long getReturnDetailWholeId() {
      return this.returnDetailWholeId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getRemnantMete() {
      return this.remnantMete;
   }

   public Long getMaterialReturnableId() {
      return this.materialReturnableId;
   }

   public void setReturnDetailWholeId(final Long returnDetailWholeId) {
      this.returnDetailWholeId = returnDetailWholeId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setRemnantMete(final BigDecimal remnantMete) {
      this.remnantMete = remnantMete;
   }

   public void setMaterialReturnableId(final Long materialReturnableId) {
      this.materialReturnableId = materialReturnableId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReturnFullRemnantCompare)) {
         return false;
      }

      ReturnFullRemnantCompare other = (ReturnFullRemnantCompare)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$returnDetailWholeId = this.getReturnDetailWholeId();
      Object other$returnDetailWholeId = other.getReturnDetailWholeId();
      if (this$returnDetailWholeId == null ? other$returnDetailWholeId == null : this$returnDetailWholeId.equals(other$returnDetailWholeId)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$materialReturnableId = this.getMaterialReturnableId();
            Object other$materialReturnableId = other.getMaterialReturnableId();
            if (this$materialReturnableId == null ? other$materialReturnableId == null : this$materialReturnableId.equals(other$materialReturnableId)) {
               Object this$remnantMete = this.getRemnantMete();
               Object other$remnantMete = other.getRemnantMete();
               return this$remnantMete == null ? other$remnantMete == null : this$remnantMete.equals(other$remnantMete);
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
      return other instanceof ReturnFullRemnantCompare;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $returnDetailWholeId = this.getReturnDetailWholeId();
      result = result * 59 + ($returnDetailWholeId == null ? 43 : $returnDetailWholeId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $materialReturnableId = this.getMaterialReturnableId();
      result = result * 59 + ($materialReturnableId == null ? 43 : $materialReturnableId.hashCode());
      Object $remnantMete = this.getRemnantMete();
      return result * 59 + ($remnantMete == null ? 43 : $remnantMete.hashCode());
   }

   @Override
   public String toString() {
      return "ReturnFullRemnantCompare(returnDetailWholeId="
         + this.getReturnDetailWholeId()
         + ", basicClass="
         + this.getBasicClass()
         + ", remnantMete="
         + this.getRemnantMete()
         + ", materialReturnableId="
         + this.getMaterialReturnableId()
         + ")";
   }

   public ReturnFullRemnantCompare(final Long returnDetailWholeId, final Integer basicClass, final BigDecimal remnantMete, final Long materialReturnableId) {
      this.returnDetailWholeId = returnDetailWholeId;
      this.basicClass = basicClass;
      this.remnantMete = remnantMete;
      this.materialReturnableId = materialReturnableId;
   }

   public ReturnFullRemnantCompare() {
   }

   public static class ReturnFullRemnantCompareBuilder {
      private Long returnDetailWholeId;
      private Integer basicClass;
      private BigDecimal remnantMete;
      private Long materialReturnableId;

      ReturnFullRemnantCompareBuilder() {
      }

      public ReturnFullRemnantCompare.ReturnFullRemnantCompareBuilder returnDetailWholeId(final Long returnDetailWholeId) {
         this.returnDetailWholeId = returnDetailWholeId;
         return this;
      }

      public ReturnFullRemnantCompare.ReturnFullRemnantCompareBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ReturnFullRemnantCompare.ReturnFullRemnantCompareBuilder remnantMete(final BigDecimal remnantMete) {
         this.remnantMete = remnantMete;
         return this;
      }

      public ReturnFullRemnantCompare.ReturnFullRemnantCompareBuilder materialReturnableId(final Long materialReturnableId) {
         this.materialReturnableId = materialReturnableId;
         return this;
      }

      public ReturnFullRemnantCompare build() {
         return new ReturnFullRemnantCompare(this.returnDetailWholeId, this.basicClass, this.remnantMete, this.materialReturnableId);
      }

      @Override
      public String toString() {
         return "ReturnFullRemnantCompare.ReturnFullRemnantCompareBuilder(returnDetailWholeId="
            + this.returnDetailWholeId
            + ", basicClass="
            + this.basicClass
            + ", remnantMete="
            + this.remnantMete
            + ", materialReturnableId="
            + this.materialReturnableId
            + ")";
      }
   }
}
