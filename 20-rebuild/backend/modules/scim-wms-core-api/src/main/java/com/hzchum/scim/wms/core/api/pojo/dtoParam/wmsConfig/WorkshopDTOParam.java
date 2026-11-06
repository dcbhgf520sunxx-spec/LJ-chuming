package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

public class WorkshopDTOParam extends Workshop implements Serializable {
   @ApiModelProperty(name = "workshopUsers", value = "仓库负责人ID集合", notes = "仓库负责人ID集合")
   private List<String> workshopUsers;
   @ApiModelProperty(name = "mesWorkshopId", value = "关联mes车间集合", notes = "关联mes车间集合")
   private List<Long> mesWorkshopId;

   public List<String> getWorkshopUsers() {
      return this.workshopUsers;
   }

   public List<Long> getMesWorkshopId() {
      return this.mesWorkshopId;
   }

   public void setWorkshopUsers(final List<String> workshopUsers) {
      this.workshopUsers = workshopUsers;
   }

   public void setMesWorkshopId(final List<Long> mesWorkshopId) {
      this.mesWorkshopId = mesWorkshopId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof WorkshopDTOParam)) {
         return false;
      } else {
         WorkshopDTOParam other = (WorkshopDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$workshopUsers = this.getWorkshopUsers();
            Object other$workshopUsers = other.getWorkshopUsers();
            if (this$workshopUsers == null ? other$workshopUsers == null : this$workshopUsers.equals(other$workshopUsers)) {
               Object this$mesWorkshopId = this.getMesWorkshopId();
               Object other$mesWorkshopId = other.getMesWorkshopId();
               return this$mesWorkshopId == null ? other$mesWorkshopId == null : this$mesWorkshopId.equals(other$mesWorkshopId);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WorkshopDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopUsers = this.getWorkshopUsers();
      result = result * 59 + ($workshopUsers == null ? 43 : $workshopUsers.hashCode());
      Object $mesWorkshopId = this.getMesWorkshopId();
      return result * 59 + ($mesWorkshopId == null ? 43 : $mesWorkshopId.hashCode());
   }

   @Override
   public String toString() {
      return "WorkshopDTOParam(workshopUsers=" + this.getWorkshopUsers() + ", mesWorkshopId=" + this.getMesWorkshopId() + ")";
   }
}
