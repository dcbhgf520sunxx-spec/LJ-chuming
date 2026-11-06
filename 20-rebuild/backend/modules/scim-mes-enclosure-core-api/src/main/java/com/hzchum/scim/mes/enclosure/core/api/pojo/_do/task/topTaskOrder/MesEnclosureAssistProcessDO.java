package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.topTaskOrder;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosureAssistProcessDO", description = "任务工单工序生产信息")
public class MesEnclosureAssistProcessDO {
   @ApiModelProperty(name = "taskOrderId", value = "工序任务工单ID", notes = "工序任务工单ID")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Long taskOrderId;
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

   public static MesEnclosureAssistProcessDO.MesEnclosureAssistProcessDOBuilder builder() {
      return new MesEnclosureAssistProcessDO.MesEnclosureAssistProcessDOBuilder();
   }

   public MesEnclosureAssistProcessDO() {
   }

   public MesEnclosureAssistProcessDO(
      final Long taskOrderId,
      final IdAndNameDO process,
      final QuantityAndWeightDetailDO totalTaskMete,
      final QuantityAndWeightDetailDO totalCompleteMete,
      final QuantityAndWeightDetailDO totalCanAssistMete
   ) {
      this.taskOrderId = taskOrderId;
      this.process = process;
      this.totalTaskMete = totalTaskMete;
      this.totalCompleteMete = totalCompleteMete;
      this.totalCanAssistMete = totalCanAssistMete;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
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
   public MesEnclosureAssistProcessDO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("process")
   public MesEnclosureAssistProcessDO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("totalTaskMete")
   public MesEnclosureAssistProcessDO setTotalTaskMete(final QuantityAndWeightDetailDO totalTaskMete) {
      this.totalTaskMete = totalTaskMete;
      return this;
   }

   @JsonProperty("totalCompleteMete")
   public MesEnclosureAssistProcessDO setTotalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
      this.totalCompleteMete = totalCompleteMete;
      return this;
   }

   @JsonProperty("totalCanAssistMete")
   public MesEnclosureAssistProcessDO setTotalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
      this.totalCanAssistMete = totalCanAssistMete;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureAssistProcessDO(taskOrderId="
         + this.getTaskOrderId()
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

      if (!(o instanceof MesEnclosureAssistProcessDO)) {
         return false;
      }

      MesEnclosureAssistProcessDO other = (MesEnclosureAssistProcessDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskOrderId = this.getTaskOrderId();
      Object other$taskOrderId = other.getTaskOrderId();
      if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureAssistProcessDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $totalTaskMete = this.getTotalTaskMete();
      result = result * 59 + ($totalTaskMete == null ? 43 : $totalTaskMete.hashCode());
      Object $totalCompleteMete = this.getTotalCompleteMete();
      result = result * 59 + ($totalCompleteMete == null ? 43 : $totalCompleteMete.hashCode());
      Object $totalCanAssistMete = this.getTotalCanAssistMete();
      return result * 59 + ($totalCanAssistMete == null ? 43 : $totalCanAssistMete.hashCode());
   }

   public static class MesEnclosureAssistProcessDOBuilder {
      private Long taskOrderId;
      private IdAndNameDO process;
      private QuantityAndWeightDetailDO totalTaskMete;
      private QuantityAndWeightDetailDO totalCompleteMete;
      private QuantityAndWeightDetailDO totalCanAssistMete;

      MesEnclosureAssistProcessDOBuilder() {
      }

      @JsonProperty("taskOrderId")
      public MesEnclosureAssistProcessDO.MesEnclosureAssistProcessDOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("process")
      public MesEnclosureAssistProcessDO.MesEnclosureAssistProcessDOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("totalTaskMete")
      public MesEnclosureAssistProcessDO.MesEnclosureAssistProcessDOBuilder totalTaskMete(final QuantityAndWeightDetailDO totalTaskMete) {
         this.totalTaskMete = totalTaskMete;
         return this;
      }

      @JsonProperty("totalCompleteMete")
      public MesEnclosureAssistProcessDO.MesEnclosureAssistProcessDOBuilder totalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
         this.totalCompleteMete = totalCompleteMete;
         return this;
      }

      @JsonProperty("totalCanAssistMete")
      public MesEnclosureAssistProcessDO.MesEnclosureAssistProcessDOBuilder totalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
         this.totalCanAssistMete = totalCanAssistMete;
         return this;
      }

      public MesEnclosureAssistProcessDO build() {
         return new MesEnclosureAssistProcessDO(this.taskOrderId, this.process, this.totalTaskMete, this.totalCompleteMete, this.totalCanAssistMete);
      }

      @Override
      public String toString() {
         return "MesEnclosureAssistProcessDO.MesEnclosureAssistProcessDOBuilder(taskOrderId="
            + this.taskOrderId
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
