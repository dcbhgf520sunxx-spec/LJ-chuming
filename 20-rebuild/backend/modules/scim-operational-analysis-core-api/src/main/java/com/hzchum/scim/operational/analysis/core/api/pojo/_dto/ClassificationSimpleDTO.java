package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("辅材一级科目")
public class ClassificationSimpleDTO {
   @ApiModelProperty(name = "classifyId", value = "主键ID", notes = "主键ID")
   private Long classifyId;
   @ApiModelProperty(name = "name", value = "科目名称", notes = "科目名称")
   private String name;

   public static ClassificationSimpleDTO.ClassificationSimpleDTOBuilder builder() {
      return new ClassificationSimpleDTO.ClassificationSimpleDTOBuilder();
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getName() {
      return this.name;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ClassificationSimpleDTO)) {
         return false;
      } else {
         ClassificationSimpleDTO other = (ClassificationSimpleDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
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
      return other instanceof ClassificationSimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "ClassificationSimpleDTO(classifyId=" + this.getClassifyId() + ", name=" + this.getName() + ")";
   }

   public ClassificationSimpleDTO(final Long classifyId, final String name) {
      this.classifyId = classifyId;
      this.name = name;
   }

   public ClassificationSimpleDTO() {
   }

   public static class ClassificationSimpleDTOBuilder {
      private Long classifyId;
      private String name;

      ClassificationSimpleDTOBuilder() {
      }

      public ClassificationSimpleDTO.ClassificationSimpleDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ClassificationSimpleDTO.ClassificationSimpleDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ClassificationSimpleDTO build() {
         return new ClassificationSimpleDTO(this.classifyId, this.name);
      }

      @Override
      public String toString() {
         return "ClassificationSimpleDTO.ClassificationSimpleDTOBuilder(classifyId=" + this.classifyId + ", name=" + this.name + ")";
      }
   }
}
