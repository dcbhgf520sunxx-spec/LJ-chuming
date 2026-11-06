package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;

@ApiModel("token解析供应商用户信息返回类")
public class SupplierUserInfoDTO {
   private Long id;
   private String name;
   private String username;
   private String phone;
   private Long supplierId;
   private String supplierName;
   private Boolean isEnabled;
   private Integer sex;
   private Integer userType;

   public static SupplierUserInfoDTO.SupplierUserInfoDTOBuilder builder() {
      return new SupplierUserInfoDTO.SupplierUserInfoDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getUsername() {
      return this.username;
   }

   public String getPhone() {
      return this.phone;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Boolean getIsEnabled() {
      return this.isEnabled;
   }

   public Integer getSex() {
      return this.sex;
   }

   public Integer getUserType() {
      return this.userType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setUsername(final String username) {
      this.username = username;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setIsEnabled(final Boolean isEnabled) {
      this.isEnabled = isEnabled;
   }

   public void setSex(final Integer sex) {
      this.sex = sex;
   }

   public void setUserType(final Integer userType) {
      this.userType = userType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierUserInfoDTO)) {
         return false;
      }

      SupplierUserInfoDTO other = (SupplierUserInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$isEnabled = this.getIsEnabled();
            Object other$isEnabled = other.getIsEnabled();
            if (this$isEnabled == null ? other$isEnabled == null : this$isEnabled.equals(other$isEnabled)) {
               Object this$sex = this.getSex();
               Object other$sex = other.getSex();
               if (this$sex == null ? other$sex == null : this$sex.equals(other$sex)) {
                  Object this$userType = this.getUserType();
                  Object other$userType = other.getUserType();
                  if (this$userType == null ? other$userType == null : this$userType.equals(other$userType)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$username = this.getUsername();
                        Object other$username = other.getUsername();
                        if (this$username == null ? other$username == null : this$username.equals(other$username)) {
                           Object this$phone = this.getPhone();
                           Object other$phone = other.getPhone();
                           if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                              Object this$supplierName = this.getSupplierName();
                              Object other$supplierName = other.getSupplierName();
                              return this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName);
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

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierUserInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $isEnabled = this.getIsEnabled();
      result = result * 59 + ($isEnabled == null ? 43 : $isEnabled.hashCode());
      Object $sex = this.getSex();
      result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
      Object $userType = this.getUserType();
      result = result * 59 + ($userType == null ? 43 : $userType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $username = this.getUsername();
      result = result * 59 + ($username == null ? 43 : $username.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $supplierName = this.getSupplierName();
      return result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierUserInfoDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", username="
         + this.getUsername()
         + ", phone="
         + this.getPhone()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", isEnabled="
         + this.getIsEnabled()
         + ", sex="
         + this.getSex()
         + ", userType="
         + this.getUserType()
         + ")";
   }

   public SupplierUserInfoDTO(
      final Long id,
      final String name,
      final String username,
      final String phone,
      final Long supplierId,
      final String supplierName,
      final Boolean isEnabled,
      final Integer sex,
      final Integer userType
   ) {
      this.id = id;
      this.name = name;
      this.username = username;
      this.phone = phone;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.isEnabled = isEnabled;
      this.sex = sex;
      this.userType = userType;
   }

   public SupplierUserInfoDTO() {
   }

   public static class SupplierUserInfoDTOBuilder {
      private Long id;
      private String name;
      private String username;
      private String phone;
      private Long supplierId;
      private String supplierName;
      private Boolean isEnabled;
      private Integer sex;
      private Integer userType;

      SupplierUserInfoDTOBuilder() {
      }

      public SupplierUserInfoDTO.SupplierUserInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierUserInfoDTO.SupplierUserInfoDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SupplierUserInfoDTO.SupplierUserInfoDTOBuilder username(final String username) {
         this.username = username;
         return this;
      }

      public SupplierUserInfoDTO.SupplierUserInfoDTOBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      public SupplierUserInfoDTO.SupplierUserInfoDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierUserInfoDTO.SupplierUserInfoDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierUserInfoDTO.SupplierUserInfoDTOBuilder isEnabled(final Boolean isEnabled) {
         this.isEnabled = isEnabled;
         return this;
      }

      public SupplierUserInfoDTO.SupplierUserInfoDTOBuilder sex(final Integer sex) {
         this.sex = sex;
         return this;
      }

      public SupplierUserInfoDTO.SupplierUserInfoDTOBuilder userType(final Integer userType) {
         this.userType = userType;
         return this;
      }

      public SupplierUserInfoDTO build() {
         return new SupplierUserInfoDTO(
            this.id, this.name, this.username, this.phone, this.supplierId, this.supplierName, this.isEnabled, this.sex, this.userType
         );
      }

      @Override
      public String toString() {
         return "SupplierUserInfoDTO.SupplierUserInfoDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", username="
            + this.username
            + ", phone="
            + this.phone
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", isEnabled="
            + this.isEnabled
            + ", sex="
            + this.sex
            + ", userType="
            + this.userType
            + ")";
      }
   }
}
