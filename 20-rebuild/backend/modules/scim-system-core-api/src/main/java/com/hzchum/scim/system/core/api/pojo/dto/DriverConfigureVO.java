package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class DriverConfigureVO {
   @ApiModelProperty("装车——填写司机信息配置 true 过磅时 false 装车时")
   @NotNull(message = "配置不能为空")
   private Boolean configure;

   public Boolean getConfigure() {
      return this.configure;
   }

   public void setConfigure(final Boolean configure) {
      this.configure = configure;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DriverConfigureVO)) {
         return false;
      }

      DriverConfigureVO other = (DriverConfigureVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$configure = this.getConfigure();
      Object other$configure = other.getConfigure();
      return this$configure == null ? other$configure == null : this$configure.equals(other$configure);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DriverConfigureVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $configure = this.getConfigure();
      return result * 59 + ($configure == null ? 43 : $configure.hashCode());
   }

   @Override
   public String toString() {
      return "DriverConfigureVO(configure=" + this.getConfigure() + ")";
   }
}
