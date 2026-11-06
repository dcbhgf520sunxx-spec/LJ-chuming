package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "TeamTaskCompleteRateDTO", description = "班组任务达成率分析")
public class TeamTaskCompleteRateDTO {
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "teamLeaderName", value = "班组长名", notes = "班组长名")
   @JsonProperty("teamLeaderName")
   @JSONField(name = "teamLeaderName")
   private String teamLeaderName;
   @ApiModelProperty(name = "avgRate", value = "平均占比(百分比)", notes = "平均占比(百分比)")
   @JsonProperty("avgRate")
   @JSONField(name = "avgRate")
   private BigDecimal avgRate;
   @ApiModelProperty(name = "monthRateList", value = "日期比率", notes = "日期比率")
   @JsonProperty("monthRateList")
   @JSONField(name = "monthRateList")
   private List<TeamEachMonthRateDTO> monthRateList;

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public BigDecimal getAvgRate() {
      return this.avgRate;
   }

   public List<TeamEachMonthRateDTO> getMonthRateList() {
      return this.monthRateList;
   }

   @JsonProperty("teamId")
   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   @JsonProperty("teamLeaderName")
   public void setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
   }

   @JsonProperty("avgRate")
   public void setAvgRate(final BigDecimal avgRate) {
      this.avgRate = avgRate;
   }

   @JsonProperty("monthRateList")
   public void setMonthRateList(final List<TeamEachMonthRateDTO> monthRateList) {
      this.monthRateList = monthRateList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamTaskCompleteRateDTO)) {
         return false;
      }

      TeamTaskCompleteRateDTO other = (TeamTaskCompleteRateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$teamId = this.getTeamId();
      Object other$teamId = other.getTeamId();
      if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
         Object this$teamLeaderName = this.getTeamLeaderName();
         Object other$teamLeaderName = other.getTeamLeaderName();
         if (this$teamLeaderName == null ? other$teamLeaderName == null : this$teamLeaderName.equals(other$teamLeaderName)) {
            Object this$avgRate = this.getAvgRate();
            Object other$avgRate = other.getAvgRate();
            if (this$avgRate == null ? other$avgRate == null : this$avgRate.equals(other$avgRate)) {
               Object this$monthRateList = this.getMonthRateList();
               Object other$monthRateList = other.getMonthRateList();
               return this$monthRateList == null ? other$monthRateList == null : this$monthRateList.equals(other$monthRateList);
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
      return other instanceof TeamTaskCompleteRateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      result = result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
      Object $avgRate = this.getAvgRate();
      result = result * 59 + ($avgRate == null ? 43 : $avgRate.hashCode());
      Object $monthRateList = this.getMonthRateList();
      return result * 59 + ($monthRateList == null ? 43 : $monthRateList.hashCode());
   }

   @Override
   public String toString() {
      return "TeamTaskCompleteRateDTO(teamId="
         + this.getTeamId()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ", avgRate="
         + this.getAvgRate()
         + ", monthRateList="
         + this.getMonthRateList()
         + ")";
   }
}
