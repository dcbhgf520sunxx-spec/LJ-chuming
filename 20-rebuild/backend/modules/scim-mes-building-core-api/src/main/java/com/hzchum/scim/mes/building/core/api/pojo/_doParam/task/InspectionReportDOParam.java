package com.hzchum.scim.mes.building.core.api.pojo._doParam.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel("质检报表查询类")
public class InspectionReportDOParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(notes = "开始")
   private LocalDateTime startDate;
   @ApiModelProperty(notes = "结束")
   private LocalDateTime endDate;
   @ApiModelProperty(notes = "产品类型")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public void setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionReportDOParam)) {
         return false;
      }

      InspectionReportDOParam other = (InspectionReportDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InspectionReportDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "InspectionReportDOParam(startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ", productType=" + this.getProductType() + ")";
   }
}
