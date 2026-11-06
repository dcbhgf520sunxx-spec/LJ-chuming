package com.hzchum.scim.project.core.api.pojo.dtoParam.sub;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "SupplierSettlement对象", description = "供应商结算表 ")
public class SubOrderSettlementDTOParam {
   @ApiModelProperty("订单id")
   @NotNull(message = "订单ID不能为空")
   private Long orderId;
   @ApiModelProperty("结算金额")
   @NotNull(message = "结算金额不能为空")
   private BigDecimal amount;
   @ApiModelProperty("是否扣除(违约金) true 扣除 false 不扣除")
   private Boolean boolDeduct;
   @ApiModelProperty("申请日期")
   @NotNull(message = "申请日期不能为空")
   private LocalDate applyDate;
   @ApiModelProperty("附件id列表")
   private List<Long> attachmentIds;
   @ApiModelProperty("备注")
   private String remark;

   public static SubOrderSettlementDTOParam.SubOrderSettlementDTOParamBuilder builder() {
      return new SubOrderSettlementDTOParam.SubOrderSettlementDTOParamBuilder();
   }

   public SubOrderSettlementDTOParam() {
   }

   public SubOrderSettlementDTOParam(
      final Long orderId, final BigDecimal amount, final Boolean boolDeduct, final LocalDate applyDate, final List<Long> attachmentIds, final String remark
   ) {
      this.orderId = orderId;
      this.amount = amount;
      this.boolDeduct = boolDeduct;
      this.applyDate = applyDate;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Boolean getBoolDeduct() {
      return this.boolDeduct;
   }

   public LocalDate getApplyDate() {
      return this.applyDate;
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

   public void setBoolDeduct(final Boolean boolDeduct) {
      this.boolDeduct = boolDeduct;
   }

   public void setApplyDate(final LocalDate applyDate) {
      this.applyDate = applyDate;
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

      if (!(o instanceof SubOrderSettlementDTOParam)) {
         return false;
      }

      SubOrderSettlementDTOParam other = (SubOrderSettlementDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderId = this.getOrderId();
      Object other$orderId = other.getOrderId();
      if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
         Object this$boolDeduct = this.getBoolDeduct();
         Object other$boolDeduct = other.getBoolDeduct();
         if (this$boolDeduct == null ? other$boolDeduct == null : this$boolDeduct.equals(other$boolDeduct)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$applyDate = this.getApplyDate();
               Object other$applyDate = other.getApplyDate();
               if (this$applyDate == null ? other$applyDate == null : this$applyDate.equals(other$applyDate)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubOrderSettlementDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $boolDeduct = this.getBoolDeduct();
      result = result * 59 + ($boolDeduct == null ? 43 : $boolDeduct.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $applyDate = this.getApplyDate();
      result = result * 59 + ($applyDate == null ? 43 : $applyDate.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "SubOrderSettlementDTOParam(orderId="
         + this.getOrderId()
         + ", amount="
         + this.getAmount()
         + ", boolDeduct="
         + this.getBoolDeduct()
         + ", applyDate="
         + this.getApplyDate()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class SubOrderSettlementDTOParamBuilder {
      private Long orderId;
      private BigDecimal amount;
      private Boolean boolDeduct;
      private LocalDate applyDate;
      private List<Long> attachmentIds;
      private String remark;

      SubOrderSettlementDTOParamBuilder() {
      }

      public SubOrderSettlementDTOParam.SubOrderSettlementDTOParamBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public SubOrderSettlementDTOParam.SubOrderSettlementDTOParamBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SubOrderSettlementDTOParam.SubOrderSettlementDTOParamBuilder boolDeduct(final Boolean boolDeduct) {
         this.boolDeduct = boolDeduct;
         return this;
      }

      public SubOrderSettlementDTOParam.SubOrderSettlementDTOParamBuilder applyDate(final LocalDate applyDate) {
         this.applyDate = applyDate;
         return this;
      }

      public SubOrderSettlementDTOParam.SubOrderSettlementDTOParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SubOrderSettlementDTOParam.SubOrderSettlementDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SubOrderSettlementDTOParam build() {
         return new SubOrderSettlementDTOParam(this.orderId, this.amount, this.boolDeduct, this.applyDate, this.attachmentIds, this.remark);
      }

      @Override
      public String toString() {
         return "SubOrderSettlementDTOParam.SubOrderSettlementDTOParamBuilder(orderId="
            + this.orderId
            + ", amount="
            + this.amount
            + ", boolDeduct="
            + this.boolDeduct
            + ", applyDate="
            + this.applyDate
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
