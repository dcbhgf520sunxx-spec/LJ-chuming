package com.hzchum.scim.rest.pojo.vo.scm.purchase;

import com.hzchum.scim.scm.core.api.pojo.dtoParam.QueryScmLumpSumSystemPurchaseOrderDTOParam;

public class QueryScmLumpSumSystemPurchaseOrderVOParam extends QueryScmLumpSumSystemPurchaseOrderDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryScmLumpSumSystemPurchaseOrderVOParam)) {
         return false;
      }

      QueryScmLumpSumSystemPurchaseOrderVOParam other = (QueryScmLumpSumSystemPurchaseOrderVOParam)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof QueryScmLumpSumSystemPurchaseOrderVOParam;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "QueryScmLumpSumSystemPurchaseOrderVOParam()";
   }
}
