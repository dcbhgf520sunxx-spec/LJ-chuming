package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("审批管理")
public class ContractAuditLedgerDto {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("付款类型")
   private Integer paymentEnum;
   @ApiModelProperty(name = "filingDate", value = "申请日期", notes = "申请日期")
   private LocalDateTime filingDate;
   @ApiModelProperty(name = "oaNumber", value = "OA编号", notes = "OA编号")
   private String oaNumber;
   @ApiModelProperty(name = "projectType", value = "项目类型", notes = "项目类型")
   private Integer projectType;
   @ApiModelProperty(name = "contractSignBodyId", value = "签订主体id", notes = "签订主体id")
   private Long contractSignBodyId;
   @ApiModelProperty(name = "contractSignBodyName", value = "签订主体名称", notes = "签订主体名称")
   private String contractSignBodyName;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性", notes = "项目属性")
   private Integer projectAttribute;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性", notes = "项目属性")
   private String projectAttributeName;
   @ApiModelProperty(name = "scope_of_audit", value = "审核范围(合同审核1， 供应商审核 2 )", notes = "审核范围(合同审核1， 供应商审核 2 )")
   private Integer scopeOfAudit;
   @ApiModelProperty(name = "initiatorId", value = "发起人", notes = "发起人")
   private Long initiatorId;
   @ApiModelProperty(name = "initiatorName", value = "发起人", notes = "发起人")
   private String initiatorName;
   @ApiModelProperty(name = "contractId", value = "采购/分包合同id", notes = "采购/分包合同id")
   private Long contractId;
   @ApiModelProperty(name = "contractNumber", value = "采购/分包合同号", notes = "采购/分包合同号")
   private String contractNumber;
   @ApiModelProperty(name = "projectId", value = "所属项目", notes = "所属项目")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "所属项目", notes = "所属项目")
   private String projectName;
   @ApiModelProperty(name = "paymentId", value = "付款id", notes = "付款id")
   private Long paymentId;
   @ApiModelProperty(name = "auditType", value = "审批类型", notes = "审批类型")
   private Integer auditType;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理", notes = "项目经理")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerName", value = "项目经理名称", notes = "项目经理名称")
   private String projectManagerName;
   @ApiModelProperty(name = "supplierId", value = "供应商", notes = "供应商")
   private Long supplierId;
   @ApiModelProperty(name = "supplierId", value = "供应商名称", notes = "供应商名称")
   private String supplierName;
   @ApiModelProperty(name = "applyAmount", value = "申请金额", notes = "申请金额")
   private BigDecimal applyAmount;
   @ApiModelProperty(name = "paymentAmount", value = "实付金额", notes = "实付金额")
   private BigDecimal paymentAmount;
   @ApiModelProperty(name = "writtenById", value = "填报人", notes = "填报人")
   private Long writtenById;
   @ApiModelProperty(name = "writtenByName", value = "填报人", notes = "填报人")
   private String writtenByName;
   @ApiModelProperty(name = "submitDate", value = "填报日期", notes = "填报日期")
   private LocalDateTime submitDate;
   @ApiModelProperty(name = "auditStatusEnum", value = "审核状态 1:审核中2:审核通过3:驳回", notes = "审核状态 1:审核中2:审核通过4:驳回")
   private Integer auditStatusEnum;
   @ApiModelProperty(name = "actuallyPayAmount", value = "本次实付金额", notes = "本次实付金额")
   private BigDecimal actuallyPayAmount;
   @ApiModelProperty(name = "paymentType", value = "付款类型", notes = "付款类型")
   private Integer paymentType;
   @ApiModelProperty(name = "paymentDate", value = "付款日期", notes = "付款日期")
   private LocalDateTime paymentDate;
   @ApiModelProperty(name = "voucherNumber", value = "凭证号", notes = "凭证号")
   private String voucherNumber;
   @ApiModelProperty(name = "attachmentId", value = "附件id", notes = "附件id")
   private Long attachmentId;
   @ApiModelProperty(name = "attachments", value = "附件对象列表", notes = "附件对象列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "approveId", value = "审批模板id", notes = "审批模板id")
   private Long approveId;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty("类型")
   private Integer type;
   @ApiModelProperty("合同额")
   private BigDecimal contractAmount;

   public Long getId() {
      return this.id;
   }

   public Integer getPaymentEnum() {
      return this.paymentEnum;
   }

   public LocalDateTime getFilingDate() {
      return this.filingDate;
   }

   public String getOaNumber() {
      return this.oaNumber;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public String getContractSignBodyName() {
      return this.contractSignBodyName;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public String getProjectAttributeName() {
      return this.projectAttributeName;
   }

   public Integer getScopeOfAudit() {
      return this.scopeOfAudit;
   }

   public Long getInitiatorId() {
      return this.initiatorId;
   }

   public String getInitiatorName() {
      return this.initiatorName;
   }

   public Long getContractId() {
      return this.contractId;
   }

   public String getContractNumber() {
      return this.contractNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getPaymentId() {
      return this.paymentId;
   }

   public Integer getAuditType() {
      return this.auditType;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public Long getWrittenById() {
      return this.writtenById;
   }

   public String getWrittenByName() {
      return this.writtenByName;
   }

   public LocalDateTime getSubmitDate() {
      return this.submitDate;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public BigDecimal getActuallyPayAmount() {
      return this.actuallyPayAmount;
   }

   public Integer getPaymentType() {
      return this.paymentType;
   }

   public LocalDateTime getPaymentDate() {
      return this.paymentDate;
   }

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public Long getApproveId() {
      return this.approveId;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
   }

   public void setFilingDate(final LocalDateTime filingDate) {
      this.filingDate = filingDate;
   }

   public void setOaNumber(final String oaNumber) {
      this.oaNumber = oaNumber;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setContractSignBodyName(final String contractSignBodyName) {
      this.contractSignBodyName = contractSignBodyName;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setProjectAttributeName(final String projectAttributeName) {
      this.projectAttributeName = projectAttributeName;
   }

   public void setScopeOfAudit(final Integer scopeOfAudit) {
      this.scopeOfAudit = scopeOfAudit;
   }

   public void setInitiatorId(final Long initiatorId) {
      this.initiatorId = initiatorId;
   }

   public void setInitiatorName(final String initiatorName) {
      this.initiatorName = initiatorName;
   }

   public void setContractId(final Long contractId) {
      this.contractId = contractId;
   }

   public void setContractNumber(final String contractNumber) {
      this.contractNumber = contractNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setPaymentId(final Long paymentId) {
      this.paymentId = paymentId;
   }

   public void setAuditType(final Integer auditType) {
      this.auditType = auditType;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
   }

   public void setWrittenByName(final String writtenByName) {
      this.writtenByName = writtenByName;
   }

   public void setSubmitDate(final LocalDateTime submitDate) {
      this.submitDate = submitDate;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   public void setActuallyPayAmount(final BigDecimal actuallyPayAmount) {
      this.actuallyPayAmount = actuallyPayAmount;
   }

   public void setPaymentType(final Integer paymentType) {
      this.paymentType = paymentType;
   }

   public void setPaymentDate(final LocalDateTime paymentDate) {
      this.paymentDate = paymentDate;
   }

   public void setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
   }

   public void setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setApproveId(final Long approveId) {
      this.approveId = approveId;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractAuditLedgerDto)) {
         return false;
      }

      ContractAuditLedgerDto other = (ContractAuditLedgerDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paymentEnum = this.getPaymentEnum();
         Object other$paymentEnum = other.getPaymentEnum();
         if (this$paymentEnum == null ? other$paymentEnum == null : this$paymentEnum.equals(other$paymentEnum)) {
            Object this$projectType = this.getProjectType();
            Object other$projectType = other.getProjectType();
            if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
               Object this$contractSignBodyId = this.getContractSignBodyId();
               Object other$contractSignBodyId = other.getContractSignBodyId();
               if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
                  Object this$projectAttribute = this.getProjectAttribute();
                  Object other$projectAttribute = other.getProjectAttribute();
                  if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                     Object this$scopeOfAudit = this.getScopeOfAudit();
                     Object other$scopeOfAudit = other.getScopeOfAudit();
                     if (this$scopeOfAudit == null ? other$scopeOfAudit == null : this$scopeOfAudit.equals(other$scopeOfAudit)) {
                        Object this$initiatorId = this.getInitiatorId();
                        Object other$initiatorId = other.getInitiatorId();
                        if (this$initiatorId == null ? other$initiatorId == null : this$initiatorId.equals(other$initiatorId)) {
                           Object this$contractId = this.getContractId();
                           Object other$contractId = other.getContractId();
                           if (this$contractId == null ? other$contractId == null : this$contractId.equals(other$contractId)) {
                              Object this$projectId = this.getProjectId();
                              Object other$projectId = other.getProjectId();
                              if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                 Object this$paymentId = this.getPaymentId();
                                 Object other$paymentId = other.getPaymentId();
                                 if (this$paymentId == null ? other$paymentId == null : this$paymentId.equals(other$paymentId)) {
                                    Object this$auditType = this.getAuditType();
                                    Object other$auditType = other.getAuditType();
                                    if (this$auditType == null ? other$auditType == null : this$auditType.equals(other$auditType)) {
                                       Object this$projectManagerId = this.getProjectManagerId();
                                       Object other$projectManagerId = other.getProjectManagerId();
                                       if (this$projectManagerId == null
                                          ? other$projectManagerId == null
                                          : this$projectManagerId.equals(other$projectManagerId)) {
                                          Object this$supplierId = this.getSupplierId();
                                          Object other$supplierId = other.getSupplierId();
                                          if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                             Object this$writtenById = this.getWrittenById();
                                             Object other$writtenById = other.getWrittenById();
                                             if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                                                Object this$auditStatusEnum = this.getAuditStatusEnum();
                                                Object other$auditStatusEnum = other.getAuditStatusEnum();
                                                if (this$auditStatusEnum == null
                                                   ? other$auditStatusEnum == null
                                                   : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                                                   Object this$paymentType = this.getPaymentType();
                                                   Object other$paymentType = other.getPaymentType();
                                                   if (this$paymentType == null ? other$paymentType == null : this$paymentType.equals(other$paymentType)) {
                                                      Object this$attachmentId = this.getAttachmentId();
                                                      Object other$attachmentId = other.getAttachmentId();
                                                      if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)
                                                         )
                                                       {
                                                         Object this$approveId = this.getApproveId();
                                                         Object other$approveId = other.getApproveId();
                                                         if (this$approveId == null ? other$approveId == null : this$approveId.equals(other$approveId)) {
                                                            Object this$type = this.getType();
                                                            Object other$type = other.getType();
                                                            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                                               Object this$filingDate = this.getFilingDate();
                                                               Object other$filingDate = other.getFilingDate();
                                                               if (this$filingDate == null
                                                                  ? other$filingDate == null
                                                                  : this$filingDate.equals(other$filingDate)) {
                                                                  Object this$oaNumber = this.getOaNumber();
                                                                  Object other$oaNumber = other.getOaNumber();
                                                                  if (this$oaNumber == null ? other$oaNumber == null : this$oaNumber.equals(other$oaNumber)) {
                                                                     Object this$contractSignBodyName = this.getContractSignBodyName();
                                                                     Object other$contractSignBodyName = other.getContractSignBodyName();
                                                                     if (this$contractSignBodyName == null
                                                                        ? other$contractSignBodyName == null
                                                                        : this$contractSignBodyName.equals(other$contractSignBodyName)) {
                                                                        Object this$projectAttributeName = this.getProjectAttributeName();
                                                                        Object other$projectAttributeName = other.getProjectAttributeName();
                                                                        if (this$projectAttributeName == null
                                                                           ? other$projectAttributeName == null
                                                                           : this$projectAttributeName.equals(other$projectAttributeName)) {
                                                                           Object this$initiatorName = this.getInitiatorName();
                                                                           Object other$initiatorName = other.getInitiatorName();
                                                                           if (this$initiatorName == null
                                                                              ? other$initiatorName == null
                                                                              : this$initiatorName.equals(other$initiatorName)) {
                                                                              Object this$contractNumber = this.getContractNumber();
                                                                              Object other$contractNumber = other.getContractNumber();
                                                                              if (this$contractNumber == null
                                                                                 ? other$contractNumber == null
                                                                                 : this$contractNumber.equals(other$contractNumber)) {
                                                                                 Object this$projectName = this.getProjectName();
                                                                                 Object other$projectName = other.getProjectName();
                                                                                 if (this$projectName == null
                                                                                    ? other$projectName == null
                                                                                    : this$projectName.equals(other$projectName)) {
                                                                                    Object this$projectManagerName = this.getProjectManagerName();
                                                                                    Object other$projectManagerName = other.getProjectManagerName();
                                                                                    if (this$projectManagerName == null
                                                                                       ? other$projectManagerName == null
                                                                                       : this$projectManagerName.equals(other$projectManagerName)) {
                                                                                       Object this$supplierName = this.getSupplierName();
                                                                                       Object other$supplierName = other.getSupplierName();
                                                                                       if (this$supplierName == null
                                                                                          ? other$supplierName == null
                                                                                          : this$supplierName.equals(other$supplierName)) {
                                                                                          Object this$applyAmount = this.getApplyAmount();
                                                                                          Object other$applyAmount = other.getApplyAmount();
                                                                                          if (this$applyAmount == null
                                                                                             ? other$applyAmount == null
                                                                                             : this$applyAmount.equals(other$applyAmount)) {
                                                                                             Object this$paymentAmount = this.getPaymentAmount();
                                                                                             Object other$paymentAmount = other.getPaymentAmount();
                                                                                             if (this$paymentAmount == null
                                                                                                ? other$paymentAmount == null
                                                                                                : this$paymentAmount.equals(other$paymentAmount)) {
                                                                                                Object this$writtenByName = this.getWrittenByName();
                                                                                                Object other$writtenByName = other.getWrittenByName();
                                                                                                if (this$writtenByName == null
                                                                                                   ? other$writtenByName == null
                                                                                                   : this$writtenByName.equals(other$writtenByName)) {
                                                                                                   Object this$submitDate = this.getSubmitDate();
                                                                                                   Object other$submitDate = other.getSubmitDate();
                                                                                                   if (this$submitDate == null
                                                                                                      ? other$submitDate == null
                                                                                                      : this$submitDate.equals(other$submitDate)) {
                                                                                                      Object this$actuallyPayAmount = this.getActuallyPayAmount();
                                                                                                      Object other$actuallyPayAmount = other.getActuallyPayAmount();
                                                                                                      if (this$actuallyPayAmount == null
                                                                                                         ? other$actuallyPayAmount == null
                                                                                                         : this$actuallyPayAmount.equals(
                                                                                                            other$actuallyPayAmount
                                                                                                         )) {
                                                                                                         Object this$paymentDate = this.getPaymentDate();
                                                                                                         Object other$paymentDate = other.getPaymentDate();
                                                                                                         if (this$paymentDate == null
                                                                                                            ? other$paymentDate == null
                                                                                                            : this$paymentDate.equals(other$paymentDate)) {
                                                                                                            Object this$voucherNumber = this.getVoucherNumber();
                                                                                                            Object other$voucherNumber = other.getVoucherNumber();
                                                                                                            if (this$voucherNumber == null
                                                                                                               ? other$voucherNumber == null
                                                                                                               : this$voucherNumber.equals(other$voucherNumber)
                                                                                                               )
                                                                                                             {
                                                                                                               Object this$attachments = this.getAttachments();
                                                                                                               Object other$attachments = other.getAttachments();
                                                                                                               if (this$attachments == null
                                                                                                                  ? other$attachments == null
                                                                                                                  : this$attachments.equals(other$attachments)) {
                                                                                                                  Object this$createTime = this.getCreateTime();
                                                                                                                  Object other$createTime = other.getCreateTime();
                                                                                                                  if (this$createTime == null
                                                                                                                     ? other$createTime == null
                                                                                                                     : this$createTime.equals(other$createTime)
                                                                                                                     )
                                                                                                                   {
                                                                                                                     Object this$contractAmount = this.getContractAmount();
                                                                                                                     Object other$contractAmount = other.getContractAmount();
                                                                                                                     return this$contractAmount == null
                                                                                                                        ? other$contractAmount == null
                                                                                                                        : this$contractAmount.equals(
                                                                                                                           other$contractAmount
                                                                                                                        );
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
      return other instanceof ContractAuditLedgerDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paymentEnum = this.getPaymentEnum();
      result = result * 59 + ($paymentEnum == null ? 43 : $paymentEnum.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $scopeOfAudit = this.getScopeOfAudit();
      result = result * 59 + ($scopeOfAudit == null ? 43 : $scopeOfAudit.hashCode());
      Object $initiatorId = this.getInitiatorId();
      result = result * 59 + ($initiatorId == null ? 43 : $initiatorId.hashCode());
      Object $contractId = this.getContractId();
      result = result * 59 + ($contractId == null ? 43 : $contractId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $paymentId = this.getPaymentId();
      result = result * 59 + ($paymentId == null ? 43 : $paymentId.hashCode());
      Object $auditType = this.getAuditType();
      result = result * 59 + ($auditType == null ? 43 : $auditType.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $writtenById = this.getWrittenById();
      result = result * 59 + ($writtenById == null ? 43 : $writtenById.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $paymentType = this.getPaymentType();
      result = result * 59 + ($paymentType == null ? 43 : $paymentType.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $approveId = this.getApproveId();
      result = result * 59 + ($approveId == null ? 43 : $approveId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $filingDate = this.getFilingDate();
      result = result * 59 + ($filingDate == null ? 43 : $filingDate.hashCode());
      Object $oaNumber = this.getOaNumber();
      result = result * 59 + ($oaNumber == null ? 43 : $oaNumber.hashCode());
      Object $contractSignBodyName = this.getContractSignBodyName();
      result = result * 59 + ($contractSignBodyName == null ? 43 : $contractSignBodyName.hashCode());
      Object $projectAttributeName = this.getProjectAttributeName();
      result = result * 59 + ($projectAttributeName == null ? 43 : $projectAttributeName.hashCode());
      Object $initiatorName = this.getInitiatorName();
      result = result * 59 + ($initiatorName == null ? 43 : $initiatorName.hashCode());
      Object $contractNumber = this.getContractNumber();
      result = result * 59 + ($contractNumber == null ? 43 : $contractNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $writtenByName = this.getWrittenByName();
      result = result * 59 + ($writtenByName == null ? 43 : $writtenByName.hashCode());
      Object $submitDate = this.getSubmitDate();
      result = result * 59 + ($submitDate == null ? 43 : $submitDate.hashCode());
      Object $actuallyPayAmount = this.getActuallyPayAmount();
      result = result * 59 + ($actuallyPayAmount == null ? 43 : $actuallyPayAmount.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $contractAmount = this.getContractAmount();
      return result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ContractAuditLedgerDto(id="
         + this.getId()
         + ", paymentEnum="
         + this.getPaymentEnum()
         + ", filingDate="
         + this.getFilingDate()
         + ", oaNumber="
         + this.getOaNumber()
         + ", projectType="
         + this.getProjectType()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", contractSignBodyName="
         + this.getContractSignBodyName()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", projectAttributeName="
         + this.getProjectAttributeName()
         + ", scopeOfAudit="
         + this.getScopeOfAudit()
         + ", initiatorId="
         + this.getInitiatorId()
         + ", initiatorName="
         + this.getInitiatorName()
         + ", contractId="
         + this.getContractId()
         + ", contractNumber="
         + this.getContractNumber()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", paymentId="
         + this.getPaymentId()
         + ", auditType="
         + this.getAuditType()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", writtenById="
         + this.getWrittenById()
         + ", writtenByName="
         + this.getWrittenByName()
         + ", submitDate="
         + this.getSubmitDate()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", actuallyPayAmount="
         + this.getActuallyPayAmount()
         + ", paymentType="
         + this.getPaymentType()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", attachments="
         + this.getAttachments()
         + ", approveId="
         + this.getApproveId()
         + ", createTime="
         + this.getCreateTime()
         + ", type="
         + this.getType()
         + ", contractAmount="
         + this.getContractAmount()
         + ")";
   }
}
