package com.hzchum.scim.mes.building.core.api.pojo._doModel.craft;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "MesPaintingCraftDetail对象", description = "涂装工艺详情表")
@Entity
@TableName("mes_painting_craft_detail")
@Table(name = "mes_painting_craft_detail")
@org.hibernate.annotations.Table(appliesTo = "mes_painting_craft_detail", comment = "涂装工艺详情表")
public class MesPaintingCraftDetail extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("涂装工艺id")
   @TableField("painting_craft_id")
   @Column(name = "painting_craft_id", columnDefinition = "bigint(20) COMMENT '涂装工艺id'", nullable = true)
   private Long paintingCraftId;
   @ApiModelProperty("涂装工艺编号")
   @TableField("painting_craft_serial_number")
   @Column(name = "painting_craft_serial_number", columnDefinition = "varchar(225) COMMENT '涂装工艺编号'", nullable = true)
   private String paintingCraftSerialNumber;
   @ApiModelProperty("涂装类型")
   @TableField("painting_type_enum")
   @Column(name = "painting_type_enum", columnDefinition = "int COMMENT '涂装类型'", nullable = true)
   private Integer paintingTypeEnum;
   @ApiModelProperty("油漆品牌")
   @TableField("paint_brand")
   @Column(name = "paint_brand", columnDefinition = "varchar(225) COMMENT '油漆品牌'", nullable = true)
   private String paintBrand;
   @ApiModelProperty("油漆类型")
   @TableField("paint_type")
   @Column(name = "paint_type", columnDefinition = "varchar(225) COMMENT '油漆类型'", nullable = true)
   private String paintType;
   @ApiModelProperty("比重(㎏/L)")
   @TableField("specific_gravity")
   @Column(name = "specific_gravity", columnDefinition = "decimal(32,8) COMMENT '比重(㎏/L)'", nullable = true)
   private BigDecimal specificGravity;
   @ApiModelProperty("体积固含量(%)")
   @TableField("volume_solid_content")
   @Column(name = "volume_solid_content", columnDefinition = "decimal(32,8) COMMENT '体积固含量(%)'", nullable = true)
   private BigDecimal volumeSolidContent;
   @ApiModelProperty("包装重量(㎏)")
   @TableField("package_weight")
   @Column(name = "package_weight", columnDefinition = "decimal(32,8) COMMENT '包装重量(㎏)'", nullable = true)
   private BigDecimal packageWeight;
   @ApiModelProperty("单位(㎏,L)")
   @TableField("unit")
   @Column(name = "unit", columnDefinition = "varchar(225) COMMENT '单位(㎏,L)'", nullable = true)
   private String unit;
   @ApiModelProperty("包装单位(桶,组)")
   @TableField("package_unit")
   @Column(name = "package_unit", columnDefinition = "varchar(225) COMMENT '包装单位(桶,组)'", nullable = true)
   private String packageUnit;
   @ApiModelProperty("漆膜厚度(µm)")
   @TableField("paint_film_thickness")
   @Column(name = "paint_film_thickness", columnDefinition = "decimal(32,8) COMMENT '漆膜厚度(µm)'", nullable = true)
   private BigDecimal paintFilmThickness;
   @ApiModelProperty("损耗系数")
   @TableField("loss_coefficient")
   @Column(name = "loss_coefficient", columnDefinition = "decimal(32,8) COMMENT '损耗系数'", nullable = true)
   private BigDecimal lossCoefficient;
   @ApiModelProperty("重量(㎏)")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "decimal(32,8) COMMENT '重量(㎏)'", nullable = true)
   private BigDecimal weight;
   @ApiModelProperty("数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8) COMMENT '数量'", nullable = true)
   private BigDecimal quantity;

   public static MesPaintingCraftDetail.MesPaintingCraftDetailBuilder builder() {
      return new MesPaintingCraftDetail.MesPaintingCraftDetailBuilder();
   }

   public MesPaintingCraftDetail() {
   }

   public MesPaintingCraftDetail(
      final Long id,
      final Long paintingCraftId,
      final String paintingCraftSerialNumber,
      final Integer paintingTypeEnum,
      final String paintBrand,
      final String paintType,
      final BigDecimal specificGravity,
      final BigDecimal volumeSolidContent,
      final BigDecimal packageWeight,
      final String unit,
      final String packageUnit,
      final BigDecimal paintFilmThickness,
      final BigDecimal lossCoefficient,
      final BigDecimal weight,
      final BigDecimal quantity
   ) {
      this.id = id;
      this.paintingCraftId = paintingCraftId;
      this.paintingCraftSerialNumber = paintingCraftSerialNumber;
      this.paintingTypeEnum = paintingTypeEnum;
      this.paintBrand = paintBrand;
      this.paintType = paintType;
      this.specificGravity = specificGravity;
      this.volumeSolidContent = volumeSolidContent;
      this.packageWeight = packageWeight;
      this.unit = unit;
      this.packageUnit = packageUnit;
      this.paintFilmThickness = paintFilmThickness;
      this.lossCoefficient = lossCoefficient;
      this.weight = weight;
      this.quantity = quantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPaintingCraftId() {
      return this.paintingCraftId;
   }

   public String getPaintingCraftSerialNumber() {
      return this.paintingCraftSerialNumber;
   }

   public Integer getPaintingTypeEnum() {
      return this.paintingTypeEnum;
   }

   public String getPaintBrand() {
      return this.paintBrand;
   }

   public String getPaintType() {
      return this.paintType;
   }

   public BigDecimal getSpecificGravity() {
      return this.specificGravity;
   }

   public BigDecimal getVolumeSolidContent() {
      return this.volumeSolidContent;
   }

   public BigDecimal getPackageWeight() {
      return this.packageWeight;
   }

   public String getUnit() {
      return this.unit;
   }

   public String getPackageUnit() {
      return this.packageUnit;
   }

   public BigDecimal getPaintFilmThickness() {
      return this.paintFilmThickness;
   }

   public BigDecimal getLossCoefficient() {
      return this.lossCoefficient;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public MesPaintingCraftDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesPaintingCraftDetail setPaintingCraftId(final Long paintingCraftId) {
      this.paintingCraftId = paintingCraftId;
      return this;
   }

   public MesPaintingCraftDetail setPaintingCraftSerialNumber(final String paintingCraftSerialNumber) {
      this.paintingCraftSerialNumber = paintingCraftSerialNumber;
      return this;
   }

   public MesPaintingCraftDetail setPaintingTypeEnum(final Integer paintingTypeEnum) {
      this.paintingTypeEnum = paintingTypeEnum;
      return this;
   }

   public MesPaintingCraftDetail setPaintBrand(final String paintBrand) {
      this.paintBrand = paintBrand;
      return this;
   }

   public MesPaintingCraftDetail setPaintType(final String paintType) {
      this.paintType = paintType;
      return this;
   }

   public MesPaintingCraftDetail setSpecificGravity(final BigDecimal specificGravity) {
      this.specificGravity = specificGravity;
      return this;
   }

   public MesPaintingCraftDetail setVolumeSolidContent(final BigDecimal volumeSolidContent) {
      this.volumeSolidContent = volumeSolidContent;
      return this;
   }

   public MesPaintingCraftDetail setPackageWeight(final BigDecimal packageWeight) {
      this.packageWeight = packageWeight;
      return this;
   }

   public MesPaintingCraftDetail setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public MesPaintingCraftDetail setPackageUnit(final String packageUnit) {
      this.packageUnit = packageUnit;
      return this;
   }

   public MesPaintingCraftDetail setPaintFilmThickness(final BigDecimal paintFilmThickness) {
      this.paintFilmThickness = paintFilmThickness;
      return this;
   }

   public MesPaintingCraftDetail setLossCoefficient(final BigDecimal lossCoefficient) {
      this.lossCoefficient = lossCoefficient;
      return this;
   }

   public MesPaintingCraftDetail setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   public MesPaintingCraftDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesPaintingCraftDetail(id="
         + this.getId()
         + ", paintingCraftId="
         + this.getPaintingCraftId()
         + ", paintingCraftSerialNumber="
         + this.getPaintingCraftSerialNumber()
         + ", paintingTypeEnum="
         + this.getPaintingTypeEnum()
         + ", paintBrand="
         + this.getPaintBrand()
         + ", paintType="
         + this.getPaintType()
         + ", specificGravity="
         + this.getSpecificGravity()
         + ", volumeSolidContent="
         + this.getVolumeSolidContent()
         + ", packageWeight="
         + this.getPackageWeight()
         + ", unit="
         + this.getUnit()
         + ", packageUnit="
         + this.getPackageUnit()
         + ", paintFilmThickness="
         + this.getPaintFilmThickness()
         + ", lossCoefficient="
         + this.getLossCoefficient()
         + ", weight="
         + this.getWeight()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPaintingCraftDetail)) {
         return false;
      }

      MesPaintingCraftDetail other = (MesPaintingCraftDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paintingCraftId = this.getPaintingCraftId();
         Object other$paintingCraftId = other.getPaintingCraftId();
         if (this$paintingCraftId == null ? other$paintingCraftId == null : this$paintingCraftId.equals(other$paintingCraftId)) {
            Object this$paintingTypeEnum = this.getPaintingTypeEnum();
            Object other$paintingTypeEnum = other.getPaintingTypeEnum();
            if (this$paintingTypeEnum == null ? other$paintingTypeEnum == null : this$paintingTypeEnum.equals(other$paintingTypeEnum)) {
               Object this$paintingCraftSerialNumber = this.getPaintingCraftSerialNumber();
               Object other$paintingCraftSerialNumber = other.getPaintingCraftSerialNumber();
               if (this$paintingCraftSerialNumber == null
                  ? other$paintingCraftSerialNumber == null
                  : this$paintingCraftSerialNumber.equals(other$paintingCraftSerialNumber)) {
                  Object this$paintBrand = this.getPaintBrand();
                  Object other$paintBrand = other.getPaintBrand();
                  if (this$paintBrand == null ? other$paintBrand == null : this$paintBrand.equals(other$paintBrand)) {
                     Object this$paintType = this.getPaintType();
                     Object other$paintType = other.getPaintType();
                     if (this$paintType == null ? other$paintType == null : this$paintType.equals(other$paintType)) {
                        Object this$specificGravity = this.getSpecificGravity();
                        Object other$specificGravity = other.getSpecificGravity();
                        if (this$specificGravity == null ? other$specificGravity == null : this$specificGravity.equals(other$specificGravity)) {
                           Object this$volumeSolidContent = this.getVolumeSolidContent();
                           Object other$volumeSolidContent = other.getVolumeSolidContent();
                           if (this$volumeSolidContent == null ? other$volumeSolidContent == null : this$volumeSolidContent.equals(other$volumeSolidContent)) {
                              Object this$packageWeight = this.getPackageWeight();
                              Object other$packageWeight = other.getPackageWeight();
                              if (this$packageWeight == null ? other$packageWeight == null : this$packageWeight.equals(other$packageWeight)) {
                                 Object this$unit = this.getUnit();
                                 Object other$unit = other.getUnit();
                                 if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                    Object this$packageUnit = this.getPackageUnit();
                                    Object other$packageUnit = other.getPackageUnit();
                                    if (this$packageUnit == null ? other$packageUnit == null : this$packageUnit.equals(other$packageUnit)) {
                                       Object this$paintFilmThickness = this.getPaintFilmThickness();
                                       Object other$paintFilmThickness = other.getPaintFilmThickness();
                                       if (this$paintFilmThickness == null
                                          ? other$paintFilmThickness == null
                                          : this$paintFilmThickness.equals(other$paintFilmThickness)) {
                                          Object this$lossCoefficient = this.getLossCoefficient();
                                          Object other$lossCoefficient = other.getLossCoefficient();
                                          if (this$lossCoefficient == null ? other$lossCoefficient == null : this$lossCoefficient.equals(other$lossCoefficient)
                                             )
                                           {
                                             Object this$weight = this.getWeight();
                                             Object other$weight = other.getWeight();
                                             if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
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
      return other instanceof MesPaintingCraftDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paintingCraftId = this.getPaintingCraftId();
      result = result * 59 + ($paintingCraftId == null ? 43 : $paintingCraftId.hashCode());
      Object $paintingTypeEnum = this.getPaintingTypeEnum();
      result = result * 59 + ($paintingTypeEnum == null ? 43 : $paintingTypeEnum.hashCode());
      Object $paintingCraftSerialNumber = this.getPaintingCraftSerialNumber();
      result = result * 59 + ($paintingCraftSerialNumber == null ? 43 : $paintingCraftSerialNumber.hashCode());
      Object $paintBrand = this.getPaintBrand();
      result = result * 59 + ($paintBrand == null ? 43 : $paintBrand.hashCode());
      Object $paintType = this.getPaintType();
      result = result * 59 + ($paintType == null ? 43 : $paintType.hashCode());
      Object $specificGravity = this.getSpecificGravity();
      result = result * 59 + ($specificGravity == null ? 43 : $specificGravity.hashCode());
      Object $volumeSolidContent = this.getVolumeSolidContent();
      result = result * 59 + ($volumeSolidContent == null ? 43 : $volumeSolidContent.hashCode());
      Object $packageWeight = this.getPackageWeight();
      result = result * 59 + ($packageWeight == null ? 43 : $packageWeight.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $packageUnit = this.getPackageUnit();
      result = result * 59 + ($packageUnit == null ? 43 : $packageUnit.hashCode());
      Object $paintFilmThickness = this.getPaintFilmThickness();
      result = result * 59 + ($paintFilmThickness == null ? 43 : $paintFilmThickness.hashCode());
      Object $lossCoefficient = this.getLossCoefficient();
      result = result * 59 + ($lossCoefficient == null ? 43 : $lossCoefficient.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class MesPaintingCraftDetailBuilder {
      private Long id;
      private Long paintingCraftId;
      private String paintingCraftSerialNumber;
      private Integer paintingTypeEnum;
      private String paintBrand;
      private String paintType;
      private BigDecimal specificGravity;
      private BigDecimal volumeSolidContent;
      private BigDecimal packageWeight;
      private String unit;
      private String packageUnit;
      private BigDecimal paintFilmThickness;
      private BigDecimal lossCoefficient;
      private BigDecimal weight;
      private BigDecimal quantity;

      MesPaintingCraftDetailBuilder() {
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder paintingCraftId(final Long paintingCraftId) {
         this.paintingCraftId = paintingCraftId;
         return this;
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder paintingCraftSerialNumber(final String paintingCraftSerialNumber) {
         this.paintingCraftSerialNumber = paintingCraftSerialNumber;
         return this;
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder paintingTypeEnum(final Integer paintingTypeEnum) {
         this.paintingTypeEnum = paintingTypeEnum;
         return this;
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder paintBrand(final String paintBrand) {
         this.paintBrand = paintBrand;
         return this;
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder paintType(final String paintType) {
         this.paintType = paintType;
         return this;
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder specificGravity(final BigDecimal specificGravity) {
         this.specificGravity = specificGravity;
         return this;
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder volumeSolidContent(final BigDecimal volumeSolidContent) {
         this.volumeSolidContent = volumeSolidContent;
         return this;
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder packageWeight(final BigDecimal packageWeight) {
         this.packageWeight = packageWeight;
         return this;
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder packageUnit(final String packageUnit) {
         this.packageUnit = packageUnit;
         return this;
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder paintFilmThickness(final BigDecimal paintFilmThickness) {
         this.paintFilmThickness = paintFilmThickness;
         return this;
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder lossCoefficient(final BigDecimal lossCoefficient) {
         this.lossCoefficient = lossCoefficient;
         return this;
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public MesPaintingCraftDetail.MesPaintingCraftDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesPaintingCraftDetail build() {
         return new MesPaintingCraftDetail(
            this.id,
            this.paintingCraftId,
            this.paintingCraftSerialNumber,
            this.paintingTypeEnum,
            this.paintBrand,
            this.paintType,
            this.specificGravity,
            this.volumeSolidContent,
            this.packageWeight,
            this.unit,
            this.packageUnit,
            this.paintFilmThickness,
            this.lossCoefficient,
            this.weight,
            this.quantity
         );
      }

      @Override
      public String toString() {
         return "MesPaintingCraftDetail.MesPaintingCraftDetailBuilder(id="
            + this.id
            + ", paintingCraftId="
            + this.paintingCraftId
            + ", paintingCraftSerialNumber="
            + this.paintingCraftSerialNumber
            + ", paintingTypeEnum="
            + this.paintingTypeEnum
            + ", paintBrand="
            + this.paintBrand
            + ", paintType="
            + this.paintType
            + ", specificGravity="
            + this.specificGravity
            + ", volumeSolidContent="
            + this.volumeSolidContent
            + ", packageWeight="
            + this.packageWeight
            + ", unit="
            + this.unit
            + ", packageUnit="
            + this.packageUnit
            + ", paintFilmThickness="
            + this.paintFilmThickness
            + ", lossCoefficient="
            + this.lossCoefficient
            + ", weight="
            + this.weight
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
