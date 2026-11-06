package com.hzchum.scim.business.core.api.pojo.dtoParam;

public class ProductionControlQuantityChangeDTOParam {
   private Long projectId;
   private String name;
   private String specification;
   private String material;
   private String unit;
   private Integer quantity;

   ProductionControlQuantityChangeDTOParam(
      final Long projectId, final String name, final String specification, final String material, final String unit, final Integer quantity
   ) {
      this.projectId = projectId;
      this.name = name;
      this.specification = specification;
      this.material = material;
      this.unit = unit;
      this.quantity = quantity;
   }

   public static ProductionControlQuantityChangeDTOParam.ProductionControlQuantityChangeDTOParamBuilder builder() {
      return new ProductionControlQuantityChangeDTOParam.ProductionControlQuantityChangeDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getUnit() {
      return this.unit;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionControlQuantityChangeDTOParam)) {
         return false;
      }

      ProductionControlQuantityChangeDTOParam other = (ProductionControlQuantityChangeDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$material = this.getMaterial();
                  Object other$material = other.getMaterial();
                  if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                     Object this$unit = this.getUnit();
                     Object other$unit = other.getUnit();
                     return this$unit == null ? other$unit == null : this$unit.equals(other$unit);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof ProductionControlQuantityChangeDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $unit = this.getUnit();
      return result * 59 + ($unit == null ? 43 : $unit.hashCode());
   }

   @Override
   public String toString() {
      return "ProductionControlQuantityChangeDTOParam(projectId="
         + this.getProjectId()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", unit="
         + this.getUnit()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   public static class ProductionControlQuantityChangeDTOParamBuilder {
      private Long projectId;
      private String name;
      private String specification;
      private String material;
      private String unit;
      private Integer quantity;

      ProductionControlQuantityChangeDTOParamBuilder() {
      }

      public ProductionControlQuantityChangeDTOParam.ProductionControlQuantityChangeDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProductionControlQuantityChangeDTOParam.ProductionControlQuantityChangeDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProductionControlQuantityChangeDTOParam.ProductionControlQuantityChangeDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProductionControlQuantityChangeDTOParam.ProductionControlQuantityChangeDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ProductionControlQuantityChangeDTOParam.ProductionControlQuantityChangeDTOParamBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public ProductionControlQuantityChangeDTOParam.ProductionControlQuantityChangeDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProductionControlQuantityChangeDTOParam build() {
         return new ProductionControlQuantityChangeDTOParam(this.projectId, this.name, this.specification, this.material, this.unit, this.quantity);
      }

      @Override
      public String toString() {
         return "ProductionControlQuantityChangeDTOParam.ProductionControlQuantityChangeDTOParamBuilder(projectId="
            + this.projectId
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", unit="
            + this.unit
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
