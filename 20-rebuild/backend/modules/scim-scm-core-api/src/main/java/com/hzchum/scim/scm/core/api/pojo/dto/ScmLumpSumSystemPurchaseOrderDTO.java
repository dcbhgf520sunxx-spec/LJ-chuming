package com.hzchum.scim.scm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.system.core.api.pojo.dto.PurchaseOrderBranchCompanyDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("包干制-采购台账")
public class ScmLumpSumSystemPurchaseOrderDTO {
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
   private Integer projectId;
   private SupplierAllBriefDTO supplier;
   private Long projectManagerId;
   private String projectManagerName;
   private PurchaseOrderBranchCompanyDTO purchaseOrderBranchCompanyDTO;
   private Long applicantId;
   private String applicantName;
   private Long lastOperatorNameId;
   private String lastOperatorName;
   private String userUpdateTime;
   private List<Long> auxMaterialIds;
   private List<Long> otherMaterialIds;
   private List<Long> gasMaterialIds;
   private List<AttachmentDTO> attachments;
   private Integer reviewStatus;
   private Boolean boolTemporaryStorage;
   private Boolean editable;
   private Boolean boolRewrite;
   private String remark;
   private Boolean boolDetail;
   @ApiModelProperty("结算额（元）")
   private BigDecimal settlementAmount;
   @ApiModelProperty("累计付款（元）")
   private BigDecimal cumulativePayment;
   @ApiModelProperty("累计开票（元）")
   private BigDecimal cumulativeInvoice;
   private List<ScmLumpSumSystemPurchaseOrderDetailDTO> purchaseOrderDetailDTOS;
   private Integer dataStatus;
   private List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS;
   private Long approveRecordIdNow;
   private String approveRecordIds;

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

