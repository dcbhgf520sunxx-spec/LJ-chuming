package com.hzchum.scim.contract.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("桁架楼承板 类")
public class TrussFloorPlateDTOParam {
   private String id;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "firstQuarter", notes = "上弦(mm)")
   private BigDecimal firstQuarter;
   @ApiModelProperty(name = "lastQuarter", notes = "下弦(mm)")
   private BigDecimal lastQuarter;
   @ApiModelProperty(name = "webMember", notes = "腹杆(mm)")
   private BigDecimal webMember;
   @ApiModelProperty(name = "vertical", notes = "竖向(mm)")
   private BigDecimal vertical;
   @ApiModelProperty(name = "level", notes = "水平(mm)")
   private BigDecimal level;
   @ApiModelProperty(name = "basementMembrane", notes = "底膜(mm)")
   private BigDecimal basementMembrane;
   @ApiModelProperty(name = "effectiveWidth", notes = "有效宽度(mm)")
   private BigDecimal effectiveWidth;
   @ApiModelProperty(name = "weightMeter", notes = "重量(kg)/m")
   private BigDecimal weightMeter;
   @ApiModelProperty(name = "quantity", notes = "数量(m)")
   private BigDecimal quantity;

   public String getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getFirstQuarter() {
      return this.firstQuarter;
   }

   public BigDecimal getLastQuarter() {
      return this.lastQuarter;
   }

   public BigDecimal getWebMember() {
      return this.webMember;
   }

   public BigDecimal getVertical() {
      return this.vertical;
   }

   public BigDecimal getLevel() {
      return this.level;
   }

   public BigDecimal getBasementMembrane() {
      return this.basementMembrane;
   }

   public BigDecimal getEffectiveWidth() {
      return this.effectiveWidth;
   }

   public BigDecimal getWeightMeter() {
      return this.weightMeter;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public void setId(final String id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setFirstQuarter(final BigDecimal firstQuarter) {
      this.firstQuarter = firstQuarter;
   }

   public void setLastQuarter(final BigDecimal lastQuarter) {
      this.lastQuarter = lastQuarter;
   }

   public void setWebMember(final BigDecimal webMember) {
      this.webMember = webMember;
   }

   public void setVertical(final BigDecimal vertical) {
      this.vertical = vertical;
   }

   public void setLevel(final BigDecimal level) {
      this.level = level;
   }

   public void setBasementMembrane(final BigDecimal basementMembrane) {
      this.basementMembrane = basementMembrane;
   }

   public void setEffectiveWidth(final BigDecimal effectiveWidth) {
      this.effectiveWidth = effectiveWidth;
   }

   public void setWeightMeter(final BigDecimal weightMeter) {
      this.weightMeter = weightMeter;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TrussFloorPlateDTOParam)) {
         return false;
      }

      TrussFloorPlateDTOParam other = (TrussFloorPlateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$firstQuarter = this.getFirstQuarter();
            Object other$firstQuarter = other.getFirstQuarter();
            if (this$firstQuarter == null ? other$firstQuarter == null : this$firstQuarter.equals(other$firstQuarter)) {
               Object this$lastQuarter = this.getLastQuarter();
               Object other$lastQuarter = other.getLastQuarter();
               if (this$lastQuarter == null ? other$lastQuarter == null : this$lastQuarter.equals(other$lastQuarter)) {
                  Object this$webMember = this.getWebMember();
                  Object other$webMember = other.getWebMember();
                  if (this$webMember == null ? other$webMember == null : this$webMember.equals(other$webMember)) {
                     Object this$vertical = this.getVertical();
                     Object other$vertical = other.getVertical();
                     if (this$vertical == null ? other$vertical == null : this$vertical.equals(other$vertical)) {
                        Object this$level = this.getLevel();
                        Object other$level = other.getLevel();
                        if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                           Object this$basementMembrane = this.getBasementMembrane();
                           Object other$basementMembrane = other.getBasementMembrane();
                           if (this$basementMembrane == null ? other$basementMembrane == null : this$basementMembrane.equals(other$basementMembrane)) {
                              Object this$effectiveWidth = this.getEffectiveWidth();
                              Object other$effectiveWidth = other.getEffectiveWidth();
                              if (this$effectiveWidth == null ? other$effectiveWidth == null : this$effectiveWidth.equals(other$effectiveWidth)) {
                                 Object this$weightMeter = this.getWeightMeter();
                                 Object other$weightMeter = other.getWeightMeter();
                                 if (this$weightMeter == null ? other$weightMeter == null : this$weightMeter.equals(other$weightMeter)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TrussFloorPlateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $firstQuarter = this.getFirstQuarter();
      result = result * 59 + ($firstQuarter == null ? 43 : $firstQuarter.hashCode());
      Object $lastQuarter = this.getLastQuarter();
      result = result * 59 + ($lastQuarter == null ? 43 : $lastQuarter.hashCode());
      Object $webMember = this.getWebMember();
      result = result * 59 + ($webMember == null ? 43 : $webMember.hashCode());
      Object $vertical = this.getVertical();
      result = result * 59 + ($vertical == null ? 43 : $vertical.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $basementMembrane = this.getBasementMembrane();
      result = result * 59 + ($basementMembrane == null ? 43 : $basementMembrane.hashCode());
      Object $effectiveWidth = this.getEffectiveWidth();
      result = result * 59 + ($effectiveWidth == null ? 43 : $effectiveWidth.hashCode());
      Object $weightMeter = this.getWeightMeter();
      result = result * 59 + ($weightMeter == null ? 43 : $weightMeter.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "TrussFloorPlateDTOParam(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", firstQuarter="
         + this.getFirstQuarter()
         + ", lastQuarter="
         + this.getLastQuarter()
         + ", webMember="
         + this.getWebMember()
         + ", vertical="
         + this.getVertical()
         + ", level="
         + this.getLevel()
         + ", basementMembrane="
         + this.getBasementMembrane()
         + ", effectiveWidth="
         + this.getEffectiveWidth()
         + ", weightMeter="
         + this.getWeightMeter()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }
}
