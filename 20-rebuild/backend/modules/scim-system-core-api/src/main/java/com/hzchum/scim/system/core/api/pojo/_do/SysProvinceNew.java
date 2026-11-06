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
@ApiModel(value = "SysProvinceNew对象", description = "")
@TableName("sys_province_new")
@Table(name = "sys_province_new")
public class SysProvinceNew extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "locationId")
   @JsonProperty("locationId")
   @JSONField(name = "locationId")
   @TableField("location_id")
   @Column(name = "location_id")
   private Long locationId;

   public static SysProvinceNew.SysProvinceNewBuilder builder() {
      return new SysProvinceNew.SysProvinceNewBuilder();
   }

   public SysProvinceNew() {
   }

   public SysProvinceNew(final Long id, final String name, final String code, final Long countryId, final Long locationId) {
      this.id = id;
      this.name = name;
      this.code = code;
      this.countryId = countryId;
      this.locationId = locationId;
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

   public Long getLocationId() {
      return this.locationId;
   }

   @JsonProperty("id")
   public SysProvinceNew setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public SysProvinceNew setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("code")
   public SysProvinceNew setCode(final String code) {
      this.code = code;
      return this;
   }

   @JsonProperty("countryId")
   public SysProvinceNew setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   @JsonProperty("locationId")
   public SysProvinceNew setLocationId(final Long locationId) {
      this.locationId = locationId;
      return this;
   }

   @Override
   public String toString() {
      return "SysProvinceNew(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", code="
         + this.getCode()
         + ", countryId="
         + this.getCountryId()
         + ", locationId="
         + this.getLocationId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysProvinceNew)) {
         return false;
      }

      SysProvinceNew other = (SysProvinceNew)o;
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
            Object this$locationId = this.getLocationId();
            Object other$locationId = other.getLocationId();
            if (this$locationId == null ? other$locationId == null : this$locationId.equals(other$locationId)) {
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
      return other instanceof SysProvinceNew;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $locationId = this.getLocationId();
      result = result * 59 + ($locationId == null ? 43 : $locationId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   public static class SysProvinceNewBuilder {
      private Long id;
      private String name;
      private String code;
      private Long countryId;
      private Long locationId;

      SysProvinceNewBuilder() {
      }

      @JsonProperty("id")
      public SysProvinceNew.SysProvinceNewBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public SysProvinceNew.SysProvinceNewBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("code")
      public SysProvinceNew.SysProvinceNewBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("countryId")
      public SysProvinceNew.SysProvinceNewBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      @JsonProperty("locationId")
      public SysProvinceNew.SysProvinceNewBuilder locationId(final Long locationId) {
         this.locationId = locationId;
         return this;
      }

      public SysProvinceNew build() {
         return new SysProvinceNew(this.id, this.name, this.code, this.countryId, this.locationId);
      }

      @Override
      public String toString() {
         return "SysProvinceNew.SysProvinceNewBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", code="
            + this.code
            + ", countryId="
            + this.countryId
            + ", locationId="
            + this.locationId
            + ")";
      }
   }
}
