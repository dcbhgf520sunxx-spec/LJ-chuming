package com.hzchum.scim.contract.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("收款列表 响应对象")
public class ContractCollectionDTO {
   @ApiModelProperty(name = "id", value = "主键id")
   private Long id;
   @ApiModelProperty(name = "type", value = "收款类型 1项目收款 2废料出售收款")
   private Integer type;
   @ApiModelProperty(name = "project", value = "项目信息")
   private ProjectInfo project;
   @ApiModelProperty(name = "contractWaste", value = "废料合同信息")
   private ContractWasteInfo contractWaste;
   @ApiModelProperty(name = "businessType", value = "项目业务类型")
   private Integer businessType;
   @ApiModelProperty(name = "contract_amount", notes = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "haveCollectionAmount", value = "已收款额")
   private BigDecimal haveCollectionAmount;
   @ApiModelProperty(name = "collectionUnit", value = "收款单位")
   private String collectionUnit;
   @ApiModelProperty(name = "collectionUnitId", value = "收款单位id")
   private Long collectionUnitId;
   @ApiModelProperty(name = "collectionDepositBank", value = "收款开户行")
   private String collectionDepositBank;
   @ApiModelProperty(name = "collectionBankAccountId", value = "收款开户行账号id")
   private Long collectionBankAccountId;
   @ApiModelProperty(name = "collectionBankAccount", value = "收款开户行账号")
   private String collectionBankAccount;
   @ApiModelProperty(name = "collectionDate", value = "收款日期")
   private LocalDate collectionDate;
   @ApiModelProperty(name = "collectionMode", value = "收款方式")
   private Integer collectionMode;
   @ApiModelProperty(name = "acceptanceDraftJson", value = "承兑汇票json")
   private String acceptanceDraftJson;
   @ApiModelProperty(name = "acceptanceDraftDTOList", value = "承兑汇票列表")
   private List<AcceptanceDraftDTO> acceptanceDraftDTOList;
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
   @ApiModelProperty(name = "lastEditorUserName", value = "最后编辑人名字")
   private Long lastEditorUserName;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "accessoryName", value = "附件名称")
   private Long accessoryId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "customer_unit", notes = "客户单位名称")
   private String customerUnit;

   public static ContractCollectionDTO.ContractCollectionDTOBuilder builder() {
      return new ContractCollectionDTO.ContractCollectionDTOBuilder();
   }

   public ContractCollectionDTO() {
   }

   public ContractCollectionDTO(
      final Long id,
      final Integer type,
      final ProjectInfo project,
      final ContractWasteInfo contractWaste,
      final Integer businessType,
      final BigDecimal contractAmount,
      final BigDecimal haveCollectionAmount,
      final String collectionUnit,
      final Long collectionUnitId,
      final String collectionDepositBank,
      final Long collectionBankAccountId,
      final String collectionBankAccount,
      final LocalDate collectionDate,
      final Integer collectionMode,
      final String acceptanceDraftJson,
      final List<AcceptanceDraftDTO> acceptanceDraftDTOList,
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
      final Long lastEditorUserName,
      final String remark,
      final LocalDateTime createTime,
      final Long accessoryId,
      final String customerUnit
   ) {
      this.id = id;
      this.type = type;
      this.project = project;
      this.contractWaste = contractWaste;
      this.businessType = businessType;
      this.contractAmount = contractAmount;
      this.haveCollectionAmount = haveCollectionAmount;
      this.collectionUnit = collectionUnit;
      this.collectionUnitId = collectionUnitId;
      this.collectionDepositBank = collectionDepositBank;
      this.collectionBankAccountId = collectionBankAccountId;
      this.collectionBankAccount = collectionBankAccount;
      this.collectionDate = collectionDate;
      this.collectionMode = collectionMode;
      this.acceptanceDraftJson = acceptanceDraftJson;
      this.acceptanceDraftDTOList = acceptanceDraftDTOList;
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
      this.lastEditorUserName = lastEditorUserName;
      this.remark = remark;
      this.createTime = createTime;
      this.accessoryId = accessoryId;
      this.customerUnit = customerUnit;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public ContractWasteInfo getContractWaste() {
      return this.contractWaste;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getHaveCollectionAmount() {
      return this.haveCollectionAmount;
   }

   public String getCollectionUnit() {
      return this.collectionUnit;
   }

   public Long getCollectionUnitId() {
      return this.collectionUnitId;
   }

   public String getCollectionDepositBank() {
      return this.collectionDepositBank;
   }

   public Long getCollectionBankAccountId() {
      return this.collectionBankAccountId;
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

   public Long getLastEditorUserName() {
      return this.lastEditorUserName;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Long getAccessoryId() {
      return this.accessoryId;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setContractWaste(final ContractWasteInfo contractWaste) {
      this.contractWaste = contractWaste;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setHaveCollectionAmount(final BigDecimal haveCollectionAmount) {
      this.haveCollectionAmount = haveCollectionAmount;
   }

   public void setCollectionUnit(final String collectionUnit) {
      this.collectionUnit = collectionUnit;
   }

   public void setCollectionUnitId(final Long collectionUnitId) {
      this.collectionUnitId = collectionUnitId;
   }

   public void setCollectionDepositBank(final String collectionDepositBank) {
      this.collectionDepositBank = collectionDepositBank;
   }

   public void setCollectionBankAccountId(final Long collectionBankAccountId) {
      this.collectionBankAccountId = collectionBankAccountId;
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

   public void setLastEditorUserName(final Long lastEditorUserName) {
      this.lastEditorUserName = lastEditorUserName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setAccessoryId(final Long accessoryId) {
      this.accessoryId = accessoryId;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractCollectionDTO)) {
         return false;
      }

      ContractCollectionDTO other = (ContractCollectionDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$businessType = this.getBusinessType();
            Object other$businessType = other.getBusinessType();
            if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
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
                                    Object this$lastEditorUserName = this.getLastEditorUserName();
                                    Object other$lastEditorUserName = other.getLastEditorUserName();
                                    if (this$lastEditorUserName == null
                                       ? other$lastEditorUserName == null
                                       : this$lastEditorUserName.equals(other$lastEditorUserName)) {
                                       Object this$accessoryId = this.getAccessoryId();
                                       Object other$accessoryId = other.getAccessoryId();
                                       if (this$accessoryId == null ? other$accessoryId == null : this$accessoryId.equals(other$accessoryId)) {
                                          Object this$project = this.getProject();
                                          Object other$project = other.getProject();
                                          if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                             Object this$contractWaste = this.getContractWaste();
                                             Object other$contractWaste = other.getContractWaste();
                                             if (this$contractWaste == null ? other$contractWaste == null : this$contractWaste.equals(other$contractWaste)) {
                                                Object this$contractAmount = this.getContractAmount();
                                                Object other$contractAmount = other.getContractAmount();
                                                if (this$contractAmount == null
                                                   ? other$contractAmount == null
                                                   : this$contractAmount.equals(other$contractAmount)) {
                                                   Object this$haveCollectionAmount = this.getHaveCollectionAmount();
                                                   Object other$haveCollectionAmount = other.getHaveCollectionAmount();
                                                   if (this$haveCollectionAmount == null
                                                      ? other$haveCollectionAmount == null
                                                      : this$haveCollectionAmount.equals(other$haveCollectionAmount)) {
                                                      Object this$collectionUnit = this.getCollectionUnit();
                                                      Object other$collectionUnit = other.getCollectionUnit();
                                                      if (this$collectionUnit == null
                                                         ? other$collectionUnit == null
                                                         : this$collectionUnit.equals(other$collectionUnit)) {
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
                                                                                                if (this$remark == null
                                                                                                   ? other$remark == null
                                                                                                   : this$remark.equals(other$remark)) {
                                                                                                   Object this$createTime = this.getCreateTime();
                                                                                                   Object other$createTime = other.getCreateTime();
                                                                                                   if (this$createTime == null
                                                                                                      ? other$createTime == null
                                                                                                      : this$createTime.equals(other$createTime)) {
                                                                                                      Object this$customerUnit = this.getCustomerUnit();
                                                                                                      Object other$customerUnit = other.getCustomerUnit();
                                                                                                      return this$customerUnit == null
                                                                                                         ? other$customerUnit == null
                                                                                                         : this$customerUnit.equals(other$customerUnit);
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
      return other instanceof ContractCollectionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
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
      Object $lastEditorUserName = this.getLastEditorUserName();
      result = result * 59 + ($lastEditorUserName == null ? 43 : $lastEditorUserName.hashCode());
      Object $accessoryId = this.getAccessoryId();
      result = result * 59 + ($accessoryId == null ? 43 : $accessoryId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $contractWaste = this.getContractWaste();
      result = result * 59 + ($contractWaste == null ? 43 : $contractWaste.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $haveCollectionAmount = this.getHaveCollectionAmount();
      result = result * 59 + ($haveCollectionAmount == null ? 43 : $haveCollectionAmount.hashCode());
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
      Object $writtenByName = this.getWrittenByName();
      result = result * 59 + ($writtenByName == null ? 43 : $writtenByName.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      return result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
   }

   @Override
   public String toString() {
      return "ContractCollectionDTO(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", project="
         + this.getProject()
         + ", contractWaste="
         + this.getContractWaste()
         + ", businessType="
         + this.getBusinessType()
         + ", contractAmount="
         + this.getContractAmount()
         + ", haveCollectionAmount="
         + this.getHaveCollectionAmount()
         + ", collectionUnit="
         + this.getCollectionUnit()
         + ", collectionUnitId="
         + this.getCollectionUnitId()
         + ", collectionDepositBank="
         + this.getCollectionDepositBank()
         + ", collectionBankAccountId="
         + this.getCollectionBankAccountId()
         + ", collectionBankAccount="
         + this.getCollectionBankAccount()
         + ", collectionDate="
         + this.getCollectionDate()
         + ", collectionMode="
         + this.getCollectionMode()
         + ", acceptanceDraftJson="
         + this.getAcceptanceDraftJson()
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
         + ", lastEditorUserName="
         + this.getLastEditorUserName()
         + ", remark="
         + this.getRemark()
         + ", createTime="
         + this.getCreateTime()
         + ", accessoryId="
         + this.getAccessoryId()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ")";
   }

   public static class ContractCollectionDTOBuilder {
      private Long id;
      private Integer type;
      private ProjectInfo project;
      private ContractWasteInfo contractWaste;
      private Integer businessType;
      private BigDecimal contractAmount;
      private BigDecimal haveCollectionAmount;
      private String collectionUnit;
      private Long collectionUnitId;
      private String collectionDepositBank;
      private Long collectionBankAccountId;
      private String collectionBankAccount;
      private LocalDate collectionDate;
      private Integer collectionMode;
      private String acceptanceDraftJson;
      private List<AcceptanceDraftDTO> acceptanceDraftDTOList;
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
      private Long lastEditorUserName;
      private String remark;
      private LocalDateTime createTime;
      private Long accessoryId;
      private String customerUnit;

      ContractCollectionDTOBuilder() {
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder contractWaste(final ContractWasteInfo contractWaste) {
         this.contractWaste = contractWaste;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder haveCollectionAmount(final BigDecimal haveCollectionAmount) {
         this.haveCollectionAmount = haveCollectionAmount;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder collectionUnit(final String collectionUnit) {
         this.collectionUnit = collectionUnit;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder collectionUnitId(final Long collectionUnitId) {
         this.collectionUnitId = collectionUnitId;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder collectionDepositBank(final String collectionDepositBank) {
         this.collectionDepositBank = collectionDepositBank;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder collectionBankAccountId(final Long collectionBankAccountId) {
         this.collectionBankAccountId = collectionBankAccountId;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder collectionBankAccount(final String collectionBankAccount) {
         this.collectionBankAccount = collectionBankAccount;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder collectionDate(final LocalDate collectionDate) {
         this.collectionDate = collectionDate;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder collectionMode(final Integer collectionMode) {
         this.collectionMode = collectionMode;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder acceptanceDraftJson(final String acceptanceDraftJson) {
         this.acceptanceDraftJson = acceptanceDraftJson;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder acceptanceDraftDTOList(final List<AcceptanceDraftDTO> acceptanceDraftDTOList) {
         this.acceptanceDraftDTOList = acceptanceDraftDTOList;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder collectionReason(final String collectionReason) {
         this.collectionReason = collectionReason;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder paymentUnit(final String paymentUnit) {
         this.paymentUnit = paymentUnit;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder paymentDepositBank(final String paymentDepositBank) {
         this.paymentDepositBank = paymentDepositBank;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder writtenByName(final String writtenByName) {
         this.writtenByName = writtenByName;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder lastEditorUserId(final Long lastEditorUserId) {
         this.lastEditorUserId = lastEditorUserId;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder lastEditorUserName(final Long lastEditorUserName) {
         this.lastEditorUserName = lastEditorUserName;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder accessoryId(final Long accessoryId) {
         this.accessoryId = accessoryId;
         return this;
      }

      public ContractCollectionDTO.ContractCollectionDTOBuilder customerUnit(final String customerUnit) {
         this.customerUnit = customerUnit;
         return this;
      }

      public ContractCollectionDTO build() {
         return new ContractCollectionDTO(
            this.id,
            this.type,
            this.project,
            this.contractWaste,
            this.businessType,
            this.contractAmount,
            this.haveCollectionAmount,
            this.collectionUnit,
            this.collectionUnitId,
            this.collectionDepositBank,
            this.collectionBankAccountId,
            this.collectionBankAccount,
            this.collectionDate,
            this.collectionMode,
            this.acceptanceDraftJson,
            this.acceptanceDraftDTOList,
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
            this.lastEditorUserName,
            this.remark,
            this.createTime,
            this.accessoryId,
            this.customerUnit
         );
      }

      @Override
      public String toString() {
         return "ContractCollectionDTO.ContractCollectionDTOBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", project="
            + this.project
            + ", contractWaste="
            + this.contractWaste
            + ", businessType="
            + this.businessType
            + ", contractAmount="
            + this.contractAmount
            + ", haveCollectionAmount="
            + this.haveCollectionAmount
            + ", collectionUnit="
            + this.collectionUnit
            + ", collectionUnitId="
            + this.collectionUnitId
            + ", collectionDepositBank="
            + this.collectionDepositBank
            + ", collectionBankAccountId="
            + this.collectionBankAccountId
            + ", collectionBankAccount="
            + this.collectionBankAccount
            + ", collectionDate="
            + this.collectionDate
            + ", collectionMode="
            + this.collectionMode
            + ", acceptanceDraftJson="
            + this.acceptanceDraftJson
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
            + ", lastEditorUserName="
            + this.lastEditorUserName
            + ", remark="
            + this.remark
            + ", createTime="
            + this.createTime
            + ", accessoryId="
            + this.accessoryId
            + ", customerUnit="
            + this.customerUnit
            + ")";
      }
   }
}
