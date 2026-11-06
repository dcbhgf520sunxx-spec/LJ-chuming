package com.hzchum.scim.scm.core.api.common;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class DetailQuantityAndMete {
   @ApiModelProperty(name = "id", value = "明细ID", notes = "明细ID")
   private Long id;
   @ApiModelProperty(name = "quantity", value = "计量量", notes = "计量量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "classifyId", value = "科目Id", notes = "科目Id")
   private Long classifyId;

   public static DetailQuantityAndMete.DetailQuantityAndMeteBuilder builder() {
      return new DetailQuantityAndMete.DetailQuantityAndMeteBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DetailQuantityAndMete)) {
         return false;
      }

      DetailQuantityAndMete other = (DetailQuantityAndMete)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
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
      return other instanceof DetailQuantityAndMete;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "DetailQuantityAndMete(id="
         + this.getId()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", classifyId="
         + this.getClassifyId()
         + ")";
   }

   public DetailQuantityAndMete(final Long id, final BigDecimal quantity, final BigDecimal mete, final Long classifyId) {
      this.id = id;
      this.quantity = quantity;
      this.mete = mete;
      this.classifyId = classifyId;
   }

   public DetailQuantityAndMete() {
   }

   public static class DetailQuantityAndMeteBuilder {
      private Long id;
      private BigDecimal quantity;
      private BigDecimal mete;
      private Long classifyId;

      DetailQuantityAndMeteBuilder() {
      }

      public DetailQuantityAndMete.DetailQuantityAndMeteBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public DetailQuantityAndMete.DetailQuantityAndMeteBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public DetailQuantityAndMete.DetailQuantityAndMeteBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public DetailQuantityAndMete.DetailQuantityAndMeteBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public DetailQuantityAndMete build() {
         return new DetailQuantityAndMete(this.id, this.quantity, this.mete, this.classifyId);
      }

      @Override
      public String toString() {
         return "DetailQuantityAndMete.DetailQuantityAndMeteBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", classifyId="
            + this.classifyId
            + ")";
      }
   }
}
