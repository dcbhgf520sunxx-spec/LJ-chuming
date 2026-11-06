package com.hzchum.scim.contract.core.api.pojo.dtoParam.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("项目内容 修改类")
public class ProjectContentUpdateDTOParam {
   @NotNull(message = "项目内容id不为空")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "parentCategory", value = "分类:  结构 (传值:STRUCTURE)    围护 (传值:ENCLOSURE) ")
   private String parentCategory;
   @ApiModelProperty(name = "alias", value = "别名")
   private String alias;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getParentCategory() {
      return this.parentCategory;
   }

   public String getAlias() {
      return this.alias;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setParentCategory(final String parentCategory) {
      this.parentCategory = parentCategory;
   }

   public void setAlias(final String alias) {
      this.alias = alias;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectContentUpdateDTOParam)) {
         return false;
      }

      ProjectContentUpdateDTOParam other = (ProjectContentUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$parentCategory = this.getParentCategory();
            Object other$parentCategory = other.getParentCategory();
            if (this$parentCategory == null ? other$parentCategory == null : this$parentCategory.equals(other$parentCategory)) {
               Object this$alias = this.getAlias();
               Object other$alias = other.getAlias();
               return this$alias == null ? other$alias == null : this$alias.equals(other$alias);
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
      return other instanceof ProjectContentUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $parentCategory = this.getParentCategory();
      result = result * 59 + ($parentCategory == null ? 43 : $parentCategory.hashCode());
      Object $alias = this.getAlias();
      return result * 59 + ($alias == null ? 43 : $alias.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectContentUpdateDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", parentCategory="
         + this.getParentCategory()
         + ", alias="
         + this.getAlias()
         + ")";
   }
}
