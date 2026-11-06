package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

public class FinishedProductsDTOParam {
   private Long id;
   private Long workshopId;
   private Long recipientId;
   private Integer quantity;

   public static FinishedProductsDTOParam.FinishedProductsDTOParamBuilder builder() {
      return new FinishedProductsDTOParam.FinishedProductsDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FinishedProductsDTOParam)) {
         return false;
      }

      FinishedProductsDTOParam other = (FinishedProductsDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$recipientId = this.getRecipientId();
            Object other$recipientId = other.getRecipientId();
            if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
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
      return other instanceof FinishedProductsDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "FinishedProductsDTOParam(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", recipientId="
         + this.getRecipientId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   public FinishedProductsDTOParam(final Long id, final Long workshopId, final Long recipientId, final Integer quantity) {
      this.id = id;
      this.workshopId = workshopId;
      this.recipientId = recipientId;
      this.quantity = quantity;
   }

   public FinishedProductsDTOParam() {
   }

   public static class FinishedProductsDTOParamBuilder {
      private Long id;
      private Long workshopId;
      private Long recipientId;
      private Integer quantity;

      FinishedProductsDTOParamBuilder() {
      }

      public FinishedProductsDTOParam.FinishedProductsDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public FinishedProductsDTOParam.FinishedProductsDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public FinishedProductsDTOParam.FinishedProductsDTOParamBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public FinishedProductsDTOParam.FinishedProductsDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public FinishedProductsDTOParam build() {
         return new FinishedProductsDTOParam(this.id, this.workshopId, this.recipientId, this.quantity);
      }

      @Override
      public String toString() {
         return "FinishedProductsDTOParam.FinishedProductsDTOParamBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", recipientId="
            + this.recipientId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
