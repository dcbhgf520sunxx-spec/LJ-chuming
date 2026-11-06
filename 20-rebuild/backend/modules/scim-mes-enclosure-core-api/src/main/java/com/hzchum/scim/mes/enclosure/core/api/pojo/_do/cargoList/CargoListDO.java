package com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(description = "发运清单列表")
public class CargoListDO {
   @ApiModelProperty("发货清单id")
   private Long id;
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty("运输方式 1运送到场 2客户自提")
   private Integer transportMode;
   @ApiModelProperty("结构计量方式 1理论计算 2磅记")
   private Integer structureMeasureMode;
   @ApiModelProperty("围护计量方式 1 长度计量 2 面积计量")
   private Integer enclosureMeasureMode;
   @ApiModelProperty("供应商")
   private SupplierPriceInfo supplier;
   @ApiModelProperty("车次编号")
   private String serialNumber;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("制造类型【1：自制，2：外包】")
   private Integer manufactureType;
   @ApiModelProperty("装载类型")
   private Integer productType;
   @ApiModelProperty("发运状态 [1 装车, 2 过磅，4发运，8收货 16 未装车]")
   private Integer status;
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
   @ApiModelProperty("装车人名称")
   private String userName;
   @ApiModelProperty("装车数量")
   private Integer quantity;
   @ApiModelProperty("装车时间（创建时间）")
   private LocalDateTime loadingTime;
   @ApiModelProperty("过磅人名称")
   private String actualUserName;
   @ApiModelProperty("过磅时间")
   private LocalDateTime actualTime;
   @ApiModelProperty("发运审核人名称")
   private String auditUserName;
   @ApiModelProperty("发运时间")
   private LocalDateTime auditTime;
   @ApiModelProperty("收货人")
   private String receiptName;
   @ApiModelProperty("收货人电话")
   private String receiptPhone;
   @ApiModelProperty("实际收货人名称")
   private String auditReceiptName;
   @ApiModelProperty("收货日期")
   private LocalDateTime auditReceiptTime;
   @ApiModelProperty("总价")
   private BigDecimal totalPrice;
   @ApiModelProperty("计价类型")
   private Integer priceType;
   @ApiModelProperty("车型")
   private String carModel;
   @ApiModelProperty("装载重量")
   private BigDecimal mete;
   @ApiModelProperty(name = "emptyCars", value = "空车重量 ", notes = "空车重量")
   private BigDecimal emptyCars;
   @ApiModelProperty("发运状态(发运记录)")
   private Integer deliveryStatus;
   @ApiModelProperty("发运状态(收货记录)")
   private Integer shipmentStatus;
   @ApiModelProperty("状态更新日期")
   private LocalDateTime statusUpdateDate;
   @ApiModelProperty("运费变更原因")
   private String changeFreightReason;
   @ApiModelProperty("取消送货原因")
   private String cancelDeliveryReason;
   @ApiModelProperty(name = "changeFreight", value = "运费变更类型")
   private Integer changeFreight;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getTransportMode() {
      return this.transportMode;
   }

   public Integer getStructureMeasureMode() {
      return this.structureMeasureMode;
   }

   public Integer getEnclosureMeasureMode() {
      return this.enclosureMeasureMode;
   }

