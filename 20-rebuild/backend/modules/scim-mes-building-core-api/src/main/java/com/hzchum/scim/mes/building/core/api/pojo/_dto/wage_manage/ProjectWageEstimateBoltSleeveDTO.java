package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("项目工价预估栓钉套筒DTO类")
public class ProjectWageEstimateBoltSleeveDTO {
   @ApiModelProperty(name = "typeNameList", value = "类型名称", notes = "类型名称")
   private List<String> typeNameList;
   @ApiModelProperty(name = "unit", value = "计量单位", notes = "计量单位")
   private String unit;
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   private BigDecimal price;
   @ApiModelProperty(name = "quantity", value = "清单数量", notes = "清单数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "provisionalEstimate", value = "暂估价(元)", notes = "暂估价(元)")
   private BigDecimal provisionalEstimate;

   public static ProjectWageEstimateBoltSleeveDTO.ProjectWageEstimateBoltSleeveDTOBuilder builder() {
      return new ProjectWageEstimateBoltSleeveDTO.ProjectWageEstimateBoltSleeveDTOBuilder();
   }

   public List<String> getTypeNameList() {
      return this.typeNameList;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getProvisionalEstimate() {
      return this.provisionalEstimate;
   }

   public void setTypeNameList(final List<String> typeNameList) {
      this.typeNameList = typeNameList;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setProvisionalEstimate(final BigDecimal provisionalEstimate) {
      this.provisionalEstimate = provisionalEstimate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectWageEstimateBoltSleeveDTO)) {
         return false;
      }

      ProjectWageEstimateBoltSleeveDTO other = (ProjectWageEstimateBoltSleeveDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$typeNameList = this.getTypeNameList();
      Object other$typeNameList = other.getTypeNameList();
      if (this$typeNameList == null ? other$typeNameList == null : this$typeNameList.equals(other$typeNameList)) {
         Object this$unit = this.getUnit();
         Object other$unit = other.getUnit();
         if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
            Object this$price = this.getPrice();
            Object other$price = other.getPrice();
            if (this$price == null ? other$price == null : this$price.equals(other$price)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$provisionalEstimate = this.getProvisionalEstimate();
                  Object other$provisionalEstimate = other.getProvisionalEstimate();
                  return this$provisionalEstimate == null ? other$provisionalEstimate == null : this$provisionalEstimate.equals(other$provisionalEstimate);
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
      return other instanceof ProjectWageEstimateBoltSleeveDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $typeNameList = this.getTypeNameList();
      result = result * 59 + ($typeNameList == null ? 43 : $typeNameList.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $provisionalEstimate = this.getProvisionalEstimate();
      return result * 59 + ($provisionalEstimate == null ? 43 : $provisionalEstimate.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectWageEstimateBoltSleeveDTO(typeNameList="
         + this.getTypeNameList()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ", quantity="
         + this.getQuantity()
         + ", provisionalEstimate="
         + this.getProvisionalEstimate()
         + ")";
   }

   public ProjectWageEstimateBoltSleeveDTO() {
   }

   public ProjectWageEstimateBoltSleeveDTO(
      final List<String> typeNameList, final String unit, final BigDecimal price, final BigDecimal quantity, final BigDecimal provisionalEstimate
   ) {
      this.typeNameList = typeNameList;
      this.unit = unit;
      this.price = price;
      this.quantity = quantity;
      this.provisionalEstimate = provisionalEstimate;
   }

   public static class ProjectWageEstimateBoltSleeveDTOBuilder {
      private List<String> typeNameList;
      private String unit;
      private BigDecimal price;
      private BigDecimal quantity;
      private BigDecimal provisionalEstimate;

      ProjectWageEstimateBoltSleeveDTOBuilder() {
      }

      public ProjectWageEstimateBoltSleeveDTO.ProjectWageEstimateBoltSleeveDTOBuilder typeNameList(final List<String> typeNameList) {
         this.typeNameList = typeNameList;
         return this;
      }

      public ProjectWageEstimateBoltSleeveDTO.ProjectWageEstimateBoltSleeveDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public ProjectWageEstimateBoltSleeveDTO.ProjectWageEstimateBoltSleeveDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public ProjectWageEstimateBoltSleeveDTO.ProjectWageEstimateBoltSleeveDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectWageEstimateBoltSleeveDTO.ProjectWageEstimateBoltSleeveDTOBuilder provisionalEstimate(final BigDecimal provisionalEstimate) {
         this.provisionalEstimate = provisionalEstimate;
         return this;
      }

      public ProjectWageEstimateBoltSleeveDTO build() {
         return new ProjectWageEstimateBoltSleeveDTO(this.typeNameList, this.unit, this.price, this.quantity, this.provisionalEstimate);
      }

      @Override
      public String toString() {
         return "ProjectWageEstimateBoltSleeveDTO.ProjectWageEstimateBoltSleeveDTOBuilder(typeNameList="
            + this.typeNameList
            + ", unit="
            + this.unit
            + ", price="
            + this.price
            + ", quantity="
            + this.quantity
            + ", provisionalEstimate="
            + this.provisionalEstimate
            + ")";
      }
   }
}
