package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "MesBuildingPartCutConfigWorkShopDTO", description = "")
public class MesBuildingPartCutConfigLineDTO {
   @ApiModelProperty(name = "productionLineId", value = "产线id", notes = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", value = "产线名称", notes = "产线名称")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "mesBuildingPartCutConfigTeamDTOList", value = "班组集合", notes = "班组集合")
   @JsonProperty("mesBuildingPartCutConfigTeamDTOList")
   @JSONField(name = "mesBuildingPartCutConfigTeamDTOList")
   private List<MesBuildingPartCutConfigTeamDTO> mesBuildingPartCutConfigTeamDTOList;

   public MesBuildingPartCutConfigLineDTO(Long productionLineId, String productionLineName) {
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.mesBuildingPartCutConfigTeamDTOList = new ArrayList<>();
   }

   public void addTeam(MesBuildingPartCutConfigTeamDTO team) {
      if (this.mesBuildingPartCutConfigTeamDTOList == null) {
         this.mesBuildingPartCutConfigTeamDTOList = new ArrayList<>();
      }

      this.mesBuildingPartCutConfigTeamDTOList.add(team);
   }

   public static MesBuildingPartCutConfigLineDTO.MesBuildingPartCutConfigLineDTOBuilder builder() {
      return new MesBuildingPartCutConfigLineDTO.MesBuildingPartCutConfigLineDTOBuilder();
   }

   public MesBuildingPartCutConfigLineDTO() {
   }

   public MesBuildingPartCutConfigLineDTO(
      final Long productionLineId, final String productionLineName, final List<MesBuildingPartCutConfigTeamDTO> mesBuildingPartCutConfigTeamDTOList
   ) {
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.mesBuildingPartCutConfigTeamDTOList = mesBuildingPartCutConfigTeamDTOList;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public List<MesBuildingPartCutConfigTeamDTO> getMesBuildingPartCutConfigTeamDTOList() {
      return this.mesBuildingPartCutConfigTeamDTOList;
   }

   @JsonProperty("productionLineId")
   public MesBuildingPartCutConfigLineDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineName")
   public MesBuildingPartCutConfigLineDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("mesBuildingPartCutConfigTeamDTOList")
   public MesBuildingPartCutConfigLineDTO setMesBuildingPartCutConfigTeamDTOList(
      final List<MesBuildingPartCutConfigTeamDTO> mesBuildingPartCutConfigTeamDTOList
   ) {
      this.mesBuildingPartCutConfigTeamDTOList = mesBuildingPartCutConfigTeamDTOList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPartCutConfigLineDTO(productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", mesBuildingPartCutConfigTeamDTOList="
         + this.getMesBuildingPartCutConfigTeamDTOList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPartCutConfigLineDTO)) {
         return false;
      }

      MesBuildingPartCutConfigLineDTO other = (MesBuildingPartCutConfigLineDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productionLineId = this.getProductionLineId();
      Object other$productionLineId = other.getProductionLineId();
      if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
         Object this$productionLineName = this.getProductionLineName();
         Object other$productionLineName = other.getProductionLineName();
         if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
            Object this$mesBuildingPartCutConfigTeamDTOList = this.getMesBuildingPartCutConfigTeamDTOList();
            Object other$mesBuildingPartCutConfigTeamDTOList = other.getMesBuildingPartCutConfigTeamDTOList();
            return this$mesBuildingPartCutConfigTeamDTOList == null
               ? other$mesBuildingPartCutConfigTeamDTOList == null
               : this$mesBuildingPartCutConfigTeamDTOList.equals(other$mesBuildingPartCutConfigTeamDTOList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPartCutConfigLineDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $mesBuildingPartCutConfigTeamDTOList = this.getMesBuildingPartCutConfigTeamDTOList();
      return result * 59 + ($mesBuildingPartCutConfigTeamDTOList == null ? 43 : $mesBuildingPartCutConfigTeamDTOList.hashCode());
   }

   public static class MesBuildingPartCutConfigLineDTOBuilder {
      private Long productionLineId;
      private String productionLineName;
      private List<MesBuildingPartCutConfigTeamDTO> mesBuildingPartCutConfigTeamDTOList;

      MesBuildingPartCutConfigLineDTOBuilder() {
      }

      @JsonProperty("productionLineId")
      public MesBuildingPartCutConfigLineDTO.MesBuildingPartCutConfigLineDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineName")
      public MesBuildingPartCutConfigLineDTO.MesBuildingPartCutConfigLineDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("mesBuildingPartCutConfigTeamDTOList")
      public MesBuildingPartCutConfigLineDTO.MesBuildingPartCutConfigLineDTOBuilder mesBuildingPartCutConfigTeamDTOList(
         final List<MesBuildingPartCutConfigTeamDTO> mesBuildingPartCutConfigTeamDTOList
      ) {
         this.mesBuildingPartCutConfigTeamDTOList = mesBuildingPartCutConfigTeamDTOList;
         return this;
      }

      public MesBuildingPartCutConfigLineDTO build() {
         return new MesBuildingPartCutConfigLineDTO(this.productionLineId, this.productionLineName, this.mesBuildingPartCutConfigTeamDTOList);
      }

      @Override
      public String toString() {
         return "MesBuildingPartCutConfigLineDTO.MesBuildingPartCutConfigLineDTOBuilder(productionLineId="
            + this.productionLineId
            + ", productionLineName="
            + this.productionLineName
            + ", mesBuildingPartCutConfigTeamDTOList="
            + this.mesBuildingPartCutConfigTeamDTOList
            + ")";
      }
   }
}
