package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProjectWasteProductChildDTO {
   private Long projectId;
   private Long monomerId;
   private Long areaId;
   private Long productId;
   private String serialNumber;
   private String specification;
   private String material;
   private String measureUnit;
   private String accountingUnit;
   private BigDecimal quantity;
   private BigDecimal mete;
   private BigDecimal singleMete;
   private BigDecimal unitPrice;
   private BigDecimal length;
   private BigDecimal totalLength;
   private String plate;
   private BigDecimal totalArea;
   private BigDecimal totalAmount;
   private BigDecimal weight;
   private BigDecimal totalWeight;
   private Long mainId;
   @ApiModelProperty(name = "wasteHandleMethod", value = "废品处理方式 1二次利用 2废品出售 ", notes = "废品处理方式 1二次利用 2废品出售")
   private Integer wasteHandleMethod;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   private Integer auditStatus;
   private BigDecimal netWeight;
   private BigDecimal totalNetWeight;
   private Long mesBuildingWarehouseRecordId;
   private Long mesBuildingReturnWarehouseRecordId;
   private Integer pricingManner;
   private BigDecimal surfaceArea;
   private String productName;
   private String monomerName;
   private String areaName;
   private Long planId;
   private String planName;
   private BigDecimal totalPrice;
   private Integer productType;
   private Integer number;
   private String productReason;
   private String storageDuration;
   private String storageLocation;
   private Long useProjectId;
   private Long workshopId;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getSingleMete() {
      return this.singleMete;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public String getPlate() {
      return this.plate;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public Long getMainId() {
      return this.mainId;
   }

   public Integer getWasteHandleMethod() {
      return this.wasteHandleMethod;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Long getMesBuildingWarehouseRecordId() {
      return this.mesBuildingWarehouseRecordId;
   }

   public Long getMesBuildingReturnWarehouseRecordId() {
      return this.mesBuildingReturnWarehouseRecordId;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getProductName() {
      return this.productName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public String getPlanName() {
      return this.planName;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getNumber() {
      return this.number;
   }

   public String getProductReason() {
      return this.productReason;
   }

   public String getStorageDuration() {
      return this.storageDuration;
   }

   public String getStorageLocation() {
      return this.storageLocation;
   }

   public Long getUseProjectId() {
      return this.useProjectId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setSingleMete(final BigDecimal singleMete) {
      this.singleMete = singleMete;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setMainId(final Long mainId) {
      this.mainId = mainId;
   }

   public void setWasteHandleMethod(final Integer wasteHandleMethod) {
      this.wasteHandleMethod = wasteHandleMethod;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setMesBuildingWarehouseRecordId(final Long mesBuildingWarehouseRecordId) {
      this.mesBuildingWarehouseRecordId = mesBuildingWarehouseRecordId;
   }

   public void setMesBuildingReturnWarehouseRecordId(final Long mesBuildingReturnWarehouseRecordId) {
      this.mesBuildingReturnWarehouseRecordId = mesBuildingReturnWarehouseRecordId;
   }

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setProductName(final String productName) {
      this.productName = productName;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setPlanId(final Long planId) {
      this.planId = planId;
   }

   public void setPlanName(final String planName) {
      this.planName = planName;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setProductReason(final String productReason) {
      this.productReason = productReason;
   }

   public void setStorageDuration(final String storageDuration) {
      this.storageDuration = storageDuration;
   }

   public void setStorageLocation(final String storageLocation) {
      this.storageLocation = storageLocation;
   }

   public void setUseProjectId(final Long useProjectId) {
      this.useProjectId = useProjectId;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectWasteProductChildDTO)) {
         return false;
      }

      ProjectWasteProductChildDTO other = (ProjectWasteProductChildDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$mainId = this.getMainId();
                  Object other$mainId = other.getMainId();
                  if (this$mainId == null ? other$mainId == null : this$mainId.equals(other$mainId)) {
                     Object this$wasteHandleMethod = this.getWasteHandleMethod();
                     Object other$wasteHandleMethod = other.getWasteHandleMethod();
                     if (this$wasteHandleMethod == null ? other$wasteHandleMethod == null : this$wasteHandleMethod.equals(other$wasteHandleMethod)) {
                        Object this$auditStatus = this.getAuditStatus();
                        Object other$auditStatus = other.getAuditStatus();
                        if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                           Object this$mesBuildingWarehouseRecordId = this.getMesBuildingWarehouseRecordId();
                           Object other$mesBuildingWarehouseRecordId = other.getMesBuildingWarehouseRecordId();
                           if (this$mesBuildingWarehouseRecordId == null
                              ? other$mesBuildingWarehouseRecordId == null
                              : this$mesBuildingWarehouseRecordId.equals(other$mesBuildingWarehouseRecordId)) {
                              Object this$mesBuildingReturnWarehouseRecordId = this.getMesBuildingReturnWarehouseRecordId();
                              Object other$mesBuildingReturnWarehouseRecordId = other.getMesBuildingReturnWarehouseRecordId();
                              if (this$mesBuildingReturnWarehouseRecordId == null
                                 ? other$mesBuildingReturnWarehouseRecordId == null
                                 : this$mesBuildingReturnWarehouseRecordId.equals(other$mesBuildingReturnWarehouseRecordId)) {
                                 Object this$pricingManner = this.getPricingManner();
                                 Object other$pricingManner = other.getPricingManner();
                                 if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                                    Object this$planId = this.getPlanId();
                                    Object other$planId = other.getPlanId();
                                    if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                                       Object this$productType = this.getProductType();
                                       Object other$productType = other.getProductType();
                                       if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                          Object this$number = this.getNumber();
                                          Object other$number = other.getNumber();
                                          if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                             Object this$useProjectId = this.getUseProjectId();
                                             Object other$useProjectId = other.getUseProjectId();
                                             if (this$useProjectId == null ? other$useProjectId == null : this$useProjectId.equals(other$useProjectId)) {
                                                Object this$workshopId = this.getWorkshopId();
                                                Object other$workshopId = other.getWorkshopId();
                                                if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                   Object this$serialNumber = this.getSerialNumber();
                                                   Object other$serialNumber = other.getSerialNumber();
                                                   if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                      Object this$specification = this.getSpecification();
                                                      Object other$specification = other.getSpecification();
                                                      if (this$specification == null
                                                         ? other$specification == null
                                                         : this$specification.equals(other$specification)) {
                                                         Object this$material = this.getMaterial();
                                                         Object other$material = other.getMaterial();
                                                         if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                            Object this$measureUnit = this.getMeasureUnit();
                                                            Object other$measureUnit = other.getMeasureUnit();
                                                            if (this$measureUnit == null
                                                               ? other$measureUnit == null
                                                               : this$measureUnit.equals(other$measureUnit)) {
                                                               Object this$accountingUnit = this.getAccountingUnit();
                                                               Object other$accountingUnit = other.getAccountingUnit();
                                                               if (this$accountingUnit == null
                                                                  ? other$accountingUnit == null
                                                                  : this$accountingUnit.equals(other$accountingUnit)) {
                                                                  Object this$quantity = this.getQuantity();
                                                                  Object other$quantity = other.getQuantity();
                                                                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                                     Object this$mete = this.getMete();
                                                                     Object other$mete = other.getMete();
                                                                     if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                        Object this$singleMete = this.getSingleMete();
                                                                        Object other$singleMete = other.getSingleMete();
                                                                        if (this$singleMete == null
                                                                           ? other$singleMete == null
                                                                           : this$singleMete.equals(other$singleMete)) {
                                                                           Object this$unitPrice = this.getUnitPrice();
                                                                           Object other$unitPrice = other.getUnitPrice();
                                                                           if (this$unitPrice == null
                                                                              ? other$unitPrice == null
                                                                              : this$unitPrice.equals(other$unitPrice)) {
                                                                              Object this$length = this.getLength();
                                                                              Object other$length = other.getLength();
                                                                              if (this$length == null ? other$length == null : this$length.equals(other$length)
                                                                                 )
                                                                               {
                                                                                 Object this$totalLength = this.getTotalLength();
                                                                                 Object other$totalLength = other.getTotalLength();
                                                                                 if (this$totalLength == null
                                                                                    ? other$totalLength == null
                                                                                    : this$totalLength.equals(other$totalLength)) {
                                                                                    Object this$plate = this.getPlate();
                                                                                    Object other$plate = other.getPlate();
                                                                                    if (this$plate == null
                                                                                       ? other$plate == null
                                                                                       : this$plate.equals(other$plate)) {
                                                                                       Object this$totalArea = this.getTotalArea();
                                                                                       Object other$totalArea = other.getTotalArea();
                                                                                       if (this$totalArea == null
                                                                                          ? other$totalArea == null
                                                                                          : this$totalArea.equals(other$totalArea)) {
                                                                                          Object this$totalAmount = this.getTotalAmount();
                                                                                          Object other$totalAmount = other.getTotalAmount();
                                                                                          if (this$totalAmount == null
                                                                                             ? other$totalAmount == null
                                                                                             : this$totalAmount.equals(other$totalAmount)) {
                                                                                             Object this$weight = this.getWeight();
                                                                                             Object other$weight = other.getWeight();
                                                                                             if (this$weight == null
                                                                                                ? other$weight == null
                                                                                                : this$weight.equals(other$weight)) {
                                                                                                Object this$totalWeight = this.getTotalWeight();
                                                                                                Object other$totalWeight = other.getTotalWeight();
                                                                                                if (this$totalWeight == null
                                                                                                   ? other$totalWeight == null
                                                                                                   : this$totalWeight.equals(other$totalWeight)) {
                                                                                                   Object this$netWeight = this.getNetWeight();
                                                                                                   Object other$netWeight = other.getNetWeight();
                                                                                                   if (this$netWeight == null
                                                                                                      ? other$netWeight == null
                                                                                                      : this$netWeight.equals(other$netWeight)) {
                                                                                                      Object this$totalNetWeight = this.getTotalNetWeight();
                                                                                                      Object other$totalNetWeight = other.getTotalNetWeight();
                                                                                                      if (this$totalNetWeight == null
                                                                                                         ? other$totalNetWeight == null
                                                                                                         : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                                                         Object this$surfaceArea = this.getSurfaceArea();
                                                                                                         Object other$surfaceArea = other.getSurfaceArea();
                                                                                                         if (this$surfaceArea == null
                                                                                                            ? other$surfaceArea == null
                                                                                                            : this$surfaceArea.equals(other$surfaceArea)) {
                                                                                                            Object this$productName = this.getProductName();
                                                                                                            Object other$productName = other.getProductName();
                                                                                                            if (this$productName == null
                                                                                                               ? other$productName == null
                                                                                                               : this$productName.equals(other$productName)) {
                                                                                                               Object this$monomerName = this.getMonomerName();
                                                                                                               Object other$monomerName = other.getMonomerName();
                                                                                                               if (this$monomerName == null
                                                                                                                  ? other$monomerName == null
                                                                                                                  : this$monomerName.equals(other$monomerName)) {
                                                                                                                  Object this$areaName = this.getAreaName();
                                                                                                                  Object other$areaName = other.getAreaName();
                                                                                                                  if (this$areaName == null
                                                                                                                     ? other$areaName == null
                                                                                                                     : this$areaName.equals(other$areaName)) {
                                                                                                                     Object this$planName = this.getPlanName();
                                                                                                                     Object other$planName = other.getPlanName();
                                                                                                                     if (this$planName == null
                                                                                                                        ? other$planName == null
                                                                                                                        : this$planName.equals(other$planName)) {
                                                                                                                        Object this$totalPrice = this.getTotalPrice();
                                                                                                                        Object other$totalPrice = other.getTotalPrice();
                                                                                                                        if (this$totalPrice == null
                                                                                                                           ? other$totalPrice == null
                                                                                                                           : this$totalPrice.equals(
                                                                                                                              other$totalPrice
                                                                                                                           )) {
                                                                                                                           Object this$productReason = this.getProductReason();
                                                                                                                           Object other$productReason = other.getProductReason();
                                                                                                                           if (this$productReason == null
                                                                                                                              ? other$productReason == null
                                                                                                                              : this$productReason.equals(
                                                                                                                                 other$productReason
                                                                                                                              )) {
                                                                                                                              Object this$storageDuration = this.getStorageDuration();
                                                                                                                              Object other$storageDuration = other.getStorageDuration();
                                                                                                                              if (this$storageDuration == null
                                                                                                                                 ? other$storageDuration
                                                                                                                                    == null
                                                                                                                                 : this$storageDuration.equals(
                                                                                                                                    other$storageDuration
                                                                                                                                 )) {
                                                                                                                                 Object this$storageLocation = this.getStorageLocation();
                                                                                                                                 Object other$storageLocation = other.getStorageLocation();
                                                                                                                                 return this$storageLocation
                                                                                                                                       == null
                                                                                                                                    ? other$storageLocation
                                                                                                                                       == null
                                                                                                                                    : this$storageLocation.equals(
                                                                                                                                       other$storageLocation
                                                                                                                                    );
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
      return other instanceof ProjectWasteProductChildDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $mainId = this.getMainId();
      result = result * 59 + ($mainId == null ? 43 : $mainId.hashCode());
      Object $wasteHandleMethod = this.getWasteHandleMethod();
      result = result * 59 + ($wasteHandleMethod == null ? 43 : $wasteHandleMethod.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $mesBuildingWarehouseRecordId = this.getMesBuildingWarehouseRecordId();
      result = result * 59 + ($mesBuildingWarehouseRecordId == null ? 43 : $mesBuildingWarehouseRecordId.hashCode());
      Object $mesBuildingReturnWarehouseRecordId = this.getMesBuildingReturnWarehouseRecordId();
      result = result * 59 + ($mesBuildingReturnWarehouseRecordId == null ? 43 : $mesBuildingReturnWarehouseRecordId.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $useProjectId = this.getUseProjectId();
      result = result * 59 + ($useProjectId == null ? 43 : $useProjectId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $singleMete = this.getSingleMete();
      result = result * 59 + ($singleMete == null ? 43 : $singleMete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $planName = this.getPlanName();
      result = result * 59 + ($planName == null ? 43 : $planName.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $productReason = this.getProductReason();
      result = result * 59 + ($productReason == null ? 43 : $productReason.hashCode());
      Object $storageDuration = this.getStorageDuration();
      result = result * 59 + ($storageDuration == null ? 43 : $storageDuration.hashCode());
      Object $storageLocation = this.getStorageLocation();
      return result * 59 + ($storageLocation == null ? 43 : $storageLocation.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectWasteProductChildDTO(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productId="
         + this.getProductId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", singleMete="
         + this.getSingleMete()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", length="
         + this.getLength()
         + ", totalLength="
         + this.getTotalLength()
         + ", plate="
         + this.getPlate()
         + ", totalArea="
         + this.getTotalArea()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", weight="
         + this.getWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", mainId="
         + this.getMainId()
         + ", wasteHandleMethod="
         + this.getWasteHandleMethod()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", mesBuildingWarehouseRecordId="
         + this.getMesBuildingWarehouseRecordId()
         + ", mesBuildingReturnWarehouseRecordId="
         + this.getMesBuildingReturnWarehouseRecordId()
         + ", pricingManner="
         + this.getPricingManner()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", productName="
         + this.getProductName()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", planId="
         + this.getPlanId()
         + ", planName="
         + this.getPlanName()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", productType="
         + this.getProductType()
         + ", number="
         + this.getNumber()
         + ", productReason="
         + this.getProductReason()
         + ", storageDuration="
         + this.getStorageDuration()
         + ", storageLocation="
         + this.getStorageLocation()
         + ", useProjectId="
         + this.getUseProjectId()
         + ", workshopId="
         + this.getWorkshopId()
         + ")";
   }
}
