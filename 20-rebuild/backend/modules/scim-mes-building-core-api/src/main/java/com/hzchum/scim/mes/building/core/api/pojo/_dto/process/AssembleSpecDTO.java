package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "组立规格配置类 ")
public class AssembleSpecDTO {
   @ApiModelProperty("规格前缀")
   private String specPrefix;
   @ApiModelProperty("是否生成工序(排产)")
   private Boolean boolSchedulingEnum;

   public static AssembleSpecDTO.AssembleSpecDTOBuilder builder() {
      return new AssembleSpecDTO.AssembleSpecDTOBuilder();
   }

   public AssembleSpecDTO() {
   }

   public AssembleSpecDTO(final String specPrefix, final Boolean boolSchedulingEnum) {
      this.specPrefix = specPrefix;
      this.boolSchedulingEnum = boolSchedulingEnum;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AssembleSpecDTO)) {
         return false;
      } else {
         AssembleSpecDTO other = (AssembleSpecDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
            Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
            if (this$boolSchedulingEnum == null ? other$boolSchedulingEnum == null : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
               Object this$specPrefix = this.getSpecPrefix();
               Object other$specPrefix = other.getSpecPrefix();
               return this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssembleSpecDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleSpecDTO(specPrefix=" + this.getSpecPrefix() + ", boolSchedulingEnum=" + this.getBoolSchedulingEnum() + ")";
   }

   public static class AssembleSpecDTOBuilder {
      private String specPrefix;
      private Boolean boolSchedulingEnum;

      AssembleSpecDTOBuilder() {
      }

      public AssembleSpecDTO.AssembleSpecDTOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public AssembleSpecDTO.AssembleSpecDTOBuilder boolSchedulingEnum(final Boolean boolSchedulingEnum) {
         this.boolSchedulingEnum = boolSchedulingEnum;
         return this;
      }

      public AssembleSpecDTO build() {
         return new AssembleSpecDTO(this.specPrefix, this.boolSchedulingEnum);
      }

      @Override
      public String toString() {
         return "AssembleSpecDTO.AssembleSpecDTOBuilder(specPrefix=" + this.specPrefix + ", boolSchedulingEnum=" + this.boolSchedulingEnum + ")";
      }
   }
}
