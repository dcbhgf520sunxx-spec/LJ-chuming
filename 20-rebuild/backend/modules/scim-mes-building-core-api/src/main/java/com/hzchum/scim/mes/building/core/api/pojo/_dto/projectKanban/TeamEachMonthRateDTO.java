package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "WorkShopEachMonthRateDTO", description = "车间每月比率")
public class TeamEachMonthRateDTO {
   @ApiModelProperty(name = "date", value = "日期", notes = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "teamLeaderName", value = "班组长名", notes = "班组长名")
   @JsonProperty("teamLeaderName")
   @JSONField(name = "teamLeaderName")
   private String teamLeaderName;
   @ApiModelProperty(name = "taskQuantityWeight", value = "任务重量", notes = "任务重量")
   @JsonProperty("taskQuantityWeight")
   @JSONField(name = "taskQuantityWeight")
   private BigDecimal taskQuantityWeight;
   @ApiModelProperty(name = "totalCompleteWeight", value = "完成重量", notes = "完成重量")
   @JsonProperty("totalCompleteWeight")
   @JSONField(name = "totalCompleteWeight")
   private BigDecimal totalCompleteWeight;
   @ApiModelProperty(name = "rate", value = "占比(百分比)", notes = "占比(百分比)")
   @JsonProperty("rate")
   @JSONField(name = "rate")
   private BigDecimal rate;

   public String getDate() {
      return this.date;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public BigDecimal getTaskQuantityWeight() {
      return this.taskQuantityWeight;
   }

   public BigDecimal getTotalCompleteWeight() {
      return this.totalCompleteWeight;
   }

   public BigDecimal getRate() {
      return this.rate;
   }

   @JsonProperty("date")
   public TeamEachMonthRateDTO setDate(final String date) {
      this.date = date;
      return this;
   }

   @JsonProperty("teamId")
   public TeamEachMonthRateDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("teamLeaderName")
   public TeamEachMonthRateDTO setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   @JsonProperty("taskQuantityWeight")
   public TeamEachMonthRateDTO setTaskQuantityWeight(final BigDecimal taskQuantityWeight) {
      this.taskQuantityWeight = taskQuantityWeight;
      return this;
   }

   @JsonProperty("totalCompleteWeight")
   public TeamEachMonthRateDTO setTotalCompleteWeight(final BigDecimal totalCompleteWeight) {
      this.totalCompleteWeight = totalCompleteWeight;
      return this;
   }

   @JsonProperty("rate")
   public TeamEachMonthRateDTO setRate(final BigDecimal rate) {
      this.rate = rate;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamEachMonthRateDTO)) {
         return false;
      }

      TeamEachMonthRateDTO other = (TeamEachMonthRateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$teamId = this.getTeamId();
      Object other$teamId = other.getTeamId();
      if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
         Object this$date = this.getDate();
         Object other$date = other.getDate();
         if (this$date == null ? other$date == null : this$date.equals(other$date)) {
            Object this$teamLeaderName = this.getTeamLeaderName();
            Object other$teamLeaderName = other.getTeamLeaderName();
            if (this$teamLeaderName == null ? other$teamLeaderName == null : this$teamLeaderName.equals(other$teamLeaderName)) {
               Object this$taskQuantityWeight = this.getTaskQuantityWeight();
               Object other$taskQuantityWeight = other.getTaskQuantityWeight();
               if (this$taskQuantityWeight == null ? other$taskQuantityWeight == null : this$taskQuantityWeight.equals(other$taskQuantityWeight)) {
                  Object this$totalCompleteWeight = this.getTotalCompleteWeight();
                  Object other$totalCompleteWeight = other.getTotalCompleteWeight();
                  if (this$totalCompleteWeight == null ? other$totalCompleteWeight == null : this$totalCompleteWeight.equals(other$totalCompleteWeight)) {
                     Object this$rate = this.getRate();
                     Object other$rate = other.getRate();
                     return this$rate == null ? other$rate == null : this$rate.equals(other$rate);
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
      return other instanceof TeamEachMonthRateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      result = result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
      Object $taskQuantityWeight = this.getTaskQuantityWeight();
      result = result * 59 + ($taskQuantityWeight == null ? 43 : $taskQuantityWeight.hashCode());
      Object $totalCompleteWeight = this.getTotalCompleteWeight();
      result = result * 59 + ($totalCompleteWeight == null ? 43 : $totalCompleteWeight.hashCode());
      Object $rate = this.getRate();
      return result * 59 + ($rate == null ? 43 : $rate.hashCode());
   }

   @Override
   public String toString() {
      return "TeamEachMonthRateDTO(date="
         + this.getDate()
         + ", teamId="
         + this.getTeamId()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ", taskQuantityWeight="
         + this.getTaskQuantityWeight()
         + ", totalCompleteWeight="
         + this.getTotalCompleteWeight()
         + ", rate="
         + this.getRate()
         + ")";
   }
}
