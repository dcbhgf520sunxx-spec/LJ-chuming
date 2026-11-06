package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(description = "构件规格配置表 ")
public class StructureSpecUpdateDTOParam {
   @ApiModelProperty("构件规格前缀")
   @NotBlank(message = "构件规格前缀")
   @Size(min = 1, max = 16, message = "构件规格前缀字数长度超出范围")
   private String specPrefix;
   @ApiModelProperty("构件规格前缀id")
   private Long id;

   public static StructureSpecUpdateDTOParam.StructureSpecUpdateDTOParamBuilder builder() {
      return new StructureSpecUpdateDTOParam.StructureSpecUpdateDTOParamBuilder();
   }

   public StructureSpecUpdateDTOParam() {
   }

   public StructureSpecUpdateDTOParam(final String specPrefix, final Long id) {
      this.specPrefix = specPrefix;
      this.id = id;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Long getId() {
      return this.id;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof StructureSpecUpdateDTOParam)) {
         return false;
      } else {
         StructureSpecUpdateDTOParam other = (StructureSpecUpdateDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
      return other instanceof StructureSpecUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "StructureSpecUpdateDTOParam(specPrefix=" + this.getSpecPrefix() + ", id=" + this.getId() + ")";
   }

   public static class StructureSpecUpdateDTOParamBuilder {
      private String specPrefix;
      private Long id;

      StructureSpecUpdateDTOParamBuilder() {
      }

      public StructureSpecUpdateDTOParam.StructureSpecUpdateDTOParamBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public StructureSpecUpdateDTOParam.StructureSpecUpdateDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public StructureSpecUpdateDTOParam build() {
         return new StructureSpecUpdateDTOParam(this.specPrefix, this.id);
      }

      @Override
      public String toString() {
         return "StructureSpecUpdateDTOParam.StructureSpecUpdateDTOParamBuilder(specPrefix=" + this.specPrefix + ", id=" + this.id + ")";
      }
   }
}
