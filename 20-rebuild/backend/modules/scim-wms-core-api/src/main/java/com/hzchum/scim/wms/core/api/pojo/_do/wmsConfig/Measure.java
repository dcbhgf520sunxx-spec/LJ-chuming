package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
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

@ApiModel(value = "Measure对象", description = "计量单位 ")
@Entity
@TableName("wms_measure")
@Table(name = "wms_measure")
public class Measure extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "classificationId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classificationId")
   @JSONField(name = "classificationId")
   @TableField("classification_id")
   @Column(name = "classification_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classificationId;
   @ApiModelProperty(name = "measureUnit", value = "计量单位名称", notes = "计量单位名称")
   @JsonProperty("measureUnit")
   @JSONField(name = "measureUnit")
   @TableField(value = "measure_unit", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "measure_unit", columnDefinition = "varchar(255)  COMMENT '计量单位名称'", nullable = true)
   private String measureUnit;
   @ApiModelProperty(name = "measurePrecision", value = "计量精度", notes = "计量精度")
   @JsonProperty("measurePrecision")
   @JSONField(name = "measurePrecision")
   @TableField(value = "measure_precision", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "measure_precision", columnDefinition = "int  COMMENT '计量精度'", nullable = true)
   private Integer measurePrecision;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位名称", notes = "核算单位名称")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(100)  COMMENT '核算单位名称'", nullable = true)
   private String accountingUnit;
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度", notes = "核算精度")
   @JsonProperty("accountingPrecision")
   @JSONField(name = "accountingPrecision")
   @TableField("accounting_precision")
   @Column(name = "accounting_precision", columnDefinition = "int  COMMENT '核算精度'", nullable = true)
   private Integer accountingPrecision;
   @ApiModelProperty(name = "outboundUnitType", value = "出库方式[1 计量, 2 核算]", notes = "出库方式[1 计量, 2 核算]")
   @JsonProperty("outboundUnitType")
   @JSONField(name = "outboundUnitType")
   @TableField("outbound_unit_type")
   @Column(name = "outbound_unit_type", columnDefinition = "int  COMMENT '出库方式[1 计量, 2 核算]'", nullable = true)
   private Integer outboundUnitType;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "rdRate", value = "高新研发费", notes = "高新研发费")
   @JsonProperty("rdRate")
   @JSONField(name = "rdRate")
   @TableField("rd_rate")
   @Column(name = "rd_rate", columnDefinition = "decimal(32,8)  COMMENT '高新研发费'", nullable = true)
   private BigDecimal rdRate;
   @ApiModelProperty(name = "boolQualityTesting", value = "是否质检", notes = "是否质检")
   @JsonProperty("boolQualityTesting")
   @JSONField(name = "boolQualityTesting")
   @TableField("bool_quality_testing")
   @Column(name = "bool_quality_testing", columnDefinition = "tinyint(1) default '0' COMMENT '是否质检'", nullable = true)
   private Boolean boolQualityTesting;
   @ApiModelProperty(name = "useParentId", value = "计量配置使用上级科目ID，可以为null，为null的话代表自己编辑的或未配置", notes = "计量配置使用上级科目ID，可以为null，为null的话代表自己编辑的或未配置")
   @JsonProperty("useParentId")
   @JSONField(name = "useParentId")
   @TableField("use_parent_id")
   @Column(name = "use_parent_id", columnDefinition = "bigint COMMENT '计量配置使用上级科目ID，可以为null，为null的话代表自己编辑的或未配置'", nullable = true)
   private Long useParentId;

   public static Measure.MeasureBuilder builder() {
      return new Measure.MeasureBuilder();
   }

   public Measure() {
   }

   public Measure(
      final Long id,
      final Long classificationId,
      final String measureUnit,
      final Integer measurePrecision,
      final String accountingUnit,
      final Integer accountingPrecision,
      final Integer outboundUnitType,
      final Integer basicClass,
      final BigDecimal rdRate,
      final Boolean boolQualityTesting,
      final Long useParentId
   ) {
      this.id = id;
      this.classificationId = classificationId;
      this.measureUnit = measureUnit;
      this.measurePrecision = measurePrecision;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.outboundUnitType = outboundUnitType;
      this.basicClass = basicClass;
      this.rdRate = rdRate;
      this.boolQualityTesting = boolQualityTesting;
      this.useParentId = useParentId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassificationId() {
      return this.classificationId;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public Integer getOutboundUnitType() {
      return this.outboundUnitType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getRdRate() {
      return this.rdRate;
   }

   public Boolean getBoolQualityTesting() {
      return this.boolQualityTesting;
   }

   public Long getUseParentId() {
      return this.useParentId;
   }

   @JsonProperty("id")
   public Measure setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("classificationId")
   public Measure setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
      return this;
   }

   @JsonProperty("measureUnit")
   public Measure setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   @JsonProperty("measurePrecision")
   public Measure setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
      return this;
   }

   @JsonProperty("accountingUnit")
   public Measure setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("accountingPrecision")
   public Measure setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
      return this;
   }

   @JsonProperty("outboundUnitType")
   public Measure setOutboundUnitType(final Integer outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
      return this;
   }

   @JsonProperty("basicClass")
   public Measure setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("rdRate")
   public Measure setRdRate(final BigDecimal rdRate) {
      this.rdRate = rdRate;
      return this;
   }

   @JsonProperty("boolQualityTesting")
   public Measure setBoolQualityTesting(final Boolean boolQualityTesting) {
      this.boolQualityTesting = boolQualityTesting;
      return this;
   }

   @JsonProperty("useParentId")
   public Measure setUseParentId(final Long useParentId) {
      this.useParentId = useParentId;
      return this;
   }

   @Override
   public String toString() {
      return "Measure(id="
         + this.getId()
         + ", classificationId="
         + this.getClassificationId()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
         + ", basicClass="
         + this.getBasicClass()
         + ", rdRate="
         + this.getRdRate()
         + ", boolQualityTesting="
         + this.getBoolQualityTesting()
         + ", useParentId="
         + this.getUseParentId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Measure)) {
         return false;
      }

      Measure other = (Measure)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classificationId = this.getClassificationId();
         Object other$classificationId = other.getClassificationId();
         if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
            Object this$measurePrecision = this.getMeasurePrecision();
            Object other$measurePrecision = other.getMeasurePrecision();
            if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
               Object this$accountingPrecision = this.getAccountingPrecision();
               Object other$accountingPrecision = other.getAccountingPrecision();
               if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
                  Object this$outboundUnitType = this.getOutboundUnitType();
                  Object other$outboundUnitType = other.getOutboundUnitType();
                  if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
                     Object this$basicClass = this.getBasicClass();
                     Object other$basicClass = other.getBasicClass();
                     if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                        Object this$boolQualityTesting = this.getBoolQualityTesting();
                        Object other$boolQualityTesting = other.getBoolQualityTesting();
                        if (this$boolQualityTesting == null ? other$boolQualityTesting == null : this$boolQualityTesting.equals(other$boolQualityTesting)) {
                           Object this$useParentId = this.getUseParentId();
                           Object other$useParentId = other.getUseParentId();
                           if (this$useParentId == null ? other$useParentId == null : this$useParentId.equals(other$useParentId)) {
                              Object this$measureUnit = this.getMeasureUnit();
                              Object other$measureUnit = other.getMeasureUnit();
                              if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                 Object this$accountingUnit = this.getAccountingUnit();
                                 Object other$accountingUnit = other.getAccountingUnit();
                                 if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                    Object this$rdRate = this.getRdRate();
                                    Object other$rdRate = other.getRdRate();
                                    return this$rdRate == null ? other$rdRate == null : this$rdRate.equals(other$rdRate);
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
      return other instanceof Measure;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolQualityTesting = this.getBoolQualityTesting();
      result = result * 59 + ($boolQualityTesting == null ? 43 : $boolQualityTesting.hashCode());
      Object $useParentId = this.getUseParentId();
      result = result * 59 + ($useParentId == null ? 43 : $useParentId.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $rdRate = this.getRdRate();
      return result * 59 + ($rdRate == null ? 43 : $rdRate.hashCode());
   }

   public static class MeasureBuilder {
      private Long id;
      private Long classificationId;
      private String measureUnit;
      private Integer measurePrecision;
      private String accountingUnit;
      private Integer accountingPrecision;
      private Integer outboundUnitType;
      private Integer basicClass;
      private BigDecimal rdRate;
      private Boolean boolQualityTesting;
      private Long useParentId;

      MeasureBuilder() {
      }

      @JsonProperty("id")
      public Measure.MeasureBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("classificationId")
      public Measure.MeasureBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      @JsonProperty("measureUnit")
      public Measure.MeasureBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("measurePrecision")
      public Measure.MeasureBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      @JsonProperty("accountingUnit")
      public Measure.MeasureBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("accountingPrecision")
      public Measure.MeasureBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      @JsonProperty("outboundUnitType")
      public Measure.MeasureBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      @JsonProperty("basicClass")
      public Measure.MeasureBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("rdRate")
      public Measure.MeasureBuilder rdRate(final BigDecimal rdRate) {
         this.rdRate = rdRate;
         return this;
      }

      @JsonProperty("boolQualityTesting")
      public Measure.MeasureBuilder boolQualityTesting(final Boolean boolQualityTesting) {
         this.boolQualityTesting = boolQualityTesting;
         return this;
      }

      @JsonProperty("useParentId")
      public Measure.MeasureBuilder useParentId(final Long useParentId) {
         this.useParentId = useParentId;
         return this;
      }

      public Measure build() {
         return new Measure(
            this.id,
            this.classificationId,
            this.measureUnit,
            this.measurePrecision,
            this.accountingUnit,
            this.accountingPrecision,
            this.outboundUnitType,
            this.basicClass,
            this.rdRate,
            this.boolQualityTesting,
            this.useParentId
         );
      }

      @Override
      public String toString() {
         return "Measure.MeasureBuilder(id="
            + this.id
            + ", classificationId="
            + this.classificationId
            + ", measureUnit="
            + this.measureUnit
            + ", measurePrecision="
            + this.measurePrecision
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", outboundUnitType="
            + this.outboundUnitType
            + ", basicClass="
            + this.basicClass
            + ", rdRate="
            + this.rdRate
            + ", boolQualityTesting="
            + this.boolQualityTesting
            + ", useParentId="
            + this.useParentId
            + ")";
      }
   }
}
