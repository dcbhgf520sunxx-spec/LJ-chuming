package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.scm.core.api.enums.PurchaseEnum;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PurchaseOrderDTOParam {
   private Long id;
   @NotNull(message = "采购类型不能为空")
   @EnumValidator(value = PurchaseEnum.class, message = "采购类型错误")
   private Integer purchaseType;
   private Integer supplyType = 1;
   private Integer basicClass;
   private Integer materialType;
   private String serialNumber;
   private String serialNumberParent;
   private List<Long> auxMaterialIds;
   private List<Long> otherMaterialIds;
   private List<Long> gasMaterialIds;
   private List<Long> projectIds;
   private Long projectId;
   private Integer projectAttribute;
   private List<Long> applyPurchaseIds;
   @NotNull(message = "签订主体不能为空")
   private Long branchCompanyId;
   private Long supplierId;
   private BigDecimal mete;
   private String meteUnit;
   private BigDecimal amount;
   private BigDecimal taxRate;
   private LocalDateTime userUpdateTime;
   private Long lastOperatorNameId;
   private String lastOperatorName;
   private Integer logisticsTransportType;
   private Integer logisticsPayerType;
   private Integer purchaseOrderPaymentMode;
   private Integer weightMeasurementMode;
   private List<Long> attachmentIds;
   private Integer invoiceType;
   private Integer purchaseStatus;
   private Integer settlementStatus;
   private Boolean editable;
   private Boolean boolRewrite;
   private String remark;
   @Valid
   List<PurchaseOrderDetailDTOParam> list;
   private List<Long> delDetailIds;
   private boolean boolUsed;
   private LocalDateTime clickTime;
   private LocalDateTime clickAddTime;
   private Boolean boolAnnual;
   private Integer level;
   private Boolean boolTemporaryStorage;
   private Integer reviewStatus;
   private LocalDateTime reviewPassTime;
   private Integer purchaseCreationState;
   private Boolean useRequisitions;
   private Boolean boolDetail;
   private String ApplyPurchaseStatus;
   private String cause;
   private Integer dataStatus;
   private Long approveRecordIdNow;
   private String approveRecordIds;
   private Long annualContractId;
   private Long projectManagerId;
   private Long workshopId;
   private Long parentId;
   private Boolean boolSysgen;
   private Integer delButtonType;
   private Integer orderPlace;
   @ApiModelProperty("构件制品计价方式 WmsWageQuotaTypeEnum")
   private Integer artifactWageQuotaType;
   @ApiModelProperty(name = "isGoForOaApproval", notes = "是否走OA审批")
   private Boolean isGoForOaApproval;

   public Long getId() {
      return this.id;
   }

   public Integer getPurchaseType() {
      return this.purchaseType;
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

   public List<Long> getAuxMaterialIds() {
      return this.auxMaterialIds;
   }

   public List<Long> getOtherMaterialIds() {
      return this.otherMaterialIds;
   }

   public List<Long> getGasMaterialIds() {
      return this.gasMaterialIds;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public List<Long> getApplyPurchaseIds() {
      return this.applyPurchaseIds;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getSupplierId() {
      return this.supplierId;
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

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public Long getLastOperatorNameId() {
      return this.lastOperatorNameId;
   }

   public String getLastOperatorName() {
      return this.lastOperatorName;
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

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Integer getPurchaseStatus() {
      return this.purchaseStatus;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
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

   public List<PurchaseOrderDetailDTOParam> getList() {
      return this.list;
   }

   public List<Long> getDelDetailIds() {
      return this.delDetailIds;
   }

   public boolean isBoolUsed() {
      return this.boolUsed;
   }

   public LocalDateTime getClickTime() {
      return this.clickTime;
   }

   public LocalDateTime getClickAddTime() {
      return this.clickAddTime;
   }

   public Boolean getBoolAnnual() {
      return this.boolAnnual;
   }

   public Integer getLevel() {
      return this.level;
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

   public Integer getPurchaseCreationState() {
      return this.purchaseCreationState;
   }

   public Boolean getUseRequisitions() {
      return this.useRequisitions;
   }

   public Boolean getBoolDetail() {
      return this.boolDetail;
   }

   public String getApplyPurchaseStatus() {
      return this.ApplyPurchaseStatus;
   }

   public String getCause() {
      return this.cause;
   }

   public Integer getDataStatus() {
      return this.dataStatus;
   }

   public Long getApproveRecordIdNow() {
      return this.approveRecordIdNow;
   }

   public String getApproveRecordIds() {
      return this.approveRecordIds;
   }

   public Long getAnnualContractId() {
      return this.annualContractId;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getParentId() {
      return this.parentId;
   }

   public Boolean getBoolSysgen() {
      return this.boolSysgen;
   }

   public Integer getDelButtonType() {
      return this.delButtonType;
   }

   public Integer getOrderPlace() {
      return this.orderPlace;
   }

   public Integer getArtifactWageQuotaType() {
      return this.artifactWageQuotaType;
   }

   public Boolean getIsGoForOaApproval() {
      return this.isGoForOaApproval;
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

   public void setAuxMaterialIds(final List<Long> auxMaterialIds) {
      this.auxMaterialIds = auxMaterialIds;
   }

   public void setOtherMaterialIds(final List<Long> otherMaterialIds) {
      this.otherMaterialIds = otherMaterialIds;
   }

   public void setGasMaterialIds(final List<Long> gasMaterialIds) {
      this.gasMaterialIds = gasMaterialIds;
   }

   public void setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setApplyPurchaseIds(final List<Long> applyPurchaseIds) {
      this.applyPurchaseIds = applyPurchaseIds;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
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

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   public void setLastOperatorNameId(final Long lastOperatorNameId) {
      this.lastOperatorNameId = lastOperatorNameId;
   }

   public void setLastOperatorName(final String lastOperatorName) {
      this.lastOperatorName = lastOperatorName;
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

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setPurchaseStatus(final Integer purchaseStatus) {
      this.purchaseStatus = purchaseStatus;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
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

   public void setList(final List<PurchaseOrderDetailDTOParam> list) {
      this.list = list;
   }

   public void setDelDetailIds(final List<Long> delDetailIds) {
      this.delDetailIds = delDetailIds;
   }

   public void setBoolUsed(final boolean boolUsed) {
      this.boolUsed = boolUsed;
   }

   public void setClickTime(final LocalDateTime clickTime) {
      this.clickTime = clickTime;
   }

   public void setClickAddTime(final LocalDateTime clickAddTime) {
      this.clickAddTime = clickAddTime;
   }

   public void setBoolAnnual(final Boolean boolAnnual) {
      this.boolAnnual = boolAnnual;
   }

   public void setLevel(final Integer level) {
      this.level = level;
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

   public void setPurchaseCreationState(final Integer purchaseCreationState) {
      this.purchaseCreationState = purchaseCreationState;
   }

   public void setUseRequisitions(final Boolean useRequisitions) {
      this.useRequisitions = useRequisitions;
   }

   public void setBoolDetail(final Boolean boolDetail) {
      this.boolDetail = boolDetail;
   }

   public void setApplyPurchaseStatus(final String ApplyPurchaseStatus) {
      this.ApplyPurchaseStatus = ApplyPurchaseStatus;
   }

   public void setCause(final String cause) {
      this.cause = cause;
   }

   public void setDataStatus(final Integer dataStatus) {
      this.dataStatus = dataStatus;
   }

   public void setApproveRecordIdNow(final Long approveRecordIdNow) {
      this.approveRecordIdNow = approveRecordIdNow;
   }

   public void setApproveRecordIds(final String approveRecordIds) {
      this.approveRecordIds = approveRecordIds;
   }

   public void setAnnualContractId(final Long annualContractId) {
      this.annualContractId = annualContractId;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setParentId(final Long parentId) {
      this.parentId = parentId;
   }

   public void setBoolSysgen(final Boolean boolSysgen) {
      this.boolSysgen = boolSysgen;
   }

   public void setDelButtonType(final Integer delButtonType) {
      this.delButtonType = delButtonType;
   }

   public void setOrderPlace(final Integer orderPlace) {
      this.orderPlace = orderPlace;
   }

   public void setArtifactWageQuotaType(final Integer artifactWageQuotaType) {
      this.artifactWageQuotaType = artifactWageQuotaType;
   }

   public void setIsGoForOaApproval(final Boolean isGoForOaApproval) {
      this.isGoForOaApproval = isGoForOaApproval;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseOrderDTOParam)) {
         return false;
      }

      PurchaseOrderDTOParam other = (PurchaseOrderDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isBoolUsed() != other.isBoolUsed()) {
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
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$materialType = this.getMaterialType();
                  Object other$materialType = other.getMaterialType();
                  if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$projectAttribute = this.getProjectAttribute();
                        Object other$projectAttribute = other.getProjectAttribute();
                        if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                           Object this$branchCompanyId = this.getBranchCompanyId();
                           Object other$branchCompanyId = other.getBranchCompanyId();
                           if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                              Object this$supplierId = this.getSupplierId();
                              Object other$supplierId = other.getSupplierId();
                              if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                 Object this$lastOperatorNameId = this.getLastOperatorNameId();
                                 Object other$lastOperatorNameId = other.getLastOperatorNameId();
                                 if (this$lastOperatorNameId == null
                                    ? other$lastOperatorNameId == null
                                    : this$lastOperatorNameId.equals(other$lastOperatorNameId)) {
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
                                             Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                             Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                             if (this$weightMeasurementMode == null
                                                ? other$weightMeasurementMode == null
                                                : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                                Object this$invoiceType = this.getInvoiceType();
                                                Object other$invoiceType = other.getInvoiceType();
                                                if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
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
                                                         Object this$editable = this.getEditable();
                                                         Object other$editable = other.getEditable();
                                                         if (this$editable == null ? other$editable == null : this$editable.equals(other$editable)) {
                                                            Object this$boolRewrite = this.getBoolRewrite();
                                                            Object other$boolRewrite = other.getBoolRewrite();
                                                            if (this$boolRewrite == null
                                                               ? other$boolRewrite == null
                                                               : this$boolRewrite.equals(other$boolRewrite)) {
                                                               Object this$boolAnnual = this.getBoolAnnual();
                                                               Object other$boolAnnual = other.getBoolAnnual();
                                                               if (this$boolAnnual == null
                                                                  ? other$boolAnnual == null
                                                                  : this$boolAnnual.equals(other$boolAnnual)) {
                                                                  Object this$level = this.getLevel();
                                                                  Object other$level = other.getLevel();
                                                                  if (this$level == null ? other$level == null : this$level.equals(other$level)) {
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
                                                                           Object this$purchaseCreationState = this.getPurchaseCreationState();
                                                                           Object other$purchaseCreationState = other.getPurchaseCreationState();
                                                                           if (this$purchaseCreationState == null
                                                                              ? other$purchaseCreationState == null
                                                                              : this$purchaseCreationState.equals(other$purchaseCreationState)) {
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
                                                                                          Object this$annualContractId = this.getAnnualContractId();
                                                                                          Object other$annualContractId = other.getAnnualContractId();
                                                                                          if (this$annualContractId == null
                                                                                             ? other$annualContractId == null
                                                                                             : this$annualContractId.equals(other$annualContractId)) {
                                                                                             Object this$projectManagerId = this.getProjectManagerId();
                                                                                             Object other$projectManagerId = other.getProjectManagerId();
                                                                                             if (this$projectManagerId == null
                                                                                                ? other$projectManagerId == null
                                                                                                : this$projectManagerId.equals(other$projectManagerId)) {
                                                                                                Object this$workshopId = this.getWorkshopId();
                                                                                                Object other$workshopId = other.getWorkshopId();
                                                                                                if (this$workshopId == null
                                                                                                   ? other$workshopId == null
                                                                                                   : this$workshopId.equals(other$workshopId)) {
                                                                                                   Object this$parentId = this.getParentId();
                                                                                                   Object other$parentId = other.getParentId();
                                                                                                   if (this$parentId == null
                                                                                                      ? other$parentId == null
                                                                                                      : this$parentId.equals(other$parentId)) {
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
                                                                                                               Object this$artifactWageQuotaType = this.getArtifactWageQuotaType();
                                                                                                               Object other$artifactWageQuotaType = other.getArtifactWageQuotaType();
                                                                                                               if (this$artifactWageQuotaType == null
                                                                                                                  ? other$artifactWageQuotaType == null
                                                                                                                  : this$artifactWageQuotaType.equals(
                                                                                                                     other$artifactWageQuotaType
                                                                                                                  )) {
                                                                                                                  Object this$isGoForOaApproval = this.getIsGoForOaApproval();
                                                                                                                  Object other$isGoForOaApproval = other.getIsGoForOaApproval();
                                                                                                                  if (this$isGoForOaApproval == null
                                                                                                                     ? other$isGoForOaApproval == null
                                                                                                                     : this$isGoForOaApproval.equals(
                                                                                                                        other$isGoForOaApproval
                                                                                                                     )) {
                                                                                                                     Object this$serialNumber = this.getSerialNumber();
                                                                                                                     Object other$serialNumber = other.getSerialNumber();
                                                                                                                     if (this$serialNumber == null
                                                                                                                        ? other$serialNumber == null
                                                                                                                        : this$serialNumber.equals(
                                                                                                                           other$serialNumber
                                                                                                                        )) {
                                                                                                                        Object this$serialNumberParent = this.getSerialNumberParent();
                                                                                                                        Object other$serialNumberParent = other.getSerialNumberParent();
                                                                                                                        if (this$serialNumberParent == null
                                                                                                                           ? other$serialNumberParent == null
                                                                                                                           : this$serialNumberParent.equals(
                                                                                                                              other$serialNumberParent
                                                                                                                           )) {
                                                                                                                           Object this$auxMaterialIds = this.getAuxMaterialIds();
                                                                                                                           Object other$auxMaterialIds = other.getAuxMaterialIds();
                                                                                                                           if (this$auxMaterialIds == null
                                                                                                                              ? other$auxMaterialIds == null
                                                                                                                              : this$auxMaterialIds.equals(
                                                                                                                                 other$auxMaterialIds
                                                                                                                              )) {
                                                                                                                              Object this$otherMaterialIds = this.getOtherMaterialIds();
                                                                                                                              Object other$otherMaterialIds = other.getOtherMaterialIds();
                                                                                                                              if (this$otherMaterialIds == null
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
                                                                                                                                    Object this$projectIds = this.getProjectIds();
                                                                                                                                    Object other$projectIds = other.getProjectIds();
                                                                                                                                    if (this$projectIds == null
                                                                                                                                       ? other$projectIds
                                                                                                                                          == null
                                                                                                                                       : this$projectIds.equals(
                                                                                                                                          other$projectIds
                                                                                                                                       )) {
                                                                                                                                       Object this$applyPurchaseIds = this.getApplyPurchaseIds();
                                                                                                                                       Object other$applyPurchaseIds = other.getApplyPurchaseIds();
                                                                                                                                       if (this$applyPurchaseIds
                                                                                                                                             == null
                                                                                                                                          ? other$applyPurchaseIds
                                                                                                                                             == null
                                                                                                                                          : this$applyPurchaseIds.equals(
                                                                                                                                             other$applyPurchaseIds
                                                                                                                                          )) {
                                                                                                                                          Object this$mete = this.getMete();
                                                                                                                                          Object other$mete = other.getMete();
                                                                                                                                          if (this$mete == null
                                                                                                                                             ? other$mete
                                                                                                                                                == null
                                                                                                                                             : this$mete.equals(
                                                                                                                                                other$mete
                                                                                                                                             )) {
                                                                                                                                             Object this$meteUnit = this.getMeteUnit();
                                                                                                                                             Object other$meteUnit = other.getMeteUnit();
                                                                                                                                             if (this$meteUnit
                                                                                                                                                   == null
                                                                                                                                                ? other$meteUnit
                                                                                                                                                   == null
                                                                                                                                                : this$meteUnit.equals(
                                                                                                                                                   other$meteUnit
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
                                                                                                                                                   Object this$taxRate = this.getTaxRate();
                                                                                                                                                   Object other$taxRate = other.getTaxRate();
                                                                                                                                                   if (this$taxRate
                                                                                                                                                         == null
                                                                                                                                                      ? other$taxRate
                                                                                                                                                         == null
                                                                                                                                                      : this$taxRate.equals(
                                                                                                                                                         other$taxRate
                                                                                                                                                      )) {
                                                                                                                                                      Object this$userUpdateTime = this.getUserUpdateTime();
                                                                                                                                                      Object other$userUpdateTime = other.getUserUpdateTime();
                                                                                                                                                      if (this$userUpdateTime
                                                                                                                                                            == null
                                                                                                                                                         ? other$userUpdateTime
                                                                                                                                                            == null
                                                                                                                                                         : this$userUpdateTime.equals(
                                                                                                                                                            other$userUpdateTime
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
                                                                                                                                                            Object this$attachmentIds = this.getAttachmentIds();
                                                                                                                                                            Object other$attachmentIds = other.getAttachmentIds();
                                                                                                                                                            if (this$attachmentIds
                                                                                                                                                                  == null
                                                                                                                                                               ? other$attachmentIds
                                                                                                                                                                  == null
                                                                                                                                                               : this$attachmentIds.equals(
                                                                                                                                                                  other$attachmentIds
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
                                                                                                                                                                  Object this$list = this.getList();
                                                                                                                                                                  Object other$list = other.getList();
                                                                                                                                                                  if (this$list
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$list
                                                                                                                                                                        == null
                                                                                                                                                                     : this$list.equals(
                                                                                                                                                                        other$list
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$delDetailIds = this.getDelDetailIds();
                                                                                                                                                                     Object other$delDetailIds = other.getDelDetailIds();
                                                                                                                                                                     if (this$delDetailIds
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$delDetailIds
                                                                                                                                                                           == null
                                                                                                                                                                        : this$delDetailIds.equals(
                                                                                                                                                                           other$delDetailIds
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$clickTime = this.getClickTime();
                                                                                                                                                                        Object other$clickTime = other.getClickTime();
                                                                                                                                                                        if (this$clickTime
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$clickTime
                                                                                                                                                                              == null
                                                                                                                                                                           : this$clickTime.equals(
                                                                                                                                                                              other$clickTime
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$clickAddTime = this.getClickAddTime();
                                                                                                                                                                           Object other$clickAddTime = other.getClickAddTime();
                                                                                                                                                                           if (this$clickAddTime
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$clickAddTime
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$clickAddTime.equals(
                                                                                                                                                                                 other$clickAddTime
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$reviewPassTime = this.getReviewPassTime();
                                                                                                                                                                              Object other$reviewPassTime = other.getReviewPassTime();
                                                                                                                                                                              if (this$reviewPassTime
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$reviewPassTime
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$reviewPassTime.equals(
                                                                                                                                                                                    other$reviewPassTime
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$ApplyPurchaseStatus = this.getApplyPurchaseStatus();
                                                                                                                                                                                 Object other$ApplyPurchaseStatus = other.getApplyPurchaseStatus();
                                                                                                                                                                                 if (this$ApplyPurchaseStatus
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$ApplyPurchaseStatus
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$ApplyPurchaseStatus.equals(
                                                                                                                                                                                       other$ApplyPurchaseStatus
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$cause = this.getCause();
                                                                                                                                                                                    Object other$cause = other.getCause();
                                                                                                                                                                                    if (this$cause
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$cause
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$cause.equals(
                                                                                                                                                                                          other$cause
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
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
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof PurchaseOrderDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isBoolUsed() ? 79 : 97);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $supplyType = this.getSupplyType();
      result = result * 59 + ($supplyType == null ? 43 : $supplyType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $lastOperatorNameId = this.getLastOperatorNameId();
      result = result * 59 + ($lastOperatorNameId == null ? 43 : $lastOperatorNameId.hashCode());
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
      Object $purchaseStatus = this.getPurchaseStatus();
      result = result * 59 + ($purchaseStatus == null ? 43 : $purchaseStatus.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $editable = this.getEditable();
      result = result * 59 + ($editable == null ? 43 : $editable.hashCode());
      Object $boolRewrite = this.getBoolRewrite();
      result = result * 59 + ($boolRewrite == null ? 43 : $boolRewrite.hashCode());
      Object $boolAnnual = this.getBoolAnnual();
      result = result * 59 + ($boolAnnual == null ? 43 : $boolAnnual.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $boolTemporaryStorage = this.getBoolTemporaryStorage();
      result = result * 59 + ($boolTemporaryStorage == null ? 43 : $boolTemporaryStorage.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $purchaseCreationState = this.getPurchaseCreationState();
      result = result * 59 + ($purchaseCreationState == null ? 43 : $purchaseCreationState.hashCode());
      Object $useRequisitions = this.getUseRequisitions();
      result = result * 59 + ($useRequisitions == null ? 43 : $useRequisitions.hashCode());
      Object $boolDetail = this.getBoolDetail();
      result = result * 59 + ($boolDetail == null ? 43 : $boolDetail.hashCode());
      Object $dataStatus = this.getDataStatus();
      result = result * 59 + ($dataStatus == null ? 43 : $dataStatus.hashCode());
      Object $approveRecordIdNow = this.getApproveRecordIdNow();
      result = result * 59 + ($approveRecordIdNow == null ? 43 : $approveRecordIdNow.hashCode());
      Object $annualContractId = this.getAnnualContractId();
      result = result * 59 + ($annualContractId == null ? 43 : $annualContractId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $boolSysgen = this.getBoolSysgen();
      result = result * 59 + ($boolSysgen == null ? 43 : $boolSysgen.hashCode());
      Object $delButtonType = this.getDelButtonType();
      result = result * 59 + ($delButtonType == null ? 43 : $delButtonType.hashCode());
      Object $orderPlace = this.getOrderPlace();
      result = result * 59 + ($orderPlace == null ? 43 : $orderPlace.hashCode());
      Object $artifactWageQuotaType = this.getArtifactWageQuotaType();
      result = result * 59 + ($artifactWageQuotaType == null ? 43 : $artifactWageQuotaType.hashCode());
      Object $isGoForOaApproval = this.getIsGoForOaApproval();
      result = result * 59 + ($isGoForOaApproval == null ? 43 : $isGoForOaApproval.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $serialNumberParent = this.getSerialNumberParent();
      result = result * 59 + ($serialNumberParent == null ? 43 : $serialNumberParent.hashCode());
      Object $auxMaterialIds = this.getAuxMaterialIds();
      result = result * 59 + ($auxMaterialIds == null ? 43 : $auxMaterialIds.hashCode());
      Object $otherMaterialIds = this.getOtherMaterialIds();
      result = result * 59 + ($otherMaterialIds == null ? 43 : $otherMaterialIds.hashCode());
      Object $gasMaterialIds = this.getGasMaterialIds();
      result = result * 59 + ($gasMaterialIds == null ? 43 : $gasMaterialIds.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $applyPurchaseIds = this.getApplyPurchaseIds();
      result = result * 59 + ($applyPurchaseIds == null ? 43 : $applyPurchaseIds.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $meteUnit = this.getMeteUnit();
      result = result * 59 + ($meteUnit == null ? 43 : $meteUnit.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $lastOperatorName = this.getLastOperatorName();
      result = result * 59 + ($lastOperatorName == null ? 43 : $lastOperatorName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $delDetailIds = this.getDelDetailIds();
      result = result * 59 + ($delDetailIds == null ? 43 : $delDetailIds.hashCode());
      Object $clickTime = this.getClickTime();
      result = result * 59 + ($clickTime == null ? 43 : $clickTime.hashCode());
      Object $clickAddTime = this.getClickAddTime();
      result = result * 59 + ($clickAddTime == null ? 43 : $clickAddTime.hashCode());
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $ApplyPurchaseStatus = this.getApplyPurchaseStatus();
      result = result * 59 + ($ApplyPurchaseStatus == null ? 43 : $ApplyPurchaseStatus.hashCode());
      Object $cause = this.getCause();
      result = result * 59 + ($cause == null ? 43 : $cause.hashCode());
      Object $approveRecordIds = this.getApproveRecordIds();
      return result * 59 + ($approveRecordIds == null ? 43 : $approveRecordIds.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseOrderDTOParam(id="
         + this.getId()
         + ", purchaseType="
         + this.getPurchaseType()
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
         + ", auxMaterialIds="
         + this.getAuxMaterialIds()
         + ", otherMaterialIds="
         + this.getOtherMaterialIds()
         + ", gasMaterialIds="
         + this.getGasMaterialIds()
         + ", projectIds="
         + this.getProjectIds()
         + ", projectId="
         + this.getProjectId()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", applyPurchaseIds="
         + this.getApplyPurchaseIds()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", supplierId="
         + this.getSupplierId()
         + ", mete="
         + this.getMete()
         + ", meteUnit="
         + this.getMeteUnit()
         + ", amount="
         + this.getAmount()
         + ", taxRate="
         + this.getTaxRate()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", lastOperatorNameId="
         + this.getLastOperatorNameId()
         + ", lastOperatorName="
         + this.getLastOperatorName()
         + ", logisticsTransportType="
         + this.getLogisticsTransportType()
         + ", logisticsPayerType="
         + this.getLogisticsPayerType()
         + ", purchaseOrderPaymentMode="
         + this.getPurchaseOrderPaymentMode()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", purchaseStatus="
         + this.getPurchaseStatus()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", editable="
         + this.getEditable()
         + ", boolRewrite="
         + this.getBoolRewrite()
         + ", remark="
         + this.getRemark()
         + ", list="
         + this.getList()
         + ", delDetailIds="
         + this.getDelDetailIds()
         + ", boolUsed="
         + this.isBoolUsed()
         + ", clickTime="
         + this.getClickTime()
         + ", clickAddTime="
         + this.getClickAddTime()
         + ", boolAnnual="
         + this.getBoolAnnual()
         + ", level="
         + this.getLevel()
         + ", boolTemporaryStorage="
         + this.getBoolTemporaryStorage()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", purchaseCreationState="
         + this.getPurchaseCreationState()
         + ", useRequisitions="
         + this.getUseRequisitions()
         + ", boolDetail="
         + this.getBoolDetail()
         + ", ApplyPurchaseStatus="
         + this.getApplyPurchaseStatus()
         + ", cause="
         + this.getCause()
         + ", dataStatus="
         + this.getDataStatus()
         + ", approveRecordIdNow="
         + this.getApproveRecordIdNow()
         + ", approveRecordIds="
         + this.getApproveRecordIds()
         + ", annualContractId="
         + this.getAnnualContractId()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", parentId="
         + this.getParentId()
         + ", boolSysgen="
         + this.getBoolSysgen()
         + ", delButtonType="
         + this.getDelButtonType()
         + ", orderPlace="
         + this.getOrderPlace()
         + ", artifactWageQuotaType="
         + this.getArtifactWageQuotaType()
         + ", isGoForOaApproval="
         + this.getIsGoForOaApproval()
         + ")";
   }
}
