package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.NotNull;

public class ProjectConfigVO {
   @NotNull(message = "是否显示项目全称不能为空")
   private Boolean showProjectFullName;
   @NotNull(message = "是否显示合同编号不能为空")
   private Boolean showSerialNumber;
   @NotNull(message = "项目名称展示方式不能为空")
   private Integer arrangement;

   public Boolean getShowProjectFullName() {
      return this.showProjectFullName;
   }

   public Boolean getShowSerialNumber() {
      return this.showSerialNumber;
   }

   public Integer getArrangement() {
      return this.arrangement;
   }

   public void setShowProjectFullName(final Boolean showProjectFullName) {
      this.showProjectFullName = showProjectFullName;
   }

   public void setShowSerialNumber(final Boolean showSerialNumber) {
      this.showSerialNumber = showSerialNumber;
   }

   public void setArrangement(final Integer arrangement) {
      this.arrangement = arrangement;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectConfigVO)) {
         return false;
      }

      ProjectConfigVO other = (ProjectConfigVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$showProjectFullName = this.getShowProjectFullName();
      Object other$showProjectFullName = other.getShowProjectFullName();
      if (this$showProjectFullName == null ? other$showProjectFullName == null : this$showProjectFullName.equals(other$showProjectFullName)) {
         Object this$showSerialNumber = this.getShowSerialNumber();
         Object other$showSerialNumber = other.getShowSerialNumber();
         if (this$showSerialNumber == null ? other$showSerialNumber == null : this$showSerialNumber.equals(other$showSerialNumber)) {
            Object this$arrangement = this.getArrangement();
            Object other$arrangement = other.getArrangement();
            return this$arrangement == null ? other$arrangement == null : this$arrangement.equals(other$arrangement);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectConfigVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $showProjectFullName = this.getShowProjectFullName();
      result = result * 59 + ($showProjectFullName == null ? 43 : $showProjectFullName.hashCode());
      Object $showSerialNumber = this.getShowSerialNumber();
      result = result * 59 + ($showSerialNumber == null ? 43 : $showSerialNumber.hashCode());
      Object $arrangement = this.getArrangement();
      return result * 59 + ($arrangement == null ? 43 : $arrangement.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectConfigVO(showProjectFullName="
         + this.getShowProjectFullName()
         + ", showSerialNumber="
         + this.getShowSerialNumber()
         + ", arrangement="
         + this.getArrangement()
         + ")";
   }
}
