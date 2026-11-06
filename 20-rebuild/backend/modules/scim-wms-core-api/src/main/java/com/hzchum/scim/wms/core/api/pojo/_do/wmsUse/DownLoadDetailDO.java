package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DownLoadDetailDO {
   private Long id;
   private String materialSn;
   private Long classifyId;
   private String classifyName;
   private Integer basicClass;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal thickness;
   private Integer invoiceType;
   private BigDecimal taxRate;
   private String specification;
   private String brand;
   private String heatNoAndBatchNo;
   private String color;
   private BigDecimal mete;
   private BigDecimal quantity;
   private BigDecimal amountExcludingVat;
   private BigDecimal amount;
   private BigDecimal unitPrice;
   private BigDecimal unitPriceExcludingVAT;
   private LocalDateTime outboundTime;
   private LocalDateTime reviewTime;
   private String serialNumber;
   private String purchaseSN;
   private String supplierName;
   private String projectName;
   private String projectId;
   private String projectNumber;
   private String warehouseName;
   private String monomerName;
   private String areaName;
   private String areaBatchName;
   private String recipientName;
   private Long recipientId;
   private String workshopName;
   private Measure measure;
   private String directionProjectSerialNumber;
   private String directionProjectName;
   private String directionMonomerName;
   private String directionAreaName;
   private String directionWareHouseName;
   private String directionWmsWorkshopName;
   private Integer transferType;
   private BigDecimal rdRate;
   private Integer rejectStatus;
   private String rejectSerialNumber;
   private LocalDateTime rejectReviewTime;
   private Long inboundId;
   private String remark;
   private String outboundSerialNumber;
   private Long materialReturnableId;
   private Long materialInventoryId;
   private LocalDateTime returnTime;
   private Long wapId;
   private String orderSerialNumber;
   private BigDecimal inputVat;
   private String applicantName;
   private LocalDateTime applicantTime;
   private String wmsWorkshopName;
   private String branchCompanyName;
   private LocalDateTime outboundTypeSelection;
   @ApiModelProperty(name = "amountExcludingVATNoFreight", value = "不含税总价不含运费")
   private BigDecimal amountExcludingVATNoFreight;
   @ApiModelProperty(name = "unitPriceExcludingVATNoFreight", value = "不含税单价不含运费")
   private BigDecimal unitPriceExcludingVATNoFreight;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "含税单价不含运费")
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "amountNoFreight", value = "入库总价含税 不含运费")
   private BigDecimal amountNoFreight;
   private Integer inboundWay;
   private String outboundSn;
   private String materialSnNew;
   @ApiModelProperty(name = "actualTheoryWeight", value = "实时理论重量(出库时最新密度计算的理论总重)")
   private BigDecimal actualTheoryWeight;

   public static DownLoadDetailDO.DownLoadDetailDOBuilder builder() {
      return new DownLoadDetailDO.DownLoadDetailDOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
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

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVAT() {
      return this.unitPriceExcludingVAT;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPurchaseSN() {
      return this.purchaseSN;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectId() {
      return this.projectId;
   }

   public String getProjectNumber() {
      return this.projectNumber;
   }

   public String getWarehouseName() {
      return this.warehouseName;
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

   public String getRecipientName() {
      return this.recipientName;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Measure getMeasure() {
      return this.measure;
   }

   public String getDirectionProjectSerialNumber() {
      return this.directionProjectSerialNumber;
   }

   public String getDirectionProjectName() {
      return this.directionProjectName;
   }

   public String getDirectionMonomerName() {
      return this.directionMonomerName;
   }

   public String getDirectionAreaName() {
      return this.directionAreaName;
   }

   public String getDirectionWareHouseName() {
      return this.directionWareHouseName;
   }

   public String getDirectionWmsWorkshopName() {
      return this.directionWmsWorkshopName;
   }

   public Integer getTransferType() {
      return this.transferType;
   }

   public BigDecimal getRdRate() {
      return this.rdRate;
   }

   public Integer getRejectStatus() {
      return this.rejectStatus;
   }

   public String getRejectSerialNumber() {
      return this.rejectSerialNumber;
   }

   public LocalDateTime getRejectReviewTime() {
      return this.rejectReviewTime;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getOutboundSerialNumber() {
      return this.outboundSerialNumber;
   }

   public Long getMaterialReturnableId() {
      return this.materialReturnableId;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public LocalDateTime getReturnTime() {
      return this.returnTime;
   }

   public Long getWapId() {
      return this.wapId;
   }

   public String getOrderSerialNumber() {
      return this.orderSerialNumber;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getApplicantTime() {
      return this.applicantTime;
   }

   public String getWmsWorkshopName() {
      return this.wmsWorkshopName;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public LocalDateTime getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public BigDecimal getAmountExcludingVATNoFreight() {
      return this.amountExcludingVATNoFreight;
   }

   public BigDecimal getUnitPriceExcludingVATNoFreight() {
      return this.unitPriceExcludingVATNoFreight;
   }

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public Integer getInboundWay() {
      return this.inboundWay;
   }

   public String getOutboundSn() {
      return this.outboundSn;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public BigDecimal getActualTheoryWeight() {
      return this.actualTheoryWeight;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
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

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setUnitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
   }

   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPurchaseSN(final String purchaseSN) {
      this.purchaseSN = purchaseSN;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setProjectId(final String projectId) {
      this.projectId = projectId;
   }

   public void setProjectNumber(final String projectNumber) {
      this.projectNumber = projectNumber;
   }

   public void setWarehouseName(final String warehouseName) {
      this.warehouseName = warehouseName;
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

   public void setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setMeasure(final Measure measure) {
      this.measure = measure;
   }

   public void setDirectionProjectSerialNumber(final String directionProjectSerialNumber) {
      this.directionProjectSerialNumber = directionProjectSerialNumber;
   }

   public void setDirectionProjectName(final String directionProjectName) {
      this.directionProjectName = directionProjectName;
   }

   public void setDirectionMonomerName(final String directionMonomerName) {
      this.directionMonomerName = directionMonomerName;
   }

   public void setDirectionAreaName(final String directionAreaName) {
      this.directionAreaName = directionAreaName;
   }

   public void setDirectionWareHouseName(final String directionWareHouseName) {
      this.directionWareHouseName = directionWareHouseName;
   }

   public void setDirectionWmsWorkshopName(final String directionWmsWorkshopName) {
      this.directionWmsWorkshopName = directionWmsWorkshopName;
   }

   public void setTransferType(final Integer transferType) {
      this.transferType = transferType;
   }

   public void setRdRate(final BigDecimal rdRate) {
      this.rdRate = rdRate;
   }

   public void setRejectStatus(final Integer rejectStatus) {
      this.rejectStatus = rejectStatus;
   }

   public void setRejectSerialNumber(final String rejectSerialNumber) {
      this.rejectSerialNumber = rejectSerialNumber;
   }

   public void setRejectReviewTime(final LocalDateTime rejectReviewTime) {
      this.rejectReviewTime = rejectReviewTime;
   }

   public void setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setOutboundSerialNumber(final String outboundSerialNumber) {
      this.outboundSerialNumber = outboundSerialNumber;
   }

   public void setMaterialReturnableId(final Long materialReturnableId) {
      this.materialReturnableId = materialReturnableId;
   }

   public void setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
   }

   public void setReturnTime(final LocalDateTime returnTime) {
      this.returnTime = returnTime;
   }

   public void setWapId(final Long wapId) {
      this.wapId = wapId;
   }

   public void setOrderSerialNumber(final String orderSerialNumber) {
      this.orderSerialNumber = orderSerialNumber;
   }

   public void setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setApplicantTime(final LocalDateTime applicantTime) {
      this.applicantTime = applicantTime;
   }

   public void setWmsWorkshopName(final String wmsWorkshopName) {
      this.wmsWorkshopName = wmsWorkshopName;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setOutboundTypeSelection(final LocalDateTime outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
   }

   public void setAmountExcludingVATNoFreight(final BigDecimal amountExcludingVATNoFreight) {
      this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
   }

   public void setUnitPriceExcludingVATNoFreight(final BigDecimal unitPriceExcludingVATNoFreight) {
      this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
   }

   public void setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
   }

   public void setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
   }

   public void setInboundWay(final Integer inboundWay) {
      this.inboundWay = inboundWay;
   }

   public void setOutboundSn(final String outboundSn) {
      this.outboundSn = outboundSn;
   }

   public void setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
   }

   public void setActualTheoryWeight(final BigDecimal actualTheoryWeight) {
      this.actualTheoryWeight = actualTheoryWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DownLoadDetailDO)) {
         return false;
      }

      DownLoadDetailDO other = (DownLoadDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$invoiceType = this.getInvoiceType();
               Object other$invoiceType = other.getInvoiceType();
               if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                  Object this$recipientId = this.getRecipientId();
                  Object other$recipientId = other.getRecipientId();
                  if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                     Object this$transferType = this.getTransferType();
                     Object other$transferType = other.getTransferType();
                     if (this$transferType == null ? other$transferType == null : this$transferType.equals(other$transferType)) {
                        Object this$rejectStatus = this.getRejectStatus();
                        Object other$rejectStatus = other.getRejectStatus();
                        if (this$rejectStatus == null ? other$rejectStatus == null : this$rejectStatus.equals(other$rejectStatus)) {
                           Object this$inboundId = this.getInboundId();
                           Object other$inboundId = other.getInboundId();
                           if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
                              Object this$materialReturnableId = this.getMaterialReturnableId();
                              Object other$materialReturnableId = other.getMaterialReturnableId();
                              if (this$materialReturnableId == null
                                 ? other$materialReturnableId == null
                                 : this$materialReturnableId.equals(other$materialReturnableId)) {
                                 Object this$materialInventoryId = this.getMaterialInventoryId();
                                 Object other$materialInventoryId = other.getMaterialInventoryId();
                                 if (this$materialInventoryId == null
                                    ? other$materialInventoryId == null
                                    : this$materialInventoryId.equals(other$materialInventoryId)) {
                                    Object this$wapId = this.getWapId();
                                    Object other$wapId = other.getWapId();
                                    if (this$wapId == null ? other$wapId == null : this$wapId.equals(other$wapId)) {
                                       Object this$inboundWay = this.getInboundWay();
                                       Object other$inboundWay = other.getInboundWay();
                                       if (this$inboundWay == null ? other$inboundWay == null : this$inboundWay.equals(other$inboundWay)) {
                                          Object this$materialSn = this.getMaterialSn();
                                          Object other$materialSn = other.getMaterialSn();
                                          if (this$materialSn == null ? other$materialSn == null : this$materialSn.equals(other$materialSn)) {
                                             Object this$classifyName = this.getClassifyName();
                                             Object other$classifyName = other.getClassifyName();
                                             if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                                Object this$length = this.getLength();
                                                Object other$length = other.getLength();
                                                if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                   Object this$width = this.getWidth();
                                                   Object other$width = other.getWidth();
                                                   if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                      Object this$thickness = this.getThickness();
                                                      Object other$thickness = other.getThickness();
                                                      if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                         Object this$taxRate = this.getTaxRate();
                                                         Object other$taxRate = other.getTaxRate();
                                                         if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                            Object this$specification = this.getSpecification();
                                                            Object other$specification = other.getSpecification();
                                                            if (this$specification == null
                                                               ? other$specification == null
                                                               : this$specification.equals(other$specification)) {
                                                               Object this$brand = this.getBrand();
                                                               Object other$brand = other.getBrand();
                                                               if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                  Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                  Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                  if (this$heatNoAndBatchNo == null
                                                                     ? other$heatNoAndBatchNo == null
                                                                     : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                     Object this$color = this.getColor();
                                                                     Object other$color = other.getColor();
                                                                     if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                        Object this$mete = this.getMete();
                                                                        Object other$mete = other.getMete();
                                                                        if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                           Object this$quantity = this.getQuantity();
                                                                           Object other$quantity = other.getQuantity();
                                                                           if (this$quantity == null
                                                                              ? other$quantity == null
                                                                              : this$quantity.equals(other$quantity)) {
                                                                              Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                              Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                              if (this$amountExcludingVat == null
                                                                                 ? other$amountExcludingVat == null
                                                                                 : this$amountExcludingVat.equals(other$amountExcludingVat)) {
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
                                                                                       Object this$unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
                                                                                       Object other$unitPriceExcludingVAT = other.getUnitPriceExcludingVAT();
                                                                                       if (this$unitPriceExcludingVAT == null
                                                                                          ? other$unitPriceExcludingVAT == null
                                                                                          : this$unitPriceExcludingVAT.equals(other$unitPriceExcludingVAT)) {
                                                                                          Object this$outboundTime = this.getOutboundTime();
                                                                                          Object other$outboundTime = other.getOutboundTime();
                                                                                          if (this$outboundTime == null
                                                                                             ? other$outboundTime == null
                                                                                             : this$outboundTime.equals(other$outboundTime)) {
                                                                                             Object this$reviewTime = this.getReviewTime();
                                                                                             Object other$reviewTime = other.getReviewTime();
                                                                                             if (this$reviewTime == null
                                                                                                ? other$reviewTime == null
                                                                                                : this$reviewTime.equals(other$reviewTime)) {
                                                                                                Object this$serialNumber = this.getSerialNumber();
                                                                                                Object other$serialNumber = other.getSerialNumber();
                                                                                                if (this$serialNumber == null
                                                                                                   ? other$serialNumber == null
                                                                                                   : this$serialNumber.equals(other$serialNumber)) {
                                                                                                   Object this$purchaseSN = this.getPurchaseSN();
                                                                                                   Object other$purchaseSN = other.getPurchaseSN();
                                                                                                   if (this$purchaseSN == null
                                                                                                      ? other$purchaseSN == null
                                                                                                      : this$purchaseSN.equals(other$purchaseSN)) {
                                                                                                      Object this$supplierName = this.getSupplierName();
                                                                                                      Object other$supplierName = other.getSupplierName();
                                                                                                      if (this$supplierName == null
                                                                                                         ? other$supplierName == null
                                                                                                         : this$supplierName.equals(other$supplierName)) {
                                                                                                         Object this$projectName = this.getProjectName();
                                                                                                         Object other$projectName = other.getProjectName();
                                                                                                         if (this$projectName == null
                                                                                                            ? other$projectName == null
                                                                                                            : this$projectName.equals(other$projectName)) {
                                                                                                            Object this$projectId = this.getProjectId();
                                                                                                            Object other$projectId = other.getProjectId();
                                                                                                            if (this$projectId == null
                                                                                                               ? other$projectId == null
                                                                                                               : this$projectId.equals(other$projectId)) {
                                                                                                               Object this$projectNumber = this.getProjectNumber();
                                                                                                               Object other$projectNumber = other.getProjectNumber();
                                                                                                               if (this$projectNumber == null
                                                                                                                  ? other$projectNumber == null
                                                                                                                  : this$projectNumber.equals(
                                                                                                                     other$projectNumber
                                                                                                                  )) {
                                                                                                                  Object this$warehouseName = this.getWarehouseName();
                                                                                                                  Object other$warehouseName = other.getWarehouseName();
                                                                                                                  if (this$warehouseName == null
                                                                                                                     ? other$warehouseName == null
                                                                                                                     : this$warehouseName.equals(
                                                                                                                        other$warehouseName
                                                                                                                     )) {
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
                                                                                                                              Object this$recipientName = this.getRecipientName();
                                                                                                                              Object other$recipientName = other.getRecipientName();
                                                                                                                              if (this$recipientName == null
                                                                                                                                 ? other$recipientName == null
                                                                                                                                 : this$recipientName.equals(
                                                                                                                                    other$recipientName
                                                                                                                                 )) {
                                                                                                                                 Object this$workshopName = this.getWorkshopName();
                                                                                                                                 Object other$workshopName = other.getWorkshopName();
                                                                                                                                 if (this$workshopName == null
                                                                                                                                    ? other$workshopName
                                                                                                                                       == null
                                                                                                                                    : this$workshopName.equals(
                                                                                                                                       other$workshopName
                                                                                                                                    )) {
                                                                                                                                    Object this$measure = this.getMeasure();
                                                                                                                                    Object other$measure = other.getMeasure();
                                                                                                                                    if (this$measure == null
                                                                                                                                       ? other$measure == null
                                                                                                                                       : this$measure.equals(
                                                                                                                                          other$measure
                                                                                                                                       )) {
                                                                                                                                       Object this$directionProjectSerialNumber = this.getDirectionProjectSerialNumber();
                                                                                                                                       Object other$directionProjectSerialNumber = other.getDirectionProjectSerialNumber();
                                                                                                                                       if (this$directionProjectSerialNumber
                                                                                                                                             == null
                                                                                                                                          ? other$directionProjectSerialNumber
                                                                                                                                             == null
                                                                                                                                          : this$directionProjectSerialNumber.equals(
                                                                                                                                             other$directionProjectSerialNumber
                                                                                                                                          )) {
                                                                                                                                          Object this$directionProjectName = this.getDirectionProjectName();
                                                                                                                                          Object other$directionProjectName = other.getDirectionProjectName();
                                                                                                                                          if (this$directionProjectName
                                                                                                                                                == null
                                                                                                                                             ? other$directionProjectName
                                                                                                                                                == null
                                                                                                                                             : this$directionProjectName.equals(
                                                                                                                                                other$directionProjectName
                                                                                                                                             )) {
                                                                                                                                             Object this$directionMonomerName = this.getDirectionMonomerName();
                                                                                                                                             Object other$directionMonomerName = other.getDirectionMonomerName();
                                                                                                                                             if (this$directionMonomerName
                                                                                                                                                   == null
                                                                                                                                                ? other$directionMonomerName
                                                                                                                                                   == null
                                                                                                                                                : this$directionMonomerName.equals(
                                                                                                                                                   other$directionMonomerName
                                                                                                                                                )) {
                                                                                                                                                Object this$directionAreaName = this.getDirectionAreaName();
                                                                                                                                                Object other$directionAreaName = other.getDirectionAreaName();
                                                                                                                                                if (this$directionAreaName
                                                                                                                                                      == null
                                                                                                                                                   ? other$directionAreaName
                                                                                                                                                      == null
                                                                                                                                                   : this$directionAreaName.equals(
                                                                                                                                                      other$directionAreaName
                                                                                                                                                   )) {
                                                                                                                                                   Object this$directionWareHouseName = this.getDirectionWareHouseName();
                                                                                                                                                   Object other$directionWareHouseName = other.getDirectionWareHouseName();
                                                                                                                                                   if (this$directionWareHouseName
                                                                                                                                                         == null
                                                                                                                                                      ? other$directionWareHouseName
                                                                                                                                                         == null
                                                                                                                                                      : this$directionWareHouseName.equals(
                                                                                                                                                         other$directionWareHouseName
                                                                                                                                                      )) {
                                                                                                                                                      Object this$directionWmsWorkshopName = this.getDirectionWmsWorkshopName();
                                                                                                                                                      Object other$directionWmsWorkshopName = other.getDirectionWmsWorkshopName();
                                                                                                                                                      if (this$directionWmsWorkshopName
                                                                                                                                                            == null
                                                                                                                                                         ? other$directionWmsWorkshopName
                                                                                                                                                            == null
                                                                                                                                                         : this$directionWmsWorkshopName.equals(
                                                                                                                                                            other$directionWmsWorkshopName
                                                                                                                                                         )) {
                                                                                                                                                         Object this$rdRate = this.getRdRate();
                                                                                                                                                         Object other$rdRate = other.getRdRate();
                                                                                                                                                         if (this$rdRate
                                                                                                                                                               == null
                                                                                                                                                            ? other$rdRate
                                                                                                                                                               == null
                                                                                                                                                            : this$rdRate.equals(
                                                                                                                                                               other$rdRate
                                                                                                                                                            )) {
                                                                                                                                                            Object this$rejectSerialNumber = this.getRejectSerialNumber();
                                                                                                                                                            Object other$rejectSerialNumber = other.getRejectSerialNumber();
                                                                                                                                                            if (this$rejectSerialNumber
                                                                                                                                                                  == null
                                                                                                                                                               ? other$rejectSerialNumber
                                                                                                                                                                  == null
                                                                                                                                                               : this$rejectSerialNumber.equals(
                                                                                                                                                                  other$rejectSerialNumber
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$rejectReviewTime = this.getRejectReviewTime();
                                                                                                                                                               Object other$rejectReviewTime = other.getRejectReviewTime();
                                                                                                                                                               if (this$rejectReviewTime
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$rejectReviewTime
                                                                                                                                                                     == null
                                                                                                                                                                  : this$rejectReviewTime.equals(
                                                                                                                                                                     other$rejectReviewTime
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
                                                                                                                                                                     Object this$outboundSerialNumber = this.getOutboundSerialNumber();
                                                                                                                                                                     Object other$outboundSerialNumber = other.getOutboundSerialNumber();
                                                                                                                                                                     if (this$outboundSerialNumber
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$outboundSerialNumber
                                                                                                                                                                           == null
                                                                                                                                                                        : this$outboundSerialNumber.equals(
                                                                                                                                                                           other$outboundSerialNumber
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$returnTime = this.getReturnTime();
                                                                                                                                                                        Object other$returnTime = other.getReturnTime();
                                                                                                                                                                        if (this$returnTime
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$returnTime
                                                                                                                                                                              == null
                                                                                                                                                                           : this$returnTime.equals(
                                                                                                                                                                              other$returnTime
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
                                                                                                                                                                              Object this$inputVat = this.getInputVat();
                                                                                                                                                                              Object other$inputVat = other.getInputVat();
                                                                                                                                                                              if (this$inputVat
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$inputVat
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$inputVat.equals(
                                                                                                                                                                                    other$inputVat
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
                                                                                                                                                                                       Object this$wmsWorkshopName = this.getWmsWorkshopName();
                                                                                                                                                                                       Object other$wmsWorkshopName = other.getWmsWorkshopName();
                                                                                                                                                                                       if (this$wmsWorkshopName
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$wmsWorkshopName
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$wmsWorkshopName.equals(
                                                                                                                                                                                             other$wmsWorkshopName
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Object this$branchCompanyName = this.getBranchCompanyName();
                                                                                                                                                                                          Object other$branchCompanyName = other.getBranchCompanyName();
                                                                                                                                                                                          if (this$branchCompanyName
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$branchCompanyName
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$branchCompanyName.equals(
                                                                                                                                                                                                other$branchCompanyName
                                                                                                                                                                                             )
                                                                                                                                                                                             )
                                                                                                                                                                                           {
                                                                                                                                                                                             Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                                                                                                                                                                                             Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                                                                                                                                                                                             if (this$outboundTypeSelection
                                                                                                                                                                                                   == null
                                                                                                                                                                                                ? other$outboundTypeSelection
                                                                                                                                                                                                   == null
                                                                                                                                                                                                : this$outboundTypeSelection.equals(
                                                                                                                                                                                                   other$outboundTypeSelection
                                                                                                                                                                                                )
                                                                                                                                                                                                )
                                                                                                                                                                                              {
                                                                                                                                                                                                Object this$amountExcludingVATNoFreight = this.getAmountExcludingVATNoFreight();
                                                                                                                                                                                                Object other$amountExcludingVATNoFreight = other.getAmountExcludingVATNoFreight();
                                                                                                                                                                                                if (this$amountExcludingVATNoFreight
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   ? other$amountExcludingVATNoFreight
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   : this$amountExcludingVATNoFreight.equals(
                                                                                                                                                                                                      other$amountExcludingVATNoFreight
                                                                                                                                                                                                   )
                                                                                                                                                                                                   )
                                                                                                                                                                                                 {
                                                                                                                                                                                                   Object this$unitPriceExcludingVATNoFreight = this.getUnitPriceExcludingVATNoFreight();
                                                                                                                                                                                                   Object other$unitPriceExcludingVATNoFreight = other.getUnitPriceExcludingVATNoFreight();
                                                                                                                                                                                                   if (this$unitPriceExcludingVATNoFreight
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      ? other$unitPriceExcludingVATNoFreight
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      : this$unitPriceExcludingVATNoFreight.equals(
                                                                                                                                                                                                         other$unitPriceExcludingVATNoFreight
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
                                                                                                                                                                                                         Object this$amountNoFreight = this.getAmountNoFreight();
                                                                                                                                                                                                         Object other$amountNoFreight = other.getAmountNoFreight();
                                                                                                                                                                                                         if (this$amountNoFreight
                                                                                                                                                                                                               == null
                                                                                                                                                                                                            ? other$amountNoFreight
                                                                                                                                                                                                               == null
                                                                                                                                                                                                            : this$amountNoFreight.equals(
                                                                                                                                                                                                               other$amountNoFreight
                                                                                                                                                                                                            )
                                                                                                                                                                                                            )
                                                                                                                                                                                                          {
                                                                                                                                                                                                            Object this$outboundSn = this.getOutboundSn();
                                                                                                                                                                                                            Object other$outboundSn = other.getOutboundSn();
                                                                                                                                                                                                            if (this$outboundSn
                                                                                                                                                                                                                  == null
                                                                                                                                                                                                               ? other$outboundSn
                                                                                                                                                                                                                  == null
                                                                                                                                                                                                               : this$outboundSn.equals(
                                                                                                                                                                                                                  other$outboundSn
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
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof DownLoadDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $transferType = this.getTransferType();
      result = result * 59 + ($transferType == null ? 43 : $transferType.hashCode());
      Object $rejectStatus = this.getRejectStatus();
      result = result * 59 + ($rejectStatus == null ? 43 : $rejectStatus.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $materialReturnableId = this.getMaterialReturnableId();
      result = result * 59 + ($materialReturnableId == null ? 43 : $materialReturnableId.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $wapId = this.getWapId();
      result = result * 59 + ($wapId == null ? 43 : $wapId.hashCode());
      Object $inboundWay = this.getInboundWay();
      result = result * 59 + ($inboundWay == null ? 43 : $inboundWay.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
      result = result * 59 + ($unitPriceExcludingVAT == null ? 43 : $unitPriceExcludingVAT.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaseSN = this.getPurchaseSN();
      result = result * 59 + ($purchaseSN == null ? 43 : $purchaseSN.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectNumber = this.getProjectNumber();
      result = result * 59 + ($projectNumber == null ? 43 : $projectNumber.hashCode());
      Object $warehouseName = this.getWarehouseName();
      result = result * 59 + ($warehouseName == null ? 43 : $warehouseName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $areaBatchName = this.getAreaBatchName();
      result = result * 59 + ($areaBatchName == null ? 43 : $areaBatchName.hashCode());
      Object $recipientName = this.getRecipientName();
      result = result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $measure = this.getMeasure();
      result = result * 59 + ($measure == null ? 43 : $measure.hashCode());
      Object $directionProjectSerialNumber = this.getDirectionProjectSerialNumber();
      result = result * 59 + ($directionProjectSerialNumber == null ? 43 : $directionProjectSerialNumber.hashCode());
      Object $directionProjectName = this.getDirectionProjectName();
      result = result * 59 + ($directionProjectName == null ? 43 : $directionProjectName.hashCode());
      Object $directionMonomerName = this.getDirectionMonomerName();
      result = result * 59 + ($directionMonomerName == null ? 43 : $directionMonomerName.hashCode());
      Object $directionAreaName = this.getDirectionAreaName();
      result = result * 59 + ($directionAreaName == null ? 43 : $directionAreaName.hashCode());
      Object $directionWareHouseName = this.getDirectionWareHouseName();
      result = result * 59 + ($directionWareHouseName == null ? 43 : $directionWareHouseName.hashCode());
      Object $directionWmsWorkshopName = this.getDirectionWmsWorkshopName();
      result = result * 59 + ($directionWmsWorkshopName == null ? 43 : $directionWmsWorkshopName.hashCode());
      Object $rdRate = this.getRdRate();
      result = result * 59 + ($rdRate == null ? 43 : $rdRate.hashCode());
      Object $rejectSerialNumber = this.getRejectSerialNumber();
      result = result * 59 + ($rejectSerialNumber == null ? 43 : $rejectSerialNumber.hashCode());
      Object $rejectReviewTime = this.getRejectReviewTime();
      result = result * 59 + ($rejectReviewTime == null ? 43 : $rejectReviewTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $outboundSerialNumber = this.getOutboundSerialNumber();
      result = result * 59 + ($outboundSerialNumber == null ? 43 : $outboundSerialNumber.hashCode());
      Object $returnTime = this.getReturnTime();
      result = result * 59 + ($returnTime == null ? 43 : $returnTime.hashCode());
      Object $orderSerialNumber = this.getOrderSerialNumber();
      result = result * 59 + ($orderSerialNumber == null ? 43 : $orderSerialNumber.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $applicantTime = this.getApplicantTime();
      result = result * 59 + ($applicantTime == null ? 43 : $applicantTime.hashCode());
      Object $wmsWorkshopName = this.getWmsWorkshopName();
      result = result * 59 + ($wmsWorkshopName == null ? 43 : $wmsWorkshopName.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $amountExcludingVATNoFreight = this.getAmountExcludingVATNoFreight();
      result = result * 59 + ($amountExcludingVATNoFreight == null ? 43 : $amountExcludingVATNoFreight.hashCode());
      Object $unitPriceExcludingVATNoFreight = this.getUnitPriceExcludingVATNoFreight();
      result = result * 59 + ($unitPriceExcludingVATNoFreight == null ? 43 : $unitPriceExcludingVATNoFreight.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $outboundSn = this.getOutboundSn();
      result = result * 59 + ($outboundSn == null ? 43 : $outboundSn.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      result = result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
      Object $actualTheoryWeight = this.getActualTheoryWeight();
      return result * 59 + ($actualTheoryWeight == null ? 43 : $actualTheoryWeight.hashCode());
   }

   @Override
   public String toString() {
      return "DownLoadDetailDO(id="
         + this.getId()
         + ", materialSn="
         + this.getMaterialSn()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", basicClass="
         + this.getBasicClass()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", specification="
         + this.getSpecification()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", amount="
         + this.getAmount()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVAT="
         + this.getUnitPriceExcludingVAT()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaseSN="
         + this.getPurchaseSN()
         + ", supplierName="
         + this.getSupplierName()
         + ", projectName="
         + this.getProjectName()
         + ", projectId="
         + this.getProjectId()
         + ", projectNumber="
         + this.getProjectNumber()
         + ", warehouseName="
         + this.getWarehouseName()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", areaBatchName="
         + this.getAreaBatchName()
         + ", recipientName="
         + this.getRecipientName()
         + ", recipientId="
         + this.getRecipientId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", measure="
         + this.getMeasure()
         + ", directionProjectSerialNumber="
         + this.getDirectionProjectSerialNumber()
         + ", directionProjectName="
         + this.getDirectionProjectName()
         + ", directionMonomerName="
         + this.getDirectionMonomerName()
         + ", directionAreaName="
         + this.getDirectionAreaName()
         + ", directionWareHouseName="
         + this.getDirectionWareHouseName()
         + ", directionWmsWorkshopName="
         + this.getDirectionWmsWorkshopName()
         + ", transferType="
         + this.getTransferType()
         + ", rdRate="
         + this.getRdRate()
         + ", rejectStatus="
         + this.getRejectStatus()
         + ", rejectSerialNumber="
         + this.getRejectSerialNumber()
         + ", rejectReviewTime="
         + this.getRejectReviewTime()
         + ", inboundId="
         + this.getInboundId()
         + ", remark="
         + this.getRemark()
         + ", outboundSerialNumber="
         + this.getOutboundSerialNumber()
         + ", materialReturnableId="
         + this.getMaterialReturnableId()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", returnTime="
         + this.getReturnTime()
         + ", wapId="
         + this.getWapId()
         + ", orderSerialNumber="
         + this.getOrderSerialNumber()
         + ", inputVat="
         + this.getInputVat()
         + ", applicantName="
         + this.getApplicantName()
         + ", applicantTime="
         + this.getApplicantTime()
         + ", wmsWorkshopName="
         + this.getWmsWorkshopName()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", amountExcludingVATNoFreight="
         + this.getAmountExcludingVATNoFreight()
         + ", unitPriceExcludingVATNoFreight="
         + this.getUnitPriceExcludingVATNoFreight()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", inboundWay="
         + this.getInboundWay()
         + ", outboundSn="
         + this.getOutboundSn()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ", actualTheoryWeight="
         + this.getActualTheoryWeight()
         + ")";
   }

   public DownLoadDetailDO(
      final Long id,
      final String materialSn,
      final Long classifyId,
      final String classifyName,
      final Integer basicClass,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final String specification,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final BigDecimal mete,
      final BigDecimal quantity,
      final BigDecimal amountExcludingVat,
      final BigDecimal amount,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVAT,
      final LocalDateTime outboundTime,
      final LocalDateTime reviewTime,
      final String serialNumber,
      final String purchaseSN,
      final String supplierName,
      final String projectName,
      final String projectId,
      final String projectNumber,
      final String warehouseName,
      final String monomerName,
      final String areaName,
      final String areaBatchName,
      final String recipientName,
      final Long recipientId,
      final String workshopName,
      final Measure measure,
      final String directionProjectSerialNumber,
      final String directionProjectName,
      final String directionMonomerName,
      final String directionAreaName,
      final String directionWareHouseName,
      final String directionWmsWorkshopName,
      final Integer transferType,
      final BigDecimal rdRate,
      final Integer rejectStatus,
      final String rejectSerialNumber,
      final LocalDateTime rejectReviewTime,
      final Long inboundId,
      final String remark,
      final String outboundSerialNumber,
      final Long materialReturnableId,
      final Long materialInventoryId,
      final LocalDateTime returnTime,
      final Long wapId,
      final String orderSerialNumber,
      final BigDecimal inputVat,
      final String applicantName,
      final LocalDateTime applicantTime,
      final String wmsWorkshopName,
      final String branchCompanyName,
      final LocalDateTime outboundTypeSelection,
      final BigDecimal amountExcludingVATNoFreight,
      final BigDecimal unitPriceExcludingVATNoFreight,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal amountNoFreight,
      final Integer inboundWay,
      final String outboundSn,
      final String materialSnNew,
      final BigDecimal actualTheoryWeight
   ) {
      this.id = id;
      this.materialSn = materialSn;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.basicClass = basicClass;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.specification = specification;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.mete = mete;
      this.quantity = quantity;
      this.amountExcludingVat = amountExcludingVat;
      this.amount = amount;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
      this.outboundTime = outboundTime;
      this.reviewTime = reviewTime;
      this.serialNumber = serialNumber;
      this.purchaseSN = purchaseSN;
      this.supplierName = supplierName;
      this.projectName = projectName;
      this.projectId = projectId;
      this.projectNumber = projectNumber;
      this.warehouseName = warehouseName;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.areaBatchName = areaBatchName;
      this.recipientName = recipientName;
      this.recipientId = recipientId;
      this.workshopName = workshopName;
      this.measure = measure;
      this.directionProjectSerialNumber = directionProjectSerialNumber;
      this.directionProjectName = directionProjectName;
      this.directionMonomerName = directionMonomerName;
      this.directionAreaName = directionAreaName;
      this.directionWareHouseName = directionWareHouseName;
      this.directionWmsWorkshopName = directionWmsWorkshopName;
      this.transferType = transferType;
      this.rdRate = rdRate;
      this.rejectStatus = rejectStatus;
      this.rejectSerialNumber = rejectSerialNumber;
      this.rejectReviewTime = rejectReviewTime;
      this.inboundId = inboundId;
      this.remark = remark;
      this.outboundSerialNumber = outboundSerialNumber;
      this.materialReturnableId = materialReturnableId;
      this.materialInventoryId = materialInventoryId;
      this.returnTime = returnTime;
      this.wapId = wapId;
      this.orderSerialNumber = orderSerialNumber;
      this.inputVat = inputVat;
      this.applicantName = applicantName;
      this.applicantTime = applicantTime;
      this.wmsWorkshopName = wmsWorkshopName;
      this.branchCompanyName = branchCompanyName;
      this.outboundTypeSelection = outboundTypeSelection;
      this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
      this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.inboundWay = inboundWay;
      this.outboundSn = outboundSn;
      this.materialSnNew = materialSnNew;
      this.actualTheoryWeight = actualTheoryWeight;
   }

   public DownLoadDetailDO() {
   }

   public static class DownLoadDetailDOBuilder {
      private Long id;
      private String materialSn;
      private Long classifyId;
      private String classifyName;
      private Integer basicClass;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private String specification;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private BigDecimal mete;
      private BigDecimal quantity;
      private BigDecimal amountExcludingVat;
      private BigDecimal amount;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVAT;
      private LocalDateTime outboundTime;
      private LocalDateTime reviewTime;
      private String serialNumber;
      private String purchaseSN;
      private String supplierName;
      private String projectName;
      private String projectId;
      private String projectNumber;
      private String warehouseName;
      private String monomerName;
      private String areaName;
      private String areaBatchName;
      private String recipientName;
      private Long recipientId;
      private String workshopName;
      private Measure measure;
      private String directionProjectSerialNumber;
      private String directionProjectName;
      private String directionMonomerName;
      private String directionAreaName;
      private String directionWareHouseName;
      private String directionWmsWorkshopName;
      private Integer transferType;
      private BigDecimal rdRate;
      private Integer rejectStatus;
      private String rejectSerialNumber;
      private LocalDateTime rejectReviewTime;
      private Long inboundId;
      private String remark;
      private String outboundSerialNumber;
      private Long materialReturnableId;
      private Long materialInventoryId;
      private LocalDateTime returnTime;
      private Long wapId;
      private String orderSerialNumber;
      private BigDecimal inputVat;
      private String applicantName;
      private LocalDateTime applicantTime;
      private String wmsWorkshopName;
      private String branchCompanyName;
      private LocalDateTime outboundTypeSelection;
      private BigDecimal amountExcludingVATNoFreight;
      private BigDecimal unitPriceExcludingVATNoFreight;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal amountNoFreight;
      private Integer inboundWay;
      private String outboundSn;
      private String materialSnNew;
      private BigDecimal actualTheoryWeight;

      DownLoadDetailDOBuilder() {
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder purchaseSN(final String purchaseSN) {
         this.purchaseSN = purchaseSN;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder projectId(final String projectId) {
         this.projectId = projectId;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder projectNumber(final String projectNumber) {
         this.projectNumber = projectNumber;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder warehouseName(final String warehouseName) {
         this.warehouseName = warehouseName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder areaBatchName(final String areaBatchName) {
         this.areaBatchName = areaBatchName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder measure(final Measure measure) {
         this.measure = measure;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder directionProjectSerialNumber(final String directionProjectSerialNumber) {
         this.directionProjectSerialNumber = directionProjectSerialNumber;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder directionProjectName(final String directionProjectName) {
         this.directionProjectName = directionProjectName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder directionMonomerName(final String directionMonomerName) {
         this.directionMonomerName = directionMonomerName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder directionAreaName(final String directionAreaName) {
         this.directionAreaName = directionAreaName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder directionWareHouseName(final String directionWareHouseName) {
         this.directionWareHouseName = directionWareHouseName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder directionWmsWorkshopName(final String directionWmsWorkshopName) {
         this.directionWmsWorkshopName = directionWmsWorkshopName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder transferType(final Integer transferType) {
         this.transferType = transferType;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder rdRate(final BigDecimal rdRate) {
         this.rdRate = rdRate;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder rejectStatus(final Integer rejectStatus) {
         this.rejectStatus = rejectStatus;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder rejectSerialNumber(final String rejectSerialNumber) {
         this.rejectSerialNumber = rejectSerialNumber;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder rejectReviewTime(final LocalDateTime rejectReviewTime) {
         this.rejectReviewTime = rejectReviewTime;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder outboundSerialNumber(final String outboundSerialNumber) {
         this.outboundSerialNumber = outboundSerialNumber;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder materialReturnableId(final Long materialReturnableId) {
         this.materialReturnableId = materialReturnableId;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder returnTime(final LocalDateTime returnTime) {
         this.returnTime = returnTime;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder wapId(final Long wapId) {
         this.wapId = wapId;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder orderSerialNumber(final String orderSerialNumber) {
         this.orderSerialNumber = orderSerialNumber;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder applicantTime(final LocalDateTime applicantTime) {
         this.applicantTime = applicantTime;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder wmsWorkshopName(final String wmsWorkshopName) {
         this.wmsWorkshopName = wmsWorkshopName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder outboundTypeSelection(final LocalDateTime outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder amountExcludingVATNoFreight(final BigDecimal amountExcludingVATNoFreight) {
         this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder unitPriceExcludingVATNoFreight(final BigDecimal unitPriceExcludingVATNoFreight) {
         this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder inboundWay(final Integer inboundWay) {
         this.inboundWay = inboundWay;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder outboundSn(final String outboundSn) {
         this.outboundSn = outboundSn;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public DownLoadDetailDO.DownLoadDetailDOBuilder actualTheoryWeight(final BigDecimal actualTheoryWeight) {
         this.actualTheoryWeight = actualTheoryWeight;
         return this;
      }

      public DownLoadDetailDO build() {
         return new DownLoadDetailDO(
            this.id,
            this.materialSn,
            this.classifyId,
            this.classifyName,
            this.basicClass,
            this.length,
            this.width,
            this.thickness,
            this.invoiceType,
            this.taxRate,
            this.specification,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.mete,
            this.quantity,
            this.amountExcludingVat,
            this.amount,
            this.unitPrice,
            this.unitPriceExcludingVAT,
            this.outboundTime,
            this.reviewTime,
            this.serialNumber,
            this.purchaseSN,
            this.supplierName,
            this.projectName,
            this.projectId,
            this.projectNumber,
            this.warehouseName,
            this.monomerName,
            this.areaName,
            this.areaBatchName,
            this.recipientName,
            this.recipientId,
            this.workshopName,
            this.measure,
            this.directionProjectSerialNumber,
            this.directionProjectName,
            this.directionMonomerName,
            this.directionAreaName,
            this.directionWareHouseName,
            this.directionWmsWorkshopName,
            this.transferType,
            this.rdRate,
            this.rejectStatus,
            this.rejectSerialNumber,
            this.rejectReviewTime,
            this.inboundId,
            this.remark,
            this.outboundSerialNumber,
            this.materialReturnableId,
            this.materialInventoryId,
            this.returnTime,
            this.wapId,
            this.orderSerialNumber,
            this.inputVat,
            this.applicantName,
            this.applicantTime,
            this.wmsWorkshopName,
            this.branchCompanyName,
            this.outboundTypeSelection,
            this.amountExcludingVATNoFreight,
            this.unitPriceExcludingVATNoFreight,
            this.unitPriceNoFreight,
            this.amountNoFreight,
            this.inboundWay,
            this.outboundSn,
            this.materialSnNew,
            this.actualTheoryWeight
         );
      }

      @Override
      public String toString() {
         return "DownLoadDetailDO.DownLoadDetailDOBuilder(id="
            + this.id
            + ", materialSn="
            + this.materialSn
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", basicClass="
            + this.basicClass
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", specification="
            + this.specification
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", mete="
            + this.mete
            + ", quantity="
            + this.quantity
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", amount="
            + this.amount
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVAT="
            + this.unitPriceExcludingVAT
            + ", outboundTime="
            + this.outboundTime
            + ", reviewTime="
            + this.reviewTime
            + ", serialNumber="
            + this.serialNumber
            + ", purchaseSN="
            + this.purchaseSN
            + ", supplierName="
            + this.supplierName
            + ", projectName="
            + this.projectName
            + ", projectId="
            + this.projectId
            + ", projectNumber="
            + this.projectNumber
            + ", warehouseName="
            + this.warehouseName
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", areaBatchName="
            + this.areaBatchName
            + ", recipientName="
            + this.recipientName
            + ", recipientId="
            + this.recipientId
            + ", workshopName="
            + this.workshopName
            + ", measure="
            + this.measure
            + ", directionProjectSerialNumber="
            + this.directionProjectSerialNumber
            + ", directionProjectName="
            + this.directionProjectName
            + ", directionMonomerName="
            + this.directionMonomerName
            + ", directionAreaName="
            + this.directionAreaName
            + ", directionWareHouseName="
            + this.directionWareHouseName
            + ", directionWmsWorkshopName="
            + this.directionWmsWorkshopName
            + ", transferType="
            + this.transferType
            + ", rdRate="
            + this.rdRate
            + ", rejectStatus="
            + this.rejectStatus
            + ", rejectSerialNumber="
            + this.rejectSerialNumber
            + ", rejectReviewTime="
            + this.rejectReviewTime
            + ", inboundId="
            + this.inboundId
            + ", remark="
            + this.remark
            + ", outboundSerialNumber="
            + this.outboundSerialNumber
            + ", materialReturnableId="
            + this.materialReturnableId
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", returnTime="
            + this.returnTime
            + ", wapId="
            + this.wapId
            + ", orderSerialNumber="
            + this.orderSerialNumber
            + ", inputVat="
            + this.inputVat
            + ", applicantName="
            + this.applicantName
            + ", applicantTime="
            + this.applicantTime
            + ", wmsWorkshopName="
            + this.wmsWorkshopName
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", amountExcludingVATNoFreight="
            + this.amountExcludingVATNoFreight
            + ", unitPriceExcludingVATNoFreight="
            + this.unitPriceExcludingVATNoFreight
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", inboundWay="
            + this.inboundWay
            + ", outboundSn="
            + this.outboundSn
            + ", materialSnNew="
            + this.materialSnNew
            + ", actualTheoryWeight="
            + this.actualTheoryWeight
            + ")";
      }
   }
}
