package com.hzchum.scim.mes.building.core.api.pojo._do.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(description = "构件发运")
public class ArtifactShipMeteDO {
   @ApiModelProperty(notes = "发运产品关联id")
   private Long linkId;
   @ApiModelProperty(notes = "是否存在制成品退货")
   private Boolean boolExistReturn;
   @ApiModelProperty("总数量")
   private Integer totalQuantity;
   @ApiModelProperty("总过磅重量（kg）")
   private BigDecimal totalWeight;
   @ApiModelProperty("总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty("总重（t）")
   private BigDecimal weight;
   @ApiModelProperty("总长度")
   private BigDecimal totalLength;
   @ApiModelProperty("单价")
   private BigDecimal unitPrice;
   @ApiModelProperty("总价")
   private BigDecimal totalPrice;
   @ApiModelProperty("生产车间名称(多个以逗号分隔)")
   private String workshopNames;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   private String licensePlate;
   @ApiModelProperty(name = "cargoSerialNumber", value = "车次编号", notes = "车次编号")
   private String cargoSerialNumber;
   @ApiModelProperty(name = "actualUserName", value = "过磅人名称", notes = "过磅人名称")
   private String actualUserName;
   @ApiModelProperty(name = "userName", value = "装车人名称", notes = "装车人名称")
   private String userName;
   @ApiModelProperty(name = "auditUserName", value = "发运审核人名称", notes = "发运审核人名称")
   private String auditUserName;
   @ApiModelProperty(name = "supplierName", value = "物流公司名称", notes = "物流公司名称")
   private String supplierName;
   @ApiModelProperty(name = "pricingManner", value = "计价方式", notes = "计价方式")
   private Integer pricingManner;
   @ApiModelProperty(name = "structureMeasureMode", value = "计量方式", notes = "计量方式")
   private Integer structureMeasureMode;
   @ApiModelProperty(name = "createTime", value = "发运时间", notes = "发运时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty("入库类型 0普通入库 1回厂返修")
   private Integer warehouseType;

   public Long getLinkId() {
      return this.linkId;
   }

   public Boolean getBoolExistReturn() {
      return this.boolExistReturn;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public String getWorkshopNames() {
      return this.workshopNames;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getCargoSerialNumber() {
      return this.cargoSerialNumber;
   }

   public String getActualUserName() {
      return this.actualUserName;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public Integer getStructureMeasureMode() {
      return this.structureMeasureMode;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public void setLinkId(final Long linkId) {
      this.linkId = linkId;
   }

   public void setBoolExistReturn(final Boolean boolExistReturn) {
      this.boolExistReturn = boolExistReturn;
   }

   public void setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setWorkshopNames(final String workshopNames) {
      this.workshopNames = workshopNames;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setCargoSerialNumber(final String cargoSerialNumber) {
      this.cargoSerialNumber = cargoSerialNumber;
   }

   public void setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
   }

   public void setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactShipMeteDO)) {
         return false;
      }

      ArtifactShipMeteDO other = (ArtifactShipMeteDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$linkId = this.getLinkId();
      Object other$linkId = other.getLinkId();
      if (this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId)) {
         Object this$boolExistReturn = this.getBoolExistReturn();
         Object other$boolExistReturn = other.getBoolExistReturn();
         if (this$boolExistReturn == null ? other$boolExistReturn == null : this$boolExistReturn.equals(other$boolExistReturn)) {
            Object this$totalQuantity = this.getTotalQuantity();
            Object other$totalQuantity = other.getTotalQuantity();
            if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
               Object this$pricingManner = this.getPricingManner();
               Object other$pricingManner = other.getPricingManner();
               if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                  Object this$structureMeasureMode = this.getStructureMeasureMode();
                  Object other$structureMeasureMode = other.getStructureMeasureMode();
                  if (this$structureMeasureMode == null ? other$structureMeasureMode == null : this$structureMeasureMode.equals(other$structureMeasureMode)) {
                     Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                     Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                     if (this$boolAllPartSendDirectly == null
                        ? other$boolAllPartSendDirectly == null
                        : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                        Object this$warehouseType = this.getWarehouseType();
                        Object other$warehouseType = other.getWarehouseType();
                        if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                           Object this$totalWeight = this.getTotalWeight();
                           Object other$totalWeight = other.getTotalWeight();
                           if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                              Object this$totalNetWeight = this.getTotalNetWeight();
                              Object other$totalNetWeight = other.getTotalNetWeight();
                              if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                 Object this$totalGrossWeight = this.getTotalGrossWeight();
                                 Object other$totalGrossWeight = other.getTotalGrossWeight();
                                 if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                    Object this$weight = this.getWeight();
                                    Object other$weight = other.getWeight();
                                    if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                       Object this$totalLength = this.getTotalLength();
                                       Object other$totalLength = other.getTotalLength();
                                       if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                          Object this$unitPrice = this.getUnitPrice();
                                          Object other$unitPrice = other.getUnitPrice();
                                          if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                             Object this$totalPrice = this.getTotalPrice();
                                             Object other$totalPrice = other.getTotalPrice();
                                             if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                                                Object this$workshopNames = this.getWorkshopNames();
                                                Object other$workshopNames = other.getWorkshopNames();
                                                if (this$workshopNames == null ? other$workshopNames == null : this$workshopNames.equals(other$workshopNames)) {
                                                   Object this$licensePlate = this.getLicensePlate();
                                                   Object other$licensePlate = other.getLicensePlate();
                                                   if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                                      Object this$cargoSerialNumber = this.getCargoSerialNumber();
                                                      Object other$cargoSerialNumber = other.getCargoSerialNumber();
                                                      if (this$cargoSerialNumber == null
                                                         ? other$cargoSerialNumber == null
                                                         : this$cargoSerialNumber.equals(other$cargoSerialNumber)) {
                                                         Object this$actualUserName = this.getActualUserName();
                                                         Object other$actualUserName = other.getActualUserName();
                                                         if (this$actualUserName == null
                                                            ? other$actualUserName == null
                                                            : this$actualUserName.equals(other$actualUserName)) {
                                                            Object this$userName = this.getUserName();
                                                            Object other$userName = other.getUserName();
                                                            if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                               Object this$auditUserName = this.getAuditUserName();
                                                               Object other$auditUserName = other.getAuditUserName();
                                                               if (this$auditUserName == null
                                                                  ? other$auditUserName == null
                                                                  : this$auditUserName.equals(other$auditUserName)) {
                                                                  Object this$supplierName = this.getSupplierName();
                                                                  Object other$supplierName = other.getSupplierName();
                                                                  if (this$supplierName == null
                                                                     ? other$supplierName == null
                                                                     : this$supplierName.equals(other$supplierName)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactShipMeteDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $linkId = this.getLinkId();
      result = result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
      Object $boolExistReturn = this.getBoolExistReturn();
      result = result * 59 + ($boolExistReturn == null ? 43 : $boolExistReturn.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $workshopNames = this.getWorkshopNames();
      result = result * 59 + ($workshopNames == null ? 43 : $workshopNames.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $cargoSerialNumber = this.getCargoSerialNumber();
      result = result * 59 + ($cargoSerialNumber == null ? 43 : $cargoSerialNumber.hashCode());
      Object $actualUserName = this.getActualUserName();
      result = result * 59 + ($actualUserName == null ? 43 : $actualUserName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactShipMeteDO(linkId="
         + this.getLinkId()
         + ", boolExistReturn="
         + this.getBoolExistReturn()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", weight="
         + this.getWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", workshopNames="
         + this.getWorkshopNames()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", cargoSerialNumber="
         + this.getCargoSerialNumber()
         + ", actualUserName="
         + this.getActualUserName()
         + ", userName="
         + this.getUserName()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", supplierName="
         + this.getSupplierName()
         + ", pricingManner="
         + this.getPricingManner()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", createTime="
         + this.getCreateTime()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", warehouseType="
         + this.getWarehouseType()
         + ")";
   }
}
