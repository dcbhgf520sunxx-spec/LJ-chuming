package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesSimpleTeamDTO;
import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel(description = "班组质量问题排名")
public class TeamProduceRealtimeInfoDTO {
   private List<MesSimpleTeamDTO> teamNames;
   private List<TeamProjectProduceInfo> projectInfos;

   public static TeamProduceRealtimeInfoDTO.TeamProduceRealtimeInfoDTOBuilder builder() {
      return new TeamProduceRealtimeInfoDTO.TeamProduceRealtimeInfoDTOBuilder();
   }

   public List<MesSimpleTeamDTO> getTeamNames() {
      return this.teamNames;
   }

   public List<TeamProjectProduceInfo> getProjectInfos() {
      return this.projectInfos;
   }

   public void setTeamNames(final List<MesSimpleTeamDTO> teamNames) {
      this.teamNames = teamNames;
   }

   public void setProjectInfos(final List<TeamProjectProduceInfo> projectInfos) {
      this.projectInfos = projectInfos;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TeamProduceRealtimeInfoDTO)) {
         return false;
      } else {
         TeamProduceRealtimeInfoDTO other = (TeamProduceRealtimeInfoDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$teamNames = this.getTeamNames();
            Object other$teamNames = other.getTeamNames();
            if (this$teamNames == null ? other$teamNames == null : this$teamNames.equals(other$teamNames)) {
               Object this$projectInfos = this.getProjectInfos();
               Object other$projectInfos = other.getProjectInfos();
               return this$projectInfos == null ? other$projectInfos == null : this$projectInfos.equals(other$projectInfos);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TeamProduceRealtimeInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teamNames = this.getTeamNames();
      result = result * 59 + ($teamNames == null ? 43 : $teamNames.hashCode());
      Object $projectInfos = this.getProjectInfos();
      return result * 59 + ($projectInfos == null ? 43 : $projectInfos.hashCode());
   }

   @Override
   public String toString() {
      return "TeamProduceRealtimeInfoDTO(super=" + super.toString() + ", teamNames=" + this.getTeamNames() + ", projectInfos=" + this.getProjectInfos() + ")";
   }

   public TeamProduceRealtimeInfoDTO(final List<MesSimpleTeamDTO> teamNames, final List<TeamProjectProduceInfo> projectInfos) {
      this.teamNames = teamNames;
      this.projectInfos = projectInfos;
   }

   public TeamProduceRealtimeInfoDTO() {
   }

   public static class TeamProduceRealtimeInfoDTOBuilder {
      private List<MesSimpleTeamDTO> teamNames;
      private List<TeamProjectProduceInfo> projectInfos;

      TeamProduceRealtimeInfoDTOBuilder() {
      }

      public TeamProduceRealtimeInfoDTO.TeamProduceRealtimeInfoDTOBuilder teamNames(final List<MesSimpleTeamDTO> teamNames) {
         this.teamNames = teamNames;
         return this;
      }

      public TeamProduceRealtimeInfoDTO.TeamProduceRealtimeInfoDTOBuilder projectInfos(final List<TeamProjectProduceInfo> projectInfos) {
         this.projectInfos = projectInfos;
         return this;
      }

      public TeamProduceRealtimeInfoDTO build() {
         return new TeamProduceRealtimeInfoDTO(this.teamNames, this.projectInfos);
      }

      @Override
      public String toString() {
         return "TeamProduceRealtimeInfoDTO.TeamProduceRealtimeInfoDTOBuilder(teamNames=" + this.teamNames + ", projectInfos=" + this.projectInfos + ")";
      }
   }
}
