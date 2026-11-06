package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("零件信息DTO")
public class TechMachinePartInfoDTO extends TechMachinePart {
   @ApiModelProperty("任务工单id")
   private Long taskOrderId;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechMachinePartInfoDTO)) {
         return false;
      }

      TechMachinePartInfoDTO other = (TechMachinePartInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$taskOrderId = this.getTaskOrderId();
      Object other$taskOrderId = other.getTaskOrderId();
      return this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechMachinePartInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $taskOrderId = this.getTaskOrderId();
      return result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
   }

   @Override
   public String toString() {
      return "TechMachinePartInfoDTO(super=" + super.toString() + ", taskOrderId=" + this.getTaskOrderId() + ")";
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public void setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
   }
}
