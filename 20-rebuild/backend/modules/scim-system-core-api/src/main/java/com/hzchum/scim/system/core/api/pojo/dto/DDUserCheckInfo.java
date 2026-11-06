package com.hzchum.scim.system.core.api.pojo.dto;

public class DDUserCheckInfo {
   private Integer result;
   private String otherInfo;

   public Integer getResult() {
      return this.result;
   }

   public String getOtherInfo() {
      return this.otherInfo;
   }

   public void setResult(final Integer result) {
      this.result = result;
   }

   public void setOtherInfo(final String otherInfo) {
      this.otherInfo = otherInfo;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof DDUserCheckInfo)) {
         return false;
      } else {
         DDUserCheckInfo other = (DDUserCheckInfo)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$result = this.getResult();
            Object other$result = other.getResult();
            if (this$result == null ? other$result == null : this$result.equals(other$result)) {
               Object this$otherInfo = this.getOtherInfo();
               Object other$otherInfo = other.getOtherInfo();
               return this$otherInfo == null ? other$otherInfo == null : this$otherInfo.equals(other$otherInfo);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DDUserCheckInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $result = this.getResult();
      result = result * 59 + ($result == null ? 43 : $result.hashCode());
      Object $otherInfo = this.getOtherInfo();
      return result * 59 + ($otherInfo == null ? 43 : $otherInfo.hashCode());
   }

   @Override
   public String toString() {
      return "DDUserCheckInfo(result=" + this.getResult() + ", otherInfo=" + this.getOtherInfo() + ")";
   }
}
