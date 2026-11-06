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

@ApiModel(value = "MesContractProjectStatisticsConfigLink对象", description = "项目统计配置关联表")
@Entity
@TableName("mes_contract_project_statistics_config_link")
@Table(name = "mes_contract_project_statistics_config_link")
@org.hibernate.annotations.Table(appliesTo = "mes_contract_project_statistics_config_link", comment = "项目统计配置关联表")
public class MesContractProjectStatisticsConfigLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "contractProjectId", value = "项目ID", notes = "项目ID")
   @TableField("contract_project_id")
   @Column(name = "contract_project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = true)
   private Long contractProjectId;
   @ApiModelProperty(name = "statisticsMode", value = "统计模式", notes = "统计模式")
   @TableField("statistics_mode")
   @Column(name = "statistics_mode", columnDefinition = "int(11)  COMMENT '统计模式'", nullable = true)
   private Integer statisticsMode;
   @ApiModelProperty(name = "statisticsDeadline", value = "统计截止日期", notes = "统计截止日期")
   @TableField("statistics_deadline")
   @Column(name = "statistics_deadline", columnDefinition = "datetime  COMMENT '统计截止日期'", nullable = true)
   private LocalDateTime statisticsDeadline;
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

   public static MesContractProjectStatisticsConfigLink.MesContractProjectStatisticsConfigLinkBuilder builder() {
      return new MesContractProjectStatisticsConfigLink.MesContractProjectStatisticsConfigLinkBuilder();
   }

   public MesContractProjectStatisticsConfigLink() {
   }

   public MesContractProjectStatisticsConfigLink(
      final Long id,
      final Long contractProjectId,
      final Integer statisticsMode,
      final LocalDateTime statisticsDeadline,
      final Integer configPrice,
      final LocalDateTime configPriceSyncStartDate,
      final LocalDateTime configPriceSyncEndDate,
      final Integer individualPrice,
      final LocalDateTime individualPriceSyncStartDate,
      final LocalDateTime individualPriceSyncEndDate
   ) {
      this.id = id;
      this.contractProjectId = contractProjectId;
      this.statisticsMode = statisticsMode;
      this.statisticsDeadline = statisticsDeadline;
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

   public Long getContractProjectId() {
      return this.contractProjectId;
   }

   public Integer getStatisticsMode() {
      return this.statisticsMode;
   }

   public LocalDateTime getStatisticsDeadline() {
      return this.statisticsDeadline;
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

   public MesContractProjectStatisticsConfigLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesContractProjectStatisticsConfigLink setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
      return this;
   }

   public MesContractProjectStatisticsConfigLink setStatisticsMode(final Integer statisticsMode) {
      this.statisticsMode = statisticsMode;
      return this;
   }

   public MesContractProjectStatisticsConfigLink setStatisticsDeadline(final LocalDateTime statisticsDeadline) {
      this.statisticsDeadline = statisticsDeadline;
      return this;
   }

   public MesContractProjectStatisticsConfigLink setConfigPrice(final Integer configPrice) {
      this.configPrice = configPrice;
      return this;
   }

   public MesContractProjectStatisticsConfigLink setConfigPriceSyncStartDate(final LocalDateTime configPriceSyncStartDate) {
      this.configPriceSyncStartDate = configPriceSyncStartDate;
      return this;
   }

   public MesContractProjectStatisticsConfigLink setConfigPriceSyncEndDate(final LocalDateTime configPriceSyncEndDate) {
      this.configPriceSyncEndDate = configPriceSyncEndDate;
      return this;
   }

   public MesContractProjectStatisticsConfigLink setIndividualPrice(final Integer individualPrice) {
      this.individualPrice = individualPrice;
      return this;
   }

   public MesContractProjectStatisticsConfigLink setIndividualPriceSyncStartDate(final LocalDateTime individualPriceSyncStartDate) {
      this.individualPriceSyncStartDate = individualPriceSyncStartDate;
      return this;
   }

   public MesContractProjectStatisticsConfigLink setIndividualPriceSyncEndDate(final LocalDateTime individualPriceSyncEndDate) {
      this.individualPriceSyncEndDate = individualPriceSyncEndDate;
      return this;
   }

   @Override
   public String toString() {
      return "MesContractProjectStatisticsConfigLink(id="
         + this.getId()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", statisticsMode="
         + this.getStatisticsMode()
         + ", statisticsDeadline="
         + this.getStatisticsDeadline()
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

      if (!(o instanceof MesContractProjectStatisticsConfigLink)) {
         return false;
      }

      MesContractProjectStatisticsConfigLink other = (MesContractProjectStatisticsConfigLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractProjectId = this.getContractProjectId();
         Object other$contractProjectId = other.getContractProjectId();
         if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
            Object this$statisticsMode = this.getStatisticsMode();
            Object other$statisticsMode = other.getStatisticsMode();
            if (this$statisticsMode == null ? other$statisticsMode == null : this$statisticsMode.equals(other$statisticsMode)) {
               Object this$configPrice = this.getConfigPrice();
               Object other$configPrice = other.getConfigPrice();
               if (this$configPrice == null ? other$configPrice == null : this$configPrice.equals(other$configPrice)) {
                  Object this$individualPrice = this.getIndividualPrice();
                  Object other$individualPrice = other.getIndividualPrice();
                  if (this$individualPrice == null ? other$individualPrice == null : this$individualPrice.equals(other$individualPrice)) {
                     Object this$statisticsDeadline = this.getStatisticsDeadline();
                     Object other$statisticsDeadline = other.getStatisticsDeadline();
                     if (this$statisticsDeadline == null ? other$statisticsDeadline == null : this$statisticsDeadline.equals(other$statisticsDeadline)) {
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
      return other instanceof MesContractProjectStatisticsConfigLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $statisticsMode = this.getStatisticsMode();
      result = result * 59 + ($statisticsMode == null ? 43 : $statisticsMode.hashCode());
      Object $configPrice = this.getConfigPrice();
      result = result * 59 + ($configPrice == null ? 43 : $configPrice.hashCode());
      Object $individualPrice = this.getIndividualPrice();
      result = result * 59 + ($individualPrice == null ? 43 : $individualPrice.hashCode());
      Object $statisticsDeadline = this.getStatisticsDeadline();
      result = result * 59 + ($statisticsDeadline == null ? 43 : $statisticsDeadline.hashCode());
      Object $configPriceSyncStartDate = this.getConfigPriceSyncStartDate();
      result = result * 59 + ($configPriceSyncStartDate == null ? 43 : $configPriceSyncStartDate.hashCode());
      Object $configPriceSyncEndDate = this.getConfigPriceSyncEndDate();
      result = result * 59 + ($configPriceSyncEndDate == null ? 43 : $configPriceSyncEndDate.hashCode());
      Object $individualPriceSyncStartDate = this.getIndividualPriceSyncStartDate();
      result = result * 59 + ($individualPriceSyncStartDate == null ? 43 : $individualPriceSyncStartDate.hashCode());
      Object $individualPriceSyncEndDate = this.getIndividualPriceSyncEndDate();
      return result * 59 + ($individualPriceSyncEndDate == null ? 43 : $individualPriceSyncEndDate.hashCode());
   }

   public static class MesContractProjectStatisticsConfigLinkBuilder {
      private Long id;
      private Long contractProjectId;
      private Integer statisticsMode;
      private LocalDateTime statisticsDeadline;
      private Integer configPrice;
      private LocalDateTime configPriceSyncStartDate;
      private LocalDateTime configPriceSyncEndDate;
      private Integer individualPrice;
      private LocalDateTime individualPriceSyncStartDate;
      private LocalDateTime individualPriceSyncEndDate;

      MesContractProjectStatisticsConfigLinkBuilder() {
      }

      public MesContractProjectStatisticsConfigLink.MesContractProjectStatisticsConfigLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesContractProjectStatisticsConfigLink.MesContractProjectStatisticsConfigLinkBuilder contractProjectId(final Long contractProjectId) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesContractProjectStatisticsConfigLink.MesContractProjectStatisticsConfigLinkBuilder statisticsMode(final Integer statisticsMode) {
         this.statisticsMode = statisticsMode;
         return this;
      }

      public MesContractProjectStatisticsConfigLink.MesContractProjectStatisticsConfigLinkBuilder statisticsDeadline(final LocalDateTime statisticsDeadline) {
         this.statisticsDeadline = statisticsDeadline;
         return this;
      }

      public MesContractProjectStatisticsConfigLink.MesContractProjectStatisticsConfigLinkBuilder configPrice(final Integer configPrice) {
         this.configPrice = configPrice;
         return this;
      }

      public MesContractProjectStatisticsConfigLink.MesContractProjectStatisticsConfigLinkBuilder configPriceSyncStartDate(
         final LocalDateTime configPriceSyncStartDate
      ) {
         this.configPriceSyncStartDate = configPriceSyncStartDate;
         return this;
      }

      public MesContractProjectStatisticsConfigLink.MesContractProjectStatisticsConfigLinkBuilder configPriceSyncEndDate(
         final LocalDateTime configPriceSyncEndDate
      ) {
         this.configPriceSyncEndDate = configPriceSyncEndDate;
         return this;
      }

      public MesContractProjectStatisticsConfigLink.MesContractProjectStatisticsConfigLinkBuilder individualPrice(final Integer individualPrice) {
         this.individualPrice = individualPrice;
         return this;
      }

      public MesContractProjectStatisticsConfigLink.MesContractProjectStatisticsConfigLinkBuilder individualPriceSyncStartDate(
         final LocalDateTime individualPriceSyncStartDate
      ) {
         this.individualPriceSyncStartDate = individualPriceSyncStartDate;
         return this;
      }

      public MesContractProjectStatisticsConfigLink.MesContractProjectStatisticsConfigLinkBuilder individualPriceSyncEndDate(
         final LocalDateTime individualPriceSyncEndDate
      ) {
         this.individualPriceSyncEndDate = individualPriceSyncEndDate;
         return this;
      }

      public MesContractProjectStatisticsConfigLink build() {
         return new MesContractProjectStatisticsConfigLink(
            this.id,
            this.contractProjectId,
            this.statisticsMode,
            this.statisticsDeadline,
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
         return "MesContractProjectStatisticsConfigLink.MesContractProjectStatisticsConfigLinkBuilder(id="
            + this.id
            + ", contractProjectId="
            + this.contractProjectId
            + ", statisticsMode="
            + this.statisticsMode
            + ", statisticsDeadline="
            + this.statisticsDeadline
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
