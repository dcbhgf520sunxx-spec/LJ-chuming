package com.hzchum.scim.scm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class BriefPurchaseOrderNewDTO {
   private Long id;
   private Integer purchaseType;
   private Boolean BoolAnnual;
   private Integer supplyType;
   private Integer basicClass;
   private Integer materialType;
   private String serialNumber;
   private String serialNumberParent;
   private List<ProjectInfo> projects;
   private Integer logisticsTransportType;
   private Integer logisticsPayerType;
   private Integer purchaseOrderPaymentMode;
   private Integer weightMeasurementMode;
   private List<BriefIdAndSNDTO> applyPurchase;
   private List<Long> auxMaterialIds;
   private List<Long> otherMaterialIds;
   private List<Long> gasMaterialIds;
   private BigDecimal mete;
   private String meteUnit;
   private BigDecimal amount;
   private BriefIdAndNameDTO branchCompany;
   private BriefIdAndNameDTO supplier;
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
   @ApiModelProperty("构件制品计价方式 WmsWageQuotaTypeEnum")
   private Integer artifactWageQuotaType;
   @ApiModelProperty("围护制品计价方式 WmsWageQuotaTypeEnum")
   private Integer enclosureWageQuotaType;
   private LocalDateTime createTime;

   public static BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder builder() {
      return new BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder();
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

   public List<ProjectInfo> getProjects() {
      return this.projects;
   }

   public Integer getLogisticsTransportType() {
      return this.logisticsTransportType;
   }

   public Integer getLogisticsPayerType() {
      return this.logisticsPayerType;
   }

   public Integer getPurchaseOrderPaymentMode() {
      return this.purchaseOrderPaymentMode;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public List<BriefIdAndSNDTO> getApplyPurchase() {
      return this.applyPurchase;
   }

   public List<Long> getAuxMaterialIds() {
      return this.auxMaterialIds;
   }

   public List<Long> getOtherMaterialIds() {
      return this.otherMaterialIds;
   }

   public List<Long> getGasMaterialIds() {
      return this.gasMaterialIds;
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

   public BriefIdAndNameDTO getBranchCompany() {
      return this.branchCompany;
   }

   public BriefIdAndNameDTO getSupplier() {
      return this.supplier;
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

   public Integer getArtifactWageQuotaType() {
      return this.artifactWageQuotaType;
   }

   public Integer getEnclosureWageQuotaType() {
      return this.enclosureWageQuotaType;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
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

   public void setProjects(final List<ProjectInfo> projects) {
      this.projects = projects;
   }

   public void setLogisticsTransportType(final Integer logisticsTransportType) {
      this.logisticsTransportType = logisticsTransportType;
   }

   public void setLogisticsPayerType(final Integer logisticsPayerType) {
      this.logisticsPayerType = logisticsPayerType;
   }

   public void setPurchaseOrderPaymentMode(final Integer purchaseOrderPaymentMode) {
      this.purchaseOrderPaymentMode = purchaseOrderPaymentMode;
   }

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   public void setApplyPurchase(final List<BriefIdAndSNDTO> applyPurchase) {
      this.applyPurchase = applyPurchase;
   }

   public void setAuxMaterialIds(final List<Long> auxMaterialIds) {
      this.auxMaterialIds = auxMaterialIds;
   }

   public void setOtherMaterialIds(final List<Long> otherMaterialIds) {
      this.otherMaterialIds = otherMaterialIds;
   }

   public void setGasMaterialIds(final List<Long> gasMaterialIds) {
      this.gasMaterialIds = gasMaterialIds;
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

   public void setBranchCompany(final BriefIdAndNameDTO branchCompany) {
      this.branchCompany = branchCompany;
   }

   public void setSupplier(final BriefIdAndNameDTO supplier) {
      this.supplier = supplier;
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

   public void setArtifactWageQuotaType(final Integer artifactWageQuotaType) {
      this.artifactWageQuotaType = artifactWageQuotaType;
   }

   public void setEnclosureWageQuotaType(final Integer enclosureWageQuotaType) {
      this.enclosureWageQuotaType = enclosureWageQuotaType;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BriefPurchaseOrderNewDTO)) {
         return false;
      }

      BriefPurchaseOrderNewDTO other = (BriefPurchaseOrderNewDTO)o;
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
                        Object this$logisticsTransportType = this.getLogisticsTransportType();
                        Object other$logisticsTransportType = other.getLogisticsTransportType();
                        if (this$logisticsTransportType == null
                           ? other$logisticsTransportType == null
                           : this$logisticsTransportType.equals(other$logisticsTransportType)) {
                           Object this$logisticsPayerType = this.getLogisticsPayerType();
                           Object other$logisticsPayerType = other.getLogisticsPayerType();
                           if (this$logisticsPayerType == null ? other$logisticsPayerType == null : this$logisticsPayerType.equals(other$logisticsPayerType)) {
                              Object this$purchaseOrderPaymentMode = this.getPurchaseOrderPaymentMode();
                              Object other$purchaseOrderPaymentMode = other.getPurchaseOrderPaymentMode();
                              if (this$purchaseOrderPaymentMode == null
                                 ? other$purchaseOrderPaymentMode == null
                                 : this$purchaseOrderPaymentMode.equals(other$purchaseOrderPaymentMode)) {
                                 Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                 Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                 if (this$weightMeasurementMode == null
                                    ? other$weightMeasurementMode == null
                                    : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                    Object this$invoiceType = this.getInvoiceType();
                                    Object other$invoiceType = other.getInvoiceType();
                                    if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                       Object this$purchaseStatus = this.getPurchaseStatus();
                                       Object other$purchaseStatus = other.getPurchaseStatus();
                                       if (this$purchaseStatus == null ? other$purchaseStatus == null : this$purchaseStatus.equals(other$purchaseStatus)) {
                                          Object this$settlementStatus = this.getSettlementStatus();
                                          Object other$settlementStatus = other.getSettlementStatus();
                                          if (this$settlementStatus == null
                                             ? other$settlementStatus == null
                                             : this$settlementStatus.equals(other$settlementStatus)) {
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
                                                         Object this$artifactWageQuotaType = this.getArtifactWageQuotaType();
                                                         Object other$artifactWageQuotaType = other.getArtifactWageQuotaType();
                                                         if (this$artifactWageQuotaType == null
                                                            ? other$artifactWageQuotaType == null
                                                            : this$artifactWageQuotaType.equals(other$artifactWageQuotaType)) {
                                                            Object this$enclosureWageQuotaType = this.getEnclosureWageQuotaType();
                                                            Object other$enclosureWageQuotaType = other.getEnclosureWageQuotaType();
                                                            if (this$enclosureWageQuotaType == null
                                                               ? other$enclosureWageQuotaType == null
                                                               : this$enclosureWageQuotaType.equals(other$enclosureWageQuotaType)) {
                                                               Object this$serialNumber = this.getSerialNumber();
                                                               Object other$serialNumber = other.getSerialNumber();
                                                               if (this$serialNumber == null
                                                                  ? other$serialNumber == null
                                                                  : this$serialNumber.equals(other$serialNumber)) {
                                                                  Object this$serialNumberParent = this.getSerialNumberParent();
                                                                  Object other$serialNumberParent = other.getSerialNumberParent();
                                                                  if (this$serialNumberParent == null
                                                                     ? other$serialNumberParent == null
                                                                     : this$serialNumberParent.equals(other$serialNumberParent)) {
                                                                     Object this$projects = this.getProjects();
                                                                     Object other$projects = other.getProjects();
                                                                     if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                                                                        Object this$applyPurchase = this.getApplyPurchase();
                                                                        Object other$applyPurchase = other.getApplyPurchase();
                                                                        if (this$applyPurchase == null
                                                                           ? other$applyPurchase == null
                                                                           : this$applyPurchase.equals(other$applyPurchase)) {
                                                                           Object this$auxMaterialIds = this.getAuxMaterialIds();
                                                                           Object other$auxMaterialIds = other.getAuxMaterialIds();
                                                                           if (this$auxMaterialIds == null
                                                                              ? other$auxMaterialIds == null
                                                                              : this$auxMaterialIds.equals(other$auxMaterialIds)) {
                                                                              Object this$otherMaterialIds = this.getOtherMaterialIds();
                                                                              Object other$otherMaterialIds = other.getOtherMaterialIds();
                                                                              if (this$otherMaterialIds == null
                                                                                 ? other$otherMaterialIds == null
                                                                                 : this$otherMaterialIds.equals(other$otherMaterialIds)) {
                                                                                 Object this$gasMaterialIds = this.getGasMaterialIds();
                                                                                 Object other$gasMaterialIds = other.getGasMaterialIds();
                                                                                 if (this$gasMaterialIds == null
                                                                                    ? other$gasMaterialIds == null
                                                                                    : this$gasMaterialIds.equals(other$gasMaterialIds)) {
                                                                                    Object this$mete = this.getMete();
                                                                                    Object other$mete = other.getMete();
                                                                                    if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                                       Object this$meteUnit = this.getMeteUnit();
                                                                                       Object other$meteUnit = other.getMeteUnit();
                                                                                       if (this$meteUnit == null
                                                                                          ? other$meteUnit == null
                                                                                          : this$meteUnit.equals(other$meteUnit)) {
                                                                                          Object this$amount = this.getAmount();
                                                                                          Object other$amount = other.getAmount();
                                                                                          if (this$amount == null
                                                                                             ? other$amount == null
                                                                                             : this$amount.equals(other$amount)) {
                                                                                             Object this$branchCompany = this.getBranchCompany();
                                                                                             Object other$branchCompany = other.getBranchCompany();
                                                                                             if (this$branchCompany == null
                                                                                                ? other$branchCompany == null
                                                                                                : this$branchCompany.equals(other$branchCompany)) {
                                                                                                Object this$supplier = this.getSupplier();
                                                                                                Object other$supplier = other.getSupplier();
                                                                                                if (this$supplier == null
                                                                                                   ? other$supplier == null
                                                                                                   : this$supplier.equals(other$supplier)) {
                                                                                                   Object this$taxRate = this.getTaxRate();
                                                                                                   Object other$taxRate = other.getTaxRate();
                                                                                                   if (this$taxRate == null
                                                                                                      ? other$taxRate == null
                                                                                                      : this$taxRate.equals(other$taxRate)) {
                                                                                                      Object this$inboundTotalQuantity = this.getInboundTotalQuantity();
                                                                                                      Object other$inboundTotalQuantity = other.getInboundTotalQuantity();
                                                                                                      if (this$inboundTotalQuantity == null
                                                                                                         ? other$inboundTotalQuantity == null
                                                                                                         : this$inboundTotalQuantity.equals(
                                                                                                            other$inboundTotalQuantity
                                                                                                         )) {
                                                                                                         Object this$inboundTotalMete = this.getInboundTotalMete();
                                                                                                         Object other$inboundTotalMete = other.getInboundTotalMete();
                                                                                                         if (this$inboundTotalMete == null
                                                                                                            ? other$inboundTotalMete == null
                                                                                                            : this$inboundTotalMete.equals(
                                                                                                               other$inboundTotalMete
                                                                                                            )) {
                                                                                                            Object this$applyPurchaseStatus = this.getApplyPurchaseStatus();
                                                                                                            Object other$applyPurchaseStatus = other.getApplyPurchaseStatus();
                                                                                                            if (this$applyPurchaseStatus == null
                                                                                                               ? other$applyPurchaseStatus == null
                                                                                                               : this$applyPurchaseStatus.equals(
                                                                                                                  other$applyPurchaseStatus
                                                                                                               )) {
                                                                                                               Object this$createTime = this.getCreateTime();
                                                                                                               Object other$createTime = other.getCreateTime();
                                                                                                               return this$createTime == null
                                                                                                                  ? other$createTime == null
                                                                                                                  : this$createTime.equals(other$createTime);
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
      return other instanceof BriefPurchaseOrderNewDTO;
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
      Object $logisticsTransportType = this.getLogisticsTransportType();
      result = result * 59 + ($logisticsTransportType == null ? 43 : $logisticsTransportType.hashCode());
      Object $logisticsPayerType = this.getLogisticsPayerType();
      result = result * 59 + ($logisticsPayerType == null ? 43 : $logisticsPayerType.hashCode());
      Object $purchaseOrderPaymentMode = this.getPurchaseOrderPaymentMode();
      result = result * 59 + ($purchaseOrderPaymentMode == null ? 43 : $purchaseOrderPaymentMode.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
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
      Object $artifactWageQuotaType = this.getArtifactWageQuotaType();
      result = result * 59 + ($artifactWageQuotaType == null ? 43 : $artifactWageQuotaType.hashCode());
      Object $enclosureWageQuotaType = this.getEnclosureWageQuotaType();
      result = result * 59 + ($enclosureWageQuotaType == null ? 43 : $enclosureWageQuotaType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $serialNumberParent = this.getSerialNumberParent();
      result = result * 59 + ($serialNumberParent == null ? 43 : $serialNumberParent.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $applyPurchase = this.getApplyPurchase();
      result = result * 59 + ($applyPurchase == null ? 43 : $applyPurchase.hashCode());
      Object $auxMaterialIds = this.getAuxMaterialIds();
      result = result * 59 + ($auxMaterialIds == null ? 43 : $auxMaterialIds.hashCode());
      Object $otherMaterialIds = this.getOtherMaterialIds();
      result = result * 59 + ($otherMaterialIds == null ? 43 : $otherMaterialIds.hashCode());
      Object $gasMaterialIds = this.getGasMaterialIds();
      result = result * 59 + ($gasMaterialIds == null ? 43 : $gasMaterialIds.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $meteUnit = this.getMeteUnit();
      result = result * 59 + ($meteUnit == null ? 43 : $meteUnit.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $branchCompany = this.getBranchCompany();
      result = result * 59 + ($branchCompany == null ? 43 : $branchCompany.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $inboundTotalQuantity = this.getInboundTotalQuantity();
      result = result * 59 + ($inboundTotalQuantity == null ? 43 : $inboundTotalQuantity.hashCode());
      Object $inboundTotalMete = this.getInboundTotalMete();
      result = result * 59 + ($inboundTotalMete == null ? 43 : $inboundTotalMete.hashCode());
      Object $applyPurchaseStatus = this.getApplyPurchaseStatus();
      result = result * 59 + ($applyPurchaseStatus == null ? 43 : $applyPurchaseStatus.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "BriefPurchaseOrderNewDTO(id="
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
         + ", projects="
         + this.getProjects()
         + ", logisticsTransportType="
         + this.getLogisticsTransportType()
         + ", logisticsPayerType="
         + this.getLogisticsPayerType()
         + ", purchaseOrderPaymentMode="
         + this.getPurchaseOrderPaymentMode()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", applyPurchase="
         + this.getApplyPurchase()
         + ", auxMaterialIds="
         + this.getAuxMaterialIds()
         + ", otherMaterialIds="
         + this.getOtherMaterialIds()
         + ", gasMaterialIds="
         + this.getGasMaterialIds()
         + ", mete="
         + this.getMete()
         + ", meteUnit="
         + this.getMeteUnit()
         + ", amount="
         + this.getAmount()
         + ", branchCompany="
         + this.getBranchCompany()
         + ", supplier="
         + this.getSupplier()
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
         + ", artifactWageQuotaType="
         + this.getArtifactWageQuotaType()
         + ", enclosureWageQuotaType="
         + this.getEnclosureWageQuotaType()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public BriefPurchaseOrderNewDTO(
      final Long id,
      final Integer purchaseType,
      final Boolean BoolAnnual,
      final Integer supplyType,
      final Integer basicClass,
      final Integer materialType,
      final String serialNumber,
      final String serialNumberParent,
      final List<ProjectInfo> projects,
      final Integer logisticsTransportType,
      final Integer logisticsPayerType,
      final Integer purchaseOrderPaymentMode,
      final Integer weightMeasurementMode,
      final List<BriefIdAndSNDTO> applyPurchase,
      final List<Long> auxMaterialIds,
      final List<Long> otherMaterialIds,
      final List<Long> gasMaterialIds,
      final BigDecimal mete,
      final String meteUnit,
      final BigDecimal amount,
      final BriefIdAndNameDTO branchCompany,
      final BriefIdAndNameDTO supplier,
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
      final Integer artifactWageQuotaType,
      final Integer enclosureWageQuotaType,
      final LocalDateTime createTime
   ) {
      this.id = id;
      this.purchaseType = purchaseType;
      this.BoolAnnual = BoolAnnual;
      this.supplyType = supplyType;
      this.basicClass = basicClass;
      this.materialType = materialType;
      this.serialNumber = serialNumber;
      this.serialNumberParent = serialNumberParent;
      this.projects = projects;
      this.logisticsTransportType = logisticsTransportType;
      this.logisticsPayerType = logisticsPayerType;
      this.purchaseOrderPaymentMode = purchaseOrderPaymentMode;
      this.weightMeasurementMode = weightMeasurementMode;
      this.applyPurchase = applyPurchase;
      this.auxMaterialIds = auxMaterialIds;
      this.otherMaterialIds = otherMaterialIds;
      this.gasMaterialIds = gasMaterialIds;
      this.mete = mete;
      this.meteUnit = meteUnit;
      this.amount = amount;
      this.branchCompany = branchCompany;
      this.supplier = supplier;
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
      this.artifactWageQuotaType = artifactWageQuotaType;
      this.enclosureWageQuotaType = enclosureWageQuotaType;
      this.createTime = createTime;
   }

   public BriefPurchaseOrderNewDTO() {
   }

   public static class BriefPurchaseOrderNewDTOBuilder {
      private Long id;
      private Integer purchaseType;
      private Boolean BoolAnnual;
      private Integer supplyType;
      private Integer basicClass;
      private Integer materialType;
      private String serialNumber;
      private String serialNumberParent;
      private List<ProjectInfo> projects;
      private Integer logisticsTransportType;
      private Integer logisticsPayerType;
      private Integer purchaseOrderPaymentMode;
      private Integer weightMeasurementMode;
      private List<BriefIdAndSNDTO> applyPurchase;
      private List<Long> auxMaterialIds;
      private List<Long> otherMaterialIds;
      private List<Long> gasMaterialIds;
      private BigDecimal mete;
      private String meteUnit;
      private BigDecimal amount;
      private BriefIdAndNameDTO branchCompany;
      private BriefIdAndNameDTO supplier;
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
      private Integer artifactWageQuotaType;
      private Integer enclosureWageQuotaType;
      private LocalDateTime createTime;

      BriefPurchaseOrderNewDTOBuilder() {
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder purchaseType(final Integer purchaseType) {
         this.purchaseType = purchaseType;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder BoolAnnual(final Boolean BoolAnnual) {
         this.BoolAnnual = BoolAnnual;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder supplyType(final Integer supplyType) {
         this.supplyType = supplyType;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder serialNumberParent(final String serialNumberParent) {
         this.serialNumberParent = serialNumberParent;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder projects(final List<ProjectInfo> projects) {
         this.projects = projects;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder logisticsTransportType(final Integer logisticsTransportType) {
         this.logisticsTransportType = logisticsTransportType;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder logisticsPayerType(final Integer logisticsPayerType) {
         this.logisticsPayerType = logisticsPayerType;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder purchaseOrderPaymentMode(final Integer purchaseOrderPaymentMode) {
         this.purchaseOrderPaymentMode = purchaseOrderPaymentMode;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder applyPurchase(final List<BriefIdAndSNDTO> applyPurchase) {
         this.applyPurchase = applyPurchase;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder auxMaterialIds(final List<Long> auxMaterialIds) {
         this.auxMaterialIds = auxMaterialIds;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder otherMaterialIds(final List<Long> otherMaterialIds) {
         this.otherMaterialIds = otherMaterialIds;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder gasMaterialIds(final List<Long> gasMaterialIds) {
         this.gasMaterialIds = gasMaterialIds;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder meteUnit(final String meteUnit) {
         this.meteUnit = meteUnit;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder branchCompany(final BriefIdAndNameDTO branchCompany) {
         this.branchCompany = branchCompany;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder supplier(final BriefIdAndNameDTO supplier) {
         this.supplier = supplier;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder inboundTotalQuantity(final BigDecimal inboundTotalQuantity) {
         this.inboundTotalQuantity = inboundTotalQuantity;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder inboundTotalMete(final BigDecimal inboundTotalMete) {
         this.inboundTotalMete = inboundTotalMete;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder purchaseStatus(final Integer purchaseStatus) {
         this.purchaseStatus = purchaseStatus;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder applyPurchaseStatus(final String applyPurchaseStatus) {
         this.applyPurchaseStatus = applyPurchaseStatus;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder boolDetail(final Boolean boolDetail) {
         this.boolDetail = boolDetail;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder dataStatus(final Integer dataStatus) {
         this.dataStatus = dataStatus;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder artifactWageQuotaType(final Integer artifactWageQuotaType) {
         this.artifactWageQuotaType = artifactWageQuotaType;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder enclosureWageQuotaType(final Integer enclosureWageQuotaType) {
         this.enclosureWageQuotaType = enclosureWageQuotaType;
         return this;
      }

      public BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public BriefPurchaseOrderNewDTO build() {
         return new BriefPurchaseOrderNewDTO(
            this.id,
            this.purchaseType,
            this.BoolAnnual,
            this.supplyType,
            this.basicClass,
            this.materialType,
            this.serialNumber,
            this.serialNumberParent,
            this.projects,
            this.logisticsTransportType,
            this.logisticsPayerType,
            this.purchaseOrderPaymentMode,
            this.weightMeasurementMode,
            this.applyPurchase,
            this.auxMaterialIds,
            this.otherMaterialIds,
            this.gasMaterialIds,
            this.mete,
            this.meteUnit,
            this.amount,
            this.branchCompany,
            this.supplier,
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
            this.artifactWageQuotaType,
            this.enclosureWageQuotaType,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "BriefPurchaseOrderNewDTO.BriefPurchaseOrderNewDTOBuilder(id="
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
            + ", projects="
            + this.projects
            + ", logisticsTransportType="
            + this.logisticsTransportType
            + ", logisticsPayerType="
            + this.logisticsPayerType
            + ", purchaseOrderPaymentMode="
            + this.purchaseOrderPaymentMode
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", applyPurchase="
            + this.applyPurchase
            + ", auxMaterialIds="
            + this.auxMaterialIds
            + ", otherMaterialIds="
            + this.otherMaterialIds
            + ", gasMaterialIds="
            + this.gasMaterialIds
            + ", mete="
            + this.mete
            + ", meteUnit="
            + this.meteUnit
            + ", amount="
            + this.amount
            + ", branchCompany="
            + this.branchCompany
            + ", supplier="
            + this.supplier
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
            + ", artifactWageQuotaType="
            + this.artifactWageQuotaType
            + ", enclosureWageQuotaType="
            + this.enclosureWageQuotaType
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
