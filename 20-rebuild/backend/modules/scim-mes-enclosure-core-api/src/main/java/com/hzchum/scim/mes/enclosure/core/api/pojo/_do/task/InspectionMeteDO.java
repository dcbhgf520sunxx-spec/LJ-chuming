package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("质检汇总量")
public class InspectionMeteDO {
   @ApiModelProperty("质检数量")
   private Integer inspectionQuantity;
   @ApiModelProperty("用户id")
   private Long userId;
   @ApiModelProperty("用户名称")
   private String userName;

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionMeteDO)) {
         return false;
      }

      InspectionMeteDO other = (InspectionMeteDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inspectionQuantity = this.getInspectionQuantity();
      Object other$inspectionQuantity = other.getInspectionQuantity();
      if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$userName = this.getUserName();
            Object other$userName = other.getUserName();
            return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InspectionMeteDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "InspectionMeteDO(inspectionQuantity=" + this.getInspectionQuantity() + ", userId=" + this.getUserId() + ", userName=" + this.getUserName() + ")";
   }
}
