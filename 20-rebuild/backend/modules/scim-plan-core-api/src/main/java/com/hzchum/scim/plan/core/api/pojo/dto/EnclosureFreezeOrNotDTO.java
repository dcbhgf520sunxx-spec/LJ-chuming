package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "EnclosureFreezeOrNotDTO对象", description = "围护冻结")
public class EnclosureFreezeOrNotDTO {
   @ApiModelProperty(name = "id", value = "围护编号")
   private Long id;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 false暂停 true进行中")
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单id", notes = "任务工单id")
   private Long taskOrderId;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   private Long taskId;

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
   }

   public void setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureFreezeOrNotDTO)) {
         return false;
      }

      EnclosureFreezeOrNotDTO other = (EnclosureFreezeOrNotDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolStatusEnum = this.getBoolStatusEnum();
         Object other$boolStatusEnum = other.getBoolStatusEnum();
         if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
            Object this$taskOrderId = this.getTaskOrderId();
            Object other$taskOrderId = other.getTaskOrderId();
            if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
               Object this$taskId = this.getTaskId();
               Object other$taskId = other.getTaskId();
               return this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId);
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
      return other instanceof EnclosureFreezeOrNotDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $taskId = this.getTaskId();
      return result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureFreezeOrNotDTO(id="
         + this.getId()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", taskId="
         + this.getTaskId()
         + ")";
   }
}
