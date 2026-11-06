package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel("SHR返回对象")
public class SHRUserInfoDTO {
   @JsonProperty("人员编号")
   private String userCode;
   @JsonProperty("人员名称")
   private String userName;
   @JsonProperty("手机号")
   private String phone;
   @JsonProperty("性别")
   private String gender;
   @JsonProperty("部门编号")
   private String deptCode;
   @JsonProperty("岗位编号")
   private String positionCode;
   @JsonProperty("排序")
   private Integer sort;
   @JsonProperty("邮箱")
   private String email;
   @JsonProperty("人资类型")
   private Integer assignType;

   public static SHRUserInfoDTO.SHRUserInfoDTOBuilder builder() {
      return new SHRUserInfoDTO.SHRUserInfoDTOBuilder();
   }

   public SHRUserInfoDTO() {
   }

   public SHRUserInfoDTO(
      final String userCode,
      final String userName,
      final String phone,
      final String gender,
      final String deptCode,
      final String positionCode,
      final Integer sort,
      final String email,
      final Integer assignType
   ) {
      this.userCode = userCode;
      this.userName = userName;
      this.phone = phone;
      this.gender = gender;
      this.deptCode = deptCode;
      this.positionCode = positionCode;
      this.sort = sort;
      this.email = email;
      this.assignType = assignType;
   }

