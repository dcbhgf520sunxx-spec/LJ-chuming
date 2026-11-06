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

@ApiModel(value = "MesBuildingLayingOffConfig对象", description = "MES零件-下料配置")
@Entity
@TableName("mes_building_laying_off_config")
@Table(name = "mes_building_laying_off_config")
public class MesBuildingLayingOffConfig extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "name", value = "下料方式名称", notes = "下料方式")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(32)  COMMENT '下料方式'", nullable = false)
   private String name;
   @ApiModelProperty(name = "cutConfigId", value = "切割配置id", notes = "切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   @TableField("cut_config_id")
   @Column(name = "cut_config_id", columnDefinition = "bigint(20)  COMMENT '切割配置id'", nullable = false)
   private Long cutConfigId;
   @ApiModelProperty(name = "minNumerical", value = "数值范围(开始)")
   @JsonProperty("minNumerical")
   @JSONField(name = "min_numerical")
   @TableField("min_numerical")
   @Column(name = "min_numerical", columnDefinition = "decimal(32,8)  COMMENT '数值范围(开始)'", nullable = false)
   private BigDecimal minNumerical;
   @ApiModelProperty(name = "maxNumerical", value = "数值范围(结束)")
   @JsonProperty("maxNumerical")
   @JSONField(name = "max_numerical")
   @TableField("max_numerical")
   @Column(name = "max_numerical", columnDefinition = "decimal(32,8)  COMMENT '数值范围(结束)'", nullable = false)
   private BigDecimal maxNumerical;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式", notes = "计价方式 [1 重量, 2 长度，4 面积, 8 数量]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   @TableField("wage_quota_type")
   @Column(name = "wage_quota_type", columnDefinition = "int(20) default '1' COMMENT '计价方式 [1 重量, 2 长度，4 面积, 8 数量]'", nullable = false)
   private Integer wageQuotaType;
   @ApiModelProperty(name = "unitPrice", value = "单价(元)")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(10,2)  COMMENT '单价(元)'", nullable = false)
   private BigDecimal unitPrice;

   public static MesBuildingLayingOffConfig.MesBuildingLayingOffConfigBuilder builder() {
      return new MesBuildingLayingOffConfig.MesBuildingLayingOffConfigBuilder();
   }

   public MesBuildingLayingOffConfig() {
   }

   public MesBuildingLayingOffConfig(
      final Long id,
      final String specPrefix,
      final String name,
      final Long cutConfigId,
      final BigDecimal minNumerical,
      final BigDecimal maxNumerical,
      final Integer wageQuotaType,
      final BigDecimal unitPrice
   ) {
      this.id = id;
      this.specPrefix = specPrefix;
      this.name = name;
      this.cutConfigId = cutConfigId;
      this.minNumerical = minNumerical;
      this.maxNumerical = maxNumerical;
      this.wageQuotaType = wageQuotaType;
      this.unitPrice = unitPrice;
   }

   public Long getId() {
      return this.id;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getName() {
      return this.name;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public BigDecimal getMinNumerical() {
      return this.minNumerical;
   }

   public BigDecimal getMaxNumerical() {
      return this.maxNumerical;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   @JsonProperty("id")
   public MesBuildingLayingOffConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("specPrefix")
   public MesBuildingLayingOffConfig setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingLayingOffConfig setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesBuildingLayingOffConfig setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("minNumerical")
   public MesBuildingLayingOffConfig setMinNumerical(final BigDecimal minNumerical) {
      this.minNumerical = minNumerical;
      return this;
   }

   @JsonProperty("maxNumerical")
   public MesBuildingLayingOffConfig setMaxNumerical(final BigDecimal maxNumerical) {
      this.maxNumerical = maxNumerical;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesBuildingLayingOffConfig setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("unitPrice")
   public MesBuildingLayingOffConfig setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingLayingOffConfig(id="
         + this.getId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", name="
         + this.getName()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", minNumerical="
         + this.getMinNumerical()
         + ", maxNumerical="
         + this.getMaxNumerical()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", unitPrice="
         + this.getUnitPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingLayingOffConfig)) {
         return false;
      }

      MesBuildingLayingOffConfig other = (MesBuildingLayingOffConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cutConfigId = this.getCutConfigId();
         Object other$cutConfigId = other.getCutConfigId();
         if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
            Object this$wageQuotaType = this.getWageQuotaType();
            Object other$wageQuotaType = other.getWageQuotaType();
            if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
               Object this$specPrefix = this.getSpecPrefix();
               Object other$specPrefix = other.getSpecPrefix();
               if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$minNumerical = this.getMinNumerical();
                     Object other$minNumerical = other.getMinNumerical();
                     if (this$minNumerical == null ? other$minNumerical == null : this$minNumerical.equals(other$minNumerical)) {
                        Object this$maxNumerical = this.getMaxNumerical();
                        Object other$maxNumerical = other.getMaxNumerical();
                        if (this$maxNumerical == null ? other$maxNumerical == null : this$maxNumerical.equals(other$maxNumerical)) {
                           Object this$unitPrice = this.getUnitPrice();
                           Object other$unitPrice = other.getUnitPrice();
                           return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
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
      return other instanceof MesBuildingLayingOffConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $minNumerical = this.getMinNumerical();
      result = result * 59 + ($minNumerical == null ? 43 : $minNumerical.hashCode());
      Object $maxNumerical = this.getMaxNumerical();
      result = result * 59 + ($maxNumerical == null ? 43 : $maxNumerical.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   public static class MesBuildingLayingOffConfigBuilder {
      private Long id;
      private String specPrefix;
      private String name;
      private Long cutConfigId;
      private BigDecimal minNumerical;
      private BigDecimal maxNumerical;
      private Integer wageQuotaType;
      private BigDecimal unitPrice;

      MesBuildingLayingOffConfigBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingLayingOffConfig.MesBuildingLayingOffConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("specPrefix")
      public MesBuildingLayingOffConfig.MesBuildingLayingOffConfigBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingLayingOffConfig.MesBuildingLayingOffConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesBuildingLayingOffConfig.MesBuildingLayingOffConfigBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("minNumerical")
      public MesBuildingLayingOffConfig.MesBuildingLayingOffConfigBuilder minNumerical(final BigDecimal minNumerical) {
         this.minNumerical = minNumerical;
         return this;
      }

      @JsonProperty("maxNumerical")
      public MesBuildingLayingOffConfig.MesBuildingLayingOffConfigBuilder maxNumerical(final BigDecimal maxNumerical) {
         this.maxNumerical = maxNumerical;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesBuildingLayingOffConfig.MesBuildingLayingOffConfigBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("unitPrice")
      public MesBuildingLayingOffConfig.MesBuildingLayingOffConfigBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MesBuildingLayingOffConfig build() {
         return new MesBuildingLayingOffConfig(
            this.id, this.specPrefix, this.name, this.cutConfigId, this.minNumerical, this.maxNumerical, this.wageQuotaType, this.unitPrice
         );
      }

      @Override
      public String toString() {
         return "MesBuildingLayingOffConfig.MesBuildingLayingOffConfigBuilder(id="
            + this.id
            + ", specPrefix="
            + this.specPrefix
            + ", name="
            + this.name
            + ", cutConfigId="
            + this.cutConfigId
            + ", minNumerical="
            + this.minNumerical
            + ", maxNumerical="
            + this.maxNumerical
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", unitPrice="
            + this.unitPrice
            + ")";
      }
   }
}
