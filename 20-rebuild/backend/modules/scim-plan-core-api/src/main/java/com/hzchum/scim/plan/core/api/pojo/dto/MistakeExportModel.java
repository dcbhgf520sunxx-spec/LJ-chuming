package com.hzchum.scim.plan.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.io.Serializable;

@ExcelTarget("MistakeExportModel")
public class MistakeExportModel implements Serializable {
   @Excel(name = "出错信息", orderNum = "1", width = 100.0)
   private String errorMessage;

   public String getErrorMessage() {
      return this.errorMessage;
   }

   public void setErrorMessage(final String errorMessage) {
      this.errorMessage = errorMessage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MistakeExportModel)) {
         return false;
      }

      MistakeExportModel other = (MistakeExportModel)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$errorMessage = this.getErrorMessage();
      Object other$errorMessage = other.getErrorMessage();
      return this$errorMessage == null ? other$errorMessage == null : this$errorMessage.equals(other$errorMessage);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MistakeExportModel;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $errorMessage = this.getErrorMessage();
      return result * 59 + ($errorMessage == null ? 43 : $errorMessage.hashCode());
   }

   @Override
   public String toString() {
      return "MistakeExportModel(errorMessage=" + this.getErrorMessage() + ")";
   }
}