   public SupplierPriceInfo getSupplier() {
      return this.supplier;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public Integer getManufactureType() {
      return this.manufactureType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getStatus() {
      return this.status;
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

   public String getUserName() {
      return this.userName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public LocalDateTime getLoadingTime() {
      return this.loadingTime;
   }

   public String getActualUserName() {
      return this.actualUserName;
   }

   public LocalDateTime getActualTime() {
      return this.actualTime;
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

   public String getReceiptPhone() {
      return this.receiptPhone;
   }

   public String getAuditReceiptName() {
      return this.auditReceiptName;
   }

   public LocalDateTime getAuditReceiptTime() {
      return this.auditReceiptTime;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
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

   public BigDecimal getEmptyCars() {
      return this.emptyCars;
   }

   public Integer getDeliveryStatus() {
      return this.deliveryStatus;
   }

   public Integer getShipmentStatus() {
      return this.shipmentStatus;
   }

   public LocalDateTime getStatusUpdateDate() {
      return this.statusUpdateDate;
   }

   public String getChangeFreightReason() {
      return this.changeFreightReason;
   }

   public String getCancelDeliveryReason() {
      return this.cancelDeliveryReason;
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

   public void setTransportMode(final Integer transportMode) {
      this.transportMode = transportMode;
   }

   public void setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
   }

   public void setEnclosureMeasureMode(final Integer enclosureMeasureMode) {
      this.enclosureMeasureMode = enclosureMeasureMode;
   }

   public void setSupplier(final SupplierPriceInfo supplier) {
      this.supplier = supplier;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setManufactureType(final Integer manufactureType) {
      this.manufactureType = manufactureType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setStatus(final Integer status) {
      this.status = status;
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

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setLoadingTime(final LocalDateTime loadingTime) {
      this.loadingTime = loadingTime;
   }

   public void setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
   }

   public void setActualTime(final LocalDateTime actualTime) {
      this.actualTime = actualTime;
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

   public void setReceiptPhone(final String receiptPhone) {
      this.receiptPhone = receiptPhone;
   }

   public void setAuditReceiptName(final String auditReceiptName) {
      this.auditReceiptName = auditReceiptName;
   }

   public void setAuditReceiptTime(final LocalDateTime auditReceiptTime) {
      this.auditReceiptTime = auditReceiptTime;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
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

   public void setEmptyCars(final BigDecimal emptyCars) {
      this.emptyCars = emptyCars;
   }

   public void setDeliveryStatus(final Integer deliveryStatus) {
      this.deliveryStatus = deliveryStatus;
   }

   public void setShipmentStatus(final Integer shipmentStatus) {
      this.shipmentStatus = shipmentStatus;
   }

   public void setStatusUpdateDate(final LocalDateTime statusUpdateDate) {
      this.statusUpdateDate = statusUpdateDate;
   }

   public void setChangeFreightReason(final String changeFreightReason) {
      this.changeFreightReason = changeFreightReason;
   }

   public void setCancelDeliveryReason(final String cancelDeliveryReason) {
      this.cancelDeliveryReason = cancelDeliveryReason;
   }

   public void setChangeFreight(final Integer changeFreight) {
      this.changeFreight = changeFreight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListDO)) {
         return false;
      }

      CargoListDO other = (CargoListDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$transportMode = this.getTransportMode();
         Object other$transportMode = other.getTransportMode();
         if (this$transportMode == null ? other$transportMode == null : this$transportMode.equals(other$transportMode)) {
            Object this$structureMeasureMode = this.getStructureMeasureMode();
            Object other$structureMeasureMode = other.getStructureMeasureMode();
            if (this$structureMeasureMode == null ? other$structureMeasureMode == null : this$structureMeasureMode.equals(other$structureMeasureMode)) {
               Object this$enclosureMeasureMode = this.getEnclosureMeasureMode();
               Object other$enclosureMeasureMode = other.getEnclosureMeasureMode();
               if (this$enclosureMeasureMode == null ? other$enclosureMeasureMode == null : this$enclosureMeasureMode.equals(other$enclosureMeasureMode)) {
                  Object this$manufactureType = this.getManufactureType();
                  Object other$manufactureType = other.getManufactureType();
                  if (this$manufactureType == null ? other$manufactureType == null : this$manufactureType.equals(other$manufactureType)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$priceType = this.getPriceType();
                              Object other$priceType = other.getPriceType();
                              if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
                                 Object this$deliveryStatus = this.getDeliveryStatus();
                                 Object other$deliveryStatus = other.getDeliveryStatus();
                                 if (this$deliveryStatus == null ? other$deliveryStatus == null : this$deliveryStatus.equals(other$deliveryStatus)) {
                                    Object this$shipmentStatus = this.getShipmentStatus();
                                    Object other$shipmentStatus = other.getShipmentStatus();
                                    if (this$shipmentStatus == null ? other$shipmentStatus == null : this$shipmentStatus.equals(other$shipmentStatus)) {
                                       Object this$changeFreight = this.getChangeFreight();
                                       Object other$changeFreight = other.getChangeFreight();
                                       if (this$changeFreight == null ? other$changeFreight == null : this$changeFreight.equals(other$changeFreight)) {
                                          Object this$project = this.getProject();
                                          Object other$project = other.getProject();
                                          if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                             Object this$supplier = this.getSupplier();
                                             Object other$supplier = other.getSupplier();
                                             if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
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
                                                            if (this$totalNetWeight == null
                                                               ? other$totalNetWeight == null
                                                               : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                               Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                               Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                               if (this$totalGrossWeight == null
                                                                  ? other$totalGrossWeight == null
                                                                  : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                  Object this$actualWeight = this.getActualWeight();
                                                                  Object other$actualWeight = other.getActualWeight();
                                                                  if (this$actualWeight == null
                                                                     ? other$actualWeight == null
                                                                     : this$actualWeight.equals(other$actualWeight)) {
                                                                     Object this$userName = this.getUserName();
                                                                     Object other$userName = other.getUserName();
                                                                     if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                                        Object this$loadingTime = this.getLoadingTime();
                                                                        Object other$loadingTime = other.getLoadingTime();
                                                                        if (this$loadingTime == null
                                                                           ? other$loadingTime == null
                                                                           : this$loadingTime.equals(other$loadingTime)) {
                                                                           Object this$actualUserName = this.getActualUserName();
                                                                           Object other$actualUserName = other.getActualUserName();
                                                                           if (this$actualUserName == null
                                                                              ? other$actualUserName == null
                                                                              : this$actualUserName.equals(other$actualUserName)) {
                                                                              Object this$actualTime = this.getActualTime();
                                                                              Object other$actualTime = other.getActualTime();
                                                                              if (this$actualTime == null
                                                                                 ? other$actualTime == null
                                                                                 : this$actualTime.equals(other$actualTime)) {
                                                                                 Object this$auditUserName = this.getAuditUserName();
                                                                                 Object other$auditUserName = other.getAuditUserName();
                                                                                 if (this$auditUserName == null
                                                                                    ? other$auditUserName == null
                                                                                    : this$auditUserName.equals(other$auditUserName)) {
                                                                                    Object this$auditTime = this.getAuditTime();
                                                                                    Object other$auditTime = other.getAuditTime();
                                                                                    if (this$auditTime == null
                                                                                       ? other$auditTime == null
                                                                                       : this$auditTime.equals(other$auditTime)) {
                                                                                       Object this$receiptName = this.getReceiptName();
                                                                                       Object other$receiptName = other.getReceiptName();
                                                                                       if (this$receiptName == null
                                                                                          ? other$receiptName == null
                                                                                          : this$receiptName.equals(other$receiptName)) {
                                                                                          Object this$receiptPhone = this.getReceiptPhone();
                                                                                          Object other$receiptPhone = other.getReceiptPhone();
                                                                                          if (this$receiptPhone == null
                                                                                             ? other$receiptPhone == null
                                                                                             : this$receiptPhone.equals(other$receiptPhone)) {
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
                                                                                                   Object this$totalPrice = this.getTotalPrice();
                                                                                                   Object other$totalPrice = other.getTotalPrice();
                                                                                                   if (this$totalPrice == null
                                                                                                      ? other$totalPrice == null
                                                                                                      : this$totalPrice.equals(other$totalPrice)) {
                                                                                                      Object this$carModel = this.getCarModel();
                                                                                                      Object other$carModel = other.getCarModel();
                                                                                                      if (this$carModel == null
                                                                                                         ? other$carModel == null
                                                                                                         : this$carModel.equals(other$carModel)) {
                                                                                                         Object this$mete = this.getMete();
                                                                                                         Object other$mete = other.getMete();
                                                                                                         if (this$mete == null
                                                                                                            ? other$mete == null
                                                                                                            : this$mete.equals(other$mete)) {
                                                                                                            Object this$emptyCars = this.getEmptyCars();
                                                                                                            Object other$emptyCars = other.getEmptyCars();
                                                                                                            if (this$emptyCars == null
                                                                                                               ? other$emptyCars == null
                                                                                                               : this$emptyCars.equals(other$emptyCars)) {
                                                                                                               Object this$statusUpdateDate = this.getStatusUpdateDate();
                                                                                                               Object other$statusUpdateDate = other.getStatusUpdateDate();
                                                                                                               if (this$statusUpdateDate == null
                                                                                                                  ? other$statusUpdateDate == null
                                                                                                                  : this$statusUpdateDate.equals(
                                                                                                                     other$statusUpdateDate
                                                                                                                  )) {
                                                                                                                  Object this$changeFreightReason = this.getChangeFreightReason();
                                                                                                                  Object other$changeFreightReason = other.getChangeFreightReason();
                                                                                                                  if (this$changeFreightReason == null
                                                                                                                     ? other$changeFreightReason == null
                                                                                                                     : this$changeFreightReason.equals(
                                                                                                                        other$changeFreightReason
                                                                                                                     )) {
                                                                                                                     Object this$cancelDeliveryReason = this.getCancelDeliveryReason();
                                                                                                                     Object other$cancelDeliveryReason = other.getCancelDeliveryReason();
                                                                                                                     return this$cancelDeliveryReason == null
                                                                                                                        ? other$cancelDeliveryReason == null
                                                                                                                        : this$cancelDeliveryReason.equals(
                                                                                                                           other$cancelDeliveryReason
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CargoListDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $transportMode = this.getTransportMode();
      result = result * 59 + ($transportMode == null ? 43 : $transportMode.hashCode());
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $enclosureMeasureMode = this.getEnclosureMeasureMode();
      result = result * 59 + ($enclosureMeasureMode == null ? 43 : $enclosureMeasureMode.hashCode());
      Object $manufactureType = this.getManufactureType();
      result = result * 59 + ($manufactureType == null ? 43 : $manufactureType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $deliveryStatus = this.getDeliveryStatus();
      result = result * 59 + ($deliveryStatus == null ? 43 : $deliveryStatus.hashCode());
      Object $shipmentStatus = this.getShipmentStatus();
      result = result * 59 + ($shipmentStatus == null ? 43 : $shipmentStatus.hashCode());
      Object $changeFreight = this.getChangeFreight();
      result = result * 59 + ($changeFreight == null ? 43 : $changeFreight.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
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
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $loadingTime = this.getLoadingTime();
      result = result * 59 + ($loadingTime == null ? 43 : $loadingTime.hashCode());
      Object $actualUserName = this.getActualUserName();
      result = result * 59 + ($actualUserName == null ? 43 : $actualUserName.hashCode());
      Object $actualTime = this.getActualTime();
      result = result * 59 + ($actualTime == null ? 43 : $actualTime.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $receiptName = this.getReceiptName();
      result = result * 59 + ($receiptName == null ? 43 : $receiptName.hashCode());
      Object $receiptPhone = this.getReceiptPhone();
      result = result * 59 + ($receiptPhone == null ? 43 : $receiptPhone.hashCode());
      Object $auditReceiptName = this.getAuditReceiptName();
      result = result * 59 + ($auditReceiptName == null ? 43 : $auditReceiptName.hashCode());
      Object $auditReceiptTime = this.getAuditReceiptTime();
      result = result * 59 + ($auditReceiptTime == null ? 43 : $auditReceiptTime.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $carModel = this.getCarModel();
      result = result * 59 + ($carModel == null ? 43 : $carModel.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $emptyCars = this.getEmptyCars();
      result = result * 59 + ($emptyCars == null ? 43 : $emptyCars.hashCode());
      Object $statusUpdateDate = this.getStatusUpdateDate();
      result = result * 59 + ($statusUpdateDate == null ? 43 : $statusUpdateDate.hashCode());
      Object $changeFreightReason = this.getChangeFreightReason();
      result = result * 59 + ($changeFreightReason == null ? 43 : $changeFreightReason.hashCode());
      Object $cancelDeliveryReason = this.getCancelDeliveryReason();
      return result * 59 + ($cancelDeliveryReason == null ? 43 : $cancelDeliveryReason.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListDO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", transportMode="
         + this.getTransportMode()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", enclosureMeasureMode="
         + this.getEnclosureMeasureMode()
         + ", supplier="
         + this.getSupplier()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", manufactureType="
         + this.getManufactureType()
         + ", productType="
         + this.getProductType()
         + ", status="
         + this.getStatus()
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
         + ", userName="
         + this.getUserName()
         + ", quantity="
         + this.getQuantity()
         + ", loadingTime="
         + this.getLoadingTime()
         + ", actualUserName="
         + this.getActualUserName()
         + ", actualTime="
         + this.getActualTime()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", receiptName="
         + this.getReceiptName()
         + ", receiptPhone="
         + this.getReceiptPhone()
         + ", auditReceiptName="
         + this.getAuditReceiptName()
         + ", auditReceiptTime="
         + this.getAuditReceiptTime()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", priceType="
         + this.getPriceType()
         + ", carModel="
         + this.getCarModel()
         + ", mete="
         + this.getMete()
         + ", emptyCars="
         + this.getEmptyCars()
         + ", deliveryStatus="
         + this.getDeliveryStatus()
         + ", shipmentStatus="
         + this.getShipmentStatus()
         + ", statusUpdateDate="
         + this.getStatusUpdateDate()
         + ", changeFreightReason="
         + this.getChangeFreightReason()
         + ", cancelDeliveryReason="
         + this.getCancelDeliveryReason()
         + ", changeFreight="
         + this.getChangeFreight()
         + ")";
   }
}
