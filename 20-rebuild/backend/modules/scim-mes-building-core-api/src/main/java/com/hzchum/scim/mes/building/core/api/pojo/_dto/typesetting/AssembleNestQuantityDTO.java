package com.hzchum.scim.mes.building.core.api.pojo._dto.typesetting;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("构件部件-套料数量")
public class AssembleNestQuantityDTO {
   @ApiModelProperty(name = "artifactId", value = "构件id", notes = "构件id)")
   private Long artifactId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "部件id)")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleNestQuantityDTO)) {
         return false;
      }

      AssembleNestQuantityDTO other = (AssembleNestQuantityDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactId = this.getArtifactId();
      Object other$artifactId = other.getArtifactId();
      if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssembleNestQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleNestQuantityDTO(artifactId=" + this.getArtifactId() + ", productId=" + this.getProductId() + ", quantity=" + this.getQuantity() + ")";
   }
}
