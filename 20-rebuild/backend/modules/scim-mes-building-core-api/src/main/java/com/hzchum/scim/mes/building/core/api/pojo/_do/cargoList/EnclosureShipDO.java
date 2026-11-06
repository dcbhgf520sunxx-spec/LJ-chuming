package com.hzchum.scim.mes.building.core.api.pojo._do.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.EnclosureBaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("围护商务")
public class EnclosureShipDO extends EnclosureBaseInfo {
   @ApiModelProperty("发运数")
   private BigDecimal shipQuantity;
   @ApiModelProperty("单价")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPrice;
   @ApiModelProperty("总价")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalPrice;
   @ApiModelProperty("序号")
   private Integer pid;
   @ApiModelProperty(name = "mete", notes = "发运总量", value = "发运总量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "pricingManner", value = "计价方式", notes = "计价方式")
   private Integer pricingManner;
   @ApiModelProperty(name = "unit", value = "核算单位", notes = "核算单位")
   private String unit;
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
   @ApiModelProperty(name = "packSerialNumber", value = "包单号", notes = "包单号")
   private String packSerialNumber;
   @ApiModelProperty(name = "warehouseType", value = "出入库类型", notes = "出入库类型")
   private Integer warehouseType;
   @ApiModelProperty(notes = "产品类型")
   private Integer productType;

   public BigDecimal getShipQuantity() {
      return this.shipQuantity;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Integer getPid() {
      return this.pid;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public String getUnit() {
      return this.unit;
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

   public String getPackSerialNumber() {
      return this.packSerialNumber;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public void setShipQuantity(final BigDecimal shipQuantity) {
      this.shipQuantity = shipQuantity;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setPid(final Integer pid) {
      this.pid = pid;
   }

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
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

   public void setPackSerialNumber(final String packSerialNumber) {
      this.packSerialNumber = packSerialNumber;
   }

   public void setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureShipDO)) {
         return false;
      }

      EnclosureShipDO other = (EnclosureShipDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pid = this.getPid();
      Object other$pid = other.getPid();
      if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
         Object this$pricingManner = this.getPricingManner();
         Object other$pricingManner = other.getPricingManner();
         if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
            Object this$warehouseType = this.getWarehouseType();
            Object other$warehouseType = other.getWarehouseType();
            if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$shipQuantity = this.getShipQuantity();
                  Object other$shipQuantity = other.getShipQuantity();
                  if (this$shipQuantity == null ? other$shipQuantity == null : this$shipQuantity.equals(other$shipQuantity)) {
                     Object this$unitPrice = this.getUnitPrice();
                     Object other$unitPrice = other.getUnitPrice();
                     if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                        Object this$totalPrice = this.getTotalPrice();
                        Object other$totalPrice = other.getTotalPrice();
                        if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                           Object this$mete = this.getMete();
                           Object other$mete = other.getMete();
                           if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                              Object this$unit = this.getUnit();
                              Object other$unit = other.getUnit();
                              if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
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
                                          if (this$actualUserName == null ? other$actualUserName == null : this$actualUserName.equals(other$actualUserName)) {
                                             Object this$userName = this.getUserName();
                                             Object other$userName = other.getUserName();
                                             if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                Object this$auditUserName = this.getAuditUserName();
                                                Object other$auditUserName = other.getAuditUserName();
                                                if (this$auditUserName == null ? other$auditUserName == null : this$auditUserName.equals(other$auditUserName)) {
                                                   Object this$supplierName = this.getSupplierName();
                                                   Object other$supplierName = other.getSupplierName();
                                                   if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                                      Object this$packSerialNumber = this.getPackSerialNumber();
                                                      Object other$packSerialNumber = other.getPackSerialNumber();
                                                      return this$packSerialNumber == null
                                                         ? other$packSerialNumber == null
                                                         : this$packSerialNumber.equals(other$packSerialNumber);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureShipDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $shipQuantity = this.getShipQuantity();
      result = result * 59 + ($shipQuantity == null ? 43 : $shipQuantity.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
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
      Object $packSerialNumber = this.getPackSerialNumber();
      return result * 59 + ($packSerialNumber == null ? 43 : $packSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureShipDO(shipQuantity="
         + this.getShipQuantity()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", pid="
         + this.getPid()
         + ", mete="
         + this.getMete()
         + ", pricingManner="
         + this.getPricingManner()
         + ", unit="
         + this.getUnit()
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
         + ", packSerialNumber="
         + this.getPackSerialNumber()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", productType="
         + this.getProductType()
         + ")";
   }
}
