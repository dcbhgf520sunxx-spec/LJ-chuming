package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.carGoDetail;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class RecentlyDespatchVO {
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   private String licensePlate;
   @ApiModelProperty(name = "serialNumber", value = "车次编号", notes = "车次编号")
   private String serialNumber;
   @ApiModelProperty(name = "actualWeight", value = "过磅净量", notes = "过磅净量")
   private BigDecimal actualWeight;

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getActualWeight() {
      return this.actualWeight;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setActualWeight(final BigDecimal actualWeight) {
      this.actualWeight = actualWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RecentlyDespatchVO)) {
         return false;
      }

      RecentlyDespatchVO other = (RecentlyDespatchVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$licensePlate = this.getLicensePlate();
      Object other$licensePlate = other.getLicensePlate();
      if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$actualWeight = this.getActualWeight();
            Object other$actualWeight = other.getActualWeight();
            return this$actualWeight == null ? other$actualWeight == null : this$actualWeight.equals(other$actualWeight);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RecentlyDespatchVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $actualWeight = this.getActualWeight();
      return result * 59 + ($actualWeight == null ? 43 : $actualWeight.hashCode());
   }

   @Override
   public String toString() {
      return "RecentlyDespatchVO(licensePlate="
         + this.getLicensePlate()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", actualWeight="
         + this.getActualWeight()
         + ")";
   }
}
