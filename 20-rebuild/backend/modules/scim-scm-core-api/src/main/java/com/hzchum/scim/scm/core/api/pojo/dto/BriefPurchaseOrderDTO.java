package com.hzchum.scim.scm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.scm.core.api.common.DetailQuantityAndMete;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class BriefPurchaseOrderDTO {
   private Long id;
   private Integer purchaseType;
   private Boolean BoolAnnual;
   private Integer supplyType;
   private Integer basicClass;
   private Integer materialType;
   private String serialNumber;
   private String serialNumberParent;
   private List<ProjectInfo> projects;
   private Integer projectAttribute;
   private Integer logisticsTransportType;
   private Integer logisticsPayerType;
   private Integer purchaseOrderPaymentMode;
   private Integer weightMeasurementMode;
   private List<BriefIdAndSNDTO> applyPurchase;
   private List<Long> auxMaterialIds;
   private String auxMaterialNames;
   private List<Long> otherMaterialIds;
   private String otherMaterialNames;
   private List<Long> gasMaterialIds;
   private String gasMaterialNames;
   private BigDecimal mete;
   private String meteUnit;
   private BigDecimal amount;
   private BriefIdAndNameDTO branchCompany;
   private BriefIdAndNameDTO supplier;
   private BigDecimal taxRate;
   private BigDecimal inboundTotalQuantity;
   private BigDecimal inboundTotalMete;
   private Integer invoiceType;
   private String applicantName;
   private Boolean boolUsed;
   private String lastOperatorName;
   private List<AttachmentDTO> attachments;
   private String remark;
   private Integer purchaseStatus;
   private Integer settlementStatus;
   private LocalDateTime createTime;
   private LocalDateTime userUpdateTime;
   private Integer level;
   private String applyPurchaseStatus;
   private Integer reviewStatus;
   private Boolean boolTemporaryStorage;
   private Boolean useRequisitions;
   private Boolean boolDetail;
   private Boolean editable;
   private List<PurchaseOrderDetailDTO> details;
   private Integer dataStatus;
   private List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS;
   private Long approveRecordIdNow;
   private String approveRecordIds;
   private IdAndNameDTO projectManager;
   private IdAndNameDTO mesWorkshop;
   private Boolean boolSysgen;
   @ApiModelProperty(name = "delButtonType ", value = "删除按钮展示类型 1撤销 2删除 3撤销删除 4撤销编辑")
   private Integer delButtonType;
   private List<DetailQuantityAndMete> detailQuantityAndMetes;
   private Integer orderPlace;
   private Integer enclosureWageQuotaType;
   private Integer artifactWageQuotaType;

   public static BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder builder() {
      return new BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getPurchaseType() {
      return this.purchaseType;
   }

   public Boolean getBoolAnnual() {
      return this.BoolAnnual;
   }

   public Integer getSupplyType() {
      return this.supplyType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSerialNumberParent() {
      return this.serialNumberParent;
   }

   public List<ProjectInfo> getProjects() {
      return this.projects;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Integer getLogisticsTransportType() {
      return this.logisticsTransportType;
   }

   public Integer getLogisticsPayerType() {
      return this.logisticsPayerType;
   }

   public Integer getPurchaseOrderPaymentMode() {
      return this.purchaseOrderPaymentMode;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public List<BriefIdAndSNDTO> getApplyPurchase() {
      return this.applyPurchase;
   }

   public List<Long> getAuxMaterialIds() {
      return this.auxMaterialIds;
   }

   public String getAuxMaterialNames() {
      return this.auxMaterialNames;
   }

   public List<Long> getOtherMaterialIds() {
      return this.otherMaterialIds;
   }

   public String getOtherMaterialNames() {
      return this.otherMaterialNames;
   }

   public List<Long> getGasMaterialIds() {
      return this.gasMaterialIds;
   }

   public String getGasMaterialNames() {
      return this.gasMaterialNames;
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

   public BriefIdAndNameDTO getBranchCompany() {
      return this.branchCompany;
   }

   public BriefIdAndNameDTO getSupplier() {
      return this.supplier;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getInboundTotalQuantity() {
      return this.inboundTotalQuantity;
   }

   public BigDecimal getInboundTotalMete() {
      return this.inboundTotalMete;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Boolean getBoolUsed() {
      return this.boolUsed;
   }

   public String getLastOperatorName() {
      return this.lastOperatorName;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getPurchaseStatus() {
      return this.purchaseStatus;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public Integer getLevel() {
      return this.level;
   }

   public String getApplyPurchaseStatus() {
      return this.applyPurchaseStatus;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Boolean getBoolTemporaryStorage() {
      return this.boolTemporaryStorage;
   }

   public Boolean getUseRequisitions() {
      return this.useRequisitions;
   }

   public Boolean getBoolDetail() {
      return this.boolDetail;
   }

   public Boolean getEditable() {
      return this.editable;
   }

   public List<PurchaseOrderDetailDTO> getDetails() {
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

   public IdAndNameDTO getProjectManager() {
      return this.projectManager;
   }

   public IdAndNameDTO getMesWorkshop() {
      return this.mesWorkshop;
   }

   public Boolean getBoolSysgen() {
      return this.boolSysgen;
   }

   public Integer getDelButtonType() {
      return this.delButtonType;
   }

   public List<DetailQuantityAndMete> getDetailQuantityAndMetes() {
      return this.detailQuantityAndMetes;
   }

   public Integer getOrderPlace() {
      return this.orderPlace;
   }

   public Integer getEnclosureWageQuotaType() {
      return this.enclosureWageQuotaType;
   }

   public Integer getArtifactWageQuotaType() {
      return this.artifactWageQuotaType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPurchaseType(final Integer purchaseType) {
      this.purchaseType = purchaseType;
   }

   public void setBoolAnnual(final Boolean BoolAnnual) {
      this.BoolAnnual = BoolAnnual;
   }

   public void setSupplyType(final Integer supplyType) {
      this.supplyType = supplyType;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSerialNumberParent(final String serialNumberParent) {
      this.serialNumberParent = serialNumberParent;
   }

   public void setProjects(final List<ProjectInfo> projects) {
      this.projects = projects;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setLogisticsTransportType(final Integer logisticsTransportType) {
      this.logisticsTransportType = logisticsTransportType;
   }

   public void setLogisticsPayerType(final Integer logisticsPayerType) {
      this.logisticsPayerType = logisticsPayerType;
   }

   public void setPurchaseOrderPaymentMode(final Integer purchaseOrderPaymentMode) {
      this.purchaseOrderPaymentMode = purchaseOrderPaymentMode;
   }

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   public void setApplyPurchase(final List<BriefIdAndSNDTO> applyPurchase) {
      this.applyPurchase = applyPurchase;
   }

   public void setAuxMaterialIds(final List<Long> auxMaterialIds) {
      this.auxMaterialIds = auxMaterialIds;
   }

   public void setAuxMaterialNames(final String auxMaterialNames) {
      this.auxMaterialNames = auxMaterialNames;
   }

   public void setOtherMaterialIds(final List<Long> otherMaterialIds) {
      this.otherMaterialIds = otherMaterialIds;
   }

   public void setOtherMaterialNames(final String otherMaterialNames) {
      this.otherMaterialNames = otherMaterialNames;
   }

   public void setGasMaterialIds(final List<Long> gasMaterialIds) {
      this.gasMaterialIds = gasMaterialIds;
   }

   public void setGasMaterialNames(final String gasMaterialNames) {
      this.gasMaterialNames = gasMaterialNames;
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

   public void setBranchCompany(final BriefIdAndNameDTO branchCompany) {
      this.branchCompany = branchCompany;
   }

   public void setSupplier(final BriefIdAndNameDTO supplier) {
      this.supplier = supplier;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setInboundTotalQuantity(final BigDecimal inboundTotalQuantity) {
      this.inboundTotalQuantity = inboundTotalQuantity;
   }

   public void setInboundTotalMete(final BigDecimal inboundTotalMete) {
      this.inboundTotalMete = inboundTotalMete;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setBoolUsed(final Boolean boolUsed) {
      this.boolUsed = boolUsed;
   }

   public void setLastOperatorName(final String lastOperatorName) {
      this.lastOperatorName = lastOperatorName;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setPurchaseStatus(final Integer purchaseStatus) {
      this.purchaseStatus = purchaseStatus;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setApplyPurchaseStatus(final String applyPurchaseStatus) {
      this.applyPurchaseStatus = applyPurchaseStatus;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setBoolTemporaryStorage(final Boolean boolTemporaryStorage) {
      this.boolTemporaryStorage = boolTemporaryStorage;
   }

   public void setUseRequisitions(final Boolean useRequisitions) {
      this.useRequisitions = useRequisitions;
   }

   public void setBoolDetail(final Boolean boolDetail) {
      this.boolDetail = boolDetail;
   }

   public void setEditable(final Boolean editable) {
      this.editable = editable;
   }

   public void setDetails(final List<PurchaseOrderDetailDTO> details) {
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

   public void setProjectManager(final IdAndNameDTO projectManager) {
      this.projectManager = projectManager;
   }

   public void setMesWorkshop(final IdAndNameDTO mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
   }

   public void setBoolSysgen(final Boolean boolSysgen) {
      this.boolSysgen = boolSysgen;
   }

   public void setDelButtonType(final Integer delButtonType) {
      this.delButtonType = delButtonType;
   }

   public void setDetailQuantityAndMetes(final List<DetailQuantityAndMete> detailQuantityAndMetes) {
      this.detailQuantityAndMetes = detailQuantityAndMetes;
   }

   public void setOrderPlace(final Integer orderPlace) {
      this.orderPlace = orderPlace;
   }

   public void setEnclosureWageQuotaType(final Integer enclosureWageQuotaType) {
      this.enclosureWageQuotaType = enclosureWageQuotaType;
   }

   public void setArtifactWageQuotaType(final Integer artifactWageQuotaType) {
      this.artifactWageQuotaType = artifactWageQuotaType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BriefPurchaseOrderDTO)) {
         return false;
      }

      BriefPurchaseOrderDTO other = (BriefPurchaseOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseType = this.getPurchaseType();
         Object other$purchaseType = other.getPurchaseType();
         if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
            Object this$BoolAnnual = this.getBoolAnnual();
            Object other$BoolAnnual = other.getBoolAnnual();
            if (this$BoolAnnual == null ? other$BoolAnnual == null : this$BoolAnnual.equals(other$BoolAnnual)) {
               Object this$supplyType = this.getSupplyType();
               Object other$supplyType = other.getSupplyType();
               if (this$supplyType == null ? other$supplyType == null : this$supplyType.equals(other$supplyType)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$materialType = this.getMaterialType();
                     Object other$materialType = other.getMaterialType();
                     if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
                        Object this$projectAttribute = this.getProjectAttribute();
                        Object other$projectAttribute = other.getProjectAttribute();
                        if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                           Object this$logisticsTransportType = this.getLogisticsTransportType();
                           Object other$logisticsTransportType = other.getLogisticsTransportType();
                           if (this$logisticsTransportType == null
                              ? other$logisticsTransportType == null
                              : this$logisticsTransportType.equals(other$logisticsTransportType)) {
                              Object this$logisticsPayerType = this.getLogisticsPayerType();
                              Object other$logisticsPayerType = other.getLogisticsPayerType();
                              if (this$logisticsPayerType == null ? other$logisticsPayerType == null : this$logisticsPayerType.equals(other$logisticsPayerType)
                                 )
                               {
                                 Object this$purchaseOrderPaymentMode = this.getPurchaseOrderPaymentMode();
                                 Object other$purchaseOrderPaymentMode = other.getPurchaseOrderPaymentMode();
                                 if (this$purchaseOrderPaymentMode == null
                                    ? other$purchaseOrderPaymentMode == null
                                    : this$purchaseOrderPaymentMode.equals(other$purchaseOrderPaymentMode)) {
                                    Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                    Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                    if (this$weightMeasurementMode == null
                                       ? other$weightMeasurementMode == null
                                       : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                       Object this$invoiceType = this.getInvoiceType();
                                       Object other$invoiceType = other.getInvoiceType();
                                       if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                          Object this$boolUsed = this.getBoolUsed();
                                          Object other$boolUsed = other.getBoolUsed();
                                          if (this$boolUsed == null ? other$boolUsed == null : this$boolUsed.equals(other$boolUsed)) {
                                             Object this$purchaseStatus = this.getPurchaseStatus();
                                             Object other$purchaseStatus = other.getPurchaseStatus();
                                             if (this$purchaseStatus == null ? other$purchaseStatus == null : this$purchaseStatus.equals(other$purchaseStatus)) {
                                                Object this$settlementStatus = this.getSettlementStatus();
                                                Object other$settlementStatus = other.getSettlementStatus();
                                                if (this$settlementStatus == null
                                                   ? other$settlementStatus == null
                                                   : this$settlementStatus.equals(other$settlementStatus)) {
                                                   Object this$level = this.getLevel();
                                                   Object other$level = other.getLevel();
                                                   if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                                                      Object this$reviewStatus = this.getReviewStatus();
                                                      Object other$reviewStatus = other.getReviewStatus();
                                                      if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)
                                                         )
                                                       {
                                                         Object this$boolTemporaryStorage = this.getBoolTemporaryStorage();
                                                         Object other$boolTemporaryStorage = other.getBoolTemporaryStorage();
                                                         if (this$boolTemporaryStorage == null
                                                            ? other$boolTemporaryStorage == null
                                                            : this$boolTemporaryStorage.equals(other$boolTemporaryStorage)) {
                                                            Object this$useRequisitions = this.getUseRequisitions();
                                                            Object other$useRequisitions = other.getUseRequisitions();
                                                            if (this$useRequisitions == null
                                                               ? other$useRequisitions == null
                                                               : this$useRequisitions.equals(other$useRequisitions)) {
                                                               Object this$boolDetail = this.getBoolDetail();
                                                               Object other$boolDetail = other.getBoolDetail();
                                                               if (this$boolDetail == null
                                                                  ? other$boolDetail == null
                                                                  : this$boolDetail.equals(other$boolDetail)) {
                                                                  Object this$editable = this.getEditable();
                                                                  Object other$editable = other.getEditable();
                                                                  if (this$editable == null ? other$editable == null : this$editable.equals(other$editable)) {
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
                                                                           Object this$boolSysgen = this.getBoolSysgen();
                                                                           Object other$boolSysgen = other.getBoolSysgen();
                                                                           if (this$boolSysgen == null
                                                                              ? other$boolSysgen == null
                                                                              : this$boolSysgen.equals(other$boolSysgen)) {
                                                                              Object this$delButtonType = this.getDelButtonType();
                                                                              Object other$delButtonType = other.getDelButtonType();
                                                                              if (this$delButtonType == null
                                                                                 ? other$delButtonType == null
                                                                                 : this$delButtonType.equals(other$delButtonType)) {
                                                                                 Object this$orderPlace = this.getOrderPlace();
                                                                                 Object other$orderPlace = other.getOrderPlace();
                                                                                 if (this$orderPlace == null
                                                                                    ? other$orderPlace == null
                                                                                    : this$orderPlace.equals(other$orderPlace)) {
                                                                                    Object this$enclosureWageQuotaType = this.getEnclosureWageQuotaType();
                                                                                    Object other$enclosureWageQuotaType = other.getEnclosureWageQuotaType();
                                                                                    if (this$enclosureWageQuotaType == null
                                                                                       ? other$enclosureWageQuotaType == null
                                                                                       : this$enclosureWageQuotaType.equals(other$enclosureWageQuotaType)) {
                                                                                       Object this$artifactWageQuotaType = this.getArtifactWageQuotaType();
                                                                                       Object other$artifactWageQuotaType = other.getArtifactWageQuotaType();
                                                                                       if (this$artifactWageQuotaType == null
                                                                                          ? other$artifactWageQuotaType == null
                                                                                          : this$artifactWageQuotaType.equals(other$artifactWageQuotaType)) {
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
                                                                                                Object this$projects = this.getProjects();
                                                                                                Object other$projects = other.getProjects();
                                                                                                if (this$projects == null
                                                                                                   ? other$projects == null
                                                                                                   : this$projects.equals(other$projects)) {
                                                                                                   Object this$applyPurchase = this.getApplyPurchase();
                                                                                                   Object other$applyPurchase = other.getApplyPurchase();
                                                                                                   if (this$applyPurchase == null
                                                                                                      ? other$applyPurchase == null
                                                                                                      : this$applyPurchase.equals(other$applyPurchase)) {
                                                                                                      Object this$auxMaterialIds = this.getAuxMaterialIds();
                                                                                                      Object other$auxMaterialIds = other.getAuxMaterialIds();
                                                                                                      if (this$auxMaterialIds == null
                                                                                                         ? other$auxMaterialIds == null
                                                                                                         : this$auxMaterialIds.equals(other$auxMaterialIds)) {
                                                                                                         Object this$auxMaterialNames = this.getAuxMaterialNames();
                                                                                                         Object other$auxMaterialNames = other.getAuxMaterialNames();
                                                                                                         if (this$auxMaterialNames == null
                                                                                                            ? other$auxMaterialNames == null
                                                                                                            : this$auxMaterialNames.equals(
                                                                                                               other$auxMaterialNames
                                                                                                            )) {
                                                                                                            Object this$otherMaterialIds = this.getOtherMaterialIds();
                                                                                                            Object other$otherMaterialIds = other.getOtherMaterialIds();
                                                                                                            if (this$otherMaterialIds == null
                                                                                                               ? other$otherMaterialIds == null
                                                                                                               : this$otherMaterialIds.equals(
                                                                                                                  other$otherMaterialIds
                                                                                                               )) {
                                                                                                               Object this$otherMaterialNames = this.getOtherMaterialNames();
                                                                                                               Object other$otherMaterialNames = other.getOtherMaterialNames();
                                                                                                               if (this$otherMaterialNames == null
                                                                                                                  ? other$otherMaterialNames == null
                                                                                                                  : this$otherMaterialNames.equals(
                                                                                                                     other$otherMaterialNames
                                                                                                                  )) {
                                                                                                                  Object this$gasMaterialIds = this.getGasMaterialIds();
                                                                                                                  Object other$gasMaterialIds = other.getGasMaterialIds();
                                                                                                                  if (this$gasMaterialIds == null
                                                                                                                     ? other$gasMaterialIds == null
                                                                                                                     : this$gasMaterialIds.equals(
                                                                                                                        other$gasMaterialIds
                                                                                                                     )) {
                                                                                                                     Object this$gasMaterialNames = this.getGasMaterialNames();
                                                                                                                     Object other$gasMaterialNames = other.getGasMaterialNames();
                                                                                                                     if (this$gasMaterialNames == null
                                                                                                                        ? other$gasMaterialNames == null
                                                                                                                        : this$gasMaterialNames.equals(
                                                                                                                           other$gasMaterialNames
                                                                                                                        )) {
                                                                                                                        Object this$mete = this.getMete();
                                                                                                                        Object other$mete = other.getMete();
                                                                                                                        if (this$mete == null
                                                                                                                           ? other$mete == null
                                                                                                                           : this$mete.equals(other$mete)) {
                                                                                                                           Object this$meteUnit = this.getMeteUnit();
                                                                                                                           Object other$meteUnit = other.getMeteUnit();
                                                                                                                           if (this$meteUnit == null
                                                                                                                              ? other$meteUnit == null
                                                                                                                              : this$meteUnit.equals(
                                                                                                                                 other$meteUnit
                                                                                                                              )) {
                                                                                                                              Object this$amount = this.getAmount();
                                                                                                                              Object other$amount = other.getAmount();
                                                                                                                              if (this$amount == null
                                                                                                                                 ? other$amount == null
                                                                                                                                 : this$amount.equals(
                                                                                                                                    other$amount
                                                                                                                                 )) {
                                                                                                                                 Object this$branchCompany = this.getBranchCompany();
                                                                                                                                 Object other$branchCompany = other.getBranchCompany();
                                                                                                                                 if (this$branchCompany == null
                                                                                                                                    ? other$branchCompany
                                                                                                                                       == null
                                                                                                                                    : this$branchCompany.equals(
                                                                                                                                       other$branchCompany
                                                                                                                                    )) {
                                                                                                                                    Object this$supplier = this.getSupplier();
                                                                                                                                    Object other$supplier = other.getSupplier();
                                                                                                                                    if (this$supplier == null
                                                                                                                                       ? other$supplier == null
                                                                                                                                       : this$supplier.equals(
                                                                                                                                          other$supplier
                                                                                                                                       )) {
                                                                                                                                       Object this$taxRate = this.getTaxRate();
                                                                                                                                       Object other$taxRate = other.getTaxRate();
                                                                                                                                       if (this$taxRate == null
                                                                                                                                          ? other$taxRate
                                                                                                                                             == null
                                                                                                                                          : this$taxRate.equals(
                                                                                                                                             other$taxRate
                                                                                                                                          )) {
                                                                                                                                          Object this$inboundTotalQuantity = this.getInboundTotalQuantity();
                                                                                                                                          Object other$inboundTotalQuantity = other.getInboundTotalQuantity();
                                                                                                                                          if (this$inboundTotalQuantity
                                                                                                                                                == null
                                                                                                                                             ? other$inboundTotalQuantity
                                                                                                                                                == null
                                                                                                                                             : this$inboundTotalQuantity.equals(
                                                                                                                                                other$inboundTotalQuantity
                                                                                                                                             )) {
                                                                                                                                             Object this$inboundTotalMete = this.getInboundTotalMete();
                                                                                                                                             Object other$inboundTotalMete = other.getInboundTotalMete();
                                                                                                                                             if (this$inboundTotalMete
                                                                                                                                                   == null
                                                                                                                                                ? other$inboundTotalMete
                                                                                                                                                   == null
                                                                                                                                                : this$inboundTotalMete.equals(
                                                                                                                                                   other$inboundTotalMete
                                                                                                                                                )) {
                                                                                                                                                Object this$applicantName = this.getApplicantName();
                                                                                                                                                Object other$applicantName = other.getApplicantName();
                                                                                                                                                if (this$applicantName
                                                                                                                                                      == null
                                                                                                                                                   ? other$applicantName
                                                                                                                                                      == null
                                                                                                                                                   : this$applicantName.equals(
                                                                                                                                                      other$applicantName
                                                                                                                                                   )) {
                                                                                                                                                   Object this$lastOperatorName = this.getLastOperatorName();
                                                                                                                                                   Object other$lastOperatorName = other.getLastOperatorName();
                                                                                                                                                   if (this$lastOperatorName
                                                                                                                                                         == null
                                                                                                                                                      ? other$lastOperatorName
                                                                                                                                                         == null
                                                                                                                                                      : this$lastOperatorName.equals(
                                                                                                                                                         other$lastOperatorName
                                                                                                                                                      )) {
                                                                                                                                                      Object this$attachments = this.getAttachments();
                                                                                                                                                      Object other$attachments = other.getAttachments();
                                                                                                                                                      if (this$attachments
                                                                                                                                                            == null
                                                                                                                                                         ? other$attachments
                                                                                                                                                            == null
                                                                                                                                                         : this$attachments.equals(
                                                                                                                                                            other$attachments
                                                                                                                                                         )) {
                                                                                                                                                         Object this$remark = this.getRemark();
                                                                                                                                                         Object other$remark = other.getRemark();
                                                                                                                                                         if (this$remark
                                                                                                                                                               == null
                                                                                                                                                            ? other$remark
                                                                                                                                                               == null
                                                                                                                                                            : this$remark.equals(
                                                                                                                                                               other$remark
                                                                                                                                                            )) {
                                                                                                                                                            Object this$createTime = this.getCreateTime();
                                                                                                                                                            Object other$createTime = other.getCreateTime();
                                                                                                                                                            if (this$createTime
                                                                                                                                                                  == null
                                                                                                                                                               ? other$createTime
                                                                                                                                                                  == null
                                                                                                                                                               : this$createTime.equals(
                                                                                                                                                                  other$createTime
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$userUpdateTime = this.getUserUpdateTime();
                                                                                                                                                               Object other$userUpdateTime = other.getUserUpdateTime();
                                                                                                                                                               if (this$userUpdateTime
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$userUpdateTime
                                                                                                                                                                     == null
                                                                                                                                                                  : this$userUpdateTime.equals(
                                                                                                                                                                     other$userUpdateTime
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$applyPurchaseStatus = this.getApplyPurchaseStatus();
                                                                                                                                                                  Object other$applyPurchaseStatus = other.getApplyPurchaseStatus();
                                                                                                                                                                  if (this$applyPurchaseStatus
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$applyPurchaseStatus
                                                                                                                                                                        == null
                                                                                                                                                                     : this$applyPurchaseStatus.equals(
                                                                                                                                                                        other$applyPurchaseStatus
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$details = this.getDetails();
                                                                                                                                                                     Object other$details = other.getDetails();
                                                                                                                                                                     if (this$details
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$details
                                                                                                                                                                           == null
                                                                                                                                                                        : this$details.equals(
                                                                                                                                                                           other$details
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
                                                                                                                                                                        Object other$wmsApproveRecordFlowDTOS = other.getWmsApproveRecordFlowDTOS();
                                                                                                                                                                        if (this$wmsApproveRecordFlowDTOS
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$wmsApproveRecordFlowDTOS
                                                                                                                                                                              == null
                                                                                                                                                                           : this$wmsApproveRecordFlowDTOS.equals(
                                                                                                                                                                              other$wmsApproveRecordFlowDTOS
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$approveRecordIds = this.getApproveRecordIds();
                                                                                                                                                                           Object other$approveRecordIds = other.getApproveRecordIds();
                                                                                                                                                                           if (this$approveRecordIds
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$approveRecordIds
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$approveRecordIds.equals(
                                                                                                                                                                                 other$approveRecordIds
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$projectManager = this.getProjectManager();
                                                                                                                                                                              Object other$projectManager = other.getProjectManager();
                                                                                                                                                                              if (this$projectManager
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$projectManager
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$projectManager.equals(
                                                                                                                                                                                    other$projectManager
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$mesWorkshop = this.getMesWorkshop();
                                                                                                                                                                                 Object other$mesWorkshop = other.getMesWorkshop();
                                                                                                                                                                                 if (this$mesWorkshop
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$mesWorkshop
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$mesWorkshop.equals(
                                                                                                                                                                                       other$mesWorkshop
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$detailQuantityAndMetes = this.getDetailQuantityAndMetes();
                                                                                                                                                                                    Object other$detailQuantityAndMetes = other.getDetailQuantityAndMetes();
                                                                                                                                                                                    return this$detailQuantityAndMetes
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$detailQuantityAndMetes
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$detailQuantityAndMetes.equals(
                                                                                                                                                                                          other$detailQuantityAndMetes
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
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof BriefPurchaseOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $BoolAnnual = this.getBoolAnnual();
      result = result * 59 + ($BoolAnnual == null ? 43 : $BoolAnnual.hashCode());
      Object $supplyType = this.getSupplyType();
      result = result * 59 + ($supplyType == null ? 43 : $supplyType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $logisticsTransportType = this.getLogisticsTransportType();
      result = result * 59 + ($logisticsTransportType == null ? 43 : $logisticsTransportType.hashCode());
      Object $logisticsPayerType = this.getLogisticsPayerType();
      result = result * 59 + ($logisticsPayerType == null ? 43 : $logisticsPayerType.hashCode());
      Object $purchaseOrderPaymentMode = this.getPurchaseOrderPaymentMode();
      result = result * 59 + ($purchaseOrderPaymentMode == null ? 43 : $purchaseOrderPaymentMode.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $boolUsed = this.getBoolUsed();
      result = result * 59 + ($boolUsed == null ? 43 : $boolUsed.hashCode());
      Object $purchaseStatus = this.getPurchaseStatus();
      result = result * 59 + ($purchaseStatus == null ? 43 : $purchaseStatus.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $boolTemporaryStorage = this.getBoolTemporaryStorage();
      result = result * 59 + ($boolTemporaryStorage == null ? 43 : $boolTemporaryStorage.hashCode());
      Object $useRequisitions = this.getUseRequisitions();
      result = result * 59 + ($useRequisitions == null ? 43 : $useRequisitions.hashCode());
      Object $boolDetail = this.getBoolDetail();
      result = result * 59 + ($boolDetail == null ? 43 : $boolDetail.hashCode());
      Object $editable = this.getEditable();
      result = result * 59 + ($editable == null ? 43 : $editable.hashCode());
      Object $dataStatus = this.getDataStatus();
      result = result * 59 + ($dataStatus == null ? 43 : $dataStatus.hashCode());
      Object $approveRecordIdNow = this.getApproveRecordIdNow();
      result = result * 59 + ($approveRecordIdNow == null ? 43 : $approveRecordIdNow.hashCode());
      Object $boolSysgen = this.getBoolSysgen();
      result = result * 59 + ($boolSysgen == null ? 43 : $boolSysgen.hashCode());
      Object $delButtonType = this.getDelButtonType();
      result = result * 59 + ($delButtonType == null ? 43 : $delButtonType.hashCode());
      Object $orderPlace = this.getOrderPlace();
      result = result * 59 + ($orderPlace == null ? 43 : $orderPlace.hashCode());
      Object $enclosureWageQuotaType = this.getEnclosureWageQuotaType();
      result = result * 59 + ($enclosureWageQuotaType == null ? 43 : $enclosureWageQuotaType.hashCode());
      Object $artifactWageQuotaType = this.getArtifactWageQuotaType();
      result = result * 59 + ($artifactWageQuotaType == null ? 43 : $artifactWageQuotaType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $serialNumberParent = this.getSerialNumberParent();
      result = result * 59 + ($serialNumberParent == null ? 43 : $serialNumberParent.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $applyPurchase = this.getApplyPurchase();
      result = result * 59 + ($applyPurchase == null ? 43 : $applyPurchase.hashCode());
      Object $auxMaterialIds = this.getAuxMaterialIds();
      result = result * 59 + ($auxMaterialIds == null ? 43 : $auxMaterialIds.hashCode());
      Object $auxMaterialNames = this.getAuxMaterialNames();
      result = result * 59 + ($auxMaterialNames == null ? 43 : $auxMaterialNames.hashCode());
      Object $otherMaterialIds = this.getOtherMaterialIds();
      result = result * 59 + ($otherMaterialIds == null ? 43 : $otherMaterialIds.hashCode());
      Object $otherMaterialNames = this.getOtherMaterialNames();
      result = result * 59 + ($otherMaterialNames == null ? 43 : $otherMaterialNames.hashCode());
      Object $gasMaterialIds = this.getGasMaterialIds();
      result = result * 59 + ($gasMaterialIds == null ? 43 : $gasMaterialIds.hashCode());
      Object $gasMaterialNames = this.getGasMaterialNames();
      result = result * 59 + ($gasMaterialNames == null ? 43 : $gasMaterialNames.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $meteUnit = this.getMeteUnit();
      result = result * 59 + ($meteUnit == null ? 43 : $meteUnit.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $branchCompany = this.getBranchCompany();
      result = result * 59 + ($branchCompany == null ? 43 : $branchCompany.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $inboundTotalQuantity = this.getInboundTotalQuantity();
      result = result * 59 + ($inboundTotalQuantity == null ? 43 : $inboundTotalQuantity.hashCode());
      Object $inboundTotalMete = this.getInboundTotalMete();
      result = result * 59 + ($inboundTotalMete == null ? 43 : $inboundTotalMete.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $lastOperatorName = this.getLastOperatorName();
      result = result * 59 + ($lastOperatorName == null ? 43 : $lastOperatorName.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $applyPurchaseStatus = this.getApplyPurchaseStatus();
      result = result * 59 + ($applyPurchaseStatus == null ? 43 : $applyPurchaseStatus.hashCode());
      Object $details = this.getDetails();
      result = result * 59 + ($details == null ? 43 : $details.hashCode());
      Object $wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
      result = result * 59 + ($wmsApproveRecordFlowDTOS == null ? 43 : $wmsApproveRecordFlowDTOS.hashCode());
      Object $approveRecordIds = this.getApproveRecordIds();
      result = result * 59 + ($approveRecordIds == null ? 43 : $approveRecordIds.hashCode());
      Object $projectManager = this.getProjectManager();
      result = result * 59 + ($projectManager == null ? 43 : $projectManager.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      result = result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
      Object $detailQuantityAndMetes = this.getDetailQuantityAndMetes();
      return result * 59 + ($detailQuantityAndMetes == null ? 43 : $detailQuantityAndMetes.hashCode());
   }

   @Override
   public String toString() {
      return "BriefPurchaseOrderDTO(id="
         + this.getId()
         + ", purchaseType="
         + this.getPurchaseType()
         + ", BoolAnnual="
         + this.getBoolAnnual()
         + ", supplyType="
         + this.getSupplyType()
         + ", basicClass="
         + this.getBasicClass()
         + ", materialType="
         + this.getMaterialType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", serialNumberParent="
         + this.getSerialNumberParent()
         + ", projects="
         + this.getProjects()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", logisticsTransportType="
         + this.getLogisticsTransportType()
         + ", logisticsPayerType="
         + this.getLogisticsPayerType()
         + ", purchaseOrderPaymentMode="
         + this.getPurchaseOrderPaymentMode()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", applyPurchase="
         + this.getApplyPurchase()
         + ", auxMaterialIds="
         + this.getAuxMaterialIds()
         + ", auxMaterialNames="
         + this.getAuxMaterialNames()
         + ", otherMaterialIds="
         + this.getOtherMaterialIds()
         + ", otherMaterialNames="
         + this.getOtherMaterialNames()
         + ", gasMaterialIds="
         + this.getGasMaterialIds()
         + ", gasMaterialNames="
         + this.getGasMaterialNames()
         + ", mete="
         + this.getMete()
         + ", meteUnit="
         + this.getMeteUnit()
         + ", amount="
         + this.getAmount()
         + ", branchCompany="
         + this.getBranchCompany()
         + ", supplier="
         + this.getSupplier()
         + ", taxRate="
         + this.getTaxRate()
         + ", inboundTotalQuantity="
         + this.getInboundTotalQuantity()
         + ", inboundTotalMete="
         + this.getInboundTotalMete()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", applicantName="
         + this.getApplicantName()
         + ", boolUsed="
         + this.getBoolUsed()
         + ", lastOperatorName="
         + this.getLastOperatorName()
         + ", attachments="
         + this.getAttachments()
         + ", remark="
         + this.getRemark()
         + ", purchaseStatus="
         + this.getPurchaseStatus()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", createTime="
         + this.getCreateTime()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", level="
         + this.getLevel()
         + ", applyPurchaseStatus="
         + this.getApplyPurchaseStatus()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", boolTemporaryStorage="
         + this.getBoolTemporaryStorage()
         + ", useRequisitions="
         + this.getUseRequisitions()
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
         + ", projectManager="
         + this.getProjectManager()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ", boolSysgen="
         + this.getBoolSysgen()
         + ", delButtonType="
         + this.getDelButtonType()
         + ", detailQuantityAndMetes="
         + this.getDetailQuantityAndMetes()
         + ", orderPlace="
         + this.getOrderPlace()
         + ", enclosureWageQuotaType="
         + this.getEnclosureWageQuotaType()
         + ", artifactWageQuotaType="
         + this.getArtifactWageQuotaType()
         + ")";
   }

   public BriefPurchaseOrderDTO(
      final Long id,
      final Integer purchaseType,
      final Boolean BoolAnnual,
      final Integer supplyType,
      final Integer basicClass,
      final Integer materialType,
      final String serialNumber,
      final String serialNumberParent,
      final List<ProjectInfo> projects,
      final Integer projectAttribute,
      final Integer logisticsTransportType,
      final Integer logisticsPayerType,
      final Integer purchaseOrderPaymentMode,
      final Integer weightMeasurementMode,
      final List<BriefIdAndSNDTO> applyPurchase,
      final List<Long> auxMaterialIds,
      final String auxMaterialNames,
      final List<Long> otherMaterialIds,
      final String otherMaterialNames,
      final List<Long> gasMaterialIds,
      final String gasMaterialNames,
      final BigDecimal mete,
      final String meteUnit,
      final BigDecimal amount,
      final BriefIdAndNameDTO branchCompany,
      final BriefIdAndNameDTO supplier,
      final BigDecimal taxRate,
      final BigDecimal inboundTotalQuantity,
      final BigDecimal inboundTotalMete,
      final Integer invoiceType,
      final String applicantName,
      final Boolean boolUsed,
      final String lastOperatorName,
      final List<AttachmentDTO> attachments,
      final String remark,
      final Integer purchaseStatus,
      final Integer settlementStatus,
      final LocalDateTime createTime,
      final LocalDateTime userUpdateTime,
      final Integer level,
      final String applyPurchaseStatus,
      final Integer reviewStatus,
      final Boolean boolTemporaryStorage,
      final Boolean useRequisitions,
      final Boolean boolDetail,
      final Boolean editable,
      final List<PurchaseOrderDetailDTO> details,
      final Integer dataStatus,
      final List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS,
      final Long approveRecordIdNow,
      final String approveRecordIds,
      final IdAndNameDTO projectManager,
      final IdAndNameDTO mesWorkshop,
      final Boolean boolSysgen,
      final Integer delButtonType,
      final List<DetailQuantityAndMete> detailQuantityAndMetes,
      final Integer orderPlace,
      final Integer enclosureWageQuotaType,
      final Integer artifactWageQuotaType
   ) {
      this.id = id;
      this.purchaseType = purchaseType;
      this.BoolAnnual = BoolAnnual;
      this.supplyType = supplyType;
      this.basicClass = basicClass;
      this.materialType = materialType;
      this.serialNumber = serialNumber;
      this.serialNumberParent = serialNumberParent;
      this.projects = projects;
      this.projectAttribute = projectAttribute;
      this.logisticsTransportType = logisticsTransportType;
      this.logisticsPayerType = logisticsPayerType;
      this.purchaseOrderPaymentMode = purchaseOrderPaymentMode;
      this.weightMeasurementMode = weightMeasurementMode;
      this.applyPurchase = applyPurchase;
      this.auxMaterialIds = auxMaterialIds;
      this.auxMaterialNames = auxMaterialNames;
      this.otherMaterialIds = otherMaterialIds;
      this.otherMaterialNames = otherMaterialNames;
      this.gasMaterialIds = gasMaterialIds;
      this.gasMaterialNames = gasMaterialNames;
      this.mete = mete;
      this.meteUnit = meteUnit;
      this.amount = amount;
      this.branchCompany = branchCompany;
      this.supplier = supplier;
      this.taxRate = taxRate;
      this.inboundTotalQuantity = inboundTotalQuantity;
      this.inboundTotalMete = inboundTotalMete;
      this.invoiceType = invoiceType;
      this.applicantName = applicantName;
      this.boolUsed = boolUsed;
      this.lastOperatorName = lastOperatorName;
      this.attachments = attachments;
      this.remark = remark;
      this.purchaseStatus = purchaseStatus;
      this.settlementStatus = settlementStatus;
      this.createTime = createTime;
      this.userUpdateTime = userUpdateTime;
      this.level = level;
      this.applyPurchaseStatus = applyPurchaseStatus;
      this.reviewStatus = reviewStatus;
      this.boolTemporaryStorage = boolTemporaryStorage;
      this.useRequisitions = useRequisitions;
      this.boolDetail = boolDetail;
      this.editable = editable;
      this.details = details;
      this.dataStatus = dataStatus;
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
      this.approveRecordIdNow = approveRecordIdNow;
      this.approveRecordIds = approveRecordIds;
      this.projectManager = projectManager;
      this.mesWorkshop = mesWorkshop;
      this.boolSysgen = boolSysgen;
      this.delButtonType = delButtonType;
      this.detailQuantityAndMetes = detailQuantityAndMetes;
      this.orderPlace = orderPlace;
      this.enclosureWageQuotaType = enclosureWageQuotaType;
      this.artifactWageQuotaType = artifactWageQuotaType;
   }

   public BriefPurchaseOrderDTO() {
   }

   public static class BriefPurchaseOrderDTOBuilder {
      private Long id;
      private Integer purchaseType;
      private Boolean BoolAnnual;
      private Integer supplyType;
      private Integer basicClass;
      private Integer materialType;
      private String serialNumber;
      private String serialNumberParent;
      private List<ProjectInfo> projects;
      private Integer projectAttribute;
      private Integer logisticsTransportType;
      private Integer logisticsPayerType;
      private Integer purchaseOrderPaymentMode;
      private Integer weightMeasurementMode;
      private List<BriefIdAndSNDTO> applyPurchase;
      private List<Long> auxMaterialIds;
      private String auxMaterialNames;
      private List<Long> otherMaterialIds;
      private String otherMaterialNames;
      private List<Long> gasMaterialIds;
      private String gasMaterialNames;
      private BigDecimal mete;
      private String meteUnit;
      private BigDecimal amount;
      private BriefIdAndNameDTO branchCompany;
      private BriefIdAndNameDTO supplier;
      private BigDecimal taxRate;
      private BigDecimal inboundTotalQuantity;
      private BigDecimal inboundTotalMete;
      private Integer invoiceType;
      private String applicantName;
      private Boolean boolUsed;
      private String lastOperatorName;
      private List<AttachmentDTO> attachments;
      private String remark;
      private Integer purchaseStatus;
      private Integer settlementStatus;
      private LocalDateTime createTime;
      private LocalDateTime userUpdateTime;
      private Integer level;
      private String applyPurchaseStatus;
      private Integer reviewStatus;
      private Boolean boolTemporaryStorage;
      private Boolean useRequisitions;
      private Boolean boolDetail;
      private Boolean editable;
      private List<PurchaseOrderDetailDTO> details;
      private Integer dataStatus;
      private List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS;
      private Long approveRecordIdNow;
      private String approveRecordIds;
      private IdAndNameDTO projectManager;
      private IdAndNameDTO mesWorkshop;
      private Boolean boolSysgen;
      private Integer delButtonType;
      private List<DetailQuantityAndMete> detailQuantityAndMetes;
      private Integer orderPlace;
      private Integer enclosureWageQuotaType;
      private Integer artifactWageQuotaType;

      BriefPurchaseOrderDTOBuilder() {
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder purchaseType(final Integer purchaseType) {
         this.purchaseType = purchaseType;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder BoolAnnual(final Boolean BoolAnnual) {
         this.BoolAnnual = BoolAnnual;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder supplyType(final Integer supplyType) {
         this.supplyType = supplyType;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder serialNumberParent(final String serialNumberParent) {
         this.serialNumberParent = serialNumberParent;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder projects(final List<ProjectInfo> projects) {
         this.projects = projects;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder logisticsTransportType(final Integer logisticsTransportType) {
         this.logisticsTransportType = logisticsTransportType;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder logisticsPayerType(final Integer logisticsPayerType) {
         this.logisticsPayerType = logisticsPayerType;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder purchaseOrderPaymentMode(final Integer purchaseOrderPaymentMode) {
         this.purchaseOrderPaymentMode = purchaseOrderPaymentMode;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder applyPurchase(final List<BriefIdAndSNDTO> applyPurchase) {
         this.applyPurchase = applyPurchase;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder auxMaterialIds(final List<Long> auxMaterialIds) {
         this.auxMaterialIds = auxMaterialIds;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder auxMaterialNames(final String auxMaterialNames) {
         this.auxMaterialNames = auxMaterialNames;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder otherMaterialIds(final List<Long> otherMaterialIds) {
         this.otherMaterialIds = otherMaterialIds;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder otherMaterialNames(final String otherMaterialNames) {
         this.otherMaterialNames = otherMaterialNames;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder gasMaterialIds(final List<Long> gasMaterialIds) {
         this.gasMaterialIds = gasMaterialIds;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder gasMaterialNames(final String gasMaterialNames) {
         this.gasMaterialNames = gasMaterialNames;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder meteUnit(final String meteUnit) {
         this.meteUnit = meteUnit;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder branchCompany(final BriefIdAndNameDTO branchCompany) {
         this.branchCompany = branchCompany;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder supplier(final BriefIdAndNameDTO supplier) {
         this.supplier = supplier;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder inboundTotalQuantity(final BigDecimal inboundTotalQuantity) {
         this.inboundTotalQuantity = inboundTotalQuantity;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder inboundTotalMete(final BigDecimal inboundTotalMete) {
         this.inboundTotalMete = inboundTotalMete;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder boolUsed(final Boolean boolUsed) {
         this.boolUsed = boolUsed;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder lastOperatorName(final String lastOperatorName) {
         this.lastOperatorName = lastOperatorName;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder purchaseStatus(final Integer purchaseStatus) {
         this.purchaseStatus = purchaseStatus;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder applyPurchaseStatus(final String applyPurchaseStatus) {
         this.applyPurchaseStatus = applyPurchaseStatus;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder boolTemporaryStorage(final Boolean boolTemporaryStorage) {
         this.boolTemporaryStorage = boolTemporaryStorage;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder useRequisitions(final Boolean useRequisitions) {
         this.useRequisitions = useRequisitions;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder boolDetail(final Boolean boolDetail) {
         this.boolDetail = boolDetail;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder editable(final Boolean editable) {
         this.editable = editable;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder details(final List<PurchaseOrderDetailDTO> details) {
         this.details = details;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder dataStatus(final Integer dataStatus) {
         this.dataStatus = dataStatus;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder wmsApproveRecordFlowDTOS(final List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS) {
         this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder approveRecordIdNow(final Long approveRecordIdNow) {
         this.approveRecordIdNow = approveRecordIdNow;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder approveRecordIds(final String approveRecordIds) {
         this.approveRecordIds = approveRecordIds;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder projectManager(final IdAndNameDTO projectManager) {
         this.projectManager = projectManager;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder mesWorkshop(final IdAndNameDTO mesWorkshop) {
         this.mesWorkshop = mesWorkshop;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder boolSysgen(final Boolean boolSysgen) {
         this.boolSysgen = boolSysgen;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder delButtonType(final Integer delButtonType) {
         this.delButtonType = delButtonType;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder detailQuantityAndMetes(final List<DetailQuantityAndMete> detailQuantityAndMetes) {
         this.detailQuantityAndMetes = detailQuantityAndMetes;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder orderPlace(final Integer orderPlace) {
         this.orderPlace = orderPlace;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder enclosureWageQuotaType(final Integer enclosureWageQuotaType) {
         this.enclosureWageQuotaType = enclosureWageQuotaType;
         return this;
      }

      public BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder artifactWageQuotaType(final Integer artifactWageQuotaType) {
         this.artifactWageQuotaType = artifactWageQuotaType;
         return this;
      }

      public BriefPurchaseOrderDTO build() {
         return new BriefPurchaseOrderDTO(
            this.id,
            this.purchaseType,
            this.BoolAnnual,
            this.supplyType,
            this.basicClass,
            this.materialType,
            this.serialNumber,
            this.serialNumberParent,
            this.projects,
            this.projectAttribute,
            this.logisticsTransportType,
            this.logisticsPayerType,
            this.purchaseOrderPaymentMode,
            this.weightMeasurementMode,
            this.applyPurchase,
            this.auxMaterialIds,
            this.auxMaterialNames,
            this.otherMaterialIds,
            this.otherMaterialNames,
            this.gasMaterialIds,
            this.gasMaterialNames,
            this.mete,
            this.meteUnit,
            this.amount,
            this.branchCompany,
            this.supplier,
            this.taxRate,
            this.inboundTotalQuantity,
            this.inboundTotalMete,
            this.invoiceType,
            this.applicantName,
            this.boolUsed,
            this.lastOperatorName,
            this.attachments,
            this.remark,
            this.purchaseStatus,
            this.settlementStatus,
            this.createTime,
            this.userUpdateTime,
            this.level,
            this.applyPurchaseStatus,
            this.reviewStatus,
            this.boolTemporaryStorage,
            this.useRequisitions,
            this.boolDetail,
            this.editable,
            this.details,
            this.dataStatus,
            this.wmsApproveRecordFlowDTOS,
            this.approveRecordIdNow,
            this.approveRecordIds,
            this.projectManager,
            this.mesWorkshop,
            this.boolSysgen,
            this.delButtonType,
            this.detailQuantityAndMetes,
            this.orderPlace,
            this.enclosureWageQuotaType,
            this.artifactWageQuotaType
         );
      }

      @Override
      public String toString() {
         return "BriefPurchaseOrderDTO.BriefPurchaseOrderDTOBuilder(id="
            + this.id
            + ", purchaseType="
            + this.purchaseType
            + ", BoolAnnual="
            + this.BoolAnnual
            + ", supplyType="
            + this.supplyType
            + ", basicClass="
            + this.basicClass
            + ", materialType="
            + this.materialType
            + ", serialNumber="
            + this.serialNumber
            + ", serialNumberParent="
            + this.serialNumberParent
            + ", projects="
            + this.projects
            + ", projectAttribute="
            + this.projectAttribute
            + ", logisticsTransportType="
            + this.logisticsTransportType
            + ", logisticsPayerType="
            + this.logisticsPayerType
            + ", purchaseOrderPaymentMode="
            + this.purchaseOrderPaymentMode
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", applyPurchase="
            + this.applyPurchase
            + ", auxMaterialIds="
            + this.auxMaterialIds
            + ", auxMaterialNames="
            + this.auxMaterialNames
            + ", otherMaterialIds="
            + this.otherMaterialIds
            + ", otherMaterialNames="
            + this.otherMaterialNames
            + ", gasMaterialIds="
            + this.gasMaterialIds
            + ", gasMaterialNames="
            + this.gasMaterialNames
            + ", mete="
            + this.mete
            + ", meteUnit="
            + this.meteUnit
            + ", amount="
            + this.amount
            + ", branchCompany="
            + this.branchCompany
            + ", supplier="
            + this.supplier
            + ", taxRate="
            + this.taxRate
            + ", inboundTotalQuantity="
            + this.inboundTotalQuantity
            + ", inboundTotalMete="
            + this.inboundTotalMete
            + ", invoiceType="
            + this.invoiceType
            + ", applicantName="
            + this.applicantName
            + ", boolUsed="
            + this.boolUsed
            + ", lastOperatorName="
            + this.lastOperatorName
            + ", attachments="
            + this.attachments
            + ", remark="
            + this.remark
            + ", purchaseStatus="
            + this.purchaseStatus
            + ", settlementStatus="
            + this.settlementStatus
            + ", createTime="
            + this.createTime
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", level="
            + this.level
            + ", applyPurchaseStatus="
            + this.applyPurchaseStatus
            + ", reviewStatus="
            + this.reviewStatus
            + ", boolTemporaryStorage="
            + this.boolTemporaryStorage
            + ", useRequisitions="
            + this.useRequisitions
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
            + ", projectManager="
            + this.projectManager
            + ", mesWorkshop="
            + this.mesWorkshop
            + ", boolSysgen="
            + this.boolSysgen
            + ", delButtonType="
            + this.delButtonType
            + ", detailQuantityAndMetes="
            + this.detailQuantityAndMetes
            + ", orderPlace="
            + this.orderPlace
            + ", enclosureWageQuotaType="
            + this.enclosureWageQuotaType
            + ", artifactWageQuotaType="
            + this.artifactWageQuotaType
            + ")";
      }
   }
}
