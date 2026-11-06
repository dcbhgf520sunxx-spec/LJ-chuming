package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ContractWaste对象", description = "废料合同表 ")
public class ContractWasteInfo {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "合同编号", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "purchaser", value = "购买方", notes = "购买方")
   private String purchaser;

   public static ContractWasteInfo.ContractWasteInfoBuilder builder() {
      return new ContractWasteInfo.ContractWasteInfoBuilder();
   }

   public ContractWasteInfo() {
   }

   public ContractWasteInfo(final Long id, final String serialNumber, final String purchaser) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.purchaser = purchaser;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPurchaser() {
      return this.purchaser;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPurchaser(final String purchaser) {
      this.purchaser = purchaser;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWasteInfo)) {
         return false;
      }

      ContractWasteInfo other = (ContractWasteInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$purchaser = this.getPurchaser();
            Object other$purchaser = other.getPurchaser();
            return this$purchaser == null ? other$purchaser == null : this$purchaser.equals(other$purchaser);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractWasteInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaser = this.getPurchaser();
      return result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWasteInfo(id=" + this.getId() + ", serialNumber=" + this.getSerialNumber() + ", purchaser=" + this.getPurchaser() + ")";
   }

   public static class ContractWasteInfoBuilder {
      private Long id;
      private String serialNumber;
      private String purchaser;

      ContractWasteInfoBuilder() {
      }

      public ContractWasteInfo.ContractWasteInfoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractWasteInfo.ContractWasteInfoBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ContractWasteInfo.ContractWasteInfoBuilder purchaser(final String purchaser) {
         this.purchaser = purchaser;
         return this;
      }

      public ContractWasteInfo build() {
         return new ContractWasteInfo(this.id, this.serialNumber, this.purchaser);
      }

      @Override
      public String toString() {
         return "ContractWasteInfo.ContractWasteInfoBuilder(id=" + this.id + ", serialNumber=" + this.serialNumber + ", purchaser=" + this.purchaser + ")";
      }
   }
}
