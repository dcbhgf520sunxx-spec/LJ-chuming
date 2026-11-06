package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.math.BigDecimal;

public class RealTimePurchaseAndInboundDTO {
   private String createTime;
   private String serialNumber;
   private String supplierName;
   private String basicClass;
   private BigDecimal contractAmount;
   private BigDecimal inboundAmount;
   private String status;

   public static RealTimePurchaseAndInboundDTO.RealTimePurchaseAndInboundDTOBuilder builder() {
      return new RealTimePurchaseAndInboundDTO.RealTimePurchaseAndInboundDTOBuilder();
   }

   public String getCreateTime() {
      return this.createTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getInboundAmount() {
      return this.inboundAmount;
   }

   public String getStatus() {
      return this.status;
   }

   public void setCreateTime(final String createTime) {
      this.createTime = createTime;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setBasicClass(final String basicClass) {
      this.basicClass = basicClass;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
   }

   public void setStatus(final String status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RealTimePurchaseAndInboundDTO)) {
         return false;
      }

      RealTimePurchaseAndInboundDTO other = (RealTimePurchaseAndInboundDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createTime = this.getCreateTime();
      Object other$createTime = other.getCreateTime();
      if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$supplierName = this.getSupplierName();
            Object other$supplierName = other.getSupplierName();
            if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$contractAmount = this.getContractAmount();
                  Object other$contractAmount = other.getContractAmount();
                  if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                     Object this$inboundAmount = this.getInboundAmount();
                     Object other$inboundAmount = other.getInboundAmount();
                     if (this$inboundAmount == null ? other$inboundAmount == null : this$inboundAmount.equals(other$inboundAmount)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        return this$status == null ? other$status == null : this$status.equals(other$status);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RealTimePurchaseAndInboundDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $inboundAmount = this.getInboundAmount();
      result = result * 59 + ($inboundAmount == null ? 43 : $inboundAmount.hashCode());
      Object $status = this.getStatus();
      return result * 59 + ($status == null ? 43 : $status.hashCode());
   }

   @Override
   public String toString() {
      return "RealTimePurchaseAndInboundDTO(createTime="
         + this.getCreateTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", supplierName="
         + this.getSupplierName()
         + ", basicClass="
         + this.getBasicClass()
         + ", contractAmount="
         + this.getContractAmount()
         + ", inboundAmount="
         + this.getInboundAmount()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public RealTimePurchaseAndInboundDTO(
      final String createTime,
      final String serialNumber,
      final String supplierName,
      final String basicClass,
      final BigDecimal contractAmount,
      final BigDecimal inboundAmount,
      final String status
   ) {
      this.createTime = createTime;
      this.serialNumber = serialNumber;
      this.supplierName = supplierName;
      this.basicClass = basicClass;
      this.contractAmount = contractAmount;
      this.inboundAmount = inboundAmount;
      this.status = status;
   }

   public RealTimePurchaseAndInboundDTO() {
   }

   public static class RealTimePurchaseAndInboundDTOBuilder {
      private String createTime;
      private String serialNumber;
      private String supplierName;
      private String basicClass;
      private BigDecimal contractAmount;
      private BigDecimal inboundAmount;
      private String status;

      RealTimePurchaseAndInboundDTOBuilder() {
      }

      public RealTimePurchaseAndInboundDTO.RealTimePurchaseAndInboundDTOBuilder createTime(final String createTime) {
         this.createTime = createTime;
         return this;
      }

      public RealTimePurchaseAndInboundDTO.RealTimePurchaseAndInboundDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public RealTimePurchaseAndInboundDTO.RealTimePurchaseAndInboundDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public RealTimePurchaseAndInboundDTO.RealTimePurchaseAndInboundDTOBuilder basicClass(final String basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public RealTimePurchaseAndInboundDTO.RealTimePurchaseAndInboundDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public RealTimePurchaseAndInboundDTO.RealTimePurchaseAndInboundDTOBuilder inboundAmount(final BigDecimal inboundAmount) {
         this.inboundAmount = inboundAmount;
         return this;
      }

      public RealTimePurchaseAndInboundDTO.RealTimePurchaseAndInboundDTOBuilder status(final String status) {
         this.status = status;
         return this;
      }

      public RealTimePurchaseAndInboundDTO build() {
         return new RealTimePurchaseAndInboundDTO(
            this.createTime, this.serialNumber, this.supplierName, this.basicClass, this.contractAmount, this.inboundAmount, this.status
         );
      }

      @Override
      public String toString() {
         return "RealTimePurchaseAndInboundDTO.RealTimePurchaseAndInboundDTOBuilder(createTime="
            + this.createTime
            + ", serialNumber="
            + this.serialNumber
            + ", supplierName="
            + this.supplierName
            + ", basicClass="
            + this.basicClass
            + ", contractAmount="
            + this.contractAmount
            + ", inboundAmount="
            + this.inboundAmount
            + ", status="
            + this.status
            + ")";
      }
   }
}
