package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import java.util.List;
import javax.validation.constraints.NotNull;

public class PartyAReturnDTOParam {
   @NotNull(message = "借用单ID不能为空")
   private Long id;
   @NotNull(message = "归还工厂不能为空")
   private Long workshopId;
   @NotNull(message = "归还仓库不能为空")
   private Long warehouseId;
   List<PartyAReturnDetailDTOParam> list;

   public static PartyAReturnDTOParam.PartyAReturnDTOParamBuilder builder() {
      return new PartyAReturnDTOParam.PartyAReturnDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public List<PartyAReturnDetailDTOParam> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setList(final List<PartyAReturnDetailDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PartyAReturnDTOParam)) {
         return false;
      }

      PartyAReturnDTOParam other = (PartyAReturnDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$warehouseId = this.getWarehouseId();
            Object other$warehouseId = other.getWarehouseId();
            if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
               Object this$list = this.getList();
               Object other$list = other.getList();
               return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof PartyAReturnDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "PartyAReturnDTOParam(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", list="
         + this.getList()
         + ")";
   }

   public PartyAReturnDTOParam(final Long id, final Long workshopId, final Long warehouseId, final List<PartyAReturnDetailDTOParam> list) {
      this.id = id;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.list = list;
   }

   public PartyAReturnDTOParam() {
   }

   public static class PartyAReturnDTOParamBuilder {
      private Long id;
      private Long workshopId;
      private Long warehouseId;
      private List<PartyAReturnDetailDTOParam> list;

      PartyAReturnDTOParamBuilder() {
      }

      public PartyAReturnDTOParam.PartyAReturnDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PartyAReturnDTOParam.PartyAReturnDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public PartyAReturnDTOParam.PartyAReturnDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public PartyAReturnDTOParam.PartyAReturnDTOParamBuilder list(final List<PartyAReturnDetailDTOParam> list) {
         this.list = list;
         return this;
      }

      public PartyAReturnDTOParam build() {
         return new PartyAReturnDTOParam(this.id, this.workshopId, this.warehouseId, this.list);
      }

      @Override
      public String toString() {
         return "PartyAReturnDTOParam.PartyAReturnDTOParamBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", list="
            + this.list
            + ")";
      }
   }
}
