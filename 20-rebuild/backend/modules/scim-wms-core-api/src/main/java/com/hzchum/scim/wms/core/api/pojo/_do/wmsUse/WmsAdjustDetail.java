package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
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

@ApiModel(value = "WmsAdjustDetail对象", description = "")
@Entity
@TableName("wms_adjust_detail")
@Table(name = "wms_adjust_detail")
@org.hibernate.annotations.Table(appliesTo = "wms_adjust_detail")
public class WmsAdjustDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "amount", value = "入库总价（不含运费）")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount")
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价（不含运费）")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT")
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "进项税")
   @JsonProperty("inputVat")
   @JSONField(name = "inputVat")
   @TableField("input_VAT")
   @Column(name = "input_VAT")
   private BigDecimal inputVat;
   @ApiModelProperty(name = "inboundDetailId", value = "入库明细id")
   @JsonProperty("inboundDetailId")
   @JSONField(name = "inboundDetailId")
   @TableField("inbound_detail_id")
   @Column(name = "inbound_detail_id")
   private Long inboundDetailId;
   @ApiModelProperty(name = "adjustId", value = "调整单id")
   @JsonProperty("adjustId")
   @JSONField(name = "adjustId")
   @TableField("adjust_id")
   @Column(name = "adjust_id")
   private Long adjustId;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status")
   private Integer reviewStatus;
   @ApiModelProperty(name = "differentAmount", value = "与上次调整的差总价")
   @JsonProperty("differentAmount")
   @JSONField(name = "differentAmount")
   @TableField("different_amount")
   @Column(name = "different_amount")
   private BigDecimal differentAmount;
   @ApiModelProperty(name = "differentAmountExcludingVat", value = "与上次调整的差不含税总价")
   @JsonProperty("differentAmountExcludingVat")
   @JSONField(name = "differentAmountExcludingVat")
   @TableField("different_amount_excluding_VAT")
   @Column(name = "different_amount_excluding_VAT")
   private BigDecimal differentAmountExcludingVat;
   @ApiModelProperty(name = "serialNumber", value = "调整单号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;

   public static WmsAdjustDetail.WmsAdjustDetailBuilder builder() {
      return new WmsAdjustDetail.WmsAdjustDetailBuilder();
   }

   public WmsAdjustDetail() {
   }

   public WmsAdjustDetail(
      final Long id,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final Long inboundDetailId,
      final Long adjustId,
      final Integer reviewStatus,
      final BigDecimal differentAmount,
      final BigDecimal differentAmountExcludingVat,
      final String serialNumber
   ) {
      this.id = id;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.inboundDetailId = inboundDetailId;
      this.adjustId = adjustId;
      this.reviewStatus = reviewStatus;
      this.differentAmount = differentAmount;
      this.differentAmountExcludingVat = differentAmountExcludingVat;
      this.serialNumber = serialNumber;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public Long getInboundDetailId() {
      return this.inboundDetailId;
   }

   public Long getAdjustId() {
      return this.adjustId;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public BigDecimal getDifferentAmount() {
      return this.differentAmount;
   }

   public BigDecimal getDifferentAmountExcludingVat() {
      return this.differentAmountExcludingVat;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public WmsAdjustDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("amount")
   public WmsAdjustDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public WmsAdjustDetail setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public WmsAdjustDetail setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("inboundDetailId")
   public WmsAdjustDetail setInboundDetailId(final Long inboundDetailId) {
      this.inboundDetailId = inboundDetailId;
      return this;
   }

   @JsonProperty("adjustId")
   public WmsAdjustDetail setAdjustId(final Long adjustId) {
      this.adjustId = adjustId;
      return this;
   }

   @JsonProperty("reviewStatus")
   public WmsAdjustDetail setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("differentAmount")
   public WmsAdjustDetail setDifferentAmount(final BigDecimal differentAmount) {
      this.differentAmount = differentAmount;
      return this;
   }

   @JsonProperty("differentAmountExcludingVat")
   public WmsAdjustDetail setDifferentAmountExcludingVat(final BigDecimal differentAmountExcludingVat) {
      this.differentAmountExcludingVat = differentAmountExcludingVat;
      return this;
   }

   @JsonProperty("serialNumber")
   public WmsAdjustDetail setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "WmsAdjustDetail(id="
         + this.getId()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", inboundDetailId="
         + this.getInboundDetailId()
         + ", adjustId="
         + this.getAdjustId()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", differentAmount="
         + this.getDifferentAmount()
         + ", differentAmountExcludingVat="
         + this.getDifferentAmountExcludingVat()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsAdjustDetail)) {
         return false;
      }

      WmsAdjustDetail other = (WmsAdjustDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inboundDetailId = this.getInboundDetailId();
         Object other$inboundDetailId = other.getInboundDetailId();
         if (this$inboundDetailId == null ? other$inboundDetailId == null : this$inboundDetailId.equals(other$inboundDetailId)) {
            Object this$adjustId = this.getAdjustId();
            Object other$adjustId = other.getAdjustId();
            if (this$adjustId == null ? other$adjustId == null : this$adjustId.equals(other$adjustId)) {
               Object this$reviewStatus = this.getReviewStatus();
               Object other$reviewStatus = other.getReviewStatus();
               if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                  Object this$amount = this.getAmount();
                  Object other$amount = other.getAmount();
                  if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                     Object this$amountExcludingVat = this.getAmountExcludingVat();
                     Object other$amountExcludingVat = other.getAmountExcludingVat();
                     if (this$amountExcludingVat == null ? other$amountExcludingVat == null : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                        Object this$inputVat = this.getInputVat();
                        Object other$inputVat = other.getInputVat();
                        if (this$inputVat == null ? other$inputVat == null : this$inputVat.equals(other$inputVat)) {
                           Object this$differentAmount = this.getDifferentAmount();
                           Object other$differentAmount = other.getDifferentAmount();
                           if (this$differentAmount == null ? other$differentAmount == null : this$differentAmount.equals(other$differentAmount)) {
                              Object this$differentAmountExcludingVat = this.getDifferentAmountExcludingVat();
                              Object other$differentAmountExcludingVat = other.getDifferentAmountExcludingVat();
                              if (this$differentAmountExcludingVat == null
                                 ? other$differentAmountExcludingVat == null
                                 : this$differentAmountExcludingVat.equals(other$differentAmountExcludingVat)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof WmsAdjustDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inboundDetailId = this.getInboundDetailId();
      result = result * 59 + ($inboundDetailId == null ? 43 : $inboundDetailId.hashCode());
      Object $adjustId = this.getAdjustId();
      result = result * 59 + ($adjustId == null ? 43 : $adjustId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $differentAmount = this.getDifferentAmount();
      result = result * 59 + ($differentAmount == null ? 43 : $differentAmount.hashCode());
      Object $differentAmountExcludingVat = this.getDifferentAmountExcludingVat();
      result = result * 59 + ($differentAmountExcludingVat == null ? 43 : $differentAmountExcludingVat.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   public static class WmsAdjustDetailBuilder {
      private Long id;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private Long inboundDetailId;
      private Long adjustId;
      private Integer reviewStatus;
      private BigDecimal differentAmount;
      private BigDecimal differentAmountExcludingVat;
      private String serialNumber;

      WmsAdjustDetailBuilder() {
      }

      public WmsAdjustDetail.WmsAdjustDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("amount")
      public WmsAdjustDetail.WmsAdjustDetailBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public WmsAdjustDetail.WmsAdjustDetailBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public WmsAdjustDetail.WmsAdjustDetailBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("inboundDetailId")
      public WmsAdjustDetail.WmsAdjustDetailBuilder inboundDetailId(final Long inboundDetailId) {
         this.inboundDetailId = inboundDetailId;
         return this;
      }

      @JsonProperty("adjustId")
      public WmsAdjustDetail.WmsAdjustDetailBuilder adjustId(final Long adjustId) {
         this.adjustId = adjustId;
         return this;
      }

      @JsonProperty("reviewStatus")
      public WmsAdjustDetail.WmsAdjustDetailBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("differentAmount")
      public WmsAdjustDetail.WmsAdjustDetailBuilder differentAmount(final BigDecimal differentAmount) {
         this.differentAmount = differentAmount;
         return this;
      }

      @JsonProperty("differentAmountExcludingVat")
      public WmsAdjustDetail.WmsAdjustDetailBuilder differentAmountExcludingVat(final BigDecimal differentAmountExcludingVat) {
         this.differentAmountExcludingVat = differentAmountExcludingVat;
         return this;
      }

      @JsonProperty("serialNumber")
      public WmsAdjustDetail.WmsAdjustDetailBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public WmsAdjustDetail build() {
         return new WmsAdjustDetail(
            this.id,
            this.amount,
            this.amountExcludingVat,
            this.inputVat,
            this.inboundDetailId,
            this.adjustId,
            this.reviewStatus,
            this.differentAmount,
            this.differentAmountExcludingVat,
            this.serialNumber
         );
      }

      @Override
      public String toString() {
         return "WmsAdjustDetail.WmsAdjustDetailBuilder(id="
            + this.id
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", inboundDetailId="
            + this.inboundDetailId
            + ", adjustId="
            + this.adjustId
            + ", reviewStatus="
            + this.reviewStatus
            + ", differentAmount="
            + this.differentAmount
            + ", differentAmountExcludingVat="
            + this.differentAmountExcludingVat
            + ", serialNumber="
            + this.serialNumber
            + ")";
      }
   }
}
