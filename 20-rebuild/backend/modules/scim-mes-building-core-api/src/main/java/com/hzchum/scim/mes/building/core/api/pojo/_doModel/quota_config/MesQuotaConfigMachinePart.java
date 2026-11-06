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

@ApiModel(value = "MesQuotaConfigMachinePart对象", description = "定额配置零件表")
@Entity
@TableName(value = "mes_quota_config_machine_part", autoResultMap = true)
@Table(name = "mes_quota_config_machine_part")
@org.hibernate.annotations.Table(appliesTo = "mes_quota_config_machine_part", comment = "定额配置零件表")
public class MesQuotaConfigMachinePart extends BaseEntity<Long> {
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
   @ApiModelProperty("产品分类(4:型材, 8:板材)")
   @TableField("product_classification_enum")
   @Column(name = "product_classification_enum", columnDefinition = "int(11) COMMENT '产品分类(1:主构件, 2:次构件)'", nullable = true)
   private Integer productClassificationEnum;
   @ApiModelProperty("零件种类ids")
   @TableField("machine_part_class_ids")
   @Column(name = "machine_part_class_ids", columnDefinition = "varchar(500) COMMENT '零件种类ids'", nullable = true)
   private String machinePartClassIds;
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

   public static MesQuotaConfigMachinePart.MesQuotaConfigMachinePartBuilder builder() {
      return new MesQuotaConfigMachinePart.MesQuotaConfigMachinePartBuilder();
   }

   public MesQuotaConfigMachinePart() {
   }

   public MesQuotaConfigMachinePart(
      final Long id,
      final String serialNumber,
      final String branchCompanyIds,
      final String workshopIds,
      final Integer productClassificationEnum,
      final String machinePartClassIds,
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
      this.productClassificationEnum = productClassificationEnum;
      this.machinePartClassIds = machinePartClassIds;
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

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public String getMachinePartClassIds() {
      return this.machinePartClassIds;
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

   public MesQuotaConfigMachinePart setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesQuotaConfigMachinePart setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesQuotaConfigMachinePart setBranchCompanyIds(final String branchCompanyIds) {
      this.branchCompanyIds = branchCompanyIds;
      return this;
   }

   public MesQuotaConfigMachinePart setWorkshopIds(final String workshopIds) {
      this.workshopIds = workshopIds;
      return this;
   }

   public MesQuotaConfigMachinePart setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
      return this;
   }

   public MesQuotaConfigMachinePart setMachinePartClassIds(final String machinePartClassIds) {
      this.machinePartClassIds = machinePartClassIds;
      return this;
   }

   public MesQuotaConfigMachinePart setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesQuotaConfigMachinePart setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public MesQuotaConfigMachinePart setQuotaType(final Integer quotaType) {
      this.quotaType = quotaType;
      return this;
   }

   public MesQuotaConfigMachinePart setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
      return this;
   }

   public MesQuotaConfigMachinePart setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesQuotaConfigMachinePart(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", branchCompanyIds="
         + this.getBranchCompanyIds()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", machinePartClassIds="
         + this.getMachinePartClassIds()
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

      if (!(o instanceof MesQuotaConfigMachinePart)) {
         return false;
      }

      MesQuotaConfigMachinePart other = (MesQuotaConfigMachinePart)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productClassificationEnum = this.getProductClassificationEnum();
         Object other$productClassificationEnum = other.getProductClassificationEnum();
         if (this$productClassificationEnum == null
            ? other$productClassificationEnum == null
            : this$productClassificationEnum.equals(other$productClassificationEnum)) {
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
                           Object this$machinePartClassIds = this.getMachinePartClassIds();
                           Object other$machinePartClassIds = other.getMachinePartClassIds();
                           if (this$machinePartClassIds == null
                              ? other$machinePartClassIds == null
                              : this$machinePartClassIds.equals(other$machinePartClassIds)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesQuotaConfigMachinePart;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
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
      Object $machinePartClassIds = this.getMachinePartClassIds();
      result = result * 59 + ($machinePartClassIds == null ? 43 : $machinePartClassIds.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      return result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
   }

   public static class MesQuotaConfigMachinePartBuilder {
      private Long id;
      private String serialNumber;
      private String branchCompanyIds;
      private String workshopIds;
      private Integer productClassificationEnum;
      private String machinePartClassIds;
      private Long processId;
      private String measureUnit;
      private Integer quotaType;
      private BigDecimal organizationInsidePrice;
      private BigDecimal organizationOutsidePrice;

      MesQuotaConfigMachinePartBuilder() {
      }

      public MesQuotaConfigMachinePart.MesQuotaConfigMachinePartBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesQuotaConfigMachinePart.MesQuotaConfigMachinePartBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesQuotaConfigMachinePart.MesQuotaConfigMachinePartBuilder branchCompanyIds(final String branchCompanyIds) {
         this.branchCompanyIds = branchCompanyIds;
         return this;
      }

      public MesQuotaConfigMachinePart.MesQuotaConfigMachinePartBuilder workshopIds(final String workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public MesQuotaConfigMachinePart.MesQuotaConfigMachinePartBuilder productClassificationEnum(final Integer productClassificationEnum) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      public MesQuotaConfigMachinePart.MesQuotaConfigMachinePartBuilder machinePartClassIds(final String machinePartClassIds) {
         this.machinePartClassIds = machinePartClassIds;
         return this;
      }

      public MesQuotaConfigMachinePart.MesQuotaConfigMachinePartBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesQuotaConfigMachinePart.MesQuotaConfigMachinePartBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public MesQuotaConfigMachinePart.MesQuotaConfigMachinePartBuilder quotaType(final Integer quotaType) {
         this.quotaType = quotaType;
         return this;
      }

      public MesQuotaConfigMachinePart.MesQuotaConfigMachinePartBuilder organizationInsidePrice(final BigDecimal organizationInsidePrice) {
         this.organizationInsidePrice = organizationInsidePrice;
         return this;
      }

      public MesQuotaConfigMachinePart.MesQuotaConfigMachinePartBuilder organizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
         this.organizationOutsidePrice = organizationOutsidePrice;
         return this;
      }

      public MesQuotaConfigMachinePart build() {
         return new MesQuotaConfigMachinePart(
            this.id,
            this.serialNumber,
            this.branchCompanyIds,
            this.workshopIds,
            this.productClassificationEnum,
            this.machinePartClassIds,
            this.processId,
            this.measureUnit,
            this.quotaType,
            this.organizationInsidePrice,
            this.organizationOutsidePrice
         );
      }

      @Override
      public String toString() {
         return "MesQuotaConfigMachinePart.MesQuotaConfigMachinePartBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", branchCompanyIds="
            + this.branchCompanyIds
            + ", workshopIds="
            + this.workshopIds
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", machinePartClassIds="
            + this.machinePartClassIds
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
