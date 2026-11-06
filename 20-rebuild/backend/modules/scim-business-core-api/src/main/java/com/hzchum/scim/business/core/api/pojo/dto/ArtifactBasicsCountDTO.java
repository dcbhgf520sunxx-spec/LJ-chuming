package com.hzchum.scim.business.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ArtifactBasicsDTO对象", description = "发运跟踪汇总")
public class ArtifactBasicsCountDTO {
   @ApiModelProperty("项目编号+名称")
   private String projectName;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("单位")
   private String unit;
   @ApiModelProperty("单价")
   private BigDecimal unitPrice;
   @ApiModelProperty("总价")
   private BigDecimal totalPrice;
   @ApiModelProperty("总重（t）")
   private BigDecimal totalWeight;
   @ApiModelProperty("总长度(米)")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "orderNumber", value = "序号", notes = "序号")
   private Integer orderNumber;

   public static ArtifactBasicsCountDTO.ArtifactBasicsCountDTOBuilder builder() {
      return new ArtifactBasicsCountDTO.ArtifactBasicsCountDTOBuilder();
   }

   public ArtifactBasicsCountDTO() {
   }

   public ArtifactBasicsCountDTO(
      final String projectName,
      final String name,
      final String material,
      final String unit,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final BigDecimal totalWeight,
      final BigDecimal totalLength,
      final Integer orderNumber
   ) {
      this.projectName = projectName;
      this.name = name;
      this.material = material;
      this.unit = unit;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.totalWeight = totalWeight;
      this.totalLength = totalLength;
      this.orderNumber = orderNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public Integer getOrderNumber() {
      return this.orderNumber;
   }

   public ArtifactBasicsCountDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ArtifactBasicsCountDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public ArtifactBasicsCountDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public ArtifactBasicsCountDTO setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public ArtifactBasicsCountDTO setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public ArtifactBasicsCountDTO setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   public ArtifactBasicsCountDTO setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   public ArtifactBasicsCountDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   public ArtifactBasicsCountDTO setOrderNumber(final Integer orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactBasicsCountDTO)) {
         return false;
      }

      ArtifactBasicsCountDTO other = (ArtifactBasicsCountDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNumber = this.getOrderNumber();
      Object other$orderNumber = other.getOrderNumber();
      if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
         Object this$projectName = this.getProjectName();
         Object other$projectName = other.getProjectName();
         if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$material = this.getMaterial();
               Object other$material = other.getMaterial();
               if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                  Object this$unit = this.getUnit();
                  Object other$unit = other.getUnit();
                  if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                     Object this$unitPrice = this.getUnitPrice();
                     Object other$unitPrice = other.getUnitPrice();
                     if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                        Object this$totalPrice = this.getTotalPrice();
                        Object other$totalPrice = other.getTotalPrice();
                        if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                           Object this$totalWeight = this.getTotalWeight();
                           Object other$totalWeight = other.getTotalWeight();
                           if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                              Object this$totalLength = this.getTotalLength();
                              Object other$totalLength = other.getTotalLength();
                              return this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength);
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
      return other instanceof ArtifactBasicsCountDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      return result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactBasicsCountDTO(projectName="
         + this.getProjectName()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", unit="
         + this.getUnit()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", orderNumber="
         + this.getOrderNumber()
         + ")";
   }

   public static class ArtifactBasicsCountDTOBuilder {
      private String projectName;
      private String name;
      private String material;
      private String unit;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private BigDecimal totalWeight;
      private BigDecimal totalLength;
      private Integer orderNumber;

      ArtifactBasicsCountDTOBuilder() {
      }

      public ArtifactBasicsCountDTO.ArtifactBasicsCountDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ArtifactBasicsCountDTO.ArtifactBasicsCountDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ArtifactBasicsCountDTO.ArtifactBasicsCountDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ArtifactBasicsCountDTO.ArtifactBasicsCountDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public ArtifactBasicsCountDTO.ArtifactBasicsCountDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public ArtifactBasicsCountDTO.ArtifactBasicsCountDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public ArtifactBasicsCountDTO.ArtifactBasicsCountDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public ArtifactBasicsCountDTO.ArtifactBasicsCountDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public ArtifactBasicsCountDTO.ArtifactBasicsCountDTOBuilder orderNumber(final Integer orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public ArtifactBasicsCountDTO build() {
         return new ArtifactBasicsCountDTO(
            this.projectName, this.name, this.material, this.unit, this.unitPrice, this.totalPrice, this.totalWeight, this.totalLength, this.orderNumber
         );
      }

      @Override
      public String toString() {
         return "ArtifactBasicsCountDTO.ArtifactBasicsCountDTOBuilder(projectName="
            + this.projectName
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", unit="
            + this.unit
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", totalWeight="
            + this.totalWeight
            + ", totalLength="
            + this.totalLength
            + ", orderNumber="
            + this.orderNumber
            + ")";
      }
   }
}
