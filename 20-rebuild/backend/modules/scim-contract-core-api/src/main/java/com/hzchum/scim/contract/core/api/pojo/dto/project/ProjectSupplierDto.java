package com.hzchum.scim.contract.core.api.pojo.dto.project;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.PaymentCommon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("ProjectSupplierDto")
public class ProjectSupplierDto extends PaymentCommon {
   @ApiModelProperty
   private String supplierName;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("合同主体id")
   private Long contractSignBodyId;
   @ApiModelProperty("合同主体")
   private String contractSignBodyName;
   @ApiModelProperty("签约主体占比")
   private BigDecimal contractSignBodyRatio;
   @ApiModelProperty("签约主体金额占比")
   private BigDecimal contractSignBodyRatioAmount;
   @ApiModelProperty("合同额")
   private BigDecimal contractAmount;
   @ApiModelProperty("项目类型")
   private Integer projectAttribute;
   @ApiModelProperty("采购类型")
   private Integer purchaseType;
   @ApiModelProperty("项目累计收入")
   private BigDecimal projectIncome;
   @ApiModelProperty("项目累计支出")
   private BigDecimal projectExpenditure;
   @ApiModelProperty("总结余")
   private BigDecimal collectionSummary;
   @ApiModelProperty("本合同累计支出")
   private BigDecimal contractExpenditure;
   @ApiModelProperty("本项目累计结余")
   private BigDecimal contractCollectionSummary;
   @ApiModelProperty("个人授信")
   private BigDecimal personalCredit;
   @ApiModelProperty("项目经理")
   private String projectManagerName;
   @ApiModelProperty("项目经理占比")
   private BigDecimal projectManagerRatio;
   @ApiModelProperty("项目经理金额占比")
   private BigDecimal projectManagerRatioAmount;
   @ApiModelProperty("签约主体id")
   private Long branchCompanyId;
   @ApiModelProperty("签约主体名称")
   private String branchCompanyName;
   @ApiModelProperty("合同金额")
   private BigDecimal amount;
   @ApiModelProperty("物资类型")
   private Integer basicClass;
   @ApiModelProperty("付款银行")
   private String paymentBank;
   @ApiModelProperty("付款日期")
   private LocalDate paymentDate;
   @ApiModelProperty("付款账号")
   private String paymentBankAccount;
   @ApiModelProperty("付款类型")
   private Integer paymentType;
   @ApiModelProperty("结算金额")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "serialNumber", value = "采购合同号", notes = "采购合同号")
   private List<String> serialNumber;
   @ApiModelProperty(name = "attachmentIds", value = "附件id", notes = "附件id")
   private String attachmentIds;
   @ApiModelProperty(name = "attachmentDto", value = "附件", notes = "附件")
   private AttachmentDTO attachmentDto;
   @ApiModelProperty("创建人")
   private String userName;
   @ApiModelProperty("供应商")
   private SupplierInfo supplier;
   @ApiModelProperty("付款事由")
   private String paymentReason;
   @ApiModelProperty("本次付款额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("分包类别id")
   private Long subcontractClassId;

   public static ProjectSupplierDto.ProjectSupplierDtoBuilder builder() {
      return new ProjectSupplierDto.ProjectSupplierDtoBuilder();
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSupplierDto)) {
         return false;
      }

      ProjectSupplierDto other = (ProjectSupplierDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$contractSignBodyId = this.getContractSignBodyId();
      Object other$contractSignBodyId = other.getContractSignBodyId();
      if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
         Object this$projectAttribute = this.getProjectAttribute();
         Object other$projectAttribute = other.getProjectAttribute();
         if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
            Object this$purchaseType = this.getPurchaseType();
            Object other$purchaseType = other.getPurchaseType();
            if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
               Object this$branchCompanyId = this.getBranchCompanyId();
               Object other$branchCompanyId = other.getBranchCompanyId();
               if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$paymentType = this.getPaymentType();
                     Object other$paymentType = other.getPaymentType();
                     if (this$paymentType == null ? other$paymentType == null : this$paymentType.equals(other$paymentType)) {
                        Object this$subcontractClassId = this.getSubcontractClassId();
                        Object other$subcontractClassId = other.getSubcontractClassId();
                        if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)) {
                           Object this$supplierName = this.getSupplierName();
                           Object other$supplierName = other.getSupplierName();
                           if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                              Object this$createTime = this.getCreateTime();
                              Object other$createTime = other.getCreateTime();
                              if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                 Object this$project = this.getProject();
                                 Object other$project = other.getProject();
                                 if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                    Object this$contractSignBodyName = this.getContractSignBodyName();
                                    Object other$contractSignBodyName = other.getContractSignBodyName();
                                    if (this$contractSignBodyName == null
                                       ? other$contractSignBodyName == null
                                       : this$contractSignBodyName.equals(other$contractSignBodyName)) {
                                       Object this$contractSignBodyRatio = this.getContractSignBodyRatio();
                                       Object other$contractSignBodyRatio = other.getContractSignBodyRatio();
                                       if (this$contractSignBodyRatio == null
                                          ? other$contractSignBodyRatio == null
                                          : this$contractSignBodyRatio.equals(other$contractSignBodyRatio)) {
                                          Object this$contractSignBodyRatioAmount = this.getContractSignBodyRatioAmount();
                                          Object other$contractSignBodyRatioAmount = other.getContractSignBodyRatioAmount();
                                          if (this$contractSignBodyRatioAmount == null
                                             ? other$contractSignBodyRatioAmount == null
                                             : this$contractSignBodyRatioAmount.equals(other$contractSignBodyRatioAmount)) {
                                             Object this$contractAmount = this.getContractAmount();
                                             Object other$contractAmount = other.getContractAmount();
                                             if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                                                Object this$projectIncome = this.getProjectIncome();
                                                Object other$projectIncome = other.getProjectIncome();
                                                if (this$projectIncome == null ? other$projectIncome == null : this$projectIncome.equals(other$projectIncome)) {
                                                   Object this$projectExpenditure = this.getProjectExpenditure();
                                                   Object other$projectExpenditure = other.getProjectExpenditure();
                                                   if (this$projectExpenditure == null
                                                      ? other$projectExpenditure == null
                                                      : this$projectExpenditure.equals(other$projectExpenditure)) {
                                                      Object this$collectionSummary = this.getCollectionSummary();
                                                      Object other$collectionSummary = other.getCollectionSummary();
                                                      if (this$collectionSummary == null
                                                         ? other$collectionSummary == null
                                                         : this$collectionSummary.equals(other$collectionSummary)) {
                                                         Object this$contractExpenditure = this.getContractExpenditure();
                                                         Object other$contractExpenditure = other.getContractExpenditure();
                                                         if (this$contractExpenditure == null
                                                            ? other$contractExpenditure == null
                                                            : this$contractExpenditure.equals(other$contractExpenditure)) {
                                                            Object this$contractCollectionSummary = this.getContractCollectionSummary();
                                                            Object other$contractCollectionSummary = other.getContractCollectionSummary();
                                                            if (this$contractCollectionSummary == null
                                                               ? other$contractCollectionSummary == null
                                                               : this$contractCollectionSummary.equals(other$contractCollectionSummary)) {
                                                               Object this$personalCredit = this.getPersonalCredit();
                                                               Object other$personalCredit = other.getPersonalCredit();
                                                               if (this$personalCredit == null
                                                                  ? other$personalCredit == null
                                                                  : this$personalCredit.equals(other$personalCredit)) {
                                                                  Object this$projectManagerName = this.getProjectManagerName();
                                                                  Object other$projectManagerName = other.getProjectManagerName();
                                                                  if (this$projectManagerName == null
                                                                     ? other$projectManagerName == null
                                                                     : this$projectManagerName.equals(other$projectManagerName)) {
                                                                     Object this$projectManagerRatio = this.getProjectManagerRatio();
                                                                     Object other$projectManagerRatio = other.getProjectManagerRatio();
                                                                     if (this$projectManagerRatio == null
                                                                        ? other$projectManagerRatio == null
                                                                        : this$projectManagerRatio.equals(other$projectManagerRatio)) {
                                                                        Object this$projectManagerRatioAmount = this.getProjectManagerRatioAmount();
                                                                        Object other$projectManagerRatioAmount = other.getProjectManagerRatioAmount();
                                                                        if (this$projectManagerRatioAmount == null
                                                                           ? other$projectManagerRatioAmount == null
                                                                           : this$projectManagerRatioAmount.equals(other$projectManagerRatioAmount)) {
                                                                           Object this$branchCompanyName = this.getBranchCompanyName();
                                                                           Object other$branchCompanyName = other.getBranchCompanyName();
                                                                           if (this$branchCompanyName == null
                                                                              ? other$branchCompanyName == null
                                                                              : this$branchCompanyName.equals(other$branchCompanyName)) {
                                                                              Object this$amount = this.getAmount();
                                                                              Object other$amount = other.getAmount();
                                                                              if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)
                                                                                 )
                                                                               {
                                                                                 Object this$paymentBank = this.getPaymentBank();
                                                                                 Object other$paymentBank = other.getPaymentBank();
                                                                                 if (this$paymentBank == null
                                                                                    ? other$paymentBank == null
                                                                                    : this$paymentBank.equals(other$paymentBank)) {
                                                                                    Object this$paymentDate = this.getPaymentDate();
                                                                                    Object other$paymentDate = other.getPaymentDate();
                                                                                    if (this$paymentDate == null
                                                                                       ? other$paymentDate == null
                                                                                       : this$paymentDate.equals(other$paymentDate)) {
                                                                                       Object this$paymentBankAccount = this.getPaymentBankAccount();
                                                                                       Object other$paymentBankAccount = other.getPaymentBankAccount();
                                                                                       if (this$paymentBankAccount == null
                                                                                          ? other$paymentBankAccount == null
                                                                                          : this$paymentBankAccount.equals(other$paymentBankAccount)) {
                                                                                          Object this$settlementAmount = this.getSettlementAmount();
                                                                                          Object other$settlementAmount = other.getSettlementAmount();
                                                                                          if (this$settlementAmount == null
                                                                                             ? other$settlementAmount == null
                                                                                             : this$settlementAmount.equals(other$settlementAmount)) {
                                                                                             Object this$serialNumber = this.getSerialNumber();
                                                                                             Object other$serialNumber = other.getSerialNumber();
                                                                                             if (this$serialNumber == null
                                                                                                ? other$serialNumber == null
                                                                                                : this$serialNumber.equals(other$serialNumber)) {
                                                                                                Object this$attachmentIds = this.getAttachmentIds();
                                                                                                Object other$attachmentIds = other.getAttachmentIds();
                                                                                                if (this$attachmentIds == null
                                                                                                   ? other$attachmentIds == null
                                                                                                   : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                                   Object this$attachmentDto = this.getAttachmentDto();
                                                                                                   Object other$attachmentDto = other.getAttachmentDto();
                                                                                                   if (this$attachmentDto == null
                                                                                                      ? other$attachmentDto == null
                                                                                                      : this$attachmentDto.equals(other$attachmentDto)) {
                                                                                                      Object this$userName = this.getUserName();
                                                                                                      Object other$userName = other.getUserName();
                                                                                                      if (this$userName == null
                                                                                                         ? other$userName == null
                                                                                                         : this$userName.equals(other$userName)) {
                                                                                                         Object this$supplier = this.getSupplier();
                                                                                                         Object other$supplier = other.getSupplier();
                                                                                                         if (this$supplier == null
                                                                                                            ? other$supplier == null
                                                                                                            : this$supplier.equals(other$supplier)) {
                                                                                                            Object this$paymentReason = this.getPaymentReason();
                                                                                                            Object other$paymentReason = other.getPaymentReason();
                                                                                                            if (this$paymentReason == null
                                                                                                               ? other$paymentReason == null
                                                                                                               : this$paymentReason.equals(other$paymentReason)
                                                                                                               )
                                                                                                             {
                                                                                                               Object this$paymentAmount = this.getPaymentAmount();
                                                                                                               Object other$paymentAmount = other.getPaymentAmount();
                                                                                                               return this$paymentAmount == null
                                                                                                                  ? other$paymentAmount == null
                                                                                                                  : this$paymentAmount.equals(
                                                                                                                     other$paymentAmount
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectSupplierDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $paymentType = this.getPaymentType();
      result = result * 59 + ($paymentType == null ? 43 : $paymentType.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $contractSignBodyName = this.getContractSignBodyName();
      result = result * 59 + ($contractSignBodyName == null ? 43 : $contractSignBodyName.hashCode());
      Object $contractSignBodyRatio = this.getContractSignBodyRatio();
      result = result * 59 + ($contractSignBodyRatio == null ? 43 : $contractSignBodyRatio.hashCode());
      Object $contractSignBodyRatioAmount = this.getContractSignBodyRatioAmount();
      result = result * 59 + ($contractSignBodyRatioAmount == null ? 43 : $contractSignBodyRatioAmount.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $projectIncome = this.getProjectIncome();
      result = result * 59 + ($projectIncome == null ? 43 : $projectIncome.hashCode());
      Object $projectExpenditure = this.getProjectExpenditure();
      result = result * 59 + ($projectExpenditure == null ? 43 : $projectExpenditure.hashCode());
      Object $collectionSummary = this.getCollectionSummary();
      result = result * 59 + ($collectionSummary == null ? 43 : $collectionSummary.hashCode());
      Object $contractExpenditure = this.getContractExpenditure();
      result = result * 59 + ($contractExpenditure == null ? 43 : $contractExpenditure.hashCode());
      Object $contractCollectionSummary = this.getContractCollectionSummary();
      result = result * 59 + ($contractCollectionSummary == null ? 43 : $contractCollectionSummary.hashCode());
      Object $personalCredit = this.getPersonalCredit();
      result = result * 59 + ($personalCredit == null ? 43 : $personalCredit.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $projectManagerRatio = this.getProjectManagerRatio();
      result = result * 59 + ($projectManagerRatio == null ? 43 : $projectManagerRatio.hashCode());
      Object $projectManagerRatioAmount = this.getProjectManagerRatioAmount();
      result = result * 59 + ($projectManagerRatioAmount == null ? 43 : $projectManagerRatioAmount.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $paymentBank = this.getPaymentBank();
      result = result * 59 + ($paymentBank == null ? 43 : $paymentBank.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentDto = this.getAttachmentDto();
      result = result * 59 + ($attachmentDto == null ? 43 : $attachmentDto.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $paymentReason = this.getPaymentReason();
      result = result * 59 + ($paymentReason == null ? 43 : $paymentReason.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      return result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
   }

   public ProjectSupplierDto() {
   }

   public ProjectSupplierDto(
      final String supplierName,
      final LocalDateTime createTime,
      final ProjectInfo project,
      final Long contractSignBodyId,
      final String contractSignBodyName,
      final BigDecimal contractSignBodyRatio,
      final BigDecimal contractSignBodyRatioAmount,
      final BigDecimal contractAmount,
      final Integer projectAttribute,
      final Integer purchaseType,
      final BigDecimal projectIncome,
      final BigDecimal projectExpenditure,
      final BigDecimal collectionSummary,
      final BigDecimal contractExpenditure,
      final BigDecimal contractCollectionSummary,
      final BigDecimal personalCredit,
      final String projectManagerName,
      final BigDecimal projectManagerRatio,
      final BigDecimal projectManagerRatioAmount,
      final Long branchCompanyId,
      final String branchCompanyName,
      final BigDecimal amount,
      final Integer basicClass,
      final String paymentBank,
      final LocalDate paymentDate,
      final String paymentBankAccount,
      final Integer paymentType,
      final BigDecimal settlementAmount,
      final List<String> serialNumber,
      final String attachmentIds,
      final AttachmentDTO attachmentDto,
      final String userName,
      final SupplierInfo supplier,
      final String paymentReason,
      final BigDecimal paymentAmount,
      final Long subcontractClassId
   ) {
      this.supplierName = supplierName;
      this.createTime = createTime;
      this.project = project;
      this.contractSignBodyId = contractSignBodyId;
      this.contractSignBodyName = contractSignBodyName;
      this.contractSignBodyRatio = contractSignBodyRatio;
      this.contractSignBodyRatioAmount = contractSignBodyRatioAmount;
      this.contractAmount = contractAmount;
      this.projectAttribute = projectAttribute;
      this.purchaseType = purchaseType;
      this.projectIncome = projectIncome;
      this.projectExpenditure = projectExpenditure;
      this.collectionSummary = collectionSummary;
      this.contractExpenditure = contractExpenditure;
      this.contractCollectionSummary = contractCollectionSummary;
      this.personalCredit = personalCredit;
      this.projectManagerName = projectManagerName;
      this.projectManagerRatio = projectManagerRatio;
      this.projectManagerRatioAmount = projectManagerRatioAmount;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.amount = amount;
      this.basicClass = basicClass;
      this.paymentBank = paymentBank;
      this.paymentDate = paymentDate;
      this.paymentBankAccount = paymentBankAccount;
      this.paymentType = paymentType;
      this.settlementAmount = settlementAmount;
      this.serialNumber = serialNumber;
      this.attachmentIds = attachmentIds;
      this.attachmentDto = attachmentDto;
      this.userName = userName;
      this.supplier = supplier;
      this.paymentReason = paymentReason;
      this.paymentAmount = paymentAmount;
      this.subcontractClassId = subcontractClassId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public String getContractSignBodyName() {
      return this.contractSignBodyName;
   }

   public BigDecimal getContractSignBodyRatio() {
      return this.contractSignBodyRatio;
   }

   public BigDecimal getContractSignBodyRatioAmount() {
      return this.contractSignBodyRatioAmount;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Integer getPurchaseType() {
      return this.purchaseType;
   }

   public BigDecimal getProjectIncome() {
      return this.projectIncome;
   }

   public BigDecimal getProjectExpenditure() {
      return this.projectExpenditure;
   }

   public BigDecimal getCollectionSummary() {
      return this.collectionSummary;
   }

   public BigDecimal getContractExpenditure() {
      return this.contractExpenditure;
   }

   public BigDecimal getContractCollectionSummary() {
      return this.contractCollectionSummary;
   }

   public BigDecimal getPersonalCredit() {
      return this.personalCredit;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public BigDecimal getProjectManagerRatio() {
      return this.projectManagerRatio;
   }

   public BigDecimal getProjectManagerRatioAmount() {
      return this.projectManagerRatioAmount;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   @Override
   public String getPaymentBank() {
      return this.paymentBank;
   }

   public LocalDate getPaymentDate() {
      return this.paymentDate;
   }

   @Override
   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public Integer getPaymentType() {
      return this.paymentType;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public List<String> getSerialNumber() {
      return this.serialNumber;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public AttachmentDTO getAttachmentDto() {
      return this.attachmentDto;
   }

   public String getUserName() {
      return this.userName;
   }

   public SupplierInfo getSupplier() {
      return this.supplier;
   }

   public String getPaymentReason() {
      return this.paymentReason;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public Long getSubcontractClassId() {
      return this.subcontractClassId;
   }

   public ProjectSupplierDto setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public ProjectSupplierDto setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public ProjectSupplierDto setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public ProjectSupplierDto setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
      return this;
   }

   public ProjectSupplierDto setContractSignBodyName(final String contractSignBodyName) {
      this.contractSignBodyName = contractSignBodyName;
      return this;
   }

   public ProjectSupplierDto setContractSignBodyRatio(final BigDecimal contractSignBodyRatio) {
      this.contractSignBodyRatio = contractSignBodyRatio;
      return this;
   }

   public ProjectSupplierDto setContractSignBodyRatioAmount(final BigDecimal contractSignBodyRatioAmount) {
      this.contractSignBodyRatioAmount = contractSignBodyRatioAmount;
      return this;
   }

   public ProjectSupplierDto setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   public ProjectSupplierDto setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public ProjectSupplierDto setPurchaseType(final Integer purchaseType) {
      this.purchaseType = purchaseType;
      return this;
   }

   public ProjectSupplierDto setProjectIncome(final BigDecimal projectIncome) {
      this.projectIncome = projectIncome;
      return this;
   }

   public ProjectSupplierDto setProjectExpenditure(final BigDecimal projectExpenditure) {
      this.projectExpenditure = projectExpenditure;
      return this;
   }

   public ProjectSupplierDto setCollectionSummary(final BigDecimal collectionSummary) {
      this.collectionSummary = collectionSummary;
      return this;
   }

   public ProjectSupplierDto setContractExpenditure(final BigDecimal contractExpenditure) {
      this.contractExpenditure = contractExpenditure;
      return this;
   }

   public ProjectSupplierDto setContractCollectionSummary(final BigDecimal contractCollectionSummary) {
      this.contractCollectionSummary = contractCollectionSummary;
      return this;
   }

   public ProjectSupplierDto setPersonalCredit(final BigDecimal personalCredit) {
      this.personalCredit = personalCredit;
      return this;
   }

   public ProjectSupplierDto setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
      return this;
   }

   public ProjectSupplierDto setProjectManagerRatio(final BigDecimal projectManagerRatio) {
      this.projectManagerRatio = projectManagerRatio;
      return this;
   }

   public ProjectSupplierDto setProjectManagerRatioAmount(final BigDecimal projectManagerRatioAmount) {
      this.projectManagerRatioAmount = projectManagerRatioAmount;
      return this;
   }

   public ProjectSupplierDto setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public ProjectSupplierDto setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
      return this;
   }

   public ProjectSupplierDto setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public ProjectSupplierDto setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public ProjectSupplierDto setPaymentBank(final String paymentBank) {
      this.paymentBank = paymentBank;
      return this;
   }

   public ProjectSupplierDto setPaymentDate(final LocalDate paymentDate) {
      this.paymentDate = paymentDate;
      return this;
   }

   public ProjectSupplierDto setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
      return this;
   }

   public ProjectSupplierDto setPaymentType(final Integer paymentType) {
      this.paymentType = paymentType;
      return this;
   }

   public ProjectSupplierDto setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
      return this;
   }

   public ProjectSupplierDto setSerialNumber(final List<String> serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ProjectSupplierDto setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public ProjectSupplierDto setAttachmentDto(final AttachmentDTO attachmentDto) {
      this.attachmentDto = attachmentDto;
      return this;
   }

   public ProjectSupplierDto setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public ProjectSupplierDto setSupplier(final SupplierInfo supplier) {
      this.supplier = supplier;
      return this;
   }

   public ProjectSupplierDto setPaymentReason(final String paymentReason) {
      this.paymentReason = paymentReason;
      return this;
   }

   public ProjectSupplierDto setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
      return this;
   }

   public ProjectSupplierDto setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectSupplierDto(supplierName="
         + this.getSupplierName()
         + ", createTime="
         + this.getCreateTime()
         + ", project="
         + this.getProject()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", contractSignBodyName="
         + this.getContractSignBodyName()
         + ", contractSignBodyRatio="
         + this.getContractSignBodyRatio()
         + ", contractSignBodyRatioAmount="
         + this.getContractSignBodyRatioAmount()
         + ", contractAmount="
         + this.getContractAmount()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", purchaseType="
         + this.getPurchaseType()
         + ", projectIncome="
         + this.getProjectIncome()
         + ", projectExpenditure="
         + this.getProjectExpenditure()
         + ", collectionSummary="
         + this.getCollectionSummary()
         + ", contractExpenditure="
         + this.getContractExpenditure()
         + ", contractCollectionSummary="
         + this.getContractCollectionSummary()
         + ", personalCredit="
         + this.getPersonalCredit()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", projectManagerRatio="
         + this.getProjectManagerRatio()
         + ", projectManagerRatioAmount="
         + this.getProjectManagerRatioAmount()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", amount="
         + this.getAmount()
         + ", basicClass="
         + this.getBasicClass()
         + ", paymentBank="
         + this.getPaymentBank()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", paymentType="
         + this.getPaymentType()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentDto="
         + this.getAttachmentDto()
         + ", userName="
         + this.getUserName()
         + ", supplier="
         + this.getSupplier()
         + ", paymentReason="
         + this.getPaymentReason()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", subcontractClassId="
         + this.getSubcontractClassId()
         + ")";
   }

   public static class ProjectSupplierDtoBuilder {
      private String supplierName;
      private LocalDateTime createTime;
      private ProjectInfo project;
      private Long contractSignBodyId;
      private String contractSignBodyName;
      private BigDecimal contractSignBodyRatio;
      private BigDecimal contractSignBodyRatioAmount;
      private BigDecimal contractAmount;
      private Integer projectAttribute;
      private Integer purchaseType;
      private BigDecimal projectIncome;
      private BigDecimal projectExpenditure;
      private BigDecimal collectionSummary;
      private BigDecimal contractExpenditure;
      private BigDecimal contractCollectionSummary;
      private BigDecimal personalCredit;
      private String projectManagerName;
      private BigDecimal projectManagerRatio;
      private BigDecimal projectManagerRatioAmount;
      private Long branchCompanyId;
      private String branchCompanyName;
      private BigDecimal amount;
      private Integer basicClass;
      private String paymentBank;
      private LocalDate paymentDate;
      private String paymentBankAccount;
      private Integer paymentType;
      private BigDecimal settlementAmount;
      private List<String> serialNumber;
      private String attachmentIds;
      private AttachmentDTO attachmentDto;
      private String userName;
      private SupplierInfo supplier;
      private String paymentReason;
      private BigDecimal paymentAmount;
      private Long subcontractClassId;

      ProjectSupplierDtoBuilder() {
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder contractSignBodyId(final Long contractSignBodyId) {
         this.contractSignBodyId = contractSignBodyId;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder contractSignBodyName(final String contractSignBodyName) {
         this.contractSignBodyName = contractSignBodyName;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder contractSignBodyRatio(final BigDecimal contractSignBodyRatio) {
         this.contractSignBodyRatio = contractSignBodyRatio;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder contractSignBodyRatioAmount(final BigDecimal contractSignBodyRatioAmount) {
         this.contractSignBodyRatioAmount = contractSignBodyRatioAmount;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder purchaseType(final Integer purchaseType) {
         this.purchaseType = purchaseType;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder projectIncome(final BigDecimal projectIncome) {
         this.projectIncome = projectIncome;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder projectExpenditure(final BigDecimal projectExpenditure) {
         this.projectExpenditure = projectExpenditure;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder collectionSummary(final BigDecimal collectionSummary) {
         this.collectionSummary = collectionSummary;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder contractExpenditure(final BigDecimal contractExpenditure) {
         this.contractExpenditure = contractExpenditure;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder contractCollectionSummary(final BigDecimal contractCollectionSummary) {
         this.contractCollectionSummary = contractCollectionSummary;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder personalCredit(final BigDecimal personalCredit) {
         this.personalCredit = personalCredit;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder projectManagerRatio(final BigDecimal projectManagerRatio) {
         this.projectManagerRatio = projectManagerRatio;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder projectManagerRatioAmount(final BigDecimal projectManagerRatioAmount) {
         this.projectManagerRatioAmount = projectManagerRatioAmount;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder paymentBank(final String paymentBank) {
         this.paymentBank = paymentBank;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder paymentDate(final LocalDate paymentDate) {
         this.paymentDate = paymentDate;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder paymentType(final Integer paymentType) {
         this.paymentType = paymentType;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder serialNumber(final List<String> serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder attachmentDto(final AttachmentDTO attachmentDto) {
         this.attachmentDto = attachmentDto;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder supplier(final SupplierInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder paymentReason(final String paymentReason) {
         this.paymentReason = paymentReason;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public ProjectSupplierDto.ProjectSupplierDtoBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      public ProjectSupplierDto build() {
         return new ProjectSupplierDto(
            this.supplierName,
            this.createTime,
            this.project,
            this.contractSignBodyId,
            this.contractSignBodyName,
            this.contractSignBodyRatio,
            this.contractSignBodyRatioAmount,
            this.contractAmount,
            this.projectAttribute,
            this.purchaseType,
            this.projectIncome,
            this.projectExpenditure,
            this.collectionSummary,
            this.contractExpenditure,
            this.contractCollectionSummary,
            this.personalCredit,
            this.projectManagerName,
            this.projectManagerRatio,
            this.projectManagerRatioAmount,
            this.branchCompanyId,
            this.branchCompanyName,
            this.amount,
            this.basicClass,
            this.paymentBank,
            this.paymentDate,
            this.paymentBankAccount,
            this.paymentType,
            this.settlementAmount,
            this.serialNumber,
            this.attachmentIds,
            this.attachmentDto,
            this.userName,
            this.supplier,
            this.paymentReason,
            this.paymentAmount,
            this.subcontractClassId
         );
      }

      @Override
      public String toString() {
         return "ProjectSupplierDto.ProjectSupplierDtoBuilder(supplierName="
            + this.supplierName
            + ", createTime="
            + this.createTime
            + ", project="
            + this.project
            + ", contractSignBodyId="
            + this.contractSignBodyId
            + ", contractSignBodyName="
            + this.contractSignBodyName
            + ", contractSignBodyRatio="
            + this.contractSignBodyRatio
            + ", contractSignBodyRatioAmount="
            + this.contractSignBodyRatioAmount
            + ", contractAmount="
            + this.contractAmount
            + ", projectAttribute="
            + this.projectAttribute
            + ", purchaseType="
            + this.purchaseType
            + ", projectIncome="
            + this.projectIncome
            + ", projectExpenditure="
            + this.projectExpenditure
            + ", collectionSummary="
            + this.collectionSummary
            + ", contractExpenditure="
            + this.contractExpenditure
            + ", contractCollectionSummary="
            + this.contractCollectionSummary
            + ", personalCredit="
            + this.personalCredit
            + ", projectManagerName="
            + this.projectManagerName
            + ", projectManagerRatio="
            + this.projectManagerRatio
            + ", projectManagerRatioAmount="
            + this.projectManagerRatioAmount
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", amount="
            + this.amount
            + ", basicClass="
            + this.basicClass
            + ", paymentBank="
            + this.paymentBank
            + ", paymentDate="
            + this.paymentDate
            + ", paymentBankAccount="
            + this.paymentBankAccount
            + ", paymentType="
            + this.paymentType
            + ", settlementAmount="
            + this.settlementAmount
            + ", serialNumber="
            + this.serialNumber
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachmentDto="
            + this.attachmentDto
            + ", userName="
            + this.userName
            + ", supplier="
            + this.supplier
            + ", paymentReason="
            + this.paymentReason
            + ", paymentAmount="
            + this.paymentAmount
            + ", subcontractClassId="
            + this.subcontractClassId
            + ")";
      }
   }
}
