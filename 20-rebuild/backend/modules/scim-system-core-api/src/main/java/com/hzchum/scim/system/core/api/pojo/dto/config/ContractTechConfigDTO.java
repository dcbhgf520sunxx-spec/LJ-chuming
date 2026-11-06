package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;

public class ContractTechConfigDTO {
   @ApiModelProperty("是否必填 true必填 false选填")
   private Boolean boolRequiredInput;

   public static ContractTechConfigDTO.ContractTechConfigDTOBuilder builder() {
      return new ContractTechConfigDTO.ContractTechConfigDTOBuilder();
   }

   public ContractTechConfigDTO(final Boolean boolRequiredInput) {
      this.boolRequiredInput = boolRequiredInput;
   }

   public ContractTechConfigDTO() {
   }

   public Boolean getBoolRequiredInput() {
      return this.boolRequiredInput;
   }

   public void setBoolRequiredInput(final Boolean boolRequiredInput) {
      this.boolRequiredInput = boolRequiredInput;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractTechConfigDTO)) {
         return false;
      }

      ContractTechConfigDTO other = (ContractTechConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolRequiredInput = this.getBoolRequiredInput();
      Object other$boolRequiredInput = other.getBoolRequiredInput();
      return this$boolRequiredInput == null ? other$boolRequiredInput == null : this$boolRequiredInput.equals(other$boolRequiredInput);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractTechConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolRequiredInput = this.getBoolRequiredInput();
      return result * 59 + ($boolRequiredInput == null ? 43 : $boolRequiredInput.hashCode());
   }

   @Override
   public String toString() {
      return "ContractTechConfigDTO(boolRequiredInput=" + this.getBoolRequiredInput() + ")";
   }

   public static class ContractTechConfigDTOBuilder {
      private Boolean boolRequiredInput;

      ContractTechConfigDTOBuilder() {
      }

      public ContractTechConfigDTO.ContractTechConfigDTOBuilder boolRequiredInput(final Boolean boolRequiredInput) {
         this.boolRequiredInput = boolRequiredInput;
         return this;
      }

      public ContractTechConfigDTO build() {
         return new ContractTechConfigDTO(this.boolRequiredInput);
      }

      @Override
      public String toString() {
         return "ContractTechConfigDTO.ContractTechConfigDTOBuilder(boolRequiredInput=" + this.boolRequiredInput + ")";
      }
   }
}
