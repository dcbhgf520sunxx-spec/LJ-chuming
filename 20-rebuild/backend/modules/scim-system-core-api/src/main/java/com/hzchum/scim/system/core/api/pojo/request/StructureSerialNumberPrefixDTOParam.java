package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(value = "SysStructureSerialNumberPrefix对象", description = "构件编号前缀表")
public class StructureSerialNumberPrefixDTOParam {
   @NotBlank(message = "编号前缀不能为空")
   @ApiModelProperty(name = "serialNumberPrefix", value = "编号前缀", notes = "编号前缀")
   @Size(min = 1, max = 16, message = "编号前缀长度超出范围")
   private String serialNumberPrefix;
   @ApiModelProperty("构件编号前缀id")
   private Long id;

   public static StructureSerialNumberPrefixDTOParam.StructureSerialNumberPrefixDTOParamBuilder builder() {
      return new StructureSerialNumberPrefixDTOParam.StructureSerialNumberPrefixDTOParamBuilder();
   }

   public StructureSerialNumberPrefixDTOParam() {
   }

   public StructureSerialNumberPrefixDTOParam(final String serialNumberPrefix, final Long id) {
      this.serialNumberPrefix = serialNumberPrefix;
      this.id = id;
   }

   public String getSerialNumberPrefix() {
      return this.serialNumberPrefix;
   }

   public Long getId() {
      return this.id;
   }

   public void setSerialNumberPrefix(final String serialNumberPrefix) {
      this.serialNumberPrefix = serialNumberPrefix;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof StructureSerialNumberPrefixDTOParam)) {
         return false;
      } else {
         StructureSerialNumberPrefixDTOParam other = (StructureSerialNumberPrefixDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$serialNumberPrefix = this.getSerialNumberPrefix();
               Object other$serialNumberPrefix = other.getSerialNumberPrefix();
               return this$serialNumberPrefix == null ? other$serialNumberPrefix == null : this$serialNumberPrefix.equals(other$serialNumberPrefix);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof StructureSerialNumberPrefixDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $serialNumberPrefix = this.getSerialNumberPrefix();
      return result * 59 + ($serialNumberPrefix == null ? 43 : $serialNumberPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "StructureSerialNumberPrefixDTOParam(serialNumberPrefix=" + this.getSerialNumberPrefix() + ", id=" + this.getId() + ")";
   }

   public static class StructureSerialNumberPrefixDTOParamBuilder {
      private String serialNumberPrefix;
      private Long id;

      StructureSerialNumberPrefixDTOParamBuilder() {
      }

      public StructureSerialNumberPrefixDTOParam.StructureSerialNumberPrefixDTOParamBuilder serialNumberPrefix(final String serialNumberPrefix) {
         this.serialNumberPrefix = serialNumberPrefix;
         return this;
      }

      public StructureSerialNumberPrefixDTOParam.StructureSerialNumberPrefixDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public StructureSerialNumberPrefixDTOParam build() {
         return new StructureSerialNumberPrefixDTOParam(this.serialNumberPrefix, this.id);
      }

      @Override
      public String toString() {
         return "StructureSerialNumberPrefixDTOParam.StructureSerialNumberPrefixDTOParamBuilder(serialNumberPrefix="
            + this.serialNumberPrefix
            + ", id="
            + this.id
            + ")";
      }
   }
}
