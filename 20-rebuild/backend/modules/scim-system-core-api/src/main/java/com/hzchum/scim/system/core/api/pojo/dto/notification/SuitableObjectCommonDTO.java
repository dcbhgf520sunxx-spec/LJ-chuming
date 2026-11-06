package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;

public class SuitableObjectCommonDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "适用对象名称 可能是人员 部门 岗位")
   private String name;
   @ApiModelProperty(name = "phoneNumber", notes = "电话号码（只适用于人员）")
   private String phoneNumber;

   SuitableObjectCommonDTO(final Long id, final String name, final String phoneNumber) {
      this.id = id;
      this.name = name;
      this.phoneNumber = phoneNumber;
   }

   public static SuitableObjectCommonDTO.SuitableObjectCommonDTOBuilder builder() {
      return new SuitableObjectCommonDTO.SuitableObjectCommonDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getPhoneNumber() {
      return this.phoneNumber;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPhoneNumber(final String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SuitableObjectCommonDTO)) {
         return false;
      }

      SuitableObjectCommonDTO other = (SuitableObjectCommonDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$phoneNumber = this.getPhoneNumber();
            Object other$phoneNumber = other.getPhoneNumber();
            return this$phoneNumber == null ? other$phoneNumber == null : this$phoneNumber.equals(other$phoneNumber);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SuitableObjectCommonDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $phoneNumber = this.getPhoneNumber();
      return result * 59 + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
   }

   @Override
   public String toString() {
      return "SuitableObjectCommonDTO(id=" + this.getId() + ", name=" + this.getName() + ", phoneNumber=" + this.getPhoneNumber() + ")";
   }

   public static class SuitableObjectCommonDTOBuilder {
      private Long id;
      private String name;
      private String phoneNumber;

      SuitableObjectCommonDTOBuilder() {
      }

      public SuitableObjectCommonDTO.SuitableObjectCommonDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SuitableObjectCommonDTO.SuitableObjectCommonDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SuitableObjectCommonDTO.SuitableObjectCommonDTOBuilder phoneNumber(final String phoneNumber) {
         this.phoneNumber = phoneNumber;
         return this;
      }

      public SuitableObjectCommonDTO build() {
         return new SuitableObjectCommonDTO(this.id, this.name, this.phoneNumber);
      }

      @Override
      public String toString() {
         return "SuitableObjectCommonDTO.SuitableObjectCommonDTOBuilder(id=" + this.id + ", name=" + this.name + ", phoneNumber=" + this.phoneNumber + ")";
      }
   }
}
