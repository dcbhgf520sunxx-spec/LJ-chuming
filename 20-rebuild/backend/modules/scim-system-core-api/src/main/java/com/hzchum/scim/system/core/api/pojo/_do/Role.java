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

@Entity
@ApiModel(value = "Role对象", description = "")
@TableName("sys_role")
@Table(name = "sys_role")
public class Role extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "is_default", value = "是否默认 true 默认角色")
   @TableField("is_default")
   @Column(name = "is_default", columnDefinition = "tinyint(1) default 0 comment '是否默认'", nullable = false)
   private Boolean isDefault;
   @ApiModelProperty(name = "name", value = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) comment '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "permission", value = "权限")
   @TableField("permission")
   @Column(name = "permission", columnDefinition = "varchar(255) comment '权限'")
   private String permission;
   @ApiModelProperty(name = "remark", value = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024) comment '备注'")
   private String remark;
   @ApiModelProperty(name = "sort", value = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11) default 1 comment '排序'", nullable = false)
   private Integer sort;

   public static Role.RoleBuilder builder() {
      return new Role.RoleBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getIsDefault() {
      return this.isDefault;
   }

   public String getName() {
      return this.name;
   }

   public String getPermission() {
      return this.permission;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Role setId(final Long id) {
      this.id = id;
      return this;
   }

   public Role setIsDefault(final Boolean isDefault) {
      this.isDefault = isDefault;
      return this;
   }

   public Role setName(final String name) {
      this.name = name;
      return this;
   }

   public Role setPermission(final String permission) {
      this.permission = permission;
      return this;
   }

   public Role setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public Role setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "Role(id="
         + this.getId()
         + ", isDefault="
         + this.getIsDefault()
         + ", name="
         + this.getName()
         + ", permission="
         + this.getPermission()
         + ", remark="
         + this.getRemark()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Role)) {
         return false;
      }

      Role other = (Role)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$isDefault = this.getIsDefault();
         Object other$isDefault = other.getIsDefault();
         if (this$isDefault == null ? other$isDefault == null : this$isDefault.equals(other$isDefault)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$permission = this.getPermission();
                  Object other$permission = other.getPermission();
                  if (this$permission == null ? other$permission == null : this$permission.equals(other$permission)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof Role;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $isDefault = this.getIsDefault();
      result = result * 59 + ($isDefault == null ? 43 : $isDefault.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $permission = this.getPermission();
      result = result * 59 + ($permission == null ? 43 : $permission.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public Role(final Long id, final Boolean isDefault, final String name, final String permission, final String remark, final Integer sort) {
      this.id = id;
      this.isDefault = isDefault;
      this.name = name;
      this.permission = permission;
      this.remark = remark;
      this.sort = sort;
   }

   public Role() {
   }

   public static class RoleBuilder {
      private Long id;
      private Boolean isDefault;
      private String name;
      private String permission;
      private String remark;
      private Integer sort;

      RoleBuilder() {
      }

      public Role.RoleBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public Role.RoleBuilder isDefault(final Boolean isDefault) {
         this.isDefault = isDefault;
         return this;
      }

      public Role.RoleBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public Role.RoleBuilder permission(final String permission) {
         this.permission = permission;
         return this;
      }

      public Role.RoleBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public Role.RoleBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public Role build() {
         return new Role(this.id, this.isDefault, this.name, this.permission, this.remark, this.sort);
      }

      @Override
      public String toString() {
         return "Role.RoleBuilder(id="
            + this.id
            + ", isDefault="
            + this.isDefault
            + ", name="
            + this.name
            + ", permission="
            + this.permission
            + ", remark="
            + this.remark
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
