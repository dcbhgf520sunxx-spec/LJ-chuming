package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import java.math.BigDecimal;

public class YearSummaryDO {
   private String thickness;
   private String classifyName;
   private String spec;
   private BigDecimal mete;

   public static YearSummaryDO.YearSummaryDOBuilder builder() {
      return new YearSummaryDO.YearSummaryDOBuilder();
   }

   public String getThickness() {
      return this.thickness;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSpec() {
      return this.spec;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setThickness(final String thickness) {
      this.thickness = thickness;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSpec(final String spec) {
      this.spec = spec;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof YearSummaryDO)) {
         return false;
      }

      YearSummaryDO other = (YearSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$thickness = this.getThickness();
      Object other$thickness = other.getThickness();
      if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
         Object this$classifyName = this.getClassifyName();
         Object other$classifyName = other.getClassifyName();
         if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
            Object this$spec = this.getSpec();
            Object other$spec = other.getSpec();
            if (this$spec == null ? other$spec == null : this$spec.equals(other$spec)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
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
      return other instanceof YearSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $spec = this.getSpec();
      result = result * 59 + ($spec == null ? 43 : $spec.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "YearSummaryDO(thickness="
         + this.getThickness()
         + ", classifyName="
         + this.getClassifyName()
         + ", spec="
         + this.getSpec()
         + ", mete="
         + this.getMete()
         + ")";
   }

   public YearSummaryDO(final String thickness, final String classifyName, final String spec, final BigDecimal mete) {
      this.thickness = thickness;
      this.classifyName = classifyName;
      this.spec = spec;
      this.mete = mete;
   }

   public YearSummaryDO() {
   }

   public static class YearSummaryDOBuilder {
      private String thickness;
      private String classifyName;
      private String spec;
      private BigDecimal mete;

      YearSummaryDOBuilder() {
      }

      public YearSummaryDO.YearSummaryDOBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      public YearSummaryDO.YearSummaryDOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public YearSummaryDO.YearSummaryDOBuilder spec(final String spec) {
         this.spec = spec;
         return this;
      }

      public YearSummaryDO.YearSummaryDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public YearSummaryDO build() {
         return new YearSummaryDO(this.thickness, this.classifyName, this.spec, this.mete);
      }

      @Override
      public String toString() {
         return "YearSummaryDO.YearSummaryDOBuilder(thickness="
            + this.thickness
            + ", classifyName="
            + this.classifyName
            + ", spec="
            + this.spec
            + ", mete="
            + this.mete
            + ")";
      }
   }
}
