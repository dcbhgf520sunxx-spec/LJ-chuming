package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("入库记录")
public class InboundRecordDTO {
   @ApiModelProperty(name = "id", value = "入库详情表ID")
   private Long id;
   @ApiModelProperty(name = "inboundId", value = "入库单ID")
   private Long inboundId;
   @ApiModelProperty(name = "inboundSerialNumber", value = "入库单号")
   private String inboundSerialNumber;
   @ApiModelProperty(name = "requisitionsSn", value = "申购单编号")
   private String requisitionsSn;
   @ApiModelProperty(name = "purchaseId", value = "采购订单ID")
   private Long purchaseId;
   @ApiModelProperty(name = "purchaseSn", value = "采购订单编号")
   private String purchaseSn;
   @ApiModelProperty(name = "taxRate", value = "税率(百分比)")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1专票 2普票 4收据")
   private Integer invoiceType;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型")
   private Integer basicClass;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供物料")
   private Boolean boolPartyA;
   @ApiModelProperty(name = "classifyId", value = "科目ID")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称")
   private String classifyName;
   @ApiModelProperty(name = "length", value = "长")
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽")
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚")
   private BigDecimal thickness;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度(厚度四舍五入)")
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "theoryWeight", value = "理论重量")
   private BigDecimal theoryWeight;
   @ApiModelProperty(name = "quantity", value = "数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号")
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "specificationIds", value = "规格配置ID集")
   private String specificationIds;
   @ApiModelProperty(name = "sectionSteelSpecIds", value = "型材库规格ID集")
   private String sectionSteelSpecIds;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "color", value = "颜色")
   private String color;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "unitNet", value = "单位净量")
   private BigDecimal unitNet;
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度")
   private Integer accountingPrecision;
   @ApiModelProperty(name = "measurePrecision", value = "计量精度")
   private Integer measurePrecision;
   @ApiModelProperty(name = "mete", value = "核算量(在计量单位未设置时,数量=核算量)")
   private BigDecimal mete;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式 [参考枚举 MeasureEnum]")
   private Integer weightMeasurementMode;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID")
   private Long warehouseId;
   @ApiModelProperty(name = "projectId", value = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "factoryId", value = "工厂ID")
   private Long factoryId;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税单价")
   @JsonProperty("unitPriceExcludingVAT")
   @JSONField(name = "unitPriceExcludingVAT")
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "unitPriceExcludingVATNoFreight", value = "不含税单价不含运费")
   @JsonProperty("unitPriceExcludingVATNoFreight")
   @JSONField(name = "unitPriceExcludingVATNoFreight")
   private BigDecimal unitPriceExcludingVATNoFreight;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价")
   @JsonProperty("amountExcludingVAT")
   @JSONField(name = "amountExcludingVAT")
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "amountExcludingVATNoFreight", value = "不含税总价不含运费")
   @JsonProperty("amountExcludingVATNoFreight")
   @JSONField(name = "amountExcludingVATNoFreight")
   private BigDecimal amountExcludingVATNoFreight;
   @ApiModelProperty(name = "inputVat", value = "进项税")
   @JsonProperty("inputVAT")
   @JSONField(name = "inputVAT")
   private BigDecimal inputVat;
   @ApiModelProperty(name = "inputVATNoFreight", value = "进项税不含运费")
   @JsonProperty("inputVATNoFreight")
   @JSONField(name = "inputVATNoFreight")
   private BigDecimal inputVATNoFreight;
   @ApiModelProperty(name = "amount", value = "入库总价")
   private BigDecimal amount;
   @ApiModelProperty(name = "amountNoFreight", value = "入库总价不含运费")
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "unitPrice", value = "含税单价")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "含税单价不含运费")
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "printStatus", value = "打印状态 [0 没有打印,1 已打印]")
   private Boolean printStatus;
   @ApiModelProperty(name = "gasReturnStatus", value = "是否有退货 [0 没有退货,1 有退货]")
   private Boolean gasReturnStatus;
   @ApiModelProperty(name = "inboundTime", value = "入库时间")
   private LocalDateTime inboundTime;
   @ApiModelProperty(name = "rejectStatus", value = "退库状态 [RejectEnum]")
   private Integer rejectStatus;
   @ApiModelProperty(name = "rejectQuantity", value = "已退货计量量")
   private BigDecimal rejectQuantity;
   @ApiModelProperty(name = "rejectMete", value = "已退货核算量")
   private BigDecimal rejectMete;
   @ApiModelProperty(name = "standardId", value = "型材执行国标ID")
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "型材执行国标名称")
   private String standardName;
   @ApiModelProperty(name = "applicantId", value = "申请人ID")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称")
   private String applicantName;
   @ApiModelProperty(name = "reviewerId", value = "审核人ID")
   private Long reviewerId;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称")
   private String reviewerName;

   public static InboundRecordDTO.InboundRecordDTOBuilder builder() {
      return new InboundRecordDTO.InboundRecordDTOBuilder();
   }

   public InboundRecordDTO() {
   }

   public InboundRecordDTO(
      final Long id,
      final Long inboundId,
      final String inboundSerialNumber,
      final String requisitionsSn,
      final Long purchaseId,
      final String purchaseSn,
      final BigDecimal taxRate,
      final Integer invoiceType,
      final Integer basicClass,
      final Boolean boolPartyA,
      final Long classifyId,
      final String classifyName,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final BigDecimal theoryWeight,
      final BigDecimal quantity,
      final String brand,
      final String heatNoAndBatchNo,
      final String specificationIds,
      final String sectionSteelSpecIds,
      final String specification,
      final String color,
      final String measureUnit,
      final String accountingUnit,
      final BigDecimal unitNet,
      final Integer accountingPrecision,
      final Integer measurePrecision,
      final BigDecimal mete,
      final Integer weightMeasurementMode,
      final Long warehouseId,
      final Long projectId,
      final Long factoryId,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal unitPriceExcludingVATNoFreight,
      final BigDecimal amountExcludingVat,
      final BigDecimal amountExcludingVATNoFreight,
      final BigDecimal inputVat,
      final BigDecimal inputVATNoFreight,
      final BigDecimal amount,
      final BigDecimal amountNoFreight,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceNoFreight,
      final String remark,
      final Boolean printStatus,
      final Boolean gasReturnStatus,
      final LocalDateTime inboundTime,
      final Integer rejectStatus,
      final BigDecimal rejectQuantity,
      final BigDecimal rejectMete,
      final Long standardId,
      final String standardName,
      final Long applicantId,
      final String applicantName,
      final Long reviewerId,
      final String reviewerName
   ) {
      this.id = id;
      this.inboundId = inboundId;
      this.inboundSerialNumber = inboundSerialNumber;
      this.requisitionsSn = requisitionsSn;
      this.purchaseId = purchaseId;
      this.purchaseSn = purchaseSn;
      this.taxRate = taxRate;
      this.invoiceType = invoiceType;
      this.basicClass = basicClass;
      this.boolPartyA = boolPartyA;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.theoryWeight = theoryWeight;
      this.quantity = quantity;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.specificationIds = specificationIds;
      this.sectionSteelSpecIds = sectionSteelSpecIds;
      this.specification = specification;
      this.color = color;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.unitNet = unitNet;
      this.accountingPrecision = accountingPrecision;
      this.measurePrecision = measurePrecision;
      this.mete = mete;
      this.weightMeasurementMode = weightMeasurementMode;
      this.warehouseId = warehouseId;
      this.projectId = projectId;
      this.factoryId = factoryId;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
      this.amountExcludingVat = amountExcludingVat;
      this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
      this.inputVat = inputVat;
      this.inputVATNoFreight = inputVATNoFreight;
      this.amount = amount;
      this.amountNoFreight = amountNoFreight;
      this.unitPrice = unitPrice;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.remark = remark;
      this.printStatus = printStatus;
      this.gasReturnStatus = gasReturnStatus;
      this.inboundTime = inboundTime;
      this.rejectStatus = rejectStatus;
      this.rejectQuantity = rejectQuantity;
      this.rejectMete = rejectMete;
      this.standardId = standardId;
      this.standardName = standardName;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public String getInboundSerialNumber() {
      return this.inboundSerialNumber;
   }

   public String getRequisitionsSn() {
      return this.requisitionsSn;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public String getPurchaseSn() {
      return this.purchaseSn;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
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

   public String getSpecificationIds() {
      return this.specificationIds;
   }

   public String getSectionSteelSpecIds() {
      return this.sectionSteelSpecIds;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getColor() {
      return this.color;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public BigDecimal getUnitPriceExcludingVATNoFreight() {
      return this.unitPriceExcludingVATNoFreight;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getAmountExcludingVATNoFreight() {
      return this.amountExcludingVATNoFreight;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public BigDecimal getInputVATNoFreight() {
      return this.inputVATNoFreight;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getPrintStatus() {
      return this.printStatus;
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

   public BigDecimal getRejectQuantity() {
      return this.rejectQuantity;
   }

   public BigDecimal getRejectMete() {
      return this.rejectMete;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
   }

   public void setInboundSerialNumber(final String inboundSerialNumber) {
      this.inboundSerialNumber = inboundSerialNumber;
   }

   public void setRequisitionsSn(final String requisitionsSn) {
      this.requisitionsSn = requisitionsSn;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setPurchaseSn(final String purchaseSn) {
      this.purchaseSn = purchaseSn;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
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

   public void setSpecificationIds(final String specificationIds) {
      this.specificationIds = specificationIds;
   }

   public void setSectionSteelSpecIds(final String sectionSteelSpecIds) {
      this.sectionSteelSpecIds = sectionSteelSpecIds;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   @JsonProperty("unitPriceExcludingVAT")
   public void setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
   }

   @JsonProperty("unitPriceExcludingVATNoFreight")
   public void setUnitPriceExcludingVATNoFreight(final BigDecimal unitPriceExcludingVATNoFreight) {
      this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
   }

   @JsonProperty("amountExcludingVAT")
   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   @JsonProperty("amountExcludingVATNoFreight")
   public void setAmountExcludingVATNoFreight(final BigDecimal amountExcludingVATNoFreight) {
      this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
   }

   @JsonProperty("inputVAT")
   public void setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
   }

   @JsonProperty("inputVATNoFreight")
   public void setInputVATNoFreight(final BigDecimal inputVATNoFreight) {
      this.inputVATNoFreight = inputVATNoFreight;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setPrintStatus(final Boolean printStatus) {
      this.printStatus = printStatus;
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

   public void setRejectQuantity(final BigDecimal rejectQuantity) {
      this.rejectQuantity = rejectQuantity;
   }

   public void setRejectMete(final BigDecimal rejectMete) {
      this.rejectMete = rejectMete;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   public void setStandardName(final String standardName) {
      this.standardName = standardName;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundRecordDTO)) {
         return false;
      }

      InboundRecordDTO other = (InboundRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inboundId = this.getInboundId();
         Object other$inboundId = other.getInboundId();
         if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
            Object this$purchaseId = this.getPurchaseId();
            Object other$purchaseId = other.getPurchaseId();
            if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
               Object this$invoiceType = this.getInvoiceType();
               Object other$invoiceType = other.getInvoiceType();
               if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$boolPartyA = this.getBoolPartyA();
                     Object other$boolPartyA = other.getBoolPartyA();
                     if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                        Object this$classifyId = this.getClassifyId();
                        Object other$classifyId = other.getClassifyId();
                        if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                           Object this$accountingPrecision = this.getAccountingPrecision();
                           Object other$accountingPrecision = other.getAccountingPrecision();
                           if (this$accountingPrecision == null
                              ? other$accountingPrecision == null
                              : this$accountingPrecision.equals(other$accountingPrecision)) {
                              Object this$measurePrecision = this.getMeasurePrecision();
                              Object other$measurePrecision = other.getMeasurePrecision();
                              if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                                 Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                 Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                 if (this$weightMeasurementMode == null
                                    ? other$weightMeasurementMode == null
                                    : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                    Object this$warehouseId = this.getWarehouseId();
                                    Object other$warehouseId = other.getWarehouseId();
                                    if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                       Object this$projectId = this.getProjectId();
                                       Object other$projectId = other.getProjectId();
                                       if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                          Object this$factoryId = this.getFactoryId();
                                          Object other$factoryId = other.getFactoryId();
                                          if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                             Object this$printStatus = this.getPrintStatus();
                                             Object other$printStatus = other.getPrintStatus();
                                             if (this$printStatus == null ? other$printStatus == null : this$printStatus.equals(other$printStatus)) {
                                                Object this$gasReturnStatus = this.getGasReturnStatus();
                                                Object other$gasReturnStatus = other.getGasReturnStatus();
                                                if (this$gasReturnStatus == null
                                                   ? other$gasReturnStatus == null
                                                   : this$gasReturnStatus.equals(other$gasReturnStatus)) {
                                                   Object this$rejectStatus = this.getRejectStatus();
                                                   Object other$rejectStatus = other.getRejectStatus();
                                                   if (this$rejectStatus == null ? other$rejectStatus == null : this$rejectStatus.equals(other$rejectStatus)) {
                                                      Object this$standardId = this.getStandardId();
                                                      Object other$standardId = other.getStandardId();
                                                      if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                                         Object this$applicantId = this.getApplicantId();
                                                         Object other$applicantId = other.getApplicantId();
                                                         if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                                                            Object this$reviewerId = this.getReviewerId();
                                                            Object other$reviewerId = other.getReviewerId();
                                                            if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                                                               Object this$inboundSerialNumber = this.getInboundSerialNumber();
                                                               Object other$inboundSerialNumber = other.getInboundSerialNumber();
                                                               if (this$inboundSerialNumber == null
                                                                  ? other$inboundSerialNumber == null
                                                                  : this$inboundSerialNumber.equals(other$inboundSerialNumber)) {
                                                                  Object this$requisitionsSn = this.getRequisitionsSn();
                                                                  Object other$requisitionsSn = other.getRequisitionsSn();
                                                                  if (this$requisitionsSn == null
                                                                     ? other$requisitionsSn == null
                                                                     : this$requisitionsSn.equals(other$requisitionsSn)) {
                                                                     Object this$purchaseSn = this.getPurchaseSn();
                                                                     Object other$purchaseSn = other.getPurchaseSn();
                                                                     if (this$purchaseSn == null
                                                                        ? other$purchaseSn == null
                                                                        : this$purchaseSn.equals(other$purchaseSn)) {
                                                                        Object this$taxRate = this.getTaxRate();
                                                                        Object other$taxRate = other.getTaxRate();
                                                                        if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                                           Object this$classifyName = this.getClassifyName();
                                                                           Object other$classifyName = other.getClassifyName();
                                                                           if (this$classifyName == null
                                                                              ? other$classifyName == null
                                                                              : this$classifyName.equals(other$classifyName)) {
                                                                              Object this$length = this.getLength();
                                                                              Object other$length = other.getLength();
                                                                              if (this$length == null ? other$length == null : this$length.equals(other$length)
                                                                                 )
                                                                               {
                                                                                 Object this$width = this.getWidth();
                                                                                 Object other$width = other.getWidth();
                                                                                 if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                                    Object this$thickness = this.getThickness();
                                                                                    Object other$thickness = other.getThickness();
                                                                                    if (this$thickness == null
                                                                                       ? other$thickness == null
                                                                                       : this$thickness.equals(other$thickness)) {
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
                                                                                             if (this$quantity == null
                                                                                                ? other$quantity == null
                                                                                                : this$quantity.equals(other$quantity)) {
                                                                                                Object this$brand = this.getBrand();
                                                                                                Object other$brand = other.getBrand();
                                                                                                if (this$brand == null
                                                                                                   ? other$brand == null
                                                                                                   : this$brand.equals(other$brand)) {
                                                                                                   Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                                   Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                                   if (this$heatNoAndBatchNo == null
                                                                                                      ? other$heatNoAndBatchNo == null
                                                                                                      : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                                                      Object this$specificationIds = this.getSpecificationIds();
                                                                                                      Object other$specificationIds = other.getSpecificationIds();
                                                                                                      if (this$specificationIds == null
                                                                                                         ? other$specificationIds == null
                                                                                                         : this$specificationIds.equals(other$specificationIds)
                                                                                                         )
                                                                                                       {
                                                                                                         Object this$sectionSteelSpecIds = this.getSectionSteelSpecIds();
                                                                                                         Object other$sectionSteelSpecIds = other.getSectionSteelSpecIds();
                                                                                                         if (this$sectionSteelSpecIds == null
                                                                                                            ? other$sectionSteelSpecIds == null
                                                                                                            : this$sectionSteelSpecIds.equals(
                                                                                                               other$sectionSteelSpecIds
                                                                                                            )) {
                                                                                                            Object this$specification = this.getSpecification();
                                                                                                            Object other$specification = other.getSpecification();
                                                                                                            if (this$specification == null
                                                                                                               ? other$specification == null
                                                                                                               : this$specification.equals(other$specification)
                                                                                                               )
                                                                                                             {
                                                                                                               Object this$color = this.getColor();
                                                                                                               Object other$color = other.getColor();
                                                                                                               if (this$color == null
                                                                                                                  ? other$color == null
                                                                                                                  : this$color.equals(other$color)) {
                                                                                                                  Object this$measureUnit = this.getMeasureUnit();
                                                                                                                  Object other$measureUnit = other.getMeasureUnit();
                                                                                                                  if (this$measureUnit == null
                                                                                                                     ? other$measureUnit == null
                                                                                                                     : this$measureUnit.equals(
                                                                                                                        other$measureUnit
                                                                                                                     )) {
                                                                                                                     Object this$accountingUnit = this.getAccountingUnit();
                                                                                                                     Object other$accountingUnit = other.getAccountingUnit();
                                                                                                                     if (this$accountingUnit == null
                                                                                                                        ? other$accountingUnit == null
                                                                                                                        : this$accountingUnit.equals(
                                                                                                                           other$accountingUnit
                                                                                                                        )) {
                                                                                                                        Object this$unitNet = this.getUnitNet();
                                                                                                                        Object other$unitNet = other.getUnitNet();
                                                                                                                        if (this$unitNet == null
                                                                                                                           ? other$unitNet == null
                                                                                                                           : this$unitNet.equals(other$unitNet)
                                                                                                                           )
                                                                                                                         {
                                                                                                                           Object this$mete = this.getMete();
                                                                                                                           Object other$mete = other.getMete();
                                                                                                                           if (this$mete == null
                                                                                                                              ? other$mete == null
                                                                                                                              : this$mete.equals(other$mete)) {
                                                                                                                              Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                                                                              Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                                                                              if (this$unitPriceExcludingVat
                                                                                                                                    == null
                                                                                                                                 ? other$unitPriceExcludingVat
                                                                                                                                    == null
                                                                                                                                 : this$unitPriceExcludingVat.equals(
                                                                                                                                    other$unitPriceExcludingVat
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
                                                                                                                                    Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                                                    Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                                                    if (this$amountExcludingVat
                                                                                                                                          == null
                                                                                                                                       ? other$amountExcludingVat
                                                                                                                                          == null
                                                                                                                                       : this$amountExcludingVat.equals(
                                                                                                                                          other$amountExcludingVat
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
                                                                                                                                          Object this$inputVat = this.getInputVat();
                                                                                                                                          Object other$inputVat = other.getInputVat();
                                                                                                                                          if (this$inputVat
                                                                                                                                                == null
                                                                                                                                             ? other$inputVat
                                                                                                                                                == null
                                                                                                                                             : this$inputVat.equals(
                                                                                                                                                other$inputVat
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
                                                                                                                                                Object this$amount = this.getAmount();
                                                                                                                                                Object other$amount = other.getAmount();
                                                                                                                                                if (this$amount
                                                                                                                                                      == null
                                                                                                                                                   ? other$amount
                                                                                                                                                      == null
                                                                                                                                                   : this$amount.equals(
                                                                                                                                                      other$amount
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
                                                                                                                                                      Object this$unitPrice = this.getUnitPrice();
                                                                                                                                                      Object other$unitPrice = other.getUnitPrice();
                                                                                                                                                      if (this$unitPrice
                                                                                                                                                            == null
                                                                                                                                                         ? other$unitPrice
                                                                                                                                                            == null
                                                                                                                                                         : this$unitPrice.equals(
                                                                                                                                                            other$unitPrice
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
                                                                                                                                                               Object this$inboundTime = this.getInboundTime();
                                                                                                                                                               Object other$inboundTime = other.getInboundTime();
                                                                                                                                                               if (this$inboundTime
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$inboundTime
                                                                                                                                                                     == null
                                                                                                                                                                  : this$inboundTime.equals(
                                                                                                                                                                     other$inboundTime
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$rejectQuantity = this.getRejectQuantity();
                                                                                                                                                                  Object other$rejectQuantity = other.getRejectQuantity();
                                                                                                                                                                  if (this$rejectQuantity
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$rejectQuantity
                                                                                                                                                                        == null
                                                                                                                                                                     : this$rejectQuantity.equals(
                                                                                                                                                                        other$rejectQuantity
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$rejectMete = this.getRejectMete();
                                                                                                                                                                     Object other$rejectMete = other.getRejectMete();
                                                                                                                                                                     if (this$rejectMete
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$rejectMete
                                                                                                                                                                           == null
                                                                                                                                                                        : this$rejectMete.equals(
                                                                                                                                                                           other$rejectMete
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$standardName = this.getStandardName();
                                                                                                                                                                        Object other$standardName = other.getStandardName();
                                                                                                                                                                        if (this$standardName
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$standardName
                                                                                                                                                                              == null
                                                                                                                                                                           : this$standardName.equals(
                                                                                                                                                                              other$standardName
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
                                                                                                                                                                              Object this$reviewerName = this.getReviewerName();
                                                                                                                                                                              Object other$reviewerName = other.getReviewerName();
                                                                                                                                                                              return this$reviewerName
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$reviewerName
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$reviewerName.equals(
                                                                                                                                                                                    other$reviewerName
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InboundRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $printStatus = this.getPrintStatus();
      result = result * 59 + ($printStatus == null ? 43 : $printStatus.hashCode());
      Object $gasReturnStatus = this.getGasReturnStatus();
      result = result * 59 + ($gasReturnStatus == null ? 43 : $gasReturnStatus.hashCode());
      Object $rejectStatus = this.getRejectStatus();
      result = result * 59 + ($rejectStatus == null ? 43 : $rejectStatus.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $inboundSerialNumber = this.getInboundSerialNumber();
      result = result * 59 + ($inboundSerialNumber == null ? 43 : $inboundSerialNumber.hashCode());
      Object $requisitionsSn = this.getRequisitionsSn();
      result = result * 59 + ($requisitionsSn == null ? 43 : $requisitionsSn.hashCode());
      Object $purchaseSn = this.getPurchaseSn();
      result = result * 59 + ($purchaseSn == null ? 43 : $purchaseSn.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
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
      Object $specificationIds = this.getSpecificationIds();
      result = result * 59 + ($specificationIds == null ? 43 : $specificationIds.hashCode());
      Object $sectionSteelSpecIds = this.getSectionSteelSpecIds();
      result = result * 59 + ($sectionSteelSpecIds == null ? 43 : $sectionSteelSpecIds.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $unitPriceExcludingVATNoFreight = this.getUnitPriceExcludingVATNoFreight();
      result = result * 59 + ($unitPriceExcludingVATNoFreight == null ? 43 : $unitPriceExcludingVATNoFreight.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $amountExcludingVATNoFreight = this.getAmountExcludingVATNoFreight();
      result = result * 59 + ($amountExcludingVATNoFreight == null ? 43 : $amountExcludingVATNoFreight.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $inputVATNoFreight = this.getInputVATNoFreight();
      result = result * 59 + ($inputVATNoFreight == null ? 43 : $inputVATNoFreight.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $inboundTime = this.getInboundTime();
      result = result * 59 + ($inboundTime == null ? 43 : $inboundTime.hashCode());
      Object $rejectQuantity = this.getRejectQuantity();
      result = result * 59 + ($rejectQuantity == null ? 43 : $rejectQuantity.hashCode());
      Object $rejectMete = this.getRejectMete();
      result = result * 59 + ($rejectMete == null ? 43 : $rejectMete.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      return result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
   }

   @Override
   public String toString() {
      return "InboundRecordDTO(id="
         + this.getId()
         + ", inboundId="
         + this.getInboundId()
         + ", inboundSerialNumber="
         + this.getInboundSerialNumber()
         + ", requisitionsSn="
         + this.getRequisitionsSn()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", purchaseSn="
         + this.getPurchaseSn()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", basicClass="
         + this.getBasicClass()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
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
         + ", specificationIds="
         + this.getSpecificationIds()
         + ", sectionSteelSpecIds="
         + this.getSectionSteelSpecIds()
         + ", specification="
         + this.getSpecification()
         + ", color="
         + this.getColor()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", unitNet="
         + this.getUnitNet()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", mete="
         + this.getMete()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", projectId="
         + this.getProjectId()
         + ", factoryId="
         + this.getFactoryId()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", unitPriceExcludingVATNoFreight="
         + this.getUnitPriceExcludingVATNoFreight()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", amountExcludingVATNoFreight="
         + this.getAmountExcludingVATNoFreight()
         + ", inputVat="
         + this.getInputVat()
         + ", inputVATNoFreight="
         + this.getInputVATNoFreight()
         + ", amount="
         + this.getAmount()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", remark="
         + this.getRemark()
         + ", printStatus="
         + this.getPrintStatus()
         + ", gasReturnStatus="
         + this.getGasReturnStatus()
         + ", inboundTime="
         + this.getInboundTime()
         + ", rejectStatus="
         + this.getRejectStatus()
         + ", rejectQuantity="
         + this.getRejectQuantity()
         + ", rejectMete="
         + this.getRejectMete()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ")";
   }

   public static class InboundRecordDTOBuilder {
      private Long id;
      private Long inboundId;
      private String inboundSerialNumber;
      private String requisitionsSn;
      private Long purchaseId;
      private String purchaseSn;
      private BigDecimal taxRate;
      private Integer invoiceType;
      private Integer basicClass;
      private Boolean boolPartyA;
      private Long classifyId;
      private String classifyName;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private BigDecimal theoryWeight;
      private BigDecimal quantity;
      private String brand;
      private String heatNoAndBatchNo;
      private String specificationIds;
      private String sectionSteelSpecIds;
      private String specification;
      private String color;
      private String measureUnit;
      private String accountingUnit;
      private BigDecimal unitNet;
      private Integer accountingPrecision;
      private Integer measurePrecision;
      private BigDecimal mete;
      private Integer weightMeasurementMode;
      private Long warehouseId;
      private Long projectId;
      private Long factoryId;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal unitPriceExcludingVATNoFreight;
      private BigDecimal amountExcludingVat;
      private BigDecimal amountExcludingVATNoFreight;
      private BigDecimal inputVat;
      private BigDecimal inputVATNoFreight;
      private BigDecimal amount;
      private BigDecimal amountNoFreight;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceNoFreight;
      private String remark;
      private Boolean printStatus;
      private Boolean gasReturnStatus;
      private LocalDateTime inboundTime;
      private Integer rejectStatus;
      private BigDecimal rejectQuantity;
      private BigDecimal rejectMete;
      private Long standardId;
      private String standardName;
      private Long applicantId;
      private String applicantName;
      private Long reviewerId;
      private String reviewerName;

      InboundRecordDTOBuilder() {
      }

      public InboundRecordDTO.InboundRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder inboundSerialNumber(final String inboundSerialNumber) {
         this.inboundSerialNumber = inboundSerialNumber;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder requisitionsSn(final String requisitionsSn) {
         this.requisitionsSn = requisitionsSn;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder purchaseSn(final String purchaseSn) {
         this.purchaseSn = purchaseSn;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder theoryWeight(final BigDecimal theoryWeight) {
         this.theoryWeight = theoryWeight;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder specificationIds(final String specificationIds) {
         this.specificationIds = specificationIds;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder sectionSteelSpecIds(final String sectionSteelSpecIds) {
         this.sectionSteelSpecIds = sectionSteelSpecIds;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("unitPriceExcludingVAT")
      public InboundRecordDTO.InboundRecordDTOBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("unitPriceExcludingVATNoFreight")
      public InboundRecordDTO.InboundRecordDTOBuilder unitPriceExcludingVATNoFreight(final BigDecimal unitPriceExcludingVATNoFreight) {
         this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVAT")
      public InboundRecordDTO.InboundRecordDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("amountExcludingVATNoFreight")
      public InboundRecordDTO.InboundRecordDTOBuilder amountExcludingVATNoFreight(final BigDecimal amountExcludingVATNoFreight) {
         this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
         return this;
      }

      @JsonProperty("inputVAT")
      public InboundRecordDTO.InboundRecordDTOBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("inputVATNoFreight")
      public InboundRecordDTO.InboundRecordDTOBuilder inputVATNoFreight(final BigDecimal inputVATNoFreight) {
         this.inputVATNoFreight = inputVATNoFreight;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder printStatus(final Boolean printStatus) {
         this.printStatus = printStatus;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder gasReturnStatus(final Boolean gasReturnStatus) {
         this.gasReturnStatus = gasReturnStatus;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder inboundTime(final LocalDateTime inboundTime) {
         this.inboundTime = inboundTime;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder rejectStatus(final Integer rejectStatus) {
         this.rejectStatus = rejectStatus;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder rejectQuantity(final BigDecimal rejectQuantity) {
         this.rejectQuantity = rejectQuantity;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder rejectMete(final BigDecimal rejectMete) {
         this.rejectMete = rejectMete;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      public InboundRecordDTO.InboundRecordDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public InboundRecordDTO build() {
         return new InboundRecordDTO(
            this.id,
            this.inboundId,
            this.inboundSerialNumber,
            this.requisitionsSn,
            this.purchaseId,
            this.purchaseSn,
            this.taxRate,
            this.invoiceType,
            this.basicClass,
            this.boolPartyA,
            this.classifyId,
            this.classifyName,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.theoryWeight,
            this.quantity,
            this.brand,
            this.heatNoAndBatchNo,
            this.specificationIds,
            this.sectionSteelSpecIds,
            this.specification,
            this.color,
            this.measureUnit,
            this.accountingUnit,
            this.unitNet,
            this.accountingPrecision,
            this.measurePrecision,
            this.mete,
            this.weightMeasurementMode,
            this.warehouseId,
            this.projectId,
            this.factoryId,
            this.unitPriceExcludingVat,
            this.unitPriceExcludingVATNoFreight,
            this.amountExcludingVat,
            this.amountExcludingVATNoFreight,
            this.inputVat,
            this.inputVATNoFreight,
            this.amount,
            this.amountNoFreight,
            this.unitPrice,
            this.unitPriceNoFreight,
            this.remark,
            this.printStatus,
            this.gasReturnStatus,
            this.inboundTime,
            this.rejectStatus,
            this.rejectQuantity,
            this.rejectMete,
            this.standardId,
            this.standardName,
            this.applicantId,
            this.applicantName,
            this.reviewerId,
            this.reviewerName
         );
      }

      @Override
      public String toString() {
         return "InboundRecordDTO.InboundRecordDTOBuilder(id="
            + this.id
            + ", inboundId="
            + this.inboundId
            + ", inboundSerialNumber="
            + this.inboundSerialNumber
            + ", requisitionsSn="
            + this.requisitionsSn
            + ", purchaseId="
            + this.purchaseId
            + ", purchaseSn="
            + this.purchaseSn
            + ", taxRate="
            + this.taxRate
            + ", invoiceType="
            + this.invoiceType
            + ", basicClass="
            + this.basicClass
            + ", boolPartyA="
            + this.boolPartyA
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
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
            + ", specificationIds="
            + this.specificationIds
            + ", sectionSteelSpecIds="
            + this.sectionSteelSpecIds
            + ", specification="
            + this.specification
            + ", color="
            + this.color
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", unitNet="
            + this.unitNet
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", measurePrecision="
            + this.measurePrecision
            + ", mete="
            + this.mete
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", warehouseId="
            + this.warehouseId
            + ", projectId="
            + this.projectId
            + ", factoryId="
            + this.factoryId
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", unitPriceExcludingVATNoFreight="
            + this.unitPriceExcludingVATNoFreight
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", amountExcludingVATNoFreight="
            + this.amountExcludingVATNoFreight
            + ", inputVat="
            + this.inputVat
            + ", inputVATNoFreight="
            + this.inputVATNoFreight
            + ", amount="
            + this.amount
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", remark="
            + this.remark
            + ", printStatus="
            + this.printStatus
            + ", gasReturnStatus="
            + this.gasReturnStatus
            + ", inboundTime="
            + this.inboundTime
            + ", rejectStatus="
            + this.rejectStatus
            + ", rejectQuantity="
            + this.rejectQuantity
            + ", rejectMete="
            + this.rejectMete
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ")";
      }
   }
}
