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

@ApiModel(value = "MesContractProjectAssemblingWeldingConfigLink对象", description = "项目装焊配置关联表")
@Entity
@TableName("mes_contract_project_assembling_welding_config_link")
@Table(name = "mes_contract_project_assembling_welding_config_link")
@org.hibernate.annotations.Table(appliesTo = "mes_contract_project_assembling_welding_config_link", comment = "项目装焊配置关联表")
public class MesContractProjectAssemblingWeldingConfigLink extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "artifactTypeId", value = "构件类型ID", notes = "构件类型ID")
   @TableField("artifact_type_id")
   @Column(name = "artifact_type_id", columnDefinition = "bigint(20)  COMMENT '构件类型ID'", nullable = true)
   private Long artifactTypeId;
   @ApiModelProperty(name = "artifact", value = "构件", notes = "构件")
   @TableField("artifact")
   @Column(name = "artifact", columnDefinition = "varchar(500)  COMMENT '构件'", nullable = true)
   private String artifact;
   @ApiModelProperty(name = "process", value = "工序", notes = "工序")
   @TableField("process")
   @Column(name = "process", columnDefinition = "varchar(255)  COMMENT '工序'", nullable = true)
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

   public static MesContractProjectAssemblingWeldingConfigLink.MesContractProjectAssemblingWeldingConfigLinkBuilder builder() {
      return new MesContractProjectAssemblingWeldingConfigLink.MesContractProjectAssemblingWeldingConfigLinkBuilder();
   }

   public MesContractProjectAssemblingWeldingConfigLink() {
   }

   public MesContractProjectAssemblingWeldingConfigLink(
      final Long id,
      final Long contractProjectId,
      final Long artifactTypeId,
      final String artifact,
      final String process,
      final Integer measurementManner,
      final BigDecimal organizationInsidePrice,
      final BigDecimal organizationOutsidePrice
   ) {
      this.id = id;
      this.contractProjectId = contractProjectId;
      this.artifactTypeId = artifactTypeId;
      this.artifact = artifact;
      this.process = process;
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

   public Long getArtifactTypeId() {
      return this.artifactTypeId;
   }

   public String getArtifact() {
      return this.artifact;
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

   public MesContractProjectAssemblingWeldingConfigLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigLink setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigLink setArtifactTypeId(final Long artifactTypeId) {
      this.artifactTypeId = artifactTypeId;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigLink setArtifact(final String artifact) {
      this.artifact = artifact;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigLink setProcess(final String process) {
      this.process = process;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigLink setMeasurementManner(final Integer measurementManner) {
      this.measurementManner = measurementManner;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigLink setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
      return this;
   }

   public MesContractProjectAssemblingWeldingConfigLink setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesContractProjectAssemblingWeldingConfigLink(id="
         + this.getId()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", artifactTypeId="
         + this.getArtifactTypeId()
         + ", artifact="
         + this.getArtifact()
         + ", process="
         + this.getProcess()
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

      if (!(o instanceof MesContractProjectAssemblingWeldingConfigLink)) {
         return false;
      }

      MesContractProjectAssemblingWeldingConfigLink other = (MesContractProjectAssemblingWeldingConfigLink)o;
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
            Object this$artifactTypeId = this.getArtifactTypeId();
            Object other$artifactTypeId = other.getArtifactTypeId();
            if (this$artifactTypeId == null ? other$artifactTypeId == null : this$artifactTypeId.equals(other$artifactTypeId)) {
               Object this$measurementManner = this.getMeasurementManner();
               Object other$measurementManner = other.getMeasurementManner();
               if (this$measurementManner == null ? other$measurementManner == null : this$measurementManner.equals(other$measurementManner)) {
                  Object this$artifact = this.getArtifact();
                  Object other$artifact = other.getArtifact();
                  if (this$artifact == null ? other$artifact == null : this$artifact.equals(other$artifact)) {
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
      return other instanceof MesContractProjectAssemblingWeldingConfigLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $artifactTypeId = this.getArtifactTypeId();
      result = result * 59 + ($artifactTypeId == null ? 43 : $artifactTypeId.hashCode());
      Object $measurementManner = this.getMeasurementManner();
      result = result * 59 + ($measurementManner == null ? 43 : $measurementManner.hashCode());
      Object $artifact = this.getArtifact();
      result = result * 59 + ($artifact == null ? 43 : $artifact.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      return result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
   }

   public static class MesContractProjectAssemblingWeldingConfigLinkBuilder {
      private Long id;
      private Long contractProjectId;
      private Long artifactTypeId;
      private String artifact;
      private String process;
      private Integer measurementManner;
      private BigDecimal organizationInsidePrice;
      private BigDecimal organizationOutsidePrice;

      MesContractProjectAssemblingWeldingConfigLinkBuilder() {
      }

      public MesContractProjectAssemblingWeldingConfigLink.MesContractProjectAssemblingWeldingConfigLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigLink.MesContractProjectAssemblingWeldingConfigLinkBuilder contractProjectId(final Long contractProjectId) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigLink.MesContractProjectAssemblingWeldingConfigLinkBuilder artifactTypeId(final Long artifactTypeId) {
         this.artifactTypeId = artifactTypeId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigLink.MesContractProjectAssemblingWeldingConfigLinkBuilder artifact(final String artifact) {
         this.artifact = artifact;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigLink.MesContractProjectAssemblingWeldingConfigLinkBuilder process(final String process) {
         this.process = process;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigLink.MesContractProjectAssemblingWeldingConfigLinkBuilder measurementManner(
         final Integer measurementManner
      ) {
         this.measurementManner = measurementManner;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigLink.MesContractProjectAssemblingWeldingConfigLinkBuilder organizationInsidePrice(
         final BigDecimal organizationInsidePrice
      ) {
         this.organizationInsidePrice = organizationInsidePrice;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigLink.MesContractProjectAssemblingWeldingConfigLinkBuilder organizationOutsidePrice(
         final BigDecimal organizationOutsidePrice
      ) {
         this.organizationOutsidePrice = organizationOutsidePrice;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigLink build() {
         return new MesContractProjectAssemblingWeldingConfigLink(
            this.id,
            this.contractProjectId,
            this.artifactTypeId,
            this.artifact,
            this.process,
            this.measurementManner,
            this.organizationInsidePrice,
            this.organizationOutsidePrice
         );
      }

      @Override
      public String toString() {
         return "MesContractProjectAssemblingWeldingConfigLink.MesContractProjectAssemblingWeldingConfigLinkBuilder(id="
            + this.id
            + ", contractProjectId="
            + this.contractProjectId
            + ", artifactTypeId="
            + this.artifactTypeId
            + ", artifact="
            + this.artifact
            + ", process="
            + this.process
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
