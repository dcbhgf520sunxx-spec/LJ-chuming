package com.hzchum.scim.mes.building.core.api.pojo._do.task.topTaskOrder;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingAssistProcessDO", description = "任务工单工序生产信息")
public class MesBuildingAssistProcessDO {
   @ApiModelProperty(name = "taskOrderId", value = "工序任务工单ID", notes = "工序任务工单ID")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Long taskOrderId;
   @ApiModelProperty(name = "sequence", value = "工序顺序", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   private Integer sequence;
   @ApiModelProperty(name = "process", value = "工序", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private IdAndNameDO process;
   @ApiModelProperty(name = "totalTaskMete", value = "任务量", notes = "任务量")
   @JsonProperty("totalTaskMete")
   @JSONField(name = "totalTaskMete")
   private QuantityAndWeightDetailDO totalTaskMete;
   @ApiModelProperty(name = "totalCompleteMete", value = "完成量", notes = "完成量")
   @JsonProperty("totalCompleteMete")
   @JSONField(name = "totalCompleteMete")
   private QuantityAndWeightDetailDO totalCompleteMete;
   @ApiModelProperty(name = "totalCanAssistMete", value = "总可协同量", notes = "总可协同量")
   @JsonProperty("totalCanAssistMete")
   @JSONField(name = "totalCanAssistMete")
   private QuantityAndWeightDetailDO totalCanAssistMete;

   public static MesBuildingAssistProcessDO.MesBuildingAssistProcessDOBuilder builder() {
      return new MesBuildingAssistProcessDO.MesBuildingAssistProcessDOBuilder();
   }

   public MesBuildingAssistProcessDO() {
   }

   public MesBuildingAssistProcessDO(
      final Long taskOrderId,
      final Integer sequence,
      final IdAndNameDO process,
      final QuantityAndWeightDetailDO totalTaskMete,
      final QuantityAndWeightDetailDO totalCompleteMete,
      final QuantityAndWeightDetailDO totalCanAssistMete
   ) {
      this.taskOrderId = taskOrderId;
      this.sequence = sequence;
      this.process = process;
      this.totalTaskMete = totalTaskMete;
      this.totalCompleteMete = totalCompleteMete;
      this.totalCanAssistMete = totalCanAssistMete;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public IdAndNameDO getProcess() {
      return this.process;
   }

   public QuantityAndWeightDetailDO getTotalTaskMete() {
      return this.totalTaskMete;
   }

   public QuantityAndWeightDetailDO getTotalCompleteMete() {
      return this.totalCompleteMete;
   }

   public QuantityAndWeightDetailDO getTotalCanAssistMete() {
      return this.totalCanAssistMete;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingAssistProcessDO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingAssistProcessDO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("process")
   public MesBuildingAssistProcessDO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("totalTaskMete")
   public MesBuildingAssistProcessDO setTotalTaskMete(final QuantityAndWeightDetailDO totalTaskMete) {
      this.totalTaskMete = totalTaskMete;
      return this;
   }

   @JsonProperty("totalCompleteMete")
   public MesBuildingAssistProcessDO setTotalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
      this.totalCompleteMete = totalCompleteMete;
      return this;
   }

   @JsonProperty("totalCanAssistMete")
   public MesBuildingAssistProcessDO setTotalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
      this.totalCanAssistMete = totalCanAssistMete;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssistProcessDO(taskOrderId="
         + this.getTaskOrderId()
         + ", sequence="
         + this.getSequence()
         + ", process="
         + this.getProcess()
         + ", totalTaskMete="
         + this.getTotalTaskMete()
         + ", totalCompleteMete="
         + this.getTotalCompleteMete()
         + ", totalCanAssistMete="
         + this.getTotalCanAssistMete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssistProcessDO)) {
         return false;
      }

      MesBuildingAssistProcessDO other = (MesBuildingAssistProcessDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskOrderId = this.getTaskOrderId();
      Object other$taskOrderId = other.getTaskOrderId();
      if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
         Object this$sequence = this.getSequence();
         Object other$sequence = other.getSequence();
         if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
            Object this$process = this.getProcess();
            Object other$process = other.getProcess();
            if (this$process == null ? other$process == null : this$process.equals(other$process)) {
               Object this$totalTaskMete = this.getTotalTaskMete();
               Object other$totalTaskMete = other.getTotalTaskMete();
               if (this$totalTaskMete == null ? other$totalTaskMete == null : this$totalTaskMete.equals(other$totalTaskMete)) {
                  Object this$totalCompleteMete = this.getTotalCompleteMete();
                  Object other$totalCompleteMete = other.getTotalCompleteMete();
                  if (this$totalCompleteMete == null ? other$totalCompleteMete == null : this$totalCompleteMete.equals(other$totalCompleteMete)) {
                     Object this$totalCanAssistMete = this.getTotalCanAssistMete();
                     Object other$totalCanAssistMete = other.getTotalCanAssistMete();
                     return this$totalCanAssistMete == null ? other$totalCanAssistMete == null : this$totalCanAssistMete.equals(other$totalCanAssistMete);
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
      return other instanceof MesBuildingAssistProcessDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $totalTaskMete = this.getTotalTaskMete();
      result = result * 59 + ($totalTaskMete == null ? 43 : $totalTaskMete.hashCode());
      Object $totalCompleteMete = this.getTotalCompleteMete();
      result = result * 59 + ($totalCompleteMete == null ? 43 : $totalCompleteMete.hashCode());
      Object $totalCanAssistMete = this.getTotalCanAssistMete();
      return result * 59 + ($totalCanAssistMete == null ? 43 : $totalCanAssistMete.hashCode());
   }

   public static class MesBuildingAssistProcessDOBuilder {
      private Long taskOrderId;
      private Integer sequence;
      private IdAndNameDO process;
      private QuantityAndWeightDetailDO totalTaskMete;
      private QuantityAndWeightDetailDO totalCompleteMete;
      private QuantityAndWeightDetailDO totalCanAssistMete;

      MesBuildingAssistProcessDOBuilder() {
      }

      @JsonProperty("taskOrderId")
      public MesBuildingAssistProcessDO.MesBuildingAssistProcessDOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingAssistProcessDO.MesBuildingAssistProcessDOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("process")
      public MesBuildingAssistProcessDO.MesBuildingAssistProcessDOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("totalTaskMete")
      public MesBuildingAssistProcessDO.MesBuildingAssistProcessDOBuilder totalTaskMete(final QuantityAndWeightDetailDO totalTaskMete) {
         this.totalTaskMete = totalTaskMete;
         return this;
      }

      @JsonProperty("totalCompleteMete")
      public MesBuildingAssistProcessDO.MesBuildingAssistProcessDOBuilder totalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
         this.totalCompleteMete = totalCompleteMete;
         return this;
      }

      @JsonProperty("totalCanAssistMete")
      public MesBuildingAssistProcessDO.MesBuildingAssistProcessDOBuilder totalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
         this.totalCanAssistMete = totalCanAssistMete;
         return this;
      }

      public MesBuildingAssistProcessDO build() {
         return new MesBuildingAssistProcessDO(
            this.taskOrderId, this.sequence, this.process, this.totalTaskMete, this.totalCompleteMete, this.totalCanAssistMete
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssistProcessDO.MesBuildingAssistProcessDOBuilder(taskOrderId="
            + this.taskOrderId
            + ", sequence="
            + this.sequence
            + ", process="
            + this.process
            + ", totalTaskMete="
            + this.totalTaskMete
            + ", totalCompleteMete="
            + this.totalCompleteMete
            + ", totalCanAssistMete="
            + this.totalCanAssistMete
            + ")";
      }
   }
}
