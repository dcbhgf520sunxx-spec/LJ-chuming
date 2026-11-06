package com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(value = "MesMachinePartQuotaConfig对象", description = "零件定额配置表")
@Entity
@TableName("mes_machine_part_quota_config")
@Table(name = "mes_machine_part_quota_config")
@org.hibernate.annotations.Table(appliesTo = "mes_machine_part_quota_config", comment = "零件定额配置表")
public class MesMachinePartQuotaConfig extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("定额编号")
   @TableField("quota_number")
   @Column(name = "quota_number", columnDefinition = "varchar(255) COMMENT '定额编号'", nullable = true)
   private String quotaNumber;
   @ApiModelProperty("车间IDs")
   @TableField("workshop_ids")
   @Column(name = "workshop_ids", columnDefinition = "varchar(255) COMMENT '车间IDs'", nullable = true)
   private String workshopIds;
   @ApiModelProperty("零件分类(4: 成品型材/型材, 8: 钢板/板材)")
   @TableField("machine_part_type")
   @Column(name = "machine_part_type", columnDefinition = "int(11) COMMENT '零件分类(4: 成品型材/型材, 8: 钢板/板材)'", nullable = true)
   private Integer machinePartType;
   @ApiModelProperty("零件类型IDs")
   @TableField("machine_part_class_ids")
   @Column(name = "machine_part_class_ids", columnDefinition = "varchar(255) COMMENT '零件类型IDs'", nullable = true)
   private String machinePartClassIds;
   @ApiModelProperty("工序ID")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20) COMMENT '工序ID'", nullable = true)
   private Long processId;
   @ApiModelProperty("计算方式")
   @TableField("calculation_way")
   @Column(name = "calculation_way", columnDefinition = "int(11) COMMENT '计算方式'", nullable = true)
   private Integer calculationWay;
   @ApiModelProperty("规格分类(true: 需分类, false: 无需分类)")
   @TableField("bool_specification_class")
   @Column(name = "bool_specification_class", columnDefinition = "tinyint(1) COMMENT '规格分类(true: 需分类, false: 无需分类)'", nullable = true)
   private Boolean boolSpecificationClass;
   @ApiModelProperty("单价(元)")
   @TableField(value = "price", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "price", columnDefinition = "decimal(32,8) COMMENT '单价(元)'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty("状态(true: 启用, false: 禁用)")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default 1 COMMENT '状态(true: 启用, false: 禁用)'", nullable = true)
   private Boolean status;

   public static MesMachinePartQuotaConfig.MesMachinePartQuotaConfigBuilder builder() {
      return new MesMachinePartQuotaConfig.MesMachinePartQuotaConfigBuilder();
   }

   public MesMachinePartQuotaConfig() {
   }

   public MesMachinePartQuotaConfig(
      final Long id,
      final String quotaNumber,
      final String workshopIds,
      final Integer machinePartType,
      final String machinePartClassIds,
      final Long processId,
      final Integer calculationWay,
      final Boolean boolSpecificationClass,
      final BigDecimal price,
      final Boolean status
   ) {
      this.id = id;
      this.quotaNumber = quotaNumber;
      this.workshopIds = workshopIds;
      this.machinePartType = machinePartType;
      this.machinePartClassIds = machinePartClassIds;
      this.processId = processId;
      this.calculationWay = calculationWay;
      this.boolSpecificationClass = boolSpecificationClass;
      this.price = price;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public String getQuotaNumber() {
      return this.quotaNumber;
   }

   public String getWorkshopIds() {
      return this.workshopIds;
   }

   public Integer getMachinePartType() {
      return this.machinePartType;
   }

   public String getMachinePartClassIds() {
      return this.machinePartClassIds;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getCalculationWay() {
      return this.calculationWay;
   }

   public Boolean getBoolSpecificationClass() {
      return this.boolSpecificationClass;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public MesMachinePartQuotaConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesMachinePartQuotaConfig setQuotaNumber(final String quotaNumber) {
      this.quotaNumber = quotaNumber;
      return this;
   }

   public MesMachinePartQuotaConfig setWorkshopIds(final String workshopIds) {
      this.workshopIds = workshopIds;
      return this;
   }

   public MesMachinePartQuotaConfig setMachinePartType(final Integer machinePartType) {
      this.machinePartType = machinePartType;
      return this;
   }

   public MesMachinePartQuotaConfig setMachinePartClassIds(final String machinePartClassIds) {
      this.machinePartClassIds = machinePartClassIds;
      return this;
   }

   public MesMachinePartQuotaConfig setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesMachinePartQuotaConfig setCalculationWay(final Integer calculationWay) {
      this.calculationWay = calculationWay;
      return this;
   }

   public MesMachinePartQuotaConfig setBoolSpecificationClass(final Boolean boolSpecificationClass) {
      this.boolSpecificationClass = boolSpecificationClass;
      return this;
   }

   public MesMachinePartQuotaConfig setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesMachinePartQuotaConfig setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "MesMachinePartQuotaConfig(id="
         + this.getId()
         + ", quotaNumber="
         + this.getQuotaNumber()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", machinePartType="
         + this.getMachinePartType()
         + ", machinePartClassIds="
         + this.getMachinePartClassIds()
         + ", processId="
         + this.getProcessId()
         + ", calculationWay="
         + this.getCalculationWay()
         + ", boolSpecificationClass="
         + this.getBoolSpecificationClass()
         + ", price="
         + this.getPrice()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesMachinePartQuotaConfig)) {
         return false;
      }

      MesMachinePartQuotaConfig other = (MesMachinePartQuotaConfig)o;
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
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$calculationWay = this.getCalculationWay();
               Object other$calculationWay = other.getCalculationWay();
               if (this$calculationWay == null ? other$calculationWay == null : this$calculationWay.equals(other$calculationWay)) {
                  Object this$boolSpecificationClass = this.getBoolSpecificationClass();
                  Object other$boolSpecificationClass = other.getBoolSpecificationClass();
                  if (this$boolSpecificationClass == null
                     ? other$boolSpecificationClass == null
                     : this$boolSpecificationClass.equals(other$boolSpecificationClass)) {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                        Object this$quotaNumber = this.getQuotaNumber();
                        Object other$quotaNumber = other.getQuotaNumber();
                        if (this$quotaNumber == null ? other$quotaNumber == null : this$quotaNumber.equals(other$quotaNumber)) {
                           Object this$workshopIds = this.getWorkshopIds();
                           Object other$workshopIds = other.getWorkshopIds();
                           if (this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds)) {
                              Object this$machinePartClassIds = this.getMachinePartClassIds();
                              Object other$machinePartClassIds = other.getMachinePartClassIds();
                              if (this$machinePartClassIds == null
                                 ? other$machinePartClassIds == null
                                 : this$machinePartClassIds.equals(other$machinePartClassIds)) {
                                 Object this$price = this.getPrice();
                                 Object other$price = other.getPrice();
                                 return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesMachinePartQuotaConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $machinePartType = this.getMachinePartType();
      result = result * 59 + ($machinePartType == null ? 43 : $machinePartType.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $calculationWay = this.getCalculationWay();
      result = result * 59 + ($calculationWay == null ? 43 : $calculationWay.hashCode());
      Object $boolSpecificationClass = this.getBoolSpecificationClass();
      result = result * 59 + ($boolSpecificationClass == null ? 43 : $boolSpecificationClass.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $quotaNumber = this.getQuotaNumber();
      result = result * 59 + ($quotaNumber == null ? 43 : $quotaNumber.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      result = result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
      Object $machinePartClassIds = this.getMachinePartClassIds();
      result = result * 59 + ($machinePartClassIds == null ? 43 : $machinePartClassIds.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesMachinePartQuotaConfigBuilder {
      private Long id;
      private String quotaNumber;
      private String workshopIds;
      private Integer machinePartType;
      private String machinePartClassIds;
      private Long processId;
      private Integer calculationWay;
      private Boolean boolSpecificationClass;
      private BigDecimal price;
      private Boolean status;

      MesMachinePartQuotaConfigBuilder() {
      }

      public MesMachinePartQuotaConfig.MesMachinePartQuotaConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesMachinePartQuotaConfig.MesMachinePartQuotaConfigBuilder quotaNumber(final String quotaNumber) {
         this.quotaNumber = quotaNumber;
         return this;
      }

      public MesMachinePartQuotaConfig.MesMachinePartQuotaConfigBuilder workshopIds(final String workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public MesMachinePartQuotaConfig.MesMachinePartQuotaConfigBuilder machinePartType(final Integer machinePartType) {
         this.machinePartType = machinePartType;
         return this;
      }

      public MesMachinePartQuotaConfig.MesMachinePartQuotaConfigBuilder machinePartClassIds(final String machinePartClassIds) {
         this.machinePartClassIds = machinePartClassIds;
         return this;
      }

      public MesMachinePartQuotaConfig.MesMachinePartQuotaConfigBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesMachinePartQuotaConfig.MesMachinePartQuotaConfigBuilder calculationWay(final Integer calculationWay) {
         this.calculationWay = calculationWay;
         return this;
      }

      public MesMachinePartQuotaConfig.MesMachinePartQuotaConfigBuilder boolSpecificationClass(final Boolean boolSpecificationClass) {
         this.boolSpecificationClass = boolSpecificationClass;
         return this;
      }

      public MesMachinePartQuotaConfig.MesMachinePartQuotaConfigBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesMachinePartQuotaConfig.MesMachinePartQuotaConfigBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesMachinePartQuotaConfig build() {
         return new MesMachinePartQuotaConfig(
            this.id,
            this.quotaNumber,
            this.workshopIds,
            this.machinePartType,
            this.machinePartClassIds,
            this.processId,
            this.calculationWay,
            this.boolSpecificationClass,
            this.price,
            this.status
         );
      }

      @Override
      public String toString() {
         return "MesMachinePartQuotaConfig.MesMachinePartQuotaConfigBuilder(id="
            + this.id
            + ", quotaNumber="
            + this.quotaNumber
            + ", workshopIds="
            + this.workshopIds
            + ", machinePartType="
            + this.machinePartType
            + ", machinePartClassIds="
            + this.machinePartClassIds
            + ", processId="
            + this.processId
            + ", calculationWay="
            + this.calculationWay
            + ", boolSpecificationClass="
            + this.boolSpecificationClass
            + ", price="
            + this.price
            + ", status="
            + this.status
            + ")";
      }
   }
}
