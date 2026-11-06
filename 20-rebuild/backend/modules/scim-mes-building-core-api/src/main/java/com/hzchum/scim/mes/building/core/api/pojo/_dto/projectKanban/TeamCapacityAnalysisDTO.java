package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "TeamCapacityAnalysisDTO", description = "班组能力分析")
public class TeamCapacityAnalysisDTO {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
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
   @ApiModelProperty(name = "teamNumber", value = "组员数", notes = "组员数")
   @JsonProperty("teamNumber")
   @JSONField(name = "teamNumber")
   private Integer teamNumber;
   @ApiModelProperty(name = "eachMonthDTO", value = "每月班组产量", notes = "每月班组产量")
   @JsonProperty("eachMonthDTO")
   @JSONField(name = "eachMonthDTO")
   private List<TeamEachMonthRateDTO> eachMonthDTO;
   @ApiModelProperty(name = "totalWeight", value = "总重量", notes = "总重量")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "avgWeight", value = "月平均重量", notes = "月平均重量")
   @JsonProperty("avgWeight")
   @JSONField(name = "avgWeight")
   private BigDecimal avgWeight;

   public Long getId() {
      return this.id;
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

   public Integer getTeamNumber() {
      return this.teamNumber;
   }

   public List<TeamEachMonthRateDTO> getEachMonthDTO() {
      return this.eachMonthDTO;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getAvgWeight() {
      return this.avgWeight;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("workshop")
   public void setWorkshop(final IdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   @JsonProperty("process")
   public void setProcess(final IdAndNameDTO process) {
      this.process = process;
   }

   @JsonProperty("team")
   public void setTeam(final IdAndNameDTO team) {
      this.team = team;
   }

   @JsonProperty("teamNumber")
   public void setTeamNumber(final Integer teamNumber) {
      this.teamNumber = teamNumber;
   }

   @JsonProperty("eachMonthDTO")
   public void setEachMonthDTO(final List<TeamEachMonthRateDTO> eachMonthDTO) {
      this.eachMonthDTO = eachMonthDTO;
   }

   @JsonProperty("totalWeight")
   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   @JsonProperty("avgWeight")
   public void setAvgWeight(final BigDecimal avgWeight) {
      this.avgWeight = avgWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamCapacityAnalysisDTO)) {
         return false;
      }

      TeamCapacityAnalysisDTO other = (TeamCapacityAnalysisDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$teamNumber = this.getTeamNumber();
         Object other$teamNumber = other.getTeamNumber();
         if (this$teamNumber == null ? other$teamNumber == null : this$teamNumber.equals(other$teamNumber)) {
            Object this$workshop = this.getWorkshop();
            Object other$workshop = other.getWorkshop();
            if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
               Object this$process = this.getProcess();
               Object other$process = other.getProcess();
               if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                  Object this$team = this.getTeam();
                  Object other$team = other.getTeam();
                  if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                     Object this$eachMonthDTO = this.getEachMonthDTO();
                     Object other$eachMonthDTO = other.getEachMonthDTO();
                     if (this$eachMonthDTO == null ? other$eachMonthDTO == null : this$eachMonthDTO.equals(other$eachMonthDTO)) {
                        Object this$totalWeight = this.getTotalWeight();
                        Object other$totalWeight = other.getTotalWeight();
                        if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                           Object this$avgWeight = this.getAvgWeight();
                           Object other$avgWeight = other.getAvgWeight();
                           return this$avgWeight == null ? other$avgWeight == null : this$avgWeight.equals(other$avgWeight);
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
      return other instanceof TeamCapacityAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamNumber = this.getTeamNumber();
      result = result * 59 + ($teamNumber == null ? 43 : $teamNumber.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $eachMonthDTO = this.getEachMonthDTO();
      result = result * 59 + ($eachMonthDTO == null ? 43 : $eachMonthDTO.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $avgWeight = this.getAvgWeight();
      return result * 59 + ($avgWeight == null ? 43 : $avgWeight.hashCode());
   }

   @Override
   public String toString() {
      return "TeamCapacityAnalysisDTO(id="
         + this.getId()
         + ", workshop="
         + this.getWorkshop()
         + ", process="
         + this.getProcess()
         + ", team="
         + this.getTeam()
         + ", teamNumber="
         + this.getTeamNumber()
         + ", eachMonthDTO="
         + this.getEachMonthDTO()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", avgWeight="
         + this.getAvgWeight()
         + ")";
   }
}
