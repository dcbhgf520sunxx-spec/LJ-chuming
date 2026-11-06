package com.hzchum.scim.contract.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(description = "供应商付款明细表 ")
@Entity
@Table(name = "contract_supplier_payment_detail")
@TableName("contract_supplier_payment_detail")
public class SupplierPaymentDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("付款表id")
   @Column
   private Long supplierPaymentId;
   @ApiModelProperty("类型 1原材料采购运输费 2制成品发运运输费 4制成品采购运输费,8零星物流运输费")
   @Column
   private Integer type;
   @ApiModelProperty("关联采购订单id")
   @Column
   private Long purchaseId;
   @ApiModelProperty("制成品发运关联项目id")
   @Column
   private Long projectId;
   @ApiModelProperty("付款单位id")
   @Column
   private Long paymentUnitId;
   @ApiModelProperty("收款单位id")
   @Column
   private Long receivingUnitId;
   @ApiModelProperty("申请金额")
   @Column
   private BigDecimal applyAmount;
   @ApiModelProperty("实付金额")
   @Column
   private BigDecimal actuallyPaymentAmount;
   @ApiModelProperty("审核状态 1未审核 2通过 4被驳回")
   @Column
   private Integer auditStatus;

   public static SupplierPaymentDetail.SupplierPaymentDetailBuilder builder() {
      return new SupplierPaymentDetail.SupplierPaymentDetailBuilder();
   }

   public SupplierPaymentDetail() {
   }

   public SupplierPaymentDetail(
      final Long id,
      final Long supplierPaymentId,
      final Integer type,
      final Long purchaseId,
      final Long projectId,
      final Long paymentUnitId,
      final Long receivingUnitId,
      final BigDecimal applyAmount,
      final BigDecimal actuallyPaymentAmount,
      final Integer auditStatus
   ) {
      this.id = id;
      this.supplierPaymentId = supplierPaymentId;
      this.type = type;
      this.purchaseId = purchaseId;
      this.projectId = projectId;
      this.paymentUnitId = paymentUnitId;
      this.receivingUnitId = receivingUnitId;
      this.applyAmount = applyAmount;
      this.actuallyPaymentAmount = actuallyPaymentAmount;
      this.auditStatus = auditStatus;
   }

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

      if (!(o instanceof SupplierPaymentDetail)) {
         return false;
      }

      SupplierPaymentDetail other = (SupplierPaymentDetail)o;
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SupplierPaymentDetail;
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
      return "SupplierPaymentDetail(id="
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

   public static class SupplierPaymentDetailBuilder {
      private Long id;
      private Long supplierPaymentId;
      private Integer type;
      private Long purchaseId;
      private Long projectId;
      private Long paymentUnitId;
      private Long receivingUnitId;
      private BigDecimal applyAmount;
      private BigDecimal actuallyPaymentAmount;
      private Integer auditStatus;

      SupplierPaymentDetailBuilder() {
      }

      public SupplierPaymentDetail.SupplierPaymentDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierPaymentDetail.SupplierPaymentDetailBuilder supplierPaymentId(final Long supplierPaymentId) {
         this.supplierPaymentId = supplierPaymentId;
         return this;
      }

      public SupplierPaymentDetail.SupplierPaymentDetailBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SupplierPaymentDetail.SupplierPaymentDetailBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public SupplierPaymentDetail.SupplierPaymentDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SupplierPaymentDetail.SupplierPaymentDetailBuilder paymentUnitId(final Long paymentUnitId) {
         this.paymentUnitId = paymentUnitId;
         return this;
      }

      public SupplierPaymentDetail.SupplierPaymentDetailBuilder receivingUnitId(final Long receivingUnitId) {
         this.receivingUnitId = receivingUnitId;
         return this;
      }

      public SupplierPaymentDetail.SupplierPaymentDetailBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      public SupplierPaymentDetail.SupplierPaymentDetailBuilder actuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
         this.actuallyPaymentAmount = actuallyPaymentAmount;
         return this;
      }

      public SupplierPaymentDetail.SupplierPaymentDetailBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public SupplierPaymentDetail build() {
         return new SupplierPaymentDetail(
            this.id,
            this.supplierPaymentId,
            this.type,
            this.purchaseId,
            this.projectId,
            this.paymentUnitId,
            this.receivingUnitId,
            this.applyAmount,
            this.actuallyPaymentAmount,
            this.auditStatus
         );
      }

      @Override
      public String toString() {
         return "SupplierPaymentDetail.SupplierPaymentDetailBuilder(id="
            + this.id
            + ", supplierPaymentId="
            + this.supplierPaymentId
            + ", type="
            + this.type
            + ", purchaseId="
            + this.purchaseId
            + ", projectId="
            + this.projectId
            + ", paymentUnitId="
            + this.paymentUnitId
            + ", receivingUnitId="
            + this.receivingUnitId
            + ", applyAmount="
            + this.applyAmount
            + ", actuallyPaymentAmount="
            + this.actuallyPaymentAmount
            + ", auditStatus="
            + this.auditStatus
            + ")";
      }
   }
}
