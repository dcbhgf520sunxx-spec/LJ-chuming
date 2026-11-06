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

@ApiModel(value = "WmsForSaleDetail对象", description = "对外销售明细表")
@Entity
@TableName("wms_for_sale_detail")
@Table(name = "wms_for_sale_detail")
@org.hibernate.annotations.Table(appliesTo = "wms_for_sale_detail", comment = "对外销售明细表")
public class WmsForSaleDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "forSaleSerialNumber", value = "对外出售单编号", notes = "对外出售单编号")
   @TableField("for_sale_serial_number")
   @Column(name = "for_sale_serial_number", columnDefinition = "varchar(255)  COMMENT '对外出售单编号'", nullable = true)
   private String forSaleSerialNumber;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "systemMete", value = "系统核算量", notes = "系统核算量")
   @TableField("system_mete")
   @Column(name = "system_mete", columnDefinition = "decimal(32,8)  COMMENT '系统核算量'", nullable = true)
   private BigDecimal systemMete;
   @ApiModelProperty(name = "inputMete", value = "用户输入重量(理论重量or过磅重量)", notes = "用户输入重量(理论重量or过磅重量)")
   @TableField("input_mete")
   @Column(name = "input_mete", columnDefinition = "decimal(32,8)  COMMENT '用户输入重量(理论重量or过磅重量)'", nullable = true)
   private BigDecimal inputMete;
   @ApiModelProperty(name = "differenceMete", value = "差异重量", notes = "差异重量")
   @TableField("difference_mete")
   @Column(name = "difference_mete", columnDefinition = "decimal(32,8)  COMMENT '差异重量'", nullable = true)
   private BigDecimal differenceMete;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式 [1理计 , 2 磅计 ,混合计] MeasureEnum", notes = "重量计量方式 [1理计 , 2 磅计 ,混合计] MeasureEnum")
   @TableField("weight_measurement_mode")
   @Column(name = "weight_measurement_mode", columnDefinition = "int  COMMENT '重量计量方式 [1理计 , 2 磅计 ,混合计] MeasureEnum'", nullable = true)
   private Integer weightMeasurementMode;
   @ApiModelProperty(name = "unitPrice", value = "成本含税单价", notes = "成本含税单价")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '成本含税单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "成本不含税单价", notes = "成本不含税单价")
   @TableField("unit_price_excluding_VAT")
   @Column(name = "unit_price_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '成本不含税单价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "amount", value = "成本含税总价", notes = "成本含税总价")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '成本含税总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "成本不含税总价", notes = "成本不含税总价")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '成本不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "成本进项税", notes = "成本进项税")
   @TableField("input_VAT")
   @Column(name = "input_VAT", columnDefinition = "decimal(32,12)  COMMENT '成本进项税'", nullable = true)
   private BigDecimal inputVat;
   @ApiModelProperty(name = "sellUnitPrice", value = "出售含税单价", notes = "出售含税单价")
   @TableField("sell_unit_price")
   @Column(name = "sell_unit_price", columnDefinition = "decimal(32,12)  COMMENT '出售含税单价'", nullable = true)
   private BigDecimal sellUnitPrice;
   @ApiModelProperty(name = "sellUnitPriceExcludingVat", value = "出售不含税单价", notes = "出售不含税单价")
   @TableField("sell_unit_price_excluding_VAT")
   @Column(name = "sell_unit_price_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '出售不含税单价'", nullable = true)
   private BigDecimal sellUnitPriceExcludingVat;
   @ApiModelProperty(name = "sellAmount", value = "出售含税总价", notes = "出售含税总价")
   @TableField("sell_amount")
   @Column(name = "sell_amount", columnDefinition = "decimal(32,12)  COMMENT '出售含税总价'", nullable = true)
   private BigDecimal sellAmount;
   @ApiModelProperty(name = "sellAmountExcludingVat", value = "出售不含税总价", notes = "出售不含税总价")
   @TableField("sell_amount_excluding_VAT")
   @Column(name = "sell_amount_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '出售不含税总价'", nullable = true)
   private BigDecimal sellAmountExcludingVat;
   @ApiModelProperty(name = "sellInputVat", value = "出售进项税", notes = "出售进项税")
   @TableField("sell_input_VAT")
   @Column(name = "sell_input_VAT", columnDefinition = "decimal(32,12)  COMMENT '出售进项税'", nullable = true)
   private BigDecimal sellInputVat;
   @ApiModelProperty(name = "profitAmount", value = "盈利总价", notes = "盈利总价")
   @TableField("profit_amount")
   @Column(name = "profit_amount", columnDefinition = "decimal(32,12)  COMMENT '盈利总价'", nullable = true)
   private BigDecimal profitAmount;
   @ApiModelProperty(name = "profitAmountExcludingVat", value = "盈利不含税总价", notes = "盈利不含税总价")
   @TableField("profit_amount_excluding_VAT")
   @Column(name = "profit_amount_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '盈利不含税总价'", nullable = true)
   private BigDecimal profitAmountExcludingVat;
   @ApiModelProperty(name = "profitInputVat", value = "盈利进项税", notes = "盈利进项税")
   @TableField("profit_input_VAT")
   @Column(name = "profit_input_VAT", columnDefinition = "decimal(32,12)  COMMENT '盈利进项税'", nullable = true)
   private BigDecimal profitInputVat;
   @ApiModelProperty(name = "outboundDetailId", value = "出库明细ID", notes = "出库明细ID")
   @TableField("outbound_detail_id")
   @Column(name = "outbound_detail_id", columnDefinition = "bigint  COMMENT '出库明细ID'", nullable = true)
   private Long outboundDetailId;
   @ApiModelProperty(name = "branchCompanyId", value = "关联交易单位(数据来源为分支机构)", notes = "关联交易单位(数据来源为分支机构)")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint  COMMENT '关联交易单位(数据来源为分支机构)'", nullable = true)
   private Long branchCompanyId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;

   public static WmsForSaleDetail.WmsForSaleDetailBuilder builder() {
      return new WmsForSaleDetail.WmsForSaleDetailBuilder();
   }

   public WmsForSaleDetail() {
   }

   public WmsForSaleDetail(
      final Long id,
      final String forSaleSerialNumber,
      final BigDecimal quantity,
      final BigDecimal systemMete,
      final BigDecimal inputMete,
      final BigDecimal differenceMete,
      final Integer weightMeasurementMode,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final BigDecimal sellUnitPrice,
      final BigDecimal sellUnitPriceExcludingVat,
      final BigDecimal sellAmount,
      final BigDecimal sellAmountExcludingVat,
      final BigDecimal sellInputVat,
      final BigDecimal profitAmount,
      final BigDecimal profitAmountExcludingVat,
      final BigDecimal profitInputVat,
      final Long outboundDetailId,
      final Long branchCompanyId,
      final String remark
   ) {
      this.id = id;
      this.forSaleSerialNumber = forSaleSerialNumber;
      this.quantity = quantity;
      this.systemMete = systemMete;
      this.inputMete = inputMete;
      this.differenceMete = differenceMete;
      this.weightMeasurementMode = weightMeasurementMode;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.sellUnitPrice = sellUnitPrice;
      this.sellUnitPriceExcludingVat = sellUnitPriceExcludingVat;
      this.sellAmount = sellAmount;
      this.sellAmountExcludingVat = sellAmountExcludingVat;
      this.sellInputVat = sellInputVat;
      this.profitAmount = profitAmount;
      this.profitAmountExcludingVat = profitAmountExcludingVat;
      this.profitInputVat = profitInputVat;
      this.outboundDetailId = outboundDetailId;
      this.branchCompanyId = branchCompanyId;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getForSaleSerialNumber() {
      return this.forSaleSerialNumber;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getSystemMete() {
      return this.systemMete;
   }

   public BigDecimal getInputMete() {
      return this.inputMete;
   }

   public BigDecimal getDifferenceMete() {
      return this.differenceMete;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
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

   public BigDecimal getSellUnitPrice() {
      return this.sellUnitPrice;
   }

   public BigDecimal getSellUnitPriceExcludingVat() {
      return this.sellUnitPriceExcludingVat;
   }

   public BigDecimal getSellAmount() {
      return this.sellAmount;
   }

   public BigDecimal getSellAmountExcludingVat() {
      return this.sellAmountExcludingVat;
   }

   public BigDecimal getSellInputVat() {
      return this.sellInputVat;
   }

   public BigDecimal getProfitAmount() {
      return this.profitAmount;
   }

   public BigDecimal getProfitAmountExcludingVat() {
      return this.profitAmountExcludingVat;
   }

   public BigDecimal getProfitInputVat() {
      return this.profitInputVat;
   }

   public Long getOutboundDetailId() {
      return this.outboundDetailId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getRemark() {
      return this.remark;
   }

   public WmsForSaleDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsForSaleDetail setForSaleSerialNumber(final String forSaleSerialNumber) {
      this.forSaleSerialNumber = forSaleSerialNumber;
      return this;
   }

   public WmsForSaleDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public WmsForSaleDetail setSystemMete(final BigDecimal systemMete) {
      this.systemMete = systemMete;
      return this;
   }

   public WmsForSaleDetail setInputMete(final BigDecimal inputMete) {
      this.inputMete = inputMete;
      return this;
   }

   public WmsForSaleDetail setDifferenceMete(final BigDecimal differenceMete) {
      this.differenceMete = differenceMete;
      return this;
   }

   public WmsForSaleDetail setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
      return this;
   }

   public WmsForSaleDetail setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public WmsForSaleDetail setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   public WmsForSaleDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public WmsForSaleDetail setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   public WmsForSaleDetail setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   public WmsForSaleDetail setSellUnitPrice(final BigDecimal sellUnitPrice) {
      this.sellUnitPrice = sellUnitPrice;
      return this;
   }

   public WmsForSaleDetail setSellUnitPriceExcludingVat(final BigDecimal sellUnitPriceExcludingVat) {
      this.sellUnitPriceExcludingVat = sellUnitPriceExcludingVat;
      return this;
   }

   public WmsForSaleDetail setSellAmount(final BigDecimal sellAmount) {
      this.sellAmount = sellAmount;
      return this;
   }

   public WmsForSaleDetail setSellAmountExcludingVat(final BigDecimal sellAmountExcludingVat) {
      this.sellAmountExcludingVat = sellAmountExcludingVat;
      return this;
   }

   public WmsForSaleDetail setSellInputVat(final BigDecimal sellInputVat) {
      this.sellInputVat = sellInputVat;
      return this;
   }

   public WmsForSaleDetail setProfitAmount(final BigDecimal profitAmount) {
      this.profitAmount = profitAmount;
      return this;
   }

   public WmsForSaleDetail setProfitAmountExcludingVat(final BigDecimal profitAmountExcludingVat) {
      this.profitAmountExcludingVat = profitAmountExcludingVat;
      return this;
   }

   public WmsForSaleDetail setProfitInputVat(final BigDecimal profitInputVat) {
      this.profitInputVat = profitInputVat;
      return this;
   }

   public WmsForSaleDetail setOutboundDetailId(final Long outboundDetailId) {
      this.outboundDetailId = outboundDetailId;
      return this;
   }

   public WmsForSaleDetail setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public WmsForSaleDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "WmsForSaleDetail(id="
         + this.getId()
         + ", forSaleSerialNumber="
         + this.getForSaleSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", systemMete="
         + this.getSystemMete()
         + ", inputMete="
         + this.getInputMete()
         + ", differenceMete="
         + this.getDifferenceMete()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", sellUnitPrice="
         + this.getSellUnitPrice()
         + ", sellUnitPriceExcludingVat="
         + this.getSellUnitPriceExcludingVat()
         + ", sellAmount="
         + this.getSellAmount()
         + ", sellAmountExcludingVat="
         + this.getSellAmountExcludingVat()
         + ", sellInputVat="
         + this.getSellInputVat()
         + ", profitAmount="
         + this.getProfitAmount()
         + ", profitAmountExcludingVat="
         + this.getProfitAmountExcludingVat()
         + ", profitInputVat="
         + this.getProfitInputVat()
         + ", outboundDetailId="
         + this.getOutboundDetailId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsForSaleDetail)) {
         return false;
      }

      WmsForSaleDetail other = (WmsForSaleDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$weightMeasurementMode = this.getWeightMeasurementMode();
         Object other$weightMeasurementMode = other.getWeightMeasurementMode();
         if (this$weightMeasurementMode == null ? other$weightMeasurementMode == null : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
            Object this$outboundDetailId = this.getOutboundDetailId();
            Object other$outboundDetailId = other.getOutboundDetailId();
            if (this$outboundDetailId == null ? other$outboundDetailId == null : this$outboundDetailId.equals(other$outboundDetailId)) {
               Object this$branchCompanyId = this.getBranchCompanyId();
               Object other$branchCompanyId = other.getBranchCompanyId();
               if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                  Object this$forSaleSerialNumber = this.getForSaleSerialNumber();
                  Object other$forSaleSerialNumber = other.getForSaleSerialNumber();
                  if (this$forSaleSerialNumber == null ? other$forSaleSerialNumber == null : this$forSaleSerialNumber.equals(other$forSaleSerialNumber)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$systemMete = this.getSystemMete();
                        Object other$systemMete = other.getSystemMete();
                        if (this$systemMete == null ? other$systemMete == null : this$systemMete.equals(other$systemMete)) {
                           Object this$inputMete = this.getInputMete();
                           Object other$inputMete = other.getInputMete();
                           if (this$inputMete == null ? other$inputMete == null : this$inputMete.equals(other$inputMete)) {
                              Object this$differenceMete = this.getDifferenceMete();
                              Object other$differenceMete = other.getDifferenceMete();
                              if (this$differenceMete == null ? other$differenceMete == null : this$differenceMete.equals(other$differenceMete)) {
                                 Object this$unitPrice = this.getUnitPrice();
                                 Object other$unitPrice = other.getUnitPrice();
                                 if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                    Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                    Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                    if (this$unitPriceExcludingVat == null
                                       ? other$unitPriceExcludingVat == null
                                       : this$unitPriceExcludingVat.equals(other$unitPriceExcludingVat)) {
                                       Object this$amount = this.getAmount();
                                       Object other$amount = other.getAmount();
                                       if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                          Object this$amountExcludingVat = this.getAmountExcludingVat();
                                          Object other$amountExcludingVat = other.getAmountExcludingVat();
                                          if (this$amountExcludingVat == null
                                             ? other$amountExcludingVat == null
                                             : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                             Object this$inputVat = this.getInputVat();
                                             Object other$inputVat = other.getInputVat();
                                             if (this$inputVat == null ? other$inputVat == null : this$inputVat.equals(other$inputVat)) {
                                                Object this$sellUnitPrice = this.getSellUnitPrice();
                                                Object other$sellUnitPrice = other.getSellUnitPrice();
                                                if (this$sellUnitPrice == null ? other$sellUnitPrice == null : this$sellUnitPrice.equals(other$sellUnitPrice)) {
                                                   Object this$sellUnitPriceExcludingVat = this.getSellUnitPriceExcludingVat();
                                                   Object other$sellUnitPriceExcludingVat = other.getSellUnitPriceExcludingVat();
                                                   if (this$sellUnitPriceExcludingVat == null
                                                      ? other$sellUnitPriceExcludingVat == null
                                                      : this$sellUnitPriceExcludingVat.equals(other$sellUnitPriceExcludingVat)) {
                                                      Object this$sellAmount = this.getSellAmount();
                                                      Object other$sellAmount = other.getSellAmount();
                                                      if (this$sellAmount == null ? other$sellAmount == null : this$sellAmount.equals(other$sellAmount)) {
                                                         Object this$sellAmountExcludingVat = this.getSellAmountExcludingVat();
                                                         Object other$sellAmountExcludingVat = other.getSellAmountExcludingVat();
                                                         if (this$sellAmountExcludingVat == null
                                                            ? other$sellAmountExcludingVat == null
                                                            : this$sellAmountExcludingVat.equals(other$sellAmountExcludingVat)) {
                                                            Object this$sellInputVat = this.getSellInputVat();
                                                            Object other$sellInputVat = other.getSellInputVat();
                                                            if (this$sellInputVat == null
                                                               ? other$sellInputVat == null
                                                               : this$sellInputVat.equals(other$sellInputVat)) {
                                                               Object this$profitAmount = this.getProfitAmount();
                                                               Object other$profitAmount = other.getProfitAmount();
                                                               if (this$profitAmount == null
                                                                  ? other$profitAmount == null
                                                                  : this$profitAmount.equals(other$profitAmount)) {
                                                                  Object this$profitAmountExcludingVat = this.getProfitAmountExcludingVat();
                                                                  Object other$profitAmountExcludingVat = other.getProfitAmountExcludingVat();
                                                                  if (this$profitAmountExcludingVat == null
                                                                     ? other$profitAmountExcludingVat == null
                                                                     : this$profitAmountExcludingVat.equals(other$profitAmountExcludingVat)) {
                                                                     Object this$profitInputVat = this.getProfitInputVat();
                                                                     Object other$profitInputVat = other.getProfitInputVat();
                                                                     if (this$profitInputVat == null
                                                                        ? other$profitInputVat == null
                                                                        : this$profitInputVat.equals(other$profitInputVat)) {
                                                                        Object this$remark = this.getRemark();
                                                                        Object other$remark = other.getRemark();
                                                                        return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof WmsForSaleDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $outboundDetailId = this.getOutboundDetailId();
      result = result * 59 + ($outboundDetailId == null ? 43 : $outboundDetailId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $forSaleSerialNumber = this.getForSaleSerialNumber();
      result = result * 59 + ($forSaleSerialNumber == null ? 43 : $forSaleSerialNumber.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $systemMete = this.getSystemMete();
      result = result * 59 + ($systemMete == null ? 43 : $systemMete.hashCode());
      Object $inputMete = this.getInputMete();
      result = result * 59 + ($inputMete == null ? 43 : $inputMete.hashCode());
      Object $differenceMete = this.getDifferenceMete();
      result = result * 59 + ($differenceMete == null ? 43 : $differenceMete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $sellUnitPrice = this.getSellUnitPrice();
      result = result * 59 + ($sellUnitPrice == null ? 43 : $sellUnitPrice.hashCode());
      Object $sellUnitPriceExcludingVat = this.getSellUnitPriceExcludingVat();
      result = result * 59 + ($sellUnitPriceExcludingVat == null ? 43 : $sellUnitPriceExcludingVat.hashCode());
      Object $sellAmount = this.getSellAmount();
      result = result * 59 + ($sellAmount == null ? 43 : $sellAmount.hashCode());
      Object $sellAmountExcludingVat = this.getSellAmountExcludingVat();
      result = result * 59 + ($sellAmountExcludingVat == null ? 43 : $sellAmountExcludingVat.hashCode());
      Object $sellInputVat = this.getSellInputVat();
      result = result * 59 + ($sellInputVat == null ? 43 : $sellInputVat.hashCode());
      Object $profitAmount = this.getProfitAmount();
      result = result * 59 + ($profitAmount == null ? 43 : $profitAmount.hashCode());
      Object $profitAmountExcludingVat = this.getProfitAmountExcludingVat();
      result = result * 59 + ($profitAmountExcludingVat == null ? 43 : $profitAmountExcludingVat.hashCode());
      Object $profitInputVat = this.getProfitInputVat();
      result = result * 59 + ($profitInputVat == null ? 43 : $profitInputVat.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class WmsForSaleDetailBuilder {
      private Long id;
      private String forSaleSerialNumber;
      private BigDecimal quantity;
      private BigDecimal systemMete;
      private BigDecimal inputMete;
      private BigDecimal differenceMete;
      private Integer weightMeasurementMode;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private BigDecimal sellUnitPrice;
      private BigDecimal sellUnitPriceExcludingVat;
      private BigDecimal sellAmount;
      private BigDecimal sellAmountExcludingVat;
      private BigDecimal sellInputVat;
      private BigDecimal profitAmount;
      private BigDecimal profitAmountExcludingVat;
      private BigDecimal profitInputVat;
      private Long outboundDetailId;
      private Long branchCompanyId;
      private String remark;

      WmsForSaleDetailBuilder() {
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder forSaleSerialNumber(final String forSaleSerialNumber) {
         this.forSaleSerialNumber = forSaleSerialNumber;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder systemMete(final BigDecimal systemMete) {
         this.systemMete = systemMete;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder inputMete(final BigDecimal inputMete) {
         this.inputMete = inputMete;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder differenceMete(final BigDecimal differenceMete) {
         this.differenceMete = differenceMete;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder sellUnitPrice(final BigDecimal sellUnitPrice) {
         this.sellUnitPrice = sellUnitPrice;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder sellUnitPriceExcludingVat(final BigDecimal sellUnitPriceExcludingVat) {
         this.sellUnitPriceExcludingVat = sellUnitPriceExcludingVat;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder sellAmount(final BigDecimal sellAmount) {
         this.sellAmount = sellAmount;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder sellAmountExcludingVat(final BigDecimal sellAmountExcludingVat) {
         this.sellAmountExcludingVat = sellAmountExcludingVat;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder sellInputVat(final BigDecimal sellInputVat) {
         this.sellInputVat = sellInputVat;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder profitAmount(final BigDecimal profitAmount) {
         this.profitAmount = profitAmount;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder profitAmountExcludingVat(final BigDecimal profitAmountExcludingVat) {
         this.profitAmountExcludingVat = profitAmountExcludingVat;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder profitInputVat(final BigDecimal profitInputVat) {
         this.profitInputVat = profitInputVat;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder outboundDetailId(final Long outboundDetailId) {
         this.outboundDetailId = outboundDetailId;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public WmsForSaleDetail.WmsForSaleDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public WmsForSaleDetail build() {
         return new WmsForSaleDetail(
            this.id,
            this.forSaleSerialNumber,
            this.quantity,
            this.systemMete,
            this.inputMete,
            this.differenceMete,
            this.weightMeasurementMode,
            this.unitPrice,
            this.unitPriceExcludingVat,
            this.amount,
            this.amountExcludingVat,
            this.inputVat,
            this.sellUnitPrice,
            this.sellUnitPriceExcludingVat,
            this.sellAmount,
            this.sellAmountExcludingVat,
            this.sellInputVat,
            this.profitAmount,
            this.profitAmountExcludingVat,
            this.profitInputVat,
            this.outboundDetailId,
            this.branchCompanyId,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "WmsForSaleDetail.WmsForSaleDetailBuilder(id="
            + this.id
            + ", forSaleSerialNumber="
            + this.forSaleSerialNumber
            + ", quantity="
            + this.quantity
            + ", systemMete="
            + this.systemMete
            + ", inputMete="
            + this.inputMete
            + ", differenceMete="
            + this.differenceMete
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", sellUnitPrice="
            + this.sellUnitPrice
            + ", sellUnitPriceExcludingVat="
            + this.sellUnitPriceExcludingVat
            + ", sellAmount="
            + this.sellAmount
            + ", sellAmountExcludingVat="
            + this.sellAmountExcludingVat
            + ", sellInputVat="
            + this.sellInputVat
            + ", profitAmount="
            + this.profitAmount
            + ", profitAmountExcludingVat="
            + this.profitAmountExcludingVat
            + ", profitInputVat="
            + this.profitInputVat
            + ", outboundDetailId="
            + this.outboundDetailId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
