package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class SelfEmployedSettlement {
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("合同额")
   private BigDecimal contractAmount;
   @ApiModelProperty("签订主体名称")
   private String branchCompanyName;
   @ApiModelProperty("累计入库额")
   private BigDecimal inboundAmountSum;
   @ApiModelProperty("累计付款")
   private BigDecimal paymentAmountSum;
   @ApiModelProperty("累计开票")
   private BigDecimal invoiceAmountSum;
   @ApiModelProperty("预结算总额")
   private BigDecimal preSettlementAmount;
   @ApiModelProperty("付款开票信息")
   private List<SupplierSettlementEchoDto> supplierSettlementEchoDtoPageVO;

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public BigDecimal getInboundAmountSum() {
      return this.inboundAmountSum;
   }

   public BigDecimal getPaymentAmountSum() {
      return this.paymentAmountSum;
   }

   public BigDecimal getInvoiceAmountSum() {
      return this.invoiceAmountSum;
   }

   public BigDecimal getPreSettlementAmount() {
      return this.preSettlementAmount;
   }

   public List<SupplierSettlementEchoDto> getSupplierSettlementEchoDtoPageVO() {
      return this.supplierSettlementEchoDtoPageVO;
   }

   public SelfEmployedSettlement setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public SelfEmployedSettlement setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   public SelfEmployedSettlement setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
      return this;
   }

   public SelfEmployedSettlement setInboundAmountSum(final BigDecimal inboundAmountSum) {
      this.inboundAmountSum = inboundAmountSum;
      return this;
   }

   public SelfEmployedSettlement setPaymentAmountSum(final BigDecimal paymentAmountSum) {
      this.paymentAmountSum = paymentAmountSum;
      return this;
   }

   public SelfEmployedSettlement setInvoiceAmountSum(final BigDecimal invoiceAmountSum) {
      this.invoiceAmountSum = invoiceAmountSum;
      return this;
   }

   public SelfEmployedSettlement setPreSettlementAmount(final BigDecimal preSettlementAmount) {
      this.preSettlementAmount = preSettlementAmount;
      return this;
   }

   public SelfEmployedSettlement setSupplierSettlementEchoDtoPageVO(final List<SupplierSettlementEchoDto> supplierSettlementEchoDtoPageVO) {
      this.supplierSettlementEchoDtoPageVO = supplierSettlementEchoDtoPageVO;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SelfEmployedSettlement)) {
         return false;
      }

      SelfEmployedSettlement other = (SelfEmployedSettlement)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectName = this.getProjectName();
      Object other$projectName = other.getProjectName();
      if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
         Object this$contractAmount = this.getContractAmount();
         Object other$contractAmount = other.getContractAmount();
         if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
            Object this$branchCompanyName = this.getBranchCompanyName();
            Object other$branchCompanyName = other.getBranchCompanyName();
            if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
               Object this$inboundAmountSum = this.getInboundAmountSum();
               Object other$inboundAmountSum = other.getInboundAmountSum();
               if (this$inboundAmountSum == null ? other$inboundAmountSum == null : this$inboundAmountSum.equals(other$inboundAmountSum)) {
                  Object this$paymentAmountSum = this.getPaymentAmountSum();
                  Object other$paymentAmountSum = other.getPaymentAmountSum();
                  if (this$paymentAmountSum == null ? other$paymentAmountSum == null : this$paymentAmountSum.equals(other$paymentAmountSum)) {
                     Object this$invoiceAmountSum = this.getInvoiceAmountSum();
                     Object other$invoiceAmountSum = other.getInvoiceAmountSum();
                     if (this$invoiceAmountSum == null ? other$invoiceAmountSum == null : this$invoiceAmountSum.equals(other$invoiceAmountSum)) {
                        Object this$preSettlementAmount = this.getPreSettlementAmount();
                        Object other$preSettlementAmount = other.getPreSettlementAmount();
                        if (this$preSettlementAmount == null ? other$preSettlementAmount == null : this$preSettlementAmount.equals(other$preSettlementAmount)) {
                           Object this$supplierSettlementEchoDtoPageVO = this.getSupplierSettlementEchoDtoPageVO();
                           Object other$supplierSettlementEchoDtoPageVO = other.getSupplierSettlementEchoDtoPageVO();
                           return this$supplierSettlementEchoDtoPageVO == null
                              ? other$supplierSettlementEchoDtoPageVO == null
                              : this$supplierSettlementEchoDtoPageVO.equals(other$supplierSettlementEchoDtoPageVO);
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
      return other instanceof SelfEmployedSettlement;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $inboundAmountSum = this.getInboundAmountSum();
      result = result * 59 + ($inboundAmountSum == null ? 43 : $inboundAmountSum.hashCode());
      Object $paymentAmountSum = this.getPaymentAmountSum();
      result = result * 59 + ($paymentAmountSum == null ? 43 : $paymentAmountSum.hashCode());
      Object $invoiceAmountSum = this.getInvoiceAmountSum();
      result = result * 59 + ($invoiceAmountSum == null ? 43 : $invoiceAmountSum.hashCode());
      Object $preSettlementAmount = this.getPreSettlementAmount();
      result = result * 59 + ($preSettlementAmount == null ? 43 : $preSettlementAmount.hashCode());
      Object $supplierSettlementEchoDtoPageVO = this.getSupplierSettlementEchoDtoPageVO();
      return result * 59 + ($supplierSettlementEchoDtoPageVO == null ? 43 : $supplierSettlementEchoDtoPageVO.hashCode());
   }

   @Override
   public String toString() {
      return "SelfEmployedSettlement(projectName="
         + this.getProjectName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", inboundAmountSum="
         + this.getInboundAmountSum()
         + ", paymentAmountSum="
         + this.getPaymentAmountSum()
         + ", invoiceAmountSum="
         + this.getInvoiceAmountSum()
         + ", preSettlementAmount="
         + this.getPreSettlementAmount()
         + ", supplierSettlementEchoDtoPageVO="
         + this.getSupplierSettlementEchoDtoPageVO()
         + ")";
   }

   public SelfEmployedSettlement(
      final String projectName,
      final BigDecimal contractAmount,
      final String branchCompanyName,
      final BigDecimal inboundAmountSum,
      final BigDecimal paymentAmountSum,
      final BigDecimal invoiceAmountSum,
      final BigDecimal preSettlementAmount,
      final List<SupplierSettlementEchoDto> supplierSettlementEchoDtoPageVO
   ) {
      this.projectName = projectName;
      this.contractAmount = contractAmount;
      this.branchCompanyName = branchCompanyName;
      this.inboundAmountSum = inboundAmountSum;
      this.paymentAmountSum = paymentAmountSum;
      this.invoiceAmountSum = invoiceAmountSum;
      this.preSettlementAmount = preSettlementAmount;
      this.supplierSettlementEchoDtoPageVO = supplierSettlementEchoDtoPageVO;
   }

   public SelfEmployedSettlement() {
   }
}
