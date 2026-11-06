package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(description = "构件规格配置表 ")
public class StructureSpecSaveDTOParam {
   @ApiModelProperty("构件规格前缀")
   @NotBlank(message = "构件规格前缀")
   @Size(min = 1, max = 32, message = "构件规格前缀长度超出范围")
   private String specPrefix;

   public static StructureSpecSaveDTOParam.StructureSpecSaveDTOParamBuilder builder() {
      return new StructureSpecSaveDTOParam.StructureSpecSaveDTOParamBuilder();
   }

   public StructureSpecSaveDTOParam() {
   }

   public StructureSpecSaveDTOParam(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StructureSpecSaveDTOParam)) {
         return false;
      }

      StructureSpecSaveDTOParam other = (StructureSpecSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$specPrefix = this.getSpecPrefix();
      Object other$specPrefix = other.getSpecPrefix();
      return this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof StructureSpecSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "StructureSpecSaveDTOParam(specPrefix=" + this.getSpecPrefix() + ")";
   }

   public static class StructureSpecSaveDTOParamBuilder {
      private String specPrefix;

      StructureSpecSaveDTOParamBuilder() {
      }

      public StructureSpecSaveDTOParam.StructureSpecSaveDTOParamBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public StructureSpecSaveDTOParam build() {
         return new StructureSpecSaveDTOParam(this.specPrefix);
      }

      @Override
      public String toString() {
         return "StructureSpecSaveDTOParam.StructureSpecSaveDTOParamBuilder(specPrefix=" + this.specPrefix + ")";
      }
   }
}
