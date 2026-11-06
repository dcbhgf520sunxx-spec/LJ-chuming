package com.hzchum.scim.mes.enclosure.core.api.pojo._do.warehouse;

import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import io.swagger.annotations.ApiModel;

@ApiModel("入发存报表构件详情")
public class WarehouseReportArtifactDO extends ArtifactBaseInfo {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseReportArtifactDO)) {
         return false;
      }

      WarehouseReportArtifactDO other = (WarehouseReportArtifactDO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WarehouseReportArtifactDO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "WarehouseReportArtifactDO()";
   }
}
