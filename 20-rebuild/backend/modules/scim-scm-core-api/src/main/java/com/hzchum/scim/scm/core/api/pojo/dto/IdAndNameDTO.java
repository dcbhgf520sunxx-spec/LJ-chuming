package com.hzchum.scim.scm.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IdAndNameDTO", description = "id和name通用类")
public class IdAndNameDTO {
   @ApiModelProperty(name = "id", notes = "项目id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "项目名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;

   public static IdAndNameDTO.IdAndNameDTOBuilder builder() {
      return new IdAndNameDTO.IdAndNameDTOBuilder();
   }

   public IdAndNameDTO() {
   }

   public IdAndNameDTO(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   @JsonProperty("id")
   public IdAndNameDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public IdAndNameDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "IdAndNameDTO(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof IdAndNameDTO)) {
         return false;
      } else {
         IdAndNameDTO other = (IdAndNameDTO)o;
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
      return other instanceof IdAndNameDTO;
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

   public static class IdAndNameDTOBuilder {
      private Long id;
      private String name;

      IdAndNameDTOBuilder() {
      }

      @JsonProperty("id")
      public IdAndNameDTO.IdAndNameDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public IdAndNameDTO.IdAndNameDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public IdAndNameDTO build() {
         return new IdAndNameDTO(this.id, this.name);
      }

      @Override
      public String toString() {
         return "IdAndNameDTO.IdAndNameDTOBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
