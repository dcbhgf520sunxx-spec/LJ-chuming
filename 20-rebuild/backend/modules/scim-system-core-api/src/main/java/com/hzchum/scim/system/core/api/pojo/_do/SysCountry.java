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
@ApiModel(value = "SysCountry对象", description = "")
@TableName("sys_country")
@Table(name = "sys_country")
public class SysCountry extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "code")
   @JsonProperty("code")
   @JSONField(name = "code")
   @TableField("code")
   @Column(name = "code")
   private String code;

   public static SysCountry.SysCountryBuilder builder() {
      return new SysCountry.SysCountryBuilder();
   }

   public SysCountry() {
   }

   public SysCountry(final Long id, final String name, final String code) {
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

   public String getCode() {
      return this.code;
   }

   @JsonProperty("id")
   public SysCountry setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public SysCountry setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("code")
   public SysCountry setCode(final String code) {
      this.code = code;
      return this;
   }

   @Override
   public String toString() {
      return "SysCountry(id=" + this.getId() + ", name=" + this.getName() + ", code=" + this.getCode() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysCountry)) {
         return false;
      }

      SysCountry other = (SysCountry)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$code = this.getCode();
            Object other$code = other.getCode();
            return this$code == null ? other$code == null : this$code.equals(other$code);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysCountry;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   public static class SysCountryBuilder {
      private Long id;
      private String name;
      private String code;

      SysCountryBuilder() {
      }

      @JsonProperty("id")
      public SysCountry.SysCountryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public SysCountry.SysCountryBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("code")
      public SysCountry.SysCountryBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public SysCountry build() {
         return new SysCountry(this.id, this.name, this.code);
      }

      @Override
      public String toString() {
         return "SysCountry.SysCountryBuilder(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ")";
      }
   }
}
