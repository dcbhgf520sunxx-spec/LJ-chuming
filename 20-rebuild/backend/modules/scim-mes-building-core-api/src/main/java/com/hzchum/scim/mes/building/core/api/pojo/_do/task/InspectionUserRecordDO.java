package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("质检记录")
public class InspectionUserRecordDO {
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("工序")
   private NameInfo process;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("质检数量")
   private Integer inspectionQuantity;
   @ApiModelProperty("质检时间")
   private LocalDateTime inspectionTime;

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getProcess() {
      return this.process;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public LocalDateTime getInspectionTime() {
      return this.inspectionTime;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setProcess(final NameInfo process) {
      this.process = process;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
   }

   public void setInspectionTime(final LocalDateTime inspectionTime) {
      this.inspectionTime = inspectionTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionUserRecordDO)) {
         return false;
      }

      InspectionUserRecordDO other = (InspectionUserRecordDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inspectionQuantity = this.getInspectionQuantity();
      Object other$inspectionQuantity = other.getInspectionQuantity();
      if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$process = this.getProcess();
            Object other$process = other.getProcess();
            if (this$process == null ? other$process == null : this$process.equals(other$process)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$inspectionTime = this.getInspectionTime();
                  Object other$inspectionTime = other.getInspectionTime();
                  return this$inspectionTime == null ? other$inspectionTime == null : this$inspectionTime.equals(other$inspectionTime);
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
      return other instanceof InspectionUserRecordDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $inspectionTime = this.getInspectionTime();
      return result * 59 + ($inspectionTime == null ? 43 : $inspectionTime.hashCode());
   }

   @Override
   public String toString() {
      return "InspectionUserRecordDO(project="
         + this.getProject()
         + ", process="
         + this.getProcess()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", inspectionTime="
         + this.getInspectionTime()
         + ")";
   }
}
