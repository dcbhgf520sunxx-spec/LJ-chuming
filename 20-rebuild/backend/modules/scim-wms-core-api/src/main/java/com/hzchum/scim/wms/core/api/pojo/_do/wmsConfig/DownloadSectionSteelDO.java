package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import java.math.BigDecimal;

public class DownloadSectionSteelDO {
   private String specification;
   private BigDecimal unitNet;

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof DownloadSectionSteelDO)) {
         return false;
      } else {
         DownloadSectionSteelDO other = (DownloadSectionSteelDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$specification = this.getSpecification();
            Object other$specification = other.getSpecification();
            if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
               Object this$unitNet = this.getUnitNet();
               Object other$unitNet = other.getUnitNet();
               return this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DownloadSectionSteelDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $unitNet = this.getUnitNet();
      return result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
   }

   @Override
   public String toString() {
      return "DownloadSectionSteelDO(specification=" + this.getSpecification() + ", unitNet=" + this.getUnitNet() + ")";
   }

   public DownloadSectionSteelDO(final String specification, final BigDecimal unitNet) {
      this.specification = specification;
      this.unitNet = unitNet;
   }

   public DownloadSectionSteelDO() {
   }
}
