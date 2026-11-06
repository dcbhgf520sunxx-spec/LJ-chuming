package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;

public class SupplierOrderFindDTOParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("属性 1原材料采购 2制成品采购 4原材料运输  8制成品运输 16专业分包")
   private Integer propertyType;
   @ApiModelProperty("开始时间")
   private LocalDate startDate;
   @ApiModelProperty("结束时间")
   private LocalDate endDate;
   @ApiModelProperty("订单号")
   private String serialNumber;
   @ApiModelProperty("供应商")
   private String supplierName;
   @ApiModelProperty("结算状态[CheckStatusEnum 0未结算 1已结算]")
   private Integer settlementStatus;
   @ApiModelProperty("页码")
   private Integer pageNumber = 1;
   @ApiModelProperty("页数")
   private Integer pageSize = 10;
   @ApiModelProperty("排序")
   private List<String> sort;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getPropertyType() {
      return this.propertyType;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
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

   public void setPropertyType(final Integer propertyType) {
      this.propertyType = propertyType;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
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

      if (!(o instanceof SupplierOrderFindDTOParam)) {
         return false;
      }

      SupplierOrderFindDTOParam other = (SupplierOrderFindDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$propertyType = this.getPropertyType();
         Object other$propertyType = other.getPropertyType();
         if (this$propertyType == null ? other$propertyType == null : this$propertyType.equals(other$propertyType)) {
            Object this$settlementStatus = this.getSettlementStatus();
            Object other$settlementStatus = other.getSettlementStatus();
            if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
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
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$supplierName = this.getSupplierName();
                              Object other$supplierName = other.getSupplierName();
                              if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierOrderFindDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $propertyType = this.getPropertyType();
      result = result * 59 + ($propertyType == null ? 43 : $propertyType.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $sort = this.getSort();
      return result * 59 + ($sort == null ? 43 : $sort.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierOrderFindDTOParam(projectId="
         + this.getProjectId()
         + ", propertyType="
         + this.getPropertyType()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", supplierName="
         + this.getSupplierName()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
