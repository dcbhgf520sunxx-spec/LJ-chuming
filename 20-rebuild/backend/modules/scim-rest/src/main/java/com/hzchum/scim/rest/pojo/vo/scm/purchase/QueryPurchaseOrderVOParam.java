package com.hzchum.scim.rest.pojo.vo.scm.purchase;

import com.hzchum.scim.scm.core.api.pojo.dtoParam.QueryPurchaseOrderDTOParam;

public class QueryPurchaseOrderVOParam extends QueryPurchaseOrderDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryPurchaseOrderVOParam)) {
         return false;
      }

      QueryPurchaseOrderVOParam other = (QueryPurchaseOrderVOParam)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof QueryPurchaseOrderVOParam;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "QueryPurchaseOrderVOParam()";
   }
}
