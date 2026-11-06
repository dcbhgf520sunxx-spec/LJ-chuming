package com.hzchum.scim.mes.building.core.api.pojo._doParam.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel("质检详情查询类")
public class InspectionDetailDOParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(notes = "开始")
   private LocalDateTime startDate;
   @ApiModelProperty(notes = "结束")
   private LocalDateTime endDate;
   @ApiModelProperty(notes = "产品类型")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty(notes = "用户id")
   @NotNull(message = "用户id不能为空")
   private Long userId;

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getUserId() {
      return this.userId;
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

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionDetailDOParam)) {
         return false;
      }

      InspectionDetailDOParam other = (InspectionDetailDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InspectionDetailDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "InspectionDetailDOParam(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", productType="
         + this.getProductType()
         + ", userId="
         + this.getUserId()
         + ")";
   }
}
