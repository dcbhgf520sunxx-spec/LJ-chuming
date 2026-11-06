package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(description = "物流记录")
public class CargoListSupplierDTO {
   @ApiModelProperty("发运时间")
   private LocalDateTime auditTime;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("装载类型")
   private Integer productType;
   @ApiModelProperty("过磅重量")
   private BigDecimal actualWeight;
   @ApiModelProperty("物流价格")
   private BigDecimal supplierPrice;
   @ApiModelProperty("运费：重量记 = 重量 * 物流价格；车次记 = 物流价格")
   private BigDecimal fare;

   CargoListSupplierDTO(
      final LocalDateTime auditTime,
      final String licensePlate,
      final Integer productType,
      final BigDecimal actualWeight,
      final BigDecimal supplierPrice,
      final BigDecimal fare
   ) {
      this.auditTime = auditTime;
      this.licensePlate = licensePlate;
      this.productType = productType;
      this.actualWeight = actualWeight;
      this.supplierPrice = supplierPrice;
      this.fare = fare;
   }

   public static CargoListSupplierDTO.CargoListSupplierDTOBuilder builder() {
      return new CargoListSupplierDTO.CargoListSupplierDTOBuilder();
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public BigDecimal getActualWeight() {
      return this.actualWeight;
   }

   public BigDecimal getSupplierPrice() {
      return this.supplierPrice;
   }

   public BigDecimal getFare() {
      return this.fare;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setActualWeight(final BigDecimal actualWeight) {
      this.actualWeight = actualWeight;
   }

   public void setSupplierPrice(final BigDecimal supplierPrice) {
      this.supplierPrice = supplierPrice;
   }

   public void setFare(final BigDecimal fare) {
      this.fare = fare;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListSupplierDTO)) {
         return false;
      }

      CargoListSupplierDTO other = (CargoListSupplierDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$auditTime = this.getAuditTime();
         Object other$auditTime = other.getAuditTime();
         if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
            Object this$licensePlate = this.getLicensePlate();
            Object other$licensePlate = other.getLicensePlate();
            if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
               Object this$actualWeight = this.getActualWeight();
               Object other$actualWeight = other.getActualWeight();
               if (this$actualWeight == null ? other$actualWeight == null : this$actualWeight.equals(other$actualWeight)) {
                  Object this$supplierPrice = this.getSupplierPrice();
                  Object other$supplierPrice = other.getSupplierPrice();
                  if (this$supplierPrice == null ? other$supplierPrice == null : this$supplierPrice.equals(other$supplierPrice)) {
                     Object this$fare = this.getFare();
                     Object other$fare = other.getFare();
                     return this$fare == null ? other$fare == null : this$fare.equals(other$fare);
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
      return other instanceof CargoListSupplierDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $actualWeight = this.getActualWeight();
      result = result * 59 + ($actualWeight == null ? 43 : $actualWeight.hashCode());
      Object $supplierPrice = this.getSupplierPrice();
      result = result * 59 + ($supplierPrice == null ? 43 : $supplierPrice.hashCode());
      Object $fare = this.getFare();
      return result * 59 + ($fare == null ? 43 : $fare.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListSupplierDTO(auditTime="
         + this.getAuditTime()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", productType="
         + this.getProductType()
         + ", actualWeight="
         + this.getActualWeight()
         + ", supplierPrice="
         + this.getSupplierPrice()
         + ", fare="
         + this.getFare()
         + ")";
   }

   public static class CargoListSupplierDTOBuilder {
      private LocalDateTime auditTime;
      private String licensePlate;
      private Integer productType;
      private BigDecimal actualWeight;
      private BigDecimal supplierPrice;
      private BigDecimal fare;

      CargoListSupplierDTOBuilder() {
      }

      public CargoListSupplierDTO.CargoListSupplierDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public CargoListSupplierDTO.CargoListSupplierDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public CargoListSupplierDTO.CargoListSupplierDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public CargoListSupplierDTO.CargoListSupplierDTOBuilder actualWeight(final BigDecimal actualWeight) {
         this.actualWeight = actualWeight;
         return this;
      }

      public CargoListSupplierDTO.CargoListSupplierDTOBuilder supplierPrice(final BigDecimal supplierPrice) {
         this.supplierPrice = supplierPrice;
         return this;
      }

      public CargoListSupplierDTO.CargoListSupplierDTOBuilder fare(final BigDecimal fare) {
         this.fare = fare;
         return this;
      }

      public CargoListSupplierDTO build() {
         return new CargoListSupplierDTO(this.auditTime, this.licensePlate, this.productType, this.actualWeight, this.supplierPrice, this.fare);
      }

      @Override
      public String toString() {
         return "CargoListSupplierDTO.CargoListSupplierDTOBuilder(auditTime="
            + this.auditTime
            + ", licensePlate="
            + this.licensePlate
            + ", productType="
            + this.productType
            + ", actualWeight="
            + this.actualWeight
            + ", supplierPrice="
            + this.supplierPrice
            + ", fare="
            + this.fare
            + ")";
      }
   }
}
