package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import java.io.Serializable;
import java.math.BigDecimal;

public class BasicConfigDTOParam implements Serializable {
   private Long id;
   private String name;
   private BigDecimal value;

   BasicConfigDTOParam(final Long id, final String name, final BigDecimal value) {
      this.id = id;
      this.name = name;
      this.value = value;
   }

   public static BasicConfigDTOParam.BasicConfigDTOParamBuilder builder() {
      return new BasicConfigDTOParam.BasicConfigDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getValue() {
      return this.value;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setValue(final BigDecimal value) {
      this.value = value;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BasicConfigDTOParam)) {
         return false;
      }

      BasicConfigDTOParam other = (BasicConfigDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
      return other instanceof BasicConfigDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   @Override
   public String toString() {
      return "BasicConfigDTOParam(id=" + this.getId() + ", name=" + this.getName() + ", value=" + this.getValue() + ")";
   }

   public static class BasicConfigDTOParamBuilder {
      private Long id;
      private String name;
      private BigDecimal value;

      BasicConfigDTOParamBuilder() {
      }

      public BasicConfigDTOParam.BasicConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BasicConfigDTOParam.BasicConfigDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BasicConfigDTOParam.BasicConfigDTOParamBuilder value(final BigDecimal value) {
         this.value = value;
         return this;
      }

      public BasicConfigDTOParam build() {
         return new BasicConfigDTOParam(this.id, this.name, this.value);
      }

      @Override
      public String toString() {
         return "BasicConfigDTOParam.BasicConfigDTOParamBuilder(id=" + this.id + ", name=" + this.name + ", value=" + this.value + ")";
      }
   }
}
