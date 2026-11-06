package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;

public class TransferDetailReviewDTOParam {
   private Long id;
   private Integer partyATransferType;
   private BigDecimal amount;
   private BigDecimal amountNoFreight;

   public static TransferDetailReviewDTOParam.TransferDetailReviewDTOParamBuilder builder() {
      return new TransferDetailReviewDTOParam.TransferDetailReviewDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getPartyATransferType() {
      return this.partyATransferType;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPartyATransferType(final Integer partyATransferType) {
      this.partyATransferType = partyATransferType;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TransferDetailReviewDTOParam)) {
         return false;
      }

      TransferDetailReviewDTOParam other = (TransferDetailReviewDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$partyATransferType = this.getPartyATransferType();
         Object other$partyATransferType = other.getPartyATransferType();
         if (this$partyATransferType == null ? other$partyATransferType == null : this$partyATransferType.equals(other$partyATransferType)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$amountNoFreight = this.getAmountNoFreight();
               Object other$amountNoFreight = other.getAmountNoFreight();
               return this$amountNoFreight == null ? other$amountNoFreight == null : this$amountNoFreight.equals(other$amountNoFreight);
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
      return other instanceof TransferDetailReviewDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $partyATransferType = this.getPartyATransferType();
      result = result * 59 + ($partyATransferType == null ? 43 : $partyATransferType.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      return result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
   }

   @Override
   public String toString() {
      return "TransferDetailReviewDTOParam(id="
         + this.getId()
         + ", partyATransferType="
         + this.getPartyATransferType()
         + ", amount="
         + this.getAmount()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ")";
   }

   public TransferDetailReviewDTOParam(final Long id, final Integer partyATransferType, final BigDecimal amount, final BigDecimal amountNoFreight) {
      this.id = id;
      this.partyATransferType = partyATransferType;
      this.amount = amount;
      this.amountNoFreight = amountNoFreight;
   }

   public TransferDetailReviewDTOParam() {
   }

   public static class TransferDetailReviewDTOParamBuilder {
      private Long id;
      private Integer partyATransferType;
      private BigDecimal amount;
      private BigDecimal amountNoFreight;

      TransferDetailReviewDTOParamBuilder() {
      }

      public TransferDetailReviewDTOParam.TransferDetailReviewDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TransferDetailReviewDTOParam.TransferDetailReviewDTOParamBuilder partyATransferType(final Integer partyATransferType) {
         this.partyATransferType = partyATransferType;
         return this;
      }

      public TransferDetailReviewDTOParam.TransferDetailReviewDTOParamBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public TransferDetailReviewDTOParam.TransferDetailReviewDTOParamBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      public TransferDetailReviewDTOParam build() {
         return new TransferDetailReviewDTOParam(this.id, this.partyATransferType, this.amount, this.amountNoFreight);
      }

      @Override
      public String toString() {
         return "TransferDetailReviewDTOParam.TransferDetailReviewDTOParamBuilder(id="
            + this.id
            + ", partyATransferType="
            + this.partyATransferType
            + ", amount="
            + this.amount
            + ", amountNoFreight="
            + this.amountNoFreight
            + ")";
      }
   }
}
