package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

public class AppOutboundDTO {
   private Integer outboundAudit;
   private Integer stockWarning;
   private Integer storageInspection;
   private Integer allocationInspection;

   public static AppOutboundDTO.AppOutboundDTOBuilder builder() {
      return new AppOutboundDTO.AppOutboundDTOBuilder();
   }

   public Integer getOutboundAudit() {
      return this.outboundAudit;
   }

   public Integer getStockWarning() {
      return this.stockWarning;
   }

   public Integer getStorageInspection() {
      return this.storageInspection;
   }

   public Integer getAllocationInspection() {
      return this.allocationInspection;
   }

   public void setOutboundAudit(final Integer outboundAudit) {
      this.outboundAudit = outboundAudit;
   }

   public void setStockWarning(final Integer stockWarning) {
      this.stockWarning = stockWarning;
   }

   public void setStorageInspection(final Integer storageInspection) {
      this.storageInspection = storageInspection;
   }

   public void setAllocationInspection(final Integer allocationInspection) {
      this.allocationInspection = allocationInspection;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppOutboundDTO)) {
         return false;
      }

      AppOutboundDTO other = (AppOutboundDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$outboundAudit = this.getOutboundAudit();
      Object other$outboundAudit = other.getOutboundAudit();
      if (this$outboundAudit == null ? other$outboundAudit == null : this$outboundAudit.equals(other$outboundAudit)) {
         Object this$stockWarning = this.getStockWarning();
         Object other$stockWarning = other.getStockWarning();
         if (this$stockWarning == null ? other$stockWarning == null : this$stockWarning.equals(other$stockWarning)) {
            Object this$storageInspection = this.getStorageInspection();
            Object other$storageInspection = other.getStorageInspection();
            if (this$storageInspection == null ? other$storageInspection == null : this$storageInspection.equals(other$storageInspection)) {
               Object this$allocationInspection = this.getAllocationInspection();
               Object other$allocationInspection = other.getAllocationInspection();
               return this$allocationInspection == null ? other$allocationInspection == null : this$allocationInspection.equals(other$allocationInspection);
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
      return other instanceof AppOutboundDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $outboundAudit = this.getOutboundAudit();
      result = result * 59 + ($outboundAudit == null ? 43 : $outboundAudit.hashCode());
      Object $stockWarning = this.getStockWarning();
      result = result * 59 + ($stockWarning == null ? 43 : $stockWarning.hashCode());
      Object $storageInspection = this.getStorageInspection();
      result = result * 59 + ($storageInspection == null ? 43 : $storageInspection.hashCode());
      Object $allocationInspection = this.getAllocationInspection();
      return result * 59 + ($allocationInspection == null ? 43 : $allocationInspection.hashCode());
   }

   @Override
   public String toString() {
      return "AppOutboundDTO(outboundAudit="
         + this.getOutboundAudit()
         + ", stockWarning="
         + this.getStockWarning()
         + ", storageInspection="
         + this.getStorageInspection()
         + ", allocationInspection="
         + this.getAllocationInspection()
         + ")";
   }

   public AppOutboundDTO(final Integer outboundAudit, final Integer stockWarning, final Integer storageInspection, final Integer allocationInspection) {
      this.outboundAudit = outboundAudit;
      this.stockWarning = stockWarning;
      this.storageInspection = storageInspection;
      this.allocationInspection = allocationInspection;
   }

   public AppOutboundDTO() {
   }

   public static class AppOutboundDTOBuilder {
      private Integer outboundAudit;
      private Integer stockWarning;
      private Integer storageInspection;
      private Integer allocationInspection;

      AppOutboundDTOBuilder() {
      }

      public AppOutboundDTO.AppOutboundDTOBuilder outboundAudit(final Integer outboundAudit) {
         this.outboundAudit = outboundAudit;
         return this;
      }

      public AppOutboundDTO.AppOutboundDTOBuilder stockWarning(final Integer stockWarning) {
         this.stockWarning = stockWarning;
         return this;
      }

      public AppOutboundDTO.AppOutboundDTOBuilder storageInspection(final Integer storageInspection) {
         this.storageInspection = storageInspection;
         return this;
      }

      public AppOutboundDTO.AppOutboundDTOBuilder allocationInspection(final Integer allocationInspection) {
         this.allocationInspection = allocationInspection;
         return this;
      }

      public AppOutboundDTO build() {
         return new AppOutboundDTO(this.outboundAudit, this.stockWarning, this.storageInspection, this.allocationInspection);
      }

      @Override
      public String toString() {
         return "AppOutboundDTO.AppOutboundDTOBuilder(outboundAudit="
            + this.outboundAudit
            + ", stockWarning="
            + this.stockWarning
            + ", storageInspection="
            + this.storageInspection
            + ", allocationInspection="
            + this.allocationInspection
            + ")";
      }
   }
}
