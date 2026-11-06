package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.SupplierPriceInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(description = "发运记录")
public class CargoListShipDTO {
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
   @ApiModelProperty("供应商")
   private SupplierPriceInfo supplier;
   @ApiModelProperty("总净重量")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("总毛重量")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty("过磅重量")
   private BigDecimal actualWeight;
   @ApiModelProperty("总长度")
   private BigDecimal totalLength;
   @ApiModelProperty("装车人名称")
   private String userName;
   @ApiModelProperty(name = "userNames", value = "历史装车人名称(多个以逗号分隔)", notes = "历史装车人名称(多个以逗号分隔)")
   private String userNames;
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
   @ApiModelProperty("发运状态")
   private Integer deliveryStatus;
   @ApiModelProperty("运费变更原因")
   private String changeFreightReason;
   @ApiModelProperty("取消送货原因")
   private String cancelDeliveryReason;
   @ApiModelProperty(name = "actualGrossWeight", value = "过磅毛重", notes = "过磅毛重")
   private BigDecimal actualGrossWeight;
   @ApiModelProperty(name = "emptyCars", value = "空车重量 ", notes = "空车重量")
   private BigDecimal emptyCars;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty("发运是否审核通过")
   private Integer checkStatus;
   @ApiModelProperty("发运状态 [1 装车, 2 过磅，4发运，8收货 16 未装车]")
   private Integer status;
   @ApiModelProperty(name = "emissionQuantity", value = "车次数")
   private Integer emissionQuantity;
   @ApiModelProperty("计价类型")
   private Integer priceType;
   @ApiModelProperty("收货人")
   private String receiptName;
   @ApiModelProperty("收货人电话")
   private String receiptPhone;
   @ApiModelProperty("实际收货人名称")
   private String auditReceiptName;
   @ApiModelProperty("收货单位")
   private String receiptUnit;
   @ApiModelProperty("收货状态 1 已收货 2 未收货")
   private Integer receiptStatus;
   @ApiModelProperty("物流详情")
   private CargoLogisticsDTO logisticsDTO;
   @ApiModelProperty("附件列表")
   private List<AttachmentDTO> attachmentList;

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

