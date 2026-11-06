package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;

public class PrintDTOParam {
   private LocalDateTime startTime;
   private LocalDateTime endTime;
   private Integer copies;
   private Integer number;
   private Integer receiptMaterialId;

   public static PrintDTOParam.PrintDTOParamBuilder builder() {
      return new PrintDTOParam.PrintDTOParamBuilder();
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public Integer getCopies() {
      return this.copies;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Integer getReceiptMaterialId() {
      return this.receiptMaterialId;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   public void setCopies(final Integer copies) {
      this.copies = copies;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setReceiptMaterialId(final Integer receiptMaterialId) {
      this.receiptMaterialId = receiptMaterialId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PrintDTOParam)) {
         return false;
      }

      PrintDTOParam other = (PrintDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$copies = this.getCopies();
      Object other$copies = other.getCopies();
      if (this$copies == null ? other$copies == null : this$copies.equals(other$copies)) {
         Object this$number = this.getNumber();
         Object other$number = other.getNumber();
         if (this$number == null ? other$number == null : this$number.equals(other$number)) {
            Object this$receiptMaterialId = this.getReceiptMaterialId();
            Object other$receiptMaterialId = other.getReceiptMaterialId();
            if (this$receiptMaterialId == null ? other$receiptMaterialId == null : this$receiptMaterialId.equals(other$receiptMaterialId)) {
               Object this$startTime = this.getStartTime();
               Object other$startTime = other.getStartTime();
               if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
                  Object this$endTime = this.getEndTime();
                  Object other$endTime = other.getEndTime();
                  return this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime);
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
      return other instanceof PrintDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $copies = this.getCopies();
      result = result * 59 + ($copies == null ? 43 : $copies.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $receiptMaterialId = this.getReceiptMaterialId();
      result = result * 59 + ($receiptMaterialId == null ? 43 : $receiptMaterialId.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      return result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
   }

   @Override
   public String toString() {
      return "PrintDTOParam(startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", copies="
         + this.getCopies()
         + ", number="
         + this.getNumber()
         + ", receiptMaterialId="
         + this.getReceiptMaterialId()
         + ")";
   }

   public PrintDTOParam(final LocalDateTime startTime, final LocalDateTime endTime, final Integer copies, final Integer number, final Integer receiptMaterialId) {
      this.startTime = startTime;
      this.endTime = endTime;
      this.copies = copies;
      this.number = number;
      this.receiptMaterialId = receiptMaterialId;
   }

   public PrintDTOParam() {
   }

   public static class PrintDTOParamBuilder {
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private Integer copies;
      private Integer number;
      private Integer receiptMaterialId;

      PrintDTOParamBuilder() {
      }

      public PrintDTOParam.PrintDTOParamBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public PrintDTOParam.PrintDTOParamBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public PrintDTOParam.PrintDTOParamBuilder copies(final Integer copies) {
         this.copies = copies;
         return this;
      }

      public PrintDTOParam.PrintDTOParamBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public PrintDTOParam.PrintDTOParamBuilder receiptMaterialId(final Integer receiptMaterialId) {
         this.receiptMaterialId = receiptMaterialId;
         return this;
      }

      public PrintDTOParam build() {
         return new PrintDTOParam(this.startTime, this.endTime, this.copies, this.number, this.receiptMaterialId);
      }

      @Override
      public String toString() {
         return "PrintDTOParam.PrintDTOParamBuilder(startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", copies="
            + this.copies
            + ", number="
            + this.number
            + ", receiptMaterialId="
            + this.receiptMaterialId
            + ")";
      }
   }
}
