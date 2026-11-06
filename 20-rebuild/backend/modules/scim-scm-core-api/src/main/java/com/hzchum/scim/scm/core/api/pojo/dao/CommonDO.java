package com.hzchum.scim.scm.core.api.pojo.dao;

public class CommonDO {
   private Integer issued;
   private Integer inbound;

   public static CommonDO.CommonDOBuilder builder() {
      return new CommonDO.CommonDOBuilder();
   }

   public Integer getIssued() {
      return this.issued;
   }

   public Integer getInbound() {
      return this.inbound;
   }

   public void setIssued(final Integer issued) {
      this.issued = issued;
   }

   public void setInbound(final Integer inbound) {
      this.inbound = inbound;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CommonDO)) {
         return false;
      } else {
         CommonDO other = (CommonDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$issued = this.getIssued();
            Object other$issued = other.getIssued();
            if (this$issued == null ? other$issued == null : this$issued.equals(other$issued)) {
               Object this$inbound = this.getInbound();
               Object other$inbound = other.getInbound();
               return this$inbound == null ? other$inbound == null : this$inbound.equals(other$inbound);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CommonDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $issued = this.getIssued();
      result = result * 59 + ($issued == null ? 43 : $issued.hashCode());
      Object $inbound = this.getInbound();
      return result * 59 + ($inbound == null ? 43 : $inbound.hashCode());
   }

   @Override
   public String toString() {
      return "CommonDO(issued=" + this.getIssued() + ", inbound=" + this.getInbound() + ")";
   }

   public CommonDO(final Integer issued, final Integer inbound) {
      this.issued = issued;
      this.inbound = inbound;
   }

   public CommonDO() {
   }

   public static class CommonDOBuilder {
      private Integer issued;
      private Integer inbound;

      CommonDOBuilder() {
      }

      public CommonDO.CommonDOBuilder issued(final Integer issued) {
         this.issued = issued;
         return this;
      }

      public CommonDO.CommonDOBuilder inbound(final Integer inbound) {
         this.inbound = inbound;
         return this;
      }

      public CommonDO build() {
         return new CommonDO(this.issued, this.inbound);
      }

      @Override
      public String toString() {
         return "CommonDO.CommonDOBuilder(issued=" + this.issued + ", inbound=" + this.inbound + ")";
      }
   }
}
