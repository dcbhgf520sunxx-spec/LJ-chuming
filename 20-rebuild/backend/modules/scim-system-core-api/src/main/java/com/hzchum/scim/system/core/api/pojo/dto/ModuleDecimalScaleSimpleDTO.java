package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ModuleDecimalScaleSimpleDTO", description = "模块小数精度 ")
public class ModuleDecimalScaleSimpleDTO {
   @ApiModelProperty(name = "menuId", value = "模块根菜单id", notes = "模块根菜单id")
   private Long menuId;
   @ApiModelProperty(name = "menuId", value = "模块根菜单名称", notes = "模块根菜单名称")
   private String menuName;
   @ApiModelProperty(name = "scale", value = "小数保留位数", notes = "小数保留位数")
   private Integer scale;

   public static ModuleDecimalScaleSimpleDTO.ModuleDecimalScaleSimpleDTOBuilder builder() {
      return new ModuleDecimalScaleSimpleDTO.ModuleDecimalScaleSimpleDTOBuilder();
   }

   public ModuleDecimalScaleSimpleDTO() {
   }

   public ModuleDecimalScaleSimpleDTO(final Long menuId, final String menuName, final Integer scale) {
      this.menuId = menuId;
      this.menuName = menuName;
      this.scale = scale;
   }

   public Long getMenuId() {
      return this.menuId;
   }

   public String getMenuName() {
      return this.menuName;
   }

   public Integer getScale() {
      return this.scale;
   }

   public void setMenuId(final Long menuId) {
      this.menuId = menuId;
   }

   public void setMenuName(final String menuName) {
      this.menuName = menuName;
   }

   public void setScale(final Integer scale) {
      this.scale = scale;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ModuleDecimalScaleSimpleDTO)) {
         return false;
      }

      ModuleDecimalScaleSimpleDTO other = (ModuleDecimalScaleSimpleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$menuId = this.getMenuId();
      Object other$menuId = other.getMenuId();
      if (this$menuId == null ? other$menuId == null : this$menuId.equals(other$menuId)) {
         Object this$scale = this.getScale();
         Object other$scale = other.getScale();
         if (this$scale == null ? other$scale == null : this$scale.equals(other$scale)) {
            Object this$menuName = this.getMenuName();
            Object other$menuName = other.getMenuName();
            return this$menuName == null ? other$menuName == null : this$menuName.equals(other$menuName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ModuleDecimalScaleSimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $menuId = this.getMenuId();
      result = result * 59 + ($menuId == null ? 43 : $menuId.hashCode());
      Object $scale = this.getScale();
      result = result * 59 + ($scale == null ? 43 : $scale.hashCode());
      Object $menuName = this.getMenuName();
      return result * 59 + ($menuName == null ? 43 : $menuName.hashCode());
   }

   @Override
   public String toString() {
      return "ModuleDecimalScaleSimpleDTO(menuId=" + this.getMenuId() + ", menuName=" + this.getMenuName() + ", scale=" + this.getScale() + ")";
   }

   public static class ModuleDecimalScaleSimpleDTOBuilder {
      private Long menuId;
      private String menuName;
      private Integer scale;

      ModuleDecimalScaleSimpleDTOBuilder() {
      }

      public ModuleDecimalScaleSimpleDTO.ModuleDecimalScaleSimpleDTOBuilder menuId(final Long menuId) {
         this.menuId = menuId;
         return this;
      }

      public ModuleDecimalScaleSimpleDTO.ModuleDecimalScaleSimpleDTOBuilder menuName(final String menuName) {
         this.menuName = menuName;
         return this;
      }

      public ModuleDecimalScaleSimpleDTO.ModuleDecimalScaleSimpleDTOBuilder scale(final Integer scale) {
         this.scale = scale;
         return this;
      }

      public ModuleDecimalScaleSimpleDTO build() {
         return new ModuleDecimalScaleSimpleDTO(this.menuId, this.menuName, this.scale);
      }

      @Override
      public String toString() {
         return "ModuleDecimalScaleSimpleDTO.ModuleDecimalScaleSimpleDTOBuilder(menuId="
            + this.menuId
            + ", menuName="
            + this.menuName
            + ", scale="
            + this.scale
            + ")";
      }
   }
}
