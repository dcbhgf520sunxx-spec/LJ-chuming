package com.hzchum.scim.common.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AreaTreeDTO", description = "区域树形结构展示信息")
public class AreaTreeDTO {
   @ApiModelProperty(name = "id", notes = "区域id", value = "区域id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "区域名", value = "区域id")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;

   public static AreaTreeDTO.AreaTreeDTOBuilder builder() {
      return new AreaTreeDTO.AreaTreeDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AreaTreeDTO)) {
         return false;
      } else {
         AreaTreeDTO other = (AreaTreeDTO)o;
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
      return other instanceof AreaTreeDTO;
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

   @Override
   public String toString() {
      return "AreaTreeDTO(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   public AreaTreeDTO() {
   }

   public AreaTreeDTO(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public static class AreaTreeDTOBuilder {
      private Long id;
      private String name;

      AreaTreeDTOBuilder() {
      }

      @JsonProperty("id")
      public AreaTreeDTO.AreaTreeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public AreaTreeDTO.AreaTreeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public AreaTreeDTO build() {
         return new AreaTreeDTO(this.id, this.name);
      }

      @Override
      public String toString() {
         return "AreaTreeDTO.AreaTreeDTOBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
