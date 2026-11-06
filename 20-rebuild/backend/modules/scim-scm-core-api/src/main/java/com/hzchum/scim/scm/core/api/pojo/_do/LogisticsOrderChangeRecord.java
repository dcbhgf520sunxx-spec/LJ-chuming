package com.hzchum.scim.scm.core.api.pojo._do;

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

@ApiModel(value = "LogisticsOrderChangeRecord对象", description = "物流订单 变更日志")
@Entity
@TableName("scm_logistics_order_change_record")
@Table(name = "scm_logistics_order_change_record")
@org.hibernate.annotations.Table(appliesTo = "scm_logistics_order_change_record", comment = "物流订单 变更日志")
public class LogisticsOrderChangeRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "logisticsOrderId", value = "物流订单ID", notes = "物流订单ID")
   @TableField("logistics_order_id")
   @Column(name = "logistics_order_id", columnDefinition = "bigint  COMMENT '物流订单ID'", nullable = true)
   private Long logisticsOrderId;
   @ApiModelProperty(name = "freightOld", value = "变更前的运费 含税")
   @TableField("freight_old")
   @Column(name = "freight_old", columnDefinition = "decimal(19,2)  COMMENT '装车费 含税'", nullable = true)
   private BigDecimal freightOld;
   @ApiModelProperty(name = "freightNew", value = "变更后的运费 含税")
   @TableField("freight_new")
   @Column(name = "freight_new", columnDefinition = "decimal(19,2)  COMMENT '装车费 含税'", nullable = true)
   private BigDecimal freightNew;
   @ApiModelProperty(name = "freightExcludingVatOld", value = "变更前的运费 不含税")
   @TableField("freight_excluding_VAT_old")
   @Column(name = "freight_excluding_VAT_old", columnDefinition = "decimal(19,2)  COMMENT '装车费 含税'", nullable = true)
   private BigDecimal freightExcludingVatOld;
   @ApiModelProperty(name = "freightExcludingVatNew", value = "变更后的运费 不含税")
   @TableField("freight_excluding_VAT_new")
   @Column(name = "freight_excluding_VAT_new", columnDefinition = "decimal(19,2)  COMMENT '装车费 含税'", nullable = true)
   private BigDecimal freightExcludingVatNew;
   @ApiModelProperty(name = "inputVatOld", value = "变更前的进项税")
   @TableField("input_VAT_old")
   @Column(name = "input_VAT_old", columnDefinition = "decimal(19,2)  COMMENT '装车费 含税'", nullable = true)
   private BigDecimal inputVatOld;
   @ApiModelProperty(name = "inputVatNew", value = "变更后的进项税")
   @TableField("input_VAT_old_new")
   @Column(name = "input_VAT_old_new", columnDefinition = "decimal(19,2)  COMMENT '装车费 含税'", nullable = true)
   private BigDecimal inputVatOldNew;
   @ApiModelProperty(name = "reason", value = "变更原因")
   @TableField("reason")
   @Column(name = "reason", columnDefinition = "varchar(255)  COMMENT '变更原因'", nullable = true)
   private String reason;

   public static LogisticsOrderChangeRecord.LogisticsOrderChangeRecordBuilder builder() {
      return new LogisticsOrderChangeRecord.LogisticsOrderChangeRecordBuilder();
   }

   public LogisticsOrderChangeRecord() {
   }

   public LogisticsOrderChangeRecord(
      final Long id,
      final Long logisticsOrderId,
      final BigDecimal freightOld,
      final BigDecimal freightNew,
      final BigDecimal freightExcludingVatOld,
      final BigDecimal freightExcludingVatNew,
      final BigDecimal inputVatOld,
      final BigDecimal inputVatOldNew,
      final String reason
   ) {
      this.id = id;
      this.logisticsOrderId = logisticsOrderId;
      this.freightOld = freightOld;
      this.freightNew = freightNew;
      this.freightExcludingVatOld = freightExcludingVatOld;
      this.freightExcludingVatNew = freightExcludingVatNew;
      this.inputVatOld = inputVatOld;
      this.inputVatOldNew = inputVatOldNew;
      this.reason = reason;
   }

   public Long getId() {
      return this.id;
   }

   public Long getLogisticsOrderId() {
      return this.logisticsOrderId;
   }

   public BigDecimal getFreightOld() {
      return this.freightOld;
   }

   public BigDecimal getFreightNew() {
      return this.freightNew;
   }

   public BigDecimal getFreightExcludingVatOld() {
      return this.freightExcludingVatOld;
   }

   public BigDecimal getFreightExcludingVatNew() {
      return this.freightExcludingVatNew;
   }

   public BigDecimal getInputVatOld() {
      return this.inputVatOld;
   }

   public BigDecimal getInputVatOldNew() {
      return this.inputVatOldNew;
   }

   public String getReason() {
      return this.reason;
   }

   public LogisticsOrderChangeRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public LogisticsOrderChangeRecord setLogisticsOrderId(final Long logisticsOrderId) {
      this.logisticsOrderId = logisticsOrderId;
      return this;
   }

   public LogisticsOrderChangeRecord setFreightOld(final BigDecimal freightOld) {
      this.freightOld = freightOld;
      return this;
   }

   public LogisticsOrderChangeRecord setFreightNew(final BigDecimal freightNew) {
      this.freightNew = freightNew;
      return this;
   }

   public LogisticsOrderChangeRecord setFreightExcludingVatOld(final BigDecimal freightExcludingVatOld) {
      this.freightExcludingVatOld = freightExcludingVatOld;
      return this;
   }

   public LogisticsOrderChangeRecord setFreightExcludingVatNew(final BigDecimal freightExcludingVatNew) {
      this.freightExcludingVatNew = freightExcludingVatNew;
      return this;
   }

   public LogisticsOrderChangeRecord setInputVatOld(final BigDecimal inputVatOld) {
      this.inputVatOld = inputVatOld;
      return this;
   }

   public LogisticsOrderChangeRecord setInputVatOldNew(final BigDecimal inputVatOldNew) {
      this.inputVatOldNew = inputVatOldNew;
      return this;
   }

   public LogisticsOrderChangeRecord setReason(final String reason) {
      this.reason = reason;
      return this;
   }

   @Override
   public String toString() {
      return "LogisticsOrderChangeRecord(id="
         + this.getId()
         + ", logisticsOrderId="
         + this.getLogisticsOrderId()
         + ", freightOld="
         + this.getFreightOld()
         + ", freightNew="
         + this.getFreightNew()
         + ", freightExcludingVatOld="
         + this.getFreightExcludingVatOld()
         + ", freightExcludingVatNew="
         + this.getFreightExcludingVatNew()
         + ", inputVatOld="
         + this.getInputVatOld()
         + ", inputVatOldNew="
         + this.getInputVatOldNew()
         + ", reason="
         + this.getReason()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsOrderChangeRecord)) {
         return false;
      }

      LogisticsOrderChangeRecord other = (LogisticsOrderChangeRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$logisticsOrderId = this.getLogisticsOrderId();
         Object other$logisticsOrderId = other.getLogisticsOrderId();
         if (this$logisticsOrderId == null ? other$logisticsOrderId == null : this$logisticsOrderId.equals(other$logisticsOrderId)) {
            Object this$freightOld = this.getFreightOld();
            Object other$freightOld = other.getFreightOld();
            if (this$freightOld == null ? other$freightOld == null : this$freightOld.equals(other$freightOld)) {
               Object this$freightNew = this.getFreightNew();
               Object other$freightNew = other.getFreightNew();
               if (this$freightNew == null ? other$freightNew == null : this$freightNew.equals(other$freightNew)) {
                  Object this$freightExcludingVatOld = this.getFreightExcludingVatOld();
                  Object other$freightExcludingVatOld = other.getFreightExcludingVatOld();
                  if (this$freightExcludingVatOld == null
                     ? other$freightExcludingVatOld == null
                     : this$freightExcludingVatOld.equals(other$freightExcludingVatOld)) {
                     Object this$freightExcludingVatNew = this.getFreightExcludingVatNew();
                     Object other$freightExcludingVatNew = other.getFreightExcludingVatNew();
                     if (this$freightExcludingVatNew == null
                        ? other$freightExcludingVatNew == null
                        : this$freightExcludingVatNew.equals(other$freightExcludingVatNew)) {
                        Object this$inputVatOld = this.getInputVatOld();
                        Object other$inputVatOld = other.getInputVatOld();
                        if (this$inputVatOld == null ? other$inputVatOld == null : this$inputVatOld.equals(other$inputVatOld)) {
                           Object this$inputVatOldNew = this.getInputVatOldNew();
                           Object other$inputVatOldNew = other.getInputVatOldNew();
                           if (this$inputVatOldNew == null ? other$inputVatOldNew == null : this$inputVatOldNew.equals(other$inputVatOldNew)) {
                              Object this$reason = this.getReason();
                              Object other$reason = other.getReason();
                              return this$reason == null ? other$reason == null : this$reason.equals(other$reason);
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
      return other instanceof LogisticsOrderChangeRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $logisticsOrderId = this.getLogisticsOrderId();
      result = result * 59 + ($logisticsOrderId == null ? 43 : $logisticsOrderId.hashCode());
      Object $freightOld = this.getFreightOld();
      result = result * 59 + ($freightOld == null ? 43 : $freightOld.hashCode());
      Object $freightNew = this.getFreightNew();
      result = result * 59 + ($freightNew == null ? 43 : $freightNew.hashCode());
      Object $freightExcludingVatOld = this.getFreightExcludingVatOld();
      result = result * 59 + ($freightExcludingVatOld == null ? 43 : $freightExcludingVatOld.hashCode());
      Object $freightExcludingVatNew = this.getFreightExcludingVatNew();
      result = result * 59 + ($freightExcludingVatNew == null ? 43 : $freightExcludingVatNew.hashCode());
      Object $inputVatOld = this.getInputVatOld();
      result = result * 59 + ($inputVatOld == null ? 43 : $inputVatOld.hashCode());
      Object $inputVatOldNew = this.getInputVatOldNew();
      result = result * 59 + ($inputVatOldNew == null ? 43 : $inputVatOldNew.hashCode());
      Object $reason = this.getReason();
      return result * 59 + ($reason == null ? 43 : $reason.hashCode());
   }

   public static class LogisticsOrderChangeRecordBuilder {
      private Long id;
      private Long logisticsOrderId;
      private BigDecimal freightOld;
      private BigDecimal freightNew;
      private BigDecimal freightExcludingVatOld;
      private BigDecimal freightExcludingVatNew;
      private BigDecimal inputVatOld;
      private BigDecimal inputVatOldNew;
      private String reason;

      LogisticsOrderChangeRecordBuilder() {
      }

      public LogisticsOrderChangeRecord.LogisticsOrderChangeRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public LogisticsOrderChangeRecord.LogisticsOrderChangeRecordBuilder logisticsOrderId(final Long logisticsOrderId) {
         this.logisticsOrderId = logisticsOrderId;
         return this;
      }

      public LogisticsOrderChangeRecord.LogisticsOrderChangeRecordBuilder freightOld(final BigDecimal freightOld) {
         this.freightOld = freightOld;
         return this;
      }

      public LogisticsOrderChangeRecord.LogisticsOrderChangeRecordBuilder freightNew(final BigDecimal freightNew) {
         this.freightNew = freightNew;
         return this;
      }

      public LogisticsOrderChangeRecord.LogisticsOrderChangeRecordBuilder freightExcludingVatOld(final BigDecimal freightExcludingVatOld) {
         this.freightExcludingVatOld = freightExcludingVatOld;
         return this;
      }

      public LogisticsOrderChangeRecord.LogisticsOrderChangeRecordBuilder freightExcludingVatNew(final BigDecimal freightExcludingVatNew) {
         this.freightExcludingVatNew = freightExcludingVatNew;
         return this;
      }

      public LogisticsOrderChangeRecord.LogisticsOrderChangeRecordBuilder inputVatOld(final BigDecimal inputVatOld) {
         this.inputVatOld = inputVatOld;
         return this;
      }

      public LogisticsOrderChangeRecord.LogisticsOrderChangeRecordBuilder inputVatOldNew(final BigDecimal inputVatOldNew) {
         this.inputVatOldNew = inputVatOldNew;
         return this;
      }

      public LogisticsOrderChangeRecord.LogisticsOrderChangeRecordBuilder reason(final String reason) {
         this.reason = reason;
         return this;
      }

      public LogisticsOrderChangeRecord build() {
         return new LogisticsOrderChangeRecord(
            this.id,
            this.logisticsOrderId,
            this.freightOld,
            this.freightNew,
            this.freightExcludingVatOld,
            this.freightExcludingVatNew,
            this.inputVatOld,
            this.inputVatOldNew,
            this.reason
         );
      }

      @Override
      public String toString() {
         return "LogisticsOrderChangeRecord.LogisticsOrderChangeRecordBuilder(id="
            + this.id
            + ", logisticsOrderId="
            + this.logisticsOrderId
            + ", freightOld="
            + this.freightOld
            + ", freightNew="
            + this.freightNew
            + ", freightExcludingVatOld="
            + this.freightExcludingVatOld
            + ", freightExcludingVatNew="
            + this.freightExcludingVatNew
            + ", inputVatOld="
            + this.inputVatOld
            + ", inputVatOldNew="
            + this.inputVatOldNew
            + ", reason="
            + this.reason
            + ")";
      }
   }
}
