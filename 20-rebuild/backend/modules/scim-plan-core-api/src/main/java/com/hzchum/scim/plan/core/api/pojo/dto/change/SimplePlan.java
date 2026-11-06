package com.hzchum.scim.plan.core.api.pojo.dto.change;

import io.swagger.annotations.ApiModelProperty;

public class SimplePlan {
   @ApiModelProperty(name = "id", value = "区域编号", notes = "区域编号")
   private Long id;
   @ApiModelProperty(name = "name", value = "批次名称", notes = "批次名称")
   private String name;
   @ApiModelProperty(name = "category", notes = "围护产品类型")
   private Integer category;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getCategory() {
      return this.category;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SimplePlan)) {
         return false;
      }

      SimplePlan other = (SimplePlan)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SimplePlan;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "SimplePlan(id=" + this.getId() + ", name=" + this.getName() + ", category=" + this.getCategory() + ")";
   }
}
