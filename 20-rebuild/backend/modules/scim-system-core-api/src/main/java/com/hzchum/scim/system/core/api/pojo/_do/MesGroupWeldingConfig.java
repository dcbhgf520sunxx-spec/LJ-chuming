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

@ApiModel(value = "MesGroupWeldingConfig对象", description = "组焊配置表")
@Entity
@TableName("mes_group_welding_config")
@Table(name = "mes_group_welding_config")
@org.hibernate.annotations.Table(appliesTo = "mes_group_welding_config", comment = "组焊配置表")
public class MesGroupWeldingConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "assembleConfigId", value = "部件类型ID", notes = "部件类型ID")
   @TableField("assemble_config_id")
   @Column(name = "assemble_config_id", columnDefinition = "bigint(20)  COMMENT '部件类型ID'", nullable = true)
   private Long assembleConfigId;
   @ApiModelProperty(name = "process", value = "生产工序", notes = "生产工序")
   @TableField("process")
   @Column(name = "process", columnDefinition = "varchar(255)  COMMENT '生产工序'", nullable = true)
   private String process;
   @ApiModelProperty(name = "statisticsMode", value = "统计模式", notes = "统计模式")
   @TableField("statistics_mode")
   @Column(name = "statistics_mode", columnDefinition = "int(11)  COMMENT '统计模式'", nullable = true)
   private Integer statisticsMode;
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

   public static MesGroupWeldingConfig.MesGroupWeldingConfigBuilder builder() {
      return new MesGroupWeldingConfig.MesGroupWeldingConfigBuilder();
   }

   public MesGroupWeldingConfig() {
   }

   public MesGroupWeldingConfig(
      final Long id,
      final Long assembleConfigId,
      final String process,
      final Integer statisticsMode,
      final Integer measurementManner,
      final BigDecimal organizationInsidePrice,
      final BigDecimal organizationOutsidePrice
   ) {
      this.id = id;
      this.assembleConfigId = assembleConfigId;
      this.process = process;
      this.statisticsMode = statisticsMode;
      this.measurementManner = measurementManner;
      this.organizationInsidePrice = organizationInsidePrice;
      this.organizationOutsidePrice = organizationOutsidePrice;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public String getProcess() {
      return this.process;
   }

   public Integer getStatisticsMode() {
      return this.statisticsMode;
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

   public MesGroupWeldingConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesGroupWeldingConfig setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
      return this;
   }

   public MesGroupWeldingConfig setProcess(final String process) {
      this.process = process;
      return this;
   }

   public MesGroupWeldingConfig setStatisticsMode(final Integer statisticsMode) {
      this.statisticsMode = statisticsMode;
      return this;
   }

   public MesGroupWeldingConfig setMeasurementManner(final Integer measurementManner) {
      this.measurementManner = measurementManner;
      return this;
   }

   public MesGroupWeldingConfig setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
      return this;
   }

   public MesGroupWeldingConfig setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesGroupWeldingConfig(id="
         + this.getId()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", process="
         + this.getProcess()
         + ", statisticsMode="
         + this.getStatisticsMode()
         + ", measurementManner="
         + this.getMeasurementManner()
         + ", organizationInsidePrice="
         + this.getOrganizationInsidePrice()
         + ", organizationOutsidePrice="
         + this.getOrganizationOutsidePrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesGroupWeldingConfig)) {
         return false;
      }

      MesGroupWeldingConfig other = (MesGroupWeldingConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assembleConfigId = this.getAssembleConfigId();
         Object other$assembleConfigId = other.getAssembleConfigId();
         if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
            Object this$statisticsMode = this.getStatisticsMode();
            Object other$statisticsMode = other.getStatisticsMode();
            if (this$statisticsMode == null ? other$statisticsMode == null : this$statisticsMode.equals(other$statisticsMode)) {
               Object this$measurementManner = this.getMeasurementManner();
               Object other$measurementManner = other.getMeasurementManner();
               if (this$measurementManner == null ? other$measurementManner == null : this$measurementManner.equals(other$measurementManner)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesGroupWeldingConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $statisticsMode = this.getStatisticsMode();
      result = result * 59 + ($statisticsMode == null ? 43 : $statisticsMode.hashCode());
      Object $measurementManner = this.getMeasurementManner();
      result = result * 59 + ($measurementManner == null ? 43 : $measurementManner.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      return result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
   }

   public static class MesGroupWeldingConfigBuilder {
      private Long id;
      private Long assembleConfigId;
      private String process;
      private Integer statisticsMode;
      private Integer measurementManner;
      private BigDecimal organizationInsidePrice;
      private BigDecimal organizationOutsidePrice;

      MesGroupWeldingConfigBuilder() {
      }

      public MesGroupWeldingConfig.MesGroupWeldingConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesGroupWeldingConfig.MesGroupWeldingConfigBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      public MesGroupWeldingConfig.MesGroupWeldingConfigBuilder process(final String process) {
         this.process = process;
         return this;
      }

      public MesGroupWeldingConfig.MesGroupWeldingConfigBuilder statisticsMode(final Integer statisticsMode) {
         this.statisticsMode = statisticsMode;
         return this;
      }

      public MesGroupWeldingConfig.MesGroupWeldingConfigBuilder measurementManner(final Integer measurementManner) {
         this.measurementManner = measurementManner;
         return this;
      }

      public MesGroupWeldingConfig.MesGroupWeldingConfigBuilder organizationInsidePrice(final BigDecimal organizationInsidePrice) {
         this.organizationInsidePrice = organizationInsidePrice;
         return this;
      }

      public MesGroupWeldingConfig.MesGroupWeldingConfigBuilder organizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
         this.organizationOutsidePrice = organizationOutsidePrice;
         return this;
      }

      public MesGroupWeldingConfig build() {
         return new MesGroupWeldingConfig(
            this.id,
            this.assembleConfigId,
            this.process,
            this.statisticsMode,
            this.measurementManner,
            this.organizationInsidePrice,
            this.organizationOutsidePrice
         );
      }

      @Override
      public String toString() {
         return "MesGroupWeldingConfig.MesGroupWeldingConfigBuilder(id="
            + this.id
            + ", assembleConfigId="
            + this.assembleConfigId
            + ", process="
            + this.process
            + ", statisticsMode="
            + this.statisticsMode
            + ", measurementManner="
            + this.measurementManner
            + ", organizationInsidePrice="
            + this.organizationInsidePrice
            + ", organizationOutsidePrice="
            + this.organizationOutsidePrice
            + ")";
      }
   }
}
