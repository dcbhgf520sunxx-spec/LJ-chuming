package com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "KanBanMachinePartSummaryDO", description = "零件厚度")
public class KanBanMachinePartSummaryDO {
   @ApiModelProperty("钢材厚度/规格")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String steelSpec;

   public static KanBanMachinePartSummaryDO.KanBanMachinePartSummaryDOBuilder builder() {
      return new KanBanMachinePartSummaryDO.KanBanMachinePartSummaryDOBuilder();
   }

   public KanBanMachinePartSummaryDO() {
   }

   public KanBanMachinePartSummaryDO(final String steelSpec) {
      this.steelSpec = steelSpec;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   @JsonProperty("name")
   public KanBanMachinePartSummaryDO setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
      return this;
   }

   @Override
   public String toString() {
      return "KanBanMachinePartSummaryDO(steelSpec=" + this.getSteelSpec() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof KanBanMachinePartSummaryDO)) {
         return false;
      }

      KanBanMachinePartSummaryDO other = (KanBanMachinePartSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$steelSpec = this.getSteelSpec();
      Object other$steelSpec = other.getSteelSpec();
      return this$steelSpec == null ? other$steelSpec == null : this$steelSpec.equals(other$steelSpec);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof KanBanMachinePartSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $steelSpec = this.getSteelSpec();
      return result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
   }

   public static class KanBanMachinePartSummaryDOBuilder {
      private String steelSpec;

      KanBanMachinePartSummaryDOBuilder() {
      }

      @JsonProperty("name")
      public KanBanMachinePartSummaryDO.KanBanMachinePartSummaryDOBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      public KanBanMachinePartSummaryDO build() {
         return new KanBanMachinePartSummaryDO(this.steelSpec);
      }

      @Override
      public String toString() {
         return "KanBanMachinePartSummaryDO.KanBanMachinePartSummaryDOBuilder(steelSpec=" + this.steelSpec + ")";
      }
   }
}
