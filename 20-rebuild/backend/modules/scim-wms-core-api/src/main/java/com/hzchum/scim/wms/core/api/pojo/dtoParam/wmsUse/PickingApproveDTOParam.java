package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.util.List;

public class PickingApproveDTOParam {
   private List<Long> ids;
   private List<Long> completeIds;
   private List<PickingApproveOutboundDTOParam> pickingOutDTOParamList;

   public static PickingApproveDTOParam.PickingApproveDTOParamBuilder builder() {
      return new PickingApproveDTOParam.PickingApproveDTOParamBuilder();
   }

   public List<Long> getIds() {
      return this.ids;
   }

   public List<Long> getCompleteIds() {
      return this.completeIds;
   }

   public List<PickingApproveOutboundDTOParam> getPickingOutDTOParamList() {
      return this.pickingOutDTOParamList;
   }

   public void setIds(final List<Long> ids) {
      this.ids = ids;
   }

   public void setCompleteIds(final List<Long> completeIds) {
      this.completeIds = completeIds;
   }

   public void setPickingOutDTOParamList(final List<PickingApproveOutboundDTOParam> pickingOutDTOParamList) {
      this.pickingOutDTOParamList = pickingOutDTOParamList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PickingApproveDTOParam)) {
         return false;
      }

      PickingApproveDTOParam other = (PickingApproveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$ids = this.getIds();
      Object other$ids = other.getIds();
      if (this$ids == null ? other$ids == null : this$ids.equals(other$ids)) {
         Object this$completeIds = this.getCompleteIds();
         Object other$completeIds = other.getCompleteIds();
         if (this$completeIds == null ? other$completeIds == null : this$completeIds.equals(other$completeIds)) {
            Object this$pickingOutDTOParamList = this.getPickingOutDTOParamList();
            Object other$pickingOutDTOParamList = other.getPickingOutDTOParamList();
            return this$pickingOutDTOParamList == null
               ? other$pickingOutDTOParamList == null
               : this$pickingOutDTOParamList.equals(other$pickingOutDTOParamList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PickingApproveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $ids = this.getIds();
      result = result * 59 + ($ids == null ? 43 : $ids.hashCode());
      Object $completeIds = this.getCompleteIds();
      result = result * 59 + ($completeIds == null ? 43 : $completeIds.hashCode());
      Object $pickingOutDTOParamList = this.getPickingOutDTOParamList();
      return result * 59 + ($pickingOutDTOParamList == null ? 43 : $pickingOutDTOParamList.hashCode());
   }

   @Override
   public String toString() {
      return "PickingApproveDTOParam(ids="
         + this.getIds()
         + ", completeIds="
         + this.getCompleteIds()
         + ", pickingOutDTOParamList="
         + this.getPickingOutDTOParamList()
         + ")";
   }

   public PickingApproveDTOParam(final List<Long> ids, final List<Long> completeIds, final List<PickingApproveOutboundDTOParam> pickingOutDTOParamList) {
      this.ids = ids;
      this.completeIds = completeIds;
      this.pickingOutDTOParamList = pickingOutDTOParamList;
   }

   public PickingApproveDTOParam() {
   }

   public static class PickingApproveDTOParamBuilder {
      private List<Long> ids;
      private List<Long> completeIds;
      private List<PickingApproveOutboundDTOParam> pickingOutDTOParamList;

      PickingApproveDTOParamBuilder() {
      }

      public PickingApproveDTOParam.PickingApproveDTOParamBuilder ids(final List<Long> ids) {
         this.ids = ids;
         return this;
      }

      public PickingApproveDTOParam.PickingApproveDTOParamBuilder completeIds(final List<Long> completeIds) {
         this.completeIds = completeIds;
         return this;
      }

      public PickingApproveDTOParam.PickingApproveDTOParamBuilder pickingOutDTOParamList(final List<PickingApproveOutboundDTOParam> pickingOutDTOParamList) {
         this.pickingOutDTOParamList = pickingOutDTOParamList;
         return this;
      }

      public PickingApproveDTOParam build() {
         return new PickingApproveDTOParam(this.ids, this.completeIds, this.pickingOutDTOParamList);
      }

      @Override
      public String toString() {
         return "PickingApproveDTOParam.PickingApproveDTOParamBuilder(ids="
            + this.ids
            + ", completeIds="
            + this.completeIds
            + ", pickingOutDTOParamList="
            + this.pickingOutDTOParamList
            + ")";
      }
   }
}
