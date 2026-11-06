package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("采购订单-修改付款")
public class PurchaseSupplierPaymentUpdateDTOParam {
   @ApiModelProperty("付款记录id ")
   @NotNull(message = "付款记录id不能为空")
   private Long id;
   @ApiModelProperty("订单id ")
   @NotNull(message = "订单id不能为空")
   private Long orderId;
   @ApiModelProperty("申请金额")
   @NotNull(message = "申请金额不能为空")
   private BigDecimal applyAmount;
   @ApiModelProperty("违约金额")
   private BigDecimal breachAmount;
   @ApiModelProperty("是否扣除")
   private Boolean boolDeduct;
   @ApiModelProperty("付款事由id")
   @NotBlank(message = "付款事由不能为空")
   private String paymentReasonId;
   @ApiModelProperty("付款日期")
   @NotNull(message = "付款日期不能为空")
   private LocalDate paymentDate;
   @ApiModelProperty("附件ids")
   private List<Long> attachmentIds;
   @ApiModelProperty("备注")
   private String remark;

   public Long getId() {
      return this.id;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public BigDecimal getBreachAmount() {
      return this.breachAmount;
   }

   public Boolean getBoolDeduct() {
      return this.boolDeduct;
   }

   public String getPaymentReasonId() {
      return this.paymentReasonId;
   }

   public LocalDate getPaymentDate() {
      return this.paymentDate;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
   }

   public void setBreachAmount(final BigDecimal breachAmount) {
      this.breachAmount = breachAmount;
   }

   public void setBoolDeduct(final Boolean boolDeduct) {
      this.boolDeduct = boolDeduct;
   }

   public void setPaymentReasonId(final String paymentReasonId) {
      this.paymentReasonId = paymentReasonId;
   }

   public void setPaymentDate(final LocalDate paymentDate) {
      this.paymentDate = paymentDate;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseSupplierPaymentUpdateDTOParam)) {
         return false;
      }

      PurchaseSupplierPaymentUpdateDTOParam other = (PurchaseSupplierPaymentUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$orderId = this.getOrderId();
         Object other$orderId = other.getOrderId();
         if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
            Object this$boolDeduct = this.getBoolDeduct();
            Object other$boolDeduct = other.getBoolDeduct();
            if (this$boolDeduct == null ? other$boolDeduct == null : this$boolDeduct.equals(other$boolDeduct)) {
               Object this$applyAmount = this.getApplyAmount();
               Object other$applyAmount = other.getApplyAmount();
               if (this$applyAmount == null ? other$applyAmount == null : this$applyAmount.equals(other$applyAmount)) {
                  Object this$breachAmount = this.getBreachAmount();
                  Object other$breachAmount = other.getBreachAmount();
                  if (this$breachAmount == null ? other$breachAmount == null : this$breachAmount.equals(other$breachAmount)) {
                     Object this$paymentReasonId = this.getPaymentReasonId();
                     Object other$paymentReasonId = other.getPaymentReasonId();
                     if (this$paymentReasonId == null ? other$paymentReasonId == null : this$paymentReasonId.equals(other$paymentReasonId)) {
                        Object this$paymentDate = this.getPaymentDate();
                        Object other$paymentDate = other.getPaymentDate();
                        if (this$paymentDate == null ? other$paymentDate == null : this$paymentDate.equals(other$paymentDate)) {
                           Object this$attachmentIds = this.getAttachmentIds();
                           Object other$attachmentIds = other.getAttachmentIds();
                           if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof PurchaseSupplierPaymentUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $boolDeduct = this.getBoolDeduct();
      result = result * 59 + ($boolDeduct == null ? 43 : $boolDeduct.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $breachAmount = this.getBreachAmount();
      result = result * 59 + ($breachAmount == null ? 43 : $breachAmount.hashCode());
      Object $paymentReasonId = this.getPaymentReasonId();
      result = result * 59 + ($paymentReasonId == null ? 43 : $paymentReasonId.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseSupplierPaymentUpdateDTOParam(id="
         + this.getId()
         + ", orderId="
         + this.getOrderId()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", breachAmount="
         + this.getBreachAmount()
         + ", boolDeduct="
         + this.getBoolDeduct()
         + ", paymentReasonId="
         + this.getPaymentReasonId()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
