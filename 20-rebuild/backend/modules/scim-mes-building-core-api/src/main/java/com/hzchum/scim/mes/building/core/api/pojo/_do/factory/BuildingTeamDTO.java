package com.hzchum.scim.mes.building.core.api.pojo._do.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class BuildingTeamDTO {
   @ApiModelProperty(name = "id", value = "班组id", notes = "班组id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "leaderName", value = "组长名称", notes = "组长名称")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "leaderId", value = "组长id", notes = "组长id")
   @JsonProperty("leaderId")
   @JSONField(name = "leaderId")
   private Long leaderId;

   public static BuildingTeamDTO.BuildingTeamDTOBuilder builder() {
      return new BuildingTeamDTO.BuildingTeamDTOBuilder();
   }

   public BuildingTeamDTO() {
   }

   public BuildingTeamDTO(final Long id, final String leaderName, final Long leaderId) {
      this.id = id;
      this.leaderName = leaderName;
      this.leaderId = leaderId;
   }

   public Long getId() {
      return this.id;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public Long getLeaderId() {
      return this.leaderId;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("leaderName")
   public void setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
   }

   @JsonProperty("leaderId")
   public void setLeaderId(final Long leaderId) {
      this.leaderId = leaderId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BuildingTeamDTO)) {
         return false;
      }

      BuildingTeamDTO other = (BuildingTeamDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$leaderId = this.getLeaderId();
         Object other$leaderId = other.getLeaderId();
         if (this$leaderId == null ? other$leaderId == null : this$leaderId.equals(other$leaderId)) {
            Object this$leaderName = this.getLeaderName();
            Object other$leaderName = other.getLeaderName();
            return this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BuildingTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $leaderId = this.getLeaderId();
      result = result * 59 + ($leaderId == null ? 43 : $leaderId.hashCode());
      Object $leaderName = this.getLeaderName();
      return result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
   }

   @Override
   public String toString() {
      return "BuildingTeamDTO(id=" + this.getId() + ", leaderName=" + this.getLeaderName() + ", leaderId=" + this.getLeaderId() + ")";
   }

   public static class BuildingTeamDTOBuilder {
      private Long id;
      private String leaderName;
      private Long leaderId;

      BuildingTeamDTOBuilder() {
      }

      @JsonProperty("id")
      public BuildingTeamDTO.BuildingTeamDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("leaderName")
      public BuildingTeamDTO.BuildingTeamDTOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("leaderId")
      public BuildingTeamDTO.BuildingTeamDTOBuilder leaderId(final Long leaderId) {
         this.leaderId = leaderId;
         return this;
      }

      public BuildingTeamDTO build() {
         return new BuildingTeamDTO(this.id, this.leaderName, this.leaderId);
      }

      @Override
      public String toString() {
         return "BuildingTeamDTO.BuildingTeamDTOBuilder(id=" + this.id + ", leaderName=" + this.leaderName + ", leaderId=" + this.leaderId + ")";
      }
   }
}
