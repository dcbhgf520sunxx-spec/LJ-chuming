package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingTaskProcessDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingTaskProcessDTO", description = "任务分配工序详情 ")
public class MesBuildingTaskProcessDTO extends MesBuildingTaskProcessDO {
   @ApiModelProperty(name = "producibleQuantity", notes = "可上报数量")
   @JsonProperty("producibleQuantity")
   @JSONField(name = "producibleQuantity")
   private Integer producibleQuantity;
   @ApiModelProperty(name = "enclosureInspection", notes = "是否有质检（围护，0 没有  1 有）")
   @JsonProperty("enclosureInspection")
   @JSONField(name = "enclosureInspection")
   private Boolean enclosureInspection;
   @ApiModelProperty(name = "taskType", notes = "任务类型（正常任务 1 ,协同任务 2 ）")
   @JsonProperty("taskType")
   @JSONField(name = "taskType")
   private Integer taskType;
   @ApiModelProperty(name = "boolOneCode", notes = "是否一物一码（是 1 ,否 0 ）")
   @JsonProperty("boolOneCode")
   @JSONField(name = "boolOneCode")
   private Boolean boolOneCode;

   public Integer getProducibleQuantity() {
      return this.producibleQuantity;
   }

   public Boolean getEnclosureInspection() {
      return this.enclosureInspection;
   }

   public Integer getTaskType() {
      return this.taskType;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   @JsonProperty("producibleQuantity")
   public MesBuildingTaskProcessDTO setProducibleQuantity(final Integer producibleQuantity) {
      this.producibleQuantity = producibleQuantity;
      return this;
   }

   @JsonProperty("enclosureInspection")
   public MesBuildingTaskProcessDTO setEnclosureInspection(final Boolean enclosureInspection) {
      this.enclosureInspection = enclosureInspection;
      return this;
   }

   @JsonProperty("taskType")
   public MesBuildingTaskProcessDTO setTaskType(final Integer taskType) {
      this.taskType = taskType;
      return this;
   }

   @JsonProperty("boolOneCode")
   public MesBuildingTaskProcessDTO setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskProcessDTO(producibleQuantity="
         + this.getProducibleQuantity()
         + ", enclosureInspection="
         + this.getEnclosureInspection()
         + ", taskType="
         + this.getTaskType()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskProcessDTO)) {
         return false;
      }

      MesBuildingTaskProcessDTO other = (MesBuildingTaskProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$producibleQuantity = this.getProducibleQuantity();
      Object other$producibleQuantity = other.getProducibleQuantity();
      if (this$producibleQuantity == null ? other$producibleQuantity == null : this$producibleQuantity.equals(other$producibleQuantity)) {
         Object this$enclosureInspection = this.getEnclosureInspection();
         Object other$enclosureInspection = other.getEnclosureInspection();
         if (this$enclosureInspection == null ? other$enclosureInspection == null : this$enclosureInspection.equals(other$enclosureInspection)) {
            Object this$taskType = this.getTaskType();
            Object other$taskType = other.getTaskType();
            if (this$taskType == null ? other$taskType == null : this$taskType.equals(other$taskType)) {
               Object this$boolOneCode = this.getBoolOneCode();
               Object other$boolOneCode = other.getBoolOneCode();
               return this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTaskProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $producibleQuantity = this.getProducibleQuantity();
      result = result * 59 + ($producibleQuantity == null ? 43 : $producibleQuantity.hashCode());
      Object $enclosureInspection = this.getEnclosureInspection();
      result = result * 59 + ($enclosureInspection == null ? 43 : $enclosureInspection.hashCode());
      Object $taskType = this.getTaskType();
      result = result * 59 + ($taskType == null ? 43 : $taskType.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      return result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
   }
}