   public SupplierPriceInfo getSupplier() {
      return this.supplier;
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

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getUserNames() {
      return this.userNames;
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

   public Integer getDeliveryStatus() {
      return this.deliveryStatus;
   }

   public String getChangeFreightReason() {
      return this.changeFreightReason;
   }

   public String getCancelDeliveryReason() {
      return this.cancelDeliveryReason;
   }

   public BigDecimal getActualGrossWeight() {
      return this.actualGrossWeight;
   }

   public BigDecimal getEmptyCars() {
      return this.emptyCars;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getCheckStatus() {
      return this.checkStatus;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getEmissionQuantity() {
      return this.emissionQuantity;
   }

   public Integer getPriceType() {
      return this.priceType;
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

   public String getReceiptUnit() {
      return this.receiptUnit;
   }

   public Integer getReceiptStatus() {
      return this.receiptStatus;
   }

   public CargoLogisticsDTO getLogisticsDTO() {
      return this.logisticsDTO;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
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

   public void setSupplier(final SupplierPriceInfo supplier) {
      this.supplier = supplier;
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

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setUserNames(final String userNames) {
      this.userNames = userNames;
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

   public void setDeliveryStatus(final Integer deliveryStatus) {
      this.deliveryStatus = deliveryStatus;
   }

   public void setChangeFreightReason(final String changeFreightReason) {
      this.changeFreightReason = changeFreightReason;
   }

   public void setCancelDeliveryReason(final String cancelDeliveryReason) {
      this.cancelDeliveryReason = cancelDeliveryReason;
   }

   public void setActualGrossWeight(final BigDecimal actualGrossWeight) {
      this.actualGrossWeight = actualGrossWeight;
   }

   public void setEmptyCars(final BigDecimal emptyCars) {
      this.emptyCars = emptyCars;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCheckStatus(final Integer checkStatus) {
      this.checkStatus = checkStatus;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setEmissionQuantity(final Integer emissionQuantity) {
      this.emissionQuantity = emissionQuantity;
   }

   public void setPriceType(final Integer priceType) {
      this.priceType = priceType;
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

   public void setReceiptUnit(final String receiptUnit) {
      this.receiptUnit = receiptUnit;
   }

   public void setReceiptStatus(final Integer receiptStatus) {
      this.receiptStatus = receiptStatus;
   }

   public void setLogisticsDTO(final CargoLogisticsDTO logisticsDTO) {
      this.logisticsDTO = logisticsDTO;
   }

   public void setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListShipDTO)) {
         return false;
      }

      CargoListShipDTO other = (CargoListShipDTO)o;
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
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$deliveryStatus = this.getDeliveryStatus();
                  Object other$deliveryStatus = other.getDeliveryStatus();
                  if (this$deliveryStatus == null ? other$deliveryStatus == null : this$deliveryStatus.equals(other$deliveryStatus)) {
                     Object this$checkStatus = this.getCheckStatus();
                     Object other$checkStatus = other.getCheckStatus();
                     if (this$checkStatus == null ? other$checkStatus == null : this$checkStatus.equals(other$checkStatus)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$emissionQuantity = this.getEmissionQuantity();
                           Object other$emissionQuantity = other.getEmissionQuantity();
                           if (this$emissionQuantity == null ? other$emissionQuantity == null : this$emissionQuantity.equals(other$emissionQuantity)) {
                              Object this$priceType = this.getPriceType();
                              Object other$priceType = other.getPriceType();
                              if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
                                 Object this$receiptStatus = this.getReceiptStatus();
                                 Object other$receiptStatus = other.getReceiptStatus();
                                 if (this$receiptStatus == null ? other$receiptStatus == null : this$receiptStatus.equals(other$receiptStatus)) {
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
                                                   Object this$supplier = this.getSupplier();
                                                   Object other$supplier = other.getSupplier();
                                                   if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
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
                                                               Object this$totalLength = this.getTotalLength();
                                                               Object other$totalLength = other.getTotalLength();
                                                               if (this$totalLength == null
                                                                  ? other$totalLength == null
                                                                  : this$totalLength.equals(other$totalLength)) {
                                                                  Object this$userName = this.getUserName();
                                                                  Object other$userName = other.getUserName();
                                                                  if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                                     Object this$userNames = this.getUserNames();
                                                                     Object other$userNames = other.getUserNames();
                                                                     if (this$userNames == null
                                                                        ? other$userNames == null
                                                                        : this$userNames.equals(other$userNames)) {
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
                                                                                       Object this$changeFreightReason = this.getChangeFreightReason();
                                                                                       Object other$changeFreightReason = other.getChangeFreightReason();
                                                                                       if (this$changeFreightReason == null
                                                                                          ? other$changeFreightReason == null
                                                                                          : this$changeFreightReason.equals(other$changeFreightReason)) {
                                                                                          Object this$cancelDeliveryReason = this.getCancelDeliveryReason();
                                                                                          Object other$cancelDeliveryReason = other.getCancelDeliveryReason();
                                                                                          if (this$cancelDeliveryReason == null
                                                                                             ? other$cancelDeliveryReason == null
                                                                                             : this$cancelDeliveryReason.equals(other$cancelDeliveryReason)) {
                                                                                             Object this$actualGrossWeight = this.getActualGrossWeight();
                                                                                             Object other$actualGrossWeight = other.getActualGrossWeight();
                                                                                             if (this$actualGrossWeight == null
                                                                                                ? other$actualGrossWeight == null
                                                                                                : this$actualGrossWeight.equals(other$actualGrossWeight)) {
                                                                                                Object this$emptyCars = this.getEmptyCars();
                                                                                                Object other$emptyCars = other.getEmptyCars();
                                                                                                if (this$emptyCars == null
                                                                                                   ? other$emptyCars == null
                                                                                                   : this$emptyCars.equals(other$emptyCars)) {
                                                                                                   Object this$remark = this.getRemark();
                                                                                                   Object other$remark = other.getRemark();
                                                                                                   if (this$remark == null
                                                                                                      ? other$remark == null
                                                                                                      : this$remark.equals(other$remark)) {
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
                                                                                                               : this$auditReceiptName.equals(
                                                                                                                  other$auditReceiptName
                                                                                                               )) {
                                                                                                               Object this$receiptUnit = this.getReceiptUnit();
                                                                                                               Object other$receiptUnit = other.getReceiptUnit();
                                                                                                               if (this$receiptUnit == null
                                                                                                                  ? other$receiptUnit == null
                                                                                                                  : this$receiptUnit.equals(other$receiptUnit)) {
                                                                                                                  Object this$logisticsDTO = this.getLogisticsDTO();
                                                                                                                  Object other$logisticsDTO = other.getLogisticsDTO();
                                                                                                                  if (this$logisticsDTO == null
                                                                                                                     ? other$logisticsDTO == null
                                                                                                                     : this$logisticsDTO.equals(
                                                                                                                        other$logisticsDTO
                                                                                                                     )) {
                                                                                                                     Object this$attachmentList = this.getAttachmentList();
                                                                                                                     Object other$attachmentList = other.getAttachmentList();
                                                                                                                     return this$attachmentList == null
                                                                                                                        ? other$attachmentList == null
                                                                                                                        : this$attachmentList.equals(
                                                                                                                           other$attachmentList
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
      return other instanceof CargoListShipDTO;
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
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $deliveryStatus = this.getDeliveryStatus();
      result = result * 59 + ($deliveryStatus == null ? 43 : $deliveryStatus.hashCode());
      Object $checkStatus = this.getCheckStatus();
      result = result * 59 + ($checkStatus == null ? 43 : $checkStatus.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $emissionQuantity = this.getEmissionQuantity();
      result = result * 59 + ($emissionQuantity == null ? 43 : $emissionQuantity.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $receiptStatus = this.getReceiptStatus();
      result = result * 59 + ($receiptStatus == null ? 43 : $receiptStatus.hashCode());
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
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $actualWeight = this.getActualWeight();
      result = result * 59 + ($actualWeight == null ? 43 : $actualWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $userNames = this.getUserNames();
      result = result * 59 + ($userNames == null ? 43 : $userNames.hashCode());
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
      Object $changeFreightReason = this.getChangeFreightReason();
      result = result * 59 + ($changeFreightReason == null ? 43 : $changeFreightReason.hashCode());
      Object $cancelDeliveryReason = this.getCancelDeliveryReason();
      result = result * 59 + ($cancelDeliveryReason == null ? 43 : $cancelDeliveryReason.hashCode());
      Object $actualGrossWeight = this.getActualGrossWeight();
      result = result * 59 + ($actualGrossWeight == null ? 43 : $actualGrossWeight.hashCode());
      Object $emptyCars = this.getEmptyCars();
      result = result * 59 + ($emptyCars == null ? 43 : $emptyCars.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $receiptName = this.getReceiptName();
      result = result * 59 + ($receiptName == null ? 43 : $receiptName.hashCode());
      Object $receiptPhone = this.getReceiptPhone();
      result = result * 59 + ($receiptPhone == null ? 43 : $receiptPhone.hashCode());
      Object $auditReceiptName = this.getAuditReceiptName();
      result = result * 59 + ($auditReceiptName == null ? 43 : $auditReceiptName.hashCode());
      Object $receiptUnit = this.getReceiptUnit();
      result = result * 59 + ($receiptUnit == null ? 43 : $receiptUnit.hashCode());
      Object $logisticsDTO = this.getLogisticsDTO();
      result = result * 59 + ($logisticsDTO == null ? 43 : $logisticsDTO.hashCode());
      Object $attachmentList = this.getAttachmentList();
      return result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListShipDTO(id="
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
         + ", supplier="
         + this.getSupplier()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", actualWeight="
         + this.getActualWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", userName="
         + this.getUserName()
         + ", userNames="
         + this.getUserNames()
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
         + ", deliveryStatus="
         + this.getDeliveryStatus()
         + ", changeFreightReason="
         + this.getChangeFreightReason()
         + ", cancelDeliveryReason="
         + this.getCancelDeliveryReason()
         + ", actualGrossWeight="
         + this.getActualGrossWeight()
         + ", emptyCars="
         + this.getEmptyCars()
         + ", remark="
         + this.getRemark()
         + ", checkStatus="
         + this.getCheckStatus()
         + ", status="
         + this.getStatus()
         + ", emissionQuantity="
         + this.getEmissionQuantity()
         + ", priceType="
         + this.getPriceType()
         + ", receiptName="
         + this.getReceiptName()
         + ", receiptPhone="
         + this.getReceiptPhone()
         + ", auditReceiptName="
         + this.getAuditReceiptName()
         + ", receiptUnit="
         + this.getReceiptUnit()
         + ", receiptStatus="
         + this.getReceiptStatus()
         + ", logisticsDTO="
         + this.getLogisticsDTO()
         + ", attachmentList="
         + this.getAttachmentList()
         + ")";
   }
}
