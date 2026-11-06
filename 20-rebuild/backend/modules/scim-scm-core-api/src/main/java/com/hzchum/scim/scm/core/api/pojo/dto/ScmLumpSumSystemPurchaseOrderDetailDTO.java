package com.hzchum.scim.scm.core.api.pojo.dto;

import java.math.BigDecimal;

public class ScmLumpSumSystemPurchaseOrderDetailDTO {
   private Long id;
   private Long purchaseId;
   private Long classifyId;
   private String classifyName;
   private Integer basicClass;
   private String specification;
   private String model;
   private String unit;
   private BigDecimal mete;
   private BigDecimal amountExcludingVat;
   private BigDecimal unitPriceExcludingVat;
   private BigDecimal inputVat;
   private BigDecimal unitPrice;
   private BigDecimal amount;
   private String remark;
   private BigDecimal inboundMete;
   private Long standardId;
   private String sectionSteelSpec;
   private String doNotSectionSteelSpec;

   public Long getId() {
      return this.id;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getModel() {
      return this.model;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getSectionSteelSpec() {
      return this.sectionSteelSpec;
   }

   public String getDoNotSectionSteelSpec() {
      return this.doNotSectionSteelSpec;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setModel(final String model) {
      this.model = model;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
   }

   public void setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   public void setSectionSteelSpec(final String sectionSteelSpec) {
      this.sectionSteelSpec = sectionSteelSpec;
   }

   public void setDoNotSectionSteelSpec(final String doNotSectionSteelSpec) {
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScmLumpSumSystemPurchaseOrderDetailDTO)) {
         return false;
      }

      ScmLumpSumSystemPurchaseOrderDetailDTO other = (ScmLumpSumSystemPurchaseOrderDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseId = this.getPurchaseId();
         Object other$purchaseId = other.getPurchaseId();
         if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$standardId = this.getStandardId();
                  Object other$standardId = other.getStandardId();
                  if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                     Object this$classifyName = this.getClassifyName();
                     Object other$classifyName = other.getClassifyName();
                     if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$model = this.getModel();
                           Object other$model = other.getModel();
                           if (this$model == null ? other$model == null : this$model.equals(other$model)) {
                              Object this$unit = this.getUnit();
                              Object other$unit = other.getUnit();
                              if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                 Object this$mete = this.getMete();
                                 Object other$mete = other.getMete();
                                 if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                    Object this$amountExcludingVat = this.getAmountExcludingVat();
                                    Object other$amountExcludingVat = other.getAmountExcludingVat();
                                    if (this$amountExcludingVat == null
                                       ? other$amountExcludingVat == null
                                       : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                       Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                       Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                       if (this$unitPriceExcludingVat == null
                                          ? other$unitPriceExcludingVat == null
                                          : this$unitPriceExcludingVat.equals(other$unitPriceExcludingVat)) {
                                          Object this$inputVat = this.getInputVat();
                                          Object other$inputVat = other.getInputVat();
                                          if (this$inputVat == null ? other$inputVat == null : this$inputVat.equals(other$inputVat)) {
                                             Object this$unitPrice = this.getUnitPrice();
                                             Object other$unitPrice = other.getUnitPrice();
                                             if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                                Object this$amount = this.getAmount();
                                                Object other$amount = other.getAmount();
                                                if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                   Object this$remark = this.getRemark();
                                                   Object other$remark = other.getRemark();
                                                   if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                      Object this$inboundMete = this.getInboundMete();
                                                      Object other$inboundMete = other.getInboundMete();
                                                      if (this$inboundMete == null ? other$inboundMete == null : this$inboundMete.equals(other$inboundMete)) {
                                                         Object this$sectionSteelSpec = this.getSectionSteelSpec();
                                                         Object other$sectionSteelSpec = other.getSectionSteelSpec();
                                                         if (this$sectionSteelSpec == null
                                                            ? other$sectionSteelSpec == null
                                                            : this$sectionSteelSpec.equals(other$sectionSteelSpec)) {
                                                            Object this$doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
                                                            Object other$doNotSectionSteelSpec = other.getDoNotSectionSteelSpec();
                                                            return this$doNotSectionSteelSpec == null
                                                               ? other$doNotSectionSteelSpec == null
                                                               : this$doNotSectionSteelSpec.equals(other$doNotSectionSteelSpec);
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
      return other instanceof ScmLumpSumSystemPurchaseOrderDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
      Object $sectionSteelSpec = this.getSectionSteelSpec();
      result = result * 59 + ($sectionSteelSpec == null ? 43 : $sectionSteelSpec.hashCode());
      Object $doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
      return result * 59 + ($doNotSectionSteelSpec == null ? 43 : $doNotSectionSteelSpec.hashCode());
   }

   @Override
   public String toString() {
      return "ScmLumpSumSystemPurchaseOrderDetailDTO(id="
         + this.getId()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", model="
         + this.getModel()
         + ", unit="
         + this.getUnit()
         + ", mete="
         + this.getMete()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", amount="
         + this.getAmount()
         + ", remark="
         + this.getRemark()
         + ", inboundMete="
         + this.getInboundMete()
         + ", standardId="
         + this.getStandardId()
         + ", sectionSteelSpec="
         + this.getSectionSteelSpec()
         + ", doNotSectionSteelSpec="
         + this.getDoNotSectionSteelSpec()
         + ")";
   }
}
