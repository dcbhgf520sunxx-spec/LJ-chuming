package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WarehouseDTOParam;
import java.util.List;

public class BatchWarehouseDTOParam {
   private Long workshopId;
   private List<WarehouseDTOParam> list;

   public static BatchWarehouseDTOParam.BatchWarehouseDTOParamBuilder builder() {
      return new BatchWarehouseDTOParam.BatchWarehouseDTOParamBuilder();
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public List<WarehouseDTOParam> getList() {
      return this.list;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setList(final List<WarehouseDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BatchWarehouseDTOParam)) {
         return false;
      } else {
         BatchWarehouseDTOParam other = (BatchWarehouseDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$list = this.getList();
               Object other$list = other.getList();
               return this$list == null ? other$list == null : this$list.equals(other$list);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BatchWarehouseDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "BatchWarehouseDTOParam(workshopId=" + this.getWorkshopId() + ", list=" + this.getList() + ")";
   }

   public BatchWarehouseDTOParam(final Long workshopId, final List<WarehouseDTOParam> list) {
      this.workshopId = workshopId;
      this.list = list;
   }

   public BatchWarehouseDTOParam() {
   }

   public static class BatchWarehouseDTOParamBuilder {
      private Long workshopId;
      private List<WarehouseDTOParam> list;

      BatchWarehouseDTOParamBuilder() {
      }

      public BatchWarehouseDTOParam.BatchWarehouseDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public BatchWarehouseDTOParam.BatchWarehouseDTOParamBuilder list(final List<WarehouseDTOParam> list) {
         this.list = list;
         return this;
      }

      public BatchWarehouseDTOParam build() {
         return new BatchWarehouseDTOParam(this.workshopId, this.list);
      }

      @Override
      public String toString() {
         return "BatchWarehouseDTOParam.BatchWarehouseDTOParamBuilder(workshopId=" + this.workshopId + ", list=" + this.list + ")";
      }
   }
}
