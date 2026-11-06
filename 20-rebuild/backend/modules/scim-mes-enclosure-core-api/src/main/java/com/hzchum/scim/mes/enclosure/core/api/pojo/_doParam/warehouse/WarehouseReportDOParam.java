package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("入发存报表查询")
public class WarehouseReportDOParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty("结束时间")
   private LocalDateTime startDate;
   @ApiModelProperty("开始时间")
   private LocalDateTime endDate;
   @ApiModelProperty("工厂id")
   private Long factoryId;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseReportDOParam)) {
         return false;
      }

      WarehouseReportDOParam other = (WarehouseReportDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$startDate = this.getStartDate();
               Object other$startDate = other.getStartDate();
               if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                  Object this$endDate = this.getEndDate();
                  Object other$endDate = other.getEndDate();
                  return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
      return other instanceof WarehouseReportDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseReportDOParam(projectId="
         + this.getProjectId()
         + ", productType="
         + this.getProductType()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", factoryId="
         + this.getFactoryId()
         + ")";
   }
}
