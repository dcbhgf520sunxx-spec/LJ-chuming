package com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingCargoListProductLink对象", description = "发运产品关联")
@Entity
@TableName("mes_building_cargo_list_product_link")
@Table(
   name = "mes_building_cargo_list_product_link",
   indexes = {
         @Index(name = "productId_index", columnList = "product_id"),
         @Index(name = "cargo_list_id_index", columnList = "cargo_list_id"),
         @Index(name = "warehouse_record_id_index", columnList = "warehouse_record_id"),
         @Index(name = "in_year_month_day_date", columnList = "in_year_month_day_date"),
         @Index(name = "in_year_month_date", columnList = "in_year_month_date")
   }
)
public class MesBuildingCargoListProductLink extends BaseEntity<Long> {
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
   @Column(name = "quantity", columnDefinition = "decimal(18,4) COMMENT '装车数量'", nullable = false)
   private BigDecimal quantity;
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
   @Column(name = "measure_mode", columnDefinition = "int(11) default 1  COMMENT '计量方式 构件:1理计2磅计, 围护:1长度计量2面积计量'")
   private Integer measureMode;
   @ApiModelProperty(name = "boolCancelShip", value = "是否取消发运 ", notes = "是否取消发运")
   @JsonProperty("boolCancelShip")
   @JSONField(name = "boolCancelShip")
   @TableField("bool_cancel_ship")
   @Column(name = "bool_cancel_ship", columnDefinition = "tinyint(1) default 0  COMMENT '是否取消发运'")
   private Boolean boolCancelShip;
   @ApiModelProperty(name = "warehouseType")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type", columnDefinition = "int(11) default '0' COMMENT ''", nullable = false)
   private Integer warehouseType;
   @ApiModelProperty(name = "boolProblemReceiving", value = "是否问题收货 1问题收货 0正常收货 ", notes = "是否问题收货 1问题收货 0正常收货")
   @JsonProperty("boolProblemReceiving")
   @JSONField(name = "boolProblemReceiving")
   @TableField("bool_problem_receiving")
   @Column(name = "bool_problem_receiving", columnDefinition = "tinyint(1)  COMMENT '是否问题收货 1问题收货 0正常收货'")
   private Boolean boolProblemReceiving;
   @ApiModelProperty(name = "inYearMonthDayDate")
   @JsonProperty("inYearMonthDayDate")
   @JSONField(name = "inYearMonthDayDate")
   @TableField(value = "in_year_month_day_date", fill = FieldFill.INSERT)
   @Column(name = "in_year_month_day_date", columnDefinition = "varchar(564) COMMENT '日期(年-月-日)'")
   private String inYearMonthDayDate;
   @ApiModelProperty(name = "inYearMonthDate")
   @JsonProperty("inYearMonthDate")
   @JSONField(name = "inYearMonthDate")
   @TableField(value = "in_year_month_date", fill = FieldFill.INSERT)
   @Column(name = "in_year_month_date", columnDefinition = "varchar(564) COMMENT '日期(年-月)'")
   private String inYearMonthDate;
   @ApiModelProperty(name = "dictionaryId", value = "字典表id")
   @JsonProperty("dictionaryId")
   @JSONField(name = "dictionaryId")
   @TableField("dictionary_id")
   @Column(name = "dictionary_id")
   private Long dictionaryId;

   public static MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder builder() {
      return new MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder();
   }

   public MesBuildingCargoListProductLink() {
   }

