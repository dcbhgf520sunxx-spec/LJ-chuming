package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "SysModuleDecimalScale对象", description = "小数精度配置表 ")
public class SysModuleDecimalScaleDtoParam {
   @ApiModelProperty(name = "menuId", value = "模块根菜单id", notes = "模块根菜单id")
   @NotNull(message = "模块不能为空")
   private Long menuId;
   @ApiModelProperty(name = "scale", value = "小数保留位数", notes = "小数保留位数")
   @NotNull(message = "小数保留位数不能为空")
   @Min(value = 0L, message = "最小保留0位小数")
   private Integer scale;

   public static SysModuleDecimalScaleDtoParam.SysModuleDecimalScaleDtoParamBuilder builder() {
      return new SysModuleDecimalScaleDtoParam.SysModuleDecimalScaleDtoParamBuilder();
   }

   public SysModuleDecimalScaleDtoParam() {
   }

   public SysModuleDecimalScaleDtoParam(final Long menuId, final Integer scale) {
      this.menuId = menuId;
      this.scale = scale;
   }

   public Long getMenuId() {
      return this.menuId;
   }

   public Integer getScale() {
      return this.scale;
   }

   public void setMenuId(final Long menuId) {
      this.menuId = menuId;
   }

   public void setScale(final Integer scale) {
      this.scale = scale;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SysModuleDecimalScaleDtoParam)) {
         return false;
      } else {
         SysModuleDecimalScaleDtoParam other = (SysModuleDecimalScaleDtoParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$menuId = this.getMenuId();
            Object other$menuId = other.getMenuId();
            if (this$menuId == null ? other$menuId == null : this$menuId.equals(other$menuId)) {
               Object this$scale = this.getScale();
               Object other$scale = other.getScale();
               return this$scale == null ? other$scale == null : this$scale.equals(other$scale);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysModuleDecimalScaleDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $menuId = this.getMenuId();
      result = result * 59 + ($menuId == null ? 43 : $menuId.hashCode());
      Object $scale = this.getScale();
      return result * 59 + ($scale == null ? 43 : $scale.hashCode());
   }

   @Override
   public String toString() {
      return "SysModuleDecimalScaleDtoParam(menuId=" + this.getMenuId() + ", scale=" + this.getScale() + ")";
   }

   public static class SysModuleDecimalScaleDtoParamBuilder {
      private Long menuId;
      private Integer scale;

      SysModuleDecimalScaleDtoParamBuilder() {
      }

      public SysModuleDecimalScaleDtoParam.SysModuleDecimalScaleDtoParamBuilder menuId(final Long menuId) {
         this.menuId = menuId;
         return this;
      }

      public SysModuleDecimalScaleDtoParam.SysModuleDecimalScaleDtoParamBuilder scale(final Integer scale) {
         this.scale = scale;
         return this;
      }

      public SysModuleDecimalScaleDtoParam build() {
         return new SysModuleDecimalScaleDtoParam(this.menuId, this.scale);
      }

      @Override
      public String toString() {
         return "SysModuleDecimalScaleDtoParam.SysModuleDecimalScaleDtoParamBuilder(menuId=" + this.menuId + ", scale=" + this.scale + ")";
      }
   }
}
