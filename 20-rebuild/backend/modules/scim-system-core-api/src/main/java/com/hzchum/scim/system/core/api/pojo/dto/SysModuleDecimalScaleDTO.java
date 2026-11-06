package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysModuleDecimalScale对象", description = "小数精度配置表 ")
public class SysModuleDecimalScaleDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "menuId", value = "模块根菜单id", notes = "模块根菜单id")
   private Long menuId;
   @ApiModelProperty(name = "menuName", value = "模块名称", notes = "模块名称")
   private String menuName;
   @ApiModelProperty(name = "scale", value = "小数保留位数", notes = "小数保留位数")
   private Integer scale;

   public static SysModuleDecimalScaleDTO.SysModuleDecimalScaleDTOBuilder builder() {
      return new SysModuleDecimalScaleDTO.SysModuleDecimalScaleDTOBuilder();
   }

   public SysModuleDecimalScaleDTO() {
   }

   public SysModuleDecimalScaleDTO(final Long id, final Long menuId, final String menuName, final Integer scale) {
      this.id = id;
      this.menuId = menuId;
      this.menuName = menuName;
      this.scale = scale;
   }

   public Long getId() {
      return this.id;
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

   public void setId(final Long id) {
      this.id = id;
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

      if (!(o instanceof SysModuleDecimalScaleDTO)) {
         return false;
      }

      SysModuleDecimalScaleDTO other = (SysModuleDecimalScaleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysModuleDecimalScaleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $menuId = this.getMenuId();
      result = result * 59 + ($menuId == null ? 43 : $menuId.hashCode());
      Object $scale = this.getScale();
      result = result * 59 + ($scale == null ? 43 : $scale.hashCode());
      Object $menuName = this.getMenuName();
      return result * 59 + ($menuName == null ? 43 : $menuName.hashCode());
   }

   @Override
   public String toString() {
      return "SysModuleDecimalScaleDTO(id="
         + this.getId()
         + ", menuId="
         + this.getMenuId()
         + ", menuName="
         + this.getMenuName()
         + ", scale="
         + this.getScale()
         + ")";
   }

   public static class SysModuleDecimalScaleDTOBuilder {
      private Long id;
      private Long menuId;
      private String menuName;
      private Integer scale;

      SysModuleDecimalScaleDTOBuilder() {
      }

      public SysModuleDecimalScaleDTO.SysModuleDecimalScaleDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysModuleDecimalScaleDTO.SysModuleDecimalScaleDTOBuilder menuId(final Long menuId) {
         this.menuId = menuId;
         return this;
      }

      public SysModuleDecimalScaleDTO.SysModuleDecimalScaleDTOBuilder menuName(final String menuName) {
         this.menuName = menuName;
         return this;
      }

      public SysModuleDecimalScaleDTO.SysModuleDecimalScaleDTOBuilder scale(final Integer scale) {
         this.scale = scale;
         return this;
      }

      public SysModuleDecimalScaleDTO build() {
         return new SysModuleDecimalScaleDTO(this.id, this.menuId, this.menuName, this.scale);
      }

      @Override
      public String toString() {
         return "SysModuleDecimalScaleDTO.SysModuleDecimalScaleDTOBuilder(id="
            + this.id
            + ", menuId="
            + this.menuId
            + ", menuName="
            + this.menuName
            + ", scale="
            + this.scale
            + ")";
      }
   }
}
