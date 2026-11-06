package com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis.ArtifactGroupAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis.EnclosureGroupAnalysisDO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class ProductGroupAnalysisDTO {
   @ApiModelProperty(name = "artifactAnalysisDTOList", value = "构件")
   @JsonInclude(Include.NON_NULL)
   private List<ArtifactGroupAnalysisDO> artifactAnalysisList;
   @ApiModelProperty(name = "enclosureAnalysisList", value = "围护")
   @JsonInclude(Include.NON_NULL)
   private List<EnclosureGroupAnalysisDO> enclosureAnalysisList;

   ProductGroupAnalysisDTO(final List<ArtifactGroupAnalysisDO> artifactAnalysisList, final List<EnclosureGroupAnalysisDO> enclosureAnalysisList) {
      this.artifactAnalysisList = artifactAnalysisList;
      this.enclosureAnalysisList = enclosureAnalysisList;
   }

   public static ProductGroupAnalysisDTO.ProductGroupAnalysisDTOBuilder builder() {
      return new ProductGroupAnalysisDTO.ProductGroupAnalysisDTOBuilder();
   }

   public List<ArtifactGroupAnalysisDO> getArtifactAnalysisList() {
      return this.artifactAnalysisList;
   }

   public List<EnclosureGroupAnalysisDO> getEnclosureAnalysisList() {
      return this.enclosureAnalysisList;
   }

   public void setArtifactAnalysisList(final List<ArtifactGroupAnalysisDO> artifactAnalysisList) {
      this.artifactAnalysisList = artifactAnalysisList;
   }

   public void setEnclosureAnalysisList(final List<EnclosureGroupAnalysisDO> enclosureAnalysisList) {
      this.enclosureAnalysisList = enclosureAnalysisList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductGroupAnalysisDTO)) {
         return false;
      } else {
         ProductGroupAnalysisDTO other = (ProductGroupAnalysisDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$artifactAnalysisList = this.getArtifactAnalysisList();
            Object other$artifactAnalysisList = other.getArtifactAnalysisList();
            if (this$artifactAnalysisList == null ? other$artifactAnalysisList == null : this$artifactAnalysisList.equals(other$artifactAnalysisList)) {
               Object this$enclosureAnalysisList = this.getEnclosureAnalysisList();
               Object other$enclosureAnalysisList = other.getEnclosureAnalysisList();
               return this$enclosureAnalysisList == null ? other$enclosureAnalysisList == null : this$enclosureAnalysisList.equals(other$enclosureAnalysisList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductGroupAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactAnalysisList = this.getArtifactAnalysisList();
      result = result * 59 + ($artifactAnalysisList == null ? 43 : $artifactAnalysisList.hashCode());
      Object $enclosureAnalysisList = this.getEnclosureAnalysisList();
      return result * 59 + ($enclosureAnalysisList == null ? 43 : $enclosureAnalysisList.hashCode());
   }

   @Override
   public String toString() {
      return "ProductGroupAnalysisDTO(artifactAnalysisList="
         + this.getArtifactAnalysisList()
         + ", enclosureAnalysisList="
         + this.getEnclosureAnalysisList()
         + ")";
   }

   public static class ProductGroupAnalysisDTOBuilder {
      private List<ArtifactGroupAnalysisDO> artifactAnalysisList;
      private List<EnclosureGroupAnalysisDO> enclosureAnalysisList;

      ProductGroupAnalysisDTOBuilder() {
      }

      public ProductGroupAnalysisDTO.ProductGroupAnalysisDTOBuilder artifactAnalysisList(final List<ArtifactGroupAnalysisDO> artifactAnalysisList) {
         this.artifactAnalysisList = artifactAnalysisList;
         return this;
      }

      public ProductGroupAnalysisDTO.ProductGroupAnalysisDTOBuilder enclosureAnalysisList(final List<EnclosureGroupAnalysisDO> enclosureAnalysisList) {
         this.enclosureAnalysisList = enclosureAnalysisList;
         return this;
      }

      public ProductGroupAnalysisDTO build() {
         return new ProductGroupAnalysisDTO(this.artifactAnalysisList, this.enclosureAnalysisList);
      }

      @Override
      public String toString() {
         return "ProductGroupAnalysisDTO.ProductGroupAnalysisDTOBuilder(artifactAnalysisList="
            + this.artifactAnalysisList
            + ", enclosureAnalysisList="
            + this.enclosureAnalysisList
            + ")";
      }
   }
}
