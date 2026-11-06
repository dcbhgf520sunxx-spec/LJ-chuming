package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ArtifactDetailDTO", description = "构件工序详情")
public class EnclosureDetailDTO {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "plate", notes = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "color", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   private String color;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "thickness", notes = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", notes = "宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "length", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalLength", notes = "总长度（m）")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", notes = "总面积（㎡）")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "brand", notes = "品牌（芯材信息）")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   private String brand;
   @ApiModelProperty(name = "processSummaryDetailsList", notes = "工序汇总")
   @JsonProperty("processSummaryDetailsList")
   @JSONField(name = "processSummaryDetailsList")
   private List<ProcessSummaryDetailsDTO> processSummaryDetailsList;

   public static EnclosureDetailDTO.EnclosureDetailDTOBuilder builder() {
      return new EnclosureDetailDTO.EnclosureDetailDTOBuilder();
   }

   public EnclosureDetailDTO() {
   }

   public EnclosureDetailDTO(
      final Long id,
      final String name,
      final String serialNumber,
      final String plate,
      final String color,
      final String material,
      final BigDecimal thickness,
      final BigDecimal width,
      final BigDecimal length,
      final Integer quantity,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final String brand,
      final List<ProcessSummaryDetailsDTO> processSummaryDetailsList
   ) {
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.plate = plate;
      this.color = color;
      this.material = material;
      this.thickness = thickness;
      this.width = width;
      this.length = length;
      this.quantity = quantity;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.brand = brand;
      this.processSummaryDetailsList = processSummaryDetailsList;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getColor() {
      return this.color;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public String getBrand() {
      return this.brand;
   }

   public List<ProcessSummaryDetailsDTO> getProcessSummaryDetailsList() {
      return this.processSummaryDetailsList;
   }

   @JsonProperty("id")
   public EnclosureDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public EnclosureDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public EnclosureDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("plate")
   public EnclosureDetailDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public EnclosureDetailDTO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("material")
   public EnclosureDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("thickness")
   public EnclosureDetailDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("width")
   public EnclosureDetailDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("length")
   public EnclosureDetailDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("quantity")
   public EnclosureDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalLength")
   public EnclosureDetailDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("totalArea")
   public EnclosureDetailDTO setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("brand")
   public EnclosureDetailDTO setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("processSummaryDetailsList")
   public EnclosureDetailDTO setProcessSummaryDetailsList(final List<ProcessSummaryDetailsDTO> processSummaryDetailsList) {
      this.processSummaryDetailsList = processSummaryDetailsList;
      return this;
   }

   @Override
   public String toString() {
      return "EnclosureDetailDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", brand="
         + this.getBrand()
         + ", processSummaryDetailsList="
         + this.getProcessSummaryDetailsList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureDetailDTO)) {
         return false;
      }

      EnclosureDetailDTO other = (EnclosureDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$plate = this.getPlate();
                  Object other$plate = other.getPlate();
                  if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                     Object this$color = this.getColor();
                     Object other$color = other.getColor();
                     if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                        Object this$material = this.getMaterial();
                        Object other$material = other.getMaterial();
                        if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                           Object this$thickness = this.getThickness();
                           Object other$thickness = other.getThickness();
                           if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                              Object this$width = this.getWidth();
                              Object other$width = other.getWidth();
                              if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                 Object this$length = this.getLength();
                                 Object other$length = other.getLength();
                                 if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                    Object this$totalLength = this.getTotalLength();
                                    Object other$totalLength = other.getTotalLength();
                                    if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                       Object this$totalArea = this.getTotalArea();
                                       Object other$totalArea = other.getTotalArea();
                                       if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                          Object this$brand = this.getBrand();
                                          Object other$brand = other.getBrand();
                                          if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                             Object this$processSummaryDetailsList = this.getProcessSummaryDetailsList();
                                             Object other$processSummaryDetailsList = other.getProcessSummaryDetailsList();
                                             return this$processSummaryDetailsList == null
                                                ? other$processSummaryDetailsList == null
                                                : this$processSummaryDetailsList.equals(other$processSummaryDetailsList);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $processSummaryDetailsList = this.getProcessSummaryDetailsList();
      return result * 59 + ($processSummaryDetailsList == null ? 43 : $processSummaryDetailsList.hashCode());
   }

   public static class EnclosureDetailDTOBuilder {
      private Long id;
      private String name;
      private String serialNumber;
      private String plate;
      private String color;
      private String material;
      private BigDecimal thickness;
      private BigDecimal width;
      private BigDecimal length;
      private Integer quantity;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private String brand;
      private List<ProcessSummaryDetailsDTO> processSummaryDetailsList;

      EnclosureDetailDTOBuilder() {
      }

      @JsonProperty("id")
      public EnclosureDetailDTO.EnclosureDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public EnclosureDetailDTO.EnclosureDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public EnclosureDetailDTO.EnclosureDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("plate")
      public EnclosureDetailDTO.EnclosureDetailDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public EnclosureDetailDTO.EnclosureDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("material")
      public EnclosureDetailDTO.EnclosureDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("thickness")
      public EnclosureDetailDTO.EnclosureDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("width")
      public EnclosureDetailDTO.EnclosureDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("length")
      public EnclosureDetailDTO.EnclosureDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("quantity")
      public EnclosureDetailDTO.EnclosureDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalLength")
      public EnclosureDetailDTO.EnclosureDetailDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public EnclosureDetailDTO.EnclosureDetailDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("brand")
      public EnclosureDetailDTO.EnclosureDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("processSummaryDetailsList")
      public EnclosureDetailDTO.EnclosureDetailDTOBuilder processSummaryDetailsList(final List<ProcessSummaryDetailsDTO> processSummaryDetailsList) {
         this.processSummaryDetailsList = processSummaryDetailsList;
         return this;
      }

      public EnclosureDetailDTO build() {
         return new EnclosureDetailDTO(
            this.id,
            this.name,
            this.serialNumber,
            this.plate,
            this.color,
            this.material,
            this.thickness,
            this.width,
            this.length,
            this.quantity,
            this.totalLength,
            this.totalArea,
            this.brand,
            this.processSummaryDetailsList
         );
      }

      @Override
      public String toString() {
         return "EnclosureDetailDTO.EnclosureDetailDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", brand="
            + this.brand
            + ", processSummaryDetailsList="
            + this.processSummaryDetailsList
            + ")";
      }
   }
}
