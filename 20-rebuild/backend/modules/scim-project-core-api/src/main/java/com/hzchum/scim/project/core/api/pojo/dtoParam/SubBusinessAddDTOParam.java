package com.hzchum.scim.project.core.api.pojo.dtoParam;

import java.math.BigDecimal;

public class SubBusinessAddDTOParam {
   private Long projectId;
   private Long monomerId;
   private Long areaId;
   private Integer type;
   private Integer category;
   private String name;
   private String material;
   private Integer quantity;
   private BigDecimal totalMete;
   private BigDecimal totalArea;

   SubBusinessAddDTOParam(
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer type,
      final Integer category,
      final String name,
      final String material,
      final Integer quantity,
      final BigDecimal totalMete,
      final BigDecimal totalArea
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.type = type;
      this.category = category;
      this.name = name;
      this.material = material;
      this.quantity = quantity;
      this.totalMete = totalMete;
      this.totalArea = totalArea;
   }

   public static SubBusinessAddDTOParam.SubBusinessAddDTOParamBuilder builder() {
      return new SubBusinessAddDTOParam.SubBusinessAddDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalMete() {
      return this.totalMete;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubBusinessAddDTOParam)) {
         return false;
      }

      SubBusinessAddDTOParam other = (SubBusinessAddDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$category = this.getCategory();
                  Object other$category = other.getCategory();
                  if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$material = this.getMaterial();
                           Object other$material = other.getMaterial();
                           if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                              Object this$totalMete = this.getTotalMete();
                              Object other$totalMete = other.getTotalMete();
                              if (this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete)) {
                                 Object this$totalArea = this.getTotalArea();
                                 Object other$totalArea = other.getTotalArea();
                                 return this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea);
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
      return other instanceof SubBusinessAddDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   @Override
   public String toString() {
      return "SubBusinessAddDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", type="
         + this.getType()
         + ", category="
         + this.getCategory()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", totalMete="
         + this.getTotalMete()
         + ", totalArea="
         + this.getTotalArea()
         + ")";
   }

   public static class SubBusinessAddDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer type;
      private Integer category;
      private String name;
      private String material;
      private Integer quantity;
      private BigDecimal totalMete;
      private BigDecimal totalArea;

      SubBusinessAddDTOParamBuilder() {
      }

      public SubBusinessAddDTOParam.SubBusinessAddDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SubBusinessAddDTOParam.SubBusinessAddDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public SubBusinessAddDTOParam.SubBusinessAddDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public SubBusinessAddDTOParam.SubBusinessAddDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SubBusinessAddDTOParam.SubBusinessAddDTOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public SubBusinessAddDTOParam.SubBusinessAddDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubBusinessAddDTOParam.SubBusinessAddDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public SubBusinessAddDTOParam.SubBusinessAddDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public SubBusinessAddDTOParam.SubBusinessAddDTOParamBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      public SubBusinessAddDTOParam.SubBusinessAddDTOParamBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public SubBusinessAddDTOParam build() {
         return new SubBusinessAddDTOParam(
            this.projectId, this.monomerId, this.areaId, this.type, this.category, this.name, this.material, this.quantity, this.totalMete, this.totalArea
         );
      }

      @Override
      public String toString() {
         return "SubBusinessAddDTOParam.SubBusinessAddDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", type="
            + this.type
            + ", category="
            + this.category
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", totalMete="
            + this.totalMete
            + ", totalArea="
            + this.totalArea
            + ")";
      }
   }
}
