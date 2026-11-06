package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.util.List;

public class APPInboundPassDTOParam {
   private Long id;
   List<InboundDetailDTOParam> list;

   public Long getId() {
      return this.id;
   }

   public List<InboundDetailDTOParam> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setList(final List<InboundDetailDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof APPInboundPassDTOParam)) {
         return false;
      } else {
         APPInboundPassDTOParam other = (APPInboundPassDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
      return other instanceof APPInboundPassDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "APPInboundPassDTOParam(id=" + this.getId() + ", list=" + this.getList() + ")";
   }
}
