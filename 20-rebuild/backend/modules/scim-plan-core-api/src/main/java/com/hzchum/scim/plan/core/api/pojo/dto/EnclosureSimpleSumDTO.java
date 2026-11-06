package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("围护总长度和总数量返回类")
public class EnclosureSimpleSumDTO {
   @ApiModelProperty(name = "totalLength", value = "总长度（m）")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "总面积(mm²)")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer totalQuantity;

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureSimpleSumDTO)) {
         return false;
      }

      EnclosureSimpleSumDTO other = (EnclosureSimpleSumDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalQuantity = this.getTotalQuantity();
      Object other$totalQuantity = other.getTotalQuantity();
      if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
         Object this$totalLength = this.getTotalLength();
         Object other$totalLength = other.getTotalLength();
         if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
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
      return other instanceof EnclosureSimpleSumDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureSimpleSumDTO(totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ")";
   }
}
