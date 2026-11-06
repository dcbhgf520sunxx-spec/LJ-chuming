package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class OverweightSMSUserDTO {
   @ApiModelProperty("是否通过")
   private Boolean isPass = false;
   @ApiModelProperty("短信接收用户")
   private List<UserCheckDTO> userChecks;

   public static OverweightSMSUserDTO.OverweightSMSUserDTOBuilder builder() {
      return new OverweightSMSUserDTO.OverweightSMSUserDTOBuilder();
   }

   public Boolean getIsPass() {
      return this.isPass;
   }

   public List<UserCheckDTO> getUserChecks() {
      return this.userChecks;
   }

   public void setIsPass(final Boolean isPass) {
      this.isPass = isPass;
   }

   public void setUserChecks(final List<UserCheckDTO> userChecks) {
      this.userChecks = userChecks;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof OverweightSMSUserDTO)) {
         return false;
      } else {
         OverweightSMSUserDTO other = (OverweightSMSUserDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$isPass = this.getIsPass();
            Object other$isPass = other.getIsPass();
            if (this$isPass == null ? other$isPass == null : this$isPass.equals(other$isPass)) {
               Object this$userChecks = this.getUserChecks();
               Object other$userChecks = other.getUserChecks();
               return this$userChecks == null ? other$userChecks == null : this$userChecks.equals(other$userChecks);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OverweightSMSUserDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $isPass = this.getIsPass();
      result = result * 59 + ($isPass == null ? 43 : $isPass.hashCode());
      Object $userChecks = this.getUserChecks();
      return result * 59 + ($userChecks == null ? 43 : $userChecks.hashCode());
   }

   @Override
   public String toString() {
      return "OverweightSMSUserDTO(isPass=" + this.getIsPass() + ", userChecks=" + this.getUserChecks() + ")";
   }

   public OverweightSMSUserDTO(final Boolean isPass, final List<UserCheckDTO> userChecks) {
      this.isPass = isPass;
      this.userChecks = userChecks;
   }

   public OverweightSMSUserDTO() {
   }

   public static class OverweightSMSUserDTOBuilder {
      private Boolean isPass;
      private List<UserCheckDTO> userChecks;

      OverweightSMSUserDTOBuilder() {
      }

      public OverweightSMSUserDTO.OverweightSMSUserDTOBuilder isPass(final Boolean isPass) {
         this.isPass = isPass;
         return this;
      }

      public OverweightSMSUserDTO.OverweightSMSUserDTOBuilder userChecks(final List<UserCheckDTO> userChecks) {
         this.userChecks = userChecks;
         return this;
      }

      public OverweightSMSUserDTO build() {
         return new OverweightSMSUserDTO(this.isPass, this.userChecks);
      }

      @Override
      public String toString() {
         return "OverweightSMSUserDTO.OverweightSMSUserDTOBuilder(isPass=" + this.isPass + ", userChecks=" + this.userChecks + ")";
      }
   }
}
