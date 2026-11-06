package com.hzchum.scim.contract.core.api.pojo.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectProductionMeteDTO", description = "项目分析")
public class ProjectProductionMeteDTO {
   @ApiModelProperty(name = "artifactMete", value = "构件产量")
   private BigDecimal artifactMete;
   @ApiModelProperty(name = "assembleMete", value = "部件产量")
   private BigDecimal assembleMete;
   @ApiModelProperty(name = "partMete", value = "零件产量")
   private BigDecimal partMete;
   @ApiModelProperty(name = "artifactDeepMete", value = "构件清单量")
   private BigDecimal artifactDeepMete;
   @ApiModelProperty(name = "assembleDeepMete", value = "部件清单量")
   private BigDecimal assembleDeepMete;
   @ApiModelProperty(name = "partDeepMete", value = "零件清单量")
   private BigDecimal partDeepMete;

   public static ProjectProductionMeteDTO.ProjectProductionMeteDTOBuilder builder() {
      return new ProjectProductionMeteDTO.ProjectProductionMeteDTOBuilder();
   }

   public BigDecimal getArtifactMete() {
      return this.artifactMete;
   }

   public BigDecimal getAssembleMete() {
      return this.assembleMete;
   }

   public BigDecimal getPartMete() {
      return this.partMete;
   }

   public BigDecimal getArtifactDeepMete() {
      return this.artifactDeepMete;
   }

   public BigDecimal getAssembleDeepMete() {
      return this.assembleDeepMete;
   }

   public BigDecimal getPartDeepMete() {
      return this.partDeepMete;
   }

   public void setArtifactMete(final BigDecimal artifactMete) {
      this.artifactMete = artifactMete;
   }

   public void setAssembleMete(final BigDecimal assembleMete) {
      this.assembleMete = assembleMete;
   }

   public void setPartMete(final BigDecimal partMete) {
      this.partMete = partMete;
   }

   public void setArtifactDeepMete(final BigDecimal artifactDeepMete) {
      this.artifactDeepMete = artifactDeepMete;
   }

   public void setAssembleDeepMete(final BigDecimal assembleDeepMete) {
      this.assembleDeepMete = assembleDeepMete;
   }

