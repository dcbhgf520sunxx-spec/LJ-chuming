package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import java.math.BigDecimal;

public class PartyABorrowReturnConf {
   private Boolean boolReturnByOtherProject;
   private BigDecimal steelPlateSideLengthDiff;
   private BigDecimal sectionSteelLengthDiff;

   public static PartyABorrowReturnConf.PartyABorrowReturnConfBuilder builder() {
      return new PartyABorrowReturnConf.PartyABorrowReturnConfBuilder();
   }

   public Boolean getBoolReturnByOtherProject() {
      return this.boolReturnByOtherProject;
   }

   public BigDecimal getSteelPlateSideLengthDiff() {
      return this.steelPlateSideLengthDiff;
   }

   public BigDecimal getSectionSteelLengthDiff() {
      return this.sectionSteelLengthDiff;
   }

   public void setBoolReturnByOtherProject(final Boolean boolReturnByOtherProject) {
      this.boolReturnByOtherProject = boolReturnByOtherProject;
   }

   public void setSteelPlateSideLengthDiff(final BigDecimal steelPlateSideLengthDiff) {
      this.steelPlateSideLengthDiff = steelPlateSideLengthDiff;
   }

   public void setSectionSteelLengthDiff(final BigDecimal sectionSteelLengthDiff) {
      this.sectionSteelLengthDiff = sectionSteelLengthDiff;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PartyABorrowReturnConf)) {
         return false;
      }

      PartyABorrowReturnConf other = (PartyABorrowReturnConf)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolReturnByOtherProject = this.getBoolReturnByOtherProject();
      Object other$boolReturnByOtherProject = other.getBoolReturnByOtherProject();
      if (this$boolReturnByOtherProject == null ? other$boolReturnByOtherProject == null : this$boolReturnByOtherProject.equals(other$boolReturnByOtherProject)
         )
       {
         Object this$steelPlateSideLengthDiff = this.getSteelPlateSideLengthDiff();
         Object other$steelPlateSideLengthDiff = other.getSteelPlateSideLengthDiff();
         if (this$steelPlateSideLengthDiff == null
            ? other$steelPlateSideLengthDiff == null
            : this$steelPlateSideLengthDiff.equals(other$steelPlateSideLengthDiff)) {
            Object this$sectionSteelLengthDiff = this.getSectionSteelLengthDiff();
            Object other$sectionSteelLengthDiff = other.getSectionSteelLengthDiff();
            return this$sectionSteelLengthDiff == null
               ? other$sectionSteelLengthDiff == null
               : this$sectionSteelLengthDiff.equals(other$sectionSteelLengthDiff);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PartyABorrowReturnConf;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolReturnByOtherProject = this.getBoolReturnByOtherProject();
      result = result * 59 + ($boolReturnByOtherProject == null ? 43 : $boolReturnByOtherProject.hashCode());
      Object $steelPlateSideLengthDiff = this.getSteelPlateSideLengthDiff();
      result = result * 59 + ($steelPlateSideLengthDiff == null ? 43 : $steelPlateSideLengthDiff.hashCode());
      Object $sectionSteelLengthDiff = this.getSectionSteelLengthDiff();
      return result * 59 + ($sectionSteelLengthDiff == null ? 43 : $sectionSteelLengthDiff.hashCode());
   }

   @Override
   public String toString() {
      return "PartyABorrowReturnConf(boolReturnByOtherProject="
         + this.getBoolReturnByOtherProject()
         + ", steelPlateSideLengthDiff="
         + this.getSteelPlateSideLengthDiff()
         + ", sectionSteelLengthDiff="
         + this.getSectionSteelLengthDiff()
         + ")";
   }

   public PartyABorrowReturnConf(final Boolean boolReturnByOtherProject, final BigDecimal steelPlateSideLengthDiff, final BigDecimal sectionSteelLengthDiff) {
      this.boolReturnByOtherProject = boolReturnByOtherProject;
      this.steelPlateSideLengthDiff = steelPlateSideLengthDiff;
      this.sectionSteelLengthDiff = sectionSteelLengthDiff;
   }

   public PartyABorrowReturnConf() {
   }

   public static class PartyABorrowReturnConfBuilder {
      private Boolean boolReturnByOtherProject;
      private BigDecimal steelPlateSideLengthDiff;
      private BigDecimal sectionSteelLengthDiff;

      PartyABorrowReturnConfBuilder() {
      }

      public PartyABorrowReturnConf.PartyABorrowReturnConfBuilder boolReturnByOtherProject(final Boolean boolReturnByOtherProject) {
         this.boolReturnByOtherProject = boolReturnByOtherProject;
         return this;
      }

      public PartyABorrowReturnConf.PartyABorrowReturnConfBuilder steelPlateSideLengthDiff(final BigDecimal steelPlateSideLengthDiff) {
         this.steelPlateSideLengthDiff = steelPlateSideLengthDiff;
         return this;
      }

      public PartyABorrowReturnConf.PartyABorrowReturnConfBuilder sectionSteelLengthDiff(final BigDecimal sectionSteelLengthDiff) {
         this.sectionSteelLengthDiff = sectionSteelLengthDiff;
         return this;
      }

      public PartyABorrowReturnConf build() {
         return new PartyABorrowReturnConf(this.boolReturnByOtherProject, this.steelPlateSideLengthDiff, this.sectionSteelLengthDiff);
      }

      @Override
      public String toString() {
         return "PartyABorrowReturnConf.PartyABorrowReturnConfBuilder(boolReturnByOtherProject="
            + this.boolReturnByOtherProject
            + ", steelPlateSideLengthDiff="
            + this.steelPlateSideLengthDiff
            + ", sectionSteelLengthDiff="
            + this.sectionSteelLengthDiff
            + ")";
      }
   }
}
