package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.processProductionProgress;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProcessProductionProgressVO {
   @ApiModelProperty(name = "processId", value = "工序id")
   private Long processId;
   @ApiModelProperty(name = "name", value = "工序名称")
   private String name;
   @ApiModelProperty(name = "taskQuantity", value = "需生产数(件)")
   private BigDecimal taskQuantity;
   @ApiModelProperty(name = "taskTon", value = "需生产量(吨)")
   private BigDecimal taskTon;
   @ApiModelProperty(name = "inspectionQuantity", value = "完成数(件)")
   private BigDecimal inspectionQuantity;
   @ApiModelProperty(name = "inspectionTon", value = "完成量(吨)")
   private BigDecimal inspectionTon;
   @ApiModelProperty(name = "rateOfQuantity", value = "完成率（按件计算）")
   private BigDecimal rateOfQuantity;
   @ApiModelProperty(name = "rateOfQuantity", value = "完成率（按吨计算）")
   private BigDecimal rateOfTon;

   public Long getProcessId() {
      return this.processId;
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTaskTon() {
      return this.taskTon;
   }

   public BigDecimal getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public BigDecimal getInspectionTon() {
      return this.inspectionTon;
   }

   public BigDecimal getRateOfQuantity() {
      return this.rateOfQuantity;
   }

   public BigDecimal getRateOfTon() {
      return this.rateOfTon;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setTaskQuantity(final BigDecimal taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   public void setTaskTon(final BigDecimal taskTon) {
      this.taskTon = taskTon;
   }

   public void setInspectionQuantity(final BigDecimal inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
   }

   public void setInspectionTon(final BigDecimal inspectionTon) {
      this.inspectionTon = inspectionTon;
   }

   public void setRateOfQuantity(final BigDecimal rateOfQuantity) {
      this.rateOfQuantity = rateOfQuantity;
   }

   public void setRateOfTon(final BigDecimal rateOfTon) {
      this.rateOfTon = rateOfTon;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessProductionProgressVO)) {
         return false;
      }

      ProcessProductionProgressVO other = (ProcessProductionProgressVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processId = this.getProcessId();
      Object other$processId = other.getProcessId();
      if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$taskQuantity = this.getTaskQuantity();
            Object other$taskQuantity = other.getTaskQuantity();
            if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
               Object this$taskTon = this.getTaskTon();
               Object other$taskTon = other.getTaskTon();
               if (this$taskTon == null ? other$taskTon == null : this$taskTon.equals(other$taskTon)) {
                  Object this$inspectionQuantity = this.getInspectionQuantity();
                  Object other$inspectionQuantity = other.getInspectionQuantity();
                  if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                     Object this$inspectionTon = this.getInspectionTon();
                     Object other$inspectionTon = other.getInspectionTon();
                     if (this$inspectionTon == null ? other$inspectionTon == null : this$inspectionTon.equals(other$inspectionTon)) {
                        Object this$rateOfQuantity = this.getRateOfQuantity();
                        Object other$rateOfQuantity = other.getRateOfQuantity();
                        if (this$rateOfQuantity == null ? other$rateOfQuantity == null : this$rateOfQuantity.equals(other$rateOfQuantity)) {
                           Object this$rateOfTon = this.getRateOfTon();
                           Object other$rateOfTon = other.getRateOfTon();
                           return this$rateOfTon == null ? other$rateOfTon == null : this$rateOfTon.equals(other$rateOfTon);
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
      return other instanceof ProcessProductionProgressVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $taskTon = this.getTaskTon();
      result = result * 59 + ($taskTon == null ? 43 : $taskTon.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $inspectionTon = this.getInspectionTon();
      result = result * 59 + ($inspectionTon == null ? 43 : $inspectionTon.hashCode());
      Object $rateOfQuantity = this.getRateOfQuantity();
      result = result * 59 + ($rateOfQuantity == null ? 43 : $rateOfQuantity.hashCode());
      Object $rateOfTon = this.getRateOfTon();
      return result * 59 + ($rateOfTon == null ? 43 : $rateOfTon.hashCode());
   }

   @Override
   public String toString() {
      return "ProcessProductionProgressVO(processId="
         + this.getProcessId()
         + ", name="
         + this.getName()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskTon="
         + this.getTaskTon()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", inspectionTon="
         + this.getInspectionTon()
         + ", rateOfQuantity="
         + this.getRateOfQuantity()
         + ", rateOfTon="
         + this.getRateOfTon()
         + ")";
   }
}
