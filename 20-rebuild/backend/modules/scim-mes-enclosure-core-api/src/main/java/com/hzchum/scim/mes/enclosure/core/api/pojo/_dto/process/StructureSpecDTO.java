package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "构件规格配置表 ")
public class StructureSpecDTO {
   @ApiModelProperty("构件规格前缀")
   private String specPrefix;
   @ApiModelProperty("是否使用组立 1是 0否")
   private Boolean boolUseAssemble;

   public static StructureSpecDTO.StructureSpecDTOBuilder builder() {
      return new StructureSpecDTO.StructureSpecDTOBuilder();
   }

   public StructureSpecDTO() {
   }

   public StructureSpecDTO(final String specPrefix, final Boolean boolUseAssemble) {
      this.specPrefix = specPrefix;
      this.boolUseAssemble = boolUseAssemble;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Boolean getBoolUseAssemble() {
      return this.boolUseAssemble;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setBoolUseAssemble(final Boolean boolUseAssemble) {
      this.boolUseAssemble = boolUseAssemble;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof StructureSpecDTO)) {
         return false;
      } else {
         StructureSpecDTO other = (StructureSpecDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$boolUseAssemble = this.getBoolUseAssemble();
            Object other$boolUseAssemble = other.getBoolUseAssemble();
            if (this$boolUseAssemble == null ? other$boolUseAssemble == null : this$boolUseAssemble.equals(other$boolUseAssemble)) {
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
      return other instanceof StructureSpecDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolUseAssemble = this.getBoolUseAssemble();
      result = result * 59 + ($boolUseAssemble == null ? 43 : $boolUseAssemble.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "StructureSpecDTO(specPrefix=" + this.getSpecPrefix() + ", boolUseAssemble=" + this.getBoolUseAssemble() + ")";
   }

   public static class StructureSpecDTOBuilder {
      private String specPrefix;
      private Boolean boolUseAssemble;

      StructureSpecDTOBuilder() {
      }

      public StructureSpecDTO.StructureSpecDTOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public StructureSpecDTO.StructureSpecDTOBuilder boolUseAssemble(final Boolean boolUseAssemble) {
         this.boolUseAssemble = boolUseAssemble;
         return this;
      }

      public StructureSpecDTO build() {
         return new StructureSpecDTO(this.specPrefix, this.boolUseAssemble);
      }

      @Override
      public String toString() {
         return "StructureSpecDTO.StructureSpecDTOBuilder(specPrefix=" + this.specPrefix + ", boolUseAssemble=" + this.boolUseAssemble + ")";
      }
   }
}
