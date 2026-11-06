package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.ProductionAnalysisDetailsDO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.OutboundAmountDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "QhseDTO", description = "问题上报汇总")
public class AuxiliaryMaterialsAnalysisDTO {
   @ApiModelProperty(name = "productionAnalysisDetails", value = "产量", notes = "产量")
   @JsonProperty("productionAnalysisDetails")
   @JSONField(name = "productionAnalysisDetails")
   private List<ProductionAnalysisDetailsDO> productionAnalysisDetails;
   @ApiModelProperty(name = "outboundAmounts", value = "产量", notes = "产量")
   @JsonProperty("outboundAmounts")
   @JSONField(name = "outboundAmounts")
   private List<OutboundAmountDTO> outboundAmounts;

   public static AuxiliaryMaterialsAnalysisDTO.AuxiliaryMaterialsAnalysisDTOBuilder builder() {
      return new AuxiliaryMaterialsAnalysisDTO.AuxiliaryMaterialsAnalysisDTOBuilder();
   }

   public AuxiliaryMaterialsAnalysisDTO(final List<ProductionAnalysisDetailsDO> productionAnalysisDetails, final List<OutboundAmountDTO> outboundAmounts) {
      this.productionAnalysisDetails = productionAnalysisDetails;
      this.outboundAmounts = outboundAmounts;
   }

   public AuxiliaryMaterialsAnalysisDTO() {
   }

   public List<ProductionAnalysisDetailsDO> getProductionAnalysisDetails() {
      return this.productionAnalysisDetails;
   }

   public List<OutboundAmountDTO> getOutboundAmounts() {
      return this.outboundAmounts;
   }

   @JsonProperty("productionAnalysisDetails")
   public AuxiliaryMaterialsAnalysisDTO setProductionAnalysisDetails(final List<ProductionAnalysisDetailsDO> productionAnalysisDetails) {
      this.productionAnalysisDetails = productionAnalysisDetails;
      return this;
   }

   @JsonProperty("outboundAmounts")
   public AuxiliaryMaterialsAnalysisDTO setOutboundAmounts(final List<OutboundAmountDTO> outboundAmounts) {
      this.outboundAmounts = outboundAmounts;
      return this;
   }

   @Override
   public String toString() {
      return "AuxiliaryMaterialsAnalysisDTO(productionAnalysisDetails="
         + this.getProductionAnalysisDetails()
         + ", outboundAmounts="
         + this.getOutboundAmounts()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AuxiliaryMaterialsAnalysisDTO)) {
         return false;
      } else {
         AuxiliaryMaterialsAnalysisDTO other = (AuxiliaryMaterialsAnalysisDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$productionAnalysisDetails = this.getProductionAnalysisDetails();
            Object other$productionAnalysisDetails = other.getProductionAnalysisDetails();
            if (this$productionAnalysisDetails == null
               ? other$productionAnalysisDetails == null
               : this$productionAnalysisDetails.equals(other$productionAnalysisDetails)) {
               Object this$outboundAmounts = this.getOutboundAmounts();
               Object other$outboundAmounts = other.getOutboundAmounts();
               return this$outboundAmounts == null ? other$outboundAmounts == null : this$outboundAmounts.equals(other$outboundAmounts);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AuxiliaryMaterialsAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productionAnalysisDetails = this.getProductionAnalysisDetails();
      result = result * 59 + ($productionAnalysisDetails == null ? 43 : $productionAnalysisDetails.hashCode());
      Object $outboundAmounts = this.getOutboundAmounts();
      return result * 59 + ($outboundAmounts == null ? 43 : $outboundAmounts.hashCode());
   }

   public static class AuxiliaryMaterialsAnalysisDTOBuilder {
      private List<ProductionAnalysisDetailsDO> productionAnalysisDetails;
      private List<OutboundAmountDTO> outboundAmounts;

      AuxiliaryMaterialsAnalysisDTOBuilder() {
      }

      @JsonProperty("productionAnalysisDetails")
      public AuxiliaryMaterialsAnalysisDTO.AuxiliaryMaterialsAnalysisDTOBuilder productionAnalysisDetails(
         final List<ProductionAnalysisDetailsDO> productionAnalysisDetails
      ) {
         this.productionAnalysisDetails = productionAnalysisDetails;
         return this;
      }

      @JsonProperty("outboundAmounts")
      public AuxiliaryMaterialsAnalysisDTO.AuxiliaryMaterialsAnalysisDTOBuilder outboundAmounts(final List<OutboundAmountDTO> outboundAmounts) {
         this.outboundAmounts = outboundAmounts;
         return this;
      }

      public AuxiliaryMaterialsAnalysisDTO build() {
         return new AuxiliaryMaterialsAnalysisDTO(this.productionAnalysisDetails, this.outboundAmounts);
      }

      @Override
      public String toString() {
         return "AuxiliaryMaterialsAnalysisDTO.AuxiliaryMaterialsAnalysisDTOBuilder(productionAnalysisDetails="
            + this.productionAnalysisDetails
            + ", outboundAmounts="
            + this.outboundAmounts
            + ")";
      }
   }
}
