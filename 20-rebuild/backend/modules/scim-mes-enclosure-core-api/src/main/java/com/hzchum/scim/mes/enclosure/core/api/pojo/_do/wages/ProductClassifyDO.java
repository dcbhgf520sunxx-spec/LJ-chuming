package com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductClassifDTO", description = "")
public class ProductClassifyDO {
   @ApiModelProperty(name = "name", notes = "名称", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "steelSpec", notes = "板厚或规格", value = "板厚或规格")
   @JsonProperty("steelSpec")
   @JSONField(name = "steelSpec")
   private String steelSpec;
   @ApiModelProperty(name = "steelId", notes = "版型id", value = "版型id")
   @JsonProperty("steelId")
   @JSONField(name = "steelId")
   private Integer steelId;
   @ApiModelProperty(name = "quantity", notes = "数量", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "category", notes = "围护类型", value = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "material", notes = "材质", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重量", value = "总毛重量")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重量", value = "总净重量")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalArea", notes = "总面积", value = "总面积")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "totalLength", notes = "总长度", value = "总长度")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;

   public static ProductClassifyDO.ProductClassifyDOBuilder builder() {
      return new ProductClassifyDO.ProductClassifyDOBuilder();
   }

   public ProductClassifyDO(
      final String name,
      final String steelSpec,
      final Integer steelId,
      final Integer quantity,
      final Integer category,
      final String material,
      final BigDecimal totalGrossWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal totalArea,
      final BigDecimal totalLength
   ) {
      this.name = name;
      this.steelSpec = steelSpec;
      this.steelId = steelId;
      this.quantity = quantity;
      this.category = category;
      this.material = material;
      this.totalGrossWeight = totalGrossWeight;
      this.totalNetWeight = totalNetWeight;
      this.totalArea = totalArea;
      this.totalLength = totalLength;
   }

   public ProductClassifyDO() {
   }

   public String getName() {
      return this.name;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   public Integer getSteelId() {
      return this.steelId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   @JsonProperty("name")
   public ProductClassifyDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("steelSpec")
   public ProductClassifyDO setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
      return this;
   }

   @JsonProperty("steelId")
   public ProductClassifyDO setSteelId(final Integer steelId) {
      this.steelId = steelId;
      return this;
   }

   @JsonProperty("quantity")
   public ProductClassifyDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("category")
   public ProductClassifyDO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("material")
   public ProductClassifyDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public ProductClassifyDO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ProductClassifyDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalArea")
   public ProductClassifyDO setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("totalLength")
   public ProductClassifyDO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @Override
   public String toString() {
      return "ProductClassifyDO(name="
         + this.getName()
         + ", steelSpec="
         + this.getSteelSpec()
         + ", steelId="
         + this.getSteelId()
         + ", quantity="
         + this.getQuantity()
         + ", category="
         + this.getCategory()
         + ", material="
         + this.getMaterial()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalArea="
         + this.getTotalArea()
         + ", totalLength="
         + this.getTotalLength()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductClassifyDO)) {
         return false;
      }

      ProductClassifyDO other = (ProductClassifyDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$steelId = this.getSteelId();
      Object other$steelId = other.getSteelId();
      if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$steelSpec = this.getSteelSpec();
                  Object other$steelSpec = other.getSteelSpec();
                  if (this$steelSpec == null ? other$steelSpec == null : this$steelSpec.equals(other$steelSpec)) {
                     Object this$material = this.getMaterial();
                     Object other$material = other.getMaterial();
                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                        Object this$totalGrossWeight = this.getTotalGrossWeight();
                        Object other$totalGrossWeight = other.getTotalGrossWeight();
                        if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                           Object this$totalNetWeight = this.getTotalNetWeight();
                           Object other$totalNetWeight = other.getTotalNetWeight();
                           if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                              Object this$totalArea = this.getTotalArea();
                              Object other$totalArea = other.getTotalArea();
                              if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                 Object this$totalLength = this.getTotalLength();
                                 Object other$totalLength = other.getTotalLength();
                                 return this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength);
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
      return other instanceof ProductClassifyDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $steelSpec = this.getSteelSpec();
      result = result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $totalLength = this.getTotalLength();
      return result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
   }

   public static class ProductClassifyDOBuilder {
      private String name;
      private String steelSpec;
      private Integer steelId;
      private Integer quantity;
      private Integer category;
      private String material;
      private BigDecimal totalGrossWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal totalArea;
      private BigDecimal totalLength;

      ProductClassifyDOBuilder() {
      }

      @JsonProperty("name")
      public ProductClassifyDO.ProductClassifyDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("steelSpec")
      public ProductClassifyDO.ProductClassifyDOBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      @JsonProperty("steelId")
      public ProductClassifyDO.ProductClassifyDOBuilder steelId(final Integer steelId) {
         this.steelId = steelId;
         return this;
      }

      @JsonProperty("quantity")
      public ProductClassifyDO.ProductClassifyDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("category")
      public ProductClassifyDO.ProductClassifyDOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("material")
      public ProductClassifyDO.ProductClassifyDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public ProductClassifyDO.ProductClassifyDOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ProductClassifyDO.ProductClassifyDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalArea")
      public ProductClassifyDO.ProductClassifyDOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("totalLength")
      public ProductClassifyDO.ProductClassifyDOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public ProductClassifyDO build() {
         return new ProductClassifyDO(
            this.name,
            this.steelSpec,
            this.steelId,
            this.quantity,
            this.category,
            this.material,
            this.totalGrossWeight,
            this.totalNetWeight,
            this.totalArea,
            this.totalLength
         );
      }

      @Override
      public String toString() {
         return "ProductClassifyDO.ProductClassifyDOBuilder(name="
            + this.name
            + ", steelSpec="
            + this.steelSpec
            + ", steelId="
            + this.steelId
            + ", quantity="
            + this.quantity
            + ", category="
            + this.category
            + ", material="
            + this.material
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalArea="
            + this.totalArea
            + ", totalLength="
            + this.totalLength
            + ")";
      }
   }
}
