package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class PrintConfigVO {
   @ApiModelProperty("围护打印配置 1基础型 2极简型")
   @NotNull(message = "围护打印配置不能为空")
   private Integer enclosureType;

   public Integer getEnclosureType() {
      return this.enclosureType;
   }

   public void setEnclosureType(final Integer enclosureType) {
      this.enclosureType = enclosureType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PrintConfigVO)) {
         return false;
      }

      PrintConfigVO other = (PrintConfigVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$enclosureType = this.getEnclosureType();
      Object other$enclosureType = other.getEnclosureType();
      return this$enclosureType == null ? other$enclosureType == null : this$enclosureType.equals(other$enclosureType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PrintConfigVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $enclosureType = this.getEnclosureType();
      return result * 59 + ($enclosureType == null ? 43 : $enclosureType.hashCode());
   }

   @Override
   public String toString() {
      return "PrintConfigVO(enclosureType=" + this.getEnclosureType() + ")";
   }
}
