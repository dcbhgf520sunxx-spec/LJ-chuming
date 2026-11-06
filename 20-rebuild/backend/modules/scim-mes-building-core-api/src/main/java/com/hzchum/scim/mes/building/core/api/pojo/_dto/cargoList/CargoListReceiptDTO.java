package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(description = "收货状态")
public class CargoListReceiptDTO {
   @ApiModelProperty("发货清单id")
   private Long id;
   @ApiModelProperty("项目")
   private ProjectInfo project;
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
   @ApiModelProperty("过磅重量")
   private BigDecimal actualWeight;
   @ApiModelProperty("发运审核人名称")
   private String auditUserName;
   @ApiModelProperty("发运时间")
   private LocalDateTime auditTime;
   @ApiModelProperty("收货人")
   private String receiptName;
   @ApiModelProperty("实际收货人名称")
   private String auditReceiptName;
   @ApiModelProperty("收货日期")
   private LocalDateTime auditReceiptTime;
   @ApiModelProperty("收货状态 1 已收货 2 未收货")
   private Integer receiptStatus;
   @ApiModelProperty("发运状态(收货记录)")
   private Integer shipmentStatus;
   @ApiModelProperty("状态更新日期")
   private LocalDateTime statusUpdateDate;
   @ApiModelProperty("物流详情")
   private CargoLogisticsDTO logisticsDTO;
   @ApiModelProperty("运费变更原因")
   private String changeFreightReason;
   @ApiModelProperty("取消送货原因")
   private String cancelDeliveryReason;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
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

