package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.system.core.api.common.enums.SystemChargingMethodEnum;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class SystemChargingMethodUpdateDTO {
   @ApiModelProperty("系统收费方式")
   @NotNull(message = "系统收费方式不能为空")
   @EnumValidator(value = SystemChargingMethodEnum.class, message = "系统收费方式类型不正确")
   private String systemChargingMethod;

   public String getSystemChargingMethod() {
      return this.systemChargingMethod;
   }

   public void setSystemChargingMethod(final String systemChargingMethod) {
      this.systemChargingMethod = systemChargingMethod;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SystemChargingMethodUpdateDTO)) {
         return false;
      }

      SystemChargingMethodUpdateDTO other = (SystemChargingMethodUpdateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$systemChargingMethod = this.getSystemChargingMethod();
      Object other$systemChargingMethod = other.getSystemChargingMethod();
      return this$systemChargingMethod == null ? other$systemChargingMethod == null : this$systemChargingMethod.equals(other$systemChargingMethod);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SystemChargingMethodUpdateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $systemChargingMethod = this.getSystemChargingMethod();
      return result * 59 + ($systemChargingMethod == null ? 43 : $systemChargingMethod.hashCode());
   }

   @Override
   public String toString() {
      return "SystemChargingMethodUpdateDTO(systemChargingMethod=" + this.getSystemChargingMethod() + ")";
   }
}
