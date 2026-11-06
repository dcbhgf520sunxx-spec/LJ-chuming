package com.hzchum.scim.rest.pojo.vo.wms.wmsConfig;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UnitVORequest {
   @NotBlank(message = "单位名称不能为空")
   private String name;
   private String symbol;
   @NotNull(message = "单位类型不能为空")
   private Integer type;

   UnitVORequest(final String name, final String symbol, final Integer type) {
      this.name = name;
      this.symbol = symbol;
      this.type = type;
   }

   public static UnitVORequest.UnitVORequestBuilder builder() {
      return new UnitVORequest.UnitVORequestBuilder();
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

      if (!(o instanceof UnitVORequest)) {
         return false;
      }

      UnitVORequest other = (UnitVORequest)o;
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
      return other instanceof UnitVORequest;
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
      return "UnitVORequest(name=" + this.getName() + ", symbol=" + this.getSymbol() + ", type=" + this.getType() + ")";
   }

   public static class UnitVORequestBuilder {
      private String name;
      private String symbol;
      private Integer type;

      UnitVORequestBuilder() {
      }

      public UnitVORequest.UnitVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public UnitVORequest.UnitVORequestBuilder symbol(final String symbol) {
         this.symbol = symbol;
         return this;
      }

      public UnitVORequest.UnitVORequestBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public UnitVORequest build() {
         return new UnitVORequest(this.name, this.symbol, this.type);
      }

      @Override
      public String toString() {
         return "UnitVORequest.UnitVORequestBuilder(name=" + this.name + ", symbol=" + this.symbol + ", type=" + this.type + ")";
      }
   }
}
