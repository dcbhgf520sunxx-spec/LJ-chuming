package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel("物流付款明细修改类")
public class SupplierPaymentDetailUpdateParam {
   @ApiModelProperty("付款详情id")
   @NotNull(message = "物流付款详情id不能为空")
   private Long id;
   @ApiModelProperty("付款表id")
   private Long supplierPaymentId;
   @ApiModelProperty("类型 1原材料 2制成品")
   private Integer type;
   @ApiModelProperty("采购品运输关联订单id")
   private Long purchaseId;
   @ApiModelProperty("制成品运输关联项目id")
   private Long projectId;
   @ApiModelProperty("付款单位id")
   private Long paymentUnitId;
   @ApiModelProperty("收款单位id")
   private Long receivingUnitId;
   @ApiModelProperty("申请付款金额")
   private BigDecimal applyAmount;
   @ApiModelProperty("实付金额")
   private BigDecimal actuallyPaymentAmount;
   @ApiModelProperty("审核状态 1未审核 2通过 4被驳回")
   private Integer auditStatus;

   public Long getId() {
      return this.id;
   }

   public Long getSupplierPaymentId() {
      return this.supplierPaymentId;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getPaymentUnitId() {
      return this.paymentUnitId;
   }

   public Long getReceivingUnitId() {
      return this.receivingUnitId;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public BigDecimal getActuallyPaymentAmount() {
      return this.actuallyPaymentAmount;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSupplierPaymentId(final Long supplierPaymentId) {
      this.supplierPaymentId = supplierPaymentId;
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

   public void setPaymentUnitId(final Long paymentUnitId) {
      this.paymentUnitId = paymentUnitId;
   }

   public void setReceivingUnitId(final Long receivingUnitId) {
      this.receivingUnitId = receivingUnitId;
   }

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
   }

   public void setActuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
      this.actuallyPaymentAmount = actuallyPaymentAmount;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPaymentDetailUpdateParam)) {
         return false;
      }

      SupplierPaymentDetailUpdateParam other = (SupplierPaymentDetailUpdateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierPaymentId = this.getSupplierPaymentId();
         Object other$supplierPaymentId = other.getSupplierPaymentId();
         if (this$supplierPaymentId == null ? other$supplierPaymentId == null : this$supplierPaymentId.equals(other$supplierPaymentId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$purchaseId = this.getPurchaseId();
               Object other$purchaseId = other.getPurchaseId();
               if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$paymentUnitId = this.getPaymentUnitId();
                     Object other$paymentUnitId = other.getPaymentUnitId();
                     if (this$paymentUnitId == null ? other$paymentUnitId == null : this$paymentUnitId.equals(other$paymentUnitId)) {
                        Object this$receivingUnitId = this.getReceivingUnitId();
                        Object other$receivingUnitId = other.getReceivingUnitId();
                        if (this$receivingUnitId == null ? other$receivingUnitId == null : this$receivingUnitId.equals(other$receivingUnitId)) {
                           Object this$auditStatus = this.getAuditStatus();
                           Object other$auditStatus = other.getAuditStatus();
                           if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                              Object this$applyAmount = this.getApplyAmount();
                              Object other$applyAmount = other.getApplyAmount();
                              if (this$applyAmount == null ? other$applyAmount == null : this$applyAmount.equals(other$applyAmount)) {
                                 Object this$actuallyPaymentAmount = this.getActuallyPaymentAmount();
                                 Object other$actuallyPaymentAmount = other.getActuallyPaymentAmount();
                                 return this$actuallyPaymentAmount == null
                                    ? other$actuallyPaymentAmount == null
                                    : this$actuallyPaymentAmount.equals(other$actuallyPaymentAmount);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierPaymentDetailUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierPaymentId = this.getSupplierPaymentId();
      result = result * 59 + ($supplierPaymentId == null ? 43 : $supplierPaymentId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $paymentUnitId = this.getPaymentUnitId();
      result = result * 59 + ($paymentUnitId == null ? 43 : $paymentUnitId.hashCode());
      Object $receivingUnitId = this.getReceivingUnitId();
      result = result * 59 + ($receivingUnitId == null ? 43 : $receivingUnitId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $actuallyPaymentAmount = this.getActuallyPaymentAmount();
      return result * 59 + ($actuallyPaymentAmount == null ? 43 : $actuallyPaymentAmount.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierPaymentDetailUpdateParam(id="
         + this.getId()
         + ", supplierPaymentId="
         + this.getSupplierPaymentId()
         + ", type="
         + this.getType()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", projectId="
         + this.getProjectId()
         + ", paymentUnitId="
         + this.getPaymentUnitId()
         + ", receivingUnitId="
         + this.getReceivingUnitId()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", actuallyPaymentAmount="
         + this.getActuallyPaymentAmount()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }
}
