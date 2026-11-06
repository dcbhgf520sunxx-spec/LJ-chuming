package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import java.io.Serializable;

public class BasicCheck implements Serializable {
   private Boolean checkType;

   public static BasicCheck.BasicCheckBuilder builder() {
      return new BasicCheck.BasicCheckBuilder();
   }

   public Boolean getCheckType() {
      return this.checkType;
   }

   public void setCheckType(final Boolean checkType) {
      this.checkType = checkType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BasicCheck)) {
         return false;
      }

      BasicCheck other = (BasicCheck)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$checkType = this.getCheckType();
      Object other$checkType = other.getCheckType();
      return this$checkType == null ? other$checkType == null : this$checkType.equals(other$checkType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BasicCheck;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $checkType = this.getCheckType();
      return result * 59 + ($checkType == null ? 43 : $checkType.hashCode());
   }

   @Override
   public String toString() {
      return "BasicCheck(checkType=" + this.getCheckType() + ")";
   }

   public BasicCheck(final Boolean checkType) {
      this.checkType = checkType;
   }

   public BasicCheck() {
   }

   public static class BasicCheckBuilder {
      private Boolean checkType;

      BasicCheckBuilder() {
      }

      public BasicCheck.BasicCheckBuilder checkType(final Boolean checkType) {
         this.checkType = checkType;
         return this;
      }

      public BasicCheck build() {
         return new BasicCheck(this.checkType);
      }

      @Override
      public String toString() {
         return "BasicCheck.BasicCheckBuilder(checkType=" + this.checkType + ")";
      }
   }
}
