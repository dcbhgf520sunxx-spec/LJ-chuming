package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ScmLumpSumSystemPurchaseOrderDTOParam {
   private Long id;
   private String serialNumberParent;
   private String serialNumber;
   private Long projectManagerId;
   private Long applicantId;
   private String applicantName;
   private Integer basicClass;
   private Integer materialType;
   private Integer purchaseType;
   private Long projectId;
   private LocalDateTime userUpdateTime;
   private Long lastOperatorNameId;
   private String lastOperatorName;
   private Long supplierId;
   private List<Long> auxMaterialIds;
   private List<Long> otherMaterialIds;
   private List<Long> gasMaterialIds;
   private Long branchCompanyId;
   private Integer logisticsPayerType;
   private BigDecimal mete;
   private String meteUnit;
   private BigDecimal amount;
   private BigDecimal taxRate;
   private Integer invoiceType;
   private List<Long> attachmentIds;
   private String remark;
   private Boolean editable;
   private Boolean boolRewrite;
   private Integer purchaseStatus;
   private Integer settlementStatus;
   private Boolean boolTemporaryStorage;
   private Integer reviewStatus;
   private LocalDateTime reviewPassTime;
   private Boolean boolDetail;
   private String applyPurchaseStatus;
   private List<ScmLumpSumSystemPurchaseOrderDetailDTOParam> list;
   private Integer dataStatus;
   private String cause;
   private Long approveRecordIdNow;
   private String approveRecordIds;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumberParent() {
      return this.serialNumberParent;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public Integer getPurchaseType() {
      return this.purchaseType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public Long getLastOperatorNameId() {
      return this.lastOperatorNameId;
   }

   public String getLastOperatorName() {
      return this.lastOperatorName;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public List<Long> getAuxMaterialIds() {
      return this.auxMaterialIds;
   }

   public List<Long> getOtherMaterialIds() {
      return this.otherMaterialIds;
   }

   public List<Long> getGasMaterialIds() {
      return this.gasMaterialIds;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Integer getLogisticsPayerType() {
      return this.logisticsPayerType;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getMeteUnit() {
      return this.meteUnit;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getEditable() {
      return this.editable;
   }

   public Boolean getBoolRewrite() {
      return this.boolRewrite;
   }

   public Integer getPurchaseStatus() {
      return this.purchaseStatus;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public Boolean getBoolTemporaryStorage() {
      return this.boolTemporaryStorage;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public LocalDateTime getReviewPassTime() {
      return this.reviewPassTime;
   }

   public Boolean getBoolDetail() {
      return this.boolDetail;
   }

   public String getApplyPurchaseStatus() {
      return this.applyPurchaseStatus;
   }

   public List<ScmLumpSumSystemPurchaseOrderDetailDTOParam> getList() {
      return this.list;
   }

   public Integer getDataStatus() {
      return this.dataStatus;
   }

   public String getCause() {
      return this.cause;
   }

   public Long getApproveRecordIdNow() {
      return this.approveRecordIdNow;
   }

   public String getApproveRecordIds() {
      return this.approveRecordIds;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumberParent(final String serialNumberParent) {
      this.serialNumberParent = serialNumberParent;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setPurchaseType(final Integer purchaseType) {
      this.purchaseType = purchaseType;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   public void setLastOperatorNameId(final Long lastOperatorNameId) {
      this.lastOperatorNameId = lastOperatorNameId;
   }

   public void setLastOperatorName(final String lastOperatorName) {
      this.lastOperatorName = lastOperatorName;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setAuxMaterialIds(final List<Long> auxMaterialIds) {
      this.auxMaterialIds = auxMaterialIds;
   }

   public void setOtherMaterialIds(final List<Long> otherMaterialIds) {
      this.otherMaterialIds = otherMaterialIds;
   }

   public void setGasMaterialIds(final List<Long> gasMaterialIds) {
      this.gasMaterialIds = gasMaterialIds;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setLogisticsPayerType(final Integer logisticsPayerType) {
      this.logisticsPayerType = logisticsPayerType;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setMeteUnit(final String meteUnit) {
      this.meteUnit = meteUnit;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setEditable(final Boolean editable) {
      this.editable = editable;
   }

   public void setBoolRewrite(final Boolean boolRewrite) {
      this.boolRewrite = boolRewrite;
   }

   public void setPurchaseStatus(final Integer purchaseStatus) {
      this.purchaseStatus = purchaseStatus;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setBoolTemporaryStorage(final Boolean boolTemporaryStorage) {
      this.boolTemporaryStorage = boolTemporaryStorage;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setReviewPassTime(final LocalDateTime reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
   }

   public void setBoolDetail(final Boolean boolDetail) {
      this.boolDetail = boolDetail;
   }

   public void setApplyPurchaseStatus(final String applyPurchaseStatus) {
      this.applyPurchaseStatus = applyPurchaseStatus;
   }

   public void setList(final List<ScmLumpSumSystemPurchaseOrderDetailDTOParam> list) {
      this.list = list;
   }

   public void setDataStatus(final Integer dataStatus) {
      this.dataStatus = dataStatus;
   }

   public void setCause(final String cause) {
      this.cause = cause;
   }

   public void setApproveRecordIdNow(final Long approveRecordIdNow) {
      this.approveRecordIdNow = approveRecordIdNow;
   }

   public void setApproveRecordIds(final String approveRecordIds) {
      this.approveRecordIds = approveRecordIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScmLumpSumSystemPurchaseOrderDTOParam)) {
         return false;
      }

      ScmLumpSumSystemPurchaseOrderDTOParam other = (ScmLumpSumSystemPurchaseOrderDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectManagerId = this.getProjectManagerId();
         Object other$projectManagerId = other.getProjectManagerId();
         if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
            Object this$applicantId = this.getApplicantId();
            Object other$applicantId = other.getApplicantId();
            if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$materialType = this.getMaterialType();
                  Object other$materialType = other.getMaterialType();
                  if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
                     Object this$purchaseType = this.getPurchaseType();
                     Object other$purchaseType = other.getPurchaseType();
                     if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
                        Object this$projectId = this.getProjectId();
                        Object other$projectId = other.getProjectId();
                        if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                           Object this$lastOperatorNameId = this.getLastOperatorNameId();
                           Object other$lastOperatorNameId = other.getLastOperatorNameId();
                           if (this$lastOperatorNameId == null ? other$lastOperatorNameId == null : this$lastOperatorNameId.equals(other$lastOperatorNameId)) {
                              Object this$supplierId = this.getSupplierId();
                              Object other$supplierId = other.getSupplierId();
                              if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                 Object this$branchCompanyId = this.getBranchCompanyId();
                                 Object other$branchCompanyId = other.getBranchCompanyId();
                                 if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                                    Object this$logisticsPayerType = this.getLogisticsPayerType();
                                    Object other$logisticsPayerType = other.getLogisticsPayerType();
                                    if (this$logisticsPayerType == null
                                       ? other$logisticsPayerType == null
                                       : this$logisticsPayerType.equals(other$logisticsPayerType)) {
                                       Object this$invoiceType = this.getInvoiceType();
                                       Object other$invoiceType = other.getInvoiceType();
                                       if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                          Object this$editable = this.getEditable();
                                          Object other$editable = other.getEditable();
                                          if (this$editable == null ? other$editable == null : this$editable.equals(other$editable)) {
                                             Object this$boolRewrite = this.getBoolRewrite();
                                             Object other$boolRewrite = other.getBoolRewrite();
                                             if (this$boolRewrite == null ? other$boolRewrite == null : this$boolRewrite.equals(other$boolRewrite)) {
                                                Object this$purchaseStatus = this.getPurchaseStatus();
                                                Object other$purchaseStatus = other.getPurchaseStatus();
                                                if (this$purchaseStatus == null
                                                   ? other$purchaseStatus == null
                                                   : this$purchaseStatus.equals(other$purchaseStatus)) {
                                                   Object this$settlementStatus = this.getSettlementStatus();
                                                   Object other$settlementStatus = other.getSettlementStatus();
                                                   if (this$settlementStatus == null
                                                      ? other$settlementStatus == null
                                                      : this$settlementStatus.equals(other$settlementStatus)) {
                                                      Object this$boolTemporaryStorage = this.getBoolTemporaryStorage();
                                                      Object other$boolTemporaryStorage = other.getBoolTemporaryStorage();
                                                      if (this$boolTemporaryStorage == null
                                                         ? other$boolTemporaryStorage == null
                                                         : this$boolTemporaryStorage.equals(other$boolTemporaryStorage)) {
                                                         Object this$reviewStatus = this.getReviewStatus();
                                                         Object other$reviewStatus = other.getReviewStatus();
                                                         if (this$reviewStatus == null
                                                            ? other$reviewStatus == null
                                                            : this$reviewStatus.equals(other$reviewStatus)) {
                                                            Object this$boolDetail = this.getBoolDetail();
                                                            Object other$boolDetail = other.getBoolDetail();
                                                            if (this$boolDetail == null ? other$boolDetail == null : this$boolDetail.equals(other$boolDetail)) {
                                                               Object this$dataStatus = this.getDataStatus();
                                                               Object other$dataStatus = other.getDataStatus();
                                                               if (this$dataStatus == null
                                                                  ? other$dataStatus == null
                                                                  : this$dataStatus.equals(other$dataStatus)) {
                                                                  Object this$approveRecordIdNow = this.getApproveRecordIdNow();
                                                                  Object other$approveRecordIdNow = other.getApproveRecordIdNow();
                                                                  if (this$approveRecordIdNow == null
                                                                     ? other$approveRecordIdNow == null
                                                                     : this$approveRecordIdNow.equals(other$approveRecordIdNow)) {
                                                                     Object this$serialNumberParent = this.getSerialNumberParent();
                                                                     Object other$serialNumberParent = other.getSerialNumberParent();
                                                                     if (this$serialNumberParent == null
                                                                        ? other$serialNumberParent == null
                                                                        : this$serialNumberParent.equals(other$serialNumberParent)) {
                                                                        Object this$serialNumber = this.getSerialNumber();
                                                                        Object other$serialNumber = other.getSerialNumber();
                                                                        if (this$serialNumber == null
                                                                           ? other$serialNumber == null
                                                                           : this$serialNumber.equals(other$serialNumber)) {
                                                                           Object this$applicantName = this.getApplicantName();
                                                                           Object other$applicantName = other.getApplicantName();
                                                                           if (this$applicantName == null
                                                                              ? other$applicantName == null
                                                                              : this$applicantName.equals(other$applicantName)) {
                                                                              Object this$userUpdateTime = this.getUserUpdateTime();
                                                                              Object other$userUpdateTime = other.getUserUpdateTime();
                                                                              if (this$userUpdateTime == null
                                                                                 ? other$userUpdateTime == null
                                                                                 : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                                                 Object this$lastOperatorName = this.getLastOperatorName();
                                                                                 Object other$lastOperatorName = other.getLastOperatorName();
                                                                                 if (this$lastOperatorName == null
                                                                                    ? other$lastOperatorName == null
                                                                                    : this$lastOperatorName.equals(other$lastOperatorName)) {
                                                                                    Object this$auxMaterialIds = this.getAuxMaterialIds();
                                                                                    Object other$auxMaterialIds = other.getAuxMaterialIds();
                                                                                    if (this$auxMaterialIds == null
                                                                                       ? other$auxMaterialIds == null
                                                                                       : this$auxMaterialIds.equals(other$auxMaterialIds)) {
                                                                                       Object this$otherMaterialIds = this.getOtherMaterialIds();
                                                                                       Object other$otherMaterialIds = other.getOtherMaterialIds();
                                                                                       if (this$otherMaterialIds == null
                                                                                          ? other$otherMaterialIds == null
                                                                                          : this$otherMaterialIds.equals(other$otherMaterialIds)) {
                                                                                          Object this$gasMaterialIds = this.getGasMaterialIds();
                                                                                          Object other$gasMaterialIds = other.getGasMaterialIds();
                                                                                          if (this$gasMaterialIds == null
                                                                                             ? other$gasMaterialIds == null
                                                                                             : this$gasMaterialIds.equals(other$gasMaterialIds)) {
                                                                                             Object this$mete = this.getMete();
                                                                                             Object other$mete = other.getMete();
                                                                                             if (this$mete == null
                                                                                                ? other$mete == null
                                                                                                : this$mete.equals(other$mete)) {
                                                                                                Object this$meteUnit = this.getMeteUnit();
                                                                                                Object other$meteUnit = other.getMeteUnit();
                                                                                                if (this$meteUnit == null
                                                                                                   ? other$meteUnit == null
                                                                                                   : this$meteUnit.equals(other$meteUnit)) {
                                                                                                   Object this$amount = this.getAmount();
                                                                                                   Object other$amount = other.getAmount();
                                                                                                   if (this$amount == null
                                                                                                      ? other$amount == null
                                                                                                      : this$amount.equals(other$amount)) {
                                                                                                      Object this$taxRate = this.getTaxRate();
                                                                                                      Object other$taxRate = other.getTaxRate();
                                                                                                      if (this$taxRate == null
                                                                                                         ? other$taxRate == null
                                                                                                         : this$taxRate.equals(other$taxRate)) {
                                                                                                         Object this$attachmentIds = this.getAttachmentIds();
                                                                                                         Object other$attachmentIds = other.getAttachmentIds();
                                                                                                         if (this$attachmentIds == null
                                                                                                            ? other$attachmentIds == null
                                                                                                            : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                                            Object this$remark = this.getRemark();
                                                                                                            Object other$remark = other.getRemark();
                                                                                                            if (this$remark == null
                                                                                                               ? other$remark == null
                                                                                                               : this$remark.equals(other$remark)) {
                                                                                                               Object this$reviewPassTime = this.getReviewPassTime();
                                                                                                               Object other$reviewPassTime = other.getReviewPassTime();
                                                                                                               if (this$reviewPassTime == null
                                                                                                                  ? other$reviewPassTime == null
                                                                                                                  : this$reviewPassTime.equals(
                                                                                                                     other$reviewPassTime
                                                                                                                  )) {
                                                                                                                  Object this$applyPurchaseStatus = this.getApplyPurchaseStatus();
                                                                                                                  Object other$applyPurchaseStatus = other.getApplyPurchaseStatus();
                                                                                                                  if (this$applyPurchaseStatus == null
                                                                                                                     ? other$applyPurchaseStatus == null
                                                                                                                     : this$applyPurchaseStatus.equals(
                                                                                                                        other$applyPurchaseStatus
                                                                                                                     )) {
                                                                                                                     Object this$list = this.getList();
                                                                                                                     Object other$list = other.getList();
                                                                                                                     if (this$list == null
                                                                                                                        ? other$list == null
                                                                                                                        : this$list.equals(other$list)) {
                                                                                                                        Object this$cause = this.getCause();
                                                                                                                        Object other$cause = other.getCause();
                                                                                                                        if (this$cause == null
                                                                                                                           ? other$cause == null
                                                                                                                           : this$cause.equals(other$cause)) {
                                                                                                                           Object this$approveRecordIds = this.getApproveRecordIds();
                                                                                                                           Object other$approveRecordIds = other.getApproveRecordIds();
                                                                                                                           return this$approveRecordIds == null
                                                                                                                              ? other$approveRecordIds == null
                                                                                                                              : this$approveRecordIds.equals(
                                                                                                                                 other$approveRecordIds
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ScmLumpSumSystemPurchaseOrderDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $lastOperatorNameId = this.getLastOperatorNameId();
      result = result * 59 + ($lastOperatorNameId == null ? 43 : $lastOperatorNameId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $logisticsPayerType = this.getLogisticsPayerType();
      result = result * 59 + ($logisticsPayerType == null ? 43 : $logisticsPayerType.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $editable = this.getEditable();
      result = result * 59 + ($editable == null ? 43 : $editable.hashCode());
      Object $boolRewrite = this.getBoolRewrite();
      result = result * 59 + ($boolRewrite == null ? 43 : $boolRewrite.hashCode());
      Object $purchaseStatus = this.getPurchaseStatus();
      result = result * 59 + ($purchaseStatus == null ? 43 : $purchaseStatus.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $boolTemporaryStorage = this.getBoolTemporaryStorage();
      result = result * 59 + ($boolTemporaryStorage == null ? 43 : $boolTemporaryStorage.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $boolDetail = this.getBoolDetail();
      result = result * 59 + ($boolDetail == null ? 43 : $boolDetail.hashCode());
      Object $dataStatus = this.getDataStatus();
      result = result * 59 + ($dataStatus == null ? 43 : $dataStatus.hashCode());
      Object $approveRecordIdNow = this.getApproveRecordIdNow();
      result = result * 59 + ($approveRecordIdNow == null ? 43 : $approveRecordIdNow.hashCode());
      Object $serialNumberParent = this.getSerialNumberParent();
      result = result * 59 + ($serialNumberParent == null ? 43 : $serialNumberParent.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $lastOperatorName = this.getLastOperatorName();
      result = result * 59 + ($lastOperatorName == null ? 43 : $lastOperatorName.hashCode());
      Object $auxMaterialIds = this.getAuxMaterialIds();
      result = result * 59 + ($auxMaterialIds == null ? 43 : $auxMaterialIds.hashCode());
      Object $otherMaterialIds = this.getOtherMaterialIds();
      result = result * 59 + ($otherMaterialIds == null ? 43 : $otherMaterialIds.hashCode());
      Object $gasMaterialIds = this.getGasMaterialIds();
      result = result * 59 + ($gasMaterialIds == null ? 43 : $gasMaterialIds.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $meteUnit = this.getMeteUnit();
      result = result * 59 + ($meteUnit == null ? 43 : $meteUnit.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $applyPurchaseStatus = this.getApplyPurchaseStatus();
      result = result * 59 + ($applyPurchaseStatus == null ? 43 : $applyPurchaseStatus.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $cause = this.getCause();
      result = result * 59 + ($cause == null ? 43 : $cause.hashCode());
      Object $approveRecordIds = this.getApproveRecordIds();
      return result * 59 + ($approveRecordIds == null ? 43 : $approveRecordIds.hashCode());
   }

   @Override
   public String toString() {
      return "ScmLumpSumSystemPurchaseOrderDTOParam(id="
         + this.getId()
         + ", serialNumberParent="
         + this.getSerialNumberParent()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", basicClass="
         + this.getBasicClass()
         + ", materialType="
         + this.getMaterialType()
         + ", purchaseType="
         + this.getPurchaseType()
         + ", projectId="
         + this.getProjectId()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", lastOperatorNameId="
         + this.getLastOperatorNameId()
         + ", lastOperatorName="
         + this.getLastOperatorName()
         + ", supplierId="
         + this.getSupplierId()
         + ", auxMaterialIds="
         + this.getAuxMaterialIds()
         + ", otherMaterialIds="
         + this.getOtherMaterialIds()
         + ", gasMaterialIds="
         + this.getGasMaterialIds()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", logisticsPayerType="
         + this.getLogisticsPayerType()
         + ", mete="
         + this.getMete()
         + ", meteUnit="
         + this.getMeteUnit()
         + ", amount="
         + this.getAmount()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", editable="
         + this.getEditable()
         + ", boolRewrite="
         + this.getBoolRewrite()
         + ", purchaseStatus="
         + this.getPurchaseStatus()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", boolTemporaryStorage="
         + this.getBoolTemporaryStorage()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", boolDetail="
         + this.getBoolDetail()
         + ", applyPurchaseStatus="
         + this.getApplyPurchaseStatus()
         + ", list="
         + this.getList()
         + ", dataStatus="
         + this.getDataStatus()
         + ", cause="
         + this.getCause()
         + ", approveRecordIdNow="
         + this.getApproveRecordIdNow()
         + ", approveRecordIds="
         + this.getApproveRecordIds()
         + ")";
   }
}
