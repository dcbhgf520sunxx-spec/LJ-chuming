package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ApiModel(value = "RoleMenuLink对象", description = "")
@TableName("sys_role_menu_link")
@Table(name = "sys_role_menu_link")
public class RoleMenuLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "menu_id")
   @JsonProperty("menu_id")
   @JSONField(name = "menu_id")
   @TableField("menu_id")
   @Column(name = "menu_id")
   private Long menuId;
   @ApiModelProperty(name = "role_id")
   @JsonProperty("role_id")
   @JSONField(name = "role_id")
   @TableField("role_id")
   @Column(name = "role_id")
   private Long roleId;
   @ApiModelProperty(name = "systemEnum", value = "菜单类型 1MES系统 2物联系统", notes = "菜单类型 1MES系统 2物联系统")
   @JsonProperty("systemEnum")
   @JSONField(name = "systemEnum")
   @TableField("system_enum")
   @Column(name = "system_enum", columnDefinition = "int(11) default '1' COMMENT '菜单类型 1MES系统 2物联系统'", nullable = false)
   private Integer systemEnum;

   public static RoleMenuLink.RoleMenuLinkBuilder builder() {
      return new RoleMenuLink.RoleMenuLinkBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getMenuId() {
      return this.menuId;
   }

   public Long getRoleId() {
      return this.roleId;
   }

   public Integer getSystemEnum() {
      return this.systemEnum;
   }

   @JsonProperty("id")
   public RoleMenuLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("menu_id")
   public RoleMenuLink setMenuId(final Long menuId) {
      this.menuId = menuId;
      return this;
   }

   @JsonProperty("role_id")
   public RoleMenuLink setRoleId(final Long roleId) {
      this.roleId = roleId;
      return this;
   }

   @JsonProperty("systemEnum")
   public RoleMenuLink setSystemEnum(final Integer systemEnum) {
      this.systemEnum = systemEnum;
      return this;
   }

   @Override
   public String toString() {
      return "RoleMenuLink(id=" + this.getId() + ", menuId=" + this.getMenuId() + ", roleId=" + this.getRoleId() + ", systemEnum=" + this.getSystemEnum() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RoleMenuLink)) {
         return false;
      }

      RoleMenuLink other = (RoleMenuLink)o;
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
            Object this$roleId = this.getRoleId();
            Object other$roleId = other.getRoleId();
            if (this$roleId == null ? other$roleId == null : this$roleId.equals(other$roleId)) {
               Object this$systemEnum = this.getSystemEnum();
               Object other$systemEnum = other.getSystemEnum();
               return this$systemEnum == null ? other$systemEnum == null : this$systemEnum.equals(other$systemEnum);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof RoleMenuLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $menuId = this.getMenuId();
      result = result * 59 + ($menuId == null ? 43 : $menuId.hashCode());
      Object $roleId = this.getRoleId();
      result = result * 59 + ($roleId == null ? 43 : $roleId.hashCode());
      Object $systemEnum = this.getSystemEnum();
      return result * 59 + ($systemEnum == null ? 43 : $systemEnum.hashCode());
   }

   public RoleMenuLink(final Long id, final Long menuId, final Long roleId, final Integer systemEnum) {
      this.id = id;
      this.menuId = menuId;
      this.roleId = roleId;
      this.systemEnum = systemEnum;
   }

   public RoleMenuLink() {
   }

   public static class RoleMenuLinkBuilder {
      private Long id;
      private Long menuId;
      private Long roleId;
      private Integer systemEnum;

      RoleMenuLinkBuilder() {
      }

      @JsonProperty("id")
      public RoleMenuLink.RoleMenuLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("menu_id")
      public RoleMenuLink.RoleMenuLinkBuilder menuId(final Long menuId) {
         this.menuId = menuId;
         return this;
      }

      @JsonProperty("role_id")
      public RoleMenuLink.RoleMenuLinkBuilder roleId(final Long roleId) {
         this.roleId = roleId;
         return this;
      }

      @JsonProperty("systemEnum")
      public RoleMenuLink.RoleMenuLinkBuilder systemEnum(final Integer systemEnum) {
         this.systemEnum = systemEnum;
         return this;
      }

      public RoleMenuLink build() {
         return new RoleMenuLink(this.id, this.menuId, this.roleId, this.systemEnum);
      }

      @Override
      public String toString() {
         return "RoleMenuLink.RoleMenuLinkBuilder(id="
            + this.id
            + ", menuId="
            + this.menuId
            + ", roleId="
            + this.roleId
            + ", systemEnum="
            + this.systemEnum
            + ")";
      }
   }
}
