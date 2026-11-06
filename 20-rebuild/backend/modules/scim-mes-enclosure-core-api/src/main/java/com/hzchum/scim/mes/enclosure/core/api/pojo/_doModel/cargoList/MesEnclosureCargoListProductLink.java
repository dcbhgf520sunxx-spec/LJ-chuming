package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesEnclosureCargoListProductLink对象", description = "发运产品关联")
@Entity
@TableName("mes_enclosure_cargo_list_product_link")
@Table(name = "mes_enclosure_cargo_list_product_link")
public class MesEnclosureCargoListProductLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "cargoListId", value = "装车id", notes = "装车id")
   @JsonProperty("cargoListId")
   @JSONField(name = "cargoListId")
   @TableField("cargo_list_id")
   @Column(name = "cargo_list_id", columnDefinition = "bigint(20)  COMMENT '装车id'", nullable = false)
   private Long cargoListId;
   @ApiModelProperty(name = "packageId", value = "包id", notes = "包id")
   @JsonProperty("packageId")
   @JSONField(name = "packageId")
   @TableField("package_id")
   @Column(name = "package_id", columnDefinition = "bigint(20)  COMMENT '包id'", nullable = true)
   private Long packageId;
   @ApiModelProperty(name = "warehouseRecordId", value = "出入库id", notes = "出入库id")
   @JsonProperty("warehouseRecordId")
   @JSONField(name = "warehouseRecordId")
   @TableField("warehouse_record_id")
   @Column(name = "warehouse_record_id", columnDefinition = "bigint(20)  COMMENT '出入库id'", nullable = false)
   private Long warehouseRecordId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "quantity", value = "装车数量", notes = "装车数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '装车数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   @TableField("net_weight")
   @Column(name = "net_weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '单净重'", nullable = false)
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重", notes = "单毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   @TableField("gross_weight")
   @Column(name = "gross_weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '单毛重'", nullable = false)
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "weight", value = "参与计算重量", notes = "参与计算重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '参与计算重量'", nullable = false)
   private BigDecimal weight;
   @ApiModelProperty(name = "length", value = "单长度", notes = "单长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '单长度'", nullable = false)
   private BigDecimal length;
   @ApiModelProperty(name = "surfaceArea", value = "单面积", notes = "单面积")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '单面积'", nullable = false)
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "category", value = "围护类型 2压型彩板 4夹心板 8桁架楼承板 16压型楼承板 32折边件 枚举:EnclosureCategoryEnum", notes = "围护类型")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11)  COMMENT '围护类型 2压型彩板 4夹心板 8桁架楼承板 16压型楼承板 32折边件 枚举:EnclosureCategoryEnum'")
   private Integer category;
   @ApiModelProperty(name = "measureMode", value = "计量方式 构件:1理计2磅计, 围护:1长度计量2面积计量 ", notes = "计量方式 构件:1理计2磅计, 围护:1长度计量2面积计量")
   @TableField("measure_mode")
   @Column(name = "measure_mode", columnDefinition = "int(11)  COMMENT '计量方式 构件:1理计2磅计, 围护:1长度计量2面积计量'")
   private Integer measureMode;

   public static MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder builder() {
      return new MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder();
   }

   public MesEnclosureCargoListProductLink() {
   }

   public MesEnclosureCargoListProductLink(
      final Long id,
      final Long cargoListId,
      final Long packageId,
      final Long warehouseRecordId,
      final Long productId,
      final Integer productType,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final BigDecimal weight,
      final BigDecimal length,
      final BigDecimal surfaceArea,
      final Integer category,
      final Integer measureMode
   ) {
      this.id = id;
      this.cargoListId = cargoListId;
      this.packageId = packageId;
      this.warehouseRecordId = warehouseRecordId;
      this.productId = productId;
      this.productType = productType;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.weight = weight;
      this.length = length;
      this.surfaceArea = surfaceArea;
      this.category = category;
      this.measureMode = measureMode;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCargoListId() {
      return this.cargoListId;
   }

   public Long getPackageId() {
      return this.packageId;
   }

   public Long getWarehouseRecordId() {
      return this.warehouseRecordId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getMeasureMode() {
      return this.measureMode;
   }

   @JsonProperty("id")
   public MesEnclosureCargoListProductLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cargoListId")
   public MesEnclosureCargoListProductLink setCargoListId(final Long cargoListId) {
      this.cargoListId = cargoListId;
      return this;
   }

   @JsonProperty("packageId")
   public MesEnclosureCargoListProductLink setPackageId(final Long packageId) {
      this.packageId = packageId;
      return this;
   }

   @JsonProperty("warehouseRecordId")
   public MesEnclosureCargoListProductLink setWarehouseRecordId(final Long warehouseRecordId) {
      this.warehouseRecordId = warehouseRecordId;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureCargoListProductLink setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesEnclosureCargoListProductLink setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureCargoListProductLink setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesEnclosureCargoListProductLink setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesEnclosureCargoListProductLink setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("weight")
   public MesEnclosureCargoListProductLink setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("length")
   public MesEnclosureCargoListProductLink setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("surfaceArea")
   public MesEnclosureCargoListProductLink setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public MesEnclosureCargoListProductLink setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public MesEnclosureCargoListProductLink setMeasureMode(final Integer measureMode) {
      this.measureMode = measureMode;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureCargoListProductLink(id="
         + this.getId()
         + ", cargoListId="
         + this.getCargoListId()
         + ", packageId="
         + this.getPackageId()
         + ", warehouseRecordId="
         + this.getWarehouseRecordId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", weight="
         + this.getWeight()
         + ", length="
         + this.getLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", category="
         + this.getCategory()
         + ", measureMode="
         + this.getMeasureMode()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureCargoListProductLink)) {
         return false;
      }

      MesEnclosureCargoListProductLink other = (MesEnclosureCargoListProductLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cargoListId = this.getCargoListId();
         Object other$cargoListId = other.getCargoListId();
         if (this$cargoListId == null ? other$cargoListId == null : this$cargoListId.equals(other$cargoListId)) {
            Object this$packageId = this.getPackageId();
            Object other$packageId = other.getPackageId();
            if (this$packageId == null ? other$packageId == null : this$packageId.equals(other$packageId)) {
               Object this$warehouseRecordId = this.getWarehouseRecordId();
               Object other$warehouseRecordId = other.getWarehouseRecordId();
               if (this$warehouseRecordId == null ? other$warehouseRecordId == null : this$warehouseRecordId.equals(other$warehouseRecordId)) {
                  Object this$productId = this.getProductId();
                  Object other$productId = other.getProductId();
                  if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$category = this.getCategory();
                           Object other$category = other.getCategory();
                           if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                              Object this$measureMode = this.getMeasureMode();
                              Object other$measureMode = other.getMeasureMode();
                              if (this$measureMode == null ? other$measureMode == null : this$measureMode.equals(other$measureMode)) {
                                 Object this$netWeight = this.getNetWeight();
                                 Object other$netWeight = other.getNetWeight();
                                 if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                    Object this$grossWeight = this.getGrossWeight();
                                    Object other$grossWeight = other.getGrossWeight();
                                    if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                       Object this$weight = this.getWeight();
                                       Object other$weight = other.getWeight();
                                       if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                             Object this$surfaceArea = this.getSurfaceArea();
                                             Object other$surfaceArea = other.getSurfaceArea();
                                             return this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureCargoListProductLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cargoListId = this.getCargoListId();
      result = result * 59 + ($cargoListId == null ? 43 : $cargoListId.hashCode());
      Object $packageId = this.getPackageId();
      result = result * 59 + ($packageId == null ? 43 : $packageId.hashCode());
      Object $warehouseRecordId = this.getWarehouseRecordId();
      result = result * 59 + ($warehouseRecordId == null ? 43 : $warehouseRecordId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $measureMode = this.getMeasureMode();
      result = result * 59 + ($measureMode == null ? 43 : $measureMode.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      return result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
   }

   public static class MesEnclosureCargoListProductLinkBuilder {
      private Long id;
      private Long cargoListId;
      private Long packageId;
      private Long warehouseRecordId;
      private Long productId;
      private Integer productType;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private BigDecimal weight;
      private BigDecimal length;
      private BigDecimal surfaceArea;
      private Integer category;
      private Integer measureMode;

      MesEnclosureCargoListProductLinkBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cargoListId")
      public MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder cargoListId(final Long cargoListId) {
         this.cargoListId = cargoListId;
         return this;
      }

      @JsonProperty("packageId")
      public MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder packageId(final Long packageId) {
         this.packageId = packageId;
         return this;
      }

      @JsonProperty("warehouseRecordId")
      public MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder warehouseRecordId(final Long warehouseRecordId) {
         this.warehouseRecordId = warehouseRecordId;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("weight")
      public MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("length")
      public MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("surfaceArea")
      public MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder measureMode(final Integer measureMode) {
         this.measureMode = measureMode;
         return this;
      }

      public MesEnclosureCargoListProductLink build() {
         return new MesEnclosureCargoListProductLink(
            this.id,
            this.cargoListId,
            this.packageId,
            this.warehouseRecordId,
            this.productId,
            this.productType,
            this.quantity,
            this.netWeight,
            this.grossWeight,
            this.weight,
            this.length,
            this.surfaceArea,
            this.category,
            this.measureMode
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureCargoListProductLink.MesEnclosureCargoListProductLinkBuilder(id="
            + this.id
            + ", cargoListId="
            + this.cargoListId
            + ", packageId="
            + this.packageId
            + ", warehouseRecordId="
            + this.warehouseRecordId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", weight="
            + this.weight
            + ", length="
            + this.length
            + ", surfaceArea="
            + this.surfaceArea
            + ", category="
            + this.category
            + ", measureMode="
            + this.measureMode
            + ")";
      }
   }
}
