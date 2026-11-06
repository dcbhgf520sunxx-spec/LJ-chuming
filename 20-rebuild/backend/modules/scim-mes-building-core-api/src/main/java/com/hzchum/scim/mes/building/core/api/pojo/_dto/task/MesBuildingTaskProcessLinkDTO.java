package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;

@ApiModel(value = "MesBuildingTaskProcessLinkDTO", description = "产类型关联工序详情返回类 ")
public class MesBuildingTaskProcessLinkDTO {
   @ApiModelProperty(name = "productProcessId", notes = "产品工序关联关系表id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   private Long productProcessId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "sequence", value = "工序顺序", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   private Integer sequence;
   @ApiModelProperty(name = "boolParallelProcess", value = "是否为并行工序[0 单工序 1 并行工序 ]", notes = "是否为并行工序[0 单工序 1 并行工序 ]")
   @JsonProperty("boolParallelProcess")
   @JSONField(name = "boolParallelProcess")
   private Boolean boolParallelProcess;
   @ApiModelProperty(name = "nodeTime", value = "时间节点", notes = "时间节点")
   @JsonProperty("nodeTime")
   @JSONField(name = "nodeTime")
   private Integer nodeTime;
   @ApiModelProperty(name = "type", value = "工序类型", notes = "工序类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "productType", value = "产品类型 [0 零件,1  构件,2  围护]", notes = "产品类型 [0 零件,1  构件,2  围护]")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = false)
   private Long teamId;

   public static MesBuildingTaskProcessLinkDTO.MesBuildingTaskProcessLinkDTOBuilder builder() {
      return new MesBuildingTaskProcessLinkDTO.MesBuildingTaskProcessLinkDTOBuilder();
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public Boolean getBoolParallelProcess() {
      return this.boolParallelProcess;
   }

   public Integer getNodeTime() {
      return this.nodeTime;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   @JsonProperty("productProcessId")
   public MesBuildingTaskProcessLinkDTO setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingTaskProcessLinkDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingTaskProcessLinkDTO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("boolParallelProcess")
   public MesBuildingTaskProcessLinkDTO setBoolParallelProcess(final Boolean boolParallelProcess) {
      this.boolParallelProcess = boolParallelProcess;
      return this;
   }

   @JsonProperty("nodeTime")
   public MesBuildingTaskProcessLinkDTO setNodeTime(final Integer nodeTime) {
      this.nodeTime = nodeTime;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingTaskProcessLinkDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingTaskProcessLinkDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingTaskProcessLinkDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskProcessLinkDTO)) {
         return false;
      }

      MesBuildingTaskProcessLinkDTO other = (MesBuildingTaskProcessLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productProcessId = this.getProductProcessId();
      Object other$productProcessId = other.getProductProcessId();
      if (this$productProcessId == null ? other$productProcessId == null : this$productProcessId.equals(other$productProcessId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$sequence = this.getSequence();
            Object other$sequence = other.getSequence();
            if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
               Object this$boolParallelProcess = this.getBoolParallelProcess();
               Object other$boolParallelProcess = other.getBoolParallelProcess();
               if (this$boolParallelProcess == null ? other$boolParallelProcess == null : this$boolParallelProcess.equals(other$boolParallelProcess)) {
                  Object this$nodeTime = this.getNodeTime();
                  Object other$nodeTime = other.getNodeTime();
                  if (this$nodeTime == null ? other$nodeTime == null : this$nodeTime.equals(other$nodeTime)) {
                     Object this$type = this.getType();
                     Object other$type = other.getType();
                     if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$teamId = this.getTeamId();
                           Object other$teamId = other.getTeamId();
                           return this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId);
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
      return other instanceof MesBuildingTaskProcessLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $boolParallelProcess = this.getBoolParallelProcess();
      result = result * 59 + ($boolParallelProcess == null ? 43 : $boolParallelProcess.hashCode());
      Object $nodeTime = this.getNodeTime();
      result = result * 59 + ($nodeTime == null ? 43 : $nodeTime.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $teamId = this.getTeamId();
      return result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingTaskProcessLinkDTO(productProcessId="
         + this.getProductProcessId()
         + ", processId="
         + this.getProcessId()
         + ", sequence="
         + this.getSequence()
         + ", boolParallelProcess="
         + this.getBoolParallelProcess()
         + ", nodeTime="
         + this.getNodeTime()
         + ", type="
         + this.getType()
         + ", productType="
         + this.getProductType()
         + ", teamId="
         + this.getTeamId()
         + ")";
   }

   public MesBuildingTaskProcessLinkDTO(
      final Long productProcessId,
      final Long processId,
      final Integer sequence,
      final Boolean boolParallelProcess,
      final Integer nodeTime,
      final Integer type,
      final Integer productType,
      final Long teamId
   ) {
      this.productProcessId = productProcessId;
      this.processId = processId;
      this.sequence = sequence;
      this.boolParallelProcess = boolParallelProcess;
      this.nodeTime = nodeTime;
      this.type = type;
      this.productType = productType;
      this.teamId = teamId;
   }

   public MesBuildingTaskProcessLinkDTO() {
   }

   public static class MesBuildingTaskProcessLinkDTOBuilder {
      private Long productProcessId;
      private Long processId;
      private Integer sequence;
      private Boolean boolParallelProcess;
      private Integer nodeTime;
      private Integer type;
      private Integer productType;
      private Long teamId;

      MesBuildingTaskProcessLinkDTOBuilder() {
      }

      @JsonProperty("productProcessId")
      public MesBuildingTaskProcessLinkDTO.MesBuildingTaskProcessLinkDTOBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingTaskProcessLinkDTO.MesBuildingTaskProcessLinkDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingTaskProcessLinkDTO.MesBuildingTaskProcessLinkDTOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("boolParallelProcess")
      public MesBuildingTaskProcessLinkDTO.MesBuildingTaskProcessLinkDTOBuilder boolParallelProcess(final Boolean boolParallelProcess) {
         this.boolParallelProcess = boolParallelProcess;
         return this;
      }

      @JsonProperty("nodeTime")
      public MesBuildingTaskProcessLinkDTO.MesBuildingTaskProcessLinkDTOBuilder nodeTime(final Integer nodeTime) {
         this.nodeTime = nodeTime;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingTaskProcessLinkDTO.MesBuildingTaskProcessLinkDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingTaskProcessLinkDTO.MesBuildingTaskProcessLinkDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingTaskProcessLinkDTO.MesBuildingTaskProcessLinkDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesBuildingTaskProcessLinkDTO build() {
         return new MesBuildingTaskProcessLinkDTO(
            this.productProcessId, this.processId, this.sequence, this.boolParallelProcess, this.nodeTime, this.type, this.productType, this.teamId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskProcessLinkDTO.MesBuildingTaskProcessLinkDTOBuilder(productProcessId="
            + this.productProcessId
            + ", processId="
            + this.processId
            + ", sequence="
            + this.sequence
            + ", boolParallelProcess="
            + this.boolParallelProcess
            + ", nodeTime="
            + this.nodeTime
            + ", type="
            + this.type
            + ", productType="
            + this.productType
            + ", teamId="
            + this.teamId
            + ")";
      }
   }
}
