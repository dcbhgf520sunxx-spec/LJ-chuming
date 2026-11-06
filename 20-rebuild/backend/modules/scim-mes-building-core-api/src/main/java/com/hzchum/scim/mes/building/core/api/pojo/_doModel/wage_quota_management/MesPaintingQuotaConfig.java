package com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management;

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

@ApiModel(value = "PaintingQuotaConfig对象", description = "涂装定额配置表")
@Entity
@TableName("mes_painting_quota_config")
@Table(name = "mes_painting_quota_config")
@org.hibernate.annotations.Table(appliesTo = "mes_painting_quota_config", comment = "涂装定额配置表")
public class MesPaintingQuotaConfig extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("车间IDs")
   @TableField("workshop_ids")
   @Column(name = "workshop_ids", columnDefinition = "varchar(255) COMMENT '车间IDs'", nullable = true)
   private String workshopIds;
   @ApiModelProperty("漆膜厚度基数(µm)")
   @TableField("paint_film_thickness_base")
   @Column(name = "paint_film_thickness_base", columnDefinition = "decimal(32,8) COMMENT '漆膜厚度基数(µm)'", nullable = true)
   private BigDecimal paintFilmThicknessBase;
   @ApiModelProperty("起步单价(元)")
   @TableField("start_price")
   @Column(name = "start_price", columnDefinition = "decimal(32,8) COMMENT '起步单价(元)'", nullable = true)
   private BigDecimal startPrice;
   @ApiModelProperty("起加漆膜厚度(µm)")
   @TableField("start_add_paint_film_thickness")
   @Column(name = "start_add_paint_film_thickness", columnDefinition = "decimal(32,8) COMMENT '起加漆膜厚度(µm)'", nullable = true)
   private BigDecimal startAddPaintFilmThickness;
   @ApiModelProperty("起加单价(元)")
   @TableField("start_add_price")
   @Column(name = "start_add_price", columnDefinition = "decimal(32,8) COMMENT '起加单价(元)'", nullable = true)
   private BigDecimal startAddPrice;

   public static MesPaintingQuotaConfig.MesPaintingQuotaConfigBuilder builder() {
      return new MesPaintingQuotaConfig.MesPaintingQuotaConfigBuilder();
   }

   public MesPaintingQuotaConfig() {
   }

   public MesPaintingQuotaConfig(
      final Long id,
      final String workshopIds,
      final BigDecimal paintFilmThicknessBase,
      final BigDecimal startPrice,
      final BigDecimal startAddPaintFilmThickness,
      final BigDecimal startAddPrice
   ) {
      this.id = id;
      this.workshopIds = workshopIds;
      this.paintFilmThicknessBase = paintFilmThicknessBase;
      this.startPrice = startPrice;
      this.startAddPaintFilmThickness = startAddPaintFilmThickness;
      this.startAddPrice = startAddPrice;
   }

   public Long getId() {
      return this.id;
   }

   public String getWorkshopIds() {
      return this.workshopIds;
   }

   public BigDecimal getPaintFilmThicknessBase() {
      return this.paintFilmThicknessBase;
   }

   public BigDecimal getStartPrice() {
      return this.startPrice;
   }

   public BigDecimal getStartAddPaintFilmThickness() {
      return this.startAddPaintFilmThickness;
   }

   public BigDecimal getStartAddPrice() {
      return this.startAddPrice;
   }

   public MesPaintingQuotaConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesPaintingQuotaConfig setWorkshopIds(final String workshopIds) {
      this.workshopIds = workshopIds;
      return this;
   }

   public MesPaintingQuotaConfig setPaintFilmThicknessBase(final BigDecimal paintFilmThicknessBase) {
      this.paintFilmThicknessBase = paintFilmThicknessBase;
      return this;
   }

   public MesPaintingQuotaConfig setStartPrice(final BigDecimal startPrice) {
      this.startPrice = startPrice;
      return this;
   }

   public MesPaintingQuotaConfig setStartAddPaintFilmThickness(final BigDecimal startAddPaintFilmThickness) {
      this.startAddPaintFilmThickness = startAddPaintFilmThickness;
      return this;
   }

   public MesPaintingQuotaConfig setStartAddPrice(final BigDecimal startAddPrice) {
      this.startAddPrice = startAddPrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesPaintingQuotaConfig(id="
         + this.getId()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", paintFilmThicknessBase="
         + this.getPaintFilmThicknessBase()
         + ", startPrice="
         + this.getStartPrice()
         + ", startAddPaintFilmThickness="
         + this.getStartAddPaintFilmThickness()
         + ", startAddPrice="
         + this.getStartAddPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPaintingQuotaConfig)) {
         return false;
      }

      MesPaintingQuotaConfig other = (MesPaintingQuotaConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopIds = this.getWorkshopIds();
         Object other$workshopIds = other.getWorkshopIds();
         if (this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds)) {
            Object this$paintFilmThicknessBase = this.getPaintFilmThicknessBase();
            Object other$paintFilmThicknessBase = other.getPaintFilmThicknessBase();
            if (this$paintFilmThicknessBase == null ? other$paintFilmThicknessBase == null : this$paintFilmThicknessBase.equals(other$paintFilmThicknessBase)) {
               Object this$startPrice = this.getStartPrice();
               Object other$startPrice = other.getStartPrice();
               if (this$startPrice == null ? other$startPrice == null : this$startPrice.equals(other$startPrice)) {
                  Object this$startAddPaintFilmThickness = this.getStartAddPaintFilmThickness();
                  Object other$startAddPaintFilmThickness = other.getStartAddPaintFilmThickness();
                  if (this$startAddPaintFilmThickness == null
                     ? other$startAddPaintFilmThickness == null
                     : this$startAddPaintFilmThickness.equals(other$startAddPaintFilmThickness)) {
                     Object this$startAddPrice = this.getStartAddPrice();
                     Object other$startAddPrice = other.getStartAddPrice();
                     return this$startAddPrice == null ? other$startAddPrice == null : this$startAddPrice.equals(other$startAddPrice);
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
      return other instanceof MesPaintingQuotaConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      result = result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
      Object $paintFilmThicknessBase = this.getPaintFilmThicknessBase();
      result = result * 59 + ($paintFilmThicknessBase == null ? 43 : $paintFilmThicknessBase.hashCode());
      Object $startPrice = this.getStartPrice();
      result = result * 59 + ($startPrice == null ? 43 : $startPrice.hashCode());
      Object $startAddPaintFilmThickness = this.getStartAddPaintFilmThickness();
      result = result * 59 + ($startAddPaintFilmThickness == null ? 43 : $startAddPaintFilmThickness.hashCode());
      Object $startAddPrice = this.getStartAddPrice();
      return result * 59 + ($startAddPrice == null ? 43 : $startAddPrice.hashCode());
   }

   public static class MesPaintingQuotaConfigBuilder {
      private Long id;
      private String workshopIds;
      private BigDecimal paintFilmThicknessBase;
      private BigDecimal startPrice;
      private BigDecimal startAddPaintFilmThickness;
      private BigDecimal startAddPrice;

      MesPaintingQuotaConfigBuilder() {
      }

      public MesPaintingQuotaConfig.MesPaintingQuotaConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesPaintingQuotaConfig.MesPaintingQuotaConfigBuilder workshopIds(final String workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public MesPaintingQuotaConfig.MesPaintingQuotaConfigBuilder paintFilmThicknessBase(final BigDecimal paintFilmThicknessBase) {
         this.paintFilmThicknessBase = paintFilmThicknessBase;
         return this;
      }

      public MesPaintingQuotaConfig.MesPaintingQuotaConfigBuilder startPrice(final BigDecimal startPrice) {
         this.startPrice = startPrice;
         return this;
      }

      public MesPaintingQuotaConfig.MesPaintingQuotaConfigBuilder startAddPaintFilmThickness(final BigDecimal startAddPaintFilmThickness) {
         this.startAddPaintFilmThickness = startAddPaintFilmThickness;
         return this;
      }

      public MesPaintingQuotaConfig.MesPaintingQuotaConfigBuilder startAddPrice(final BigDecimal startAddPrice) {
         this.startAddPrice = startAddPrice;
         return this;
      }

      public MesPaintingQuotaConfig build() {
         return new MesPaintingQuotaConfig(
            this.id, this.workshopIds, this.paintFilmThicknessBase, this.startPrice, this.startAddPaintFilmThickness, this.startAddPrice
         );
      }

      @Override
      public String toString() {
         return "MesPaintingQuotaConfig.MesPaintingQuotaConfigBuilder(id="
            + this.id
            + ", workshopIds="
            + this.workshopIds
            + ", paintFilmThicknessBase="
            + this.paintFilmThicknessBase
            + ", startPrice="
            + this.startPrice
            + ", startAddPaintFilmThickness="
            + this.startAddPaintFilmThickness
            + ", startAddPrice="
            + this.startAddPrice
            + ")";
      }
   }
}
