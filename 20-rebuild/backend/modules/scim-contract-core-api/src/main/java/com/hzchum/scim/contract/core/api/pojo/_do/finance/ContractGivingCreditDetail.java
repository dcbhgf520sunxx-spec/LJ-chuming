package com.hzchum.scim.contract.core.api.pojo._do.finance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "ContractGivingCreditDetail对象", description = "授信使用明细 ")
@Entity
@TableName("contract_giving_credit_detail")
@Table(name = "contract_giving_credit_detail")
@org.hibernate.annotations.Table(appliesTo = "contract_giving_credit_detail", comment = "授信使用明细 ")
public class ContractGivingCreditDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '创建人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "creditId", value = "授信id", notes = "授信id")
   @TableField("credit_id")
   @Column(name = "credit_id", columnDefinition = "bigint(20)  COMMENT '授信id'", nullable = false)
   private Long creditId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "purchaseId", value = "采购id", notes = "采购id")
   @TableField("purchase_id")
   @Column(name = "purchase_id", columnDefinition = "bigint(20)  COMMENT '采购id'", nullable = true)
   private Long purchaseId;
   @ApiModelProperty(name = "orderId", value = "订单id", notes = "订单id")
   @TableField("order_id")
   @Column(name = "order_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '订单id'", nullable = false)
   private Long orderId;
   @ApiModelProperty(name = "purchaseId", value = "付款表id", notes = "付款表id")
   @TableField("supplier_payment_id")
   @Column(name = "supplier_payment_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '付款表id'", nullable = false)
   private Long supplierPaymentId;
   @ApiModelProperty(name = "useDate", value = "使用时间", notes = "使用时间")
   @TableField("use_date")
   @Column(name = "use_date", columnDefinition = "datetime(6) COMMENT '使用时间'", nullable = false)
   private LocalDateTime useDate;
   @ApiModelProperty(name = "useAmount", value = "使用额度", notes = "使用额度")
   @TableField("use_amount")
   @Column(name = "use_amount", columnDefinition = "decimal(32,4)  COMMENT '使用额度'", nullable = false)
   private BigDecimal useAmount;
   @ApiModelProperty(name = "annualInterest", value = "年利息(%)", notes = "年利息(%)")
   @TableField("annual_interest")
   @Column(name = "annual_interest", columnDefinition = "decimal(32,4) default 0.00 COMMENT '年利息(%)'", nullable = false)
   private BigDecimal annualInterest;
   @ApiModelProperty(name = "monthlyInterest", value = "月利息(%)", notes = "月利息(%)")
   @TableField("monthly_interest")
   @Column(name = "monthly_interest", columnDefinition = "decimal(32,4) default 0.00  COMMENT '月利息(%)'", nullable = false)
   private BigDecimal monthlyInterest;
   @ApiModelProperty(name = "dayInterest", value = "日利息(%)", notes = "日利息(%)")
   @TableField("day_interest")
   @Column(name = "day_interest", columnDefinition = "decimal(32,4) DEFAULT 0.00 COMMENT '日利息(%)'", nullable = false)
   private BigDecimal dayInterest;
   @ApiModelProperty(name = "returnPrincipalAmount", value = "已还款本金", notes = "已还款本金")
   @TableField("return_principal_amount")
   @Column(name = "return_principal_amount", columnDefinition = "decimal(32,4) DEFAULT 0.00 COMMENT '已还款本金'", nullable = false)
   private BigDecimal returnPrincipalAmount;
   @ApiModelProperty(name = "returnInterestAmount", value = "已还款利息", notes = "已还款利息")
   @TableField("return_interest_amount")
   @Column(name = "return_interest_amount", columnDefinition = "decimal(32,4) DEFAULT 0.00 COMMENT '已还款利息'", nullable = false)
   private BigDecimal returnInterestAmount;
   @ApiModelProperty(name = "paymentReasonId", value = "付款事由", notes = "付款事由")
   @TableField("payment_reason_id")
   @Column(name = "payment_reason_id", columnDefinition = "varchar(255)  COMMENT '付款事由'", nullable = true)
   private String paymentReasonId;
   @ApiModelProperty(name = "auditStatus", value = "付款审批状态：1 待审核 2 通过 4 不通过", notes = "付款审批状态：1 待审核 2 通过 4 不通过")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11)  COMMENT '付款审批状态 审批状态：1 待审核 2 通过 4 不通过'", nullable = false)
   private Integer auditStatus;
   @ApiModelProperty(name = "isStatus", value = "是否还款", notes = "是否还款")
   @TableField("is_status")
   @Column(name = "is_status", columnDefinition = "int(11) default '0' COMMENT '是否还款 0:收款，1：还款'", nullable = false)
   private Integer isStatus;

   public static ContractGivingCreditDetail.ContractGivingCreditDetailBuilder builder() {
      return new ContractGivingCreditDetail.ContractGivingCreditDetailBuilder();
   }

   public ContractGivingCreditDetail() {
   }

   public ContractGivingCreditDetail(
      final Long id,
      final Long userId,
      final Long creditId,
      final Long projectId,
      final Long purchaseId,
      final Long orderId,
      final Long supplierPaymentId,
      final LocalDateTime useDate,
      final BigDecimal useAmount,
      final BigDecimal annualInterest,
      final BigDecimal monthlyInterest,
      final BigDecimal dayInterest,
      final BigDecimal returnPrincipalAmount,
      final BigDecimal returnInterestAmount,
      final String paymentReasonId,
      final Integer auditStatus,
      final Integer isStatus
   ) {
      this.id = id;
      this.userId = userId;
      this.creditId = creditId;
      this.projectId = projectId;
      this.purchaseId = purchaseId;
      this.orderId = orderId;
      this.supplierPaymentId = supplierPaymentId;
      this.useDate = useDate;
      this.useAmount = useAmount;
      this.annualInterest = annualInterest;
      this.monthlyInterest = monthlyInterest;
      this.dayInterest = dayInterest;
      this.returnPrincipalAmount = returnPrincipalAmount;
      this.returnInterestAmount = returnInterestAmount;
      this.paymentReasonId = paymentReasonId;
      this.auditStatus = auditStatus;
      this.isStatus = isStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getCreditId() {
      return this.creditId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public Long getSupplierPaymentId() {
      return this.supplierPaymentId;
   }

   public LocalDateTime getUseDate() {
      return this.useDate;
   }

   public BigDecimal getUseAmount() {
      return this.useAmount;
   }

   public BigDecimal getAnnualInterest() {
      return this.annualInterest;
   }

   public BigDecimal getMonthlyInterest() {
      return this.monthlyInterest;
   }

   public BigDecimal getDayInterest() {
      return this.dayInterest;
   }

   public BigDecimal getReturnPrincipalAmount() {
      return this.returnPrincipalAmount;
   }

   public BigDecimal getReturnInterestAmount() {
      return this.returnInterestAmount;
   }

   public String getPaymentReasonId() {
      return this.paymentReasonId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Integer getIsStatus() {
      return this.isStatus;
   }

   public ContractGivingCreditDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractGivingCreditDetail setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractGivingCreditDetail setCreditId(final Long creditId) {
      this.creditId = creditId;
      return this;
   }

   public ContractGivingCreditDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractGivingCreditDetail setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
      return this;
   }

   public ContractGivingCreditDetail setOrderId(final Long orderId) {
      this.orderId = orderId;
      return this;
   }

   public ContractGivingCreditDetail setSupplierPaymentId(final Long supplierPaymentId) {
      this.supplierPaymentId = supplierPaymentId;
      return this;
   }

   public ContractGivingCreditDetail setUseDate(final LocalDateTime useDate) {
      this.useDate = useDate;
      return this;
   }

   public ContractGivingCreditDetail setUseAmount(final BigDecimal useAmount) {
      this.useAmount = useAmount;
      return this;
   }

   public ContractGivingCreditDetail setAnnualInterest(final BigDecimal annualInterest) {
      this.annualInterest = annualInterest;
      return this;
   }

   public ContractGivingCreditDetail setMonthlyInterest(final BigDecimal monthlyInterest) {
      this.monthlyInterest = monthlyInterest;
      return this;
   }

   public ContractGivingCreditDetail setDayInterest(final BigDecimal dayInterest) {
      this.dayInterest = dayInterest;
      return this;
   }

   public ContractGivingCreditDetail setReturnPrincipalAmount(final BigDecimal returnPrincipalAmount) {
      this.returnPrincipalAmount = returnPrincipalAmount;
      return this;
   }

   public ContractGivingCreditDetail setReturnInterestAmount(final BigDecimal returnInterestAmount) {
      this.returnInterestAmount = returnInterestAmount;
      return this;
   }

   public ContractGivingCreditDetail setPaymentReasonId(final String paymentReasonId) {
      this.paymentReasonId = paymentReasonId;
      return this;
   }

   public ContractGivingCreditDetail setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   public ContractGivingCreditDetail setIsStatus(final Integer isStatus) {
      this.isStatus = isStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ContractGivingCreditDetail(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", creditId="
         + this.getCreditId()
         + ", projectId="
         + this.getProjectId()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", orderId="
         + this.getOrderId()
         + ", supplierPaymentId="
         + this.getSupplierPaymentId()
         + ", useDate="
         + this.getUseDate()
         + ", useAmount="
         + this.getUseAmount()
         + ", annualInterest="
         + this.getAnnualInterest()
         + ", monthlyInterest="
         + this.getMonthlyInterest()
         + ", dayInterest="
         + this.getDayInterest()
         + ", returnPrincipalAmount="
         + this.getReturnPrincipalAmount()
         + ", returnInterestAmount="
         + this.getReturnInterestAmount()
         + ", paymentReasonId="
         + this.getPaymentReasonId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", isStatus="
         + this.getIsStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractGivingCreditDetail)) {
         return false;
      }

      ContractGivingCreditDetail other = (ContractGivingCreditDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$creditId = this.getCreditId();
            Object other$creditId = other.getCreditId();
            if (this$creditId == null ? other$creditId == null : this$creditId.equals(other$creditId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$purchaseId = this.getPurchaseId();
                  Object other$purchaseId = other.getPurchaseId();
                  if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
                     Object this$orderId = this.getOrderId();
                     Object other$orderId = other.getOrderId();
                     if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
                        Object this$supplierPaymentId = this.getSupplierPaymentId();
                        Object other$supplierPaymentId = other.getSupplierPaymentId();
                        if (this$supplierPaymentId == null ? other$supplierPaymentId == null : this$supplierPaymentId.equals(other$supplierPaymentId)) {
                           Object this$auditStatus = this.getAuditStatus();
                           Object other$auditStatus = other.getAuditStatus();
                           if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                              Object this$isStatus = this.getIsStatus();
                              Object other$isStatus = other.getIsStatus();
                              if (this$isStatus == null ? other$isStatus == null : this$isStatus.equals(other$isStatus)) {
                                 Object this$useDate = this.getUseDate();
                                 Object other$useDate = other.getUseDate();
                                 if (this$useDate == null ? other$useDate == null : this$useDate.equals(other$useDate)) {
                                    Object this$useAmount = this.getUseAmount();
                                    Object other$useAmount = other.getUseAmount();
                                    if (this$useAmount == null ? other$useAmount == null : this$useAmount.equals(other$useAmount)) {
                                       Object this$annualInterest = this.getAnnualInterest();
                                       Object other$annualInterest = other.getAnnualInterest();
                                       if (this$annualInterest == null ? other$annualInterest == null : this$annualInterest.equals(other$annualInterest)) {
                                          Object this$monthlyInterest = this.getMonthlyInterest();
                                          Object other$monthlyInterest = other.getMonthlyInterest();
                                          if (this$monthlyInterest == null ? other$monthlyInterest == null : this$monthlyInterest.equals(other$monthlyInterest)
                                             )
                                           {
                                             Object this$dayInterest = this.getDayInterest();
                                             Object other$dayInterest = other.getDayInterest();
                                             if (this$dayInterest == null ? other$dayInterest == null : this$dayInterest.equals(other$dayInterest)) {
                                                Object this$returnPrincipalAmount = this.getReturnPrincipalAmount();
                                                Object other$returnPrincipalAmount = other.getReturnPrincipalAmount();
                                                if (this$returnPrincipalAmount == null
                                                   ? other$returnPrincipalAmount == null
                                                   : this$returnPrincipalAmount.equals(other$returnPrincipalAmount)) {
                                                   Object this$returnInterestAmount = this.getReturnInterestAmount();
                                                   Object other$returnInterestAmount = other.getReturnInterestAmount();
                                                   if (this$returnInterestAmount == null
                                                      ? other$returnInterestAmount == null
                                                      : this$returnInterestAmount.equals(other$returnInterestAmount)) {
                                                      Object this$paymentReasonId = this.getPaymentReasonId();
                                                      Object other$paymentReasonId = other.getPaymentReasonId();
                                                      return this$paymentReasonId == null
                                                         ? other$paymentReasonId == null
                                                         : this$paymentReasonId.equals(other$paymentReasonId);
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
      return other instanceof ContractGivingCreditDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $creditId = this.getCreditId();
      result = result * 59 + ($creditId == null ? 43 : $creditId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $supplierPaymentId = this.getSupplierPaymentId();
      result = result * 59 + ($supplierPaymentId == null ? 43 : $supplierPaymentId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $isStatus = this.getIsStatus();
      result = result * 59 + ($isStatus == null ? 43 : $isStatus.hashCode());
      Object $useDate = this.getUseDate();
      result = result * 59 + ($useDate == null ? 43 : $useDate.hashCode());
      Object $useAmount = this.getUseAmount();
      result = result * 59 + ($useAmount == null ? 43 : $useAmount.hashCode());
      Object $annualInterest = this.getAnnualInterest();
      result = result * 59 + ($annualInterest == null ? 43 : $annualInterest.hashCode());
      Object $monthlyInterest = this.getMonthlyInterest();
      result = result * 59 + ($monthlyInterest == null ? 43 : $monthlyInterest.hashCode());
      Object $dayInterest = this.getDayInterest();
      result = result * 59 + ($dayInterest == null ? 43 : $dayInterest.hashCode());
      Object $returnPrincipalAmount = this.getReturnPrincipalAmount();
      result = result * 59 + ($returnPrincipalAmount == null ? 43 : $returnPrincipalAmount.hashCode());
      Object $returnInterestAmount = this.getReturnInterestAmount();
      result = result * 59 + ($returnInterestAmount == null ? 43 : $returnInterestAmount.hashCode());
      Object $paymentReasonId = this.getPaymentReasonId();
      return result * 59 + ($paymentReasonId == null ? 43 : $paymentReasonId.hashCode());
   }

   public static class ContractGivingCreditDetailBuilder {
      private Long id;
      private Long userId;
      private Long creditId;
      private Long projectId;
      private Long purchaseId;
      private Long orderId;
      private Long supplierPaymentId;
      private LocalDateTime useDate;
      private BigDecimal useAmount;
      private BigDecimal annualInterest;
      private BigDecimal monthlyInterest;
      private BigDecimal dayInterest;
      private BigDecimal returnPrincipalAmount;
      private BigDecimal returnInterestAmount;
      private String paymentReasonId;
      private Integer auditStatus;
      private Integer isStatus;

      ContractGivingCreditDetailBuilder() {
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder creditId(final Long creditId) {
         this.creditId = creditId;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder supplierPaymentId(final Long supplierPaymentId) {
         this.supplierPaymentId = supplierPaymentId;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder useDate(final LocalDateTime useDate) {
         this.useDate = useDate;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder useAmount(final BigDecimal useAmount) {
         this.useAmount = useAmount;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder annualInterest(final BigDecimal annualInterest) {
         this.annualInterest = annualInterest;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder monthlyInterest(final BigDecimal monthlyInterest) {
         this.monthlyInterest = monthlyInterest;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder dayInterest(final BigDecimal dayInterest) {
         this.dayInterest = dayInterest;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder returnPrincipalAmount(final BigDecimal returnPrincipalAmount) {
         this.returnPrincipalAmount = returnPrincipalAmount;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder returnInterestAmount(final BigDecimal returnInterestAmount) {
         this.returnInterestAmount = returnInterestAmount;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder paymentReasonId(final String paymentReasonId) {
         this.paymentReasonId = paymentReasonId;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractGivingCreditDetail.ContractGivingCreditDetailBuilder isStatus(final Integer isStatus) {
         this.isStatus = isStatus;
         return this;
      }

      public ContractGivingCreditDetail build() {
         return new ContractGivingCreditDetail(
            this.id,
            this.userId,
            this.creditId,
            this.projectId,
            this.purchaseId,
            this.orderId,
            this.supplierPaymentId,
            this.useDate,
            this.useAmount,
            this.annualInterest,
            this.monthlyInterest,
            this.dayInterest,
            this.returnPrincipalAmount,
            this.returnInterestAmount,
            this.paymentReasonId,
            this.auditStatus,
            this.isStatus
         );
      }

      @Override
      public String toString() {
         return "ContractGivingCreditDetail.ContractGivingCreditDetailBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", creditId="
            + this.creditId
            + ", projectId="
            + this.projectId
            + ", purchaseId="
            + this.purchaseId
            + ", orderId="
            + this.orderId
            + ", supplierPaymentId="
            + this.supplierPaymentId
            + ", useDate="
            + this.useDate
            + ", useAmount="
            + this.useAmount
            + ", annualInterest="
            + this.annualInterest
            + ", monthlyInterest="
            + this.monthlyInterest
            + ", dayInterest="
            + this.dayInterest
            + ", returnPrincipalAmount="
            + this.returnPrincipalAmount
            + ", returnInterestAmount="
            + this.returnInterestAmount
            + ", paymentReasonId="
            + this.paymentReasonId
            + ", auditStatus="
            + this.auditStatus
            + ", isStatus="
            + this.isStatus
            + ")";
      }
   }
}
