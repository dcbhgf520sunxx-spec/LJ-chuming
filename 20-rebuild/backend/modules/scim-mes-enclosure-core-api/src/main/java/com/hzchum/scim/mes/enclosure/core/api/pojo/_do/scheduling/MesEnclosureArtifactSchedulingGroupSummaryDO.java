package com.hzchum.scim.mes.enclosure.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosureArtifactSchedulingGroupSummaryDTO", description = "生产组构件排产信息汇总")
public class MesEnclosureArtifactSchedulingGroupSummaryDO {
   @ApiModelProperty(name = "workshop", value = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", value = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", value = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "mete", value = "清单量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private QuantityAndWeightDetailDO mete;

   public static MesEnclosureArtifactSchedulingGroupSummaryDO.MesEnclosureArtifactSchedulingGroupSummaryDOBuilder builder() {
      return new MesEnclosureArtifactSchedulingGroupSummaryDO.MesEnclosureArtifactSchedulingGroupSummaryDOBuilder();
   }

   public MesEnclosureArtifactSchedulingGroupSummaryDO(
      final WorkshopDetailDO workshop, final ProductionLineDetailDO productionLine, final GroupsCurrencyDO groups, final QuantityAndWeightDetailDO mete
   ) {
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
      this.mete = mete;
   }

   public MesEnclosureArtifactSchedulingGroupSummaryDO() {
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public GroupsCurrencyDO getGroups() {
      return this.groups;
   }

   public QuantityAndWeightDetailDO getMete() {
      return this.mete;
   }

   @JsonProperty("workshop")
   public MesEnclosureArtifactSchedulingGroupSummaryDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MesEnclosureArtifactSchedulingGroupSummaryDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public MesEnclosureArtifactSchedulingGroupSummaryDO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("mete")
   public MesEnclosureArtifactSchedulingGroupSummaryDO setMete(final QuantityAndWeightDetailDO mete) {
      this.mete = mete;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureArtifactSchedulingGroupSummaryDO(workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", mete="
         + this.getMete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureArtifactSchedulingGroupSummaryDO)) {
         return false;
      }

      MesEnclosureArtifactSchedulingGroupSummaryDO other = (MesEnclosureArtifactSchedulingGroupSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshop = this.getWorkshop();
      Object other$workshop = other.getWorkshop();
      if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
         Object this$productionLine = this.getProductionLine();
         Object other$productionLine = other.getProductionLine();
         if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
            Object this$groups = this.getGroups();
            Object other$groups = other.getGroups();
            if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
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
      return other instanceof MesEnclosureArtifactSchedulingGroupSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   public static class MesEnclosureArtifactSchedulingGroupSummaryDOBuilder {
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO groups;
      private QuantityAndWeightDetailDO mete;

      MesEnclosureArtifactSchedulingGroupSummaryDOBuilder() {
      }

      @JsonProperty("workshop")
      public MesEnclosureArtifactSchedulingGroupSummaryDO.MesEnclosureArtifactSchedulingGroupSummaryDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public MesEnclosureArtifactSchedulingGroupSummaryDO.MesEnclosureArtifactSchedulingGroupSummaryDOBuilder productionLine(
         final ProductionLineDetailDO productionLine
      ) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public MesEnclosureArtifactSchedulingGroupSummaryDO.MesEnclosureArtifactSchedulingGroupSummaryDOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("mete")
      public MesEnclosureArtifactSchedulingGroupSummaryDO.MesEnclosureArtifactSchedulingGroupSummaryDOBuilder mete(final QuantityAndWeightDetailDO mete) {
         this.mete = mete;
         return this;
      }

      public MesEnclosureArtifactSchedulingGroupSummaryDO build() {
         return new MesEnclosureArtifactSchedulingGroupSummaryDO(this.workshop, this.productionLine, this.groups, this.mete);
      }

      @Override
      public String toString() {
         return "MesEnclosureArtifactSchedulingGroupSummaryDO.MesEnclosureArtifactSchedulingGroupSummaryDOBuilder(workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", mete="
            + this.mete
            + ")";
      }
   }
}
