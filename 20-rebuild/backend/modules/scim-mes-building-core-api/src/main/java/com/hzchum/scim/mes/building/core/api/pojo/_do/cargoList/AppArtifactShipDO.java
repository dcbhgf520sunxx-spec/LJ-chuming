package com.hzchum.scim.mes.building.core.api.pojo._do.cargoList;

import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "构件发运记录")
public class AppArtifactShipDO extends ArtifactBaseInfo {
   @ApiModelProperty(notes = "车牌")
   private String licensePlate;

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppArtifactShipDO)) {
         return false;
      }

      AppArtifactShipDO other = (AppArtifactShipDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$licensePlate = this.getLicensePlate();
      Object other$licensePlate = other.getLicensePlate();
      return this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof AppArtifactShipDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $licensePlate = this.getLicensePlate();
      return result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
   }

   @Override
   public String toString() {
      return "AppArtifactShipDO(licensePlate=" + this.getLicensePlate() + ")";
   }
}
