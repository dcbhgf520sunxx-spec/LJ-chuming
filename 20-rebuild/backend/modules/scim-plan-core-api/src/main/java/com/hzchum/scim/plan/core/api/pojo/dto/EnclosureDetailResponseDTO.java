package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class EnclosureDetailResponseDTO implements Serializable {
   @ApiModelProperty(name = "id", value = "夹芯板彩板id")
   private Long id;
   @ApiModelProperty(name = "type", value = "类型 1.内板 2.外板")
   private Integer type;
   @ApiModelProperty(name = "plate", value = "内外板")
   private String plate;
   @ApiModelProperty(name = "boardShape", value = "板形状")
   private String boardShape;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）")
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", value = "宽度")
   private BigDecimal width;
   @ApiModelProperty(name = "claddingMaterial", value = "镀层")
   private String claddingMaterial;
   @ApiModelProperty(name = "coating", value = "涂层")
   private String coating;
   @ApiModelProperty(name = "color", value = "颜色")
   private String color;

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getBoardShape() {
      return this.boardShape;
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

   public String getCladdingMaterial() {
      return this.claddingMaterial;
   }

   public String getCoating() {
      return this.coating;
   }

   public String getColor() {
      return this.color;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setBoardShape(final String boardShape) {
      this.boardShape = boardShape;
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

   public void setCladdingMaterial(final String claddingMaterial) {
      this.claddingMaterial = claddingMaterial;
   }

   public void setCoating(final String coating) {
      this.coating = coating;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureDetailResponseDTO)) {
         return false;
      }

      EnclosureDetailResponseDTO other = (EnclosureDetailResponseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$plate = this.getPlate();
            Object other$plate = other.getPlate();
            if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
               Object this$boardShape = this.getBoardShape();
               Object other$boardShape = other.getBoardShape();
               if (this$boardShape == null ? other$boardShape == null : this$boardShape.equals(other$boardShape)) {
                  Object this$brand = this.getBrand();
                  Object other$brand = other.getBrand();
                  if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                     Object this$thickness = this.getThickness();
                     Object other$thickness = other.getThickness();
                     if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                        Object this$width = this.getWidth();
                        Object other$width = other.getWidth();
                        if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                           Object this$claddingMaterial = this.getCladdingMaterial();
                           Object other$claddingMaterial = other.getCladdingMaterial();
                           if (this$claddingMaterial == null ? other$claddingMaterial == null : this$claddingMaterial.equals(other$claddingMaterial)) {
                              Object this$coating = this.getCoating();
                              Object other$coating = other.getCoating();
                              if (this$coating == null ? other$coating == null : this$coating.equals(other$coating)) {
                                 Object this$color = this.getColor();
                                 Object other$color = other.getColor();
                                 return this$color == null ? other$color == null : this$color.equals(other$color);
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
      return other instanceof EnclosureDetailResponseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $boardShape = this.getBoardShape();
      result = result * 59 + ($boardShape == null ? 43 : $boardShape.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $claddingMaterial = this.getCladdingMaterial();
      result = result * 59 + ($claddingMaterial == null ? 43 : $claddingMaterial.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $color = this.getColor();
      return result * 59 + ($color == null ? 43 : $color.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureDetailResponseDTO(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", plate="
         + this.getPlate()
         + ", boardShape="
         + this.getBoardShape()
         + ", brand="
         + this.getBrand()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", claddingMaterial="
         + this.getCladdingMaterial()
         + ", coating="
         + this.getCoating()
         + ", color="
         + this.getColor()
         + ")";
   }
}
