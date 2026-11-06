package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

public class NotPrintedNumberDTO {
   private Integer totalMaterial = 0;
   private Integer inboundMaterial = 0;
   private Integer outboundMaterial = 0;
   private Integer transferMaterial = 0;
   private Integer returnMaterial = 0;
   private Integer surplusMaterial = 0;

   public static NotPrintedNumberDTO.NotPrintedNumberDTOBuilder builder() {
      return new NotPrintedNumberDTO.NotPrintedNumberDTOBuilder();
   }

   public Integer getTotalMaterial() {
      return this.totalMaterial;
   }

   public Integer getInboundMaterial() {
      return this.inboundMaterial;
   }

   public Integer getOutboundMaterial() {
      return this.outboundMaterial;
   }

   public Integer getTransferMaterial() {
      return this.transferMaterial;
   }

   public Integer getReturnMaterial() {
      return this.returnMaterial;
   }

   public Integer getSurplusMaterial() {
      return this.surplusMaterial;
   }

   public void setTotalMaterial(final Integer totalMaterial) {
      this.totalMaterial = totalMaterial;
   }

   public void setInboundMaterial(final Integer inboundMaterial) {
      this.inboundMaterial = inboundMaterial;
   }

   public void setOutboundMaterial(final Integer outboundMaterial) {
      this.outboundMaterial = outboundMaterial;
   }

   public void setTransferMaterial(final Integer transferMaterial) {
      this.transferMaterial = transferMaterial;
   }

   public void setReturnMaterial(final Integer returnMaterial) {
      this.returnMaterial = returnMaterial;
   }

   public void setSurplusMaterial(final Integer surplusMaterial) {
      this.surplusMaterial = surplusMaterial;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NotPrintedNumberDTO)) {
         return false;
      }

      NotPrintedNumberDTO other = (NotPrintedNumberDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalMaterial = this.getTotalMaterial();
      Object other$totalMaterial = other.getTotalMaterial();
      if (this$totalMaterial == null ? other$totalMaterial == null : this$totalMaterial.equals(other$totalMaterial)) {
         Object this$inboundMaterial = this.getInboundMaterial();
         Object other$inboundMaterial = other.getInboundMaterial();
         if (this$inboundMaterial == null ? other$inboundMaterial == null : this$inboundMaterial.equals(other$inboundMaterial)) {
            Object this$outboundMaterial = this.getOutboundMaterial();
            Object other$outboundMaterial = other.getOutboundMaterial();
            if (this$outboundMaterial == null ? other$outboundMaterial == null : this$outboundMaterial.equals(other$outboundMaterial)) {
               Object this$transferMaterial = this.getTransferMaterial();
               Object other$transferMaterial = other.getTransferMaterial();
               if (this$transferMaterial == null ? other$transferMaterial == null : this$transferMaterial.equals(other$transferMaterial)) {
                  Object this$returnMaterial = this.getReturnMaterial();
                  Object other$returnMaterial = other.getReturnMaterial();
                  if (this$returnMaterial == null ? other$returnMaterial == null : this$returnMaterial.equals(other$returnMaterial)) {
                     Object this$surplusMaterial = this.getSurplusMaterial();
                     Object other$surplusMaterial = other.getSurplusMaterial();
                     return this$surplusMaterial == null ? other$surplusMaterial == null : this$surplusMaterial.equals(other$surplusMaterial);
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
      return other instanceof NotPrintedNumberDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalMaterial = this.getTotalMaterial();
      result = result * 59 + ($totalMaterial == null ? 43 : $totalMaterial.hashCode());
      Object $inboundMaterial = this.getInboundMaterial();
      result = result * 59 + ($inboundMaterial == null ? 43 : $inboundMaterial.hashCode());
      Object $outboundMaterial = this.getOutboundMaterial();
      result = result * 59 + ($outboundMaterial == null ? 43 : $outboundMaterial.hashCode());
      Object $transferMaterial = this.getTransferMaterial();
      result = result * 59 + ($transferMaterial == null ? 43 : $transferMaterial.hashCode());
      Object $returnMaterial = this.getReturnMaterial();
      result = result * 59 + ($returnMaterial == null ? 43 : $returnMaterial.hashCode());
      Object $surplusMaterial = this.getSurplusMaterial();
      return result * 59 + ($surplusMaterial == null ? 43 : $surplusMaterial.hashCode());
   }

   @Override
   public String toString() {
      return "NotPrintedNumberDTO(totalMaterial="
         + this.getTotalMaterial()
         + ", inboundMaterial="
         + this.getInboundMaterial()
         + ", outboundMaterial="
         + this.getOutboundMaterial()
         + ", transferMaterial="
         + this.getTransferMaterial()
         + ", returnMaterial="
         + this.getReturnMaterial()
         + ", surplusMaterial="
         + this.getSurplusMaterial()
         + ")";
   }

   public NotPrintedNumberDTO(
      final Integer totalMaterial,
      final Integer inboundMaterial,
      final Integer outboundMaterial,
      final Integer transferMaterial,
      final Integer returnMaterial,
      final Integer surplusMaterial
   ) {
      this.totalMaterial = totalMaterial;
      this.inboundMaterial = inboundMaterial;
      this.outboundMaterial = outboundMaterial;
      this.transferMaterial = transferMaterial;
      this.returnMaterial = returnMaterial;
      this.surplusMaterial = surplusMaterial;
   }

   public NotPrintedNumberDTO() {
   }

   public static class NotPrintedNumberDTOBuilder {
      private Integer totalMaterial;
      private Integer inboundMaterial;
      private Integer outboundMaterial;
      private Integer transferMaterial;
      private Integer returnMaterial;
      private Integer surplusMaterial;

      NotPrintedNumberDTOBuilder() {
      }

      public NotPrintedNumberDTO.NotPrintedNumberDTOBuilder totalMaterial(final Integer totalMaterial) {
         this.totalMaterial = totalMaterial;
         return this;
      }

      public NotPrintedNumberDTO.NotPrintedNumberDTOBuilder inboundMaterial(final Integer inboundMaterial) {
         this.inboundMaterial = inboundMaterial;
         return this;
      }

      public NotPrintedNumberDTO.NotPrintedNumberDTOBuilder outboundMaterial(final Integer outboundMaterial) {
         this.outboundMaterial = outboundMaterial;
         return this;
      }

      public NotPrintedNumberDTO.NotPrintedNumberDTOBuilder transferMaterial(final Integer transferMaterial) {
         this.transferMaterial = transferMaterial;
         return this;
      }

      public NotPrintedNumberDTO.NotPrintedNumberDTOBuilder returnMaterial(final Integer returnMaterial) {
         this.returnMaterial = returnMaterial;
         return this;
      }

      public NotPrintedNumberDTO.NotPrintedNumberDTOBuilder surplusMaterial(final Integer surplusMaterial) {
         this.surplusMaterial = surplusMaterial;
         return this;
      }

      public NotPrintedNumberDTO build() {
         return new NotPrintedNumberDTO(
            this.totalMaterial, this.inboundMaterial, this.outboundMaterial, this.transferMaterial, this.returnMaterial, this.surplusMaterial
         );
      }

      @Override
      public String toString() {
         return "NotPrintedNumberDTO.NotPrintedNumberDTOBuilder(totalMaterial="
            + this.totalMaterial
            + ", inboundMaterial="
            + this.inboundMaterial
            + ", outboundMaterial="
            + this.outboundMaterial
            + ", transferMaterial="
            + this.transferMaterial
            + ", returnMaterial="
            + this.returnMaterial
            + ", surplusMaterial="
            + this.surplusMaterial
            + ")";
      }
   }
}
