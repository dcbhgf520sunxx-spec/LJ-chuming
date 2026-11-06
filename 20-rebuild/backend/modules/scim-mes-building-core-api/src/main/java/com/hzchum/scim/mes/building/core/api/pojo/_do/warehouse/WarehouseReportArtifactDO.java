package com.hzchum.scim.mes.building.core.api.pojo._do.warehouse;

import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("入发存报表构件详情")
public class WarehouseReportArtifactDO extends ArtifactBaseInfo {
   @ApiModelProperty(notes = "包单号")
   private String packSerialNumber;

   public String getPackSerialNumber() {
      return this.packSerialNumber;
   }

   public void setPackSerialNumber(final String packSerialNumber) {
      this.packSerialNumber = packSerialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseReportArtifactDO)) {
         return false;
      }

      WarehouseReportArtifactDO other = (WarehouseReportArtifactDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$packSerialNumber = this.getPackSerialNumber();
      Object other$packSerialNumber = other.getPackSerialNumber();
      return this$packSerialNumber == null ? other$packSerialNumber == null : this$packSerialNumber.equals(other$packSerialNumber);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WarehouseReportArtifactDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $packSerialNumber = this.getPackSerialNumber();
      return result * 59 + ($packSerialNumber == null ? 43 : $packSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseReportArtifactDO(packSerialNumber=" + this.getPackSerialNumber() + ")";
   }
}
