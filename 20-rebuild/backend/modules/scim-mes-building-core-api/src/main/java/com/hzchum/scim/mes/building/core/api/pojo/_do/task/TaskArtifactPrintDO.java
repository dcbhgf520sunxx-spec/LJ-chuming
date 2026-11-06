package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingReportNumberStatusDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
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
   @ApiModelProperty(name = "taskOrderId", value = "工单id", notes = "工单id")
   private Long taskOrderId;
   @ApiModelProperty(name = "taskOrderNumber", value = "工单号", notes = "工单号")
   private String taskOrderNumber;
   @ApiModelProperty("任务数量")
   private Integer taskQuantity;
   @ApiModelProperty("入库数量")
   private Integer warehouseQuantity;
   @ApiModelProperty("打印数量")
   private Integer printQuantity;
   @ApiModelProperty("打印时间")
   private LocalDateTime printTime;
   @ApiModelProperty("要求完成日期")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty("是否一物一码")
   private Boolean boolOneCode;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty("一物一码序号及关联信息")
   List<MesBuildingReportNumberStatusDTO> numberStatusDTOS;
   @ApiModelProperty("构件产品序列号集合")
   private List<Integer> numbers;
   @ApiModelProperty("构件产品序列号和图号")
   private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;
   @ApiModelProperty("打印状态")
   private Integer taskPrintEnum;

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

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getWarehouseQuantity() {
      return this.warehouseQuantity;
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

   @Override
   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public List<MesBuildingReportNumberStatusDTO> getNumberStatusDTOS() {
      return this.numberStatusDTOS;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public List<DrawingAndSerialNumberDTO> getDrawingAndSerialNumber() {
      return this.drawingAndSerialNumber;
   }

   public Integer getTaskPrintEnum() {
      return this.taskPrintEnum;
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

   public void setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
   }

   public void setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
   }

   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   public void setWarehouseQuantity(final Integer warehouseQuantity) {
      this.warehouseQuantity = warehouseQuantity;
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

   @Override
   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setNumberStatusDTOS(final List<MesBuildingReportNumberStatusDTO> numberStatusDTOS) {
      this.numberStatusDTOS = numberStatusDTOS;
   }

   public void setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
   }

   public void setDrawingAndSerialNumber(final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber) {
      this.drawingAndSerialNumber = drawingAndSerialNumber;
   }

   public void setTaskPrintEnum(final Integer taskPrintEnum) {
      this.taskPrintEnum = taskPrintEnum;
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
                  Object this$taskOrderId = this.getTaskOrderId();
                  Object other$taskOrderId = other.getTaskOrderId();
                  if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                     Object this$taskQuantity = this.getTaskQuantity();
                     Object other$taskQuantity = other.getTaskQuantity();
                     if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                        Object this$warehouseQuantity = this.getWarehouseQuantity();
                        Object other$warehouseQuantity = other.getWarehouseQuantity();
                        if (this$warehouseQuantity == null ? other$warehouseQuantity == null : this$warehouseQuantity.equals(other$warehouseQuantity)) {
                           Object this$printQuantity = this.getPrintQuantity();
                           Object other$printQuantity = other.getPrintQuantity();
                           if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                              Object this$boolOneCode = this.getBoolOneCode();
                              Object other$boolOneCode = other.getBoolOneCode();
                              if (this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode)) {
                                 Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                                 Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                                 if (this$boolAllPartSendDirectly == null
                                    ? other$boolAllPartSendDirectly == null
                                    : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                                    Object this$taskPrintEnum = this.getTaskPrintEnum();
                                    Object other$taskPrintEnum = other.getTaskPrintEnum();
                                    if (this$taskPrintEnum == null ? other$taskPrintEnum == null : this$taskPrintEnum.equals(other$taskPrintEnum)) {
                                       Object this$taskOrderNumber = this.getTaskOrderNumber();
                                       Object other$taskOrderNumber = other.getTaskOrderNumber();
                                       if (this$taskOrderNumber == null ? other$taskOrderNumber == null : this$taskOrderNumber.equals(other$taskOrderNumber)) {
                                          Object this$printTime = this.getPrintTime();
                                          Object other$printTime = other.getPrintTime();
                                          if (this$printTime == null ? other$printTime == null : this$printTime.equals(other$printTime)) {
                                             Object this$askCompleteTime = this.getAskCompleteTime();
                                             Object other$askCompleteTime = other.getAskCompleteTime();
                                             if (this$askCompleteTime == null
                                                ? other$askCompleteTime == null
                                                : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                Object this$numberStatusDTOS = this.getNumberStatusDTOS();
                                                Object other$numberStatusDTOS = other.getNumberStatusDTOS();
                                                if (this$numberStatusDTOS == null
                                                   ? other$numberStatusDTOS == null
                                                   : this$numberStatusDTOS.equals(other$numberStatusDTOS)) {
                                                   Object this$numbers = this.getNumbers();
                                                   Object other$numbers = other.getNumbers();
                                                   if (this$numbers == null ? other$numbers == null : this$numbers.equals(other$numbers)) {
                                                      Object this$drawingAndSerialNumber = this.getDrawingAndSerialNumber();
                                                      Object other$drawingAndSerialNumber = other.getDrawingAndSerialNumber();
                                                      return this$drawingAndSerialNumber == null
                                                         ? other$drawingAndSerialNumber == null
                                                         : this$drawingAndSerialNumber.equals(other$drawingAndSerialNumber);
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
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $warehouseQuantity = this.getWarehouseQuantity();
      result = result * 59 + ($warehouseQuantity == null ? 43 : $warehouseQuantity.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $taskPrintEnum = this.getTaskPrintEnum();
      result = result * 59 + ($taskPrintEnum == null ? 43 : $taskPrintEnum.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $printTime = this.getPrintTime();
      result = result * 59 + ($printTime == null ? 43 : $printTime.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $numberStatusDTOS = this.getNumberStatusDTOS();
      result = result * 59 + ($numberStatusDTOS == null ? 43 : $numberStatusDTOS.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $drawingAndSerialNumber = this.getDrawingAndSerialNumber();
      return result * 59 + ($drawingAndSerialNumber == null ? 43 : $drawingAndSerialNumber.hashCode());
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
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", warehouseQuantity="
         + this.getWarehouseQuantity()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", printTime="
         + this.getPrintTime()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", numberStatusDTOS="
         + this.getNumberStatusDTOS()
         + ", numbers="
         + this.getNumbers()
         + ", drawingAndSerialNumber="
         + this.getDrawingAndSerialNumber()
         + ", taskPrintEnum="
         + this.getTaskPrintEnum()
         + ")";
   }
}
