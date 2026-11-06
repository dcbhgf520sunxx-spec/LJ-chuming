package com.hzchum.scim.mes.building.core.api.pojo._doParam.cargoList;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.ShipmentStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("发运条件查询")
public class CargoListDOParam {
   @ApiModelProperty("发运清单ids 用户发运记录名称编号查询")
   private List<Long> ids;
   @ApiModelProperty("项目ids 用于物流详情运输方式、车次跟踪查询")
   private List<Long> projectIds;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty(notes = "物流价格id")
   private Long supplierPriceId;
   @ApiModelProperty("制造类型【1：自制，2：外包】")
   private Integer manufactureType;
   @ApiModelProperty("装载类型")
   private Integer productType;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(notes = "发运状态 [1 装车, 2 过磅，4发运，8收货]")
   private Integer status;
   @ApiModelProperty("车次编号")
   private String serialNumber;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("司机名称")
   private String driverName;
   @ApiModelProperty("装车人")
   private String userName;
   @ApiModelProperty("装车开始时间")
   private LocalDateTime startDate;
   @ApiModelProperty("装车结束时间")
   private LocalDateTime endDate;
   @ApiModelProperty("过磅人")
   private String actualUserName;
   @ApiModelProperty("过磅开始时间")
   private LocalDateTime actualStartDate;
   @ApiModelProperty("过磅结束时间")
   private LocalDateTime actualEndDate;
   @ApiModelProperty("发运人")
   private String auditUserName;
   @ApiModelProperty("计价类型")
   private Integer priceType;
   @ApiModelProperty("发运开始时间")
   private LocalDateTime auditStartDate;
   @ApiModelProperty("发运结束时间")
   private LocalDateTime auditEndDate;
   @ApiModelProperty("收货人")
   private String receiptName;
   @ApiModelProperty("实际收货人名称")
   private String auditReceiptName;
   @ApiModelProperty("收货开始日期")
   private LocalDateTime auditReceiptStartDate;
   @ApiModelProperty("收货结束日期")
   private LocalDateTime auditReceiptEndDate;
   @ApiModelProperty("供应商名称")
   private String supplierName;
   @ApiModelProperty("发运状态(发运记录)")
   private Integer deliveryStatus;
   @ApiModelProperty("差值率起点")
   private Double minNum;
   @ApiModelProperty("差值率终点")
   private Double maxNum;
   @EnumValidator(value = ShipmentStatusEnum.class, message = "发运状态类型不支持")
   @ApiModelProperty("发运状态(收货状态)")
   private Integer shipmentStatus;
   @ApiModelProperty("状态更新开始日期")
   private LocalDateTime statusUpdateStartDate;
   @ApiModelProperty("状态更新结束日期")
   private LocalDateTime statusUpdateEndDate;
   @ApiModelProperty("项目类型")
   private Integer projectType;
   @ApiModelProperty(notes = "页码")
   Integer pageNumber = 1;
   @ApiModelProperty(notes = "页数")
   Integer pageSize = 10;
   @ApiModelProperty(notes = "排序")
   List<String> sort;
   @ApiModelProperty("是否精确查询")
   private Boolean boolAccurateQuery = Boolean.FALSE;