   public BigDecimal getActualWeight() {
      return this.actualWeight;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public String getReceiptName() {
      return this.receiptName;
   }

   public String getAuditReceiptName() {
      return this.auditReceiptName;
   }

   public LocalDateTime getAuditReceiptTime() {
      return this.auditReceiptTime;
   }

   public Integer getReceiptStatus() {
      return this.receiptStatus;
   }

   public Integer getShipmentStatus() {
      return this.shipmentStatus;
   }

   public LocalDateTime getStatusUpdateDate() {
      return this.statusUpdateDate;
   }

   public CargoLogisticsDTO getLogisticsDTO() {
      return this.logisticsDTO;
   }

   public String getChangeFreightReason() {
      return this.changeFreightReason;
   }

   public String getCancelDeliveryReason() {
      return this.cancelDeliveryReason;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
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

   public void setActualWeight(final BigDecimal actualWeight) {
      this.actualWeight = actualWeight;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setReceiptName(final String receiptName) {
      this.receiptName = receiptName;
   }

   public void setAuditReceiptName(final String auditReceiptName) {
      this.auditReceiptName = auditReceiptName;
   }

   public void setAuditReceiptTime(final LocalDateTime auditReceiptTime) {
      this.auditReceiptTime = auditReceiptTime;
   }

   public void setReceiptStatus(final Integer receiptStatus) {
      this.receiptStatus = receiptStatus;
   }

   public void setShipmentStatus(final Integer shipmentStatus) {
      this.shipmentStatus = shipmentStatus;
   }

   public void setStatusUpdateDate(final LocalDateTime statusUpdateDate) {
      this.statusUpdateDate = statusUpdateDate;
   }

   public void setLogisticsDTO(final CargoLogisticsDTO logisticsDTO) {
      this.logisticsDTO = logisticsDTO;
   }

   public void setChangeFreightReason(final String changeFreightReason) {
      this.changeFreightReason = changeFreightReason;
   }

   public void setCancelDeliveryReason(final String cancelDeliveryReason) {
      this.cancelDeliveryReason = cancelDeliveryReason;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListReceiptDTO)) {
         return false;
      }

      CargoListReceiptDTO other = (CargoListReceiptDTO)o;
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
               Object this$receiptStatus = this.getReceiptStatus();
               Object other$receiptStatus = other.getReceiptStatus();
               if (this$receiptStatus == null ? other$receiptStatus == null : this$receiptStatus.equals(other$receiptStatus)) {
                  Object this$shipmentStatus = this.getShipmentStatus();
                  Object other$shipmentStatus = other.getShipmentStatus();
                  if (this$shipmentStatus == null ? other$shipmentStatus == null : this$shipmentStatus.equals(other$shipmentStatus)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
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
                                    Object this$actualWeight = this.getActualWeight();
                                    Object other$actualWeight = other.getActualWeight();
                                    if (this$actualWeight == null ? other$actualWeight == null : this$actualWeight.equals(other$actualWeight)) {
                                       Object this$auditUserName = this.getAuditUserName();
                                       Object other$auditUserName = other.getAuditUserName();
                                       if (this$auditUserName == null ? other$auditUserName == null : this$auditUserName.equals(other$auditUserName)) {
                                          Object this$auditTime = this.getAuditTime();
                                          Object other$auditTime = other.getAuditTime();
                                          if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                             Object this$receiptName = this.getReceiptName();
                                             Object other$receiptName = other.getReceiptName();
                                             if (this$receiptName == null ? other$receiptName == null : this$receiptName.equals(other$receiptName)) {
                                                Object this$auditReceiptName = this.getAuditReceiptName();
                                                Object other$auditReceiptName = other.getAuditReceiptName();
                                                if (this$auditReceiptName == null
                                                   ? other$auditReceiptName == null
                                                   : this$auditReceiptName.equals(other$auditReceiptName)) {
                                                   Object this$auditReceiptTime = this.getAuditReceiptTime();
                                                   Object other$auditReceiptTime = other.getAuditReceiptTime();
                                                   if (this$auditReceiptTime == null
                                                      ? other$auditReceiptTime == null
                                                      : this$auditReceiptTime.equals(other$auditReceiptTime)) {
                                                      Object this$statusUpdateDate = this.getStatusUpdateDate();
                                                      Object other$statusUpdateDate = other.getStatusUpdateDate();
                                                      if (this$statusUpdateDate == null
                                                         ? other$statusUpdateDate == null
                                                         : this$statusUpdateDate.equals(other$statusUpdateDate)) {
                                                         Object this$logisticsDTO = this.getLogisticsDTO();
                                                         Object other$logisticsDTO = other.getLogisticsDTO();
                                                         if (this$logisticsDTO == null
                                                            ? other$logisticsDTO == null
                                                            : this$logisticsDTO.equals(other$logisticsDTO)) {
                                                            Object this$changeFreightReason = this.getChangeFreightReason();
                                                            Object other$changeFreightReason = other.getChangeFreightReason();
                                                            if (this$changeFreightReason == null
                                                               ? other$changeFreightReason == null
                                                               : this$changeFreightReason.equals(other$changeFreightReason)) {
                                                               Object this$cancelDeliveryReason = this.getCancelDeliveryReason();
                                                               Object other$cancelDeliveryReason = other.getCancelDeliveryReason();
                                                               return this$cancelDeliveryReason == null
                                                                  ? other$cancelDeliveryReason == null
                                                                  : this$cancelDeliveryReason.equals(other$cancelDeliveryReason);
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
      return other instanceof CargoListReceiptDTO;
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
      Object $receiptStatus = this.getReceiptStatus();
      result = result * 59 + ($receiptStatus == null ? 43 : $receiptStatus.hashCode());
      Object $shipmentStatus = this.getShipmentStatus();
      result = result * 59 + ($shipmentStatus == null ? 43 : $shipmentStatus.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $driverName = this.getDriverName();
      result = result * 59 + ($driverName == null ? 43 : $driverName.hashCode());
      Object $driverPhone = this.getDriverPhone();
      result = result * 59 + ($driverPhone == null ? 43 : $driverPhone.hashCode());
      Object $actualWeight = this.getActualWeight();
      result = result * 59 + ($actualWeight == null ? 43 : $actualWeight.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $receiptName = this.getReceiptName();
      result = result * 59 + ($receiptName == null ? 43 : $receiptName.hashCode());
      Object $auditReceiptName = this.getAuditReceiptName();
      result = result * 59 + ($auditReceiptName == null ? 43 : $auditReceiptName.hashCode());
      Object $auditReceiptTime = this.getAuditReceiptTime();
      result = result * 59 + ($auditReceiptTime == null ? 43 : $auditReceiptTime.hashCode());
      Object $statusUpdateDate = this.getStatusUpdateDate();
      result = result * 59 + ($statusUpdateDate == null ? 43 : $statusUpdateDate.hashCode());
      Object $logisticsDTO = this.getLogisticsDTO();
      result = result * 59 + ($logisticsDTO == null ? 43 : $logisticsDTO.hashCode());
      Object $changeFreightReason = this.getChangeFreightReason();
      result = result * 59 + ($changeFreightReason == null ? 43 : $changeFreightReason.hashCode());
      Object $cancelDeliveryReason = this.getCancelDeliveryReason();
      return result * 59 + ($cancelDeliveryReason == null ? 43 : $cancelDeliveryReason.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListReceiptDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
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
         + ", actualWeight="
         + this.getActualWeight()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", receiptName="
         + this.getReceiptName()
         + ", auditReceiptName="
         + this.getAuditReceiptName()
         + ", auditReceiptTime="
         + this.getAuditReceiptTime()
         + ", receiptStatus="
         + this.getReceiptStatus()
         + ", shipmentStatus="
         + this.getShipmentStatus()
         + ", statusUpdateDate="
         + this.getStatusUpdateDate()
         + ", logisticsDTO="
         + this.getLogisticsDTO()
         + ", changeFreightReason="
         + this.getChangeFreightReason()
         + ", cancelDeliveryReason="
         + this.getCancelDeliveryReason()
         + ")";
   }
}
