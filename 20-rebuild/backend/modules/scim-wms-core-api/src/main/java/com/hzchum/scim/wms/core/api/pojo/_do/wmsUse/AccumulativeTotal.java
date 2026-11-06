package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

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

@ApiModel(value = "AccumulativeTotal对象", description = "累计统计表")
@Entity
@TableName("accumulative_total")
@Table(name = "accumulative_total")
@org.hibernate.annotations.Table(appliesTo = "accumulative_total", comment = "累计统计表")
public class AccumulativeTotal extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "aggregateValue", value = "累计值", notes = "累计值")
   @TableField("aggregate_value")
   @Column(name = "aggregate_value", columnDefinition = "decimal(32,8)  COMMENT '累计值'", nullable = true)
   private BigDecimal aggregateValue;
   @ApiModelProperty(name = "aggregateValueExcludingVat", value = "累计值 (金额的话保存一个不含税的)", notes = "累计值 累计值 (金额的话保存一个不含税的)")
   @TableField("aggregate_value_excluding_vat")
   @Column(name = "aggregate_value_excluding_vat", columnDefinition = "decimal(32,8)  COMMENT '累计值 累计值 (金额的话保存一个不含税的)'", nullable = true)
   private BigDecimal aggregateValueExcludingVat;
   @ApiModelProperty(name = "aggregateType", value = "累计类型 aggregateTypeEnum", notes = "累计类型 aggregateTypeEnum")
   @TableField("aggregate_type")
   @Column(name = "aggregate_type", columnDefinition = "int  COMMENT '累计类型 aggregateTypeEnum'", nullable = true)
   private Integer aggregateType;

   public static AccumulativeTotal.AccumulativeTotalBuilder builder() {
      return new AccumulativeTotal.AccumulativeTotalBuilder();
   }

   public AccumulativeTotal() {
   }

   public AccumulativeTotal(final Long id, final BigDecimal aggregateValue, final BigDecimal aggregateValueExcludingVat, final Integer aggregateType) {
      this.id = id;
      this.aggregateValue = aggregateValue;
      this.aggregateValueExcludingVat = aggregateValueExcludingVat;
      this.aggregateType = aggregateType;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getAggregateValue() {
      return this.aggregateValue;
   }

   public BigDecimal getAggregateValueExcludingVat() {
      return this.aggregateValueExcludingVat;
   }

   public Integer getAggregateType() {
      return this.aggregateType;
   }

   public AccumulativeTotal setId(final Long id) {
      this.id = id;
      return this;
   }

   public AccumulativeTotal setAggregateValue(final BigDecimal aggregateValue) {
      this.aggregateValue = aggregateValue;
      return this;
   }

   public AccumulativeTotal setAggregateValueExcludingVat(final BigDecimal aggregateValueExcludingVat) {
      this.aggregateValueExcludingVat = aggregateValueExcludingVat;
      return this;
   }

   public AccumulativeTotal setAggregateType(final Integer aggregateType) {
      this.aggregateType = aggregateType;
      return this;
   }

   @Override
   public String toString() {
      return "AccumulativeTotal(id="
         + this.getId()
         + ", aggregateValue="
         + this.getAggregateValue()
         + ", aggregateValueExcludingVat="
         + this.getAggregateValueExcludingVat()
         + ", aggregateType="
         + this.getAggregateType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AccumulativeTotal)) {
         return false;
      }

      AccumulativeTotal other = (AccumulativeTotal)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$aggregateType = this.getAggregateType();
         Object other$aggregateType = other.getAggregateType();
         if (this$aggregateType == null ? other$aggregateType == null : this$aggregateType.equals(other$aggregateType)) {
            Object this$aggregateValue = this.getAggregateValue();
            Object other$aggregateValue = other.getAggregateValue();
            if (this$aggregateValue == null ? other$aggregateValue == null : this$aggregateValue.equals(other$aggregateValue)) {
               Object this$aggregateValueExcludingVat = this.getAggregateValueExcludingVat();
               Object other$aggregateValueExcludingVat = other.getAggregateValueExcludingVat();
               return this$aggregateValueExcludingVat == null
                  ? other$aggregateValueExcludingVat == null
                  : this$aggregateValueExcludingVat.equals(other$aggregateValueExcludingVat);
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
      return other instanceof AccumulativeTotal;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $aggregateType = this.getAggregateType();
      result = result * 59 + ($aggregateType == null ? 43 : $aggregateType.hashCode());
      Object $aggregateValue = this.getAggregateValue();
      result = result * 59 + ($aggregateValue == null ? 43 : $aggregateValue.hashCode());
      Object $aggregateValueExcludingVat = this.getAggregateValueExcludingVat();
      return result * 59 + ($aggregateValueExcludingVat == null ? 43 : $aggregateValueExcludingVat.hashCode());
   }

   public static class AccumulativeTotalBuilder {
      private Long id;
      private BigDecimal aggregateValue;
      private BigDecimal aggregateValueExcludingVat;
      private Integer aggregateType;

      AccumulativeTotalBuilder() {
      }

      public AccumulativeTotal.AccumulativeTotalBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AccumulativeTotal.AccumulativeTotalBuilder aggregateValue(final BigDecimal aggregateValue) {
         this.aggregateValue = aggregateValue;
         return this;
      }

      public AccumulativeTotal.AccumulativeTotalBuilder aggregateValueExcludingVat(final BigDecimal aggregateValueExcludingVat) {
         this.aggregateValueExcludingVat = aggregateValueExcludingVat;
         return this;
      }

      public AccumulativeTotal.AccumulativeTotalBuilder aggregateType(final Integer aggregateType) {
         this.aggregateType = aggregateType;
         return this;
      }

      public AccumulativeTotal build() {
         return new AccumulativeTotal(this.id, this.aggregateValue, this.aggregateValueExcludingVat, this.aggregateType);
      }

      @Override
      public String toString() {
         return "AccumulativeTotal.AccumulativeTotalBuilder(id="
            + this.id
            + ", aggregateValue="
            + this.aggregateValue
            + ", aggregateValueExcludingVat="
            + this.aggregateValueExcludingVat
            + ", aggregateType="
            + this.aggregateType
            + ")";
      }
   }
}
