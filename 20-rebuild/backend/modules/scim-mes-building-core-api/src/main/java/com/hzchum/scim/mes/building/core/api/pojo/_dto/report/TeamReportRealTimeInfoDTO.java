package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TeamReportRealTimeInfoDTO", description = "班组上报实时信息")
public class TeamReportRealTimeInfoDTO {
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "shopName", notes = "车间")
   @JsonProperty("shopName")
   @JSONField(name = "shopName")
   private String shopName;
   @ApiModelProperty(name = "lineId", notes = "产线id")
   @JsonProperty("lineId")
   @JSONField(name = "lineId")
   private Long lineId;
   @ApiModelProperty(name = "lineName", notes = "产线")
   @JsonProperty("lineName")
   @JSONField(name = "lineName")
   private String lineName;
   @ApiModelProperty(name = "avgNetWeight", notes = "平均能力")
   @JsonProperty("avgNetWeight")
   @JSONField(name = "avgNetWeight")
   private BigDecimal avgNetWeight;
   @ApiModelProperty(name = "unTotalNetWeight", notes = "在手任务")
   @JsonProperty("unTotalNetWeight")
   @JSONField(name = "unTotalNetWeight")
   private BigDecimal unTotalNetWeight;
   @ApiModelProperty(name = "currentMonthScheduling", notes = "当月排产")
   @JsonProperty("currentMonthScheduling")
   @JSONField(name = "currentMonthScheduling")
   private BigDecimal currentMonthScheduling;
   @ApiModelProperty(name = "teamLeaderName", notes = "班组长名称")
   @JsonProperty("teamLeaderName")
   @JSONField(name = "teamLeaderName")
   private String teamLeaderName;

   public static TeamReportRealTimeInfoDTO.TeamReportRealTimeInfoDTOBuilder builder() {
      return new TeamReportRealTimeInfoDTO.TeamReportRealTimeInfoDTOBuilder();
   }

   public TeamReportRealTimeInfoDTO() {
   }

   public TeamReportRealTimeInfoDTO(
      final Long teamId,
      final String shopName,
      final Long lineId,
      final String lineName,
      final BigDecimal avgNetWeight,
      final BigDecimal unTotalNetWeight,
      final BigDecimal currentMonthScheduling,
      final String teamLeaderName
   ) {
      this.teamId = teamId;
      this.shopName = shopName;
      this.lineId = lineId;
      this.lineName = lineName;
      this.avgNetWeight = avgNetWeight;
      this.unTotalNetWeight = unTotalNetWeight;
      this.currentMonthScheduling = currentMonthScheduling;
      this.teamLeaderName = teamLeaderName;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getShopName() {
      return this.shopName;
   }

   public Long getLineId() {
      return this.lineId;
   }

   public String getLineName() {
      return this.lineName;
   }

   public BigDecimal getAvgNetWeight() {
      return this.avgNetWeight;
   }

   public BigDecimal getUnTotalNetWeight() {
      return this.unTotalNetWeight;
   }

   public BigDecimal getCurrentMonthScheduling() {
      return this.currentMonthScheduling;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   @JsonProperty("teamId")
   public TeamReportRealTimeInfoDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("shopName")
   public TeamReportRealTimeInfoDTO setShopName(final String shopName) {
      this.shopName = shopName;
      return this;
   }

   @JsonProperty("lineId")
   public TeamReportRealTimeInfoDTO setLineId(final Long lineId) {
      this.lineId = lineId;
      return this;
   }

   @JsonProperty("lineName")
   public TeamReportRealTimeInfoDTO setLineName(final String lineName) {
      this.lineName = lineName;
      return this;
   }

   @JsonProperty("avgNetWeight")
   public TeamReportRealTimeInfoDTO setAvgNetWeight(final BigDecimal avgNetWeight) {
      this.avgNetWeight = avgNetWeight;
      return this;
   }

   @JsonProperty("unTotalNetWeight")
   public TeamReportRealTimeInfoDTO setUnTotalNetWeight(final BigDecimal unTotalNetWeight) {
      this.unTotalNetWeight = unTotalNetWeight;
      return this;
   }

   @JsonProperty("currentMonthScheduling")
   public TeamReportRealTimeInfoDTO setCurrentMonthScheduling(final BigDecimal currentMonthScheduling) {
      this.currentMonthScheduling = currentMonthScheduling;
      return this;
   }

   @JsonProperty("teamLeaderName")
   public TeamReportRealTimeInfoDTO setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   @Override
   public String toString() {
      return "TeamReportRealTimeInfoDTO(teamId="
         + this.getTeamId()
         + ", shopName="
         + this.getShopName()
         + ", lineId="
         + this.getLineId()
         + ", lineName="
         + this.getLineName()
         + ", avgNetWeight="
         + this.getAvgNetWeight()
         + ", unTotalNetWeight="
         + this.getUnTotalNetWeight()
         + ", currentMonthScheduling="
         + this.getCurrentMonthScheduling()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamReportRealTimeInfoDTO)) {
         return false;
      }

      TeamReportRealTimeInfoDTO other = (TeamReportRealTimeInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$teamId = this.getTeamId();
      Object other$teamId = other.getTeamId();
      if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
         Object this$lineId = this.getLineId();
         Object other$lineId = other.getLineId();
         if (this$lineId == null ? other$lineId == null : this$lineId.equals(other$lineId)) {
            Object this$shopName = this.getShopName();
            Object other$shopName = other.getShopName();
            if (this$shopName == null ? other$shopName == null : this$shopName.equals(other$shopName)) {
               Object this$lineName = this.getLineName();
               Object other$lineName = other.getLineName();
               if (this$lineName == null ? other$lineName == null : this$lineName.equals(other$lineName)) {
                  Object this$avgNetWeight = this.getAvgNetWeight();
                  Object other$avgNetWeight = other.getAvgNetWeight();
                  if (this$avgNetWeight == null ? other$avgNetWeight == null : this$avgNetWeight.equals(other$avgNetWeight)) {
                     Object this$unTotalNetWeight = this.getUnTotalNetWeight();
                     Object other$unTotalNetWeight = other.getUnTotalNetWeight();
                     if (this$unTotalNetWeight == null ? other$unTotalNetWeight == null : this$unTotalNetWeight.equals(other$unTotalNetWeight)) {
                        Object this$currentMonthScheduling = this.getCurrentMonthScheduling();
                        Object other$currentMonthScheduling = other.getCurrentMonthScheduling();
                        if (this$currentMonthScheduling == null
                           ? other$currentMonthScheduling == null
                           : this$currentMonthScheduling.equals(other$currentMonthScheduling)) {
                           Object this$teamLeaderName = this.getTeamLeaderName();
                           Object other$teamLeaderName = other.getTeamLeaderName();
                           return this$teamLeaderName == null ? other$teamLeaderName == null : this$teamLeaderName.equals(other$teamLeaderName);
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
      return other instanceof TeamReportRealTimeInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $lineId = this.getLineId();
      result = result * 59 + ($lineId == null ? 43 : $lineId.hashCode());
      Object $shopName = this.getShopName();
      result = result * 59 + ($shopName == null ? 43 : $shopName.hashCode());
      Object $lineName = this.getLineName();
      result = result * 59 + ($lineName == null ? 43 : $lineName.hashCode());
      Object $avgNetWeight = this.getAvgNetWeight();
      result = result * 59 + ($avgNetWeight == null ? 43 : $avgNetWeight.hashCode());
      Object $unTotalNetWeight = this.getUnTotalNetWeight();
      result = result * 59 + ($unTotalNetWeight == null ? 43 : $unTotalNetWeight.hashCode());
      Object $currentMonthScheduling = this.getCurrentMonthScheduling();
      result = result * 59 + ($currentMonthScheduling == null ? 43 : $currentMonthScheduling.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      return result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
   }

   public static class TeamReportRealTimeInfoDTOBuilder {
      private Long teamId;
      private String shopName;
      private Long lineId;
      private String lineName;
      private BigDecimal avgNetWeight;
      private BigDecimal unTotalNetWeight;
      private BigDecimal currentMonthScheduling;
      private String teamLeaderName;

      TeamReportRealTimeInfoDTOBuilder() {
      }

      @JsonProperty("teamId")
      public TeamReportRealTimeInfoDTO.TeamReportRealTimeInfoDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("shopName")
      public TeamReportRealTimeInfoDTO.TeamReportRealTimeInfoDTOBuilder shopName(final String shopName) {
         this.shopName = shopName;
         return this;
      }

      @JsonProperty("lineId")
      public TeamReportRealTimeInfoDTO.TeamReportRealTimeInfoDTOBuilder lineId(final Long lineId) {
         this.lineId = lineId;
         return this;
      }

      @JsonProperty("lineName")
      public TeamReportRealTimeInfoDTO.TeamReportRealTimeInfoDTOBuilder lineName(final String lineName) {
         this.lineName = lineName;
         return this;
      }

      @JsonProperty("avgNetWeight")
      public TeamReportRealTimeInfoDTO.TeamReportRealTimeInfoDTOBuilder avgNetWeight(final BigDecimal avgNetWeight) {
         this.avgNetWeight = avgNetWeight;
         return this;
      }

      @JsonProperty("unTotalNetWeight")
      public TeamReportRealTimeInfoDTO.TeamReportRealTimeInfoDTOBuilder unTotalNetWeight(final BigDecimal unTotalNetWeight) {
         this.unTotalNetWeight = unTotalNetWeight;
         return this;
      }

      @JsonProperty("currentMonthScheduling")
      public TeamReportRealTimeInfoDTO.TeamReportRealTimeInfoDTOBuilder currentMonthScheduling(final BigDecimal currentMonthScheduling) {
         this.currentMonthScheduling = currentMonthScheduling;
         return this;
      }

      @JsonProperty("teamLeaderName")
      public TeamReportRealTimeInfoDTO.TeamReportRealTimeInfoDTOBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      public TeamReportRealTimeInfoDTO build() {
         return new TeamReportRealTimeInfoDTO(
            this.teamId, this.shopName, this.lineId, this.lineName, this.avgNetWeight, this.unTotalNetWeight, this.currentMonthScheduling, this.teamLeaderName
         );
      }

      @Override
      public String toString() {
         return "TeamReportRealTimeInfoDTO.TeamReportRealTimeInfoDTOBuilder(teamId="
            + this.teamId
            + ", shopName="
            + this.shopName
            + ", lineId="
            + this.lineId
            + ", lineName="
            + this.lineName
            + ", avgNetWeight="
            + this.avgNetWeight
            + ", unTotalNetWeight="
            + this.unTotalNetWeight
            + ", currentMonthScheduling="
            + this.currentMonthScheduling
            + ", teamLeaderName="
            + this.teamLeaderName
            + ")";
      }
   }
}
