package com.hzchum.scim.mes.building.core.api.pojo._dto.team;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;

@ApiModel(value = "TeamProduceProcessInfoDTO", description = "构件关联部件零件生产信息")
public class TeamProduceProcessInfoDTO {
   @ApiModelProperty(name = "teamId", value = "生产班组", notes = "生产班组")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20) default '0' COMMENT '生产组id'")
   private Long teamId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", value = "工序名称", notes = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "productionLineId", value = "产线id", notes = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", value = "产线名称", notes = "产线名称")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "teamLeaderName", value = "工序名称", notes = "工序名称")
   @JsonProperty("teamLeaderName")
   @JSONField(name = "teamLeaderName")
   private String teamLeaderName;
   @ApiModelProperty(name = "netWeightSum", value = "总重量", notes = "总重量")
   @JsonProperty("netWeightSum")
   @JSONField(name = "netWeightSum")
   private String netWeightSum;

   public static TeamProduceProcessInfoDTO.TeamProduceProcessInfoDTOBuilder builder() {
      return new TeamProduceProcessInfoDTO.TeamProduceProcessInfoDTOBuilder();
   }

   public TeamProduceProcessInfoDTO() {
   }

   public TeamProduceProcessInfoDTO(
      final Long teamId,
      final Long processId,
      final String processName,
      final Long productionLineId,
      final String productionLineName,
      final String teamLeaderName,
      final String netWeightSum
   ) {
      this.teamId = teamId;
      this.processId = processId;
      this.processName = processName;
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.teamLeaderName = teamLeaderName;
      this.netWeightSum = netWeightSum;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public String getNetWeightSum() {
      return this.netWeightSum;
   }

   @JsonProperty("teamId")
   public TeamProduceProcessInfoDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("processId")
   public TeamProduceProcessInfoDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public TeamProduceProcessInfoDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("productionLineId")
   public TeamProduceProcessInfoDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineName")
   public TeamProduceProcessInfoDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("teamLeaderName")
   public TeamProduceProcessInfoDTO setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   @JsonProperty("netWeightSum")
   public TeamProduceProcessInfoDTO setNetWeightSum(final String netWeightSum) {
      this.netWeightSum = netWeightSum;
      return this;
   }

   @Override
   public String toString() {
      return "TeamProduceProcessInfoDTO(teamId="
         + this.getTeamId()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ", netWeightSum="
         + this.getNetWeightSum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamProduceProcessInfoDTO)) {
         return false;
      }

      TeamProduceProcessInfoDTO other = (TeamProduceProcessInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$teamId = this.getTeamId();
      Object other$teamId = other.getTeamId();
      if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$productionLineId = this.getProductionLineId();
            Object other$productionLineId = other.getProductionLineId();
            if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
               Object this$processName = this.getProcessName();
               Object other$processName = other.getProcessName();
               if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                  Object this$productionLineName = this.getProductionLineName();
                  Object other$productionLineName = other.getProductionLineName();
                  if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
                     Object this$teamLeaderName = this.getTeamLeaderName();
                     Object other$teamLeaderName = other.getTeamLeaderName();
                     if (this$teamLeaderName == null ? other$teamLeaderName == null : this$teamLeaderName.equals(other$teamLeaderName)) {
                        Object this$netWeightSum = this.getNetWeightSum();
                        Object other$netWeightSum = other.getNetWeightSum();
                        return this$netWeightSum == null ? other$netWeightSum == null : this$netWeightSum.equals(other$netWeightSum);
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
      return other instanceof TeamProduceProcessInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      result = result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
      Object $netWeightSum = this.getNetWeightSum();
      return result * 59 + ($netWeightSum == null ? 43 : $netWeightSum.hashCode());
   }

   public static class TeamProduceProcessInfoDTOBuilder {
      private Long teamId;
      private Long processId;
      private String processName;
      private Long productionLineId;
      private String productionLineName;
      private String teamLeaderName;
      private String netWeightSum;

      TeamProduceProcessInfoDTOBuilder() {
      }

      @JsonProperty("teamId")
      public TeamProduceProcessInfoDTO.TeamProduceProcessInfoDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("processId")
      public TeamProduceProcessInfoDTO.TeamProduceProcessInfoDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public TeamProduceProcessInfoDTO.TeamProduceProcessInfoDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("productionLineId")
      public TeamProduceProcessInfoDTO.TeamProduceProcessInfoDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineName")
      public TeamProduceProcessInfoDTO.TeamProduceProcessInfoDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("teamLeaderName")
      public TeamProduceProcessInfoDTO.TeamProduceProcessInfoDTOBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      @JsonProperty("netWeightSum")
      public TeamProduceProcessInfoDTO.TeamProduceProcessInfoDTOBuilder netWeightSum(final String netWeightSum) {
         this.netWeightSum = netWeightSum;
         return this;
      }

      public TeamProduceProcessInfoDTO build() {
         return new TeamProduceProcessInfoDTO(
            this.teamId, this.processId, this.processName, this.productionLineId, this.productionLineName, this.teamLeaderName, this.netWeightSum
         );
      }

      @Override
      public String toString() {
         return "TeamProduceProcessInfoDTO.TeamProduceProcessInfoDTOBuilder(teamId="
            + this.teamId
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineName="
            + this.productionLineName
            + ", teamLeaderName="
            + this.teamLeaderName
            + ", netWeightSum="
            + this.netWeightSum
            + ")";
      }
   }
}
