package com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingCargoListAddress对象", description = "发运表")
@Entity
@TableName("mes_building_cargo_list_address")
@Table(name = "mes_building_cargo_list_address", indexes = @Index(name = "cargoListId_index", columnList = "cargo_list_id"))
public class MesBuildingCargoListAddress extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "cargoListId", value = "发运Id", notes = "发运Id")
   @JsonProperty("cargoListId")
   @JSONField(name = "cargo_list_id")
   @TableField("cargo_list_id")
   @Column(name = "cargo_list_id", columnDefinition = "bigint(20)  COMMENT '发运Id'", nullable = false)
   private Long cargoListId;
   @ApiModelProperty(name = "countryId", value = "国家id")
   @JsonProperty("countryId")
   @JSONField(name = "country_id")
   @TableField("country_id")
   @Column(name = "country_id", columnDefinition = "bigint(20)  COMMENT '国家id'", nullable = true)
   private Long countryId;
   @ApiModelProperty(name = "country_name", value = "国家名称")
   @JsonProperty("country_name")
   @JSONField(name = "country_name")
   @TableField(value = "country_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "country_name")
   private String countryName;
   @ApiModelProperty(name = "provinceId", value = "省id")
   @JsonProperty("provinceId")
   @JSONField(name = "province_id")
   @TableField("province_id")
   @Column(name = "province_id", columnDefinition = "bigint(20)  COMMENT '省id'", nullable = true)
   private Long provinceId;
   @ApiModelProperty(name = "province_name", value = "所在省名称")
   @JsonProperty("province_name")
   @JSONField(name = "province_name")
   @TableField(value = "province_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "province_name")
   private String provinceName;
   @ApiModelProperty(name = "cityId", value = "所在市id")
   @JsonProperty("cityId")
   @JSONField(name = "city_id")
   @TableField("city_id")
   @Column(name = "city_id", columnDefinition = "bigint(20)  COMMENT '区id'", nullable = true)
   private Long cityId;
   @ApiModelProperty(name = "city_name", value = "所在市名称")
   @JsonProperty("city_name")
   @JSONField(name = "city_name")
   @TableField(value = "city_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "city_name")
   private String cityName;
   @ApiModelProperty(name = "regionId", value = "区id")
   @JsonProperty("regionId")
   @JSONField(name = "region_id")
   @TableField("region_id")
   @Column(name = "region_id", columnDefinition = "bigint(20)  COMMENT '区id'", nullable = true)
   private Long regionId;
   @ApiModelProperty(name = "region_name", notes = "区名称")
   @JsonProperty("region_name")
   @JSONField(name = "region_name")
   @TableField(value = "region_name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "region_name")
   private String regionName;
   @ApiModelProperty(name = "regionalFullName", notes = "省市区")
   @JsonProperty("regionalFullName")
   @JSONField(name = "regional_full_name")
   @TableField("regional_full_name")
   @Column(name = "regional_full_name", columnDefinition = "VARCHAR(1024) default '' COMMENT '省市区'")
   private String regionalFullName;
   @ApiModelProperty(name = "address", notes = "项目详细地址")
   @JsonProperty("address")
   @JSONField(name = "address")
   @TableField("address")
   @Column(name = "address", columnDefinition = "VARCHAR(1024) COMMENT '项目详细地址'")
   private String address;

   public static MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder builder() {
      return new MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder();
   }

   public MesBuildingCargoListAddress() {
   }

   public MesBuildingCargoListAddress(
      final Long id,
      final Long cargoListId,
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final String regionName,
      final String regionalFullName,
      final String address
   ) {
      this.id = id;
      this.cargoListId = cargoListId;
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.regionalFullName = regionalFullName;
      this.address = address;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCargoListId() {
      return this.cargoListId;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public String getCountryName() {
      return this.countryName;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public String getProvinceName() {
      return this.provinceName;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public String getCityName() {
      return this.cityName;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public String getRegionName() {
      return this.regionName;
   }

   public String getRegionalFullName() {
      return this.regionalFullName;
   }

   public String getAddress() {
      return this.address;
   }

   @JsonProperty("id")
   public MesBuildingCargoListAddress setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cargoListId")
   public MesBuildingCargoListAddress setCargoListId(final Long cargoListId) {
      this.cargoListId = cargoListId;
      return this;
   }

   @JsonProperty("countryId")
   public MesBuildingCargoListAddress setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   @JsonProperty("country_name")
   public MesBuildingCargoListAddress setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   @JsonProperty("provinceId")
   public MesBuildingCargoListAddress setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   @JsonProperty("province_name")
   public MesBuildingCargoListAddress setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   @JsonProperty("cityId")
   public MesBuildingCargoListAddress setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   @JsonProperty("city_name")
   public MesBuildingCargoListAddress setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   @JsonProperty("regionId")
   public MesBuildingCargoListAddress setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   @JsonProperty("region_name")
   public MesBuildingCargoListAddress setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   @JsonProperty("regionalFullName")
   public MesBuildingCargoListAddress setRegionalFullName(final String regionalFullName) {
      this.regionalFullName = regionalFullName;
      return this;
   }

   @JsonProperty("address")
   public MesBuildingCargoListAddress setAddress(final String address) {
      this.address = address;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCargoListAddress(id="
         + this.getId()
         + ", cargoListId="
         + this.getCargoListId()
         + ", countryId="
         + this.getCountryId()
         + ", countryName="
         + this.getCountryName()
         + ", provinceId="
         + this.getProvinceId()
         + ", provinceName="
         + this.getProvinceName()
         + ", cityId="
         + this.getCityId()
         + ", cityName="
         + this.getCityName()
         + ", regionId="
         + this.getRegionId()
         + ", regionName="
         + this.getRegionName()
         + ", regionalFullName="
         + this.getRegionalFullName()
         + ", address="
         + this.getAddress()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCargoListAddress)) {
         return false;
      }

      MesBuildingCargoListAddress other = (MesBuildingCargoListAddress)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cargoListId = this.getCargoListId();
         Object other$cargoListId = other.getCargoListId();
         if (this$cargoListId == null ? other$cargoListId == null : this$cargoListId.equals(other$cargoListId)) {
            Object this$countryId = this.getCountryId();
            Object other$countryId = other.getCountryId();
            if (this$countryId == null ? other$countryId == null : this$countryId.equals(other$countryId)) {
               Object this$provinceId = this.getProvinceId();
               Object other$provinceId = other.getProvinceId();
               if (this$provinceId == null ? other$provinceId == null : this$provinceId.equals(other$provinceId)) {
                  Object this$cityId = this.getCityId();
                  Object other$cityId = other.getCityId();
                  if (this$cityId == null ? other$cityId == null : this$cityId.equals(other$cityId)) {
                     Object this$regionId = this.getRegionId();
                     Object other$regionId = other.getRegionId();
                     if (this$regionId == null ? other$regionId == null : this$regionId.equals(other$regionId)) {
                        Object this$countryName = this.getCountryName();
                        Object other$countryName = other.getCountryName();
                        if (this$countryName == null ? other$countryName == null : this$countryName.equals(other$countryName)) {
                           Object this$provinceName = this.getProvinceName();
                           Object other$provinceName = other.getProvinceName();
                           if (this$provinceName == null ? other$provinceName == null : this$provinceName.equals(other$provinceName)) {
                              Object this$cityName = this.getCityName();
                              Object other$cityName = other.getCityName();
                              if (this$cityName == null ? other$cityName == null : this$cityName.equals(other$cityName)) {
                                 Object this$regionName = this.getRegionName();
                                 Object other$regionName = other.getRegionName();
                                 if (this$regionName == null ? other$regionName == null : this$regionName.equals(other$regionName)) {
                                    Object this$regionalFullName = this.getRegionalFullName();
                                    Object other$regionalFullName = other.getRegionalFullName();
                                    if (this$regionalFullName == null ? other$regionalFullName == null : this$regionalFullName.equals(other$regionalFullName)) {
                                       Object this$address = this.getAddress();
                                       Object other$address = other.getAddress();
                                       return this$address == null ? other$address == null : this$address.equals(other$address);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingCargoListAddress;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cargoListId = this.getCargoListId();
      result = result * 59 + ($cargoListId == null ? 43 : $cargoListId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $regionalFullName = this.getRegionalFullName();
      result = result * 59 + ($regionalFullName == null ? 43 : $regionalFullName.hashCode());
      Object $address = this.getAddress();
      return result * 59 + ($address == null ? 43 : $address.hashCode());
   }

   public static class MesBuildingCargoListAddressBuilder {
      private Long id;
      private Long cargoListId;
      private Long countryId;
      private String countryName;
      private Long provinceId;
      private String provinceName;
      private Long cityId;
      private String cityName;
      private Long regionId;
      private String regionName;
      private String regionalFullName;
      private String address;

      MesBuildingCargoListAddressBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cargoListId")
      public MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder cargoListId(final Long cargoListId) {
         this.cargoListId = cargoListId;
         return this;
      }

      @JsonProperty("countryId")
      public MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      @JsonProperty("country_name")
      public MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      @JsonProperty("provinceId")
      public MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      @JsonProperty("province_name")
      public MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      @JsonProperty("cityId")
      public MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      @JsonProperty("city_name")
      public MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      @JsonProperty("regionId")
      public MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      @JsonProperty("region_name")
      public MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      @JsonProperty("regionalFullName")
      public MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder regionalFullName(final String regionalFullName) {
         this.regionalFullName = regionalFullName;
         return this;
      }

      @JsonProperty("address")
      public MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public MesBuildingCargoListAddress build() {
         return new MesBuildingCargoListAddress(
            this.id,
            this.cargoListId,
            this.countryId,
            this.countryName,
            this.provinceId,
            this.provinceName,
            this.cityId,
            this.cityName,
            this.regionId,
            this.regionName,
            this.regionalFullName,
            this.address
         );
      }

      @Override
      public String toString() {
         return "MesBuildingCargoListAddress.MesBuildingCargoListAddressBuilder(id="
            + this.id
            + ", cargoListId="
            + this.cargoListId
            + ", countryId="
            + this.countryId
            + ", countryName="
            + this.countryName
            + ", provinceId="
            + this.provinceId
            + ", provinceName="
            + this.provinceName
            + ", cityId="
            + this.cityId
            + ", cityName="
            + this.cityName
            + ", regionId="
            + this.regionId
            + ", regionName="
            + this.regionName
            + ", regionalFullName="
            + this.regionalFullName
            + ", address="
            + this.address
            + ")";
      }
   }
}