   public void setPartDeepMete(final BigDecimal partDeepMete) {
      this.partDeepMete = partDeepMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionMeteDTO)) {
         return false;
      }

      ProjectProductionMeteDTO other = (ProjectProductionMeteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactMete = this.getArtifactMete();
      Object other$artifactMete = other.getArtifactMete();
      if (this$artifactMete == null ? other$artifactMete == null : this$artifactMete.equals(other$artifactMete)) {
         Object this$assembleMete = this.getAssembleMete();
         Object other$assembleMete = other.getAssembleMete();
         if (this$assembleMete == null ? other$assembleMete == null : this$assembleMete.equals(other$assembleMete)) {
            Object this$partMete = this.getPartMete();
            Object other$partMete = other.getPartMete();
            if (this$partMete == null ? other$partMete == null : this$partMete.equals(other$partMete)) {
               Object this$artifactDeepMete = this.getArtifactDeepMete();
               Object other$artifactDeepMete = other.getArtifactDeepMete();
               if (this$artifactDeepMete == null ? other$artifactDeepMete == null : this$artifactDeepMete.equals(other$artifactDeepMete)) {
                  Object this$assembleDeepMete = this.getAssembleDeepMete();
                  Object other$assembleDeepMete = other.getAssembleDeepMete();
                  if (this$assembleDeepMete == null ? other$assembleDeepMete == null : this$assembleDeepMete.equals(other$assembleDeepMete)) {
                     Object this$partDeepMete = this.getPartDeepMete();
                     Object other$partDeepMete = other.getPartDeepMete();
                     return this$partDeepMete == null ? other$partDeepMete == null : this$partDeepMete.equals(other$partDeepMete);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectProductionMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactMete = this.getArtifactMete();
      result = result * 59 + ($artifactMete == null ? 43 : $artifactMete.hashCode());
      Object $assembleMete = this.getAssembleMete();
      result = result * 59 + ($assembleMete == null ? 43 : $assembleMete.hashCode());
      Object $partMete = this.getPartMete();
      result = result * 59 + ($partMete == null ? 43 : $partMete.hashCode());
      Object $artifactDeepMete = this.getArtifactDeepMete();
      result = result * 59 + ($artifactDeepMete == null ? 43 : $artifactDeepMete.hashCode());
      Object $assembleDeepMete = this.getAssembleDeepMete();
      result = result * 59 + ($assembleDeepMete == null ? 43 : $assembleDeepMete.hashCode());
      Object $partDeepMete = this.getPartDeepMete();
      return result * 59 + ($partDeepMete == null ? 43 : $partDeepMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductionMeteDTO(artifactMete="
         + this.getArtifactMete()
         + ", assembleMete="
         + this.getAssembleMete()
         + ", partMete="
         + this.getPartMete()
         + ", artifactDeepMete="
         + this.getArtifactDeepMete()
         + ", assembleDeepMete="
         + this.getAssembleDeepMete()
         + ", partDeepMete="
         + this.getPartDeepMete()
         + ")";
   }

   public ProjectProductionMeteDTO(
      final BigDecimal artifactMete,
      final BigDecimal assembleMete,
      final BigDecimal partMete,
      final BigDecimal artifactDeepMete,
      final BigDecimal assembleDeepMete,
      final BigDecimal partDeepMete
   ) {
      this.artifactMete = artifactMete;
      this.assembleMete = assembleMete;
      this.partMete = partMete;
      this.artifactDeepMete = artifactDeepMete;
      this.assembleDeepMete = assembleDeepMete;
      this.partDeepMete = partDeepMete;
   }

   public ProjectProductionMeteDTO() {
   }

   public static class ProjectProductionMeteDTOBuilder {
      private BigDecimal artifactMete;
      private BigDecimal assembleMete;
      private BigDecimal partMete;
      private BigDecimal artifactDeepMete;
      private BigDecimal assembleDeepMete;
      private BigDecimal partDeepMete;

      ProjectProductionMeteDTOBuilder() {
      }

      public ProjectProductionMeteDTO.ProjectProductionMeteDTOBuilder artifactMete(final BigDecimal artifactMete) {
         this.artifactMete = artifactMete;
         return this;
      }

      public ProjectProductionMeteDTO.ProjectProductionMeteDTOBuilder assembleMete(final BigDecimal assembleMete) {
         this.assembleMete = assembleMete;
         return this;
      }

      public ProjectProductionMeteDTO.ProjectProductionMeteDTOBuilder partMete(final BigDecimal partMete) {
         this.partMete = partMete;
         return this;
      }

      public ProjectProductionMeteDTO.ProjectProductionMeteDTOBuilder artifactDeepMete(final BigDecimal artifactDeepMete) {
         this.artifactDeepMete = artifactDeepMete;
         return this;
      }

      public ProjectProductionMeteDTO.ProjectProductionMeteDTOBuilder assembleDeepMete(final BigDecimal assembleDeepMete) {
         this.assembleDeepMete = assembleDeepMete;
         return this;
      }

      public ProjectProductionMeteDTO.ProjectProductionMeteDTOBuilder partDeepMete(final BigDecimal partDeepMete) {
         this.partDeepMete = partDeepMete;
         return this;
      }

      public ProjectProductionMeteDTO build() {
         return new ProjectProductionMeteDTO(
            this.artifactMete, this.assembleMete, this.partMete, this.artifactDeepMete, this.assembleDeepMete, this.partDeepMete
         );
      }

      @Override
      public String toString() {
         return "ProjectProductionMeteDTO.ProjectProductionMeteDTOBuilder(artifactMete="
            + this.artifactMete
            + ", assembleMete="
            + this.assembleMete
            + ", partMete="
            + this.partMete
            + ", artifactDeepMete="
            + this.artifactDeepMete
            + ", assembleDeepMete="
            + this.assembleDeepMete
            + ", partDeepMete="
            + this.partDeepMete
            + ")";
      }
   }
}
