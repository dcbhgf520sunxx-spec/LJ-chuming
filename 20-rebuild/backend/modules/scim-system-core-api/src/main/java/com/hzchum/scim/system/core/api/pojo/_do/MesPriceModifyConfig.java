package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesPriceModifyConfig对象", description = "价格修改配置表")
@Entity
@TableName("mes_price_modify_config")
@Table(name = "mes_price_modify_config")
@org.hibernate.annotations.Table(appliesTo = "mes_price_modify_config", comment = "价格修改配置表")
public class MesPriceModifyConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "configPrice", value = "配置价格修改场景", notes = "配置价格修改场景")
   @TableField("config_price")
   @Column(name = "config_price", columnDefinition = "int(11)  COMMENT '配置价格修改场景'", nullable = true)
   private Integer configPrice;
   @ApiModelProperty(name = "configPriceSyncStartDate", value = "配置价格同步开始日期", notes = "配置价格同步开始日期")
   @TableField("config_price_sync_start_date")
   @Column(name = "config_price_sync_start_date", columnDefinition = "datetime  COMMENT '配置价格同步开始日期'", nullable = true)
   private LocalDateTime configPriceSyncStartDate;
   @ApiModelProperty(name = "configPriceSyncEndDate", value = "配置价格同步结束日期", notes = "配置价格同步结束日期")
   @TableField("config_price_sync_end_date")
   @Column(name = "config_price_sync_end_date", columnDefinition = "datetime  COMMENT '配置价格同步结束日期'", nullable = true)
   private LocalDateTime configPriceSyncEndDate;
   @ApiModelProperty(name = "individualPrice", value = "单个价格修改场景", notes = "单个价格修改场景")
   @TableField("individual_price")
   @Column(name = "individual_price", columnDefinition = "int(11)  COMMENT '单个价格修改场景'", nullable = true)
   private Integer individualPrice;
   @ApiModelProperty(name = "individualPriceSyncStartDate", value = "单个价格同步开始日期", notes = "单个价格同步开始日期")
   @TableField("individual_price_sync_start_date")
   @Column(name = "individual_price_sync_start_date", columnDefinition = "datetime  COMMENT '单个价格同步开始日期'", nullable = true)
   private LocalDateTime individualPriceSyncStartDate;
   @ApiModelProperty(name = "individualPriceSyncEndDate", value = "单个价格同步结束日期", notes = "单个价格同步结束日期")
   @TableField("individual_price_sync_end_date")
   @Column(name = "individual_price_sync_end_date", columnDefinition = "datetime  COMMENT '单个价格同步结束日期'", nullable = true)
   private LocalDateTime individualPriceSyncEndDate;

   public static MesPriceModifyConfig.MesPriceModifyConfigBuilder builder() {
      return new MesPriceModifyConfig.MesPriceModifyConfigBuilder();
   }

   public MesPriceModifyConfig() {
   }

   public MesPriceModifyConfig(
      final Long id,
      final Integer configPrice,
      final LocalDateTime configPriceSyncStartDate,
      final LocalDateTime configPriceSyncEndDate,
      final Integer individualPrice,
      final LocalDateTime individualPriceSyncStartDate,
      final LocalDateTime individualPriceSyncEndDate
   ) {
      this.id = id;
      this.configPrice = configPrice;
      this.configPriceSyncStartDate = configPriceSyncStartDate;
      this.configPriceSyncEndDate = configPriceSyncEndDate;
      this.individualPrice = individualPrice;
      this.individualPriceSyncStartDate = individualPriceSyncStartDate;
      this.individualPriceSyncEndDate = individualPriceSyncEndDate;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getConfigPrice() {
      return this.configPrice;
   }

   public LocalDateTime getConfigPriceSyncStartDate() {
      return this.configPriceSyncStartDate;
   }

   public LocalDateTime getConfigPriceSyncEndDate() {
      return this.configPriceSyncEndDate;
   }

   public Integer getIndividualPrice() {
      return this.individualPrice;
   }

   public LocalDateTime getIndividualPriceSyncStartDate() {
      return this.individualPriceSyncStartDate;
   }

   public LocalDateTime getIndividualPriceSyncEndDate() {
      return this.individualPriceSyncEndDate;
   }

   public MesPriceModifyConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesPriceModifyConfig setConfigPrice(final Integer configPrice) {
      this.configPrice = configPrice;
      return this;
   }

   public MesPriceModifyConfig setConfigPriceSyncStartDate(final LocalDateTime configPriceSyncStartDate) {
      this.configPriceSyncStartDate = configPriceSyncStartDate;
      return this;
   }

   public MesPriceModifyConfig setConfigPriceSyncEndDate(final LocalDateTime configPriceSyncEndDate) {
      this.configPriceSyncEndDate = configPriceSyncEndDate;
      return this;
   }

   public MesPriceModifyConfig setIndividualPrice(final Integer individualPrice) {
      this.individualPrice = individualPrice;
      return this;
   }

   public MesPriceModifyConfig setIndividualPriceSyncStartDate(final LocalDateTime individualPriceSyncStartDate) {
      this.individualPriceSyncStartDate = individualPriceSyncStartDate;
      return this;
   }

   public MesPriceModifyConfig setIndividualPriceSyncEndDate(final LocalDateTime individualPriceSyncEndDate) {
      this.individualPriceSyncEndDate = individualPriceSyncEndDate;
      return this;
   }

   @Override
   public String toString() {
      return "MesPriceModifyConfig(id="
         + this.getId()
         + ", configPrice="
         + this.getConfigPrice()
         + ", configPriceSyncStartDate="
         + this.getConfigPriceSyncStartDate()
         + ", configPriceSyncEndDate="
         + this.getConfigPriceSyncEndDate()
         + ", individualPrice="
         + this.getIndividualPrice()
         + ", individualPriceSyncStartDate="
         + this.getIndividualPriceSyncStartDate()
         + ", individualPriceSyncEndDate="
         + this.getIndividualPriceSyncEndDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPriceModifyConfig)) {
         return false;
      }

      MesPriceModifyConfig other = (MesPriceModifyConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$configPrice = this.getConfigPrice();
         Object other$configPrice = other.getConfigPrice();
         if (this$configPrice == null ? other$configPrice == null : this$configPrice.equals(other$configPrice)) {
            Object this$individualPrice = this.getIndividualPrice();
            Object other$individualPrice = other.getIndividualPrice();
            if (this$individualPrice == null ? other$individualPrice == null : this$individualPrice.equals(other$individualPrice)) {
               Object this$configPriceSyncStartDate = this.getConfigPriceSyncStartDate();
               Object other$configPriceSyncStartDate = other.getConfigPriceSyncStartDate();
               if (this$configPriceSyncStartDate == null
                  ? other$configPriceSyncStartDate == null
                  : this$configPriceSyncStartDate.equals(other$configPriceSyncStartDate)) {
                  Object this$configPriceSyncEndDate = this.getConfigPriceSyncEndDate();
                  Object other$configPriceSyncEndDate = other.getConfigPriceSyncEndDate();
                  if (this$configPriceSyncEndDate == null
                     ? other$configPriceSyncEndDate == null
                     : this$configPriceSyncEndDate.equals(other$configPriceSyncEndDate)) {
                     Object this$individualPriceSyncStartDate = this.getIndividualPriceSyncStartDate();
                     Object other$individualPriceSyncStartDate = other.getIndividualPriceSyncStartDate();
                     if (this$individualPriceSyncStartDate == null
                        ? other$individualPriceSyncStartDate == null
                        : this$individualPriceSyncStartDate.equals(other$individualPriceSyncStartDate)) {
                        Object this$individualPriceSyncEndDate = this.getIndividualPriceSyncEndDate();
                        Object other$individualPriceSyncEndDate = other.getIndividualPriceSyncEndDate();
                        return this$individualPriceSyncEndDate == null
                           ? other$individualPriceSyncEndDate == null
                           : this$individualPriceSyncEndDate.equals(other$individualPriceSyncEndDate);
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
      return other instanceof MesPriceModifyConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $configPrice = this.getConfigPrice();
      result = result * 59 + ($configPrice == null ? 43 : $configPrice.hashCode());
      Object $individualPrice = this.getIndividualPrice();
      result = result * 59 + ($individualPrice == null ? 43 : $individualPrice.hashCode());
      Object $configPriceSyncStartDate = this.getConfigPriceSyncStartDate();
      result = result * 59 + ($configPriceSyncStartDate == null ? 43 : $configPriceSyncStartDate.hashCode());
      Object $configPriceSyncEndDate = this.getConfigPriceSyncEndDate();
      result = result * 59 + ($configPriceSyncEndDate == null ? 43 : $configPriceSyncEndDate.hashCode());
      Object $individualPriceSyncStartDate = this.getIndividualPriceSyncStartDate();
      result = result * 59 + ($individualPriceSyncStartDate == null ? 43 : $individualPriceSyncStartDate.hashCode());
      Object $individualPriceSyncEndDate = this.getIndividualPriceSyncEndDate();
      return result * 59 + ($individualPriceSyncEndDate == null ? 43 : $individualPriceSyncEndDate.hashCode());
   }

   public static class MesPriceModifyConfigBuilder {
      private Long id;
      private Integer configPrice;
      private LocalDateTime configPriceSyncStartDate;
      private LocalDateTime configPriceSyncEndDate;
      private Integer individualPrice;
      private LocalDateTime individualPriceSyncStartDate;
      private LocalDateTime individualPriceSyncEndDate;

      MesPriceModifyConfigBuilder() {
      }

      public MesPriceModifyConfig.MesPriceModifyConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesPriceModifyConfig.MesPriceModifyConfigBuilder configPrice(final Integer configPrice) {
         this.configPrice = configPrice;
         return this;
      }

      public MesPriceModifyConfig.MesPriceModifyConfigBuilder configPriceSyncStartDate(final LocalDateTime configPriceSyncStartDate) {
         this.configPriceSyncStartDate = configPriceSyncStartDate;
         return this;
      }

      public MesPriceModifyConfig.MesPriceModifyConfigBuilder configPriceSyncEndDate(final LocalDateTime configPriceSyncEndDate) {
         this.configPriceSyncEndDate = configPriceSyncEndDate;
         return this;
      }

      public MesPriceModifyConfig.MesPriceModifyConfigBuilder individualPrice(final Integer individualPrice) {
         this.individualPrice = individualPrice;
         return this;
      }

      public MesPriceModifyConfig.MesPriceModifyConfigBuilder individualPriceSyncStartDate(final LocalDateTime individualPriceSyncStartDate) {
         this.individualPriceSyncStartDate = individualPriceSyncStartDate;
         return this;
      }

      public MesPriceModifyConfig.MesPriceModifyConfigBuilder individualPriceSyncEndDate(final LocalDateTime individualPriceSyncEndDate) {
         this.individualPriceSyncEndDate = individualPriceSyncEndDate;
         return this;
      }

      public MesPriceModifyConfig build() {
         return new MesPriceModifyConfig(
            this.id,
            this.configPrice,
            this.configPriceSyncStartDate,
            this.configPriceSyncEndDate,
            this.individualPrice,
            this.individualPriceSyncStartDate,
            this.individualPriceSyncEndDate
         );
      }

      @Override
      public String toString() {
         return "MesPriceModifyConfig.MesPriceModifyConfigBuilder(id="
            + this.id
            + ", configPrice="
            + this.configPrice
            + ", configPriceSyncStartDate="
            + this.configPriceSyncStartDate
            + ", configPriceSyncEndDate="
            + this.configPriceSyncEndDate
            + ", individualPrice="
            + this.individualPrice
            + ", individualPriceSyncStartDate="
            + this.individualPriceSyncStartDate
            + ", individualPriceSyncEndDate="
            + this.individualPriceSyncEndDate
            + ")";
      }
   }
}
