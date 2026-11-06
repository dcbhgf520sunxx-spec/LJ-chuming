package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "地址信息返回类型 ")
public class AddressSimpleInfoDTO {
   @ApiModelProperty(name = "countryId", value = "国家id", notes = "国家id")
   private Long countryId;
   @ApiModelProperty(name = "countryName", value = "国家名称", notes = "国家名称")
   private String countryName;
   @ApiModelProperty(name = "provinceId", value = "省份id", notes = "省份id")
   private Long provinceId;
   @ApiModelProperty(name = "provinceName", value = "省份名称", notes = "省份名称")
   private String provinceName;
   @ApiModelProperty(name = "cityId", value = "城市id", notes = "城市id")
   private Long cityId;
   @ApiModelProperty(name = "cityName", value = "城市名称", notes = "城市名称")
   private String cityName;
   @ApiModelProperty(name = "regionId", value = "地区id", notes = "地区id")
   private Long regionId;
   @ApiModelProperty(name = "regionName", value = "地区名称", notes = "地区名称")
   private String regionName;

   public static AddressSimpleInfoDTO.AddressSimpleInfoDTOBuilder builder() {
      return new AddressSimpleInfoDTO.AddressSimpleInfoDTOBuilder();
   }

   public AddressSimpleInfoDTO() {
   }

   public AddressSimpleInfoDTO(
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final String regionName
   ) {
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
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

   public void setCountryId(final Long countryId) {
      this.countryId = countryId;
   }

   public void setCountryName(final String countryName) {
      this.countryName = countryName;
   }

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
   }

   public void setCityId(final Long cityId) {
      this.cityId = cityId;
   }

   public void setCityName(final String cityName) {
      this.cityName = cityName;
   }

   public void setRegionId(final Long regionId) {
      this.regionId = regionId;
   }

   public void setRegionName(final String regionName) {
      this.regionName = regionName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AddressSimpleInfoDTO)) {
         return false;
      }

      AddressSimpleInfoDTO other = (AddressSimpleInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

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
                           return this$regionName == null ? other$regionName == null : this$regionName.equals(other$regionName);
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

   protected boolean canEqual(final Object other) {
      return other instanceof AddressSimpleInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
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
      return result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
   }

   @Override
   public String toString() {
      return "AddressSimpleInfoDTO(countryId="
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
         + ")";
   }

   public static class AddressSimpleInfoDTOBuilder {
      private Long countryId;
      private String countryName;
      private Long provinceId;
      private String provinceName;
      private Long cityId;
      private String cityName;
      private Long regionId;
      private String regionName;

      AddressSimpleInfoDTOBuilder() {
      }

      public AddressSimpleInfoDTO.AddressSimpleInfoDTOBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public AddressSimpleInfoDTO.AddressSimpleInfoDTOBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public AddressSimpleInfoDTO.AddressSimpleInfoDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public AddressSimpleInfoDTO.AddressSimpleInfoDTOBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public AddressSimpleInfoDTO.AddressSimpleInfoDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public AddressSimpleInfoDTO.AddressSimpleInfoDTOBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public AddressSimpleInfoDTO.AddressSimpleInfoDTOBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public AddressSimpleInfoDTO.AddressSimpleInfoDTOBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public AddressSimpleInfoDTO build() {
         return new AddressSimpleInfoDTO(
            this.countryId, this.countryName, this.provinceId, this.provinceName, this.cityId, this.cityName, this.regionId, this.regionName
         );
      }

      @Override
      public String toString() {
         return "AddressSimpleInfoDTO.AddressSimpleInfoDTOBuilder(countryId="
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
            + ")";
      }
   }
}
