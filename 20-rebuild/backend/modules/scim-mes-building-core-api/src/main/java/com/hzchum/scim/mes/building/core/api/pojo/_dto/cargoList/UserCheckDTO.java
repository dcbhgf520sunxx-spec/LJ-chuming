package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

public class UserCheckDTO {
   @ApiModelProperty("手机号")
   @NotBlank(message = "手机号不能为空")
   private String phone;
   @ApiModelProperty("用户姓名")
   private String name;

   public static UserCheckDTO.UserCheckDTOBuilder builder() {
      return new UserCheckDTO.UserCheckDTOBuilder();
   }

   public String getPhone() {
      return this.phone;
   }

   public String getName() {
      return this.name;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof UserCheckDTO)) {
         return false;
      } else {
         UserCheckDTO other = (UserCheckDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$phone = this.getPhone();
            Object other$phone = other.getPhone();
            if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserCheckDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "UserCheckDTO(phone=" + this.getPhone() + ", name=" + this.getName() + ")";
   }

   public UserCheckDTO(final String phone, final String name) {
      this.phone = phone;
      this.name = name;
   }

   public UserCheckDTO() {
   }

   public static class UserCheckDTOBuilder {
      private String phone;
      private String name;

      UserCheckDTOBuilder() {
      }

      public UserCheckDTO.UserCheckDTOBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      public UserCheckDTO.UserCheckDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public UserCheckDTO build() {
         return new UserCheckDTO(this.phone, this.name);
      }

      @Override
      public String toString() {
         return "UserCheckDTO.UserCheckDTOBuilder(phone=" + this.phone + ", name=" + this.name + ")";
      }
   }
}