   public String getUserCode() {
      return this.userCode;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getGender() {
      return this.gender;
   }

   public String getDeptCode() {
      return this.deptCode;
   }

   public String getPositionCode() {
      return this.positionCode;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getEmail() {
      return this.email;
   }

   public Integer getAssignType() {
      return this.assignType;
   }

   @JsonProperty("人员编号")
   public SHRUserInfoDTO setUserCode(final String userCode) {
      this.userCode = userCode;
      return this;
   }

   @JsonProperty("人员名称")
   public SHRUserInfoDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("手机号")
   public SHRUserInfoDTO setPhone(final String phone) {
      this.phone = phone;
      return this;
   }

   @JsonProperty("性别")
   public SHRUserInfoDTO setGender(final String gender) {
      this.gender = gender;
      return this;
   }

   @JsonProperty("部门编号")
   public SHRUserInfoDTO setDeptCode(final String deptCode) {
      this.deptCode = deptCode;
      return this;
   }

   @JsonProperty("岗位编号")
   public SHRUserInfoDTO setPositionCode(final String positionCode) {
      this.positionCode = positionCode;
      return this;
   }

   @JsonProperty("排序")
   public SHRUserInfoDTO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("邮箱")
   public SHRUserInfoDTO setEmail(final String email) {
      this.email = email;
      return this;
   }

   @JsonProperty("人资类型")
   public SHRUserInfoDTO setAssignType(final Integer assignType) {
      this.assignType = assignType;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SHRUserInfoDTO)) {
         return false;
      }

      SHRUserInfoDTO other = (SHRUserInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sort = this.getSort();
      Object other$sort = other.getSort();
      if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
         Object this$assignType = this.getAssignType();
         Object other$assignType = other.getAssignType();
         if (this$assignType == null ? other$assignType == null : this$assignType.equals(other$assignType)) {
            Object this$userCode = this.getUserCode();
            Object other$userCode = other.getUserCode();
            if (this$userCode == null ? other$userCode == null : this$userCode.equals(other$userCode)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                  Object this$phone = this.getPhone();
                  Object other$phone = other.getPhone();
                  if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                     Object this$gender = this.getGender();
                     Object other$gender = other.getGender();
                     if (this$gender == null ? other$gender == null : this$gender.equals(other$gender)) {
                        Object this$deptCode = this.getDeptCode();
                        Object other$deptCode = other.getDeptCode();
                        if (this$deptCode == null ? other$deptCode == null : this$deptCode.equals(other$deptCode)) {
                           Object this$positionCode = this.getPositionCode();
                           Object other$positionCode = other.getPositionCode();
                           if (this$positionCode == null ? other$positionCode == null : this$positionCode.equals(other$positionCode)) {
                              Object this$email = this.getEmail();
                              Object other$email = other.getEmail();
                              return this$email == null ? other$email == null : this$email.equals(other$email);
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
      return other instanceof SHRUserInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $assignType = this.getAssignType();
      result = result * 59 + ($assignType == null ? 43 : $assignType.hashCode());
      Object $userCode = this.getUserCode();
      result = result * 59 + ($userCode == null ? 43 : $userCode.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $gender = this.getGender();
      result = result * 59 + ($gender == null ? 43 : $gender.hashCode());
      Object $deptCode = this.getDeptCode();
      result = result * 59 + ($deptCode == null ? 43 : $deptCode.hashCode());
      Object $positionCode = this.getPositionCode();
      result = result * 59 + ($positionCode == null ? 43 : $positionCode.hashCode());
      Object $email = this.getEmail();
      return result * 59 + ($email == null ? 43 : $email.hashCode());
   }

   @Override
   public String toString() {
      return "SHRUserInfoDTO(userCode="
         + this.getUserCode()
         + ", userName="
         + this.getUserName()
         + ", phone="
         + this.getPhone()
         + ", gender="
         + this.getGender()
         + ", deptCode="
         + this.getDeptCode()
         + ", positionCode="
         + this.getPositionCode()
         + ", sort="
         + this.getSort()
         + ", email="
         + this.getEmail()
         + ", assignType="
         + this.getAssignType()
         + ")";
   }

   public static class SHRUserInfoDTOBuilder {
      private String userCode;
      private String userName;
      private String phone;
      private String gender;
      private String deptCode;
      private String positionCode;
      private Integer sort;
      private String email;
      private Integer assignType;

      SHRUserInfoDTOBuilder() {
      }

      @JsonProperty("人员编号")
      public SHRUserInfoDTO.SHRUserInfoDTOBuilder userCode(final String userCode) {
         this.userCode = userCode;
         return this;
      }

      @JsonProperty("人员名称")
      public SHRUserInfoDTO.SHRUserInfoDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("手机号")
      public SHRUserInfoDTO.SHRUserInfoDTOBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      @JsonProperty("性别")
      public SHRUserInfoDTO.SHRUserInfoDTOBuilder gender(final String gender) {
         this.gender = gender;
         return this;
      }

      @JsonProperty("部门编号")
      public SHRUserInfoDTO.SHRUserInfoDTOBuilder deptCode(final String deptCode) {
         this.deptCode = deptCode;
         return this;
      }

      @JsonProperty("岗位编号")
      public SHRUserInfoDTO.SHRUserInfoDTOBuilder positionCode(final String positionCode) {
         this.positionCode = positionCode;
         return this;
      }

      @JsonProperty("排序")
      public SHRUserInfoDTO.SHRUserInfoDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("邮箱")
      public SHRUserInfoDTO.SHRUserInfoDTOBuilder email(final String email) {
         this.email = email;
         return this;
      }

      @JsonProperty("人资类型")
      public SHRUserInfoDTO.SHRUserInfoDTOBuilder assignType(final Integer assignType) {
         this.assignType = assignType;
         return this;
      }

      public SHRUserInfoDTO build() {
         return new SHRUserInfoDTO(
            this.userCode, this.userName, this.phone, this.gender, this.deptCode, this.positionCode, this.sort, this.email, this.assignType
         );
      }

      @Override
      public String toString() {
         return "SHRUserInfoDTO.SHRUserInfoDTOBuilder(userCode="
            + this.userCode
            + ", userName="
            + this.userName
            + ", phone="
            + this.phone
            + ", gender="
            + this.gender
            + ", deptCode="
            + this.deptCode
            + ", positionCode="
            + this.positionCode
            + ", sort="
            + this.sort
            + ", email="
            + this.email
            + ", assignType="
            + this.assignType
            + ")";
      }
   }
}
