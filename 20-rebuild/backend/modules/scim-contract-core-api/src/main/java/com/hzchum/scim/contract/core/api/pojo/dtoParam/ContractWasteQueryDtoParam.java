package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ContractWaste对象", description = "废料合同表 ")
public class ContractWasteQueryDtoParam {
   @ApiModelProperty(name = "serialNumber", value = "合同编号", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "purchaser", value = "购买方", notes = "购买方")
   private String purchaser;
   @ApiModelProperty(name = "userName", value = "创建人", notes = "创建人")
   private String userName;

   public static ContractWasteQueryDtoParam.ContractWasteQueryDtoParamBuilder builder() {
      return new ContractWasteQueryDtoParam.ContractWasteQueryDtoParamBuilder();
   }

   public ContractWasteQueryDtoParam() {
   }

   public ContractWasteQueryDtoParam(final String serialNumber, final String purchaser, final String userName) {
      this.serialNumber = serialNumber;
      this.purchaser = purchaser;
      this.userName = userName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPurchaser() {
      return this.purchaser;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPurchaser(final String purchaser) {
      this.purchaser = purchaser;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWasteQueryDtoParam)) {
         return false;
      }

      ContractWasteQueryDtoParam other = (ContractWasteQueryDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$serialNumber = this.getSerialNumber();
      Object other$serialNumber = other.getSerialNumber();
      if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
         Object this$purchaser = this.getPurchaser();
         Object other$purchaser = other.getPurchaser();
         if (this$purchaser == null ? other$purchaser == null : this$purchaser.equals(other$purchaser)) {
            Object this$userName = this.getUserName();
            Object other$userName = other.getUserName();
            return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractWasteQueryDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaser = this.getPurchaser();
      result = result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWasteQueryDtoParam(serialNumber="
         + this.getSerialNumber()
         + ", purchaser="
         + this.getPurchaser()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   public static class ContractWasteQueryDtoParamBuilder {
      private String serialNumber;
      private String purchaser;
      private String userName;

      ContractWasteQueryDtoParamBuilder() {
      }

      public ContractWasteQueryDtoParam.ContractWasteQueryDtoParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ContractWasteQueryDtoParam.ContractWasteQueryDtoParamBuilder purchaser(final String purchaser) {
         this.purchaser = purchaser;
         return this;
      }

      public ContractWasteQueryDtoParam.ContractWasteQueryDtoParamBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ContractWasteQueryDtoParam build() {
         return new ContractWasteQueryDtoParam(this.serialNumber, this.purchaser, this.userName);
      }

      @Override
      public String toString() {
         return "ContractWasteQueryDtoParam.ContractWasteQueryDtoParamBuilder(serialNumber="
            + this.serialNumber
            + ", purchaser="
            + this.purchaser
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
