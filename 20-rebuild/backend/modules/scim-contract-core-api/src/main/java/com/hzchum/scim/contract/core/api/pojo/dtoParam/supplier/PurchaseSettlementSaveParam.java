package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.Size;

public class PurchaseSettlementSaveParam {
   @ApiModelProperty("是否预结算")
   private Boolean boolPreSettlement;
   @ApiModelProperty("发起人id")
   private Long userId;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty("采购合同id(采购单id)")
   private Long orderId;
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("附件id列表")
   @Size(max = 10, message = "附件数量超出限制(10个)!")
   private List<Long> attachmentId;

   public Boolean getBoolPreSettlement() {
      return this.boolPreSettlement;
   }

   public Long getUserId() {
      return this.userId;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<Long> getAttachmentId() {
      return this.attachmentId;
   }

   public void setBoolPreSettlement(final Boolean boolPreSettlement) {
      this.boolPreSettlement = boolPreSettlement;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAttachmentId(final List<Long> attachmentId) {
      this.attachmentId = attachmentId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseSettlementSaveParam)) {
         return false;
      }

      PurchaseSettlementSaveParam other = (PurchaseSettlementSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolPreSettlement = this.getBoolPreSettlement();
      Object other$boolPreSettlement = other.getBoolPreSettlement();
      if (this$boolPreSettlement == null ? other$boolPreSettlement == null : this$boolPreSettlement.equals(other$boolPreSettlement)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$orderId = this.getOrderId();
            Object other$orderId = other.getOrderId();
            if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
               Object this$createTime = this.getCreateTime();
               Object other$createTime = other.getCreateTime();
               if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                  Object this$settlementAmount = this.getSettlementAmount();
                  Object other$settlementAmount = other.getSettlementAmount();
                  if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                        Object this$attachmentId = this.getAttachmentId();
                        Object other$attachmentId = other.getAttachmentId();
                        return this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId);
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
      return other instanceof PurchaseSettlementSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolPreSettlement = this.getBoolPreSettlement();
      result = result * 59 + ($boolPreSettlement == null ? 43 : $boolPreSettlement.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentId = this.getAttachmentId();
      return result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseSettlementSaveParam(boolPreSettlement="
         + this.getBoolPreSettlement()
         + ", userId="
         + this.getUserId()
         + ", createTime="
         + this.getCreateTime()
         + ", orderId="
         + this.getOrderId()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", remark="
         + this.getRemark()
         + ", attachmentId="
         + this.getAttachmentId()
         + ")";
   }

   public PurchaseSettlementSaveParam() {
   }

   public PurchaseSettlementSaveParam(
      final Boolean boolPreSettlement,
      final Long userId,
      final LocalDateTime createTime,
      final Long orderId,
      final BigDecimal settlementAmount,
      final String remark,
      final List<Long> attachmentId
   ) {
      this.boolPreSettlement = boolPreSettlement;
      this.userId = userId;
      this.createTime = createTime;
      this.orderId = orderId;
      this.settlementAmount = settlementAmount;
      this.remark = remark;
      this.attachmentId = attachmentId;
   }
}
