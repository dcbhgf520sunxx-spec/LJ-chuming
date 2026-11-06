package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "物流供应商付款明细表 ")
public class SupplierPaymentDetailDTO {
   @ApiModelProperty("主键ID")
   private Long id;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("采购品运输关联订单id")
   private Long purchaseId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "serialNumber", value = "采购单号")
   private String serialNumber;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("制成品运输关联项目id")
   private Long projectId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("制成品运输关联项目名称")
   private String projectName;
   @ApiModelProperty("付款表id")
   private Long supplierPaymentId;
   @ApiModelProperty("类型 1原材料运输 2制成品运输")
   private Integer type;
   @ApiModelProperty("付款单位id")
   private Long paymentUnitId;
   @ApiModelProperty("收款单位id")
   private Long receivingUnitId;
   @ApiModelProperty("运费总额")
   private BigDecimal freight;
   @ApiModelProperty("已付金额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("申请金额")
   private BigDecimal applyAmount;
   @ApiModelProperty("实付金额")
   private BigDecimal actuallyPaymentAmount;
   @ApiModelProperty("审核状态 1未审核 2通过 4被驳回")
   private Integer auditStatus;

   public static SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder builder() {
      return new SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder();
   }

   public SupplierPaymentDetailDTO() {
   }

   public SupplierPaymentDetailDTO(
      final Long id,
      final Long purchaseId,
      final String serialNumber,
      final Long projectId,
      final String projectName,
      final Long supplierPaymentId,
      final Integer type,
      final Long paymentUnitId,
      final Long receivingUnitId,
      final BigDecimal freight,
      final BigDecimal paymentAmount,
      final BigDecimal applyAmount,
      final BigDecimal actuallyPaymentAmount,
      final Integer auditStatus
   ) {
      this.id = id;
      this.purchaseId = purchaseId;
      this.serialNumber = serialNumber;
      this.projectId = projectId;
      this.projectName = projectName;
      this.supplierPaymentId = supplierPaymentId;
      this.type = type;
      this.paymentUnitId = paymentUnitId;
      this.receivingUnitId = receivingUnitId;
      this.freight = freight;
      this.paymentAmount = paymentAmount;
      this.applyAmount = applyAmount;
      this.actuallyPaymentAmount = actuallyPaymentAmount;
      this.auditStatus = auditStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getSupplierPaymentId() {
      return this.supplierPaymentId;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getPaymentUnitId() {
      return this.paymentUnitId;
   }

   public Long getReceivingUnitId() {
      return this.receivingUnitId;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
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

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setSupplierPaymentId(final Long supplierPaymentId) {
      this.supplierPaymentId = supplierPaymentId;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setPaymentUnitId(final Long paymentUnitId) {
      this.paymentUnitId = paymentUnitId;
   }

   public void setReceivingUnitId(final Long receivingUnitId) {
      this.receivingUnitId = receivingUnitId;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
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

      if (!(o instanceof SupplierPaymentDetailDTO)) {
         return false;
      }

      SupplierPaymentDetailDTO other = (SupplierPaymentDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseId = this.getPurchaseId();
         Object other$purchaseId = other.getPurchaseId();
         if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$supplierPaymentId = this.getSupplierPaymentId();
               Object other$supplierPaymentId = other.getSupplierPaymentId();
               if (this$supplierPaymentId == null ? other$supplierPaymentId == null : this$supplierPaymentId.equals(other$supplierPaymentId)) {
                  Object this$type = this.getType();
                  Object other$type = other.getType();
                  if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                     Object this$paymentUnitId = this.getPaymentUnitId();
                     Object other$paymentUnitId = other.getPaymentUnitId();
                     if (this$paymentUnitId == null ? other$paymentUnitId == null : this$paymentUnitId.equals(other$paymentUnitId)) {
                        Object this$receivingUnitId = this.getReceivingUnitId();
                        Object other$receivingUnitId = other.getReceivingUnitId();
                        if (this$receivingUnitId == null ? other$receivingUnitId == null : this$receivingUnitId.equals(other$receivingUnitId)) {
                           Object this$auditStatus = this.getAuditStatus();
                           Object other$auditStatus = other.getAuditStatus();
                           if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$projectName = this.getProjectName();
                                 Object other$projectName = other.getProjectName();
                                 if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                    Object this$freight = this.getFreight();
                                    Object other$freight = other.getFreight();
                                    if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                                       Object this$paymentAmount = this.getPaymentAmount();
                                       Object other$paymentAmount = other.getPaymentAmount();
                                       if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
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
      return other instanceof SupplierPaymentDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierPaymentId = this.getSupplierPaymentId();
      result = result * 59 + ($supplierPaymentId == null ? 43 : $supplierPaymentId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $paymentUnitId = this.getPaymentUnitId();
      result = result * 59 + ($paymentUnitId == null ? 43 : $paymentUnitId.hashCode());
      Object $receivingUnitId = this.getReceivingUnitId();
      result = result * 59 + ($receivingUnitId == null ? 43 : $receivingUnitId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $actuallyPaymentAmount = this.getActuallyPaymentAmount();
      return result * 59 + ($actuallyPaymentAmount == null ? 43 : $actuallyPaymentAmount.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierPaymentDetailDTO(id="
         + this.getId()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", supplierPaymentId="
         + this.getSupplierPaymentId()
         + ", type="
         + this.getType()
         + ", paymentUnitId="
         + this.getPaymentUnitId()
         + ", receivingUnitId="
         + this.getReceivingUnitId()
         + ", freight="
         + this.getFreight()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", actuallyPaymentAmount="
         + this.getActuallyPaymentAmount()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }

   public static class SupplierPaymentDetailDTOBuilder {
      private Long id;
      private Long purchaseId;
      private String serialNumber;
      private Long projectId;
      private String projectName;
      private Long supplierPaymentId;
      private Integer type;
      private Long paymentUnitId;
      private Long receivingUnitId;
      private BigDecimal freight;
      private BigDecimal paymentAmount;
      private BigDecimal applyAmount;
      private BigDecimal actuallyPaymentAmount;
      private Integer auditStatus;

      SupplierPaymentDetailDTOBuilder() {
      }

      public SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder supplierPaymentId(final Long supplierPaymentId) {
         this.supplierPaymentId = supplierPaymentId;
         return this;
      }

      public SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder paymentUnitId(final Long paymentUnitId) {
         this.paymentUnitId = paymentUnitId;
         return this;
      }

      public SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder receivingUnitId(final Long receivingUnitId) {
         this.receivingUnitId = receivingUnitId;
         return this;
      }

      public SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder freight(final BigDecimal freight) {
         this.freight = freight;
         return this;
      }

      public SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      public SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder actuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
         this.actuallyPaymentAmount = actuallyPaymentAmount;
         return this;
      }

      public SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public SupplierPaymentDetailDTO build() {
         return new SupplierPaymentDetailDTO(
            this.id,
            this.purchaseId,
            this.serialNumber,
            this.projectId,
            this.projectName,
            this.supplierPaymentId,
            this.type,
            this.paymentUnitId,
            this.receivingUnitId,
            this.freight,
            this.paymentAmount,
            this.applyAmount,
            this.actuallyPaymentAmount,
            this.auditStatus
         );
      }

      @Override
      public String toString() {
         return "SupplierPaymentDetailDTO.SupplierPaymentDetailDTOBuilder(id="
            + this.id
            + ", purchaseId="
            + this.purchaseId
            + ", serialNumber="
            + this.serialNumber
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", supplierPaymentId="
            + this.supplierPaymentId
            + ", type="
            + this.type
            + ", paymentUnitId="
            + this.paymentUnitId
            + ", receivingUnitId="
            + this.receivingUnitId
            + ", freight="
            + this.freight
            + ", paymentAmount="
            + this.paymentAmount
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
