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

@ApiModel(value = "MesPaintConfig对象", description = "油漆配置表")
@Entity
@TableName("mes_paint_config")
@Table(name = "mes_paint_config")
@org.hibernate.annotations.Table(appliesTo = "mes_paint_config", comment = "油漆配置表")
public class MesPaintConfig extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
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

   public static MesPaintConfig.MesPaintConfigBuilder builder() {
      return new MesPaintConfig.MesPaintConfigBuilder();
   }

   public MesPaintConfig() {
   }

   public MesPaintConfig(
      final Long id,
      final Integer paintingTypeEnum,
      final String paintBrand,
      final String paintType,
      final BigDecimal specificGravity,
      final BigDecimal volumeSolidContent,
      final BigDecimal packageWeight,
      final String unit,
      final String packageUnit
   ) {
      this.id = id;
      this.paintingTypeEnum = paintingTypeEnum;
      this.paintBrand = paintBrand;
      this.paintType = paintType;
      this.specificGravity = specificGravity;
      this.volumeSolidContent = volumeSolidContent;
      this.packageWeight = packageWeight;
      this.unit = unit;
      this.packageUnit = packageUnit;
   }

   public Long getId() {
      return this.id;
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

   public MesPaintConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesPaintConfig setPaintingTypeEnum(final Integer paintingTypeEnum) {
      this.paintingTypeEnum = paintingTypeEnum;
      return this;
   }

   public MesPaintConfig setPaintBrand(final String paintBrand) {
      this.paintBrand = paintBrand;
      return this;
   }

   public MesPaintConfig setPaintType(final String paintType) {
      this.paintType = paintType;
      return this;
   }

   public MesPaintConfig setSpecificGravity(final BigDecimal specificGravity) {
      this.specificGravity = specificGravity;
      return this;
   }

   public MesPaintConfig setVolumeSolidContent(final BigDecimal volumeSolidContent) {
      this.volumeSolidContent = volumeSolidContent;
      return this;
   }

   public MesPaintConfig setPackageWeight(final BigDecimal packageWeight) {
      this.packageWeight = packageWeight;
      return this;
   }

   public MesPaintConfig setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public MesPaintConfig setPackageUnit(final String packageUnit) {
      this.packageUnit = packageUnit;
      return this;
   }

   @Override
   public String toString() {
      return "MesPaintConfig(id="
         + this.getId()
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPaintConfig)) {
         return false;
      }

      MesPaintConfig other = (MesPaintConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paintingTypeEnum = this.getPaintingTypeEnum();
         Object other$paintingTypeEnum = other.getPaintingTypeEnum();
         if (this$paintingTypeEnum == null ? other$paintingTypeEnum == null : this$paintingTypeEnum.equals(other$paintingTypeEnum)) {
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
                              return this$packageUnit == null ? other$packageUnit == null : this$packageUnit.equals(other$packageUnit);
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
      return other instanceof MesPaintConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paintingTypeEnum = this.getPaintingTypeEnum();
      result = result * 59 + ($paintingTypeEnum == null ? 43 : $paintingTypeEnum.hashCode());
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
      return result * 59 + ($packageUnit == null ? 43 : $packageUnit.hashCode());
   }

   public static class MesPaintConfigBuilder {
      private Long id;
      private Integer paintingTypeEnum;
      private String paintBrand;
      private String paintType;
      private BigDecimal specificGravity;
      private BigDecimal volumeSolidContent;
      private BigDecimal packageWeight;
      private String unit;
      private String packageUnit;

      MesPaintConfigBuilder() {
      }

      public MesPaintConfig.MesPaintConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesPaintConfig.MesPaintConfigBuilder paintingTypeEnum(final Integer paintingTypeEnum) {
         this.paintingTypeEnum = paintingTypeEnum;
         return this;
      }

      public MesPaintConfig.MesPaintConfigBuilder paintBrand(final String paintBrand) {
         this.paintBrand = paintBrand;
         return this;
      }

      public MesPaintConfig.MesPaintConfigBuilder paintType(final String paintType) {
         this.paintType = paintType;
         return this;
      }

      public MesPaintConfig.MesPaintConfigBuilder specificGravity(final BigDecimal specificGravity) {
         this.specificGravity = specificGravity;
         return this;
      }

      public MesPaintConfig.MesPaintConfigBuilder volumeSolidContent(final BigDecimal volumeSolidContent) {
         this.volumeSolidContent = volumeSolidContent;
         return this;
      }

      public MesPaintConfig.MesPaintConfigBuilder packageWeight(final BigDecimal packageWeight) {
         this.packageWeight = packageWeight;
         return this;
      }

      public MesPaintConfig.MesPaintConfigBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesPaintConfig.MesPaintConfigBuilder packageUnit(final String packageUnit) {
         this.packageUnit = packageUnit;
         return this;
      }

      public MesPaintConfig build() {
         return new MesPaintConfig(
            this.id,
            this.paintingTypeEnum,
            this.paintBrand,
            this.paintType,
            this.specificGravity,
            this.volumeSolidContent,
            this.packageWeight,
            this.unit,
            this.packageUnit
         );
      }

      @Override
      public String toString() {
         return "MesPaintConfig.MesPaintConfigBuilder(id="
            + this.id
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
            + ")";
      }
   }
}
