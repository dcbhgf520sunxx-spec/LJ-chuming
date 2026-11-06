package com.hzchum.scim.system.core.api.pojo.dto.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

public class MesBuildingProductionLineTeamLinkDTO {
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @NotNull(message = "产线不能为空")
   private Long productionLineId;
   @ApiModelProperty(name = "teamType", value = "班组类型[0 班组 1 质检班组]", notes = "班组类型[0 班组 1 质检班组]")
   private Boolean teamType;
   @ApiModelProperty(name = "teamIds", value = "所包含班组ids", notes = "所包含班组ids")
   @JsonProperty("teamIds")
   @JSONField(name = "teamIds")
   @JsonInclude(Include.NON_NULL)
   private List<Long> teamIds;
   @ApiModelProperty(name = "inspectionTeamIds", value = "所包含质检班组ids", notes = "所包含质检班组ids")
   @JsonProperty("inspectionTeamIds")
   @JSONField(name = "inspectionTeamIds")
   @JsonInclude(Include.NON_NULL)
   private List<Long> inspectionTeamIds;

   public static MesBuildingProductionLineTeamLinkDTO.MesBuildingProductionLineTeamLinkDTOBuilder builder() {
      return new MesBuildingProductionLineTeamLinkDTO.MesBuildingProductionLineTeamLinkDTOBuilder();
   }

   public MesBuildingProductionLineTeamLinkDTO() {
   }

   public MesBuildingProductionLineTeamLinkDTO(
      final Long productionLineId, final Boolean teamType, final List<Long> teamIds, final List<Long> inspectionTeamIds
   ) {
      this.productionLineId = productionLineId;
      this.teamType = teamType;
      this.teamIds = teamIds;
      this.inspectionTeamIds = inspectionTeamIds;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Boolean getTeamType() {
      return this.teamType;
   }

   public List<Long> getTeamIds() {
      return this.teamIds;
   }

   public List<Long> getInspectionTeamIds() {
      return this.inspectionTeamIds;
   }

   public void setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
   }

   public void setTeamType(final Boolean teamType) {
      this.teamType = teamType;
   }

   @JsonProperty("teamIds")
   public void setTeamIds(final List<Long> teamIds) {
      this.teamIds = teamIds;
   }

   @JsonProperty("inspectionTeamIds")
   public void setInspectionTeamIds(final List<Long> inspectionTeamIds) {
      this.inspectionTeamIds = inspectionTeamIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductionLineTeamLinkDTO)) {
         return false;
      }

      MesBuildingProductionLineTeamLinkDTO other = (MesBuildingProductionLineTeamLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productionLineId = this.getProductionLineId();
      Object other$productionLineId = other.getProductionLineId();
      if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
         Object this$teamType = this.getTeamType();
         Object other$teamType = other.getTeamType();
         if (this$teamType == null ? other$teamType == null : this$teamType.equals(other$teamType)) {
            Object this$teamIds = this.getTeamIds();
            Object other$teamIds = other.getTeamIds();
            if (this$teamIds == null ? other$teamIds == null : this$teamIds.equals(other$teamIds)) {
               Object this$inspectionTeamIds = this.getInspectionTeamIds();
               Object other$inspectionTeamIds = other.getInspectionTeamIds();
               return this$inspectionTeamIds == null ? other$inspectionTeamIds == null : this$inspectionTeamIds.equals(other$inspectionTeamIds);
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
      return other instanceof MesBuildingProductionLineTeamLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $teamType = this.getTeamType();
      result = result * 59 + ($teamType == null ? 43 : $teamType.hashCode());
      Object $teamIds = this.getTeamIds();
      result = result * 59 + ($teamIds == null ? 43 : $teamIds.hashCode());
      Object $inspectionTeamIds = this.getInspectionTeamIds();
      return result * 59 + ($inspectionTeamIds == null ? 43 : $inspectionTeamIds.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingProductionLineTeamLinkDTO(productionLineId="
         + this.getProductionLineId()
         + ", teamType="
         + this.getTeamType()
         + ", teamIds="
         + this.getTeamIds()
         + ", inspectionTeamIds="
         + this.getInspectionTeamIds()
         + ")";
   }

   public static class MesBuildingProductionLineTeamLinkDTOBuilder {
      private Long productionLineId;
      private Boolean teamType;
      private List<Long> teamIds;
      private List<Long> inspectionTeamIds;

      MesBuildingProductionLineTeamLinkDTOBuilder() {
      }

      public MesBuildingProductionLineTeamLinkDTO.MesBuildingProductionLineTeamLinkDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public MesBuildingProductionLineTeamLinkDTO.MesBuildingProductionLineTeamLinkDTOBuilder teamType(final Boolean teamType) {
         this.teamType = teamType;
         return this;
      }

      @JsonProperty("teamIds")
      public MesBuildingProductionLineTeamLinkDTO.MesBuildingProductionLineTeamLinkDTOBuilder teamIds(final List<Long> teamIds) {
         this.teamIds = teamIds;
         return this;
      }

      @JsonProperty("inspectionTeamIds")
      public MesBuildingProductionLineTeamLinkDTO.MesBuildingProductionLineTeamLinkDTOBuilder inspectionTeamIds(final List<Long> inspectionTeamIds) {
         this.inspectionTeamIds = inspectionTeamIds;
         return this;
      }

      public MesBuildingProductionLineTeamLinkDTO build() {
         return new MesBuildingProductionLineTeamLinkDTO(this.productionLineId, this.teamType, this.teamIds, this.inspectionTeamIds);
      }

      @Override
      public String toString() {
         return "MesBuildingProductionLineTeamLinkDTO.MesBuildingProductionLineTeamLinkDTOBuilder(productionLineId="
            + this.productionLineId
            + ", teamType="
            + this.teamType
            + ", teamIds="
            + this.teamIds
            + ", inspectionTeamIds="
            + this.inspectionTeamIds
            + ")";
      }
   }
}
