package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

@ApiModel("SubcontractClassConfig对象dtoParam")
public class SubcontractClassConfigDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "分包类别名称", notes = "分包类别名称")
   @NotBlank(message = "分包类别名称不能为空")
   private String name;

   public static SubcontractClassConfigDTOParam.SubcontractClassConfigDTOParamBuilder builder() {
      return new SubcontractClassConfigDTOParam.SubcontractClassConfigDTOParamBuilder();
   }

   public SubcontractClassConfigDTOParam() {
   }

   public SubcontractClassConfigDTOParam(final Long id, final String name) {
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
      } else if (!(o instanceof SubcontractClassConfigDTOParam)) {
         return false;
      } else {
         SubcontractClassConfigDTOParam other = (SubcontractClassConfigDTOParam)o;
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
      return other instanceof SubcontractClassConfigDTOParam;
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
      return "SubcontractClassConfigDTOParam(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   public static class SubcontractClassConfigDTOParamBuilder {
      private Long id;
      private String name;

      SubcontractClassConfigDTOParamBuilder() {
      }

      public SubcontractClassConfigDTOParam.SubcontractClassConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubcontractClassConfigDTOParam.SubcontractClassConfigDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubcontractClassConfigDTOParam build() {
         return new SubcontractClassConfigDTOParam(this.id, this.name);
      }

      @Override
      public String toString() {
         return "SubcontractClassConfigDTOParam.SubcontractClassConfigDTOParamBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
