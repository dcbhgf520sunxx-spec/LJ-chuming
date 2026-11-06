package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "ContractCollection对象", description = "收款表")
public class ContractCollectionAuditDTO extends ContractAuditBaseDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
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
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty("附件列表")
   private List<AttachmentDTO> attachmentList;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractCollectionAuditDTO)) {
         return false;
      }

      ContractCollectionAuditDTO other = (ContractCollectionAuditDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
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
                                       if (this$collectionDate == null ? other$collectionDate == null : this$collectionDate.equals(other$collectionDate)) {
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
                                                                  if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)
                                                                     )
                                                                   {
                                                                     Object this$remark = this.getRemark();
                                                                     Object other$remark = other.getRemark();
                                                                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                        Object this$attachmentList = this.getAttachmentList();
                                                                        Object other$attachmentList = other.getAttachmentList();
                                                                        return this$attachmentList == null
                                                                           ? other$attachmentList == null
                                                                           : this$attachmentList.equals(other$attachmentList);
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
      return other instanceof ContractCollectionAuditDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
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
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
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
      Object $attachmentList = this.getAttachmentList();
      return result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
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

   public String getRemark() {
      return this.remark;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
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

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
   }

   @Override
   public String toString() {
      return "ContractCollectionAuditDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
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
         + ", remark="
         + this.getRemark()
         + ", attachmentList="
         + this.getAttachmentList()
         + ")";
   }
}
