package com.hzchum.scim.contract.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@ApiModel("制品回收-付款")
public class ContractRecyclePaymentDTO {
   @ApiModelProperty(name = "id", value = "主键id")
   private Long id;
   @ApiModelProperty("项目id")
   private ProjectInfo project;
   @ApiModelProperty("付款单位id")
   private Long paymentUnitId;
   @ApiModelProperty("付款单位")
   private String paymentUnit;
   @ApiModelProperty("(合同)收款单位id(合同供应商id)")
   private Long receivingUnitId;
   @ApiModelProperty("(合同)收款单位")
   private String receivingUnit;
   @ApiModelProperty("实际收款单位id")
   private Long actualReceivingUnitId;
   @ApiModelProperty("实际收款单位")
   private String actualReceivingUnit;
   @ApiModelProperty("申请金额")
   private BigDecimal applyAmount;
   @ApiModelProperty("让利金额")
   private BigDecimal deductionAmount;
   @ApiModelProperty("付款事由id")
   private String paymentReasonId;
   @ApiModelProperty("付款事由名称")
   private String paymentReasonName;
   @ApiModelProperty("付款日期")
   private LocalDate paymentDate;
   @ApiModelProperty("收款银行")
   private String receiveBank;
   @ApiModelProperty("收款账号")
   private String receiveBankAccount;
   @ApiModelProperty("申请人id")
   private Long applyUserId;
   @ApiModelProperty("申请人名称")
   private String applyUserName;
   @ApiModelProperty("附件id字符串")
   private String attachmentIds;
   @ApiModelProperty("附件列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("实付金额")
   private BigDecimal actuallyPaymentAmount;
   @ApiModelProperty("付款方式 1对公转账 2对私转账 4承兑汇票 8转账支票")
   private Integer paymentMethod;
   @ApiModelProperty("付款银行")
   private String paymentBank;
   @ApiModelProperty("付款账号")
   private String paymentBankAccount;
   @ApiModelProperty("审核人id")
   private Long auditUserId;
   @ApiModelProperty("审核人名字")
   private String auditUserName;
   @ApiModelProperty("审核时间")
   private LocalDateTime auditTime;
   @ApiModelProperty("审核状态 1未审核(审核中、待审核) 2审核通过 4驳回")
   private Integer auditStatus;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("物流订单或发运id列表")
   private Set<Long> logisticsCargoIds;

   public static ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder builder() {
      return new ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder();
   }

   public ContractRecyclePaymentDTO() {
   }

   public ContractRecyclePaymentDTO(
      final Long id,
      final ProjectInfo project,
      final Long paymentUnitId,
      final String paymentUnit,
      final Long receivingUnitId,
      final String receivingUnit,
      final Long actualReceivingUnitId,
      final String actualReceivingUnit,
      final BigDecimal applyAmount,
      final BigDecimal deductionAmount,
      final String paymentReasonId,
      final String paymentReasonName,
      final LocalDate paymentDate,
      final String receiveBank,
      final String receiveBankAccount,
      final Long applyUserId,
      final String applyUserName,
      final String attachmentIds,
      final List<AttachmentDTO> attachments,
      final String remark,
      final BigDecimal actuallyPaymentAmount,
      final Integer paymentMethod,
      final String paymentBank,
      final String paymentBankAccount,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime,
      final Integer auditStatus,
      final LocalDateTime createTime,
      final Set<Long> logisticsCargoIds
   ) {
      this.id = id;
      this.project = project;
      this.paymentUnitId = paymentUnitId;
      this.paymentUnit = paymentUnit;
      this.receivingUnitId = receivingUnitId;
      this.receivingUnit = receivingUnit;
      this.actualReceivingUnitId = actualReceivingUnitId;
      this.actualReceivingUnit = actualReceivingUnit;
      this.applyAmount = applyAmount;
      this.deductionAmount = deductionAmount;
      this.paymentReasonId = paymentReasonId;
      this.paymentReasonName = paymentReasonName;
      this.paymentDate = paymentDate;
      this.receiveBank = receiveBank;
      this.receiveBankAccount = receiveBankAccount;
      this.applyUserId = applyUserId;
      this.applyUserName = applyUserName;
      this.attachmentIds = attachmentIds;
      this.attachments = attachments;
      this.remark = remark;
      this.actuallyPaymentAmount = actuallyPaymentAmount;
      this.paymentMethod = paymentMethod;
      this.paymentBank = paymentBank;
      this.paymentBankAccount = paymentBankAccount;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.auditStatus = auditStatus;
      this.createTime = createTime;
      this.logisticsCargoIds = logisticsCargoIds;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getPaymentUnitId() {
      return this.paymentUnitId;
   }

   public String getPaymentUnit() {
      return this.paymentUnit;
   }

   public Long getReceivingUnitId() {
      return this.receivingUnitId;
   }

   public String getReceivingUnit() {
      return this.receivingUnit;
   }

   public Long getActualReceivingUnitId() {
      return this.actualReceivingUnitId;
   }

   public String getActualReceivingUnit() {
      return this.actualReceivingUnit;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public BigDecimal getDeductionAmount() {
      return this.deductionAmount;
   }

   public String getPaymentReasonId() {
      return this.paymentReasonId;
   }

   public String getPaymentReasonName() {
      return this.paymentReasonName;
   }

   public LocalDate getPaymentDate() {
      return this.paymentDate;
   }

   public String getReceiveBank() {
      return this.receiveBank;
   }

   public String getReceiveBankAccount() {
      return this.receiveBankAccount;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getActuallyPaymentAmount() {
      return this.actuallyPaymentAmount;
   }

   public Integer getPaymentMethod() {
      return this.paymentMethod;
   }

   public String getPaymentBank() {
      return this.paymentBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Set<Long> getLogisticsCargoIds() {
      return this.logisticsCargoIds;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setPaymentUnitId(final Long paymentUnitId) {
      this.paymentUnitId = paymentUnitId;
   }

   public void setPaymentUnit(final String paymentUnit) {
      this.paymentUnit = paymentUnit;
   }

   public void setReceivingUnitId(final Long receivingUnitId) {
      this.receivingUnitId = receivingUnitId;
   }

   public void setReceivingUnit(final String receivingUnit) {
      this.receivingUnit = receivingUnit;
   }

   public void setActualReceivingUnitId(final Long actualReceivingUnitId) {
      this.actualReceivingUnitId = actualReceivingUnitId;
   }

   public void setActualReceivingUnit(final String actualReceivingUnit) {
      this.actualReceivingUnit = actualReceivingUnit;
   }

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
   }

   public void setDeductionAmount(final BigDecimal deductionAmount) {
      this.deductionAmount = deductionAmount;
   }

   public void setPaymentReasonId(final String paymentReasonId) {
      this.paymentReasonId = paymentReasonId;
   }

   public void setPaymentReasonName(final String paymentReasonName) {
      this.paymentReasonName = paymentReasonName;
   }

   public void setPaymentDate(final LocalDate paymentDate) {
      this.paymentDate = paymentDate;
   }

   public void setReceiveBank(final String receiveBank) {
      this.receiveBank = receiveBank;
   }

   public void setReceiveBankAccount(final String receiveBankAccount) {
      this.receiveBankAccount = receiveBankAccount;
   }

   public void setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
   }

   public void setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setActuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
      this.actuallyPaymentAmount = actuallyPaymentAmount;
   }

   public void setPaymentMethod(final Integer paymentMethod) {
      this.paymentMethod = paymentMethod;
   }

   public void setPaymentBank(final String paymentBank) {
      this.paymentBank = paymentBank;
   }

   public void setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
   }

   public void setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setLogisticsCargoIds(final Set<Long> logisticsCargoIds) {
      this.logisticsCargoIds = logisticsCargoIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractRecyclePaymentDTO)) {
         return false;
      }

      ContractRecyclePaymentDTO other = (ContractRecyclePaymentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paymentUnitId = this.getPaymentUnitId();
         Object other$paymentUnitId = other.getPaymentUnitId();
         if (this$paymentUnitId == null ? other$paymentUnitId == null : this$paymentUnitId.equals(other$paymentUnitId)) {
            Object this$receivingUnitId = this.getReceivingUnitId();
            Object other$receivingUnitId = other.getReceivingUnitId();
            if (this$receivingUnitId == null ? other$receivingUnitId == null : this$receivingUnitId.equals(other$receivingUnitId)) {
               Object this$actualReceivingUnitId = this.getActualReceivingUnitId();
               Object other$actualReceivingUnitId = other.getActualReceivingUnitId();
               if (this$actualReceivingUnitId == null ? other$actualReceivingUnitId == null : this$actualReceivingUnitId.equals(other$actualReceivingUnitId)) {
                  Object this$applyUserId = this.getApplyUserId();
                  Object other$applyUserId = other.getApplyUserId();
                  if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
                     Object this$paymentMethod = this.getPaymentMethod();
                     Object other$paymentMethod = other.getPaymentMethod();
                     if (this$paymentMethod == null ? other$paymentMethod == null : this$paymentMethod.equals(other$paymentMethod)) {
                        Object this$auditUserId = this.getAuditUserId();
                        Object other$auditUserId = other.getAuditUserId();
                        if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                           Object this$auditStatus = this.getAuditStatus();
                           Object other$auditStatus = other.getAuditStatus();
                           if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                              Object this$project = this.getProject();
                              Object other$project = other.getProject();
                              if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                 Object this$paymentUnit = this.getPaymentUnit();
                                 Object other$paymentUnit = other.getPaymentUnit();
                                 if (this$paymentUnit == null ? other$paymentUnit == null : this$paymentUnit.equals(other$paymentUnit)) {
                                    Object this$receivingUnit = this.getReceivingUnit();
                                    Object other$receivingUnit = other.getReceivingUnit();
                                    if (this$receivingUnit == null ? other$receivingUnit == null : this$receivingUnit.equals(other$receivingUnit)) {
                                       Object this$actualReceivingUnit = this.getActualReceivingUnit();
                                       Object other$actualReceivingUnit = other.getActualReceivingUnit();
                                       if (this$actualReceivingUnit == null
                                          ? other$actualReceivingUnit == null
                                          : this$actualReceivingUnit.equals(other$actualReceivingUnit)) {
                                          Object this$applyAmount = this.getApplyAmount();
                                          Object other$applyAmount = other.getApplyAmount();
                                          if (this$applyAmount == null ? other$applyAmount == null : this$applyAmount.equals(other$applyAmount)) {
                                             Object this$deductionAmount = this.getDeductionAmount();
                                             Object other$deductionAmount = other.getDeductionAmount();
                                             if (this$deductionAmount == null
                                                ? other$deductionAmount == null
                                                : this$deductionAmount.equals(other$deductionAmount)) {
                                                Object this$paymentReasonId = this.getPaymentReasonId();
                                                Object other$paymentReasonId = other.getPaymentReasonId();
                                                if (this$paymentReasonId == null
                                                   ? other$paymentReasonId == null
                                                   : this$paymentReasonId.equals(other$paymentReasonId)) {
                                                   Object this$paymentReasonName = this.getPaymentReasonName();
                                                   Object other$paymentReasonName = other.getPaymentReasonName();
                                                   if (this$paymentReasonName == null
                                                      ? other$paymentReasonName == null
                                                      : this$paymentReasonName.equals(other$paymentReasonName)) {
                                                      Object this$paymentDate = this.getPaymentDate();
                                                      Object other$paymentDate = other.getPaymentDate();
                                                      if (this$paymentDate == null ? other$paymentDate == null : this$paymentDate.equals(other$paymentDate)) {
                                                         Object this$receiveBank = this.getReceiveBank();
                                                         Object other$receiveBank = other.getReceiveBank();
                                                         if (this$receiveBank == null ? other$receiveBank == null : this$receiveBank.equals(other$receiveBank)) {
                                                            Object this$receiveBankAccount = this.getReceiveBankAccount();
                                                            Object other$receiveBankAccount = other.getReceiveBankAccount();
                                                            if (this$receiveBankAccount == null
                                                               ? other$receiveBankAccount == null
                                                               : this$receiveBankAccount.equals(other$receiveBankAccount)) {
                                                               Object this$applyUserName = this.getApplyUserName();
                                                               Object other$applyUserName = other.getApplyUserName();
                                                               if (this$applyUserName == null
                                                                  ? other$applyUserName == null
                                                                  : this$applyUserName.equals(other$applyUserName)) {
                                                                  Object this$attachmentIds = this.getAttachmentIds();
                                                                  Object other$attachmentIds = other.getAttachmentIds();
                                                                  if (this$attachmentIds == null
                                                                     ? other$attachmentIds == null
                                                                     : this$attachmentIds.equals(other$attachmentIds)) {
                                                                     Object this$attachments = this.getAttachments();
                                                                     Object other$attachments = other.getAttachments();
                                                                     if (this$attachments == null
                                                                        ? other$attachments == null
                                                                        : this$attachments.equals(other$attachments)) {
                                                                        Object this$remark = this.getRemark();
                                                                        Object other$remark = other.getRemark();
                                                                        if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                           Object this$actuallyPaymentAmount = this.getActuallyPaymentAmount();
                                                                           Object other$actuallyPaymentAmount = other.getActuallyPaymentAmount();
                                                                           if (this$actuallyPaymentAmount == null
                                                                              ? other$actuallyPaymentAmount == null
                                                                              : this$actuallyPaymentAmount.equals(other$actuallyPaymentAmount)) {
                                                                              Object this$paymentBank = this.getPaymentBank();
                                                                              Object other$paymentBank = other.getPaymentBank();
                                                                              if (this$paymentBank == null
                                                                                 ? other$paymentBank == null
                                                                                 : this$paymentBank.equals(other$paymentBank)) {
                                                                                 Object this$paymentBankAccount = this.getPaymentBankAccount();
                                                                                 Object other$paymentBankAccount = other.getPaymentBankAccount();
                                                                                 if (this$paymentBankAccount == null
                                                                                    ? other$paymentBankAccount == null
                                                                                    : this$paymentBankAccount.equals(other$paymentBankAccount)) {
                                                                                    Object this$auditUserName = this.getAuditUserName();
                                                                                    Object other$auditUserName = other.getAuditUserName();
                                                                                    if (this$auditUserName == null
                                                                                       ? other$auditUserName == null
                                                                                       : this$auditUserName.equals(other$auditUserName)) {
                                                                                       Object this$auditTime = this.getAuditTime();
                                                                                       Object other$auditTime = other.getAuditTime();
                                                                                       if (this$auditTime == null
                                                                                          ? other$auditTime == null
                                                                                          : this$auditTime.equals(other$auditTime)) {
                                                                                          Object this$createTime = this.getCreateTime();
                                                                                          Object other$createTime = other.getCreateTime();
                                                                                          if (this$createTime == null
                                                                                             ? other$createTime == null
                                                                                             : this$createTime.equals(other$createTime)) {
                                                                                             Object this$logisticsCargoIds = this.getLogisticsCargoIds();
                                                                                             Object other$logisticsCargoIds = other.getLogisticsCargoIds();
                                                                                             return this$logisticsCargoIds == null
                                                                                                ? other$logisticsCargoIds == null
                                                                                                : this$logisticsCargoIds.equals(other$logisticsCargoIds);
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
      return other instanceof ContractRecyclePaymentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paymentUnitId = this.getPaymentUnitId();
      result = result * 59 + ($paymentUnitId == null ? 43 : $paymentUnitId.hashCode());
      Object $receivingUnitId = this.getReceivingUnitId();
      result = result * 59 + ($receivingUnitId == null ? 43 : $receivingUnitId.hashCode());
      Object $actualReceivingUnitId = this.getActualReceivingUnitId();
      result = result * 59 + ($actualReceivingUnitId == null ? 43 : $actualReceivingUnitId.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $paymentMethod = this.getPaymentMethod();
      result = result * 59 + ($paymentMethod == null ? 43 : $paymentMethod.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $paymentUnit = this.getPaymentUnit();
      result = result * 59 + ($paymentUnit == null ? 43 : $paymentUnit.hashCode());
      Object $receivingUnit = this.getReceivingUnit();
      result = result * 59 + ($receivingUnit == null ? 43 : $receivingUnit.hashCode());
      Object $actualReceivingUnit = this.getActualReceivingUnit();
      result = result * 59 + ($actualReceivingUnit == null ? 43 : $actualReceivingUnit.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $deductionAmount = this.getDeductionAmount();
      result = result * 59 + ($deductionAmount == null ? 43 : $deductionAmount.hashCode());
      Object $paymentReasonId = this.getPaymentReasonId();
      result = result * 59 + ($paymentReasonId == null ? 43 : $paymentReasonId.hashCode());
      Object $paymentReasonName = this.getPaymentReasonName();
      result = result * 59 + ($paymentReasonName == null ? 43 : $paymentReasonName.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $receiveBank = this.getReceiveBank();
      result = result * 59 + ($receiveBank == null ? 43 : $receiveBank.hashCode());
      Object $receiveBankAccount = this.getReceiveBankAccount();
      result = result * 59 + ($receiveBankAccount == null ? 43 : $receiveBankAccount.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $actuallyPaymentAmount = this.getActuallyPaymentAmount();
      result = result * 59 + ($actuallyPaymentAmount == null ? 43 : $actuallyPaymentAmount.hashCode());
      Object $paymentBank = this.getPaymentBank();
      result = result * 59 + ($paymentBank == null ? 43 : $paymentBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $logisticsCargoIds = this.getLogisticsCargoIds();
      return result * 59 + ($logisticsCargoIds == null ? 43 : $logisticsCargoIds.hashCode());
   }

   @Override
   public String toString() {
      return "ContractRecyclePaymentDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", paymentUnitId="
         + this.getPaymentUnitId()
         + ", paymentUnit="
         + this.getPaymentUnit()
         + ", receivingUnitId="
         + this.getReceivingUnitId()
         + ", receivingUnit="
         + this.getReceivingUnit()
         + ", actualReceivingUnitId="
         + this.getActualReceivingUnitId()
         + ", actualReceivingUnit="
         + this.getActualReceivingUnit()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", deductionAmount="
         + this.getDeductionAmount()
         + ", paymentReasonId="
         + this.getPaymentReasonId()
         + ", paymentReasonName="
         + this.getPaymentReasonName()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", receiveBank="
         + this.getReceiveBank()
         + ", receiveBankAccount="
         + this.getReceiveBankAccount()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachments="
         + this.getAttachments()
         + ", remark="
         + this.getRemark()
         + ", actuallyPaymentAmount="
         + this.getActuallyPaymentAmount()
         + ", paymentMethod="
         + this.getPaymentMethod()
         + ", paymentBank="
         + this.getPaymentBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", createTime="
         + this.getCreateTime()
         + ", logisticsCargoIds="
         + this.getLogisticsCargoIds()
         + ")";
   }

   public static class ContractRecyclePaymentDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private Long paymentUnitId;
      private String paymentUnit;
      private Long receivingUnitId;
      private String receivingUnit;
      private Long actualReceivingUnitId;
      private String actualReceivingUnit;
      private BigDecimal applyAmount;
      private BigDecimal deductionAmount;
      private String paymentReasonId;
      private String paymentReasonName;
      private LocalDate paymentDate;
      private String receiveBank;
      private String receiveBankAccount;
      private Long applyUserId;
      private String applyUserName;
      private String attachmentIds;
      private List<AttachmentDTO> attachments;
      private String remark;
      private BigDecimal actuallyPaymentAmount;
      private Integer paymentMethod;
      private String paymentBank;
      private String paymentBankAccount;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;
      private Integer auditStatus;
      private LocalDateTime createTime;
      private Set<Long> logisticsCargoIds;

      ContractRecyclePaymentDTOBuilder() {
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder paymentUnitId(final Long paymentUnitId) {
         this.paymentUnitId = paymentUnitId;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder paymentUnit(final String paymentUnit) {
         this.paymentUnit = paymentUnit;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder receivingUnitId(final Long receivingUnitId) {
         this.receivingUnitId = receivingUnitId;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder receivingUnit(final String receivingUnit) {
         this.receivingUnit = receivingUnit;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder actualReceivingUnitId(final Long actualReceivingUnitId) {
         this.actualReceivingUnitId = actualReceivingUnitId;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder actualReceivingUnit(final String actualReceivingUnit) {
         this.actualReceivingUnit = actualReceivingUnit;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder deductionAmount(final BigDecimal deductionAmount) {
         this.deductionAmount = deductionAmount;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder paymentReasonId(final String paymentReasonId) {
         this.paymentReasonId = paymentReasonId;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder paymentReasonName(final String paymentReasonName) {
         this.paymentReasonName = paymentReasonName;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder paymentDate(final LocalDate paymentDate) {
         this.paymentDate = paymentDate;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder receiveBank(final String receiveBank) {
         this.receiveBank = receiveBank;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder receiveBankAccount(final String receiveBankAccount) {
         this.receiveBankAccount = receiveBankAccount;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder applyUserName(final String applyUserName) {
         this.applyUserName = applyUserName;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder actuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
         this.actuallyPaymentAmount = actuallyPaymentAmount;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder paymentMethod(final Integer paymentMethod) {
         this.paymentMethod = paymentMethod;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder paymentBank(final String paymentBank) {
         this.paymentBank = paymentBank;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder logisticsCargoIds(final Set<Long> logisticsCargoIds) {
         this.logisticsCargoIds = logisticsCargoIds;
         return this;
      }

      public ContractRecyclePaymentDTO build() {
         return new ContractRecyclePaymentDTO(
            this.id,
            this.project,
            this.paymentUnitId,
            this.paymentUnit,
            this.receivingUnitId,
            this.receivingUnit,
            this.actualReceivingUnitId,
            this.actualReceivingUnit,
            this.applyAmount,
            this.deductionAmount,
            this.paymentReasonId,
            this.paymentReasonName,
            this.paymentDate,
            this.receiveBank,
            this.receiveBankAccount,
            this.applyUserId,
            this.applyUserName,
            this.attachmentIds,
            this.attachments,
            this.remark,
            this.actuallyPaymentAmount,
            this.paymentMethod,
            this.paymentBank,
            this.paymentBankAccount,
            this.auditUserId,
            this.auditUserName,
            this.auditTime,
            this.auditStatus,
            this.createTime,
            this.logisticsCargoIds
         );
      }

      @Override
      public String toString() {
         return "ContractRecyclePaymentDTO.ContractRecyclePaymentDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", paymentUnitId="
            + this.paymentUnitId
            + ", paymentUnit="
            + this.paymentUnit
            + ", receivingUnitId="
            + this.receivingUnitId
            + ", receivingUnit="
            + this.receivingUnit
            + ", actualReceivingUnitId="
            + this.actualReceivingUnitId
            + ", actualReceivingUnit="
            + this.actualReceivingUnit
            + ", applyAmount="
            + this.applyAmount
            + ", deductionAmount="
            + this.deductionAmount
            + ", paymentReasonId="
            + this.paymentReasonId
            + ", paymentReasonName="
            + this.paymentReasonName
            + ", paymentDate="
            + this.paymentDate
            + ", receiveBank="
            + this.receiveBank
            + ", receiveBankAccount="
            + this.receiveBankAccount
            + ", applyUserId="
            + this.applyUserId
            + ", applyUserName="
            + this.applyUserName
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachments="
            + this.attachments
            + ", remark="
            + this.remark
            + ", actuallyPaymentAmount="
            + this.actuallyPaymentAmount
            + ", paymentMethod="
            + this.paymentMethod
            + ", paymentBank="
            + this.paymentBank
            + ", paymentBankAccount="
            + this.paymentBankAccount
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ", auditStatus="
            + this.auditStatus
            + ", createTime="
            + this.createTime
            + ", logisticsCargoIds="
            + this.logisticsCargoIds
            + ")";
      }
   }
}