   public Integer getProjectId() {
      return this.projectId;
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

   public String getUserUpdateTime() {
      return this.userUpdateTime;
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

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Boolean getBoolTemporaryStorage() {
      return this.boolTemporaryStorage;
   }

   public Boolean getEditable() {
      return this.editable;
   }

   public Boolean getBoolRewrite() {
      return this.boolRewrite;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolDetail() {
      return this.boolDetail;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getCumulativePayment() {
      return this.cumulativePayment;
   }

   public BigDecimal getCumulativeInvoice() {
      return this.cumulativeInvoice;
   }

   public List<ScmLumpSumSystemPurchaseOrderDetailDTO> getPurchaseOrderDetailDTOS() {
      return this.purchaseOrderDetailDTOS;
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

   public void setProjectId(final Integer projectId) {
      this.projectId = projectId;
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

   public void setUserUpdateTime(final String userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
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

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setBoolTemporaryStorage(final Boolean boolTemporaryStorage) {
      this.boolTemporaryStorage = boolTemporaryStorage;
   }

   public void setEditable(final Boolean editable) {
      this.editable = editable;
   }

   public void setBoolRewrite(final Boolean boolRewrite) {
      this.boolRewrite = boolRewrite;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBoolDetail(final Boolean boolDetail) {
      this.boolDetail = boolDetail;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setCumulativePayment(final BigDecimal cumulativePayment) {
      this.cumulativePayment = cumulativePayment;
   }

   public void setCumulativeInvoice(final BigDecimal cumulativeInvoice) {
      this.cumulativeInvoice = cumulativeInvoice;
   }

   public void setPurchaseOrderDetailDTOS(final List<ScmLumpSumSystemPurchaseOrderDetailDTO> purchaseOrderDetailDTOS) {
      this.purchaseOrderDetailDTOS = purchaseOrderDetailDTOS;
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

      if (!(o instanceof ScmLumpSumSystemPurchaseOrderDTO)) {
         return false;
      }

      ScmLumpSumSystemPurchaseOrderDTO other = (ScmLumpSumSystemPurchaseOrderDTO)o;
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
                              Object this$projectId = this.getProjectId();
                              Object other$projectId = other.getProjectId();
                              if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
                                                Object this$editable = this.getEditable();
                                                Object other$editable = other.getEditable();
                                                if (this$editable == null ? other$editable == null : this$editable.equals(other$editable)) {
                                                   Object this$boolRewrite = this.getBoolRewrite();
                                                   Object other$boolRewrite = other.getBoolRewrite();
                                                   if (this$boolRewrite == null ? other$boolRewrite == null : this$boolRewrite.equals(other$boolRewrite)) {
                                                      Object this$boolDetail = this.getBoolDetail();
                                                      Object other$boolDetail = other.getBoolDetail();
                                                      if (this$boolDetail == null ? other$boolDetail == null : this$boolDetail.equals(other$boolDetail)) {
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
                                                               if (this$createTime == null
                                                                  ? other$createTime == null
                                                                  : this$createTime.equals(other$createTime)) {
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
                                                                           if (this$meteUnit == null
                                                                              ? other$meteUnit == null
                                                                              : this$meteUnit.equals(other$meteUnit)) {
                                                                              Object this$amount = this.getAmount();
                                                                              Object other$amount = other.getAmount();
                                                                              if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)
                                                                                 )
                                                                               {
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
                                                                                                Object this$applicantName = this.getApplicantName();
                                                                                                Object other$applicantName = other.getApplicantName();
                                                                                                if (this$applicantName == null
                                                                                                   ? other$applicantName == null
                                                                                                   : this$applicantName.equals(other$applicantName)) {
                                                                                                   Object this$lastOperatorName = this.getLastOperatorName();
                                                                                                   Object other$lastOperatorName = other.getLastOperatorName();
                                                                                                   if (this$lastOperatorName == null
                                                                                                      ? other$lastOperatorName == null
                                                                                                      : this$lastOperatorName.equals(other$lastOperatorName)) {
                                                                                                      Object this$userUpdateTime = this.getUserUpdateTime();
                                                                                                      Object other$userUpdateTime = other.getUserUpdateTime();
                                                                                                      if (this$userUpdateTime == null
                                                                                                         ? other$userUpdateTime == null
                                                                                                         : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                                                                         Object this$auxMaterialIds = this.getAuxMaterialIds();
                                                                                                         Object other$auxMaterialIds = other.getAuxMaterialIds();
                                                                                                         if (this$auxMaterialIds == null
                                                                                                            ? other$auxMaterialIds == null
                                                                                                            : this$auxMaterialIds.equals(other$auxMaterialIds)) {
                                                                                                            Object this$otherMaterialIds = this.getOtherMaterialIds();
                                                                                                            Object other$otherMaterialIds = other.getOtherMaterialIds();
                                                                                                            if (this$otherMaterialIds == null
                                                                                                               ? other$otherMaterialIds == null
                                                                                                               : this$otherMaterialIds.equals(
                                                                                                                  other$otherMaterialIds
                                                                                                               )) {
                                                                                                               Object this$gasMaterialIds = this.getGasMaterialIds();
                                                                                                               Object other$gasMaterialIds = other.getGasMaterialIds();
                                                                                                               if (this$gasMaterialIds == null
                                                                                                                  ? other$gasMaterialIds == null
                                                                                                                  : this$gasMaterialIds.equals(
                                                                                                                     other$gasMaterialIds
                                                                                                                  )) {
                                                                                                                  Object this$attachments = this.getAttachments();
                                                                                                                  Object other$attachments = other.getAttachments();
                                                                                                                  if (this$attachments == null
                                                                                                                     ? other$attachments == null
                                                                                                                     : this$attachments.equals(
                                                                                                                        other$attachments
                                                                                                                     )) {
                                                                                                                     Object this$remark = this.getRemark();
                                                                                                                     Object other$remark = other.getRemark();
                                                                                                                     if (this$remark == null
                                                                                                                        ? other$remark == null
                                                                                                                        : this$remark.equals(other$remark)) {
                                                                                                                        Object this$settlementAmount = this.getSettlementAmount();
                                                                                                                        Object other$settlementAmount = other.getSettlementAmount();
                                                                                                                        if (this$settlementAmount == null
                                                                                                                           ? other$settlementAmount == null
                                                                                                                           : this$settlementAmount.equals(
                                                                                                                              other$settlementAmount
                                                                                                                           )) {
                                                                                                                           Object this$cumulativePayment = this.getCumulativePayment();
                                                                                                                           Object other$cumulativePayment = other.getCumulativePayment();
                                                                                                                           if (this$cumulativePayment == null
                                                                                                                              ? other$cumulativePayment == null
                                                                                                                              : this$cumulativePayment.equals(
                                                                                                                                 other$cumulativePayment
                                                                                                                              )) {
                                                                                                                              Object this$cumulativeInvoice = this.getCumulativeInvoice();
                                                                                                                              Object other$cumulativeInvoice = other.getCumulativeInvoice();
                                                                                                                              if (this$cumulativeInvoice
                                                                                                                                    == null
                                                                                                                                 ? other$cumulativeInvoice
                                                                                                                                    == null
                                                                                                                                 : this$cumulativeInvoice.equals(
                                                                                                                                    other$cumulativeInvoice
                                                                                                                                 )) {
                                                                                                                                 Object this$purchaseOrderDetailDTOS = this.getPurchaseOrderDetailDTOS();
                                                                                                                                 Object other$purchaseOrderDetailDTOS = other.getPurchaseOrderDetailDTOS();
                                                                                                                                 if (this$purchaseOrderDetailDTOS
                                                                                                                                       == null
                                                                                                                                    ? other$purchaseOrderDetailDTOS
                                                                                                                                       == null
                                                                                                                                    : this$purchaseOrderDetailDTOS.equals(
                                                                                                                                       other$purchaseOrderDetailDTOS
                                                                                                                                    )) {
                                                                                                                                    Object this$wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
                                                                                                                                    Object other$wmsApproveRecordFlowDTOS = other.getWmsApproveRecordFlowDTOS();
                                                                                                                                    if (this$wmsApproveRecordFlowDTOS
                                                                                                                                          == null
                                                                                                                                       ? other$wmsApproveRecordFlowDTOS
                                                                                                                                          == null
                                                                                                                                       : this$wmsApproveRecordFlowDTOS.equals(
                                                                                                                                          other$wmsApproveRecordFlowDTOS
                                                                                                                                       )) {
                                                                                                                                       Object this$approveRecordIds = this.getApproveRecordIds();
                                                                                                                                       Object other$approveRecordIds = other.getApproveRecordIds();
                                                                                                                                       return this$approveRecordIds
                                                                                                                                             == null
                                                                                                                                          ? other$approveRecordIds
                                                                                                                                             == null
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
               } else {
                  return false;
               }
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
      return other instanceof ScmLumpSumSystemPurchaseOrderDTO;
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
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
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
      Object $editable = this.getEditable();
      result = result * 59 + ($editable == null ? 43 : $editable.hashCode());
      Object $boolRewrite = this.getBoolRewrite();
      result = result * 59 + ($boolRewrite == null ? 43 : $boolRewrite.hashCode());
      Object $boolDetail = this.getBoolDetail();
      result = result * 59 + ($boolDetail == null ? 43 : $boolDetail.hashCode());
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
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $lastOperatorName = this.getLastOperatorName();
      result = result * 59 + ($lastOperatorName == null ? 43 : $lastOperatorName.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $auxMaterialIds = this.getAuxMaterialIds();
      result = result * 59 + ($auxMaterialIds == null ? 43 : $auxMaterialIds.hashCode());
      Object $otherMaterialIds = this.getOtherMaterialIds();
      result = result * 59 + ($otherMaterialIds == null ? 43 : $otherMaterialIds.hashCode());
      Object $gasMaterialIds = this.getGasMaterialIds();
      result = result * 59 + ($gasMaterialIds == null ? 43 : $gasMaterialIds.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $cumulativePayment = this.getCumulativePayment();
      result = result * 59 + ($cumulativePayment == null ? 43 : $cumulativePayment.hashCode());
      Object $cumulativeInvoice = this.getCumulativeInvoice();
      result = result * 59 + ($cumulativeInvoice == null ? 43 : $cumulativeInvoice.hashCode());
      Object $purchaseOrderDetailDTOS = this.getPurchaseOrderDetailDTOS();
      result = result * 59 + ($purchaseOrderDetailDTOS == null ? 43 : $purchaseOrderDetailDTOS.hashCode());
      Object $wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
      result = result * 59 + ($wmsApproveRecordFlowDTOS == null ? 43 : $wmsApproveRecordFlowDTOS.hashCode());
      Object $approveRecordIds = this.getApproveRecordIds();
      return result * 59 + ($approveRecordIds == null ? 43 : $approveRecordIds.hashCode());
   }

   @Override
   public String toString() {
      return "ScmLumpSumSystemPurchaseOrderDTO(id="
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
         + ", projectId="
         + this.getProjectId()
         + ", supplier="
         + this.getSupplier()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", purchaseOrderBranchCompanyDTO="
         + this.getPurchaseOrderBranchCompanyDTO()
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
         + ", auxMaterialIds="
         + this.getAuxMaterialIds()
         + ", otherMaterialIds="
         + this.getOtherMaterialIds()
         + ", gasMaterialIds="
         + this.getGasMaterialIds()
         + ", attachments="
         + this.getAttachments()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", boolTemporaryStorage="
         + this.getBoolTemporaryStorage()
         + ", editable="
         + this.getEditable()
         + ", boolRewrite="
         + this.getBoolRewrite()
         + ", remark="
         + this.getRemark()
         + ", boolDetail="
         + this.getBoolDetail()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", cumulativePayment="
         + this.getCumulativePayment()
         + ", cumulativeInvoice="
         + this.getCumulativeInvoice()
         + ", purchaseOrderDetailDTOS="
         + this.getPurchaseOrderDetailDTOS()
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
}
