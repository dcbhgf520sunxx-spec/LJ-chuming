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

@ApiModel(value = "WmsForSale对象", description = "对外销售表")
@Entity
@TableName("wms_for_sale")
@Table(name = "wms_for_sale")
@org.hibernate.annotations.Table(appliesTo = "wms_for_sale", comment = "对外销售表")
public class WmsForSale extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "对外出售单编号", notes = "对外出售单编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '对外出售单编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 [1 专用增值税发票,2 普通增值税发票,4 收据]", notes = "发票类型 [1 专用增值税发票,2 普通增值税发票,4 收据]")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int  COMMENT '发票类型 [1 专用增值税发票,2 普通增值税发票,4 收据]'", nullable = true)
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "amount", value = "成本总价", notes = "成本总价")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '成本总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "成本不含税总价", notes = "成本不含税总价")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '成本不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "成本进项税", notes = "成本进项税")
   @TableField("input_VAT")
   @Column(name = "input_VAT", columnDefinition = "decimal(32,12)  COMMENT '成本进项税'", nullable = true)
   private BigDecimal inputVat;
   @ApiModelProperty(name = "sellAmount", value = "出售总价", notes = "出售总价")
   @TableField("sell_amount")
   @Column(name = "sell_amount", columnDefinition = "decimal(32,12)  COMMENT '出售总价'", nullable = true)
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
   @ApiModelProperty(name = "outboundId", value = "出库单ID", notes = "出库单ID")
   @TableField("outbound_id")
   @Column(name = "outbound_id", columnDefinition = "bigint  COMMENT '出库单ID'", nullable = true)
   private Long outboundId;
   @ApiModelProperty(name = "outboundSerialNumber", value = "出库单编号", notes = "出库单编号")
   @TableField("outbound_serial_number")
   @Column(name = "outbound_serial_number", columnDefinition = "varchar(255)  COMMENT '出库单编号'", nullable = true)
   private String outboundSerialNumber;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态  ReviewStatusEnum", notes = "审核状态  ReviewStatusEnum")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT '审核状态  ReviewStatusEnum'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewerId", value = "审核人Id", notes = "审核人Id")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id", columnDefinition = "bigint  COMMENT '审核人Id'", nullable = true)
   private Long reviewerId;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称", notes = "审核人名称")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name", columnDefinition = "varchar(255)  COMMENT '审核人名称'", nullable = true)
   private String reviewerName;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT '申请人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255)  COMMENT '申请人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "branchCompanyId", value = "关联交易单位(数据来源为分支机构)", notes = "关联交易单位(数据来源为分支机构)")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint  COMMENT '关联交易单位(数据来源为分支机构)'", nullable = true)
   private Long branchCompanyId;
   @ApiModelProperty(name = "purchaser", value = "购买方", notes = "购买方")
   @TableField("purchaser")
   @Column(name = "purchaser", columnDefinition = "varchar(255)  COMMENT '购买方'", nullable = true)
   private String purchaser;

   public static WmsForSale.WmsForSaleBuilder builder() {
      return new WmsForSale.WmsForSaleBuilder();
   }

   public WmsForSale() {
   }

   public WmsForSale(
      final Long id,
      final String serialNumber,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final BigDecimal sellAmount,
      final BigDecimal sellAmountExcludingVat,
      final BigDecimal sellInputVat,
      final BigDecimal profitAmount,
      final BigDecimal profitAmountExcludingVat,
      final BigDecimal profitInputVat,
      final BigDecimal systemMete,
      final BigDecimal inputMete,
      final BigDecimal differenceMete,
      final Long outboundId,
      final String outboundSerialNumber,
      final Integer reviewStatus,
      final Long reviewerId,
      final String reviewerName,
      final Long applicantId,
      final String applicantName,
      final Long branchCompanyId,
      final String purchaser
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.sellAmount = sellAmount;
      this.sellAmountExcludingVat = sellAmountExcludingVat;
      this.sellInputVat = sellInputVat;
      this.profitAmount = profitAmount;
      this.profitAmountExcludingVat = profitAmountExcludingVat;
      this.profitInputVat = profitInputVat;
      this.systemMete = systemMete;
      this.inputMete = inputMete;
      this.differenceMete = differenceMete;
      this.outboundId = outboundId;
      this.outboundSerialNumber = outboundSerialNumber;
      this.reviewStatus = reviewStatus;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.branchCompanyId = branchCompanyId;
      this.purchaser = purchaser;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
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

   public BigDecimal getSystemMete() {
      return this.systemMete;
   }

   public BigDecimal getInputMete() {
      return this.inputMete;
   }

   public BigDecimal getDifferenceMete() {
      return this.differenceMete;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public String getOutboundSerialNumber() {
      return this.outboundSerialNumber;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getPurchaser() {
      return this.purchaser;
   }

   public WmsForSale setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsForSale setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public WmsForSale setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   public WmsForSale setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   public WmsForSale setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public WmsForSale setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   public WmsForSale setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   public WmsForSale setSellAmount(final BigDecimal sellAmount) {
      this.sellAmount = sellAmount;
      return this;
   }

   public WmsForSale setSellAmountExcludingVat(final BigDecimal sellAmountExcludingVat) {
      this.sellAmountExcludingVat = sellAmountExcludingVat;
      return this;
   }

   public WmsForSale setSellInputVat(final BigDecimal sellInputVat) {
      this.sellInputVat = sellInputVat;
      return this;
   }

   public WmsForSale setProfitAmount(final BigDecimal profitAmount) {
      this.profitAmount = profitAmount;
      return this;
   }

   public WmsForSale setProfitAmountExcludingVat(final BigDecimal profitAmountExcludingVat) {
      this.profitAmountExcludingVat = profitAmountExcludingVat;
      return this;
   }

   public WmsForSale setProfitInputVat(final BigDecimal profitInputVat) {
      this.profitInputVat = profitInputVat;
      return this;
   }

   public WmsForSale setSystemMete(final BigDecimal systemMete) {
      this.systemMete = systemMete;
      return this;
   }

   public WmsForSale setInputMete(final BigDecimal inputMete) {
      this.inputMete = inputMete;
      return this;
   }

   public WmsForSale setDifferenceMete(final BigDecimal differenceMete) {
      this.differenceMete = differenceMete;
      return this;
   }

   public WmsForSale setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   public WmsForSale setOutboundSerialNumber(final String outboundSerialNumber) {
      this.outboundSerialNumber = outboundSerialNumber;
      return this;
   }

   public WmsForSale setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   public WmsForSale setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   public WmsForSale setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   public WmsForSale setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   public WmsForSale setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   public WmsForSale setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public WmsForSale setPurchaser(final String purchaser) {
      this.purchaser = purchaser;
      return this;
   }

   @Override
   public String toString() {
      return "WmsForSale(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
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
         + ", systemMete="
         + this.getSystemMete()
         + ", inputMete="
         + this.getInputMete()
         + ", differenceMete="
         + this.getDifferenceMete()
         + ", outboundId="
         + this.getOutboundId()
         + ", outboundSerialNumber="
         + this.getOutboundSerialNumber()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", purchaser="
         + this.getPurchaser()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsForSale)) {
         return false;
      }

      WmsForSale other = (WmsForSale)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$invoiceType = this.getInvoiceType();
         Object other$invoiceType = other.getInvoiceType();
         if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
            Object this$outboundId = this.getOutboundId();
            Object other$outboundId = other.getOutboundId();
            if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
               Object this$reviewStatus = this.getReviewStatus();
               Object other$reviewStatus = other.getReviewStatus();
               if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                  Object this$reviewerId = this.getReviewerId();
                  Object other$reviewerId = other.getReviewerId();
                  if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                     Object this$applicantId = this.getApplicantId();
                     Object other$applicantId = other.getApplicantId();
                     if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                        Object this$branchCompanyId = this.getBranchCompanyId();
                        Object other$branchCompanyId = other.getBranchCompanyId();
                        if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$taxRate = this.getTaxRate();
                              Object other$taxRate = other.getTaxRate();
                              if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
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
                                                if (this$sellInputVat == null ? other$sellInputVat == null : this$sellInputVat.equals(other$sellInputVat)) {
                                                   Object this$profitAmount = this.getProfitAmount();
                                                   Object other$profitAmount = other.getProfitAmount();
                                                   if (this$profitAmount == null ? other$profitAmount == null : this$profitAmount.equals(other$profitAmount)) {
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
                                                            Object this$systemMete = this.getSystemMete();
                                                            Object other$systemMete = other.getSystemMete();
                                                            if (this$systemMete == null ? other$systemMete == null : this$systemMete.equals(other$systemMete)) {
                                                               Object this$inputMete = this.getInputMete();
                                                               Object other$inputMete = other.getInputMete();
                                                               if (this$inputMete == null ? other$inputMete == null : this$inputMete.equals(other$inputMete)) {
                                                                  Object this$differenceMete = this.getDifferenceMete();
                                                                  Object other$differenceMete = other.getDifferenceMete();
                                                                  if (this$differenceMete == null
                                                                     ? other$differenceMete == null
                                                                     : this$differenceMete.equals(other$differenceMete)) {
                                                                     Object this$outboundSerialNumber = this.getOutboundSerialNumber();
                                                                     Object other$outboundSerialNumber = other.getOutboundSerialNumber();
                                                                     if (this$outboundSerialNumber == null
                                                                        ? other$outboundSerialNumber == null
                                                                        : this$outboundSerialNumber.equals(other$outboundSerialNumber)) {
                                                                        Object this$reviewerName = this.getReviewerName();
                                                                        Object other$reviewerName = other.getReviewerName();
                                                                        if (this$reviewerName == null
                                                                           ? other$reviewerName == null
                                                                           : this$reviewerName.equals(other$reviewerName)) {
                                                                           Object this$applicantName = this.getApplicantName();
                                                                           Object other$applicantName = other.getApplicantName();
                                                                           if (this$applicantName == null
                                                                              ? other$applicantName == null
                                                                              : this$applicantName.equals(other$applicantName)) {
                                                                              Object this$purchaser = this.getPurchaser();
                                                                              Object other$purchaser = other.getPurchaser();
                                                                              return this$purchaser == null
                                                                                 ? other$purchaser == null
                                                                                 : this$purchaser.equals(other$purchaser);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsForSale;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
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
      Object $systemMete = this.getSystemMete();
      result = result * 59 + ($systemMete == null ? 43 : $systemMete.hashCode());
      Object $inputMete = this.getInputMete();
      result = result * 59 + ($inputMete == null ? 43 : $inputMete.hashCode());
      Object $differenceMete = this.getDifferenceMete();
      result = result * 59 + ($differenceMete == null ? 43 : $differenceMete.hashCode());
      Object $outboundSerialNumber = this.getOutboundSerialNumber();
      result = result * 59 + ($outboundSerialNumber == null ? 43 : $outboundSerialNumber.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $purchaser = this.getPurchaser();
      return result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
   }

   public static class WmsForSaleBuilder {
      private Long id;
      private String serialNumber;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private BigDecimal sellAmount;
      private BigDecimal sellAmountExcludingVat;
      private BigDecimal sellInputVat;
      private BigDecimal profitAmount;
      private BigDecimal profitAmountExcludingVat;
      private BigDecimal profitInputVat;
      private BigDecimal systemMete;
      private BigDecimal inputMete;
      private BigDecimal differenceMete;
      private Long outboundId;
      private String outboundSerialNumber;
      private Integer reviewStatus;
      private Long reviewerId;
      private String reviewerName;
      private Long applicantId;
      private String applicantName;
      private Long branchCompanyId;
      private String purchaser;

      WmsForSaleBuilder() {
      }

      public WmsForSale.WmsForSaleBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder sellAmount(final BigDecimal sellAmount) {
         this.sellAmount = sellAmount;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder sellAmountExcludingVat(final BigDecimal sellAmountExcludingVat) {
         this.sellAmountExcludingVat = sellAmountExcludingVat;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder sellInputVat(final BigDecimal sellInputVat) {
         this.sellInputVat = sellInputVat;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder profitAmount(final BigDecimal profitAmount) {
         this.profitAmount = profitAmount;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder profitAmountExcludingVat(final BigDecimal profitAmountExcludingVat) {
         this.profitAmountExcludingVat = profitAmountExcludingVat;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder profitInputVat(final BigDecimal profitInputVat) {
         this.profitInputVat = profitInputVat;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder systemMete(final BigDecimal systemMete) {
         this.systemMete = systemMete;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder inputMete(final BigDecimal inputMete) {
         this.inputMete = inputMete;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder differenceMete(final BigDecimal differenceMete) {
         this.differenceMete = differenceMete;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder outboundSerialNumber(final String outboundSerialNumber) {
         this.outboundSerialNumber = outboundSerialNumber;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public WmsForSale.WmsForSaleBuilder purchaser(final String purchaser) {
         this.purchaser = purchaser;
         return this;
      }

      public WmsForSale build() {
         return new WmsForSale(
            this.id,
            this.serialNumber,
            this.invoiceType,
            this.taxRate,
            this.amount,
            this.amountExcludingVat,
            this.inputVat,
            this.sellAmount,
            this.sellAmountExcludingVat,
            this.sellInputVat,
            this.profitAmount,
            this.profitAmountExcludingVat,
            this.profitInputVat,
            this.systemMete,
            this.inputMete,
            this.differenceMete,
            this.outboundId,
            this.outboundSerialNumber,
            this.reviewStatus,
            this.reviewerId,
            this.reviewerName,
            this.applicantId,
            this.applicantName,
            this.branchCompanyId,
            this.purchaser
         );
      }

      @Override
      public String toString() {
         return "WmsForSale.WmsForSaleBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
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
            + ", systemMete="
            + this.systemMete
            + ", inputMete="
            + this.inputMete
            + ", differenceMete="
            + this.differenceMete
            + ", outboundId="
            + this.outboundId
            + ", outboundSerialNumber="
            + this.outboundSerialNumber
            + ", reviewStatus="
            + this.reviewStatus
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", purchaser="
            + this.purchaser
            + ")";
      }
   }
}
