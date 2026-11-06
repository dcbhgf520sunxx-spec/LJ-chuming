package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SysModuleDecimalScale对象", description = "小数精度配置表 ")
@Entity
@TableName("sys_module_decimal_scale")
@Table(name = "sys_module_decimal_scale")
@org.hibernate.annotations.Table(appliesTo = "sys_module_decimal_scale", comment = "小数精度配置表")
public class SysModuleDecimalScale extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "menuId", value = "模块根菜单id", notes = "模块根菜单id")
   @TableField("menu_id")
   @Column(name = "menu_id", columnDefinition = "bigint(20) COMMENT '模块根菜单id'", nullable = false)
   private Long menuId;
   @ApiModelProperty(name = "scale", value = "小数保留位数", notes = "小数保留位数")
   @TableField("scale")
   @Column(name = "scale", columnDefinition = "int(11) default 4 comment '小数保留位数'", nullable = false)
   private Integer scale;

   public static SysModuleDecimalScale.SysModuleDecimalScaleBuilder builder() {
      return new SysModuleDecimalScale.SysModuleDecimalScaleBuilder();
   }

   public SysModuleDecimalScale() {
   }

   public SysModuleDecimalScale(final Long id, final Long menuId, final Integer scale) {
      this.id = id;
      this.menuId = menuId;
      this.scale = scale;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMenuId() {
      return this.menuId;
   }

   public Integer getScale() {
      return this.scale;
   }

   public SysModuleDecimalScale setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysModuleDecimalScale setMenuId(final Long menuId) {
      this.menuId = menuId;
      return this;
   }

   public SysModuleDecimalScale setScale(final Integer scale) {
      this.scale = scale;
      return this;
   }

   @Override
   public String toString() {
      return "SysModuleDecimalScale(id=" + this.getId() + ", menuId=" + this.getMenuId() + ", scale=" + this.getScale() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysModuleDecimalScale)) {
         return false;
      }

      SysModuleDecimalScale other = (SysModuleDecimalScale)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
            return this$scale == null ? other$scale == null : this$scale.equals(other$scale);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysModuleDecimalScale;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $menuId = this.getMenuId();
      result = result * 59 + ($menuId == null ? 43 : $menuId.hashCode());
      Object $scale = this.getScale();
      return result * 59 + ($scale == null ? 43 : $scale.hashCode());
   }

   public static class SysModuleDecimalScaleBuilder {
      private Long id;
      private Long menuId;
      private Integer scale;

      SysModuleDecimalScaleBuilder() {
      }

      public SysModuleDecimalScale.SysModuleDecimalScaleBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysModuleDecimalScale.SysModuleDecimalScaleBuilder menuId(final Long menuId) {
         this.menuId = menuId;
         return this;
      }

      public SysModuleDecimalScale.SysModuleDecimalScaleBuilder scale(final Integer scale) {
         this.scale = scale;
         return this;
      }

      public SysModuleDecimalScale build() {
         return new SysModuleDecimalScale(this.id, this.menuId, this.scale);
      }

      @Override
      public String toString() {
         return "SysModuleDecimalScale.SysModuleDecimalScaleBuilder(id=" + this.id + ", menuId=" + this.menuId + ", scale=" + this.scale + ")";
      }
   }
}
