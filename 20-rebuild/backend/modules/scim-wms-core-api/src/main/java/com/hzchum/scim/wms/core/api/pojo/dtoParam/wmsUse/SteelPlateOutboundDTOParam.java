package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SteelPlateOutboundDTOParam {
   private Long id;
   private Integer halfMode;
   private BigDecimal halfSize;
   private Long materialId;
   private Integer materialOutboundMode;
   private String outboundUnit;
   private Integer outboundUnitPrecision;
   private Integer outboundAddress;
   private Long projectId;
   private Long monomerId;
   private Long areaId;
   private Long areaBatchId;
   private BigDecimal quantity;
   private BigDecimal mete;
   private BigDecimal totalWeight;
   private Long recipientId;
   private Long workshopId;
   private String remark;
   private Long convertId;
   private LocalDateTime outboundTime;
   private Boolean boolPartyA;
   private List<BattenDetailDTOParam> battenList;
   private Long purchaseId;
   private Integer outboundTypeSelection;
   private Integer reviewStatus;
   private Outbound outbound;
   private Long branchCompanyId;
   private BigDecimal inputMete;
   private BigDecimal sellUnitPrice;
   private BigDecimal sellAmount;
   private Integer invoiceType;
   private BigDecimal taxRate;
   private Boolean boolSubmitCheck;
   private String serialNumber;
   private Integer weightMeasurementMode;
   private Long materialFreezeRecordId;
   private Long taskOrderId;
   private String taskOrderNumber;
   private BigDecimal pickingMete;
   private List<Long> pickingIds;
   private List<Long> pickingDetailIds;
   private Long pickingId;
   private Long pickingDetailId;
   private Integer transactStatus;
   private BigDecimal pickingArea;
   private BigDecimal handlingArea;
   private String purchaser;
   private BigDecimal actualTheoryWeight;
   private Boolean isNeedRemind;

   public static SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder builder() {
      return new SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getHalfMode() {
      return this.halfMode;
   }

   public BigDecimal getHalfSize() {
      return this.halfSize;
   }

   public Long getMaterialId() {
      return this.materialId;
   }

   public Integer getMaterialOutboundMode() {
      return this.materialOutboundMode;
   }

   public String getOutboundUnit() {
      return this.outboundUnit;
   }

   public Integer getOutboundUnitPrecision() {
      return this.outboundUnitPrecision;
   }

   public Integer getOutboundAddress() {
      return this.outboundAddress;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getConvertId() {
      return this.convertId;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public List<BattenDetailDTOParam> getBattenList() {
      return this.battenList;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Outbound getOutbound() {
      return this.outbound;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public BigDecimal getInputMete() {
      return this.inputMete;
   }

   public BigDecimal getSellUnitPrice() {
      return this.sellUnitPrice;
   }

   public BigDecimal getSellAmount() {
      return this.sellAmount;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Boolean getBoolSubmitCheck() {
      return this.boolSubmitCheck;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public Long getMaterialFreezeRecordId() {
      return this.materialFreezeRecordId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public BigDecimal getPickingMete() {
      return this.pickingMete;
   }

   public List<Long> getPickingIds() {
      return this.pickingIds;
   }

   public List<Long> getPickingDetailIds() {
      return this.pickingDetailIds;
   }

   public Long getPickingId() {
      return this.pickingId;
   }

   public Long getPickingDetailId() {
      return this.pickingDetailId;
   }

   public Integer getTransactStatus() {
      return this.transactStatus;
   }

   public BigDecimal getPickingArea() {
      return this.pickingArea;
   }

   public BigDecimal getHandlingArea() {
      return this.handlingArea;
   }

   public String getPurchaser() {
      return this.purchaser;
   }

   public BigDecimal getActualTheoryWeight() {
      return this.actualTheoryWeight;
   }

   public Boolean getIsNeedRemind() {
      return this.isNeedRemind;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setHalfMode(final Integer halfMode) {
      this.halfMode = halfMode;
   }

   public void setHalfSize(final BigDecimal halfSize) {
      this.halfSize = halfSize;
   }

   public void setMaterialId(final Long materialId) {
      this.materialId = materialId;
   }

   public void setMaterialOutboundMode(final Integer materialOutboundMode) {
      this.materialOutboundMode = materialOutboundMode;
   }

   public void setOutboundUnit(final String outboundUnit) {
      this.outboundUnit = outboundUnit;
   }

   public void setOutboundUnitPrecision(final Integer outboundUnitPrecision) {
      this.outboundUnitPrecision = outboundUnitPrecision;
   }

   public void setOutboundAddress(final Integer outboundAddress) {
      this.outboundAddress = outboundAddress;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setConvertId(final Long convertId) {
      this.convertId = convertId;
   }

   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setBattenList(final List<BattenDetailDTOParam> battenList) {
      this.battenList = battenList;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setOutbound(final Outbound outbound) {
      this.outbound = outbound;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setInputMete(final BigDecimal inputMete) {
      this.inputMete = inputMete;
   }

   public void setSellUnitPrice(final BigDecimal sellUnitPrice) {
      this.sellUnitPrice = sellUnitPrice;
   }

   public void setSellAmount(final BigDecimal sellAmount) {
      this.sellAmount = sellAmount;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setBoolSubmitCheck(final Boolean boolSubmitCheck) {
      this.boolSubmitCheck = boolSubmitCheck;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   public void setMaterialFreezeRecordId(final Long materialFreezeRecordId) {
      this.materialFreezeRecordId = materialFreezeRecordId;
   }

   public void setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
   }

   public void setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
   }

   public void setPickingMete(final BigDecimal pickingMete) {
      this.pickingMete = pickingMete;
   }

   public void setPickingIds(final List<Long> pickingIds) {
      this.pickingIds = pickingIds;
   }

   public void setPickingDetailIds(final List<Long> pickingDetailIds) {
      this.pickingDetailIds = pickingDetailIds;
   }

   public void setPickingId(final Long pickingId) {
      this.pickingId = pickingId;
   }

   public void setPickingDetailId(final Long pickingDetailId) {
      this.pickingDetailId = pickingDetailId;
   }

   public void setTransactStatus(final Integer transactStatus) {
      this.transactStatus = transactStatus;
   }

   public void setPickingArea(final BigDecimal pickingArea) {
      this.pickingArea = pickingArea;
   }

   public void setHandlingArea(final BigDecimal handlingArea) {
      this.handlingArea = handlingArea;
   }

   public void setPurchaser(final String purchaser) {
      this.purchaser = purchaser;
   }

   public void setActualTheoryWeight(final BigDecimal actualTheoryWeight) {
      this.actualTheoryWeight = actualTheoryWeight;
   }

   public void setIsNeedRemind(final Boolean isNeedRemind) {
      this.isNeedRemind = isNeedRemind;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelPlateOutboundDTOParam)) {
         return false;
      }

      SteelPlateOutboundDTOParam other = (SteelPlateOutboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$halfMode = this.getHalfMode();
         Object other$halfMode = other.getHalfMode();
         if (this$halfMode == null ? other$halfMode == null : this$halfMode.equals(other$halfMode)) {
            Object this$materialId = this.getMaterialId();
            Object other$materialId = other.getMaterialId();
            if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
               Object this$materialOutboundMode = this.getMaterialOutboundMode();
               Object other$materialOutboundMode = other.getMaterialOutboundMode();
               if (this$materialOutboundMode == null ? other$materialOutboundMode == null : this$materialOutboundMode.equals(other$materialOutboundMode)) {
                  Object this$outboundUnitPrecision = this.getOutboundUnitPrecision();
                  Object other$outboundUnitPrecision = other.getOutboundUnitPrecision();
                  if (this$outboundUnitPrecision == null ? other$outboundUnitPrecision == null : this$outboundUnitPrecision.equals(other$outboundUnitPrecision)
                     )
                   {
                     Object this$outboundAddress = this.getOutboundAddress();
                     Object other$outboundAddress = other.getOutboundAddress();
                     if (this$outboundAddress == null ? other$outboundAddress == null : this$outboundAddress.equals(other$outboundAddress)) {
                        Object this$projectId = this.getProjectId();
                        Object other$projectId = other.getProjectId();
                        if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                           Object this$monomerId = this.getMonomerId();
                           Object other$monomerId = other.getMonomerId();
                           if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                              Object this$areaId = this.getAreaId();
                              Object other$areaId = other.getAreaId();
                              if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                 Object this$areaBatchId = this.getAreaBatchId();
                                 Object other$areaBatchId = other.getAreaBatchId();
                                 if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                                    Object this$recipientId = this.getRecipientId();
                                    Object other$recipientId = other.getRecipientId();
                                    if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                                       Object this$workshopId = this.getWorkshopId();
                                       Object other$workshopId = other.getWorkshopId();
                                       if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                          Object this$convertId = this.getConvertId();
                                          Object other$convertId = other.getConvertId();
                                          if (this$convertId == null ? other$convertId == null : this$convertId.equals(other$convertId)) {
                                             Object this$boolPartyA = this.getBoolPartyA();
                                             Object other$boolPartyA = other.getBoolPartyA();
                                             if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                                Object this$purchaseId = this.getPurchaseId();
                                                Object other$purchaseId = other.getPurchaseId();
                                                if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
                                                   Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                                                   Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                                                   if (this$outboundTypeSelection == null
                                                      ? other$outboundTypeSelection == null
                                                      : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                                                      Object this$reviewStatus = this.getReviewStatus();
                                                      Object other$reviewStatus = other.getReviewStatus();
                                                      if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)
                                                         )
                                                       {
                                                         Object this$branchCompanyId = this.getBranchCompanyId();
                                                         Object other$branchCompanyId = other.getBranchCompanyId();
                                                         if (this$branchCompanyId == null
                                                            ? other$branchCompanyId == null
                                                            : this$branchCompanyId.equals(other$branchCompanyId)) {
                                                            Object this$invoiceType = this.getInvoiceType();
                                                            Object other$invoiceType = other.getInvoiceType();
                                                            if (this$invoiceType == null
                                                               ? other$invoiceType == null
                                                               : this$invoiceType.equals(other$invoiceType)) {
                                                               Object this$boolSubmitCheck = this.getBoolSubmitCheck();
                                                               Object other$boolSubmitCheck = other.getBoolSubmitCheck();
                                                               if (this$boolSubmitCheck == null
                                                                  ? other$boolSubmitCheck == null
                                                                  : this$boolSubmitCheck.equals(other$boolSubmitCheck)) {
                                                                  Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                                                  Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                                                  if (this$weightMeasurementMode == null
                                                                     ? other$weightMeasurementMode == null
                                                                     : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                                                     Object this$materialFreezeRecordId = this.getMaterialFreezeRecordId();
                                                                     Object other$materialFreezeRecordId = other.getMaterialFreezeRecordId();
                                                                     if (this$materialFreezeRecordId == null
                                                                        ? other$materialFreezeRecordId == null
                                                                        : this$materialFreezeRecordId.equals(other$materialFreezeRecordId)) {
                                                                        Object this$taskOrderId = this.getTaskOrderId();
                                                                        Object other$taskOrderId = other.getTaskOrderId();
                                                                        if (this$taskOrderId == null
                                                                           ? other$taskOrderId == null
                                                                           : this$taskOrderId.equals(other$taskOrderId)) {
                                                                           Object this$pickingId = this.getPickingId();
                                                                           Object other$pickingId = other.getPickingId();
                                                                           if (this$pickingId == null
                                                                              ? other$pickingId == null
                                                                              : this$pickingId.equals(other$pickingId)) {
                                                                              Object this$pickingDetailId = this.getPickingDetailId();
                                                                              Object other$pickingDetailId = other.getPickingDetailId();
                                                                              if (this$pickingDetailId == null
                                                                                 ? other$pickingDetailId == null
                                                                                 : this$pickingDetailId.equals(other$pickingDetailId)) {
                                                                                 Object this$transactStatus = this.getTransactStatus();
                                                                                 Object other$transactStatus = other.getTransactStatus();
                                                                                 if (this$transactStatus == null
                                                                                    ? other$transactStatus == null
                                                                                    : this$transactStatus.equals(other$transactStatus)) {
                                                                                    Object this$isNeedRemind = this.getIsNeedRemind();
                                                                                    Object other$isNeedRemind = other.getIsNeedRemind();
                                                                                    if (this$isNeedRemind == null
                                                                                       ? other$isNeedRemind == null
                                                                                       : this$isNeedRemind.equals(other$isNeedRemind)) {
                                                                                       Object this$halfSize = this.getHalfSize();
                                                                                       Object other$halfSize = other.getHalfSize();
                                                                                       if (this$halfSize == null
                                                                                          ? other$halfSize == null
                                                                                          : this$halfSize.equals(other$halfSize)) {
                                                                                          Object this$outboundUnit = this.getOutboundUnit();
                                                                                          Object other$outboundUnit = other.getOutboundUnit();
                                                                                          if (this$outboundUnit == null
                                                                                             ? other$outboundUnit == null
                                                                                             : this$outboundUnit.equals(other$outboundUnit)) {
                                                                                             Object this$quantity = this.getQuantity();
                                                                                             Object other$quantity = other.getQuantity();
                                                                                             if (this$quantity == null
                                                                                                ? other$quantity == null
                                                                                                : this$quantity.equals(other$quantity)) {
                                                                                                Object this$mete = this.getMete();
                                                                                                Object other$mete = other.getMete();
                                                                                                if (this$mete == null
                                                                                                   ? other$mete == null
                                                                                                   : this$mete.equals(other$mete)) {
                                                                                                   Object this$totalWeight = this.getTotalWeight();
                                                                                                   Object other$totalWeight = other.getTotalWeight();
                                                                                                   if (this$totalWeight == null
                                                                                                      ? other$totalWeight == null
                                                                                                      : this$totalWeight.equals(other$totalWeight)) {
                                                                                                      Object this$remark = this.getRemark();
                                                                                                      Object other$remark = other.getRemark();
                                                                                                      if (this$remark == null
                                                                                                         ? other$remark == null
                                                                                                         : this$remark.equals(other$remark)) {
                                                                                                         Object this$outboundTime = this.getOutboundTime();
                                                                                                         Object other$outboundTime = other.getOutboundTime();
                                                                                                         if (this$outboundTime == null
                                                                                                            ? other$outboundTime == null
                                                                                                            : this$outboundTime.equals(other$outboundTime)) {
                                                                                                            Object this$battenList = this.getBattenList();
                                                                                                            Object other$battenList = other.getBattenList();
                                                                                                            if (this$battenList == null
                                                                                                               ? other$battenList == null
                                                                                                               : this$battenList.equals(other$battenList)) {
                                                                                                               Object this$outbound = this.getOutbound();
                                                                                                               Object other$outbound = other.getOutbound();
                                                                                                               if (this$outbound == null
                                                                                                                  ? other$outbound == null
                                                                                                                  : this$outbound.equals(other$outbound)) {
                                                                                                                  Object this$inputMete = this.getInputMete();
                                                                                                                  Object other$inputMete = other.getInputMete();
                                                                                                                  if (this$inputMete == null
                                                                                                                     ? other$inputMete == null
                                                                                                                     : this$inputMete.equals(other$inputMete)) {
                                                                                                                     Object this$sellUnitPrice = this.getSellUnitPrice();
                                                                                                                     Object other$sellUnitPrice = other.getSellUnitPrice();
                                                                                                                     if (this$sellUnitPrice == null
                                                                                                                        ? other$sellUnitPrice == null
                                                                                                                        : this$sellUnitPrice.equals(
                                                                                                                           other$sellUnitPrice
                                                                                                                        )) {
                                                                                                                        Object this$sellAmount = this.getSellAmount();
                                                                                                                        Object other$sellAmount = other.getSellAmount();
                                                                                                                        if (this$sellAmount == null
                                                                                                                           ? other$sellAmount == null
                                                                                                                           : this$sellAmount.equals(
                                                                                                                              other$sellAmount
                                                                                                                           )) {
                                                                                                                           Object this$taxRate = this.getTaxRate();
                                                                                                                           Object other$taxRate = other.getTaxRate();
                                                                                                                           if (this$taxRate == null
                                                                                                                              ? other$taxRate == null
                                                                                                                              : this$taxRate.equals(
                                                                                                                                 other$taxRate
                                                                                                                              )) {
                                                                                                                              Object this$serialNumber = this.getSerialNumber();
                                                                                                                              Object other$serialNumber = other.getSerialNumber();
                                                                                                                              if (this$serialNumber == null
                                                                                                                                 ? other$serialNumber == null
                                                                                                                                 : this$serialNumber.equals(
                                                                                                                                    other$serialNumber
                                                                                                                                 )) {
                                                                                                                                 Object this$taskOrderNumber = this.getTaskOrderNumber();
                                                                                                                                 Object other$taskOrderNumber = other.getTaskOrderNumber();
                                                                                                                                 if (this$taskOrderNumber
                                                                                                                                       == null
                                                                                                                                    ? other$taskOrderNumber
                                                                                                                                       == null
                                                                                                                                    : this$taskOrderNumber.equals(
                                                                                                                                       other$taskOrderNumber
                                                                                                                                    )) {
                                                                                                                                    Object this$pickingMete = this.getPickingMete();
                                                                                                                                    Object other$pickingMete = other.getPickingMete();
                                                                                                                                    if (this$pickingMete
                                                                                                                                          == null
                                                                                                                                       ? other$pickingMete
                                                                                                                                          == null
                                                                                                                                       : this$pickingMete.equals(
                                                                                                                                          other$pickingMete
                                                                                                                                       )) {
                                                                                                                                       Object this$pickingIds = this.getPickingIds();
                                                                                                                                       Object other$pickingIds = other.getPickingIds();
                                                                                                                                       if (this$pickingIds
                                                                                                                                             == null
                                                                                                                                          ? other$pickingIds
                                                                                                                                             == null
                                                                                                                                          : this$pickingIds.equals(
                                                                                                                                             other$pickingIds
                                                                                                                                          )) {
                                                                                                                                          Object this$pickingDetailIds = this.getPickingDetailIds();
                                                                                                                                          Object other$pickingDetailIds = other.getPickingDetailIds();
                                                                                                                                          if (this$pickingDetailIds
                                                                                                                                                == null
                                                                                                                                             ? other$pickingDetailIds
                                                                                                                                                == null
                                                                                                                                             : this$pickingDetailIds.equals(
                                                                                                                                                other$pickingDetailIds
                                                                                                                                             )) {
                                                                                                                                             Object this$pickingArea = this.getPickingArea();
                                                                                                                                             Object other$pickingArea = other.getPickingArea();
                                                                                                                                             if (this$pickingArea
                                                                                                                                                   == null
                                                                                                                                                ? other$pickingArea
                                                                                                                                                   == null
                                                                                                                                                : this$pickingArea.equals(
                                                                                                                                                   other$pickingArea
                                                                                                                                                )) {
                                                                                                                                                Object this$handlingArea = this.getHandlingArea();
                                                                                                                                                Object other$handlingArea = other.getHandlingArea();
                                                                                                                                                if (this$handlingArea
                                                                                                                                                      == null
                                                                                                                                                   ? other$handlingArea
                                                                                                                                                      == null
                                                                                                                                                   : this$handlingArea.equals(
                                                                                                                                                      other$handlingArea
                                                                                                                                                   )) {
                                                                                                                                                   Object this$purchaser = this.getPurchaser();
                                                                                                                                                   Object other$purchaser = other.getPurchaser();
                                                                                                                                                   if (this$purchaser
                                                                                                                                                         == null
                                                                                                                                                      ? other$purchaser
                                                                                                                                                         == null
                                                                                                                                                      : this$purchaser.equals(
                                                                                                                                                         other$purchaser
                                                                                                                                                      )) {
                                                                                                                                                      Object this$actualTheoryWeight = this.getActualTheoryWeight();
                                                                                                                                                      Object other$actualTheoryWeight = other.getActualTheoryWeight();
                                                                                                                                                      return this$actualTheoryWeight
                                                                                                                                                            == null
                                                                                                                                                         ? other$actualTheoryWeight
                                                                                                                                                            == null
                                                                                                                                                         : this$actualTheoryWeight.equals(
                                                                                                                                                            other$actualTheoryWeight
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SteelPlateOutboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $halfMode = this.getHalfMode();
      result = result * 59 + ($halfMode == null ? 43 : $halfMode.hashCode());
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $materialOutboundMode = this.getMaterialOutboundMode();
      result = result * 59 + ($materialOutboundMode == null ? 43 : $materialOutboundMode.hashCode());
      Object $outboundUnitPrecision = this.getOutboundUnitPrecision();
      result = result * 59 + ($outboundUnitPrecision == null ? 43 : $outboundUnitPrecision.hashCode());
      Object $outboundAddress = this.getOutboundAddress();
      result = result * 59 + ($outboundAddress == null ? 43 : $outboundAddress.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $convertId = this.getConvertId();
      result = result * 59 + ($convertId == null ? 43 : $convertId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $boolSubmitCheck = this.getBoolSubmitCheck();
      result = result * 59 + ($boolSubmitCheck == null ? 43 : $boolSubmitCheck.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $materialFreezeRecordId = this.getMaterialFreezeRecordId();
      result = result * 59 + ($materialFreezeRecordId == null ? 43 : $materialFreezeRecordId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $pickingId = this.getPickingId();
      result = result * 59 + ($pickingId == null ? 43 : $pickingId.hashCode());
      Object $pickingDetailId = this.getPickingDetailId();
      result = result * 59 + ($pickingDetailId == null ? 43 : $pickingDetailId.hashCode());
      Object $transactStatus = this.getTransactStatus();
      result = result * 59 + ($transactStatus == null ? 43 : $transactStatus.hashCode());
      Object $isNeedRemind = this.getIsNeedRemind();
      result = result * 59 + ($isNeedRemind == null ? 43 : $isNeedRemind.hashCode());
      Object $halfSize = this.getHalfSize();
      result = result * 59 + ($halfSize == null ? 43 : $halfSize.hashCode());
      Object $outboundUnit = this.getOutboundUnit();
      result = result * 59 + ($outboundUnit == null ? 43 : $outboundUnit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $battenList = this.getBattenList();
      result = result * 59 + ($battenList == null ? 43 : $battenList.hashCode());
      Object $outbound = this.getOutbound();
      result = result * 59 + ($outbound == null ? 43 : $outbound.hashCode());
      Object $inputMete = this.getInputMete();
      result = result * 59 + ($inputMete == null ? 43 : $inputMete.hashCode());
      Object $sellUnitPrice = this.getSellUnitPrice();
      result = result * 59 + ($sellUnitPrice == null ? 43 : $sellUnitPrice.hashCode());
      Object $sellAmount = this.getSellAmount();
      result = result * 59 + ($sellAmount == null ? 43 : $sellAmount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $pickingMete = this.getPickingMete();
      result = result * 59 + ($pickingMete == null ? 43 : $pickingMete.hashCode());
      Object $pickingIds = this.getPickingIds();
      result = result * 59 + ($pickingIds == null ? 43 : $pickingIds.hashCode());
      Object $pickingDetailIds = this.getPickingDetailIds();
      result = result * 59 + ($pickingDetailIds == null ? 43 : $pickingDetailIds.hashCode());
      Object $pickingArea = this.getPickingArea();
      result = result * 59 + ($pickingArea == null ? 43 : $pickingArea.hashCode());
      Object $handlingArea = this.getHandlingArea();
      result = result * 59 + ($handlingArea == null ? 43 : $handlingArea.hashCode());
      Object $purchaser = this.getPurchaser();
      result = result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
      Object $actualTheoryWeight = this.getActualTheoryWeight();
      return result * 59 + ($actualTheoryWeight == null ? 43 : $actualTheoryWeight.hashCode());
   }

   @Override
   public String toString() {
      return "SteelPlateOutboundDTOParam(id="
         + this.getId()
         + ", halfMode="
         + this.getHalfMode()
         + ", halfSize="
         + this.getHalfSize()
         + ", materialId="
         + this.getMaterialId()
         + ", materialOutboundMode="
         + this.getMaterialOutboundMode()
         + ", outboundUnit="
         + this.getOutboundUnit()
         + ", outboundUnitPrecision="
         + this.getOutboundUnitPrecision()
         + ", outboundAddress="
         + this.getOutboundAddress()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", recipientId="
         + this.getRecipientId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", remark="
         + this.getRemark()
         + ", convertId="
         + this.getConvertId()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", battenList="
         + this.getBattenList()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", outbound="
         + this.getOutbound()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", inputMete="
         + this.getInputMete()
         + ", sellUnitPrice="
         + this.getSellUnitPrice()
         + ", sellAmount="
         + this.getSellAmount()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", boolSubmitCheck="
         + this.getBoolSubmitCheck()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", materialFreezeRecordId="
         + this.getMaterialFreezeRecordId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", pickingMete="
         + this.getPickingMete()
         + ", pickingIds="
         + this.getPickingIds()
         + ", pickingDetailIds="
         + this.getPickingDetailIds()
         + ", pickingId="
         + this.getPickingId()
         + ", pickingDetailId="
         + this.getPickingDetailId()
         + ", transactStatus="
         + this.getTransactStatus()
         + ", pickingArea="
         + this.getPickingArea()
         + ", handlingArea="
         + this.getHandlingArea()
         + ", purchaser="
         + this.getPurchaser()
         + ", actualTheoryWeight="
         + this.getActualTheoryWeight()
         + ", isNeedRemind="
         + this.getIsNeedRemind()
         + ")";
   }

   public SteelPlateOutboundDTOParam(
      final Long id,
      final Integer halfMode,
      final BigDecimal halfSize,
      final Long materialId,
      final Integer materialOutboundMode,
      final String outboundUnit,
      final Integer outboundUnitPrecision,
      final Integer outboundAddress,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal totalWeight,
      final Long recipientId,
      final Long workshopId,
      final String remark,
      final Long convertId,
      final LocalDateTime outboundTime,
      final Boolean boolPartyA,
      final List<BattenDetailDTOParam> battenList,
      final Long purchaseId,
      final Integer outboundTypeSelection,
      final Integer reviewStatus,
      final Outbound outbound,
      final Long branchCompanyId,
      final BigDecimal inputMete,
      final BigDecimal sellUnitPrice,
      final BigDecimal sellAmount,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final Boolean boolSubmitCheck,
      final String serialNumber,
      final Integer weightMeasurementMode,
      final Long materialFreezeRecordId,
      final Long taskOrderId,
      final String taskOrderNumber,
      final BigDecimal pickingMete,
      final List<Long> pickingIds,
      final List<Long> pickingDetailIds,
      final Long pickingId,
      final Long pickingDetailId,
      final Integer transactStatus,
      final BigDecimal pickingArea,
      final BigDecimal handlingArea,
      final String purchaser,
      final BigDecimal actualTheoryWeight,
      final Boolean isNeedRemind
   ) {
      this.id = id;
      this.halfMode = halfMode;
      this.halfSize = halfSize;
      this.materialId = materialId;
      this.materialOutboundMode = materialOutboundMode;
      this.outboundUnit = outboundUnit;
      this.outboundUnitPrecision = outboundUnitPrecision;
      this.outboundAddress = outboundAddress;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.quantity = quantity;
      this.mete = mete;
      this.totalWeight = totalWeight;
      this.recipientId = recipientId;
      this.workshopId = workshopId;
      this.remark = remark;
      this.convertId = convertId;
      this.outboundTime = outboundTime;
      this.boolPartyA = boolPartyA;
      this.battenList = battenList;
      this.purchaseId = purchaseId;
      this.outboundTypeSelection = outboundTypeSelection;
      this.reviewStatus = reviewStatus;
      this.outbound = outbound;
      this.branchCompanyId = branchCompanyId;
      this.inputMete = inputMete;
      this.sellUnitPrice = sellUnitPrice;
      this.sellAmount = sellAmount;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.boolSubmitCheck = boolSubmitCheck;
      this.serialNumber = serialNumber;
      this.weightMeasurementMode = weightMeasurementMode;
      this.materialFreezeRecordId = materialFreezeRecordId;
      this.taskOrderId = taskOrderId;
      this.taskOrderNumber = taskOrderNumber;
      this.pickingMete = pickingMete;
      this.pickingIds = pickingIds;
      this.pickingDetailIds = pickingDetailIds;
      this.pickingId = pickingId;
      this.pickingDetailId = pickingDetailId;
      this.transactStatus = transactStatus;
      this.pickingArea = pickingArea;
      this.handlingArea = handlingArea;
      this.purchaser = purchaser;
      this.actualTheoryWeight = actualTheoryWeight;
      this.isNeedRemind = isNeedRemind;
   }

   public SteelPlateOutboundDTOParam() {
   }

   public static class SteelPlateOutboundDTOParamBuilder {
      private Long id;
      private Integer halfMode;
      private BigDecimal halfSize;
      private Long materialId;
      private Integer materialOutboundMode;
      private String outboundUnit;
      private Integer outboundUnitPrecision;
      private Integer outboundAddress;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal totalWeight;
      private Long recipientId;
      private Long workshopId;
      private String remark;
      private Long convertId;
      private LocalDateTime outboundTime;
      private Boolean boolPartyA;
      private List<BattenDetailDTOParam> battenList;
      private Long purchaseId;
      private Integer outboundTypeSelection;
      private Integer reviewStatus;
      private Outbound outbound;
      private Long branchCompanyId;
      private BigDecimal inputMete;
      private BigDecimal sellUnitPrice;
      private BigDecimal sellAmount;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private Boolean boolSubmitCheck;
      private String serialNumber;
      private Integer weightMeasurementMode;
      private Long materialFreezeRecordId;
      private Long taskOrderId;
      private String taskOrderNumber;
      private BigDecimal pickingMete;
      private List<Long> pickingIds;
      private List<Long> pickingDetailIds;
      private Long pickingId;
      private Long pickingDetailId;
      private Integer transactStatus;
      private BigDecimal pickingArea;
      private BigDecimal handlingArea;
      private String purchaser;
      private BigDecimal actualTheoryWeight;
      private Boolean isNeedRemind;

      SteelPlateOutboundDTOParamBuilder() {
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder halfMode(final Integer halfMode) {
         this.halfMode = halfMode;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder halfSize(final BigDecimal halfSize) {
         this.halfSize = halfSize;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder materialId(final Long materialId) {
         this.materialId = materialId;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder materialOutboundMode(final Integer materialOutboundMode) {
         this.materialOutboundMode = materialOutboundMode;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder outboundUnit(final String outboundUnit) {
         this.outboundUnit = outboundUnit;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder outboundUnitPrecision(final Integer outboundUnitPrecision) {
         this.outboundUnitPrecision = outboundUnitPrecision;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder outboundAddress(final Integer outboundAddress) {
         this.outboundAddress = outboundAddress;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder convertId(final Long convertId) {
         this.convertId = convertId;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder battenList(final List<BattenDetailDTOParam> battenList) {
         this.battenList = battenList;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder outbound(final Outbound outbound) {
         this.outbound = outbound;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder inputMete(final BigDecimal inputMete) {
         this.inputMete = inputMete;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder sellUnitPrice(final BigDecimal sellUnitPrice) {
         this.sellUnitPrice = sellUnitPrice;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder sellAmount(final BigDecimal sellAmount) {
         this.sellAmount = sellAmount;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder boolSubmitCheck(final Boolean boolSubmitCheck) {
         this.boolSubmitCheck = boolSubmitCheck;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder materialFreezeRecordId(final Long materialFreezeRecordId) {
         this.materialFreezeRecordId = materialFreezeRecordId;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder taskOrderNumber(final String taskOrderNumber) {
         this.taskOrderNumber = taskOrderNumber;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder pickingMete(final BigDecimal pickingMete) {
         this.pickingMete = pickingMete;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder pickingIds(final List<Long> pickingIds) {
         this.pickingIds = pickingIds;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder pickingDetailIds(final List<Long> pickingDetailIds) {
         this.pickingDetailIds = pickingDetailIds;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder pickingId(final Long pickingId) {
         this.pickingId = pickingId;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder pickingDetailId(final Long pickingDetailId) {
         this.pickingDetailId = pickingDetailId;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder transactStatus(final Integer transactStatus) {
         this.transactStatus = transactStatus;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder pickingArea(final BigDecimal pickingArea) {
         this.pickingArea = pickingArea;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder handlingArea(final BigDecimal handlingArea) {
         this.handlingArea = handlingArea;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder purchaser(final String purchaser) {
         this.purchaser = purchaser;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder actualTheoryWeight(final BigDecimal actualTheoryWeight) {
         this.actualTheoryWeight = actualTheoryWeight;
         return this;
      }

      public SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder isNeedRemind(final Boolean isNeedRemind) {
         this.isNeedRemind = isNeedRemind;
         return this;
      }

      public SteelPlateOutboundDTOParam build() {
         return new SteelPlateOutboundDTOParam(
            this.id,
            this.halfMode,
            this.halfSize,
            this.materialId,
            this.materialOutboundMode,
            this.outboundUnit,
            this.outboundUnitPrecision,
            this.outboundAddress,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.quantity,
            this.mete,
            this.totalWeight,
            this.recipientId,
            this.workshopId,
            this.remark,
            this.convertId,
            this.outboundTime,
            this.boolPartyA,
            this.battenList,
            this.purchaseId,
            this.outboundTypeSelection,
            this.reviewStatus,
            this.outbound,
            this.branchCompanyId,
            this.inputMete,
            this.sellUnitPrice,
            this.sellAmount,
            this.invoiceType,
            this.taxRate,
            this.boolSubmitCheck,
            this.serialNumber,
            this.weightMeasurementMode,
            this.materialFreezeRecordId,
            this.taskOrderId,
            this.taskOrderNumber,
            this.pickingMete,
            this.pickingIds,
            this.pickingDetailIds,
            this.pickingId,
            this.pickingDetailId,
            this.transactStatus,
            this.pickingArea,
            this.handlingArea,
            this.purchaser,
            this.actualTheoryWeight,
            this.isNeedRemind
         );
      }

      @Override
      public String toString() {
         return "SteelPlateOutboundDTOParam.SteelPlateOutboundDTOParamBuilder(id="
            + this.id
            + ", halfMode="
            + this.halfMode
            + ", halfSize="
            + this.halfSize
            + ", materialId="
            + this.materialId
            + ", materialOutboundMode="
            + this.materialOutboundMode
            + ", outboundUnit="
            + this.outboundUnit
            + ", outboundUnitPrecision="
            + this.outboundUnitPrecision
            + ", outboundAddress="
            + this.outboundAddress
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", totalWeight="
            + this.totalWeight
            + ", recipientId="
            + this.recipientId
            + ", workshopId="
            + this.workshopId
            + ", remark="
            + this.remark
            + ", convertId="
            + this.convertId
            + ", outboundTime="
            + this.outboundTime
            + ", boolPartyA="
            + this.boolPartyA
            + ", battenList="
            + this.battenList
            + ", purchaseId="
            + this.purchaseId
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", reviewStatus="
            + this.reviewStatus
            + ", outbound="
            + this.outbound
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", inputMete="
            + this.inputMete
            + ", sellUnitPrice="
            + this.sellUnitPrice
            + ", sellAmount="
            + this.sellAmount
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", boolSubmitCheck="
            + this.boolSubmitCheck
            + ", serialNumber="
            + this.serialNumber
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", materialFreezeRecordId="
            + this.materialFreezeRecordId
            + ", taskOrderId="
            + this.taskOrderId
            + ", taskOrderNumber="
            + this.taskOrderNumber
            + ", pickingMete="
            + this.pickingMete
            + ", pickingIds="
            + this.pickingIds
            + ", pickingDetailIds="
            + this.pickingDetailIds
            + ", pickingId="
            + this.pickingId
            + ", pickingDetailId="
            + this.pickingDetailId
            + ", transactStatus="
            + this.transactStatus
            + ", pickingArea="
            + this.pickingArea
            + ", handlingArea="
            + this.handlingArea
            + ", purchaser="
            + this.purchaser
            + ", actualTheoryWeight="
            + this.actualTheoryWeight
            + ", isNeedRemind="
            + this.isNeedRemind
            + ")";
      }
   }
}
