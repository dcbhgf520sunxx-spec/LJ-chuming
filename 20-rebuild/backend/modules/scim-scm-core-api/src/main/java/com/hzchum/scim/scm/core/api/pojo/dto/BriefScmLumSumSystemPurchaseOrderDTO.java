package com.hzchum.scim.scm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.system.core.api.pojo.dto.PurchaseOrderBranchCompanyDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class BriefScmLumSumSystemPurchaseOrderDTO {
   private Long id;
   private LocalDateTime createTime;
   private Integer settlementStatus;
   private Integer purchaseStatus;
   private Integer basicClass;
   private Integer materialType;
   private Integer purchaseType;
   private String serialNumber;
   private String serialNumberParent;
   private BigDecimal mete;
   private String meteUnit;
   private BigDecimal amount;
   private BigDecimal taxRate;
   private Integer invoiceType;
   private Integer logisticsPayerType;
   private ProjectInfoDTO projects;
   private SupplierAllBriefDTO supplier;
   private Long projectManagerId;
   private String projectManagerName;
   private PurchaseOrderBranchCompanyDTO purchaseOrderBranchCompanyDTO;
   private List<Long> auxMaterialIds;
   private List<Long> otherMaterialIds;
   private List<Long> gasMaterialIds;
   private Long applicantId;
   private String applicantName;
   private Long lastOperatorNameId;
   private String lastOperatorName;
   private LocalDateTime userUpdateTime;
   private List<AttachmentDTO> attachments;
   private Integer reviewStatus;
   private Boolean boolTemporaryStorage;
   private String remark;
   private Boolean boolDetail;
   private Boolean editable;
   private List<ScmLumpSumSystemPurchaseOrderDetailDTO> details;
   private Integer dataStatus;
   private List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS;
   private Long approveRecordIdNow;
   private String approveRecordIds;

   public static BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder builder() {
      return new BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public Integer getPurchaseStatus() {
      return this.purchaseStatus;
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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSerialNumberParent() {
      return this.serialNumberParent;
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

   public Integer getLogisticsPayerType() {
      return this.logisticsPayerType;
   }

   public ProjectInfoDTO getProjects() {
      return this.projects;
   }

   public SupplierAllBriefDTO getSupplier() {
      return this.supplier;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public PurchaseOrderBranchCompanyDTO getPurchaseOrderBranchCompanyDTO() {
      return this.purchaseOrderBranchCompanyDTO;
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

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getLastOperatorNameId() {
      return this.lastOperatorNameId;
   }

   public String getLastOperatorName() {
      return this.lastOperatorName;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Boolean getBoolTemporaryStorage() {
      return this.boolTemporaryStorage;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolDetail() {
      return this.boolDetail;
   }

   public Boolean getEditable() {
      return this.editable;
   }

   public List<ScmLumpSumSystemPurchaseOrderDetailDTO> getDetails() {
      return this.details;
   }

   public Integer getDataStatus() {
      return this.dataStatus;
   }

   public List<WmsApproveRecordFlowDTO> getWmsApproveRecordFlowDTOS() {
      return this.wmsApproveRecordFlowDTOS;
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

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setPurchaseStatus(final Integer purchaseStatus) {
      this.purchaseStatus = purchaseStatus;
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

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSerialNumberParent(final String serialNumberParent) {
      this.serialNumberParent = serialNumberParent;
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

   public void setLogisticsPayerType(final Integer logisticsPayerType) {
      this.logisticsPayerType = logisticsPayerType;
   }

   public void setProjects(final ProjectInfoDTO projects) {
      this.projects = projects;
   }

   public void setSupplier(final SupplierAllBriefDTO supplier) {
      this.supplier = supplier;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setPurchaseOrderBranchCompanyDTO(final PurchaseOrderBranchCompanyDTO purchaseOrderBranchCompanyDTO) {
      this.purchaseOrderBranchCompanyDTO = purchaseOrderBranchCompanyDTO;
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

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setLastOperatorNameId(final Long lastOperatorNameId) {
      this.lastOperatorNameId = lastOperatorNameId;
   }

   public void setLastOperatorName(final String lastOperatorName) {
      this.lastOperatorName = lastOperatorName;
   }

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setBoolTemporaryStorage(final Boolean boolTemporaryStorage) {
      this.boolTemporaryStorage = boolTemporaryStorage;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBoolDetail(final Boolean boolDetail) {
      this.boolDetail = boolDetail;
   }

   public void setEditable(final Boolean editable) {
      this.editable = editable;
   }

   public void setDetails(final List<ScmLumpSumSystemPurchaseOrderDetailDTO> details) {
      this.details = details;
   }

   public void setDataStatus(final Integer dataStatus) {
      this.dataStatus = dataStatus;
   }

   public void setWmsApproveRecordFlowDTOS(final List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS) {
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
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

      if (!(o instanceof BriefScmLumSumSystemPurchaseOrderDTO)) {
         return false;
      }

      BriefScmLumSumSystemPurchaseOrderDTO other = (BriefScmLumSumSystemPurchaseOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$settlementStatus = this.getSettlementStatus();
         Object other$settlementStatus = other.getSettlementStatus();
         if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
            Object this$purchaseStatus = this.getPurchaseStatus();
            Object other$purchaseStatus = other.getPurchaseStatus();
            if (this$purchaseStatus == null ? other$purchaseStatus == null : this$purchaseStatus.equals(other$purchaseStatus)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$materialType = this.getMaterialType();
                  Object other$materialType = other.getMaterialType();
                  if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
                     Object this$purchaseType = this.getPurchaseType();
                     Object other$purchaseType = other.getPurchaseType();
                     if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
                        Object this$invoiceType = this.getInvoiceType();
                        Object other$invoiceType = other.getInvoiceType();
                        if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                           Object this$logisticsPayerType = this.getLogisticsPayerType();
                           Object other$logisticsPayerType = other.getLogisticsPayerType();
                           if (this$logisticsPayerType == null ? other$logisticsPayerType == null : this$logisticsPayerType.equals(other$logisticsPayerType)) {
                              Object this$projectManagerId = this.getProjectManagerId();
                              Object other$projectManagerId = other.getProjectManagerId();
                              if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                                 Object this$applicantId = this.getApplicantId();
                                 Object other$applicantId = other.getApplicantId();
                                 if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                                    Object this$lastOperatorNameId = this.getLastOperatorNameId();
                                    Object other$lastOperatorNameId = other.getLastOperatorNameId();
                                    if (this$lastOperatorNameId == null
                                       ? other$lastOperatorNameId == null
                                       : this$lastOperatorNameId.equals(other$lastOperatorNameId)) {
                                       Object this$reviewStatus = this.getReviewStatus();
                                       Object other$reviewStatus = other.getReviewStatus();
                                       if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                                          Object this$boolTemporaryStorage = this.getBoolTemporaryStorage();
                                          Object other$boolTemporaryStorage = other.getBoolTemporaryStorage();
                                          if (this$boolTemporaryStorage == null
                                             ? other$boolTemporaryStorage == null
                                             : this$boolTemporaryStorage.equals(other$boolTemporaryStorage)) {
                                             Object this$boolDetail = this.getBoolDetail();
                                             Object other$boolDetail = other.getBoolDetail();
                                             if (this$boolDetail == null ? other$boolDetail == null : this$boolDetail.equals(other$boolDetail)) {
                                                Object this$editable = this.getEditable();
                                                Object other$editable = other.getEditable();
                                                if (this$editable == null ? other$editable == null : this$editable.equals(other$editable)) {
                                                   Object this$dataStatus = this.getDataStatus();
                                                   Object other$dataStatus = other.getDataStatus();
                                                   if (this$dataStatus == null ? other$dataStatus == null : this$dataStatus.equals(other$dataStatus)) {
                                                      Object this$approveRecordIdNow = this.getApproveRecordIdNow();
                                                      Object other$approveRecordIdNow = other.getApproveRecordIdNow();
                                                      if (this$approveRecordIdNow == null
                                                         ? other$approveRecordIdNow == null
                                                         : this$approveRecordIdNow.equals(other$approveRecordIdNow)) {
                                                         Object this$createTime = this.getCreateTime();
                                                         Object other$createTime = other.getCreateTime();
                                                         if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                            Object this$serialNumber = this.getSerialNumber();
                                                            Object other$serialNumber = other.getSerialNumber();
                                                            if (this$serialNumber == null
                                                               ? other$serialNumber == null
                                                               : this$serialNumber.equals(other$serialNumber)) {
                                                               Object this$serialNumberParent = this.getSerialNumberParent();
                                                               Object other$serialNumberParent = other.getSerialNumberParent();
                                                               if (this$serialNumberParent == null
                                                                  ? other$serialNumberParent == null
                                                                  : this$serialNumberParent.equals(other$serialNumberParent)) {
                                                                  Object this$mete = this.getMete();
                                                                  Object other$mete = other.getMete();
                                                                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                     Object this$meteUnit = this.getMeteUnit();
                                                                     Object other$meteUnit = other.getMeteUnit();
                                                                     if (this$meteUnit == null ? other$meteUnit == null : this$meteUnit.equals(other$meteUnit)) {
                                                                        Object this$amount = this.getAmount();
                                                                        Object other$amount = other.getAmount();
                                                                        if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                           Object this$taxRate = this.getTaxRate();
                                                                           Object other$taxRate = other.getTaxRate();
                                                                           if (this$taxRate == null
                                                                              ? other$taxRate == null
                                                                              : this$taxRate.equals(other$taxRate)) {
                                                                              Object this$projects = this.getProjects();
                                                                              Object other$projects = other.getProjects();
                                                                              if (this$projects == null
                                                                                 ? other$projects == null
                                                                                 : this$projects.equals(other$projects)) {
                                                                                 Object this$supplier = this.getSupplier();
                                                                                 Object other$supplier = other.getSupplier();
                                                                                 if (this$supplier == null
                                                                                    ? other$supplier == null
                                                                                    : this$supplier.equals(other$supplier)) {
                                                                                    Object this$projectManagerName = this.getProjectManagerName();
                                                                                    Object other$projectManagerName = other.getProjectManagerName();
                                                                                    if (this$projectManagerName == null
                                                                                       ? other$projectManagerName == null
                                                                                       : this$projectManagerName.equals(other$projectManagerName)) {
                                                                                       Object this$purchaseOrderBranchCompanyDTO = this.getPurchaseOrderBranchCompanyDTO();
                                                                                       Object other$purchaseOrderBranchCompanyDTO = other.getPurchaseOrderBranchCompanyDTO();
                                                                                       if (this$purchaseOrderBranchCompanyDTO == null
                                                                                          ? other$purchaseOrderBranchCompanyDTO == null
                                                                                          : this$purchaseOrderBranchCompanyDTO.equals(
                                                                                             other$purchaseOrderBranchCompanyDTO
                                                                                          )) {
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
                                                                                                   Object this$applicantName = this.getApplicantName();
                                                                                                   Object other$applicantName = other.getApplicantName();
                                                                                                   if (this$applicantName == null
                                                                                                      ? other$applicantName == null
                                                                                                      : this$applicantName.equals(other$applicantName)) {
                                                                                                      Object this$lastOperatorName = this.getLastOperatorName();
                                                                                                      Object other$lastOperatorName = other.getLastOperatorName();
                                                                                                      if (this$lastOperatorName == null
                                                                                                         ? other$lastOperatorName == null
                                                                                                         : this$lastOperatorName.equals(other$lastOperatorName)
                                                                                                         )
                                                                                                       {
                                                                                                         Object this$userUpdateTime = this.getUserUpdateTime();
                                                                                                         Object other$userUpdateTime = other.getUserUpdateTime();
                                                                                                         if (this$userUpdateTime == null
                                                                                                            ? other$userUpdateTime == null
                                                                                                            : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                                                                            Object this$attachments = this.getAttachments();
                                                                                                            Object other$attachments = other.getAttachments();
                                                                                                            if (this$attachments == null
                                                                                                               ? other$attachments == null
                                                                                                               : this$attachments.equals(other$attachments)) {
                                                                                                               Object this$remark = this.getRemark();
                                                                                                               Object other$remark = other.getRemark();
                                                                                                               if (this$remark == null
                                                                                                                  ? other$remark == null
                                                                                                                  : this$remark.equals(other$remark)) {
                                                                                                                  Object this$details = this.getDetails();
                                                                                                                  Object other$details = other.getDetails();
                                                                                                                  if (this$details == null
                                                                                                                     ? other$details == null
                                                                                                                     : this$details.equals(other$details)) {
                                                                                                                     Object this$wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
                                                                                                                     Object other$wmsApproveRecordFlowDTOS = other.getWmsApproveRecordFlowDTOS();
                                                                                                                     if (this$wmsApproveRecordFlowDTOS == null
                                                                                                                        ? other$wmsApproveRecordFlowDTOS
                                                                                                                           == null
                                                                                                                        : this$wmsApproveRecordFlowDTOS.equals(
                                                                                                                           other$wmsApproveRecordFlowDTOS
                                                                                                                        )) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BriefScmLumSumSystemPurchaseOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $purchaseStatus = this.getPurchaseStatus();
      result = result * 59 + ($purchaseStatus == null ? 43 : $purchaseStatus.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $logisticsPayerType = this.getLogisticsPayerType();
      result = result * 59 + ($logisticsPayerType == null ? 43 : $logisticsPayerType.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $lastOperatorNameId = this.getLastOperatorNameId();
      result = result * 59 + ($lastOperatorNameId == null ? 43 : $lastOperatorNameId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $boolTemporaryStorage = this.getBoolTemporaryStorage();
      result = result * 59 + ($boolTemporaryStorage == null ? 43 : $boolTemporaryStorage.hashCode());
      Object $boolDetail = this.getBoolDetail();
      result = result * 59 + ($boolDetail == null ? 43 : $boolDetail.hashCode());
      Object $editable = this.getEditable();
      result = result * 59 + ($editable == null ? 43 : $editable.hashCode());
      Object $dataStatus = this.getDataStatus();
      result = result * 59 + ($dataStatus == null ? 43 : $dataStatus.hashCode());
      Object $approveRecordIdNow = this.getApproveRecordIdNow();
      result = result * 59 + ($approveRecordIdNow == null ? 43 : $approveRecordIdNow.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $serialNumberParent = this.getSerialNumberParent();
      result = result * 59 + ($serialNumberParent == null ? 43 : $serialNumberParent.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $meteUnit = this.getMeteUnit();
      result = result * 59 + ($meteUnit == null ? 43 : $meteUnit.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $purchaseOrderBranchCompanyDTO = this.getPurchaseOrderBranchCompanyDTO();
      result = result * 59 + ($purchaseOrderBranchCompanyDTO == null ? 43 : $purchaseOrderBranchCompanyDTO.hashCode());
      Object $auxMaterialIds = this.getAuxMaterialIds();
      result = result * 59 + ($auxMaterialIds == null ? 43 : $auxMaterialIds.hashCode());
      Object $otherMaterialIds = this.getOtherMaterialIds();
      result = result * 59 + ($otherMaterialIds == null ? 43 : $otherMaterialIds.hashCode());
      Object $gasMaterialIds = this.getGasMaterialIds();
      result = result * 59 + ($gasMaterialIds == null ? 43 : $gasMaterialIds.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $lastOperatorName = this.getLastOperatorName();
      result = result * 59 + ($lastOperatorName == null ? 43 : $lastOperatorName.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $details = this.getDetails();
      result = result * 59 + ($details == null ? 43 : $details.hashCode());
      Object $wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
      result = result * 59 + ($wmsApproveRecordFlowDTOS == null ? 43 : $wmsApproveRecordFlowDTOS.hashCode());
      Object $approveRecordIds = this.getApproveRecordIds();
      return result * 59 + ($approveRecordIds == null ? 43 : $approveRecordIds.hashCode());
   }

   @Override
   public String toString() {
      return "BriefScmLumSumSystemPurchaseOrderDTO(id="
         + this.getId()
         + ", createTime="
         + this.getCreateTime()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", purchaseStatus="
         + this.getPurchaseStatus()
         + ", basicClass="
         + this.getBasicClass()
         + ", materialType="
         + this.getMaterialType()
         + ", purchaseType="
         + this.getPurchaseType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", serialNumberParent="
         + this.getSerialNumberParent()
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
         + ", logisticsPayerType="
         + this.getLogisticsPayerType()
         + ", projects="
         + this.getProjects()
         + ", supplier="
         + this.getSupplier()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", purchaseOrderBranchCompanyDTO="
         + this.getPurchaseOrderBranchCompanyDTO()
         + ", auxMaterialIds="
         + this.getAuxMaterialIds()
         + ", otherMaterialIds="
         + this.getOtherMaterialIds()
         + ", gasMaterialIds="
         + this.getGasMaterialIds()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", lastOperatorNameId="
         + this.getLastOperatorNameId()
         + ", lastOperatorName="
         + this.getLastOperatorName()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", attachments="
         + this.getAttachments()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", boolTemporaryStorage="
         + this.getBoolTemporaryStorage()
         + ", remark="
         + this.getRemark()
         + ", boolDetail="
         + this.getBoolDetail()
         + ", editable="
         + this.getEditable()
         + ", details="
         + this.getDetails()
         + ", dataStatus="
         + this.getDataStatus()
         + ", wmsApproveRecordFlowDTOS="
         + this.getWmsApproveRecordFlowDTOS()
         + ", approveRecordIdNow="
         + this.getApproveRecordIdNow()
         + ", approveRecordIds="
         + this.getApproveRecordIds()
         + ")";
   }

   public BriefScmLumSumSystemPurchaseOrderDTO(
      final Long id,
      final LocalDateTime createTime,
      final Integer settlementStatus,
      final Integer purchaseStatus,
      final Integer basicClass,
      final Integer materialType,
      final Integer purchaseType,
      final String serialNumber,
      final String serialNumberParent,
      final BigDecimal mete,
      final String meteUnit,
      final BigDecimal amount,
      final BigDecimal taxRate,
      final Integer invoiceType,
      final Integer logisticsPayerType,
      final ProjectInfoDTO projects,
      final SupplierAllBriefDTO supplier,
      final Long projectManagerId,
      final String projectManagerName,
      final PurchaseOrderBranchCompanyDTO purchaseOrderBranchCompanyDTO,
      final List<Long> auxMaterialIds,
      final List<Long> otherMaterialIds,
      final List<Long> gasMaterialIds,
      final Long applicantId,
      final String applicantName,
      final Long lastOperatorNameId,
      final String lastOperatorName,
      final LocalDateTime userUpdateTime,
      final List<AttachmentDTO> attachments,
      final Integer reviewStatus,
      final Boolean boolTemporaryStorage,
      final String remark,
      final Boolean boolDetail,
      final Boolean editable,
      final List<ScmLumpSumSystemPurchaseOrderDetailDTO> details,
      final Integer dataStatus,
      final List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS,
      final Long approveRecordIdNow,
      final String approveRecordIds
   ) {
      this.id = id;
      this.createTime = createTime;
      this.settlementStatus = settlementStatus;
      this.purchaseStatus = purchaseStatus;
      this.basicClass = basicClass;
      this.materialType = materialType;
      this.purchaseType = purchaseType;
      this.serialNumber = serialNumber;
      this.serialNumberParent = serialNumberParent;
      this.mete = mete;
      this.meteUnit = meteUnit;
      this.amount = amount;
      this.taxRate = taxRate;
      this.invoiceType = invoiceType;
      this.logisticsPayerType = logisticsPayerType;
      this.projects = projects;
      this.supplier = supplier;
      this.projectManagerId = projectManagerId;
      this.projectManagerName = projectManagerName;
      this.purchaseOrderBranchCompanyDTO = purchaseOrderBranchCompanyDTO;
      this.auxMaterialIds = auxMaterialIds;
      this.otherMaterialIds = otherMaterialIds;
      this.gasMaterialIds = gasMaterialIds;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.lastOperatorNameId = lastOperatorNameId;
      this.lastOperatorName = lastOperatorName;
      this.userUpdateTime = userUpdateTime;
      this.attachments = attachments;
      this.reviewStatus = reviewStatus;
      this.boolTemporaryStorage = boolTemporaryStorage;
      this.remark = remark;
      this.boolDetail = boolDetail;
      this.editable = editable;
      this.details = details;
      this.dataStatus = dataStatus;
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
      this.approveRecordIdNow = approveRecordIdNow;
      this.approveRecordIds = approveRecordIds;
   }

   public BriefScmLumSumSystemPurchaseOrderDTO() {
   }

   public static class BriefScmLumSumSystemPurchaseOrderDTOBuilder {
      private Long id;
      private LocalDateTime createTime;
      private Integer settlementStatus;
      private Integer purchaseStatus;
      private Integer basicClass;
      private Integer materialType;
      private Integer purchaseType;
      private String serialNumber;
      private String serialNumberParent;
      private BigDecimal mete;
      private String meteUnit;
      private BigDecimal amount;
      private BigDecimal taxRate;
      private Integer invoiceType;
      private Integer logisticsPayerType;
      private ProjectInfoDTO projects;
      private SupplierAllBriefDTO supplier;
      private Long projectManagerId;
      private String projectManagerName;
      private PurchaseOrderBranchCompanyDTO purchaseOrderBranchCompanyDTO;
      private List<Long> auxMaterialIds;
      private List<Long> otherMaterialIds;
      private List<Long> gasMaterialIds;
      private Long applicantId;
      private String applicantName;
      private Long lastOperatorNameId;
      private String lastOperatorName;
      private LocalDateTime userUpdateTime;
      private List<AttachmentDTO> attachments;
      private Integer reviewStatus;
      private Boolean boolTemporaryStorage;
      private String remark;
      private Boolean boolDetail;
      private Boolean editable;
      private List<ScmLumpSumSystemPurchaseOrderDetailDTO> details;
      private Integer dataStatus;
      private List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS;
      private Long approveRecordIdNow;
      private String approveRecordIds;

      BriefScmLumSumSystemPurchaseOrderDTOBuilder() {
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder purchaseStatus(final Integer purchaseStatus) {
         this.purchaseStatus = purchaseStatus;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder purchaseType(final Integer purchaseType) {
         this.purchaseType = purchaseType;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder serialNumberParent(final String serialNumberParent) {
         this.serialNumberParent = serialNumberParent;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder meteUnit(final String meteUnit) {
         this.meteUnit = meteUnit;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder logisticsPayerType(final Integer logisticsPayerType) {
         this.logisticsPayerType = logisticsPayerType;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder projects(final ProjectInfoDTO projects) {
         this.projects = projects;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder supplier(final SupplierAllBriefDTO supplier) {
         this.supplier = supplier;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder purchaseOrderBranchCompanyDTO(
         final PurchaseOrderBranchCompanyDTO purchaseOrderBranchCompanyDTO
      ) {
         this.purchaseOrderBranchCompanyDTO = purchaseOrderBranchCompanyDTO;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder auxMaterialIds(final List<Long> auxMaterialIds) {
         this.auxMaterialIds = auxMaterialIds;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder otherMaterialIds(final List<Long> otherMaterialIds) {
         this.otherMaterialIds = otherMaterialIds;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder gasMaterialIds(final List<Long> gasMaterialIds) {
         this.gasMaterialIds = gasMaterialIds;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder lastOperatorNameId(final Long lastOperatorNameId) {
         this.lastOperatorNameId = lastOperatorNameId;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder lastOperatorName(final String lastOperatorName) {
         this.lastOperatorName = lastOperatorName;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder boolTemporaryStorage(final Boolean boolTemporaryStorage) {
         this.boolTemporaryStorage = boolTemporaryStorage;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder boolDetail(final Boolean boolDetail) {
         this.boolDetail = boolDetail;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder editable(final Boolean editable) {
         this.editable = editable;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder details(
         final List<ScmLumpSumSystemPurchaseOrderDetailDTO> details
      ) {
         this.details = details;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder dataStatus(final Integer dataStatus) {
         this.dataStatus = dataStatus;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder wmsApproveRecordFlowDTOS(
         final List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS
      ) {
         this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder approveRecordIdNow(final Long approveRecordIdNow) {
         this.approveRecordIdNow = approveRecordIdNow;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder approveRecordIds(final String approveRecordIds) {
         this.approveRecordIds = approveRecordIds;
         return this;
      }

      public BriefScmLumSumSystemPurchaseOrderDTO build() {
         return new BriefScmLumSumSystemPurchaseOrderDTO(
            this.id,
            this.createTime,
            this.settlementStatus,
            this.purchaseStatus,
            this.basicClass,
            this.materialType,
            this.purchaseType,
            this.serialNumber,
            this.serialNumberParent,
            this.mete,
            this.meteUnit,
            this.amount,
            this.taxRate,
            this.invoiceType,
            this.logisticsPayerType,
            this.projects,
            this.supplier,
            this.projectManagerId,
            this.projectManagerName,
            this.purchaseOrderBranchCompanyDTO,
            this.auxMaterialIds,
            this.otherMaterialIds,
            this.gasMaterialIds,
            this.applicantId,
            this.applicantName,
            this.lastOperatorNameId,
            this.lastOperatorName,
            this.userUpdateTime,
            this.attachments,
            this.reviewStatus,
            this.boolTemporaryStorage,
            this.remark,
            this.boolDetail,
            this.editable,
            this.details,
            this.dataStatus,
            this.wmsApproveRecordFlowDTOS,
            this.approveRecordIdNow,
            this.approveRecordIds
         );
      }

      @Override
      public String toString() {
         return "BriefScmLumSumSystemPurchaseOrderDTO.BriefScmLumSumSystemPurchaseOrderDTOBuilder(id="
            + this.id
            + ", createTime="
            + this.createTime
            + ", settlementStatus="
            + this.settlementStatus
            + ", purchaseStatus="
            + this.purchaseStatus
            + ", basicClass="
            + this.basicClass
            + ", materialType="
            + this.materialType
            + ", purchaseType="
            + this.purchaseType
            + ", serialNumber="
            + this.serialNumber
            + ", serialNumberParent="
            + this.serialNumberParent
            + ", mete="
            + this.mete
            + ", meteUnit="
            + this.meteUnit
            + ", amount="
            + this.amount
            + ", taxRate="
            + this.taxRate
            + ", invoiceType="
            + this.invoiceType
            + ", logisticsPayerType="
            + this.logisticsPayerType
            + ", projects="
            + this.projects
            + ", supplier="
            + this.supplier
            + ", projectManagerId="
            + this.projectManagerId
            + ", projectManagerName="
            + this.projectManagerName
            + ", purchaseOrderBranchCompanyDTO="
            + this.purchaseOrderBranchCompanyDTO
            + ", auxMaterialIds="
            + this.auxMaterialIds
            + ", otherMaterialIds="
            + this.otherMaterialIds
            + ", gasMaterialIds="
            + this.gasMaterialIds
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", lastOperatorNameId="
            + this.lastOperatorNameId
            + ", lastOperatorName="
            + this.lastOperatorName
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", attachments="
            + this.attachments
            + ", reviewStatus="
            + this.reviewStatus
            + ", boolTemporaryStorage="
            + this.boolTemporaryStorage
            + ", remark="
            + this.remark
            + ", boolDetail="
            + this.boolDetail
            + ", editable="
            + this.editable
            + ", details="
            + this.details
            + ", dataStatus="
            + this.dataStatus
            + ", wmsApproveRecordFlowDTOS="
            + this.wmsApproveRecordFlowDTOS
            + ", approveRecordIdNow="
            + this.approveRecordIdNow
            + ", approveRecordIds="
            + this.approveRecordIds
            + ")";
      }
   }
}
