package com.hzchum.scim.rest.pojo.vo.scm.supplier;

import com.hzchum.scim.scm.core.api.pojo.dtoParam.SupplierDTOParam;

public class SupplierVORequest extends SupplierDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierVORequest)) {
         return false;
      }

      SupplierVORequest other = (SupplierVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SupplierVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "SupplierVORequest()";
   }
}
