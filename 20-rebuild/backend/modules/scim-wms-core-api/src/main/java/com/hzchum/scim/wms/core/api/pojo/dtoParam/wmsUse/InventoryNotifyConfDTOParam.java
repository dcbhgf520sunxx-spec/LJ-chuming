package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.util.List;

public class InventoryNotifyConfDTOParam {
   private Long workshopId;
   private String workshopName;
   private List<Long> deptIds;
   private List<Long> userIds;

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public List<Long> getDeptIds() {
      return this.deptIds;
   }

   public List<Long> getUserIds() {
      return this.userIds;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setDeptIds(final List<Long> deptIds) {
      this.deptIds = deptIds;
   }

   public void setUserIds(final List<Long> userIds) {
      this.userIds = userIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryNotifyConfDTOParam)) {
         return false;
      }

      InventoryNotifyConfDTOParam other = (InventoryNotifyConfDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$workshopName = this.getWorkshopName();
         Object other$workshopName = other.getWorkshopName();
         if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
            Object this$deptIds = this.getDeptIds();
            Object other$deptIds = other.getDeptIds();
            if (this$deptIds == null ? other$deptIds == null : this$deptIds.equals(other$deptIds)) {
               Object this$userIds = this.getUserIds();
               Object other$userIds = other.getUserIds();
               return this$userIds == null ? other$userIds == null : this$userIds.equals(other$userIds);
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
      return other instanceof InventoryNotifyConfDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $deptIds = this.getDeptIds();
      result = result * 59 + ($deptIds == null ? 43 : $deptIds.hashCode());
      Object $userIds = this.getUserIds();
      return result * 59 + ($userIds == null ? 43 : $userIds.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryNotifyConfDTOParam(workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", deptIds="
         + this.getDeptIds()
         + ", userIds="
         + this.getUserIds()
         + ")";
   }

   public InventoryNotifyConfDTOParam(final Long workshopId, final String workshopName, final List<Long> deptIds, final List<Long> userIds) {
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.deptIds = deptIds;
      this.userIds = userIds;
   }

   public InventoryNotifyConfDTOParam() {
   }
}
