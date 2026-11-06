package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.ShipmentStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("收货条件查询")
public class CargoListReceiptDTOParam {
   @ApiModelProperty("项目id")
   private Long projectId;
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
   @ApiModelProperty("办理人(发运人)")
   private String auditUserName;
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
   @ApiModelProperty("收货状态 1 已收货 2 未收货")
   private Integer receiptStatus;
   @ApiModelProperty("项目类型")
   private Integer projectType;
   @EnumValidator(value = ShipmentStatusEnum.class, message = "发运状态类型不支持")
   @ApiModelProperty("发运状态")
   private Integer shipmentStatus;
   @ApiModelProperty("状态更新开始日期")
   private LocalDateTime statusUpdateStartDate;
   @ApiModelProperty("状态更新结束日期")
   private LocalDateTime statusUpdateEndDate;
   @ApiModelProperty("名称编号")
   private String blurry;
   @ApiModelProperty(notes = "页码")
   Integer pageNumber = 1;
   @ApiModelProperty(notes = "页数")
   Integer pageSize = 10;
   @ApiModelProperty(notes = "排序")
   List<String> sort;

   public Long getProjectId() {
      return this.projectId;
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

   public String getAuditUserName() {
      return this.auditUserName;
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

   public Integer getReceiptStatus() {
      return this.receiptStatus;
   }

   public Integer getProjectType() {
      return this.projectType;
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

   public String getBlurry() {
      return this.blurry;
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

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
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

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
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

   public void setReceiptStatus(final Integer receiptStatus) {
      this.receiptStatus = receiptStatus;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
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

   public void setBlurry(final String blurry) {
      this.blurry = blurry;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListReceiptDTOParam)) {
         return false;
      }

      CargoListReceiptDTOParam other = (CargoListReceiptDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$manufactureType = this.getManufactureType();
         Object other$manufactureType = other.getManufactureType();
         if (this$manufactureType == null ? other$manufactureType == null : this$manufactureType.equals(other$manufactureType)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$receiptStatus = this.getReceiptStatus();
               Object other$receiptStatus = other.getReceiptStatus();
               if (this$receiptStatus == null ? other$receiptStatus == null : this$receiptStatus.equals(other$receiptStatus)) {
                  Object this$projectType = this.getProjectType();
                  Object other$projectType = other.getProjectType();
                  if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                     Object this$shipmentStatus = this.getShipmentStatus();
                     Object other$shipmentStatus = other.getShipmentStatus();
                     if (this$shipmentStatus == null ? other$shipmentStatus == null : this$shipmentStatus.equals(other$shipmentStatus)) {
                        Object this$pageNumber = this.getPageNumber();
                        Object other$pageNumber = other.getPageNumber();
                        if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                           Object this$pageSize = this.getPageSize();
                           Object other$pageSize = other.getPageSize();
                           if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$licensePlate = this.getLicensePlate();
                                 Object other$licensePlate = other.getLicensePlate();
                                 if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                    Object this$driverName = this.getDriverName();
                                    Object other$driverName = other.getDriverName();
                                    if (this$driverName == null ? other$driverName == null : this$driverName.equals(other$driverName)) {
                                       Object this$auditUserName = this.getAuditUserName();
                                       Object other$auditUserName = other.getAuditUserName();
                                       if (this$auditUserName == null ? other$auditUserName == null : this$auditUserName.equals(other$auditUserName)) {
                                          Object this$auditStartDate = this.getAuditStartDate();
                                          Object other$auditStartDate = other.getAuditStartDate();
                                          if (this$auditStartDate == null ? other$auditStartDate == null : this$auditStartDate.equals(other$auditStartDate)) {
                                             Object this$auditEndDate = this.getAuditEndDate();
                                             Object other$auditEndDate = other.getAuditEndDate();
                                             if (this$auditEndDate == null ? other$auditEndDate == null : this$auditEndDate.equals(other$auditEndDate)) {
                                                Object this$receiptName = this.getReceiptName();
                                                Object other$receiptName = other.getReceiptName();
                                                if (this$receiptName == null ? other$receiptName == null : this$receiptName.equals(other$receiptName)) {
                                                   Object this$auditReceiptName = this.getAuditReceiptName();
                                                   Object other$auditReceiptName = other.getAuditReceiptName();
                                                   if (this$auditReceiptName == null
                                                      ? other$auditReceiptName == null
                                                      : this$auditReceiptName.equals(other$auditReceiptName)) {
                                                      Object this$auditReceiptStartDate = this.getAuditReceiptStartDate();
                                                      Object other$auditReceiptStartDate = other.getAuditReceiptStartDate();
                                                      if (this$auditReceiptStartDate == null
                                                         ? other$auditReceiptStartDate == null
                                                         : this$auditReceiptStartDate.equals(other$auditReceiptStartDate)) {
                                                         Object this$auditReceiptEndDate = this.getAuditReceiptEndDate();
                                                         Object other$auditReceiptEndDate = other.getAuditReceiptEndDate();
                                                         if (this$auditReceiptEndDate == null
                                                            ? other$auditReceiptEndDate == null
                                                            : this$auditReceiptEndDate.equals(other$auditReceiptEndDate)) {
                                                            Object this$statusUpdateStartDate = this.getStatusUpdateStartDate();
                                                            Object other$statusUpdateStartDate = other.getStatusUpdateStartDate();
                                                            if (this$statusUpdateStartDate == null
                                                               ? other$statusUpdateStartDate == null
                                                               : this$statusUpdateStartDate.equals(other$statusUpdateStartDate)) {
                                                               Object this$statusUpdateEndDate = this.getStatusUpdateEndDate();
                                                               Object other$statusUpdateEndDate = other.getStatusUpdateEndDate();
                                                               if (this$statusUpdateEndDate == null
                                                                  ? other$statusUpdateEndDate == null
                                                                  : this$statusUpdateEndDate.equals(other$statusUpdateEndDate)) {
                                                                  Object this$blurry = this.getBlurry();
                                                                  Object other$blurry = other.getBlurry();
                                                                  if (this$blurry == null ? other$blurry == null : this$blurry.equals(other$blurry)) {
                                                                     Object this$sort = this.getSort();
                                                                     Object other$sort = other.getSort();
                                                                     return this$sort == null ? other$sort == null : this$sort.equals(other$sort);
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
      return other instanceof CargoListReceiptDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $manufactureType = this.getManufactureType();
      result = result * 59 + ($manufactureType == null ? 43 : $manufactureType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $receiptStatus = this.getReceiptStatus();
      result = result * 59 + ($receiptStatus == null ? 43 : $receiptStatus.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $shipmentStatus = this.getShipmentStatus();
      result = result * 59 + ($shipmentStatus == null ? 43 : $shipmentStatus.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $driverName = this.getDriverName();
      result = result * 59 + ($driverName == null ? 43 : $driverName.hashCode());
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
      Object $statusUpdateStartDate = this.getStatusUpdateStartDate();
      result = result * 59 + ($statusUpdateStartDate == null ? 43 : $statusUpdateStartDate.hashCode());
      Object $statusUpdateEndDate = this.getStatusUpdateEndDate();
      result = result * 59 + ($statusUpdateEndDate == null ? 43 : $statusUpdateEndDate.hashCode());
      Object $blurry = this.getBlurry();
      result = result * 59 + ($blurry == null ? 43 : $blurry.hashCode());
      Object $sort = this.getSort();
      return result * 59 + ($sort == null ? 43 : $sort.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListReceiptDTOParam(projectId="
         + this.getProjectId()
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
         + ", auditUserName="
         + this.getAuditUserName()
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
         + ", receiptStatus="
         + this.getReceiptStatus()
         + ", projectType="
         + this.getProjectType()
         + ", shipmentStatus="
         + this.getShipmentStatus()
         + ", statusUpdateStartDate="
         + this.getStatusUpdateStartDate()
         + ", statusUpdateEndDate="
         + this.getStatusUpdateEndDate()
         + ", blurry="
         + this.getBlurry()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
