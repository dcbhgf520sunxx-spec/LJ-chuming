package com.hzchum.scim.scm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PurchaseOrderDTO {
   private Long id;
   private Integer purchaseType;
   private Integer supplyType;
   private Integer materialType;
   private Integer basicClass;
   private String basicClassName;
   private String serialNumber;
   private String serialNumberParent;
   private String projectIds;
   private List<ProjectInfo> projects;
   private ProjectInfo project;
   private com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO projectManager;
   private Integer projectAttribute;
   private Long applicantId;
   private String applicantName;
   private String lastOperatorName;
   private List<Long> strucAreaIds;
   private List<Long> enclAreaIds;
   private List<String> applyPurchaseSN;
   private List<Long> auxMaterialIds;
   private List<Long> otherMaterialIds;
   private List<Long> gasMaterialIds;
   private BriefIdAndNameDTO supplier;
   private BigDecimal mete;
   private BigDecimal amount;
   private String meteUnit;
   private BriefIdAndNameDTO branchCompany;
   private BigDecimal taxRate;
   private Integer invoiceType;
   private Integer weightMeasurementMode;
   private Integer logisticsTransportType;
   private Integer logisticsPayerType;
   private Integer purchaseOrderPaymentMode;
   private List<AttachmentDTO> attachments;
   private Integer purchaseStatus;
   private Integer settlementStatus;
   private String remark;
   private Boolean editable;
   private Boolean boolUsed;
   private LocalDateTime userUpdateTime;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;
   private Integer level;
   private Integer reviewStatus;
   private Boolean boolAnnual;
   private Boolean boolTemporaryStorage;
   private String applyPurchaseStatus;
   private Boolean useRequisitions;
   private Boolean boolDetail;
   @ApiModelProperty("结算额（元）")
   private BigDecimal settlementAmount;
   @ApiModelProperty("预结算额（元）")
   private BigDecimal preSettlementAmount;
   @ApiModelProperty("入库额（元）")
   private BigDecimal inboundAmount;
   @ApiModelProperty("累计付款（元）")
   private BigDecimal cumulativePayment;
   @ApiModelProperty("未付款（元）")
   private BigDecimal unpaidAmount;
   @ApiModelProperty("付款率")
   private BigDecimal paymentRate;
   @ApiModelProperty("累计开票（元）")
   private BigDecimal cumulativeInvoice;
   @ApiModelProperty("开票率")
   private BigDecimal invoiceRate;
   private List<PurchaseOrderDetailDTO> purchaseOrderDetailDTOS;
   private Integer dataStatus;
   private List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS;
   private Long approveRecordIdNow;
   private String approveRecordIds;
   private Integer orderPlace;
   private Integer enclosureWageQuotaType;
   private Integer artifactWageQuotaType;
   @ApiModelProperty("待付款审批")
   private Integer paymentSize;
   @ApiModelProperty("待开票审批")
   private Integer invoiceSize;
   @ApiModelProperty("结算待审批数")
   private Integer settlementSize;
   private com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO mesWorkshop;
   @ApiModelProperty("预结算待审批数")
   private Integer preSettlementSize;
   private Long supplierId;
   @ApiModelProperty("实际入库量占比")
   private BigDecimal actualInboundMeteRatio;

   public static PurchaseOrderDTO.PurchaseOrderDTOBuilder builder() {
      return new PurchaseOrderDTO.PurchaseOrderDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getPurchaseType() {
      return this.purchaseType;
   }

   public Integer getSupplyType() {
      return this.supplyType;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getBasicClassName() {
      return this.basicClassName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSerialNumberParent() {
      return this.serialNumberParent;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public List<ProjectInfo> getProjects() {
      return this.projects;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO getProjectManager() {
      return this.projectManager;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getLastOperatorName() {
      return this.lastOperatorName;
   }

   public List<Long> getStrucAreaIds() {
      return this.strucAreaIds;
   }

   public List<Long> getEnclAreaIds() {
      return this.enclAreaIds;
   }

   public List<String> getApplyPurchaseSN() {
      return this.applyPurchaseSN;
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

   public BriefIdAndNameDTO getSupplier() {
      return this.supplier;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getMeteUnit() {
      return this.meteUnit;
   }

   public BriefIdAndNameDTO getBranchCompany() {
      return this.branchCompany;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
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

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public Integer getPurchaseStatus() {
      return this.purchaseStatus;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getEditable() {
      return this.editable;
   }

   public Boolean getBoolUsed() {
      return this.boolUsed;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Boolean getBoolAnnual() {
      return this.boolAnnual;
   }

   public Boolean getBoolTemporaryStorage() {
      return this.boolTemporaryStorage;
   }

   public String getApplyPurchaseStatus() {
      return this.applyPurchaseStatus;
   }

   public Boolean getUseRequisitions() {
      return this.useRequisitions;
   }

   public Boolean getBoolDetail() {
      return this.boolDetail;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getPreSettlementAmount() {
      return this.preSettlementAmount;
   }

   public BigDecimal getInboundAmount() {
      return this.inboundAmount;
   }

   public BigDecimal getCumulativePayment() {
      return this.cumulativePayment;
   }

   public BigDecimal getUnpaidAmount() {
      return this.unpaidAmount;
   }

   public BigDecimal getPaymentRate() {
      return this.paymentRate;
   }

   public BigDecimal getCumulativeInvoice() {
      return this.cumulativeInvoice;
   }

   public BigDecimal getInvoiceRate() {
      return this.invoiceRate;
   }

   public List<PurchaseOrderDetailDTO> getPurchaseOrderDetailDTOS() {
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

   public Integer getOrderPlace() {
      return this.orderPlace;
   }

   public Integer getEnclosureWageQuotaType() {
      return this.enclosureWageQuotaType;
   }

   public Integer getArtifactWageQuotaType() {
      return this.artifactWageQuotaType;
   }

   public Integer getPaymentSize() {
      return this.paymentSize;
   }

   public Integer getInvoiceSize() {
      return this.invoiceSize;
   }

   public Integer getSettlementSize() {
      return this.settlementSize;
   }

   public com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO getMesWorkshop() {
      return this.mesWorkshop;
   }

   public Integer getPreSettlementSize() {
      return this.preSettlementSize;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public BigDecimal getActualInboundMeteRatio() {
      return this.actualInboundMeteRatio;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPurchaseType(final Integer purchaseType) {
      this.purchaseType = purchaseType;
   }

   public void setSupplyType(final Integer supplyType) {
      this.supplyType = supplyType;
   }

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setBasicClassName(final String basicClassName) {
      this.basicClassName = basicClassName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSerialNumberParent(final String serialNumberParent) {
      this.serialNumberParent = serialNumberParent;
   }

   public void setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
   }

   public void setProjects(final List<ProjectInfo> projects) {
      this.projects = projects;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setProjectManager(final com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO projectManager) {
      this.projectManager = projectManager;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setLastOperatorName(final String lastOperatorName) {
      this.lastOperatorName = lastOperatorName;
   }

   public void setStrucAreaIds(final List<Long> strucAreaIds) {
      this.strucAreaIds = strucAreaIds;
   }

   public void setEnclAreaIds(final List<Long> enclAreaIds) {
      this.enclAreaIds = enclAreaIds;
   }

   public void setApplyPurchaseSN(final List<String> applyPurchaseSN) {
      this.applyPurchaseSN = applyPurchaseSN;
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

   public void setSupplier(final BriefIdAndNameDTO supplier) {
      this.supplier = supplier;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setMeteUnit(final String meteUnit) {
      this.meteUnit = meteUnit;
   }

   public void setBranchCompany(final BriefIdAndNameDTO branchCompany) {
      this.branchCompany = branchCompany;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
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

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setPurchaseStatus(final Integer purchaseStatus) {
      this.purchaseStatus = purchaseStatus;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setEditable(final Boolean editable) {
      this.editable = editable;
   }

   public void setBoolUsed(final Boolean boolUsed) {
      this.boolUsed = boolUsed;
   }

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setBoolAnnual(final Boolean boolAnnual) {
      this.boolAnnual = boolAnnual;
   }

   public void setBoolTemporaryStorage(final Boolean boolTemporaryStorage) {
      this.boolTemporaryStorage = boolTemporaryStorage;
   }

   public void setApplyPurchaseStatus(final String applyPurchaseStatus) {
      this.applyPurchaseStatus = applyPurchaseStatus;
   }

   public void setUseRequisitions(final Boolean useRequisitions) {
      this.useRequisitions = useRequisitions;
   }

   public void setBoolDetail(final Boolean boolDetail) {
      this.boolDetail = boolDetail;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setPreSettlementAmount(final BigDecimal preSettlementAmount) {
      this.preSettlementAmount = preSettlementAmount;
   }

   public void setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
   }

   public void setCumulativePayment(final BigDecimal cumulativePayment) {
      this.cumulativePayment = cumulativePayment;
   }

   public void setUnpaidAmount(final BigDecimal unpaidAmount) {
      this.unpaidAmount = unpaidAmount;
   }

   public void setPaymentRate(final BigDecimal paymentRate) {
      this.paymentRate = paymentRate;
   }

   public void setCumulativeInvoice(final BigDecimal cumulativeInvoice) {
      this.cumulativeInvoice = cumulativeInvoice;
   }

   public void setInvoiceRate(final BigDecimal invoiceRate) {
      this.invoiceRate = invoiceRate;
   }

   public void setPurchaseOrderDetailDTOS(final List<PurchaseOrderDetailDTO> purchaseOrderDetailDTOS) {
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

   public void setOrderPlace(final Integer orderPlace) {
      this.orderPlace = orderPlace;
   }

   public void setEnclosureWageQuotaType(final Integer enclosureWageQuotaType) {
      this.enclosureWageQuotaType = enclosureWageQuotaType;
   }

   public void setArtifactWageQuotaType(final Integer artifactWageQuotaType) {
      this.artifactWageQuotaType = artifactWageQuotaType;
   }

   public void setPaymentSize(final Integer paymentSize) {
      this.paymentSize = paymentSize;
   }

   public void setInvoiceSize(final Integer invoiceSize) {
      this.invoiceSize = invoiceSize;
   }

   public void setSettlementSize(final Integer settlementSize) {
      this.settlementSize = settlementSize;
   }

   public void setMesWorkshop(final com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
   }

   public void setPreSettlementSize(final Integer preSettlementSize) {
      this.preSettlementSize = preSettlementSize;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setActualInboundMeteRatio(final BigDecimal actualInboundMeteRatio) {
      this.actualInboundMeteRatio = actualInboundMeteRatio;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseOrderDTO)) {
         return false;
      }

      PurchaseOrderDTO other = (PurchaseOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseType = this.getPurchaseType();
         Object other$purchaseType = other.getPurchaseType();
         if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
            Object this$supplyType = this.getSupplyType();
            Object other$supplyType = other.getSupplyType();
            if (this$supplyType == null ? other$supplyType == null : this$supplyType.equals(other$supplyType)) {
               Object this$materialType = this.getMaterialType();
               Object other$materialType = other.getMaterialType();
               if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$projectAttribute = this.getProjectAttribute();
                     Object other$projectAttribute = other.getProjectAttribute();
                     if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                        Object this$applicantId = this.getApplicantId();
                        Object other$applicantId = other.getApplicantId();
                        if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                           Object this$invoiceType = this.getInvoiceType();
                           Object other$invoiceType = other.getInvoiceType();
                           if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                              Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                              Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                              if (this$weightMeasurementMode == null
                                 ? other$weightMeasurementMode == null
                                 : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                 Object this$logisticsTransportType = this.getLogisticsTransportType();
                                 Object other$logisticsTransportType = other.getLogisticsTransportType();
                                 if (this$logisticsTransportType == null
                                    ? other$logisticsTransportType == null
                                    : this$logisticsTransportType.equals(other$logisticsTransportType)) {
                                    Object this$logisticsPayerType = this.getLogisticsPayerType();
                                    Object other$logisticsPayerType = other.getLogisticsPayerType();
                                    if (this$logisticsPayerType == null
                                       ? other$logisticsPayerType == null
                                       : this$logisticsPayerType.equals(other$logisticsPayerType)) {
                                       Object this$purchaseOrderPaymentMode = this.getPurchaseOrderPaymentMode();
                                       Object other$purchaseOrderPaymentMode = other.getPurchaseOrderPaymentMode();
                                       if (this$purchaseOrderPaymentMode == null
                                          ? other$purchaseOrderPaymentMode == null
                                          : this$purchaseOrderPaymentMode.equals(other$purchaseOrderPaymentMode)) {
                                          Object this$purchaseStatus = this.getPurchaseStatus();
                                          Object other$purchaseStatus = other.getPurchaseStatus();
                                          if (this$purchaseStatus == null ? other$purchaseStatus == null : this$purchaseStatus.equals(other$purchaseStatus)) {
                                             Object this$settlementStatus = this.getSettlementStatus();
                                             Object other$settlementStatus = other.getSettlementStatus();
                                             if (this$settlementStatus == null
                                                ? other$settlementStatus == null
                                                : this$settlementStatus.equals(other$settlementStatus)) {
                                                Object this$editable = this.getEditable();
                                                Object other$editable = other.getEditable();
                                                if (this$editable == null ? other$editable == null : this$editable.equals(other$editable)) {
                                                   Object this$boolUsed = this.getBoolUsed();
                                                   Object other$boolUsed = other.getBoolUsed();
                                                   if (this$boolUsed == null ? other$boolUsed == null : this$boolUsed.equals(other$boolUsed)) {
                                                      Object this$level = this.getLevel();
                                                      Object other$level = other.getLevel();
                                                      if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                                                         Object this$reviewStatus = this.getReviewStatus();
                                                         Object other$reviewStatus = other.getReviewStatus();
                                                         if (this$reviewStatus == null
                                                            ? other$reviewStatus == null
                                                            : this$reviewStatus.equals(other$reviewStatus)) {
                                                            Object this$boolAnnual = this.getBoolAnnual();
                                                            Object other$boolAnnual = other.getBoolAnnual();
                                                            if (this$boolAnnual == null ? other$boolAnnual == null : this$boolAnnual.equals(other$boolAnnual)) {
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
                                                                                       Object this$paymentSize = this.getPaymentSize();
                                                                                       Object other$paymentSize = other.getPaymentSize();
                                                                                       if (this$paymentSize == null
                                                                                          ? other$paymentSize == null
                                                                                          : this$paymentSize.equals(other$paymentSize)) {
                                                                                          Object this$invoiceSize = this.getInvoiceSize();
                                                                                          Object other$invoiceSize = other.getInvoiceSize();
                                                                                          if (this$invoiceSize == null
                                                                                             ? other$invoiceSize == null
                                                                                             : this$invoiceSize.equals(other$invoiceSize)) {
                                                                                             Object this$settlementSize = this.getSettlementSize();
                                                                                             Object other$settlementSize = other.getSettlementSize();
                                                                                             if (this$settlementSize == null
                                                                                                ? other$settlementSize == null
                                                                                                : this$settlementSize.equals(other$settlementSize)) {
                                                                                                Object this$preSettlementSize = this.getPreSettlementSize();
                                                                                                Object other$preSettlementSize = other.getPreSettlementSize();
                                                                                                if (this$preSettlementSize == null
                                                                                                   ? other$preSettlementSize == null
                                                                                                   : this$preSettlementSize.equals(other$preSettlementSize)) {
                                                                                                   Object this$supplierId = this.getSupplierId();
                                                                                                   Object other$supplierId = other.getSupplierId();
                                                                                                   if (this$supplierId == null
                                                                                                      ? other$supplierId == null
                                                                                                      : this$supplierId.equals(other$supplierId)) {
                                                                                                      Object this$basicClassName = this.getBasicClassName();
                                                                                                      Object other$basicClassName = other.getBasicClassName();
                                                                                                      if (this$basicClassName == null
                                                                                                         ? other$basicClassName == null
                                                                                                         : this$basicClassName.equals(other$basicClassName)) {
                                                                                                         Object this$serialNumber = this.getSerialNumber();
                                                                                                         Object other$serialNumber = other.getSerialNumber();
                                                                                                         if (this$serialNumber == null
                                                                                                            ? other$serialNumber == null
                                                                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                                                                            Object this$serialNumberParent = this.getSerialNumberParent();
                                                                                                            Object other$serialNumberParent = other.getSerialNumberParent();
                                                                                                            if (this$serialNumberParent == null
                                                                                                               ? other$serialNumberParent == null
                                                                                                               : this$serialNumberParent.equals(
                                                                                                                  other$serialNumberParent
                                                                                                               )) {
                                                                                                               Object this$projectIds = this.getProjectIds();
                                                                                                               Object other$projectIds = other.getProjectIds();
                                                                                                               if (this$projectIds == null
                                                                                                                  ? other$projectIds == null
                                                                                                                  : this$projectIds.equals(other$projectIds)) {
                                                                                                                  Object this$projects = this.getProjects();
                                                                                                                  Object other$projects = other.getProjects();
                                                                                                                  if (this$projects == null
                                                                                                                     ? other$projects == null
                                                                                                                     : this$projects.equals(other$projects)) {
                                                                                                                     Object this$project = this.getProject();
                                                                                                                     Object other$project = other.getProject();
                                                                                                                     if (this$project == null
                                                                                                                        ? other$project == null
                                                                                                                        : this$project.equals(other$project)) {
                                                                                                                        Object this$projectManager = this.getProjectManager();
                                                                                                                        Object other$projectManager = other.getProjectManager();
                                                                                                                        if (this$projectManager == null
                                                                                                                           ? other$projectManager == null
                                                                                                                           : this$projectManager.equals(
                                                                                                                              other$projectManager
                                                                                                                           )) {
                                                                                                                           Object this$applicantName = this.getApplicantName();
                                                                                                                           Object other$applicantName = other.getApplicantName();
                                                                                                                           if (this$applicantName == null
                                                                                                                              ? other$applicantName == null
                                                                                                                              : this$applicantName.equals(
                                                                                                                                 other$applicantName
                                                                                                                              )) {
                                                                                                                              Object this$lastOperatorName = this.getLastOperatorName();
                                                                                                                              Object other$lastOperatorName = other.getLastOperatorName();
                                                                                                                              if (this$lastOperatorName == null
                                                                                                                                 ? other$lastOperatorName
                                                                                                                                    == null
                                                                                                                                 : this$lastOperatorName.equals(
                                                                                                                                    other$lastOperatorName
                                                                                                                                 )) {
                                                                                                                                 Object this$strucAreaIds = this.getStrucAreaIds();
                                                                                                                                 Object other$strucAreaIds = other.getStrucAreaIds();
                                                                                                                                 if (this$strucAreaIds == null
                                                                                                                                    ? other$strucAreaIds
                                                                                                                                       == null
                                                                                                                                    : this$strucAreaIds.equals(
                                                                                                                                       other$strucAreaIds
                                                                                                                                    )) {
                                                                                                                                    Object this$enclAreaIds = this.getEnclAreaIds();
                                                                                                                                    Object other$enclAreaIds = other.getEnclAreaIds();
                                                                                                                                    if (this$enclAreaIds
                                                                                                                                          == null
                                                                                                                                       ? other$enclAreaIds
                                                                                                                                          == null
                                                                                                                                       : this$enclAreaIds.equals(
                                                                                                                                          other$enclAreaIds
                                                                                                                                       )) {
                                                                                                                                       Object this$applyPurchaseSN = this.getApplyPurchaseSN();
                                                                                                                                       Object other$applyPurchaseSN = other.getApplyPurchaseSN();
                                                                                                                                       if (this$applyPurchaseSN
                                                                                                                                             == null
                                                                                                                                          ? other$applyPurchaseSN
                                                                                                                                             == null
                                                                                                                                          : this$applyPurchaseSN.equals(
                                                                                                                                             other$applyPurchaseSN
                                                                                                                                          )) {
                                                                                                                                          Object this$auxMaterialIds = this.getAuxMaterialIds();
                                                                                                                                          Object other$auxMaterialIds = other.getAuxMaterialIds();
                                                                                                                                          if (this$auxMaterialIds
                                                                                                                                                == null
                                                                                                                                             ? other$auxMaterialIds
                                                                                                                                                == null
                                                                                                                                             : this$auxMaterialIds.equals(
                                                                                                                                                other$auxMaterialIds
                                                                                                                                             )) {
                                                                                                                                             Object this$otherMaterialIds = this.getOtherMaterialIds();
                                                                                                                                             Object other$otherMaterialIds = other.getOtherMaterialIds();
                                                                                                                                             if (this$otherMaterialIds
                                                                                                                                                   == null
                                                                                                                                                ? other$otherMaterialIds
                                                                                                                                                   == null
                                                                                                                                                : this$otherMaterialIds.equals(
                                                                                                                                                   other$otherMaterialIds
                                                                                                                                                )) {
                                                                                                                                                Object this$gasMaterialIds = this.getGasMaterialIds();
                                                                                                                                                Object other$gasMaterialIds = other.getGasMaterialIds();
                                                                                                                                                if (this$gasMaterialIds
                                                                                                                                                      == null
                                                                                                                                                   ? other$gasMaterialIds
                                                                                                                                                      == null
                                                                                                                                                   : this$gasMaterialIds.equals(
                                                                                                                                                      other$gasMaterialIds
                                                                                                                                                   )) {
                                                                                                                                                   Object this$supplier = this.getSupplier();
                                                                                                                                                   Object other$supplier = other.getSupplier();
                                                                                                                                                   if (this$supplier
                                                                                                                                                         == null
                                                                                                                                                      ? other$supplier
                                                                                                                                                         == null
                                                                                                                                                      : this$supplier.equals(
                                                                                                                                                         other$supplier
                                                                                                                                                      )) {
                                                                                                                                                      Object this$mete = this.getMete();
                                                                                                                                                      Object other$mete = other.getMete();
                                                                                                                                                      if (this$mete
                                                                                                                                                            == null
                                                                                                                                                         ? other$mete
                                                                                                                                                            == null
                                                                                                                                                         : this$mete.equals(
                                                                                                                                                            other$mete
                                                                                                                                                         )) {
                                                                                                                                                         Object this$amount = this.getAmount();
                                                                                                                                                         Object other$amount = other.getAmount();
                                                                                                                                                         if (this$amount
                                                                                                                                                               == null
                                                                                                                                                            ? other$amount
                                                                                                                                                               == null
                                                                                                                                                            : this$amount.equals(
                                                                                                                                                               other$amount
                                                                                                                                                            )) {
                                                                                                                                                            Object this$meteUnit = this.getMeteUnit();
                                                                                                                                                            Object other$meteUnit = other.getMeteUnit();
                                                                                                                                                            if (this$meteUnit
                                                                                                                                                                  == null
                                                                                                                                                               ? other$meteUnit
                                                                                                                                                                  == null
                                                                                                                                                               : this$meteUnit.equals(
                                                                                                                                                                  other$meteUnit
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$branchCompany = this.getBranchCompany();
                                                                                                                                                               Object other$branchCompany = other.getBranchCompany();
                                                                                                                                                               if (this$branchCompany
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$branchCompany
                                                                                                                                                                     == null
                                                                                                                                                                  : this$branchCompany.equals(
                                                                                                                                                                     other$branchCompany
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$taxRate = this.getTaxRate();
                                                                                                                                                                  Object other$taxRate = other.getTaxRate();
                                                                                                                                                                  if (this$taxRate
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$taxRate
                                                                                                                                                                        == null
                                                                                                                                                                     : this$taxRate.equals(
                                                                                                                                                                        other$taxRate
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$attachments = this.getAttachments();
                                                                                                                                                                     Object other$attachments = other.getAttachments();
                                                                                                                                                                     if (this$attachments
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$attachments
                                                                                                                                                                           == null
                                                                                                                                                                        : this$attachments.equals(
                                                                                                                                                                           other$attachments
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$remark = this.getRemark();
                                                                                                                                                                        Object other$remark = other.getRemark();
                                                                                                                                                                        if (this$remark
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$remark
                                                                                                                                                                              == null
                                                                                                                                                                           : this$remark.equals(
                                                                                                                                                                              other$remark
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
                                                                                                                                                                                 Object this$updateTime = this.getUpdateTime();
                                                                                                                                                                                 Object other$updateTime = other.getUpdateTime();
                                                                                                                                                                                 if (this$updateTime
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$updateTime
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$updateTime.equals(
                                                                                                                                                                                       other$updateTime
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
                                                                                                                                                                                       Object this$settlementAmount = this.getSettlementAmount();
                                                                                                                                                                                       Object other$settlementAmount = other.getSettlementAmount();
                                                                                                                                                                                       if (this$settlementAmount
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$settlementAmount
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$settlementAmount.equals(
                                                                                                                                                                                             other$settlementAmount
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Object this$preSettlementAmount = this.getPreSettlementAmount();
                                                                                                                                                                                          Object other$preSettlementAmount = other.getPreSettlementAmount();
                                                                                                                                                                                          if (this$preSettlementAmount
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$preSettlementAmount
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$preSettlementAmount.equals(
                                                                                                                                                                                                other$preSettlementAmount
                                                                                                                                                                                             )
                                                                                                                                                                                             )
                                                                                                                                                                                           {
                                                                                                                                                                                             Object this$inboundAmount = this.getInboundAmount();
                                                                                                                                                                                             Object other$inboundAmount = other.getInboundAmount();
                                                                                                                                                                                             if (this$inboundAmount
                                                                                                                                                                                                   == null
                                                                                                                                                                                                ? other$inboundAmount
                                                                                                                                                                                                   == null
                                                                                                                                                                                                : this$inboundAmount.equals(
                                                                                                                                                                                                   other$inboundAmount
                                                                                                                                                                                                )
                                                                                                                                                                                                )
                                                                                                                                                                                              {
                                                                                                                                                                                                Object this$cumulativePayment = this.getCumulativePayment();
                                                                                                                                                                                                Object other$cumulativePayment = other.getCumulativePayment();
                                                                                                                                                                                                if (this$cumulativePayment
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   ? other$cumulativePayment
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   : this$cumulativePayment.equals(
                                                                                                                                                                                                      other$cumulativePayment
                                                                                                                                                                                                   )
                                                                                                                                                                                                   )
                                                                                                                                                                                                 {
                                                                                                                                                                                                   Object this$unpaidAmount = this.getUnpaidAmount();
                                                                                                                                                                                                   Object other$unpaidAmount = other.getUnpaidAmount();
                                                                                                                                                                                                   if (this$unpaidAmount
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      ? other$unpaidAmount
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      : this$unpaidAmount.equals(
                                                                                                                                                                                                         other$unpaidAmount
                                                                                                                                                                                                      )
                                                                                                                                                                                                      )
                                                                                                                                                                                                    {
                                                                                                                                                                                                      Object this$paymentRate = this.getPaymentRate();
                                                                                                                                                                                                      Object other$paymentRate = other.getPaymentRate();
                                                                                                                                                                                                      if (this$paymentRate
                                                                                                                                                                                                            == null
                                                                                                                                                                                                         ? other$paymentRate
                                                                                                                                                                                                            == null
                                                                                                                                                                                                         : this$paymentRate.equals(
                                                                                                                                                                                                            other$paymentRate
                                                                                                                                                                                                         )
                                                                                                                                                                                                         )
                                                                                                                                                                                                       {
                                                                                                                                                                                                         Object this$cumulativeInvoice = this.getCumulativeInvoice();
                                                                                                                                                                                                         Object other$cumulativeInvoice = other.getCumulativeInvoice();
                                                                                                                                                                                                         if (this$cumulativeInvoice
                                                                                                                                                                                                               == null
                                                                                                                                                                                                            ? other$cumulativeInvoice
                                                                                                                                                                                                               == null
                                                                                                                                                                                                            : this$cumulativeInvoice.equals(
                                                                                                                                                                                                               other$cumulativeInvoice
                                                                                                                                                                                                            )
                                                                                                                                                                                                            )
                                                                                                                                                                                                          {
                                                                                                                                                                                                            Object this$invoiceRate = this.getInvoiceRate();
                                                                                                                                                                                                            Object other$invoiceRate = other.getInvoiceRate();
                                                                                                                                                                                                            if (this$invoiceRate
                                                                                                                                                                                                                  == null
                                                                                                                                                                                                               ? other$invoiceRate
                                                                                                                                                                                                                  == null
                                                                                                                                                                                                               : this$invoiceRate.equals(
                                                                                                                                                                                                                  other$invoiceRate
                                                                                                                                                                                                               )
                                                                                                                                                                                                               )
                                                                                                                                                                                                             {
                                                                                                                                                                                                               Object this$purchaseOrderDetailDTOS = this.getPurchaseOrderDetailDTOS();
                                                                                                                                                                                                               Object other$purchaseOrderDetailDTOS = other.getPurchaseOrderDetailDTOS();
                                                                                                                                                                                                               if (this$purchaseOrderDetailDTOS
                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                  ? other$purchaseOrderDetailDTOS
                                                                                                                                                                                                                     == null
                                                                                                                                                                                                                  : this$purchaseOrderDetailDTOS.equals(
                                                                                                                                                                                                                     other$purchaseOrderDetailDTOS
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
                                                                                                                                                                                                                           Object this$actualInboundMeteRatio = this.getActualInboundMeteRatio();
                                                                                                                                                                                                                           Object other$actualInboundMeteRatio = other.getActualInboundMeteRatio();
                                                                                                                                                                                                                           return this$actualInboundMeteRatio
                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                              ? other$actualInboundMeteRatio
                                                                                                                                                                                                                                 == null
                                                                                                                                                                                                                              : this$actualInboundMeteRatio.equals(
                                                                                                                                                                                                                                 other$actualInboundMeteRatio
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
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof PurchaseOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $supplyType = this.getSupplyType();
      result = result * 59 + ($supplyType == null ? 43 : $supplyType.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $logisticsTransportType = this.getLogisticsTransportType();
      result = result * 59 + ($logisticsTransportType == null ? 43 : $logisticsTransportType.hashCode());
      Object $logisticsPayerType = this.getLogisticsPayerType();
      result = result * 59 + ($logisticsPayerType == null ? 43 : $logisticsPayerType.hashCode());
      Object $purchaseOrderPaymentMode = this.getPurchaseOrderPaymentMode();
      result = result * 59 + ($purchaseOrderPaymentMode == null ? 43 : $purchaseOrderPaymentMode.hashCode());
      Object $purchaseStatus = this.getPurchaseStatus();
      result = result * 59 + ($purchaseStatus == null ? 43 : $purchaseStatus.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $editable = this.getEditable();
      result = result * 59 + ($editable == null ? 43 : $editable.hashCode());
      Object $boolUsed = this.getBoolUsed();
      result = result * 59 + ($boolUsed == null ? 43 : $boolUsed.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $boolAnnual = this.getBoolAnnual();
      result = result * 59 + ($boolAnnual == null ? 43 : $boolAnnual.hashCode());
      Object $boolTemporaryStorage = this.getBoolTemporaryStorage();
      result = result * 59 + ($boolTemporaryStorage == null ? 43 : $boolTemporaryStorage.hashCode());
      Object $useRequisitions = this.getUseRequisitions();
      result = result * 59 + ($useRequisitions == null ? 43 : $useRequisitions.hashCode());
      Object $boolDetail = this.getBoolDetail();
      result = result * 59 + ($boolDetail == null ? 43 : $boolDetail.hashCode());
      Object $dataStatus = this.getDataStatus();
      result = result * 59 + ($dataStatus == null ? 43 : $dataStatus.hashCode());
      Object $approveRecordIdNow = this.getApproveRecordIdNow();
      result = result * 59 + ($approveRecordIdNow == null ? 43 : $approveRecordIdNow.hashCode());
      Object $orderPlace = this.getOrderPlace();
      result = result * 59 + ($orderPlace == null ? 43 : $orderPlace.hashCode());
      Object $enclosureWageQuotaType = this.getEnclosureWageQuotaType();
      result = result * 59 + ($enclosureWageQuotaType == null ? 43 : $enclosureWageQuotaType.hashCode());
      Object $artifactWageQuotaType = this.getArtifactWageQuotaType();
      result = result * 59 + ($artifactWageQuotaType == null ? 43 : $artifactWageQuotaType.hashCode());
      Object $paymentSize = this.getPaymentSize();
      result = result * 59 + ($paymentSize == null ? 43 : $paymentSize.hashCode());
      Object $invoiceSize = this.getInvoiceSize();
      result = result * 59 + ($invoiceSize == null ? 43 : $invoiceSize.hashCode());
      Object $settlementSize = this.getSettlementSize();
      result = result * 59 + ($settlementSize == null ? 43 : $settlementSize.hashCode());
      Object $preSettlementSize = this.getPreSettlementSize();
      result = result * 59 + ($preSettlementSize == null ? 43 : $preSettlementSize.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $basicClassName = this.getBasicClassName();
      result = result * 59 + ($basicClassName == null ? 43 : $basicClassName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $serialNumberParent = this.getSerialNumberParent();
      result = result * 59 + ($serialNumberParent == null ? 43 : $serialNumberParent.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $projectManager = this.getProjectManager();
      result = result * 59 + ($projectManager == null ? 43 : $projectManager.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $lastOperatorName = this.getLastOperatorName();
      result = result * 59 + ($lastOperatorName == null ? 43 : $lastOperatorName.hashCode());
      Object $strucAreaIds = this.getStrucAreaIds();
      result = result * 59 + ($strucAreaIds == null ? 43 : $strucAreaIds.hashCode());
      Object $enclAreaIds = this.getEnclAreaIds();
      result = result * 59 + ($enclAreaIds == null ? 43 : $enclAreaIds.hashCode());
      Object $applyPurchaseSN = this.getApplyPurchaseSN();
      result = result * 59 + ($applyPurchaseSN == null ? 43 : $applyPurchaseSN.hashCode());
      Object $auxMaterialIds = this.getAuxMaterialIds();
      result = result * 59 + ($auxMaterialIds == null ? 43 : $auxMaterialIds.hashCode());
      Object $otherMaterialIds = this.getOtherMaterialIds();
      result = result * 59 + ($otherMaterialIds == null ? 43 : $otherMaterialIds.hashCode());
      Object $gasMaterialIds = this.getGasMaterialIds();
      result = result * 59 + ($gasMaterialIds == null ? 43 : $gasMaterialIds.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $meteUnit = this.getMeteUnit();
      result = result * 59 + ($meteUnit == null ? 43 : $meteUnit.hashCode());
      Object $branchCompany = this.getBranchCompany();
      result = result * 59 + ($branchCompany == null ? 43 : $branchCompany.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $applyPurchaseStatus = this.getApplyPurchaseStatus();
      result = result * 59 + ($applyPurchaseStatus == null ? 43 : $applyPurchaseStatus.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $preSettlementAmount = this.getPreSettlementAmount();
      result = result * 59 + ($preSettlementAmount == null ? 43 : $preSettlementAmount.hashCode());
      Object $inboundAmount = this.getInboundAmount();
      result = result * 59 + ($inboundAmount == null ? 43 : $inboundAmount.hashCode());
      Object $cumulativePayment = this.getCumulativePayment();
      result = result * 59 + ($cumulativePayment == null ? 43 : $cumulativePayment.hashCode());
      Object $unpaidAmount = this.getUnpaidAmount();
      result = result * 59 + ($unpaidAmount == null ? 43 : $unpaidAmount.hashCode());
      Object $paymentRate = this.getPaymentRate();
      result = result * 59 + ($paymentRate == null ? 43 : $paymentRate.hashCode());
      Object $cumulativeInvoice = this.getCumulativeInvoice();
      result = result * 59 + ($cumulativeInvoice == null ? 43 : $cumulativeInvoice.hashCode());
      Object $invoiceRate = this.getInvoiceRate();
      result = result * 59 + ($invoiceRate == null ? 43 : $invoiceRate.hashCode());
      Object $purchaseOrderDetailDTOS = this.getPurchaseOrderDetailDTOS();
      result = result * 59 + ($purchaseOrderDetailDTOS == null ? 43 : $purchaseOrderDetailDTOS.hashCode());
      Object $wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
      result = result * 59 + ($wmsApproveRecordFlowDTOS == null ? 43 : $wmsApproveRecordFlowDTOS.hashCode());
      Object $approveRecordIds = this.getApproveRecordIds();
      result = result * 59 + ($approveRecordIds == null ? 43 : $approveRecordIds.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      result = result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
      Object $actualInboundMeteRatio = this.getActualInboundMeteRatio();
      return result * 59 + ($actualInboundMeteRatio == null ? 43 : $actualInboundMeteRatio.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseOrderDTO(id="
         + this.getId()
         + ", purchaseType="
         + this.getPurchaseType()
         + ", supplyType="
         + this.getSupplyType()
         + ", materialType="
         + this.getMaterialType()
         + ", basicClass="
         + this.getBasicClass()
         + ", basicClassName="
         + this.getBasicClassName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", serialNumberParent="
         + this.getSerialNumberParent()
         + ", projectIds="
         + this.getProjectIds()
         + ", projects="
         + this.getProjects()
         + ", project="
         + this.getProject()
         + ", projectManager="
         + this.getProjectManager()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", lastOperatorName="
         + this.getLastOperatorName()
         + ", strucAreaIds="
         + this.getStrucAreaIds()
         + ", enclAreaIds="
         + this.getEnclAreaIds()
         + ", applyPurchaseSN="
         + this.getApplyPurchaseSN()
         + ", auxMaterialIds="
         + this.getAuxMaterialIds()
         + ", otherMaterialIds="
         + this.getOtherMaterialIds()
         + ", gasMaterialIds="
         + this.getGasMaterialIds()
         + ", supplier="
         + this.getSupplier()
         + ", mete="
         + this.getMete()
         + ", amount="
         + this.getAmount()
         + ", meteUnit="
         + this.getMeteUnit()
         + ", branchCompany="
         + this.getBranchCompany()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", logisticsTransportType="
         + this.getLogisticsTransportType()
         + ", logisticsPayerType="
         + this.getLogisticsPayerType()
         + ", purchaseOrderPaymentMode="
         + this.getPurchaseOrderPaymentMode()
         + ", attachments="
         + this.getAttachments()
         + ", purchaseStatus="
         + this.getPurchaseStatus()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", remark="
         + this.getRemark()
         + ", editable="
         + this.getEditable()
         + ", boolUsed="
         + this.getBoolUsed()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", level="
         + this.getLevel()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", boolAnnual="
         + this.getBoolAnnual()
         + ", boolTemporaryStorage="
         + this.getBoolTemporaryStorage()
         + ", applyPurchaseStatus="
         + this.getApplyPurchaseStatus()
         + ", useRequisitions="
         + this.getUseRequisitions()
         + ", boolDetail="
         + this.getBoolDetail()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", preSettlementAmount="
         + this.getPreSettlementAmount()
         + ", inboundAmount="
         + this.getInboundAmount()
         + ", cumulativePayment="
         + this.getCumulativePayment()
         + ", unpaidAmount="
         + this.getUnpaidAmount()
         + ", paymentRate="
         + this.getPaymentRate()
         + ", cumulativeInvoice="
         + this.getCumulativeInvoice()
         + ", invoiceRate="
         + this.getInvoiceRate()
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
         + ", orderPlace="
         + this.getOrderPlace()
         + ", enclosureWageQuotaType="
         + this.getEnclosureWageQuotaType()
         + ", artifactWageQuotaType="
         + this.getArtifactWageQuotaType()
         + ", paymentSize="
         + this.getPaymentSize()
         + ", invoiceSize="
         + this.getInvoiceSize()
         + ", settlementSize="
         + this.getSettlementSize()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ", preSettlementSize="
         + this.getPreSettlementSize()
         + ", supplierId="
         + this.getSupplierId()
         + ", actualInboundMeteRatio="
         + this.getActualInboundMeteRatio()
         + ")";
   }

   public PurchaseOrderDTO(
      final Long id,
      final Integer purchaseType,
      final Integer supplyType,
      final Integer materialType,
      final Integer basicClass,
      final String basicClassName,
      final String serialNumber,
      final String serialNumberParent,
      final String projectIds,
      final List<ProjectInfo> projects,
      final ProjectInfo project,
      final com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO projectManager,
      final Integer projectAttribute,
      final Long applicantId,
      final String applicantName,
      final String lastOperatorName,
      final List<Long> strucAreaIds,
      final List<Long> enclAreaIds,
      final List<String> applyPurchaseSN,
      final List<Long> auxMaterialIds,
      final List<Long> otherMaterialIds,
      final List<Long> gasMaterialIds,
      final BriefIdAndNameDTO supplier,
      final BigDecimal mete,
      final BigDecimal amount,
      final String meteUnit,
      final BriefIdAndNameDTO branchCompany,
      final BigDecimal taxRate,
      final Integer invoiceType,
      final Integer weightMeasurementMode,
      final Integer logisticsTransportType,
      final Integer logisticsPayerType,
      final Integer purchaseOrderPaymentMode,
      final List<AttachmentDTO> attachments,
      final Integer purchaseStatus,
      final Integer settlementStatus,
      final String remark,
      final Boolean editable,
      final Boolean boolUsed,
      final LocalDateTime userUpdateTime,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final Integer level,
      final Integer reviewStatus,
      final Boolean boolAnnual,
      final Boolean boolTemporaryStorage,
      final String applyPurchaseStatus,
      final Boolean useRequisitions,
      final Boolean boolDetail,
      final BigDecimal settlementAmount,
      final BigDecimal preSettlementAmount,
      final BigDecimal inboundAmount,
      final BigDecimal cumulativePayment,
      final BigDecimal unpaidAmount,
      final BigDecimal paymentRate,
      final BigDecimal cumulativeInvoice,
      final BigDecimal invoiceRate,
      final List<PurchaseOrderDetailDTO> purchaseOrderDetailDTOS,
      final Integer dataStatus,
      final List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS,
      final Long approveRecordIdNow,
      final String approveRecordIds,
      final Integer orderPlace,
      final Integer enclosureWageQuotaType,
      final Integer artifactWageQuotaType,
      final Integer paymentSize,
      final Integer invoiceSize,
      final Integer settlementSize,
      final com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO mesWorkshop,
      final Integer preSettlementSize,
      final Long supplierId,
      final BigDecimal actualInboundMeteRatio
   ) {
      this.id = id;
      this.purchaseType = purchaseType;
      this.supplyType = supplyType;
      this.materialType = materialType;
      this.basicClass = basicClass;
      this.basicClassName = basicClassName;
      this.serialNumber = serialNumber;
      this.serialNumberParent = serialNumberParent;
      this.projectIds = projectIds;
      this.projects = projects;
      this.project = project;
      this.projectManager = projectManager;
      this.projectAttribute = projectAttribute;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.lastOperatorName = lastOperatorName;
      this.strucAreaIds = strucAreaIds;
      this.enclAreaIds = enclAreaIds;
      this.applyPurchaseSN = applyPurchaseSN;
      this.auxMaterialIds = auxMaterialIds;
      this.otherMaterialIds = otherMaterialIds;
      this.gasMaterialIds = gasMaterialIds;
      this.supplier = supplier;
      this.mete = mete;
      this.amount = amount;
      this.meteUnit = meteUnit;
      this.branchCompany = branchCompany;
      this.taxRate = taxRate;
      this.invoiceType = invoiceType;
      this.weightMeasurementMode = weightMeasurementMode;
      this.logisticsTransportType = logisticsTransportType;
      this.logisticsPayerType = logisticsPayerType;
      this.purchaseOrderPaymentMode = purchaseOrderPaymentMode;
      this.attachments = attachments;
      this.purchaseStatus = purchaseStatus;
      this.settlementStatus = settlementStatus;
      this.remark = remark;
      this.editable = editable;
      this.boolUsed = boolUsed;
      this.userUpdateTime = userUpdateTime;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.level = level;
      this.reviewStatus = reviewStatus;
      this.boolAnnual = boolAnnual;
      this.boolTemporaryStorage = boolTemporaryStorage;
      this.applyPurchaseStatus = applyPurchaseStatus;
      this.useRequisitions = useRequisitions;
      this.boolDetail = boolDetail;
      this.settlementAmount = settlementAmount;
      this.preSettlementAmount = preSettlementAmount;
      this.inboundAmount = inboundAmount;
      this.cumulativePayment = cumulativePayment;
      this.unpaidAmount = unpaidAmount;
      this.paymentRate = paymentRate;
      this.cumulativeInvoice = cumulativeInvoice;
      this.invoiceRate = invoiceRate;
      this.purchaseOrderDetailDTOS = purchaseOrderDetailDTOS;
      this.dataStatus = dataStatus;
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
      this.approveRecordIdNow = approveRecordIdNow;
      this.approveRecordIds = approveRecordIds;
      this.orderPlace = orderPlace;
      this.enclosureWageQuotaType = enclosureWageQuotaType;
      this.artifactWageQuotaType = artifactWageQuotaType;
      this.paymentSize = paymentSize;
      this.invoiceSize = invoiceSize;
      this.settlementSize = settlementSize;
      this.mesWorkshop = mesWorkshop;
      this.preSettlementSize = preSettlementSize;
      this.supplierId = supplierId;
      this.actualInboundMeteRatio = actualInboundMeteRatio;
   }

   public PurchaseOrderDTO() {
   }

   public static class PurchaseOrderDTOBuilder {
      private Long id;
      private Integer purchaseType;
      private Integer supplyType;
      private Integer materialType;
      private Integer basicClass;
      private String basicClassName;
      private String serialNumber;
      private String serialNumberParent;
      private String projectIds;
      private List<ProjectInfo> projects;
      private ProjectInfo project;
      private com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO projectManager;
      private Integer projectAttribute;
      private Long applicantId;
      private String applicantName;
      private String lastOperatorName;
      private List<Long> strucAreaIds;
      private List<Long> enclAreaIds;
      private List<String> applyPurchaseSN;
      private List<Long> auxMaterialIds;
      private List<Long> otherMaterialIds;
      private List<Long> gasMaterialIds;
      private BriefIdAndNameDTO supplier;
      private BigDecimal mete;
      private BigDecimal amount;
      private String meteUnit;
      private BriefIdAndNameDTO branchCompany;
      private BigDecimal taxRate;
      private Integer invoiceType;
      private Integer weightMeasurementMode;
      private Integer logisticsTransportType;
      private Integer logisticsPayerType;
      private Integer purchaseOrderPaymentMode;
      private List<AttachmentDTO> attachments;
      private Integer purchaseStatus;
      private Integer settlementStatus;
      private String remark;
      private Boolean editable;
      private Boolean boolUsed;
      private LocalDateTime userUpdateTime;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private Integer level;
      private Integer reviewStatus;
      private Boolean boolAnnual;
      private Boolean boolTemporaryStorage;
      private String applyPurchaseStatus;
      private Boolean useRequisitions;
      private Boolean boolDetail;
      private BigDecimal settlementAmount;
      private BigDecimal preSettlementAmount;
      private BigDecimal inboundAmount;
      private BigDecimal cumulativePayment;
      private BigDecimal unpaidAmount;
      private BigDecimal paymentRate;
      private BigDecimal cumulativeInvoice;
      private BigDecimal invoiceRate;
      private List<PurchaseOrderDetailDTO> purchaseOrderDetailDTOS;
      private Integer dataStatus;
      private List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS;
      private Long approveRecordIdNow;
      private String approveRecordIds;
      private Integer orderPlace;
      private Integer enclosureWageQuotaType;
      private Integer artifactWageQuotaType;
      private Integer paymentSize;
      private Integer invoiceSize;
      private Integer settlementSize;
      private com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO mesWorkshop;
      private Integer preSettlementSize;
      private Long supplierId;
      private BigDecimal actualInboundMeteRatio;

      PurchaseOrderDTOBuilder() {
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder purchaseType(final Integer purchaseType) {
         this.purchaseType = purchaseType;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder supplyType(final Integer supplyType) {
         this.supplyType = supplyType;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder basicClassName(final String basicClassName) {
         this.basicClassName = basicClassName;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder serialNumberParent(final String serialNumberParent) {
         this.serialNumberParent = serialNumberParent;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder projects(final List<ProjectInfo> projects) {
         this.projects = projects;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder projectManager(final com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO projectManager) {
         this.projectManager = projectManager;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder lastOperatorName(final String lastOperatorName) {
         this.lastOperatorName = lastOperatorName;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder strucAreaIds(final List<Long> strucAreaIds) {
         this.strucAreaIds = strucAreaIds;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder enclAreaIds(final List<Long> enclAreaIds) {
         this.enclAreaIds = enclAreaIds;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder applyPurchaseSN(final List<String> applyPurchaseSN) {
         this.applyPurchaseSN = applyPurchaseSN;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder auxMaterialIds(final List<Long> auxMaterialIds) {
         this.auxMaterialIds = auxMaterialIds;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder otherMaterialIds(final List<Long> otherMaterialIds) {
         this.otherMaterialIds = otherMaterialIds;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder gasMaterialIds(final List<Long> gasMaterialIds) {
         this.gasMaterialIds = gasMaterialIds;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder supplier(final BriefIdAndNameDTO supplier) {
         this.supplier = supplier;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder meteUnit(final String meteUnit) {
         this.meteUnit = meteUnit;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder branchCompany(final BriefIdAndNameDTO branchCompany) {
         this.branchCompany = branchCompany;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder logisticsTransportType(final Integer logisticsTransportType) {
         this.logisticsTransportType = logisticsTransportType;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder logisticsPayerType(final Integer logisticsPayerType) {
         this.logisticsPayerType = logisticsPayerType;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder purchaseOrderPaymentMode(final Integer purchaseOrderPaymentMode) {
         this.purchaseOrderPaymentMode = purchaseOrderPaymentMode;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder purchaseStatus(final Integer purchaseStatus) {
         this.purchaseStatus = purchaseStatus;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder editable(final Boolean editable) {
         this.editable = editable;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder boolUsed(final Boolean boolUsed) {
         this.boolUsed = boolUsed;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder boolAnnual(final Boolean boolAnnual) {
         this.boolAnnual = boolAnnual;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder boolTemporaryStorage(final Boolean boolTemporaryStorage) {
         this.boolTemporaryStorage = boolTemporaryStorage;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder applyPurchaseStatus(final String applyPurchaseStatus) {
         this.applyPurchaseStatus = applyPurchaseStatus;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder useRequisitions(final Boolean useRequisitions) {
         this.useRequisitions = useRequisitions;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder boolDetail(final Boolean boolDetail) {
         this.boolDetail = boolDetail;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder preSettlementAmount(final BigDecimal preSettlementAmount) {
         this.preSettlementAmount = preSettlementAmount;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder inboundAmount(final BigDecimal inboundAmount) {
         this.inboundAmount = inboundAmount;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder cumulativePayment(final BigDecimal cumulativePayment) {
         this.cumulativePayment = cumulativePayment;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder unpaidAmount(final BigDecimal unpaidAmount) {
         this.unpaidAmount = unpaidAmount;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder paymentRate(final BigDecimal paymentRate) {
         this.paymentRate = paymentRate;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder cumulativeInvoice(final BigDecimal cumulativeInvoice) {
         this.cumulativeInvoice = cumulativeInvoice;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder invoiceRate(final BigDecimal invoiceRate) {
         this.invoiceRate = invoiceRate;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder purchaseOrderDetailDTOS(final List<PurchaseOrderDetailDTO> purchaseOrderDetailDTOS) {
         this.purchaseOrderDetailDTOS = purchaseOrderDetailDTOS;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder dataStatus(final Integer dataStatus) {
         this.dataStatus = dataStatus;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder wmsApproveRecordFlowDTOS(final List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS) {
         this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder approveRecordIdNow(final Long approveRecordIdNow) {
         this.approveRecordIdNow = approveRecordIdNow;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder approveRecordIds(final String approveRecordIds) {
         this.approveRecordIds = approveRecordIds;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder orderPlace(final Integer orderPlace) {
         this.orderPlace = orderPlace;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder enclosureWageQuotaType(final Integer enclosureWageQuotaType) {
         this.enclosureWageQuotaType = enclosureWageQuotaType;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder artifactWageQuotaType(final Integer artifactWageQuotaType) {
         this.artifactWageQuotaType = artifactWageQuotaType;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder paymentSize(final Integer paymentSize) {
         this.paymentSize = paymentSize;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder invoiceSize(final Integer invoiceSize) {
         this.invoiceSize = invoiceSize;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder settlementSize(final Integer settlementSize) {
         this.settlementSize = settlementSize;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder mesWorkshop(final com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO mesWorkshop) {
         this.mesWorkshop = mesWorkshop;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder preSettlementSize(final Integer preSettlementSize) {
         this.preSettlementSize = preSettlementSize;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public PurchaseOrderDTO.PurchaseOrderDTOBuilder actualInboundMeteRatio(final BigDecimal actualInboundMeteRatio) {
         this.actualInboundMeteRatio = actualInboundMeteRatio;
         return this;
      }

      public PurchaseOrderDTO build() {
         return new PurchaseOrderDTO(
            this.id,
            this.purchaseType,
            this.supplyType,
            this.materialType,
            this.basicClass,
            this.basicClassName,
            this.serialNumber,
            this.serialNumberParent,
            this.projectIds,
            this.projects,
            this.project,
            this.projectManager,
            this.projectAttribute,
            this.applicantId,
            this.applicantName,
            this.lastOperatorName,
            this.strucAreaIds,
            this.enclAreaIds,
            this.applyPurchaseSN,
            this.auxMaterialIds,
            this.otherMaterialIds,
            this.gasMaterialIds,
            this.supplier,
            this.mete,
            this.amount,
            this.meteUnit,
            this.branchCompany,
            this.taxRate,
            this.invoiceType,
            this.weightMeasurementMode,
            this.logisticsTransportType,
            this.logisticsPayerType,
            this.purchaseOrderPaymentMode,
            this.attachments,
            this.purchaseStatus,
            this.settlementStatus,
            this.remark,
            this.editable,
            this.boolUsed,
            this.userUpdateTime,
            this.createTime,
            this.updateTime,
            this.level,
            this.reviewStatus,
            this.boolAnnual,
            this.boolTemporaryStorage,
            this.applyPurchaseStatus,
            this.useRequisitions,
            this.boolDetail,
            this.settlementAmount,
            this.preSettlementAmount,
            this.inboundAmount,
            this.cumulativePayment,
            this.unpaidAmount,
            this.paymentRate,
            this.cumulativeInvoice,
            this.invoiceRate,
            this.purchaseOrderDetailDTOS,
            this.dataStatus,
            this.wmsApproveRecordFlowDTOS,
            this.approveRecordIdNow,
            this.approveRecordIds,
            this.orderPlace,
            this.enclosureWageQuotaType,
            this.artifactWageQuotaType,
            this.paymentSize,
            this.invoiceSize,
            this.settlementSize,
            this.mesWorkshop,
            this.preSettlementSize,
            this.supplierId,
            this.actualInboundMeteRatio
         );
      }

      @Override
      public String toString() {
         return "PurchaseOrderDTO.PurchaseOrderDTOBuilder(id="
            + this.id
            + ", purchaseType="
            + this.purchaseType
            + ", supplyType="
            + this.supplyType
            + ", materialType="
            + this.materialType
            + ", basicClass="
            + this.basicClass
            + ", basicClassName="
            + this.basicClassName
            + ", serialNumber="
            + this.serialNumber
            + ", serialNumberParent="
            + this.serialNumberParent
            + ", projectIds="
            + this.projectIds
            + ", projects="
            + this.projects
            + ", project="
            + this.project
            + ", projectManager="
            + this.projectManager
            + ", projectAttribute="
            + this.projectAttribute
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", lastOperatorName="
            + this.lastOperatorName
            + ", strucAreaIds="
            + this.strucAreaIds
            + ", enclAreaIds="
            + this.enclAreaIds
            + ", applyPurchaseSN="
            + this.applyPurchaseSN
            + ", auxMaterialIds="
            + this.auxMaterialIds
            + ", otherMaterialIds="
            + this.otherMaterialIds
            + ", gasMaterialIds="
            + this.gasMaterialIds
            + ", supplier="
            + this.supplier
            + ", mete="
            + this.mete
            + ", amount="
            + this.amount
            + ", meteUnit="
            + this.meteUnit
            + ", branchCompany="
            + this.branchCompany
            + ", taxRate="
            + this.taxRate
            + ", invoiceType="
            + this.invoiceType
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", logisticsTransportType="
            + this.logisticsTransportType
            + ", logisticsPayerType="
            + this.logisticsPayerType
            + ", purchaseOrderPaymentMode="
            + this.purchaseOrderPaymentMode
            + ", attachments="
            + this.attachments
            + ", purchaseStatus="
            + this.purchaseStatus
            + ", settlementStatus="
            + this.settlementStatus
            + ", remark="
            + this.remark
            + ", editable="
            + this.editable
            + ", boolUsed="
            + this.boolUsed
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", createTime="
            + this.createTime
            + ", updateTime="
            + this.updateTime
            + ", level="
            + this.level
            + ", reviewStatus="
            + this.reviewStatus
            + ", boolAnnual="
            + this.boolAnnual
            + ", boolTemporaryStorage="
            + this.boolTemporaryStorage
            + ", applyPurchaseStatus="
            + this.applyPurchaseStatus
            + ", useRequisitions="
            + this.useRequisitions
            + ", boolDetail="
            + this.boolDetail
            + ", settlementAmount="
            + this.settlementAmount
            + ", preSettlementAmount="
            + this.preSettlementAmount
            + ", inboundAmount="
            + this.inboundAmount
            + ", cumulativePayment="
            + this.cumulativePayment
            + ", unpaidAmount="
            + this.unpaidAmount
            + ", paymentRate="
            + this.paymentRate
            + ", cumulativeInvoice="
            + this.cumulativeInvoice
            + ", invoiceRate="
            + this.invoiceRate
            + ", purchaseOrderDetailDTOS="
            + this.purchaseOrderDetailDTOS
            + ", dataStatus="
            + this.dataStatus
            + ", wmsApproveRecordFlowDTOS="
            + this.wmsApproveRecordFlowDTOS
            + ", approveRecordIdNow="
            + this.approveRecordIdNow
            + ", approveRecordIds="
            + this.approveRecordIds
            + ", orderPlace="
            + this.orderPlace
            + ", enclosureWageQuotaType="
            + this.enclosureWageQuotaType
            + ", artifactWageQuotaType="
            + this.artifactWageQuotaType
            + ", paymentSize="
            + this.paymentSize
            + ", invoiceSize="
            + this.invoiceSize
            + ", settlementSize="
            + this.settlementSize
            + ", mesWorkshop="
            + this.mesWorkshop
            + ", preSettlementSize="
            + this.preSettlementSize
            + ", supplierId="
            + this.supplierId
            + ", actualInboundMeteRatio="
            + this.actualInboundMeteRatio
            + ")";
      }
   }
}
