package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SupplierSummaryCargoListDTO {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("物流公司id")
   private Long supplierId;
   @ApiModelProperty("物流公司")
   private String supplierName;
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty("运输日期")
   private LocalDateTime shipDate;
   @ApiModelProperty(name = "serialNumber", value = "车次编号", notes = "车次编号")
   private String serialNumber;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("装载重量")
   private BigDecimal loadingWeight;
   @ApiModelProperty("车型")
   private String carModel;
   @ApiModelProperty("司机姓名")
   private String driverName;
   @ApiModelProperty("司机电话")
   private String driverPhone;
   @ApiModelProperty("运费")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "status", value = "发运状态 [1 装车, 2 过磅，4发运，8收货 16 未装车]")
   private Integer status;
   @ApiModelProperty(name = "shipmentStatus", value = "发运状态 1送货中 2取消送货 4已签收'")
   private Integer shipmentStatus;
   @ApiModelProperty(name = "changeFreight", value = "运费变更类型")
   private Integer changeFreight;
   @ApiModelProperty("是否个人承运")
   private Integer boolPersonalEnum;

   public Long getId() {
      return this.id;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public LocalDateTime getShipDate() {
      return this.shipDate;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public BigDecimal getLoadingWeight() {
      return this.loadingWeight;
   }

   public String getCarModel() {
      return this.carModel;
   }

   public String getDriverName() {
      return this.driverName;
   }

   public String getDriverPhone() {
      return this.driverPhone;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getShipmentStatus() {
      return this.shipmentStatus;
   }

   public Integer getChangeFreight() {
      return this.changeFreight;
   }

   public Integer getBoolPersonalEnum() {
      return this.boolPersonalEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setShipDate(final LocalDateTime shipDate) {
      this.shipDate = shipDate;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setLoadingWeight(final BigDecimal loadingWeight) {
      this.loadingWeight = loadingWeight;
   }

   public void setCarModel(final String carModel) {
      this.carModel = carModel;
   }

   public void setDriverName(final String driverName) {
      this.driverName = driverName;
   }

   public void setDriverPhone(final String driverPhone) {
      this.driverPhone = driverPhone;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setShipmentStatus(final Integer shipmentStatus) {
      this.shipmentStatus = shipmentStatus;
   }

   public void setChangeFreight(final Integer changeFreight) {
      this.changeFreight = changeFreight;
   }

   public void setBoolPersonalEnum(final Integer boolPersonalEnum) {
      this.boolPersonalEnum = boolPersonalEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierSummaryCargoListDTO)) {
         return false;
      }

      SupplierSummaryCargoListDTO other = (SupplierSummaryCargoListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$shipmentStatus = this.getShipmentStatus();
               Object other$shipmentStatus = other.getShipmentStatus();
               if (this$shipmentStatus == null ? other$shipmentStatus == null : this$shipmentStatus.equals(other$shipmentStatus)) {
                  Object this$changeFreight = this.getChangeFreight();
                  Object other$changeFreight = other.getChangeFreight();
                  if (this$changeFreight == null ? other$changeFreight == null : this$changeFreight.equals(other$changeFreight)) {
                     Object this$boolPersonalEnum = this.getBoolPersonalEnum();
                     Object other$boolPersonalEnum = other.getBoolPersonalEnum();
                     if (this$boolPersonalEnum == null ? other$boolPersonalEnum == null : this$boolPersonalEnum.equals(other$boolPersonalEnum)) {
                        Object this$supplierName = this.getSupplierName();
                        Object other$supplierName = other.getSupplierName();
                        if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                              Object this$shipDate = this.getShipDate();
                              Object other$shipDate = other.getShipDate();
                              if (this$shipDate == null ? other$shipDate == null : this$shipDate.equals(other$shipDate)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$licensePlate = this.getLicensePlate();
                                    Object other$licensePlate = other.getLicensePlate();
                                    if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                       Object this$loadingWeight = this.getLoadingWeight();
                                       Object other$loadingWeight = other.getLoadingWeight();
                                       if (this$loadingWeight == null ? other$loadingWeight == null : this$loadingWeight.equals(other$loadingWeight)) {
                                          Object this$carModel = this.getCarModel();
                                          Object other$carModel = other.getCarModel();
                                          if (this$carModel == null ? other$carModel == null : this$carModel.equals(other$carModel)) {
                                             Object this$driverName = this.getDriverName();
                                             Object other$driverName = other.getDriverName();
                                             if (this$driverName == null ? other$driverName == null : this$driverName.equals(other$driverName)) {
                                                Object this$driverPhone = this.getDriverPhone();
                                                Object other$driverPhone = other.getDriverPhone();
                                                if (this$driverPhone == null ? other$driverPhone == null : this$driverPhone.equals(other$driverPhone)) {
                                                   Object this$totalPrice = this.getTotalPrice();
                                                   Object other$totalPrice = other.getTotalPrice();
                                                   return this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice);
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
      return other instanceof SupplierSummaryCargoListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $shipmentStatus = this.getShipmentStatus();
      result = result * 59 + ($shipmentStatus == null ? 43 : $shipmentStatus.hashCode());
      Object $changeFreight = this.getChangeFreight();
      result = result * 59 + ($changeFreight == null ? 43 : $changeFreight.hashCode());
      Object $boolPersonalEnum = this.getBoolPersonalEnum();
      result = result * 59 + ($boolPersonalEnum == null ? 43 : $boolPersonalEnum.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $shipDate = this.getShipDate();
      result = result * 59 + ($shipDate == null ? 43 : $shipDate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $loadingWeight = this.getLoadingWeight();
      result = result * 59 + ($loadingWeight == null ? 43 : $loadingWeight.hashCode());
      Object $carModel = this.getCarModel();
      result = result * 59 + ($carModel == null ? 43 : $carModel.hashCode());
      Object $driverName = this.getDriverName();
      result = result * 59 + ($driverName == null ? 43 : $driverName.hashCode());
      Object $driverPhone = this.getDriverPhone();
      result = result * 59 + ($driverPhone == null ? 43 : $driverPhone.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSummaryCargoListDTO(id="
         + this.getId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", project="
         + this.getProject()
         + ", shipDate="
         + this.getShipDate()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", loadingWeight="
         + this.getLoadingWeight()
         + ", carModel="
         + this.getCarModel()
         + ", driverName="
         + this.getDriverName()
         + ", driverPhone="
         + this.getDriverPhone()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", status="
         + this.getStatus()
         + ", shipmentStatus="
         + this.getShipmentStatus()
         + ", changeFreight="
         + this.getChangeFreight()
         + ", boolPersonalEnum="
         + this.getBoolPersonalEnum()
         + ")";
   }
}
