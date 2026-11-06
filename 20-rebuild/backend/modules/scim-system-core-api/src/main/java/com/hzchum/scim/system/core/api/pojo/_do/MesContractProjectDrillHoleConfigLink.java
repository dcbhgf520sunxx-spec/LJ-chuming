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

@ApiModel(value = "MesContractProjectDrillHoleConfigLink对象", description = "项目钻孔配置关联表")
@Entity
@TableName("mes_contract_project_drill_hole_config_link")
@Table(name = "mes_contract_project_drill_hole_config_link")
@org.hibernate.annotations.Table(appliesTo = "mes_contract_project_drill_hole_config_link", comment = "项目钻孔配置关联表")
public class MesContractProjectDrillHoleConfigLink extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "process", value = "生产工序", notes = "生产工序")
   @TableField("process")
   @Column(name = "process", columnDefinition = "varchar(255)  COMMENT '生产工序'", nullable = true)
   private String process;
   @ApiModelProperty(name = "pricingManner", value = "计价方式", notes = "计价方式")
   @TableField("pricing_manner")
   @Column(name = "pricing_manner", columnDefinition = "int(11)  COMMENT '计价方式'", nullable = true)
   private Integer pricingManner;
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
   @ApiModelProperty(name = "fixedPrice", value = "一口价(元)", notes = "一口价(元)")
   @TableField("fixed_price")
   @Column(name = "fixed_price", columnDefinition = "decimal(32,8)  COMMENT '一口价(元)'", nullable = true)
   private BigDecimal fixedPrice;
   @ApiModelProperty(name = "statisticsConfigStatisticsMode", value = "统计配置统计模式", notes = "统计配置统计模式")
   @TableField("statistics_config_statistics_mode")
   @Column(name = "statistics_config_statistics_mode", columnDefinition = "int(11)  COMMENT '统计配置统计模式'", nullable = true)
   private Integer statisticsConfigStatisticsMode;

   public static MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder builder() {
      return new MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder();
   }

   public MesContractProjectDrillHoleConfigLink() {
   }

   public MesContractProjectDrillHoleConfigLink(
      final Long id,
      final Long contractProjectId,
      final Integer machinePartType,
      final Long steelClassificationId,
      final Integer statisticsMode,
      final String process,
      final Integer pricingManner,
      final Integer measurementManner,
      final BigDecimal organizationInsidePrice,
      final BigDecimal organizationOutsidePrice,
      final BigDecimal fixedPrice,
      final Integer statisticsConfigStatisticsMode
   ) {
      this.id = id;
      this.contractProjectId = contractProjectId;
      this.machinePartType = machinePartType;
      this.steelClassificationId = steelClassificationId;
      this.statisticsMode = statisticsMode;
      this.process = process;
      this.pricingManner = pricingManner;
      this.measurementManner = measurementManner;
      this.organizationInsidePrice = organizationInsidePrice;
      this.organizationOutsidePrice = organizationOutsidePrice;
      this.fixedPrice = fixedPrice;
      this.statisticsConfigStatisticsMode = statisticsConfigStatisticsMode;
   }

   public Long getId() {
      return this.id;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
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

   public String getProcess() {
      return this.process;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
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

   public BigDecimal getFixedPrice() {
      return this.fixedPrice;
   }

   public Integer getStatisticsConfigStatisticsMode() {
      return this.statisticsConfigStatisticsMode;
   }

   public MesContractProjectDrillHoleConfigLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesContractProjectDrillHoleConfigLink setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
      return this;
   }

   public MesContractProjectDrillHoleConfigLink setMachinePartType(final Integer machinePartType) {
      this.machinePartType = machinePartType;
      return this;
   }

   public MesContractProjectDrillHoleConfigLink setSteelClassificationId(final Long steelClassificationId) {
      this.steelClassificationId = steelClassificationId;
      return this;
   }

   public MesContractProjectDrillHoleConfigLink setStatisticsMode(final Integer statisticsMode) {
      this.statisticsMode = statisticsMode;
      return this;
   }

   public MesContractProjectDrillHoleConfigLink setProcess(final String process) {
      this.process = process;
      return this;
   }

   public MesContractProjectDrillHoleConfigLink setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
      return this;
   }

   public MesContractProjectDrillHoleConfigLink setMeasurementManner(final Integer measurementManner) {
      this.measurementManner = measurementManner;
      return this;
   }

   public MesContractProjectDrillHoleConfigLink setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
      return this;
   }

   public MesContractProjectDrillHoleConfigLink setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
      return this;
   }

   public MesContractProjectDrillHoleConfigLink setFixedPrice(final BigDecimal fixedPrice) {
      this.fixedPrice = fixedPrice;
      return this;
   }

   public MesContractProjectDrillHoleConfigLink setStatisticsConfigStatisticsMode(final Integer statisticsConfigStatisticsMode) {
      this.statisticsConfigStatisticsMode = statisticsConfigStatisticsMode;
      return this;
   }

   @Override
   public String toString() {
      return "MesContractProjectDrillHoleConfigLink(id="
         + this.getId()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", machinePartType="
         + this.getMachinePartType()
         + ", steelClassificationId="
         + this.getSteelClassificationId()
         + ", statisticsMode="
         + this.getStatisticsMode()
         + ", process="
         + this.getProcess()
         + ", pricingManner="
         + this.getPricingManner()
         + ", measurementManner="
         + this.getMeasurementManner()
         + ", organizationInsidePrice="
         + this.getOrganizationInsidePrice()
         + ", organizationOutsidePrice="
         + this.getOrganizationOutsidePrice()
         + ", fixedPrice="
         + this.getFixedPrice()
         + ", statisticsConfigStatisticsMode="
         + this.getStatisticsConfigStatisticsMode()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectDrillHoleConfigLink)) {
         return false;
      }

      MesContractProjectDrillHoleConfigLink other = (MesContractProjectDrillHoleConfigLink)o;
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
            Object this$machinePartType = this.getMachinePartType();
            Object other$machinePartType = other.getMachinePartType();
            if (this$machinePartType == null ? other$machinePartType == null : this$machinePartType.equals(other$machinePartType)) {
               Object this$steelClassificationId = this.getSteelClassificationId();
               Object other$steelClassificationId = other.getSteelClassificationId();
               if (this$steelClassificationId == null ? other$steelClassificationId == null : this$steelClassificationId.equals(other$steelClassificationId)) {
                  Object this$statisticsMode = this.getStatisticsMode();
                  Object other$statisticsMode = other.getStatisticsMode();
                  if (this$statisticsMode == null ? other$statisticsMode == null : this$statisticsMode.equals(other$statisticsMode)) {
                     Object this$pricingManner = this.getPricingManner();
                     Object other$pricingManner = other.getPricingManner();
                     if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
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
                                    if (this$organizationOutsidePrice == null
                                       ? other$organizationOutsidePrice == null
                                       : this$organizationOutsidePrice.equals(other$organizationOutsidePrice)) {
                                       Object this$fixedPrice = this.getFixedPrice();
                                       Object other$fixedPrice = other.getFixedPrice();
                                       return this$fixedPrice == null ? other$fixedPrice == null : this$fixedPrice.equals(other$fixedPrice);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesContractProjectDrillHoleConfigLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $machinePartType = this.getMachinePartType();
      result = result * 59 + ($machinePartType == null ? 43 : $machinePartType.hashCode());
      Object $steelClassificationId = this.getSteelClassificationId();
      result = result * 59 + ($steelClassificationId == null ? 43 : $steelClassificationId.hashCode());
      Object $statisticsMode = this.getStatisticsMode();
      result = result * 59 + ($statisticsMode == null ? 43 : $statisticsMode.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $measurementManner = this.getMeasurementManner();
      result = result * 59 + ($measurementManner == null ? 43 : $measurementManner.hashCode());
      Object $statisticsConfigStatisticsMode = this.getStatisticsConfigStatisticsMode();
      result = result * 59 + ($statisticsConfigStatisticsMode == null ? 43 : $statisticsConfigStatisticsMode.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      result = result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
      Object $fixedPrice = this.getFixedPrice();
      return result * 59 + ($fixedPrice == null ? 43 : $fixedPrice.hashCode());
   }

   public static class MesContractProjectDrillHoleConfigLinkBuilder {
      private Long id;
      private Long contractProjectId;
      private Integer machinePartType;
      private Long steelClassificationId;
      private Integer statisticsMode;
      private String process;
      private Integer pricingManner;
      private Integer measurementManner;
      private BigDecimal organizationInsidePrice;
      private BigDecimal organizationOutsidePrice;
      private BigDecimal fixedPrice;
      private Integer statisticsConfigStatisticsMode;

      MesContractProjectDrillHoleConfigLinkBuilder() {
      }

      public MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder contractProjectId(final Long contractProjectId) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder machinePartType(final Integer machinePartType) {
         this.machinePartType = machinePartType;
         return this;
      }

      public MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder steelClassificationId(final Long steelClassificationId) {
         this.steelClassificationId = steelClassificationId;
         return this;
      }

      public MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder statisticsMode(final Integer statisticsMode) {
         this.statisticsMode = statisticsMode;
         return this;
      }

      public MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder process(final String process) {
         this.process = process;
         return this;
      }

      public MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder measurementManner(final Integer measurementManner) {
         this.measurementManner = measurementManner;
         return this;
      }

      public MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder organizationInsidePrice(
         final BigDecimal organizationInsidePrice
      ) {
         this.organizationInsidePrice = organizationInsidePrice;
         return this;
      }

      public MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder organizationOutsidePrice(
         final BigDecimal organizationOutsidePrice
      ) {
         this.organizationOutsidePrice = organizationOutsidePrice;
         return this;
      }

      public MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder fixedPrice(final BigDecimal fixedPrice) {
         this.fixedPrice = fixedPrice;
         return this;
      }

      public MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder statisticsConfigStatisticsMode(
         final Integer statisticsConfigStatisticsMode
      ) {
         this.statisticsConfigStatisticsMode = statisticsConfigStatisticsMode;
         return this;
      }

      public MesContractProjectDrillHoleConfigLink build() {
         return new MesContractProjectDrillHoleConfigLink(
            this.id,
            this.contractProjectId,
            this.machinePartType,
            this.steelClassificationId,
            this.statisticsMode,
            this.process,
            this.pricingManner,
            this.measurementManner,
            this.organizationInsidePrice,
            this.organizationOutsidePrice,
            this.fixedPrice,
            this.statisticsConfigStatisticsMode
         );
      }

      @Override
      public String toString() {
         return "MesContractProjectDrillHoleConfigLink.MesContractProjectDrillHoleConfigLinkBuilder(id="
            + this.id
            + ", contractProjectId="
            + this.contractProjectId
            + ", machinePartType="
            + this.machinePartType
            + ", steelClassificationId="
            + this.steelClassificationId
            + ", statisticsMode="
            + this.statisticsMode
            + ", process="
            + this.process
            + ", pricingManner="
            + this.pricingManner
            + ", measurementManner="
            + this.measurementManner
            + ", organizationInsidePrice="
            + this.organizationInsidePrice
            + ", organizationOutsidePrice="
            + this.organizationOutsidePrice
            + ", fixedPrice="
            + this.fixedPrice
            + ", statisticsConfigStatisticsMode="
            + this.statisticsConfigStatisticsMode
            + ")";
      }
   }
}
