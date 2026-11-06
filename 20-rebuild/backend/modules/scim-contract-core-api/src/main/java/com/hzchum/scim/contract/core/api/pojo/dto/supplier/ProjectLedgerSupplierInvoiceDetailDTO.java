package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiOperation("项目台账-项目支出信息详情")
public class ProjectLedgerSupplierInvoiceDetailDTO {
   @ApiModelProperty("编号")
   private String number;
   @ApiModelProperty("日期")
   private LocalDateTime paymentDate;
   @ApiModelProperty("金额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("类型")
   private Integer type;

   ProjectLedgerSupplierInvoiceDetailDTO(final String number, final LocalDateTime paymentDate, final BigDecimal paymentAmount, final Integer type) {
      this.number = number;
      this.paymentDate = paymentDate;
      this.paymentAmount = paymentAmount;
      this.type = type;
   }

   public static ProjectLedgerSupplierInvoiceDetailDTO.ProjectLedgerSupplierInvoiceDetailDTOBuilder builder() {
      return new ProjectLedgerSupplierInvoiceDetailDTO.ProjectLedgerSupplierInvoiceDetailDTOBuilder();
   }

   public String getNumber() {
      return this.number;
   }

   public LocalDateTime getPaymentDate() {
      return this.paymentDate;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public Integer getType() {
      return this.type;
   }

   public void setNumber(final String number) {
      this.number = number;
   }

   public void setPaymentDate(final LocalDateTime paymentDate) {
      this.paymentDate = paymentDate;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLedgerSupplierInvoiceDetailDTO)) {
         return false;
      }

      ProjectLedgerSupplierInvoiceDetailDTO other = (ProjectLedgerSupplierInvoiceDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$number = this.getNumber();
         Object other$number = other.getNumber();
         if (this$number == null ? other$number == null : this$number.equals(other$number)) {
            Object this$paymentDate = this.getPaymentDate();
            Object other$paymentDate = other.getPaymentDate();
            if (this$paymentDate == null ? other$paymentDate == null : this$paymentDate.equals(other$paymentDate)) {
               Object this$paymentAmount = this.getPaymentAmount();
               Object other$paymentAmount = other.getPaymentAmount();
               return this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount);
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
      return other instanceof ProjectLedgerSupplierInvoiceDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      return result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLedgerSupplierInvoiceDetailDTO(number="
         + this.getNumber()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", type="
         + this.getType()
         + ")";
   }

   public static class ProjectLedgerSupplierInvoiceDetailDTOBuilder {
      private String number;
      private LocalDateTime paymentDate;
      private BigDecimal paymentAmount;
      private Integer type;

      ProjectLedgerSupplierInvoiceDetailDTOBuilder() {
      }

      public ProjectLedgerSupplierInvoiceDetailDTO.ProjectLedgerSupplierInvoiceDetailDTOBuilder number(final String number) {
         this.number = number;
         return this;
      }

      public ProjectLedgerSupplierInvoiceDetailDTO.ProjectLedgerSupplierInvoiceDetailDTOBuilder paymentDate(final LocalDateTime paymentDate) {
         this.paymentDate = paymentDate;
         return this;
      }

      public ProjectLedgerSupplierInvoiceDetailDTO.ProjectLedgerSupplierInvoiceDetailDTOBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public ProjectLedgerSupplierInvoiceDetailDTO.ProjectLedgerSupplierInvoiceDetailDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ProjectLedgerSupplierInvoiceDetailDTO build() {
         return new ProjectLedgerSupplierInvoiceDetailDTO(this.number, this.paymentDate, this.paymentAmount, this.type);
      }

      @Override
      public String toString() {
         return "ProjectLedgerSupplierInvoiceDetailDTO.ProjectLedgerSupplierInvoiceDetailDTOBuilder(number="
            + this.number
            + ", paymentDate="
            + this.paymentDate
            + ", paymentAmount="
            + this.paymentAmount
            + ", type="
            + this.type
            + ")";
      }
   }
}
