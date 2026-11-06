package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("结算填报")
public class SubOrderSettlementAddParam {
   @ApiModelProperty("申请日期")
   @NotNull(message = "申请日期不能为空")
   private LocalDateTime createTime;
   @ApiModelProperty("创建人不能为空!")
   private Long userId;
   @ApiModelProperty("分包合同id")
   @NotNull(message = "分包合同id不能为空")
   private Long orderId;
   @NotNull(message = "结算额不能为空")
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @NotNull(message = "附件id列表")
   private List<Long> attachmentId;
   @ApiModelProperty("备注")
   @Size(max = 255, message = "备注字数超出限制!")
   private String remark;

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public List<Long> getAttachmentId() {
      return this.attachmentId;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setAttachmentId(final List<Long> attachmentId) {
      this.attachmentId = attachmentId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubOrderSettlementAddParam)) {
         return false;
      }

      SubOrderSettlementAddParam other = (SubOrderSettlementAddParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

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
                  Object this$attachmentId = this.getAttachmentId();
                  Object other$attachmentId = other.getAttachmentId();
                  if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
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
      return other instanceof SubOrderSettlementAddParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "SubOrderSettlementAddParam(createTime="
         + this.getCreateTime()
         + ", userId="
         + this.getUserId()
         + ", orderId="
         + this.getOrderId()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
