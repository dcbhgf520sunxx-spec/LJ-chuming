package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class SupplierSelfEmployedDto {
   @ApiModelProperty("合同id")
   private Long orderId;
   @ApiModelProperty("合同主体id")
   private Long contractSignBodyId;
   @ApiModelProperty("合同名称")
   private String contractSignBodyName;
   @ApiModelProperty("合同编号")
   private String purchaseContractNumber;
   @ApiModelProperty("累计入库额")
   private BigDecimal inboundAmountSum;
   @ApiModelProperty("已入库额")
   private BigDecimal storageAmountSum;
   @ApiModelProperty("累计付款")
   private BigDecimal paymentAmountSum;
   @ApiModelProperty("累计开票")
   private BigDecimal invoiceAmountSum;
   @ApiModelProperty("合同额")
   private BigDecimal contractAmount;
   @ApiModelProperty("本次付款")
   private BigDecimal paymentAmount;
   @ApiModelProperty("名称")
   private String projectNames;
   @ApiModelProperty(name = "actualAmountPaid", value = "实付金额", notes = "实付金额")
   private BigDecimal actualAmountPaid;
   @ApiModelProperty("申请发票金额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("实开发票金额")
   private BigDecimal actualInvoiceAmount;
   @ApiModelProperty(name = "isStatus", value = "是否审核", notes = "是否审核")
   private Boolean isStatus;

   public static SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder builder() {
      return new SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder();
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public String getContractSignBodyName() {
      return this.contractSignBodyName;
   }

   public String getPurchaseContractNumber() {
      return this.purchaseContractNumber;
   }

   public BigDecimal getInboundAmountSum() {
      return this.inboundAmountSum;
   }

   public BigDecimal getStorageAmountSum() {
      return this.storageAmountSum;
   }

   public BigDecimal getPaymentAmountSum() {
      return this.paymentAmountSum;
   }

   public BigDecimal getInvoiceAmountSum() {
      return this.invoiceAmountSum;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public String getProjectNames() {
      return this.projectNames;
   }

   public BigDecimal getActualAmountPaid() {
      return this.actualAmountPaid;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getActualInvoiceAmount() {
      return this.actualInvoiceAmount;
   }

   public Boolean getIsStatus() {
      return this.isStatus;
   }

   public SupplierSelfEmployedDto setOrderId(final Long orderId) {
      this.orderId = orderId;
      return this;
   }

   public SupplierSelfEmployedDto setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
      return this;
   }

   public SupplierSelfEmployedDto setContractSignBodyName(final String contractSignBodyName) {
      this.contractSignBodyName = contractSignBodyName;
      return this;
   }

   public SupplierSelfEmployedDto setPurchaseContractNumber(final String purchaseContractNumber) {
      this.purchaseContractNumber = purchaseContractNumber;
      return this;
   }

   public SupplierSelfEmployedDto setInboundAmountSum(final BigDecimal inboundAmountSum) {
      this.inboundAmountSum = inboundAmountSum;
      return this;
   }

   public SupplierSelfEmployedDto setStorageAmountSum(final BigDecimal storageAmountSum) {
      this.storageAmountSum = storageAmountSum;
      return this;
   }

   public SupplierSelfEmployedDto setPaymentAmountSum(final BigDecimal paymentAmountSum) {
      this.paymentAmountSum = paymentAmountSum;
      return this;
   }

   public SupplierSelfEmployedDto setInvoiceAmountSum(final BigDecimal invoiceAmountSum) {
      this.invoiceAmountSum = invoiceAmountSum;
      return this;
   }

   public SupplierSelfEmployedDto setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   public SupplierSelfEmployedDto setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
      return this;
   }

   public SupplierSelfEmployedDto setProjectNames(final String projectNames) {
      this.projectNames = projectNames;
      return this;
   }

   public SupplierSelfEmployedDto setActualAmountPaid(final BigDecimal actualAmountPaid) {
      this.actualAmountPaid = actualAmountPaid;
      return this;
   }

   public SupplierSelfEmployedDto setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
      return this;
   }

   public SupplierSelfEmployedDto setActualInvoiceAmount(final BigDecimal actualInvoiceAmount) {
      this.actualInvoiceAmount = actualInvoiceAmount;
      return this;
   }

   public SupplierSelfEmployedDto setIsStatus(final Boolean isStatus) {
      this.isStatus = isStatus;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierSelfEmployedDto)) {
         return false;
      }

      SupplierSelfEmployedDto other = (SupplierSelfEmployedDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderId = this.getOrderId();
      Object other$orderId = other.getOrderId();
      if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
         Object this$contractSignBodyId = this.getContractSignBodyId();
         Object other$contractSignBodyId = other.getContractSignBodyId();
         if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
            Object this$isStatus = this.getIsStatus();
            Object other$isStatus = other.getIsStatus();
            if (this$isStatus == null ? other$isStatus == null : this$isStatus.equals(other$isStatus)) {
               Object this$contractSignBodyName = this.getContractSignBodyName();
               Object other$contractSignBodyName = other.getContractSignBodyName();
               if (this$contractSignBodyName == null ? other$contractSignBodyName == null : this$contractSignBodyName.equals(other$contractSignBodyName)) {
                  Object this$purchaseContractNumber = this.getPurchaseContractNumber();
                  Object other$purchaseContractNumber = other.getPurchaseContractNumber();
                  if (this$purchaseContractNumber == null
                     ? other$purchaseContractNumber == null
                     : this$purchaseContractNumber.equals(other$purchaseContractNumber)) {
                     Object this$inboundAmountSum = this.getInboundAmountSum();
                     Object other$inboundAmountSum = other.getInboundAmountSum();
                     if (this$inboundAmountSum == null ? other$inboundAmountSum == null : this$inboundAmountSum.equals(other$inboundAmountSum)) {
                        Object this$storageAmountSum = this.getStorageAmountSum();
                        Object other$storageAmountSum = other.getStorageAmountSum();
                        if (this$storageAmountSum == null ? other$storageAmountSum == null : this$storageAmountSum.equals(other$storageAmountSum)) {
                           Object this$paymentAmountSum = this.getPaymentAmountSum();
                           Object other$paymentAmountSum = other.getPaymentAmountSum();
                           if (this$paymentAmountSum == null ? other$paymentAmountSum == null : this$paymentAmountSum.equals(other$paymentAmountSum)) {
                              Object this$invoiceAmountSum = this.getInvoiceAmountSum();
                              Object other$invoiceAmountSum = other.getInvoiceAmountSum();
                              if (this$invoiceAmountSum == null ? other$invoiceAmountSum == null : this$invoiceAmountSum.equals(other$invoiceAmountSum)) {
                                 Object this$contractAmount = this.getContractAmount();
                                 Object other$contractAmount = other.getContractAmount();
                                 if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                                    Object this$paymentAmount = this.getPaymentAmount();
                                    Object other$paymentAmount = other.getPaymentAmount();
                                    if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
                                       Object this$projectNames = this.getProjectNames();
                                       Object other$projectNames = other.getProjectNames();
                                       if (this$projectNames == null ? other$projectNames == null : this$projectNames.equals(other$projectNames)) {
                                          Object this$actualAmountPaid = this.getActualAmountPaid();
                                          Object other$actualAmountPaid = other.getActualAmountPaid();
                                          if (this$actualAmountPaid == null
                                             ? other$actualAmountPaid == null
                                             : this$actualAmountPaid.equals(other$actualAmountPaid)) {
                                             Object this$invoiceAmount = this.getInvoiceAmount();
                                             Object other$invoiceAmount = other.getInvoiceAmount();
                                             if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                                                Object this$actualInvoiceAmount = this.getActualInvoiceAmount();
                                                Object other$actualInvoiceAmount = other.getActualInvoiceAmount();
                                                return this$actualInvoiceAmount == null
                                                   ? other$actualInvoiceAmount == null
                                                   : this$actualInvoiceAmount.equals(other$actualInvoiceAmount);
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
      return other instanceof SupplierSelfEmployedDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $isStatus = this.getIsStatus();
      result = result * 59 + ($isStatus == null ? 43 : $isStatus.hashCode());
      Object $contractSignBodyName = this.getContractSignBodyName();
      result = result * 59 + ($contractSignBodyName == null ? 43 : $contractSignBodyName.hashCode());
      Object $purchaseContractNumber = this.getPurchaseContractNumber();
      result = result * 59 + ($purchaseContractNumber == null ? 43 : $purchaseContractNumber.hashCode());
      Object $inboundAmountSum = this.getInboundAmountSum();
      result = result * 59 + ($inboundAmountSum == null ? 43 : $inboundAmountSum.hashCode());
      Object $storageAmountSum = this.getStorageAmountSum();
      result = result * 59 + ($storageAmountSum == null ? 43 : $storageAmountSum.hashCode());
      Object $paymentAmountSum = this.getPaymentAmountSum();
      result = result * 59 + ($paymentAmountSum == null ? 43 : $paymentAmountSum.hashCode());
      Object $invoiceAmountSum = this.getInvoiceAmountSum();
      result = result * 59 + ($invoiceAmountSum == null ? 43 : $invoiceAmountSum.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $projectNames = this.getProjectNames();
      result = result * 59 + ($projectNames == null ? 43 : $projectNames.hashCode());
      Object $actualAmountPaid = this.getActualAmountPaid();
      result = result * 59 + ($actualAmountPaid == null ? 43 : $actualAmountPaid.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $actualInvoiceAmount = this.getActualInvoiceAmount();
      return result * 59 + ($actualInvoiceAmount == null ? 43 : $actualInvoiceAmount.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSelfEmployedDto(orderId="
         + this.getOrderId()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", contractSignBodyName="
         + this.getContractSignBodyName()
         + ", purchaseContractNumber="
         + this.getPurchaseContractNumber()
         + ", inboundAmountSum="
         + this.getInboundAmountSum()
         + ", storageAmountSum="
         + this.getStorageAmountSum()
         + ", paymentAmountSum="
         + this.getPaymentAmountSum()
         + ", invoiceAmountSum="
         + this.getInvoiceAmountSum()
         + ", contractAmount="
         + this.getContractAmount()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", projectNames="
         + this.getProjectNames()
         + ", actualAmountPaid="
         + this.getActualAmountPaid()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", actualInvoiceAmount="
         + this.getActualInvoiceAmount()
         + ", isStatus="
         + this.getIsStatus()
         + ")";
   }

   public SupplierSelfEmployedDto(
      final Long orderId,
      final Long contractSignBodyId,
      final String contractSignBodyName,
      final String purchaseContractNumber,
      final BigDecimal inboundAmountSum,
      final BigDecimal storageAmountSum,
      final BigDecimal paymentAmountSum,
      final BigDecimal invoiceAmountSum,
      final BigDecimal contractAmount,
      final BigDecimal paymentAmount,
      final String projectNames,
      final BigDecimal actualAmountPaid,
      final BigDecimal invoiceAmount,
      final BigDecimal actualInvoiceAmount,
      final Boolean isStatus
   ) {
      this.orderId = orderId;
      this.contractSignBodyId = contractSignBodyId;
      this.contractSignBodyName = contractSignBodyName;
      this.purchaseContractNumber = purchaseContractNumber;
      this.inboundAmountSum = inboundAmountSum;
      this.storageAmountSum = storageAmountSum;
      this.paymentAmountSum = paymentAmountSum;
      this.invoiceAmountSum = invoiceAmountSum;
      this.contractAmount = contractAmount;
      this.paymentAmount = paymentAmount;
      this.projectNames = projectNames;
      this.actualAmountPaid = actualAmountPaid;
      this.invoiceAmount = invoiceAmount;
      this.actualInvoiceAmount = actualInvoiceAmount;
      this.isStatus = isStatus;
   }

   public SupplierSelfEmployedDto() {
   }

   public static class SupplierSelfEmployedDtoBuilder {
      private Long orderId;
      private Long contractSignBodyId;
      private String contractSignBodyName;
      private String purchaseContractNumber;
      private BigDecimal inboundAmountSum;
      private BigDecimal storageAmountSum;
      private BigDecimal paymentAmountSum;
      private BigDecimal invoiceAmountSum;
      private BigDecimal contractAmount;
      private BigDecimal paymentAmount;
      private String projectNames;
      private BigDecimal actualAmountPaid;
      private BigDecimal invoiceAmount;
      private BigDecimal actualInvoiceAmount;
      private Boolean isStatus;

      SupplierSelfEmployedDtoBuilder() {
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder contractSignBodyId(final Long contractSignBodyId) {
         this.contractSignBodyId = contractSignBodyId;
         return this;
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder contractSignBodyName(final String contractSignBodyName) {
         this.contractSignBodyName = contractSignBodyName;
         return this;
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder purchaseContractNumber(final String purchaseContractNumber) {
         this.purchaseContractNumber = purchaseContractNumber;
         return this;
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder inboundAmountSum(final BigDecimal inboundAmountSum) {
         this.inboundAmountSum = inboundAmountSum;
         return this;
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder storageAmountSum(final BigDecimal storageAmountSum) {
         this.storageAmountSum = storageAmountSum;
         return this;
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder paymentAmountSum(final BigDecimal paymentAmountSum) {
         this.paymentAmountSum = paymentAmountSum;
         return this;
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder invoiceAmountSum(final BigDecimal invoiceAmountSum) {
         this.invoiceAmountSum = invoiceAmountSum;
         return this;
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder projectNames(final String projectNames) {
         this.projectNames = projectNames;
         return this;
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder actualAmountPaid(final BigDecimal actualAmountPaid) {
         this.actualAmountPaid = actualAmountPaid;
         return this;
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder actualInvoiceAmount(final BigDecimal actualInvoiceAmount) {
         this.actualInvoiceAmount = actualInvoiceAmount;
         return this;
      }

      public SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder isStatus(final Boolean isStatus) {
         this.isStatus = isStatus;
         return this;
      }

      public SupplierSelfEmployedDto build() {
         return new SupplierSelfEmployedDto(
            this.orderId,
            this.contractSignBodyId,
            this.contractSignBodyName,
            this.purchaseContractNumber,
            this.inboundAmountSum,
            this.storageAmountSum,
            this.paymentAmountSum,
            this.invoiceAmountSum,
            this.contractAmount,
            this.paymentAmount,
            this.projectNames,
            this.actualAmountPaid,
            this.invoiceAmount,
            this.actualInvoiceAmount,
            this.isStatus
         );
      }

      @Override
      public String toString() {
         return "SupplierSelfEmployedDto.SupplierSelfEmployedDtoBuilder(orderId="
            + this.orderId
            + ", contractSignBodyId="
            + this.contractSignBodyId
            + ", contractSignBodyName="
            + this.contractSignBodyName
            + ", purchaseContractNumber="
            + this.purchaseContractNumber
            + ", inboundAmountSum="
            + this.inboundAmountSum
            + ", storageAmountSum="
            + this.storageAmountSum
            + ", paymentAmountSum="
            + this.paymentAmountSum
            + ", invoiceAmountSum="
            + this.invoiceAmountSum
            + ", contractAmount="
            + this.contractAmount
            + ", paymentAmount="
            + this.paymentAmount
            + ", projectNames="
            + this.projectNames
            + ", actualAmountPaid="
            + this.actualAmountPaid
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", actualInvoiceAmount="
            + this.actualInvoiceAmount
            + ", isStatus="
            + this.isStatus
            + ")";
      }
   }
}
