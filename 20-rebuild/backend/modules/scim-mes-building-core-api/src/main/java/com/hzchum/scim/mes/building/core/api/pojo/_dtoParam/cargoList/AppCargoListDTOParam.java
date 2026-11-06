package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("发运条件查询")
public class AppCargoListDTOParam {
   @ApiModelProperty(notes = "物流价格id")
   private Long supplierPriceId;
   @ApiModelProperty(notes = "发运状态 [1 装车, 2 过磅，4发运，8收货 16 未装车]")
   private Integer status;
   @ApiModelProperty("装车开始时间")
   private LocalDateTime startDate;
   @ApiModelProperty("装车结束时间")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   private String licensePlate;
   @ApiModelProperty("页码")
   private Integer pageNumber = 1;
   @ApiModelProperty("页数")
   private Integer pageSize = 10;
   @ApiModelProperty("排序")
   private List<String> sort;

   public Long getSupplierPriceId() {
      return this.supplierPriceId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public String getLicensePlate() {
      return this.licensePlate;
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

   public void setSupplierPriceId(final Long supplierPriceId) {
      this.supplierPriceId = supplierPriceId;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
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

      if (!(o instanceof AppCargoListDTOParam)) {
         return false;
      }

      AppCargoListDTOParam other = (AppCargoListDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierPriceId = this.getSupplierPriceId();
      Object other$supplierPriceId = other.getSupplierPriceId();
      if (this$supplierPriceId == null ? other$supplierPriceId == null : this$supplierPriceId.equals(other$supplierPriceId)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$pageNumber = this.getPageNumber();
            Object other$pageNumber = other.getPageNumber();
            if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
               Object this$pageSize = this.getPageSize();
               Object other$pageSize = other.getPageSize();
               if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                  Object this$startDate = this.getStartDate();
                  Object other$startDate = other.getStartDate();
                  if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                     Object this$endDate = this.getEndDate();
                     Object other$endDate = other.getEndDate();
                     if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                        Object this$licensePlate = this.getLicensePlate();
                        Object other$licensePlate = other.getLicensePlate();
                        if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
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
      return other instanceof AppCargoListDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierPriceId = this.getSupplierPriceId();
      result = result * 59 + ($supplierPriceId == null ? 43 : $supplierPriceId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $sort = this.getSort();
      return result * 59 + ($sort == null ? 43 : $sort.hashCode());
   }

   @Override
   public String toString() {
      return "AppCargoListDTOParam(supplierPriceId="
         + this.getSupplierPriceId()
         + ", status="
         + this.getStatus()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
