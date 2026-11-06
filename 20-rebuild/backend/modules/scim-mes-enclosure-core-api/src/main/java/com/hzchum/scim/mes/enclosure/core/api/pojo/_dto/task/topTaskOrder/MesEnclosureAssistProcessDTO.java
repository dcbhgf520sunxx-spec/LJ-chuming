package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.topTaskOrder;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesEnclosureAssistProcessDTO", description = "任务工单工序生产信息")
public class MesEnclosureAssistProcessDTO {
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
   @JsonInclude(Include.NON_NULL)
   private QuantityAndWeightDetailDO totalCanAssistMete;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;

   public static MesEnclosureAssistProcessDTO.MesEnclosureAssistProcessDTOBuilder builder() {
      return new MesEnclosureAssistProcessDTO.MesEnclosureAssistProcessDTOBuilder();
   }

   public MesEnclosureAssistProcessDTO() {
   }

   public MesEnclosureAssistProcessDTO(
      final Long taskOrderId,
      final IdAndNameDO process,
      final QuantityAndWeightDetailDO totalTaskMete,
      final QuantityAndWeightDetailDO totalCompleteMete,
      final QuantityAndWeightDetailDO totalCanAssistMete,
      final LocalDateTime askCompleteTime
   ) {
      this.taskOrderId = taskOrderId;
      this.process = process;
      this.totalTaskMete = totalTaskMete;
      this.totalCompleteMete = totalCompleteMete;
      this.totalCanAssistMete = totalCanAssistMete;
      this.askCompleteTime = askCompleteTime;
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

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   @JsonProperty("taskOrderId")
   public MesEnclosureAssistProcessDTO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("process")
   public MesEnclosureAssistProcessDTO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("totalTaskMete")
   public MesEnclosureAssistProcessDTO setTotalTaskMete(final QuantityAndWeightDetailDO totalTaskMete) {
      this.totalTaskMete = totalTaskMete;
      return this;
   }

   @JsonProperty("totalCompleteMete")
   public MesEnclosureAssistProcessDTO setTotalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
      this.totalCompleteMete = totalCompleteMete;
      return this;
   }

   @JsonProperty("totalCanAssistMete")
   public MesEnclosureAssistProcessDTO setTotalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
      this.totalCanAssistMete = totalCanAssistMete;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureAssistProcessDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureAssistProcessDTO(taskOrderId="
         + this.getTaskOrderId()
         + ", process="
         + this.getProcess()
         + ", totalTaskMete="
         + this.getTotalTaskMete()
         + ", totalCompleteMete="
         + this.getTotalCompleteMete()
         + ", totalCanAssistMete="
         + this.getTotalCanAssistMete()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureAssistProcessDTO)) {
         return false;
      }

      MesEnclosureAssistProcessDTO other = (MesEnclosureAssistProcessDTO)o;
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
                  if (this$totalCanAssistMete == null ? other$totalCanAssistMete == null : this$totalCanAssistMete.equals(other$totalCanAssistMete)) {
                     Object this$askCompleteTime = this.getAskCompleteTime();
                     Object other$askCompleteTime = other.getAskCompleteTime();
                     return this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime);
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
      return other instanceof MesEnclosureAssistProcessDTO;
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
      result = result * 59 + ($totalCanAssistMete == null ? 43 : $totalCanAssistMete.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   public static class MesEnclosureAssistProcessDTOBuilder {
      private Long taskOrderId;
      private IdAndNameDO process;
      private QuantityAndWeightDetailDO totalTaskMete;
      private QuantityAndWeightDetailDO totalCompleteMete;
      private QuantityAndWeightDetailDO totalCanAssistMete;
      private LocalDateTime askCompleteTime;

      MesEnclosureAssistProcessDTOBuilder() {
      }

      @JsonProperty("taskOrderId")
      public MesEnclosureAssistProcessDTO.MesEnclosureAssistProcessDTOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("process")
      public MesEnclosureAssistProcessDTO.MesEnclosureAssistProcessDTOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("totalTaskMete")
      public MesEnclosureAssistProcessDTO.MesEnclosureAssistProcessDTOBuilder totalTaskMete(final QuantityAndWeightDetailDO totalTaskMete) {
         this.totalTaskMete = totalTaskMete;
         return this;
      }

      @JsonProperty("totalCompleteMete")
      public MesEnclosureAssistProcessDTO.MesEnclosureAssistProcessDTOBuilder totalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
         this.totalCompleteMete = totalCompleteMete;
         return this;
      }

      @JsonProperty("totalCanAssistMete")
      public MesEnclosureAssistProcessDTO.MesEnclosureAssistProcessDTOBuilder totalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
         this.totalCanAssistMete = totalCanAssistMete;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureAssistProcessDTO.MesEnclosureAssistProcessDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public MesEnclosureAssistProcessDTO build() {
         return new MesEnclosureAssistProcessDTO(
            this.taskOrderId, this.process, this.totalTaskMete, this.totalCompleteMete, this.totalCanAssistMete, this.askCompleteTime
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureAssistProcessDTO.MesEnclosureAssistProcessDTOBuilder(taskOrderId="
            + this.taskOrderId
            + ", process="
            + this.process
            + ", totalTaskMete="
            + this.totalTaskMete
            + ", totalCompleteMete="
            + this.totalCompleteMete
            + ", totalCanAssistMete="
            + this.totalCanAssistMete
            + ", askCompleteTime="
            + this.askCompleteTime
            + ")";
      }
   }
}
