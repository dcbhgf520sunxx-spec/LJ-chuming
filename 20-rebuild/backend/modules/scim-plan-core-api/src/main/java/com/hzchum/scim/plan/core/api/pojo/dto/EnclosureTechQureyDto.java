package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("围护批次计划 查询条件类")
public class EnclosureTechQureyDto {
   @NotNull(message = "围护批次分类不能为空")
   @ApiModelProperty(name = "category", value = "批次类型")
   private Integer category;
   @NotNull(message = "项目ID不能为空")
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;

   public Integer getCategory() {
      return this.category;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof EnclosureTechQureyDto)) {
         return false;
      } else {
         EnclosureTechQureyDto other = (EnclosureTechQureyDto)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               return this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureTechQureyDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $projectId = this.getProjectId();
      return result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureTechQureyDto(category=" + this.getCategory() + ", projectId=" + this.getProjectId() + ")";
   }
}