   public MesBuildingCargoListProductLink(
      final Long id,
      final Long cargoListId,
      final Long packageId,
      final Long warehouseRecordId,
      final Long productId,
      final Integer productType,
      final BigDecimal quantity,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final BigDecimal weight,
      final BigDecimal length,
      final BigDecimal surfaceArea,
      final Integer category,
      final Integer measureMode,
      final Boolean boolCancelShip,
      final Integer warehouseType,
      final Boolean boolProblemReceiving,
      final String inYearMonthDayDate,
      final String inYearMonthDate,
      final Long dictionaryId
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
      this.boolCancelShip = boolCancelShip;
      this.warehouseType = warehouseType;
      this.boolProblemReceiving = boolProblemReceiving;
      this.inYearMonthDayDate = inYearMonthDayDate;
      this.inYearMonthDate = inYearMonthDate;
      this.dictionaryId = dictionaryId;
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

   public BigDecimal getQuantity() {
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

   public Boolean getBoolCancelShip() {
      return this.boolCancelShip;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Boolean getBoolProblemReceiving() {
      return this.boolProblemReceiving;
   }

   public String getInYearMonthDayDate() {
      return this.inYearMonthDayDate;
   }

   public String getInYearMonthDate() {
      return this.inYearMonthDate;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   @JsonProperty("id")
   public MesBuildingCargoListProductLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cargoListId")
   public MesBuildingCargoListProductLink setCargoListId(final Long cargoListId) {
      this.cargoListId = cargoListId;
      return this;
   }

   @JsonProperty("packageId")
   public MesBuildingCargoListProductLink setPackageId(final Long packageId) {
      this.packageId = packageId;
      return this;
   }

   @JsonProperty("warehouseRecordId")
   public MesBuildingCargoListProductLink setWarehouseRecordId(final Long warehouseRecordId) {
      this.warehouseRecordId = warehouseRecordId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingCargoListProductLink setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingCargoListProductLink setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingCargoListProductLink setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingCargoListProductLink setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesBuildingCargoListProductLink setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("weight")
   public MesBuildingCargoListProductLink setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingCargoListProductLink setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("surfaceArea")
   public MesBuildingCargoListProductLink setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public MesBuildingCargoListProductLink setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public MesBuildingCargoListProductLink setMeasureMode(final Integer measureMode) {
      this.measureMode = measureMode;
      return this;
   }

   @JsonProperty("boolCancelShip")
   public MesBuildingCargoListProductLink setBoolCancelShip(final Boolean boolCancelShip) {
      this.boolCancelShip = boolCancelShip;
      return this;
   }

   @JsonProperty("warehouseType")
   public MesBuildingCargoListProductLink setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("boolProblemReceiving")
   public MesBuildingCargoListProductLink setBoolProblemReceiving(final Boolean boolProblemReceiving) {
      this.boolProblemReceiving = boolProblemReceiving;
      return this;
   }

   @JsonProperty("inYearMonthDayDate")
   public MesBuildingCargoListProductLink setInYearMonthDayDate(final String inYearMonthDayDate) {
      this.inYearMonthDayDate = inYearMonthDayDate;
      return this;
   }

   @JsonProperty("inYearMonthDate")
   public MesBuildingCargoListProductLink setInYearMonthDate(final String inYearMonthDate) {
      this.inYearMonthDate = inYearMonthDate;
      return this;
   }

   @JsonProperty("dictionaryId")
   public MesBuildingCargoListProductLink setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCargoListProductLink(id="
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
         + ", boolCancelShip="
         + this.getBoolCancelShip()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", boolProblemReceiving="
         + this.getBoolProblemReceiving()
         + ", inYearMonthDayDate="
         + this.getInYearMonthDayDate()
         + ", inYearMonthDate="
         + this.getInYearMonthDate()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCargoListProductLink)) {
         return false;
      }

      MesBuildingCargoListProductLink other = (MesBuildingCargoListProductLink)o;
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
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$measureMode = this.getMeasureMode();
                           Object other$measureMode = other.getMeasureMode();
                           if (this$measureMode == null ? other$measureMode == null : this$measureMode.equals(other$measureMode)) {
                              Object this$boolCancelShip = this.getBoolCancelShip();
                              Object other$boolCancelShip = other.getBoolCancelShip();
                              if (this$boolCancelShip == null ? other$boolCancelShip == null : this$boolCancelShip.equals(other$boolCancelShip)) {
                                 Object this$warehouseType = this.getWarehouseType();
                                 Object other$warehouseType = other.getWarehouseType();
                                 if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                                    Object this$boolProblemReceiving = this.getBoolProblemReceiving();
                                    Object other$boolProblemReceiving = other.getBoolProblemReceiving();
                                    if (this$boolProblemReceiving == null
                                       ? other$boolProblemReceiving == null
                                       : this$boolProblemReceiving.equals(other$boolProblemReceiving)) {
                                       Object this$dictionaryId = this.getDictionaryId();
                                       Object other$dictionaryId = other.getDictionaryId();
                                       if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                                          Object this$quantity = this.getQuantity();
                                          Object other$quantity = other.getQuantity();
                                          if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
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
                                                         if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                            Object this$inYearMonthDayDate = this.getInYearMonthDayDate();
                                                            Object other$inYearMonthDayDate = other.getInYearMonthDayDate();
                                                            if (this$inYearMonthDayDate == null
                                                               ? other$inYearMonthDayDate == null
                                                               : this$inYearMonthDayDate.equals(other$inYearMonthDayDate)) {
                                                               Object this$inYearMonthDate = this.getInYearMonthDate();
                                                               Object other$inYearMonthDate = other.getInYearMonthDate();
                                                               return this$inYearMonthDate == null
                                                                  ? other$inYearMonthDate == null
                                                                  : this$inYearMonthDate.equals(other$inYearMonthDate);
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
      return other instanceof MesBuildingCargoListProductLink;
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
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $measureMode = this.getMeasureMode();
      result = result * 59 + ($measureMode == null ? 43 : $measureMode.hashCode());
      Object $boolCancelShip = this.getBoolCancelShip();
      result = result * 59 + ($boolCancelShip == null ? 43 : $boolCancelShip.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $boolProblemReceiving = this.getBoolProblemReceiving();
      result = result * 59 + ($boolProblemReceiving == null ? 43 : $boolProblemReceiving.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $inYearMonthDayDate = this.getInYearMonthDayDate();
      result = result * 59 + ($inYearMonthDayDate == null ? 43 : $inYearMonthDayDate.hashCode());
      Object $inYearMonthDate = this.getInYearMonthDate();
      return result * 59 + ($inYearMonthDate == null ? 43 : $inYearMonthDate.hashCode());
   }

   public static class MesBuildingCargoListProductLinkBuilder {
      private Long id;
      private Long cargoListId;
      private Long packageId;
      private Long warehouseRecordId;
      private Long productId;
      private Integer productType;
      private BigDecimal quantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private BigDecimal weight;
      private BigDecimal length;
      private BigDecimal surfaceArea;
      private Integer category;
      private Integer measureMode;
      private Boolean boolCancelShip;
      private Integer warehouseType;
      private Boolean boolProblemReceiving;
      private String inYearMonthDayDate;
      private String inYearMonthDate;
      private Long dictionaryId;

      MesBuildingCargoListProductLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cargoListId")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder cargoListId(final Long cargoListId) {
         this.cargoListId = cargoListId;
         return this;
      }

      @JsonProperty("packageId")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder packageId(final Long packageId) {
         this.packageId = packageId;
         return this;
      }

      @JsonProperty("warehouseRecordId")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder warehouseRecordId(final Long warehouseRecordId) {
         this.warehouseRecordId = warehouseRecordId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("weight")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("surfaceArea")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder measureMode(final Integer measureMode) {
         this.measureMode = measureMode;
         return this;
      }

      @JsonProperty("boolCancelShip")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder boolCancelShip(final Boolean boolCancelShip) {
         this.boolCancelShip = boolCancelShip;
         return this;
      }

      @JsonProperty("warehouseType")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("boolProblemReceiving")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder boolProblemReceiving(final Boolean boolProblemReceiving) {
         this.boolProblemReceiving = boolProblemReceiving;
         return this;
      }

      @JsonProperty("inYearMonthDayDate")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder inYearMonthDayDate(final String inYearMonthDayDate) {
         this.inYearMonthDayDate = inYearMonthDayDate;
         return this;
      }

      @JsonProperty("inYearMonthDate")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder inYearMonthDate(final String inYearMonthDate) {
         this.inYearMonthDate = inYearMonthDate;
         return this;
      }

      @JsonProperty("dictionaryId")
      public MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public MesBuildingCargoListProductLink build() {
         return new MesBuildingCargoListProductLink(
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
            this.measureMode,
            this.boolCancelShip,
            this.warehouseType,
            this.boolProblemReceiving,
            this.inYearMonthDayDate,
            this.inYearMonthDate,
            this.dictionaryId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingCargoListProductLink.MesBuildingCargoListProductLinkBuilder(id="
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
            + ", boolCancelShip="
            + this.boolCancelShip
            + ", warehouseType="
            + this.warehouseType
            + ", boolProblemReceiving="
            + this.boolProblemReceiving
            + ", inYearMonthDayDate="
            + this.inYearMonthDayDate
            + ", inYearMonthDate="
            + this.inYearMonthDate
            + ", dictionaryId="
            + this.dictionaryId
            + ")";
      }
   }
}
