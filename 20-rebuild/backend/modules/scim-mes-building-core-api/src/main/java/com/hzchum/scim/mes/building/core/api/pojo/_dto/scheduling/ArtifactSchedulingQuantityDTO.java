package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("构件排产数量")
public class ArtifactSchedulingQuantityDTO {
   @ApiModelProperty("构件ID")
   private Long artifactId;
   @ApiModelProperty("排产数量")
   private Integer quantity;

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ArtifactSchedulingQuantityDTO)) {
         return false;
      } else {
         ArtifactSchedulingQuantityDTO other = (ArtifactSchedulingQuantityDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$artifactId = this.getArtifactId();
            Object other$artifactId = other.getArtifactId();
            if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactSchedulingQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactSchedulingQuantityDTO(artifactId=" + this.getArtifactId() + ", quantity=" + this.getQuantity() + ")";
   }
}
