package com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MesBuildingAssistProcessDTO", description = "任务工单工序生产信息")
public class MesBuildingAssistProcessDTO {
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
   @JsonInclude(Include.NON_NULL)
   private QuantityAndWeightDetailDO totalCanAssistMete;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "nextProcessList", value = "后续的工序列表", notes = "后续的工序列表")
   @JsonProperty("nextProcessList")
   @JSONField(name = "nextProcessList")
   private List<IdAndNameDO> nextProcessList;

   public static MesBuildingAssistProcessDTO.MesBuildingAssistProcessDTOBuilder builder() {
      return new MesBuildingAssistProcessDTO.MesBuildingAssistProcessDTOBuilder();
   }

   public MesBuildingAssistProcessDTO() {
   }

   public MesBuildingAssistProcessDTO(
      final Long taskOrderId,
      final Integer sequence,
      final IdAndNameDO process,
      final QuantityAndWeightDetailDO totalTaskMete,
      final QuantityAndWeightDetailDO totalCompleteMete,
      final QuantityAndWeightDetailDO totalCanAssistMete,
      final LocalDateTime askCompleteTime,
      final List<IdAndNameDO> nextProcessList
   ) {
      this.taskOrderId = taskOrderId;
      this.sequence = sequence;
      this.process = process;
      this.totalTaskMete = totalTaskMete;
      this.totalCompleteMete = totalCompleteMete;
      this.totalCanAssistMete = totalCanAssistMete;
      this.askCompleteTime = askCompleteTime;
      this.nextProcessList = nextProcessList;
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

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public List<IdAndNameDO> getNextProcessList() {
      return this.nextProcessList;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingAssistProcessDTO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingAssistProcessDTO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("process")
   public MesBuildingAssistProcessDTO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("totalTaskMete")
   public MesBuildingAssistProcessDTO setTotalTaskMete(final QuantityAndWeightDetailDO totalTaskMete) {
      this.totalTaskMete = totalTaskMete;
      return this;
   }

   @JsonProperty("totalCompleteMete")
   public MesBuildingAssistProcessDTO setTotalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
      this.totalCompleteMete = totalCompleteMete;
      return this;
   }

   @JsonProperty("totalCanAssistMete")
   public MesBuildingAssistProcessDTO setTotalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
      this.totalCanAssistMete = totalCanAssistMete;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingAssistProcessDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("nextProcessList")
   public MesBuildingAssistProcessDTO setNextProcessList(final List<IdAndNameDO> nextProcessList) {
      this.nextProcessList = nextProcessList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssistProcessDTO(taskOrderId="
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
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", nextProcessList="
         + this.getNextProcessList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssistProcessDTO)) {
         return false;
      }

      MesBuildingAssistProcessDTO other = (MesBuildingAssistProcessDTO)o;
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
                     if (this$totalCanAssistMete == null ? other$totalCanAssistMete == null : this$totalCanAssistMete.equals(other$totalCanAssistMete)) {
                        Object this$askCompleteTime = this.getAskCompleteTime();
                        Object other$askCompleteTime = other.getAskCompleteTime();
                        if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                           Object this$nextProcessList = this.getNextProcessList();
                           Object other$nextProcessList = other.getNextProcessList();
                           return this$nextProcessList == null ? other$nextProcessList == null : this$nextProcessList.equals(other$nextProcessList);
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
      return other instanceof MesBuildingAssistProcessDTO;
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
      result = result * 59 + ($totalCanAssistMete == null ? 43 : $totalCanAssistMete.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $nextProcessList = this.getNextProcessList();
      return result * 59 + ($nextProcessList == null ? 43 : $nextProcessList.hashCode());
   }

   public static class MesBuildingAssistProcessDTOBuilder {
      private Long taskOrderId;
      private Integer sequence;
      private IdAndNameDO process;
      private QuantityAndWeightDetailDO totalTaskMete;
      private QuantityAndWeightDetailDO totalCompleteMete;
      private QuantityAndWeightDetailDO totalCanAssistMete;
      private LocalDateTime askCompleteTime;
      private List<IdAndNameDO> nextProcessList;

      MesBuildingAssistProcessDTOBuilder() {
      }

      @JsonProperty("taskOrderId")
      public MesBuildingAssistProcessDTO.MesBuildingAssistProcessDTOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingAssistProcessDTO.MesBuildingAssistProcessDTOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("process")
      public MesBuildingAssistProcessDTO.MesBuildingAssistProcessDTOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("totalTaskMete")
      public MesBuildingAssistProcessDTO.MesBuildingAssistProcessDTOBuilder totalTaskMete(final QuantityAndWeightDetailDO totalTaskMete) {
         this.totalTaskMete = totalTaskMete;
         return this;
      }

      @JsonProperty("totalCompleteMete")
      public MesBuildingAssistProcessDTO.MesBuildingAssistProcessDTOBuilder totalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
         this.totalCompleteMete = totalCompleteMete;
         return this;
      }

      @JsonProperty("totalCanAssistMete")
      public MesBuildingAssistProcessDTO.MesBuildingAssistProcessDTOBuilder totalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
         this.totalCanAssistMete = totalCanAssistMete;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingAssistProcessDTO.MesBuildingAssistProcessDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("nextProcessList")
      public MesBuildingAssistProcessDTO.MesBuildingAssistProcessDTOBuilder nextProcessList(final List<IdAndNameDO> nextProcessList) {
         this.nextProcessList = nextProcessList;
         return this;
      }

      public MesBuildingAssistProcessDTO build() {
         return new MesBuildingAssistProcessDTO(
            this.taskOrderId,
            this.sequence,
            this.process,
            this.totalTaskMete,
            this.totalCompleteMete,
            this.totalCanAssistMete,
            this.askCompleteTime,
            this.nextProcessList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssistProcessDTO.MesBuildingAssistProcessDTOBuilder(taskOrderId="
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
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", nextProcessList="
            + this.nextProcessList
            + ")";
      }
   }
}
