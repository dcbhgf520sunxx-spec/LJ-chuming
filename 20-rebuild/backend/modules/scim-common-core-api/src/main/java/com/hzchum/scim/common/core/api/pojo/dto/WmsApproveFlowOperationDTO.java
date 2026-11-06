package com.hzchum.scim.common.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo._do.WmsApproveFlowOperation;

public class WmsApproveFlowOperationDTO extends WmsApproveFlowOperation {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveFlowOperationDTO)) {
         return false;
      }

      WmsApproveFlowOperationDTO other = (WmsApproveFlowOperationDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsApproveFlowOperationDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "WmsApproveFlowOperationDTO()";
   }
}
