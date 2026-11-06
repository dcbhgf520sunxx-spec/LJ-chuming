package com.hzchum.scim.crm.core.api.pojo.dto;

public class CrmRegionCommonDTO {
   Long countryId;
   Long provinceId;
   Long cityId;
   Long regionId;

   public static CrmRegionCommonDTO.CrmRegionCommonDTOBuilder builder() {
      return new CrmRegionCommonDTO.CrmRegionCommonDTOBuilder();
   }

   public CrmRegionCommonDTO() {
   }

   public CrmRegionCommonDTO(final Long countryId, final Long provinceId, final Long cityId, final Long regionId) {
      this.countryId = countryId;
      this.provinceId = provinceId;
      this.cityId = cityId;
      this.regionId = regionId;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public CrmRegionCommonDTO setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   public CrmRegionCommonDTO setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   public CrmRegionCommonDTO setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   public CrmRegionCommonDTO setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   @Override
   public String toString() {
      return "CrmRegionCommonDTO(countryId="
         + this.getCountryId()
         + ", provinceId="
         + this.getProvinceId()
         + ", cityId="
         + this.getCityId()
         + ", regionId="
         + this.getRegionId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmRegionCommonDTO)) {
         return false;
      }

      CrmRegionCommonDTO other = (CrmRegionCommonDTO)o;
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
               return this$regionId == null ? other$regionId == null : this$regionId.equals(other$regionId);
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
      return other instanceof CrmRegionCommonDTO;
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
      return result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
   }

   public static class CrmRegionCommonDTOBuilder {
      private Long countryId;
      private Long provinceId;
      private Long cityId;
      private Long regionId;

      CrmRegionCommonDTOBuilder() {
      }

      public CrmRegionCommonDTO.CrmRegionCommonDTOBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public CrmRegionCommonDTO.CrmRegionCommonDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public CrmRegionCommonDTO.CrmRegionCommonDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public CrmRegionCommonDTO.CrmRegionCommonDTOBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public CrmRegionCommonDTO build() {
         return new CrmRegionCommonDTO(this.countryId, this.provinceId, this.cityId, this.regionId);
      }

      @Override
      public String toString() {
         return "CrmRegionCommonDTO.CrmRegionCommonDTOBuilder(countryId="
            + this.countryId
            + ", provinceId="
            + this.provinceId
            + ", cityId="
            + this.cityId
            + ", regionId="
            + this.regionId
            + ")";
      }
   }
}
