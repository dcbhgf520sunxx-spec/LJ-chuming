package com.hzchum.scim.plan.core.api.pojo.dto.drawing;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProductDrawingsSummaryDetailDTO", description = "产品图纸数据统计返回类")
public class ProductDrawingsSummaryDetailDTO {
   @ApiModelProperty(name = "artifactQuantity", value = "构件清单总数")
   private Integer artifactQuantity;
   @ApiModelProperty(name = "artifactDrawingQuantity", value = "构件图纸总数")
   private Integer artifactDrawingQuantity;
   @ApiModelProperty(name = "assembleQuantity", value = "部件清单总数")
   private Integer assembleQuantity;
   @ApiModelProperty(name = "assembleDrawingQuantity", value = "部件图纸总数")
   private Integer assembleDrawingQuantity;
   @ApiModelProperty(name = "partQuantity", value = "零件清单总数")
   private Integer partQuantity;
   @ApiModelProperty(name = "partDrawingQuantity", value = "零件图纸总数")
   private Integer partDrawingQuantity;

   public static ProductDrawingsSummaryDetailDTO.ProductDrawingsSummaryDetailDTOBuilder builder() {
      return new ProductDrawingsSummaryDetailDTO.ProductDrawingsSummaryDetailDTOBuilder();
   }

   public ProductDrawingsSummaryDetailDTO() {
   }

   public ProductDrawingsSummaryDetailDTO(
      final Integer artifactQuantity,
      final Integer artifactDrawingQuantity,
      final Integer assembleQuantity,
      final Integer assembleDrawingQuantity,
      final Integer partQuantity,
      final Integer partDrawingQuantity
   ) {
      this.artifactQuantity = artifactQuantity;
      this.artifactDrawingQuantity = artifactDrawingQuantity;
      this.assembleQuantity = assembleQuantity;
      this.assembleDrawingQuantity = assembleDrawingQuantity;
      this.partQuantity = partQuantity;
      this.partDrawingQuantity = partDrawingQuantity;
   }

   public Integer getArtifactQuantity() {
      return this.artifactQuantity;
   }

   public Integer getArtifactDrawingQuantity() {
      return this.artifactDrawingQuantity;
   }

   public Integer getAssembleQuantity() {
      return this.assembleQuantity;
   }

   public Integer getAssembleDrawingQuantity() {
      return this.assembleDrawingQuantity;
   }

   public Integer getPartQuantity() {
      return this.partQuantity;
   }

   public Integer getPartDrawingQuantity() {
      return this.partDrawingQuantity;
   }

   public void setArtifactQuantity(final Integer artifactQuantity) {
      this.artifactQuantity = artifactQuantity;
   }

   public void setArtifactDrawingQuantity(final Integer artifactDrawingQuantity) {
      this.artifactDrawingQuantity = artifactDrawingQuantity;
   }

   public void setAssembleQuantity(final Integer assembleQuantity) {
      this.assembleQuantity = assembleQuantity;
   }

   public void setAssembleDrawingQuantity(final Integer assembleDrawingQuantity) {
      this.assembleDrawingQuantity = assembleDrawingQuantity;
   }

   public void setPartQuantity(final Integer partQuantity) {
      this.partQuantity = partQuantity;
   }

