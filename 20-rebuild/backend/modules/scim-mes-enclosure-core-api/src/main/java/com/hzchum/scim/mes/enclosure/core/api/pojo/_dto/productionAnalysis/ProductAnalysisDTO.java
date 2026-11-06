package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.productionAnalysis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.productionAnalysis.ArtifactAnalysisDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.productionAnalysis.EnclosureAnalysisDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProductAnalysisDTO", description = "项目看板")
public class ProductAnalysisDTO {
   @ApiModelProperty(name = "artifactAnalysis", value = "构件")
   @JsonInclude(Include.NON_NULL)
   private ArtifactAnalysisDO artifactAnalysis;
   @ApiModelProperty(name = "enclosureAnalysis", value = "围护")
   @JsonInclude(Include.NON_NULL)
   private EnclosureAnalysisDO enclosureAnalysis;

   public static ProductAnalysisDTO.ProductAnalysisDTOBuilder builder() {
      return new ProductAnalysisDTO.ProductAnalysisDTOBuilder();
   }

   public ProductAnalysisDTO(final ArtifactAnalysisDO artifactAnalysis, final EnclosureAnalysisDO enclosureAnalysis) {
      this.artifactAnalysis = artifactAnalysis;
      this.enclosureAnalysis = enclosureAnalysis;
   }

   public ProductAnalysisDTO() {
   }

   public ArtifactAnalysisDO getArtifactAnalysis() {
      return this.artifactAnalysis;
   }

   public EnclosureAnalysisDO getEnclosureAnalysis() {
      return this.enclosureAnalysis;
   }

   public ProductAnalysisDTO setArtifactAnalysis(final ArtifactAnalysisDO artifactAnalysis) {
      this.artifactAnalysis = artifactAnalysis;
      return this;
   }

   public ProductAnalysisDTO setEnclosureAnalysis(final EnclosureAnalysisDO enclosureAnalysis) {
      this.enclosureAnalysis = enclosureAnalysis;
      return this;
   }

   @Override
   public String toString() {
      return "ProductAnalysisDTO(artifactAnalysis=" + this.getArtifactAnalysis() + ", enclosureAnalysis=" + this.getEnclosureAnalysis() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductAnalysisDTO)) {
         return false;
      } else {
         ProductAnalysisDTO other = (ProductAnalysisDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$artifactAnalysis = this.getArtifactAnalysis();
            Object other$artifactAnalysis = other.getArtifactAnalysis();
            if (this$artifactAnalysis == null ? other$artifactAnalysis == null : this$artifactAnalysis.equals(other$artifactAnalysis)) {
               Object this$enclosureAnalysis = this.getEnclosureAnalysis();
               Object other$enclosureAnalysis = other.getEnclosureAnalysis();
               return this$enclosureAnalysis == null ? other$enclosureAnalysis == null : this$enclosureAnalysis.equals(other$enclosureAnalysis);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactAnalysis = this.getArtifactAnalysis();
      result = result * 59 + ($artifactAnalysis == null ? 43 : $artifactAnalysis.hashCode());
      Object $enclosureAnalysis = this.getEnclosureAnalysis();
      return result * 59 + ($enclosureAnalysis == null ? 43 : $enclosureAnalysis.hashCode());
   }

   public static class ProductAnalysisDTOBuilder {
      private ArtifactAnalysisDO artifactAnalysis;
      private EnclosureAnalysisDO enclosureAnalysis;

      ProductAnalysisDTOBuilder() {
      }

      public ProductAnalysisDTO.ProductAnalysisDTOBuilder artifactAnalysis(final ArtifactAnalysisDO artifactAnalysis) {
         this.artifactAnalysis = artifactAnalysis;
         return this;
      }

      public ProductAnalysisDTO.ProductAnalysisDTOBuilder enclosureAnalysis(final EnclosureAnalysisDO enclosureAnalysis) {
         this.enclosureAnalysis = enclosureAnalysis;
         return this;
      }

      public ProductAnalysisDTO build() {
         return new ProductAnalysisDTO(this.artifactAnalysis, this.enclosureAnalysis);
      }

      @Override
      public String toString() {
         return "ProductAnalysisDTO.ProductAnalysisDTOBuilder(artifactAnalysis="
            + this.artifactAnalysis
            + ", enclosureAnalysis="
            + this.enclosureAnalysis
            + ")";
      }
   }
}
