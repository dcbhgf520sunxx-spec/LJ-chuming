package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("OaSupplierPaymentDTO")
public class OaSupplierPaymentDTO {
   @ApiModelProperty(name = "htbh", value = "合同编号")
   private String htbh;
   @ApiModelProperty(name = "hkje", value = "汇款金额")
   private double hkje;

   public static OaSupplierPaymentDTO.OaSupplierPaymentDTOBuilder builder() {
      return new OaSupplierPaymentDTO.OaSupplierPaymentDTOBuilder();
   }

   public OaSupplierPaymentDTO(final String htbh, final double hkje) {
      this.htbh = htbh;
      this.hkje = hkje;
   }

   public OaSupplierPaymentDTO() {
   }

   public String getHtbh() {
      return this.htbh;
   }

   public double getHkje() {
      return this.hkje;
   }

   public OaSupplierPaymentDTO setHtbh(final String htbh) {
      this.htbh = htbh;
      return this;
   }

   public OaSupplierPaymentDTO setHkje(final double hkje) {
      this.hkje = hkje;
      return this;
   }

   @Override
   public String toString() {
      return "OaSupplierPaymentDTO(htbh=" + this.getHtbh() + ", hkje=" + this.getHkje() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaSupplierPaymentDTO)) {
         return false;
      }

      OaSupplierPaymentDTO other = (OaSupplierPaymentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (Double.compare(this.getHkje(), other.getHkje()) != 0) {
         return false;
      }

      Object this$htbh = this.getHtbh();
      Object other$htbh = other.getHtbh();
      return this$htbh == null ? other$htbh == null : this$htbh.equals(other$htbh);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OaSupplierPaymentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $hkje = Double.doubleToLongBits(this.getHkje());
      result = result * 59 + (int)($hkje >>> 32 ^ $hkje);
      Object $htbh = this.getHtbh();
      return result * 59 + ($htbh == null ? 43 : $htbh.hashCode());
   }

   public static class OaSupplierPaymentDTOBuilder {
      private String htbh;
      private double hkje;

      OaSupplierPaymentDTOBuilder() {
      }

      public OaSupplierPaymentDTO.OaSupplierPaymentDTOBuilder htbh(final String htbh) {
         this.htbh = htbh;
         return this;
      }

      public OaSupplierPaymentDTO.OaSupplierPaymentDTOBuilder hkje(final double hkje) {
         this.hkje = hkje;
         return this;
      }

      public OaSupplierPaymentDTO build() {
         return new OaSupplierPaymentDTO(this.htbh, this.hkje);
      }

      @Override
      public String toString() {
         return "OaSupplierPaymentDTO.OaSupplierPaymentDTOBuilder(htbh=" + this.htbh + ", hkje=" + this.hkje + ")";
      }
   }
}
