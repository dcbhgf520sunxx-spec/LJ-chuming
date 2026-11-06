package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InboundReceiptDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InboundDetailDO {
   private Long id;
   private Long inboundId;
   private Boolean boolPartyA;
   private String requisitionsSn;
   private Integer basicClass;
   private Integer type;
   private Long classifyId;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal thickness;
   private BigDecimal theoryThickness;
   private BigDecimal theoryWeight;
   private BigDecimal quantity;
   private String brand;
   private String heatNoAndBatchNo;
   private Integer invoiceType;
   private BigDecimal taxRate;
   private String specification;
   private String color;
   private BigDecimal mete;
   private BriefIdAndNameDTO warehouse;
   private BriefIdAndNameDTO workshop;
   private Long projectId;
   private BigDecimal priceExcludingVat;
   private BigDecimal amountExcludingVat;
   private BigDecimal inputVat;
   private BigDecimal amount;
   private BigDecimal unitPrice;
   private String remark;
   private Boolean gasReturnStatus;
   private LocalDateTime inboundTime;
   private Integer rejectStatus;
   private InboundReceiptDTO inboundReceipt;
   private Long standardId;
   private String standardName;
   private BigDecimal quantityCount;
   private BigDecimal meteCount;
   private BigDecimal amountCount;
   private BigDecimal amountExcludingVatCount;
   @ApiModelProperty(name = "amountExcludingVATNoFreight", value = "不含税总价不含运费")
   private BigDecimal amountExcludingVATNoFreight;
   @ApiModelProperty(name = "unitPriceExcludingVATNoFreight", value = "不含税单价不含运费")
   private BigDecimal unitPriceExcludingVATNoFreight;
   @ApiModelProperty(name = "inputVATNoFreight", value = "进项税不含运费")
   private BigDecimal inputVATNoFreight;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "含税单价不含运费")
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "amountNoFreight", value = "入库总价含税 不含运费")
   private BigDecimal amountNoFreight;
   private Long artifactEnclosureId;
   private Long MaterialCodeConfigId;
   private Integer inboundWay;
   private LocalDateTime realTime;

   public static InboundDetailDO.InboundDetailDOBuilder builder() {
      return new InboundDetailDO.InboundDetailDOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public String getRequisitionsSn() {
      return this.requisitionsSn;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public BigDecimal getTheoryWeight() {
      return this.theoryWeight;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getPriceExcludingVat() {
      return this.priceExcludingVat;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getGasReturnStatus() {
      return this.gasReturnStatus;
   }

   public LocalDateTime getInboundTime() {
      return this.inboundTime;
   }

   public Integer getRejectStatus() {
      return this.rejectStatus;
   }

   public InboundReceiptDTO getInboundReceipt() {
      return this.inboundReceipt;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
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

   public BigDecimal getAmountExcludingVATNoFreight() {
      return this.amountExcludingVATNoFreight;
   }

   public BigDecimal getUnitPriceExcludingVATNoFreight() {
      return this.unitPriceExcludingVATNoFreight;
   }

   public BigDecimal getInputVATNoFreight() {
      return this.inputVATNoFreight;
   }

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public Long getArtifactEnclosureId() {
      return this.artifactEnclosureId;
   }

   public Long getMaterialCodeConfigId() {
      return this.MaterialCodeConfigId;
   }

   public Integer getInboundWay() {
      return this.inboundWay;
   }

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setRequisitionsSn(final String requisitionsSn) {
      this.requisitionsSn = requisitionsSn;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
   }

   public void setTheoryWeight(final BigDecimal theoryWeight) {
      this.theoryWeight = theoryWeight;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setPriceExcludingVat(final BigDecimal priceExcludingVat) {
      this.priceExcludingVat = priceExcludingVat;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setGasReturnStatus(final Boolean gasReturnStatus) {
      this.gasReturnStatus = gasReturnStatus;
   }

   public void setInboundTime(final LocalDateTime inboundTime) {
      this.inboundTime = inboundTime;
   }

   public void setRejectStatus(final Integer rejectStatus) {
      this.rejectStatus = rejectStatus;
   }

   public void setInboundReceipt(final InboundReceiptDTO inboundReceipt) {
      this.inboundReceipt = inboundReceipt;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   public void setStandardName(final String standardName) {
      this.standardName = standardName;
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

   public void setAmountExcludingVATNoFreight(final BigDecimal amountExcludingVATNoFreight) {
      this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
   }

   public void setUnitPriceExcludingVATNoFreight(final BigDecimal unitPriceExcludingVATNoFreight) {
      this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
   }

   public void setInputVATNoFreight(final BigDecimal inputVATNoFreight) {
      this.inputVATNoFreight = inputVATNoFreight;
   }

   public void setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
   }

   public void setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
   }

   public void setArtifactEnclosureId(final Long artifactEnclosureId) {
      this.artifactEnclosureId = artifactEnclosureId;
   }

   public void setMaterialCodeConfigId(final Long MaterialCodeConfigId) {
      this.MaterialCodeConfigId = MaterialCodeConfigId;
   }

   public void setInboundWay(final Integer inboundWay) {
      this.inboundWay = inboundWay;
   }

   public void setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundDetailDO)) {
         return false;
      }

      InboundDetailDO other = (InboundDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inboundId = this.getInboundId();
         Object other$inboundId = other.getInboundId();
         if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
            Object this$boolPartyA = this.getBoolPartyA();
            Object other$boolPartyA = other.getBoolPartyA();
            if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$type = this.getType();
                  Object other$type = other.getType();
                  if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                     Object this$classifyId = this.getClassifyId();
                     Object other$classifyId = other.getClassifyId();
                     if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                        Object this$invoiceType = this.getInvoiceType();
                        Object other$invoiceType = other.getInvoiceType();
                        if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                           Object this$projectId = this.getProjectId();
                           Object other$projectId = other.getProjectId();
                           if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                              Object this$gasReturnStatus = this.getGasReturnStatus();
                              Object other$gasReturnStatus = other.getGasReturnStatus();
                              if (this$gasReturnStatus == null ? other$gasReturnStatus == null : this$gasReturnStatus.equals(other$gasReturnStatus)) {
                                 Object this$rejectStatus = this.getRejectStatus();
                                 Object other$rejectStatus = other.getRejectStatus();
                                 if (this$rejectStatus == null ? other$rejectStatus == null : this$rejectStatus.equals(other$rejectStatus)) {
                                    Object this$standardId = this.getStandardId();
                                    Object other$standardId = other.getStandardId();
                                    if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                       Object this$artifactEnclosureId = this.getArtifactEnclosureId();
                                       Object other$artifactEnclosureId = other.getArtifactEnclosureId();
                                       if (this$artifactEnclosureId == null
                                          ? other$artifactEnclosureId == null
                                          : this$artifactEnclosureId.equals(other$artifactEnclosureId)) {
                                          Object this$MaterialCodeConfigId = this.getMaterialCodeConfigId();
                                          Object other$MaterialCodeConfigId = other.getMaterialCodeConfigId();
                                          if (this$MaterialCodeConfigId == null
                                             ? other$MaterialCodeConfigId == null
                                             : this$MaterialCodeConfigId.equals(other$MaterialCodeConfigId)) {
                                             Object this$inboundWay = this.getInboundWay();
                                             Object other$inboundWay = other.getInboundWay();
                                             if (this$inboundWay == null ? other$inboundWay == null : this$inboundWay.equals(other$inboundWay)) {
                                                Object this$requisitionsSn = this.getRequisitionsSn();
                                                Object other$requisitionsSn = other.getRequisitionsSn();
                                                if (this$requisitionsSn == null
                                                   ? other$requisitionsSn == null
                                                   : this$requisitionsSn.equals(other$requisitionsSn)) {
                                                   Object this$length = this.getLength();
                                                   Object other$length = other.getLength();
                                                   if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                      Object this$width = this.getWidth();
                                                      Object other$width = other.getWidth();
                                                      if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                         Object this$thickness = this.getThickness();
                                                         Object other$thickness = other.getThickness();
                                                         if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                            Object this$theoryThickness = this.getTheoryThickness();
                                                            Object other$theoryThickness = other.getTheoryThickness();
                                                            if (this$theoryThickness == null
                                                               ? other$theoryThickness == null
                                                               : this$theoryThickness.equals(other$theoryThickness)) {
                                                               Object this$theoryWeight = this.getTheoryWeight();
                                                               Object other$theoryWeight = other.getTheoryWeight();
                                                               if (this$theoryWeight == null
                                                                  ? other$theoryWeight == null
                                                                  : this$theoryWeight.equals(other$theoryWeight)) {
                                                                  Object this$quantity = this.getQuantity();
                                                                  Object other$quantity = other.getQuantity();
                                                                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                                     Object this$brand = this.getBrand();
                                                                     Object other$brand = other.getBrand();
                                                                     if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                        Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                        Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                        if (this$heatNoAndBatchNo == null
                                                                           ? other$heatNoAndBatchNo == null
                                                                           : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                           Object this$taxRate = this.getTaxRate();
                                                                           Object other$taxRate = other.getTaxRate();
                                                                           if (this$taxRate == null
                                                                              ? other$taxRate == null
                                                                              : this$taxRate.equals(other$taxRate)) {
                                                                              Object this$specification = this.getSpecification();
                                                                              Object other$specification = other.getSpecification();
                                                                              if (this$specification == null
                                                                                 ? other$specification == null
                                                                                 : this$specification.equals(other$specification)) {
                                                                                 Object this$color = this.getColor();
                                                                                 Object other$color = other.getColor();
                                                                                 if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                                    Object this$mete = this.getMete();
                                                                                    Object other$mete = other.getMete();
                                                                                    if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                                       Object this$warehouse = this.getWarehouse();
                                                                                       Object other$warehouse = other.getWarehouse();
                                                                                       if (this$warehouse == null
                                                                                          ? other$warehouse == null
                                                                                          : this$warehouse.equals(other$warehouse)) {
                                                                                          Object this$workshop = this.getWorkshop();
                                                                                          Object other$workshop = other.getWorkshop();
                                                                                          if (this$workshop == null
                                                                                             ? other$workshop == null
                                                                                             : this$workshop.equals(other$workshop)) {
                                                                                             Object this$priceExcludingVat = this.getPriceExcludingVat();
                                                                                             Object other$priceExcludingVat = other.getPriceExcludingVat();
                                                                                             if (this$priceExcludingVat == null
                                                                                                ? other$priceExcludingVat == null
                                                                                                : this$priceExcludingVat.equals(other$priceExcludingVat)) {
                                                                                                Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                if (this$amountExcludingVat == null
                                                                                                   ? other$amountExcludingVat == null
                                                                                                   : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                                                   Object this$inputVat = this.getInputVat();
                                                                                                   Object other$inputVat = other.getInputVat();
                                                                                                   if (this$inputVat == null
                                                                                                      ? other$inputVat == null
                                                                                                      : this$inputVat.equals(other$inputVat)) {
                                                                                                      Object this$amount = this.getAmount();
                                                                                                      Object other$amount = other.getAmount();
                                                                                                      if (this$amount == null
                                                                                                         ? other$amount == null
                                                                                                         : this$amount.equals(other$amount)) {
                                                                                                         Object this$unitPrice = this.getUnitPrice();
                                                                                                         Object other$unitPrice = other.getUnitPrice();
                                                                                                         if (this$unitPrice == null
                                                                                                            ? other$unitPrice == null
                                                                                                            : this$unitPrice.equals(other$unitPrice)) {
                                                                                                            Object this$remark = this.getRemark();
                                                                                                            Object other$remark = other.getRemark();
                                                                                                            if (this$remark == null
                                                                                                               ? other$remark == null
                                                                                                               : this$remark.equals(other$remark)) {
                                                                                                               Object this$inboundTime = this.getInboundTime();
                                                                                                               Object other$inboundTime = other.getInboundTime();
                                                                                                               if (this$inboundTime == null
                                                                                                                  ? other$inboundTime == null
                                                                                                                  : this$inboundTime.equals(other$inboundTime)) {
                                                                                                                  Object this$inboundReceipt = this.getInboundReceipt();
                                                                                                                  Object other$inboundReceipt = other.getInboundReceipt();
                                                                                                                  if (this$inboundReceipt == null
                                                                                                                     ? other$inboundReceipt == null
                                                                                                                     : this$inboundReceipt.equals(
                                                                                                                        other$inboundReceipt
                                                                                                                     )) {
                                                                                                                     Object this$standardName = this.getStandardName();
                                                                                                                     Object other$standardName = other.getStandardName();
                                                                                                                     if (this$standardName == null
                                                                                                                        ? other$standardName == null
                                                                                                                        : this$standardName.equals(
                                                                                                                           other$standardName
                                                                                                                        )) {
                                                                                                                        Object this$quantityCount = this.getQuantityCount();
                                                                                                                        Object other$quantityCount = other.getQuantityCount();
                                                                                                                        if (this$quantityCount == null
                                                                                                                           ? other$quantityCount == null
                                                                                                                           : this$quantityCount.equals(
                                                                                                                              other$quantityCount
                                                                                                                           )) {
                                                                                                                           Object this$meteCount = this.getMeteCount();
                                                                                                                           Object other$meteCount = other.getMeteCount();
                                                                                                                           if (this$meteCount == null
                                                                                                                              ? other$meteCount == null
                                                                                                                              : this$meteCount.equals(
                                                                                                                                 other$meteCount
                                                                                                                              )) {
                                                                                                                              Object this$amountCount = this.getAmountCount();
                                                                                                                              Object other$amountCount = other.getAmountCount();
                                                                                                                              if (this$amountCount == null
                                                                                                                                 ? other$amountCount == null
                                                                                                                                 : this$amountCount.equals(
                                                                                                                                    other$amountCount
                                                                                                                                 )) {
                                                                                                                                 Object this$amountExcludingVatCount = this.getAmountExcludingVatCount();
                                                                                                                                 Object other$amountExcludingVatCount = other.getAmountExcludingVatCount();
                                                                                                                                 if (this$amountExcludingVatCount
                                                                                                                                       == null
                                                                                                                                    ? other$amountExcludingVatCount
                                                                                                                                       == null
                                                                                                                                    : this$amountExcludingVatCount.equals(
                                                                                                                                       other$amountExcludingVatCount
                                                                                                                                    )) {
                                                                                                                                    Object this$amountExcludingVATNoFreight = this.getAmountExcludingVATNoFreight();
                                                                                                                                    Object other$amountExcludingVATNoFreight = other.getAmountExcludingVATNoFreight();
                                                                                                                                    if (this$amountExcludingVATNoFreight
                                                                                                                                          == null
                                                                                                                                       ? other$amountExcludingVATNoFreight
                                                                                                                                          == null
                                                                                                                                       : this$amountExcludingVATNoFreight.equals(
                                                                                                                                          other$amountExcludingVATNoFreight
                                                                                                                                       )) {
                                                                                                                                       Object this$unitPriceExcludingVATNoFreight = this.getUnitPriceExcludingVATNoFreight();
                                                                                                                                       Object other$unitPriceExcludingVATNoFreight = other.getUnitPriceExcludingVATNoFreight();
                                                                                                                                       if (this$unitPriceExcludingVATNoFreight
                                                                                                                                             == null
                                                                                                                                          ? other$unitPriceExcludingVATNoFreight
                                                                                                                                             == null
                                                                                                                                          : this$unitPriceExcludingVATNoFreight.equals(
                                                                                                                                             other$unitPriceExcludingVATNoFreight
                                                                                                                                          )) {
                                                                                                                                          Object this$inputVATNoFreight = this.getInputVATNoFreight();
                                                                                                                                          Object other$inputVATNoFreight = other.getInputVATNoFreight();
                                                                                                                                          if (this$inputVATNoFreight
                                                                                                                                                == null
                                                                                                                                             ? other$inputVATNoFreight
                                                                                                                                                == null
                                                                                                                                             : this$inputVATNoFreight.equals(
                                                                                                                                                other$inputVATNoFreight
                                                                                                                                             )) {
                                                                                                                                             Object this$unitPriceNoFreight = this.getUnitPriceNoFreight();
                                                                                                                                             Object other$unitPriceNoFreight = other.getUnitPriceNoFreight();
                                                                                                                                             if (this$unitPriceNoFreight
                                                                                                                                                   == null
                                                                                                                                                ? other$unitPriceNoFreight
                                                                                                                                                   == null
                                                                                                                                                : this$unitPriceNoFreight.equals(
                                                                                                                                                   other$unitPriceNoFreight
                                                                                                                                                )) {
                                                                                                                                                Object this$amountNoFreight = this.getAmountNoFreight();
                                                                                                                                                Object other$amountNoFreight = other.getAmountNoFreight();
                                                                                                                                                if (this$amountNoFreight
                                                                                                                                                      == null
                                                                                                                                                   ? other$amountNoFreight
                                                                                                                                                      == null
                                                                                                                                                   : this$amountNoFreight.equals(
                                                                                                                                                      other$amountNoFreight
                                                                                                                                                   )) {
                                                                                                                                                   Object this$realTime = this.getRealTime();
                                                                                                                                                   Object other$realTime = other.getRealTime();
                                                                                                                                                   return this$realTime
                                                                                                                                                         == null
                                                                                                                                                      ? other$realTime
                                                                                                                                                         == null
                                                                                                                                                      : this$realTime.equals(
                                                                                                                                                         other$realTime
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InboundDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $gasReturnStatus = this.getGasReturnStatus();
      result = result * 59 + ($gasReturnStatus == null ? 43 : $gasReturnStatus.hashCode());
      Object $rejectStatus = this.getRejectStatus();
      result = result * 59 + ($rejectStatus == null ? 43 : $rejectStatus.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $artifactEnclosureId = this.getArtifactEnclosureId();
      result = result * 59 + ($artifactEnclosureId == null ? 43 : $artifactEnclosureId.hashCode());
      Object $MaterialCodeConfigId = this.getMaterialCodeConfigId();
      result = result * 59 + ($MaterialCodeConfigId == null ? 43 : $MaterialCodeConfigId.hashCode());
      Object $inboundWay = this.getInboundWay();
      result = result * 59 + ($inboundWay == null ? 43 : $inboundWay.hashCode());
      Object $requisitionsSn = this.getRequisitionsSn();
      result = result * 59 + ($requisitionsSn == null ? 43 : $requisitionsSn.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $theoryWeight = this.getTheoryWeight();
      result = result * 59 + ($theoryWeight == null ? 43 : $theoryWeight.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $priceExcludingVat = this.getPriceExcludingVat();
      result = result * 59 + ($priceExcludingVat == null ? 43 : $priceExcludingVat.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $inboundTime = this.getInboundTime();
      result = result * 59 + ($inboundTime == null ? 43 : $inboundTime.hashCode());
      Object $inboundReceipt = this.getInboundReceipt();
      result = result * 59 + ($inboundReceipt == null ? 43 : $inboundReceipt.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $quantityCount = this.getQuantityCount();
      result = result * 59 + ($quantityCount == null ? 43 : $quantityCount.hashCode());
      Object $meteCount = this.getMeteCount();
      result = result * 59 + ($meteCount == null ? 43 : $meteCount.hashCode());
      Object $amountCount = this.getAmountCount();
      result = result * 59 + ($amountCount == null ? 43 : $amountCount.hashCode());
      Object $amountExcludingVatCount = this.getAmountExcludingVatCount();
      result = result * 59 + ($amountExcludingVatCount == null ? 43 : $amountExcludingVatCount.hashCode());
      Object $amountExcludingVATNoFreight = this.getAmountExcludingVATNoFreight();
      result = result * 59 + ($amountExcludingVATNoFreight == null ? 43 : $amountExcludingVATNoFreight.hashCode());
      Object $unitPriceExcludingVATNoFreight = this.getUnitPriceExcludingVATNoFreight();
      result = result * 59 + ($unitPriceExcludingVATNoFreight == null ? 43 : $unitPriceExcludingVATNoFreight.hashCode());
      Object $inputVATNoFreight = this.getInputVATNoFreight();
      result = result * 59 + ($inputVATNoFreight == null ? 43 : $inputVATNoFreight.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $realTime = this.getRealTime();
      return result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
   }

   @Override
   public String toString() {
      return "InboundDetailDO(id="
         + this.getId()
         + ", inboundId="
         + this.getInboundId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", requisitionsSn="
         + this.getRequisitionsSn()
         + ", basicClass="
         + this.getBasicClass()
         + ", type="
         + this.getType()
         + ", classifyId="
         + this.getClassifyId()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", theoryWeight="
         + this.getTheoryWeight()
         + ", quantity="
         + this.getQuantity()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", specification="
         + this.getSpecification()
         + ", color="
         + this.getColor()
         + ", mete="
         + this.getMete()
         + ", warehouse="
         + this.getWarehouse()
         + ", workshop="
         + this.getWorkshop()
         + ", projectId="
         + this.getProjectId()
         + ", priceExcludingVat="
         + this.getPriceExcludingVat()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", amount="
         + this.getAmount()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", remark="
         + this.getRemark()
         + ", gasReturnStatus="
         + this.getGasReturnStatus()
         + ", inboundTime="
         + this.getInboundTime()
         + ", rejectStatus="
         + this.getRejectStatus()
         + ", inboundReceipt="
         + this.getInboundReceipt()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", quantityCount="
         + this.getQuantityCount()
         + ", meteCount="
         + this.getMeteCount()
         + ", amountCount="
         + this.getAmountCount()
         + ", amountExcludingVatCount="
         + this.getAmountExcludingVatCount()
         + ", amountExcludingVATNoFreight="
         + this.getAmountExcludingVATNoFreight()
         + ", unitPriceExcludingVATNoFreight="
         + this.getUnitPriceExcludingVATNoFreight()
         + ", inputVATNoFreight="
         + this.getInputVATNoFreight()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", artifactEnclosureId="
         + this.getArtifactEnclosureId()
         + ", MaterialCodeConfigId="
         + this.getMaterialCodeConfigId()
         + ", inboundWay="
         + this.getInboundWay()
         + ", realTime="
         + this.getRealTime()
         + ")";
   }

   public InboundDetailDO(
      final Long id,
      final Long inboundId,
      final Boolean boolPartyA,
      final String requisitionsSn,
      final Integer basicClass,
      final Integer type,
      final Long classifyId,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final BigDecimal theoryWeight,
      final BigDecimal quantity,
      final String brand,
      final String heatNoAndBatchNo,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final String specification,
      final String color,
      final BigDecimal mete,
      final BriefIdAndNameDTO warehouse,
      final BriefIdAndNameDTO workshop,
      final Long projectId,
      final BigDecimal priceExcludingVat,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final BigDecimal amount,
      final BigDecimal unitPrice,
      final String remark,
      final Boolean gasReturnStatus,
      final LocalDateTime inboundTime,
      final Integer rejectStatus,
      final InboundReceiptDTO inboundReceipt,
      final Long standardId,
      final String standardName,
      final BigDecimal quantityCount,
      final BigDecimal meteCount,
      final BigDecimal amountCount,
      final BigDecimal amountExcludingVatCount,
      final BigDecimal amountExcludingVATNoFreight,
      final BigDecimal unitPriceExcludingVATNoFreight,
      final BigDecimal inputVATNoFreight,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal amountNoFreight,
      final Long artifactEnclosureId,
      final Long MaterialCodeConfigId,
      final Integer inboundWay,
      final LocalDateTime realTime
   ) {
      this.id = id;
      this.inboundId = inboundId;
      this.boolPartyA = boolPartyA;
      this.requisitionsSn = requisitionsSn;
      this.basicClass = basicClass;
      this.type = type;
      this.classifyId = classifyId;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.theoryWeight = theoryWeight;
      this.quantity = quantity;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.specification = specification;
      this.color = color;
      this.mete = mete;
      this.warehouse = warehouse;
      this.workshop = workshop;
      this.projectId = projectId;
      this.priceExcludingVat = priceExcludingVat;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.amount = amount;
      this.unitPrice = unitPrice;
      this.remark = remark;
      this.gasReturnStatus = gasReturnStatus;
      this.inboundTime = inboundTime;
      this.rejectStatus = rejectStatus;
      this.inboundReceipt = inboundReceipt;
      this.standardId = standardId;
      this.standardName = standardName;
      this.quantityCount = quantityCount;
      this.meteCount = meteCount;
      this.amountCount = amountCount;
      this.amountExcludingVatCount = amountExcludingVatCount;
      this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
      this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
      this.inputVATNoFreight = inputVATNoFreight;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.artifactEnclosureId = artifactEnclosureId;
      this.MaterialCodeConfigId = MaterialCodeConfigId;
      this.inboundWay = inboundWay;
      this.realTime = realTime;
   }

   public InboundDetailDO() {
   }

   public static class InboundDetailDOBuilder {
      private Long id;
      private Long inboundId;
      private Boolean boolPartyA;
      private String requisitionsSn;
      private Integer basicClass;
      private Integer type;
      private Long classifyId;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private BigDecimal theoryWeight;
      private BigDecimal quantity;
      private String brand;
      private String heatNoAndBatchNo;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private String specification;
      private String color;
      private BigDecimal mete;
      private BriefIdAndNameDTO warehouse;
      private BriefIdAndNameDTO workshop;
      private Long projectId;
      private BigDecimal priceExcludingVat;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private BigDecimal amount;
      private BigDecimal unitPrice;
      private String remark;
      private Boolean gasReturnStatus;
      private LocalDateTime inboundTime;
      private Integer rejectStatus;
      private InboundReceiptDTO inboundReceipt;
      private Long standardId;
      private String standardName;
      private BigDecimal quantityCount;
      private BigDecimal meteCount;
      private BigDecimal amountCount;
      private BigDecimal amountExcludingVatCount;
      private BigDecimal amountExcludingVATNoFreight;
      private BigDecimal unitPriceExcludingVATNoFreight;
      private BigDecimal inputVATNoFreight;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal amountNoFreight;
      private Long artifactEnclosureId;
      private Long MaterialCodeConfigId;
      private Integer inboundWay;
      private LocalDateTime realTime;

      InboundDetailDOBuilder() {
      }

      public InboundDetailDO.InboundDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder requisitionsSn(final String requisitionsSn) {
         this.requisitionsSn = requisitionsSn;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder theoryWeight(final BigDecimal theoryWeight) {
         this.theoryWeight = theoryWeight;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder priceExcludingVat(final BigDecimal priceExcludingVat) {
         this.priceExcludingVat = priceExcludingVat;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder gasReturnStatus(final Boolean gasReturnStatus) {
         this.gasReturnStatus = gasReturnStatus;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder inboundTime(final LocalDateTime inboundTime) {
         this.inboundTime = inboundTime;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder rejectStatus(final Integer rejectStatus) {
         this.rejectStatus = rejectStatus;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder inboundReceipt(final InboundReceiptDTO inboundReceipt) {
         this.inboundReceipt = inboundReceipt;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder quantityCount(final BigDecimal quantityCount) {
         this.quantityCount = quantityCount;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder meteCount(final BigDecimal meteCount) {
         this.meteCount = meteCount;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder amountCount(final BigDecimal amountCount) {
         this.amountCount = amountCount;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder amountExcludingVatCount(final BigDecimal amountExcludingVatCount) {
         this.amountExcludingVatCount = amountExcludingVatCount;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder amountExcludingVATNoFreight(final BigDecimal amountExcludingVATNoFreight) {
         this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder unitPriceExcludingVATNoFreight(final BigDecimal unitPriceExcludingVATNoFreight) {
         this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder inputVATNoFreight(final BigDecimal inputVATNoFreight) {
         this.inputVATNoFreight = inputVATNoFreight;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder artifactEnclosureId(final Long artifactEnclosureId) {
         this.artifactEnclosureId = artifactEnclosureId;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder MaterialCodeConfigId(final Long MaterialCodeConfigId) {
         this.MaterialCodeConfigId = MaterialCodeConfigId;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder inboundWay(final Integer inboundWay) {
         this.inboundWay = inboundWay;
         return this;
      }

      public InboundDetailDO.InboundDetailDOBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      public InboundDetailDO build() {
         return new InboundDetailDO(
            this.id,
            this.inboundId,
            this.boolPartyA,
            this.requisitionsSn,
            this.basicClass,
            this.type,
            this.classifyId,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.theoryWeight,
            this.quantity,
            this.brand,
            this.heatNoAndBatchNo,
            this.invoiceType,
            this.taxRate,
            this.specification,
            this.color,
            this.mete,
            this.warehouse,
            this.workshop,
            this.projectId,
            this.priceExcludingVat,
            this.amountExcludingVat,
            this.inputVat,
            this.amount,
            this.unitPrice,
            this.remark,
            this.gasReturnStatus,
            this.inboundTime,
            this.rejectStatus,
            this.inboundReceipt,
            this.standardId,
            this.standardName,
            this.quantityCount,
            this.meteCount,
            this.amountCount,
            this.amountExcludingVatCount,
            this.amountExcludingVATNoFreight,
            this.unitPriceExcludingVATNoFreight,
            this.inputVATNoFreight,
            this.unitPriceNoFreight,
            this.amountNoFreight,
            this.artifactEnclosureId,
            this.MaterialCodeConfigId,
            this.inboundWay,
            this.realTime
         );
      }

      @Override
      public String toString() {
         return "InboundDetailDO.InboundDetailDOBuilder(id="
            + this.id
            + ", inboundId="
            + this.inboundId
            + ", boolPartyA="
            + this.boolPartyA
            + ", requisitionsSn="
            + this.requisitionsSn
            + ", basicClass="
            + this.basicClass
            + ", type="
            + this.type
            + ", classifyId="
            + this.classifyId
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", theoryThickness="
            + this.theoryThickness
            + ", theoryWeight="
            + this.theoryWeight
            + ", quantity="
            + this.quantity
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", specification="
            + this.specification
            + ", color="
            + this.color
            + ", mete="
            + this.mete
            + ", warehouse="
            + this.warehouse
            + ", workshop="
            + this.workshop
            + ", projectId="
            + this.projectId
            + ", priceExcludingVat="
            + this.priceExcludingVat
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", amount="
            + this.amount
            + ", unitPrice="
            + this.unitPrice
            + ", remark="
            + this.remark
            + ", gasReturnStatus="
            + this.gasReturnStatus
            + ", inboundTime="
            + this.inboundTime
            + ", rejectStatus="
            + this.rejectStatus
            + ", inboundReceipt="
            + this.inboundReceipt
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", quantityCount="
            + this.quantityCount
            + ", meteCount="
            + this.meteCount
            + ", amountCount="
            + this.amountCount
            + ", amountExcludingVatCount="
            + this.amountExcludingVatCount
            + ", amountExcludingVATNoFreight="
            + this.amountExcludingVATNoFreight
            + ", unitPriceExcludingVATNoFreight="
            + this.unitPriceExcludingVATNoFreight
            + ", inputVATNoFreight="
            + this.inputVATNoFreight
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", artifactEnclosureId="
            + this.artifactEnclosureId
            + ", MaterialCodeConfigId="
            + this.MaterialCodeConfigId
            + ", inboundWay="
            + this.inboundWay
            + ", realTime="
            + this.realTime
            + ")";
      }
   }
}
