package com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis.ArtifactDetailsAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis.EnclosureDetailsAnalysisDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProductAnalysisDTO", description = "项目看板")
public class ProductDetailsAnalysisDTO {
   @ApiModelProperty(name = "artifactDetailsAnalysisDTOList", value = "构件")
   @JsonInclude(Include.NON_NULL)
   private List<ArtifactDetailsAnalysisDO> artifactDetailsAnalysisDTOList;
   @ApiModelProperty(name = "enclosureDetailsAnalysisList", value = "围护")
   @JsonInclude(Include.NON_NULL)
   private List<EnclosureDetailsAnalysisDO> enclosureDetailsAnalysisList;

   public static ProductDetailsAnalysisDTO.ProductDetailsAnalysisDTOBuilder builder() {
      return new ProductDetailsAnalysisDTO.ProductDetailsAnalysisDTOBuilder();
   }

   public ProductDetailsAnalysisDTO(
      final List<ArtifactDetailsAnalysisDO> artifactDetailsAnalysisDTOList, final List<EnclosureDetailsAnalysisDO> enclosureDetailsAnalysisList
   ) {
      this.artifactDetailsAnalysisDTOList = artifactDetailsAnalysisDTOList;
      this.enclosureDetailsAnalysisList = enclosureDetailsAnalysisList;
   }

   public ProductDetailsAnalysisDTO() {
   }

   public List<ArtifactDetailsAnalysisDO> getArtifactDetailsAnalysisDTOList() {
      return this.artifactDetailsAnalysisDTOList;
   }

   public List<EnclosureDetailsAnalysisDO> getEnclosureDetailsAnalysisList() {
      return this.enclosureDetailsAnalysisList;
   }

   public void setArtifactDetailsAnalysisDTOList(final List<ArtifactDetailsAnalysisDO> artifactDetailsAnalysisDTOList) {
      this.artifactDetailsAnalysisDTOList = artifactDetailsAnalysisDTOList;
   }

   public void setEnclosureDetailsAnalysisList(final List<EnclosureDetailsAnalysisDO> enclosureDetailsAnalysisList) {
      this.enclosureDetailsAnalysisList = enclosureDetailsAnalysisList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductDetailsAnalysisDTO)) {
         return false;
      } else {
         ProductDetailsAnalysisDTO other = (ProductDetailsAnalysisDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$artifactDetailsAnalysisDTOList = this.getArtifactDetailsAnalysisDTOList();
            Object other$artifactDetailsAnalysisDTOList = other.getArtifactDetailsAnalysisDTOList();
            if (this$artifactDetailsAnalysisDTOList == null
               ? other$artifactDetailsAnalysisDTOList == null
               : this$artifactDetailsAnalysisDTOList.equals(other$artifactDetailsAnalysisDTOList)) {
               Object this$enclosureDetailsAnalysisList = this.getEnclosureDetailsAnalysisList();
               Object other$enclosureDetailsAnalysisList = other.getEnclosureDetailsAnalysisList();
               return this$enclosureDetailsAnalysisList == null
                  ? other$enclosureDetailsAnalysisList == null
                  : this$enclosureDetailsAnalysisList.equals(other$enclosureDetailsAnalysisList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductDetailsAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactDetailsAnalysisDTOList = this.getArtifactDetailsAnalysisDTOList();
      result = result * 59 + ($artifactDetailsAnalysisDTOList == null ? 43 : $artifactDetailsAnalysisDTOList.hashCode());
      Object $enclosureDetailsAnalysisList = this.getEnclosureDetailsAnalysisList();
      return result * 59 + ($enclosureDetailsAnalysisList == null ? 43 : $enclosureDetailsAnalysisList.hashCode());
   }

   @Override
   public String toString() {
      return "ProductDetailsAnalysisDTO(artifactDetailsAnalysisDTOList="
         + this.getArtifactDetailsAnalysisDTOList()
         + ", enclosureDetailsAnalysisList="
         + this.getEnclosureDetailsAnalysisList()
         + ")";
   }

   public static class ProductDetailsAnalysisDTOBuilder {
      private List<ArtifactDetailsAnalysisDO> artifactDetailsAnalysisDTOList;
      private List<EnclosureDetailsAnalysisDO> enclosureDetailsAnalysisList;

      ProductDetailsAnalysisDTOBuilder() {
      }

      public ProductDetailsAnalysisDTO.ProductDetailsAnalysisDTOBuilder artifactDetailsAnalysisDTOList(
         final List<ArtifactDetailsAnalysisDO> artifactDetailsAnalysisDTOList
      ) {
         this.artifactDetailsAnalysisDTOList = artifactDetailsAnalysisDTOList;
         return this;
      }

      public ProductDetailsAnalysisDTO.ProductDetailsAnalysisDTOBuilder enclosureDetailsAnalysisList(
         final List<EnclosureDetailsAnalysisDO> enclosureDetailsAnalysisList
      ) {
         this.enclosureDetailsAnalysisList = enclosureDetailsAnalysisList;
         return this;
      }

      public ProductDetailsAnalysisDTO build() {
         return new ProductDetailsAnalysisDTO(this.artifactDetailsAnalysisDTOList, this.enclosureDetailsAnalysisList);
      }

      @Override
      public String toString() {
         return "ProductDetailsAnalysisDTO.ProductDetailsAnalysisDTOBuilder(artifactDetailsAnalysisDTOList="
            + this.artifactDetailsAnalysisDTOList
            + ", enclosureDetailsAnalysisList="
            + this.enclosureDetailsAnalysisList
            + ")";
      }
   }
}
