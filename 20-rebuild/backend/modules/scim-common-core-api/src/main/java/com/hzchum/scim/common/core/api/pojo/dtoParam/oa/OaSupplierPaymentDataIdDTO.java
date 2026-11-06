package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("OaSupplierPaymentDataIdDTO")
public class OaSupplierPaymentDataIdDTO {
   @ApiModelProperty(name = "id", value = "付款表id")
   private Long id;
   @ApiModelProperty("付款额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("实付金额")
   private BigDecimal actuallyPaymentAmount;

   public static OaSupplierPaymentDataIdDTO.OaSupplierPaymentDataIdDTOBuilder builder() {
      return new OaSupplierPaymentDataIdDTO.OaSupplierPaymentDataIdDTOBuilder();
   }

   public OaSupplierPaymentDataIdDTO(final Long id, final BigDecimal paymentAmount, final String serialNumber, final BigDecimal actuallyPaymentAmount) {
      this.id = id;
      this.paymentAmount = paymentAmount;
      this.serialNumber = serialNumber;
      this.actuallyPaymentAmount = actuallyPaymentAmount;
   }

   public OaSupplierPaymentDataIdDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getActuallyPaymentAmount() {
      return this.actuallyPaymentAmount;
   }

   public OaSupplierPaymentDataIdDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public OaSupplierPaymentDataIdDTO setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
      return this;
   }

   public OaSupplierPaymentDataIdDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public OaSupplierPaymentDataIdDTO setActuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
      this.actuallyPaymentAmount = actuallyPaymentAmount;
      return this;
   }

   @Override
   public String toString() {
      return "OaSupplierPaymentDataIdDTO(id="
         + this.getId()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", actuallyPaymentAmount="
         + this.getActuallyPaymentAmount()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaSupplierPaymentDataIdDTO)) {
         return false;
      }

      OaSupplierPaymentDataIdDTO other = (OaSupplierPaymentDataIdDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paymentAmount = this.getPaymentAmount();
         Object other$paymentAmount = other.getPaymentAmount();
         if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$actuallyPaymentAmount = this.getActuallyPaymentAmount();
               Object other$actuallyPaymentAmount = other.getActuallyPaymentAmount();
               return this$actuallyPaymentAmount == null ? other$actuallyPaymentAmount == null : this$actuallyPaymentAmount.equals(other$actuallyPaymentAmount);
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
      return other instanceof OaSupplierPaymentDataIdDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $actuallyPaymentAmount = this.getActuallyPaymentAmount();
      return result * 59 + ($actuallyPaymentAmount == null ? 43 : $actuallyPaymentAmount.hashCode());
   }

   public static class OaSupplierPaymentDataIdDTOBuilder {
      private Long id;
      private BigDecimal paymentAmount;
      private String serialNumber;
      private BigDecimal actuallyPaymentAmount;

      OaSupplierPaymentDataIdDTOBuilder() {
      }

      public OaSupplierPaymentDataIdDTO.OaSupplierPaymentDataIdDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OaSupplierPaymentDataIdDTO.OaSupplierPaymentDataIdDTOBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public OaSupplierPaymentDataIdDTO.OaSupplierPaymentDataIdDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public OaSupplierPaymentDataIdDTO.OaSupplierPaymentDataIdDTOBuilder actuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
         this.actuallyPaymentAmount = actuallyPaymentAmount;
         return this;
      }

      public OaSupplierPaymentDataIdDTO build() {
         return new OaSupplierPaymentDataIdDTO(this.id, this.paymentAmount, this.serialNumber, this.actuallyPaymentAmount);
      }

      @Override
      public String toString() {
         return "OaSupplierPaymentDataIdDTO.OaSupplierPaymentDataIdDTOBuilder(id="
            + this.id
            + ", paymentAmount="
            + this.paymentAmount
            + ", serialNumber="
            + this.serialNumber
            + ", actuallyPaymentAmount="
            + this.actuallyPaymentAmount
            + ")";
      }
   }
}
