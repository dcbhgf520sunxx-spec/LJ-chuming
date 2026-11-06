package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

public class ReportDownload {
   private Integer amountShow;
   private Integer amountExcludingTAXShow;

   public static ReportDownload.ReportDownloadBuilder builder() {
      return new ReportDownload.ReportDownloadBuilder();
   }

   public Integer getAmountShow() {
      return this.amountShow;
   }

   public Integer getAmountExcludingTAXShow() {
      return this.amountExcludingTAXShow;
   }

   public void setAmountShow(final Integer amountShow) {
      this.amountShow = amountShow;
   }

   public void setAmountExcludingTAXShow(final Integer amountExcludingTAXShow) {
      this.amountExcludingTAXShow = amountExcludingTAXShow;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ReportDownload)) {
         return false;
      } else {
         ReportDownload other = (ReportDownload)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$amountShow = this.getAmountShow();
            Object other$amountShow = other.getAmountShow();
            if (this$amountShow == null ? other$amountShow == null : this$amountShow.equals(other$amountShow)) {
               Object this$amountExcludingTAXShow = this.getAmountExcludingTAXShow();
               Object other$amountExcludingTAXShow = other.getAmountExcludingTAXShow();
               return this$amountExcludingTAXShow == null
                  ? other$amountExcludingTAXShow == null
                  : this$amountExcludingTAXShow.equals(other$amountExcludingTAXShow);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ReportDownload;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $amountShow = this.getAmountShow();
      result = result * 59 + ($amountShow == null ? 43 : $amountShow.hashCode());
      Object $amountExcludingTAXShow = this.getAmountExcludingTAXShow();
      return result * 59 + ($amountExcludingTAXShow == null ? 43 : $amountExcludingTAXShow.hashCode());
   }

   @Override
   public String toString() {
      return "ReportDownload(amountShow=" + this.getAmountShow() + ", amountExcludingTAXShow=" + this.getAmountExcludingTAXShow() + ")";
   }

   public ReportDownload(final Integer amountShow, final Integer amountExcludingTAXShow) {
      this.amountShow = amountShow;
      this.amountExcludingTAXShow = amountExcludingTAXShow;
   }

   public ReportDownload() {
   }

   public static class ReportDownloadBuilder {
      private Integer amountShow;
      private Integer amountExcludingTAXShow;

      ReportDownloadBuilder() {
      }

      public ReportDownload.ReportDownloadBuilder amountShow(final Integer amountShow) {
         this.amountShow = amountShow;
         return this;
      }

      public ReportDownload.ReportDownloadBuilder amountExcludingTAXShow(final Integer amountExcludingTAXShow) {
         this.amountExcludingTAXShow = amountExcludingTAXShow;
         return this;
      }

      public ReportDownload build() {
         return new ReportDownload(this.amountShow, this.amountExcludingTAXShow);
      }

      @Override
      public String toString() {
         return "ReportDownload.ReportDownloadBuilder(amountShow=" + this.amountShow + ", amountExcludingTAXShow=" + this.amountExcludingTAXShow + ")";
      }
   }
}
