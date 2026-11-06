package com.hzchum.scim.plan.core.api.pojo._do;

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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "TechPaintTechnologyDetail对象", description = "喷漆工艺详情表 ")
@Entity
@TableName("tech_paint_technology_detail")
@Table(
   name = "tech_paint_technology_detail",
   indexes = {
         @Index(name = "paint_config_id", columnList = "paint_config_id"),
         @Index(name = "paint_technology_id", columnList = "paint_technology_id, painting_type_enum")
   }
)
@org.hibernate.annotations.Table(appliesTo = "tech_paint_technology_detail", comment = "喷漆工艺详情表 ")
public class TechPaintTechnologyDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "paintTechnologyId", value = "喷漆工艺id", notes = "喷漆工艺id")
   @TableField("paint_technology_id")
   @Column(name = "paint_technology_id", columnDefinition = "bigint(20)  COMMENT '喷漆工艺id'", nullable = false)
   private Long paintTechnologyId;
   @ApiModelProperty(name = "paintingTypeEnum", value = "喷漆类型 1底漆 2中间漆 4面漆", notes = "喷漆类型 1底漆 2中间漆 4面漆")
   @TableField("painting_type_enum")
   @Column(name = "painting_type_enum", columnDefinition = "int(11)  COMMENT '喷漆类型 1底漆 2中间漆 4面漆'", nullable = false)
   private Integer paintingTypeEnum;
   @ApiModelProperty(name = "paintConfigId", value = "油漆配置id", notes = "油漆配置id")
   @TableField("paint_config_id")
   @Column(name = "paint_config_id", columnDefinition = "bigint(20)  COMMENT '油漆配置id'", nullable = false)
   private Long paintConfigId;
   @ApiModelProperty(name = "paintType", value = "油漆类型(名称)", notes = "油漆类型(名称)")
   @TableField("paint_type")
   @Column(name = "paint_type", columnDefinition = "varchar(255)  COMMENT '油漆类型(名称)'", nullable = false)
   private String paintType;
   @ApiModelProperty(name = "paintBrand", value = "油漆品牌", notes = "油漆品牌")
   @TableField("paint_brand")
   @Column(name = "paint_brand", columnDefinition = "varchar(255)  COMMENT '油漆品牌'", nullable = false)
   private String paintBrand;
   @ApiModelProperty(name = "paintColor", value = "油漆颜色", notes = "油漆颜色")
   @TableField("paint_color")
   @Column(name = "paint_color", columnDefinition = "varchar(255)  COMMENT '油漆颜色'", nullable = false)
   private String paintColor;
   @ApiModelProperty(name = "paintFilmThickness", value = "漆膜厚度(μm)", notes = "漆膜厚度(μm)")
   @TableField("paint_film_thickness")
   @Column(name = "paint_film_thickness", columnDefinition = "decimal(8,2)  COMMENT '漆膜厚度(μm)'", nullable = false)
   private BigDecimal paintFilmThickness;

   public static TechPaintTechnologyDetail.TechPaintTechnologyDetailBuilder builder() {
      return new TechPaintTechnologyDetail.TechPaintTechnologyDetailBuilder();
   }

   public TechPaintTechnologyDetail() {
   }

   public TechPaintTechnologyDetail(
      final Long id,
      final Long paintTechnologyId,
      final Integer paintingTypeEnum,
      final Long paintConfigId,
      final String paintType,
      final String paintBrand,
      final String paintColor,
      final BigDecimal paintFilmThickness
   ) {
      this.id = id;
      this.paintTechnologyId = paintTechnologyId;
      this.paintingTypeEnum = paintingTypeEnum;
      this.paintConfigId = paintConfigId;
      this.paintType = paintType;
      this.paintBrand = paintBrand;
      this.paintColor = paintColor;
      this.paintFilmThickness = paintFilmThickness;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPaintTechnologyId() {
      return this.paintTechnologyId;
   }

   public Integer getPaintingTypeEnum() {
      return this.paintingTypeEnum;
   }

   public Long getPaintConfigId() {
      return this.paintConfigId;
   }

   public String getPaintType() {
      return this.paintType;
   }

   public String getPaintBrand() {
      return this.paintBrand;
   }

   public String getPaintColor() {
      return this.paintColor;
   }

   public BigDecimal getPaintFilmThickness() {
      return this.paintFilmThickness;
   }

   public TechPaintTechnologyDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechPaintTechnologyDetail setPaintTechnologyId(final Long paintTechnologyId) {
      this.paintTechnologyId = paintTechnologyId;
      return this;
   }

   public TechPaintTechnologyDetail setPaintingTypeEnum(final Integer paintingTypeEnum) {
      this.paintingTypeEnum = paintingTypeEnum;
      return this;
   }

   public TechPaintTechnologyDetail setPaintConfigId(final Long paintConfigId) {
      this.paintConfigId = paintConfigId;
      return this;
   }

   public TechPaintTechnologyDetail setPaintType(final String paintType) {
      this.paintType = paintType;
      return this;
   }

   public TechPaintTechnologyDetail setPaintBrand(final String paintBrand) {
      this.paintBrand = paintBrand;
      return this;
   }

   public TechPaintTechnologyDetail setPaintColor(final String paintColor) {
      this.paintColor = paintColor;
      return this;
   }

   public TechPaintTechnologyDetail setPaintFilmThickness(final BigDecimal paintFilmThickness) {
      this.paintFilmThickness = paintFilmThickness;
      return this;
   }

   @Override
   public String toString() {
      return "TechPaintTechnologyDetail(id="
         + this.getId()
         + ", paintTechnologyId="
         + this.getPaintTechnologyId()
         + ", paintingTypeEnum="
         + this.getPaintingTypeEnum()
         + ", paintConfigId="
         + this.getPaintConfigId()
         + ", paintType="
         + this.getPaintType()
         + ", paintBrand="
         + this.getPaintBrand()
         + ", paintColor="
         + this.getPaintColor()
         + ", paintFilmThickness="
         + this.getPaintFilmThickness()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechPaintTechnologyDetail)) {
         return false;
      }

      TechPaintTechnologyDetail other = (TechPaintTechnologyDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paintTechnologyId = this.getPaintTechnologyId();
         Object other$paintTechnologyId = other.getPaintTechnologyId();
         if (this$paintTechnologyId == null ? other$paintTechnologyId == null : this$paintTechnologyId.equals(other$paintTechnologyId)) {
            Object this$paintingTypeEnum = this.getPaintingTypeEnum();
            Object other$paintingTypeEnum = other.getPaintingTypeEnum();
            if (this$paintingTypeEnum == null ? other$paintingTypeEnum == null : this$paintingTypeEnum.equals(other$paintingTypeEnum)) {
               Object this$paintConfigId = this.getPaintConfigId();
               Object other$paintConfigId = other.getPaintConfigId();
               if (this$paintConfigId == null ? other$paintConfigId == null : this$paintConfigId.equals(other$paintConfigId)) {
                  Object this$paintType = this.getPaintType();
                  Object other$paintType = other.getPaintType();
                  if (this$paintType == null ? other$paintType == null : this$paintType.equals(other$paintType)) {
                     Object this$paintBrand = this.getPaintBrand();
                     Object other$paintBrand = other.getPaintBrand();
                     if (this$paintBrand == null ? other$paintBrand == null : this$paintBrand.equals(other$paintBrand)) {
                        Object this$paintColor = this.getPaintColor();
                        Object other$paintColor = other.getPaintColor();
                        if (this$paintColor == null ? other$paintColor == null : this$paintColor.equals(other$paintColor)) {
                           Object this$paintFilmThickness = this.getPaintFilmThickness();
                           Object other$paintFilmThickness = other.getPaintFilmThickness();
                           return this$paintFilmThickness == null ? other$paintFilmThickness == null : this$paintFilmThickness.equals(other$paintFilmThickness);
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
      return other instanceof TechPaintTechnologyDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paintTechnologyId = this.getPaintTechnologyId();
      result = result * 59 + ($paintTechnologyId == null ? 43 : $paintTechnologyId.hashCode());
      Object $paintingTypeEnum = this.getPaintingTypeEnum();
      result = result * 59 + ($paintingTypeEnum == null ? 43 : $paintingTypeEnum.hashCode());
      Object $paintConfigId = this.getPaintConfigId();
      result = result * 59 + ($paintConfigId == null ? 43 : $paintConfigId.hashCode());
      Object $paintType = this.getPaintType();
      result = result * 59 + ($paintType == null ? 43 : $paintType.hashCode());
      Object $paintBrand = this.getPaintBrand();
      result = result * 59 + ($paintBrand == null ? 43 : $paintBrand.hashCode());
      Object $paintColor = this.getPaintColor();
      result = result * 59 + ($paintColor == null ? 43 : $paintColor.hashCode());
      Object $paintFilmThickness = this.getPaintFilmThickness();
      return result * 59 + ($paintFilmThickness == null ? 43 : $paintFilmThickness.hashCode());
   }

   public static class TechPaintTechnologyDetailBuilder {
      private Long id;
      private Long paintTechnologyId;
      private Integer paintingTypeEnum;
      private Long paintConfigId;
      private String paintType;
      private String paintBrand;
      private String paintColor;
      private BigDecimal paintFilmThickness;

      TechPaintTechnologyDetailBuilder() {
      }

      public TechPaintTechnologyDetail.TechPaintTechnologyDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechPaintTechnologyDetail.TechPaintTechnologyDetailBuilder paintTechnologyId(final Long paintTechnologyId) {
         this.paintTechnologyId = paintTechnologyId;
         return this;
      }

      public TechPaintTechnologyDetail.TechPaintTechnologyDetailBuilder paintingTypeEnum(final Integer paintingTypeEnum) {
         this.paintingTypeEnum = paintingTypeEnum;
         return this;
      }

      public TechPaintTechnologyDetail.TechPaintTechnologyDetailBuilder paintConfigId(final Long paintConfigId) {
         this.paintConfigId = paintConfigId;
         return this;
      }

      public TechPaintTechnologyDetail.TechPaintTechnologyDetailBuilder paintType(final String paintType) {
         this.paintType = paintType;
         return this;
      }

      public TechPaintTechnologyDetail.TechPaintTechnologyDetailBuilder paintBrand(final String paintBrand) {
         this.paintBrand = paintBrand;
         return this;
      }

      public TechPaintTechnologyDetail.TechPaintTechnologyDetailBuilder paintColor(final String paintColor) {
         this.paintColor = paintColor;
         return this;
      }

      public TechPaintTechnologyDetail.TechPaintTechnologyDetailBuilder paintFilmThickness(final BigDecimal paintFilmThickness) {
         this.paintFilmThickness = paintFilmThickness;
         return this;
      }

      public TechPaintTechnologyDetail build() {
         return new TechPaintTechnologyDetail(
            this.id,
            this.paintTechnologyId,
            this.paintingTypeEnum,
            this.paintConfigId,
            this.paintType,
            this.paintBrand,
            this.paintColor,
            this.paintFilmThickness
         );
      }

      @Override
      public String toString() {
         return "TechPaintTechnologyDetail.TechPaintTechnologyDetailBuilder(id="
            + this.id
            + ", paintTechnologyId="
            + this.paintTechnologyId
            + ", paintingTypeEnum="
            + this.paintingTypeEnum
            + ", paintConfigId="
            + this.paintConfigId
            + ", paintType="
            + this.paintType
            + ", paintBrand="
            + this.paintBrand
            + ", paintColor="
            + this.paintColor
            + ", paintFilmThickness="
            + this.paintFilmThickness
            + ")";
      }
   }
}
