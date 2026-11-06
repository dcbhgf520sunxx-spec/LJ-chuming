package com.hzchum.scim.mes.building.core.api.pojo._do.warehouse;

import com.hzchum.scim.common.core.api.pojo.common.EnclosureBaseInfo;
import io.swagger.annotations.ApiModel;

@ApiModel("入发存报表围护详情")
public class WarehouseReportEnclosureDO extends EnclosureBaseInfo {
   WarehouseReportEnclosureDO() {
   }

   public static WarehouseReportEnclosureDO.WarehouseReportEnclosureDOBuilder builder() {
      return new WarehouseReportEnclosureDO.WarehouseReportEnclosureDOBuilder();
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseReportEnclosureDO)) {
         return false;
      }

      WarehouseReportEnclosureDO other = (WarehouseReportEnclosureDO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WarehouseReportEnclosureDO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "WarehouseReportEnclosureDO()";
   }

   public static class WarehouseReportEnclosureDOBuilder {
      WarehouseReportEnclosureDOBuilder() {
      }

      public WarehouseReportEnclosureDO build() {
         return new WarehouseReportEnclosureDO();
      }

      @Override
      public String toString() {
         return "WarehouseReportEnclosureDO.WarehouseReportEnclosureDOBuilder()";
      }
   }
}
