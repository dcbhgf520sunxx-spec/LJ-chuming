package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task;

import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.MesEnclosureReportNumberStatusDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("任务构件打印响应类")
public class TaskArtifactPrintDO extends ArtifactBaseInfo {
   @ApiModelProperty("产品id")
   private Long id;
   @ApiModelProperty("任务id")
   private Long taskId;
   @ApiModelProperty("工厂id")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   private Long workshopId;
   @ApiModelProperty("任务数量")
   private Integer taskQuantity;
   @ApiModelProperty("打印数量")
   private Integer printQuantity;
   @ApiModelProperty("打印时间")
   private LocalDateTime printTime;
   @ApiModelProperty("要求完成日期")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty("是否一物一码")
   private Boolean boolOneCode;
   @ApiModelProperty("一物一码序号及关联信息")
   List<MesEnclosureReportNumberStatusDTO> numberStatusDTOS;

   public Long getId() {
      return this.id;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public LocalDateTime getPrintTime() {
      return this.printTime;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   public List<MesEnclosureReportNumberStatusDTO> getNumberStatusDTOS() {
      return this.numberStatusDTOS;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   public void setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
   }

   public void setPrintTime(final LocalDateTime printTime) {
      this.printTime = printTime;
   }

   public void setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
   }

   public void setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
   }

   public void setNumberStatusDTOS(final List<MesEnclosureReportNumberStatusDTO> numberStatusDTOS) {
      this.numberStatusDTOS = numberStatusDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskArtifactPrintDO)) {
         return false;
      }

      TaskArtifactPrintDO other = (TaskArtifactPrintDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$taskQuantity = this.getTaskQuantity();
                  Object other$taskQuantity = other.getTaskQuantity();
                  if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                     Object this$printQuantity = this.getPrintQuantity();
                     Object other$printQuantity = other.getPrintQuantity();
                     if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                        Object this$boolOneCode = this.getBoolOneCode();
                        Object other$boolOneCode = other.getBoolOneCode();
                        if (this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode)) {
                           Object this$printTime = this.getPrintTime();
                           Object other$printTime = other.getPrintTime();
                           if (this$printTime == null ? other$printTime == null : this$printTime.equals(other$printTime)) {
                              Object this$askCompleteTime = this.getAskCompleteTime();
                              Object other$askCompleteTime = other.getAskCompleteTime();
                              if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                                 Object this$numberStatusDTOS = this.getNumberStatusDTOS();
                                 Object other$numberStatusDTOS = other.getNumberStatusDTOS();
                                 return this$numberStatusDTOS == null ? other$numberStatusDTOS == null : this$numberStatusDTOS.equals(other$numberStatusDTOS);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TaskArtifactPrintDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $printTime = this.getPrintTime();
      result = result * 59 + ($printTime == null ? 43 : $printTime.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $numberStatusDTOS = this.getNumberStatusDTOS();
      return result * 59 + ($numberStatusDTOS == null ? 43 : $numberStatusDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "TaskArtifactPrintDO(id="
         + this.getId()
         + ", taskId="
         + this.getTaskId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", printTime="
         + this.getPrintTime()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ", numberStatusDTOS="
         + this.getNumberStatusDTOS()
         + ")";
   }
}
