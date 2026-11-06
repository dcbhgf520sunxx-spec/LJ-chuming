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
@ApiModel(value = "SysLocation对象", description = "")
@TableName("sys_location")
@Table(name = "sys_location")
public class SysLocation extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;

   public static SysLocation.SysLocationBuilder builder() {
      return new SysLocation.SysLocationBuilder();
   }

   public SysLocation() {
   }

   public SysLocation(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   @JsonProperty("id")
   public SysLocation setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public SysLocation setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "SysLocation(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SysLocation)) {
         return false;
      } else {
         SysLocation other = (SysLocation)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysLocation;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class SysLocationBuilder {
      private Long id;
      private String name;

      SysLocationBuilder() {
      }

      @JsonProperty("id")
      public SysLocation.SysLocationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public SysLocation.SysLocationBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysLocation build() {
         return new SysLocation(this.id, this.name);
      }

      @Override
      public String toString() {
         return "SysLocation.SysLocationBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
