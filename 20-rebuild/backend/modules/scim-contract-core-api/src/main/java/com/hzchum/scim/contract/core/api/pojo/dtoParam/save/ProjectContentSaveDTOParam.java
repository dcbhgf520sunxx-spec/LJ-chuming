package com.hzchum.scim.contract.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("新增项目内容 请求类")
public class ProjectContentSaveDTOParam {
   @NotBlank(message = "项目内容名称不能为空")
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "parentCategory", value = "分类:  结构 (STRUCTURE)    围护 (ENCLOSURE) ")
   private String parentCategory;
   @NotNull(message = "业务类型不能为空")
   @Min(1L)
   @Max(2L)
   @ApiModelProperty(name = "businessType", value = "业务类型 1加工承揽 2项目承包")
   private Integer businessType;
   @ApiModelProperty(name = "alias", value = "别名")
   private String alias;

   public String getName() {
      return this.name;
   }

   public String getParentCategory() {
      return this.parentCategory;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public String getAlias() {
      return this.alias;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setParentCategory(final String parentCategory) {
      this.parentCategory = parentCategory;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setAlias(final String alias) {
      this.alias = alias;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectContentSaveDTOParam)) {
         return false;
      }

      ProjectContentSaveDTOParam other = (ProjectContentSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$businessType = this.getBusinessType();
      Object other$businessType = other.getBusinessType();
      if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
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
      return other instanceof ProjectContentSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $parentCategory = this.getParentCategory();
      result = result * 59 + ($parentCategory == null ? 43 : $parentCategory.hashCode());
      Object $alias = this.getAlias();
      return result * 59 + ($alias == null ? 43 : $alias.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectContentSaveDTOParam(name="
         + this.getName()
         + ", parentCategory="
         + this.getParentCategory()
         + ", businessType="
         + this.getBusinessType()
         + ", alias="
         + this.getAlias()
         + ")";
   }
}
