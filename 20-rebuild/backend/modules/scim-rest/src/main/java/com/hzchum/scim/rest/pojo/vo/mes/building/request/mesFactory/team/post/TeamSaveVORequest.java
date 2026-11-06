package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.team.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingTeamUserLinkDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "TeamSaveVORequest", description = "")
public class TeamSaveVORequest {
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]", value = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   @NotNull(message = "编制属性不能为空")
   private Boolean organizationType;
   @ApiModelProperty(name = "hasMen", value = "是否有组员0无，1有", notes = "是否有组员0无，1有")
   @JsonProperty("hasMen")
   @JSONField(name = "hasMen")
   private Boolean hasMen;
   @ApiModelProperty(name = "userLinks", notes = "班组人员", value = "班组人员")
   @JsonProperty("userLinks")
   @JSONField(name = "userLinks")
   private List<MesBuildingTeamUserLinkDTOParam> userLinks;
   @ApiModelProperty(name = "teamStatus", notes = "班组状态1开启 0关闭", value = "班组状态1开启 0关闭")
   @JsonProperty("teamStatus")
   @JSONField(name = "teamStatus")
   private Boolean teamStatus;

   public static TeamSaveVORequest.TeamSaveVORequestBuilder builder() {
      return new TeamSaveVORequest.TeamSaveVORequestBuilder();
   }

   public TeamSaveVORequest() {
   }

   public TeamSaveVORequest(
      final Long processId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Boolean organizationType,
      final Boolean hasMen,
      final List<MesBuildingTeamUserLinkDTOParam> userLinks,
      final Boolean teamStatus
   ) {
      this.processId = processId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.organizationType = organizationType;
      this.hasMen = hasMen;
      this.userLinks = userLinks;
      this.teamStatus = teamStatus;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   public Boolean getHasMen() {
      return this.hasMen;
   }

   public List<MesBuildingTeamUserLinkDTOParam> getUserLinks() {
      return this.userLinks;
   }

   public Boolean getTeamStatus() {
      return this.teamStatus;
   }

   @JsonProperty("processId")
   public TeamSaveVORequest setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("factoryId")
   public TeamSaveVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public TeamSaveVORequest setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public TeamSaveVORequest setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("organizationType")
   public TeamSaveVORequest setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("hasMen")
   public TeamSaveVORequest setHasMen(final Boolean hasMen) {
      this.hasMen = hasMen;
      return this;
   }

   @JsonProperty("userLinks")
   public TeamSaveVORequest setUserLinks(final List<MesBuildingTeamUserLinkDTOParam> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @JsonProperty("teamStatus")
   public TeamSaveVORequest setTeamStatus(final Boolean teamStatus) {
      this.teamStatus = teamStatus;
      return this;
   }

   @Override
   public String toString() {
      return "TeamSaveVORequest(processId="
         + this.getProcessId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", organizationType="
         + this.getOrganizationType()
         + ", hasMen="
         + this.getHasMen()
         + ", userLinks="
         + this.getUserLinks()
         + ", teamStatus="
         + this.getTeamStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamSaveVORequest)) {
         return false;
      }

      TeamSaveVORequest other = (TeamSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processId = this.getProcessId();
      Object other$processId = other.getProcessId();
      if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$organizationType = this.getOrganizationType();
                  Object other$organizationType = other.getOrganizationType();
                  if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
                     Object this$hasMen = this.getHasMen();
                     Object other$hasMen = other.getHasMen();
                     if (this$hasMen == null ? other$hasMen == null : this$hasMen.equals(other$hasMen)) {
                        Object this$teamStatus = this.getTeamStatus();
                        Object other$teamStatus = other.getTeamStatus();
                        if (this$teamStatus == null ? other$teamStatus == null : this$teamStatus.equals(other$teamStatus)) {
                           Object this$userLinks = this.getUserLinks();
                           Object other$userLinks = other.getUserLinks();
                           return this$userLinks == null ? other$userLinks == null : this$userLinks.equals(other$userLinks);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TeamSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $hasMen = this.getHasMen();
      result = result * 59 + ($hasMen == null ? 43 : $hasMen.hashCode());
      Object $teamStatus = this.getTeamStatus();
      result = result * 59 + ($teamStatus == null ? 43 : $teamStatus.hashCode());
      Object $userLinks = this.getUserLinks();
      return result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
   }

   public static class TeamSaveVORequestBuilder {
      private Long processId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Boolean organizationType;
      private Boolean hasMen;
      private List<MesBuildingTeamUserLinkDTOParam> userLinks;
      private Boolean teamStatus;

      TeamSaveVORequestBuilder() {
      }

      @JsonProperty("processId")
      public TeamSaveVORequest.TeamSaveVORequestBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("factoryId")
      public TeamSaveVORequest.TeamSaveVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public TeamSaveVORequest.TeamSaveVORequestBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public TeamSaveVORequest.TeamSaveVORequestBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("organizationType")
      public TeamSaveVORequest.TeamSaveVORequestBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("hasMen")
      public TeamSaveVORequest.TeamSaveVORequestBuilder hasMen(final Boolean hasMen) {
         this.hasMen = hasMen;
         return this;
      }

      @JsonProperty("userLinks")
      public TeamSaveVORequest.TeamSaveVORequestBuilder userLinks(final List<MesBuildingTeamUserLinkDTOParam> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      @JsonProperty("teamStatus")
      public TeamSaveVORequest.TeamSaveVORequestBuilder teamStatus(final Boolean teamStatus) {
         this.teamStatus = teamStatus;
         return this;
      }

      public TeamSaveVORequest build() {
         return new TeamSaveVORequest(
            this.processId, this.factoryId, this.workshopId, this.productionLineId, this.organizationType, this.hasMen, this.userLinks, this.teamStatus
         );
      }

      @Override
      public String toString() {
         return "TeamSaveVORequest.TeamSaveVORequestBuilder(processId="
            + this.processId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", organizationType="
            + this.organizationType
            + ", hasMen="
            + this.hasMen
            + ", userLinks="
            + this.userLinks
            + ", teamStatus="
            + this.teamStatus
            + ")";
      }
   }
}
