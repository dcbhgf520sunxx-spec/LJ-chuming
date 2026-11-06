package com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config;

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

@ApiModel(value = "MesQuotaConfigAssemble对象", description = "定额配置部件表")
@Entity
@TableName("mes_quota_config_assemble")
@Table(name = "mes_quota_config_assemble")
@org.hibernate.annotations.Table(appliesTo = "mes_quota_config_assemble", comment = "定额配置部件表")
public class MesQuotaConfigAssemble extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("定额编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255) COMMENT '定额编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty("机构ids")
   @TableField("branch_company_ids")
   @Column(name = "branch_company_ids", columnDefinition = "varchar(255) COMMENT '机构ids'", nullable = true)
   private String branchCompanyIds;
   @ApiModelProperty("车间ids")
   @TableField("workshop_ids")
   @Column(name = "workshop_ids", columnDefinition = "varchar(255) COMMENT '车间ids'", nullable = true)
   private String workshopIds;
   @ApiModelProperty("部件种类ids")
   @TableField("assemble_class_ids")
   @Column(name = "assemble_class_ids", columnDefinition = "varchar(500) COMMENT '部件种类ids'", nullable = true)
   private String assembleClassIds;
   @ApiModelProperty("工序id")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20) COMMENT '工序id'", nullable = true)
   private Long processId;
   @ApiModelProperty("计量单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(255) COMMENT '计量单位'", nullable = true)
   private String measureUnit;
   @ApiModelProperty("定额类型(1:恒量定额, 2:变量定额)")
   @TableField("quota_type")
   @Column(name = "quota_type", columnDefinition = "int(11) COMMENT '定额类型(1:恒量定额, 2:变量定额)'", nullable = true)
   private Integer quotaType;
   @ApiModelProperty("编制内单价(元)")
   @TableField("organization_inside_price")
   @Column(name = "organization_inside_price", columnDefinition = "decimal(32,8)  COMMENT '编制内单价(元)'", nullable = true)
   private BigDecimal organizationInsidePrice;
   @ApiModelProperty("编制外单价(元)")
   @TableField("organization_outside_price")
   @Column(name = "organization_outside_price", columnDefinition = "decimal(32,8)  COMMENT '编制外单价(元)'", nullable = true)
   private BigDecimal organizationOutsidePrice;

   public static MesQuotaConfigAssemble.MesQuotaConfigAssembleBuilder builder() {
      return new MesQuotaConfigAssemble.MesQuotaConfigAssembleBuilder();
   }

   public MesQuotaConfigAssemble() {
   }

   public MesQuotaConfigAssemble(
      final Long id,
      final String serialNumber,
      final String branchCompanyIds,
      final String workshopIds,
      final String assembleClassIds,
      final Long processId,
      final String measureUnit,
      final Integer quotaType,
      final BigDecimal organizationInsidePrice,
      final BigDecimal organizationOutsidePrice
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.branchCompanyIds = branchCompanyIds;
      this.workshopIds = workshopIds;
      this.assembleClassIds = assembleClassIds;
      this.processId = processId;
      this.measureUnit = measureUnit;
      this.quotaType = quotaType;
      this.organizationInsidePrice = organizationInsidePrice;
      this.organizationOutsidePrice = organizationOutsidePrice;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getBranchCompanyIds() {
      return this.branchCompanyIds;
   }

   public String getWorkshopIds() {
      return this.workshopIds;
   }

   public String getAssembleClassIds() {
      return this.assembleClassIds;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getQuotaType() {
      return this.quotaType;
   }

   public BigDecimal getOrganizationInsidePrice() {
      return this.organizationInsidePrice;
   }

   public BigDecimal getOrganizationOutsidePrice() {
      return this.organizationOutsidePrice;
   }

   public MesQuotaConfigAssemble setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesQuotaConfigAssemble setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesQuotaConfigAssemble setBranchCompanyIds(final String branchCompanyIds) {
      this.branchCompanyIds = branchCompanyIds;
      return this;
   }

   public MesQuotaConfigAssemble setWorkshopIds(final String workshopIds) {
      this.workshopIds = workshopIds;
      return this;
   }

   public MesQuotaConfigAssemble setAssembleClassIds(final String assembleClassIds) {
      this.assembleClassIds = assembleClassIds;
      return this;
   }

   public MesQuotaConfigAssemble setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesQuotaConfigAssemble setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public MesQuotaConfigAssemble setQuotaType(final Integer quotaType) {
      this.quotaType = quotaType;
      return this;
   }

   public MesQuotaConfigAssemble setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
      return this;
   }

   public MesQuotaConfigAssemble setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesQuotaConfigAssemble(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", branchCompanyIds="
         + this.getBranchCompanyIds()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", assembleClassIds="
         + this.getAssembleClassIds()
         + ", processId="
         + this.getProcessId()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", quotaType="
         + this.getQuotaType()
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

      if (!(o instanceof MesQuotaConfigAssemble)) {
         return false;
      }

      MesQuotaConfigAssemble other = (MesQuotaConfigAssemble)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$quotaType = this.getQuotaType();
            Object other$quotaType = other.getQuotaType();
            if (this$quotaType == null ? other$quotaType == null : this$quotaType.equals(other$quotaType)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$branchCompanyIds = this.getBranchCompanyIds();
                  Object other$branchCompanyIds = other.getBranchCompanyIds();
                  if (this$branchCompanyIds == null ? other$branchCompanyIds == null : this$branchCompanyIds.equals(other$branchCompanyIds)) {
                     Object this$workshopIds = this.getWorkshopIds();
                     Object other$workshopIds = other.getWorkshopIds();
                     if (this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds)) {
                        Object this$assembleClassIds = this.getAssembleClassIds();
                        Object other$assembleClassIds = other.getAssembleClassIds();
                        if (this$assembleClassIds == null ? other$assembleClassIds == null : this$assembleClassIds.equals(other$assembleClassIds)) {
                           Object this$measureUnit = this.getMeasureUnit();
                           Object other$measureUnit = other.getMeasureUnit();
                           if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
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
      return other instanceof MesQuotaConfigAssemble;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $quotaType = this.getQuotaType();
      result = result * 59 + ($quotaType == null ? 43 : $quotaType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $branchCompanyIds = this.getBranchCompanyIds();
      result = result * 59 + ($branchCompanyIds == null ? 43 : $branchCompanyIds.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      result = result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
      Object $assembleClassIds = this.getAssembleClassIds();
      result = result * 59 + ($assembleClassIds == null ? 43 : $assembleClassIds.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      return result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
   }

   public static class MesQuotaConfigAssembleBuilder {
      private Long id;
      private String serialNumber;
      private String branchCompanyIds;
      private String workshopIds;
      private String assembleClassIds;
      private Long processId;
      private String measureUnit;
      private Integer quotaType;
      private BigDecimal organizationInsidePrice;
      private BigDecimal organizationOutsidePrice;

      MesQuotaConfigAssembleBuilder() {
      }

      public MesQuotaConfigAssemble.MesQuotaConfigAssembleBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesQuotaConfigAssemble.MesQuotaConfigAssembleBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesQuotaConfigAssemble.MesQuotaConfigAssembleBuilder branchCompanyIds(final String branchCompanyIds) {
         this.branchCompanyIds = branchCompanyIds;
         return this;
      }

      public MesQuotaConfigAssemble.MesQuotaConfigAssembleBuilder workshopIds(final String workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public MesQuotaConfigAssemble.MesQuotaConfigAssembleBuilder assembleClassIds(final String assembleClassIds) {
         this.assembleClassIds = assembleClassIds;
         return this;
      }

      public MesQuotaConfigAssemble.MesQuotaConfigAssembleBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesQuotaConfigAssemble.MesQuotaConfigAssembleBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public MesQuotaConfigAssemble.MesQuotaConfigAssembleBuilder quotaType(final Integer quotaType) {
         this.quotaType = quotaType;
         return this;
      }

      public MesQuotaConfigAssemble.MesQuotaConfigAssembleBuilder organizationInsidePrice(final BigDecimal organizationInsidePrice) {
         this.organizationInsidePrice = organizationInsidePrice;
         return this;
      }

      public MesQuotaConfigAssemble.MesQuotaConfigAssembleBuilder organizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
         this.organizationOutsidePrice = organizationOutsidePrice;
         return this;
      }

      public MesQuotaConfigAssemble build() {
         return new MesQuotaConfigAssemble(
            this.id,
            this.serialNumber,
            this.branchCompanyIds,
            this.workshopIds,
            this.assembleClassIds,
            this.processId,
            this.measureUnit,
            this.quotaType,
            this.organizationInsidePrice,
            this.organizationOutsidePrice
         );
      }

      @Override
      public String toString() {
         return "MesQuotaConfigAssemble.MesQuotaConfigAssembleBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", branchCompanyIds="
            + this.branchCompanyIds
            + ", workshopIds="
            + this.workshopIds
            + ", assembleClassIds="
            + this.assembleClassIds
            + ", processId="
            + this.processId
            + ", measureUnit="
            + this.measureUnit
            + ", quotaType="
            + this.quotaType
            + ", organizationInsidePrice="
            + this.organizationInsidePrice
            + ", organizationOutsidePrice="
            + this.organizationOutsidePrice
            + ")";
      }
   }
}
