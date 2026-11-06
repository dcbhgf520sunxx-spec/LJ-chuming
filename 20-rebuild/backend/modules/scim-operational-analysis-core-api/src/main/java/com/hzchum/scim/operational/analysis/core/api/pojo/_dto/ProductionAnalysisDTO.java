package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.ProductionAnalysisDetailsDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProductionAnalysisDTO", description = "产量分析")
public class ProductionAnalysisDTO {
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   @JsonProperty("year")
   @JSONField(name = "year")
   private String year;
   @ApiModelProperty(name = "productionDetailsList", value = "产量", notes = "产量")
   @JsonProperty("productionDetailsList")
   @JSONField(name = "productionDetailsList")
   private List<ProductionAnalysisDetailsDO> productionDetailsList;

   public static ProductionAnalysisDTO.ProductionAnalysisDTOBuilder builder() {
      return new ProductionAnalysisDTO.ProductionAnalysisDTOBuilder();
   }

   public ProductionAnalysisDTO(final String year, final List<ProductionAnalysisDetailsDO> productionDetailsList) {
      this.year = year;
      this.productionDetailsList = productionDetailsList;
   }

   public ProductionAnalysisDTO() {
   }

   public String getYear() {
      return this.year;
   }

   public List<ProductionAnalysisDetailsDO> getProductionDetailsList() {
      return this.productionDetailsList;
   }

   @JsonProperty("year")
   public ProductionAnalysisDTO setYear(final String year) {
      this.year = year;
      return this;
   }

   @JsonProperty("productionDetailsList")
   public ProductionAnalysisDTO setProductionDetailsList(final List<ProductionAnalysisDetailsDO> productionDetailsList) {
      this.productionDetailsList = productionDetailsList;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionAnalysisDTO(year=" + this.getYear() + ", productionDetailsList=" + this.getProductionDetailsList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductionAnalysisDTO)) {
         return false;
      } else {
         ProductionAnalysisDTO other = (ProductionAnalysisDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$year = this.getYear();
            Object other$year = other.getYear();
            if (this$year == null ? other$year == null : this$year.equals(other$year)) {
               Object this$productionDetailsList = this.getProductionDetailsList();
               Object other$productionDetailsList = other.getProductionDetailsList();
               return this$productionDetailsList == null ? other$productionDetailsList == null : this$productionDetailsList.equals(other$productionDetailsList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductionAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $productionDetailsList = this.getProductionDetailsList();
      return result * 59 + ($productionDetailsList == null ? 43 : $productionDetailsList.hashCode());
   }

   public static class ProductionAnalysisDTOBuilder {
      private String year;
      private List<ProductionAnalysisDetailsDO> productionDetailsList;

      ProductionAnalysisDTOBuilder() {
      }

      @JsonProperty("year")
      public ProductionAnalysisDTO.ProductionAnalysisDTOBuilder year(final String year) {
         this.year = year;
         return this;
      }

      @JsonProperty("productionDetailsList")
      public ProductionAnalysisDTO.ProductionAnalysisDTOBuilder productionDetailsList(final List<ProductionAnalysisDetailsDO> productionDetailsList) {
         this.productionDetailsList = productionDetailsList;
         return this;
      }

      public ProductionAnalysisDTO build() {
         return new ProductionAnalysisDTO(this.year, this.productionDetailsList);
      }

      @Override
      public String toString() {
         return "ProductionAnalysisDTO.ProductionAnalysisDTOBuilder(year=" + this.year + ", productionDetailsList=" + this.productionDetailsList + ")";
      }
   }
}
