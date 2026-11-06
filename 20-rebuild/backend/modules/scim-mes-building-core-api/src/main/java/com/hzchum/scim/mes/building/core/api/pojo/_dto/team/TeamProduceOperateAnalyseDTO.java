package com.hzchum.scim.mes.building.core.api.pojo._dto.team;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "运营分析班组产量", description = "运营分析班组产量")
public class TeamProduceOperateAnalyseDTO {
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private IdAndNameDTO workshop;
   @ApiModelProperty(name = "process", value = "工序", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private IdAndNameDTO process;
   @ApiModelProperty(name = "team", value = "班组", notes = "班组")
   @JsonProperty("team")
   @JSONField(name = "team")
   private IdAndNameDTO team;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "totalWeight", value = "总重", notes = "总重")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "currentTotalWeight", value = "本月总重", notes = "本月总重")
   @JsonProperty("currentTotalWeight")
   @JSONField(name = "currentTotalWeight")
   private BigDecimal currentTotalWeight;
   @ApiModelProperty(name = "lastTotalWeight", value = "上月总重", notes = "上月总重")
   @JsonProperty("lastTotalWeight")
   @JSONField(name = "lastTotalWeight")
   private BigDecimal lastTotalWeight;

   public static TeamProduceOperateAnalyseDTO.TeamProduceOperateAnalyseDTOBuilder builder() {
      return new TeamProduceOperateAnalyseDTO.TeamProduceOperateAnalyseDTOBuilder();
   }

   public TeamProduceOperateAnalyseDTO() {
   }

   public TeamProduceOperateAnalyseDTO(
      final IdAndNameDTO workshop,
      final IdAndNameDTO process,
      final IdAndNameDTO team,
      final Integer taskTypeEnum,
      final BigDecimal totalWeight,
      final BigDecimal currentTotalWeight,
      final BigDecimal lastTotalWeight
   ) {
      this.workshop = workshop;
      this.process = process;
      this.team = team;
      this.taskTypeEnum = taskTypeEnum;
      this.totalWeight = totalWeight;
      this.currentTotalWeight = currentTotalWeight;
      this.lastTotalWeight = lastTotalWeight;
   }

   public IdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public IdAndNameDTO getProcess() {
      return this.process;
   }

   public IdAndNameDTO getTeam() {
      return this.team;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getCurrentTotalWeight() {
      return this.currentTotalWeight;
   }

   public BigDecimal getLastTotalWeight() {
      return this.lastTotalWeight;
   }

   @JsonProperty("workshop")
   public TeamProduceOperateAnalyseDTO setWorkshop(final IdAndNameDTO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("process")
   public TeamProduceOperateAnalyseDTO setProcess(final IdAndNameDTO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("team")
   public TeamProduceOperateAnalyseDTO setTeam(final IdAndNameDTO team) {
      this.team = team;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public TeamProduceOperateAnalyseDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("totalWeight")
   public TeamProduceOperateAnalyseDTO setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @JsonProperty("currentTotalWeight")
   public TeamProduceOperateAnalyseDTO setCurrentTotalWeight(final BigDecimal currentTotalWeight) {
      this.currentTotalWeight = currentTotalWeight;
      return this;
   }

   @JsonProperty("lastTotalWeight")
   public TeamProduceOperateAnalyseDTO setLastTotalWeight(final BigDecimal lastTotalWeight) {
      this.lastTotalWeight = lastTotalWeight;
      return this;
   }

   @Override
   public String toString() {
      return "TeamProduceOperateAnalyseDTO(workshop="
         + this.getWorkshop()
         + ", process="
         + this.getProcess()
         + ", team="
         + this.getTeam()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", currentTotalWeight="
         + this.getCurrentTotalWeight()
         + ", lastTotalWeight="
         + this.getLastTotalWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamProduceOperateAnalyseDTO)) {
         return false;
      }

      TeamProduceOperateAnalyseDTO other = (TeamProduceOperateAnalyseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskTypeEnum = this.getTaskTypeEnum();
      Object other$taskTypeEnum = other.getTaskTypeEnum();
      if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
         Object this$workshop = this.getWorkshop();
         Object other$workshop = other.getWorkshop();
         if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
            Object this$process = this.getProcess();
            Object other$process = other.getProcess();
            if (this$process == null ? other$process == null : this$process.equals(other$process)) {
               Object this$team = this.getTeam();
               Object other$team = other.getTeam();
               if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                  Object this$totalWeight = this.getTotalWeight();
                  Object other$totalWeight = other.getTotalWeight();
                  if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                     Object this$currentTotalWeight = this.getCurrentTotalWeight();
                     Object other$currentTotalWeight = other.getCurrentTotalWeight();
                     if (this$currentTotalWeight == null ? other$currentTotalWeight == null : this$currentTotalWeight.equals(other$currentTotalWeight)) {
                        Object this$lastTotalWeight = this.getLastTotalWeight();
                        Object other$lastTotalWeight = other.getLastTotalWeight();
                        return this$lastTotalWeight == null ? other$lastTotalWeight == null : this$lastTotalWeight.equals(other$lastTotalWeight);
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
      return other instanceof TeamProduceOperateAnalyseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $currentTotalWeight = this.getCurrentTotalWeight();
      result = result * 59 + ($currentTotalWeight == null ? 43 : $currentTotalWeight.hashCode());
      Object $lastTotalWeight = this.getLastTotalWeight();
      return result * 59 + ($lastTotalWeight == null ? 43 : $lastTotalWeight.hashCode());
   }

   public static class TeamProduceOperateAnalyseDTOBuilder {
      private IdAndNameDTO workshop;
      private IdAndNameDTO process;
      private IdAndNameDTO team;
      private Integer taskTypeEnum;
      private BigDecimal totalWeight;
      private BigDecimal currentTotalWeight;
      private BigDecimal lastTotalWeight;

      TeamProduceOperateAnalyseDTOBuilder() {
      }

      @JsonProperty("workshop")
      public TeamProduceOperateAnalyseDTO.TeamProduceOperateAnalyseDTOBuilder workshop(final IdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("process")
      public TeamProduceOperateAnalyseDTO.TeamProduceOperateAnalyseDTOBuilder process(final IdAndNameDTO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("team")
      public TeamProduceOperateAnalyseDTO.TeamProduceOperateAnalyseDTOBuilder team(final IdAndNameDTO team) {
         this.team = team;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public TeamProduceOperateAnalyseDTO.TeamProduceOperateAnalyseDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("totalWeight")
      public TeamProduceOperateAnalyseDTO.TeamProduceOperateAnalyseDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("currentTotalWeight")
      public TeamProduceOperateAnalyseDTO.TeamProduceOperateAnalyseDTOBuilder currentTotalWeight(final BigDecimal currentTotalWeight) {
         this.currentTotalWeight = currentTotalWeight;
         return this;
      }

      @JsonProperty("lastTotalWeight")
      public TeamProduceOperateAnalyseDTO.TeamProduceOperateAnalyseDTOBuilder lastTotalWeight(final BigDecimal lastTotalWeight) {
         this.lastTotalWeight = lastTotalWeight;
         return this;
      }

      public TeamProduceOperateAnalyseDTO build() {
         return new TeamProduceOperateAnalyseDTO(
            this.workshop, this.process, this.team, this.taskTypeEnum, this.totalWeight, this.currentTotalWeight, this.lastTotalWeight
         );
      }

      @Override
      public String toString() {
         return "TeamProduceOperateAnalyseDTO.TeamProduceOperateAnalyseDTOBuilder(workshop="
            + this.workshop
            + ", process="
            + this.process
            + ", team="
            + this.team
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", totalWeight="
            + this.totalWeight
            + ", currentTotalWeight="
            + this.currentTotalWeight
            + ", lastTotalWeight="
            + this.lastTotalWeight
            + ")";
      }
   }
}
