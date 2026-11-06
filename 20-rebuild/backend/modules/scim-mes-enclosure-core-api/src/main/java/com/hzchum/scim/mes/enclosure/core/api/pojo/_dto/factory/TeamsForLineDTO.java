package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "TeamsForLineDTO", description = "产线下班组详情返回类")
public class TeamsForLineDTO {
   @ApiModelProperty(name = "lineId", value = "生产线ID", notes = "生产线ID")
   @JsonProperty("lineId")
   @JSONField(name = "lineId")
   private Long lineId;
   @ApiModelProperty(name = "lineName", value = "生产线名称", notes = "生产线名称")
   @JsonProperty("lineName")
   @JSONField(name = "lineName")
   private String lineName;
   @ApiModelProperty(name = "teams", value = "生产班组", notes = "生产班组")
   @JsonProperty("teams")
   @JSONField(name = "teams")
   private List<MesEnclosureTeamDTO> teams;
   @ApiModelProperty(name = "inspectionTeams", value = "质检班组", notes = "质检班组")
   @JsonProperty("inspectionTeams")
   @JSONField(name = "inspectionTeams")
   private List<MesEnclosureInspectionTeamDTO> inspectionTeams;

   public static TeamsForLineDTO.TeamsForLineDTOBuilder builder() {
      return new TeamsForLineDTO.TeamsForLineDTOBuilder();
   }

   public Long getLineId() {
      return this.lineId;
   }

   public String getLineName() {
      return this.lineName;
   }

   public List<MesEnclosureTeamDTO> getTeams() {
      return this.teams;
   }

   public List<MesEnclosureInspectionTeamDTO> getInspectionTeams() {
      return this.inspectionTeams;
   }

   @JsonProperty("lineId")
   public TeamsForLineDTO setLineId(final Long lineId) {
      this.lineId = lineId;
      return this;
   }

   @JsonProperty("lineName")
   public TeamsForLineDTO setLineName(final String lineName) {
      this.lineName = lineName;
      return this;
   }

   @JsonProperty("teams")
   public TeamsForLineDTO setTeams(final List<MesEnclosureTeamDTO> teams) {
      this.teams = teams;
      return this;
   }

   @JsonProperty("inspectionTeams")
   public TeamsForLineDTO setInspectionTeams(final List<MesEnclosureInspectionTeamDTO> inspectionTeams) {
      this.inspectionTeams = inspectionTeams;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamsForLineDTO)) {
         return false;
      }

      TeamsForLineDTO other = (TeamsForLineDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$lineId = this.getLineId();
      Object other$lineId = other.getLineId();
      if (this$lineId == null ? other$lineId == null : this$lineId.equals(other$lineId)) {
         Object this$lineName = this.getLineName();
         Object other$lineName = other.getLineName();
         if (this$lineName == null ? other$lineName == null : this$lineName.equals(other$lineName)) {
            Object this$teams = this.getTeams();
            Object other$teams = other.getTeams();
            if (this$teams == null ? other$teams == null : this$teams.equals(other$teams)) {
               Object this$inspectionTeams = this.getInspectionTeams();
               Object other$inspectionTeams = other.getInspectionTeams();
               return this$inspectionTeams == null ? other$inspectionTeams == null : this$inspectionTeams.equals(other$inspectionTeams);
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
      return other instanceof TeamsForLineDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $lineId = this.getLineId();
      result = result * 59 + ($lineId == null ? 43 : $lineId.hashCode());
      Object $lineName = this.getLineName();
      result = result * 59 + ($lineName == null ? 43 : $lineName.hashCode());
      Object $teams = this.getTeams();
      result = result * 59 + ($teams == null ? 43 : $teams.hashCode());
      Object $inspectionTeams = this.getInspectionTeams();
      return result * 59 + ($inspectionTeams == null ? 43 : $inspectionTeams.hashCode());
   }

   @Override
   public String toString() {
      return "TeamsForLineDTO(lineId="
         + this.getLineId()
         + ", lineName="
         + this.getLineName()
         + ", teams="
         + this.getTeams()
         + ", inspectionTeams="
         + this.getInspectionTeams()
         + ")";
   }

   public TeamsForLineDTO(
      final Long lineId, final String lineName, final List<MesEnclosureTeamDTO> teams, final List<MesEnclosureInspectionTeamDTO> inspectionTeams
   ) {
      this.lineId = lineId;
      this.lineName = lineName;
      this.teams = teams;
      this.inspectionTeams = inspectionTeams;
   }

   public TeamsForLineDTO() {
   }

   public static class TeamsForLineDTOBuilder {
      private Long lineId;
      private String lineName;
      private List<MesEnclosureTeamDTO> teams;
      private List<MesEnclosureInspectionTeamDTO> inspectionTeams;

      TeamsForLineDTOBuilder() {
      }

      @JsonProperty("lineId")
      public TeamsForLineDTO.TeamsForLineDTOBuilder lineId(final Long lineId) {
         this.lineId = lineId;
         return this;
      }

      @JsonProperty("lineName")
      public TeamsForLineDTO.TeamsForLineDTOBuilder lineName(final String lineName) {
         this.lineName = lineName;
         return this;
      }

      @JsonProperty("teams")
      public TeamsForLineDTO.TeamsForLineDTOBuilder teams(final List<MesEnclosureTeamDTO> teams) {
         this.teams = teams;
         return this;
      }

      @JsonProperty("inspectionTeams")
      public TeamsForLineDTO.TeamsForLineDTOBuilder inspectionTeams(final List<MesEnclosureInspectionTeamDTO> inspectionTeams) {
         this.inspectionTeams = inspectionTeams;
         return this;
      }

      public TeamsForLineDTO build() {
         return new TeamsForLineDTO(this.lineId, this.lineName, this.teams, this.inspectionTeams);
      }

      @Override
      public String toString() {
         return "TeamsForLineDTO.TeamsForLineDTOBuilder(lineId="
            + this.lineId
            + ", lineName="
            + this.lineName
            + ", teams="
            + this.teams
            + ", inspectionTeams="
            + this.inspectionTeams
            + ")";
      }
   }
}
