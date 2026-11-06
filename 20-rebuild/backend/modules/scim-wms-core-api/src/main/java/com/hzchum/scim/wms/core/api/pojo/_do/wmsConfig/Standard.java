package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

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

@ApiModel(value = "standard对象", description = "型材标准")
@Entity
@TableName("wms_standard")
@Table(name = "wms_standard")
@org.hibernate.annotations.Table(appliesTo = "wms_standard", comment = "型材标准")
public class Standard extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "国标名称", notes = "国标名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '国标名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "code")
   @JsonProperty("code")
   @JSONField(name = "code")
   @TableField("code")
   @Column(name = "code", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer code;

   public static Standard.StandardBuilder builder() {
      return new Standard.StandardBuilder();
   }

   public Standard() {
   }

   public Standard(final Long id, final String name, final Integer code) {
      this.id = id;
      this.name = name;
      this.code = code;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getCode() {
      return this.code;
   }

   @JsonProperty("id")
   public Standard setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public Standard setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("code")
   public Standard setCode(final Integer code) {
      this.code = code;
      return this;
   }

   @Override
   public String toString() {
      return "Standard(id=" + this.getId() + ", name=" + this.getName() + ", code=" + this.getCode() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Standard)) {
         return false;
      }

      Standard other = (Standard)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$code = this.getCode();
         Object other$code = other.getCode();
         if (this$code == null ? other$code == null : this$code.equals(other$code)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof Standard;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class StandardBuilder {
      private Long id;
      private String name;
      private Integer code;

      StandardBuilder() {
      }

      @JsonProperty("id")
      public Standard.StandardBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public Standard.StandardBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("code")
      public Standard.StandardBuilder code(final Integer code) {
         this.code = code;
         return this;
      }

      public Standard build() {
         return new Standard(this.id, this.name, this.code);
      }

      @Override
      public String toString() {
         return "Standard.StandardBuilder(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ")";
      }
   }
}
