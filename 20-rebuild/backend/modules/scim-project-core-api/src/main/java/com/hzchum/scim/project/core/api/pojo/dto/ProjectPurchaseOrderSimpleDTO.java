package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("外购合同简单信息")
public class ProjectPurchaseOrderSimpleDTO {
   private Long id;
   private Integer purchaseType;
   private Boolean BoolAnnual;
   private Integer supplyType;
   private Integer basicClass;
   private Integer materialType;
   private String serialNumber;
   private String serialNumberParent;
   private BigDecimal mete;
   private String meteUnit;
   private BigDecimal amount;
   private BigDecimal taxRate;
   private BigDecimal inboundTotalQuantity;
   private BigDecimal inboundTotalMete;
   private Integer invoiceType;
   private Integer purchaseStatus;
   private Integer settlementStatus;
   private String applyPurchaseStatus;
   private Integer reviewStatus;
   private Boolean boolDetail;
   private Integer dataStatus;
   private Integer projectAttribute;
   @ApiModelProperty(name = "receiveState", value = "工地外购收货状态")
   private Integer receiveState;
   private String projectName;
   private String supplierName;

   public static ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder builder() {
      return new ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder();
   }

   public ProjectPurchaseOrderSimpleDTO() {
   }

   public ProjectPurchaseOrderSimpleDTO(
      final Long id,
      final Integer purchaseType,
      final Boolean BoolAnnual,
      final Integer supplyType,
      final Integer basicClass,
      final Integer materialType,
      final String serialNumber,
      final String serialNumberParent,
      final BigDecimal mete,
      final String meteUnit,
      final BigDecimal amount,
      final BigDecimal taxRate,
      final BigDecimal inboundTotalQuantity,
      final BigDecimal inboundTotalMete,
      final Integer invoiceType,
      final Integer purchaseStatus,
      final Integer settlementStatus,
      final String applyPurchaseStatus,
      final Integer reviewStatus,
      final Boolean boolDetail,
      final Integer dataStatus,
      final Integer projectAttribute,
      final Integer receiveState,
      final String projectName,
      final String supplierName
   ) {
      this.id = id;
      this.purchaseType = purchaseType;
      this.BoolAnnual = BoolAnnual;
      this.supplyType = supplyType;
      this.basicClass = basicClass;
      this.materialType = materialType;
      this.serialNumber = serialNumber;
      this.serialNumberParent = serialNumberParent;
      this.mete = mete;
      this.meteUnit = meteUnit;
      this.amount = amount;
      this.taxRate = taxRate;
      this.inboundTotalQuantity = inboundTotalQuantity;
      this.inboundTotalMete = inboundTotalMete;
      this.invoiceType = invoiceType;
      this.purchaseStatus = purchaseStatus;
      this.settlementStatus = settlementStatus;
      this.applyPurchaseStatus = applyPurchaseStatus;
      this.reviewStatus = reviewStatus;
      this.boolDetail = boolDetail;
      this.dataStatus = dataStatus;
      this.projectAttribute = projectAttribute;
      this.receiveState = receiveState;
      this.projectName = projectName;
      this.supplierName = supplierName;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getPurchaseType() {
      return this.purchaseType;
   }

   public Boolean getBoolAnnual() {
      return this.BoolAnnual;
   }

   public Integer getSupplyType() {
      return this.supplyType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSerialNumberParent() {
      return this.serialNumberParent;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getMeteUnit() {
      return this.meteUnit;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getInboundTotalQuantity() {
      return this.inboundTotalQuantity;
   }

   public BigDecimal getInboundTotalMete() {
      return this.inboundTotalMete;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Integer getPurchaseStatus() {
      return this.purchaseStatus;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public String getApplyPurchaseStatus() {
      return this.applyPurchaseStatus;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Boolean getBoolDetail() {
      return this.boolDetail;
   }

   public Integer getDataStatus() {
      return this.dataStatus;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Integer getReceiveState() {
      return this.receiveState;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPurchaseType(final Integer purchaseType) {
      this.purchaseType = purchaseType;
   }

   public void setBoolAnnual(final Boolean BoolAnnual) {
      this.BoolAnnual = BoolAnnual;
   }

   public void setSupplyType(final Integer supplyType) {
      this.supplyType = supplyType;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSerialNumberParent(final String serialNumberParent) {
      this.serialNumberParent = serialNumberParent;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setMeteUnit(final String meteUnit) {
      this.meteUnit = meteUnit;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setInboundTotalQuantity(final BigDecimal inboundTotalQuantity) {
      this.inboundTotalQuantity = inboundTotalQuantity;
   }

   public void setInboundTotalMete(final BigDecimal inboundTotalMete) {
      this.inboundTotalMete = inboundTotalMete;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setPurchaseStatus(final Integer purchaseStatus) {
      this.purchaseStatus = purchaseStatus;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setApplyPurchaseStatus(final String applyPurchaseStatus) {
      this.applyPurchaseStatus = applyPurchaseStatus;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setBoolDetail(final Boolean boolDetail) {
      this.boolDetail = boolDetail;
   }

   public void setDataStatus(final Integer dataStatus) {
      this.dataStatus = dataStatus;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setReceiveState(final Integer receiveState) {
      this.receiveState = receiveState;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPurchaseOrderSimpleDTO)) {
         return false;
      }

      ProjectPurchaseOrderSimpleDTO other = (ProjectPurchaseOrderSimpleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseType = this.getPurchaseType();
         Object other$purchaseType = other.getPurchaseType();
         if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
            Object this$BoolAnnual = this.getBoolAnnual();
            Object other$BoolAnnual = other.getBoolAnnual();
            if (this$BoolAnnual == null ? other$BoolAnnual == null : this$BoolAnnual.equals(other$BoolAnnual)) {
               Object this$supplyType = this.getSupplyType();
               Object other$supplyType = other.getSupplyType();
               if (this$supplyType == null ? other$supplyType == null : this$supplyType.equals(other$supplyType)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$materialType = this.getMaterialType();
                     Object other$materialType = other.getMaterialType();
                     if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
                        Object this$invoiceType = this.getInvoiceType();
                        Object other$invoiceType = other.getInvoiceType();
                        if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                           Object this$purchaseStatus = this.getPurchaseStatus();
                           Object other$purchaseStatus = other.getPurchaseStatus();
                           if (this$purchaseStatus == null ? other$purchaseStatus == null : this$purchaseStatus.equals(other$purchaseStatus)) {
                              Object this$settlementStatus = this.getSettlementStatus();
                              Object other$settlementStatus = other.getSettlementStatus();
                              if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
                                 Object this$reviewStatus = this.getReviewStatus();
                                 Object other$reviewStatus = other.getReviewStatus();
                                 if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                                    Object this$boolDetail = this.getBoolDetail();
                                    Object other$boolDetail = other.getBoolDetail();
                                    if (this$boolDetail == null ? other$boolDetail == null : this$boolDetail.equals(other$boolDetail)) {
                                       Object this$dataStatus = this.getDataStatus();
                                       Object other$dataStatus = other.getDataStatus();
                                       if (this$dataStatus == null ? other$dataStatus == null : this$dataStatus.equals(other$dataStatus)) {
                                          Object this$projectAttribute = this.getProjectAttribute();
                                          Object other$projectAttribute = other.getProjectAttribute();
                                          if (this$projectAttribute == null
                                             ? other$projectAttribute == null
                                             : this$projectAttribute.equals(other$projectAttribute)) {
                                             Object this$receiveState = this.getReceiveState();
                                             Object other$receiveState = other.getReceiveState();
                                             if (this$receiveState == null ? other$receiveState == null : this$receiveState.equals(other$receiveState)) {
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$serialNumberParent = this.getSerialNumberParent();
                                                   Object other$serialNumberParent = other.getSerialNumberParent();
                                                   if (this$serialNumberParent == null
                                                      ? other$serialNumberParent == null
                                                      : this$serialNumberParent.equals(other$serialNumberParent)) {
                                                      Object this$mete = this.getMete();
                                                      Object other$mete = other.getMete();
                                                      if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                         Object this$meteUnit = this.getMeteUnit();
                                                         Object other$meteUnit = other.getMeteUnit();
                                                         if (this$meteUnit == null ? other$meteUnit == null : this$meteUnit.equals(other$meteUnit)) {
                                                            Object this$amount = this.getAmount();
                                                            Object other$amount = other.getAmount();
                                                            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                               Object this$taxRate = this.getTaxRate();
                                                               Object other$taxRate = other.getTaxRate();
                                                               if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                                  Object this$inboundTotalQuantity = this.getInboundTotalQuantity();
                                                                  Object other$inboundTotalQuantity = other.getInboundTotalQuantity();
                                                                  if (this$inboundTotalQuantity == null
                                                                     ? other$inboundTotalQuantity == null
                                                                     : this$inboundTotalQuantity.equals(other$inboundTotalQuantity)) {
                                                                     Object this$inboundTotalMete = this.getInboundTotalMete();
                                                                     Object other$inboundTotalMete = other.getInboundTotalMete();
                                                                     if (this$inboundTotalMete == null
                                                                        ? other$inboundTotalMete == null
                                                                        : this$inboundTotalMete.equals(other$inboundTotalMete)) {
                                                                        Object this$applyPurchaseStatus = this.getApplyPurchaseStatus();
                                                                        Object other$applyPurchaseStatus = other.getApplyPurchaseStatus();
                                                                        if (this$applyPurchaseStatus == null
                                                                           ? other$applyPurchaseStatus == null
                                                                           : this$applyPurchaseStatus.equals(other$applyPurchaseStatus)) {
                                                                           Object this$projectName = this.getProjectName();
                                                                           Object other$projectName = other.getProjectName();
                                                                           if (this$projectName == null
                                                                              ? other$projectName == null
                                                                              : this$projectName.equals(other$projectName)) {
                                                                              Object this$supplierName = this.getSupplierName();
                                                                              Object other$supplierName = other.getSupplierName();
                                                                              return this$supplierName == null
                                                                                 ? other$supplierName == null
                                                                                 : this$supplierName.equals(other$supplierName);
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
      return other instanceof ProjectPurchaseOrderSimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $BoolAnnual = this.getBoolAnnual();
      result = result * 59 + ($BoolAnnual == null ? 43 : $BoolAnnual.hashCode());
      Object $supplyType = this.getSupplyType();
      result = result * 59 + ($supplyType == null ? 43 : $supplyType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $purchaseStatus = this.getPurchaseStatus();
      result = result * 59 + ($purchaseStatus == null ? 43 : $purchaseStatus.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $boolDetail = this.getBoolDetail();
      result = result * 59 + ($boolDetail == null ? 43 : $boolDetail.hashCode());
      Object $dataStatus = this.getDataStatus();
      result = result * 59 + ($dataStatus == null ? 43 : $dataStatus.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $receiveState = this.getReceiveState();
      result = result * 59 + ($receiveState == null ? 43 : $receiveState.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $serialNumberParent = this.getSerialNumberParent();
      result = result * 59 + ($serialNumberParent == null ? 43 : $serialNumberParent.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $meteUnit = this.getMeteUnit();
      result = result * 59 + ($meteUnit == null ? 43 : $meteUnit.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $inboundTotalQuantity = this.getInboundTotalQuantity();
      result = result * 59 + ($inboundTotalQuantity == null ? 43 : $inboundTotalQuantity.hashCode());
      Object $inboundTotalMete = this.getInboundTotalMete();
      result = result * 59 + ($inboundTotalMete == null ? 43 : $inboundTotalMete.hashCode());
      Object $applyPurchaseStatus = this.getApplyPurchaseStatus();
      result = result * 59 + ($applyPurchaseStatus == null ? 43 : $applyPurchaseStatus.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $supplierName = this.getSupplierName();
      return result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPurchaseOrderSimpleDTO(id="
         + this.getId()
         + ", purchaseType="
         + this.getPurchaseType()
         + ", BoolAnnual="
         + this.getBoolAnnual()
         + ", supplyType="
         + this.getSupplyType()
         + ", basicClass="
         + this.getBasicClass()
         + ", materialType="
         + this.getMaterialType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", serialNumberParent="
         + this.getSerialNumberParent()
         + ", mete="
         + this.getMete()
         + ", meteUnit="
         + this.getMeteUnit()
         + ", amount="
         + this.getAmount()
         + ", taxRate="
         + this.getTaxRate()
         + ", inboundTotalQuantity="
         + this.getInboundTotalQuantity()
         + ", inboundTotalMete="
         + this.getInboundTotalMete()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", purchaseStatus="
         + this.getPurchaseStatus()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", applyPurchaseStatus="
         + this.getApplyPurchaseStatus()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", boolDetail="
         + this.getBoolDetail()
         + ", dataStatus="
         + this.getDataStatus()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", receiveState="
         + this.getReceiveState()
         + ", projectName="
         + this.getProjectName()
         + ", supplierName="
         + this.getSupplierName()
         + ")";
   }

   public static class ProjectPurchaseOrderSimpleDTOBuilder {
      private Long id;
      private Integer purchaseType;
      private Boolean BoolAnnual;
      private Integer supplyType;
      private Integer basicClass;
      private Integer materialType;
      private String serialNumber;
      private String serialNumberParent;
      private BigDecimal mete;
      private String meteUnit;
      private BigDecimal amount;
      private BigDecimal taxRate;
      private BigDecimal inboundTotalQuantity;
      private BigDecimal inboundTotalMete;
      private Integer invoiceType;
      private Integer purchaseStatus;
      private Integer settlementStatus;
      private String applyPurchaseStatus;
      private Integer reviewStatus;
      private Boolean boolDetail;
      private Integer dataStatus;
      private Integer projectAttribute;
      private Integer receiveState;
      private String projectName;
      private String supplierName;

      ProjectPurchaseOrderSimpleDTOBuilder() {
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder purchaseType(final Integer purchaseType) {
         this.purchaseType = purchaseType;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder BoolAnnual(final Boolean BoolAnnual) {
         this.BoolAnnual = BoolAnnual;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder supplyType(final Integer supplyType) {
         this.supplyType = supplyType;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder serialNumberParent(final String serialNumberParent) {
         this.serialNumberParent = serialNumberParent;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder meteUnit(final String meteUnit) {
         this.meteUnit = meteUnit;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder inboundTotalQuantity(final BigDecimal inboundTotalQuantity) {
         this.inboundTotalQuantity = inboundTotalQuantity;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder inboundTotalMete(final BigDecimal inboundTotalMete) {
         this.inboundTotalMete = inboundTotalMete;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder purchaseStatus(final Integer purchaseStatus) {
         this.purchaseStatus = purchaseStatus;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder applyPurchaseStatus(final String applyPurchaseStatus) {
         this.applyPurchaseStatus = applyPurchaseStatus;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder boolDetail(final Boolean boolDetail) {
         this.boolDetail = boolDetail;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder dataStatus(final Integer dataStatus) {
         this.dataStatus = dataStatus;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder receiveState(final Integer receiveState) {
         this.receiveState = receiveState;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectPurchaseOrderSimpleDTO build() {
         return new ProjectPurchaseOrderSimpleDTO(
            this.id,
            this.purchaseType,
            this.BoolAnnual,
            this.supplyType,
            this.basicClass,
            this.materialType,
            this.serialNumber,
            this.serialNumberParent,
            this.mete,
            this.meteUnit,
            this.amount,
            this.taxRate,
            this.inboundTotalQuantity,
            this.inboundTotalMete,
            this.invoiceType,
            this.purchaseStatus,
            this.settlementStatus,
            this.applyPurchaseStatus,
            this.reviewStatus,
            this.boolDetail,
            this.dataStatus,
            this.projectAttribute,
            this.receiveState,
            this.projectName,
            this.supplierName
         );
      }

      @Override
      public String toString() {
         return "ProjectPurchaseOrderSimpleDTO.ProjectPurchaseOrderSimpleDTOBuilder(id="
            + this.id
            + ", purchaseType="
            + this.purchaseType
            + ", BoolAnnual="
            + this.BoolAnnual
            + ", supplyType="
            + this.supplyType
            + ", basicClass="
            + this.basicClass
            + ", materialType="
            + this.materialType
            + ", serialNumber="
            + this.serialNumber
            + ", serialNumberParent="
            + this.serialNumberParent
            + ", mete="
            + this.mete
            + ", meteUnit="
            + this.meteUnit
            + ", amount="
            + this.amount
            + ", taxRate="
            + this.taxRate
            + ", inboundTotalQuantity="
            + this.inboundTotalQuantity
            + ", inboundTotalMete="
            + this.inboundTotalMete
            + ", invoiceType="
            + this.invoiceType
            + ", purchaseStatus="
            + this.purchaseStatus
            + ", settlementStatus="
            + this.settlementStatus
            + ", applyPurchaseStatus="
            + this.applyPurchaseStatus
            + ", reviewStatus="
            + this.reviewStatus
            + ", boolDetail="
            + this.boolDetail
            + ", dataStatus="
            + this.dataStatus
            + ", projectAttribute="
            + this.projectAttribute
            + ", receiveState="
            + this.receiveState
            + ", projectName="
            + this.projectName
            + ", supplierName="
            + this.supplierName
            + ")";
      }
   }
}
