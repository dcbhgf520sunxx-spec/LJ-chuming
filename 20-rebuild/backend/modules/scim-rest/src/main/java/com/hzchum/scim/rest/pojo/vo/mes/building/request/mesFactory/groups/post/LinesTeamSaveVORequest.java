package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.groups.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProductionLineSaveVORequest", description = "")
public class LinesTeamSaveVORequest {
   @ApiModelProperty(name = "id", notes = "生产线id", value = "生产线id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "teamIds", notes = "班组id", value = "班组id")
   @JsonProperty("teamIds")
   @JSONField(name = "teamIds")
   private List<Long> teamIds;
   @ApiModelProperty(name = "teamType", value = "班组类型[0 班组 1 质检班组]", notes = "班组类型[0 班组 1 质检班组]")
   @JsonProperty("teamType")
   @JSONField(name = "teamType")
   private Boolean teamType;

   public static LinesTeamSaveVORequest.LinesTeamSaveVORequestBuilder builder() {
      return new LinesTeamSaveVORequest.LinesTeamSaveVORequestBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public List<Long> getTeamIds() {
      return this.teamIds;
   }

   public Boolean getTeamType() {
      return this.teamType;
   }

   @JsonProperty("id")
   public LinesTeamSaveVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamIds")
   public LinesTeamSaveVORequest setTeamIds(final List<Long> teamIds) {
      this.teamIds = teamIds;
      return this;
   }

   @JsonProperty("teamType")
   public LinesTeamSaveVORequest setTeamType(final Boolean teamType) {
      this.teamType = teamType;
      return this;
   }

   @Override
   public String toString() {
      return "LinesTeamSaveVORequest(id=" + this.getId() + ", teamIds=" + this.getTeamIds() + ", teamType=" + this.getTeamType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LinesTeamSaveVORequest)) {
         return false;
      }

      LinesTeamSaveVORequest other = (LinesTeamSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$teamType = this.getTeamType();
         Object other$teamType = other.getTeamType();
         if (this$teamType == null ? other$teamType == null : this$teamType.equals(other$teamType)) {
            Object this$teamIds = this.getTeamIds();
            Object other$teamIds = other.getTeamIds();
            return this$teamIds == null ? other$teamIds == null : this$teamIds.equals(other$teamIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof LinesTeamSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamType = this.getTeamType();
      result = result * 59 + ($teamType == null ? 43 : $teamType.hashCode());
      Object $teamIds = this.getTeamIds();
      return result * 59 + ($teamIds == null ? 43 : $teamIds.hashCode());
   }

   public LinesTeamSaveVORequest(final Long id, final List<Long> teamIds, final Boolean teamType) {
      this.id = id;
      this.teamIds = teamIds;
      this.teamType = teamType;
   }

   public LinesTeamSaveVORequest() {
   }

   public static class LinesTeamSaveVORequestBuilder {
      private Long id;
      private List<Long> teamIds;
      private Boolean teamType;

      LinesTeamSaveVORequestBuilder() {
      }

      @JsonProperty("id")
      public LinesTeamSaveVORequest.LinesTeamSaveVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamIds")
      public LinesTeamSaveVORequest.LinesTeamSaveVORequestBuilder teamIds(final List<Long> teamIds) {
         this.teamIds = teamIds;
         return this;
      }

      @JsonProperty("teamType")
      public LinesTeamSaveVORequest.LinesTeamSaveVORequestBuilder teamType(final Boolean teamType) {
         this.teamType = teamType;
         return this;
      }

      public LinesTeamSaveVORequest build() {
         return new LinesTeamSaveVORequest(this.id, this.teamIds, this.teamType);
      }

      @Override
      public String toString() {
         return "LinesTeamSaveVORequest.LinesTeamSaveVORequestBuilder(id=" + this.id + ", teamIds=" + this.teamIds + ", teamType=" + this.teamType + ")";
      }
   }
}
