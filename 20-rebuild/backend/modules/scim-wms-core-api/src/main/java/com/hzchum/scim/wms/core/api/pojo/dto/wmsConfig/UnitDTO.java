package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import java.io.Serializable;

public class UnitDTO implements Serializable {
   private static final long serialVersionUID = 8615143744778361364L;
   private Long id;
   private String name;
   private String symbol;
   private String type;
   private Integer status;

   UnitDTO(final Long id, final String name, final String symbol, final String type, final Integer status) {
      this.id = id;
      this.name = name;
      this.symbol = symbol;
      this.type = type;
      this.status = status;
   }

   public static UnitDTO.UnitDTOBuilder builder() {
      return new UnitDTO.UnitDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSymbol() {
      return this.symbol;
   }

   public String getType() {
      return this.type;
   }

   public Integer getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSymbol(final String symbol) {
      this.symbol = symbol;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UnitDTO)) {
         return false;
      }

      UnitDTO other = (UnitDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$symbol = this.getSymbol();
               Object other$symbol = other.getSymbol();
               if (this$symbol == null ? other$symbol == null : this$symbol.equals(other$symbol)) {
                  Object this$type = this.getType();
                  Object other$type = other.getType();
                  return this$type == null ? other$type == null : this$type.equals(other$type);
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UnitDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $symbol = this.getSymbol();
      result = result * 59 + ($symbol == null ? 43 : $symbol.hashCode());
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "UnitDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", symbol="
         + this.getSymbol()
         + ", type="
         + this.getType()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class UnitDTOBuilder {
      private Long id;
      private String name;
      private String symbol;
      private String type;
      private Integer status;

      UnitDTOBuilder() {
      }

      public UnitDTO.UnitDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public UnitDTO.UnitDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public UnitDTO.UnitDTOBuilder symbol(final String symbol) {
         this.symbol = symbol;
         return this;
      }

      public UnitDTO.UnitDTOBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public UnitDTO.UnitDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public UnitDTO build() {
         return new UnitDTO(this.id, this.name, this.symbol, this.type, this.status);
      }

      @Override
      public String toString() {
         return "UnitDTO.UnitDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", symbol="
            + this.symbol
            + ", type="
            + this.type
            + ", status="
            + this.status
            + ")";
      }
   }
}
