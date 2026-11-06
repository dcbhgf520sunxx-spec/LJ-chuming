package com.hzchum.scim.plan.core.api.pojo.dto.product;

import java.math.BigDecimal;

public class ProductMeteGroupByProjectDTO {
   private Long projectId;
   private Integer quantity;
   private BigDecimal mete;

   ProductMeteGroupByProjectDTO(final Long projectId, final Integer quantity, final BigDecimal mete) {
      this.projectId = projectId;
      this.quantity = quantity;
      this.mete = mete;
   }

   public static ProductMeteGroupByProjectDTO.ProductMeteGroupByProjectDTOBuilder builder() {
      return new ProductMeteGroupByProjectDTO.ProductMeteGroupByProjectDTOBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductMeteGroupByProjectDTO)) {
         return false;
      }

      ProductMeteGroupByProjectDTO other = (ProductMeteGroupByProjectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductMeteGroupByProjectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "ProductMeteGroupByProjectDTO(projectId=" + this.getProjectId() + ", quantity=" + this.getQuantity() + ", mete=" + this.getMete() + ")";
   }

   public static class ProductMeteGroupByProjectDTOBuilder {
      private Long projectId;
      private Integer quantity;
      private BigDecimal mete;

      ProductMeteGroupByProjectDTOBuilder() {
      }

      public ProductMeteGroupByProjectDTO.ProductMeteGroupByProjectDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProductMeteGroupByProjectDTO.ProductMeteGroupByProjectDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProductMeteGroupByProjectDTO.ProductMeteGroupByProjectDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProductMeteGroupByProjectDTO build() {
         return new ProductMeteGroupByProjectDTO(this.projectId, this.quantity, this.mete);
      }

      @Override
      public String toString() {
         return "ProductMeteGroupByProjectDTO.ProductMeteGroupByProjectDTOBuilder(projectId="
            + this.projectId
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ")";
      }
   }
}
