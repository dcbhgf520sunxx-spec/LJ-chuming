package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MaterialDTO {
   private Integer BasicClass;
   private String classifyName;
   private String specification;
   private String measureUnit;
   private String accountingUnit;
   private BigDecimal quantity;
   private BigDecimal mete;
   private BigDecimal unitPriceExcludingVat;
   private BigDecimal amountExcludingVat;
   private LocalDateTime inboundTime;

   public static MaterialDTO.MaterialDTOBuilder builder() {
      return new MaterialDTO.MaterialDTOBuilder();
   }

   public Integer getBasicClass() {
      return this.BasicClass;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public LocalDateTime getInboundTime() {
      return this.inboundTime;
   }

   public void setBasicClass(final Integer BasicClass) {
      this.BasicClass = BasicClass;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setInboundTime(final LocalDateTime inboundTime) {
      this.inboundTime = inboundTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialDTO)) {
         return false;
      }

      MaterialDTO other = (MaterialDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$BasicClass = this.getBasicClass();
      Object other$BasicClass = other.getBasicClass();
      if (this$BasicClass == null ? other$BasicClass == null : this$BasicClass.equals(other$BasicClass)) {
         Object this$classifyName = this.getClassifyName();
         Object other$classifyName = other.getClassifyName();
         if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
            Object this$specification = this.getSpecification();
            Object other$specification = other.getSpecification();
            if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
               Object this$measureUnit = this.getMeasureUnit();
               Object other$measureUnit = other.getMeasureUnit();
               if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                  Object this$accountingUnit = this.getAccountingUnit();
                  Object other$accountingUnit = other.getAccountingUnit();
                  if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$mete = this.getMete();
                        Object other$mete = other.getMete();
                        if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                           Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                           Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                           if (this$unitPriceExcludingVat == null
                              ? other$unitPriceExcludingVat == null
                              : this$unitPriceExcludingVat.equals(other$unitPriceExcludingVat)) {
                              Object this$amountExcludingVat = this.getAmountExcludingVat();
                              Object other$amountExcludingVat = other.getAmountExcludingVat();
                              if (this$amountExcludingVat == null ? other$amountExcludingVat == null : this$amountExcludingVat.equals(other$amountExcludingVat)
                                 )
                               {
                                 Object this$inboundTime = this.getInboundTime();
                                 Object other$inboundTime = other.getInboundTime();
                                 return this$inboundTime == null ? other$inboundTime == null : this$inboundTime.equals(other$inboundTime);
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
      return other instanceof MaterialDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $BasicClass = this.getBasicClass();
      result = result * 59 + ($BasicClass == null ? 43 : $BasicClass.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inboundTime = this.getInboundTime();
      return result * 59 + ($inboundTime == null ? 43 : $inboundTime.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialDTO(BasicClass="
         + this.getBasicClass()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inboundTime="
         + this.getInboundTime()
         + ")";
   }

   public MaterialDTO(
      final Integer BasicClass,
      final String classifyName,
      final String specification,
      final String measureUnit,
      final String accountingUnit,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal amountExcludingVat,
      final LocalDateTime inboundTime
   ) {
      this.BasicClass = BasicClass;
      this.classifyName = classifyName;
      this.specification = specification;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.quantity = quantity;
      this.mete = mete;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.amountExcludingVat = amountExcludingVat;
      this.inboundTime = inboundTime;
   }

   public MaterialDTO() {
   }

   public static class MaterialDTOBuilder {
      private Integer BasicClass;
      private String classifyName;
      private String specification;
      private String measureUnit;
      private String accountingUnit;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal amountExcludingVat;
      private LocalDateTime inboundTime;

      MaterialDTOBuilder() {
      }

      public MaterialDTO.MaterialDTOBuilder BasicClass(final Integer BasicClass) {
         this.BasicClass = BasicClass;
         return this;
      }

      public MaterialDTO.MaterialDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public MaterialDTO.MaterialDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MaterialDTO.MaterialDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public MaterialDTO.MaterialDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public MaterialDTO.MaterialDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public MaterialDTO.MaterialDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MaterialDTO.MaterialDTOBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      public MaterialDTO.MaterialDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public MaterialDTO.MaterialDTOBuilder inboundTime(final LocalDateTime inboundTime) {
         this.inboundTime = inboundTime;
         return this;
      }

      public MaterialDTO build() {
         return new MaterialDTO(
            this.BasicClass,
            this.classifyName,
            this.specification,
            this.measureUnit,
            this.accountingUnit,
            this.quantity,
            this.mete,
            this.unitPriceExcludingVat,
            this.amountExcludingVat,
            this.inboundTime
         );
      }

      @Override
      public String toString() {
         return "MaterialDTO.MaterialDTOBuilder(BasicClass="
            + this.BasicClass
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inboundTime="
            + this.inboundTime
            + ")";
      }
   }
}
