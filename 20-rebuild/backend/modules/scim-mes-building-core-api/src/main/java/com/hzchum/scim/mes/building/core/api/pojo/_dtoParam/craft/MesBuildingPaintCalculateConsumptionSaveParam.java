package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.building.core.api.enums.PaintingTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class MesBuildingPaintCalculateConsumptionSaveParam {
   @NotNull(message = "喷漆类型不能为空!")
   @EnumValidator(value = PaintingTypeEnum.class, message = "喷漆类型有误!")
   @ApiModelProperty(name = "paintingTypeEnum", value = "喷漆类型 1底漆 2中间漆 4面漆", notes = "喷漆类型 1底漆 2中间漆 4面漆")
   private Integer paintingTypeEnum;
   @NotNull(message = "油漆配置id不能为空!")
   @ApiModelProperty(name = "paintConfigId", value = "油漆配置id", notes = "油漆配置id")
   private Long paintConfigId;
   @NotNull(message = "漆膜厚度(μm)不能为空!")
   @ApiModelProperty(name = "paintThickness", value = "漆膜厚度(μm)", notes = "漆膜厚度(μm)")
   private BigDecimal paintThickness;
   @NotNull(message = "损耗系数不能为空!")
   @ApiModelProperty(name = "lossCoefficient", value = "损耗系数", notes = "损耗系数")
   private BigDecimal lossCoefficient;
   @NotNull(message = "涂装面积(m²)不能为空!")
   @ApiModelProperty(name = "totalArea", value = "涂装面积(m²)", notes = "涂装面积(m²)")
   private BigDecimal totalArea;
   @NotNull(message = "油漆组数不能为空!")
   @ApiModelProperty(name = "groupQuantity", value = "油漆组数", notes = "油漆组数")
   private BigDecimal groupQuantity;
   @NotNull(message = "油漆重量不能为空!")
   @ApiModelProperty(name = "paintWeight", value = "油漆重量(kg)", notes = "油漆重量(kg)")
   private BigDecimal paintWeight;

   public Integer getPaintingTypeEnum() {
      return this.paintingTypeEnum;
   }

   public Long getPaintConfigId() {
      return this.paintConfigId;
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

   public void setPaintingTypeEnum(final Integer paintingTypeEnum) {
      this.paintingTypeEnum = paintingTypeEnum;
   }

   public void setPaintConfigId(final Long paintConfigId) {
      this.paintConfigId = paintConfigId;
   }

   public void setPaintThickness(final BigDecimal paintThickness) {
      this.paintThickness = paintThickness;
   }

   public void setLossCoefficient(final BigDecimal lossCoefficient) {
      this.lossCoefficient = lossCoefficient;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setGroupQuantity(final BigDecimal groupQuantity) {
      this.groupQuantity = groupQuantity;
   }

   public void setPaintWeight(final BigDecimal paintWeight) {
      this.paintWeight = paintWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPaintCalculateConsumptionSaveParam)) {
         return false;
      }

      MesBuildingPaintCalculateConsumptionSaveParam other = (MesBuildingPaintCalculateConsumptionSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$paintingTypeEnum = this.getPaintingTypeEnum();
      Object other$paintingTypeEnum = other.getPaintingTypeEnum();
      if (this$paintingTypeEnum == null ? other$paintingTypeEnum == null : this$paintingTypeEnum.equals(other$paintingTypeEnum)) {
         Object this$paintConfigId = this.getPaintConfigId();
         Object other$paintConfigId = other.getPaintConfigId();
         if (this$paintConfigId == null ? other$paintConfigId == null : this$paintConfigId.equals(other$paintConfigId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPaintCalculateConsumptionSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $paintingTypeEnum = this.getPaintingTypeEnum();
      result = result * 59 + ($paintingTypeEnum == null ? 43 : $paintingTypeEnum.hashCode());
      Object $paintConfigId = this.getPaintConfigId();
      result = result * 59 + ($paintConfigId == null ? 43 : $paintConfigId.hashCode());
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

   @Override
   public String toString() {
      return "MesBuildingPaintCalculateConsumptionSaveParam(paintingTypeEnum="
         + this.getPaintingTypeEnum()
         + ", paintConfigId="
         + this.getPaintConfigId()
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
}
