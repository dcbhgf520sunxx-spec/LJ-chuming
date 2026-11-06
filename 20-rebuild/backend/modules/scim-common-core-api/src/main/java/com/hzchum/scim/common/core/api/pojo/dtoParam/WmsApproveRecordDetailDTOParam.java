package com.hzchum.scim.common.core.api.pojo.dtoParam;

import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import java.io.Serializable;

public class WmsApproveRecordDetailDTOParam extends WmsApproveRecordDetail implements Serializable {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveRecordDetailDTOParam)) {
         return false;
      }

      WmsApproveRecordDetailDTOParam other = (WmsApproveRecordDetailDTOParam)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsApproveRecordDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "WmsApproveRecordDetailDTOParam()";
   }
}
