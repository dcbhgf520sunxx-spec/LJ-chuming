package com.hzchum.scim.mes.building.core.api.pojo._doParam.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingEnclosureDetailDOParam", description = "围护夹芯板详情  ")
public class MesBuildingEnclosureDetailDOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "enclosureId", notes = "围护id")
   @JsonProperty("enclosureId")
   @JSONField(name = "enclosureId")
   private Long enclosureId;
   @ApiModelProperty(name = "plate", notes = "内外板")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "boardShape", notes = "板形状")
   @JsonProperty("boardShape")
   @JSONField(name = "boardShape")
   private String boardShape;
   @ApiModelProperty(name = "brand", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   private String brand;
   @ApiModelProperty(name = "thickness", notes = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", notes = "宽度")
   @JsonProperty("width")
   @JSONField(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "claddingMaterial", notes = "镀层")
   @JsonProperty("claddingMaterial")
   @JSONField(name = "claddingMaterial")
   private String claddingMaterial;
   @ApiModelProperty(name = "coating", notes = "涂层")
   @JsonProperty("coating")
   @JSONField(name = "coating")
   private String coating;
   @ApiModelProperty(name = "color", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   private String color;

   public static MesBuildingEnclosureDetailDOParam.MesBuildingEnclosureDetailDOParamBuilder builder() {
      return new MesBuildingEnclosureDetailDOParam.MesBuildingEnclosureDetailDOParamBuilder();
   }

   public MesBuildingEnclosureDetailDOParam() {
   }

   public MesBuildingEnclosureDetailDOParam(
      final Long id,
      final Long enclosureId,
      final String plate,
      final String boardShape,
      final String brand,
      final BigDecimal thickness,
      final BigDecimal width,
      final String claddingMaterial,
      final String coating,
      final String color
   ) {
      this.id = id;
      this.enclosureId = enclosureId;
      this.plate = plate;
      this.boardShape = boardShape;
      this.brand = brand;
      this.thickness = thickness;
      this.width = width;
      this.claddingMaterial = claddingMaterial;
      this.coating = coating;
      this.color = color;
   }

   public Long getId() {
      return this.id;
   }

   public Long getEnclosureId() {
      return this.enclosureId;
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

   @JsonProperty("id")
   public MesBuildingEnclosureDetailDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("enclosureId")
   public MesBuildingEnclosureDetailDOParam setEnclosureId(final Long enclosureId) {
      this.enclosureId = enclosureId;
      return this;
   }

   @JsonProperty("plate")
   public MesBuildingEnclosureDetailDOParam setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("boardShape")
   public MesBuildingEnclosureDetailDOParam setBoardShape(final String boardShape) {
      this.boardShape = boardShape;
      return this;
   }

   @JsonProperty("brand")
   public MesBuildingEnclosureDetailDOParam setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("thickness")
   public MesBuildingEnclosureDetailDOParam setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("width")
   public MesBuildingEnclosureDetailDOParam setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("claddingMaterial")
   public MesBuildingEnclosureDetailDOParam setCladdingMaterial(final String claddingMaterial) {
      this.claddingMaterial = claddingMaterial;
      return this;
   }

   @JsonProperty("coating")
   public MesBuildingEnclosureDetailDOParam setCoating(final String coating) {
      this.coating = coating;
      return this;
   }

   @JsonProperty("color")
   public MesBuildingEnclosureDetailDOParam setColor(final String color) {
      this.color = color;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingEnclosureDetailDOParam(id="
         + this.getId()
         + ", enclosureId="
         + this.getEnclosureId()
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingEnclosureDetailDOParam)) {
         return false;
      }

      MesBuildingEnclosureDetailDOParam other = (MesBuildingEnclosureDetailDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$enclosureId = this.getEnclosureId();
         Object other$enclosureId = other.getEnclosureId();
         if (this$enclosureId == null ? other$enclosureId == null : this$enclosureId.equals(other$enclosureId)) {
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingEnclosureDetailDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $enclosureId = this.getEnclosureId();
      result = result * 59 + ($enclosureId == null ? 43 : $enclosureId.hashCode());
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

   public static class MesBuildingEnclosureDetailDOParamBuilder {
      private Long id;
      private Long enclosureId;
      private String plate;
      private String boardShape;
      private String brand;
      private BigDecimal thickness;
      private BigDecimal width;
      private String claddingMaterial;
      private String coating;
      private String color;

      MesBuildingEnclosureDetailDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingEnclosureDetailDOParam.MesBuildingEnclosureDetailDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("enclosureId")
      public MesBuildingEnclosureDetailDOParam.MesBuildingEnclosureDetailDOParamBuilder enclosureId(final Long enclosureId) {
         this.enclosureId = enclosureId;
         return this;
      }

      @JsonProperty("plate")
      public MesBuildingEnclosureDetailDOParam.MesBuildingEnclosureDetailDOParamBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("boardShape")
      public MesBuildingEnclosureDetailDOParam.MesBuildingEnclosureDetailDOParamBuilder boardShape(final String boardShape) {
         this.boardShape = boardShape;
         return this;
      }

      @JsonProperty("brand")
      public MesBuildingEnclosureDetailDOParam.MesBuildingEnclosureDetailDOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("thickness")
      public MesBuildingEnclosureDetailDOParam.MesBuildingEnclosureDetailDOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("width")
      public MesBuildingEnclosureDetailDOParam.MesBuildingEnclosureDetailDOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("claddingMaterial")
      public MesBuildingEnclosureDetailDOParam.MesBuildingEnclosureDetailDOParamBuilder claddingMaterial(final String claddingMaterial) {
         this.claddingMaterial = claddingMaterial;
         return this;
      }

      @JsonProperty("coating")
      public MesBuildingEnclosureDetailDOParam.MesBuildingEnclosureDetailDOParamBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      @JsonProperty("color")
      public MesBuildingEnclosureDetailDOParam.MesBuildingEnclosureDetailDOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public MesBuildingEnclosureDetailDOParam build() {
         return new MesBuildingEnclosureDetailDOParam(
            this.id, this.enclosureId, this.plate, this.boardShape, this.brand, this.thickness, this.width, this.claddingMaterial, this.coating, this.color
         );
      }

      @Override
      public String toString() {
         return "MesBuildingEnclosureDetailDOParam.MesBuildingEnclosureDetailDOParamBuilder(id="
            + this.id
            + ", enclosureId="
            + this.enclosureId
            + ", plate="
            + this.plate
            + ", boardShape="
            + this.boardShape
            + ", brand="
            + this.brand
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", claddingMaterial="
            + this.claddingMaterial
            + ", coating="
            + this.coating
            + ", color="
            + this.color
            + ")";
      }
   }
}
