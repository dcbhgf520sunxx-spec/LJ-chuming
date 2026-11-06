package com.hzchum.scim.common.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CargoPackVO", description = "发运装车限制")
public class CargoPackVO {
   @ApiModelProperty(name = "boolCrossMonomerCargo", notes = "是否可跨单体装车")
   private Boolean boolCrossMonomerCargo;
   @ApiModelProperty(name = "boolCrossMonomerPack", notes = "是否可跨单体打包")
   private Boolean boolCrossMonomerPack;

   public Boolean getBoolCrossMonomerCargo() {
      return this.boolCrossMonomerCargo;
   }

   public Boolean getBoolCrossMonomerPack() {
      return this.boolCrossMonomerPack;
   }

   public void setBoolCrossMonomerCargo(final Boolean boolCrossMonomerCargo) {
      this.boolCrossMonomerCargo = boolCrossMonomerCargo;
   }

   public void setBoolCrossMonomerPack(final Boolean boolCrossMonomerPack) {
      this.boolCrossMonomerPack = boolCrossMonomerPack;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CargoPackVO)) {
         return false;
      } else {
         CargoPackVO other = (CargoPackVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$boolCrossMonomerCargo = this.getBoolCrossMonomerCargo();
            Object other$boolCrossMonomerCargo = other.getBoolCrossMonomerCargo();
            if (this$boolCrossMonomerCargo == null ? other$boolCrossMonomerCargo == null : this$boolCrossMonomerCargo.equals(other$boolCrossMonomerCargo)) {
               Object this$boolCrossMonomerPack = this.getBoolCrossMonomerPack();
               Object other$boolCrossMonomerPack = other.getBoolCrossMonomerPack();
               return this$boolCrossMonomerPack == null ? other$boolCrossMonomerPack == null : this$boolCrossMonomerPack.equals(other$boolCrossMonomerPack);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CargoPackVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolCrossMonomerCargo = this.getBoolCrossMonomerCargo();
      result = result * 59 + ($boolCrossMonomerCargo == null ? 43 : $boolCrossMonomerCargo.hashCode());
      Object $boolCrossMonomerPack = this.getBoolCrossMonomerPack();
      return result * 59 + ($boolCrossMonomerPack == null ? 43 : $boolCrossMonomerPack.hashCode());
   }

   @Override
   public String toString() {
      return "CargoPackVO(boolCrossMonomerCargo=" + this.getBoolCrossMonomerCargo() + ", boolCrossMonomerPack=" + this.getBoolCrossMonomerPack() + ")";
   }
}
