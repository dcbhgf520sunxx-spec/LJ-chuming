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
@ApiModel(value = "SysProvince对象", description = "")
@TableName("sys_province")
@Table(name = "sys_province")
public class SysProvince extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "countryId")
   @JsonProperty("countryId")
   @JSONField(name = "countryId")
   @TableField("country_id")
   @Column(name = "country_id")
   private Long countryId;

   public static SysProvince.SysProvinceBuilder builder() {
      return new SysProvince.SysProvinceBuilder();
   }

   public SysProvince() {
   }

   public SysProvince(final Long id, final String name, final String code, final Long countryId) {
      this.id = id;
      this.name = name;
      this.code = code;
      this.countryId = countryId;
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

   public Long getCountryId() {
      return this.countryId;
   }

   @JsonProperty("id")
   public SysProvince setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public SysProvince setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("code")
   public SysProvince setCode(final String code) {
      this.code = code;
      return this;
   }

   @JsonProperty("countryId")
   public SysProvince setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   @Override
   public String toString() {
      return "SysProvince(id=" + this.getId() + ", name=" + this.getName() + ", code=" + this.getCode() + ", countryId=" + this.getCountryId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysProvince)) {
         return false;
      }

      SysProvince other = (SysProvince)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$countryId = this.getCountryId();
         Object other$countryId = other.getCountryId();
         if (this$countryId == null ? other$countryId == null : this$countryId.equals(other$countryId)) {
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
      return other instanceof SysProvince;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   public static class SysProvinceBuilder {
      private Long id;
      private String name;
      private String code;
      private Long countryId;

      SysProvinceBuilder() {
      }

      @JsonProperty("id")
      public SysProvince.SysProvinceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public SysProvince.SysProvinceBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("code")
      public SysProvince.SysProvinceBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("countryId")
      public SysProvince.SysProvinceBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public SysProvince build() {
         return new SysProvince(this.id, this.name, this.code, this.countryId);
      }

      @Override
      public String toString() {
         return "SysProvince.SysProvinceBuilder(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ", countryId=" + this.countryId + ")";
      }
   }
}
