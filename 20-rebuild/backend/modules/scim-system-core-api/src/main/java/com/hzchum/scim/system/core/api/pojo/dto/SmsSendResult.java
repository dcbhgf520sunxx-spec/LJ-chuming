package com.hzchum.scim.system.core.api.pojo.dto;

public class SmsSendResult {
   private boolean boolSuccess;
   private String errorMessage;

   public boolean isBoolSuccess() {
      return this.boolSuccess;
   }

   public String getErrorMessage() {
      return this.errorMessage;
   }

   public void setBoolSuccess(final boolean boolSuccess) {
      this.boolSuccess = boolSuccess;
   }

   public void setErrorMessage(final String errorMessage) {
      this.errorMessage = errorMessage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SmsSendResult)) {
         return false;
      }

      SmsSendResult other = (SmsSendResult)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isBoolSuccess() != other.isBoolSuccess()) {
         return false;
      }

      Object this$errorMessage = this.getErrorMessage();
      Object other$errorMessage = other.getErrorMessage();
      return this$errorMessage == null ? other$errorMessage == null : this$errorMessage.equals(other$errorMessage);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SmsSendResult;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isBoolSuccess() ? 79 : 97);
      Object $errorMessage = this.getErrorMessage();
      return result * 59 + ($errorMessage == null ? 43 : $errorMessage.hashCode());
   }

   @Override
   public String toString() {
      return "SmsSendResult(boolSuccess=" + this.isBoolSuccess() + ", errorMessage=" + this.getErrorMessage() + ")";
   }
}
