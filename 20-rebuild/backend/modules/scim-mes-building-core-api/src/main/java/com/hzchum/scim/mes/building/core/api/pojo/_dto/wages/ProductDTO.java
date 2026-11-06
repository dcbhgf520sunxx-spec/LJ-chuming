package com.hzchum.scim.mes.building.core.api.pojo._dto.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductClassifDTO", description = "")
public class ProductDTO {
   @ApiModelProperty(name = "id", notes = "主键ID")
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
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", notes = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "area", notes = "面积（㎡）")
   @JsonProperty("area")
   @JSONField(name = "area")
   private BigDecimal area;
   @ApiModelProperty(name = "producedQuantity", notes = "已生产")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "thickness", notes = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", notes = "宽度")
   @JsonProperty("width")
   @JSONField(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "color", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   private String color;
   @ApiModelProperty(name = "category", notes = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;

   public static ProductDTO.ProductDTOBuilder builder() {
      return new ProductDTO.ProductDTOBuilder();
   }

   public ProductDTO(
      final Long id,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal area,
      final Integer producedQuantity,
      final BigDecimal thickness,
      final BigDecimal width,
      final String color,
      final Integer category
   ) {
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.area = area;
      this.producedQuantity = producedQuantity;
      this.thickness = thickness;
      this.width = width;
      this.color = color;
      this.category = category;
   }

   public ProductDTO() {
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

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public String getColor() {
      return this.color;
   }

   public Integer getCategory() {
      return this.category;
   }

   @JsonProperty("id")
   public ProductDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProductDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProductDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ProductDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public ProductDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public ProductDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public ProductDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public ProductDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ProductDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public ProductDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public ProductDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("area")
   public ProductDTO setArea(final BigDecimal area) {
      this.area = area;
      return this;
   }

   @JsonProperty("producedQuantity")
   public ProductDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("thickness")
   public ProductDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("width")
   public ProductDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("color")
   public ProductDTO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("category")
   public ProductDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @Override
   public String toString() {
      return "ProductDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", area="
         + this.getArea()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", color="
         + this.getColor()
         + ", category="
         + this.getCategory()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductDTO)) {
         return false;
      }

      ProductDTO other = (ProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$producedQuantity = this.getProducedQuantity();
            Object other$producedQuantity = other.getProducedQuantity();
            if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
               Object this$category = this.getCategory();
               Object other$category = other.getCategory();
               if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$length = this.getLength();
                           Object other$length = other.getLength();
                           if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                 Object this$netWeight = this.getNetWeight();
                                 Object other$netWeight = other.getNetWeight();
                                 if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                    Object this$totalNetWeight = this.getTotalNetWeight();
                                    Object other$totalNetWeight = other.getTotalNetWeight();
                                    if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                       Object this$grossWeight = this.getGrossWeight();
                                       Object other$grossWeight = other.getGrossWeight();
                                       if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                          Object this$totalGrossWeight = this.getTotalGrossWeight();
                                          Object other$totalGrossWeight = other.getTotalGrossWeight();
                                          if (this$totalGrossWeight == null
                                             ? other$totalGrossWeight == null
                                             : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                             Object this$area = this.getArea();
                                             Object other$area = other.getArea();
                                             if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                Object this$thickness = this.getThickness();
                                                Object other$thickness = other.getThickness();
                                                if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                   Object this$width = this.getWidth();
                                                   Object other$width = other.getWidth();
                                                   if (this$width == null ? other$width == null : this$width.equals(other$width)) {
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
      return other instanceof ProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $color = this.getColor();
      return result * 59 + ($color == null ? 43 : $color.hashCode());
   }

   public static class ProductDTOBuilder {
      private Long id;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal area;
      private Integer producedQuantity;
      private BigDecimal thickness;
      private BigDecimal width;
      private String color;
      private Integer category;

      ProductDTOBuilder() {
      }

      @JsonProperty("id")
      public ProductDTO.ProductDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProductDTO.ProductDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProductDTO.ProductDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ProductDTO.ProductDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public ProductDTO.ProductDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public ProductDTO.ProductDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public ProductDTO.ProductDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public ProductDTO.ProductDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ProductDTO.ProductDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public ProductDTO.ProductDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public ProductDTO.ProductDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("area")
      public ProductDTO.ProductDTOBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      @JsonProperty("producedQuantity")
      public ProductDTO.ProductDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("thickness")
      public ProductDTO.ProductDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("width")
      public ProductDTO.ProductDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("color")
      public ProductDTO.ProductDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("category")
      public ProductDTO.ProductDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProductDTO build() {
         return new ProductDTO(
            this.id,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.area,
            this.producedQuantity,
            this.thickness,
            this.width,
            this.color,
            this.category
         );
      }

      @Override
      public String toString() {
         return "ProductDTO.ProductDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", area="
            + this.area
            + ", producedQuantity="
            + this.producedQuantity
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", color="
            + this.color
            + ", category="
            + this.category
            + ")";
      }
   }
}
