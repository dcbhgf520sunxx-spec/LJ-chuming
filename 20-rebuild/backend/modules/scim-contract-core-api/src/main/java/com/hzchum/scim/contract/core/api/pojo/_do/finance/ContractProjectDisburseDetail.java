package com.hzchum.scim.contract.core.api.pojo._do.finance;

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

@ApiModel(value = "ContractProjectDisburseDetail对象", description = "项目支出表 ")
@Entity
@TableName("contract_project_disburse_detail")
@Table(name = "contract_project_disburse_detail")
@org.hibernate.annotations.Table(appliesTo = "contract_project_disburse_detail", comment = "项目支出表 ")
public class ContractProjectDisburseDetail extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "purchaseContractNumber", value = "采购合同编号", notes = "采购合同编号")
   @TableField("purchase_contract_number")
   @Column(name = "purchase_contract_number", columnDefinition = "varchar(64)  COMMENT '采购合同编号'", nullable = false)
   private String purchaseContractNumber;
   @ApiModelProperty(name = "expenseType", value = "支出类型", notes = "支出类型")
   @TableField("expense_type")
   @Column(name = "expense_type", columnDefinition = "int(11)  COMMENT '支出类型'", nullable = false)
   private Integer expenseType;
   @ApiModelProperty(name = "supplierId", value = "供应商id", notes = "供应商id")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '供应商id'", nullable = false)
   private Long supplierId;
   @ApiModelProperty(name = "purchaseDetailId", value = "采购id", notes = "采购id")
   @TableField("purchase_detail_id")
   @Column(name = "purchase_detail_id", columnDefinition = "bigint(20)  COMMENT '采购id'", nullable = true)
   private Long purchaseDetailId;
   @ApiModelProperty(name = "expenseMoney", value = "支出金额", notes = "支出金额")
   @TableField("expense_money")
   @Column(name = "expense_money", columnDefinition = "decimal(32,4)  COMMENT '支出金额'", nullable = false)
   private BigDecimal expenseMoney;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理", notes = "项目经理")
   @TableField("project_manager_id")
   @Column(name = "project_manager_id", columnDefinition = "bigint(20)  COMMENT '项目经理'", nullable = false)
   private Long projectManagerId;
   @ApiModelProperty(name = "receivingUnitId", value = "收款单位", notes = "收款单位")
   @TableField("receiving_unit_id")
   @Column(name = "receiving_unit_id", columnDefinition = "varchar(64)  COMMENT '收款单位'", nullable = true)
   private String receivingUnitId;
   @ApiModelProperty(name = "receiveBank", value = "收款银行", notes = "收款银行")
   @TableField("receive_bank")
   @Column(name = "receive_bank", columnDefinition = "bigint(20)  COMMENT '收款银行'", nullable = true)
   private Long receiveBank;
   @ApiModelProperty(name = "receiveBankAccount", value = "收款银行号码", notes = "收款银行号码")
   @TableField("receive_bank_account")
   @Column(name = "receive_bank_account", columnDefinition = "varchar(64)  COMMENT '收款银行号码'", nullable = true)
   private String receiveBankAccount;
   @ApiModelProperty(name = "paymentUnitId", value = "付款单位", notes = "付款单位")
   @TableField("payment_unit_id")
   @Column(name = "payment_unit_id", columnDefinition = "bigint(20)  COMMENT '付款单位'", nullable = true)
   private Long paymentUnitId;
   @ApiModelProperty(name = "paymentBank", value = "付款银行", notes = "付款银行")
   @TableField("payment_bank")
   @Column(name = "payment_bank", columnDefinition = "varchar(64)  COMMENT '付款银行'", nullable = true)
   private String paymentBank;
   @ApiModelProperty(name = "paymentBankAccount", value = "付款银行号码", notes = "付款银行号码")
   @TableField("payment_bank_account")
   @Column(name = "payment_bank_account", columnDefinition = "varchar(64)  COMMENT '付款银行号码'", nullable = true)
   private String paymentBankAccount;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'", nullable = true)
   private String remark;

   public static ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder builder() {
      return new ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder();
   }

   public ContractProjectDisburseDetail() {
   }

   public ContractProjectDisburseDetail(
      final Long id,
      final Long userId,
      final String purchaseContractNumber,
      final Integer expenseType,
      final Long supplierId,
      final Long purchaseDetailId,
      final BigDecimal expenseMoney,
      final Long projectId,
      final Long projectManagerId,
      final String receivingUnitId,
      final Long receiveBank,
      final String receiveBankAccount,
      final Long paymentUnitId,
      final String paymentBank,
      final String paymentBankAccount,
      final String remark
   ) {
      this.id = id;
      this.userId = userId;
      this.purchaseContractNumber = purchaseContractNumber;
      this.expenseType = expenseType;
      this.supplierId = supplierId;
      this.purchaseDetailId = purchaseDetailId;
      this.expenseMoney = expenseMoney;
      this.projectId = projectId;
      this.projectManagerId = projectManagerId;
      this.receivingUnitId = receivingUnitId;
      this.receiveBank = receiveBank;
      this.receiveBankAccount = receiveBankAccount;
      this.paymentUnitId = paymentUnitId;
      this.paymentBank = paymentBank;
      this.paymentBankAccount = paymentBankAccount;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getPurchaseContractNumber() {
      return this.purchaseContractNumber;
   }

   public Integer getExpenseType() {
      return this.expenseType;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getPurchaseDetailId() {
      return this.purchaseDetailId;
   }

   public BigDecimal getExpenseMoney() {
      return this.expenseMoney;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getReceivingUnitId() {
      return this.receivingUnitId;
   }

   public Long getReceiveBank() {
      return this.receiveBank;
   }

   public String getReceiveBankAccount() {
      return this.receiveBankAccount;
   }

   public Long getPaymentUnitId() {
      return this.paymentUnitId;
   }

   public String getPaymentBank() {
      return this.paymentBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public String getRemark() {
      return this.remark;
   }

   public ContractProjectDisburseDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractProjectDisburseDetail setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractProjectDisburseDetail setPurchaseContractNumber(final String purchaseContractNumber) {
      this.purchaseContractNumber = purchaseContractNumber;
      return this;
   }

   public ContractProjectDisburseDetail setExpenseType(final Integer expenseType) {
      this.expenseType = expenseType;
      return this;
   }

   public ContractProjectDisburseDetail setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public ContractProjectDisburseDetail setPurchaseDetailId(final Long purchaseDetailId) {
      this.purchaseDetailId = purchaseDetailId;
      return this;
   }

   public ContractProjectDisburseDetail setExpenseMoney(final BigDecimal expenseMoney) {
      this.expenseMoney = expenseMoney;
      return this;
   }

   public ContractProjectDisburseDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractProjectDisburseDetail setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public ContractProjectDisburseDetail setReceivingUnitId(final String receivingUnitId) {
      this.receivingUnitId = receivingUnitId;
      return this;
   }

   public ContractProjectDisburseDetail setReceiveBank(final Long receiveBank) {
      this.receiveBank = receiveBank;
      return this;
   }

   public ContractProjectDisburseDetail setReceiveBankAccount(final String receiveBankAccount) {
      this.receiveBankAccount = receiveBankAccount;
      return this;
   }

   public ContractProjectDisburseDetail setPaymentUnitId(final Long paymentUnitId) {
      this.paymentUnitId = paymentUnitId;
      return this;
   }

   public ContractProjectDisburseDetail setPaymentBank(final String paymentBank) {
      this.paymentBank = paymentBank;
      return this;
   }

   public ContractProjectDisburseDetail setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
      return this;
   }

   public ContractProjectDisburseDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "ContractProjectDisburseDetail(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", purchaseContractNumber="
         + this.getPurchaseContractNumber()
         + ", expenseType="
         + this.getExpenseType()
         + ", supplierId="
         + this.getSupplierId()
         + ", purchaseDetailId="
         + this.getPurchaseDetailId()
         + ", expenseMoney="
         + this.getExpenseMoney()
         + ", projectId="
         + this.getProjectId()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", receivingUnitId="
         + this.getReceivingUnitId()
         + ", receiveBank="
         + this.getReceiveBank()
         + ", receiveBankAccount="
         + this.getReceiveBankAccount()
         + ", paymentUnitId="
         + this.getPaymentUnitId()
         + ", paymentBank="
         + this.getPaymentBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectDisburseDetail)) {
         return false;
      }

      ContractProjectDisburseDetail other = (ContractProjectDisburseDetail)o;
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
            Object this$expenseType = this.getExpenseType();
            Object other$expenseType = other.getExpenseType();
            if (this$expenseType == null ? other$expenseType == null : this$expenseType.equals(other$expenseType)) {
               Object this$supplierId = this.getSupplierId();
               Object other$supplierId = other.getSupplierId();
               if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                  Object this$purchaseDetailId = this.getPurchaseDetailId();
                  Object other$purchaseDetailId = other.getPurchaseDetailId();
                  if (this$purchaseDetailId == null ? other$purchaseDetailId == null : this$purchaseDetailId.equals(other$purchaseDetailId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$projectManagerId = this.getProjectManagerId();
                        Object other$projectManagerId = other.getProjectManagerId();
                        if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                           Object this$receiveBank = this.getReceiveBank();
                           Object other$receiveBank = other.getReceiveBank();
                           if (this$receiveBank == null ? other$receiveBank == null : this$receiveBank.equals(other$receiveBank)) {
                              Object this$paymentUnitId = this.getPaymentUnitId();
                              Object other$paymentUnitId = other.getPaymentUnitId();
                              if (this$paymentUnitId == null ? other$paymentUnitId == null : this$paymentUnitId.equals(other$paymentUnitId)) {
                                 Object this$purchaseContractNumber = this.getPurchaseContractNumber();
                                 Object other$purchaseContractNumber = other.getPurchaseContractNumber();
                                 if (this$purchaseContractNumber == null
                                    ? other$purchaseContractNumber == null
                                    : this$purchaseContractNumber.equals(other$purchaseContractNumber)) {
                                    Object this$expenseMoney = this.getExpenseMoney();
                                    Object other$expenseMoney = other.getExpenseMoney();
                                    if (this$expenseMoney == null ? other$expenseMoney == null : this$expenseMoney.equals(other$expenseMoney)) {
                                       Object this$receivingUnitId = this.getReceivingUnitId();
                                       Object other$receivingUnitId = other.getReceivingUnitId();
                                       if (this$receivingUnitId == null ? other$receivingUnitId == null : this$receivingUnitId.equals(other$receivingUnitId)) {
                                          Object this$receiveBankAccount = this.getReceiveBankAccount();
                                          Object other$receiveBankAccount = other.getReceiveBankAccount();
                                          if (this$receiveBankAccount == null
                                             ? other$receiveBankAccount == null
                                             : this$receiveBankAccount.equals(other$receiveBankAccount)) {
                                             Object this$paymentBank = this.getPaymentBank();
                                             Object other$paymentBank = other.getPaymentBank();
                                             if (this$paymentBank == null ? other$paymentBank == null : this$paymentBank.equals(other$paymentBank)) {
                                                Object this$paymentBankAccount = this.getPaymentBankAccount();
                                                Object other$paymentBankAccount = other.getPaymentBankAccount();
                                                if (this$paymentBankAccount == null
                                                   ? other$paymentBankAccount == null
                                                   : this$paymentBankAccount.equals(other$paymentBankAccount)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractProjectDisburseDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $expenseType = this.getExpenseType();
      result = result * 59 + ($expenseType == null ? 43 : $expenseType.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $purchaseDetailId = this.getPurchaseDetailId();
      result = result * 59 + ($purchaseDetailId == null ? 43 : $purchaseDetailId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $receiveBank = this.getReceiveBank();
      result = result * 59 + ($receiveBank == null ? 43 : $receiveBank.hashCode());
      Object $paymentUnitId = this.getPaymentUnitId();
      result = result * 59 + ($paymentUnitId == null ? 43 : $paymentUnitId.hashCode());
      Object $purchaseContractNumber = this.getPurchaseContractNumber();
      result = result * 59 + ($purchaseContractNumber == null ? 43 : $purchaseContractNumber.hashCode());
      Object $expenseMoney = this.getExpenseMoney();
      result = result * 59 + ($expenseMoney == null ? 43 : $expenseMoney.hashCode());
      Object $receivingUnitId = this.getReceivingUnitId();
      result = result * 59 + ($receivingUnitId == null ? 43 : $receivingUnitId.hashCode());
      Object $receiveBankAccount = this.getReceiveBankAccount();
      result = result * 59 + ($receiveBankAccount == null ? 43 : $receiveBankAccount.hashCode());
      Object $paymentBank = this.getPaymentBank();
      result = result * 59 + ($paymentBank == null ? 43 : $paymentBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ContractProjectDisburseDetailBuilder {
      private Long id;
      private Long userId;
      private String purchaseContractNumber;
      private Integer expenseType;
      private Long supplierId;
      private Long purchaseDetailId;
      private BigDecimal expenseMoney;
      private Long projectId;
      private Long projectManagerId;
      private String receivingUnitId;
      private Long receiveBank;
      private String receiveBankAccount;
      private Long paymentUnitId;
      private String paymentBank;
      private String paymentBankAccount;
      private String remark;

      ContractProjectDisburseDetailBuilder() {
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder purchaseContractNumber(final String purchaseContractNumber) {
         this.purchaseContractNumber = purchaseContractNumber;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder expenseType(final Integer expenseType) {
         this.expenseType = expenseType;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder purchaseDetailId(final Long purchaseDetailId) {
         this.purchaseDetailId = purchaseDetailId;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder expenseMoney(final BigDecimal expenseMoney) {
         this.expenseMoney = expenseMoney;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder receivingUnitId(final String receivingUnitId) {
         this.receivingUnitId = receivingUnitId;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder receiveBank(final Long receiveBank) {
         this.receiveBank = receiveBank;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder receiveBankAccount(final String receiveBankAccount) {
         this.receiveBankAccount = receiveBankAccount;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder paymentUnitId(final Long paymentUnitId) {
         this.paymentUnitId = paymentUnitId;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder paymentBank(final String paymentBank) {
         this.paymentBank = paymentBank;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractProjectDisburseDetail build() {
         return new ContractProjectDisburseDetail(
            this.id,
            this.userId,
            this.purchaseContractNumber,
            this.expenseType,
            this.supplierId,
            this.purchaseDetailId,
            this.expenseMoney,
            this.projectId,
            this.projectManagerId,
            this.receivingUnitId,
            this.receiveBank,
            this.receiveBankAccount,
            this.paymentUnitId,
            this.paymentBank,
            this.paymentBankAccount,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractProjectDisburseDetail.ContractProjectDisburseDetailBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", purchaseContractNumber="
            + this.purchaseContractNumber
            + ", expenseType="
            + this.expenseType
            + ", supplierId="
            + this.supplierId
            + ", purchaseDetailId="
            + this.purchaseDetailId
            + ", expenseMoney="
            + this.expenseMoney
            + ", projectId="
            + this.projectId
            + ", projectManagerId="
            + this.projectManagerId
            + ", receivingUnitId="
            + this.receivingUnitId
            + ", receiveBank="
            + this.receiveBank
            + ", receiveBankAccount="
            + this.receiveBankAccount
            + ", paymentUnitId="
            + this.paymentUnitId
            + ", paymentBank="
            + this.paymentBank
            + ", paymentBankAccount="
            + this.paymentBankAccount
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
