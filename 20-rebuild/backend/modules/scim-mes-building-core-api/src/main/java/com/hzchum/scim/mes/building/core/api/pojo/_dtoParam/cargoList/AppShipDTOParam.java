package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("APP发运条件查询")
public class AppShipDTOParam {
   @ApiModelProperty(notes = "项目名称")
   private String name;
   @ApiModelProperty(notes = "车牌")
   private String licensePlate;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("开始日期")
   private LocalDateTime startDate;
   @ApiModelProperty("结束日期")
   private LocalDateTime endDate;
   @ApiModelProperty("页码")
   private Integer pageNumber = 1;
   @ApiModelProperty("页数")
   private Integer pageSize = 10;
   @ApiModelProperty("排序")
   private List<String> sort;

   public String getName() {
      return this.name;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
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

   public void setName(final String name) {
      this.name = name;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
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

      if (!(o instanceof AppShipDTOParam)) {
         return false;
      }

      AppShipDTOParam other = (AppShipDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pageNumber = this.getPageNumber();
      Object other$pageNumber = other.getPageNumber();
      if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
         Object this$pageSize = this.getPageSize();
         Object other$pageSize = other.getPageSize();
         if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$licensePlate = this.getLicensePlate();
               Object other$licensePlate = other.getLicensePlate();
               if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$startDate = this.getStartDate();
                     Object other$startDate = other.getStartDate();
                     if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                        Object this$endDate = this.getEndDate();
                        Object other$endDate = other.getEndDate();
                        if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppShipDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $sort = this.getSort();
      return result * 59 + ($sort == null ? 43 : $sort.hashCode());
   }

   @Override
   public String toString() {
      return "AppShipDTOParam(name="
         + this.getName()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
