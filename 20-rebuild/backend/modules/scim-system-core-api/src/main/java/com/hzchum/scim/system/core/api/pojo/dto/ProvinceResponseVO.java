package com.hzchum.scim.system.core.api.pojo.dto;

import java.io.Serializable;
import java.util.List;

public class ProvinceResponseVO implements Serializable {
   private static final long serialVersionUID = 1L;
   private Long id;
   private String name;
   private String code;
   private List<CityResponseVO> cityList;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getCode() {
      return this.code;
   }

   public List<CityResponseVO> getCityList() {
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

   public void setCityList(final List<CityResponseVO> cityList) {
      this.cityList = cityList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProvinceResponseVO)) {
         return false;
      }

      ProvinceResponseVO other = (ProvinceResponseVO)o;
      if (!other.canEqual(this)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProvinceResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $cityList = this.getCityList();
      return result * 59 + ($cityList == null ? 43 : $cityList.hashCode());
   }

   @Override
   public String toString() {
      return "ProvinceResponseVO(id=" + this.getId() + ", name=" + this.getName() + ", code=" + this.getCode() + ", cityList=" + this.getCityList() + ")";
   }
}
