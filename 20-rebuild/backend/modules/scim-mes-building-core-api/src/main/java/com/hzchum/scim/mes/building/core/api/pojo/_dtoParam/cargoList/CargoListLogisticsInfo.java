package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "物流信息")
public class CargoListLogisticsInfo {
   @ApiModelProperty("价格详情id")
   private Long supplierPriceId;
   @ApiModelProperty("车型")
   private String carModel;
   @ApiModelProperty("收货人")
   private String receiptName;
   @ApiModelProperty("收货人电话")
   private String receiptPhone;

   public Long getSupplierPriceId() {
      return this.supplierPriceId;
   }

   public String getCarModel() {
      return this.carModel;
   }

   public String getReceiptName() {
      return this.receiptName;
   }

   public String getReceiptPhone() {
      return this.receiptPhone;
   }

   public void setSupplierPriceId(final Long supplierPriceId) {
      this.supplierPriceId = supplierPriceId;
   }

   public void setCarModel(final String carModel) {
      this.carModel = carModel;
   }

   public void setReceiptName(final String receiptName) {
      this.receiptName = receiptName;
   }

   public void setReceiptPhone(final String receiptPhone) {
      this.receiptPhone = receiptPhone;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListLogisticsInfo)) {
         return false;
      }

      CargoListLogisticsInfo other = (CargoListLogisticsInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierPriceId = this.getSupplierPriceId();
      Object other$supplierPriceId = other.getSupplierPriceId();
      if (this$supplierPriceId == null ? other$supplierPriceId == null : this$supplierPriceId.equals(other$supplierPriceId)) {
         Object this$carModel = this.getCarModel();
         Object other$carModel = other.getCarModel();
         if (this$carModel == null ? other$carModel == null : this$carModel.equals(other$carModel)) {
            Object this$receiptName = this.getReceiptName();
            Object other$receiptName = other.getReceiptName();
            if (this$receiptName == null ? other$receiptName == null : this$receiptName.equals(other$receiptName)) {
               Object this$receiptPhone = this.getReceiptPhone();
               Object other$receiptPhone = other.getReceiptPhone();
               return this$receiptPhone == null ? other$receiptPhone == null : this$receiptPhone.equals(other$receiptPhone);
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
      return other instanceof CargoListLogisticsInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierPriceId = this.getSupplierPriceId();
      result = result * 59 + ($supplierPriceId == null ? 43 : $supplierPriceId.hashCode());
      Object $carModel = this.getCarModel();
      result = result * 59 + ($carModel == null ? 43 : $carModel.hashCode());
      Object $receiptName = this.getReceiptName();
      result = result * 59 + ($receiptName == null ? 43 : $receiptName.hashCode());
      Object $receiptPhone = this.getReceiptPhone();
      return result * 59 + ($receiptPhone == null ? 43 : $receiptPhone.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListLogisticsInfo(supplierPriceId="
         + this.getSupplierPriceId()
         + ", carModel="
         + this.getCarModel()
         + ", receiptName="
         + this.getReceiptName()
         + ", receiptPhone="
         + this.getReceiptPhone()
         + ")";
   }
}
