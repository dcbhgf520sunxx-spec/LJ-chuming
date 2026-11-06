package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.SupplierPriceInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(description = "物流详情")
public class CargoListLogisticsDTO {
   @ApiModelProperty("发货清单id")
   private Long id;
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty("供应商")
   private SupplierPriceInfo supplier;
   @ApiModelProperty("总价")
   private BigDecimal totalPrice;
   @ApiModelProperty("制造类型【1：自制，2：外包】")
   private Integer manufactureType;
   @ApiModelProperty("装载类型")
   private Integer productType;
   @ApiModelProperty("车次编号")
   private String serialNumber;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("司机名称")
   private String driverName;
   @ApiModelProperty("司机手机号")
   private String driverPhone;
   @ApiModelProperty("总净重量")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("总毛重量")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty("过磅重量")
   private BigDecimal actualWeight;
   @ApiModelProperty("发运时间")
   private LocalDateTime auditTime;
   @ApiModelProperty("计价类型")
   private Integer priceType;
   @ApiModelProperty("车型")
   private String carModel;
   @ApiModelProperty("装载重量")
   private BigDecimal mete;
   @ApiModelProperty("发运状态(发运记录)")
   private Integer deliveryStatus;
   @ApiModelProperty(name = "changeFreight", value = "运费变更类型")
   private Integer changeFreight;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public SupplierPriceInfo getSupplier() {
      return this.supplier;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Integer getManufactureType() {
      return this.manufactureType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getDriverName() {
      return this.driverName;
   }

   public String getDriverPhone() {
      return this.driverPhone;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getActualWeight() {
      return this.actualWeight;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public String getCarModel() {
      return this.carModel;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getDeliveryStatus() {
      return this.deliveryStatus;
   }

   public Integer getChangeFreight() {
      return this.changeFreight;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setSupplier(final SupplierPriceInfo supplier) {
      this.supplier = supplier;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setManufactureType(final Integer manufactureType) {
      this.manufactureType = manufactureType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setDriverName(final String driverName) {
      this.driverName = driverName;
   }

   public void setDriverPhone(final String driverPhone) {
      this.driverPhone = driverPhone;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setActualWeight(final BigDecimal actualWeight) {
      this.actualWeight = actualWeight;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setPriceType(final Integer priceType) {
      this.priceType = priceType;
   }

   public void setCarModel(final String carModel) {
      this.carModel = carModel;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setDeliveryStatus(final Integer deliveryStatus) {
      this.deliveryStatus = deliveryStatus;
   }

   public void setChangeFreight(final Integer changeFreight) {
      this.changeFreight = changeFreight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListLogisticsDTO)) {
         return false;
      }

      CargoListLogisticsDTO other = (CargoListLogisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$manufactureType = this.getManufactureType();
         Object other$manufactureType = other.getManufactureType();
         if (this$manufactureType == null ? other$manufactureType == null : this$manufactureType.equals(other$manufactureType)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$priceType = this.getPriceType();
               Object other$priceType = other.getPriceType();
               if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
                  Object this$deliveryStatus = this.getDeliveryStatus();
                  Object other$deliveryStatus = other.getDeliveryStatus();
                  if (this$deliveryStatus == null ? other$deliveryStatus == null : this$deliveryStatus.equals(other$deliveryStatus)) {
                     Object this$changeFreight = this.getChangeFreight();
                     Object other$changeFreight = other.getChangeFreight();
                     if (this$changeFreight == null ? other$changeFreight == null : this$changeFreight.equals(other$changeFreight)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$supplier = this.getSupplier();
                           Object other$supplier = other.getSupplier();
                           if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                              Object this$totalPrice = this.getTotalPrice();
                              Object other$totalPrice = other.getTotalPrice();
                              if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$licensePlate = this.getLicensePlate();
                                    Object other$licensePlate = other.getLicensePlate();
                                    if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                       Object this$driverName = this.getDriverName();
                                       Object other$driverName = other.getDriverName();
                                       if (this$driverName == null ? other$driverName == null : this$driverName.equals(other$driverName)) {
                                          Object this$driverPhone = this.getDriverPhone();
                                          Object other$driverPhone = other.getDriverPhone();
                                          if (this$driverPhone == null ? other$driverPhone == null : this$driverPhone.equals(other$driverPhone)) {
                                             Object this$totalNetWeight = this.getTotalNetWeight();
                                             Object other$totalNetWeight = other.getTotalNetWeight();
                                             if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                if (this$totalGrossWeight == null
                                                   ? other$totalGrossWeight == null
                                                   : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                   Object this$actualWeight = this.getActualWeight();
                                                   Object other$actualWeight = other.getActualWeight();
                                                   if (this$actualWeight == null ? other$actualWeight == null : this$actualWeight.equals(other$actualWeight)) {
                                                      Object this$auditTime = this.getAuditTime();
                                                      Object other$auditTime = other.getAuditTime();
                                                      if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                                         Object this$carModel = this.getCarModel();
                                                         Object other$carModel = other.getCarModel();
                                                         if (this$carModel == null ? other$carModel == null : this$carModel.equals(other$carModel)) {
                                                            Object this$mete = this.getMete();
                                                            Object other$mete = other.getMete();
                                                            return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
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
      return other instanceof CargoListLogisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $manufactureType = this.getManufactureType();
      result = result * 59 + ($manufactureType == null ? 43 : $manufactureType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $deliveryStatus = this.getDeliveryStatus();
      result = result * 59 + ($deliveryStatus == null ? 43 : $deliveryStatus.hashCode());
      Object $changeFreight = this.getChangeFreight();
      result = result * 59 + ($changeFreight == null ? 43 : $changeFreight.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $driverName = this.getDriverName();
      result = result * 59 + ($driverName == null ? 43 : $driverName.hashCode());
      Object $driverPhone = this.getDriverPhone();
      result = result * 59 + ($driverPhone == null ? 43 : $driverPhone.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $actualWeight = this.getActualWeight();
      result = result * 59 + ($actualWeight == null ? 43 : $actualWeight.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $carModel = this.getCarModel();
      result = result * 59 + ($carModel == null ? 43 : $carModel.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListLogisticsDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", supplier="
         + this.getSupplier()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", manufactureType="
         + this.getManufactureType()
         + ", productType="
         + this.getProductType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", driverName="
         + this.getDriverName()
         + ", driverPhone="
         + this.getDriverPhone()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", actualWeight="
         + this.getActualWeight()
         + ", auditTime="
         + this.getAuditTime()
         + ", priceType="
         + this.getPriceType()
         + ", carModel="
         + this.getCarModel()
         + ", mete="
         + this.getMete()
         + ", deliveryStatus="
         + this.getDeliveryStatus()
         + ", changeFreight="
         + this.getChangeFreight()
         + ")";
   }
}
