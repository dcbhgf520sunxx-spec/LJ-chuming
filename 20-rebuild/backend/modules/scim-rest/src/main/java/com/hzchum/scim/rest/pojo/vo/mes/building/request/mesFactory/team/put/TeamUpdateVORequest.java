package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.team.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingTeamUserLinkDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "TeamUpdateVORequest", description = "")
public class TeamUpdateVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @NotNull(message = "生产线id不能为空")
   private Long productionLineId;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]", value = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Boolean organizationType;
   @ApiModelProperty(name = "hasMen", value = "是否有组员0无，1有", notes = "是否有组员0无，1有")
   @JsonProperty("hasMen")
   @JSONField(name = "hasMen")
   private Boolean hasMen;
   @ApiModelProperty(name = "userLinks", notes = "班组人员", value = "班组人员")
   @JsonProperty("userLinks")
   @JSONField(name = "userLinks")
   private List<MesBuildingTeamUserLinkDTOParam> userLinks;
   @ApiModelProperty(name = "boolNestCutEnum", value = "切割方式", notes = "切割方式")
   private Boolean boolNestCutEnum;
   @ApiModelProperty("mes分类 1建刚 2桥梁")
   @JsonProperty("mesProductEnum")
   @JSONField(name = "mesProductEnum")
   private Integer mesProductEnum;

   public static TeamUpdateVORequest.TeamUpdateVORequestBuilder builder() {
      return new TeamUpdateVORequest.TeamUpdateVORequestBuilder();
   }

   public TeamUpdateVORequest() {
   }

   public TeamUpdateVORequest(
      final Long id,
      final Long processId,
      final Long workshopId,
      final Long productionLineId,
      final Boolean organizationType,
      final Boolean hasMen,
      final List<MesBuildingTeamUserLinkDTOParam> userLinks,
      final Boolean boolNestCutEnum,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.processId = processId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.organizationType = organizationType;
      this.hasMen = hasMen;
      this.userLinks = userLinks;
      this.boolNestCutEnum = boolNestCutEnum;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
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

   public Boolean getBoolNestCutEnum() {
      return this.boolNestCutEnum;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   @JsonProperty("id")
   public TeamUpdateVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public TeamUpdateVORequest setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("workshopId")
   public TeamUpdateVORequest setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public TeamUpdateVORequest setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("organizationType")
   public TeamUpdateVORequest setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("hasMen")
   public TeamUpdateVORequest setHasMen(final Boolean hasMen) {
      this.hasMen = hasMen;
      return this;
   }

   @JsonProperty("userLinks")
   public TeamUpdateVORequest setUserLinks(final List<MesBuildingTeamUserLinkDTOParam> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   public TeamUpdateVORequest setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
      return this;
   }

   @JsonProperty("mesProductEnum")
   public TeamUpdateVORequest setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "TeamUpdateVORequest(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
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
         + ", boolNestCutEnum="
         + this.getBoolNestCutEnum()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamUpdateVORequest)) {
         return false;
      }

      TeamUpdateVORequest other = (TeamUpdateVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
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
                        Object this$boolNestCutEnum = this.getBoolNestCutEnum();
                        Object other$boolNestCutEnum = other.getBoolNestCutEnum();
                        if (this$boolNestCutEnum == null ? other$boolNestCutEnum == null : this$boolNestCutEnum.equals(other$boolNestCutEnum)) {
                           Object this$mesProductEnum = this.getMesProductEnum();
                           Object other$mesProductEnum = other.getMesProductEnum();
                           if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TeamUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $hasMen = this.getHasMen();
      result = result * 59 + ($hasMen == null ? 43 : $hasMen.hashCode());
      Object $boolNestCutEnum = this.getBoolNestCutEnum();
      result = result * 59 + ($boolNestCutEnum == null ? 43 : $boolNestCutEnum.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $userLinks = this.getUserLinks();
      return result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
   }

   public static class TeamUpdateVORequestBuilder {
      private Long id;
      private Long processId;
      private Long workshopId;
      private Long productionLineId;
      private Boolean organizationType;
      private Boolean hasMen;
      private List<MesBuildingTeamUserLinkDTOParam> userLinks;
      private Boolean boolNestCutEnum;
      private Integer mesProductEnum;

      TeamUpdateVORequestBuilder() {
      }

      @JsonProperty("id")
      public TeamUpdateVORequest.TeamUpdateVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public TeamUpdateVORequest.TeamUpdateVORequestBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("workshopId")
      public TeamUpdateVORequest.TeamUpdateVORequestBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public TeamUpdateVORequest.TeamUpdateVORequestBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("organizationType")
      public TeamUpdateVORequest.TeamUpdateVORequestBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("hasMen")
      public TeamUpdateVORequest.TeamUpdateVORequestBuilder hasMen(final Boolean hasMen) {
         this.hasMen = hasMen;
         return this;
      }

      @JsonProperty("userLinks")
      public TeamUpdateVORequest.TeamUpdateVORequestBuilder userLinks(final List<MesBuildingTeamUserLinkDTOParam> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      public TeamUpdateVORequest.TeamUpdateVORequestBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      @JsonProperty("mesProductEnum")
      public TeamUpdateVORequest.TeamUpdateVORequestBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public TeamUpdateVORequest build() {
         return new TeamUpdateVORequest(
            this.id,
            this.processId,
            this.workshopId,
            this.productionLineId,
            this.organizationType,
            this.hasMen,
            this.userLinks,
            this.boolNestCutEnum,
            this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "TeamUpdateVORequest.TeamUpdateVORequestBuilder(id="
            + this.id
            + ", processId="
            + this.processId
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
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
