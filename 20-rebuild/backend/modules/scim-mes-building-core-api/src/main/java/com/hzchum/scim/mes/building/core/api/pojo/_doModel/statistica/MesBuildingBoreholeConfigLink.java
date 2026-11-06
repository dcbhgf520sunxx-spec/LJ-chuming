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

@ApiModel(value = "MesBuildingBoreholeConfigLink对象", description = "钻孔配置关联")
@Entity
@TableName("mes_building_borehole_config_link")
@Table(name = "mes_building_borehole_config_link")
public class MesBuildingBoreholeConfigLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "boreholeConfigId", value = "钻孔配置id")
   @JsonProperty("boreholeConfigId")
   @JSONField(name = "boreholeConfigId")
   @TableField("borehole_config_id")
   @Column(name = "borehole_config_id", columnDefinition = "bigint(20)  COMMENT '钻孔配置id'", nullable = false)
   private Long boreholeConfigId;
   @ApiModelProperty(name = "minBoreDiameter", value = "最小孔径(毫米)")
   @JsonProperty("minBoreDiameter")
   @JSONField(name = "min_Bore_Diameter")
   @TableField("min_Bore_Diameter")
   @Column(name = "min_Bore_Diameter", columnDefinition = "decimal(32,8) COMMENT '最小孔径(毫米)'", nullable = false)
   private BigDecimal minBoreDiameter;
   @ApiModelProperty(name = "maxBoreDiameter", value = "最大孔径(毫米)")
   @JsonProperty("maxBoreDiameter")
   @JSONField(name = "max_Bore_Diameter")
   @TableField("max_Bore_Diameter")
   @Column(name = "max_Bore_Diameter", columnDefinition = "decimal(32,8) COMMENT '最大孔径(毫米)'", nullable = false)
   private BigDecimal maxBoreDiameter;
   @ApiModelProperty(name = "unitPrice", value = "单价(元)")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(10,2)  COMMENT '单价(元)'", nullable = false)
   private BigDecimal unitPrice;

   public static MesBuildingBoreholeConfigLink.MesBuildingBoreholeConfigLinkBuilder builder() {
      return new MesBuildingBoreholeConfigLink.MesBuildingBoreholeConfigLinkBuilder();
   }

   public MesBuildingBoreholeConfigLink() {
   }

   public MesBuildingBoreholeConfigLink(
      final Long id, final Long boreholeConfigId, final BigDecimal minBoreDiameter, final BigDecimal maxBoreDiameter, final BigDecimal unitPrice
   ) {
      this.id = id;
      this.boreholeConfigId = boreholeConfigId;
      this.minBoreDiameter = minBoreDiameter;
      this.maxBoreDiameter = maxBoreDiameter;
      this.unitPrice = unitPrice;
   }

   public Long getId() {
      return this.id;
   }

   public Long getBoreholeConfigId() {
      return this.boreholeConfigId;
   }

   public BigDecimal getMinBoreDiameter() {
      return this.minBoreDiameter;
   }

   public BigDecimal getMaxBoreDiameter() {
      return this.maxBoreDiameter;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   @JsonProperty("id")
   public MesBuildingBoreholeConfigLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("boreholeConfigId")
   public MesBuildingBoreholeConfigLink setBoreholeConfigId(final Long boreholeConfigId) {
      this.boreholeConfigId = boreholeConfigId;
      return this;
   }

   @JsonProperty("minBoreDiameter")
   public MesBuildingBoreholeConfigLink setMinBoreDiameter(final BigDecimal minBoreDiameter) {
      this.minBoreDiameter = minBoreDiameter;
      return this;
   }

   @JsonProperty("maxBoreDiameter")
   public MesBuildingBoreholeConfigLink setMaxBoreDiameter(final BigDecimal maxBoreDiameter) {
      this.maxBoreDiameter = maxBoreDiameter;
      return this;
   }

   @JsonProperty("unitPrice")
   public MesBuildingBoreholeConfigLink setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingBoreholeConfigLink(id="
         + this.getId()
         + ", boreholeConfigId="
         + this.getBoreholeConfigId()
         + ", minBoreDiameter="
         + this.getMinBoreDiameter()
         + ", maxBoreDiameter="
         + this.getMaxBoreDiameter()
         + ", unitPrice="
         + this.getUnitPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingBoreholeConfigLink)) {
         return false;
      }

      MesBuildingBoreholeConfigLink other = (MesBuildingBoreholeConfigLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boreholeConfigId = this.getBoreholeConfigId();
         Object other$boreholeConfigId = other.getBoreholeConfigId();
         if (this$boreholeConfigId == null ? other$boreholeConfigId == null : this$boreholeConfigId.equals(other$boreholeConfigId)) {
            Object this$minBoreDiameter = this.getMinBoreDiameter();
            Object other$minBoreDiameter = other.getMinBoreDiameter();
            if (this$minBoreDiameter == null ? other$minBoreDiameter == null : this$minBoreDiameter.equals(other$minBoreDiameter)) {
               Object this$maxBoreDiameter = this.getMaxBoreDiameter();
               Object other$maxBoreDiameter = other.getMaxBoreDiameter();
               if (this$maxBoreDiameter == null ? other$maxBoreDiameter == null : this$maxBoreDiameter.equals(other$maxBoreDiameter)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingBoreholeConfigLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boreholeConfigId = this.getBoreholeConfigId();
      result = result * 59 + ($boreholeConfigId == null ? 43 : $boreholeConfigId.hashCode());
      Object $minBoreDiameter = this.getMinBoreDiameter();
      result = result * 59 + ($minBoreDiameter == null ? 43 : $minBoreDiameter.hashCode());
      Object $maxBoreDiameter = this.getMaxBoreDiameter();
      result = result * 59 + ($maxBoreDiameter == null ? 43 : $maxBoreDiameter.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   public static class MesBuildingBoreholeConfigLinkBuilder {
      private Long id;
      private Long boreholeConfigId;
      private BigDecimal minBoreDiameter;
      private BigDecimal maxBoreDiameter;
      private BigDecimal unitPrice;

      MesBuildingBoreholeConfigLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingBoreholeConfigLink.MesBuildingBoreholeConfigLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("boreholeConfigId")
      public MesBuildingBoreholeConfigLink.MesBuildingBoreholeConfigLinkBuilder boreholeConfigId(final Long boreholeConfigId) {
         this.boreholeConfigId = boreholeConfigId;
         return this;
      }

      @JsonProperty("minBoreDiameter")
      public MesBuildingBoreholeConfigLink.MesBuildingBoreholeConfigLinkBuilder minBoreDiameter(final BigDecimal minBoreDiameter) {
         this.minBoreDiameter = minBoreDiameter;
         return this;
      }

      @JsonProperty("maxBoreDiameter")
      public MesBuildingBoreholeConfigLink.MesBuildingBoreholeConfigLinkBuilder maxBoreDiameter(final BigDecimal maxBoreDiameter) {
         this.maxBoreDiameter = maxBoreDiameter;
         return this;
      }

      @JsonProperty("unitPrice")
      public MesBuildingBoreholeConfigLink.MesBuildingBoreholeConfigLinkBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MesBuildingBoreholeConfigLink build() {
         return new MesBuildingBoreholeConfigLink(this.id, this.boreholeConfigId, this.minBoreDiameter, this.maxBoreDiameter, this.unitPrice);
      }

      @Override
      public String toString() {
         return "MesBuildingBoreholeConfigLink.MesBuildingBoreholeConfigLinkBuilder(id="
            + this.id
            + ", boreholeConfigId="
            + this.boreholeConfigId
            + ", minBoreDiameter="
            + this.minBoreDiameter
            + ", maxBoreDiameter="
            + this.maxBoreDiameter
            + ", unitPrice="
            + this.unitPrice
            + ")";
      }
   }
}
