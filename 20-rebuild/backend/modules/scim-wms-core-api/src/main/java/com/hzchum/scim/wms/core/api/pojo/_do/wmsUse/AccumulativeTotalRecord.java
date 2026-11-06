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

@ApiModel(value = "AccumulativeTotalRecord对象", description = "累计统计记录表")
@Entity
@TableName("accumulative_total_record")
@Table(name = "accumulative_total_record")
@org.hibernate.annotations.Table(appliesTo = "accumulative_total_record", comment = "累计统计记录表")
public class AccumulativeTotalRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "addValue", value = "新增值", notes = "新增值")
   @TableField("add_value")
   @Column(name = "add_value", columnDefinition = "decimal(32,8)  COMMENT '新增值'", nullable = true)
   private BigDecimal addValue;
   @ApiModelProperty(name = "addValueExcludingVat", value = "新增值 (金额的话保存一个不含税的)", notes = "新增值 (金额的话保存一个不含税的)")
   @TableField("add_value_excluding_vat")
   @Column(name = "add_value_excluding_vat", columnDefinition = "decimal(32,8)  COMMENT '新增值 (金额的话保存一个不含税的)'", nullable = true)
   private BigDecimal addValueExcludingVat;
   @ApiModelProperty(name = "aggregateType", value = "类型 aggregateTypeEnum", notes = "类型 aggregateTypeEnum")
   @TableField("aggregate_type")
   @Column(name = "aggregate_type", columnDefinition = "int  COMMENT '类型 aggregateTypeEnum'", nullable = true)
   private Integer aggregateType;
   @ApiModelProperty(name = "dataId", value = "关联数据ID", notes = "关联数据ID")
   @TableField("data_id")
   @Column(name = "data_id", columnDefinition = "bigint  COMMENT '关联数据ID'", nullable = false)
   private Long dataId;

   public static AccumulativeTotalRecord.AccumulativeTotalRecordBuilder builder() {
      return new AccumulativeTotalRecord.AccumulativeTotalRecordBuilder();
   }

   public AccumulativeTotalRecord() {
   }

   public AccumulativeTotalRecord(
      final Long id, final BigDecimal addValue, final BigDecimal addValueExcludingVat, final Integer aggregateType, final Long dataId
   ) {
      this.id = id;
      this.addValue = addValue;
      this.addValueExcludingVat = addValueExcludingVat;
      this.aggregateType = aggregateType;
      this.dataId = dataId;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getAddValue() {
      return this.addValue;
   }

   public BigDecimal getAddValueExcludingVat() {
      return this.addValueExcludingVat;
   }

   public Integer getAggregateType() {
      return this.aggregateType;
   }

   public Long getDataId() {
      return this.dataId;
   }

   public AccumulativeTotalRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public AccumulativeTotalRecord setAddValue(final BigDecimal addValue) {
      this.addValue = addValue;
      return this;
   }

   public AccumulativeTotalRecord setAddValueExcludingVat(final BigDecimal addValueExcludingVat) {
      this.addValueExcludingVat = addValueExcludingVat;
      return this;
   }

   public AccumulativeTotalRecord setAggregateType(final Integer aggregateType) {
      this.aggregateType = aggregateType;
      return this;
   }

   public AccumulativeTotalRecord setDataId(final Long dataId) {
      this.dataId = dataId;
      return this;
   }

   @Override
   public String toString() {
      return "AccumulativeTotalRecord(id="
         + this.getId()
         + ", addValue="
         + this.getAddValue()
         + ", addValueExcludingVat="
         + this.getAddValueExcludingVat()
         + ", aggregateType="
         + this.getAggregateType()
         + ", dataId="
         + this.getDataId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AccumulativeTotalRecord)) {
         return false;
      }

      AccumulativeTotalRecord other = (AccumulativeTotalRecord)o;
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
            Object this$dataId = this.getDataId();
            Object other$dataId = other.getDataId();
            if (this$dataId == null ? other$dataId == null : this$dataId.equals(other$dataId)) {
               Object this$addValue = this.getAddValue();
               Object other$addValue = other.getAddValue();
               if (this$addValue == null ? other$addValue == null : this$addValue.equals(other$addValue)) {
                  Object this$addValueExcludingVat = this.getAddValueExcludingVat();
                  Object other$addValueExcludingVat = other.getAddValueExcludingVat();
                  return this$addValueExcludingVat == null ? other$addValueExcludingVat == null : this$addValueExcludingVat.equals(other$addValueExcludingVat);
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
      return other instanceof AccumulativeTotalRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $aggregateType = this.getAggregateType();
      result = result * 59 + ($aggregateType == null ? 43 : $aggregateType.hashCode());
      Object $dataId = this.getDataId();
      result = result * 59 + ($dataId == null ? 43 : $dataId.hashCode());
      Object $addValue = this.getAddValue();
      result = result * 59 + ($addValue == null ? 43 : $addValue.hashCode());
      Object $addValueExcludingVat = this.getAddValueExcludingVat();
      return result * 59 + ($addValueExcludingVat == null ? 43 : $addValueExcludingVat.hashCode());
   }

   public static class AccumulativeTotalRecordBuilder {
      private Long id;
      private BigDecimal addValue;
      private BigDecimal addValueExcludingVat;
      private Integer aggregateType;
      private Long dataId;

      AccumulativeTotalRecordBuilder() {
      }

      public AccumulativeTotalRecord.AccumulativeTotalRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AccumulativeTotalRecord.AccumulativeTotalRecordBuilder addValue(final BigDecimal addValue) {
         this.addValue = addValue;
         return this;
      }

      public AccumulativeTotalRecord.AccumulativeTotalRecordBuilder addValueExcludingVat(final BigDecimal addValueExcludingVat) {
         this.addValueExcludingVat = addValueExcludingVat;
         return this;
      }

      public AccumulativeTotalRecord.AccumulativeTotalRecordBuilder aggregateType(final Integer aggregateType) {
         this.aggregateType = aggregateType;
         return this;
      }

      public AccumulativeTotalRecord.AccumulativeTotalRecordBuilder dataId(final Long dataId) {
         this.dataId = dataId;
         return this;
      }

      public AccumulativeTotalRecord build() {
         return new AccumulativeTotalRecord(this.id, this.addValue, this.addValueExcludingVat, this.aggregateType, this.dataId);
      }

      @Override
      public String toString() {
         return "AccumulativeTotalRecord.AccumulativeTotalRecordBuilder(id="
            + this.id
            + ", addValue="
            + this.addValue
            + ", addValueExcludingVat="
            + this.addValueExcludingVat
            + ", aggregateType="
            + this.aggregateType
            + ", dataId="
            + this.dataId
            + ")";
      }
   }
}
