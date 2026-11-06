package com.hzchum.scim.scm.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("SubcontractClassConfig对象dto")
public class SubcontractClassConfigDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "分包类别名称", notes = "分包类别名称")
   private String name;

   public static SubcontractClassConfigDTO.SubcontractClassConfigDTOBuilder builder() {
      return new SubcontractClassConfigDTO.SubcontractClassConfigDTOBuilder();
   }

   public SubcontractClassConfigDTO() {
   }

   public SubcontractClassConfigDTO(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SubcontractClassConfigDTO)) {
         return false;
      } else {
         SubcontractClassConfigDTO other = (SubcontractClassConfigDTO)o;
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
      return other instanceof SubcontractClassConfigDTO;
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
      return "SubcontractClassConfigDTO(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   public static class SubcontractClassConfigDTOBuilder {
      private Long id;
      private String name;

      SubcontractClassConfigDTOBuilder() {
      }

      public SubcontractClassConfigDTO.SubcontractClassConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubcontractClassConfigDTO.SubcontractClassConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubcontractClassConfigDTO build() {
         return new SubcontractClassConfigDTO(this.id, this.name);
      }

      @Override
      public String toString() {
         return "SubcontractClassConfigDTO.SubcontractClassConfigDTOBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
