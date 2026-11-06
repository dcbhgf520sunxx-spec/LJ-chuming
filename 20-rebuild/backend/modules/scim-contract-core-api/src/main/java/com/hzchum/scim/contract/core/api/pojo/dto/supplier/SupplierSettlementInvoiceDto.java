package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;

@ApiOperation("采购结算-发票信息回显")
public class SupplierSettlementInvoiceDto {
   @ApiModelProperty("内包制付款开票信息回显")
   private PageVO<SupplierSettlementEchoDto> list;
   @ApiModelProperty("采购订单id")
   private Long orderId;
   @ApiModelProperty("签订主体id")
   private Long signatoryId;
   @ApiModelProperty("签订主体名称")
   private String signatoryName;
   @ApiModelProperty("项目合同额")
   private BigDecimal contractAmount;
   @ApiModelProperty("采购合同额")
   private BigDecimal paymentContractAmount;
   @ApiModelProperty("结算金额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("物资类型")
   private Integer basicClass;

   public PageVO<SupplierSettlementEchoDto> getList() {
      return this.list;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public Long getSignatoryId() {
      return this.signatoryId;
   }

   public String getSignatoryName() {
      return this.signatoryName;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getPaymentContractAmount() {
      return this.paymentContractAmount;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public SupplierSettlementInvoiceDto setList(final PageVO<SupplierSettlementEchoDto> list) {
      this.list = list;
      return this;
   }

   public SupplierSettlementInvoiceDto setOrderId(final Long orderId) {
      this.orderId = orderId;
      return this;
   }

   public SupplierSettlementInvoiceDto setSignatoryId(final Long signatoryId) {
      this.signatoryId = signatoryId;
      return this;
   }

   public SupplierSettlementInvoiceDto setSignatoryName(final String signatoryName) {
      this.signatoryName = signatoryName;
      return this;
   }

   public SupplierSettlementInvoiceDto setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   public SupplierSettlementInvoiceDto setPaymentContractAmount(final BigDecimal paymentContractAmount) {
      this.paymentContractAmount = paymentContractAmount;
      return this;
   }

   public SupplierSettlementInvoiceDto setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
      return this;
   }

   public SupplierSettlementInvoiceDto setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierSettlementInvoiceDto)) {
         return false;
      }

      SupplierSettlementInvoiceDto other = (SupplierSettlementInvoiceDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderId = this.getOrderId();
      Object other$orderId = other.getOrderId();
      if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
         Object this$signatoryId = this.getSignatoryId();
         Object other$signatoryId = other.getSignatoryId();
         if (this$signatoryId == null ? other$signatoryId == null : this$signatoryId.equals(other$signatoryId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$list = this.getList();
               Object other$list = other.getList();
               if (this$list == null ? other$list == null : this$list.equals(other$list)) {
                  Object this$signatoryName = this.getSignatoryName();
                  Object other$signatoryName = other.getSignatoryName();
                  if (this$signatoryName == null ? other$signatoryName == null : this$signatoryName.equals(other$signatoryName)) {
                     Object this$contractAmount = this.getContractAmount();
                     Object other$contractAmount = other.getContractAmount();
                     if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                        Object this$paymentContractAmount = this.getPaymentContractAmount();
                        Object other$paymentContractAmount = other.getPaymentContractAmount();
                        if (this$paymentContractAmount == null
                           ? other$paymentContractAmount == null
                           : this$paymentContractAmount.equals(other$paymentContractAmount)) {
                           Object this$settlementAmount = this.getSettlementAmount();
                           Object other$settlementAmount = other.getSettlementAmount();
                           return this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount);
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
      return other instanceof SupplierSettlementInvoiceDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $signatoryId = this.getSignatoryId();
      result = result * 59 + ($signatoryId == null ? 43 : $signatoryId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $signatoryName = this.getSignatoryName();
      result = result * 59 + ($signatoryName == null ? 43 : $signatoryName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $paymentContractAmount = this.getPaymentContractAmount();
      result = result * 59 + ($paymentContractAmount == null ? 43 : $paymentContractAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      return result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSettlementInvoiceDto(list="
         + this.getList()
         + ", orderId="
         + this.getOrderId()
         + ", signatoryId="
         + this.getSignatoryId()
         + ", signatoryName="
         + this.getSignatoryName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", paymentContractAmount="
         + this.getPaymentContractAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", basicClass="
         + this.getBasicClass()
         + ")";
   }
}
