package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("收货量")
public class ProjectReceivingMeteDTO {
   @ApiModelProperty(name = "quality", value = "收货数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "产品总量(重量kg/长度m)")
   private BigDecimal mete;
   @ApiModelProperty(name = "totalArea", value = "总面积(m2)", notes = "产品总量")
   private BigDecimal totalArea;

   public static ProjectReceivingMeteDTO.ProjectReceivingMeteDTOBuilder builder() {
      return new ProjectReceivingMeteDTO.ProjectReceivingMeteDTOBuilder();
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceivingMeteDTO)) {
         return false;
      }

      ProjectReceivingMeteDTO other = (ProjectReceivingMeteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
            Object this$totalArea = this.getTotalArea();
            Object other$totalArea = other.getTotalArea();
            return this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReceivingMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReceivingMeteDTO(quantity=" + this.getQuantity() + ", mete=" + this.getMete() + ", totalArea=" + this.getTotalArea() + ")";
   }

   public ProjectReceivingMeteDTO(final BigDecimal quantity, final BigDecimal mete, final BigDecimal totalArea) {
      this.quantity = quantity;
      this.mete = mete;
      this.totalArea = totalArea;
   }

   public ProjectReceivingMeteDTO() {
   }

   public static class ProjectReceivingMeteDTOBuilder {
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal totalArea;

      ProjectReceivingMeteDTOBuilder() {
      }

      public ProjectReceivingMeteDTO.ProjectReceivingMeteDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectReceivingMeteDTO.ProjectReceivingMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectReceivingMeteDTO.ProjectReceivingMeteDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public ProjectReceivingMeteDTO build() {
         return new ProjectReceivingMeteDTO(this.quantity, this.mete, this.totalArea);
      }

      @Override
      public String toString() {
         return "ProjectReceivingMeteDTO.ProjectReceivingMeteDTOBuilder(quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", totalArea="
            + this.totalArea
            + ")";
      }
   }
}
