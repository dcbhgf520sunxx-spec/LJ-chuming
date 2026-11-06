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
@ApiModel(value = "PermissionType对象", description = "")
@TableName("sys_permission_type")
@Table(name = "sys_permission_type")
public class PermissionType extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "icon")
   @JsonProperty("icon")
   @JSONField(name = "icon")
   @TableField("icon")
   @Column(name = "icon")
   private String icon;
   @ApiModelProperty(name = "name")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "sort")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort")
   private Integer sort;

   public static PermissionType.PermissionTypeBuilder builder() {
      return new PermissionType.PermissionTypeBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getIcon() {
      return this.icon;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   @JsonProperty("id")
   public PermissionType setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("icon")
   public PermissionType setIcon(final String icon) {
      this.icon = icon;
      return this;
   }

   @JsonProperty("name")
   public PermissionType setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public PermissionType setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "PermissionType(id=" + this.getId() + ", icon=" + this.getIcon() + ", name=" + this.getName() + ", sort=" + this.getSort() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PermissionType)) {
         return false;
      }

      PermissionType other = (PermissionType)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$icon = this.getIcon();
            Object other$icon = other.getIcon();
            if (this$icon == null ? other$icon == null : this$icon.equals(other$icon)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof PermissionType;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $icon = this.getIcon();
      result = result * 59 + ($icon == null ? 43 : $icon.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public PermissionType(final Long id, final String icon, final String name, final Integer sort) {
      this.id = id;
      this.icon = icon;
      this.name = name;
      this.sort = sort;
   }

   public PermissionType() {
   }

   public static class PermissionTypeBuilder {
      private Long id;
      private String icon;
      private String name;
      private Integer sort;

      PermissionTypeBuilder() {
      }

      @JsonProperty("id")
      public PermissionType.PermissionTypeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("icon")
      public PermissionType.PermissionTypeBuilder icon(final String icon) {
         this.icon = icon;
         return this;
      }

      @JsonProperty("name")
      public PermissionType.PermissionTypeBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public PermissionType.PermissionTypeBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public PermissionType build() {
         return new PermissionType(this.id, this.icon, this.name, this.sort);
      }

      @Override
      public String toString() {
         return "PermissionType.PermissionTypeBuilder(id=" + this.id + ", icon=" + this.icon + ", name=" + this.name + ", sort=" + this.sort + ")";
      }
   }
}
