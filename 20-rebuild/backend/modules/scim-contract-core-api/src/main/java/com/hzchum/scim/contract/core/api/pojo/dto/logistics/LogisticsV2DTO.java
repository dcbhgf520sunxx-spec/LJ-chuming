package com.hzchum.scim.contract.core.api.pojo.dto.logistics;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("物流汇总")
public class LogisticsV2DTO {
   @ApiModelProperty("项目id/采购订单id/物流公司id")
   private Long id;
   @ApiModelProperty("物流单位")
   private NameInfo logisticsCompany;
   @ApiModelProperty("签订主体")
   private NameInfo branchCompany;
   @ApiModelProperty("车次")
   private Integer trainNumber;
   @ApiModelProperty("累计金额")
   private BigDecimal freight;
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("累计付款")
   private BigDecimal payment;
   @ApiModelProperty("累计收票")
   private BigDecimal invoice;
   @ApiModelProperty("执行状态")
   private Integer executeStatus;

   public static LogisticsV2DTO.LogisticsV2DTOBuilder builder() {
      return new LogisticsV2DTO.LogisticsV2DTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public NameInfo getLogisticsCompany() {
      return this.logisticsCompany;
   }

   public NameInfo getBranchCompany() {
      return this.branchCompany;
   }

   public Integer getTrainNumber() {
      return this.trainNumber;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getPayment() {
      return this.payment;
   }

   public BigDecimal getInvoice() {
      return this.invoice;
   }

   public Integer getExecuteStatus() {
      return this.executeStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setLogisticsCompany(final NameInfo logisticsCompany) {
      this.logisticsCompany = logisticsCompany;
   }

   public void setBranchCompany(final NameInfo branchCompany) {
      this.branchCompany = branchCompany;
   }

   public void setTrainNumber(final Integer trainNumber) {
      this.trainNumber = trainNumber;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setPayment(final BigDecimal payment) {
      this.payment = payment;
   }

   public void setInvoice(final BigDecimal invoice) {
      this.invoice = invoice;
   }

   public void setExecuteStatus(final Integer executeStatus) {
      this.executeStatus = executeStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsV2DTO)) {
         return false;
      }

      LogisticsV2DTO other = (LogisticsV2DTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$trainNumber = this.getTrainNumber();
         Object other$trainNumber = other.getTrainNumber();
         if (this$trainNumber == null ? other$trainNumber == null : this$trainNumber.equals(other$trainNumber)) {
            Object this$executeStatus = this.getExecuteStatus();
            Object other$executeStatus = other.getExecuteStatus();
            if (this$executeStatus == null ? other$executeStatus == null : this$executeStatus.equals(other$executeStatus)) {
               Object this$logisticsCompany = this.getLogisticsCompany();
               Object other$logisticsCompany = other.getLogisticsCompany();
               if (this$logisticsCompany == null ? other$logisticsCompany == null : this$logisticsCompany.equals(other$logisticsCompany)) {
                  Object this$branchCompany = this.getBranchCompany();
                  Object other$branchCompany = other.getBranchCompany();
                  if (this$branchCompany == null ? other$branchCompany == null : this$branchCompany.equals(other$branchCompany)) {
                     Object this$freight = this.getFreight();
                     Object other$freight = other.getFreight();
                     if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                        Object this$settlementAmount = this.getSettlementAmount();
                        Object other$settlementAmount = other.getSettlementAmount();
                        if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
                           Object this$payment = this.getPayment();
                           Object other$payment = other.getPayment();
                           if (this$payment == null ? other$payment == null : this$payment.equals(other$payment)) {
                              Object this$invoice = this.getInvoice();
                              Object other$invoice = other.getInvoice();
                              return this$invoice == null ? other$invoice == null : this$invoice.equals(other$invoice);
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
      return other instanceof LogisticsV2DTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $trainNumber = this.getTrainNumber();
      result = result * 59 + ($trainNumber == null ? 43 : $trainNumber.hashCode());
      Object $executeStatus = this.getExecuteStatus();
      result = result * 59 + ($executeStatus == null ? 43 : $executeStatus.hashCode());
      Object $logisticsCompany = this.getLogisticsCompany();
      result = result * 59 + ($logisticsCompany == null ? 43 : $logisticsCompany.hashCode());
      Object $branchCompany = this.getBranchCompany();
      result = result * 59 + ($branchCompany == null ? 43 : $branchCompany.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $payment = this.getPayment();
      result = result * 59 + ($payment == null ? 43 : $payment.hashCode());
      Object $invoice = this.getInvoice();
      return result * 59 + ($invoice == null ? 43 : $invoice.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsV2DTO(id="
         + this.getId()
         + ", logisticsCompany="
         + this.getLogisticsCompany()
         + ", branchCompany="
         + this.getBranchCompany()
         + ", trainNumber="
         + this.getTrainNumber()
         + ", freight="
         + this.getFreight()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", payment="
         + this.getPayment()
         + ", invoice="
         + this.getInvoice()
         + ", executeStatus="
         + this.getExecuteStatus()
         + ")";
   }

   public LogisticsV2DTO(
      final Long id,
      final NameInfo logisticsCompany,
      final NameInfo branchCompany,
      final Integer trainNumber,
      final BigDecimal freight,
      final BigDecimal settlementAmount,
      final BigDecimal payment,
      final BigDecimal invoice,
      final Integer executeStatus
   ) {
      this.id = id;
      this.logisticsCompany = logisticsCompany;
      this.branchCompany = branchCompany;
      this.trainNumber = trainNumber;
      this.freight = freight;
      this.settlementAmount = settlementAmount;
      this.payment = payment;
      this.invoice = invoice;
      this.executeStatus = executeStatus;
   }

   public LogisticsV2DTO() {
   }

   public static class LogisticsV2DTOBuilder {
      private Long id;
      private NameInfo logisticsCompany;
      private NameInfo branchCompany;
      private Integer trainNumber;
      private BigDecimal freight;
      private BigDecimal settlementAmount;
      private BigDecimal payment;
      private BigDecimal invoice;
      private Integer executeStatus;

      LogisticsV2DTOBuilder() {
      }

      public LogisticsV2DTO.LogisticsV2DTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public LogisticsV2DTO.LogisticsV2DTOBuilder logisticsCompany(final NameInfo logisticsCompany) {
         this.logisticsCompany = logisticsCompany;
         return this;
      }

      public LogisticsV2DTO.LogisticsV2DTOBuilder branchCompany(final NameInfo branchCompany) {
         this.branchCompany = branchCompany;
         return this;
      }

      public LogisticsV2DTO.LogisticsV2DTOBuilder trainNumber(final Integer trainNumber) {
         this.trainNumber = trainNumber;
         return this;
      }

      public LogisticsV2DTO.LogisticsV2DTOBuilder freight(final BigDecimal freight) {
         this.freight = freight;
         return this;
      }

      public LogisticsV2DTO.LogisticsV2DTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public LogisticsV2DTO.LogisticsV2DTOBuilder payment(final BigDecimal payment) {
         this.payment = payment;
         return this;
      }

      public LogisticsV2DTO.LogisticsV2DTOBuilder invoice(final BigDecimal invoice) {
         this.invoice = invoice;
         return this;
      }

      public LogisticsV2DTO.LogisticsV2DTOBuilder executeStatus(final Integer executeStatus) {
         this.executeStatus = executeStatus;
         return this;
      }

      public LogisticsV2DTO build() {
         return new LogisticsV2DTO(
            this.id,
            this.logisticsCompany,
            this.branchCompany,
            this.trainNumber,
            this.freight,
            this.settlementAmount,
            this.payment,
            this.invoice,
            this.executeStatus
         );
      }

      @Override
      public String toString() {
         return "LogisticsV2DTO.LogisticsV2DTOBuilder(id="
            + this.id
            + ", logisticsCompany="
            + this.logisticsCompany
            + ", branchCompany="
            + this.branchCompany
            + ", trainNumber="
            + this.trainNumber
            + ", freight="
            + this.freight
            + ", settlementAmount="
            + this.settlementAmount
            + ", payment="
            + this.payment
            + ", invoice="
            + this.invoice
            + ", executeStatus="
            + this.executeStatus
            + ")";
      }
   }
}
