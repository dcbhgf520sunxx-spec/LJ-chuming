package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

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

@ApiModel(value = "WmsPickingDetail对象", description = "")
@Entity
@TableName("wms_picking_detail")
@Table(name = "wms_picking_detail")
@org.hibernate.annotations.Table(appliesTo = "wms_picking_detail")
public class WmsPickingDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "pickingId", value = "领料单ID", notes = "领料单ID")
   @TableField("picking_id")
   @Column(name = "picking_id", columnDefinition = "bigint(20)  COMMENT '领料单ID'", nullable = true)
   private Long pickingId;
   @ApiModelProperty(name = "pickingType", value = "领料类型", notes = "领料类型")
   @TableField("picking_type")
   @Column(name = "picking_type", columnDefinition = "varchar(255)  COMMENT '领料类型'", nullable = true)
   private String pickingType;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT '材质'", nullable = true)
   private String material;
   @ApiModelProperty(name = "thick", value = "厚度", notes = "厚度")
   @TableField("thick")
   @Column(name = "thick", columnDefinition = "decimal(32,8) COMMENT '厚度'", nullable = true)
   private BigDecimal thick;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "unit", value = "单位", notes = "单位")
   @TableField("unit")
   @Column(name = "unit", columnDefinition = "varchar(255)  COMMENT '单位'", nullable = true)
   private String unit;
   @ApiModelProperty(name = "pickingAmount", value = "领料量（kg）", notes = "领料量（kg）")
   @TableField("picking_amount")
   @Column(name = "picking_amount", columnDefinition = "decimal(32,8) default '0'  COMMENT '领料量'", nullable = true)
   private BigDecimal pickingAmount;
   @ApiModelProperty(name = "volume", value = "办理量（g）", notes = "办理量（g）")
   @TableField("volume")
   @Column(name = "volume", columnDefinition = "decimal(32,8) default '0' COMMENT '办理量（g）'", nullable = true)
   private BigDecimal volume;
   @ApiModelProperty(name = "reviewPickingAmount", value = "审核中领料量（g）", notes = "审核中领料量（g）")
   @TableField("review_picking_amount")
   @Column(name = "review_picking_amount", columnDefinition = "decimal(32,8) default '0' COMMENT '审核中领料量（g）'", nullable = true)
   private BigDecimal reviewPickingAmount;
   @ApiModelProperty(name = "pickingArea", value = "领料面积(钢板适用)(mm²)", notes = "领料面积(钢板适用)(mm²)")
   @TableField("picking_area")
   @Column(name = "picking_area", columnDefinition = "decimal(32,8) default '0'  COMMENT '领料面积(钢板适用)(mm²)'", nullable = true)
   private BigDecimal pickingArea;
   @ApiModelProperty(name = "handlingArea", value = "办理面积(钢板适用)(mm²)", notes = "办理面积(钢板适用)(mm²)")
   @TableField("handling_area")
   @Column(name = "handling_area", columnDefinition = "decimal(32,8) default '0'  COMMENT '办理面积(钢板适用)(mm²)'", nullable = true)
   private BigDecimal handlingArea;
   @ApiModelProperty(name = "reviewPickingArea", value = "审核中领料面积(钢板适用)(mm²)", notes = "审核中领料面积(钢板适用)(mm²)")
   @TableField("review_picking_area")
   @Column(name = "review_picking_area", columnDefinition = "decimal(32,8) default '0' COMMENT '审核中领料面积(钢板适用)(mm²)'", nullable = true)
   private BigDecimal reviewPickingArea;
   @ApiModelProperty(name = "pickingLength", value = "领料长度(型材适用)(mm)", notes = "领料长度(型材适用)(mm)")
   @TableField("picking_length")
   @Column(name = "picking_length", columnDefinition = "decimal(32,8) default '0'  COMMENT '领料长度(型材适用)(mm)'", nullable = true)
   private BigDecimal pickingLength;
   @ApiModelProperty(name = "handlingLength", value = "办理长度(型材适用)(mm)", notes = "办理长度(型材适用)(mm)")
   @TableField("handling_length")
   @Column(name = "handling_length", columnDefinition = "decimal(32,8) default '0' COMMENT '办理长度(型材适用)(mm)'", nullable = true)
   private BigDecimal handlingLength;
   @ApiModelProperty(name = "reviewPickingLength", value = "审核中领料长度(型材适用)(mm)", notes = "审核中领料长度(型材适用)(mm)")
   @TableField("review_picking_length")
   @Column(name = "review_picking_length", columnDefinition = "decimal(32,8) default '0' COMMENT '审核中领料长度(型材适用)(mm)'", nullable = true)
   private BigDecimal reviewPickingLength;
   @ApiModelProperty(name = "taskOrderId", value = "工单ID", notes = "工单ID")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20)  COMMENT '工单ID'", nullable = true)
   private Long taskOrderId;
   @ApiModelProperty(name = "boolComplete", value = "是否齐套 默认未齐套", notes = "是否齐套 默认未齐套")
   @TableField("bool_complete")
   @Column(name = "bool_complete", columnDefinition = "tinyint(1)  default '0'  COMMENT '是否齐套 默认未齐套'", nullable = true)
   private Boolean boolComplete;

   public static WmsPickingDetail.WmsPickingDetailBuilder builder() {
      return new WmsPickingDetail.WmsPickingDetailBuilder();
   }

   public WmsPickingDetail() {
   }

   public WmsPickingDetail(
      final Long id,
      final Long pickingId,
      final String pickingType,
      final String specification,
      final String material,
      final BigDecimal thick,
      final BigDecimal quantity,
      final String unit,
      final BigDecimal pickingAmount,
      final BigDecimal volume,
      final BigDecimal reviewPickingAmount,
      final BigDecimal pickingArea,
      final BigDecimal handlingArea,
      final BigDecimal reviewPickingArea,
      final BigDecimal pickingLength,
      final BigDecimal handlingLength,
      final BigDecimal reviewPickingLength,
      final Long taskOrderId,
      final Boolean boolComplete
   ) {
      this.id = id;
      this.pickingId = pickingId;
      this.pickingType = pickingType;
      this.specification = specification;
      this.material = material;
      this.thick = thick;
      this.quantity = quantity;
      this.unit = unit;
      this.pickingAmount = pickingAmount;
      this.volume = volume;
      this.reviewPickingAmount = reviewPickingAmount;
      this.pickingArea = pickingArea;
      this.handlingArea = handlingArea;
      this.reviewPickingArea = reviewPickingArea;
      this.pickingLength = pickingLength;
      this.handlingLength = handlingLength;
      this.reviewPickingLength = reviewPickingLength;
      this.taskOrderId = taskOrderId;
      this.boolComplete = boolComplete;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPickingId() {
      return this.pickingId;
   }

   public String getPickingType() {
      return this.pickingType;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getThick() {
      return this.thick;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPickingAmount() {
      return this.pickingAmount;
   }

   public BigDecimal getVolume() {
      return this.volume;
   }

   public BigDecimal getReviewPickingAmount() {
      return this.reviewPickingAmount;
   }

   public BigDecimal getPickingArea() {
      return this.pickingArea;
   }

   public BigDecimal getHandlingArea() {
      return this.handlingArea;
   }

   public BigDecimal getReviewPickingArea() {
      return this.reviewPickingArea;
   }

   public BigDecimal getPickingLength() {
      return this.pickingLength;
   }

   public BigDecimal getHandlingLength() {
      return this.handlingLength;
   }

   public BigDecimal getReviewPickingLength() {
      return this.reviewPickingLength;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Boolean getBoolComplete() {
      return this.boolComplete;
   }

   public WmsPickingDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsPickingDetail setPickingId(final Long pickingId) {
      this.pickingId = pickingId;
      return this;
   }

   public WmsPickingDetail setPickingType(final String pickingType) {
      this.pickingType = pickingType;
      return this;
   }

   public WmsPickingDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public WmsPickingDetail setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public WmsPickingDetail setThick(final BigDecimal thick) {
      this.thick = thick;
      return this;
   }

   public WmsPickingDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public WmsPickingDetail setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public WmsPickingDetail setPickingAmount(final BigDecimal pickingAmount) {
      this.pickingAmount = pickingAmount;
      return this;
   }

   public WmsPickingDetail setVolume(final BigDecimal volume) {
      this.volume = volume;
      return this;
   }

   public WmsPickingDetail setReviewPickingAmount(final BigDecimal reviewPickingAmount) {
      this.reviewPickingAmount = reviewPickingAmount;
      return this;
   }

   public WmsPickingDetail setPickingArea(final BigDecimal pickingArea) {
      this.pickingArea = pickingArea;
      return this;
   }

   public WmsPickingDetail setHandlingArea(final BigDecimal handlingArea) {
      this.handlingArea = handlingArea;
      return this;
   }

   public WmsPickingDetail setReviewPickingArea(final BigDecimal reviewPickingArea) {
      this.reviewPickingArea = reviewPickingArea;
      return this;
   }

   public WmsPickingDetail setPickingLength(final BigDecimal pickingLength) {
      this.pickingLength = pickingLength;
      return this;
   }

   public WmsPickingDetail setHandlingLength(final BigDecimal handlingLength) {
      this.handlingLength = handlingLength;
      return this;
   }

   public WmsPickingDetail setReviewPickingLength(final BigDecimal reviewPickingLength) {
      this.reviewPickingLength = reviewPickingLength;
      return this;
   }

   public WmsPickingDetail setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   public WmsPickingDetail setBoolComplete(final Boolean boolComplete) {
      this.boolComplete = boolComplete;
      return this;
   }

   @Override
   public String toString() {
      return "WmsPickingDetail(id="
         + this.getId()
         + ", pickingId="
         + this.getPickingId()
         + ", pickingType="
         + this.getPickingType()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", thick="
         + this.getThick()
         + ", quantity="
         + this.getQuantity()
         + ", unit="
         + this.getUnit()
         + ", pickingAmount="
         + this.getPickingAmount()
         + ", volume="
         + this.getVolume()
         + ", reviewPickingAmount="
         + this.getReviewPickingAmount()
         + ", pickingArea="
         + this.getPickingArea()
         + ", handlingArea="
         + this.getHandlingArea()
         + ", reviewPickingArea="
         + this.getReviewPickingArea()
         + ", pickingLength="
         + this.getPickingLength()
         + ", handlingLength="
         + this.getHandlingLength()
         + ", reviewPickingLength="
         + this.getReviewPickingLength()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", boolComplete="
         + this.getBoolComplete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsPickingDetail)) {
         return false;
      }

      WmsPickingDetail other = (WmsPickingDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pickingId = this.getPickingId();
         Object other$pickingId = other.getPickingId();
         if (this$pickingId == null ? other$pickingId == null : this$pickingId.equals(other$pickingId)) {
            Object this$taskOrderId = this.getTaskOrderId();
            Object other$taskOrderId = other.getTaskOrderId();
            if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
               Object this$boolComplete = this.getBoolComplete();
               Object other$boolComplete = other.getBoolComplete();
               if (this$boolComplete == null ? other$boolComplete == null : this$boolComplete.equals(other$boolComplete)) {
                  Object this$pickingType = this.getPickingType();
                  Object other$pickingType = other.getPickingType();
                  if (this$pickingType == null ? other$pickingType == null : this$pickingType.equals(other$pickingType)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$material = this.getMaterial();
                        Object other$material = other.getMaterial();
                        if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                           Object this$thick = this.getThick();
                           Object other$thick = other.getThick();
                           if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                 Object this$unit = this.getUnit();
                                 Object other$unit = other.getUnit();
                                 if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                    Object this$pickingAmount = this.getPickingAmount();
                                    Object other$pickingAmount = other.getPickingAmount();
                                    if (this$pickingAmount == null ? other$pickingAmount == null : this$pickingAmount.equals(other$pickingAmount)) {
                                       Object this$volume = this.getVolume();
                                       Object other$volume = other.getVolume();
                                       if (this$volume == null ? other$volume == null : this$volume.equals(other$volume)) {
                                          Object this$reviewPickingAmount = this.getReviewPickingAmount();
                                          Object other$reviewPickingAmount = other.getReviewPickingAmount();
                                          if (this$reviewPickingAmount == null
                                             ? other$reviewPickingAmount == null
                                             : this$reviewPickingAmount.equals(other$reviewPickingAmount)) {
                                             Object this$pickingArea = this.getPickingArea();
                                             Object other$pickingArea = other.getPickingArea();
                                             if (this$pickingArea == null ? other$pickingArea == null : this$pickingArea.equals(other$pickingArea)) {
                                                Object this$handlingArea = this.getHandlingArea();
                                                Object other$handlingArea = other.getHandlingArea();
                                                if (this$handlingArea == null ? other$handlingArea == null : this$handlingArea.equals(other$handlingArea)) {
                                                   Object this$reviewPickingArea = this.getReviewPickingArea();
                                                   Object other$reviewPickingArea = other.getReviewPickingArea();
                                                   if (this$reviewPickingArea == null
                                                      ? other$reviewPickingArea == null
                                                      : this$reviewPickingArea.equals(other$reviewPickingArea)) {
                                                      Object this$pickingLength = this.getPickingLength();
                                                      Object other$pickingLength = other.getPickingLength();
                                                      if (this$pickingLength == null
                                                         ? other$pickingLength == null
                                                         : this$pickingLength.equals(other$pickingLength)) {
                                                         Object this$handlingLength = this.getHandlingLength();
                                                         Object other$handlingLength = other.getHandlingLength();
                                                         if (this$handlingLength == null
                                                            ? other$handlingLength == null
                                                            : this$handlingLength.equals(other$handlingLength)) {
                                                            Object this$reviewPickingLength = this.getReviewPickingLength();
                                                            Object other$reviewPickingLength = other.getReviewPickingLength();
                                                            return this$reviewPickingLength == null
                                                               ? other$reviewPickingLength == null
                                                               : this$reviewPickingLength.equals(other$reviewPickingLength);
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
      return other instanceof WmsPickingDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pickingId = this.getPickingId();
      result = result * 59 + ($pickingId == null ? 43 : $pickingId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $boolComplete = this.getBoolComplete();
      result = result * 59 + ($boolComplete == null ? 43 : $boolComplete.hashCode());
      Object $pickingType = this.getPickingType();
      result = result * 59 + ($pickingType == null ? 43 : $pickingType.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $pickingAmount = this.getPickingAmount();
      result = result * 59 + ($pickingAmount == null ? 43 : $pickingAmount.hashCode());
      Object $volume = this.getVolume();
      result = result * 59 + ($volume == null ? 43 : $volume.hashCode());
      Object $reviewPickingAmount = this.getReviewPickingAmount();
      result = result * 59 + ($reviewPickingAmount == null ? 43 : $reviewPickingAmount.hashCode());
      Object $pickingArea = this.getPickingArea();
      result = result * 59 + ($pickingArea == null ? 43 : $pickingArea.hashCode());
      Object $handlingArea = this.getHandlingArea();
      result = result * 59 + ($handlingArea == null ? 43 : $handlingArea.hashCode());
      Object $reviewPickingArea = this.getReviewPickingArea();
      result = result * 59 + ($reviewPickingArea == null ? 43 : $reviewPickingArea.hashCode());
      Object $pickingLength = this.getPickingLength();
      result = result * 59 + ($pickingLength == null ? 43 : $pickingLength.hashCode());
      Object $handlingLength = this.getHandlingLength();
      result = result * 59 + ($handlingLength == null ? 43 : $handlingLength.hashCode());
      Object $reviewPickingLength = this.getReviewPickingLength();
      return result * 59 + ($reviewPickingLength == null ? 43 : $reviewPickingLength.hashCode());
   }

   public static class WmsPickingDetailBuilder {
      private Long id;
      private Long pickingId;
      private String pickingType;
      private String specification;
      private String material;
      private BigDecimal thick;
      private BigDecimal quantity;
      private String unit;
      private BigDecimal pickingAmount;
      private BigDecimal volume;
      private BigDecimal reviewPickingAmount;
      private BigDecimal pickingArea;
      private BigDecimal handlingArea;
      private BigDecimal reviewPickingArea;
      private BigDecimal pickingLength;
      private BigDecimal handlingLength;
      private BigDecimal reviewPickingLength;
      private Long taskOrderId;
      private Boolean boolComplete;

      WmsPickingDetailBuilder() {
      }

      public WmsPickingDetail.WmsPickingDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder pickingId(final Long pickingId) {
         this.pickingId = pickingId;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder pickingType(final String pickingType) {
         this.pickingType = pickingType;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder thick(final BigDecimal thick) {
         this.thick = thick;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder pickingAmount(final BigDecimal pickingAmount) {
         this.pickingAmount = pickingAmount;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder volume(final BigDecimal volume) {
         this.volume = volume;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder reviewPickingAmount(final BigDecimal reviewPickingAmount) {
         this.reviewPickingAmount = reviewPickingAmount;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder pickingArea(final BigDecimal pickingArea) {
         this.pickingArea = pickingArea;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder handlingArea(final BigDecimal handlingArea) {
         this.handlingArea = handlingArea;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder reviewPickingArea(final BigDecimal reviewPickingArea) {
         this.reviewPickingArea = reviewPickingArea;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder pickingLength(final BigDecimal pickingLength) {
         this.pickingLength = pickingLength;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder handlingLength(final BigDecimal handlingLength) {
         this.handlingLength = handlingLength;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder reviewPickingLength(final BigDecimal reviewPickingLength) {
         this.reviewPickingLength = reviewPickingLength;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public WmsPickingDetail.WmsPickingDetailBuilder boolComplete(final Boolean boolComplete) {
         this.boolComplete = boolComplete;
         return this;
      }

      public WmsPickingDetail build() {
         return new WmsPickingDetail(
            this.id,
            this.pickingId,
            this.pickingType,
            this.specification,
            this.material,
            this.thick,
            this.quantity,
            this.unit,
            this.pickingAmount,
            this.volume,
            this.reviewPickingAmount,
            this.pickingArea,
            this.handlingArea,
            this.reviewPickingArea,
            this.pickingLength,
            this.handlingLength,
            this.reviewPickingLength,
            this.taskOrderId,
            this.boolComplete
         );
      }

      @Override
      public String toString() {
         return "WmsPickingDetail.WmsPickingDetailBuilder(id="
            + this.id
            + ", pickingId="
            + this.pickingId
            + ", pickingType="
            + this.pickingType
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", thick="
            + this.thick
            + ", quantity="
            + this.quantity
            + ", unit="
            + this.unit
            + ", pickingAmount="
            + this.pickingAmount
            + ", volume="
            + this.volume
            + ", reviewPickingAmount="
            + this.reviewPickingAmount
            + ", pickingArea="
            + this.pickingArea
            + ", handlingArea="
            + this.handlingArea
            + ", reviewPickingArea="
            + this.reviewPickingArea
            + ", pickingLength="
            + this.pickingLength
            + ", handlingLength="
            + this.handlingLength
            + ", reviewPickingLength="
            + this.reviewPickingLength
            + ", taskOrderId="
            + this.taskOrderId
            + ", boolComplete="
            + this.boolComplete
            + ")";
      }
   }
}
