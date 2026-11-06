package com.hzchum.scim.plan.core.api.pojo.voParam;

import io.swagger.annotations.ApiModelProperty;

public class EnclosureChangeVoParam {
   @ApiModelProperty(name = "projectId", value = "项目筛选类型（ALL/current）", notes = "项目筛选类型（ALL/current）")
   private Long projectId;
   @ApiModelProperty(name = "handleStatusEnum", value = "处理状态 1未处理 2处理通过 4驳回", notes = "处理状态 1未处理 2处理通过 4驳回")
   private Integer handleStatusEnum;
   @ApiModelProperty(name = "planId", value = "区域Id", notes = "区域Id")
   private Long planId;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getHandleStatusEnum() {
      return this.handleStatusEnum;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setHandleStatusEnum(final Integer handleStatusEnum) {
      this.handleStatusEnum = handleStatusEnum;
   }

   public void setPlanId(final Long planId) {
      this.planId = planId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureChangeVoParam)) {
         return false;
      }

      EnclosureChangeVoParam other = (EnclosureChangeVoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$handleStatusEnum = this.getHandleStatusEnum();
         Object other$handleStatusEnum = other.getHandleStatusEnum();
         if (this$handleStatusEnum == null ? other$handleStatusEnum == null : this$handleStatusEnum.equals(other$handleStatusEnum)) {
            Object this$planId = this.getPlanId();
            Object other$planId = other.getPlanId();
            if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof EnclosureChangeVoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $handleStatusEnum = this.getHandleStatusEnum();
      result = result * 59 + ($handleStatusEnum == null ? 43 : $handleStatusEnum.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureChangeVoParam(projectId="
         + this.getProjectId()
         + ", handleStatusEnum="
         + this.getHandleStatusEnum()
         + ", planId="
         + this.getPlanId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }
}
