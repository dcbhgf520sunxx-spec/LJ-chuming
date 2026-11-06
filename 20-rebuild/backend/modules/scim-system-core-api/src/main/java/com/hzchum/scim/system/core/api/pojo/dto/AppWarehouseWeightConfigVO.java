package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class AppWarehouseWeightConfigVO {
   @ApiModelProperty("打包:显示0，净重，1.毛重)")
   @NotNull(message = "打包:显示0，净重，1.毛重")
   private Integer pack;
   @ApiModelProperty("装车:显示0，净重，1.毛重)")
   @NotNull(message = "装车:显示0，净重，1.毛重")
   private Integer carLoading;
   @ApiModelProperty("货物过磅:显示0，净重，1.毛重)")
   @NotNull(message = "货物过磅:显示0，净重，1.毛重")
   private Integer WeighingGoods;
   @ApiModelProperty("出库复核:显示0，净重，1.毛重)")
   @NotNull(message = "出库复核:显示0，净重，1.毛重")
   private Integer CheckOutWarehouse;
   @ApiModelProperty("物流管理:显示0，净重，1.毛重)")
   @NotNull(message = "物流管理:显示0，净重，1.毛重")
   private Integer LogisticsManagement;
   @ApiModelProperty("收货:显示0，净重，1.毛重)")
   @NotNull(message = "收货:显示0，净重，1.毛重")
   private Integer ReceiveGoods;

   public Integer getPack() {
      return this.pack;
   }

   public Integer getCarLoading() {
      return this.carLoading;
   }

   public Integer getWeighingGoods() {
      return this.WeighingGoods;
   }

   public Integer getCheckOutWarehouse() {
      return this.CheckOutWarehouse;
   }

   public Integer getLogisticsManagement() {
      return this.LogisticsManagement;
   }

   public Integer getReceiveGoods() {
      return this.ReceiveGoods;
   }

   public void setPack(final Integer pack) {
      this.pack = pack;
   }

   public void setCarLoading(final Integer carLoading) {
      this.carLoading = carLoading;
   }

   public void setWeighingGoods(final Integer WeighingGoods) {
      this.WeighingGoods = WeighingGoods;
   }

   public void setCheckOutWarehouse(final Integer CheckOutWarehouse) {
      this.CheckOutWarehouse = CheckOutWarehouse;
   }

   public void setLogisticsManagement(final Integer LogisticsManagement) {
      this.LogisticsManagement = LogisticsManagement;
   }

   public void setReceiveGoods(final Integer ReceiveGoods) {
      this.ReceiveGoods = ReceiveGoods;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppWarehouseWeightConfigVO)) {
         return false;
      }

      AppWarehouseWeightConfigVO other = (AppWarehouseWeightConfigVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pack = this.getPack();
      Object other$pack = other.getPack();
      if (this$pack == null ? other$pack == null : this$pack.equals(other$pack)) {
         Object this$carLoading = this.getCarLoading();
         Object other$carLoading = other.getCarLoading();
         if (this$carLoading == null ? other$carLoading == null : this$carLoading.equals(other$carLoading)) {
            Object this$WeighingGoods = this.getWeighingGoods();
            Object other$WeighingGoods = other.getWeighingGoods();
            if (this$WeighingGoods == null ? other$WeighingGoods == null : this$WeighingGoods.equals(other$WeighingGoods)) {
               Object this$CheckOutWarehouse = this.getCheckOutWarehouse();
               Object other$CheckOutWarehouse = other.getCheckOutWarehouse();
               if (this$CheckOutWarehouse == null ? other$CheckOutWarehouse == null : this$CheckOutWarehouse.equals(other$CheckOutWarehouse)) {
                  Object this$LogisticsManagement = this.getLogisticsManagement();
                  Object other$LogisticsManagement = other.getLogisticsManagement();
                  if (this$LogisticsManagement == null ? other$LogisticsManagement == null : this$LogisticsManagement.equals(other$LogisticsManagement)) {
                     Object this$ReceiveGoods = this.getReceiveGoods();
                     Object other$ReceiveGoods = other.getReceiveGoods();
                     return this$ReceiveGoods == null ? other$ReceiveGoods == null : this$ReceiveGoods.equals(other$ReceiveGoods);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppWarehouseWeightConfigVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pack = this.getPack();
      result = result * 59 + ($pack == null ? 43 : $pack.hashCode());
      Object $carLoading = this.getCarLoading();
      result = result * 59 + ($carLoading == null ? 43 : $carLoading.hashCode());
      Object $WeighingGoods = this.getWeighingGoods();
      result = result * 59 + ($WeighingGoods == null ? 43 : $WeighingGoods.hashCode());
      Object $CheckOutWarehouse = this.getCheckOutWarehouse();
      result = result * 59 + ($CheckOutWarehouse == null ? 43 : $CheckOutWarehouse.hashCode());
      Object $LogisticsManagement = this.getLogisticsManagement();
      result = result * 59 + ($LogisticsManagement == null ? 43 : $LogisticsManagement.hashCode());
      Object $ReceiveGoods = this.getReceiveGoods();
      return result * 59 + ($ReceiveGoods == null ? 43 : $ReceiveGoods.hashCode());
   }

   @Override
   public String toString() {
      return "AppWarehouseWeightConfigVO(pack="
         + this.getPack()
         + ", carLoading="
         + this.getCarLoading()
         + ", WeighingGoods="
         + this.getWeighingGoods()
         + ", CheckOutWarehouse="
         + this.getCheckOutWarehouse()
         + ", LogisticsManagement="
         + this.getLogisticsManagement()
         + ", ReceiveGoods="
         + this.getReceiveGoods()
         + ")";
   }
}
