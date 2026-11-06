package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "TeamScheduledSummaryDTO", description = "总排产信息")
public class TeamScheduledSummaryDTO {
   @ApiModelProperty(name = "totalScheduledWeight", notes = "总排产量(吨)")
   @JsonProperty("totalScheduledWeight")
   @JSONField(name = "totalScheduledWeight")
   private BigDecimal totalScheduledWeight;
   @ApiModelProperty(name = "teamScheduledInfo", notes = "班组已排产信息")
   @JsonProperty("teamScheduledInfo")
   @JSONField(name = "teamScheduledInfo")
   private List<TeamScheduledInfoDTO> teamScheduledInfo;

   public static TeamScheduledSummaryDTO.TeamScheduledSummaryDTOBuilder builder() {
      return new TeamScheduledSummaryDTO.TeamScheduledSummaryDTOBuilder();
   }

   public TeamScheduledSummaryDTO() {
   }

   public TeamScheduledSummaryDTO(final BigDecimal totalScheduledWeight, final List<TeamScheduledInfoDTO> teamScheduledInfo) {
      this.totalScheduledWeight = totalScheduledWeight;
      this.teamScheduledInfo = teamScheduledInfo;
   }

   public BigDecimal getTotalScheduledWeight() {
      return this.totalScheduledWeight;
   }

   public List<TeamScheduledInfoDTO> getTeamScheduledInfo() {
      return this.teamScheduledInfo;
   }

   @JsonProperty("totalScheduledWeight")
   public TeamScheduledSummaryDTO setTotalScheduledWeight(final BigDecimal totalScheduledWeight) {
      this.totalScheduledWeight = totalScheduledWeight;
      return this;
   }

   @JsonProperty("teamScheduledInfo")
   public TeamScheduledSummaryDTO setTeamScheduledInfo(final List<TeamScheduledInfoDTO> teamScheduledInfo) {
      this.teamScheduledInfo = teamScheduledInfo;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TeamScheduledSummaryDTO)) {
         return false;
      } else {
         TeamScheduledSummaryDTO other = (TeamScheduledSummaryDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$totalScheduledWeight = this.getTotalScheduledWeight();
            Object other$totalScheduledWeight = other.getTotalScheduledWeight();
            if (this$totalScheduledWeight == null ? other$totalScheduledWeight == null : this$totalScheduledWeight.equals(other$totalScheduledWeight)) {
               Object this$teamScheduledInfo = this.getTeamScheduledInfo();
               Object other$teamScheduledInfo = other.getTeamScheduledInfo();
               return this$teamScheduledInfo == null ? other$teamScheduledInfo == null : this$teamScheduledInfo.equals(other$teamScheduledInfo);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TeamScheduledSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalScheduledWeight = this.getTotalScheduledWeight();
      result = result * 59 + ($totalScheduledWeight == null ? 43 : $totalScheduledWeight.hashCode());
      Object $teamScheduledInfo = this.getTeamScheduledInfo();
      return result * 59 + ($teamScheduledInfo == null ? 43 : $teamScheduledInfo.hashCode());
   }

   @Override
   public String toString() {
      return "TeamScheduledSummaryDTO(totalScheduledWeight=" + this.getTotalScheduledWeight() + ", teamScheduledInfo=" + this.getTeamScheduledInfo() + ")";
   }

   public static class TeamScheduledSummaryDTOBuilder {
      private BigDecimal totalScheduledWeight;
      private List<TeamScheduledInfoDTO> teamScheduledInfo;

      TeamScheduledSummaryDTOBuilder() {
      }

      @JsonProperty("totalScheduledWeight")
      public TeamScheduledSummaryDTO.TeamScheduledSummaryDTOBuilder totalScheduledWeight(final BigDecimal totalScheduledWeight) {
         this.totalScheduledWeight = totalScheduledWeight;
         return this;
      }

      @JsonProperty("teamScheduledInfo")
      public TeamScheduledSummaryDTO.TeamScheduledSummaryDTOBuilder teamScheduledInfo(final List<TeamScheduledInfoDTO> teamScheduledInfo) {
         this.teamScheduledInfo = teamScheduledInfo;
         return this;
      }

      public TeamScheduledSummaryDTO build() {
         return new TeamScheduledSummaryDTO(this.totalScheduledWeight, this.teamScheduledInfo);
      }

      @Override
      public String toString() {
         return "TeamScheduledSummaryDTO.TeamScheduledSummaryDTOBuilder(totalScheduledWeight="
            + this.totalScheduledWeight
            + ", teamScheduledInfo="
            + this.teamScheduledInfo
            + ")";
      }
   }
}
