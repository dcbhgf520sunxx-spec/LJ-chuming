package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundListDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReturnDetailDO {
   private Long id;
   private Long classifyId;
   private Boolean boolPartyA;
   private Integer basicClass;
   private String specification;
   private String color;
   private String brand;
   private String heatNoAndBatchNo;
   private BigDecimal quantity;
   private BigDecimal thickness;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal mete;
   private BigDecimal weight;
   private BigDecimal unitPrice;
   private BigDecimal unitPriceExcludingVAT;
   private BigDecimal amount;
   private BigDecimal amountExcludingVAT;
   private BigDecimal inputVAT;
   private ProjectInfo project;
   private Integer invoiceType;
   private BigDecimal taxRate;
   private Long standardId;
   private String nationalStandard;
   private BriefIdAndNameDTO workshop;
   private BriefIdAndNameDTO warehouse;
   private ReturnDTO returnReceipt;
   private OutboundListDTO outboundReceipt;
   private String remark;
   private Long materialReturnableId;
   private String recipient;
   private String departmentName;
   private BigDecimal quantityCount;
   private BigDecimal meteCount;
   private BigDecimal amountCount;
   private BigDecimal amountExcludingVatCount;
   private Integer outboundTypeSelection;
   private LocalDateTime realTime;
   private String yearMonth;
   private String serialNumber;
   private String measureUnit;
   private String accountingUnit;
   private String workshopName;
   private Boolean boolReturns;
   private Long materialCodeConfigId;
   private String materialSnNew;
   private LocalDateTime reviewTime;

   public static ReturnDetailDO.ReturnDetailDOBuilder builder() {
      return new ReturnDetailDO.ReturnDetailDOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
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

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getWeight() {
      return this.weight;
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

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public ReturnDTO getReturnReceipt() {
      return this.returnReceipt;
   }

   public OutboundListDTO getOutboundReceipt() {
      return this.outboundReceipt;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getMaterialReturnableId() {
      return this.materialReturnableId;
   }

   public String getRecipient() {
      return this.recipient;
   }

   public String getDepartmentName() {
      return this.departmentName;
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

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   public String getYearMonth() {
      return this.yearMonth;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Boolean getBoolReturns() {
      return this.boolReturns;
   }

   public Long getMaterialCodeConfigId() {
      return this.materialCodeConfigId;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
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

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
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

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setReturnReceipt(final ReturnDTO returnReceipt) {
      this.returnReceipt = returnReceipt;
   }

   public void setOutboundReceipt(final OutboundListDTO outboundReceipt) {
      this.outboundReceipt = outboundReceipt;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setMaterialReturnableId(final Long materialReturnableId) {
      this.materialReturnableId = materialReturnableId;
   }

   public void setRecipient(final String recipient) {
      this.recipient = recipient;
   }

   public void setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
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

   public void setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
   }

   public void setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
   }

   public void setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setBoolReturns(final Boolean boolReturns) {
      this.boolReturns = boolReturns;
   }

   public void setMaterialCodeConfigId(final Long materialCodeConfigId) {
      this.materialCodeConfigId = materialCodeConfigId;
   }

   public void setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReturnDetailDO)) {
         return false;
      }

      ReturnDetailDO other = (ReturnDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$boolPartyA = this.getBoolPartyA();
            Object other$boolPartyA = other.getBoolPartyA();
            if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$invoiceType = this.getInvoiceType();
                  Object other$invoiceType = other.getInvoiceType();
                  if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                     Object this$standardId = this.getStandardId();
                     Object other$standardId = other.getStandardId();
                     if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                        Object this$materialReturnableId = this.getMaterialReturnableId();
                        Object other$materialReturnableId = other.getMaterialReturnableId();
                        if (this$materialReturnableId == null
                           ? other$materialReturnableId == null
                           : this$materialReturnableId.equals(other$materialReturnableId)) {
                           Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                           Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                           if (this$outboundTypeSelection == null
                              ? other$outboundTypeSelection == null
                              : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                              Object this$boolReturns = this.getBoolReturns();
                              Object other$boolReturns = other.getBoolReturns();
                              if (this$boolReturns == null ? other$boolReturns == null : this$boolReturns.equals(other$boolReturns)) {
                                 Object this$materialCodeConfigId = this.getMaterialCodeConfigId();
                                 Object other$materialCodeConfigId = other.getMaterialCodeConfigId();
                                 if (this$materialCodeConfigId == null
                                    ? other$materialCodeConfigId == null
                                    : this$materialCodeConfigId.equals(other$materialCodeConfigId)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$color = this.getColor();
                                       Object other$color = other.getColor();
                                       if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                          Object this$brand = this.getBrand();
                                          Object other$brand = other.getBrand();
                                          if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                             Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                             Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                             if (this$heatNoAndBatchNo == null
                                                ? other$heatNoAndBatchNo == null
                                                : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                Object this$quantity = this.getQuantity();
                                                Object other$quantity = other.getQuantity();
                                                if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                   Object this$thickness = this.getThickness();
                                                   Object other$thickness = other.getThickness();
                                                   if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                      Object this$length = this.getLength();
                                                      Object other$length = other.getLength();
                                                      if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                         Object this$width = this.getWidth();
                                                         Object other$width = other.getWidth();
                                                         if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                            Object this$mete = this.getMete();
                                                            Object other$mete = other.getMete();
                                                            if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                               Object this$weight = this.getWeight();
                                                               Object other$weight = other.getWeight();
                                                               if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                                  Object this$unitPrice = this.getUnitPrice();
                                                                  Object other$unitPrice = other.getUnitPrice();
                                                                  if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)
                                                                     )
                                                                   {
                                                                     Object this$unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
                                                                     Object other$unitPriceExcludingVAT = other.getUnitPriceExcludingVAT();
                                                                     if (this$unitPriceExcludingVAT == null
                                                                        ? other$unitPriceExcludingVAT == null
                                                                        : this$unitPriceExcludingVAT.equals(other$unitPriceExcludingVAT)) {
                                                                        Object this$amount = this.getAmount();
                                                                        Object other$amount = other.getAmount();
                                                                        if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                           Object this$amountExcludingVAT = this.getAmountExcludingVAT();
                                                                           Object other$amountExcludingVAT = other.getAmountExcludingVAT();
                                                                           if (this$amountExcludingVAT == null
                                                                              ? other$amountExcludingVAT == null
                                                                              : this$amountExcludingVAT.equals(other$amountExcludingVAT)) {
                                                                              Object this$inputVAT = this.getInputVAT();
                                                                              Object other$inputVAT = other.getInputVAT();
                                                                              if (this$inputVAT == null
                                                                                 ? other$inputVAT == null
                                                                                 : this$inputVAT.equals(other$inputVAT)) {
                                                                                 Object this$project = this.getProject();
                                                                                 Object other$project = other.getProject();
                                                                                 if (this$project == null
                                                                                    ? other$project == null
                                                                                    : this$project.equals(other$project)) {
                                                                                    Object this$taxRate = this.getTaxRate();
                                                                                    Object other$taxRate = other.getTaxRate();
                                                                                    if (this$taxRate == null
                                                                                       ? other$taxRate == null
                                                                                       : this$taxRate.equals(other$taxRate)) {
                                                                                       Object this$nationalStandard = this.getNationalStandard();
                                                                                       Object other$nationalStandard = other.getNationalStandard();
                                                                                       if (this$nationalStandard == null
                                                                                          ? other$nationalStandard == null
                                                                                          : this$nationalStandard.equals(other$nationalStandard)) {
                                                                                          Object this$workshop = this.getWorkshop();
                                                                                          Object other$workshop = other.getWorkshop();
                                                                                          if (this$workshop == null
                                                                                             ? other$workshop == null
                                                                                             : this$workshop.equals(other$workshop)) {
                                                                                             Object this$warehouse = this.getWarehouse();
                                                                                             Object other$warehouse = other.getWarehouse();
                                                                                             if (this$warehouse == null
                                                                                                ? other$warehouse == null
                                                                                                : this$warehouse.equals(other$warehouse)) {
                                                                                                Object this$returnReceipt = this.getReturnReceipt();
                                                                                                Object other$returnReceipt = other.getReturnReceipt();
                                                                                                if (this$returnReceipt == null
                                                                                                   ? other$returnReceipt == null
                                                                                                   : this$returnReceipt.equals(other$returnReceipt)) {
                                                                                                   Object this$outboundReceipt = this.getOutboundReceipt();
                                                                                                   Object other$outboundReceipt = other.getOutboundReceipt();
                                                                                                   if (this$outboundReceipt == null
                                                                                                      ? other$outboundReceipt == null
                                                                                                      : this$outboundReceipt.equals(other$outboundReceipt)) {
                                                                                                      Object this$remark = this.getRemark();
                                                                                                      Object other$remark = other.getRemark();
                                                                                                      if (this$remark == null
                                                                                                         ? other$remark == null
                                                                                                         : this$remark.equals(other$remark)) {
                                                                                                         Object this$recipient = this.getRecipient();
                                                                                                         Object other$recipient = other.getRecipient();
                                                                                                         if (this$recipient == null
                                                                                                            ? other$recipient == null
                                                                                                            : this$recipient.equals(other$recipient)) {
                                                                                                            Object this$departmentName = this.getDepartmentName();
                                                                                                            Object other$departmentName = other.getDepartmentName();
                                                                                                            if (this$departmentName == null
                                                                                                               ? other$departmentName == null
                                                                                                               : this$departmentName.equals(
                                                                                                                  other$departmentName
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
                                                                                                                     : this$meteCount.equals(other$meteCount)) {
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
                                                                                                                           Object this$realTime = this.getRealTime();
                                                                                                                           Object other$realTime = other.getRealTime();
                                                                                                                           if (this$realTime == null
                                                                                                                              ? other$realTime == null
                                                                                                                              : this$realTime.equals(
                                                                                                                                 other$realTime
                                                                                                                              )) {
                                                                                                                              Object this$yearMonth = this.getYearMonth();
                                                                                                                              Object other$yearMonth = other.getYearMonth();
                                                                                                                              if (this$yearMonth == null
                                                                                                                                 ? other$yearMonth == null
                                                                                                                                 : this$yearMonth.equals(
                                                                                                                                    other$yearMonth
                                                                                                                                 )) {
                                                                                                                                 Object this$serialNumber = this.getSerialNumber();
                                                                                                                                 Object other$serialNumber = other.getSerialNumber();
                                                                                                                                 if (this$serialNumber == null
                                                                                                                                    ? other$serialNumber
                                                                                                                                       == null
                                                                                                                                    : this$serialNumber.equals(
                                                                                                                                       other$serialNumber
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
                                                                                                                                          Object this$workshopName = this.getWorkshopName();
                                                                                                                                          Object other$workshopName = other.getWorkshopName();
                                                                                                                                          if (this$workshopName
                                                                                                                                                == null
                                                                                                                                             ? other$workshopName
                                                                                                                                                == null
                                                                                                                                             : this$workshopName.equals(
                                                                                                                                                other$workshopName
                                                                                                                                             )) {
                                                                                                                                             Object this$materialSnNew = this.getMaterialSnNew();
                                                                                                                                             Object other$materialSnNew = other.getMaterialSnNew();
                                                                                                                                             if (this$materialSnNew
                                                                                                                                                   == null
                                                                                                                                                ? other$materialSnNew
                                                                                                                                                   == null
                                                                                                                                                : this$materialSnNew.equals(
                                                                                                                                                   other$materialSnNew
                                                                                                                                                )) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ReturnDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $materialReturnableId = this.getMaterialReturnableId();
      result = result * 59 + ($materialReturnableId == null ? 43 : $materialReturnableId.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $boolReturns = this.getBoolReturns();
      result = result * 59 + ($boolReturns == null ? 43 : $boolReturns.hashCode());
      Object $materialCodeConfigId = this.getMaterialCodeConfigId();
      result = result * 59 + ($materialCodeConfigId == null ? 43 : $materialCodeConfigId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
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
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $returnReceipt = this.getReturnReceipt();
      result = result * 59 + ($returnReceipt == null ? 43 : $returnReceipt.hashCode());
      Object $outboundReceipt = this.getOutboundReceipt();
      result = result * 59 + ($outboundReceipt == null ? 43 : $outboundReceipt.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $recipient = this.getRecipient();
      result = result * 59 + ($recipient == null ? 43 : $recipient.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $quantityCount = this.getQuantityCount();
      result = result * 59 + ($quantityCount == null ? 43 : $quantityCount.hashCode());
      Object $meteCount = this.getMeteCount();
      result = result * 59 + ($meteCount == null ? 43 : $meteCount.hashCode());
      Object $amountCount = this.getAmountCount();
      result = result * 59 + ($amountCount == null ? 43 : $amountCount.hashCode());
      Object $amountExcludingVatCount = this.getAmountExcludingVatCount();
      result = result * 59 + ($amountExcludingVatCount == null ? 43 : $amountExcludingVatCount.hashCode());
      Object $realTime = this.getRealTime();
      result = result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      result = result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
      Object $reviewTime = this.getReviewTime();
      return result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
   }

   @Override
   public String toString() {
      return "ReturnDetailDO(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", quantity="
         + this.getQuantity()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", mete="
         + this.getMete()
         + ", weight="
         + this.getWeight()
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
         + ", project="
         + this.getProject()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", standardId="
         + this.getStandardId()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", workshop="
         + this.getWorkshop()
         + ", warehouse="
         + this.getWarehouse()
         + ", returnReceipt="
         + this.getReturnReceipt()
         + ", outboundReceipt="
         + this.getOutboundReceipt()
         + ", remark="
         + this.getRemark()
         + ", materialReturnableId="
         + this.getMaterialReturnableId()
         + ", recipient="
         + this.getRecipient()
         + ", departmentName="
         + this.getDepartmentName()
         + ", quantityCount="
         + this.getQuantityCount()
         + ", meteCount="
         + this.getMeteCount()
         + ", amountCount="
         + this.getAmountCount()
         + ", amountExcludingVatCount="
         + this.getAmountExcludingVatCount()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", realTime="
         + this.getRealTime()
         + ", yearMonth="
         + this.getYearMonth()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", workshopName="
         + this.getWorkshopName()
         + ", boolReturns="
         + this.getBoolReturns()
         + ", materialCodeConfigId="
         + this.getMaterialCodeConfigId()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ", reviewTime="
         + this.getReviewTime()
         + ")";
   }

   public ReturnDetailDO(
      final Long id,
      final Long classifyId,
      final Boolean boolPartyA,
      final Integer basicClass,
      final String specification,
      final String color,
      final String brand,
      final String heatNoAndBatchNo,
      final BigDecimal quantity,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal mete,
      final BigDecimal weight,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVAT,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT,
      final ProjectInfo project,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final Long standardId,
      final String nationalStandard,
      final BriefIdAndNameDTO workshop,
      final BriefIdAndNameDTO warehouse,
      final ReturnDTO returnReceipt,
      final OutboundListDTO outboundReceipt,
      final String remark,
      final Long materialReturnableId,
      final String recipient,
      final String departmentName,
      final BigDecimal quantityCount,
      final BigDecimal meteCount,
      final BigDecimal amountCount,
      final BigDecimal amountExcludingVatCount,
      final Integer outboundTypeSelection,
      final LocalDateTime realTime,
      final String yearMonth,
      final String serialNumber,
      final String measureUnit,
      final String accountingUnit,
      final String workshopName,
      final Boolean boolReturns,
      final Long materialCodeConfigId,
      final String materialSnNew,
      final LocalDateTime reviewTime
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.boolPartyA = boolPartyA;
      this.basicClass = basicClass;
      this.specification = specification;
      this.color = color;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.quantity = quantity;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.mete = mete;
      this.weight = weight;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
      this.project = project;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.standardId = standardId;
      this.nationalStandard = nationalStandard;
      this.workshop = workshop;
      this.warehouse = warehouse;
      this.returnReceipt = returnReceipt;
      this.outboundReceipt = outboundReceipt;
      this.remark = remark;
      this.materialReturnableId = materialReturnableId;
      this.recipient = recipient;
      this.departmentName = departmentName;
      this.quantityCount = quantityCount;
      this.meteCount = meteCount;
      this.amountCount = amountCount;
      this.amountExcludingVatCount = amountExcludingVatCount;
      this.outboundTypeSelection = outboundTypeSelection;
      this.realTime = realTime;
      this.yearMonth = yearMonth;
      this.serialNumber = serialNumber;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.workshopName = workshopName;
      this.boolReturns = boolReturns;
      this.materialCodeConfigId = materialCodeConfigId;
      this.materialSnNew = materialSnNew;
      this.reviewTime = reviewTime;
   }

   public ReturnDetailDO() {
   }

   public static class ReturnDetailDOBuilder {
      private Long id;
      private Long classifyId;
      private Boolean boolPartyA;
      private Integer basicClass;
      private String specification;
      private String color;
      private String brand;
      private String heatNoAndBatchNo;
      private BigDecimal quantity;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal mete;
      private BigDecimal weight;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVAT;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;
      private ProjectInfo project;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private Long standardId;
      private String nationalStandard;
      private BriefIdAndNameDTO workshop;
      private BriefIdAndNameDTO warehouse;
      private ReturnDTO returnReceipt;
      private OutboundListDTO outboundReceipt;
      private String remark;
      private Long materialReturnableId;
      private String recipient;
      private String departmentName;
      private BigDecimal quantityCount;
      private BigDecimal meteCount;
      private BigDecimal amountCount;
      private BigDecimal amountExcludingVatCount;
      private Integer outboundTypeSelection;
      private LocalDateTime realTime;
      private String yearMonth;
      private String serialNumber;
      private String measureUnit;
      private String accountingUnit;
      private String workshopName;
      private Boolean boolReturns;
      private Long materialCodeConfigId;
      private String materialSnNew;
      private LocalDateTime reviewTime;

      ReturnDetailDOBuilder() {
      }

      public ReturnDetailDO.ReturnDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder returnReceipt(final ReturnDTO returnReceipt) {
         this.returnReceipt = returnReceipt;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder outboundReceipt(final OutboundListDTO outboundReceipt) {
         this.outboundReceipt = outboundReceipt;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder materialReturnableId(final Long materialReturnableId) {
         this.materialReturnableId = materialReturnableId;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder recipient(final String recipient) {
         this.recipient = recipient;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder quantityCount(final BigDecimal quantityCount) {
         this.quantityCount = quantityCount;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder meteCount(final BigDecimal meteCount) {
         this.meteCount = meteCount;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder amountCount(final BigDecimal amountCount) {
         this.amountCount = amountCount;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder amountExcludingVatCount(final BigDecimal amountExcludingVatCount) {
         this.amountExcludingVatCount = amountExcludingVatCount;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder yearMonth(final String yearMonth) {
         this.yearMonth = yearMonth;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder boolReturns(final Boolean boolReturns) {
         this.boolReturns = boolReturns;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder materialCodeConfigId(final Long materialCodeConfigId) {
         this.materialCodeConfigId = materialCodeConfigId;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public ReturnDetailDO.ReturnDetailDOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public ReturnDetailDO build() {
         return new ReturnDetailDO(
            this.id,
            this.classifyId,
            this.boolPartyA,
            this.basicClass,
            this.specification,
            this.color,
            this.brand,
            this.heatNoAndBatchNo,
            this.quantity,
            this.thickness,
            this.length,
            this.width,
            this.mete,
            this.weight,
            this.unitPrice,
            this.unitPriceExcludingVAT,
            this.amount,
            this.amountExcludingVAT,
            this.inputVAT,
            this.project,
            this.invoiceType,
            this.taxRate,
            this.standardId,
            this.nationalStandard,
            this.workshop,
            this.warehouse,
            this.returnReceipt,
            this.outboundReceipt,
            this.remark,
            this.materialReturnableId,
            this.recipient,
            this.departmentName,
            this.quantityCount,
            this.meteCount,
            this.amountCount,
            this.amountExcludingVatCount,
            this.outboundTypeSelection,
            this.realTime,
            this.yearMonth,
            this.serialNumber,
            this.measureUnit,
            this.accountingUnit,
            this.workshopName,
            this.boolReturns,
            this.materialCodeConfigId,
            this.materialSnNew,
            this.reviewTime
         );
      }

      @Override
      public String toString() {
         return "ReturnDetailDO.ReturnDetailDOBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", boolPartyA="
            + this.boolPartyA
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", quantity="
            + this.quantity
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", mete="
            + this.mete
            + ", weight="
            + this.weight
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
            + ", project="
            + this.project
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", standardId="
            + this.standardId
            + ", nationalStandard="
            + this.nationalStandard
            + ", workshop="
            + this.workshop
            + ", warehouse="
            + this.warehouse
            + ", returnReceipt="
            + this.returnReceipt
            + ", outboundReceipt="
            + this.outboundReceipt
            + ", remark="
            + this.remark
            + ", materialReturnableId="
            + this.materialReturnableId
            + ", recipient="
            + this.recipient
            + ", departmentName="
            + this.departmentName
            + ", quantityCount="
            + this.quantityCount
            + ", meteCount="
            + this.meteCount
            + ", amountCount="
            + this.amountCount
            + ", amountExcludingVatCount="
            + this.amountExcludingVatCount
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", realTime="
            + this.realTime
            + ", yearMonth="
            + this.yearMonth
            + ", serialNumber="
            + this.serialNumber
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", workshopName="
            + this.workshopName
            + ", boolReturns="
            + this.boolReturns
            + ", materialCodeConfigId="
            + this.materialCodeConfigId
            + ", materialSnNew="
            + this.materialSnNew
            + ", reviewTime="
            + this.reviewTime
            + ")";
      }
   }
}
