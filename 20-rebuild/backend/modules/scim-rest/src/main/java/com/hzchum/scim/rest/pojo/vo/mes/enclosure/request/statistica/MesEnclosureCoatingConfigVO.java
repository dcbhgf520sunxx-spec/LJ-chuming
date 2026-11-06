package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.statistica;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.enclosure.core.api.enums.PaintingTypeEnum;
import com.hzchum.scim.mes.enclosure.core.api.enums.WageQuotaTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureCoatingConfigVO", description = "涂装配置VO ")
public class MesEnclosureCoatingConfigVO {
   @ApiModelProperty(name = "id", value = "主键id")
   private Long id;
   @ApiModelProperty(name = "name", value = "油漆类别")
   @NotNull(message = "油漆类别不能为空")
   @EnumValidator(value = PaintingTypeEnum.class, message = "油漆类别错误")
   private Integer type;
   @ApiModelProperty(name = "name", value = "油漆名称")
   @NotNull(message = "油漆名称不能为空")
   private String name;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   @NotNull(message = "计量单位不能为空")
   @EnumValidator(value = WageQuotaTypeEnum.class, message = "计量单位类别错误")
   private Integer measureUnit;
   @ApiModelProperty(name = "thickness", value = "标准厚度(微米)")
   @Min(0L)
   private Integer thickness;
   @ApiModelProperty(name = "outThickness", value = "超标厚度(微米)")
   private Integer outThickness;
   @ApiModelProperty(name = "unitPrice", value = "标准单价")
   @NotNull(message = "标准单价不能为空")
   @Min(0L)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "outUnitPrice", value = "超标单价(元)")
   @Min(0L)
   private BigDecimal outUnitPrice;

   public static MesEnclosureCoatingConfigVO.MesEnclosureCoatingConfigVOBuilder builder() {
      return new MesEnclosureCoatingConfigVO.MesEnclosureCoatingConfigVOBuilder();
   }

   public MesEnclosureCoatingConfigVO() {
   }

   public MesEnclosureCoatingConfigVO(
      final Long id,
      final Integer type,
      final String name,
      final Integer measureUnit,
      final Integer thickness,
      final Integer outThickness,
      final BigDecimal unitPrice,
      final BigDecimal outUnitPrice
   ) {
      this.id = id;
      this.type = type;
      this.name = name;
      this.measureUnit = measureUnit;
      this.thickness = thickness;
      this.outThickness = outThickness;
      this.unitPrice = unitPrice;
      this.outUnitPrice = outUnitPrice;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public Integer getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getThickness() {
      return this.thickness;
   }

   public Integer getOutThickness() {
      return this.outThickness;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getOutUnitPrice() {
      return this.outUnitPrice;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMeasureUnit(final Integer measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setThickness(final Integer thickness) {
      this.thickness = thickness;
   }

   public void setOutThickness(final Integer outThickness) {
      this.outThickness = outThickness;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setOutUnitPrice(final BigDecimal outUnitPrice) {
      this.outUnitPrice = outUnitPrice;
   }

   @Override
   public String toString() {
      return "MesEnclosureCoatingConfigVO(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", name="
         + this.getName()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", thickness="
         + this.getThickness()
         + ", outThickness="
         + this.getOutThickness()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", outUnitPrice="
         + this.getOutUnitPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureCoatingConfigVO)) {
         return false;
      }

      MesEnclosureCoatingConfigVO other = (MesEnclosureCoatingConfigVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$measureUnit = this.getMeasureUnit();
            Object other$measureUnit = other.getMeasureUnit();
            if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
               Object this$thickness = this.getThickness();
               Object other$thickness = other.getThickness();
               if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                  Object this$outThickness = this.getOutThickness();
                  Object other$outThickness = other.getOutThickness();
                  if (this$outThickness == null ? other$outThickness == null : this$outThickness.equals(other$outThickness)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$unitPrice = this.getUnitPrice();
                        Object other$unitPrice = other.getUnitPrice();
                        if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                           Object this$outUnitPrice = this.getOutUnitPrice();
                           Object other$outUnitPrice = other.getOutUnitPrice();
                           return this$outUnitPrice == null ? other$outUnitPrice == null : this$outUnitPrice.equals(other$outUnitPrice);
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
      return other instanceof MesEnclosureCoatingConfigVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $outThickness = this.getOutThickness();
      result = result * 59 + ($outThickness == null ? 43 : $outThickness.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $outUnitPrice = this.getOutUnitPrice();
      return result * 59 + ($outUnitPrice == null ? 43 : $outUnitPrice.hashCode());
   }

   public static class MesEnclosureCoatingConfigVOBuilder {
      private Long id;
      private Integer type;
      private String name;
      private Integer measureUnit;
      private Integer thickness;
      private Integer outThickness;
      private BigDecimal unitPrice;
      private BigDecimal outUnitPrice;

      MesEnclosureCoatingConfigVOBuilder() {
      }

      public MesEnclosureCoatingConfigVO.MesEnclosureCoatingConfigVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureCoatingConfigVO.MesEnclosureCoatingConfigVOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MesEnclosureCoatingConfigVO.MesEnclosureCoatingConfigVOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesEnclosureCoatingConfigVO.MesEnclosureCoatingConfigVOBuilder measureUnit(final Integer measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public MesEnclosureCoatingConfigVO.MesEnclosureCoatingConfigVOBuilder thickness(final Integer thickness) {
         this.thickness = thickness;
         return this;
      }

      public MesEnclosureCoatingConfigVO.MesEnclosureCoatingConfigVOBuilder outThickness(final Integer outThickness) {
         this.outThickness = outThickness;
         return this;
      }

      public MesEnclosureCoatingConfigVO.MesEnclosureCoatingConfigVOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MesEnclosureCoatingConfigVO.MesEnclosureCoatingConfigVOBuilder outUnitPrice(final BigDecimal outUnitPrice) {
         this.outUnitPrice = outUnitPrice;
         return this;
      }

      public MesEnclosureCoatingConfigVO build() {
         return new MesEnclosureCoatingConfigVO(
            this.id, this.type, this.name, this.measureUnit, this.thickness, this.outThickness, this.unitPrice, this.outUnitPrice
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureCoatingConfigVO.MesEnclosureCoatingConfigVOBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", name="
            + this.name
            + ", measureUnit="
            + this.measureUnit
            + ", thickness="
            + this.thickness
            + ", outThickness="
            + this.outThickness
            + ", unitPrice="
            + this.unitPrice
            + ", outUnitPrice="
            + this.outUnitPrice
            + ")";
      }
   }
}
