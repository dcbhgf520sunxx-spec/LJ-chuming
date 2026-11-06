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

@ApiModel(value = "MesAssembleQuotaConfig对象", description = "部件定额配置表")
@Entity
@TableName("mes_assemble_quota_config")
@Table(name = "mes_assemble_quota_config")
@org.hibernate.annotations.Table(appliesTo = "mes_assemble_quota_config", comment = "部件定额配置表")
public class MesAssembleQuotaConfig extends BaseEntity<Long> {
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
   @ApiModelProperty("部件类型IDs")
   @TableField("assemble_class_ids")
   @Column(name = "assemble_class_ids", columnDefinition = "varchar(255) COMMENT '部件类型IDs'", nullable = true)
   private String assembleClassIds;
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
   @ApiModelProperty("分类方式")
   @TableField("classification_way_enum")
   @Column(name = "classification_way_enum", columnDefinition = "int(11) COMMENT '分类方式'", nullable = true)
   private Integer classificationWayEnum;
   @ApiModelProperty("单价(元)")
   @TableField(value = "price", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "price", columnDefinition = "decimal(32,8) COMMENT '单价(元)'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty("状态(true: 启用, false: 禁用)")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default 1 COMMENT '状态(true: 启用, false: 禁用)'", nullable = true)
   private Boolean status;

   public static MesAssembleQuotaConfig.MesAssembleQuotaConfigBuilder builder() {
      return new MesAssembleQuotaConfig.MesAssembleQuotaConfigBuilder();
   }

   public MesAssembleQuotaConfig() {
   }

