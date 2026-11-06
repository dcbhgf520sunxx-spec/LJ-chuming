package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("结算填报")
public class SupplierSettlementSaveDTOParam {
   @ApiModelProperty("订单id ")
   @NotNull(message = "采购订单id不能为空")
   private Long orderId;
   @ApiModelProperty("结算金额")
   @NotNull(message = "结算金额不能为空")
   @Min(value = 0L, message = "结算金额不能小于0")
   private BigDecimal amount;
   @ApiModelProperty("附件ids")
   private List<Long> attachmentIds;
   @ApiModelProperty("备注")
   private String remark;

   public Long getOrderId() {
      return this.orderId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
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

      if (!(o instanceof SupplierSettlementSaveDTOParam)) {
         return false;
      }

      SupplierSettlementSaveDTOParam other = (SupplierSettlementSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderId = this.getOrderId();
      Object other$orderId = other.getOrderId();
      if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
         Object this$amount = this.getAmount();
         Object other$amount = other.getAmount();
         if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierSettlementSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSettlementSaveDTOParam(orderId="
         + this.getOrderId()
         + ", amount="
         + this.getAmount()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