   public List<Long> getIds() {
      return this.ids;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getSupplierPriceId() {
      return this.supplierPriceId;
   }

   public Integer getManufactureType() {
      return this.manufactureType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getStatus() {
      return this.status;
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

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public String getActualUserName() {
      return this.actualUserName;
   }

   public LocalDateTime getActualStartDate() {
      return this.actualStartDate;
   }

   public LocalDateTime getActualEndDate() {
      return this.actualEndDate;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public LocalDateTime getAuditStartDate() {
      return this.auditStartDate;
   }

   public LocalDateTime getAuditEndDate() {
      return this.auditEndDate;
   }

   public String getReceiptName() {
      return this.receiptName;
   }

   public String getAuditReceiptName() {
      return this.auditReceiptName;
   }

   public LocalDateTime getAuditReceiptStartDate() {
      return this.auditReceiptStartDate;
   }

   public LocalDateTime getAuditReceiptEndDate() {
      return this.auditReceiptEndDate;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getDeliveryStatus() {
      return this.deliveryStatus;
   }

   public Double getMinNum() {
      return this.minNum;
   }

   public Double getMaxNum() {
      return this.maxNum;
   }

   public Integer getShipmentStatus() {
      return this.shipmentStatus;
   }

   public LocalDateTime getStatusUpdateStartDate() {
      return this.statusUpdateStartDate;
   }

   public LocalDateTime getStatusUpdateEndDate() {
      return this.statusUpdateEndDate;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public List<String> getSort() {
      return this.sort;
   }

   public Boolean getBoolAccurateQuery() {
      return this.boolAccurateQuery;
   }

   public void setIds(final List<Long> ids) {
      this.ids = ids;
   }

   public void setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setSupplierPriceId(final Long supplierPriceId) {
      this.supplierPriceId = supplierPriceId;
   }

   public void setManufactureType(final Integer manufactureType) {
      this.manufactureType = manufactureType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setStatus(final Integer status) {
      this.status = status;
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

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
   }

   public void setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
   }

   public void setActualStartDate(final LocalDateTime actualStartDate) {
      this.actualStartDate = actualStartDate;
   }

   public void setActualEndDate(final LocalDateTime actualEndDate) {
      this.actualEndDate = actualEndDate;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setPriceType(final Integer priceType) {
      this.priceType = priceType;
   }

   public void setAuditStartDate(final LocalDateTime auditStartDate) {
      this.auditStartDate = auditStartDate;
   }

   public void setAuditEndDate(final LocalDateTime auditEndDate) {
      this.auditEndDate = auditEndDate;
   }

   public void setReceiptName(final String receiptName) {
      this.receiptName = receiptName;
   }

   public void setAuditReceiptName(final String auditReceiptName) {
      this.auditReceiptName = auditReceiptName;
   }

   public void setAuditReceiptStartDate(final LocalDateTime auditReceiptStartDate) {
      this.auditReceiptStartDate = auditReceiptStartDate;
   }

   public void setAuditReceiptEndDate(final LocalDateTime auditReceiptEndDate) {
      this.auditReceiptEndDate = auditReceiptEndDate;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setDeliveryStatus(final Integer deliveryStatus) {
      this.deliveryStatus = deliveryStatus;
   }

   public void setMinNum(final Double minNum) {
      this.minNum = minNum;
   }

   public void setMaxNum(final Double maxNum) {
      this.maxNum = maxNum;
   }

   public void setShipmentStatus(final Integer shipmentStatus) {
      this.shipmentStatus = shipmentStatus;
   }

   public void setStatusUpdateStartDate(final LocalDateTime statusUpdateStartDate) {
      this.statusUpdateStartDate = statusUpdateStartDate;
   }

   public void setStatusUpdateEndDate(final LocalDateTime statusUpdateEndDate) {
      this.statusUpdateEndDate = statusUpdateEndDate;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   public void setSort(final List<String> sort) {
      this.sort = sort;
   }

   public void setBoolAccurateQuery(final Boolean boolAccurateQuery) {
      this.boolAccurateQuery = boolAccurateQuery;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListDOParam)) {
         return false;
      }

      CargoListDOParam other = (CargoListDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$supplierPriceId = this.getSupplierPriceId();
            Object other$supplierPriceId = other.getSupplierPriceId();
            if (this$supplierPriceId == null ? other$supplierPriceId == null : this$supplierPriceId.equals(other$supplierPriceId)) {
               Object this$manufactureType = this.getManufactureType();
               Object other$manufactureType = other.getManufactureType();
               if (this$manufactureType == null ? other$manufactureType == null : this$manufactureType.equals(other$manufactureType)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$priceType = this.getPriceType();
                           Object other$priceType = other.getPriceType();
                           if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
                              Object this$deliveryStatus = this.getDeliveryStatus();
                              Object other$deliveryStatus = other.getDeliveryStatus();
                              if (this$deliveryStatus == null ? other$deliveryStatus == null : this$deliveryStatus.equals(other$deliveryStatus)) {
                                 Object this$minNum = this.getMinNum();
                                 Object other$minNum = other.getMinNum();
                                 if (this$minNum == null ? other$minNum == null : this$minNum.equals(other$minNum)) {
                                    Object this$maxNum = this.getMaxNum();
                                    Object other$maxNum = other.getMaxNum();
                                    if (this$maxNum == null ? other$maxNum == null : this$maxNum.equals(other$maxNum)) {
                                       Object this$shipmentStatus = this.getShipmentStatus();
                                       Object other$shipmentStatus = other.getShipmentStatus();
                                       if (this$shipmentStatus == null ? other$shipmentStatus == null : this$shipmentStatus.equals(other$shipmentStatus)) {
                                          Object this$projectType = this.getProjectType();
                                          Object other$projectType = other.getProjectType();
                                          if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                                             Object this$pageNumber = this.getPageNumber();
                                             Object other$pageNumber = other.getPageNumber();
                                             if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                                                Object this$pageSize = this.getPageSize();
                                                Object other$pageSize = other.getPageSize();
                                                if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                                                   Object this$boolAccurateQuery = this.getBoolAccurateQuery();
                                                   Object other$boolAccurateQuery = other.getBoolAccurateQuery();
                                                   if (this$boolAccurateQuery == null
                                                      ? other$boolAccurateQuery == null
                                                      : this$boolAccurateQuery.equals(other$boolAccurateQuery)) {
                                                      Object this$ids = this.getIds();
                                                      Object other$ids = other.getIds();
                                                      if (this$ids == null ? other$ids == null : this$ids.equals(other$ids)) {
                                                         Object this$projectIds = this.getProjectIds();
                                                         Object other$projectIds = other.getProjectIds();
                                                         if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                                            Object this$serialNumber = this.getSerialNumber();
                                                            Object other$serialNumber = other.getSerialNumber();
                                                            if (this$serialNumber == null
                                                               ? other$serialNumber == null
                                                               : this$serialNumber.equals(other$serialNumber)) {
                                                               Object this$licensePlate = this.getLicensePlate();
                                                               Object other$licensePlate = other.getLicensePlate();
                                                               if (this$licensePlate == null
                                                                  ? other$licensePlate == null
                                                                  : this$licensePlate.equals(other$licensePlate)) {
                                                                  Object this$driverName = this.getDriverName();
                                                                  Object other$driverName = other.getDriverName();
                                                                  if (this$driverName == null
                                                                     ? other$driverName == null
                                                                     : this$driverName.equals(other$driverName)) {
                                                                     Object this$userName = this.getUserName();
                                                                     Object other$userName = other.getUserName();
                                                                     if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                                        Object this$startDate = this.getStartDate();
                                                                        Object other$startDate = other.getStartDate();
                                                                        if (this$startDate == null
                                                                           ? other$startDate == null
                                                                           : this$startDate.equals(other$startDate)) {
                                                                           Object this$endDate = this.getEndDate();
                                                                           Object other$endDate = other.getEndDate();
                                                                           if (this$endDate == null
                                                                              ? other$endDate == null
                                                                              : this$endDate.equals(other$endDate)) {
                                                                              Object this$actualUserName = this.getActualUserName();
                                                                              Object other$actualUserName = other.getActualUserName();
                                                                              if (this$actualUserName == null
                                                                                 ? other$actualUserName == null
                                                                                 : this$actualUserName.equals(other$actualUserName)) {
                                                                                 Object this$actualStartDate = this.getActualStartDate();
                                                                                 Object other$actualStartDate = other.getActualStartDate();
                                                                                 if (this$actualStartDate == null
                                                                                    ? other$actualStartDate == null
                                                                                    : this$actualStartDate.equals(other$actualStartDate)) {
                                                                                    Object this$actualEndDate = this.getActualEndDate();
                                                                                    Object other$actualEndDate = other.getActualEndDate();
                                                                                    if (this$actualEndDate == null
                                                                                       ? other$actualEndDate == null
                                                                                       : this$actualEndDate.equals(other$actualEndDate)) {
                                                                                       Object this$auditUserName = this.getAuditUserName();
                                                                                       Object other$auditUserName = other.getAuditUserName();
                                                                                       if (this$auditUserName == null
                                                                                          ? other$auditUserName == null
                                                                                          : this$auditUserName.equals(other$auditUserName)) {
                                                                                          Object this$auditStartDate = this.getAuditStartDate();
                                                                                          Object other$auditStartDate = other.getAuditStartDate();
                                                                                          if (this$auditStartDate == null
                                                                                             ? other$auditStartDate == null
                                                                                             : this$auditStartDate.equals(other$auditStartDate)) {
                                                                                             Object this$auditEndDate = this.getAuditEndDate();
                                                                                             Object other$auditEndDate = other.getAuditEndDate();
                                                                                             if (this$auditEndDate == null
                                                                                                ? other$auditEndDate == null
                                                                                                : this$auditEndDate.equals(other$auditEndDate)) {
                                                                                                Object this$receiptName = this.getReceiptName();
                                                                                                Object other$receiptName = other.getReceiptName();
                                                                                                if (this$receiptName == null
                                                                                                   ? other$receiptName == null
                                                                                                   : this$receiptName.equals(other$receiptName)) {
                                                                                                   Object this$auditReceiptName = this.getAuditReceiptName();
                                                                                                   Object other$auditReceiptName = other.getAuditReceiptName();
                                                                                                   if (this$auditReceiptName == null
                                                                                                      ? other$auditReceiptName == null
                                                                                                      : this$auditReceiptName.equals(other$auditReceiptName)) {
                                                                                                      Object this$auditReceiptStartDate = this.getAuditReceiptStartDate();
                                                                                                      Object other$auditReceiptStartDate = other.getAuditReceiptStartDate();
                                                                                                      if (this$auditReceiptStartDate == null
                                                                                                         ? other$auditReceiptStartDate == null
                                                                                                         : this$auditReceiptStartDate.equals(
                                                                                                            other$auditReceiptStartDate
                                                                                                         )) {
                                                                                                         Object this$auditReceiptEndDate = this.getAuditReceiptEndDate();
                                                                                                         Object other$auditReceiptEndDate = other.getAuditReceiptEndDate();
                                                                                                         if (this$auditReceiptEndDate == null
                                                                                                            ? other$auditReceiptEndDate == null
                                                                                                            : this$auditReceiptEndDate.equals(
                                                                                                               other$auditReceiptEndDate
                                                                                                            )) {
                                                                                                            Object this$supplierName = this.getSupplierName();
                                                                                                            Object other$supplierName = other.getSupplierName();
                                                                                                            if (this$supplierName == null
                                                                                                               ? other$supplierName == null
                                                                                                               : this$supplierName.equals(other$supplierName)) {
                                                                                                               Object this$statusUpdateStartDate = this.getStatusUpdateStartDate();
                                                                                                               Object other$statusUpdateStartDate = other.getStatusUpdateStartDate();
                                                                                                               if (this$statusUpdateStartDate == null
                                                                                                                  ? other$statusUpdateStartDate == null
                                                                                                                  : this$statusUpdateStartDate.equals(
                                                                                                                     other$statusUpdateStartDate
                                                                                                                  )) {
                                                                                                                  Object this$statusUpdateEndDate = this.getStatusUpdateEndDate();
                                                                                                                  Object other$statusUpdateEndDate = other.getStatusUpdateEndDate();
                                                                                                                  if (this$statusUpdateEndDate == null
                                                                                                                     ? other$statusUpdateEndDate == null
                                                                                                                     : this$statusUpdateEndDate.equals(
                                                                                                                        other$statusUpdateEndDate
                                                                                                                     )) {
                                                                                                                     Object this$sort = this.getSort();
                                                                                                                     Object other$sort = other.getSort();
                                                                                                                     return this$sort == null
                                                                                                                        ? other$sort == null
                                                                                                                        : this$sort.equals(other$sort);
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
      return other instanceof CargoListDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $supplierPriceId = this.getSupplierPriceId();
      result = result * 59 + ($supplierPriceId == null ? 43 : $supplierPriceId.hashCode());
      Object $manufactureType = this.getManufactureType();
      result = result * 59 + ($manufactureType == null ? 43 : $manufactureType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $deliveryStatus = this.getDeliveryStatus();
      result = result * 59 + ($deliveryStatus == null ? 43 : $deliveryStatus.hashCode());
      Object $minNum = this.getMinNum();
      result = result * 59 + ($minNum == null ? 43 : $minNum.hashCode());
      Object $maxNum = this.getMaxNum();
      result = result * 59 + ($maxNum == null ? 43 : $maxNum.hashCode());
      Object $shipmentStatus = this.getShipmentStatus();
      result = result * 59 + ($shipmentStatus == null ? 43 : $shipmentStatus.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $boolAccurateQuery = this.getBoolAccurateQuery();
      result = result * 59 + ($boolAccurateQuery == null ? 43 : $boolAccurateQuery.hashCode());
      Object $ids = this.getIds();
      result = result * 59 + ($ids == null ? 43 : $ids.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $driverName = this.getDriverName();
      result = result * 59 + ($driverName == null ? 43 : $driverName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $actualUserName = this.getActualUserName();
      result = result * 59 + ($actualUserName == null ? 43 : $actualUserName.hashCode());
      Object $actualStartDate = this.getActualStartDate();
      result = result * 59 + ($actualStartDate == null ? 43 : $actualStartDate.hashCode());
      Object $actualEndDate = this.getActualEndDate();
      result = result * 59 + ($actualEndDate == null ? 43 : $actualEndDate.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditStartDate = this.getAuditStartDate();
      result = result * 59 + ($auditStartDate == null ? 43 : $auditStartDate.hashCode());
      Object $auditEndDate = this.getAuditEndDate();
      result = result * 59 + ($auditEndDate == null ? 43 : $auditEndDate.hashCode());
      Object $receiptName = this.getReceiptName();
      result = result * 59 + ($receiptName == null ? 43 : $receiptName.hashCode());
      Object $auditReceiptName = this.getAuditReceiptName();
      result = result * 59 + ($auditReceiptName == null ? 43 : $auditReceiptName.hashCode());
      Object $auditReceiptStartDate = this.getAuditReceiptStartDate();
      result = result * 59 + ($auditReceiptStartDate == null ? 43 : $auditReceiptStartDate.hashCode());
      Object $auditReceiptEndDate = this.getAuditReceiptEndDate();
      result = result * 59 + ($auditReceiptEndDate == null ? 43 : $auditReceiptEndDate.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $statusUpdateStartDate = this.getStatusUpdateStartDate();
      result = result * 59 + ($statusUpdateStartDate == null ? 43 : $statusUpdateStartDate.hashCode());
      Object $statusUpdateEndDate = this.getStatusUpdateEndDate();
      result = result * 59 + ($statusUpdateEndDate == null ? 43 : $statusUpdateEndDate.hashCode());
      Object $sort = this.getSort();
      return result * 59 + ($sort == null ? 43 : $sort.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListDOParam(ids="
         + this.getIds()
         + ", projectIds="
         + this.getProjectIds()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", supplierPriceId="
         + this.getSupplierPriceId()
         + ", manufactureType="
         + this.getManufactureType()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", status="
         + this.getStatus()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", driverName="
         + this.getDriverName()
         + ", userName="
         + this.getUserName()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", actualUserName="
         + this.getActualUserName()
         + ", actualStartDate="
         + this.getActualStartDate()
         + ", actualEndDate="
         + this.getActualEndDate()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", priceType="
         + this.getPriceType()
         + ", auditStartDate="
         + this.getAuditStartDate()
         + ", auditEndDate="
         + this.getAuditEndDate()
         + ", receiptName="
         + this.getReceiptName()
         + ", auditReceiptName="
         + this.getAuditReceiptName()
         + ", auditReceiptStartDate="
         + this.getAuditReceiptStartDate()
         + ", auditReceiptEndDate="
         + this.getAuditReceiptEndDate()
         + ", supplierName="
         + this.getSupplierName()
         + ", deliveryStatus="
         + this.getDeliveryStatus()
         + ", minNum="
         + this.getMinNum()
         + ", maxNum="
         + this.getMaxNum()
         + ", shipmentStatus="
         + this.getShipmentStatus()
         + ", statusUpdateStartDate="
         + this.getStatusUpdateStartDate()
         + ", statusUpdateEndDate="
         + this.getStatusUpdateEndDate()
         + ", projectType="
         + this.getProjectType()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ", boolAccurateQuery="
         + this.getBoolAccurateQuery()
         + ")";
   }
}
