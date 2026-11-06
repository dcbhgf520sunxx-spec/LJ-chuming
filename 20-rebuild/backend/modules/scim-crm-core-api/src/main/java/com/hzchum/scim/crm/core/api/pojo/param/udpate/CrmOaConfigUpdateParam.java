package com.hzchum.scim.crm.core.api.pojo.param.udpate;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class CrmOaConfigUpdateParam {
   @NotNull(message = "是否走OA审批不能为空")
   @ApiModelProperty(value = "是否走OA审批", required = true)
   private Boolean enabled;

   public Boolean getEnabled() {
      return this.enabled;
   }

   public void setEnabled(final Boolean enabled) {
      this.enabled = enabled;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmOaConfigUpdateParam)) {
         return false;
      }

      CrmOaConfigUpdateParam other = (CrmOaConfigUpdateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$enabled = this.getEnabled();
      Object other$enabled = other.getEnabled();
      return this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmOaConfigUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $enabled = this.getEnabled();
      return result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
   }

   @Override
   public String toString() {
      return "CrmOaConfigUpdateParam(enabled=" + this.getEnabled() + ")";
   }
}
