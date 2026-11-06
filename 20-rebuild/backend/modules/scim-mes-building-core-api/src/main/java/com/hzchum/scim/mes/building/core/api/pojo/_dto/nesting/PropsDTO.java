package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "套料报告单第二部分", description = "套料报告单第二部分")
public class PropsDTO {
   private String prop_value;
   private String prop_name;

   public static PropsDTO.PropsDTOBuilder builder() {
      return new PropsDTO.PropsDTOBuilder();
   }

   public PropsDTO(final String prop_value, final String prop_name) {
      this.prop_value = prop_value;
      this.prop_name = prop_name;
   }

   public PropsDTO() {
   }

   public String getProp_value() {
      return this.prop_value;
   }

   public String getProp_name() {
      return this.prop_name;
   }

   public PropsDTO setProp_value(final String prop_value) {
      this.prop_value = prop_value;
      return this;
   }

   public PropsDTO setProp_name(final String prop_name) {
      this.prop_name = prop_name;
      return this;
   }

   @Override
   public String toString() {
      return "PropsDTO(prop_value=" + this.getProp_value() + ", prop_name=" + this.getProp_name() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PropsDTO)) {
         return false;
      } else {
         PropsDTO other = (PropsDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$prop_value = this.getProp_value();
            Object other$prop_value = other.getProp_value();
            if (this$prop_value == null ? other$prop_value == null : this$prop_value.equals(other$prop_value)) {
               Object this$prop_name = this.getProp_name();
               Object other$prop_name = other.getProp_name();
               return this$prop_name == null ? other$prop_name == null : this$prop_name.equals(other$prop_name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PropsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $prop_value = this.getProp_value();
      result = result * 59 + ($prop_value == null ? 43 : $prop_value.hashCode());
      Object $prop_name = this.getProp_name();
      return result * 59 + ($prop_name == null ? 43 : $prop_name.hashCode());
   }

   public static class PropsDTOBuilder {
      private String prop_value;
      private String prop_name;

      PropsDTOBuilder() {
      }

      public PropsDTO.PropsDTOBuilder prop_value(final String prop_value) {
         this.prop_value = prop_value;
         return this;
      }

      public PropsDTO.PropsDTOBuilder prop_name(final String prop_name) {
         this.prop_name = prop_name;
         return this;
      }

      public PropsDTO build() {
         return new PropsDTO(this.prop_value, this.prop_name);
      }

      @Override
      public String toString() {
         return "PropsDTO.PropsDTOBuilder(prop_value=" + this.prop_value + ", prop_name=" + this.prop_name + ")";
      }
   }
}
