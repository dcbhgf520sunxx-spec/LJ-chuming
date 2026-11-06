package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("项目工价预估其他分摊DTO类")
public class ProjectWageEstimateOtherApportionmentDTO {
   @ApiModelProperty(name = "type", value = "类型", notes = "类型")
   private String type;
   @ApiModelProperty(name = "unit", value = "计量单位", notes = "计量单位")
   private String unit;
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   private BigDecimal price;
   @ApiModelProperty(name = "totalInventoryQuantity", value = "清单总量", notes = "清单总量")
   private BigDecimal totalInventoryQuantity;
   @ApiModelProperty(name = "totalPrice", value = "总价(元)", notes = "总价(元)")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "artifactIdList", value = "构件ID列表", notes = "构件ID列表")
   private List<Long> artifactIdList;

   public static ProjectWageEstimateOtherApportionmentDTO.ProjectWageEstimateOtherApportionmentDTOBuilder builder() {
      return new ProjectWageEstimateOtherApportionmentDTO.ProjectWageEstimateOtherApportionmentDTOBuilder();
   }

   public String getType() {
      return this.type;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getTotalInventoryQuantity() {
      return this.totalInventoryQuantity;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public List<Long> getArtifactIdList() {
      return this.artifactIdList;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setTotalInventoryQuantity(final BigDecimal totalInventoryQuantity) {
      this.totalInventoryQuantity = totalInventoryQuantity;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setArtifactIdList(final List<Long> artifactIdList) {
      this.artifactIdList = artifactIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectWageEstimateOtherApportionmentDTO)) {
         return false;
      }

      ProjectWageEstimateOtherApportionmentDTO other = (ProjectWageEstimateOtherApportionmentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$unit = this.getUnit();
         Object other$unit = other.getUnit();
         if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
            Object this$price = this.getPrice();
            Object other$price = other.getPrice();
            if (this$price == null ? other$price == null : this$price.equals(other$price)) {
               Object this$totalInventoryQuantity = this.getTotalInventoryQuantity();
               Object other$totalInventoryQuantity = other.getTotalInventoryQuantity();
               if (this$totalInventoryQuantity == null
                  ? other$totalInventoryQuantity == null
                  : this$totalInventoryQuantity.equals(other$totalInventoryQuantity)) {
                  Object this$totalPrice = this.getTotalPrice();
                  Object other$totalPrice = other.getTotalPrice();
                  if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                     Object this$artifactIdList = this.getArtifactIdList();
                     Object other$artifactIdList = other.getArtifactIdList();
                     return this$artifactIdList == null ? other$artifactIdList == null : this$artifactIdList.equals(other$artifactIdList);
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
      return other instanceof ProjectWageEstimateOtherApportionmentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $totalInventoryQuantity = this.getTotalInventoryQuantity();
      result = result * 59 + ($totalInventoryQuantity == null ? 43 : $totalInventoryQuantity.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $artifactIdList = this.getArtifactIdList();
      return result * 59 + ($artifactIdList == null ? 43 : $artifactIdList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectWageEstimateOtherApportionmentDTO(type="
         + this.getType()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ", totalInventoryQuantity="
         + this.getTotalInventoryQuantity()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", artifactIdList="
         + this.getArtifactIdList()
         + ")";
   }

   public ProjectWageEstimateOtherApportionmentDTO() {
   }

   public ProjectWageEstimateOtherApportionmentDTO(
      final String type,
      final String unit,
      final BigDecimal price,
      final BigDecimal totalInventoryQuantity,
      final BigDecimal totalPrice,
      final List<Long> artifactIdList
   ) {
      this.type = type;
      this.unit = unit;
      this.price = price;
      this.totalInventoryQuantity = totalInventoryQuantity;
      this.totalPrice = totalPrice;
      this.artifactIdList = artifactIdList;
   }

   public static class ProjectWageEstimateOtherApportionmentDTOBuilder {
      private String type;
      private String unit;
      private BigDecimal price;
      private BigDecimal totalInventoryQuantity;
      private BigDecimal totalPrice;
      private List<Long> artifactIdList;

      ProjectWageEstimateOtherApportionmentDTOBuilder() {
      }

      public ProjectWageEstimateOtherApportionmentDTO.ProjectWageEstimateOtherApportionmentDTOBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public ProjectWageEstimateOtherApportionmentDTO.ProjectWageEstimateOtherApportionmentDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public ProjectWageEstimateOtherApportionmentDTO.ProjectWageEstimateOtherApportionmentDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public ProjectWageEstimateOtherApportionmentDTO.ProjectWageEstimateOtherApportionmentDTOBuilder totalInventoryQuantity(
         final BigDecimal totalInventoryQuantity
      ) {
         this.totalInventoryQuantity = totalInventoryQuantity;
         return this;
      }

      public ProjectWageEstimateOtherApportionmentDTO.ProjectWageEstimateOtherApportionmentDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public ProjectWageEstimateOtherApportionmentDTO.ProjectWageEstimateOtherApportionmentDTOBuilder artifactIdList(final List<Long> artifactIdList) {
         this.artifactIdList = artifactIdList;
         return this;
      }

      public ProjectWageEstimateOtherApportionmentDTO build() {
         return new ProjectWageEstimateOtherApportionmentDTO(
            this.type, this.unit, this.price, this.totalInventoryQuantity, this.totalPrice, this.artifactIdList
         );
      }

      @Override
      public String toString() {
         return "ProjectWageEstimateOtherApportionmentDTO.ProjectWageEstimateOtherApportionmentDTOBuilder(type="
            + this.type
            + ", unit="
            + this.unit
            + ", price="
            + this.price
            + ", totalInventoryQuantity="
            + this.totalInventoryQuantity
            + ", totalPrice="
            + this.totalPrice
            + ", artifactIdList="
            + this.artifactIdList
            + ")";
      }
   }
}
