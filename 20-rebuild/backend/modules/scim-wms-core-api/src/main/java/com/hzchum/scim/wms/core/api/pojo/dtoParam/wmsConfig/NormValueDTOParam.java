package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import java.math.BigDecimal;

public class NormValueDTOParam {
   private Long normId;
   private String name;
   private BigDecimal value;

   NormValueDTOParam(final Long normId, final String name, final BigDecimal value) {
      this.normId = normId;
      this.name = name;
      this.value = value;
   }

   public static NormValueDTOParam.NormValueDTOParamBuilder builder() {
      return new NormValueDTOParam.NormValueDTOParamBuilder();
   }

   public Long getNormId() {
      return this.normId;
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getValue() {
      return this.value;
   }

   public void setNormId(final Long normId) {
      this.normId = normId;
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

      if (!(o instanceof NormValueDTOParam)) {
         return false;
      }

      NormValueDTOParam other = (NormValueDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$normId = this.getNormId();
      Object other$normId = other.getNormId();
      if (this$normId == null ? other$normId == null : this$normId.equals(other$normId)) {
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
      return other instanceof NormValueDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $normId = this.getNormId();
      result = result * 59 + ($normId == null ? 43 : $normId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   @Override
   public String toString() {
      return "NormValueDTOParam(normId=" + this.getNormId() + ", name=" + this.getName() + ", value=" + this.getValue() + ")";
   }

   public static class NormValueDTOParamBuilder {
      private Long normId;
      private String name;
      private BigDecimal value;

      NormValueDTOParamBuilder() {
      }

      public NormValueDTOParam.NormValueDTOParamBuilder normId(final Long normId) {
         this.normId = normId;
         return this;
      }

      public NormValueDTOParam.NormValueDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public NormValueDTOParam.NormValueDTOParamBuilder value(final BigDecimal value) {
         this.value = value;
         return this;
      }

      public NormValueDTOParam build() {
         return new NormValueDTOParam(this.normId, this.name, this.value);
      }

      @Override
      public String toString() {
         return "NormValueDTOParam.NormValueDTOParamBuilder(normId=" + this.normId + ", name=" + this.name + ", value=" + this.value + ")";
      }
   }
}
