package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingProductProcessLinkDOParam对象", description = "")
public class MesBuildingProductProcessLinkDTOParam {
   @ApiModelProperty(name = "id", notes = "工序id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "sequence", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   private Integer sequence;
   @ApiModelProperty(name = "partProdMode", value = "零件生产方式[1 数控切割 2 半自动切割]", notes = "零件生产方式[1 数控切割 2 半自动切割]")
   @JsonProperty("partProdMode")
   @JSONField(name = "partProdMode")
   private Integer partProdMode;
   @ApiModelProperty(name = "boolFixedProcess", value = "是否为固定工序[0 灵活工序 1 固定工序 ]", notes = "是否为固定工序[0 灵活工序 1 固定工序 ]")
   @JsonProperty("boolFixedProcess")
   @JSONField(name = "boolFixedProcess")
   private Boolean boolFixedProcess;
   @ApiModelProperty(name = "nodeTime", value = "时间节点", notes = "时间节点")
   @JsonProperty("nodeTime")
   @JSONField(name = "nodeTime")
   private Integer nodeTime;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @NotNull(message = "班组不能为空")
   private Long teamId;
   @ApiModelProperty(name = "teamLeaderName", value = "班组长名", notes = "班组长名")
   @JsonProperty("teamLeaderName")
   @JSONField(name = "teamLeaderName")
   private String teamLeaderName;
   @ApiModelProperty(name = "boolParallelProcess", value = "是否为并行工序[0 单工序 1 并行工序 ]", notes = "是否为并行工序[0 单工序 1 并行工序 ]")
   @JsonProperty("boolParallelProcess")
   @JSONField(name = "boolParallelProcess")
   private Boolean boolParallelProcess;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;

   public static MesBuildingProductProcessLinkDTOParam.MesBuildingProductProcessLinkDTOParamBuilder builder() {
      return new MesBuildingProductProcessLinkDTOParam.MesBuildingProductProcessLinkDTOParamBuilder();
   }

   public MesBuildingProductProcessLinkDTOParam() {
   }

   public MesBuildingProductProcessLinkDTOParam(
      final Long id,
      final Long processId,
      final Integer sequence,
      final Integer partProdMode,
      final Boolean boolFixedProcess,
      final Integer nodeTime,
      final Long teamId,
      final String teamLeaderName,
      final Boolean boolParallelProcess,
      final Long userId
   ) {
      this.id = id;
      this.processId = processId;
      this.sequence = sequence;
      this.partProdMode = partProdMode;
      this.boolFixedProcess = boolFixedProcess;
      this.nodeTime = nodeTime;
      this.teamId = teamId;
      this.teamLeaderName = teamLeaderName;
      this.boolParallelProcess = boolParallelProcess;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public Integer getPartProdMode() {
      return this.partProdMode;
   }

   public Boolean getBoolFixedProcess() {
      return this.boolFixedProcess;
   }

   public Integer getNodeTime() {
      return this.nodeTime;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public Boolean getBoolParallelProcess() {
      return this.boolParallelProcess;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesBuildingProductProcessLinkDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingProductProcessLinkDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingProductProcessLinkDTOParam setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("partProdMode")
   public MesBuildingProductProcessLinkDTOParam setPartProdMode(final Integer partProdMode) {
      this.partProdMode = partProdMode;
      return this;
   }

   @JsonProperty("boolFixedProcess")
   public MesBuildingProductProcessLinkDTOParam setBoolFixedProcess(final Boolean boolFixedProcess) {
      this.boolFixedProcess = boolFixedProcess;
      return this;
   }

   @JsonProperty("nodeTime")
   public MesBuildingProductProcessLinkDTOParam setNodeTime(final Integer nodeTime) {
      this.nodeTime = nodeTime;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingProductProcessLinkDTOParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("teamLeaderName")
   public MesBuildingProductProcessLinkDTOParam setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   @JsonProperty("boolParallelProcess")
   public MesBuildingProductProcessLinkDTOParam setBoolParallelProcess(final Boolean boolParallelProcess) {
      this.boolParallelProcess = boolParallelProcess;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProductProcessLinkDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductProcessLinkDTOParam(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", sequence="
         + this.getSequence()
         + ", partProdMode="
         + this.getPartProdMode()
         + ", boolFixedProcess="
         + this.getBoolFixedProcess()
         + ", nodeTime="
         + this.getNodeTime()
         + ", teamId="
         + this.getTeamId()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ", boolParallelProcess="
         + this.getBoolParallelProcess()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductProcessLinkDTOParam)) {
         return false;
      }

      MesBuildingProductProcessLinkDTOParam other = (MesBuildingProductProcessLinkDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$sequence = this.getSequence();
            Object other$sequence = other.getSequence();
            if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
               Object this$partProdMode = this.getPartProdMode();
               Object other$partProdMode = other.getPartProdMode();
               if (this$partProdMode == null ? other$partProdMode == null : this$partProdMode.equals(other$partProdMode)) {
                  Object this$boolFixedProcess = this.getBoolFixedProcess();
                  Object other$boolFixedProcess = other.getBoolFixedProcess();
                  if (this$boolFixedProcess == null ? other$boolFixedProcess == null : this$boolFixedProcess.equals(other$boolFixedProcess)) {
                     Object this$nodeTime = this.getNodeTime();
                     Object other$nodeTime = other.getNodeTime();
                     if (this$nodeTime == null ? other$nodeTime == null : this$nodeTime.equals(other$nodeTime)) {
                        Object this$teamId = this.getTeamId();
                        Object other$teamId = other.getTeamId();
                        if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                           Object this$boolParallelProcess = this.getBoolParallelProcess();
                           Object other$boolParallelProcess = other.getBoolParallelProcess();
                           if (this$boolParallelProcess == null
                              ? other$boolParallelProcess == null
                              : this$boolParallelProcess.equals(other$boolParallelProcess)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProductProcessLinkDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $partProdMode = this.getPartProdMode();
      result = result * 59 + ($partProdMode == null ? 43 : $partProdMode.hashCode());
      Object $boolFixedProcess = this.getBoolFixedProcess();
      result = result * 59 + ($boolFixedProcess == null ? 43 : $boolFixedProcess.hashCode());
      Object $nodeTime = this.getNodeTime();
      result = result * 59 + ($nodeTime == null ? 43 : $nodeTime.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $boolParallelProcess = this.getBoolParallelProcess();
      result = result * 59 + ($boolParallelProcess == null ? 43 : $boolParallelProcess.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      return result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
   }

   public static class MesBuildingProductProcessLinkDTOParamBuilder {
      private Long id;
      private Long processId;
      private Integer sequence;
      private Integer partProdMode;
      private Boolean boolFixedProcess;
      private Integer nodeTime;
      private Long teamId;
      private String teamLeaderName;
      private Boolean boolParallelProcess;
      private Long userId;

      MesBuildingProductProcessLinkDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductProcessLinkDTOParam.MesBuildingProductProcessLinkDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingProductProcessLinkDTOParam.MesBuildingProductProcessLinkDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingProductProcessLinkDTOParam.MesBuildingProductProcessLinkDTOParamBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("partProdMode")
      public MesBuildingProductProcessLinkDTOParam.MesBuildingProductProcessLinkDTOParamBuilder partProdMode(final Integer partProdMode) {
         this.partProdMode = partProdMode;
         return this;
      }

      @JsonProperty("boolFixedProcess")
      public MesBuildingProductProcessLinkDTOParam.MesBuildingProductProcessLinkDTOParamBuilder boolFixedProcess(final Boolean boolFixedProcess) {
         this.boolFixedProcess = boolFixedProcess;
         return this;
      }

      @JsonProperty("nodeTime")
      public MesBuildingProductProcessLinkDTOParam.MesBuildingProductProcessLinkDTOParamBuilder nodeTime(final Integer nodeTime) {
         this.nodeTime = nodeTime;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingProductProcessLinkDTOParam.MesBuildingProductProcessLinkDTOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("teamLeaderName")
      public MesBuildingProductProcessLinkDTOParam.MesBuildingProductProcessLinkDTOParamBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      @JsonProperty("boolParallelProcess")
      public MesBuildingProductProcessLinkDTOParam.MesBuildingProductProcessLinkDTOParamBuilder boolParallelProcess(final Boolean boolParallelProcess) {
         this.boolParallelProcess = boolParallelProcess;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProductProcessLinkDTOParam.MesBuildingProductProcessLinkDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingProductProcessLinkDTOParam build() {
         return new MesBuildingProductProcessLinkDTOParam(
            this.id,
            this.processId,
            this.sequence,
            this.partProdMode,
            this.boolFixedProcess,
            this.nodeTime,
            this.teamId,
            this.teamLeaderName,
            this.boolParallelProcess,
            this.userId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductProcessLinkDTOParam.MesBuildingProductProcessLinkDTOParamBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", sequence="
            + this.sequence
            + ", partProdMode="
            + this.partProdMode
            + ", boolFixedProcess="
            + this.boolFixedProcess
            + ", nodeTime="
            + this.nodeTime
            + ", teamId="
            + this.teamId
            + ", teamLeaderName="
            + this.teamLeaderName
            + ", boolParallelProcess="
            + this.boolParallelProcess
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
