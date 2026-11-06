package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import java.util.List;

public class InboundCrossDTOParam {
   private Long id;
   private Long outboundId;
   List<MaterialInventory> list;

   public Long getId() {
      return this.id;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public List<MaterialInventory> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
   }

   public void setList(final List<MaterialInventory> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundCrossDTOParam)) {
         return false;
      }

      InboundCrossDTOParam other = (InboundCrossDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$outboundId = this.getOutboundId();
         Object other$outboundId = other.getOutboundId();
         if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
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
      return other instanceof InboundCrossDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "InboundCrossDTOParam(id=" + this.getId() + ", outboundId=" + this.getOutboundId() + ", list=" + this.getList() + ")";
   }

   public InboundCrossDTOParam(final Long id, final Long outboundId, final List<MaterialInventory> list) {
      this.id = id;
      this.outboundId = outboundId;
      this.list = list;
   }

   public InboundCrossDTOParam() {
   }
}
