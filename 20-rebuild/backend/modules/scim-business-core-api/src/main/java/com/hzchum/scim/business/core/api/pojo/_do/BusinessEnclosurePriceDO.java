package com.hzchum.scim.business.core.api.pojo._do;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "BusinessEnclosurePriceDO", description = "围护 ")
public class BusinessEnclosurePriceDO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "category", value = "品类")
   private Integer category;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "plate", value = "板型")
   private String plate;
   @ApiModelProperty(name = "color", value = "颜色")
   private String color;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "thickness", value = "厚度")
   private BigDecimal thickness;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "totalQuantity", value = "总数")
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalLength", value = "总长度mm")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "总面积(平方米)")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "unitPrice", value = "单价")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "priceType", value = "计价方式")
   private Integer priceType;

   public static BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder builder() {
      return new BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder();
   }

   public BusinessEnclosurePriceDO() {
   }

   public BusinessEnclosurePriceDO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Integer category,
      final String name,
      final String plate,
      final String color,
      final String material,
      final BigDecimal thickness,
      final BigDecimal length,
      final Integer totalQuantity,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final BigDecimal unitPrice,
      final Integer priceType
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.category = category;
      this.name = name;
      this.plate = plate;
      this.color = color;
      this.material = material;
      this.thickness = thickness;
      this.length = length;
      this.totalQuantity = totalQuantity;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.unitPrice = unitPrice;
      this.priceType = priceType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getName() {
      return this.name;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public BusinessEnclosurePriceDO setId(final Long id) {
      this.id = id;
      return this;
   }

   public BusinessEnclosurePriceDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public BusinessEnclosurePriceDO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public BusinessEnclosurePriceDO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public BusinessEnclosurePriceDO setName(final String name) {
      this.name = name;
      return this;
   }

   public BusinessEnclosurePriceDO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   public BusinessEnclosurePriceDO setColor(final String color) {
      this.color = color;
      return this;
   }

   public BusinessEnclosurePriceDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public BusinessEnclosurePriceDO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   public BusinessEnclosurePriceDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public BusinessEnclosurePriceDO setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   public BusinessEnclosurePriceDO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   public BusinessEnclosurePriceDO setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   public BusinessEnclosurePriceDO setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public BusinessEnclosurePriceDO setPriceType(final Integer priceType) {
      this.priceType = priceType;
      return this;
   }

   @Override
   public String toString() {
      return "BusinessEnclosurePriceDO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", category="
         + this.getCategory()
         + ", name="
         + this.getName()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", priceType="
         + this.getPriceType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessEnclosurePriceDO)) {
         return false;
      }

      BusinessEnclosurePriceDO other = (BusinessEnclosurePriceDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$category = this.getCategory();
               Object other$category = other.getCategory();
               if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                  Object this$totalQuantity = this.getTotalQuantity();
                  Object other$totalQuantity = other.getTotalQuantity();
                  if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
                     Object this$priceType = this.getPriceType();
                     Object other$priceType = other.getPriceType();
                     if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$totalLength = this.getTotalLength();
                                          Object other$totalLength = other.getTotalLength();
                                          if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                             Object this$totalArea = this.getTotalArea();
                                             Object other$totalArea = other.getTotalArea();
                                             if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                                Object this$unitPrice = this.getUnitPrice();
                                                Object other$unitPrice = other.getUnitPrice();
                                                return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
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
      return other instanceof BusinessEnclosurePriceDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   public static class BusinessEnclosurePriceDOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Integer category;
      private String name;
      private String plate;
      private String color;
      private String material;
      private BigDecimal thickness;
      private BigDecimal length;
      private Integer totalQuantity;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private BigDecimal unitPrice;
      private Integer priceType;

      BusinessEnclosurePriceDOBuilder() {
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder priceType(final Integer priceType) {
         this.priceType = priceType;
         return this;
      }

      public BusinessEnclosurePriceDO build() {
         return new BusinessEnclosurePriceDO(
            this.id,
            this.projectId,
            this.monomerId,
            this.category,
            this.name,
            this.plate,
            this.color,
            this.material,
            this.thickness,
            this.length,
            this.totalQuantity,
            this.totalLength,
            this.totalArea,
            this.unitPrice,
            this.priceType
         );
      }

      @Override
      public String toString() {
         return "BusinessEnclosurePriceDO.BusinessEnclosurePriceDOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", category="
            + this.category
            + ", name="
            + this.name
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", unitPrice="
            + this.unitPrice
            + ", priceType="
            + this.priceType
            + ")";
      }
   }
}
