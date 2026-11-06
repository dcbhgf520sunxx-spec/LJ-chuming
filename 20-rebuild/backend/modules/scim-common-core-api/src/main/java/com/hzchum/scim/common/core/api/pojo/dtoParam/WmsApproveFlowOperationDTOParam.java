package com.hzchum.scim.common.core.api.pojo.dtoParam;

import com.hzchum.scim.common.core.api.pojo._do.WmsApproveFlowOperation;

public class WmsApproveFlowOperationDTOParam extends WmsApproveFlowOperation {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveFlowOperationDTOParam)) {
         return false;
      }

      WmsApproveFlowOperationDTOParam other = (WmsApproveFlowOperationDTOParam)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsApproveFlowOperationDTOParam;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "WmsApproveFlowOperationDTOParam()";
   }
}
