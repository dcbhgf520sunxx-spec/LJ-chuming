package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

public class PrintLabelTipWay {
   private Boolean afterApplication;
   private Boolean afterReview;

   public static PrintLabelTipWay.PrintLabelTipWayBuilder builder() {
      return new PrintLabelTipWay.PrintLabelTipWayBuilder();
   }

   public Boolean getAfterApplication() {
      return this.afterApplication;
   }

   public Boolean getAfterReview() {
      return this.afterReview;
   }

   public void setAfterApplication(final Boolean afterApplication) {
      this.afterApplication = afterApplication;
   }

   public void setAfterReview(final Boolean afterReview) {
      this.afterReview = afterReview;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PrintLabelTipWay)) {
         return false;
      } else {
         PrintLabelTipWay other = (PrintLabelTipWay)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$afterApplication = this.getAfterApplication();
            Object other$afterApplication = other.getAfterApplication();
            if (this$afterApplication == null ? other$afterApplication == null : this$afterApplication.equals(other$afterApplication)) {
               Object this$afterReview = this.getAfterReview();
               Object other$afterReview = other.getAfterReview();
               return this$afterReview == null ? other$afterReview == null : this$afterReview.equals(other$afterReview);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PrintLabelTipWay;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $afterApplication = this.getAfterApplication();
      result = result * 59 + ($afterApplication == null ? 43 : $afterApplication.hashCode());
      Object $afterReview = this.getAfterReview();
      return result * 59 + ($afterReview == null ? 43 : $afterReview.hashCode());
   }

   @Override
   public String toString() {
      return "PrintLabelTipWay(afterApplication=" + this.getAfterApplication() + ", afterReview=" + this.getAfterReview() + ")";
   }

   public PrintLabelTipWay(final Boolean afterApplication, final Boolean afterReview) {
      this.afterApplication = afterApplication;
      this.afterReview = afterReview;
   }

   public PrintLabelTipWay() {
   }

   public static class PrintLabelTipWayBuilder {
      private Boolean afterApplication;
      private Boolean afterReview;

      PrintLabelTipWayBuilder() {
      }

      public PrintLabelTipWay.PrintLabelTipWayBuilder afterApplication(final Boolean afterApplication) {
         this.afterApplication = afterApplication;
         return this;
      }

      public PrintLabelTipWay.PrintLabelTipWayBuilder afterReview(final Boolean afterReview) {
         this.afterReview = afterReview;
         return this;
      }

      public PrintLabelTipWay build() {
         return new PrintLabelTipWay(this.afterApplication, this.afterReview);
      }

      @Override
      public String toString() {
         return "PrintLabelTipWay.PrintLabelTipWayBuilder(afterApplication=" + this.afterApplication + ", afterReview=" + this.afterReview + ")";
      }
   }
}
