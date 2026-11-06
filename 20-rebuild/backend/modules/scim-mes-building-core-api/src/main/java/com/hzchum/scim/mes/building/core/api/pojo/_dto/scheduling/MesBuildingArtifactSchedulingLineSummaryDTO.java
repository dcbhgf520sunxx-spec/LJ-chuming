package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingArtifactSchedulingLineSummaryDTO", description = "产线构件排产信息汇总")
public class MesBuildingArtifactSchedulingLineSummaryDTO {
   @ApiModelProperty(name = "workshop", value = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", value = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "mete", value = "清单量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private QuantityAndWeightDetailDO mete;

   public static MesBuildingArtifactSchedulingLineSummaryDTO.MesBuildingArtifactSchedulingLineSummaryDTOBuilder builder() {
      return new MesBuildingArtifactSchedulingLineSummaryDTO.MesBuildingArtifactSchedulingLineSummaryDTOBuilder();
   }

   public MesBuildingArtifactSchedulingLineSummaryDTO(
      final WorkshopDetailDO workshop, final ProductionLineDetailDO productionLine, final QuantityAndWeightDetailDO mete
   ) {
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.mete = mete;
   }

   public MesBuildingArtifactSchedulingLineSummaryDTO() {
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public QuantityAndWeightDetailDO getMete() {
      return this.mete;
   }

   @JsonProperty("workshop")
   public MesBuildingArtifactSchedulingLineSummaryDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MesBuildingArtifactSchedulingLineSummaryDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("mete")
   public MesBuildingArtifactSchedulingLineSummaryDTO setMete(final QuantityAndWeightDetailDO mete) {
      this.mete = mete;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactSchedulingLineSummaryDTO(workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", mete="
         + this.getMete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactSchedulingLineSummaryDTO)) {
         return false;
      }

      MesBuildingArtifactSchedulingLineSummaryDTO other = (MesBuildingArtifactSchedulingLineSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshop = this.getWorkshop();
      Object other$workshop = other.getWorkshop();
      if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
         Object this$productionLine = this.getProductionLine();
         Object other$productionLine = other.getProductionLine();
         if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
            Object this$mete = this.getMete();
            Object other$mete = other.getMete();
            return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactSchedulingLineSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   public static class MesBuildingArtifactSchedulingLineSummaryDTOBuilder {
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private QuantityAndWeightDetailDO mete;

      MesBuildingArtifactSchedulingLineSummaryDTOBuilder() {
      }

      @JsonProperty("workshop")
      public MesBuildingArtifactSchedulingLineSummaryDTO.MesBuildingArtifactSchedulingLineSummaryDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public MesBuildingArtifactSchedulingLineSummaryDTO.MesBuildingArtifactSchedulingLineSummaryDTOBuilder productionLine(
         final ProductionLineDetailDO productionLine
      ) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("mete")
      public MesBuildingArtifactSchedulingLineSummaryDTO.MesBuildingArtifactSchedulingLineSummaryDTOBuilder mete(final QuantityAndWeightDetailDO mete) {
         this.mete = mete;
         return this;
      }

      public MesBuildingArtifactSchedulingLineSummaryDTO build() {
         return new MesBuildingArtifactSchedulingLineSummaryDTO(this.workshop, this.productionLine, this.mete);
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactSchedulingLineSummaryDTO.MesBuildingArtifactSchedulingLineSummaryDTOBuilder(workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", mete="
            + this.mete
            + ")";
      }
   }
}
