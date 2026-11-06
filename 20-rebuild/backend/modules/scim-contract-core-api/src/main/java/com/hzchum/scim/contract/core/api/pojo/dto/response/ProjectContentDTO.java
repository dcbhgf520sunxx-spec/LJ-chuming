package com.hzchum.scim.contract.core.api.pojo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
public class ProjectContentDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "no", value = "编号")
   private Integer no;
   @ApiModelProperty(name = "categoryType", value = "分类:  结构 围护 配套件 箱体件")
   private Integer categoryType;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getNo() {
      return this.no;
   }

   public Integer getCategoryType() {
      return this.categoryType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setNo(final Integer no) {
      this.no = no;
   }

   public void setCategoryType(final Integer categoryType) {
      this.categoryType = categoryType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectContentDTO)) {
         return false;
      }

      ProjectContentDTO other = (ProjectContentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$no = this.getNo();
         Object other$no = other.getNo();
         if (this$no == null ? other$no == null : this$no.equals(other$no)) {
            Object this$categoryType = this.getCategoryType();
            Object other$categoryType = other.getCategoryType();
            if (this$categoryType == null ? other$categoryType == null : this$categoryType.equals(other$categoryType)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof ProjectContentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $no = this.getNo();
      result = result * 59 + ($no == null ? 43 : $no.hashCode());
      Object $categoryType = this.getCategoryType();
      result = result * 59 + ($categoryType == null ? 43 : $categoryType.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectContentDTO(id=" + this.getId() + ", name=" + this.getName() + ", no=" + this.getNo() + ", categoryType=" + this.getCategoryType() + ")";
   }
}
