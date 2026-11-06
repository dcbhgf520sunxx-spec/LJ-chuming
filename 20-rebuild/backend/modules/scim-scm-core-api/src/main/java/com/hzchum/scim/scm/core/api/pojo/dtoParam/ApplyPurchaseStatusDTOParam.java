package com.hzchum.scim.scm.core.api.pojo.dtoParam;

public class ApplyPurchaseStatusDTOParam {
   private Long id;
   private Integer purchaseCreationState;

   public Long getId() {
      return this.id;
   }

   public Integer getPurchaseCreationState() {
      return this.purchaseCreationState;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPurchaseCreationState(final Integer purchaseCreationState) {
      this.purchaseCreationState = purchaseCreationState;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ApplyPurchaseStatusDTOParam)) {
         return false;
      } else {
         ApplyPurchaseStatusDTOParam other = (ApplyPurchaseStatusDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$purchaseCreationState = this.getPurchaseCreationState();
               Object other$purchaseCreationState = other.getPurchaseCreationState();
               return this$purchaseCreationState == null ? other$purchaseCreationState == null : this$purchaseCreationState.equals(other$purchaseCreationState);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ApplyPurchaseStatusDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseCreationState = this.getPurchaseCreationState();
      return result * 59 + ($purchaseCreationState == null ? 43 : $purchaseCreationState.hashCode());
   }

   @Override
   public String toString() {
      return "ApplyPurchaseStatusDTOParam(id=" + this.getId() + ", purchaseCreationState=" + this.getPurchaseCreationState() + ")";
   }
}