   public void setPartDrawingQuantity(final Integer partDrawingQuantity) {
      this.partDrawingQuantity = partDrawingQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductDrawingsSummaryDetailDTO)) {
         return false;
      }

      ProductDrawingsSummaryDetailDTO other = (ProductDrawingsSummaryDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactQuantity = this.getArtifactQuantity();
      Object other$artifactQuantity = other.getArtifactQuantity();
      if (this$artifactQuantity == null ? other$artifactQuantity == null : this$artifactQuantity.equals(other$artifactQuantity)) {
         Object this$artifactDrawingQuantity = this.getArtifactDrawingQuantity();
         Object other$artifactDrawingQuantity = other.getArtifactDrawingQuantity();
         if (this$artifactDrawingQuantity == null ? other$artifactDrawingQuantity == null : this$artifactDrawingQuantity.equals(other$artifactDrawingQuantity)) {
            Object this$assembleQuantity = this.getAssembleQuantity();
            Object other$assembleQuantity = other.getAssembleQuantity();
            if (this$assembleQuantity == null ? other$assembleQuantity == null : this$assembleQuantity.equals(other$assembleQuantity)) {
               Object this$assembleDrawingQuantity = this.getAssembleDrawingQuantity();
               Object other$assembleDrawingQuantity = other.getAssembleDrawingQuantity();
               if (this$assembleDrawingQuantity == null
                  ? other$assembleDrawingQuantity == null
                  : this$assembleDrawingQuantity.equals(other$assembleDrawingQuantity)) {
                  Object this$partQuantity = this.getPartQuantity();
                  Object other$partQuantity = other.getPartQuantity();
                  if (this$partQuantity == null ? other$partQuantity == null : this$partQuantity.equals(other$partQuantity)) {
                     Object this$partDrawingQuantity = this.getPartDrawingQuantity();
                     Object other$partDrawingQuantity = other.getPartDrawingQuantity();
                     return this$partDrawingQuantity == null ? other$partDrawingQuantity == null : this$partDrawingQuantity.equals(other$partDrawingQuantity);
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
      return other instanceof ProductDrawingsSummaryDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactQuantity = this.getArtifactQuantity();
      result = result * 59 + ($artifactQuantity == null ? 43 : $artifactQuantity.hashCode());
      Object $artifactDrawingQuantity = this.getArtifactDrawingQuantity();
      result = result * 59 + ($artifactDrawingQuantity == null ? 43 : $artifactDrawingQuantity.hashCode());
      Object $assembleQuantity = this.getAssembleQuantity();
      result = result * 59 + ($assembleQuantity == null ? 43 : $assembleQuantity.hashCode());
      Object $assembleDrawingQuantity = this.getAssembleDrawingQuantity();
      result = result * 59 + ($assembleDrawingQuantity == null ? 43 : $assembleDrawingQuantity.hashCode());
      Object $partQuantity = this.getPartQuantity();
      result = result * 59 + ($partQuantity == null ? 43 : $partQuantity.hashCode());
      Object $partDrawingQuantity = this.getPartDrawingQuantity();
      return result * 59 + ($partDrawingQuantity == null ? 43 : $partDrawingQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "ProductDrawingsSummaryDetailDTO(artifactQuantity="
         + this.getArtifactQuantity()
         + ", artifactDrawingQuantity="
         + this.getArtifactDrawingQuantity()
         + ", assembleQuantity="
         + this.getAssembleQuantity()
         + ", assembleDrawingQuantity="
         + this.getAssembleDrawingQuantity()
         + ", partQuantity="
         + this.getPartQuantity()
         + ", partDrawingQuantity="
         + this.getPartDrawingQuantity()
         + ")";
   }

   public static class ProductDrawingsSummaryDetailDTOBuilder {
      private Integer artifactQuantity;
      private Integer artifactDrawingQuantity;
      private Integer assembleQuantity;
      private Integer assembleDrawingQuantity;
      private Integer partQuantity;
      private Integer partDrawingQuantity;

      ProductDrawingsSummaryDetailDTOBuilder() {
      }

      public ProductDrawingsSummaryDetailDTO.ProductDrawingsSummaryDetailDTOBuilder artifactQuantity(final Integer artifactQuantity) {
         this.artifactQuantity = artifactQuantity;
         return this;
      }

      public ProductDrawingsSummaryDetailDTO.ProductDrawingsSummaryDetailDTOBuilder artifactDrawingQuantity(final Integer artifactDrawingQuantity) {
         this.artifactDrawingQuantity = artifactDrawingQuantity;
         return this;
      }

      public ProductDrawingsSummaryDetailDTO.ProductDrawingsSummaryDetailDTOBuilder assembleQuantity(final Integer assembleQuantity) {
         this.assembleQuantity = assembleQuantity;
         return this;
      }

      public ProductDrawingsSummaryDetailDTO.ProductDrawingsSummaryDetailDTOBuilder assembleDrawingQuantity(final Integer assembleDrawingQuantity) {
         this.assembleDrawingQuantity = assembleDrawingQuantity;
         return this;
      }

      public ProductDrawingsSummaryDetailDTO.ProductDrawingsSummaryDetailDTOBuilder partQuantity(final Integer partQuantity) {
         this.partQuantity = partQuantity;
         return this;
      }

      public ProductDrawingsSummaryDetailDTO.ProductDrawingsSummaryDetailDTOBuilder partDrawingQuantity(final Integer partDrawingQuantity) {
         this.partDrawingQuantity = partDrawingQuantity;
         return this;
      }

      public ProductDrawingsSummaryDetailDTO build() {
         return new ProductDrawingsSummaryDetailDTO(
            this.artifactQuantity,
            this.artifactDrawingQuantity,
            this.assembleQuantity,
            this.assembleDrawingQuantity,
            this.partQuantity,
            this.partDrawingQuantity
         );
      }

      @Override
      public String toString() {
         return "ProductDrawingsSummaryDetailDTO.ProductDrawingsSummaryDetailDTOBuilder(artifactQuantity="
            + this.artifactQuantity
            + ", artifactDrawingQuantity="
            + this.artifactDrawingQuantity
            + ", assembleQuantity="
            + this.assembleQuantity
            + ", assembleDrawingQuantity="
            + this.assembleDrawingQuantity
            + ", partQuantity="
            + this.partQuantity
            + ", partDrawingQuantity="
            + this.partDrawingQuantity
            + ")";
      }
   }
}
