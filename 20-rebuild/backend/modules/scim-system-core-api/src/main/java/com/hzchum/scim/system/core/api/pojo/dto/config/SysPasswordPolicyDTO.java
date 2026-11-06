package com.hzchum.scim.system.core.api.pojo.dto.config;

public class SysPasswordPolicyDTO {
   private Boolean containNumbers;
   private Boolean containSpecialCharacters;
   private Boolean containLetter;
   private Integer minLength;
   private String password;
   private Boolean loginVerification;

   public static SysPasswordPolicyDTO.SysPasswordPolicyDTOBuilder builder() {
      return new SysPasswordPolicyDTO.SysPasswordPolicyDTOBuilder();
   }

   public SysPasswordPolicyDTO() {
   }

   public SysPasswordPolicyDTO(
      final Boolean containNumbers,
      final Boolean containSpecialCharacters,
      final Boolean containLetter,
      final Integer minLength,
      final String password,
      final Boolean loginVerification
   ) {
      this.containNumbers = containNumbers;
      this.containSpecialCharacters = containSpecialCharacters;
      this.containLetter = containLetter;
      this.minLength = minLength;
      this.password = password;
      this.loginVerification = loginVerification;
   }

   public Boolean getContainNumbers() {
      return this.containNumbers;
   }

   public Boolean getContainSpecialCharacters() {
      return this.containSpecialCharacters;
   }

   public Boolean getContainLetter() {
      return this.containLetter;
   }

   public Integer getMinLength() {
      return this.minLength;
   }

   public String getPassword() {
      return this.password;
   }

   public Boolean getLoginVerification() {
      return this.loginVerification;
   }

   public void setContainNumbers(final Boolean containNumbers) {
      this.containNumbers = containNumbers;
   }

   public void setContainSpecialCharacters(final Boolean containSpecialCharacters) {
      this.containSpecialCharacters = containSpecialCharacters;
   }

   public void setContainLetter(final Boolean containLetter) {
      this.containLetter = containLetter;
   }

   public void setMinLength(final Integer minLength) {
      this.minLength = minLength;
   }

   public void setPassword(final String password) {
      this.password = password;
   }

   public void setLoginVerification(final Boolean loginVerification) {
      this.loginVerification = loginVerification;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPasswordPolicyDTO)) {
         return false;
      }

      SysPasswordPolicyDTO other = (SysPasswordPolicyDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$containNumbers = this.getContainNumbers();
      Object other$containNumbers = other.getContainNumbers();
      if (this$containNumbers == null ? other$containNumbers == null : this$containNumbers.equals(other$containNumbers)) {
         Object this$containSpecialCharacters = this.getContainSpecialCharacters();
         Object other$containSpecialCharacters = other.getContainSpecialCharacters();
         if (this$containSpecialCharacters == null
            ? other$containSpecialCharacters == null
            : this$containSpecialCharacters.equals(other$containSpecialCharacters)) {
            Object this$containLetter = this.getContainLetter();
            Object other$containLetter = other.getContainLetter();
            if (this$containLetter == null ? other$containLetter == null : this$containLetter.equals(other$containLetter)) {
               Object this$minLength = this.getMinLength();
               Object other$minLength = other.getMinLength();
               if (this$minLength == null ? other$minLength == null : this$minLength.equals(other$minLength)) {
                  Object this$loginVerification = this.getLoginVerification();
                  Object other$loginVerification = other.getLoginVerification();
                  if (this$loginVerification == null ? other$loginVerification == null : this$loginVerification.equals(other$loginVerification)) {
                     Object this$password = this.getPassword();
                     Object other$password = other.getPassword();
                     return this$password == null ? other$password == null : this$password.equals(other$password);
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
      return other instanceof SysPasswordPolicyDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $containNumbers = this.getContainNumbers();
      result = result * 59 + ($containNumbers == null ? 43 : $containNumbers.hashCode());
      Object $containSpecialCharacters = this.getContainSpecialCharacters();
      result = result * 59 + ($containSpecialCharacters == null ? 43 : $containSpecialCharacters.hashCode());
      Object $containLetter = this.getContainLetter();
      result = result * 59 + ($containLetter == null ? 43 : $containLetter.hashCode());
      Object $minLength = this.getMinLength();
      result = result * 59 + ($minLength == null ? 43 : $minLength.hashCode());
      Object $loginVerification = this.getLoginVerification();
      result = result * 59 + ($loginVerification == null ? 43 : $loginVerification.hashCode());
      Object $password = this.getPassword();
      return result * 59 + ($password == null ? 43 : $password.hashCode());
   }

   @Override
   public String toString() {
      return "SysPasswordPolicyDTO(containNumbers="
         + this.getContainNumbers()
         + ", containSpecialCharacters="
         + this.getContainSpecialCharacters()
         + ", containLetter="
         + this.getContainLetter()
         + ", minLength="
         + this.getMinLength()
         + ", password="
         + this.getPassword()
         + ", loginVerification="
         + this.getLoginVerification()
         + ")";
   }

   public static class SysPasswordPolicyDTOBuilder {
      private Boolean containNumbers;
      private Boolean containSpecialCharacters;
      private Boolean containLetter;
      private Integer minLength;
      private String password;
      private Boolean loginVerification;

      SysPasswordPolicyDTOBuilder() {
      }

      public SysPasswordPolicyDTO.SysPasswordPolicyDTOBuilder containNumbers(final Boolean containNumbers) {
         this.containNumbers = containNumbers;
         return this;
      }

      public SysPasswordPolicyDTO.SysPasswordPolicyDTOBuilder containSpecialCharacters(final Boolean containSpecialCharacters) {
         this.containSpecialCharacters = containSpecialCharacters;
         return this;
      }

      public SysPasswordPolicyDTO.SysPasswordPolicyDTOBuilder containLetter(final Boolean containLetter) {
         this.containLetter = containLetter;
         return this;
      }

      public SysPasswordPolicyDTO.SysPasswordPolicyDTOBuilder minLength(final Integer minLength) {
         this.minLength = minLength;
         return this;
      }

      public SysPasswordPolicyDTO.SysPasswordPolicyDTOBuilder password(final String password) {
         this.password = password;
         return this;
      }

      public SysPasswordPolicyDTO.SysPasswordPolicyDTOBuilder loginVerification(final Boolean loginVerification) {
         this.loginVerification = loginVerification;
         return this;
      }

      public SysPasswordPolicyDTO build() {
         return new SysPasswordPolicyDTO(
            this.containNumbers, this.containSpecialCharacters, this.containLetter, this.minLength, this.password, this.loginVerification
         );
      }

      @Override
      public String toString() {
         return "SysPasswordPolicyDTO.SysPasswordPolicyDTOBuilder(containNumbers="
            + this.containNumbers
            + ", containSpecialCharacters="
            + this.containSpecialCharacters
            + ", containLetter="
            + this.containLetter
            + ", minLength="
            + this.minLength
            + ", password="
            + this.password
            + ", loginVerification="
            + this.loginVerification
            + ")";
      }
   }
}
