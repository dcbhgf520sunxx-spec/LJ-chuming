package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesProcessTeamProductionLineListDTO", description = "")
public class MesProcessTeamProductionLineListDTO {
   @ApiModelProperty(name = "lineId", notes = "产线Id")
   @JsonProperty("lineId")
   @JSONField(name = "lineId")
   private Long lineId;
   @ApiModelProperty(name = "lineName", notes = "产线名称")
   @JsonProperty("lineName")
   @JSONField(name = "lineName")
   private String productionLineName;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "teamId", notes = "班组Id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名", value = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "leaderName", notes = "班组长名称", value = "班组长名称")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "type", notes = "工序类型[压板、钻孔..]", value = "工序类型[压板、钻孔..]")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;

   public static MesProcessTeamProductionLineListDTO.MesProcessTeamProductionLineListDTOBuilder builder() {
      return new MesProcessTeamProductionLineListDTO.MesProcessTeamProductionLineListDTOBuilder();
   }

   public MesProcessTeamProductionLineListDTO() {
   }

   public MesProcessTeamProductionLineListDTO(
      final Long lineId,
      final String productionLineName,
      final Integer taskTypeEnum,
      final Long workshopId,
      final Long teamId,
      final Long processId,
      final String processName,
      final String leaderName,
      final Integer type
   ) {
      this.lineId = lineId;
      this.productionLineName = productionLineName;
      this.taskTypeEnum = taskTypeEnum;
      this.workshopId = workshopId;
      this.teamId = teamId;
      this.processId = processId;
      this.processName = processName;
      this.leaderName = leaderName;
      this.type = type;
   }

   public Long getLineId() {
      return this.lineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Long getWorkshopId() {
      return this.workshopId;
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

   public String getLeaderName() {
      return this.leaderName;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("lineId")
   public MesProcessTeamProductionLineListDTO setLineId(final Long lineId) {
      this.lineId = lineId;
      return this;
   }

   @JsonProperty("lineName")
   public MesProcessTeamProductionLineListDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesProcessTeamProductionLineListDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("workshopId")
   public MesProcessTeamProductionLineListDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("teamId")
   public MesProcessTeamProductionLineListDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("processId")
   public MesProcessTeamProductionLineListDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public MesProcessTeamProductionLineListDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("leaderName")
   public MesProcessTeamProductionLineListDTO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @JsonProperty("type")
   public MesProcessTeamProductionLineListDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "MesProcessTeamProductionLineListDTO(lineId="
         + this.getLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", workshopId="
         + this.getWorkshopId()
         + ", teamId="
         + this.getTeamId()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", leaderName="
         + this.getLeaderName()
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProcessTeamProductionLineListDTO)) {
         return false;
      }

      MesProcessTeamProductionLineListDTO other = (MesProcessTeamProductionLineListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$lineId = this.getLineId();
      Object other$lineId = other.getLineId();
      if (this$lineId == null ? other$lineId == null : this$lineId.equals(other$lineId)) {
         Object this$taskTypeEnum = this.getTaskTypeEnum();
         Object other$taskTypeEnum = other.getTaskTypeEnum();
         if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$type = this.getType();
                     Object other$type = other.getType();
                     if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                        Object this$productionLineName = this.getProductionLineName();
                        Object other$productionLineName = other.getProductionLineName();
                        if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
                           Object this$processName = this.getProcessName();
                           Object other$processName = other.getProcessName();
                           if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                              Object this$leaderName = this.getLeaderName();
                              Object other$leaderName = other.getLeaderName();
                              return this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesProcessTeamProductionLineListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $lineId = this.getLineId();
      result = result * 59 + ($lineId == null ? 43 : $lineId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $leaderName = this.getLeaderName();
      return result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
   }

   public static class MesProcessTeamProductionLineListDTOBuilder {
      private Long lineId;
      private String productionLineName;
      private Integer taskTypeEnum;
      private Long workshopId;
      private Long teamId;
      private Long processId;
      private String processName;
      private String leaderName;
      private Integer type;

      MesProcessTeamProductionLineListDTOBuilder() {
      }

      @JsonProperty("lineId")
      public MesProcessTeamProductionLineListDTO.MesProcessTeamProductionLineListDTOBuilder lineId(final Long lineId) {
         this.lineId = lineId;
         return this;
      }

      @JsonProperty("lineName")
      public MesProcessTeamProductionLineListDTO.MesProcessTeamProductionLineListDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesProcessTeamProductionLineListDTO.MesProcessTeamProductionLineListDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("workshopId")
      public MesProcessTeamProductionLineListDTO.MesProcessTeamProductionLineListDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("teamId")
      public MesProcessTeamProductionLineListDTO.MesProcessTeamProductionLineListDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("processId")
      public MesProcessTeamProductionLineListDTO.MesProcessTeamProductionLineListDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public MesProcessTeamProductionLineListDTO.MesProcessTeamProductionLineListDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("leaderName")
      public MesProcessTeamProductionLineListDTO.MesProcessTeamProductionLineListDTOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      @JsonProperty("type")
      public MesProcessTeamProductionLineListDTO.MesProcessTeamProductionLineListDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MesProcessTeamProductionLineListDTO build() {
         return new MesProcessTeamProductionLineListDTO(
            this.lineId, this.productionLineName, this.taskTypeEnum, this.workshopId, this.teamId, this.processId, this.processName, this.leaderName, this.type
         );
      }

      @Override
      public String toString() {
         return "MesProcessTeamProductionLineListDTO.MesProcessTeamProductionLineListDTOBuilder(lineId="
            + this.lineId
            + ", productionLineName="
            + this.productionLineName
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", workshopId="
            + this.workshopId
            + ", teamId="
            + this.teamId
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", leaderName="
            + this.leaderName
            + ", type="
            + this.type
            + ")";
      }
   }
}
