package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.util.List;

public class UpdateOutboundDTOParam {
   private Long id;
   private List<Long> deleteDetailIds;
   private List<SteelPlateOutboundDTOParam> list;

   public static UpdateOutboundDTOParam.UpdateOutboundDTOParamBuilder builder() {
      return new UpdateOutboundDTOParam.UpdateOutboundDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public List<Long> getDeleteDetailIds() {
      return this.deleteDetailIds;
   }

   public List<SteelPlateOutboundDTOParam> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setDeleteDetailIds(final List<Long> deleteDetailIds) {
      this.deleteDetailIds = deleteDetailIds;
   }

   public void setList(final List<SteelPlateOutboundDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UpdateOutboundDTOParam)) {
         return false;
      }

      UpdateOutboundDTOParam other = (UpdateOutboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$deleteDetailIds = this.getDeleteDetailIds();
         Object other$deleteDetailIds = other.getDeleteDetailIds();
         if (this$deleteDetailIds == null ? other$deleteDetailIds == null : this$deleteDetailIds.equals(other$deleteDetailIds)) {
            Object this$list = this.getList();
            Object other$list = other.getList();
            return this$list == null ? other$list == null : this$list.equals(other$list);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UpdateOutboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $deleteDetailIds = this.getDeleteDetailIds();
      result = result * 59 + ($deleteDetailIds == null ? 43 : $deleteDetailIds.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "UpdateOutboundDTOParam(id=" + this.getId() + ", deleteDetailIds=" + this.getDeleteDetailIds() + ", list=" + this.getList() + ")";
   }

   public UpdateOutboundDTOParam(final Long id, final List<Long> deleteDetailIds, final List<SteelPlateOutboundDTOParam> list) {
      this.id = id;
      this.deleteDetailIds = deleteDetailIds;
      this.list = list;
   }

   public UpdateOutboundDTOParam() {
   }

   public static class UpdateOutboundDTOParamBuilder {
      private Long id;
      private List<Long> deleteDetailIds;
      private List<SteelPlateOutboundDTOParam> list;

      UpdateOutboundDTOParamBuilder() {
      }

      public UpdateOutboundDTOParam.UpdateOutboundDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public UpdateOutboundDTOParam.UpdateOutboundDTOParamBuilder deleteDetailIds(final List<Long> deleteDetailIds) {
         this.deleteDetailIds = deleteDetailIds;
         return this;
      }

      public UpdateOutboundDTOParam.UpdateOutboundDTOParamBuilder list(final List<SteelPlateOutboundDTOParam> list) {
         this.list = list;
         return this;
      }

      public UpdateOutboundDTOParam build() {
         return new UpdateOutboundDTOParam(this.id, this.deleteDetailIds, this.list);
      }

      @Override
      public String toString() {
         return "UpdateOutboundDTOParam.UpdateOutboundDTOParamBuilder(id="
            + this.id
            + ", deleteDetailIds="
            + this.deleteDetailIds
            + ", list="
            + this.list
            + ")";
      }
   }
}
