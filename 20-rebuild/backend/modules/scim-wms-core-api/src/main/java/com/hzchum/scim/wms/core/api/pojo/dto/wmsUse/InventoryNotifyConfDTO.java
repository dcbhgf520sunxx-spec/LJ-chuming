package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.util.List;

public class InventoryNotifyConfDTO {
   private Long workshopId;
   private List<Long> userIds;
   private List<Long> deptIds;

   public static InventoryNotifyConfDTO.InventoryNotifyConfDTOBuilder builder() {
      return new InventoryNotifyConfDTO.InventoryNotifyConfDTOBuilder();
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public List<Long> getUserIds() {
      return this.userIds;
   }

   public List<Long> getDeptIds() {
      return this.deptIds;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setUserIds(final List<Long> userIds) {
      this.userIds = userIds;
   }

   public void setDeptIds(final List<Long> deptIds) {
      this.deptIds = deptIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryNotifyConfDTO)) {
         return false;
      }

      InventoryNotifyConfDTO other = (InventoryNotifyConfDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$userIds = this.getUserIds();
         Object other$userIds = other.getUserIds();
         if (this$userIds == null ? other$userIds == null : this$userIds.equals(other$userIds)) {
            Object this$deptIds = this.getDeptIds();
            Object other$deptIds = other.getDeptIds();
            return this$deptIds == null ? other$deptIds == null : this$deptIds.equals(other$deptIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InventoryNotifyConfDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $userIds = this.getUserIds();
      result = result * 59 + ($userIds == null ? 43 : $userIds.hashCode());
      Object $deptIds = this.getDeptIds();
      return result * 59 + ($deptIds == null ? 43 : $deptIds.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryNotifyConfDTO(workshopId=" + this.getWorkshopId() + ", userIds=" + this.getUserIds() + ", deptIds=" + this.getDeptIds() + ")";
   }

   public InventoryNotifyConfDTO(final Long workshopId, final List<Long> userIds, final List<Long> deptIds) {
      this.workshopId = workshopId;
      this.userIds = userIds;
      this.deptIds = deptIds;
   }

   public InventoryNotifyConfDTO() {
   }

   public static class InventoryNotifyConfDTOBuilder {
      private Long workshopId;
      private List<Long> userIds;
      private List<Long> deptIds;

      InventoryNotifyConfDTOBuilder() {
      }

      public InventoryNotifyConfDTO.InventoryNotifyConfDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public InventoryNotifyConfDTO.InventoryNotifyConfDTOBuilder userIds(final List<Long> userIds) {
         this.userIds = userIds;
         return this;
      }

      public InventoryNotifyConfDTO.InventoryNotifyConfDTOBuilder deptIds(final List<Long> deptIds) {
         this.deptIds = deptIds;
         return this;
      }

      public InventoryNotifyConfDTO build() {
         return new InventoryNotifyConfDTO(this.workshopId, this.userIds, this.deptIds);
      }

      @Override
      public String toString() {
         return "InventoryNotifyConfDTO.InventoryNotifyConfDTOBuilder(workshopId="
            + this.workshopId
            + ", userIds="
            + this.userIds
            + ", deptIds="
            + this.deptIds
            + ")";
      }
   }
}
