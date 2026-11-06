package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("物流详情条件查询")
public class CargoListLogisticsDTOParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("供应商价格条件查询")
   private Long supplierPriceId;
   @ApiModelProperty(notes = "运输方式 1运送到场 2客户自提")
   private Integer transportMode;
   @ApiModelProperty("装载类型")
   private Integer productType;
   @ApiModelProperty("计价类型")
   private Integer priceType;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty("车次编号")
   private String serialNumber;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("司机名称")
   private String driverName;
   @ApiModelProperty("供应商名称")
   private String supplierName;
   @ApiModelProperty("司机电话")
   private String driverPhone;
   @ApiModelProperty("制造类型【1：自制，2：外包】")
   private Integer manufactureType;
   @ApiModelProperty("发运开始时间")
   private LocalDateTime auditStartDate;
   @ApiModelProperty("发运结束时间")
   private LocalDateTime auditEndDate;
   @ApiModelProperty("项目类型")
   private Integer projectType;
   @ApiModelProperty(notes = "页码")
   Integer pageNumber = 1;
   @ApiModelProperty(notes = "页数")
   Integer pageSize = 10;
   @ApiModelProperty(notes = "排序")
   List<String> sort;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierPriceId() {
      return this.supplierPriceId;
   }

   public Integer getTransportMode() {
      return this.transportMode;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getPriceType() {
      return this.priceType;
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

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getDriverPhone() {
      return this.driverPhone;
   }

   public Integer getManufactureType() {
      return this.manufactureType;
   }

   public LocalDateTime getAuditStartDate() {
      return this.auditStartDate;
   }

   public LocalDateTime getAuditEndDate() {
      return this.auditEndDate;
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

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSupplierPriceId(final Long supplierPriceId) {
      this.supplierPriceId = supplierPriceId;
   }

   public void setTransportMode(final Integer transportMode) {
      this.transportMode = transportMode;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setPriceType(final Integer priceType) {
      this.priceType = priceType;
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

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setDriverPhone(final String driverPhone) {
      this.driverPhone = driverPhone;
   }

   public void setManufactureType(final Integer manufactureType) {
      this.manufactureType = manufactureType;
   }

   public void setAuditStartDate(final LocalDateTime auditStartDate) {
      this.auditStartDate = auditStartDate;
   }

   public void setAuditEndDate(final LocalDateTime auditEndDate) {
      this.auditEndDate = auditEndDate;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListLogisticsDTOParam)) {
         return false;
      }

      CargoListLogisticsDTOParam other = (CargoListLogisticsDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$supplierPriceId = this.getSupplierPriceId();
         Object other$supplierPriceId = other.getSupplierPriceId();
         if (this$supplierPriceId == null ? other$supplierPriceId == null : this$supplierPriceId.equals(other$supplierPriceId)) {
            Object this$transportMode = this.getTransportMode();
            Object other$transportMode = other.getTransportMode();
            if (this$transportMode == null ? other$transportMode == null : this$transportMode.equals(other$transportMode)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$priceType = this.getPriceType();
                  Object other$priceType = other.getPriceType();
                  if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$manufactureType = this.getManufactureType();
                        Object other$manufactureType = other.getManufactureType();
                        if (this$manufactureType == null ? other$manufactureType == null : this$manufactureType.equals(other$manufactureType)) {
                           Object this$projectType = this.getProjectType();
                           Object other$projectType = other.getProjectType();
                           if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
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
                                             Object this$supplierName = this.getSupplierName();
                                             Object other$supplierName = other.getSupplierName();
                                             if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                                Object this$driverPhone = this.getDriverPhone();
                                                Object other$driverPhone = other.getDriverPhone();
                                                if (this$driverPhone == null ? other$driverPhone == null : this$driverPhone.equals(other$driverPhone)) {
                                                   Object this$auditStartDate = this.getAuditStartDate();
                                                   Object other$auditStartDate = other.getAuditStartDate();
                                                   if (this$auditStartDate == null
                                                      ? other$auditStartDate == null
                                                      : this$auditStartDate.equals(other$auditStartDate)) {
                                                      Object this$auditEndDate = this.getAuditEndDate();
                                                      Object other$auditEndDate = other.getAuditEndDate();
                                                      if (this$auditEndDate == null ? other$auditEndDate == null : this$auditEndDate.equals(other$auditEndDate)
                                                         )
                                                       {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CargoListLogisticsDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierPriceId = this.getSupplierPriceId();
      result = result * 59 + ($supplierPriceId == null ? 43 : $supplierPriceId.hashCode());
      Object $transportMode = this.getTransportMode();
      result = result * 59 + ($transportMode == null ? 43 : $transportMode.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $manufactureType = this.getManufactureType();
      result = result * 59 + ($manufactureType == null ? 43 : $manufactureType.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
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
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $driverPhone = this.getDriverPhone();
      result = result * 59 + ($driverPhone == null ? 43 : $driverPhone.hashCode());
      Object $auditStartDate = this.getAuditStartDate();
      result = result * 59 + ($auditStartDate == null ? 43 : $auditStartDate.hashCode());
      Object $auditEndDate = this.getAuditEndDate();
      result = result * 59 + ($auditEndDate == null ? 43 : $auditEndDate.hashCode());
      Object $sort = this.getSort();
      return result * 59 + ($sort == null ? 43 : $sort.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListLogisticsDTOParam(projectId="
         + this.getProjectId()
         + ", supplierPriceId="
         + this.getSupplierPriceId()
         + ", transportMode="
         + this.getTransportMode()
         + ", productType="
         + this.getProductType()
         + ", priceType="
         + this.getPriceType()
         + ", category="
         + this.getCategory()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", driverName="
         + this.getDriverName()
         + ", supplierName="
         + this.getSupplierName()
         + ", driverPhone="
         + this.getDriverPhone()
         + ", manufactureType="
         + this.getManufactureType()
         + ", auditStartDate="
         + this.getAuditStartDate()
         + ", auditEndDate="
         + this.getAuditEndDate()
         + ", projectType="
         + this.getProjectType()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
