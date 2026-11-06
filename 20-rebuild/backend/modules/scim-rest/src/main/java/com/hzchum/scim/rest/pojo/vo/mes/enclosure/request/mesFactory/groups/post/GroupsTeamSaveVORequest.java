package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.groups.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProductionLineSaveVORequest", description = "")
public class GroupsTeamSaveVORequest {
   @ApiModelProperty(name = "id", notes = "生产组id", value = "生产组id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "teamIds", notes = "班组id", value = "班组id")
   @JsonProperty("teamIds")
   @JSONField(name = "teamIds")
   private List<Long> teamIds;

   public static GroupsTeamSaveVORequest.GroupsTeamSaveVORequestBuilder builder() {
      return new GroupsTeamSaveVORequest.GroupsTeamSaveVORequestBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public List<Long> getTeamIds() {
      return this.teamIds;
   }

   @JsonProperty("id")
   public GroupsTeamSaveVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamIds")
   public GroupsTeamSaveVORequest setTeamIds(final List<Long> teamIds) {
      this.teamIds = teamIds;
      return this;
   }

   @Override
   public String toString() {
      return "GroupsTeamSaveVORequest(id=" + this.getId() + ", teamIds=" + this.getTeamIds() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof GroupsTeamSaveVORequest)) {
         return false;
      } else {
         GroupsTeamSaveVORequest other = (GroupsTeamSaveVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$teamIds = this.getTeamIds();
               Object other$teamIds = other.getTeamIds();
               return this$teamIds == null ? other$teamIds == null : this$teamIds.equals(other$teamIds);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof GroupsTeamSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamIds = this.getTeamIds();
      return result * 59 + ($teamIds == null ? 43 : $teamIds.hashCode());
   }

   public GroupsTeamSaveVORequest(final Long id, final List<Long> teamIds) {
      this.id = id;
      this.teamIds = teamIds;
   }

   public GroupsTeamSaveVORequest() {
   }

   public static class GroupsTeamSaveVORequestBuilder {
      private Long id;
      private List<Long> teamIds;

      GroupsTeamSaveVORequestBuilder() {
      }

      @JsonProperty("id")
      public GroupsTeamSaveVORequest.GroupsTeamSaveVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamIds")
      public GroupsTeamSaveVORequest.GroupsTeamSaveVORequestBuilder teamIds(final List<Long> teamIds) {
         this.teamIds = teamIds;
         return this;
      }

      public GroupsTeamSaveVORequest build() {
         return new GroupsTeamSaveVORequest(this.id, this.teamIds);
      }

      @Override
      public String toString() {
         return "GroupsTeamSaveVORequest.GroupsTeamSaveVORequestBuilder(id=" + this.id + ", teamIds=" + this.teamIds + ")";
      }
   }
}
