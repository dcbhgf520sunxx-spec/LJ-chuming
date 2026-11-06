package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.math.BigDecimal;

public class IdAndMete {
   private Long id;
   private BigDecimal mete;

   public static IdAndMete.IdAndMeteBuilder builder() {
      return new IdAndMete.IdAndMeteBuilder();
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
      } else if (!(o instanceof IdAndMete)) {
         return false;
      } else {
         IdAndMete other = (IdAndMete)o;
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
      return other instanceof IdAndMete;
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
      return "IdAndMete(id=" + this.getId() + ", mete=" + this.getMete() + ")";
   }

   public IdAndMete(final Long id, final BigDecimal mete) {
      this.id = id;
      this.mete = mete;
   }

   public IdAndMete() {
   }

   public static class IdAndMeteBuilder {
      private Long id;
      private BigDecimal mete;

      IdAndMeteBuilder() {
      }

      public IdAndMete.IdAndMeteBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public IdAndMete.IdAndMeteBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public IdAndMete build() {
         return new IdAndMete(this.id, this.mete);
      }

      @Override
      public String toString() {
         return "IdAndMete.IdAndMeteBuilder(id=" + this.id + ", mete=" + this.mete + ")";
      }
   }
}
