package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("套料构件信息")
public class ArtifactTypesettingDTO {
   @ApiModelProperty(name = "id", value = "构件id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty("构件数量")
   private Integer artifactQuantity;
   @ApiModelProperty(name = "structureClassId", value = "构件种类id")
   private Long structureClassId;
   @ApiModelProperty(name = "classificationName", value = "构件类型名称")
   private String classificationName;

   public static ArtifactTypesettingDTO.ArtifactTypesettingDTOBuilder builder() {
      return new ArtifactTypesettingDTO.ArtifactTypesettingDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getArtifactQuantity() {
      return this.artifactQuantity;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setArtifactQuantity(final Integer artifactQuantity) {
      this.artifactQuantity = artifactQuantity;
   }

   public void setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
   }

   public void setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactTypesettingDTO)) {
         return false;
      }

      ArtifactTypesettingDTO other = (ArtifactTypesettingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactQuantity = this.getArtifactQuantity();
         Object other$artifactQuantity = other.getArtifactQuantity();
         if (this$artifactQuantity == null ? other$artifactQuantity == null : this$artifactQuantity.equals(other$artifactQuantity)) {
            Object this$structureClassId = this.getStructureClassId();
            Object other$structureClassId = other.getStructureClassId();
            if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactTypesettingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactQuantity = this.getArtifactQuantity();
      result = result * 59 + ($artifactQuantity == null ? 43 : $artifactQuantity.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $classificationName = this.getClassificationName();
      return result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactTypesettingDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", artifactQuantity="
         + this.getArtifactQuantity()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", classificationName="
         + this.getClassificationName()
         + ")";
   }

   public ArtifactTypesettingDTO(
      final Long id, final String serialNumber, final Integer artifactQuantity, final Long structureClassId, final String classificationName
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.artifactQuantity = artifactQuantity;
      this.structureClassId = structureClassId;
      this.classificationName = classificationName;
   }

   public ArtifactTypesettingDTO() {
   }

   public static class ArtifactTypesettingDTOBuilder {
      private Long id;
      private String serialNumber;
      private Integer artifactQuantity;
      private Long structureClassId;
      private String classificationName;

      ArtifactTypesettingDTOBuilder() {
      }

      public ArtifactTypesettingDTO.ArtifactTypesettingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ArtifactTypesettingDTO.ArtifactTypesettingDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ArtifactTypesettingDTO.ArtifactTypesettingDTOBuilder artifactQuantity(final Integer artifactQuantity) {
         this.artifactQuantity = artifactQuantity;
         return this;
      }

      public ArtifactTypesettingDTO.ArtifactTypesettingDTOBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public ArtifactTypesettingDTO.ArtifactTypesettingDTOBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      public ArtifactTypesettingDTO build() {
         return new ArtifactTypesettingDTO(this.id, this.serialNumber, this.artifactQuantity, this.structureClassId, this.classificationName);
      }

      @Override
      public String toString() {
         return "ArtifactTypesettingDTO.ArtifactTypesettingDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", artifactQuantity="
            + this.artifactQuantity
            + ", structureClassId="
            + this.structureClassId
            + ", classificationName="
            + this.classificationName
            + ")";
      }
   }
}
