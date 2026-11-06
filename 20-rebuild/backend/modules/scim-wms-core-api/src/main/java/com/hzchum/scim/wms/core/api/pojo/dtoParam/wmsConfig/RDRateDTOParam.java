package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import java.math.BigDecimal;

public class RDRateDTOParam {
   private Long id;
   private BigDecimal rdRate;

   public static RDRateDTOParam.RDRateDTOParamBuilder builder() {
      return new RDRateDTOParam.RDRateDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getRdRate() {
      return this.rdRate;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setRdRate(final BigDecimal rdRate) {
      this.rdRate = rdRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof RDRateDTOParam)) {
         return false;
      } else {
         RDRateDTOParam other = (RDRateDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$rdRate = this.getRdRate();
               Object other$rdRate = other.getRdRate();
               return this$rdRate == null ? other$rdRate == null : this$rdRate.equals(other$rdRate);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RDRateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $rdRate = this.getRdRate();
      return result * 59 + ($rdRate == null ? 43 : $rdRate.hashCode());
   }

   @Override
   public String toString() {
      return "RDRateDTOParam(id=" + this.getId() + ", rdRate=" + this.getRdRate() + ")";
   }

   public RDRateDTOParam(final Long id, final BigDecimal rdRate) {
      this.id = id;
      this.rdRate = rdRate;
   }

   public RDRateDTOParam() {
   }

   public static class RDRateDTOParamBuilder {
      private Long id;
      private BigDecimal rdRate;

      RDRateDTOParamBuilder() {
      }

      public RDRateDTOParam.RDRateDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public RDRateDTOParam.RDRateDTOParamBuilder rdRate(final BigDecimal rdRate) {
         this.rdRate = rdRate;
         return this;
      }

      public RDRateDTOParam build() {
         return new RDRateDTOParam(this.id, this.rdRate);
      }

      @Override
      public String toString() {
         return "RDRateDTOParam.RDRateDTOParamBuilder(id=" + this.id + ", rdRate=" + this.rdRate + ")";
      }
   }
}
