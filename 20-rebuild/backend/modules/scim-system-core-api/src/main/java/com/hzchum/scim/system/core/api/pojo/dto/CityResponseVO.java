package com.hzchum.scim.system.core.api.pojo.dto;

import java.io.Serializable;
import java.util.List;

public class CityResponseVO implements Serializable {
   private static final long serialVersionUID = 1L;
   private Long id;
   private String name;
   private String code;
   private Long countryId;
   private Long provinceId;
   private List<RegionResponseVO> cityList;

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

   public Long getProvinceId() {
      return this.provinceId;
   }

   public List<RegionResponseVO> getCityList() {
      return this.cityList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setCountryId(final Long countryId) {
      this.countryId = countryId;
   }

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setCityList(final List<RegionResponseVO> cityList) {
      this.cityList = cityList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CityResponseVO)) {
         return false;
      }

      CityResponseVO other = (CityResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$countryId = this.getCountryId();
         Object other$countryId = other.getCountryId();
         if (this$countryId == null ? other$countryId == null : this$countryId.equals(other$countryId)) {
            Object this$provinceId = this.getProvinceId();
            Object other$provinceId = other.getProvinceId();
            if (this$provinceId == null ? other$provinceId == null : this$provinceId.equals(other$provinceId)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$code = this.getCode();
                  Object other$code = other.getCode();
                  if (this$code == null ? other$code == null : this$code.equals(other$code)) {
                     Object this$cityList = this.getCityList();
                     Object other$cityList = other.getCityList();
                     return this$cityList == null ? other$cityList == null : this$cityList.equals(other$cityList);
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
      return other instanceof CityResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $cityList = this.getCityList();
      return result * 59 + ($cityList == null ? 43 : $cityList.hashCode());
   }

   @Override
   public String toString() {
      return "CityResponseVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", code="
         + this.getCode()
         + ", countryId="
         + this.getCountryId()
         + ", provinceId="
         + this.getProvinceId()
         + ", cityList="
         + this.getCityList()
         + ")";
   }
}
