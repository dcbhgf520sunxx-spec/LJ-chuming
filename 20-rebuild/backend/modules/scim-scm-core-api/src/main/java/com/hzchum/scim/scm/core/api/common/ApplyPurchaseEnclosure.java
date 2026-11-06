package com.hzchum.scim.scm.core.api.common;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@ExcelTarget("user")
public class ApplyPurchaseEnclosure {
   @Excel(name = "编号")
   private Integer id;
   @Excel(name = "科目名称")
   private String className;
   @Excel(name = "规格")
   private String spec;
   @Excel(name = "计量单位")
   private String measureUnit;
   @Excel(name = "计量量")
   private String quantity;
   @Excel(name = "核算单位")
   private String accountingUnit;
   @Excel(name = "核算量")
   private String mete;
   @Excel(name = "品牌")
   private String brand;

   public static ApplyPurchaseEnclosure.ApplyPurchaseEnclosureBuilder builder() {
      return new ApplyPurchaseEnclosure.ApplyPurchaseEnclosureBuilder();
   }

   public Integer getId() {
      return this.id;
   }

   public String getClassName() {
      return this.className;
   }

   public String getSpec() {
      return this.spec;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getQuantity() {
      return this.quantity;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getMete() {
      return this.mete;
   }

   public String getBrand() {
      return this.brand;
   }

   public void setId(final Integer id) {
      this.id = id;
   }

   public void setClassName(final String className) {
      this.className = className;
   }

   public void setSpec(final String spec) {
      this.spec = spec;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setQuantity(final String quantity) {
      this.quantity = quantity;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMete(final String mete) {
      this.mete = mete;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApplyPurchaseEnclosure)) {
         return false;
      }

      ApplyPurchaseEnclosure other = (ApplyPurchaseEnclosure)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$className = this.getClassName();
         Object other$className = other.getClassName();
         if (this$className == null ? other$className == null : this$className.equals(other$className)) {
            Object this$spec = this.getSpec();
            Object other$spec = other.getSpec();
            if (this$spec == null ? other$spec == null : this$spec.equals(other$spec)) {
               Object this$measureUnit = this.getMeasureUnit();
               Object other$measureUnit = other.getMeasureUnit();
               if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$accountingUnit = this.getAccountingUnit();
                     Object other$accountingUnit = other.getAccountingUnit();
                     if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                        Object this$mete = this.getMete();
                        Object other$mete = other.getMete();
                        if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                           Object this$brand = this.getBrand();
                           Object other$brand = other.getBrand();
                           return this$brand == null ? other$brand == null : this$brand.equals(other$brand);
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
      return other instanceof ApplyPurchaseEnclosure;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $className = this.getClassName();
      result = result * 59 + ($className == null ? 43 : $className.hashCode());
      Object $spec = this.getSpec();
      result = result * 59 + ($spec == null ? 43 : $spec.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $brand = this.getBrand();
      return result * 59 + ($brand == null ? 43 : $brand.hashCode());
   }

   @Override
   public String toString() {
      return "ApplyPurchaseEnclosure(id="
         + this.getId()
         + ", className="
         + this.getClassName()
         + ", spec="
         + this.getSpec()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", quantity="
         + this.getQuantity()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", brand="
         + this.getBrand()
         + ")";
   }

   public ApplyPurchaseEnclosure(
      final Integer id,
      final String className,
      final String spec,
      final String measureUnit,
      final String quantity,
      final String accountingUnit,
      final String mete,
      final String brand
   ) {
      this.id = id;
      this.className = className;
      this.spec = spec;
      this.measureUnit = measureUnit;
      this.quantity = quantity;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.brand = brand;
   }

   public ApplyPurchaseEnclosure() {
   }

   public static class ApplyPurchaseEnclosureBuilder {
      private Integer id;
      private String className;
      private String spec;
      private String measureUnit;
      private String quantity;
      private String accountingUnit;
      private String mete;
      private String brand;

      ApplyPurchaseEnclosureBuilder() {
      }

      public ApplyPurchaseEnclosure.ApplyPurchaseEnclosureBuilder id(final Integer id) {
         this.id = id;
         return this;
      }

      public ApplyPurchaseEnclosure.ApplyPurchaseEnclosureBuilder className(final String className) {
         this.className = className;
         return this;
      }

      public ApplyPurchaseEnclosure.ApplyPurchaseEnclosureBuilder spec(final String spec) {
         this.spec = spec;
         return this;
      }

      public ApplyPurchaseEnclosure.ApplyPurchaseEnclosureBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ApplyPurchaseEnclosure.ApplyPurchaseEnclosureBuilder quantity(final String quantity) {
         this.quantity = quantity;
         return this;
      }

      public ApplyPurchaseEnclosure.ApplyPurchaseEnclosureBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ApplyPurchaseEnclosure.ApplyPurchaseEnclosureBuilder mete(final String mete) {
         this.mete = mete;
         return this;
      }

      public ApplyPurchaseEnclosure.ApplyPurchaseEnclosureBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ApplyPurchaseEnclosure build() {
         return new ApplyPurchaseEnclosure(this.id, this.className, this.spec, this.measureUnit, this.quantity, this.accountingUnit, this.mete, this.brand);
      }

      @Override
      public String toString() {
         return "ApplyPurchaseEnclosure.ApplyPurchaseEnclosureBuilder(id="
            + this.id
            + ", className="
            + this.className
            + ", spec="
            + this.spec
            + ", measureUnit="
            + this.measureUnit
            + ", quantity="
            + this.quantity
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", brand="
            + this.brand
            + ")";
      }
   }
}
