package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingProcessLagDTO", description = "工序滞后数据")
public class MesBuildingProcessLagDTO {
   @ApiModelProperty(name = "teskProcessId", value = "工序id")
   private Long teskProcessId;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "unQuantity", value = "滞后数量")
   private Integer unQuantity;
   @ApiModelProperty(name = "workshopName", value = "车间名称")
   private String workshopName;
   @ApiModelProperty(name = "processName", value = "工序名称")
   private String processName;
   @ApiModelProperty(name = "orderNumber", value = "工单号")
   private String orderNumber;
   @ApiModelProperty(name = "teamName", value = "班组名称")
   private String teamName;

   public Long getTeskProcessId() {
      return this.teskProcessId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getUnQuantity() {
      return this.unQuantity;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public MesBuildingProcessLagDTO setTeskProcessId(final Long teskProcessId) {
      this.teskProcessId = teskProcessId;
      return this;
   }

   public MesBuildingProcessLagDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesBuildingProcessLagDTO setUnQuantity(final Integer unQuantity) {
      this.unQuantity = unQuantity;
      return this;
   }

   public MesBuildingProcessLagDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   public MesBuildingProcessLagDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   public MesBuildingProcessLagDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   public MesBuildingProcessLagDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProcessLagDTO(teskProcessId="
         + this.getTeskProcessId()
         + ", projectId="
         + this.getProjectId()
         + ", unQuantity="
         + this.getUnQuantity()
         + ", workshopName="
         + this.getWorkshopName()
         + ", processName="
         + this.getProcessName()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", teamName="
         + this.getTeamName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProcessLagDTO)) {
         return false;
      }

      MesBuildingProcessLagDTO other = (MesBuildingProcessLagDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$teskProcessId = this.getTeskProcessId();
      Object other$teskProcessId = other.getTeskProcessId();
      if (this$teskProcessId == null ? other$teskProcessId == null : this$teskProcessId.equals(other$teskProcessId)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$unQuantity = this.getUnQuantity();
            Object other$unQuantity = other.getUnQuantity();
            if (this$unQuantity == null ? other$unQuantity == null : this$unQuantity.equals(other$unQuantity)) {
               Object this$workshopName = this.getWorkshopName();
               Object other$workshopName = other.getWorkshopName();
               if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                  Object this$processName = this.getProcessName();
                  Object other$processName = other.getProcessName();
                  if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                     Object this$orderNumber = this.getOrderNumber();
                     Object other$orderNumber = other.getOrderNumber();
                     if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                        Object this$teamName = this.getTeamName();
                        Object other$teamName = other.getTeamName();
                        return this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName);
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
      return other instanceof MesBuildingProcessLagDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teskProcessId = this.getTeskProcessId();
      result = result * 59 + ($teskProcessId == null ? 43 : $teskProcessId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $unQuantity = this.getUnQuantity();
      result = result * 59 + ($unQuantity == null ? 43 : $unQuantity.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $teamName = this.getTeamName();
      return result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
   }
}
