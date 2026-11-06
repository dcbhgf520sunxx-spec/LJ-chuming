package com.hzchum.scim.rest.pojo.vo.scm.purchase;

import com.hzchum.scim.scm.core.api.pojo.dtoParam.PurchaseOrderDTOParam;

public class PurchaseOrderVORequest extends PurchaseOrderDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseOrderVORequest)) {
         return false;
      }

      PurchaseOrderVORequest other = (PurchaseOrderVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof PurchaseOrderVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "PurchaseOrderVORequest()";
   }
}
