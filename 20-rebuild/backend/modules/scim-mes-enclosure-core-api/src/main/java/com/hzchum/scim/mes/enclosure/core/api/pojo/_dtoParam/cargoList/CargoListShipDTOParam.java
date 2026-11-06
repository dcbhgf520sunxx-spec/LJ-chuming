package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("发运条件查询")
public class CargoListShipDTOParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("制造类型【1：自制，2：外包】")
   private Integer manufactureType;
   @ApiModelProperty("装载类型")
   private Integer productType;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
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
   @ApiModelProperty("名称编号")
   private String blurry;
   @ApiModelProperty("发运状态")
   private Integer deliveryStatus;
   @ApiModelProperty("差值率起点")
   private Double minNum;
   @ApiModelProperty("差值率终点")
   private Double maxNum;
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

   public Integer getCategory() {
      return this.category;
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

   public String getBlurry() {
      return this.blurry;
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

   public void setCategory(final Integer category) {
      this.category = category;
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

   public void setBlurry(final String blurry) {
      this.blurry = blurry;
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

      if (!(o instanceof CargoListShipDTOParam)) {
         return false;
      }

      CargoListShipDTOParam other = (CargoListShipDTOParam)o;
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
               Object this$category = this.getCategory();
               Object other$category = other.getCategory();
               if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                  Object this$deliveryStatus = this.getDeliveryStatus();
                  Object other$deliveryStatus = other.getDeliveryStatus();
                  if (this$deliveryStatus == null ? other$deliveryStatus == null : this$deliveryStatus.equals(other$deliveryStatus)) {
                     Object this$minNum = this.getMinNum();
                     Object other$minNum = other.getMinNum();
                     if (this$minNum == null ? other$minNum == null : this$minNum.equals(other$minNum)) {
                        Object this$maxNum = this.getMaxNum();
                        Object other$maxNum = other.getMaxNum();
                        if (this$maxNum == null ? other$maxNum == null : this$maxNum.equals(other$maxNum)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CargoListShipDTOParam;
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
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $deliveryStatus = this.getDeliveryStatus();
      result = result * 59 + ($deliveryStatus == null ? 43 : $deliveryStatus.hashCode());
      Object $minNum = this.getMinNum();
      result = result * 59 + ($minNum == null ? 43 : $minNum.hashCode());
      Object $maxNum = this.getMaxNum();
      result = result * 59 + ($maxNum == null ? 43 : $maxNum.hashCode());
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
      Object $blurry = this.getBlurry();
      result = result * 59 + ($blurry == null ? 43 : $blurry.hashCode());
      Object $sort = this.getSort();
      return result * 59 + ($sort == null ? 43 : $sort.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListShipDTOParam(projectId="
         + this.getProjectId()
         + ", manufactureType="
         + this.getManufactureType()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
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
         + ", blurry="
         + this.getBlurry()
         + ", deliveryStatus="
         + this.getDeliveryStatus()
         + ", minNum="
         + this.getMinNum()
         + ", maxNum="
         + this.getMaxNum()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
