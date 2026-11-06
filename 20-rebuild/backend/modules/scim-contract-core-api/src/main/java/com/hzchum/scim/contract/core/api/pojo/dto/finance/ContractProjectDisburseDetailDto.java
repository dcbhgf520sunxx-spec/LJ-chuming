package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目支出详情")
public class ContractProjectDisburseDetailDto {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   private Long userId;
   @ApiModelProperty(name = "purchaseContractNumber", value = "采购合同编号", notes = "采购合同编号")
   private String purchaseContractNumber;
   @ApiModelProperty(name = "voucherNumber", value = "凭证号")
   private String voucherNumber;
   @ApiModelProperty(name = "expenseType", value = "支出类型", notes = "支出类型")
   private Integer expenseType;
   @ApiModelProperty(name = "supplierId", value = "供应商id", notes = "供应商id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "供应商名称", notes = "供应商名称")
   private String supplierName;
   @ApiModelProperty(name = "purchaseDetailId", value = "采购id", notes = "采购id")
   private Long purchaseDetailId;
   @ApiModelProperty(name = "expenseMoney", value = "支出金额", notes = "支出金额")
   private BigDecimal expenseMoney;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理", notes = "项目经理")
   private Long projectManagerId;
   @ApiModelProperty(name = "receivingUnitId", value = "收款单位", notes = "收款单位")
   private String receivingUnitId;
   @ApiModelProperty(name = "receiveBank", value = "收款银行", notes = "收款银行")
   private Long receiveBank;
   @ApiModelProperty(name = "receiveBankAccount", value = "收款银行号码", notes = "收款银行号码")
   private String receiveBankAccount;
   @ApiModelProperty(name = "paymentUnitId", value = "付款单位", notes = "付款单位")
   private Long paymentUnitId;
   @ApiModelProperty(name = "paymentBank", value = "付款银行", notes = "付款银行")
   private String paymentBank;
   @ApiModelProperty(name = "paymentBankAccount", value = "付款银行号码", notes = "付款银行号码")
   private String paymentBankAccount;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty("剩余未支付")
   private BigDecimal unpaidAmount;
   @ApiModelProperty("采购合同额")
   private BigDecimal projectAmount;
   @ApiModelProperty("采购合同结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("付款率")
   private BigDecimal paymentRate;
   @ApiModelProperty("累计收票")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("收票率")
   private BigDecimal invoiceRate;

   public static ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder builder() {
      return new ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder();
   }

   public ContractProjectDisburseDetailDto() {
   }

   public ContractProjectDisburseDetailDto(
      final Long id,
      final Long userId,
      final String purchaseContractNumber,
      final String voucherNumber,
      final Integer expenseType,
      final Long supplierId,
      final String supplierName,
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
      final String remark,
      final BigDecimal unpaidAmount,
      final BigDecimal projectAmount,
      final BigDecimal settlementAmount,
      final BigDecimal paymentRate,
      final BigDecimal invoiceAmount,
      final BigDecimal invoiceRate
   ) {
      this.id = id;
      this.userId = userId;
      this.purchaseContractNumber = purchaseContractNumber;
      this.voucherNumber = voucherNumber;
      this.expenseType = expenseType;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
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
      this.unpaidAmount = unpaidAmount;
      this.projectAmount = projectAmount;
      this.settlementAmount = settlementAmount;
      this.paymentRate = paymentRate;
      this.invoiceAmount = invoiceAmount;
      this.invoiceRate = invoiceRate;
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

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public Integer getExpenseType() {
      return this.expenseType;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
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

   public BigDecimal getUnpaidAmount() {
      return this.unpaidAmount;
   }

   public BigDecimal getProjectAmount() {
      return this.projectAmount;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getPaymentRate() {
      return this.paymentRate;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getInvoiceRate() {
      return this.invoiceRate;
   }

   public ContractProjectDisburseDetailDto setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractProjectDisburseDetailDto setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractProjectDisburseDetailDto setPurchaseContractNumber(final String purchaseContractNumber) {
      this.purchaseContractNumber = purchaseContractNumber;
      return this;
   }

   public ContractProjectDisburseDetailDto setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
      return this;
   }

   public ContractProjectDisburseDetailDto setExpenseType(final Integer expenseType) {
      this.expenseType = expenseType;
      return this;
   }

   public ContractProjectDisburseDetailDto setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public ContractProjectDisburseDetailDto setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public ContractProjectDisburseDetailDto setPurchaseDetailId(final Long purchaseDetailId) {
      this.purchaseDetailId = purchaseDetailId;
      return this;
   }

   public ContractProjectDisburseDetailDto setExpenseMoney(final BigDecimal expenseMoney) {
      this.expenseMoney = expenseMoney;
      return this;
   }

   public ContractProjectDisburseDetailDto setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractProjectDisburseDetailDto setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public ContractProjectDisburseDetailDto setReceivingUnitId(final String receivingUnitId) {
      this.receivingUnitId = receivingUnitId;
      return this;
   }

   public ContractProjectDisburseDetailDto setReceiveBank(final Long receiveBank) {
      this.receiveBank = receiveBank;
      return this;
   }

   public ContractProjectDisburseDetailDto setReceiveBankAccount(final String receiveBankAccount) {
      this.receiveBankAccount = receiveBankAccount;
      return this;
   }

   public ContractProjectDisburseDetailDto setPaymentUnitId(final Long paymentUnitId) {
      this.paymentUnitId = paymentUnitId;
      return this;
   }

   public ContractProjectDisburseDetailDto setPaymentBank(final String paymentBank) {
      this.paymentBank = paymentBank;
      return this;
   }

   public ContractProjectDisburseDetailDto setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
      return this;
   }

   public ContractProjectDisburseDetailDto setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ContractProjectDisburseDetailDto setUnpaidAmount(final BigDecimal unpaidAmount) {
      this.unpaidAmount = unpaidAmount;
      return this;
   }

   public ContractProjectDisburseDetailDto setProjectAmount(final BigDecimal projectAmount) {
      this.projectAmount = projectAmount;
      return this;
   }

   public ContractProjectDisburseDetailDto setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
      return this;
   }

   public ContractProjectDisburseDetailDto setPaymentRate(final BigDecimal paymentRate) {
      this.paymentRate = paymentRate;
      return this;
   }

   public ContractProjectDisburseDetailDto setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
      return this;
   }

   public ContractProjectDisburseDetailDto setInvoiceRate(final BigDecimal invoiceRate) {
      this.invoiceRate = invoiceRate;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectDisburseDetailDto)) {
         return false;
      }

      ContractProjectDisburseDetailDto other = (ContractProjectDisburseDetailDto)o;
      if (!other.canEqual(this)) {
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
                                    Object this$voucherNumber = this.getVoucherNumber();
                                    Object other$voucherNumber = other.getVoucherNumber();
                                    if (this$voucherNumber == null ? other$voucherNumber == null : this$voucherNumber.equals(other$voucherNumber)) {
                                       Object this$supplierName = this.getSupplierName();
                                       Object other$supplierName = other.getSupplierName();
                                       if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                          Object this$expenseMoney = this.getExpenseMoney();
                                          Object other$expenseMoney = other.getExpenseMoney();
                                          if (this$expenseMoney == null ? other$expenseMoney == null : this$expenseMoney.equals(other$expenseMoney)) {
                                             Object this$receivingUnitId = this.getReceivingUnitId();
                                             Object other$receivingUnitId = other.getReceivingUnitId();
                                             if (this$receivingUnitId == null
                                                ? other$receivingUnitId == null
                                                : this$receivingUnitId.equals(other$receivingUnitId)) {
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
                                                         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                            Object this$unpaidAmount = this.getUnpaidAmount();
                                                            Object other$unpaidAmount = other.getUnpaidAmount();
                                                            if (this$unpaidAmount == null
                                                               ? other$unpaidAmount == null
                                                               : this$unpaidAmount.equals(other$unpaidAmount)) {
                                                               Object this$projectAmount = this.getProjectAmount();
                                                               Object other$projectAmount = other.getProjectAmount();
                                                               if (this$projectAmount == null
                                                                  ? other$projectAmount == null
                                                                  : this$projectAmount.equals(other$projectAmount)) {
                                                                  Object this$settlementAmount = this.getSettlementAmount();
                                                                  Object other$settlementAmount = other.getSettlementAmount();
                                                                  if (this$settlementAmount == null
                                                                     ? other$settlementAmount == null
                                                                     : this$settlementAmount.equals(other$settlementAmount)) {
                                                                     Object this$paymentRate = this.getPaymentRate();
                                                                     Object other$paymentRate = other.getPaymentRate();
                                                                     if (this$paymentRate == null
                                                                        ? other$paymentRate == null
                                                                        : this$paymentRate.equals(other$paymentRate)) {
                                                                        Object this$invoiceAmount = this.getInvoiceAmount();
                                                                        Object other$invoiceAmount = other.getInvoiceAmount();
                                                                        if (this$invoiceAmount == null
                                                                           ? other$invoiceAmount == null
                                                                           : this$invoiceAmount.equals(other$invoiceAmount)) {
                                                                           Object this$invoiceRate = this.getInvoiceRate();
                                                                           Object other$invoiceRate = other.getInvoiceRate();
                                                                           return this$invoiceRate == null
                                                                              ? other$invoiceRate == null
                                                                              : this$invoiceRate.equals(other$invoiceRate);
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

   protected boolean canEqual(final Object other) {
      return other instanceof ContractProjectDisburseDetailDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
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
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
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
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $unpaidAmount = this.getUnpaidAmount();
      result = result * 59 + ($unpaidAmount == null ? 43 : $unpaidAmount.hashCode());
      Object $projectAmount = this.getProjectAmount();
      result = result * 59 + ($projectAmount == null ? 43 : $projectAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $paymentRate = this.getPaymentRate();
      result = result * 59 + ($paymentRate == null ? 43 : $paymentRate.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $invoiceRate = this.getInvoiceRate();
      return result * 59 + ($invoiceRate == null ? 43 : $invoiceRate.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectDisburseDetailDto(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", purchaseContractNumber="
         + this.getPurchaseContractNumber()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", expenseType="
         + this.getExpenseType()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
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
         + ", unpaidAmount="
         + this.getUnpaidAmount()
         + ", projectAmount="
         + this.getProjectAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", paymentRate="
         + this.getPaymentRate()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceRate="
         + this.getInvoiceRate()
         + ")";
   }

   public static class ContractProjectDisburseDetailDtoBuilder {
      private Long id;
      private Long userId;
      private String purchaseContractNumber;
      private String voucherNumber;
      private Integer expenseType;
      private Long supplierId;
      private String supplierName;
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
      private BigDecimal unpaidAmount;
      private BigDecimal projectAmount;
      private BigDecimal settlementAmount;
      private BigDecimal paymentRate;
      private BigDecimal invoiceAmount;
      private BigDecimal invoiceRate;

      ContractProjectDisburseDetailDtoBuilder() {
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder purchaseContractNumber(final String purchaseContractNumber) {
         this.purchaseContractNumber = purchaseContractNumber;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder expenseType(final Integer expenseType) {
         this.expenseType = expenseType;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder purchaseDetailId(final Long purchaseDetailId) {
         this.purchaseDetailId = purchaseDetailId;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder expenseMoney(final BigDecimal expenseMoney) {
         this.expenseMoney = expenseMoney;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder receivingUnitId(final String receivingUnitId) {
         this.receivingUnitId = receivingUnitId;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder receiveBank(final Long receiveBank) {
         this.receiveBank = receiveBank;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder receiveBankAccount(final String receiveBankAccount) {
         this.receiveBankAccount = receiveBankAccount;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder paymentUnitId(final Long paymentUnitId) {
         this.paymentUnitId = paymentUnitId;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder paymentBank(final String paymentBank) {
         this.paymentBank = paymentBank;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder unpaidAmount(final BigDecimal unpaidAmount) {
         this.unpaidAmount = unpaidAmount;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder projectAmount(final BigDecimal projectAmount) {
         this.projectAmount = projectAmount;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder paymentRate(final BigDecimal paymentRate) {
         this.paymentRate = paymentRate;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder invoiceRate(final BigDecimal invoiceRate) {
         this.invoiceRate = invoiceRate;
         return this;
      }

      public ContractProjectDisburseDetailDto build() {
         return new ContractProjectDisburseDetailDto(
            this.id,
            this.userId,
            this.purchaseContractNumber,
            this.voucherNumber,
            this.expenseType,
            this.supplierId,
            this.supplierName,
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
            this.remark,
            this.unpaidAmount,
            this.projectAmount,
            this.settlementAmount,
            this.paymentRate,
            this.invoiceAmount,
            this.invoiceRate
         );
      }

      @Override
      public String toString() {
         return "ContractProjectDisburseDetailDto.ContractProjectDisburseDetailDtoBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", purchaseContractNumber="
            + this.purchaseContractNumber
            + ", voucherNumber="
            + this.voucherNumber
            + ", expenseType="
            + this.expenseType
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
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
            + ", unpaidAmount="
            + this.unpaidAmount
            + ", projectAmount="
            + this.projectAmount
            + ", settlementAmount="
            + this.settlementAmount
            + ", paymentRate="
            + this.paymentRate
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", invoiceRate="
            + this.invoiceRate
            + ")";
      }
   }
}
