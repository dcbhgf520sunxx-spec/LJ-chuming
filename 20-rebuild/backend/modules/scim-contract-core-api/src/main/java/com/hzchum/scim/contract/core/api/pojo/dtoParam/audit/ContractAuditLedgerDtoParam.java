package com.hzchum.scim.contract.core.api.pojo.dtoParam.audit;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContractAuditLedgerDtoParam {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "paymentEnum", value = "付款类型", notes = "付款类型")
   private Integer paymentEnum;
   @ApiModelProperty(name = "filingDate", value = "申请日期", notes = "申请日期")
   private LocalDateTime filingDate;
   @ApiModelProperty(name = "oaNumber", value = "OA编号", notes = "OA编号")
   private String oaNumber;
   @ApiModelProperty(name = "projectType", value = "项目类型", notes = "项目类型")
   private Integer projectType;
   @ApiModelProperty(name = "initiatorId", value = "发起人", notes = "发起人")
   private Long initiatorId;
   @ApiModelProperty(name = "contractId", value = "采购/分包合同id", notes = "采购/分包合同id")
   private Long contractId;
   @ApiModelProperty(name = "contractNumber", value = "采购/分包合同号", notes = "采购/分包合同号")
   private String contractNumber;
   @ApiModelProperty(name = "projectId", value = "所属项目", notes = "所属项目")
   private Long projectId;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理", notes = "项目经理")
   private Long projectManagerId;
   @ApiModelProperty(name = "supplierId", value = "供应商", notes = "供应商")
   private Long supplierId;
   @ApiModelProperty(name = "applyAmount", value = "申请金额", notes = "申请金额")
   private BigDecimal applyAmount;
   @ApiModelProperty(name = "paymentAmount", value = "实付金额", notes = "实付金额")
   private BigDecimal paymentAmount;
   @ApiModelProperty(name = "writtenById", value = "填报人", notes = "填报人")
   private Long writtenById;
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
   @ApiModelProperty(name = "approveId", value = "审批模板id", notes = "审批模板id")
   private Long approveId;

   public static ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder builder() {
      return new ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder();
   }

   public ContractAuditLedgerDtoParam() {
   }

   public ContractAuditLedgerDtoParam(
      final Long id,
      final Integer paymentEnum,
      final LocalDateTime filingDate,
      final String oaNumber,
      final Integer projectType,
      final Long initiatorId,
      final Long contractId,
      final String contractNumber,
      final Long projectId,
      final Long projectManagerId,
      final Long supplierId,
      final BigDecimal applyAmount,
      final BigDecimal paymentAmount,
      final Long writtenById,
      final LocalDateTime submitDate,
      final Integer auditStatusEnum,
      final BigDecimal actuallyPayAmount,
      final Integer paymentType,
      final LocalDateTime paymentDate,
      final String voucherNumber,
      final Long attachmentId,
      final Long approveId
   ) {
      this.id = id;
      this.paymentEnum = paymentEnum;
      this.filingDate = filingDate;
      this.oaNumber = oaNumber;
      this.projectType = projectType;
      this.initiatorId = initiatorId;
      this.contractId = contractId;
      this.contractNumber = contractNumber;
      this.projectId = projectId;
      this.projectManagerId = projectManagerId;
      this.supplierId = supplierId;
      this.applyAmount = applyAmount;
      this.paymentAmount = paymentAmount;
      this.writtenById = writtenById;
      this.submitDate = submitDate;
      this.auditStatusEnum = auditStatusEnum;
      this.actuallyPayAmount = actuallyPayAmount;
      this.paymentType = paymentType;
      this.paymentDate = paymentDate;
      this.voucherNumber = voucherNumber;
      this.attachmentId = attachmentId;
      this.approveId = approveId;
   }

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

   public Long getInitiatorId() {
      return this.initiatorId;
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

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public Long getSupplierId() {
      return this.supplierId;
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

   public Long getApproveId() {
      return this.approveId;
   }

   public ContractAuditLedgerDtoParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractAuditLedgerDtoParam setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
      return this;
   }

   public ContractAuditLedgerDtoParam setFilingDate(final LocalDateTime filingDate) {
      this.filingDate = filingDate;
      return this;
   }

   public ContractAuditLedgerDtoParam setOaNumber(final String oaNumber) {
      this.oaNumber = oaNumber;
      return this;
   }

   public ContractAuditLedgerDtoParam setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   public ContractAuditLedgerDtoParam setInitiatorId(final Long initiatorId) {
      this.initiatorId = initiatorId;
      return this;
   }

   public ContractAuditLedgerDtoParam setContractId(final Long contractId) {
      this.contractId = contractId;
      return this;
   }

   public ContractAuditLedgerDtoParam setContractNumber(final String contractNumber) {
      this.contractNumber = contractNumber;
      return this;
   }

   public ContractAuditLedgerDtoParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractAuditLedgerDtoParam setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public ContractAuditLedgerDtoParam setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public ContractAuditLedgerDtoParam setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
      return this;
   }

   public ContractAuditLedgerDtoParam setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
      return this;
   }

   public ContractAuditLedgerDtoParam setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
      return this;
   }

   public ContractAuditLedgerDtoParam setSubmitDate(final LocalDateTime submitDate) {
      this.submitDate = submitDate;
      return this;
   }

   public ContractAuditLedgerDtoParam setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
      return this;
   }

   public ContractAuditLedgerDtoParam setActuallyPayAmount(final BigDecimal actuallyPayAmount) {
      this.actuallyPayAmount = actuallyPayAmount;
      return this;
   }

   public ContractAuditLedgerDtoParam setPaymentType(final Integer paymentType) {
      this.paymentType = paymentType;
      return this;
   }

   public ContractAuditLedgerDtoParam setPaymentDate(final LocalDateTime paymentDate) {
      this.paymentDate = paymentDate;
      return this;
   }

   public ContractAuditLedgerDtoParam setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
      return this;
   }

   public ContractAuditLedgerDtoParam setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
      return this;
   }

   public ContractAuditLedgerDtoParam setApproveId(final Long approveId) {
      this.approveId = approveId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractAuditLedgerDtoParam)) {
         return false;
      }

      ContractAuditLedgerDtoParam other = (ContractAuditLedgerDtoParam)o;
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
               Object this$initiatorId = this.getInitiatorId();
               Object other$initiatorId = other.getInitiatorId();
               if (this$initiatorId == null ? other$initiatorId == null : this$initiatorId.equals(other$initiatorId)) {
                  Object this$contractId = this.getContractId();
                  Object other$contractId = other.getContractId();
                  if (this$contractId == null ? other$contractId == null : this$contractId.equals(other$contractId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$projectManagerId = this.getProjectManagerId();
                        Object other$projectManagerId = other.getProjectManagerId();
                        if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                           Object this$supplierId = this.getSupplierId();
                           Object other$supplierId = other.getSupplierId();
                           if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                              Object this$writtenById = this.getWrittenById();
                              Object other$writtenById = other.getWrittenById();
                              if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                                 Object this$auditStatusEnum = this.getAuditStatusEnum();
                                 Object other$auditStatusEnum = other.getAuditStatusEnum();
                                 if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                                    Object this$paymentType = this.getPaymentType();
                                    Object other$paymentType = other.getPaymentType();
                                    if (this$paymentType == null ? other$paymentType == null : this$paymentType.equals(other$paymentType)) {
                                       Object this$attachmentId = this.getAttachmentId();
                                       Object other$attachmentId = other.getAttachmentId();
                                       if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
                                          Object this$approveId = this.getApproveId();
                                          Object other$approveId = other.getApproveId();
                                          if (this$approveId == null ? other$approveId == null : this$approveId.equals(other$approveId)) {
                                             Object this$filingDate = this.getFilingDate();
                                             Object other$filingDate = other.getFilingDate();
                                             if (this$filingDate == null ? other$filingDate == null : this$filingDate.equals(other$filingDate)) {
                                                Object this$oaNumber = this.getOaNumber();
                                                Object other$oaNumber = other.getOaNumber();
                                                if (this$oaNumber == null ? other$oaNumber == null : this$oaNumber.equals(other$oaNumber)) {
                                                   Object this$contractNumber = this.getContractNumber();
                                                   Object other$contractNumber = other.getContractNumber();
                                                   if (this$contractNumber == null
                                                      ? other$contractNumber == null
                                                      : this$contractNumber.equals(other$contractNumber)) {
                                                      Object this$applyAmount = this.getApplyAmount();
                                                      Object other$applyAmount = other.getApplyAmount();
                                                      if (this$applyAmount == null ? other$applyAmount == null : this$applyAmount.equals(other$applyAmount)) {
                                                         Object this$paymentAmount = this.getPaymentAmount();
                                                         Object other$paymentAmount = other.getPaymentAmount();
                                                         if (this$paymentAmount == null
                                                            ? other$paymentAmount == null
                                                            : this$paymentAmount.equals(other$paymentAmount)) {
                                                            Object this$submitDate = this.getSubmitDate();
                                                            Object other$submitDate = other.getSubmitDate();
                                                            if (this$submitDate == null ? other$submitDate == null : this$submitDate.equals(other$submitDate)) {
                                                               Object this$actuallyPayAmount = this.getActuallyPayAmount();
                                                               Object other$actuallyPayAmount = other.getActuallyPayAmount();
                                                               if (this$actuallyPayAmount == null
                                                                  ? other$actuallyPayAmount == null
                                                                  : this$actuallyPayAmount.equals(other$actuallyPayAmount)) {
                                                                  Object this$paymentDate = this.getPaymentDate();
                                                                  Object other$paymentDate = other.getPaymentDate();
                                                                  if (this$paymentDate == null
                                                                     ? other$paymentDate == null
                                                                     : this$paymentDate.equals(other$paymentDate)) {
                                                                     Object this$voucherNumber = this.getVoucherNumber();
                                                                     Object other$voucherNumber = other.getVoucherNumber();
                                                                     return this$voucherNumber == null
                                                                        ? other$voucherNumber == null
                                                                        : this$voucherNumber.equals(other$voucherNumber);
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
      return other instanceof ContractAuditLedgerDtoParam;
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
      Object $initiatorId = this.getInitiatorId();
      result = result * 59 + ($initiatorId == null ? 43 : $initiatorId.hashCode());
      Object $contractId = this.getContractId();
      result = result * 59 + ($contractId == null ? 43 : $contractId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
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
      Object $filingDate = this.getFilingDate();
      result = result * 59 + ($filingDate == null ? 43 : $filingDate.hashCode());
      Object $oaNumber = this.getOaNumber();
      result = result * 59 + ($oaNumber == null ? 43 : $oaNumber.hashCode());
      Object $contractNumber = this.getContractNumber();
      result = result * 59 + ($contractNumber == null ? 43 : $contractNumber.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $submitDate = this.getSubmitDate();
      result = result * 59 + ($submitDate == null ? 43 : $submitDate.hashCode());
      Object $actuallyPayAmount = this.getActuallyPayAmount();
      result = result * 59 + ($actuallyPayAmount == null ? 43 : $actuallyPayAmount.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      return result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
   }

   @Override
   public String toString() {
      return "ContractAuditLedgerDtoParam(id="
         + this.getId()
         + ", paymentEnum="
         + this.getPaymentEnum()
         + ", filingDate="
         + this.getFilingDate()
         + ", oaNumber="
         + this.getOaNumber()
         + ", projectType="
         + this.getProjectType()
         + ", initiatorId="
         + this.getInitiatorId()
         + ", contractId="
         + this.getContractId()
         + ", contractNumber="
         + this.getContractNumber()
         + ", projectId="
         + this.getProjectId()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", supplierId="
         + this.getSupplierId()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", writtenById="
         + this.getWrittenById()
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
         + ", approveId="
         + this.getApproveId()
         + ")";
   }

   public static class ContractAuditLedgerDtoParamBuilder {
      private Long id;
      private Integer paymentEnum;
      private LocalDateTime filingDate;
      private String oaNumber;
      private Integer projectType;
      private Long initiatorId;
      private Long contractId;
      private String contractNumber;
      private Long projectId;
      private Long projectManagerId;
      private Long supplierId;
      private BigDecimal applyAmount;
      private BigDecimal paymentAmount;
      private Long writtenById;
      private LocalDateTime submitDate;
      private Integer auditStatusEnum;
      private BigDecimal actuallyPayAmount;
      private Integer paymentType;
      private LocalDateTime paymentDate;
      private String voucherNumber;
      private Long attachmentId;
      private Long approveId;

      ContractAuditLedgerDtoParamBuilder() {
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder paymentEnum(final Integer paymentEnum) {
         this.paymentEnum = paymentEnum;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder filingDate(final LocalDateTime filingDate) {
         this.filingDate = filingDate;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder oaNumber(final String oaNumber) {
         this.oaNumber = oaNumber;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder initiatorId(final Long initiatorId) {
         this.initiatorId = initiatorId;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder contractId(final Long contractId) {
         this.contractId = contractId;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder contractNumber(final String contractNumber) {
         this.contractNumber = contractNumber;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder submitDate(final LocalDateTime submitDate) {
         this.submitDate = submitDate;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder actuallyPayAmount(final BigDecimal actuallyPayAmount) {
         this.actuallyPayAmount = actuallyPayAmount;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder paymentType(final Integer paymentType) {
         this.paymentType = paymentType;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder paymentDate(final LocalDateTime paymentDate) {
         this.paymentDate = paymentDate;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder approveId(final Long approveId) {
         this.approveId = approveId;
         return this;
      }

      public ContractAuditLedgerDtoParam build() {
         return new ContractAuditLedgerDtoParam(
            this.id,
            this.paymentEnum,
            this.filingDate,
            this.oaNumber,
            this.projectType,
            this.initiatorId,
            this.contractId,
            this.contractNumber,
            this.projectId,
            this.projectManagerId,
            this.supplierId,
            this.applyAmount,
            this.paymentAmount,
            this.writtenById,
            this.submitDate,
            this.auditStatusEnum,
            this.actuallyPayAmount,
            this.paymentType,
            this.paymentDate,
            this.voucherNumber,
            this.attachmentId,
            this.approveId
         );
      }

      @Override
      public String toString() {
         return "ContractAuditLedgerDtoParam.ContractAuditLedgerDtoParamBuilder(id="
            + this.id
            + ", paymentEnum="
            + this.paymentEnum
            + ", filingDate="
            + this.filingDate
            + ", oaNumber="
            + this.oaNumber
            + ", projectType="
            + this.projectType
            + ", initiatorId="
            + this.initiatorId
            + ", contractId="
            + this.contractId
            + ", contractNumber="
            + this.contractNumber
            + ", projectId="
            + this.projectId
            + ", projectManagerId="
            + this.projectManagerId
            + ", supplierId="
            + this.supplierId
            + ", applyAmount="
            + this.applyAmount
            + ", paymentAmount="
            + this.paymentAmount
            + ", writtenById="
            + this.writtenById
            + ", submitDate="
            + this.submitDate
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", actuallyPayAmount="
            + this.actuallyPayAmount
            + ", paymentType="
            + this.paymentType
            + ", paymentDate="
            + this.paymentDate
            + ", voucherNumber="
            + this.voucherNumber
            + ", attachmentId="
            + this.attachmentId
            + ", approveId="
            + this.approveId
            + ")";
      }
   }
}
