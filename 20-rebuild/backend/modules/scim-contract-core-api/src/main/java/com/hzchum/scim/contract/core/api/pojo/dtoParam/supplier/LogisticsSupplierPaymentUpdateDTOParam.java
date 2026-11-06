package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("修改物流付款-请求类")
public class LogisticsSupplierPaymentUpdateDTOParam {
   @ApiModelProperty("付款记录id")
   @NotNull(message = "付款记录id不能为空")
   private Long id;
   @ApiModelProperty("物流供应商id")
   @NotNull(message = "物流供应商id不能为空")
   private Long receivingUnitId;
   @NotNull(message = "付款单位id不能为空")
   @ApiModelProperty("付款单位id")
   private Long paymentUnitId;
   @ApiModelProperty("申请金额")
   @NotNull(message = "申请金额不能为空")
   private BigDecimal applyAmount;
   @ApiModelProperty("付款事由id")
   private String paymentReasonId;
   @ApiModelProperty("付款日期")
   private LocalDate paymentDate;
   @ApiModelProperty("附件ids")
   private List<Long> attachmentIds;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("物流付款详情列表")
   @Valid
   @NotEmpty(message = "物流付款详情列表不能为空")
   private List<SupplierPaymentDetailUpdateParam> paymentDetails;

   public Long getId() {
      return this.id;
   }

   public Long getReceivingUnitId() {
      return this.receivingUnitId;
   }

   public Long getPaymentUnitId() {
      return this.paymentUnitId;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
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

   public List<SupplierPaymentDetailUpdateParam> getPaymentDetails() {
      return this.paymentDetails;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setReceivingUnitId(final Long receivingUnitId) {
      this.receivingUnitId = receivingUnitId;
   }

   public void setPaymentUnitId(final Long paymentUnitId) {
      this.paymentUnitId = paymentUnitId;
   }

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
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

   public void setPaymentDetails(final List<SupplierPaymentDetailUpdateParam> paymentDetails) {
      this.paymentDetails = paymentDetails;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsSupplierPaymentUpdateDTOParam)) {
         return false;
      }

      LogisticsSupplierPaymentUpdateDTOParam other = (LogisticsSupplierPaymentUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$receivingUnitId = this.getReceivingUnitId();
         Object other$receivingUnitId = other.getReceivingUnitId();
         if (this$receivingUnitId == null ? other$receivingUnitId == null : this$receivingUnitId.equals(other$receivingUnitId)) {
            Object this$paymentUnitId = this.getPaymentUnitId();
            Object other$paymentUnitId = other.getPaymentUnitId();
            if (this$paymentUnitId == null ? other$paymentUnitId == null : this$paymentUnitId.equals(other$paymentUnitId)) {
               Object this$applyAmount = this.getApplyAmount();
               Object other$applyAmount = other.getApplyAmount();
               if (this$applyAmount == null ? other$applyAmount == null : this$applyAmount.equals(other$applyAmount)) {
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
                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                              Object this$paymentDetails = this.getPaymentDetails();
                              Object other$paymentDetails = other.getPaymentDetails();
                              return this$paymentDetails == null ? other$paymentDetails == null : this$paymentDetails.equals(other$paymentDetails);
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
      return other instanceof LogisticsSupplierPaymentUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $receivingUnitId = this.getReceivingUnitId();
      result = result * 59 + ($receivingUnitId == null ? 43 : $receivingUnitId.hashCode());
      Object $paymentUnitId = this.getPaymentUnitId();
      result = result * 59 + ($paymentUnitId == null ? 43 : $paymentUnitId.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $paymentReasonId = this.getPaymentReasonId();
      result = result * 59 + ($paymentReasonId == null ? 43 : $paymentReasonId.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $paymentDetails = this.getPaymentDetails();
      return result * 59 + ($paymentDetails == null ? 43 : $paymentDetails.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsSupplierPaymentUpdateDTOParam(id="
         + this.getId()
         + ", receivingUnitId="
         + this.getReceivingUnitId()
         + ", paymentUnitId="
         + this.getPaymentUnitId()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", paymentReasonId="
         + this.getPaymentReasonId()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", paymentDetails="
         + this.getPaymentDetails()
         + ")";
   }
}
