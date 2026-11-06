package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OldUserCheckVO {
   @NotNull(message = "用户id不能为空")
   private Long id;
   private String name;
   @NotNull(message = "用户电话不能为空")
   private String phone;
   @NotNull(message = "过磅超标值不能为空")
   @Min(value = 0L, message = "过磅超标值不能小于0")
   private Double maxWeight;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getPhone() {
      return this.phone;
   }

   public Double getMaxWeight() {
      return this.maxWeight;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setMaxWeight(final Double maxWeight) {
      this.maxWeight = maxWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OldUserCheckVO)) {
         return false;
      }

      OldUserCheckVO other = (OldUserCheckVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$maxWeight = this.getMaxWeight();
         Object other$maxWeight = other.getMaxWeight();
         if (this$maxWeight == null ? other$maxWeight == null : this$maxWeight.equals(other$maxWeight)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$phone = this.getPhone();
               Object other$phone = other.getPhone();
               return this$phone == null ? other$phone == null : this$phone.equals(other$phone);
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
      return other instanceof OldUserCheckVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $maxWeight = this.getMaxWeight();
      result = result * 59 + ($maxWeight == null ? 43 : $maxWeight.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $phone = this.getPhone();
      return result * 59 + ($phone == null ? 43 : $phone.hashCode());
   }

   @Override
   public String toString() {
      return "OldUserCheckVO(id=" + this.getId() + ", name=" + this.getName() + ", phone=" + this.getPhone() + ", maxWeight=" + this.getMaxWeight() + ")";
   }
}
