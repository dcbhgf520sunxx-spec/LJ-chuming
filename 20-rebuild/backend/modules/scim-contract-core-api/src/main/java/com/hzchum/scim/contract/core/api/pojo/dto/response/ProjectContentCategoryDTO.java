package com.hzchum.scim.contract.core.api.pojo.dto.response;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class ProjectContentCategoryDTO {
   @ApiModelProperty(name = "categoryType", value = "分类: 1结构 2围护 4配套件 8箱体件")
   private Integer categoryType;
   @ApiModelProperty(name = "categoryName", value = "分类名称")
   private String categoryName;
   @ApiModelProperty(name = "children", value = "项目内容列表")
   private List<ProjectContentDTO> children;

   public Integer getCategoryType() {
      return this.categoryType;
   }

   public String getCategoryName() {
      return this.categoryName;
   }

   public List<ProjectContentDTO> getChildren() {
      return this.children;
   }

   public void setCategoryType(final Integer categoryType) {
      this.categoryType = categoryType;
   }

   public void setCategoryName(final String categoryName) {
      this.categoryName = categoryName;
   }

   public void setChildren(final List<ProjectContentDTO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectContentCategoryDTO)) {
         return false;
      }

      ProjectContentCategoryDTO other = (ProjectContentCategoryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$categoryType = this.getCategoryType();
      Object other$categoryType = other.getCategoryType();
      if (this$categoryType == null ? other$categoryType == null : this$categoryType.equals(other$categoryType)) {
         Object this$categoryName = this.getCategoryName();
         Object other$categoryName = other.getCategoryName();
         if (this$categoryName == null ? other$categoryName == null : this$categoryName.equals(other$categoryName)) {
            Object this$children = this.getChildren();
            Object other$children = other.getChildren();
            return this$children == null ? other$children == null : this$children.equals(other$children);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectContentCategoryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $categoryType = this.getCategoryType();
      result = result * 59 + ($categoryType == null ? 43 : $categoryType.hashCode());
      Object $categoryName = this.getCategoryName();
      result = result * 59 + ($categoryName == null ? 43 : $categoryName.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectContentCategoryDTO(categoryType="
         + this.getCategoryType()
         + ", categoryName="
         + this.getCategoryName()
         + ", children="
         + this.getChildren()
         + ")";
   }
}
