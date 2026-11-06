package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WorkshopDO", description = "车间信息")
public class SimpleWorkShopDTO {
   @ApiModelProperty(name = "id", notes = "车间id", value = "车间id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "车间名", value = "车间名")
   private String name;

   public static SimpleWorkShopDTO.SimpleWorkShopDTOBuilder builder() {
      return new SimpleWorkShopDTO.SimpleWorkShopDTOBuilder();
   }

   public SimpleWorkShopDTO() {
   }

   public SimpleWorkShopDTO(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public SimpleWorkShopDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public SimpleWorkShopDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "SimpleWorkShopDTO(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SimpleWorkShopDTO)) {
         return false;
      } else {
         SimpleWorkShopDTO other = (SimpleWorkShopDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SimpleWorkShopDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class SimpleWorkShopDTOBuilder {
      private Long id;
      private String name;

      SimpleWorkShopDTOBuilder() {
      }

      public SimpleWorkShopDTO.SimpleWorkShopDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SimpleWorkShopDTO.SimpleWorkShopDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SimpleWorkShopDTO build() {
         return new SimpleWorkShopDTO(this.id, this.name);
      }

      @Override
      public String toString() {
         return "SimpleWorkShopDTO.SimpleWorkShopDTOBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
