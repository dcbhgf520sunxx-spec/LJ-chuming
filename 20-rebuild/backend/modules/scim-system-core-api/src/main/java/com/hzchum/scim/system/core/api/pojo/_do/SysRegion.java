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
@ApiModel(value = "SysRegion对象", description = "")
@TableName("sys_region")
@Table(name = "sys_region")
public class SysRegion extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "cityId")
   @JsonProperty("cityId")
   @JSONField(name = "cityId")
   @TableField("city_id")
   @Column(name = "city_id")
   private Long cityId;
   @ApiModelProperty(name = "provinceId")
   @JsonProperty("provinceId")
   @JSONField(name = "provinceId")
   @TableField("province_id")
   @Column(name = "province_id")
   private Long provinceId;

   public static SysRegion.SysRegionBuilder builder() {
      return new SysRegion.SysRegionBuilder();
   }

   public SysRegion() {
   }

   public SysRegion(final Long id, final String name, final String code, final Long cityId, final Long provinceId) {
      this.id = id;
      this.name = name;
      this.code = code;
      this.cityId = cityId;
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

   public Long getCityId() {
      return this.cityId;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   @JsonProperty("id")
   public SysRegion setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public SysRegion setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("code")
   public SysRegion setCode(final String code) {
      this.code = code;
      return this;
   }

   @JsonProperty("cityId")
   public SysRegion setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   @JsonProperty("provinceId")
   public SysRegion setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   @Override
   public String toString() {
      return "SysRegion(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", code="
         + this.getCode()
         + ", cityId="
         + this.getCityId()
         + ", provinceId="
         + this.getProvinceId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysRegion)) {
         return false;
      }

      SysRegion other = (SysRegion)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cityId = this.getCityId();
         Object other$cityId = other.getCityId();
         if (this$cityId == null ? other$cityId == null : this$cityId.equals(other$cityId)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysRegion;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   public static class SysRegionBuilder {
      private Long id;
      private String name;
      private String code;
      private Long cityId;
      private Long provinceId;

      SysRegionBuilder() {
      }

      @JsonProperty("id")
      public SysRegion.SysRegionBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public SysRegion.SysRegionBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("code")
      public SysRegion.SysRegionBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("cityId")
      public SysRegion.SysRegionBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      @JsonProperty("provinceId")
      public SysRegion.SysRegionBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public SysRegion build() {
         return new SysRegion(this.id, this.name, this.code, this.cityId, this.provinceId);
      }

      @Override
      public String toString() {
         return "SysRegion.SysRegionBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", code="
            + this.code
            + ", cityId="
            + this.cityId
            + ", provinceId="
            + this.provinceId
            + ")";
      }
   }
}
