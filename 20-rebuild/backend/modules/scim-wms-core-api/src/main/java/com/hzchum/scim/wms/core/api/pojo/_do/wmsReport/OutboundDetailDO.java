package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailSellDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundListDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutboundDetailDO {
   private Long id;
   private Boolean boolPartyA;
   private Integer materialIsWhole;
   private Integer materialOutboundMode;
   private Long classifyId;
   private Integer basicClass;
   private BigDecimal quantity;
   private BigDecimal thickness;
   private BigDecimal length;
   private BigDecimal width;
   private String heatNoAndBatchNo;
   private String specification;
   private String brand;
   private String color;
   private String remark;
   private BigDecimal mete;
   private Integer outboundRelationType;
   private Boolean boolBasicClassChange;
   private Integer invoiceType;
   private BigDecimal taxRate;
   private BigDecimal unitPrice;
   private BigDecimal unitPriceExcludingVAT;
   private BigDecimal amount;
   private BigDecimal amountExcludingVAT;
   private BigDecimal inputVAT;
   private BigDecimal unitNet;
   private ProjectInfo project;
   private String monomerName;
   private String areaName;
   private String areaBatchName;
   private Integer type;
   private BriefIdAndNameDTO factory;
   private BriefIdAndNameDTO warehouse;
   private OutboundListDTO outboundReceipt;
   private Long standardId;
   private String nationalStandard;
   private String recipientName;
   private BriefIdAndNameDTO workshop;
   private BriefIdAndNameDTO mesWorkshop;
   private String measureUnit;
   private String accountingUnit;
   private Integer accountingPrecision;
   private Integer measurePrecision;
   private Long wapId;
   private BigDecimal quantityCount;
   private BigDecimal meteCount;
   private BigDecimal amountCount;
   private BigDecimal amountExcludingVatCount;
   private BigDecimal unitPriceNoFreight;
   private OutboundDetailSellDTO outboundDetailSellDTO;
   private String orderSerialNumber;
   private String applicantName;
   private LocalDateTime applicantTime;
   private Integer outboundTypeSelection;
   private Boolean boolScheduling;
   private String childOrderNumber;
   private Long materialCodeConfigId;
   private String materialSnNew;
   private BigDecimal actualTheoryWeight;
   private Long outboundId;
   private String purchaser;
   private LocalDateTime reviewTime;
   private Long projectId;

   public static OutboundDetailDO.OutboundDetailDOBuilder builder() {
      return new OutboundDetailDO.OutboundDetailDOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Integer getMaterialOutboundMode() {
      return this.materialOutboundMode;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getOutboundRelationType() {
      return this.outboundRelationType;
   }

   public Boolean getBoolBasicClassChange() {
      return this.boolBasicClassChange;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVAT() {
      return this.unitPriceExcludingVAT;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   public BigDecimal getInputVAT() {
      return this.inputVAT;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getAreaBatchName() {
      return this.areaBatchName;
   }

   public Integer getType() {
      return this.type;
   }

   public BriefIdAndNameDTO getFactory() {
      return this.factory;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public OutboundListDTO getOutboundReceipt() {
      return this.outboundReceipt;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public String getRecipientName() {
      return this.recipientName;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BriefIdAndNameDTO getMesWorkshop() {
      return this.mesWorkshop;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public Long getWapId() {
      return this.wapId;
   }

   public BigDecimal getQuantityCount() {
      return this.quantityCount;
   }

   public BigDecimal getMeteCount() {
      return this.meteCount;
   }

   public BigDecimal getAmountCount() {
      return this.amountCount;
   }

   public BigDecimal getAmountExcludingVatCount() {
      return this.amountExcludingVatCount;
   }

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public OutboundDetailSellDTO getOutboundDetailSellDTO() {
      return this.outboundDetailSellDTO;
   }

   public String getOrderSerialNumber() {
      return this.orderSerialNumber;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getApplicantTime() {
      return this.applicantTime;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public Boolean getBoolScheduling() {
      return this.boolScheduling;
   }

   public String getChildOrderNumber() {
      return this.childOrderNumber;
   }

   public Long getMaterialCodeConfigId() {
      return this.materialCodeConfigId;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public BigDecimal getActualTheoryWeight() {
      return this.actualTheoryWeight;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public String getPurchaser() {
      return this.purchaser;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
   }

   public void setMaterialOutboundMode(final Integer materialOutboundMode) {
      this.materialOutboundMode = materialOutboundMode;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setOutboundRelationType(final Integer outboundRelationType) {
      this.outboundRelationType = outboundRelationType;
   }

   public void setBoolBasicClassChange(final Boolean boolBasicClassChange) {
      this.boolBasicClassChange = boolBasicClassChange;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setUnitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public void setInputVAT(final BigDecimal inputVAT) {
      this.inputVAT = inputVAT;
   }

   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setAreaBatchName(final String areaBatchName) {
      this.areaBatchName = areaBatchName;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setFactory(final BriefIdAndNameDTO factory) {
      this.factory = factory;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setOutboundReceipt(final OutboundListDTO outboundReceipt) {
      this.outboundReceipt = outboundReceipt;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setMesWorkshop(final BriefIdAndNameDTO mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setWapId(final Long wapId) {
      this.wapId = wapId;
   }

   public void setQuantityCount(final BigDecimal quantityCount) {
      this.quantityCount = quantityCount;
   }

   public void setMeteCount(final BigDecimal meteCount) {
      this.meteCount = meteCount;
   }

   public void setAmountCount(final BigDecimal amountCount) {
      this.amountCount = amountCount;
   }

   public void setAmountExcludingVatCount(final BigDecimal amountExcludingVatCount) {
      this.amountExcludingVatCount = amountExcludingVatCount;
   }

   public void setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
   }

   public void setOutboundDetailSellDTO(final OutboundDetailSellDTO outboundDetailSellDTO) {
      this.outboundDetailSellDTO = outboundDetailSellDTO;
   }

   public void setOrderSerialNumber(final String orderSerialNumber) {
      this.orderSerialNumber = orderSerialNumber;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setApplicantTime(final LocalDateTime applicantTime) {
      this.applicantTime = applicantTime;
   }

   public void setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
   }

   public void setBoolScheduling(final Boolean boolScheduling) {
      this.boolScheduling = boolScheduling;
   }

   public void setChildOrderNumber(final String childOrderNumber) {
      this.childOrderNumber = childOrderNumber;
   }

   public void setMaterialCodeConfigId(final Long materialCodeConfigId) {
      this.materialCodeConfigId = materialCodeConfigId;
   }

   public void setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
   }

   public void setActualTheoryWeight(final BigDecimal actualTheoryWeight) {
      this.actualTheoryWeight = actualTheoryWeight;
   }

   public void setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
   }

   public void setPurchaser(final String purchaser) {
      this.purchaser = purchaser;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundDetailDO)) {
         return false;
      }

      OutboundDetailDO other = (OutboundDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolPartyA = this.getBoolPartyA();
         Object other$boolPartyA = other.getBoolPartyA();
         if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
            Object this$materialIsWhole = this.getMaterialIsWhole();
            Object other$materialIsWhole = other.getMaterialIsWhole();
            if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
               Object this$materialOutboundMode = this.getMaterialOutboundMode();
               Object other$materialOutboundMode = other.getMaterialOutboundMode();
               if (this$materialOutboundMode == null ? other$materialOutboundMode == null : this$materialOutboundMode.equals(other$materialOutboundMode)) {
                  Object this$classifyId = this.getClassifyId();
                  Object other$classifyId = other.getClassifyId();
                  if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                     Object this$basicClass = this.getBasicClass();
                     Object other$basicClass = other.getBasicClass();
                     if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                        Object this$outboundRelationType = this.getOutboundRelationType();
                        Object other$outboundRelationType = other.getOutboundRelationType();
                        if (this$outboundRelationType == null
                           ? other$outboundRelationType == null
                           : this$outboundRelationType.equals(other$outboundRelationType)) {
                           Object this$boolBasicClassChange = this.getBoolBasicClassChange();
                           Object other$boolBasicClassChange = other.getBoolBasicClassChange();
                           if (this$boolBasicClassChange == null
                              ? other$boolBasicClassChange == null
                              : this$boolBasicClassChange.equals(other$boolBasicClassChange)) {
                              Object this$invoiceType = this.getInvoiceType();
                              Object other$invoiceType = other.getInvoiceType();
                              if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                 Object this$type = this.getType();
                                 Object other$type = other.getType();
                                 if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                    Object this$standardId = this.getStandardId();
                                    Object other$standardId = other.getStandardId();
                                    if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                       Object this$accountingPrecision = this.getAccountingPrecision();
                                       Object other$accountingPrecision = other.getAccountingPrecision();
                                       if (this$accountingPrecision == null
                                          ? other$accountingPrecision == null
                                          : this$accountingPrecision.equals(other$accountingPrecision)) {
                                          Object this$measurePrecision = this.getMeasurePrecision();
                                          Object other$measurePrecision = other.getMeasurePrecision();
                                          if (this$measurePrecision == null
                                             ? other$measurePrecision == null
                                             : this$measurePrecision.equals(other$measurePrecision)) {
                                             Object this$wapId = this.getWapId();
                                             Object other$wapId = other.getWapId();
                                             if (this$wapId == null ? other$wapId == null : this$wapId.equals(other$wapId)) {
                                                Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                                                Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                                                if (this$outboundTypeSelection == null
                                                   ? other$outboundTypeSelection == null
                                                   : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                                                   Object this$boolScheduling = this.getBoolScheduling();
                                                   Object other$boolScheduling = other.getBoolScheduling();
                                                   if (this$boolScheduling == null
                                                      ? other$boolScheduling == null
                                                      : this$boolScheduling.equals(other$boolScheduling)) {
                                                      Object this$materialCodeConfigId = this.getMaterialCodeConfigId();
                                                      Object other$materialCodeConfigId = other.getMaterialCodeConfigId();
                                                      if (this$materialCodeConfigId == null
                                                         ? other$materialCodeConfigId == null
                                                         : this$materialCodeConfigId.equals(other$materialCodeConfigId)) {
                                                         Object this$outboundId = this.getOutboundId();
                                                         Object other$outboundId = other.getOutboundId();
                                                         if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
                                                            Object this$projectId = this.getProjectId();
                                                            Object other$projectId = other.getProjectId();
                                                            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                                               Object this$quantity = this.getQuantity();
                                                               Object other$quantity = other.getQuantity();
                                                               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                                  Object this$thickness = this.getThickness();
                                                                  Object other$thickness = other.getThickness();
                                                                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)
                                                                     )
                                                                   {
                                                                     Object this$length = this.getLength();
                                                                     Object other$length = other.getLength();
                                                                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                        Object this$width = this.getWidth();
                                                                        Object other$width = other.getWidth();
                                                                        if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                           Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                           Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                           if (this$heatNoAndBatchNo == null
                                                                              ? other$heatNoAndBatchNo == null
                                                                              : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                              Object this$specification = this.getSpecification();
                                                                              Object other$specification = other.getSpecification();
                                                                              if (this$specification == null
                                                                                 ? other$specification == null
                                                                                 : this$specification.equals(other$specification)) {
                                                                                 Object this$brand = this.getBrand();
                                                                                 Object other$brand = other.getBrand();
                                                                                 if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                                    Object this$color = this.getColor();
                                                                                    Object other$color = other.getColor();
                                                                                    if (this$color == null
                                                                                       ? other$color == null
                                                                                       : this$color.equals(other$color)) {
                                                                                       Object this$remark = this.getRemark();
                                                                                       Object other$remark = other.getRemark();
                                                                                       if (this$remark == null
                                                                                          ? other$remark == null
                                                                                          : this$remark.equals(other$remark)) {
                                                                                          Object this$mete = this.getMete();
                                                                                          Object other$mete = other.getMete();
                                                                                          if (this$mete == null
                                                                                             ? other$mete == null
                                                                                             : this$mete.equals(other$mete)) {
                                                                                             Object this$taxRate = this.getTaxRate();
                                                                                             Object other$taxRate = other.getTaxRate();
                                                                                             if (this$taxRate == null
                                                                                                ? other$taxRate == null
                                                                                                : this$taxRate.equals(other$taxRate)) {
                                                                                                Object this$unitPrice = this.getUnitPrice();
                                                                                                Object other$unitPrice = other.getUnitPrice();
                                                                                                if (this$unitPrice == null
                                                                                                   ? other$unitPrice == null
                                                                                                   : this$unitPrice.equals(other$unitPrice)) {
                                                                                                   Object this$unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
                                                                                                   Object other$unitPriceExcludingVAT = other.getUnitPriceExcludingVAT();
                                                                                                   if (this$unitPriceExcludingVAT == null
                                                                                                      ? other$unitPriceExcludingVAT == null
                                                                                                      : this$unitPriceExcludingVAT.equals(
                                                                                                         other$unitPriceExcludingVAT
                                                                                                      )) {
                                                                                                      Object this$amount = this.getAmount();
                                                                                                      Object other$amount = other.getAmount();
                                                                                                      if (this$amount == null
                                                                                                         ? other$amount == null
                                                                                                         : this$amount.equals(other$amount)) {
                                                                                                         Object this$amountExcludingVAT = this.getAmountExcludingVAT();
                                                                                                         Object other$amountExcludingVAT = other.getAmountExcludingVAT();
                                                                                                         if (this$amountExcludingVAT == null
                                                                                                            ? other$amountExcludingVAT == null
                                                                                                            : this$amountExcludingVAT.equals(
                                                                                                               other$amountExcludingVAT
                                                                                                            )) {
                                                                                                            Object this$inputVAT = this.getInputVAT();
                                                                                                            Object other$inputVAT = other.getInputVAT();
                                                                                                            if (this$inputVAT == null
                                                                                                               ? other$inputVAT == null
                                                                                                               : this$inputVAT.equals(other$inputVAT)) {
                                                                                                               Object this$unitNet = this.getUnitNet();
                                                                                                               Object other$unitNet = other.getUnitNet();
                                                                                                               if (this$unitNet == null
                                                                                                                  ? other$unitNet == null
                                                                                                                  : this$unitNet.equals(other$unitNet)) {
                                                                                                                  Object this$project = this.getProject();
                                                                                                                  Object other$project = other.getProject();
                                                                                                                  if (this$project == null
                                                                                                                     ? other$project == null
                                                                                                                     : this$project.equals(other$project)) {
                                                                                                                     Object this$monomerName = this.getMonomerName();
                                                                                                                     Object other$monomerName = other.getMonomerName();
                                                                                                                     if (this$monomerName == null
                                                                                                                        ? other$monomerName == null
                                                                                                                        : this$monomerName.equals(
                                                                                                                           other$monomerName
                                                                                                                        )) {
                                                                                                                        Object this$areaName = this.getAreaName();
                                                                                                                        Object other$areaName = other.getAreaName();
                                                                                                                        if (this$areaName == null
                                                                                                                           ? other$areaName == null
                                                                                                                           : this$areaName.equals(
                                                                                                                              other$areaName
                                                                                                                           )) {
                                                                                                                           Object this$areaBatchName = this.getAreaBatchName();
                                                                                                                           Object other$areaBatchName = other.getAreaBatchName();
                                                                                                                           if (this$areaBatchName == null
                                                                                                                              ? other$areaBatchName == null
                                                                                                                              : this$areaBatchName.equals(
                                                                                                                                 other$areaBatchName
                                                                                                                              )) {
                                                                                                                              Object this$factory = this.getFactory();
                                                                                                                              Object other$factory = other.getFactory();
                                                                                                                              if (this$factory == null
                                                                                                                                 ? other$factory == null
                                                                                                                                 : this$factory.equals(
                                                                                                                                    other$factory
                                                                                                                                 )) {
                                                                                                                                 Object this$warehouse = this.getWarehouse();
                                                                                                                                 Object other$warehouse = other.getWarehouse();
                                                                                                                                 if (this$warehouse == null
                                                                                                                                    ? other$warehouse == null
                                                                                                                                    : this$warehouse.equals(
                                                                                                                                       other$warehouse
                                                                                                                                    )) {
                                                                                                                                    Object this$outboundReceipt = this.getOutboundReceipt();
                                                                                                                                    Object other$outboundReceipt = other.getOutboundReceipt();
                                                                                                                                    if (this$outboundReceipt
                                                                                                                                          == null
                                                                                                                                       ? other$outboundReceipt
                                                                                                                                          == null
                                                                                                                                       : this$outboundReceipt.equals(
                                                                                                                                          other$outboundReceipt
                                                                                                                                       )) {
                                                                                                                                       Object this$nationalStandard = this.getNationalStandard();
                                                                                                                                       Object other$nationalStandard = other.getNationalStandard();
                                                                                                                                       if (this$nationalStandard
                                                                                                                                             == null
                                                                                                                                          ? other$nationalStandard
                                                                                                                                             == null
                                                                                                                                          : this$nationalStandard.equals(
                                                                                                                                             other$nationalStandard
                                                                                                                                          )) {
                                                                                                                                          Object this$recipientName = this.getRecipientName();
                                                                                                                                          Object other$recipientName = other.getRecipientName();
                                                                                                                                          if (this$recipientName
                                                                                                                                                == null
                                                                                                                                             ? other$recipientName
                                                                                                                                                == null
                                                                                                                                             : this$recipientName.equals(
                                                                                                                                                other$recipientName
                                                                                                                                             )) {
                                                                                                                                             Object this$workshop = this.getWorkshop();
                                                                                                                                             Object other$workshop = other.getWorkshop();
                                                                                                                                             if (this$workshop
                                                                                                                                                   == null
                                                                                                                                                ? other$workshop
                                                                                                                                                   == null
                                                                                                                                                : this$workshop.equals(
                                                                                                                                                   other$workshop
                                                                                                                                                )) {
                                                                                                                                                Object this$mesWorkshop = this.getMesWorkshop();
                                                                                                                                                Object other$mesWorkshop = other.getMesWorkshop();
                                                                                                                                                if (this$mesWorkshop
                                                                                                                                                      == null
                                                                                                                                                   ? other$mesWorkshop
                                                                                                                                                      == null
                                                                                                                                                   : this$mesWorkshop.equals(
                                                                                                                                                      other$mesWorkshop
                                                                                                                                                   )) {
                                                                                                                                                   Object this$measureUnit = this.getMeasureUnit();
                                                                                                                                                   Object other$measureUnit = other.getMeasureUnit();
                                                                                                                                                   if (this$measureUnit
                                                                                                                                                         == null
                                                                                                                                                      ? other$measureUnit
                                                                                                                                                         == null
                                                                                                                                                      : this$measureUnit.equals(
                                                                                                                                                         other$measureUnit
                                                                                                                                                      )) {
                                                                                                                                                      Object this$accountingUnit = this.getAccountingUnit();
                                                                                                                                                      Object other$accountingUnit = other.getAccountingUnit();
                                                                                                                                                      if (this$accountingUnit
                                                                                                                                                            == null
                                                                                                                                                         ? other$accountingUnit
                                                                                                                                                            == null
                                                                                                                                                         : this$accountingUnit.equals(
                                                                                                                                                            other$accountingUnit
                                                                                                                                                         )) {
                                                                                                                                                         Object this$quantityCount = this.getQuantityCount();
                                                                                                                                                         Object other$quantityCount = other.getQuantityCount();
                                                                                                                                                         if (this$quantityCount
                                                                                                                                                               == null
                                                                                                                                                            ? other$quantityCount
                                                                                                                                                               == null
                                                                                                                                                            : this$quantityCount.equals(
                                                                                                                                                               other$quantityCount
                                                                                                                                                            )) {
                                                                                                                                                            Object this$meteCount = this.getMeteCount();
                                                                                                                                                            Object other$meteCount = other.getMeteCount();
                                                                                                                                                            if (this$meteCount
                                                                                                                                                                  == null
                                                                                                                                                               ? other$meteCount
                                                                                                                                                                  == null
                                                                                                                                                               : this$meteCount.equals(
                                                                                                                                                                  other$meteCount
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$amountCount = this.getAmountCount();
                                                                                                                                                               Object other$amountCount = other.getAmountCount();
                                                                                                                                                               if (this$amountCount
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$amountCount
                                                                                                                                                                     == null
                                                                                                                                                                  : this$amountCount.equals(
                                                                                                                                                                     other$amountCount
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$amountExcludingVatCount = this.getAmountExcludingVatCount();
                                                                                                                                                                  Object other$amountExcludingVatCount = other.getAmountExcludingVatCount();
                                                                                                                                                                  if (this$amountExcludingVatCount
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$amountExcludingVatCount
                                                                                                                                                                        == null
                                                                                                                                                                     : this$amountExcludingVatCount.equals(
                                                                                                                                                                        other$amountExcludingVatCount
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$unitPriceNoFreight = this.getUnitPriceNoFreight();
                                                                                                                                                                     Object other$unitPriceNoFreight = other.getUnitPriceNoFreight();
                                                                                                                                                                     if (this$unitPriceNoFreight
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$unitPriceNoFreight
                                                                                                                                                                           == null
                                                                                                                                                                        : this$unitPriceNoFreight.equals(
                                                                                                                                                                           other$unitPriceNoFreight
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$outboundDetailSellDTO = this.getOutboundDetailSellDTO();
                                                                                                                                                                        Object other$outboundDetailSellDTO = other.getOutboundDetailSellDTO();
                                                                                                                                                                        if (this$outboundDetailSellDTO
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$outboundDetailSellDTO
                                                                                                                                                                              == null
                                                                                                                                                                           : this$outboundDetailSellDTO.equals(
                                                                                                                                                                              other$outboundDetailSellDTO
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$orderSerialNumber = this.getOrderSerialNumber();
                                                                                                                                                                           Object other$orderSerialNumber = other.getOrderSerialNumber();
                                                                                                                                                                           if (this$orderSerialNumber
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$orderSerialNumber
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$orderSerialNumber.equals(
                                                                                                                                                                                 other$orderSerialNumber
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$applicantName = this.getApplicantName();
                                                                                                                                                                              Object other$applicantName = other.getApplicantName();
                                                                                                                                                                              if (this$applicantName
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$applicantName
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$applicantName.equals(
                                                                                                                                                                                    other$applicantName
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$applicantTime = this.getApplicantTime();
                                                                                                                                                                                 Object other$applicantTime = other.getApplicantTime();
                                                                                                                                                                                 if (this$applicantTime
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$applicantTime
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$applicantTime.equals(
                                                                                                                                                                                       other$applicantTime
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$childOrderNumber = this.getChildOrderNumber();
                                                                                                                                                                                    Object other$childOrderNumber = other.getChildOrderNumber();
                                                                                                                                                                                    if (this$childOrderNumber
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$childOrderNumber
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$childOrderNumber.equals(
                                                                                                                                                                                          other$childOrderNumber
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$materialSnNew = this.getMaterialSnNew();
                                                                                                                                                                                       Object other$materialSnNew = other.getMaterialSnNew();
                                                                                                                                                                                       if (this$materialSnNew
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$materialSnNew
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$materialSnNew.equals(
                                                                                                                                                                                             other$materialSnNew
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Object this$actualTheoryWeight = this.getActualTheoryWeight();
                                                                                                                                                                                          Object other$actualTheoryWeight = other.getActualTheoryWeight();
                                                                                                                                                                                          if (this$actualTheoryWeight
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$actualTheoryWeight
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$actualTheoryWeight.equals(
                                                                                                                                                                                                other$actualTheoryWeight
                                                                                                                                                                                             )
                                                                                                                                                                                             )
                                                                                                                                                                                           {
                                                                                                                                                                                             Object this$purchaser = this.getPurchaser();
                                                                                                                                                                                             Object other$purchaser = other.getPurchaser();
                                                                                                                                                                                             if (this$purchaser
                                                                                                                                                                                                   == null
                                                                                                                                                                                                ? other$purchaser
                                                                                                                                                                                                   == null
                                                                                                                                                                                                : this$purchaser.equals(
                                                                                                                                                                                                   other$purchaser
                                                                                                                                                                                                )
                                                                                                                                                                                                )
                                                                                                                                                                                              {
                                                                                                                                                                                                Object this$reviewTime = this.getReviewTime();
                                                                                                                                                                                                Object other$reviewTime = other.getReviewTime();
                                                                                                                                                                                                return this$reviewTime
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   ? other$reviewTime
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   : this$reviewTime.equals(
                                                                                                                                                                                                      other$reviewTime
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OutboundDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $materialOutboundMode = this.getMaterialOutboundMode();
      result = result * 59 + ($materialOutboundMode == null ? 43 : $materialOutboundMode.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $outboundRelationType = this.getOutboundRelationType();
      result = result * 59 + ($outboundRelationType == null ? 43 : $outboundRelationType.hashCode());
      Object $boolBasicClassChange = this.getBoolBasicClassChange();
      result = result * 59 + ($boolBasicClassChange == null ? 43 : $boolBasicClassChange.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $wapId = this.getWapId();
      result = result * 59 + ($wapId == null ? 43 : $wapId.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $boolScheduling = this.getBoolScheduling();
      result = result * 59 + ($boolScheduling == null ? 43 : $boolScheduling.hashCode());
      Object $materialCodeConfigId = this.getMaterialCodeConfigId();
      result = result * 59 + ($materialCodeConfigId == null ? 43 : $materialCodeConfigId.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
      result = result * 59 + ($unitPriceExcludingVAT == null ? 43 : $unitPriceExcludingVAT.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $inputVAT = this.getInputVAT();
      result = result * 59 + ($inputVAT == null ? 43 : $inputVAT.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $areaBatchName = this.getAreaBatchName();
      result = result * 59 + ($areaBatchName == null ? 43 : $areaBatchName.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $outboundReceipt = this.getOutboundReceipt();
      result = result * 59 + ($outboundReceipt == null ? 43 : $outboundReceipt.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $recipientName = this.getRecipientName();
      result = result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      result = result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $quantityCount = this.getQuantityCount();
      result = result * 59 + ($quantityCount == null ? 43 : $quantityCount.hashCode());
      Object $meteCount = this.getMeteCount();
      result = result * 59 + ($meteCount == null ? 43 : $meteCount.hashCode());
      Object $amountCount = this.getAmountCount();
      result = result * 59 + ($amountCount == null ? 43 : $amountCount.hashCode());
      Object $amountExcludingVatCount = this.getAmountExcludingVatCount();
      result = result * 59 + ($amountExcludingVatCount == null ? 43 : $amountExcludingVatCount.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $outboundDetailSellDTO = this.getOutboundDetailSellDTO();
      result = result * 59 + ($outboundDetailSellDTO == null ? 43 : $outboundDetailSellDTO.hashCode());
      Object $orderSerialNumber = this.getOrderSerialNumber();
      result = result * 59 + ($orderSerialNumber == null ? 43 : $orderSerialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $applicantTime = this.getApplicantTime();
      result = result * 59 + ($applicantTime == null ? 43 : $applicantTime.hashCode());
      Object $childOrderNumber = this.getChildOrderNumber();
      result = result * 59 + ($childOrderNumber == null ? 43 : $childOrderNumber.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      result = result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
      Object $actualTheoryWeight = this.getActualTheoryWeight();
      result = result * 59 + ($actualTheoryWeight == null ? 43 : $actualTheoryWeight.hashCode());
      Object $purchaser = this.getPurchaser();
      result = result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
      Object $reviewTime = this.getReviewTime();
      return result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundDetailDO(id="
         + this.getId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", materialOutboundMode="
         + this.getMaterialOutboundMode()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", quantity="
         + this.getQuantity()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", specification="
         + this.getSpecification()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", remark="
         + this.getRemark()
         + ", mete="
         + this.getMete()
         + ", outboundRelationType="
         + this.getOutboundRelationType()
         + ", boolBasicClassChange="
         + this.getBoolBasicClassChange()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVAT="
         + this.getUnitPriceExcludingVAT()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", inputVAT="
         + this.getInputVAT()
         + ", unitNet="
         + this.getUnitNet()
         + ", project="
         + this.getProject()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", areaBatchName="
         + this.getAreaBatchName()
         + ", type="
         + this.getType()
         + ", factory="
         + this.getFactory()
         + ", warehouse="
         + this.getWarehouse()
         + ", outboundReceipt="
         + this.getOutboundReceipt()
         + ", standardId="
         + this.getStandardId()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", recipientName="
         + this.getRecipientName()
         + ", workshop="
         + this.getWorkshop()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", wapId="
         + this.getWapId()
         + ", quantityCount="
         + this.getQuantityCount()
         + ", meteCount="
         + this.getMeteCount()
         + ", amountCount="
         + this.getAmountCount()
         + ", amountExcludingVatCount="
         + this.getAmountExcludingVatCount()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", outboundDetailSellDTO="
         + this.getOutboundDetailSellDTO()
         + ", orderSerialNumber="
         + this.getOrderSerialNumber()
         + ", applicantName="
         + this.getApplicantName()
         + ", applicantTime="
         + this.getApplicantTime()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", boolScheduling="
         + this.getBoolScheduling()
         + ", childOrderNumber="
         + this.getChildOrderNumber()
         + ", materialCodeConfigId="
         + this.getMaterialCodeConfigId()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ", actualTheoryWeight="
         + this.getActualTheoryWeight()
         + ", outboundId="
         + this.getOutboundId()
         + ", purchaser="
         + this.getPurchaser()
         + ", reviewTime="
         + this.getReviewTime()
         + ", projectId="
         + this.getProjectId()
         + ")";
   }

   public OutboundDetailDO(
      final Long id,
      final Boolean boolPartyA,
      final Integer materialIsWhole,
      final Integer materialOutboundMode,
      final Long classifyId,
      final Integer basicClass,
      final BigDecimal quantity,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final String heatNoAndBatchNo,
      final String specification,
      final String brand,
      final String color,
      final String remark,
      final BigDecimal mete,
      final Integer outboundRelationType,
      final Boolean boolBasicClassChange,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVAT,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT,
      final BigDecimal unitNet,
      final ProjectInfo project,
      final String monomerName,
      final String areaName,
      final String areaBatchName,
      final Integer type,
      final BriefIdAndNameDTO factory,
      final BriefIdAndNameDTO warehouse,
      final OutboundListDTO outboundReceipt,
      final Long standardId,
      final String nationalStandard,
      final String recipientName,
      final BriefIdAndNameDTO workshop,
      final BriefIdAndNameDTO mesWorkshop,
      final String measureUnit,
      final String accountingUnit,
      final Integer accountingPrecision,
      final Integer measurePrecision,
      final Long wapId,
      final BigDecimal quantityCount,
      final BigDecimal meteCount,
      final BigDecimal amountCount,
      final BigDecimal amountExcludingVatCount,
      final BigDecimal unitPriceNoFreight,
      final OutboundDetailSellDTO outboundDetailSellDTO,
      final String orderSerialNumber,
      final String applicantName,
      final LocalDateTime applicantTime,
      final Integer outboundTypeSelection,
      final Boolean boolScheduling,
      final String childOrderNumber,
      final Long materialCodeConfigId,
      final String materialSnNew,
      final BigDecimal actualTheoryWeight,
      final Long outboundId,
      final String purchaser,
      final LocalDateTime reviewTime,
      final Long projectId
   ) {
      this.id = id;
      this.boolPartyA = boolPartyA;
      this.materialIsWhole = materialIsWhole;
      this.materialOutboundMode = materialOutboundMode;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.quantity = quantity;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.specification = specification;
      this.brand = brand;
      this.color = color;
      this.remark = remark;
      this.mete = mete;
      this.outboundRelationType = outboundRelationType;
      this.boolBasicClassChange = boolBasicClassChange;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
      this.unitNet = unitNet;
      this.project = project;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.areaBatchName = areaBatchName;
      this.type = type;
      this.factory = factory;
      this.warehouse = warehouse;
      this.outboundReceipt = outboundReceipt;
      this.standardId = standardId;
      this.nationalStandard = nationalStandard;
      this.recipientName = recipientName;
      this.workshop = workshop;
      this.mesWorkshop = mesWorkshop;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.measurePrecision = measurePrecision;
      this.wapId = wapId;
      this.quantityCount = quantityCount;
      this.meteCount = meteCount;
      this.amountCount = amountCount;
      this.amountExcludingVatCount = amountExcludingVatCount;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.outboundDetailSellDTO = outboundDetailSellDTO;
      this.orderSerialNumber = orderSerialNumber;
      this.applicantName = applicantName;
      this.applicantTime = applicantTime;
      this.outboundTypeSelection = outboundTypeSelection;
      this.boolScheduling = boolScheduling;
      this.childOrderNumber = childOrderNumber;
      this.materialCodeConfigId = materialCodeConfigId;
      this.materialSnNew = materialSnNew;
      this.actualTheoryWeight = actualTheoryWeight;
      this.outboundId = outboundId;
      this.purchaser = purchaser;
      this.reviewTime = reviewTime;
      this.projectId = projectId;
   }

   public OutboundDetailDO() {
   }

   public static class OutboundDetailDOBuilder {
      private Long id;
      private Boolean boolPartyA;
      private Integer materialIsWhole;
      private Integer materialOutboundMode;
      private Long classifyId;
      private Integer basicClass;
      private BigDecimal quantity;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private String heatNoAndBatchNo;
      private String specification;
      private String brand;
      private String color;
      private String remark;
      private BigDecimal mete;
      private Integer outboundRelationType;
      private Boolean boolBasicClassChange;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVAT;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;
      private BigDecimal unitNet;
      private ProjectInfo project;
      private String monomerName;
      private String areaName;
      private String areaBatchName;
      private Integer type;
      private BriefIdAndNameDTO factory;
      private BriefIdAndNameDTO warehouse;
      private OutboundListDTO outboundReceipt;
      private Long standardId;
      private String nationalStandard;
      private String recipientName;
      private BriefIdAndNameDTO workshop;
      private BriefIdAndNameDTO mesWorkshop;
      private String measureUnit;
      private String accountingUnit;
      private Integer accountingPrecision;
      private Integer measurePrecision;
      private Long wapId;
      private BigDecimal quantityCount;
      private BigDecimal meteCount;
      private BigDecimal amountCount;
      private BigDecimal amountExcludingVatCount;
      private BigDecimal unitPriceNoFreight;
      private OutboundDetailSellDTO outboundDetailSellDTO;
      private String orderSerialNumber;
      private String applicantName;
      private LocalDateTime applicantTime;
      private Integer outboundTypeSelection;
      private Boolean boolScheduling;
      private String childOrderNumber;
      private Long materialCodeConfigId;
      private String materialSnNew;
      private BigDecimal actualTheoryWeight;
      private Long outboundId;
      private String purchaser;
      private LocalDateTime reviewTime;
      private Long projectId;

      OutboundDetailDOBuilder() {
      }

      public OutboundDetailDO.OutboundDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder materialOutboundMode(final Integer materialOutboundMode) {
         this.materialOutboundMode = materialOutboundMode;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder outboundRelationType(final Integer outboundRelationType) {
         this.outboundRelationType = outboundRelationType;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder boolBasicClassChange(final Boolean boolBasicClassChange) {
         this.boolBasicClassChange = boolBasicClassChange;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder areaBatchName(final String areaBatchName) {
         this.areaBatchName = areaBatchName;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder factory(final BriefIdAndNameDTO factory) {
         this.factory = factory;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder outboundReceipt(final OutboundListDTO outboundReceipt) {
         this.outboundReceipt = outboundReceipt;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder mesWorkshop(final BriefIdAndNameDTO mesWorkshop) {
         this.mesWorkshop = mesWorkshop;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder wapId(final Long wapId) {
         this.wapId = wapId;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder quantityCount(final BigDecimal quantityCount) {
         this.quantityCount = quantityCount;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder meteCount(final BigDecimal meteCount) {
         this.meteCount = meteCount;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder amountCount(final BigDecimal amountCount) {
         this.amountCount = amountCount;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder amountExcludingVatCount(final BigDecimal amountExcludingVatCount) {
         this.amountExcludingVatCount = amountExcludingVatCount;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder outboundDetailSellDTO(final OutboundDetailSellDTO outboundDetailSellDTO) {
         this.outboundDetailSellDTO = outboundDetailSellDTO;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder orderSerialNumber(final String orderSerialNumber) {
         this.orderSerialNumber = orderSerialNumber;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder applicantTime(final LocalDateTime applicantTime) {
         this.applicantTime = applicantTime;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder boolScheduling(final Boolean boolScheduling) {
         this.boolScheduling = boolScheduling;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder childOrderNumber(final String childOrderNumber) {
         this.childOrderNumber = childOrderNumber;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder materialCodeConfigId(final Long materialCodeConfigId) {
         this.materialCodeConfigId = materialCodeConfigId;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder actualTheoryWeight(final BigDecimal actualTheoryWeight) {
         this.actualTheoryWeight = actualTheoryWeight;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder purchaser(final String purchaser) {
         this.purchaser = purchaser;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public OutboundDetailDO.OutboundDetailDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public OutboundDetailDO build() {
         return new OutboundDetailDO(
            this.id,
            this.boolPartyA,
            this.materialIsWhole,
            this.materialOutboundMode,
            this.classifyId,
            this.basicClass,
            this.quantity,
            this.thickness,
            this.length,
            this.width,
            this.heatNoAndBatchNo,
            this.specification,
            this.brand,
            this.color,
            this.remark,
            this.mete,
            this.outboundRelationType,
            this.boolBasicClassChange,
            this.invoiceType,
            this.taxRate,
            this.unitPrice,
            this.unitPriceExcludingVAT,
            this.amount,
            this.amountExcludingVAT,
            this.inputVAT,
            this.unitNet,
            this.project,
            this.monomerName,
            this.areaName,
            this.areaBatchName,
            this.type,
            this.factory,
            this.warehouse,
            this.outboundReceipt,
            this.standardId,
            this.nationalStandard,
            this.recipientName,
            this.workshop,
            this.mesWorkshop,
            this.measureUnit,
            this.accountingUnit,
            this.accountingPrecision,
            this.measurePrecision,
            this.wapId,
            this.quantityCount,
            this.meteCount,
            this.amountCount,
            this.amountExcludingVatCount,
            this.unitPriceNoFreight,
            this.outboundDetailSellDTO,
            this.orderSerialNumber,
            this.applicantName,
            this.applicantTime,
            this.outboundTypeSelection,
            this.boolScheduling,
            this.childOrderNumber,
            this.materialCodeConfigId,
            this.materialSnNew,
            this.actualTheoryWeight,
            this.outboundId,
            this.purchaser,
            this.reviewTime,
            this.projectId
         );
      }

      @Override
      public String toString() {
         return "OutboundDetailDO.OutboundDetailDOBuilder(id="
            + this.id
            + ", boolPartyA="
            + this.boolPartyA
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", materialOutboundMode="
            + this.materialOutboundMode
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", quantity="
            + this.quantity
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", specification="
            + this.specification
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", remark="
            + this.remark
            + ", mete="
            + this.mete
            + ", outboundRelationType="
            + this.outboundRelationType
            + ", boolBasicClassChange="
            + this.boolBasicClassChange
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVAT="
            + this.unitPriceExcludingVAT
            + ", amount="
            + this.amount
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ", inputVAT="
            + this.inputVAT
            + ", unitNet="
            + this.unitNet
            + ", project="
            + this.project
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", areaBatchName="
            + this.areaBatchName
            + ", type="
            + this.type
            + ", factory="
            + this.factory
            + ", warehouse="
            + this.warehouse
            + ", outboundReceipt="
            + this.outboundReceipt
            + ", standardId="
            + this.standardId
            + ", nationalStandard="
            + this.nationalStandard
            + ", recipientName="
            + this.recipientName
            + ", workshop="
            + this.workshop
            + ", mesWorkshop="
            + this.mesWorkshop
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", measurePrecision="
            + this.measurePrecision
            + ", wapId="
            + this.wapId
            + ", quantityCount="
            + this.quantityCount
            + ", meteCount="
            + this.meteCount
            + ", amountCount="
            + this.amountCount
            + ", amountExcludingVatCount="
            + this.amountExcludingVatCount
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", outboundDetailSellDTO="
            + this.outboundDetailSellDTO
            + ", orderSerialNumber="
            + this.orderSerialNumber
            + ", applicantName="
            + this.applicantName
            + ", applicantTime="
            + this.applicantTime
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", boolScheduling="
            + this.boolScheduling
            + ", childOrderNumber="
            + this.childOrderNumber
            + ", materialCodeConfigId="
            + this.materialCodeConfigId
            + ", materialSnNew="
            + this.materialSnNew
            + ", actualTheoryWeight="
            + this.actualTheoryWeight
            + ", outboundId="
            + this.outboundId
            + ", purchaser="
            + this.purchaser
            + ", reviewTime="
            + this.reviewTime
            + ", projectId="
            + this.projectId
            + ")";
      }
   }
}
