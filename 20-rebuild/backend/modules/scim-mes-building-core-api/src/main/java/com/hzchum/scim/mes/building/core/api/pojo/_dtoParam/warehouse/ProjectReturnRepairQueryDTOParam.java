package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse;

import io.swagger.annotations.ApiModelProperty;

public class ProjectReturnRepairQueryDTOParam {
   @ApiModelProperty("项目id")
   Long projectId;
   @ApiModelProperty("返修产品发运状态 1.未发运 2.发运中 4.发运完毕")
   Integer returnShipStatus;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getReturnShipStatus() {
      return this.returnShipStatus;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setReturnShipStatus(final Integer returnShipStatus) {
      this.returnShipStatus = returnShipStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectReturnRepairQueryDTOParam)) {
         return false;
      } else {
         ProjectReturnRepairQueryDTOParam other = (ProjectReturnRepairQueryDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$returnShipStatus = this.getReturnShipStatus();
               Object other$returnShipStatus = other.getReturnShipStatus();
               return this$returnShipStatus == null ? other$returnShipStatus == null : this$returnShipStatus.equals(other$returnShipStatus);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReturnRepairQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $returnShipStatus = this.getReturnShipStatus();
      return result * 59 + ($returnShipStatus == null ? 43 : $returnShipStatus.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReturnRepairQueryDTOParam(projectId=" + this.getProjectId() + ", returnShipStatus=" + this.getReturnShipStatus() + ")";
   }
}
