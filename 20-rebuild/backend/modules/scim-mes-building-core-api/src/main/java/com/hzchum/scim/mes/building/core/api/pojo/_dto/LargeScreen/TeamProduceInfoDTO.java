package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "班组")
public class TeamProduceInfoDTO {
   @ApiModelProperty(name = "teamName", value = "班组名称")
   @JsonProperty("teamName")
   @JSONField(name = "teamName")
   private String teamName;
   @ApiModelProperty(name = "processName", value = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "totalWeight", value = "总重")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "currentMonthWeight", value = "当前月重量")
   @JsonProperty("currentMonthWeight")
   @JSONField(name = "currentMonthWeight")
   private BigDecimal currentMonthWeight;
   @ApiModelProperty(name = "lastMonthWeight", value = "上个月重量")
   @JsonProperty("lastMonthWeight")
   @JSONField(name = "lastMonthWeight")
   private BigDecimal lastMonthWeight;
   @ApiModelProperty(name = "todayWeight", value = "今日产量")
   @JsonProperty("todayWeight")
   @JSONField(name = "todayWeight")
   private BigDecimal todayWeight;

   public static TeamProduceInfoDTO.TeamProduceInfoDTOBuilder builder() {
      return new TeamProduceInfoDTO.TeamProduceInfoDTOBuilder();
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getCurrentMonthWeight() {
      return this.currentMonthWeight;
   }

   public BigDecimal getLastMonthWeight() {
      return this.lastMonthWeight;
   }

   public BigDecimal getTodayWeight() {
      return this.todayWeight;
   }

   @JsonProperty("teamName")
   public void setTeamName(final String teamName) {
      this.teamName = teamName;
   }

   @JsonProperty("processName")
   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @JsonProperty("totalWeight")
   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   @JsonProperty("currentMonthWeight")
   public void setCurrentMonthWeight(final BigDecimal currentMonthWeight) {
      this.currentMonthWeight = currentMonthWeight;
   }

   @JsonProperty("lastMonthWeight")
   public void setLastMonthWeight(final BigDecimal lastMonthWeight) {
      this.lastMonthWeight = lastMonthWeight;
   }

   @JsonProperty("todayWeight")
   public void setTodayWeight(final BigDecimal todayWeight) {
      this.todayWeight = todayWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamProduceInfoDTO)) {
         return false;
      }

      TeamProduceInfoDTO other = (TeamProduceInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$teamName = this.getTeamName();
      Object other$teamName = other.getTeamName();
      if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
         Object this$processName = this.getProcessName();
         Object other$processName = other.getProcessName();
         if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
            Object this$totalWeight = this.getTotalWeight();
            Object other$totalWeight = other.getTotalWeight();
            if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
               Object this$currentMonthWeight = this.getCurrentMonthWeight();
               Object other$currentMonthWeight = other.getCurrentMonthWeight();
               if (this$currentMonthWeight == null ? other$currentMonthWeight == null : this$currentMonthWeight.equals(other$currentMonthWeight)) {
                  Object this$lastMonthWeight = this.getLastMonthWeight();
                  Object other$lastMonthWeight = other.getLastMonthWeight();
                  if (this$lastMonthWeight == null ? other$lastMonthWeight == null : this$lastMonthWeight.equals(other$lastMonthWeight)) {
                     Object this$todayWeight = this.getTodayWeight();
                     Object other$todayWeight = other.getTodayWeight();
                     return this$todayWeight == null ? other$todayWeight == null : this$todayWeight.equals(other$todayWeight);
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
      return other instanceof TeamProduceInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $currentMonthWeight = this.getCurrentMonthWeight();
      result = result * 59 + ($currentMonthWeight == null ? 43 : $currentMonthWeight.hashCode());
      Object $lastMonthWeight = this.getLastMonthWeight();
      result = result * 59 + ($lastMonthWeight == null ? 43 : $lastMonthWeight.hashCode());
      Object $todayWeight = this.getTodayWeight();
      return result * 59 + ($todayWeight == null ? 43 : $todayWeight.hashCode());
   }

   @Override
   public String toString() {
      return "TeamProduceInfoDTO(super="
         + super.toString()
         + ", teamName="
         + this.getTeamName()
         + ", processName="
         + this.getProcessName()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", currentMonthWeight="
         + this.getCurrentMonthWeight()
         + ", lastMonthWeight="
         + this.getLastMonthWeight()
         + ", todayWeight="
         + this.getTodayWeight()
         + ")";
   }

   public TeamProduceInfoDTO(
      final String teamName,
      final String processName,
      final BigDecimal totalWeight,
      final BigDecimal currentMonthWeight,
      final BigDecimal lastMonthWeight,
      final BigDecimal todayWeight
   ) {
      this.teamName = teamName;
      this.processName = processName;
      this.totalWeight = totalWeight;
      this.currentMonthWeight = currentMonthWeight;
      this.lastMonthWeight = lastMonthWeight;
      this.todayWeight = todayWeight;
   }

   public TeamProduceInfoDTO() {
   }

   public static class TeamProduceInfoDTOBuilder {
      private String teamName;
      private String processName;
      private BigDecimal totalWeight;
      private BigDecimal currentMonthWeight;
      private BigDecimal lastMonthWeight;
      private BigDecimal todayWeight;

      TeamProduceInfoDTOBuilder() {
      }

      @JsonProperty("teamName")
      public TeamProduceInfoDTO.TeamProduceInfoDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      @JsonProperty("processName")
      public TeamProduceInfoDTO.TeamProduceInfoDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("totalWeight")
      public TeamProduceInfoDTO.TeamProduceInfoDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("currentMonthWeight")
      public TeamProduceInfoDTO.TeamProduceInfoDTOBuilder currentMonthWeight(final BigDecimal currentMonthWeight) {
         this.currentMonthWeight = currentMonthWeight;
         return this;
      }

      @JsonProperty("lastMonthWeight")
      public TeamProduceInfoDTO.TeamProduceInfoDTOBuilder lastMonthWeight(final BigDecimal lastMonthWeight) {
         this.lastMonthWeight = lastMonthWeight;
         return this;
      }

      @JsonProperty("todayWeight")
      public TeamProduceInfoDTO.TeamProduceInfoDTOBuilder todayWeight(final BigDecimal todayWeight) {
         this.todayWeight = todayWeight;
         return this;
      }

      public TeamProduceInfoDTO build() {
         return new TeamProduceInfoDTO(this.teamName, this.processName, this.totalWeight, this.currentMonthWeight, this.lastMonthWeight, this.todayWeight);
      }

      @Override
      public String toString() {
         return "TeamProduceInfoDTO.TeamProduceInfoDTOBuilder(teamName="
            + this.teamName
            + ", processName="
            + this.processName
            + ", totalWeight="
            + this.totalWeight
            + ", currentMonthWeight="
            + this.currentMonthWeight
            + ", lastMonthWeight="
            + this.lastMonthWeight
            + ", todayWeight="
            + this.todayWeight
            + ")";
      }
   }
}
