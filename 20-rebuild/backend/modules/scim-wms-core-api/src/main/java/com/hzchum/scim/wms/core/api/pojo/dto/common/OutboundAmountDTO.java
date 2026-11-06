package com.hzchum.scim.wms.core.api.pojo.dto.common;

import java.math.BigDecimal;
import java.util.Map;

public class OutboundAmountDTO {
   private Long classifyId;
   private String classifyName;
   private Map<Integer, BigDecimal> amount;

   public static OutboundAmountDTO.OutboundAmountDTOBuilder builder() {
      return new OutboundAmountDTO.OutboundAmountDTOBuilder();
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Map<Integer, BigDecimal> getAmount() {
      return this.amount;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setAmount(final Map<Integer, BigDecimal> amount) {
      this.amount = amount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundAmountDTO)) {
         return false;
      }

      OutboundAmountDTO other = (OutboundAmountDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classifyId = this.getClassifyId();
      Object other$classifyId = other.getClassifyId();
      if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
         Object this$classifyName = this.getClassifyName();
         Object other$classifyName = other.getClassifyName();
         if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            return this$amount == null ? other$amount == null : this$amount.equals(other$amount);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OutboundAmountDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundAmountDTO(classifyId=" + this.getClassifyId() + ", classifyName=" + this.getClassifyName() + ", amount=" + this.getAmount() + ")";
   }

   public OutboundAmountDTO(final Long classifyId, final String classifyName, final Map<Integer, BigDecimal> amount) {
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.amount = amount;
   }

   public OutboundAmountDTO() {
   }

   public static class OutboundAmountDTOBuilder {
      private Long classifyId;
      private String classifyName;
      private Map<Integer, BigDecimal> amount;

      OutboundAmountDTOBuilder() {
      }

      public OutboundAmountDTO.OutboundAmountDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public OutboundAmountDTO.OutboundAmountDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public OutboundAmountDTO.OutboundAmountDTOBuilder amount(final Map<Integer, BigDecimal> amount) {
         this.amount = amount;
         return this;
      }

      public OutboundAmountDTO build() {
         return new OutboundAmountDTO(this.classifyId, this.classifyName, this.amount);
      }

      @Override
      public String toString() {
         return "OutboundAmountDTO.OutboundAmountDTOBuilder(classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", amount="
            + this.amount
            + ")";
      }
   }
}
