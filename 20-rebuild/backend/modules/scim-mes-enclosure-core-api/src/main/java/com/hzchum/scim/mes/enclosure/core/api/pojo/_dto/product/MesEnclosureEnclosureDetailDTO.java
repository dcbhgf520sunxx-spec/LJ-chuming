package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesEnclosureEnclosureDetailDTO", description = "围护夹芯板详情  ")
public class MesEnclosureEnclosureDetailDTO extends BaseEntity<Long> {
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

   public static MesEnclosureEnclosureDetailDTO.MesEnclosureEnclosureDetailDTOBuilder builder() {
      return new MesEnclosureEnclosureDetailDTO.MesEnclosureEnclosureDetailDTOBuilder();
   }

   public MesEnclosureEnclosureDetailDTO() {
   }

   public MesEnclosureEnclosureDetailDTO(
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
   public MesEnclosureEnclosureDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("enclosureId")
   public MesEnclosureEnclosureDetailDTO setEnclosureId(final Long enclosureId) {
      this.enclosureId = enclosureId;
      return this;
   }

   @JsonProperty("plate")
   public MesEnclosureEnclosureDetailDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("boardShape")
   public MesEnclosureEnclosureDetailDTO setBoardShape(final String boardShape) {
      this.boardShape = boardShape;
      return this;
   }

   @JsonProperty("brand")
   public MesEnclosureEnclosureDetailDTO setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("thickness")
   public MesEnclosureEnclosureDetailDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("width")
   public MesEnclosureEnclosureDetailDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("claddingMaterial")
   public MesEnclosureEnclosureDetailDTO setCladdingMaterial(final String claddingMaterial) {
      this.claddingMaterial = claddingMaterial;
      return this;
   }

   @JsonProperty("coating")
   public MesEnclosureEnclosureDetailDTO setCoating(final String coating) {
      this.coating = coating;
      return this;
   }

   @JsonProperty("color")
   public MesEnclosureEnclosureDetailDTO setColor(final String color) {
      this.color = color;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureEnclosureDetailDTO(id="
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

      if (!(o instanceof MesEnclosureEnclosureDetailDTO)) {
         return false;
      }

      MesEnclosureEnclosureDetailDTO other = (MesEnclosureEnclosureDetailDTO)o;
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
      return other instanceof MesEnclosureEnclosureDetailDTO;
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

   public static class MesEnclosureEnclosureDetailDTOBuilder {
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

      MesEnclosureEnclosureDetailDTOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureEnclosureDetailDTO.MesEnclosureEnclosureDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("enclosureId")
      public MesEnclosureEnclosureDetailDTO.MesEnclosureEnclosureDetailDTOBuilder enclosureId(final Long enclosureId) {
         this.enclosureId = enclosureId;
         return this;
      }

      @JsonProperty("plate")
      public MesEnclosureEnclosureDetailDTO.MesEnclosureEnclosureDetailDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("boardShape")
      public MesEnclosureEnclosureDetailDTO.MesEnclosureEnclosureDetailDTOBuilder boardShape(final String boardShape) {
         this.boardShape = boardShape;
         return this;
      }

      @JsonProperty("brand")
      public MesEnclosureEnclosureDetailDTO.MesEnclosureEnclosureDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("thickness")
      public MesEnclosureEnclosureDetailDTO.MesEnclosureEnclosureDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("width")
      public MesEnclosureEnclosureDetailDTO.MesEnclosureEnclosureDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("claddingMaterial")
      public MesEnclosureEnclosureDetailDTO.MesEnclosureEnclosureDetailDTOBuilder claddingMaterial(final String claddingMaterial) {
         this.claddingMaterial = claddingMaterial;
         return this;
      }

      @JsonProperty("coating")
      public MesEnclosureEnclosureDetailDTO.MesEnclosureEnclosureDetailDTOBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      @JsonProperty("color")
      public MesEnclosureEnclosureDetailDTO.MesEnclosureEnclosureDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public MesEnclosureEnclosureDetailDTO build() {
         return new MesEnclosureEnclosureDetailDTO(
            this.id, this.enclosureId, this.plate, this.boardShape, this.brand, this.thickness, this.width, this.claddingMaterial, this.coating, this.color
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureEnclosureDetailDTO.MesEnclosureEnclosureDetailDTOBuilder(id="
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
