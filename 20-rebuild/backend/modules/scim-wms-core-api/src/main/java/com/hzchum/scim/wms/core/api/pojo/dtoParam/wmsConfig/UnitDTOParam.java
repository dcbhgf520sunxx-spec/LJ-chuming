package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

public class UnitDTOParam {
   private String name;
   private String symbol;
   private Integer type;

   public static UnitDTOParam.UnitDTOParamBuilder builder() {
      return new UnitDTOParam.UnitDTOParamBuilder();
   }

   public String getName() {
      return this.name;
   }

   public String getSymbol() {
      return this.symbol;
   }

   public Integer getType() {
      return this.type;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSymbol(final String symbol) {
      this.symbol = symbol;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UnitDTOParam)) {
         return false;
      }

      UnitDTOParam other = (UnitDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$symbol = this.getSymbol();
            Object other$symbol = other.getSymbol();
            return this$symbol == null ? other$symbol == null : this$symbol.equals(other$symbol);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UnitDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $symbol = this.getSymbol();
      return result * 59 + ($symbol == null ? 43 : $symbol.hashCode());
   }

   @Override
   public String toString() {
      return "UnitDTOParam(name=" + this.getName() + ", symbol=" + this.getSymbol() + ", type=" + this.getType() + ")";
   }

   public UnitDTOParam(final String name, final String symbol, final Integer type) {
      this.name = name;
      this.symbol = symbol;
      this.type = type;
   }

   public UnitDTOParam() {
   }

   public static class UnitDTOParamBuilder {
      private String name;
      private String symbol;
      private Integer type;

      UnitDTOParamBuilder() {
      }

      public UnitDTOParam.UnitDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public UnitDTOParam.UnitDTOParamBuilder symbol(final String symbol) {
         this.symbol = symbol;
         return this;
      }

      public UnitDTOParam.UnitDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public UnitDTOParam build() {
         return new UnitDTOParam(this.name, this.symbol, this.type);
      }

      @Override
      public String toString() {
         return "UnitDTOParam.UnitDTOParamBuilder(name=" + this.name + ", symbol=" + this.symbol + ", type=" + this.type + ")";
      }
   }
}
