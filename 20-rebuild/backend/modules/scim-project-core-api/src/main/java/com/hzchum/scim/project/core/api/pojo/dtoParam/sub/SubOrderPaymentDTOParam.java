package com.hzchum.scim.project.core.api.pojo.dtoParam.sub;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("分包订单-付款新增类")
public class SubOrderPaymentDTOParam {
   @ApiModelProperty(name = "id", value = "主键id")
   private Long id;
   @ApiModelProperty("分包订单id ")
   @NotNull(message = "分包订单ID不能为空")
   private Long orderId;
   @ApiModelProperty("输入金额")
   @NotNull(message = "输入金额不能为空")
   private BigDecimal inputAmount;
   @ApiModelProperty("是否扣除违约金 true:扣除 false:不扣除")
   @NotNull(message = "本次付款是否扣除违约金必填")
   private Boolean boolDeduct;
   @ApiModelProperty("是否修改违约金")
   private boolean boolUpdateBreachAmount;
   @ApiModelProperty("付款事由id")
   @NotNull(message = "付款事由不能为空")
   private String paymentReasonId;
   @ApiModelProperty("付款日期")
   @NotNull(message = "付款日期不能为空")
   private LocalDate paymentDate;
   @ApiModelProperty("附件id列表")
   @Size(max = 10, message = "附件数量超出范围")
   private List<Long> attachmentIds;
   @ApiModelProperty("备注")
   @Size(max = 1000, message = "字数超出范围")
   private String remark;

   public Long getId() {
      return this.id;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public BigDecimal getInputAmount() {
      return this.inputAmount;
   }

   public Boolean getBoolDeduct() {
      return this.boolDeduct;
   }

   public boolean isBoolUpdateBreachAmount() {
      return this.boolUpdateBreachAmount;
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

   public void setInputAmount(final BigDecimal inputAmount) {
      this.inputAmount = inputAmount;
   }

   public void setBoolDeduct(final Boolean boolDeduct) {
      this.boolDeduct = boolDeduct;
   }

   public void setBoolUpdateBreachAmount(final boolean boolUpdateBreachAmount) {
      this.boolUpdateBreachAmount = boolUpdateBreachAmount;
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

      if (!(o instanceof SubOrderPaymentDTOParam)) {
         return false;
      }

      SubOrderPaymentDTOParam other = (SubOrderPaymentDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isBoolUpdateBreachAmount() != other.isBoolUpdateBreachAmount()) {
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
               Object this$inputAmount = this.getInputAmount();
               Object other$inputAmount = other.getInputAmount();
               if (this$inputAmount == null ? other$inputAmount == null : this$inputAmount.equals(other$inputAmount)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubOrderPaymentDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isBoolUpdateBreachAmount() ? 79 : 97);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $boolDeduct = this.getBoolDeduct();
      result = result * 59 + ($boolDeduct == null ? 43 : $boolDeduct.hashCode());
      Object $inputAmount = this.getInputAmount();
      result = result * 59 + ($inputAmount == null ? 43 : $inputAmount.hashCode());
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
      return "SubOrderPaymentDTOParam(id="
         + this.getId()
         + ", orderId="
         + this.getOrderId()
         + ", inputAmount="
         + this.getInputAmount()
         + ", boolDeduct="
         + this.getBoolDeduct()
         + ", boolUpdateBreachAmount="
         + this.isBoolUpdateBreachAmount()
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
