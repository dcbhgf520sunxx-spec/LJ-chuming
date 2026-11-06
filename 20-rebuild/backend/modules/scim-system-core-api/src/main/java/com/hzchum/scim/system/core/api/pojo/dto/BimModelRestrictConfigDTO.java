package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Bim已上传限制配置")
public class BimModelRestrictConfigDTO {
   @ApiModelProperty("code")
   private String code;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("value")
   private String value;

   BimModelRestrictConfigDTO(final String code, final String name, final String value) {
      this.code = code;
      this.name = name;
      this.value = value;
   }

   public static BimModelRestrictConfigDTO.BimModelRestrictConfigDTOBuilder builder() {
      return new BimModelRestrictConfigDTO.BimModelRestrictConfigDTOBuilder();
   }

   public String getCode() {
      return this.code;
   }

   public String getName() {
      return this.name;
   }

   public String getValue() {
      return this.value;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setValue(final String value) {
      this.value = value;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimModelRestrictConfigDTO)) {
         return false;
      }

      BimModelRestrictConfigDTO other = (BimModelRestrictConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$code = this.getCode();
      Object other$code = other.getCode();
      if (this$code == null ? other$code == null : this$code.equals(other$code)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$value = this.getValue();
            Object other$value = other.getValue();
            return this$value == null ? other$value == null : this$value.equals(other$value);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BimModelRestrictConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   @Override
   public String toString() {
      return "BimModelRestrictConfigDTO(code=" + this.getCode() + ", name=" + this.getName() + ", value=" + this.getValue() + ")";
   }

   public static class BimModelRestrictConfigDTOBuilder {
      private String code;
      private String name;
      private String value;

      BimModelRestrictConfigDTOBuilder() {
      }

      public BimModelRestrictConfigDTO.BimModelRestrictConfigDTOBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public BimModelRestrictConfigDTO.BimModelRestrictConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BimModelRestrictConfigDTO.BimModelRestrictConfigDTOBuilder value(final String value) {
         this.value = value;
         return this;
      }

      public BimModelRestrictConfigDTO build() {
         return new BimModelRestrictConfigDTO(this.code, this.name, this.value);
      }

      @Override
      public String toString() {
         return "BimModelRestrictConfigDTO.BimModelRestrictConfigDTOBuilder(code=" + this.code + ", name=" + this.name + ", value=" + this.value + ")";
      }
   }
}
