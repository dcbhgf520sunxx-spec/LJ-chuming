package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "WmsRestitutionDetail对象", description = "归还明细")
@Entity
@TableName("wms_restitution_detail")
@Table(name = "wms_restitution_detail")
public class WmsRestitutionDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "outboundDetailId", value = "出库单明细ID（本条归还明细对应的借用出库明细）", notes = "出库单明细ID")
   @JsonProperty("outboundDetailId")
   @JSONField(name = "outboundDetailId")
   @TableField("outbound_detail_Id")
   @Column(name = "outbound_detail_Id", columnDefinition = "bigint  COMMENT '出库单明细ID'", nullable = true)
   private Long outboundDetailId;
   @ApiModelProperty(name = "restitutionId", value = "退还单ID", notes = "退还单ID")
   @JsonProperty("restitutionId")
   @JSONField(name = "restitutionId")
   @TableField("restitution_id")
   @Column(name = "restitution_id", columnDefinition = "bigint  COMMENT '退还单ID'", nullable = true)
   private Long restitutionId;
   @ApiModelProperty(name = "quantity", value = "退还数量", notes = "退还数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '退还数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "退还核算量", notes = "退还核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '退还核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "time", value = "退还时间", notes = "退还时间")
   @JsonProperty("time")
   @JSONField(name = "time")
   @TableField("time")
   @Column(name = "time", columnDefinition = "datetime  COMMENT '退还时间'", nullable = true)
   private LocalDateTime time;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "amount", value = "报损含税总价", notes = "报损含税总价")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField(value = "amount", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '报损含税总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "unitPrice", value = "含税单价", notes = "含税单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField(value = "unit_price", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '含税单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价", notes = "不含税总价")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税单价", notes = "不含税单价")
   @JsonProperty("unitPriceExcludingVat")
   @JSONField(name = "unitPriceExcludingVat")
   @TableField("unit_price_excluding_VAT")
   @Column(name = "unit_price_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '不含税单价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "进项税", notes = "进项税")
   @JsonProperty("inputVat")
   @JSONField(name = "inputVat")
   @TableField("input_VAT")
   @Column(name = "input_VAT", columnDefinition = "decimal(32,12)  COMMENT '进项税'", nullable = true)
   private BigDecimal inputVat;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "移动加权价 不含运费", notes = "移动加权价 不含运费")
   @JsonProperty("unitPriceNoFreight")
   @JSONField(name = "unitPriceNoFreight")
   @TableField("unit_price_no_freight")
   @Column(name = "unit_price_no_freight", columnDefinition = "decimal(32,8)  COMMENT '移动加权价 不含运费'", nullable = true)
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "unitPriceExcludingVatNoFreight", value = "不含税加权价 不含运费", notes = "不含税加权价 不含运费")
   @JsonProperty("unitPriceExcludingVatNoFreight")
   @JSONField(name = "unitPriceExcludingVatNoFreight")
   @TableField("unit_price_excluding_VAT_no_freight")
   @Column(name = "unit_price_excluding_VAT_no_freight", columnDefinition = "decimal(32,8)  COMMENT '不含税加权价 不含运费'", nullable = true)
   private BigDecimal unitPriceExcludingVatNoFreight;
   @ApiModelProperty(name = "amountNoFreight", value = "总价 不含运费", notes = "总价 不含运费")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '总价 不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "不含税总价 不含运费", notes = "不含税总价 不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_vat_no_freight")
   @Column(name = "amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税总价 不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "borrowAmount", value = "含税总价(原价格 借出价格)", notes = "报损含税总价(原价格 借出价格)")
   @JsonProperty("borrowAmount")
   @JSONField(name = "borrowAmount")
   @TableField(value = "borrow_amount", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "borrow_amount", columnDefinition = "decimal(32,12)  COMMENT '报损含税总价(原价格 借出价格)'", nullable = true)
   private BigDecimal borrowAmount;
   @ApiModelProperty(name = "borrowAmountExcludingVat", value = "不含税总价(原价格 借出价格)", notes = "不含税总价(原价格 借出价格)")
   @JsonProperty("borrowAmountExcludingVat")
   @JSONField(name = "borrowAmountExcludingVat")
   @TableField("borrow_amount_excluding_VAT")
   @Column(name = "borrow_amount_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '不含税总价(原价格 借出价格)'", nullable = true)
   private BigDecimal borrowAmountExcludingVat;
   @ApiModelProperty(name = "restitutionType", value = "退还类型", notes = "退还类型")
   @JsonProperty("restitutionType")
   @JSONField(name = "restitutionType")
   @TableField("restitution_type")
   @Column(name = "restitution_type", columnDefinition = "int  COMMENT '1归还 2报损'", nullable = true)
   private Integer restitutionType;

   public static WmsRestitutionDetail.WmsRestitutionDetailBuilder builder() {
      return new WmsRestitutionDetail.WmsRestitutionDetailBuilder();
   }

   public WmsRestitutionDetail() {
   }

   public WmsRestitutionDetail(
      final Long id,
      final Long outboundDetailId,
      final Long restitutionId,
      final BigDecimal quantity,
      final BigDecimal mete,
      final LocalDateTime time,
      final BigDecimal taxRate,
      final BigDecimal amount,
      final BigDecimal unitPrice,
      final BigDecimal amountExcludingVat,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal inputVat,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal unitPriceExcludingVatNoFreight,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal borrowAmount,
      final BigDecimal borrowAmountExcludingVat,
      final Integer restitutionType
   ) {
      this.id = id;
      this.outboundDetailId = outboundDetailId;
      this.restitutionId = restitutionId;
      this.quantity = quantity;
      this.mete = mete;
      this.time = time;
      this.taxRate = taxRate;
      this.amount = amount;
      this.unitPrice = unitPrice;
      this.amountExcludingVat = amountExcludingVat;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.inputVat = inputVat;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.borrowAmount = borrowAmount;
      this.borrowAmountExcludingVat = borrowAmountExcludingVat;
      this.restitutionType = restitutionType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getOutboundDetailId() {
      return this.outboundDetailId;
   }

   public Long getRestitutionId() {
      return this.restitutionId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public LocalDateTime getTime() {
      return this.time;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public BigDecimal getUnitPriceExcludingVatNoFreight() {
      return this.unitPriceExcludingVatNoFreight;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public BigDecimal getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   public BigDecimal getBorrowAmount() {
      return this.borrowAmount;
   }

   public BigDecimal getBorrowAmountExcludingVat() {
      return this.borrowAmountExcludingVat;
   }

   public Integer getRestitutionType() {
      return this.restitutionType;
   }

   public WmsRestitutionDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("outboundDetailId")
   public WmsRestitutionDetail setOutboundDetailId(final Long outboundDetailId) {
      this.outboundDetailId = outboundDetailId;
      return this;
   }

   @JsonProperty("restitutionId")
   public WmsRestitutionDetail setRestitutionId(final Long restitutionId) {
      this.restitutionId = restitutionId;
      return this;
   }

   @JsonProperty("quantity")
   public WmsRestitutionDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public WmsRestitutionDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("time")
   public WmsRestitutionDetail setTime(final LocalDateTime time) {
      this.time = time;
      return this;
   }

   @JsonProperty("taxRate")
   public WmsRestitutionDetail setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("amount")
   public WmsRestitutionDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("unitPrice")
   public WmsRestitutionDetail setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public WmsRestitutionDetail setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public WmsRestitutionDetail setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public WmsRestitutionDetail setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("unitPriceNoFreight")
   public WmsRestitutionDetail setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   @JsonProperty("unitPriceExcludingVatNoFreight")
   public WmsRestitutionDetail setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public WmsRestitutionDetail setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public WmsRestitutionDetail setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("borrowAmount")
   public WmsRestitutionDetail setBorrowAmount(final BigDecimal borrowAmount) {
      this.borrowAmount = borrowAmount;
      return this;
   }

   @JsonProperty("borrowAmountExcludingVat")
   public WmsRestitutionDetail setBorrowAmountExcludingVat(final BigDecimal borrowAmountExcludingVat) {
      this.borrowAmountExcludingVat = borrowAmountExcludingVat;
      return this;
   }

   @JsonProperty("restitutionType")
   public WmsRestitutionDetail setRestitutionType(final Integer restitutionType) {
      this.restitutionType = restitutionType;
      return this;
   }

   @Override
   public String toString() {
      return "WmsRestitutionDetail(id="
         + this.getId()
         + ", outboundDetailId="
         + this.getOutboundDetailId()
         + ", restitutionId="
         + this.getRestitutionId()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", time="
         + this.getTime()
         + ", taxRate="
         + this.getTaxRate()
         + ", amount="
         + this.getAmount()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", unitPriceExcludingVatNoFreight="
         + this.getUnitPriceExcludingVatNoFreight()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", borrowAmount="
         + this.getBorrowAmount()
         + ", borrowAmountExcludingVat="
         + this.getBorrowAmountExcludingVat()
         + ", restitutionType="
         + this.getRestitutionType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsRestitutionDetail)) {
         return false;
      }

      WmsRestitutionDetail other = (WmsRestitutionDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$outboundDetailId = this.getOutboundDetailId();
         Object other$outboundDetailId = other.getOutboundDetailId();
         if (this$outboundDetailId == null ? other$outboundDetailId == null : this$outboundDetailId.equals(other$outboundDetailId)) {
            Object this$restitutionId = this.getRestitutionId();
            Object other$restitutionId = other.getRestitutionId();
            if (this$restitutionId == null ? other$restitutionId == null : this$restitutionId.equals(other$restitutionId)) {
               Object this$restitutionType = this.getRestitutionType();
               Object other$restitutionType = other.getRestitutionType();
               if (this$restitutionType == null ? other$restitutionType == null : this$restitutionType.equals(other$restitutionType)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$mete = this.getMete();
                     Object other$mete = other.getMete();
                     if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                        Object this$time = this.getTime();
                        Object other$time = other.getTime();
                        if (this$time == null ? other$time == null : this$time.equals(other$time)) {
                           Object this$taxRate = this.getTaxRate();
                           Object other$taxRate = other.getTaxRate();
                           if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                              Object this$amount = this.getAmount();
                              Object other$amount = other.getAmount();
                              if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                 Object this$unitPrice = this.getUnitPrice();
                                 Object other$unitPrice = other.getUnitPrice();
                                 if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                    Object this$amountExcludingVat = this.getAmountExcludingVat();
                                    Object other$amountExcludingVat = other.getAmountExcludingVat();
                                    if (this$amountExcludingVat == null
                                       ? other$amountExcludingVat == null
                                       : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                       Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                       Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                       if (this$unitPriceExcludingVat == null
                                          ? other$unitPriceExcludingVat == null
                                          : this$unitPriceExcludingVat.equals(other$unitPriceExcludingVat)) {
                                          Object this$inputVat = this.getInputVat();
                                          Object other$inputVat = other.getInputVat();
                                          if (this$inputVat == null ? other$inputVat == null : this$inputVat.equals(other$inputVat)) {
                                             Object this$unitPriceNoFreight = this.getUnitPriceNoFreight();
                                             Object other$unitPriceNoFreight = other.getUnitPriceNoFreight();
                                             if (this$unitPriceNoFreight == null
                                                ? other$unitPriceNoFreight == null
                                                : this$unitPriceNoFreight.equals(other$unitPriceNoFreight)) {
                                                Object this$unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
                                                Object other$unitPriceExcludingVatNoFreight = other.getUnitPriceExcludingVatNoFreight();
                                                if (this$unitPriceExcludingVatNoFreight == null
                                                   ? other$unitPriceExcludingVatNoFreight == null
                                                   : this$unitPriceExcludingVatNoFreight.equals(other$unitPriceExcludingVatNoFreight)) {
                                                   Object this$amountNoFreight = this.getAmountNoFreight();
                                                   Object other$amountNoFreight = other.getAmountNoFreight();
                                                   if (this$amountNoFreight == null
                                                      ? other$amountNoFreight == null
                                                      : this$amountNoFreight.equals(other$amountNoFreight)) {
                                                      Object this$amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
                                                      Object other$amountExcludingVatNoFreight = other.getAmountExcludingVatNoFreight();
                                                      if (this$amountExcludingVatNoFreight == null
                                                         ? other$amountExcludingVatNoFreight == null
                                                         : this$amountExcludingVatNoFreight.equals(other$amountExcludingVatNoFreight)) {
                                                         Object this$borrowAmount = this.getBorrowAmount();
                                                         Object other$borrowAmount = other.getBorrowAmount();
                                                         if (this$borrowAmount == null
                                                            ? other$borrowAmount == null
                                                            : this$borrowAmount.equals(other$borrowAmount)) {
                                                            Object this$borrowAmountExcludingVat = this.getBorrowAmountExcludingVat();
                                                            Object other$borrowAmountExcludingVat = other.getBorrowAmountExcludingVat();
                                                            return this$borrowAmountExcludingVat == null
                                                               ? other$borrowAmountExcludingVat == null
                                                               : this$borrowAmountExcludingVat.equals(other$borrowAmountExcludingVat);
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
      return other instanceof WmsRestitutionDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $outboundDetailId = this.getOutboundDetailId();
      result = result * 59 + ($outboundDetailId == null ? 43 : $outboundDetailId.hashCode());
      Object $restitutionId = this.getRestitutionId();
      result = result * 59 + ($restitutionId == null ? 43 : $restitutionId.hashCode());
      Object $restitutionType = this.getRestitutionType();
      result = result * 59 + ($restitutionType == null ? 43 : $restitutionType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $time = this.getTime();
      result = result * 59 + ($time == null ? 43 : $time.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
      result = result * 59 + ($unitPriceExcludingVatNoFreight == null ? 43 : $unitPriceExcludingVatNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $borrowAmount = this.getBorrowAmount();
      result = result * 59 + ($borrowAmount == null ? 43 : $borrowAmount.hashCode());
      Object $borrowAmountExcludingVat = this.getBorrowAmountExcludingVat();
      return result * 59 + ($borrowAmountExcludingVat == null ? 43 : $borrowAmountExcludingVat.hashCode());
   }

   public static class WmsRestitutionDetailBuilder {
      private Long id;
      private Long outboundDetailId;
      private Long restitutionId;
      private BigDecimal quantity;
      private BigDecimal mete;
      private LocalDateTime time;
      private BigDecimal taxRate;
      private BigDecimal amount;
      private BigDecimal unitPrice;
      private BigDecimal amountExcludingVat;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal inputVat;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal unitPriceExcludingVatNoFreight;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal borrowAmount;
      private BigDecimal borrowAmountExcludingVat;
      private Integer restitutionType;

      WmsRestitutionDetailBuilder() {
      }

      public WmsRestitutionDetail.WmsRestitutionDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("outboundDetailId")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder outboundDetailId(final Long outboundDetailId) {
         this.outboundDetailId = outboundDetailId;
         return this;
      }

      @JsonProperty("restitutionId")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder restitutionId(final Long restitutionId) {
         this.restitutionId = restitutionId;
         return this;
      }

      @JsonProperty("quantity")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("time")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder time(final LocalDateTime time) {
         this.time = time;
         return this;
      }

      @JsonProperty("taxRate")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("amount")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("unitPrice")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("unitPriceNoFreight")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      @JsonProperty("unitPriceExcludingVatNoFreight")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder unitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
         this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("borrowAmount")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder borrowAmount(final BigDecimal borrowAmount) {
         this.borrowAmount = borrowAmount;
         return this;
      }

      @JsonProperty("borrowAmountExcludingVat")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder borrowAmountExcludingVat(final BigDecimal borrowAmountExcludingVat) {
         this.borrowAmountExcludingVat = borrowAmountExcludingVat;
         return this;
      }

      @JsonProperty("restitutionType")
      public WmsRestitutionDetail.WmsRestitutionDetailBuilder restitutionType(final Integer restitutionType) {
         this.restitutionType = restitutionType;
         return this;
      }

      public WmsRestitutionDetail build() {
         return new WmsRestitutionDetail(
            this.id,
            this.outboundDetailId,
            this.restitutionId,
            this.quantity,
            this.mete,
            this.time,
            this.taxRate,
            this.amount,
            this.unitPrice,
            this.amountExcludingVat,
            this.unitPriceExcludingVat,
            this.inputVat,
            this.unitPriceNoFreight,
            this.unitPriceExcludingVatNoFreight,
            this.amountNoFreight,
            this.amountExcludingVatNoFreight,
            this.borrowAmount,
            this.borrowAmountExcludingVat,
            this.restitutionType
         );
      }

      @Override
      public String toString() {
         return "WmsRestitutionDetail.WmsRestitutionDetailBuilder(id="
            + this.id
            + ", outboundDetailId="
            + this.outboundDetailId
            + ", restitutionId="
            + this.restitutionId
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", time="
            + this.time
            + ", taxRate="
            + this.taxRate
            + ", amount="
            + this.amount
            + ", unitPrice="
            + this.unitPrice
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", unitPriceExcludingVatNoFreight="
            + this.unitPriceExcludingVatNoFreight
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", borrowAmount="
            + this.borrowAmount
            + ", borrowAmountExcludingVat="
            + this.borrowAmountExcludingVat
            + ", restitutionType="
            + this.restitutionType
            + ")";
      }
   }
}
