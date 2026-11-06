package com.hzchum.scim.wms.core.api.pojo.dto.common;

import java.math.BigDecimal;

public class ReceiptMeteDTO {
   private Long id;
   private BigDecimal mete;

   public static ReceiptMeteDTO.ReceiptMeteDTOBuilder builder() {
      return new ReceiptMeteDTO.ReceiptMeteDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ReceiptMeteDTO)) {
         return false;
      } else {
         ReceiptMeteDTO other = (ReceiptMeteDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ReceiptMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "ReceiptMeteDTO(id=" + this.getId() + ", mete=" + this.getMete() + ")";
   }

   public ReceiptMeteDTO(final Long id, final BigDecimal mete) {
      this.id = id;
      this.mete = mete;
   }

   public ReceiptMeteDTO() {
   }

   public static class ReceiptMeteDTOBuilder {
      private Long id;
      private BigDecimal mete;

      ReceiptMeteDTOBuilder() {
      }

      public ReceiptMeteDTO.ReceiptMeteDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReceiptMeteDTO.ReceiptMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ReceiptMeteDTO build() {
         return new ReceiptMeteDTO(this.id, this.mete);
      }

      @Override
      public String toString() {
         return "ReceiptMeteDTO.ReceiptMeteDTOBuilder(id=" + this.id + ", mete=" + this.mete + ")";
      }
   }
}
