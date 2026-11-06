package com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica;

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

@ApiModel(value = "MesBuildingCoatingConfig对象", description = "涂装配置")
@Entity
@TableName("mes_building_coating_config")
@Table(name = "mes_building_coating_config")
public class MesBuildingCoatingConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "type", value = "油漆类别")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(2)  COMMENT '油漆类别'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "name", value = "油漆名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(32)  COMMENT '油漆名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   @JsonProperty("measureUnit")
   @JSONField(name = "measureUnit")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(32)  COMMENT '计量单位'", nullable = false)
   private Integer measureUnit;
   @ApiModelProperty(name = "thickness", value = "标准厚度(微米)")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "int(11) COMMENT '标准厚度(微米)'")
   private Integer thickness;
   @ApiModelProperty(name = "outThickness", value = "超标厚度(微米)")
   @JsonProperty("outThickness")
   @JSONField(name = "outThickness")
   @TableField("out_thickness")
   @Column(name = "out_thickness", columnDefinition = "int(11) COMMENT '超标厚度'")
   private Integer outThickness;
   @ApiModelProperty(name = "unitPrice", value = "标准单价(元)")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(10,2)  COMMENT '单价(元)'", nullable = false)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "outUnitPrice", value = "超标单价(元)")
   @JsonProperty("outUnitPrice")
   @JSONField(name = "outUnitPrice")
   @TableField("out_unit_price")
   @Column(name = "out_unit_price", columnDefinition = "decimal(10,2)  COMMENT '单价(元)'")
   private BigDecimal outUnitPrice;

   public static MesBuildingCoatingConfig.MesBuildingCoatingConfigBuilder builder() {
      return new MesBuildingCoatingConfig.MesBuildingCoatingConfigBuilder();
   }

   public MesBuildingCoatingConfig() {
   }

   public MesBuildingCoatingConfig(
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

   @JsonProperty("id")
   public MesBuildingCoatingConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingCoatingConfig setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingCoatingConfig setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("measureUnit")
   public MesBuildingCoatingConfig setMeasureUnit(final Integer measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   @JsonProperty("thickness")
   public MesBuildingCoatingConfig setThickness(final Integer thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("outThickness")
   public MesBuildingCoatingConfig setOutThickness(final Integer outThickness) {
      this.outThickness = outThickness;
      return this;
   }

   @JsonProperty("unitPrice")
   public MesBuildingCoatingConfig setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("outUnitPrice")
   public MesBuildingCoatingConfig setOutUnitPrice(final BigDecimal outUnitPrice) {
      this.outUnitPrice = outUnitPrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCoatingConfig(id="
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

      if (!(o instanceof MesBuildingCoatingConfig)) {
         return false;
      }

      MesBuildingCoatingConfig other = (MesBuildingCoatingConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingCoatingConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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

   public static class MesBuildingCoatingConfigBuilder {
      private Long id;
      private Integer type;
      private String name;
      private Integer measureUnit;
      private Integer thickness;
      private Integer outThickness;
      private BigDecimal unitPrice;
      private BigDecimal outUnitPrice;

      MesBuildingCoatingConfigBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingCoatingConfig.MesBuildingCoatingConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingCoatingConfig.MesBuildingCoatingConfigBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingCoatingConfig.MesBuildingCoatingConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("measureUnit")
      public MesBuildingCoatingConfig.MesBuildingCoatingConfigBuilder measureUnit(final Integer measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("thickness")
      public MesBuildingCoatingConfig.MesBuildingCoatingConfigBuilder thickness(final Integer thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("outThickness")
      public MesBuildingCoatingConfig.MesBuildingCoatingConfigBuilder outThickness(final Integer outThickness) {
         this.outThickness = outThickness;
         return this;
      }

      @JsonProperty("unitPrice")
      public MesBuildingCoatingConfig.MesBuildingCoatingConfigBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("outUnitPrice")
      public MesBuildingCoatingConfig.MesBuildingCoatingConfigBuilder outUnitPrice(final BigDecimal outUnitPrice) {
         this.outUnitPrice = outUnitPrice;
         return this;
      }

      public MesBuildingCoatingConfig build() {
         return new MesBuildingCoatingConfig(
            this.id, this.type, this.name, this.measureUnit, this.thickness, this.outThickness, this.unitPrice, this.outUnitPrice
         );
      }

      @Override
      public String toString() {
         return "MesBuildingCoatingConfig.MesBuildingCoatingConfigBuilder(id="
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
