package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "MesLayingOffConfig对象", description = "下料配置表")
@Entity
@TableName("mes_laying_off_config")
@Table(name = "mes_laying_off_config")
@org.hibernate.annotations.Table(appliesTo = "mes_laying_off_config", comment = "下料配置表")
public class MesLayingOffConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "machinePartType", value = "零件类型", notes = "零件类型")
   @TableField("machine_part_type")
   @Column(name = "machine_part_type", columnDefinition = "int(11)  COMMENT '零件类型'", nullable = true)
   private Integer machinePartType;
   @ApiModelProperty(name = "steelClassificationId", value = "零件类型分类ID", notes = "零件类型分类ID")
   @TableField("steel_classification_id")
   @Column(name = "steel_classification_id", columnDefinition = "bigint(20)  COMMENT '零件类型分类ID'", nullable = true)
   private Long steelClassificationId;
   @ApiModelProperty(name = "statisticsMode", value = "统计模式", notes = "统计模式")
   @TableField("statistics_mode")
   @Column(name = "statistics_mode", columnDefinition = "int(11)  COMMENT '统计模式'", nullable = true)
   private Integer statisticsMode;
   @ApiModelProperty(name = "boolFixedPrice", value = "是否一口价", notes = "是否一口价")
   @TableField("bool_fixed_price")
   @Column(name = "bool_fixed_price", columnDefinition = "tinyint(1)  COMMENT '是否一口价'", nullable = true)
   private Boolean boolFixedPrice;
   @ApiModelProperty(name = "process", value = "生产工序", notes = "生产工序")
   @TableField("process")
   @Column(name = "process", columnDefinition = "varchar(255)  COMMENT '生产工序'", nullable = true)
   private String process;
   @ApiModelProperty(name = "measurementManner", value = "计量方式", notes = "计量方式")
   @TableField("measurement_manner")
   @Column(name = "measurement_manner", columnDefinition = "int(11)  COMMENT '计量方式'", nullable = true)
   private Integer measurementManner;
   @ApiModelProperty(name = "organizationInsidePrice", value = "编制内单价(元)", notes = "编制内单价(元)")
   @TableField("organization_inside_price")
   @Column(name = "organization_inside_price", columnDefinition = "decimal(32,8)  COMMENT '编制内单价(元)'", nullable = true)
   private BigDecimal organizationInsidePrice;
   @ApiModelProperty(name = "organizationOutsidePrice", value = "编制外单价(元)", notes = "编制外单价(元)")
   @TableField("organization_outside_price")
   @Column(name = "organization_outside_price", columnDefinition = "decimal(32,8)  COMMENT '编制外单价(元)'", nullable = true)
   private BigDecimal organizationOutsidePrice;
   @ApiModelProperty(name = "statisticsConfigStatisticsMode", value = "统计配置统计模式", notes = "统计配置统计模式")
   @TableField("statistics_config_statistics_mode")
   @Column(name = "statistics_config_statistics_mode", columnDefinition = "int(11)  COMMENT '统计配置统计模式'", nullable = true)
   private Integer statisticsConfigStatisticsMode;

   public static MesLayingOffConfig.MesLayingOffConfigBuilder builder() {
      return new MesLayingOffConfig.MesLayingOffConfigBuilder();
   }

   public MesLayingOffConfig() {
   }

   public MesLayingOffConfig(
      final Long id,
      final Integer machinePartType,
      final Long steelClassificationId,
      final Integer statisticsMode,
      final Boolean boolFixedPrice,
      final String process,
      final Integer measurementManner,
      final BigDecimal organizationInsidePrice,
      final BigDecimal organizationOutsidePrice,
      final Integer statisticsConfigStatisticsMode
   ) {
      this.id = id;
      this.machinePartType = machinePartType;
      this.steelClassificationId = steelClassificationId;
      this.statisticsMode = statisticsMode;
      this.boolFixedPrice = boolFixedPrice;
      this.process = process;
      this.measurementManner = measurementManner;
      this.organizationInsidePrice = organizationInsidePrice;
      this.organizationOutsidePrice = organizationOutsidePrice;
      this.statisticsConfigStatisticsMode = statisticsConfigStatisticsMode;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getMachinePartType() {
      return this.machinePartType;
   }

   public Long getSteelClassificationId() {
      return this.steelClassificationId;
   }

   public Integer getStatisticsMode() {
      return this.statisticsMode;
   }

   public Boolean getBoolFixedPrice() {
      return this.boolFixedPrice;
   }

   public String getProcess() {
      return this.process;
   }

   public Integer getMeasurementManner() {
      return this.measurementManner;
   }

   public BigDecimal getOrganizationInsidePrice() {
      return this.organizationInsidePrice;
   }

   public BigDecimal getOrganizationOutsidePrice() {
      return this.organizationOutsidePrice;
   }

   public Integer getStatisticsConfigStatisticsMode() {
      return this.statisticsConfigStatisticsMode;
   }

   public MesLayingOffConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesLayingOffConfig setMachinePartType(final Integer machinePartType) {
      this.machinePartType = machinePartType;
      return this;
   }

   public MesLayingOffConfig setSteelClassificationId(final Long steelClassificationId) {
      this.steelClassificationId = steelClassificationId;
      return this;
   }

   public MesLayingOffConfig setStatisticsMode(final Integer statisticsMode) {
      this.statisticsMode = statisticsMode;
      return this;
   }

   public MesLayingOffConfig setBoolFixedPrice(final Boolean boolFixedPrice) {
      this.boolFixedPrice = boolFixedPrice;
      return this;
   }

   public MesLayingOffConfig setProcess(final String process) {
      this.process = process;
      return this;
   }

   public MesLayingOffConfig setMeasurementManner(final Integer measurementManner) {
      this.measurementManner = measurementManner;
      return this;
   }

   public MesLayingOffConfig setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
      return this;
   }

   public MesLayingOffConfig setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
      return this;
   }

   public MesLayingOffConfig setStatisticsConfigStatisticsMode(final Integer statisticsConfigStatisticsMode) {
      this.statisticsConfigStatisticsMode = statisticsConfigStatisticsMode;
      return this;
   }

   @Override
   public String toString() {
      return "MesLayingOffConfig(id="
         + this.getId()
         + ", machinePartType="
         + this.getMachinePartType()
         + ", steelClassificationId="
         + this.getSteelClassificationId()
         + ", statisticsMode="
         + this.getStatisticsMode()
         + ", boolFixedPrice="
         + this.getBoolFixedPrice()
         + ", process="
         + this.getProcess()
         + ", measurementManner="
         + this.getMeasurementManner()
         + ", organizationInsidePrice="
         + this.getOrganizationInsidePrice()
         + ", organizationOutsidePrice="
         + this.getOrganizationOutsidePrice()
         + ", statisticsConfigStatisticsMode="
         + this.getStatisticsConfigStatisticsMode()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesLayingOffConfig)) {
         return false;
      }

      MesLayingOffConfig other = (MesLayingOffConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$machinePartType = this.getMachinePartType();
         Object other$machinePartType = other.getMachinePartType();
         if (this$machinePartType == null ? other$machinePartType == null : this$machinePartType.equals(other$machinePartType)) {
            Object this$steelClassificationId = this.getSteelClassificationId();
            Object other$steelClassificationId = other.getSteelClassificationId();
            if (this$steelClassificationId == null ? other$steelClassificationId == null : this$steelClassificationId.equals(other$steelClassificationId)) {
               Object this$statisticsMode = this.getStatisticsMode();
               Object other$statisticsMode = other.getStatisticsMode();
               if (this$statisticsMode == null ? other$statisticsMode == null : this$statisticsMode.equals(other$statisticsMode)) {
                  Object this$boolFixedPrice = this.getBoolFixedPrice();
                  Object other$boolFixedPrice = other.getBoolFixedPrice();
                  if (this$boolFixedPrice == null ? other$boolFixedPrice == null : this$boolFixedPrice.equals(other$boolFixedPrice)) {
                     Object this$measurementManner = this.getMeasurementManner();
                     Object other$measurementManner = other.getMeasurementManner();
                     if (this$measurementManner == null ? other$measurementManner == null : this$measurementManner.equals(other$measurementManner)) {
                        Object this$statisticsConfigStatisticsMode = this.getStatisticsConfigStatisticsMode();
                        Object other$statisticsConfigStatisticsMode = other.getStatisticsConfigStatisticsMode();
                        if (this$statisticsConfigStatisticsMode == null
                           ? other$statisticsConfigStatisticsMode == null
                           : this$statisticsConfigStatisticsMode.equals(other$statisticsConfigStatisticsMode)) {
                           Object this$process = this.getProcess();
                           Object other$process = other.getProcess();
                           if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                              Object this$organizationInsidePrice = this.getOrganizationInsidePrice();
                              Object other$organizationInsidePrice = other.getOrganizationInsidePrice();
                              if (this$organizationInsidePrice == null
                                 ? other$organizationInsidePrice == null
                                 : this$organizationInsidePrice.equals(other$organizationInsidePrice)) {
                                 Object this$organizationOutsidePrice = this.getOrganizationOutsidePrice();
                                 Object other$organizationOutsidePrice = other.getOrganizationOutsidePrice();
                                 return this$organizationOutsidePrice == null
                                    ? other$organizationOutsidePrice == null
                                    : this$organizationOutsidePrice.equals(other$organizationOutsidePrice);
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
      return other instanceof MesLayingOffConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $machinePartType = this.getMachinePartType();
      result = result * 59 + ($machinePartType == null ? 43 : $machinePartType.hashCode());
      Object $steelClassificationId = this.getSteelClassificationId();
      result = result * 59 + ($steelClassificationId == null ? 43 : $steelClassificationId.hashCode());
      Object $statisticsMode = this.getStatisticsMode();
      result = result * 59 + ($statisticsMode == null ? 43 : $statisticsMode.hashCode());
      Object $boolFixedPrice = this.getBoolFixedPrice();
      result = result * 59 + ($boolFixedPrice == null ? 43 : $boolFixedPrice.hashCode());
      Object $measurementManner = this.getMeasurementManner();
      result = result * 59 + ($measurementManner == null ? 43 : $measurementManner.hashCode());
      Object $statisticsConfigStatisticsMode = this.getStatisticsConfigStatisticsMode();
      result = result * 59 + ($statisticsConfigStatisticsMode == null ? 43 : $statisticsConfigStatisticsMode.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      return result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
   }

   public static class MesLayingOffConfigBuilder {
      private Long id;
      private Integer machinePartType;
      private Long steelClassificationId;
      private Integer statisticsMode;
      private Boolean boolFixedPrice;
      private String process;
      private Integer measurementManner;
      private BigDecimal organizationInsidePrice;
      private BigDecimal organizationOutsidePrice;
      private Integer statisticsConfigStatisticsMode;

      MesLayingOffConfigBuilder() {
      }

      public MesLayingOffConfig.MesLayingOffConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesLayingOffConfig.MesLayingOffConfigBuilder machinePartType(final Integer machinePartType) {
         this.machinePartType = machinePartType;
         return this;
      }

      public MesLayingOffConfig.MesLayingOffConfigBuilder steelClassificationId(final Long steelClassificationId) {
         this.steelClassificationId = steelClassificationId;
         return this;
      }

      public MesLayingOffConfig.MesLayingOffConfigBuilder statisticsMode(final Integer statisticsMode) {
         this.statisticsMode = statisticsMode;
         return this;
      }

      public MesLayingOffConfig.MesLayingOffConfigBuilder boolFixedPrice(final Boolean boolFixedPrice) {
         this.boolFixedPrice = boolFixedPrice;
         return this;
      }

      public MesLayingOffConfig.MesLayingOffConfigBuilder process(final String process) {
         this.process = process;
         return this;
      }

      public MesLayingOffConfig.MesLayingOffConfigBuilder measurementManner(final Integer measurementManner) {
         this.measurementManner = measurementManner;
         return this;
      }

      public MesLayingOffConfig.MesLayingOffConfigBuilder organizationInsidePrice(final BigDecimal organizationInsidePrice) {
         this.organizationInsidePrice = organizationInsidePrice;
         return this;
      }

      public MesLayingOffConfig.MesLayingOffConfigBuilder organizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
         this.organizationOutsidePrice = organizationOutsidePrice;
         return this;
      }

      public MesLayingOffConfig.MesLayingOffConfigBuilder statisticsConfigStatisticsMode(final Integer statisticsConfigStatisticsMode) {
         this.statisticsConfigStatisticsMode = statisticsConfigStatisticsMode;
         return this;
      }

      public MesLayingOffConfig build() {
         return new MesLayingOffConfig(
            this.id,
            this.machinePartType,
            this.steelClassificationId,
            this.statisticsMode,
            this.boolFixedPrice,
            this.process,
            this.measurementManner,
            this.organizationInsidePrice,
            this.organizationOutsidePrice,
            this.statisticsConfigStatisticsMode
         );
      }

      @Override
      public String toString() {
         return "MesLayingOffConfig.MesLayingOffConfigBuilder(id="
            + this.id
            + ", machinePartType="
            + this.machinePartType
            + ", steelClassificationId="
            + this.steelClassificationId
            + ", statisticsMode="
            + this.statisticsMode
            + ", boolFixedPrice="
            + this.boolFixedPrice
            + ", process="
            + this.process
            + ", measurementManner="
            + this.measurementManner
            + ", organizationInsidePrice="
            + this.organizationInsidePrice
            + ", organizationOutsidePrice="
            + this.organizationOutsidePrice
            + ", statisticsConfigStatisticsMode="
            + this.statisticsConfigStatisticsMode
            + ")";
      }
   }
}
