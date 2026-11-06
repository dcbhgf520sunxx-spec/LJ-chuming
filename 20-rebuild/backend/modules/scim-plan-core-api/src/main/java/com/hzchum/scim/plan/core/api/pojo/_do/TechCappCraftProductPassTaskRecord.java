package com.hzchum.scim.plan.core.api.pojo._do;

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

@ApiModel(value = "TechCappCraftProductPassTaskRecord对象", description = "")
@Entity
@TableName("tech_capp_craft_product_pass_task_record")
@Table(name = "tech_capp_craft_product_pass_task_record")
@org.hibernate.annotations.Table(appliesTo = "tech_capp_craft_product_pass_task_record")
public class TechCappCraftProductPassTaskRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "techCappCraftProductPassTaskId", value = "焊道任务表id", notes = "焊道任务表id")
   @TableField("tech_capp_craft_product_pass_task_id")
   @Column(name = "tech_capp_craft_product_pass_task_id", columnDefinition = "bigint(20)  COMMENT '焊道任务表id'", nullable = false)
   private Long techCappCraftProductPassTaskId;
   @ApiModelProperty(name = "electricity", value = "电流(A)", notes = "电流(A)")
   @TableField("electricity")
   @Column(name = "electricity", columnDefinition = "decimal(32,8)  COMMENT '电流(A)'", nullable = false)
   private BigDecimal electricity;
   @ApiModelProperty(name = "techCappCraftProductPassTaskId", value = "工艺卡产品任务表ID", notes = "工艺卡产品任务表ID")
   @TableField("tech_capp_craft_product_task_id")
   @Column(name = "tech_capp_craft_product_task_id", columnDefinition = "bigint(20)  COMMENT '工艺卡产品任务表ID'", nullable = false)
   private Long techCappCraftProductTaskId;
   @ApiModelProperty(name = "voltage", value = "电压(V)", notes = "电压(V)")
   @TableField("voltage")
   @Column(name = "voltage", columnDefinition = "decimal(32,8)  COMMENT '电压(V)'", nullable = false)
   private BigDecimal voltage;

   public static TechCappCraftProductPassTaskRecord.TechCappCraftProductPassTaskRecordBuilder builder() {
      return new TechCappCraftProductPassTaskRecord.TechCappCraftProductPassTaskRecordBuilder();
   }

   public TechCappCraftProductPassTaskRecord() {
   }

   public TechCappCraftProductPassTaskRecord(
      final Long id, final Long techCappCraftProductPassTaskId, final BigDecimal electricity, final Long techCappCraftProductTaskId, final BigDecimal voltage
   ) {
      this.id = id;
      this.techCappCraftProductPassTaskId = techCappCraftProductPassTaskId;
      this.electricity = electricity;
      this.techCappCraftProductTaskId = techCappCraftProductTaskId;
      this.voltage = voltage;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTechCappCraftProductPassTaskId() {
      return this.techCappCraftProductPassTaskId;
   }

   public BigDecimal getElectricity() {
      return this.electricity;
   }

   public Long getTechCappCraftProductTaskId() {
      return this.techCappCraftProductTaskId;
   }

   public BigDecimal getVoltage() {
      return this.voltage;
   }

   public TechCappCraftProductPassTaskRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechCappCraftProductPassTaskRecord setTechCappCraftProductPassTaskId(final Long techCappCraftProductPassTaskId) {
      this.techCappCraftProductPassTaskId = techCappCraftProductPassTaskId;
      return this;
   }

   public TechCappCraftProductPassTaskRecord setElectricity(final BigDecimal electricity) {
      this.electricity = electricity;
      return this;
   }

   public TechCappCraftProductPassTaskRecord setTechCappCraftProductTaskId(final Long techCappCraftProductTaskId) {
      this.techCappCraftProductTaskId = techCappCraftProductTaskId;
      return this;
   }

   public TechCappCraftProductPassTaskRecord setVoltage(final BigDecimal voltage) {
      this.voltage = voltage;
      return this;
   }

   @Override
   public String toString() {
      return "TechCappCraftProductPassTaskRecord(id="
         + this.getId()
         + ", techCappCraftProductPassTaskId="
         + this.getTechCappCraftProductPassTaskId()
         + ", electricity="
         + this.getElectricity()
         + ", techCappCraftProductTaskId="
         + this.getTechCappCraftProductTaskId()
         + ", voltage="
         + this.getVoltage()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechCappCraftProductPassTaskRecord)) {
         return false;
      }

      TechCappCraftProductPassTaskRecord other = (TechCappCraftProductPassTaskRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$techCappCraftProductPassTaskId = this.getTechCappCraftProductPassTaskId();
         Object other$techCappCraftProductPassTaskId = other.getTechCappCraftProductPassTaskId();
         if (this$techCappCraftProductPassTaskId == null
            ? other$techCappCraftProductPassTaskId == null
            : this$techCappCraftProductPassTaskId.equals(other$techCappCraftProductPassTaskId)) {
            Object this$techCappCraftProductTaskId = this.getTechCappCraftProductTaskId();
            Object other$techCappCraftProductTaskId = other.getTechCappCraftProductTaskId();
            if (this$techCappCraftProductTaskId == null
               ? other$techCappCraftProductTaskId == null
               : this$techCappCraftProductTaskId.equals(other$techCappCraftProductTaskId)) {
               Object this$electricity = this.getElectricity();
               Object other$electricity = other.getElectricity();
               if (this$electricity == null ? other$electricity == null : this$electricity.equals(other$electricity)) {
                  Object this$voltage = this.getVoltage();
                  Object other$voltage = other.getVoltage();
                  return this$voltage == null ? other$voltage == null : this$voltage.equals(other$voltage);
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
      return other instanceof TechCappCraftProductPassTaskRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $techCappCraftProductPassTaskId = this.getTechCappCraftProductPassTaskId();
      result = result * 59 + ($techCappCraftProductPassTaskId == null ? 43 : $techCappCraftProductPassTaskId.hashCode());
      Object $techCappCraftProductTaskId = this.getTechCappCraftProductTaskId();
      result = result * 59 + ($techCappCraftProductTaskId == null ? 43 : $techCappCraftProductTaskId.hashCode());
      Object $electricity = this.getElectricity();
      result = result * 59 + ($electricity == null ? 43 : $electricity.hashCode());
      Object $voltage = this.getVoltage();
      return result * 59 + ($voltage == null ? 43 : $voltage.hashCode());
   }

   public static class TechCappCraftProductPassTaskRecordBuilder {
      private Long id;
      private Long techCappCraftProductPassTaskId;
      private BigDecimal electricity;
      private Long techCappCraftProductTaskId;
      private BigDecimal voltage;

      TechCappCraftProductPassTaskRecordBuilder() {
      }

      public TechCappCraftProductPassTaskRecord.TechCappCraftProductPassTaskRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechCappCraftProductPassTaskRecord.TechCappCraftProductPassTaskRecordBuilder techCappCraftProductPassTaskId(
         final Long techCappCraftProductPassTaskId
      ) {
         this.techCappCraftProductPassTaskId = techCappCraftProductPassTaskId;
         return this;
      }

      public TechCappCraftProductPassTaskRecord.TechCappCraftProductPassTaskRecordBuilder electricity(final BigDecimal electricity) {
         this.electricity = electricity;
         return this;
      }

      public TechCappCraftProductPassTaskRecord.TechCappCraftProductPassTaskRecordBuilder techCappCraftProductTaskId(final Long techCappCraftProductTaskId) {
         this.techCappCraftProductTaskId = techCappCraftProductTaskId;
         return this;
      }

      public TechCappCraftProductPassTaskRecord.TechCappCraftProductPassTaskRecordBuilder voltage(final BigDecimal voltage) {
         this.voltage = voltage;
         return this;
      }

      public TechCappCraftProductPassTaskRecord build() {
         return new TechCappCraftProductPassTaskRecord(
            this.id, this.techCappCraftProductPassTaskId, this.electricity, this.techCappCraftProductTaskId, this.voltage
         );
      }

      @Override
      public String toString() {
         return "TechCappCraftProductPassTaskRecord.TechCappCraftProductPassTaskRecordBuilder(id="
            + this.id
            + ", techCappCraftProductPassTaskId="
            + this.techCappCraftProductPassTaskId
            + ", electricity="
            + this.electricity
            + ", techCappCraftProductTaskId="
            + this.techCappCraftProductTaskId
            + ", voltage="
            + this.voltage
            + ")";
      }
   }
}
