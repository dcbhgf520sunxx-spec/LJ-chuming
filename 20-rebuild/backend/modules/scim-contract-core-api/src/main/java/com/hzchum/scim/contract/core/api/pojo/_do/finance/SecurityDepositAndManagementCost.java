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

@ApiModel(value = "SecurityDepositAndManagementCost对象", description = "保证金与管理费 ")
@Entity
@TableName("security_deposit_and_management_cost")
@Table(name = "security_deposit_and_management_cost")
@org.hibernate.annotations.Table(appliesTo = "security_deposit_and_management_cost", comment = "保证金与管理费 ")
public class SecurityDepositAndManagementCost extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "dateTime", value = "记录日期", notes = "记录日期")
   @TableField("date_time")
   @Column(name = "date_time", columnDefinition = "datetime(6) COMMENT '记录日期'", nullable = false)
   private LocalDateTime dateTime;
   @ApiModelProperty(name = "income", value = "收入", notes = "收入")
   @TableField("income")
   @Column(name = "income", columnDefinition = "decimal(32,8)  COMMENT '收入'", nullable = true)
   private BigDecimal income;
   @ApiModelProperty(name = "amountOperationTypeEnum", value = "资金操作类型 1扣除 2退还", notes = "资金操作类型 1扣除 2退还")
   @TableField("amount_operation_type_enum")
   @Column(name = "amount_operation_type_enum", columnDefinition = "int(11) DEFAULT 1 COMMENT '资金操作类型 1扣除 2退还'", nullable = false)
   private Integer amountOperationTypeEnum;
   @ApiModelProperty(name = "collectionId", value = "收款表id", notes = "收款表id")
   @TableField("collection_id")
   @Column(name = "collection_id", columnDefinition = "bigint(20)  COMMENT '项目id'")
   private Long collectionId;
   @ApiModelProperty(name = "management_fee_rate", notes = "管理费率")
   @TableField("management_fee_rate")
   @Column(name = "management_fee_rate", columnDefinition = "decimal(32,8) default 0 comment '管理费率'")
   private BigDecimal managementFeeRate;
   @ApiModelProperty(name = "amount", value = "金额", notes = "金额")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,8) DEFAULT 0  COMMENT '金额'", nullable = false)
   private BigDecimal amount;
   @ApiModelProperty(name = "securityDeductIncome", value = "保证金扣除金额", notes = "保证金扣除金额")
   @TableField("security_deduct_income")
   @Column(name = "security_deduct_income", columnDefinition = "decimal(32,8)  COMMENT '保证金扣除金额'", nullable = true)
   private BigDecimal securityDeductIncome;
   @ApiModelProperty(name = "securityRecord", value = "保证金退还记录", notes = "保证金退还记录")
   @TableField("security_record")
   @Column(name = "security_record", columnDefinition = "decimal(32,8)  COMMENT '保证金退还记录'", nullable = true)
   private BigDecimal securityRecord;
   @ApiModelProperty(name = "managementDeductIncome", value = "管理费扣除金额", notes = "管理费扣除金额")
   @TableField("management_deduct_income")
   @Column(name = "management_deduct_income", columnDefinition = "decimal(32,8)  COMMENT '管理费扣除金额'", nullable = true)
   private BigDecimal managementDeductIncome;
   @ApiModelProperty(name = "rate", value = "管理费费率", notes = "管理费费率")
   @TableField("rate")
   @Column(name = "rate", columnDefinition = "varchar(64)  COMMENT '管理费费率'", nullable = true)
   private String rate;
   @ApiModelProperty(name = "managementRecord", value = "管理费退还金额", notes = "管理费退还金额")
   @TableField("management_record")
   @Column(name = "management_record", columnDefinition = "decimal(32,8)  COMMENT '管理费退还记录'", nullable = true)
   private BigDecimal managementRecord;
   @ApiModelProperty(name = "amountType", value = "金额类型  1保证金 2管理费 ", notes = "金额类型  1保证金 2管理费")
   @TableField("amount_type")
   @Column(name = "amount_type", columnDefinition = "tinyint(1) COMMENT '金额类型 1保证金 2管理费'", nullable = false)
   private Integer amountType;
   @ApiModelProperty(name = "voucherNumber", value = "凭证号")
   @TableField("voucher_number")
   @Column(name = "voucher_number", columnDefinition = "varchar(128) default '0' comment '凭证号'", nullable = false)
   private String voucherNumber;
   @ApiModelProperty(name = "residualAmount", value = "剩余金额", notes = "剩余金额")
   @TableField("residual_amount")
   @Column(name = "residual_amount", columnDefinition = "decimal(32,8)  COMMENT '剩余金额'", nullable = true)
   private BigDecimal residualAmount;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(64)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1待审核 2通过 4驳回", notes = "审核状态 1待审核 2通过 4驳回")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11) DEFAULT 1 COMMENT '审核状态 1待审核 2通过 4驳回'", nullable = false)
   private Integer auditStatus;

   public static SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder builder() {
      return new SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder();
   }

   public SecurityDepositAndManagementCost() {
   }

   public SecurityDepositAndManagementCost(
      final Long id,
      final Long userId,
      final Long projectId,
      final LocalDateTime dateTime,
      final BigDecimal income,
      final Integer amountOperationTypeEnum,
      final Long collectionId,
      final BigDecimal managementFeeRate,
      final BigDecimal amount,
      final BigDecimal securityDeductIncome,
      final BigDecimal securityRecord,
      final BigDecimal managementDeductIncome,
      final String rate,
      final BigDecimal managementRecord,
      final Integer amountType,
      final String voucherNumber,
      final BigDecimal residualAmount,
      final String remark,
      final Integer auditStatus
   ) {
      this.id = id;
      this.userId = userId;
      this.projectId = projectId;
      this.dateTime = dateTime;
      this.income = income;
      this.amountOperationTypeEnum = amountOperationTypeEnum;
      this.collectionId = collectionId;
      this.managementFeeRate = managementFeeRate;
      this.amount = amount;
      this.securityDeductIncome = securityDeductIncome;
      this.securityRecord = securityRecord;
      this.managementDeductIncome = managementDeductIncome;
      this.rate = rate;
      this.managementRecord = managementRecord;
      this.amountType = amountType;
      this.voucherNumber = voucherNumber;
      this.residualAmount = residualAmount;
      this.remark = remark;
      this.auditStatus = auditStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDateTime getDateTime() {
      return this.dateTime;
   }

   public BigDecimal getIncome() {
      return this.income;
   }

   public Integer getAmountOperationTypeEnum() {
      return this.amountOperationTypeEnum;
   }

   public Long getCollectionId() {
      return this.collectionId;
   }

   public BigDecimal getManagementFeeRate() {
      return this.managementFeeRate;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getSecurityDeductIncome() {
      return this.securityDeductIncome;
   }

   public BigDecimal getSecurityRecord() {
      return this.securityRecord;
   }

   public BigDecimal getManagementDeductIncome() {
      return this.managementDeductIncome;
   }

   public String getRate() {
      return this.rate;
   }

   public BigDecimal getManagementRecord() {
      return this.managementRecord;
   }

   public Integer getAmountType() {
      return this.amountType;
   }

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public BigDecimal getResidualAmount() {
      return this.residualAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public SecurityDepositAndManagementCost setId(final Long id) {
      this.id = id;
      return this;
   }

   public SecurityDepositAndManagementCost setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public SecurityDepositAndManagementCost setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public SecurityDepositAndManagementCost setDateTime(final LocalDateTime dateTime) {
      this.dateTime = dateTime;
      return this;
   }

   public SecurityDepositAndManagementCost setIncome(final BigDecimal income) {
      this.income = income;
      return this;
   }

   public SecurityDepositAndManagementCost setAmountOperationTypeEnum(final Integer amountOperationTypeEnum) {
      this.amountOperationTypeEnum = amountOperationTypeEnum;
      return this;
   }

   public SecurityDepositAndManagementCost setCollectionId(final Long collectionId) {
      this.collectionId = collectionId;
      return this;
   }

   public SecurityDepositAndManagementCost setManagementFeeRate(final BigDecimal managementFeeRate) {
      this.managementFeeRate = managementFeeRate;
      return this;
   }

   public SecurityDepositAndManagementCost setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public SecurityDepositAndManagementCost setSecurityDeductIncome(final BigDecimal securityDeductIncome) {
      this.securityDeductIncome = securityDeductIncome;
      return this;
   }

   public SecurityDepositAndManagementCost setSecurityRecord(final BigDecimal securityRecord) {
      this.securityRecord = securityRecord;
      return this;
   }

   public SecurityDepositAndManagementCost setManagementDeductIncome(final BigDecimal managementDeductIncome) {
      this.managementDeductIncome = managementDeductIncome;
      return this;
   }

   public SecurityDepositAndManagementCost setRate(final String rate) {
      this.rate = rate;
      return this;
   }

   public SecurityDepositAndManagementCost setManagementRecord(final BigDecimal managementRecord) {
      this.managementRecord = managementRecord;
      return this;
   }

   public SecurityDepositAndManagementCost setAmountType(final Integer amountType) {
      this.amountType = amountType;
      return this;
   }

   public SecurityDepositAndManagementCost setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
      return this;
   }

   public SecurityDepositAndManagementCost setResidualAmount(final BigDecimal residualAmount) {
      this.residualAmount = residualAmount;
      return this;
   }

   public SecurityDepositAndManagementCost setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public SecurityDepositAndManagementCost setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @Override
   public String toString() {
      return "SecurityDepositAndManagementCost(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", projectId="
         + this.getProjectId()
         + ", dateTime="
         + this.getDateTime()
         + ", income="
         + this.getIncome()
         + ", amountOperationTypeEnum="
         + this.getAmountOperationTypeEnum()
         + ", collectionId="
         + this.getCollectionId()
         + ", managementFeeRate="
         + this.getManagementFeeRate()
         + ", amount="
         + this.getAmount()
         + ", securityDeductIncome="
         + this.getSecurityDeductIncome()
         + ", securityRecord="
         + this.getSecurityRecord()
         + ", managementDeductIncome="
         + this.getManagementDeductIncome()
         + ", rate="
         + this.getRate()
         + ", managementRecord="
         + this.getManagementRecord()
         + ", amountType="
         + this.getAmountType()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", residualAmount="
         + this.getResidualAmount()
         + ", remark="
         + this.getRemark()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SecurityDepositAndManagementCost)) {
         return false;
      }

      SecurityDepositAndManagementCost other = (SecurityDepositAndManagementCost)o;
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
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$amountOperationTypeEnum = this.getAmountOperationTypeEnum();
               Object other$amountOperationTypeEnum = other.getAmountOperationTypeEnum();
               if (this$amountOperationTypeEnum == null
                  ? other$amountOperationTypeEnum == null
                  : this$amountOperationTypeEnum.equals(other$amountOperationTypeEnum)) {
                  Object this$collectionId = this.getCollectionId();
                  Object other$collectionId = other.getCollectionId();
                  if (this$collectionId == null ? other$collectionId == null : this$collectionId.equals(other$collectionId)) {
                     Object this$amountType = this.getAmountType();
                     Object other$amountType = other.getAmountType();
                     if (this$amountType == null ? other$amountType == null : this$amountType.equals(other$amountType)) {
                        Object this$auditStatus = this.getAuditStatus();
                        Object other$auditStatus = other.getAuditStatus();
                        if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                           Object this$dateTime = this.getDateTime();
                           Object other$dateTime = other.getDateTime();
                           if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
                              Object this$income = this.getIncome();
                              Object other$income = other.getIncome();
                              if (this$income == null ? other$income == null : this$income.equals(other$income)) {
                                 Object this$managementFeeRate = this.getManagementFeeRate();
                                 Object other$managementFeeRate = other.getManagementFeeRate();
                                 if (this$managementFeeRate == null ? other$managementFeeRate == null : this$managementFeeRate.equals(other$managementFeeRate)) {
                                    Object this$amount = this.getAmount();
                                    Object other$amount = other.getAmount();
                                    if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                       Object this$securityDeductIncome = this.getSecurityDeductIncome();
                                       Object other$securityDeductIncome = other.getSecurityDeductIncome();
                                       if (this$securityDeductIncome == null
                                          ? other$securityDeductIncome == null
                                          : this$securityDeductIncome.equals(other$securityDeductIncome)) {
                                          Object this$securityRecord = this.getSecurityRecord();
                                          Object other$securityRecord = other.getSecurityRecord();
                                          if (this$securityRecord == null ? other$securityRecord == null : this$securityRecord.equals(other$securityRecord)) {
                                             Object this$managementDeductIncome = this.getManagementDeductIncome();
                                             Object other$managementDeductIncome = other.getManagementDeductIncome();
                                             if (this$managementDeductIncome == null
                                                ? other$managementDeductIncome == null
                                                : this$managementDeductIncome.equals(other$managementDeductIncome)) {
                                                Object this$rate = this.getRate();
                                                Object other$rate = other.getRate();
                                                if (this$rate == null ? other$rate == null : this$rate.equals(other$rate)) {
                                                   Object this$managementRecord = this.getManagementRecord();
                                                   Object other$managementRecord = other.getManagementRecord();
                                                   if (this$managementRecord == null
                                                      ? other$managementRecord == null
                                                      : this$managementRecord.equals(other$managementRecord)) {
                                                      Object this$voucherNumber = this.getVoucherNumber();
                                                      Object other$voucherNumber = other.getVoucherNumber();
                                                      if (this$voucherNumber == null
                                                         ? other$voucherNumber == null
                                                         : this$voucherNumber.equals(other$voucherNumber)) {
                                                         Object this$residualAmount = this.getResidualAmount();
                                                         Object other$residualAmount = other.getResidualAmount();
                                                         if (this$residualAmount == null
                                                            ? other$residualAmount == null
                                                            : this$residualAmount.equals(other$residualAmount)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SecurityDepositAndManagementCost;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $amountOperationTypeEnum = this.getAmountOperationTypeEnum();
      result = result * 59 + ($amountOperationTypeEnum == null ? 43 : $amountOperationTypeEnum.hashCode());
      Object $collectionId = this.getCollectionId();
      result = result * 59 + ($collectionId == null ? 43 : $collectionId.hashCode());
      Object $amountType = this.getAmountType();
      result = result * 59 + ($amountType == null ? 43 : $amountType.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $income = this.getIncome();
      result = result * 59 + ($income == null ? 43 : $income.hashCode());
      Object $managementFeeRate = this.getManagementFeeRate();
      result = result * 59 + ($managementFeeRate == null ? 43 : $managementFeeRate.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $securityDeductIncome = this.getSecurityDeductIncome();
      result = result * 59 + ($securityDeductIncome == null ? 43 : $securityDeductIncome.hashCode());
      Object $securityRecord = this.getSecurityRecord();
      result = result * 59 + ($securityRecord == null ? 43 : $securityRecord.hashCode());
      Object $managementDeductIncome = this.getManagementDeductIncome();
      result = result * 59 + ($managementDeductIncome == null ? 43 : $managementDeductIncome.hashCode());
      Object $rate = this.getRate();
      result = result * 59 + ($rate == null ? 43 : $rate.hashCode());
      Object $managementRecord = this.getManagementRecord();
      result = result * 59 + ($managementRecord == null ? 43 : $managementRecord.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $residualAmount = this.getResidualAmount();
      result = result * 59 + ($residualAmount == null ? 43 : $residualAmount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class SecurityDepositAndManagementCostBuilder {
      private Long id;
      private Long userId;
      private Long projectId;
      private LocalDateTime dateTime;
      private BigDecimal income;
      private Integer amountOperationTypeEnum;
      private Long collectionId;
      private BigDecimal managementFeeRate;
      private BigDecimal amount;
      private BigDecimal securityDeductIncome;
      private BigDecimal securityRecord;
      private BigDecimal managementDeductIncome;
      private String rate;
      private BigDecimal managementRecord;
      private Integer amountType;
      private String voucherNumber;
      private BigDecimal residualAmount;
      private String remark;
      private Integer auditStatus;

      SecurityDepositAndManagementCostBuilder() {
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder dateTime(final LocalDateTime dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder income(final BigDecimal income) {
         this.income = income;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder amountOperationTypeEnum(final Integer amountOperationTypeEnum) {
         this.amountOperationTypeEnum = amountOperationTypeEnum;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder collectionId(final Long collectionId) {
         this.collectionId = collectionId;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder managementFeeRate(final BigDecimal managementFeeRate) {
         this.managementFeeRate = managementFeeRate;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder securityDeductIncome(final BigDecimal securityDeductIncome) {
         this.securityDeductIncome = securityDeductIncome;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder securityRecord(final BigDecimal securityRecord) {
         this.securityRecord = securityRecord;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder managementDeductIncome(final BigDecimal managementDeductIncome) {
         this.managementDeductIncome = managementDeductIncome;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder rate(final String rate) {
         this.rate = rate;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder managementRecord(final BigDecimal managementRecord) {
         this.managementRecord = managementRecord;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder amountType(final Integer amountType) {
         this.amountType = amountType;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder residualAmount(final BigDecimal residualAmount) {
         this.residualAmount = residualAmount;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public SecurityDepositAndManagementCost build() {
         return new SecurityDepositAndManagementCost(
            this.id,
            this.userId,
            this.projectId,
            this.dateTime,
            this.income,
            this.amountOperationTypeEnum,
            this.collectionId,
            this.managementFeeRate,
            this.amount,
            this.securityDeductIncome,
            this.securityRecord,
            this.managementDeductIncome,
            this.rate,
            this.managementRecord,
            this.amountType,
            this.voucherNumber,
            this.residualAmount,
            this.remark,
            this.auditStatus
         );
      }

      @Override
      public String toString() {
         return "SecurityDepositAndManagementCost.SecurityDepositAndManagementCostBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", projectId="
            + this.projectId
            + ", dateTime="
            + this.dateTime
            + ", income="
            + this.income
            + ", amountOperationTypeEnum="
            + this.amountOperationTypeEnum
            + ", collectionId="
            + this.collectionId
            + ", managementFeeRate="
            + this.managementFeeRate
            + ", amount="
            + this.amount
            + ", securityDeductIncome="
            + this.securityDeductIncome
            + ", securityRecord="
            + this.securityRecord
            + ", managementDeductIncome="
            + this.managementDeductIncome
            + ", rate="
            + this.rate
            + ", managementRecord="
            + this.managementRecord
            + ", amountType="
            + this.amountType
            + ", voucherNumber="
            + this.voucherNumber
            + ", residualAmount="
            + this.residualAmount
            + ", remark="
            + this.remark
            + ", auditStatus="
            + this.auditStatus
            + ")";
      }
   }
}
