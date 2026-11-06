package com.hzchum.scim.mes.enclosure.core.api.pojo._dto._package;

import com.hzchum.scim.mes.enclosure.core.api.pojo._do._package.PackageDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "包 ")
public class PackageDTO extends PackageDO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("包内数量")
   private Integer quantity;
   @ApiModelProperty("围护长度")
   private BigDecimal enclLength;
   @ApiModelProperty("结构毛重")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty("结构净重")
   private BigDecimal totalNetWeight;

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getEnclLength() {
      return this.enclLength;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setEnclLength(final BigDecimal enclLength) {
      this.enclLength = enclLength;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PackageDTO)) {
         return false;
      }

      PackageDTO other = (PackageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$enclLength = this.getEnclLength();
         Object other$enclLength = other.getEnclLength();
         if (this$enclLength == null ? other$enclLength == null : this$enclLength.equals(other$enclLength)) {
            Object this$totalGrossWeight = this.getTotalGrossWeight();
            Object other$totalGrossWeight = other.getTotalGrossWeight();
            if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
               Object this$totalNetWeight = this.getTotalNetWeight();
               Object other$totalNetWeight = other.getTotalNetWeight();
               return this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof PackageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $enclLength = this.getEnclLength();
      result = result * 59 + ($enclLength == null ? 43 : $enclLength.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      return result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
   }

   @Override
   public String toString() {
      return "PackageDTO(quantity="
         + this.getQuantity()
         + ", enclLength="
         + this.getEnclLength()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ")";
   }
}
