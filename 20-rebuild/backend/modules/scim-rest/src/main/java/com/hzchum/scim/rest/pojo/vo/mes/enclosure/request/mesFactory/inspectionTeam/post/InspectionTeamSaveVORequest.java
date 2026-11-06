package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.inspectionTeam.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureInspectionTeamUserLinkDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "InspectionTeamSaveVORequest", description = "")
public class InspectionTeamSaveVORequest {
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @NotNull(message = "工厂id不能为空")
   private Long factoryId;
   @ApiModelProperty(name = "userLinks", notes = "质检人员", value = "质检人员")
   @JsonProperty("userLinks")
   @JSONField(name = "userLinks")
   private List<MesEnclosureInspectionTeamUserLinkDTOParam> userLinks;

   public static InspectionTeamSaveVORequest.InspectionTeamSaveVORequestBuilder builder() {
      return new InspectionTeamSaveVORequest.InspectionTeamSaveVORequestBuilder();
   }

   public InspectionTeamSaveVORequest() {
   }

   public InspectionTeamSaveVORequest(final Long factoryId, final List<MesEnclosureInspectionTeamUserLinkDTOParam> userLinks) {
      this.factoryId = factoryId;
      this.userLinks = userLinks;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public List<MesEnclosureInspectionTeamUserLinkDTOParam> getUserLinks() {
      return this.userLinks;
   }

   @JsonProperty("factoryId")
   public InspectionTeamSaveVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("userLinks")
   public InspectionTeamSaveVORequest setUserLinks(final List<MesEnclosureInspectionTeamUserLinkDTOParam> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @Override
   public String toString() {
      return "InspectionTeamSaveVORequest(factoryId=" + this.getFactoryId() + ", userLinks=" + this.getUserLinks() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof InspectionTeamSaveVORequest)) {
         return false;
      } else {
         InspectionTeamSaveVORequest other = (InspectionTeamSaveVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$userLinks = this.getUserLinks();
               Object other$userLinks = other.getUserLinks();
               return this$userLinks == null ? other$userLinks == null : this$userLinks.equals(other$userLinks);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InspectionTeamSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $userLinks = this.getUserLinks();
      return result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
   }

   public static class InspectionTeamSaveVORequestBuilder {
      private Long factoryId;
      private List<MesEnclosureInspectionTeamUserLinkDTOParam> userLinks;

      InspectionTeamSaveVORequestBuilder() {
      }

      @JsonProperty("factoryId")
      public InspectionTeamSaveVORequest.InspectionTeamSaveVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("userLinks")
      public InspectionTeamSaveVORequest.InspectionTeamSaveVORequestBuilder userLinks(final List<MesEnclosureInspectionTeamUserLinkDTOParam> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      public InspectionTeamSaveVORequest build() {
         return new InspectionTeamSaveVORequest(this.factoryId, this.userLinks);
      }

      @Override
      public String toString() {
         return "InspectionTeamSaveVORequest.InspectionTeamSaveVORequestBuilder(factoryId=" + this.factoryId + ", userLinks=" + this.userLinks + ")";
      }
   }
}
