package com.hzchum.scim.contract.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("压型楼承板 新增类")
public class PressureBearingPlateDTOParam {
   private String id;
   @ApiModelProperty(name = "mode", notes = "类型")
   private String mode;
   @ApiModelProperty(name = "plateType", notes = "板型")
   private String plateType;
   @ApiModelProperty(name = "effectiveWidth", value = "有效宽度(mm)")
   private BigDecimal effectiveWidth;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "thickness", notes = "板厚(mm)")
   private BigDecimal thickness;
   @ApiModelProperty(name = "brand", notes = "品牌")
   private String brand;
   @ApiModelProperty(name = "plating", notes = "镀层")
   private String plating;
   @ApiModelProperty(name = "yieldStrength", notes = "屈服强度")
   private String yieldStrength;
   @ApiModelProperty(name = "quantity", notes = "数量(m)")
   private BigDecimal quantity;

   public String getId() {
      return this.id;
   }

   public String getMode() {
      return this.mode;
   }

   public String getPlateType() {
      return this.plateType;
   }

   public BigDecimal getEffectiveWidth() {
      return this.effectiveWidth;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getPlating() {
      return this.plating;
   }

   public String getYieldStrength() {
      return this.yieldStrength;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public void setId(final String id) {
      this.id = id;
   }

   public void setMode(final String mode) {
      this.mode = mode;
   }

   public void setPlateType(final String plateType) {
      this.plateType = plateType;
   }

   public void setEffectiveWidth(final BigDecimal effectiveWidth) {
      this.effectiveWidth = effectiveWidth;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setPlating(final String plating) {
      this.plating = plating;
   }

   public void setYieldStrength(final String yieldStrength) {
      this.yieldStrength = yieldStrength;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PressureBearingPlateDTOParam)) {
         return false;
      }

      PressureBearingPlateDTOParam other = (PressureBearingPlateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$mode = this.getMode();
         Object other$mode = other.getMode();
         if (this$mode == null ? other$mode == null : this$mode.equals(other$mode)) {
            Object this$plateType = this.getPlateType();
            Object other$plateType = other.getPlateType();
            if (this$plateType == null ? other$plateType == null : this$plateType.equals(other$plateType)) {
               Object this$effectiveWidth = this.getEffectiveWidth();
               Object other$effectiveWidth = other.getEffectiveWidth();
               if (this$effectiveWidth == null ? other$effectiveWidth == null : this$effectiveWidth.equals(other$effectiveWidth)) {
                  Object this$unfoldedWidth = this.getUnfoldedWidth();
                  Object other$unfoldedWidth = other.getUnfoldedWidth();
                  if (this$unfoldedWidth == null ? other$unfoldedWidth == null : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                     Object this$thickness = this.getThickness();
                     Object other$thickness = other.getThickness();
                     if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                        Object this$brand = this.getBrand();
                        Object other$brand = other.getBrand();
                        if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                           Object this$plating = this.getPlating();
                           Object other$plating = other.getPlating();
                           if (this$plating == null ? other$plating == null : this$plating.equals(other$plating)) {
                              Object this$yieldStrength = this.getYieldStrength();
                              Object other$yieldStrength = other.getYieldStrength();
                              if (this$yieldStrength == null ? other$yieldStrength == null : this$yieldStrength.equals(other$yieldStrength)) {
                                 Object this$quantity = this.getQuantity();
                                 Object other$quantity = other.getQuantity();
                                 return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
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
      return other instanceof PressureBearingPlateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $mode = this.getMode();
      result = result * 59 + ($mode == null ? 43 : $mode.hashCode());
      Object $plateType = this.getPlateType();
      result = result * 59 + ($plateType == null ? 43 : $plateType.hashCode());
      Object $effectiveWidth = this.getEffectiveWidth();
      result = result * 59 + ($effectiveWidth == null ? 43 : $effectiveWidth.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $yieldStrength = this.getYieldStrength();
      result = result * 59 + ($yieldStrength == null ? 43 : $yieldStrength.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "PressureBearingPlateDTOParam(id="
         + this.getId()
         + ", mode="
         + this.getMode()
         + ", plateType="
         + this.getPlateType()
         + ", effectiveWidth="
         + this.getEffectiveWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", plating="
         + this.getPlating()
         + ", yieldStrength="
         + this.getYieldStrength()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }
}
