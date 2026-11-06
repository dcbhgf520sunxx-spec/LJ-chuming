package com.hzchum.scim.cut.core.api.request;

import java.math.BigDecimal;

public class ProjectGuide {
   private Integer partNum;
   private BigDecimal partWeight;
   private Integer partNestNum;
   private BigDecimal partNestWeight;

   public static ProjectGuide.ProjectGuideBuilder builder() {
      return new ProjectGuide.ProjectGuideBuilder();
   }

   public ProjectGuide() {
   }

   public ProjectGuide(final Integer partNum, final BigDecimal partWeight, final Integer partNestNum, final BigDecimal partNestWeight) {
      this.partNum = partNum;
      this.partWeight = partWeight;
      this.partNestNum = partNestNum;
      this.partNestWeight = partNestWeight;
   }

   public Integer getPartNum() {
      return this.partNum;
   }

   public BigDecimal getPartWeight() {
      return this.partWeight;
   }

   public Integer getPartNestNum() {
      return this.partNestNum;
   }

   public BigDecimal getPartNestWeight() {
      return this.partNestWeight;
   }

   public void setPartNum(final Integer partNum) {
      this.partNum = partNum;
   }

   public void setPartWeight(final BigDecimal partWeight) {
      this.partWeight = partWeight;
   }

   public void setPartNestNum(final Integer partNestNum) {
      this.partNestNum = partNestNum;
   }

   public void setPartNestWeight(final BigDecimal partNestWeight) {
      this.partNestWeight = partNestWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectGuide)) {
         return false;
      }

      ProjectGuide other = (ProjectGuide)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$partNum = this.getPartNum();
      Object other$partNum = other.getPartNum();
      if (this$partNum == null ? other$partNum == null : this$partNum.equals(other$partNum)) {
         Object this$partNestNum = this.getPartNestNum();
         Object other$partNestNum = other.getPartNestNum();
         if (this$partNestNum == null ? other$partNestNum == null : this$partNestNum.equals(other$partNestNum)) {
            Object this$partWeight = this.getPartWeight();
            Object other$partWeight = other.getPartWeight();
            if (this$partWeight == null ? other$partWeight == null : this$partWeight.equals(other$partWeight)) {
               Object this$partNestWeight = this.getPartNestWeight();
               Object other$partNestWeight = other.getPartNestWeight();
               return this$partNestWeight == null ? other$partNestWeight == null : this$partNestWeight.equals(other$partNestWeight);
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
      return other instanceof ProjectGuide;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $partNum = this.getPartNum();
      result = result * 59 + ($partNum == null ? 43 : $partNum.hashCode());
      Object $partNestNum = this.getPartNestNum();
      result = result * 59 + ($partNestNum == null ? 43 : $partNestNum.hashCode());
      Object $partWeight = this.getPartWeight();
      result = result * 59 + ($partWeight == null ? 43 : $partWeight.hashCode());
      Object $partNestWeight = this.getPartNestWeight();
      return result * 59 + ($partNestWeight == null ? 43 : $partNestWeight.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectGuide(partNum="
         + this.getPartNum()
         + ", partWeight="
         + this.getPartWeight()
         + ", partNestNum="
         + this.getPartNestNum()
         + ", partNestWeight="
         + this.getPartNestWeight()
         + ")";
   }

   public static class ProjectGuideBuilder {
      private Integer partNum;
      private BigDecimal partWeight;
      private Integer partNestNum;
      private BigDecimal partNestWeight;

      ProjectGuideBuilder() {
      }

      public ProjectGuide.ProjectGuideBuilder partNum(final Integer partNum) {
         this.partNum = partNum;
         return this;
      }

      public ProjectGuide.ProjectGuideBuilder partWeight(final BigDecimal partWeight) {
         this.partWeight = partWeight;
         return this;
      }

      public ProjectGuide.ProjectGuideBuilder partNestNum(final Integer partNestNum) {
         this.partNestNum = partNestNum;
         return this;
      }

      public ProjectGuide.ProjectGuideBuilder partNestWeight(final BigDecimal partNestWeight) {
         this.partNestWeight = partNestWeight;
         return this;
      }

      public ProjectGuide build() {
         return new ProjectGuide(this.partNum, this.partWeight, this.partNestNum, this.partNestWeight);
      }

      @Override
      public String toString() {
         return "ProjectGuide.ProjectGuideBuilder(partNum="
            + this.partNum
            + ", partWeight="
            + this.partWeight
            + ", partNestNum="
            + this.partNestNum
            + ", partNestWeight="
            + this.partNestWeight
            + ")";
      }
   }
}
