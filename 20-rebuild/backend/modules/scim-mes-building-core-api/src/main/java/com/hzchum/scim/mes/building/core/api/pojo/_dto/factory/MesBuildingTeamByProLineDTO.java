package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class MesBuildingTeamByProLineDTO {
   @ApiModelProperty(name = "teamList", value = "班组")
   List<MesBuildingTeam> teamList;
   @ApiModelProperty(name = "inspectionTeamList", value = "质检班组")
   List<MesBuildingInspectionTeam> inspectionTeamList;

   public static MesBuildingTeamByProLineDTO.MesBuildingTeamByProLineDTOBuilder builder() {
      return new MesBuildingTeamByProLineDTO.MesBuildingTeamByProLineDTOBuilder();
   }

   public MesBuildingTeamByProLineDTO() {
   }

   public MesBuildingTeamByProLineDTO(final List<MesBuildingTeam> teamList, final List<MesBuildingInspectionTeam> inspectionTeamList) {
      this.teamList = teamList;
      this.inspectionTeamList = inspectionTeamList;
   }

   public List<MesBuildingTeam> getTeamList() {
      return this.teamList;
   }

   public List<MesBuildingInspectionTeam> getInspectionTeamList() {
      return this.inspectionTeamList;
   }

   public MesBuildingTeamByProLineDTO setTeamList(final List<MesBuildingTeam> teamList) {
      this.teamList = teamList;
      return this;
   }

   public MesBuildingTeamByProLineDTO setInspectionTeamList(final List<MesBuildingInspectionTeam> inspectionTeamList) {
      this.inspectionTeamList = inspectionTeamList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTeamByProLineDTO(teamList=" + this.getTeamList() + ", inspectionTeamList=" + this.getInspectionTeamList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingTeamByProLineDTO)) {
         return false;
      } else {
         MesBuildingTeamByProLineDTO other = (MesBuildingTeamByProLineDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$teamList = this.getTeamList();
            Object other$teamList = other.getTeamList();
            if (this$teamList == null ? other$teamList == null : this$teamList.equals(other$teamList)) {
               Object this$inspectionTeamList = this.getInspectionTeamList();
               Object other$inspectionTeamList = other.getInspectionTeamList();
               return this$inspectionTeamList == null ? other$inspectionTeamList == null : this$inspectionTeamList.equals(other$inspectionTeamList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTeamByProLineDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teamList = this.getTeamList();
      result = result * 59 + ($teamList == null ? 43 : $teamList.hashCode());
      Object $inspectionTeamList = this.getInspectionTeamList();
      return result * 59 + ($inspectionTeamList == null ? 43 : $inspectionTeamList.hashCode());
   }

   public static class MesBuildingTeamByProLineDTOBuilder {
      private List<MesBuildingTeam> teamList;
      private List<MesBuildingInspectionTeam> inspectionTeamList;

      MesBuildingTeamByProLineDTOBuilder() {
      }

      public MesBuildingTeamByProLineDTO.MesBuildingTeamByProLineDTOBuilder teamList(final List<MesBuildingTeam> teamList) {
         this.teamList = teamList;
         return this;
      }

      public MesBuildingTeamByProLineDTO.MesBuildingTeamByProLineDTOBuilder inspectionTeamList(final List<MesBuildingInspectionTeam> inspectionTeamList) {
         this.inspectionTeamList = inspectionTeamList;
         return this;
      }

      public MesBuildingTeamByProLineDTO build() {
         return new MesBuildingTeamByProLineDTO(this.teamList, this.inspectionTeamList);
      }

      @Override
      public String toString() {
         return "MesBuildingTeamByProLineDTO.MesBuildingTeamByProLineDTOBuilder(teamList="
            + this.teamList
            + ", inspectionTeamList="
            + this.inspectionTeamList
            + ")";
      }
   }
}
