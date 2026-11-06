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

@ApiModel(value = "MesQuotaConfigAssembleCondition对象", description = "定额配置部件条件表")
@Entity
@TableName("mes_quota_config_assemble_condition")
@Table(name = "mes_quota_config_assemble_condition")
@org.hibernate.annotations.Table(appliesTo = "mes_quota_config_assemble_condition", comment = "定额配置部件条件表")
public class MesQuotaConfigAssembleCondition extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("定额配置id")
   @TableField("quota_config_id")
   @Column(name = "quota_config_id", columnDefinition = "bigint(20) COMMENT '定额配置id'", nullable = true)
   private Long quotaConfigId;
   @ApiModelProperty("定额编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255) COMMENT '定额编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty("条件")
   @TableField("condition_enum")
   @Column(name = "condition_enum", columnDefinition = "int(11) COMMENT '条件'", nullable = true)
   private Integer conditionEnum;
   @ApiModelProperty("比较运算符1")
   @TableField("comparison_operator_one")
   @Column(name = "comparison_operator_one", columnDefinition = "int(11)  COMMENT '比较运算符1'", nullable = true)
   private Integer comparisonOperatorOne;
   @ApiModelProperty("数字1")
   @TableField("number_one")
   @Column(name = "number_one", columnDefinition = "decimal(32,8) COMMENT '数字1'", nullable = true)
   private BigDecimal numberOne;
   @ApiModelProperty("比较运算符2")
   @TableField("comparison_operator_two")
   @Column(name = "comparison_operator_two", columnDefinition = "int(11)  COMMENT '比较运算符2'", nullable = true)
   private Integer comparisonOperatorTwo;
   @ApiModelProperty("数字2")
   @TableField("number_two")
   @Column(name = "number_two", columnDefinition = "decimal(32,8)  COMMENT '数字2'", nullable = true)
   private BigDecimal numberTwo;

   public static MesQuotaConfigAssembleCondition.MesQuotaConfigAssembleConditionBuilder builder() {
      return new MesQuotaConfigAssembleCondition.MesQuotaConfigAssembleConditionBuilder();
   }

   public MesQuotaConfigAssembleCondition() {
   }

   public MesQuotaConfigAssembleCondition(
      final Long id,
      final Long quotaConfigId,
      final String serialNumber,
      final Integer conditionEnum,
      final Integer comparisonOperatorOne,
      final BigDecimal numberOne,
      final Integer comparisonOperatorTwo,
      final BigDecimal numberTwo
   ) {
      this.id = id;
      this.quotaConfigId = quotaConfigId;
      this.serialNumber = serialNumber;
      this.conditionEnum = conditionEnum;
      this.comparisonOperatorOne = comparisonOperatorOne;
      this.numberOne = numberOne;
      this.comparisonOperatorTwo = comparisonOperatorTwo;
      this.numberTwo = numberTwo;
   }

   public Long getId() {
      return this.id;
   }

   public Long getQuotaConfigId() {
      return this.quotaConfigId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getConditionEnum() {
      return this.conditionEnum;
   }

   public Integer getComparisonOperatorOne() {
      return this.comparisonOperatorOne;
   }

   public BigDecimal getNumberOne() {
      return this.numberOne;
   }

   public Integer getComparisonOperatorTwo() {
      return this.comparisonOperatorTwo;
   }

   public BigDecimal getNumberTwo() {
      return this.numberTwo;
   }

   public MesQuotaConfigAssembleCondition setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesQuotaConfigAssembleCondition setQuotaConfigId(final Long quotaConfigId) {
      this.quotaConfigId = quotaConfigId;
      return this;
   }

   public MesQuotaConfigAssembleCondition setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesQuotaConfigAssembleCondition setConditionEnum(final Integer conditionEnum) {
      this.conditionEnum = conditionEnum;
      return this;
   }

   public MesQuotaConfigAssembleCondition setComparisonOperatorOne(final Integer comparisonOperatorOne) {
      this.comparisonOperatorOne = comparisonOperatorOne;
      return this;
   }

   public MesQuotaConfigAssembleCondition setNumberOne(final BigDecimal numberOne) {
      this.numberOne = numberOne;
      return this;
   }

   public MesQuotaConfigAssembleCondition setComparisonOperatorTwo(final Integer comparisonOperatorTwo) {
      this.comparisonOperatorTwo = comparisonOperatorTwo;
      return this;
   }

   public MesQuotaConfigAssembleCondition setNumberTwo(final BigDecimal numberTwo) {
      this.numberTwo = numberTwo;
      return this;
   }

   @Override
   public String toString() {
      return "MesQuotaConfigAssembleCondition(id="
         + this.getId()
         + ", quotaConfigId="
         + this.getQuotaConfigId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", conditionEnum="
         + this.getConditionEnum()
         + ", comparisonOperatorOne="
         + this.getComparisonOperatorOne()
         + ", numberOne="
         + this.getNumberOne()
         + ", comparisonOperatorTwo="
         + this.getComparisonOperatorTwo()
         + ", numberTwo="
         + this.getNumberTwo()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigAssembleCondition)) {
         return false;
      }

      MesQuotaConfigAssembleCondition other = (MesQuotaConfigAssembleCondition)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quotaConfigId = this.getQuotaConfigId();
         Object other$quotaConfigId = other.getQuotaConfigId();
         if (this$quotaConfigId == null ? other$quotaConfigId == null : this$quotaConfigId.equals(other$quotaConfigId)) {
            Object this$conditionEnum = this.getConditionEnum();
            Object other$conditionEnum = other.getConditionEnum();
            if (this$conditionEnum == null ? other$conditionEnum == null : this$conditionEnum.equals(other$conditionEnum)) {
               Object this$comparisonOperatorOne = this.getComparisonOperatorOne();
               Object other$comparisonOperatorOne = other.getComparisonOperatorOne();
               if (this$comparisonOperatorOne == null ? other$comparisonOperatorOne == null : this$comparisonOperatorOne.equals(other$comparisonOperatorOne)) {
                  Object this$comparisonOperatorTwo = this.getComparisonOperatorTwo();
                  Object other$comparisonOperatorTwo = other.getComparisonOperatorTwo();
                  if (this$comparisonOperatorTwo == null ? other$comparisonOperatorTwo == null : this$comparisonOperatorTwo.equals(other$comparisonOperatorTwo)
                     )
                   {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$numberOne = this.getNumberOne();
                        Object other$numberOne = other.getNumberOne();
                        if (this$numberOne == null ? other$numberOne == null : this$numberOne.equals(other$numberOne)) {
                           Object this$numberTwo = this.getNumberTwo();
                           Object other$numberTwo = other.getNumberTwo();
                           return this$numberTwo == null ? other$numberTwo == null : this$numberTwo.equals(other$numberTwo);
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
      return other instanceof MesQuotaConfigAssembleCondition;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quotaConfigId = this.getQuotaConfigId();
      result = result * 59 + ($quotaConfigId == null ? 43 : $quotaConfigId.hashCode());
      Object $conditionEnum = this.getConditionEnum();
      result = result * 59 + ($conditionEnum == null ? 43 : $conditionEnum.hashCode());
      Object $comparisonOperatorOne = this.getComparisonOperatorOne();
      result = result * 59 + ($comparisonOperatorOne == null ? 43 : $comparisonOperatorOne.hashCode());
      Object $comparisonOperatorTwo = this.getComparisonOperatorTwo();
      result = result * 59 + ($comparisonOperatorTwo == null ? 43 : $comparisonOperatorTwo.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $numberOne = this.getNumberOne();
      result = result * 59 + ($numberOne == null ? 43 : $numberOne.hashCode());
      Object $numberTwo = this.getNumberTwo();
      return result * 59 + ($numberTwo == null ? 43 : $numberTwo.hashCode());
   }

   public static class MesQuotaConfigAssembleConditionBuilder {
      private Long id;
      private Long quotaConfigId;
      private String serialNumber;
      private Integer conditionEnum;
      private Integer comparisonOperatorOne;
      private BigDecimal numberOne;
      private Integer comparisonOperatorTwo;
      private BigDecimal numberTwo;

      MesQuotaConfigAssembleConditionBuilder() {
      }

      public MesQuotaConfigAssembleCondition.MesQuotaConfigAssembleConditionBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesQuotaConfigAssembleCondition.MesQuotaConfigAssembleConditionBuilder quotaConfigId(final Long quotaConfigId) {
         this.quotaConfigId = quotaConfigId;
         return this;
      }

      public MesQuotaConfigAssembleCondition.MesQuotaConfigAssembleConditionBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesQuotaConfigAssembleCondition.MesQuotaConfigAssembleConditionBuilder conditionEnum(final Integer conditionEnum) {
         this.conditionEnum = conditionEnum;
         return this;
      }

      public MesQuotaConfigAssembleCondition.MesQuotaConfigAssembleConditionBuilder comparisonOperatorOne(final Integer comparisonOperatorOne) {
         this.comparisonOperatorOne = comparisonOperatorOne;
         return this;
      }

      public MesQuotaConfigAssembleCondition.MesQuotaConfigAssembleConditionBuilder numberOne(final BigDecimal numberOne) {
         this.numberOne = numberOne;
         return this;
      }

      public MesQuotaConfigAssembleCondition.MesQuotaConfigAssembleConditionBuilder comparisonOperatorTwo(final Integer comparisonOperatorTwo) {
         this.comparisonOperatorTwo = comparisonOperatorTwo;
         return this;
      }

      public MesQuotaConfigAssembleCondition.MesQuotaConfigAssembleConditionBuilder numberTwo(final BigDecimal numberTwo) {
         this.numberTwo = numberTwo;
         return this;
      }

      public MesQuotaConfigAssembleCondition build() {
         return new MesQuotaConfigAssembleCondition(
            this.id,
            this.quotaConfigId,
            this.serialNumber,
            this.conditionEnum,
            this.comparisonOperatorOne,
            this.numberOne,
            this.comparisonOperatorTwo,
            this.numberTwo
         );
      }

      @Override
      public String toString() {
         return "MesQuotaConfigAssembleCondition.MesQuotaConfigAssembleConditionBuilder(id="
            + this.id
            + ", quotaConfigId="
            + this.quotaConfigId
            + ", serialNumber="
            + this.serialNumber
            + ", conditionEnum="
            + this.conditionEnum
            + ", comparisonOperatorOne="
            + this.comparisonOperatorOne
            + ", numberOne="
            + this.numberOne
            + ", comparisonOperatorTwo="
            + this.comparisonOperatorTwo
            + ", numberTwo="
            + this.numberTwo
            + ")";
      }
   }
}
