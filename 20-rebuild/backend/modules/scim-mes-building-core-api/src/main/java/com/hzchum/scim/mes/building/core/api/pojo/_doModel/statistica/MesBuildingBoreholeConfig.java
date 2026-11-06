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

@ApiModel(value = "MesBuildingBoreholeConfig对象", description = "钻孔配置")
@Entity
@TableName("mes_building_borehole_config")
@Table(name = "mes_building_borehole_config")
public class MesBuildingBoreholeConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "specPrefix", value = "零件规格前缀")
   @JsonProperty("specPrefix")
   @JSONField(name = "specPrefix")
   @TableField("spec_prefix")
   @Column(name = "spec_prefix", columnDefinition = "varchar(32)  COMMENT '零件规格前缀'", nullable = false)
   private String specPrefix;
   @ApiModelProperty(name = "minThickness", value = "最小板厚(毫米)")
   @JsonProperty("minThickness")
   @JSONField(name = "min_thickness")
   @TableField("min_thickness")
   @Column(name = "min_thickness", columnDefinition = "decimal(32,8) COMMENT '最小板厚(毫米)'", nullable = false)
   private BigDecimal minThickness;
   @ApiModelProperty(name = "maxThickness", value = "最大板厚(毫米)")
   @JsonProperty("maxThickness")
   @JSONField(name = "max_thickness")
   @TableField("max_thickness")
   @Column(name = "max_thickness", columnDefinition = "decimal(32,8) COMMENT '最大板厚(毫米)'", nullable = false)
   private BigDecimal maxThickness;

   public static MesBuildingBoreholeConfig.MesBuildingBoreholeConfigBuilder builder() {
      return new MesBuildingBoreholeConfig.MesBuildingBoreholeConfigBuilder();
   }

   public MesBuildingBoreholeConfig() {
   }

   public MesBuildingBoreholeConfig(final Long id, final String specPrefix, final BigDecimal minThickness, final BigDecimal maxThickness) {
      this.id = id;
      this.specPrefix = specPrefix;
      this.minThickness = minThickness;
      this.maxThickness = maxThickness;
   }

   public Long getId() {
      return this.id;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public BigDecimal getMinThickness() {
      return this.minThickness;
   }

   public BigDecimal getMaxThickness() {
      return this.maxThickness;
   }

   @JsonProperty("id")
   public MesBuildingBoreholeConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("specPrefix")
   public MesBuildingBoreholeConfig setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   @JsonProperty("minThickness")
   public MesBuildingBoreholeConfig setMinThickness(final BigDecimal minThickness) {
      this.minThickness = minThickness;
      return this;
   }

   @JsonProperty("maxThickness")
   public MesBuildingBoreholeConfig setMaxThickness(final BigDecimal maxThickness) {
      this.maxThickness = maxThickness;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingBoreholeConfig(id="
         + this.getId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", minThickness="
         + this.getMinThickness()
         + ", maxThickness="
         + this.getMaxThickness()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingBoreholeConfig)) {
         return false;
      }

      MesBuildingBoreholeConfig other = (MesBuildingBoreholeConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$specPrefix = this.getSpecPrefix();
         Object other$specPrefix = other.getSpecPrefix();
         if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
            Object this$minThickness = this.getMinThickness();
            Object other$minThickness = other.getMinThickness();
            if (this$minThickness == null ? other$minThickness == null : this$minThickness.equals(other$minThickness)) {
               Object this$maxThickness = this.getMaxThickness();
               Object other$maxThickness = other.getMaxThickness();
               return this$maxThickness == null ? other$maxThickness == null : this$maxThickness.equals(other$maxThickness);
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
      return other instanceof MesBuildingBoreholeConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $minThickness = this.getMinThickness();
      result = result * 59 + ($minThickness == null ? 43 : $minThickness.hashCode());
      Object $maxThickness = this.getMaxThickness();
      return result * 59 + ($maxThickness == null ? 43 : $maxThickness.hashCode());
   }

   public static class MesBuildingBoreholeConfigBuilder {
      private Long id;
      private String specPrefix;
      private BigDecimal minThickness;
      private BigDecimal maxThickness;

      MesBuildingBoreholeConfigBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingBoreholeConfig.MesBuildingBoreholeConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("specPrefix")
      public MesBuildingBoreholeConfig.MesBuildingBoreholeConfigBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      @JsonProperty("minThickness")
      public MesBuildingBoreholeConfig.MesBuildingBoreholeConfigBuilder minThickness(final BigDecimal minThickness) {
         this.minThickness = minThickness;
         return this;
      }

      @JsonProperty("maxThickness")
      public MesBuildingBoreholeConfig.MesBuildingBoreholeConfigBuilder maxThickness(final BigDecimal maxThickness) {
         this.maxThickness = maxThickness;
         return this;
      }

      public MesBuildingBoreholeConfig build() {
         return new MesBuildingBoreholeConfig(this.id, this.specPrefix, this.minThickness, this.maxThickness);
      }

      @Override
      public String toString() {
         return "MesBuildingBoreholeConfig.MesBuildingBoreholeConfigBuilder(id="
            + this.id
            + ", specPrefix="
            + this.specPrefix
            + ", minThickness="
            + this.minThickness
            + ", maxThickness="
            + this.maxThickness
            + ")";
      }
   }
}
