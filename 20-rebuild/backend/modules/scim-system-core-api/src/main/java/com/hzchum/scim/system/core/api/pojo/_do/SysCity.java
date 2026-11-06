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

@ApiModel(value = "SysCity对象", description = "")
@Entity
@TableName("sys_city")
@Table(name = "sys_city")
public class SysCity extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "provinceId")
   @JsonProperty("provinceId")
   @JSONField(name = "provinceId")
   @TableField("province_id")
   @Column(name = "province_id")
   private Long provinceId;

   public static SysCity.SysCityBuilder builder() {
      return new SysCity.SysCityBuilder();
   }

   public SysCity() {
   }

   public SysCity(final Long id, final String name, final String code, final Long provinceId) {
      this.id = id;
      this.name = name;
      this.code = code;
      this.provinceId = provinceId;
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

   public Long getProvinceId() {
      return this.provinceId;
   }

   @JsonProperty("id")
   public SysCity setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public SysCity setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("code")
   public SysCity setCode(final String code) {
      this.code = code;
      return this;
   }

   @JsonProperty("provinceId")
   public SysCity setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   @Override
   public String toString() {
      return "SysCity(id=" + this.getId() + ", name=" + this.getName() + ", code=" + this.getCode() + ", provinceId=" + this.getProvinceId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysCity)) {
         return false;
      }

      SysCity other = (SysCity)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$provinceId = this.getProvinceId();
         Object other$provinceId = other.getProvinceId();
         if (this$provinceId == null ? other$provinceId == null : this$provinceId.equals(other$provinceId)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysCity;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   public static class SysCityBuilder {
      private Long id;
      private String name;
      private String code;
      private Long provinceId;

      SysCityBuilder() {
      }

      @JsonProperty("id")
      public SysCity.SysCityBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public SysCity.SysCityBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("code")
      public SysCity.SysCityBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("provinceId")
      public SysCity.SysCityBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public SysCity build() {
         return new SysCity(this.id, this.name, this.code, this.provinceId);
      }

      @Override
      public String toString() {
         return "SysCity.SysCityBuilder(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ", provinceId=" + this.provinceId + ")";
      }
   }
}
