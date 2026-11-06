package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import java.math.BigDecimal;

public class StandardDetailDTOParam {
   private Long id;
   private BigDecimal unitNet;

   StandardDetailDTOParam(final Long id, final BigDecimal unitNet) {
      this.id = id;
      this.unitNet = unitNet;
   }

   public static StandardDetailDTOParam.StandardDetailDTOParamBuilder builder() {
      return new StandardDetailDTOParam.StandardDetailDTOParamBuilder();
   }

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
      } else if (!(o instanceof StandardDetailDTOParam)) {
         return false;
      } else {
         StandardDetailDTOParam other = (StandardDetailDTOParam)o;
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
      return other instanceof StandardDetailDTOParam;
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
      return "StandardDetailDTOParam(id=" + this.getId() + ", unitNet=" + this.getUnitNet() + ")";
   }

   public static class StandardDetailDTOParamBuilder {
      private Long id;
      private BigDecimal unitNet;

      StandardDetailDTOParamBuilder() {
      }

      public StandardDetailDTOParam.StandardDetailDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public StandardDetailDTOParam.StandardDetailDTOParamBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public StandardDetailDTOParam build() {
         return new StandardDetailDTOParam(this.id, this.unitNet);
      }

      @Override
      public String toString() {
         return "StandardDetailDTOParam.StandardDetailDTOParamBuilder(id=" + this.id + ", unitNet=" + this.unitNet + ")";
      }
   }
}