   public MesAssembleQuotaConfig(
      final Long id,
      final String quotaNumber,
      final String workshopIds,
      final String assembleClassIds,
      final Long processId,
      final Integer calculationWay,
      final Boolean boolSpecificationClass,
      final Integer classificationWayEnum,
      final BigDecimal price,
      final Boolean status
   ) {
      this.id = id;
      this.quotaNumber = quotaNumber;
      this.workshopIds = workshopIds;
      this.assembleClassIds = assembleClassIds;
      this.processId = processId;
      this.calculationWay = calculationWay;
      this.boolSpecificationClass = boolSpecificationClass;
      this.classificationWayEnum = classificationWayEnum;
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

   public String getAssembleClassIds() {
      return this.assembleClassIds;
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

   public Integer getClassificationWayEnum() {
      return this.classificationWayEnum;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public MesAssembleQuotaConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesAssembleQuotaConfig setQuotaNumber(final String quotaNumber) {
      this.quotaNumber = quotaNumber;
      return this;
   }

   public MesAssembleQuotaConfig setWorkshopIds(final String workshopIds) {
      this.workshopIds = workshopIds;
      return this;
   }

   public MesAssembleQuotaConfig setAssembleClassIds(final String assembleClassIds) {
      this.assembleClassIds = assembleClassIds;
      return this;
   }

   public MesAssembleQuotaConfig setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesAssembleQuotaConfig setCalculationWay(final Integer calculationWay) {
      this.calculationWay = calculationWay;
      return this;
   }

   public MesAssembleQuotaConfig setBoolSpecificationClass(final Boolean boolSpecificationClass) {
      this.boolSpecificationClass = boolSpecificationClass;
      return this;
   }

   public MesAssembleQuotaConfig setClassificationWayEnum(final Integer classificationWayEnum) {
      this.classificationWayEnum = classificationWayEnum;
      return this;
   }

   public MesAssembleQuotaConfig setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesAssembleQuotaConfig setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "MesAssembleQuotaConfig(id="
         + this.getId()
         + ", quotaNumber="
         + this.getQuotaNumber()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", assembleClassIds="
         + this.getAssembleClassIds()
         + ", processId="
         + this.getProcessId()
         + ", calculationWay="
         + this.getCalculationWay()
         + ", boolSpecificationClass="
         + this.getBoolSpecificationClass()
         + ", classificationWayEnum="
         + this.getClassificationWayEnum()
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

      if (!(o instanceof MesAssembleQuotaConfig)) {
         return false;
      }

      MesAssembleQuotaConfig other = (MesAssembleQuotaConfig)o;
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
            Object this$calculationWay = this.getCalculationWay();
            Object other$calculationWay = other.getCalculationWay();
            if (this$calculationWay == null ? other$calculationWay == null : this$calculationWay.equals(other$calculationWay)) {
               Object this$boolSpecificationClass = this.getBoolSpecificationClass();
               Object other$boolSpecificationClass = other.getBoolSpecificationClass();
               if (this$boolSpecificationClass == null
                  ? other$boolSpecificationClass == null
                  : this$boolSpecificationClass.equals(other$boolSpecificationClass)) {
                  Object this$classificationWayEnum = this.getClassificationWayEnum();
                  Object other$classificationWayEnum = other.getClassificationWayEnum();
                  if (this$classificationWayEnum == null ? other$classificationWayEnum == null : this$classificationWayEnum.equals(other$classificationWayEnum)
                     )
                   {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                        Object this$quotaNumber = this.getQuotaNumber();
                        Object other$quotaNumber = other.getQuotaNumber();
                        if (this$quotaNumber == null ? other$quotaNumber == null : this$quotaNumber.equals(other$quotaNumber)) {
                           Object this$workshopIds = this.getWorkshopIds();
                           Object other$workshopIds = other.getWorkshopIds();
                           if (this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds)) {
                              Object this$assembleClassIds = this.getAssembleClassIds();
                              Object other$assembleClassIds = other.getAssembleClassIds();
                              if (this$assembleClassIds == null ? other$assembleClassIds == null : this$assembleClassIds.equals(other$assembleClassIds)) {
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
      return other instanceof MesAssembleQuotaConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $calculationWay = this.getCalculationWay();
      result = result * 59 + ($calculationWay == null ? 43 : $calculationWay.hashCode());
      Object $boolSpecificationClass = this.getBoolSpecificationClass();
      result = result * 59 + ($boolSpecificationClass == null ? 43 : $boolSpecificationClass.hashCode());
      Object $classificationWayEnum = this.getClassificationWayEnum();
      result = result * 59 + ($classificationWayEnum == null ? 43 : $classificationWayEnum.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $quotaNumber = this.getQuotaNumber();
      result = result * 59 + ($quotaNumber == null ? 43 : $quotaNumber.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      result = result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
      Object $assembleClassIds = this.getAssembleClassIds();
      result = result * 59 + ($assembleClassIds == null ? 43 : $assembleClassIds.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesAssembleQuotaConfigBuilder {
      private Long id;
      private String quotaNumber;
      private String workshopIds;
      private String assembleClassIds;
      private Long processId;
      private Integer calculationWay;
      private Boolean boolSpecificationClass;
      private Integer classificationWayEnum;
      private BigDecimal price;
      private Boolean status;

      MesAssembleQuotaConfigBuilder() {
      }

      public MesAssembleQuotaConfig.MesAssembleQuotaConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesAssembleQuotaConfig.MesAssembleQuotaConfigBuilder quotaNumber(final String quotaNumber) {
         this.quotaNumber = quotaNumber;
         return this;
      }

      public MesAssembleQuotaConfig.MesAssembleQuotaConfigBuilder workshopIds(final String workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public MesAssembleQuotaConfig.MesAssembleQuotaConfigBuilder assembleClassIds(final String assembleClassIds) {
         this.assembleClassIds = assembleClassIds;
         return this;
      }

      public MesAssembleQuotaConfig.MesAssembleQuotaConfigBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesAssembleQuotaConfig.MesAssembleQuotaConfigBuilder calculationWay(final Integer calculationWay) {
         this.calculationWay = calculationWay;
         return this;
      }

      public MesAssembleQuotaConfig.MesAssembleQuotaConfigBuilder boolSpecificationClass(final Boolean boolSpecificationClass) {
         this.boolSpecificationClass = boolSpecificationClass;
         return this;
      }

      public MesAssembleQuotaConfig.MesAssembleQuotaConfigBuilder classificationWayEnum(final Integer classificationWayEnum) {
         this.classificationWayEnum = classificationWayEnum;
         return this;
      }

      public MesAssembleQuotaConfig.MesAssembleQuotaConfigBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesAssembleQuotaConfig.MesAssembleQuotaConfigBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesAssembleQuotaConfig build() {
         return new MesAssembleQuotaConfig(
            this.id,
            this.quotaNumber,
            this.workshopIds,
            this.assembleClassIds,
            this.processId,
            this.calculationWay,
            this.boolSpecificationClass,
            this.classificationWayEnum,
            this.price,
            this.status
         );
      }

      @Override
      public String toString() {
         return "MesAssembleQuotaConfig.MesAssembleQuotaConfigBuilder(id="
            + this.id
            + ", quotaNumber="
            + this.quotaNumber
            + ", workshopIds="
            + this.workshopIds
            + ", assembleClassIds="
            + this.assembleClassIds
            + ", processId="
            + this.processId
            + ", calculationWay="
            + this.calculationWay
            + ", boolSpecificationClass="
            + this.boolSpecificationClass
            + ", classificationWayEnum="
            + this.classificationWayEnum
            + ", price="
            + this.price
            + ", status="
            + this.status
            + ")";
      }
   }
}
