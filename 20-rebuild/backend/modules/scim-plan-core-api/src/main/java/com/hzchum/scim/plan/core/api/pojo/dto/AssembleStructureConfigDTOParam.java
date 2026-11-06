package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("型材套料部件构件配置DTOParam")
public class AssembleStructureConfigDTOParam {
   @ApiModelProperty(name = "id", value = "构件配置表id")
   private Long id;
   @ApiModelProperty(name = "classificationName", value = "构件种类名称")
   private String classificationName;
   @ApiModelProperty(name = "definitionWord", value = "智能线定义代码")
   private String definitionWord;
   @ApiModelProperty(name = "assembleId", value = "部件表id")
   private Long assembleId;

   public static AssembleStructureConfigDTOParam.AssembleStructureConfigDTOParamBuilder builder() {
      return new AssembleStructureConfigDTOParam.AssembleStructureConfigDTOParamBuilder();
   }

   public AssembleStructureConfigDTOParam() {
   }

   public AssembleStructureConfigDTOParam(final Long id, final String classificationName, final String definitionWord, final Long assembleId) {
      this.id = id;
      this.classificationName = classificationName;
      this.definitionWord = definitionWord;
      this.assembleId = assembleId;
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

   public Long getAssembleId() {
      return this.assembleId;
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

   public void setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleStructureConfigDTOParam)) {
         return false;
      }

      AssembleStructureConfigDTOParam other = (AssembleStructureConfigDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assembleId = this.getAssembleId();
         Object other$assembleId = other.getAssembleId();
         if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssembleStructureConfigDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $definitionWord = this.getDefinitionWord();
      return result * 59 + ($definitionWord == null ? 43 : $definitionWord.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleStructureConfigDTOParam(id="
         + this.getId()
         + ", classificationName="
         + this.getClassificationName()
         + ", definitionWord="
         + this.getDefinitionWord()
         + ", assembleId="
         + this.getAssembleId()
         + ")";
   }

   public static class AssembleStructureConfigDTOParamBuilder {
      private Long id;
      private String classificationName;
      private String definitionWord;
      private Long assembleId;

      AssembleStructureConfigDTOParamBuilder() {
      }

      public AssembleStructureConfigDTOParam.AssembleStructureConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AssembleStructureConfigDTOParam.AssembleStructureConfigDTOParamBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      public AssembleStructureConfigDTOParam.AssembleStructureConfigDTOParamBuilder definitionWord(final String definitionWord) {
         this.definitionWord = definitionWord;
         return this;
      }

      public AssembleStructureConfigDTOParam.AssembleStructureConfigDTOParamBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      public AssembleStructureConfigDTOParam build() {
         return new AssembleStructureConfigDTOParam(this.id, this.classificationName, this.definitionWord, this.assembleId);
      }

      @Override
      public String toString() {
         return "AssembleStructureConfigDTOParam.AssembleStructureConfigDTOParamBuilder(id="
            + this.id
            + ", classificationName="
            + this.classificationName
            + ", definitionWord="
            + this.definitionWord
            + ", assembleId="
            + this.assembleId
            + ")";
      }
   }
}
