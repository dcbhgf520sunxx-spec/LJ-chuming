package com.hzchum.scim.system.core.api.pojo.dto;

import java.io.Serializable;

public class RegionResponseVO implements Serializable {
   private static final long serialVersionUID = 1L;
   private Long id;
   private String name;
   private String code;
   private Long cityId;

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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setCityId(final Long cityId) {
      this.cityId = cityId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RegionResponseVO)) {
         return false;
      }

      RegionResponseVO other = (RegionResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cityId = this.getCityId();
         Object other$cityId = other.getCityId();
         if (this$cityId == null ? other$cityId == null : this$cityId.equals(other$cityId)) {
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

   protected boolean canEqual(final Object other) {
      return other instanceof RegionResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   @Override
   public String toString() {
      return "RegionResponseVO(id=" + this.getId() + ", name=" + this.getName() + ", code=" + this.getCode() + ", cityId=" + this.getCityId() + ")";
   }
}
