package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel("物流付款明细新增类")
public class SupplierPaymentDetailSaveParam {
   @ApiModelProperty("类型 1原材料 2制成品 8零星物流")
   @NotNull(message = "付款详情类型不能为空")
   private Integer type;
   @ApiModelProperty("原材料运输关联订单id")
   private Long purchaseId;
   @ApiModelProperty("制成品运输关联项目id")
   private Long projectId;
   @ApiModelProperty("申请金额")
   @NotNull(message = "付款详情申请不能为空")
   private BigDecimal applyAmount;

   public Integer getType() {
      return this.type;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPaymentDetailSaveParam)) {
         return false;
      }

      SupplierPaymentDetailSaveParam other = (SupplierPaymentDetailSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$purchaseId = this.getPurchaseId();
         Object other$purchaseId = other.getPurchaseId();
         if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$applyAmount = this.getApplyAmount();
               Object other$applyAmount = other.getApplyAmount();
               return this$applyAmount == null ? other$applyAmount == null : this$applyAmount.equals(other$applyAmount);
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
      return other instanceof SupplierPaymentDetailSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $applyAmount = this.getApplyAmount();
      return result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierPaymentDetailSaveParam(type="
         + this.getType()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", projectId="
         + this.getProjectId()
         + ", applyAmount="
         + this.getApplyAmount()
         + ")";
   }
}
