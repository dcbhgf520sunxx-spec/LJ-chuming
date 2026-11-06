package com.hzchum.scim.common.core.api.pojo.dto;

import java.math.BigDecimal;

public class BasicClassMeteAndAmountDTO {
   private Long projectId;
   private Long basicClass;
   private BigDecimal mete;
   private BigDecimal transformMete;
   private String transformUnit;
   private String time;
   private BigDecimal amount;
   private BigDecimal amountExcludingVat;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTransformMete() {
      return this.transformMete;
   }

   public String getTransformUnit() {
      return this.transformUnit;
   }

   public String getTime() {
      return this.time;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setBasicClass(final Long basicClass) {
      this.basicClass = basicClass;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setTransformMete(final BigDecimal transformMete) {
      this.transformMete = transformMete;
   }

   public void setTransformUnit(final String transformUnit) {
      this.transformUnit = transformUnit;
   }

   public void setTime(final String time) {
      this.time = time;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BasicClassMeteAndAmountDTO)) {
         return false;
      }

      BasicClassMeteAndAmountDTO other = (BasicClassMeteAndAmountDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$mete = this.getMete();
            Object other$mete = other.getMete();
            if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
               Object this$transformMete = this.getTransformMete();
               Object other$transformMete = other.getTransformMete();
               if (this$transformMete == null ? other$transformMete == null : this$transformMete.equals(other$transformMete)) {
                  Object this$transformUnit = this.getTransformUnit();
                  Object other$transformUnit = other.getTransformUnit();
                  if (this$transformUnit == null ? other$transformUnit == null : this$transformUnit.equals(other$transformUnit)) {
                     Object this$time = this.getTime();
                     Object other$time = other.getTime();
                     if (this$time == null ? other$time == null : this$time.equals(other$time)) {
                        Object this$amount = this.getAmount();
                        Object other$amount = other.getAmount();
                        if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                           Object this$amountExcludingVat = this.getAmountExcludingVat();
                           Object other$amountExcludingVat = other.getAmountExcludingVat();
                           return this$amountExcludingVat == null ? other$amountExcludingVat == null : this$amountExcludingVat.equals(other$amountExcludingVat);
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
      return other instanceof BasicClassMeteAndAmountDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $transformMete = this.getTransformMete();
      result = result * 59 + ($transformMete == null ? 43 : $transformMete.hashCode());
      Object $transformUnit = this.getTransformUnit();
      result = result * 59 + ($transformUnit == null ? 43 : $transformUnit.hashCode());
      Object $time = this.getTime();
      result = result * 59 + ($time == null ? 43 : $time.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      return result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
   }

   @Override
   public String toString() {
      return "BasicClassMeteAndAmountDTO(projectId="
         + this.getProjectId()
         + ", basicClass="
         + this.getBasicClass()
         + ", mete="
         + this.getMete()
         + ", transformMete="
         + this.getTransformMete()
         + ", transformUnit="
         + this.getTransformUnit()
         + ", time="
         + this.getTime()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ")";
   }
}
