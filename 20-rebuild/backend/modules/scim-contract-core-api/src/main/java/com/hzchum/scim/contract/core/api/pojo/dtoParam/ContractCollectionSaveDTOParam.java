package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.PayTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dto.AcceptanceDraftDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("新增收款")
public class ContractCollectionSaveDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "level", value = "单位等级")
   private Integer level;
   @ApiModelProperty("凭证号")
   private String voucherNumber;
   @ApiModelProperty(name = "contractWasteId", value = "废料合同id")
   private Long contractWasteId;
   @ApiModelProperty(name = "collectionUnitId", value = "收款单位id")
   @NotNull(message = "收款单位id不能为空")
   private Long collectionUnitId;
   @ApiModelProperty(name = "collectionUnitId", value = "收款单位")
   private String collectionUnit;
   @ApiModelProperty(name = "collectionBankAccountId", value = "收款开户行账号id")
   private Long collectionBankAccountId;
   @ApiModelProperty(name = "collectionDepositBank", value = "收款开户行")
   private String collectionDepositBank;
   @ApiModelProperty(name = "collectionDate", value = "收款日期")
   @NotNull(message = "收款日期不能为空")
   private LocalDate collectionDate;
   @ApiModelProperty(name = "collectionMode", value = "收款方式")
   @NotNull(message = "收款方式不能为空")
   @EnumValidator(value = PayTypeEnum.class, message = "收款方式有误!")
   private Integer collectionMode;
   @ApiModelProperty(name = "acceptanceDraftDTOList", value = "承兑汇票列表")
   private List<AcceptanceDraftDTO> acceptanceDraftDTOList;
   @ApiModelProperty(name = "collectionAmount", value = "收款金额")
   @NotNull(message = "本次收款金额不能为空")
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "collectionReason", value = "收款是由")
   private String collectionReason;
   @ApiModelProperty(name = "paymentUnit", value = "付款单位名称")
   @NotBlank(message = "付款单位名称不能为空")
   private String paymentUnit;
   @ApiModelProperty(name = "paymentDepositBank", value = "付款方开户行")
   private String paymentDepositBank;
   @ApiModelProperty(name = "paymentBankAccount", value = "付款方银行账号")
   private String paymentBankAccount;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理id")
   private Long projectManagerId;
   @ApiModelProperty(name = "writtenById", value = "填报人id")
   private Long writtenById;
   @ApiModelProperty(name = "remark", value = "备注")
   @Size(max = 255, message = "备注字数超出限制!")
   private String remark;
   @ApiModelProperty(name = "accessoryId", value = "附件id列表")
   private List<Long> accessoryId;
   @ApiModelProperty(name = "attachmentId", value = "附件列表")
   private List<Long> attachmentId;

   public static ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder builder() {
      return new ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder();
   }

   public ContractCollectionSaveDTOParam() {
   }

   public ContractCollectionSaveDTOParam(
      final Long projectId,
      final Integer level,
      final String voucherNumber,
      final Long contractWasteId,
      final Long collectionUnitId,
      final String collectionUnit,
      final Long collectionBankAccountId,
      final String collectionDepositBank,
      final LocalDate collectionDate,
      final Integer collectionMode,
      final List<AcceptanceDraftDTO> acceptanceDraftDTOList,
      final BigDecimal collectionAmount,
      final String collectionReason,
      final String paymentUnit,
      final String paymentDepositBank,
      final String paymentBankAccount,
      final Long projectManagerId,
      final Long writtenById,
      final String remark,
      final List<Long> accessoryId,
      final List<Long> attachmentId
   ) {
      this.projectId = projectId;
      this.level = level;
      this.voucherNumber = voucherNumber;
      this.contractWasteId = contractWasteId;
      this.collectionUnitId = collectionUnitId;
      this.collectionUnit = collectionUnit;
      this.collectionBankAccountId = collectionBankAccountId;
      this.collectionDepositBank = collectionDepositBank;
      this.collectionDate = collectionDate;
      this.collectionMode = collectionMode;
      this.acceptanceDraftDTOList = acceptanceDraftDTOList;
      this.collectionAmount = collectionAmount;
      this.collectionReason = collectionReason;
      this.paymentUnit = paymentUnit;
      this.paymentDepositBank = paymentDepositBank;
      this.paymentBankAccount = paymentBankAccount;
      this.projectManagerId = projectManagerId;
      this.writtenById = writtenById;
      this.remark = remark;
      this.accessoryId = accessoryId;
      this.attachmentId = attachmentId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getLevel() {
      return this.level;
   }

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public Long getCollectionUnitId() {
      return this.collectionUnitId;
   }

   public String getCollectionUnit() {
      return this.collectionUnit;
   }

   public Long getCollectionBankAccountId() {
      return this.collectionBankAccountId;
   }

   public String getCollectionDepositBank() {
      return this.collectionDepositBank;
   }

   public LocalDate getCollectionDate() {
      return this.collectionDate;
   }

   public Integer getCollectionMode() {
      return this.collectionMode;
   }

   public List<AcceptanceDraftDTO> getAcceptanceDraftDTOList() {
      return this.acceptanceDraftDTOList;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public String getCollectionReason() {
      return this.collectionReason;
   }

   public String getPaymentUnit() {
      return this.paymentUnit;
   }

   public String getPaymentDepositBank() {
      return this.paymentDepositBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public Long getWrittenById() {
      return this.writtenById;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<Long> getAccessoryId() {
      return this.accessoryId;
   }

   public List<Long> getAttachmentId() {
      return this.attachmentId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
   }

   public void setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
   }

   public void setCollectionUnitId(final Long collectionUnitId) {
      this.collectionUnitId = collectionUnitId;
   }

   public void setCollectionUnit(final String collectionUnit) {
      this.collectionUnit = collectionUnit;
   }

   public void setCollectionBankAccountId(final Long collectionBankAccountId) {
      this.collectionBankAccountId = collectionBankAccountId;
   }

   public void setCollectionDepositBank(final String collectionDepositBank) {
      this.collectionDepositBank = collectionDepositBank;
   }

   public void setCollectionDate(final LocalDate collectionDate) {
      this.collectionDate = collectionDate;
   }

   public void setCollectionMode(final Integer collectionMode) {
      this.collectionMode = collectionMode;
   }

   public void setAcceptanceDraftDTOList(final List<AcceptanceDraftDTO> acceptanceDraftDTOList) {
      this.acceptanceDraftDTOList = acceptanceDraftDTOList;
   }

   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   public void setCollectionReason(final String collectionReason) {
      this.collectionReason = collectionReason;
   }

   public void setPaymentUnit(final String paymentUnit) {
      this.paymentUnit = paymentUnit;
   }

   public void setPaymentDepositBank(final String paymentDepositBank) {
      this.paymentDepositBank = paymentDepositBank;
   }

   public void setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAccessoryId(final List<Long> accessoryId) {
      this.accessoryId = accessoryId;
   }

   public void setAttachmentId(final List<Long> attachmentId) {
      this.attachmentId = attachmentId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractCollectionSaveDTOParam)) {
         return false;
      }

      ContractCollectionSaveDTOParam other = (ContractCollectionSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$level = this.getLevel();
         Object other$level = other.getLevel();
         if (this$level == null ? other$level == null : this$level.equals(other$level)) {
            Object this$contractWasteId = this.getContractWasteId();
            Object other$contractWasteId = other.getContractWasteId();
            if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
               Object this$collectionUnitId = this.getCollectionUnitId();
               Object other$collectionUnitId = other.getCollectionUnitId();
               if (this$collectionUnitId == null ? other$collectionUnitId == null : this$collectionUnitId.equals(other$collectionUnitId)) {
                  Object this$collectionBankAccountId = this.getCollectionBankAccountId();
                  Object other$collectionBankAccountId = other.getCollectionBankAccountId();
                  if (this$collectionBankAccountId == null
                     ? other$collectionBankAccountId == null
                     : this$collectionBankAccountId.equals(other$collectionBankAccountId)) {
                     Object this$collectionMode = this.getCollectionMode();
                     Object other$collectionMode = other.getCollectionMode();
                     if (this$collectionMode == null ? other$collectionMode == null : this$collectionMode.equals(other$collectionMode)) {
                        Object this$projectManagerId = this.getProjectManagerId();
                        Object other$projectManagerId = other.getProjectManagerId();
                        if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                           Object this$writtenById = this.getWrittenById();
                           Object other$writtenById = other.getWrittenById();
                           if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                              Object this$voucherNumber = this.getVoucherNumber();
                              Object other$voucherNumber = other.getVoucherNumber();
                              if (this$voucherNumber == null ? other$voucherNumber == null : this$voucherNumber.equals(other$voucherNumber)) {
                                 Object this$collectionUnit = this.getCollectionUnit();
                                 Object other$collectionUnit = other.getCollectionUnit();
                                 if (this$collectionUnit == null ? other$collectionUnit == null : this$collectionUnit.equals(other$collectionUnit)) {
                                    Object this$collectionDepositBank = this.getCollectionDepositBank();
                                    Object other$collectionDepositBank = other.getCollectionDepositBank();
                                    if (this$collectionDepositBank == null
                                       ? other$collectionDepositBank == null
                                       : this$collectionDepositBank.equals(other$collectionDepositBank)) {
                                       Object this$collectionDate = this.getCollectionDate();
                                       Object other$collectionDate = other.getCollectionDate();
                                       if (this$collectionDate == null ? other$collectionDate == null : this$collectionDate.equals(other$collectionDate)) {
                                          Object this$acceptanceDraftDTOList = this.getAcceptanceDraftDTOList();
                                          Object other$acceptanceDraftDTOList = other.getAcceptanceDraftDTOList();
                                          if (this$acceptanceDraftDTOList == null
                                             ? other$acceptanceDraftDTOList == null
                                             : this$acceptanceDraftDTOList.equals(other$acceptanceDraftDTOList)) {
                                             Object this$collectionAmount = this.getCollectionAmount();
                                             Object other$collectionAmount = other.getCollectionAmount();
                                             if (this$collectionAmount == null
                                                ? other$collectionAmount == null
                                                : this$collectionAmount.equals(other$collectionAmount)) {
                                                Object this$collectionReason = this.getCollectionReason();
                                                Object other$collectionReason = other.getCollectionReason();
                                                if (this$collectionReason == null
                                                   ? other$collectionReason == null
                                                   : this$collectionReason.equals(other$collectionReason)) {
                                                   Object this$paymentUnit = this.getPaymentUnit();
                                                   Object other$paymentUnit = other.getPaymentUnit();
                                                   if (this$paymentUnit == null ? other$paymentUnit == null : this$paymentUnit.equals(other$paymentUnit)) {
                                                      Object this$paymentDepositBank = this.getPaymentDepositBank();
                                                      Object other$paymentDepositBank = other.getPaymentDepositBank();
                                                      if (this$paymentDepositBank == null
                                                         ? other$paymentDepositBank == null
                                                         : this$paymentDepositBank.equals(other$paymentDepositBank)) {
                                                         Object this$paymentBankAccount = this.getPaymentBankAccount();
                                                         Object other$paymentBankAccount = other.getPaymentBankAccount();
                                                         if (this$paymentBankAccount == null
                                                            ? other$paymentBankAccount == null
                                                            : this$paymentBankAccount.equals(other$paymentBankAccount)) {
                                                            Object this$remark = this.getRemark();
                                                            Object other$remark = other.getRemark();
                                                            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                               Object this$accessoryId = this.getAccessoryId();
                                                               Object other$accessoryId = other.getAccessoryId();
                                                               if (this$accessoryId == null
                                                                  ? other$accessoryId == null
                                                                  : this$accessoryId.equals(other$accessoryId)) {
                                                                  Object this$attachmentId = this.getAttachmentId();
                                                                  Object other$attachmentId = other.getAttachmentId();
                                                                  return this$attachmentId == null
                                                                     ? other$attachmentId == null
                                                                     : this$attachmentId.equals(other$attachmentId);
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
      return other instanceof ContractCollectionSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $collectionUnitId = this.getCollectionUnitId();
      result = result * 59 + ($collectionUnitId == null ? 43 : $collectionUnitId.hashCode());
      Object $collectionBankAccountId = this.getCollectionBankAccountId();
      result = result * 59 + ($collectionBankAccountId == null ? 43 : $collectionBankAccountId.hashCode());
      Object $collectionMode = this.getCollectionMode();
      result = result * 59 + ($collectionMode == null ? 43 : $collectionMode.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $writtenById = this.getWrittenById();
      result = result * 59 + ($writtenById == null ? 43 : $writtenById.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $collectionUnit = this.getCollectionUnit();
      result = result * 59 + ($collectionUnit == null ? 43 : $collectionUnit.hashCode());
      Object $collectionDepositBank = this.getCollectionDepositBank();
      result = result * 59 + ($collectionDepositBank == null ? 43 : $collectionDepositBank.hashCode());
      Object $collectionDate = this.getCollectionDate();
      result = result * 59 + ($collectionDate == null ? 43 : $collectionDate.hashCode());
      Object $acceptanceDraftDTOList = this.getAcceptanceDraftDTOList();
      result = result * 59 + ($acceptanceDraftDTOList == null ? 43 : $acceptanceDraftDTOList.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $collectionReason = this.getCollectionReason();
      result = result * 59 + ($collectionReason == null ? 43 : $collectionReason.hashCode());
      Object $paymentUnit = this.getPaymentUnit();
      result = result * 59 + ($paymentUnit == null ? 43 : $paymentUnit.hashCode());
      Object $paymentDepositBank = this.getPaymentDepositBank();
      result = result * 59 + ($paymentDepositBank == null ? 43 : $paymentDepositBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $accessoryId = this.getAccessoryId();
      result = result * 59 + ($accessoryId == null ? 43 : $accessoryId.hashCode());
      Object $attachmentId = this.getAttachmentId();
      return result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
   }

   @Override
   public String toString() {
      return "ContractCollectionSaveDTOParam(projectId="
         + this.getProjectId()
         + ", level="
         + this.getLevel()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", collectionUnitId="
         + this.getCollectionUnitId()
         + ", collectionUnit="
         + this.getCollectionUnit()
         + ", collectionBankAccountId="
         + this.getCollectionBankAccountId()
         + ", collectionDepositBank="
         + this.getCollectionDepositBank()
         + ", collectionDate="
         + this.getCollectionDate()
         + ", collectionMode="
         + this.getCollectionMode()
         + ", acceptanceDraftDTOList="
         + this.getAcceptanceDraftDTOList()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", collectionReason="
         + this.getCollectionReason()
         + ", paymentUnit="
         + this.getPaymentUnit()
         + ", paymentDepositBank="
         + this.getPaymentDepositBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", writtenById="
         + this.getWrittenById()
         + ", remark="
         + this.getRemark()
         + ", accessoryId="
         + this.getAccessoryId()
         + ", attachmentId="
         + this.getAttachmentId()
         + ")";
   }

   public static class ContractCollectionSaveDTOParamBuilder {
      private Long projectId;
      private Integer level;
      private String voucherNumber;
      private Long contractWasteId;
      private Long collectionUnitId;
      private String collectionUnit;
      private Long collectionBankAccountId;
      private String collectionDepositBank;
      private LocalDate collectionDate;
      private Integer collectionMode;
      private List<AcceptanceDraftDTO> acceptanceDraftDTOList;
      private BigDecimal collectionAmount;
      private String collectionReason;
      private String paymentUnit;
      private String paymentDepositBank;
      private String paymentBankAccount;
      private Long projectManagerId;
      private Long writtenById;
      private String remark;
      private List<Long> accessoryId;
      private List<Long> attachmentId;

      ContractCollectionSaveDTOParamBuilder() {
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder collectionUnitId(final Long collectionUnitId) {
         this.collectionUnitId = collectionUnitId;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder collectionUnit(final String collectionUnit) {
         this.collectionUnit = collectionUnit;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder collectionBankAccountId(final Long collectionBankAccountId) {
         this.collectionBankAccountId = collectionBankAccountId;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder collectionDepositBank(final String collectionDepositBank) {
         this.collectionDepositBank = collectionDepositBank;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder collectionDate(final LocalDate collectionDate) {
         this.collectionDate = collectionDate;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder collectionMode(final Integer collectionMode) {
         this.collectionMode = collectionMode;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder acceptanceDraftDTOList(final List<AcceptanceDraftDTO> acceptanceDraftDTOList) {
         this.acceptanceDraftDTOList = acceptanceDraftDTOList;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder collectionReason(final String collectionReason) {
         this.collectionReason = collectionReason;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder paymentUnit(final String paymentUnit) {
         this.paymentUnit = paymentUnit;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder paymentDepositBank(final String paymentDepositBank) {
         this.paymentDepositBank = paymentDepositBank;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder accessoryId(final List<Long> accessoryId) {
         this.accessoryId = accessoryId;
         return this;
      }

      public ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder attachmentId(final List<Long> attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ContractCollectionSaveDTOParam build() {
         return new ContractCollectionSaveDTOParam(
            this.projectId,
            this.level,
            this.voucherNumber,
            this.contractWasteId,
            this.collectionUnitId,
            this.collectionUnit,
            this.collectionBankAccountId,
            this.collectionDepositBank,
            this.collectionDate,
            this.collectionMode,
            this.acceptanceDraftDTOList,
            this.collectionAmount,
            this.collectionReason,
            this.paymentUnit,
            this.paymentDepositBank,
            this.paymentBankAccount,
            this.projectManagerId,
            this.writtenById,
            this.remark,
            this.accessoryId,
            this.attachmentId
         );
      }

      @Override
      public String toString() {
         return "ContractCollectionSaveDTOParam.ContractCollectionSaveDTOParamBuilder(projectId="
            + this.projectId
            + ", level="
            + this.level
            + ", voucherNumber="
            + this.voucherNumber
            + ", contractWasteId="
            + this.contractWasteId
            + ", collectionUnitId="
            + this.collectionUnitId
            + ", collectionUnit="
            + this.collectionUnit
            + ", collectionBankAccountId="
            + this.collectionBankAccountId
            + ", collectionDepositBank="
            + this.collectionDepositBank
            + ", collectionDate="
            + this.collectionDate
            + ", collectionMode="
            + this.collectionMode
            + ", acceptanceDraftDTOList="
            + this.acceptanceDraftDTOList
            + ", collectionAmount="
            + this.collectionAmount
            + ", collectionReason="
            + this.collectionReason
            + ", paymentUnit="
            + this.paymentUnit
            + ", paymentDepositBank="
            + this.paymentDepositBank
            + ", paymentBankAccount="
            + this.paymentBankAccount
            + ", projectManagerId="
            + this.projectManagerId
            + ", writtenById="
            + this.writtenById
            + ", remark="
            + this.remark
            + ", accessoryId="
            + this.accessoryId
            + ", attachmentId="
            + this.attachmentId
            + ")";
      }
   }
}
