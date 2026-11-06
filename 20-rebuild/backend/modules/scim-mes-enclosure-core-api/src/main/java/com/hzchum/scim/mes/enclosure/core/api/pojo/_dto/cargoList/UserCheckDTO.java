package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModelProperty;

public class UserCheckDTO {
   @ApiModelProperty("手机号")
   private String phone;
   @ApiModelProperty("用户姓名")
   private String name;
   @ApiModelProperty("是否通过")
   private Boolean isPass = false;

   public static UserCheckDTO.UserCheckDTOBuilder builder() {
      return new UserCheckDTO.UserCheckDTOBuilder();
   }

   public String getPhone() {
      return this.phone;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getIsPass() {
      return this.isPass;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setIsPass(final Boolean isPass) {
      this.isPass = isPass;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserCheckDTO)) {
         return false;
      }

      UserCheckDTO other = (UserCheckDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$isPass = this.getIsPass();
      Object other$isPass = other.getIsPass();
      if (this$isPass == null ? other$isPass == null : this$isPass.equals(other$isPass)) {
         Object this$phone = this.getPhone();
         Object other$phone = other.getPhone();
         if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserCheckDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $isPass = this.getIsPass();
      result = result * 59 + ($isPass == null ? 43 : $isPass.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "UserCheckDTO(phone=" + this.getPhone() + ", name=" + this.getName() + ", isPass=" + this.getIsPass() + ")";
   }

   public UserCheckDTO(final String phone, final String name, final Boolean isPass) {
      this.phone = phone;
      this.name = name;
      this.isPass = isPass;
   }

   public UserCheckDTO() {
   }

   public static class UserCheckDTOBuilder {
      private String phone;
      private String name;
      private Boolean isPass;

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

      public UserCheckDTO.UserCheckDTOBuilder isPass(final Boolean isPass) {
         this.isPass = isPass;
         return this;
      }

      public UserCheckDTO build() {
         return new UserCheckDTO(this.phone, this.name, this.isPass);
      }

      @Override
      public String toString() {
         return "UserCheckDTO.UserCheckDTOBuilder(phone=" + this.phone + ", name=" + this.name + ", isPass=" + this.isPass + ")";
      }
   }
}
