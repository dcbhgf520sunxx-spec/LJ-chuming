package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "KanBanMachinePartSummaryDTO", description = "零件厚度")
public class KanBanMachinePartSummaryDTO {
   @ApiModelProperty("钢材厚度/规格")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String steelSpec;

   public static KanBanMachinePartSummaryDTO.KanBanMachinePartSummaryDTOBuilder builder() {
      return new KanBanMachinePartSummaryDTO.KanBanMachinePartSummaryDTOBuilder();
   }

   public KanBanMachinePartSummaryDTO() {
   }

   public KanBanMachinePartSummaryDTO(final String steelSpec) {
      this.steelSpec = steelSpec;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   @JsonProperty("name")
   public KanBanMachinePartSummaryDTO setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
      return this;
   }

   @Override
   public String toString() {
      return "KanBanMachinePartSummaryDTO(steelSpec=" + this.getSteelSpec() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof KanBanMachinePartSummaryDTO)) {
         return false;
      }

      KanBanMachinePartSummaryDTO other = (KanBanMachinePartSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$steelSpec = this.getSteelSpec();
      Object other$steelSpec = other.getSteelSpec();
      return this$steelSpec == null ? other$steelSpec == null : this$steelSpec.equals(other$steelSpec);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof KanBanMachinePartSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $steelSpec = this.getSteelSpec();
      return result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
   }

   public static class KanBanMachinePartSummaryDTOBuilder {
      private String steelSpec;

      KanBanMachinePartSummaryDTOBuilder() {
      }

      @JsonProperty("name")
      public KanBanMachinePartSummaryDTO.KanBanMachinePartSummaryDTOBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      public KanBanMachinePartSummaryDTO build() {
         return new KanBanMachinePartSummaryDTO(this.steelSpec);
      }

      @Override
      public String toString() {
         return "KanBanMachinePartSummaryDTO.KanBanMachinePartSummaryDTOBuilder(steelSpec=" + this.steelSpec + ")";
      }
   }
}
