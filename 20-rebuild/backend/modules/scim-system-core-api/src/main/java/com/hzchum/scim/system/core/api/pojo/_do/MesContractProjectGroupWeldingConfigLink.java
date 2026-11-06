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

@ApiModel(value = "MesContractProjectGroupWeldingConfigLink对象", description = "项目组焊配置关联表")
@Entity
@TableName("mes_contract_project_group_welding_config_link")
@Table(name = "mes_contract_project_group_welding_config_link")
@org.hibernate.annotations.Table(appliesTo = "mes_contract_project_group_welding_config_link", comment = "项目组焊配置关联表")
public class MesContractProjectGroupWeldingConfigLink extends BaseEntity<Long> {
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

   public static MesContractProjectGroupWeldingConfigLink.MesContractProjectGroupWeldingConfigLinkBuilder builder() {
      return new MesContractProjectGroupWeldingConfigLink.MesContractProjectGroupWeldingConfigLinkBuilder();
   }

   public MesContractProjectGroupWeldingConfigLink() {
   }

   public MesContractProjectGroupWeldingConfigLink(
      final Long id,
      final Long contractProjectId,
      final Long assembleConfigId,
      final String process,
      final Integer statisticsMode,
      final Integer measurementManner,
      final BigDecimal organizationInsidePrice,
      final BigDecimal organizationOutsidePrice
   ) {
      this.id = id;
      this.contractProjectId = contractProjectId;
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

   public Long getContractProjectId() {
      return this.contractProjectId;
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

   public MesContractProjectGroupWeldingConfigLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesContractProjectGroupWeldingConfigLink setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
      return this;
   }

   public MesContractProjectGroupWeldingConfigLink setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
      return this;
   }

   public MesContractProjectGroupWeldingConfigLink setProcess(final String process) {
      this.process = process;
      return this;
   }

   public MesContractProjectGroupWeldingConfigLink setStatisticsMode(final Integer statisticsMode) {
      this.statisticsMode = statisticsMode;
      return this;
   }

   public MesContractProjectGroupWeldingConfigLink setMeasurementManner(final Integer measurementManner) {
      this.measurementManner = measurementManner;
      return this;
   }

   public MesContractProjectGroupWeldingConfigLink setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
      return this;
   }

   public MesContractProjectGroupWeldingConfigLink setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesContractProjectGroupWeldingConfigLink(id="
         + this.getId()
         + ", contractProjectId="
         + this.getContractProjectId()
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

      if (!(o instanceof MesContractProjectGroupWeldingConfigLink)) {
         return false;
      }

      MesContractProjectGroupWeldingConfigLink other = (MesContractProjectGroupWeldingConfigLink)o;
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesContractProjectGroupWeldingConfigLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
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

   public static class MesContractProjectGroupWeldingConfigLinkBuilder {
      private Long id;
      private Long contractProjectId;
      private Long assembleConfigId;
      private String process;
      private Integer statisticsMode;
      private Integer measurementManner;
      private BigDecimal organizationInsidePrice;
      private BigDecimal organizationOutsidePrice;

      MesContractProjectGroupWeldingConfigLinkBuilder() {
      }

      public MesContractProjectGroupWeldingConfigLink.MesContractProjectGroupWeldingConfigLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesContractProjectGroupWeldingConfigLink.MesContractProjectGroupWeldingConfigLinkBuilder contractProjectId(final Long contractProjectId) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesContractProjectGroupWeldingConfigLink.MesContractProjectGroupWeldingConfigLinkBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      public MesContractProjectGroupWeldingConfigLink.MesContractProjectGroupWeldingConfigLinkBuilder process(final String process) {
         this.process = process;
         return this;
      }

      public MesContractProjectGroupWeldingConfigLink.MesContractProjectGroupWeldingConfigLinkBuilder statisticsMode(final Integer statisticsMode) {
         this.statisticsMode = statisticsMode;
         return this;
      }

      public MesContractProjectGroupWeldingConfigLink.MesContractProjectGroupWeldingConfigLinkBuilder measurementManner(final Integer measurementManner) {
         this.measurementManner = measurementManner;
         return this;
      }

      public MesContractProjectGroupWeldingConfigLink.MesContractProjectGroupWeldingConfigLinkBuilder organizationInsidePrice(
         final BigDecimal organizationInsidePrice
      ) {
         this.organizationInsidePrice = organizationInsidePrice;
         return this;
      }

      public MesContractProjectGroupWeldingConfigLink.MesContractProjectGroupWeldingConfigLinkBuilder organizationOutsidePrice(
         final BigDecimal organizationOutsidePrice
      ) {
         this.organizationOutsidePrice = organizationOutsidePrice;
         return this;
      }

      public MesContractProjectGroupWeldingConfigLink build() {
         return new MesContractProjectGroupWeldingConfigLink(
            this.id,
            this.contractProjectId,
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
         return "MesContractProjectGroupWeldingConfigLink.MesContractProjectGroupWeldingConfigLinkBuilder(id="
            + this.id
            + ", contractProjectId="
            + this.contractProjectId
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
