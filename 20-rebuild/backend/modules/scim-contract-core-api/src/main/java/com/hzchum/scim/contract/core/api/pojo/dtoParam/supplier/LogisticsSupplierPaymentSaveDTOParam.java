package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("物流新增付款-请求类")
public class LogisticsSupplierPaymentSaveDTOParam {
   @ApiModelProperty("物流供应商id")
   @NotNull(message = "物流供应商id不能为空")
   private Long supplierId;
   @NotNull(message = "签约公司主体id不能为空")
   @ApiModelProperty("签约公司主体id")
   private Long branchCompanyId;
   @ApiModelProperty("申请总金额")
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
   private List<SupplierPaymentDetailSaveParam> detailSaveParams;

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
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

   public List<SupplierPaymentDetailSaveParam> getDetailSaveParams() {
      return this.detailSaveParams;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
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

   public void setDetailSaveParams(final List<SupplierPaymentDetailSaveParam> detailSaveParams) {
      this.detailSaveParams = detailSaveParams;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsSupplierPaymentSaveDTOParam)) {
         return false;
      }

      LogisticsSupplierPaymentSaveDTOParam other = (LogisticsSupplierPaymentSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierId = this.getSupplierId();
      Object other$supplierId = other.getSupplierId();
      if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
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
                           Object this$detailSaveParams = this.getDetailSaveParams();
                           Object other$detailSaveParams = other.getDetailSaveParams();
                           return this$detailSaveParams == null ? other$detailSaveParams == null : this$detailSaveParams.equals(other$detailSaveParams);
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
      return other instanceof LogisticsSupplierPaymentSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
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
      Object $detailSaveParams = this.getDetailSaveParams();
      return result * 59 + ($detailSaveParams == null ? 43 : $detailSaveParams.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsSupplierPaymentSaveDTOParam(supplierId="
         + this.getSupplierId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
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
         + ", detailSaveParams="
         + this.getDetailSaveParams()
         + ")";
   }
}
