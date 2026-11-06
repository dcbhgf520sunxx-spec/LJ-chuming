package com.hzchum.scim.plan.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("围护清单合计 响应类")
public class EnclosureSumDTO {
   @ApiModelProperty(name = "plate", value = "版型")
   private String plate;
   @ApiModelProperty(name = "color", value = "颜色")
   private String color;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）")
   private BigDecimal thickness;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "width", value = "宽度（mm）")
   private BigDecimal width;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "coating", value = "涂层")
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层")
   private String plating;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "weight", value = "重量")
   private BigDecimal weight;
   @ApiModelProperty(name = "totalLength", value = "总长度（m）")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "总面积（㎡）")
   private BigDecimal totalArea;

   public String getPlate() {
      return this.plate;
   }

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public String getCoating() {
      return this.coating;
   }

   public String getPlating() {
      return this.plating;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
   }

   public void setCoating(final String coating) {
      this.coating = coating;
   }

   public void setPlating(final String plating) {
      this.plating = plating;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureSumDTO)) {
         return false;
      }

      EnclosureSumDTO other = (EnclosureSumDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$plate = this.getPlate();
         Object other$plate = other.getPlate();
         if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
            Object this$color = this.getColor();
            Object other$color = other.getColor();
            if (this$color == null ? other$color == null : this$color.equals(other$color)) {
               Object this$brand = this.getBrand();
               Object other$brand = other.getBrand();
               if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                  Object this$thickness = this.getThickness();
                  Object other$thickness = other.getThickness();
                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                     Object this$width = this.getWidth();
                     Object other$width = other.getWidth();
                     if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                        Object this$unfoldedWidth = this.getUnfoldedWidth();
                        Object other$unfoldedWidth = other.getUnfoldedWidth();
                        if (this$unfoldedWidth == null ? other$unfoldedWidth == null : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                           Object this$coating = this.getCoating();
                           Object other$coating = other.getCoating();
                           if (this$coating == null ? other$coating == null : this$coating.equals(other$coating)) {
                              Object this$plating = this.getPlating();
                              Object other$plating = other.getPlating();
                              if (this$plating == null ? other$plating == null : this$plating.equals(other$plating)) {
                                 Object this$weight = this.getWeight();
                                 Object other$weight = other.getWeight();
                                 if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
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
      return other instanceof EnclosureSumDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureSumDTO(plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ", quantity="
         + this.getQuantity()
         + ", weight="
         + this.getWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ")";
   }
}
