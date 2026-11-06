package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel(value = "MesBuildingProductionPlanningDTO", description = "计划滞后-生产计划数据")
public class MesBuildingProductionPlanningDTO {
   @ApiModelProperty(name = "teskProcessId", value = "工序id")
   private Long teskProcessId;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "orderNumber", value = "工单编号")
   private String orderNumber;
   @ApiModelProperty(name = "workshopName", value = "车间名称")
   private String workshopName;
   @ApiModelProperty(name = "processName", value = "工序名称")
   private String processName;
   @ApiModelProperty(name = "teamName", value = "班组名称")
   private String teamName;
   @ApiModelProperty(name = "completeTime", value = "要求完成日期")
   private LocalDate completeTime;

   public Long getTeskProcessId() {
      return this.teskProcessId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public LocalDate getCompleteTime() {
      return this.completeTime;
   }

   public MesBuildingProductionPlanningDTO setTeskProcessId(final Long teskProcessId) {
      this.teskProcessId = teskProcessId;
      return this;
   }

   public MesBuildingProductionPlanningDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public MesBuildingProductionPlanningDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   public MesBuildingProductionPlanningDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   public MesBuildingProductionPlanningDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   public MesBuildingProductionPlanningDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   public MesBuildingProductionPlanningDTO setCompleteTime(final LocalDate completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductionPlanningDTO(teskProcessId="
         + this.getTeskProcessId()
         + ", projectName="
         + this.getProjectName()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", workshopName="
         + this.getWorkshopName()
         + ", processName="
         + this.getProcessName()
         + ", teamName="
         + this.getTeamName()
         + ", completeTime="
         + this.getCompleteTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductionPlanningDTO)) {
         return false;
      }

      MesBuildingProductionPlanningDTO other = (MesBuildingProductionPlanningDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$teskProcessId = this.getTeskProcessId();
      Object other$teskProcessId = other.getTeskProcessId();
      if (this$teskProcessId == null ? other$teskProcessId == null : this$teskProcessId.equals(other$teskProcessId)) {
         Object this$projectName = this.getProjectName();
         Object other$projectName = other.getProjectName();
         if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
            Object this$orderNumber = this.getOrderNumber();
            Object other$orderNumber = other.getOrderNumber();
            if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
               Object this$workshopName = this.getWorkshopName();
               Object other$workshopName = other.getWorkshopName();
               if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                  Object this$processName = this.getProcessName();
                  Object other$processName = other.getProcessName();
                  if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                     Object this$teamName = this.getTeamName();
                     Object other$teamName = other.getTeamName();
                     if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
                        Object this$completeTime = this.getCompleteTime();
                        Object other$completeTime = other.getCompleteTime();
                        return this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime);
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
      return other instanceof MesBuildingProductionPlanningDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teskProcessId = this.getTeskProcessId();
      result = result * 59 + ($teskProcessId == null ? 43 : $teskProcessId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }
}
