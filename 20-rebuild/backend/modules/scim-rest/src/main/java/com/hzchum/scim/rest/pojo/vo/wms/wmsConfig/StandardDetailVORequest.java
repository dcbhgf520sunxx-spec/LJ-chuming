package com.hzchum.scim.rest.pojo.vo.wms.wmsConfig;

import java.math.BigDecimal;

public class StandardDetailVORequest {
   private Long id;
   private BigDecimal unitNet;

   public Long getId() {
      return this.id;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof StandardDetailVORequest)) {
         return false;
      } else {
         StandardDetailVORequest other = (StandardDetailVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
      return other instanceof StandardDetailVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $unitNet = this.getUnitNet();
      return result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
   }

   @Override
   public String toString() {
      return "StandardDetailVORequest(id=" + this.getId() + ", unitNet=" + this.getUnitNet() + ")";
   }
}
