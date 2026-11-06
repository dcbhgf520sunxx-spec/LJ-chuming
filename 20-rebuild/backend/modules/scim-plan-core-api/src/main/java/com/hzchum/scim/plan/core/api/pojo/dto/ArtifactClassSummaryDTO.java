package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class ArtifactClassSummaryDTO {
   @ApiModelProperty("构件分类id")
   private Long structureClassId;
   @ApiModelProperty("构件分类名称")
   private String structureClassName;
   @ApiModelProperty("构件编号数量")
   private Integer quantity;

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public String getStructureClassName() {
      return this.structureClassName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
   }

   public void setStructureClassName(final String structureClassName) {
      this.structureClassName = structureClassName;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactClassSummaryDTO)) {
         return false;
      }

      ArtifactClassSummaryDTO other = (ArtifactClassSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$structureClassId = this.getStructureClassId();
      Object other$structureClassId = other.getStructureClassId();
      if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$structureClassName = this.getStructureClassName();
            Object other$structureClassName = other.getStructureClassName();
            return this$structureClassName == null ? other$structureClassName == null : this$structureClassName.equals(other$structureClassName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactClassSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $structureClassName = this.getStructureClassName();
      return result * 59 + ($structureClassName == null ? 43 : $structureClassName.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactClassSummaryDTO(structureClassId="
         + this.getStructureClassId()
         + ", structureClassName="
         + this.getStructureClassName()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }
}
