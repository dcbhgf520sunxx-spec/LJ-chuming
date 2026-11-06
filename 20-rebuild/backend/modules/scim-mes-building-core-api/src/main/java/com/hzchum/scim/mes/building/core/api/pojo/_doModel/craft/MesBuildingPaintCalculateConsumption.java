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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingPaintCalculateConsumption对象", description = "油漆计算用量表")
@Entity
@TableName("mes_building_paint_calculate_consumption")
@Table(
   name = "mes_building_paint_calculate_consumption",
   indexes = {
         @Index(name = "project_id", columnList = "project_id"),
         @Index(name = "paint_technology_id", columnList = "paint_technology_id"),
         @Index(name = "paint_calculate_record_id", columnList = " paint_calculate_record_id")
   }
)
@org.hibernate.annotations.Table(appliesTo = "mes_building_paint_calculate_consumption", comment = "油漆计算用量表")
public class MesBuildingPaintCalculateConsumption extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "paintTechnologyId", value = "喷漆工艺id", notes = "喷漆工艺id")
   @TableField("paint_technology_id")
   @Column(name = "paint_technology_id", columnDefinition = "bigint(20)  COMMENT '喷漆工艺id'", nullable = false)
   private Long paintTechnologyId;
   @ApiModelProperty(name = "paintCalculateRecordId", value = "油漆计算记录id", notes = "油漆计算记录id")
   @TableField("paint_calculate_record_id")
   @Column(name = "paint_calculate_record_id", columnDefinition = "bigint(20)  COMMENT '油漆计算记录id'", nullable = false)
   private Long paintCalculateRecordId;
   @ApiModelProperty(name = "paintingTypeEnum", value = "喷漆类型 1底漆 2中间漆 4面漆", notes = "喷漆类型 1底漆 2中间漆 4面漆")
   @TableField("painting_type_enum")
   @Column(name = "painting_type_enum", columnDefinition = "int(11)  COMMENT '喷漆类型 1底漆 2中间漆 4面漆'", nullable = false)
   private Integer paintingTypeEnum;
   @ApiModelProperty(name = "paintConfigId", value = "油漆配置id", notes = "油漆配置id")
   @TableField("paint_config_id")
   @Column(name = "paint_config_id", columnDefinition = "bigint(20)  COMMENT '油漆配置id'", nullable = false)
   private Long paintConfigId;
   @ApiModelProperty(name = "paintType", value = "油漆类型", notes = "油漆类型")
   @TableField("paint_type")
   @Column(name = "paint_type", columnDefinition = "varchar(255)  COMMENT '油漆类型'", nullable = false)
   private String paintType;
   @ApiModelProperty(name = "paintBrand", value = "油漆品牌", notes = "油漆品牌")
   @TableField("paint_brand")
   @Column(name = "paint_brand", columnDefinition = "varchar(255)  COMMENT '油漆品牌'", nullable = false)
   private String paintBrand;
   @ApiModelProperty(name = "paintColor", value = "油漆颜色", notes = "油漆颜色")
   @TableField("paint_color")
   @Column(name = "paint_color", columnDefinition = "varchar(255)  COMMENT '油漆颜色'", nullable = false)
   private String paintColor;
   @ApiModelProperty(name = "paintThickness", value = "漆膜厚度(μm)", notes = "漆膜厚度(μm)")
   @TableField("paint_thickness")
   @Column(name = "paint_thickness", columnDefinition = "decimal(32,4)  COMMENT '漆膜厚度(μm)'", nullable = false)
   private BigDecimal paintThickness;
   @ApiModelProperty(name = "lossCoefficient", value = "损耗系数", notes = "损耗系数")
   @TableField("loss_coefficient")
   @Column(name = "loss_coefficient", columnDefinition = "decimal(32,4) default '0.0000' COMMENT '损耗系数'", nullable = false)
   private BigDecimal lossCoefficient;
   @ApiModelProperty(name = "totalArea", value = "面积(m²)", notes = "面积(m²)")
   @TableField("total_area")
   @Column(name = "total_area", columnDefinition = "decimal(32,4)  COMMENT '面积(m²)'", nullable = false)
   private BigDecimal totalArea;
   @ApiModelProperty(name = "groupQuantity", value = "油漆组数", notes = "油漆组数")
   @TableField("group_quantity")
   @Column(name = "group_quantity", columnDefinition = "decimal(32,4)  COMMENT '油漆组数'", nullable = false)
   private BigDecimal groupQuantity;
   @ApiModelProperty(name = "paintWeight", value = "油漆重量(kg)", notes = "油漆重量(kg)")
   @TableField("paint_weight")
   @Column(name = "paint_weight", columnDefinition = "decimal(32,4)  COMMENT '油漆重量(kg)'", nullable = false)
   private BigDecimal paintWeight;

   public static MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder builder() {
      return new MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder();
   }

   public MesBuildingPaintCalculateConsumption() {
   }

   public MesBuildingPaintCalculateConsumption(
      final Long id,
      final Long projectId,
      final Long paintTechnologyId,
      final Long paintCalculateRecordId,
      final Integer paintingTypeEnum,
      final Long paintConfigId,
      final String paintType,
      final String paintBrand,
      final String paintColor,
      final BigDecimal paintThickness,
      final BigDecimal lossCoefficient,
      final BigDecimal totalArea,
      final BigDecimal groupQuantity,
      final BigDecimal paintWeight
   ) {
      this.id = id;
      this.projectId = projectId;
      this.paintTechnologyId = paintTechnologyId;
      this.paintCalculateRecordId = paintCalculateRecordId;
      this.paintingTypeEnum = paintingTypeEnum;
      this.paintConfigId = paintConfigId;
      this.paintType = paintType;
      this.paintBrand = paintBrand;
      this.paintColor = paintColor;
      this.paintThickness = paintThickness;
      this.lossCoefficient = lossCoefficient;
      this.totalArea = totalArea;
      this.groupQuantity = groupQuantity;
      this.paintWeight = paintWeight;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getPaintTechnologyId() {
      return this.paintTechnologyId;
   }

   public Long getPaintCalculateRecordId() {
      return this.paintCalculateRecordId;
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

   public BigDecimal getPaintThickness() {
      return this.paintThickness;
   }

   public BigDecimal getLossCoefficient() {
      return this.lossCoefficient;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getGroupQuantity() {
      return this.groupQuantity;
   }

   public BigDecimal getPaintWeight() {
      return this.paintWeight;
   }

   public MesBuildingPaintCalculateConsumption setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingPaintCalculateConsumption setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesBuildingPaintCalculateConsumption setPaintTechnologyId(final Long paintTechnologyId) {
      this.paintTechnologyId = paintTechnologyId;
      return this;
   }

   public MesBuildingPaintCalculateConsumption setPaintCalculateRecordId(final Long paintCalculateRecordId) {
      this.paintCalculateRecordId = paintCalculateRecordId;
      return this;
   }

   public MesBuildingPaintCalculateConsumption setPaintingTypeEnum(final Integer paintingTypeEnum) {
      this.paintingTypeEnum = paintingTypeEnum;
      return this;
   }

   public MesBuildingPaintCalculateConsumption setPaintConfigId(final Long paintConfigId) {
      this.paintConfigId = paintConfigId;
      return this;
   }

   public MesBuildingPaintCalculateConsumption setPaintType(final String paintType) {
      this.paintType = paintType;
      return this;
   }

   public MesBuildingPaintCalculateConsumption setPaintBrand(final String paintBrand) {
      this.paintBrand = paintBrand;
      return this;
   }

   public MesBuildingPaintCalculateConsumption setPaintColor(final String paintColor) {
      this.paintColor = paintColor;
      return this;
   }

   public MesBuildingPaintCalculateConsumption setPaintThickness(final BigDecimal paintThickness) {
      this.paintThickness = paintThickness;
      return this;
   }

   public MesBuildingPaintCalculateConsumption setLossCoefficient(final BigDecimal lossCoefficient) {
      this.lossCoefficient = lossCoefficient;
      return this;
   }

   public MesBuildingPaintCalculateConsumption setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   public MesBuildingPaintCalculateConsumption setGroupQuantity(final BigDecimal groupQuantity) {
      this.groupQuantity = groupQuantity;
      return this;
   }

   public MesBuildingPaintCalculateConsumption setPaintWeight(final BigDecimal paintWeight) {
      this.paintWeight = paintWeight;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPaintCalculateConsumption(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", paintTechnologyId="
         + this.getPaintTechnologyId()
         + ", paintCalculateRecordId="
         + this.getPaintCalculateRecordId()
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
         + ", paintThickness="
         + this.getPaintThickness()
         + ", lossCoefficient="
         + this.getLossCoefficient()
         + ", totalArea="
         + this.getTotalArea()
         + ", groupQuantity="
         + this.getGroupQuantity()
         + ", paintWeight="
         + this.getPaintWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPaintCalculateConsumption)) {
         return false;
      }

      MesBuildingPaintCalculateConsumption other = (MesBuildingPaintCalculateConsumption)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$paintTechnologyId = this.getPaintTechnologyId();
            Object other$paintTechnologyId = other.getPaintTechnologyId();
            if (this$paintTechnologyId == null ? other$paintTechnologyId == null : this$paintTechnologyId.equals(other$paintTechnologyId)) {
               Object this$paintCalculateRecordId = this.getPaintCalculateRecordId();
               Object other$paintCalculateRecordId = other.getPaintCalculateRecordId();
               if (this$paintCalculateRecordId == null
                  ? other$paintCalculateRecordId == null
                  : this$paintCalculateRecordId.equals(other$paintCalculateRecordId)) {
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
                                 Object this$paintThickness = this.getPaintThickness();
                                 Object other$paintThickness = other.getPaintThickness();
                                 if (this$paintThickness == null ? other$paintThickness == null : this$paintThickness.equals(other$paintThickness)) {
                                    Object this$lossCoefficient = this.getLossCoefficient();
                                    Object other$lossCoefficient = other.getLossCoefficient();
                                    if (this$lossCoefficient == null ? other$lossCoefficient == null : this$lossCoefficient.equals(other$lossCoefficient)) {
                                       Object this$totalArea = this.getTotalArea();
                                       Object other$totalArea = other.getTotalArea();
                                       if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                          Object this$groupQuantity = this.getGroupQuantity();
                                          Object other$groupQuantity = other.getGroupQuantity();
                                          if (this$groupQuantity == null ? other$groupQuantity == null : this$groupQuantity.equals(other$groupQuantity)) {
                                             Object this$paintWeight = this.getPaintWeight();
                                             Object other$paintWeight = other.getPaintWeight();
                                             return this$paintWeight == null ? other$paintWeight == null : this$paintWeight.equals(other$paintWeight);
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
      return other instanceof MesBuildingPaintCalculateConsumption;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $paintTechnologyId = this.getPaintTechnologyId();
      result = result * 59 + ($paintTechnologyId == null ? 43 : $paintTechnologyId.hashCode());
      Object $paintCalculateRecordId = this.getPaintCalculateRecordId();
      result = result * 59 + ($paintCalculateRecordId == null ? 43 : $paintCalculateRecordId.hashCode());
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
      Object $paintThickness = this.getPaintThickness();
      result = result * 59 + ($paintThickness == null ? 43 : $paintThickness.hashCode());
      Object $lossCoefficient = this.getLossCoefficient();
      result = result * 59 + ($lossCoefficient == null ? 43 : $lossCoefficient.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $groupQuantity = this.getGroupQuantity();
      result = result * 59 + ($groupQuantity == null ? 43 : $groupQuantity.hashCode());
      Object $paintWeight = this.getPaintWeight();
      return result * 59 + ($paintWeight == null ? 43 : $paintWeight.hashCode());
   }

   public static class MesBuildingPaintCalculateConsumptionBuilder {
      private Long id;
      private Long projectId;
      private Long paintTechnologyId;
      private Long paintCalculateRecordId;
      private Integer paintingTypeEnum;
      private Long paintConfigId;
      private String paintType;
      private String paintBrand;
      private String paintColor;
      private BigDecimal paintThickness;
      private BigDecimal lossCoefficient;
      private BigDecimal totalArea;
      private BigDecimal groupQuantity;
      private BigDecimal paintWeight;

      MesBuildingPaintCalculateConsumptionBuilder() {
      }

      public MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder paintTechnologyId(final Long paintTechnologyId) {
         this.paintTechnologyId = paintTechnologyId;
         return this;
      }

      public MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder paintCalculateRecordId(final Long paintCalculateRecordId) {
         this.paintCalculateRecordId = paintCalculateRecordId;
         return this;
      }

      public MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder paintingTypeEnum(final Integer paintingTypeEnum) {
         this.paintingTypeEnum = paintingTypeEnum;
         return this;
      }

      public MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder paintConfigId(final Long paintConfigId) {
         this.paintConfigId = paintConfigId;
         return this;
      }

      public MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder paintType(final String paintType) {
         this.paintType = paintType;
         return this;
      }

      public MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder paintBrand(final String paintBrand) {
         this.paintBrand = paintBrand;
         return this;
      }

      public MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder paintColor(final String paintColor) {
         this.paintColor = paintColor;
         return this;
      }

      public MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder paintThickness(final BigDecimal paintThickness) {
         this.paintThickness = paintThickness;
         return this;
      }

      public MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder lossCoefficient(final BigDecimal lossCoefficient) {
         this.lossCoefficient = lossCoefficient;
         return this;
      }

      public MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder groupQuantity(final BigDecimal groupQuantity) {
         this.groupQuantity = groupQuantity;
         return this;
      }

      public MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder paintWeight(final BigDecimal paintWeight) {
         this.paintWeight = paintWeight;
         return this;
      }

      public MesBuildingPaintCalculateConsumption build() {
         return new MesBuildingPaintCalculateConsumption(
            this.id,
            this.projectId,
            this.paintTechnologyId,
            this.paintCalculateRecordId,
            this.paintingTypeEnum,
            this.paintConfigId,
            this.paintType,
            this.paintBrand,
            this.paintColor,
            this.paintThickness,
            this.lossCoefficient,
            this.totalArea,
            this.groupQuantity,
            this.paintWeight
         );
      }

      @Override
      public String toString() {
         return "MesBuildingPaintCalculateConsumption.MesBuildingPaintCalculateConsumptionBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", paintTechnologyId="
            + this.paintTechnologyId
            + ", paintCalculateRecordId="
            + this.paintCalculateRecordId
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
            + ", paintThickness="
            + this.paintThickness
            + ", lossCoefficient="
            + this.lossCoefficient
            + ", totalArea="
            + this.totalArea
            + ", groupQuantity="
            + this.groupQuantity
            + ", paintWeight="
            + this.paintWeight
            + ")";
      }
   }
}
