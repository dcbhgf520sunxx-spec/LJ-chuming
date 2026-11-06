package com.hzchum.scim.mes.building.core.api.pojo._dto.craft;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class MesPaintStructureClassDTO {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("构件种类id")
   private Long structureClassId;
   @ApiModelProperty("构件种类名称")
   private String structureClassName;
   @ApiModelProperty("数量")
   private Integer quantity;
   @ApiModelProperty("面积(m²)")
   private BigDecimal totalArea;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("总重量(吨)")
   private BigDecimal totalWeight;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("平均(吨/kg)")
   private BigDecimal average;

   public static MesPaintStructureClassDTO.MesPaintStructureClassDTOBuilder builder() {
      return new MesPaintStructureClassDTO.MesPaintStructureClassDTOBuilder();
   }

   public MesPaintStructureClassDTO(
      final Long projectId,
      final Long structureClassId,
      final String structureClassName,
      final Integer quantity,
      final BigDecimal totalArea,
      final BigDecimal totalWeight,
      final BigDecimal average
   ) {
      this.projectId = projectId;
      this.structureClassId = structureClassId;
      this.structureClassName = structureClassName;
      this.quantity = quantity;
      this.totalArea = totalArea;
      this.totalWeight = totalWeight;
      this.average = average;
   }

   public MesPaintStructureClassDTO() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public String getStructureClassName() {
      return this.structureClassName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getAverage() {
      return this.average;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
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

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setAverage(final BigDecimal average) {
      this.average = average;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPaintStructureClassDTO)) {
         return false;
      }

      MesPaintStructureClassDTO other = (MesPaintStructureClassDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$structureClassId = this.getStructureClassId();
         Object other$structureClassId = other.getStructureClassId();
         if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$structureClassName = this.getStructureClassName();
               Object other$structureClassName = other.getStructureClassName();
               if (this$structureClassName == null ? other$structureClassName == null : this$structureClassName.equals(other$structureClassName)) {
                  Object this$totalArea = this.getTotalArea();
                  Object other$totalArea = other.getTotalArea();
                  if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                     Object this$totalWeight = this.getTotalWeight();
                     Object other$totalWeight = other.getTotalWeight();
                     if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                        Object this$average = this.getAverage();
                        Object other$average = other.getAverage();
                        return this$average == null ? other$average == null : this$average.equals(other$average);
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
      return other instanceof MesPaintStructureClassDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $structureClassName = this.getStructureClassName();
      result = result * 59 + ($structureClassName == null ? 43 : $structureClassName.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $average = this.getAverage();
      return result * 59 + ($average == null ? 43 : $average.hashCode());
   }

   @Override
   public String toString() {
      return "MesPaintStructureClassDTO(projectId="
         + this.getProjectId()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", structureClassName="
         + this.getStructureClassName()
         + ", quantity="
         + this.getQuantity()
         + ", totalArea="
         + this.getTotalArea()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", average="
         + this.getAverage()
         + ")";
   }

   public static class MesPaintStructureClassDTOBuilder {
      private Long projectId;
      private Long structureClassId;
      private String structureClassName;
      private Integer quantity;
      private BigDecimal totalArea;
      private BigDecimal totalWeight;
      private BigDecimal average;

      MesPaintStructureClassDTOBuilder() {
      }

      public MesPaintStructureClassDTO.MesPaintStructureClassDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesPaintStructureClassDTO.MesPaintStructureClassDTOBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public MesPaintStructureClassDTO.MesPaintStructureClassDTOBuilder structureClassName(final String structureClassName) {
         this.structureClassName = structureClassName;
         return this;
      }

      public MesPaintStructureClassDTO.MesPaintStructureClassDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesPaintStructureClassDTO.MesPaintStructureClassDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public MesPaintStructureClassDTO.MesPaintStructureClassDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public MesPaintStructureClassDTO.MesPaintStructureClassDTOBuilder average(final BigDecimal average) {
         this.average = average;
         return this;
      }

      public MesPaintStructureClassDTO build() {
         return new MesPaintStructureClassDTO(
            this.projectId, this.structureClassId, this.structureClassName, this.quantity, this.totalArea, this.totalWeight, this.average
         );
      }

      @Override
      public String toString() {
         return "MesPaintStructureClassDTO.MesPaintStructureClassDTOBuilder(projectId="
            + this.projectId
            + ", structureClassId="
            + this.structureClassId
            + ", structureClassName="
            + this.structureClassName
            + ", quantity="
            + this.quantity
            + ", totalArea="
            + this.totalArea
            + ", totalWeight="
            + this.totalWeight
            + ", average="
            + this.average
            + ")";
      }
   }
}
