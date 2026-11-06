package com.hzchum.scim.plan.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@ExcelTarget("MistakeExportDTO")
public class MistakeExportDTO {
   @Excel(name = "出错序号", orderNum = "0")
   private Integer orderNo;
   @Excel(name = "出错信息", orderNum = "1", width = 80.0)
   private String errorMessage;

   public static MistakeExportDTO.MistakeExportDTOBuilder builder() {
      return new MistakeExportDTO.MistakeExportDTOBuilder();
   }

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getErrorMessage() {
      return this.errorMessage;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setErrorMessage(final String errorMessage) {
      this.errorMessage = errorMessage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MistakeExportDTO)) {
         return false;
      } else {
         MistakeExportDTO other = (MistakeExportDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$orderNo = this.getOrderNo();
            Object other$orderNo = other.getOrderNo();
            if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
               Object this$errorMessage = this.getErrorMessage();
               Object other$errorMessage = other.getErrorMessage();
               return this$errorMessage == null ? other$errorMessage == null : this$errorMessage.equals(other$errorMessage);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MistakeExportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $errorMessage = this.getErrorMessage();
      return result * 59 + ($errorMessage == null ? 43 : $errorMessage.hashCode());
   }

   @Override
   public String toString() {
      return "MistakeExportDTO(orderNo=" + this.getOrderNo() + ", errorMessage=" + this.getErrorMessage() + ")";
   }

   public MistakeExportDTO() {
   }

   public MistakeExportDTO(final Integer orderNo, final String errorMessage) {
      this.orderNo = orderNo;
      this.errorMessage = errorMessage;
   }

   public static class MistakeExportDTOBuilder {
      private Integer orderNo;
      private String errorMessage;

      MistakeExportDTOBuilder() {
      }

      public MistakeExportDTO.MistakeExportDTOBuilder orderNo(final Integer orderNo) {
         this.orderNo = orderNo;
         return this;
      }

      public MistakeExportDTO.MistakeExportDTOBuilder errorMessage(final String errorMessage) {
         this.errorMessage = errorMessage;
         return this;
      }

      public MistakeExportDTO build() {
         return new MistakeExportDTO(this.orderNo, this.errorMessage);
      }

      @Override
      public String toString() {
         return "MistakeExportDTO.MistakeExportDTOBuilder(orderNo=" + this.orderNo + ", errorMessage=" + this.errorMessage + ")";
      }
   }
}
