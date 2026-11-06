package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.MesEnclosureTaskProcessDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosureTaskProcessDTO", description = "任务分配工序详情 ")
public class MesEnclosureTaskProcessDTO extends MesEnclosureTaskProcessDO {
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

   public Boolean getEnclosureInspection() {
      return this.enclosureInspection;
   }

   public Integer getTaskType() {
      return this.taskType;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   @JsonProperty("enclosureInspection")
   public MesEnclosureTaskProcessDTO setEnclosureInspection(final Boolean enclosureInspection) {
      this.enclosureInspection = enclosureInspection;
      return this;
   }

   @JsonProperty("taskType")
   public MesEnclosureTaskProcessDTO setTaskType(final Integer taskType) {
      this.taskType = taskType;
      return this;
   }

   @JsonProperty("boolOneCode")
   public MesEnclosureTaskProcessDTO setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTaskProcessDTO(enclosureInspection="
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

      if (!(o instanceof MesEnclosureTaskProcessDTO)) {
         return false;
      }

      MesEnclosureTaskProcessDTO other = (MesEnclosureTaskProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureTaskProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $enclosureInspection = this.getEnclosureInspection();
      result = result * 59 + ($enclosureInspection == null ? 43 : $enclosureInspection.hashCode());
      Object $taskType = this.getTaskType();
      result = result * 59 + ($taskType == null ? 43 : $taskType.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      return result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
   }
}
