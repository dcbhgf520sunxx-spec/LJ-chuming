package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("型材套料部件构件配置DTO")
public class AssembleStructureNameDTO {
   @ApiModelProperty(name = "id", value = "构件配置表id")
   private Long id;
   @ApiModelProperty(name = "classificationName", value = "构件种类名称")
   private String classificationName;
   @ApiModelProperty(name = "definitionWord", value = "智能线定义代码")
   private String definitionWord;

   public static AssembleStructureNameDTO.AssembleStructureNameDTOBuilder builder() {
      return new AssembleStructureNameDTO.AssembleStructureNameDTOBuilder();
   }

   public AssembleStructureNameDTO() {
   }

   public AssembleStructureNameDTO(final Long id, final String classificationName, final String definitionWord) {
      this.id = id;
      this.classificationName = classificationName;
      this.definitionWord = definitionWord;
   }

   public Long getId() {
      return this.id;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public String getDefinitionWord() {
      return this.definitionWord;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
   }

   public void setDefinitionWord(final String definitionWord) {
      this.definitionWord = definitionWord;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleStructureNameDTO)) {
         return false;
      }

      AssembleStructureNameDTO other = (AssembleStructureNameDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classificationName = this.getClassificationName();
         Object other$classificationName = other.getClassificationName();
         if (this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName)) {
            Object this$definitionWord = this.getDefinitionWord();
            Object other$definitionWord = other.getDefinitionWord();
            return this$definitionWord == null ? other$definitionWord == null : this$definitionWord.equals(other$definitionWord);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssembleStructureNameDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $definitionWord = this.getDefinitionWord();
      return result * 59 + ($definitionWord == null ? 43 : $definitionWord.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleStructureNameDTO(id="
         + this.getId()
         + ", classificationName="
         + this.getClassificationName()
         + ", definitionWord="
         + this.getDefinitionWord()
         + ")";
   }

   public static class AssembleStructureNameDTOBuilder {
      private Long id;
      private String classificationName;
      private String definitionWord;

      AssembleStructureNameDTOBuilder() {
      }

      public AssembleStructureNameDTO.AssembleStructureNameDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AssembleStructureNameDTO.AssembleStructureNameDTOBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      public AssembleStructureNameDTO.AssembleStructureNameDTOBuilder definitionWord(final String definitionWord) {
         this.definitionWord = definitionWord;
         return this;
      }

      public AssembleStructureNameDTO build() {
         return new AssembleStructureNameDTO(this.id, this.classificationName, this.definitionWord);
      }

      @Override
      public String toString() {
         return "AssembleStructureNameDTO.AssembleStructureNameDTOBuilder(id="
            + this.id
            + ", classificationName="
            + this.classificationName
            + ", definitionWord="
            + this.definitionWord
            + ")";
      }
   }
}
