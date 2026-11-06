package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import io.swagger.annotations.ApiModelProperty;

public class ClassificationBaseDTO {
   private Long id;
   @ApiModelProperty("种类名称")
   private String classificationName;
   @ApiModelProperty("构件分类 1主构件 2次构件")
   private Integer artifactType;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   private Integer mesProductEnum;

   public static ClassificationBaseDTO.ClassificationBaseDTOBuilder builder() {
      return new ClassificationBaseDTO.ClassificationBaseDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
   }

   public void setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
   }

   public void setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ClassificationBaseDTO)) {
         return false;
      }

      ClassificationBaseDTO other = (ClassificationBaseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactType = this.getArtifactType();
         Object other$artifactType = other.getArtifactType();
         if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
            Object this$mesProductEnum = this.getMesProductEnum();
            Object other$mesProductEnum = other.getMesProductEnum();
            if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
               Object this$classificationName = this.getClassificationName();
               Object other$classificationName = other.getClassificationName();
               return this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName);
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
      return other instanceof ClassificationBaseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $classificationName = this.getClassificationName();
      return result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
   }

   @Override
   public String toString() {
      return "ClassificationBaseDTO(id="
         + this.getId()
         + ", classificationName="
         + this.getClassificationName()
         + ", artifactType="
         + this.getArtifactType()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   public ClassificationBaseDTO(final Long id, final String classificationName, final Integer artifactType, final Integer mesProductEnum) {
      this.id = id;
      this.classificationName = classificationName;
      this.artifactType = artifactType;
      this.mesProductEnum = mesProductEnum;
   }

   public ClassificationBaseDTO() {
   }

   public static class ClassificationBaseDTOBuilder {
      private Long id;
      private String classificationName;
      private Integer artifactType;
      private Integer mesProductEnum;

      ClassificationBaseDTOBuilder() {
      }

      public ClassificationBaseDTO.ClassificationBaseDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ClassificationBaseDTO.ClassificationBaseDTOBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      public ClassificationBaseDTO.ClassificationBaseDTOBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public ClassificationBaseDTO.ClassificationBaseDTOBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public ClassificationBaseDTO build() {
         return new ClassificationBaseDTO(this.id, this.classificationName, this.artifactType, this.mesProductEnum);
      }

      @Override
      public String toString() {
         return "ClassificationBaseDTO.ClassificationBaseDTOBuilder(id="
            + this.id
            + ", classificationName="
            + this.classificationName
            + ", artifactType="
            + this.artifactType
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
