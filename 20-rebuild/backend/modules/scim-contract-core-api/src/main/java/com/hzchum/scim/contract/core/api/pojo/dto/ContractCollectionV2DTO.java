package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "ContractCollection对象", description = "收款表")
public class ContractCollectionV2DTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   private Long id;
   @ApiModelProperty(name = "voucherNumber", value = "凭证号")
   private String voucherNumber;
   @ApiModelProperty(name = "type", value = "收款类型 1项目收款 2废料收款 CollectionTypeEnum")
   private Integer type;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "contract_waste_id", value = "废料合同id")
   private Long contractWasteId;
   @ApiModelProperty(name = "collectionUnitId", value = "收款单位(项目合同签订主体)id")
   private Long collectionUnitId;
   @ApiModelProperty(name = "collectionUnit", value = "收款单位")
   private String collectionUnit;
   @ApiModelProperty(name = "collectionBankAccountId", value = "收款开户行账号id")
   private Long collectionBankAccountId;
   @ApiModelProperty(name = "collectionDepositBank", value = "收款开户行")
   private String collectionDepositBank;
   @ApiModelProperty(name = "collectionBankAccount", value = "收款开户行账号")
   private String collectionBankAccount;
   @ApiModelProperty(name = "collectionDate", value = "收款日期")
   private LocalDate collectionDate;
   @ApiModelProperty(name = "collectionMode", value = "收款方式")
   private Integer collectionMode;
   @ApiModelProperty(name = "acceptanceDraftJson", value = "承兑汇票json")
   private String acceptanceDraftJson;
   @ApiModelProperty(name = "collectionAmount", value = "收款金额")
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "collectionReason", value = "收款是由")
   private String collectionReason;
   @ApiModelProperty(name = "paymentUnit", value = "付款单位")
   private String paymentUnit;
   @ApiModelProperty(name = "paymentDepositBank", value = "付款方开户行")
   private String paymentDepositBank;
   @ApiModelProperty(name = "paymentBankAccount", value = "付款方银行账号")
   private String paymentBankAccount;
   @ApiModelProperty(name = "writtenById", value = "填报人id")
   private Long writtenById;
   @ApiModelProperty(name = "writtenByName", value = "填报人名字")
   private String writtenByName;
   @ApiModelProperty(name = "auditorId", value = "审核人id")
   private Long auditorId;
   @ApiModelProperty(name = "auditorName", value = "审核人名字")
   private String auditorName;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "auditStatus", value = "审核状态  1审核中 2审核通过 4已驳回")
   private Integer auditStatus;
   @ApiModelProperty(name = "lastEditorUserId", value = "最后编辑人id")
   private Long lastEditorUserId;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "accessoryId", value = "附件id")
   private String accessoryId;
   @ApiModelProperty("附件id字符串")
   private String attachmentIds;
   @ApiModelProperty("附件列表")
   private List<AttachmentDTO> attachments;

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public void setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
   }

   public static ContractCollectionV2DTO.ContractCollectionV2DTOBuilder builder() {
      return new ContractCollectionV2DTO.ContractCollectionV2DTOBuilder();
   }

   public ContractCollectionV2DTO() {
   }

   public ContractCollectionV2DTO(
      final Long id,
      final Integer type,
      final Long projectId,
      final Long contractWasteId,
      final Long collectionUnitId,
      final String collectionUnit,
      final Long collectionBankAccountId,
      final String collectionDepositBank,
      final String collectionBankAccount,
      final LocalDate collectionDate,
      final Integer collectionMode,
      final String acceptanceDraftJson,
      final BigDecimal collectionAmount,
      final String collectionReason,
      final String paymentUnit,
      final String paymentDepositBank,
      final String paymentBankAccount,
      final Long writtenById,
      final String writtenByName,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime,
      final Integer auditStatus,
      final Long lastEditorUserId,
      final String remark,
      final String accessoryId,
      final String attachmentIds,
      final List<AttachmentDTO> attachments
   ) {
      this.id = id;
      this.type = type;
      this.projectId = projectId;
      this.contractWasteId = contractWasteId;
      this.collectionUnitId = collectionUnitId;
      this.collectionUnit = collectionUnit;
      this.collectionBankAccountId = collectionBankAccountId;
      this.collectionDepositBank = collectionDepositBank;
      this.collectionBankAccount = collectionBankAccount;
      this.collectionDate = collectionDate;
      this.collectionMode = collectionMode;
      this.acceptanceDraftJson = acceptanceDraftJson;
      this.collectionAmount = collectionAmount;
      this.collectionReason = collectionReason;
      this.paymentUnit = paymentUnit;
      this.paymentDepositBank = paymentDepositBank;
      this.paymentBankAccount = paymentBankAccount;
      this.writtenById = writtenById;
      this.writtenByName = writtenByName;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
      this.auditStatus = auditStatus;
      this.lastEditorUserId = lastEditorUserId;
      this.remark = remark;
      this.accessoryId = accessoryId;
      this.attachmentIds = attachmentIds;
      this.attachments = attachments;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public String getCollectionBankAccount() {
      return this.collectionBankAccount;
   }

   public LocalDate getCollectionDate() {
      return this.collectionDate;
   }

   public Integer getCollectionMode() {
      return this.collectionMode;
   }

   public String getAcceptanceDraftJson() {
      return this.acceptanceDraftJson;
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

   public Long getWrittenById() {
      return this.writtenById;
   }

   public String getWrittenByName() {
      return this.writtenByName;
   }

   public Long getAuditorId() {
      return this.auditorId;
   }

   public String getAuditorName() {
      return this.auditorName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Long getLastEditorUserId() {
      return this.lastEditorUserId;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getAccessoryId() {
      return this.accessoryId;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
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

   public void setCollectionBankAccount(final String collectionBankAccount) {
      this.collectionBankAccount = collectionBankAccount;
   }

   public void setCollectionDate(final LocalDate collectionDate) {
      this.collectionDate = collectionDate;
   }

   public void setCollectionMode(final Integer collectionMode) {
      this.collectionMode = collectionMode;
   }

   public void setAcceptanceDraftJson(final String acceptanceDraftJson) {
      this.acceptanceDraftJson = acceptanceDraftJson;
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

   public void setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
   }

   public void setWrittenByName(final String writtenByName) {
      this.writtenByName = writtenByName;
   }

   public void setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
   }

   public void setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setLastEditorUserId(final Long lastEditorUserId) {
      this.lastEditorUserId = lastEditorUserId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAccessoryId(final String accessoryId) {
      this.accessoryId = accessoryId;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractCollectionV2DTO)) {
         return false;
      }

      ContractCollectionV2DTO other = (ContractCollectionV2DTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
                           Object this$writtenById = this.getWrittenById();
                           Object other$writtenById = other.getWrittenById();
                           if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                              Object this$auditorId = this.getAuditorId();
                              Object other$auditorId = other.getAuditorId();
                              if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                                 Object this$auditStatus = this.getAuditStatus();
                                 Object other$auditStatus = other.getAuditStatus();
                                 if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                    Object this$lastEditorUserId = this.getLastEditorUserId();
                                    Object other$lastEditorUserId = other.getLastEditorUserId();
                                    if (this$lastEditorUserId == null ? other$lastEditorUserId == null : this$lastEditorUserId.equals(other$lastEditorUserId)) {
                                       Object this$collectionUnit = this.getCollectionUnit();
                                       Object other$collectionUnit = other.getCollectionUnit();
                                       if (this$collectionUnit == null ? other$collectionUnit == null : this$collectionUnit.equals(other$collectionUnit)) {
                                          Object this$collectionDepositBank = this.getCollectionDepositBank();
                                          Object other$collectionDepositBank = other.getCollectionDepositBank();
                                          if (this$collectionDepositBank == null
                                             ? other$collectionDepositBank == null
                                             : this$collectionDepositBank.equals(other$collectionDepositBank)) {
                                             Object this$collectionBankAccount = this.getCollectionBankAccount();
                                             Object other$collectionBankAccount = other.getCollectionBankAccount();
                                             if (this$collectionBankAccount == null
                                                ? other$collectionBankAccount == null
                                                : this$collectionBankAccount.equals(other$collectionBankAccount)) {
                                                Object this$collectionDate = this.getCollectionDate();
                                                Object other$collectionDate = other.getCollectionDate();
                                                if (this$collectionDate == null
                                                   ? other$collectionDate == null
                                                   : this$collectionDate.equals(other$collectionDate)) {
                                                   Object this$acceptanceDraftJson = this.getAcceptanceDraftJson();
                                                   Object other$acceptanceDraftJson = other.getAcceptanceDraftJson();
                                                   if (this$acceptanceDraftJson == null
                                                      ? other$acceptanceDraftJson == null
                                                      : this$acceptanceDraftJson.equals(other$acceptanceDraftJson)) {
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
                                                            if (this$paymentUnit == null
                                                               ? other$paymentUnit == null
                                                               : this$paymentUnit.equals(other$paymentUnit)) {
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
                                                                     Object this$writtenByName = this.getWrittenByName();
                                                                     Object other$writtenByName = other.getWrittenByName();
                                                                     if (this$writtenByName == null
                                                                        ? other$writtenByName == null
                                                                        : this$writtenByName.equals(other$writtenByName)) {
                                                                        Object this$auditorName = this.getAuditorName();
                                                                        Object other$auditorName = other.getAuditorName();
                                                                        if (this$auditorName == null
                                                                           ? other$auditorName == null
                                                                           : this$auditorName.equals(other$auditorName)) {
                                                                           Object this$auditTime = this.getAuditTime();
                                                                           Object other$auditTime = other.getAuditTime();
                                                                           if (this$auditTime == null
                                                                              ? other$auditTime == null
                                                                              : this$auditTime.equals(other$auditTime)) {
                                                                              Object this$remark = this.getRemark();
                                                                              Object other$remark = other.getRemark();
                                                                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)
                                                                                 )
                                                                               {
                                                                                 Object this$accessoryId = this.getAccessoryId();
                                                                                 Object other$accessoryId = other.getAccessoryId();
                                                                                 if (this$accessoryId == null
                                                                                    ? other$accessoryId == null
                                                                                    : this$accessoryId.equals(other$accessoryId)) {
                                                                                    Object this$attachmentIds = this.getAttachmentIds();
                                                                                    Object other$attachmentIds = other.getAttachmentIds();
                                                                                    if (this$attachmentIds == null
                                                                                       ? other$attachmentIds == null
                                                                                       : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                       Object this$attachments = this.getAttachments();
                                                                                       Object other$attachments = other.getAttachments();
                                                                                       return this$attachments == null
                                                                                          ? other$attachments == null
                                                                                          : this$attachments.equals(other$attachments);
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
      return other instanceof ContractCollectionV2DTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $collectionUnitId = this.getCollectionUnitId();
      result = result * 59 + ($collectionUnitId == null ? 43 : $collectionUnitId.hashCode());
      Object $collectionBankAccountId = this.getCollectionBankAccountId();
      result = result * 59 + ($collectionBankAccountId == null ? 43 : $collectionBankAccountId.hashCode());
      Object $collectionMode = this.getCollectionMode();
      result = result * 59 + ($collectionMode == null ? 43 : $collectionMode.hashCode());
      Object $writtenById = this.getWrittenById();
      result = result * 59 + ($writtenById == null ? 43 : $writtenById.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $lastEditorUserId = this.getLastEditorUserId();
      result = result * 59 + ($lastEditorUserId == null ? 43 : $lastEditorUserId.hashCode());
      Object $collectionUnit = this.getCollectionUnit();
      result = result * 59 + ($collectionUnit == null ? 43 : $collectionUnit.hashCode());
      Object $collectionDepositBank = this.getCollectionDepositBank();
      result = result * 59 + ($collectionDepositBank == null ? 43 : $collectionDepositBank.hashCode());
      Object $collectionBankAccount = this.getCollectionBankAccount();
      result = result * 59 + ($collectionBankAccount == null ? 43 : $collectionBankAccount.hashCode());
      Object $collectionDate = this.getCollectionDate();
      result = result * 59 + ($collectionDate == null ? 43 : $collectionDate.hashCode());
      Object $acceptanceDraftJson = this.getAcceptanceDraftJson();
      result = result * 59 + ($acceptanceDraftJson == null ? 43 : $acceptanceDraftJson.hashCode());
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
      Object $writtenByName = this.getWrittenByName();
      result = result * 59 + ($writtenByName == null ? 43 : $writtenByName.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $accessoryId = this.getAccessoryId();
      result = result * 59 + ($accessoryId == null ? 43 : $accessoryId.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachments = this.getAttachments();
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   @Override
   public String toString() {
      return "ContractCollectionV2DTO(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", projectId="
         + this.getProjectId()
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
         + ", collectionBankAccount="
         + this.getCollectionBankAccount()
         + ", collectionDate="
         + this.getCollectionDate()
         + ", collectionMode="
         + this.getCollectionMode()
         + ", acceptanceDraftJson="
         + this.getAcceptanceDraftJson()
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
         + ", writtenById="
         + this.getWrittenById()
         + ", writtenByName="
         + this.getWrittenByName()
         + ", auditorId="
         + this.getAuditorId()
         + ", auditorName="
         + this.getAuditorName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", lastEditorUserId="
         + this.getLastEditorUserId()
         + ", remark="
         + this.getRemark()
         + ", accessoryId="
         + this.getAccessoryId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachments="
         + this.getAttachments()
         + ")";
   }

   public static class ContractCollectionV2DTOBuilder {
      private Long id;
      private String voucherNumber;
      private Integer type;
      private Long projectId;
      private Long contractWasteId;
      private Long collectionUnitId;
      private String collectionUnit;
      private Long collectionBankAccountId;
      private String collectionDepositBank;
      private String collectionBankAccount;
      private LocalDate collectionDate;
      private Integer collectionMode;
      private String acceptanceDraftJson;
      private BigDecimal collectionAmount;
      private String collectionReason;
      private String paymentUnit;
      private String paymentDepositBank;
      private String paymentBankAccount;
      private Long writtenById;
      private String writtenByName;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;
      private Integer auditStatus;
      private Long lastEditorUserId;
      private String remark;
      private String accessoryId;
      private String attachmentIds;
      private List<AttachmentDTO> attachments;

      ContractCollectionV2DTOBuilder() {
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder collectionUnitId(final Long collectionUnitId) {
         this.collectionUnitId = collectionUnitId;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder collectionUnit(final String collectionUnit) {
         this.collectionUnit = collectionUnit;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder collectionBankAccountId(final Long collectionBankAccountId) {
         this.collectionBankAccountId = collectionBankAccountId;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder collectionDepositBank(final String collectionDepositBank) {
         this.collectionDepositBank = collectionDepositBank;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder collectionBankAccount(final String collectionBankAccount) {
         this.collectionBankAccount = collectionBankAccount;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder collectionDate(final LocalDate collectionDate) {
         this.collectionDate = collectionDate;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder collectionMode(final Integer collectionMode) {
         this.collectionMode = collectionMode;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder acceptanceDraftJson(final String acceptanceDraftJson) {
         this.acceptanceDraftJson = acceptanceDraftJson;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder collectionReason(final String collectionReason) {
         this.collectionReason = collectionReason;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder paymentUnit(final String paymentUnit) {
         this.paymentUnit = paymentUnit;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder paymentDepositBank(final String paymentDepositBank) {
         this.paymentDepositBank = paymentDepositBank;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder writtenByName(final String writtenByName) {
         this.writtenByName = writtenByName;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder lastEditorUserId(final Long lastEditorUserId) {
         this.lastEditorUserId = lastEditorUserId;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder accessoryId(final String accessoryId) {
         this.accessoryId = accessoryId;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractCollectionV2DTO.ContractCollectionV2DTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractCollectionV2DTO build() {
         ContractCollectionV2DTO result = new ContractCollectionV2DTO(
            this.id,
            this.type,
            this.projectId,
            this.contractWasteId,
            this.collectionUnitId,
            this.collectionUnit,
            this.collectionBankAccountId,
            this.collectionDepositBank,
            this.collectionBankAccount,
            this.collectionDate,
            this.collectionMode,
            this.acceptanceDraftJson,
            this.collectionAmount,
            this.collectionReason,
            this.paymentUnit,
            this.paymentDepositBank,
            this.paymentBankAccount,
            this.writtenById,
            this.writtenByName,
            this.auditorId,
            this.auditorName,
            this.auditTime,
            this.auditStatus,
            this.lastEditorUserId,
            this.remark,
            this.accessoryId,
            this.attachmentIds,
            this.attachments
         );
         result.setVoucherNumber(this.voucherNumber);
         return result;
      }

      @Override
      public String toString() {
         return "ContractCollectionV2DTO.ContractCollectionV2DTOBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", projectId="
            + this.projectId
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
            + ", collectionBankAccount="
            + this.collectionBankAccount
            + ", collectionDate="
            + this.collectionDate
            + ", collectionMode="
            + this.collectionMode
            + ", acceptanceDraftJson="
            + this.acceptanceDraftJson
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
            + ", writtenById="
            + this.writtenById
            + ", writtenByName="
            + this.writtenByName
            + ", auditorId="
            + this.auditorId
            + ", auditorName="
            + this.auditorName
            + ", auditTime="
            + this.auditTime
            + ", auditStatus="
            + this.auditStatus
            + ", lastEditorUserId="
            + this.lastEditorUserId
            + ", remark="
            + this.remark
            + ", accessoryId="
            + this.accessoryId
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachments="
            + this.attachments
            + ")";
      }
   }
}
