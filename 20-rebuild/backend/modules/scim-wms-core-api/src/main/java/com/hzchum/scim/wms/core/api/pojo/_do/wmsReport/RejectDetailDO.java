package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InboundReceiptDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RejectDetailDO {
   private Long id;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型")
   @JsonProperty("basicClass")
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID")
   @JsonProperty("classifyId")
   private Long classifyId;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   private String specification;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态(1 整料, 余料)")
   @JsonProperty("materialIsWhole")
   private Integer materialIsWhole;
   @ApiModelProperty(name = "warehouseType", value = "仓库类型[1 公共库,2 项目库]")
   @JsonProperty("warehouseType")
   private Integer warehouseType;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供物料")
   @JsonProperty("boolPartyA")
   private Boolean boolPartyA;
   @ApiModelProperty(name = "projectId", value = "项目ID")
   @JsonProperty("projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @JsonProperty("areaId")
   private Long areaId;
   @ApiModelProperty(name = "quantity", value = "计量量")
   @JsonProperty("quantity")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "核算量")
   @JsonProperty("mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "length", value = "长度")
   @JsonProperty("length")
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽度")
   @JsonProperty("width")
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度")
   @JsonProperty("thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度")
   @JsonProperty("theoryThickness")
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "unitNet", value = "单位净量")
   @JsonProperty("unitNet")
   private BigDecimal unitNet;
   @ApiModelProperty(name = "brand", value = "品牌")
   @JsonProperty("brand")
   private String brand;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号")
   @JsonProperty("heatNoAndBatchNo")
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "color", value = "颜色")
   @JsonProperty("color")
   private String color;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID")
   @JsonProperty("warehouseId")
   private Long warehouseId;
   @ApiModelProperty(name = "factoryId", value = "工厂ID")
   @JsonProperty("factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "rejectId", value = "退货单ID")
   @JsonProperty("rejectId")
   private Long rejectId;
   @ApiModelProperty(name = "unitPrice", value = "含税单价")
   @JsonProperty("unitPrice")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "unitPriceExcludingVAT", value = "不含税单价")
   @JsonProperty("unitPriceExcludingVAT")
   private BigDecimal unitPriceExcludingVAT;
   @ApiModelProperty(name = "amount", value = "含税总价")
   @JsonProperty("amount")
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVAT", value = "不含税总价")
   @JsonProperty("amountExcludingVAT")
   private BigDecimal amountExcludingVAT;
   @ApiModelProperty(name = "inputVAT", value = "进项税")
   private BigDecimal inputVAT;
   @ApiModelProperty(name = "taxRate", value = "税率(百分比)")
   @JsonProperty("taxRate")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 [InvoiceTypeEnum]")
   @JsonProperty("invoiceType")
   private Integer invoiceType;
   @ApiModelProperty(name = "standardId", value = "型材执行国标ID")
   @JsonProperty("standardId")
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "型材执行国标名称")
   @JsonProperty("standardName")
   private String standardName;
   @ApiModelProperty(name = "materialSn", value = "物料编号")
   @JsonProperty("materialSn")
   private String materialSn;
   private String applicantName;
   @ApiModelProperty(name = "project", value = "项目信息")
   private ProjectInfo project;
   @ApiModelProperty(name = "rejectTime", value = "退货时间")
   private LocalDateTime rejectTime;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "reviewTime", value = "审核时间")
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "reviewerName", value = "审核人姓名")
   private String reviewerName;
   @ApiModelProperty(name = "warehouse", value = "仓库位置信息")
   private BriefIdAndNameDTO warehouse;
   @ApiModelProperty(name = "rejectSN", value = "退货单号")
   private String rejectSN;
   @ApiModelProperty(name = "classifyName", value = "科目名称")
   private String classifyName;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "inboundReceipt", value = "入库信息")
   private InboundReceiptDTO inboundReceipt;
   @ApiModelProperty(name = "supplier", value = "供应商信息")
   private BriefIdAndNameDTO supplier;
   @ApiModelProperty(name = "purchaseOrder", value = "采购单信息")
   private BriefIdAndSNDTO purchaseOrder;
   @ApiModelProperty(name = "quantityCount", value = "数量汇总")
   private BigDecimal quantityCount;
   @ApiModelProperty(name = "meteCount", value = "核算量汇总")
   private BigDecimal meteCount;
   @ApiModelProperty(name = "amountCount", value = "含税金额汇总")
   private BigDecimal amountCount;
   @ApiModelProperty(name = "amountExcludingVatCount", value = "不含税金额汇总")
   private BigDecimal amountExcludingVatCount;
   @ApiModelProperty(name = "rejectDO", value = "退货对象")
   private RejectDO rejectDO;

   public static RejectDetailDO.RejectDetailDOBuilder builder() {
      return new RejectDetailDO.RejectDetailDOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
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

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
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

   public BigDecimal getUnitNet() {
      return this.unitNet;
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

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getRejectId() {
      return this.rejectId;
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

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public LocalDateTime getRejectTime() {
      return this.rejectTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public String getRejectSN() {
      return this.rejectSN;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getRemark() {
      return this.remark;
   }

   public InboundReceiptDTO getInboundReceipt() {
      return this.inboundReceipt;
   }

   public BriefIdAndNameDTO getSupplier() {
      return this.supplier;
   }

   public BriefIdAndSNDTO getPurchaseOrder() {
      return this.purchaseOrder;
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

   public RejectDO getRejectDO() {
      return this.rejectDO;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("basicClass")
   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   @JsonProperty("classifyId")
   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("materialIsWhole")
   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
   }

   @JsonProperty("warehouseType")
   public void setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
   }

   @JsonProperty("boolPartyA")
   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   @JsonProperty("projectId")
   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @JsonProperty("monomerId")
   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   @JsonProperty("areaId")
   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   @JsonProperty("quantity")
   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("width")
   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   @JsonProperty("thickness")
   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   @JsonProperty("theoryThickness")
   public void setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
   }

   @JsonProperty("unitNet")
   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   @JsonProperty("brand")
   public void setBrand(final String brand) {
      this.brand = brand;
   }

   @JsonProperty("heatNoAndBatchNo")
   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   @JsonProperty("color")
   public void setColor(final String color) {
      this.color = color;
   }

   @JsonProperty("warehouseId")
   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   @JsonProperty("factoryId")
   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   @JsonProperty("rejectId")
   public void setRejectId(final Long rejectId) {
      this.rejectId = rejectId;
   }

   @JsonProperty("unitPrice")
   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   @JsonProperty("unitPriceExcludingVAT")
   public void setUnitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
   }

   @JsonProperty("amount")
   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @JsonProperty("amountExcludingVAT")
   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public void setInputVAT(final BigDecimal inputVAT) {
      this.inputVAT = inputVAT;
   }

   @JsonProperty("taxRate")
   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   @JsonProperty("invoiceType")
   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   @JsonProperty("standardId")
   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   @JsonProperty("standardName")
   public void setStandardName(final String standardName) {
      this.standardName = standardName;
   }

   @JsonProperty("materialSn")
   public void setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setRejectTime(final LocalDateTime rejectTime) {
      this.rejectTime = rejectTime;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setRejectSN(final String rejectSN) {
      this.rejectSN = rejectSN;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setInboundReceipt(final InboundReceiptDTO inboundReceipt) {
      this.inboundReceipt = inboundReceipt;
   }

   public void setSupplier(final BriefIdAndNameDTO supplier) {
      this.supplier = supplier;
   }

   public void setPurchaseOrder(final BriefIdAndSNDTO purchaseOrder) {
      this.purchaseOrder = purchaseOrder;
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

   public void setRejectDO(final RejectDO rejectDO) {
      this.rejectDO = rejectDO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RejectDetailDO)) {
         return false;
      }

      RejectDetailDO other = (RejectDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$materialIsWhole = this.getMaterialIsWhole();
               Object other$materialIsWhole = other.getMaterialIsWhole();
               if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                  Object this$warehouseType = this.getWarehouseType();
                  Object other$warehouseType = other.getWarehouseType();
                  if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                     Object this$boolPartyA = this.getBoolPartyA();
                     Object other$boolPartyA = other.getBoolPartyA();
                     if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                        Object this$projectId = this.getProjectId();
                        Object other$projectId = other.getProjectId();
                        if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                           Object this$monomerId = this.getMonomerId();
                           Object other$monomerId = other.getMonomerId();
                           if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                              Object this$areaId = this.getAreaId();
                              Object other$areaId = other.getAreaId();
                              if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                 Object this$warehouseId = this.getWarehouseId();
                                 Object other$warehouseId = other.getWarehouseId();
                                 if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                    Object this$factoryId = this.getFactoryId();
                                    Object other$factoryId = other.getFactoryId();
                                    if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                       Object this$rejectId = this.getRejectId();
                                       Object other$rejectId = other.getRejectId();
                                       if (this$rejectId == null ? other$rejectId == null : this$rejectId.equals(other$rejectId)) {
                                          Object this$invoiceType = this.getInvoiceType();
                                          Object other$invoiceType = other.getInvoiceType();
                                          if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                             Object this$standardId = this.getStandardId();
                                             Object other$standardId = other.getStandardId();
                                             if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$quantity = this.getQuantity();
                                                   Object other$quantity = other.getQuantity();
                                                   if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                      Object this$mete = this.getMete();
                                                      Object other$mete = other.getMete();
                                                      if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
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
                                                                     Object this$unitNet = this.getUnitNet();
                                                                     Object other$unitNet = other.getUnitNet();
                                                                     if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
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
                                                                                       Object this$amount = this.getAmount();
                                                                                       Object other$amount = other.getAmount();
                                                                                       if (this$amount == null
                                                                                          ? other$amount == null
                                                                                          : this$amount.equals(other$amount)) {
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
                                                                                                Object this$taxRate = this.getTaxRate();
                                                                                                Object other$taxRate = other.getTaxRate();
                                                                                                if (this$taxRate == null
                                                                                                   ? other$taxRate == null
                                                                                                   : this$taxRate.equals(other$taxRate)) {
                                                                                                   Object this$standardName = this.getStandardName();
                                                                                                   Object other$standardName = other.getStandardName();
                                                                                                   if (this$standardName == null
                                                                                                      ? other$standardName == null
                                                                                                      : this$standardName.equals(other$standardName)) {
                                                                                                      Object this$materialSn = this.getMaterialSn();
                                                                                                      Object other$materialSn = other.getMaterialSn();
                                                                                                      if (this$materialSn == null
                                                                                                         ? other$materialSn == null
                                                                                                         : this$materialSn.equals(other$materialSn)) {
                                                                                                         Object this$applicantName = this.getApplicantName();
                                                                                                         Object other$applicantName = other.getApplicantName();
                                                                                                         if (this$applicantName == null
                                                                                                            ? other$applicantName == null
                                                                                                            : this$applicantName.equals(other$applicantName)) {
                                                                                                            Object this$project = this.getProject();
                                                                                                            Object other$project = other.getProject();
                                                                                                            if (this$project == null
                                                                                                               ? other$project == null
                                                                                                               : this$project.equals(other$project)) {
                                                                                                               Object this$rejectTime = this.getRejectTime();
                                                                                                               Object other$rejectTime = other.getRejectTime();
                                                                                                               if (this$rejectTime == null
                                                                                                                  ? other$rejectTime == null
                                                                                                                  : this$rejectTime.equals(other$rejectTime)) {
                                                                                                                  Object this$createTime = this.getCreateTime();
                                                                                                                  Object other$createTime = other.getCreateTime();
                                                                                                                  if (this$createTime == null
                                                                                                                     ? other$createTime == null
                                                                                                                     : this$createTime.equals(other$createTime)
                                                                                                                     )
                                                                                                                   {
                                                                                                                     Object this$reviewTime = this.getReviewTime();
                                                                                                                     Object other$reviewTime = other.getReviewTime();
                                                                                                                     if (this$reviewTime == null
                                                                                                                        ? other$reviewTime == null
                                                                                                                        : this$reviewTime.equals(
                                                                                                                           other$reviewTime
                                                                                                                        )) {
                                                                                                                        Object this$reviewerName = this.getReviewerName();
                                                                                                                        Object other$reviewerName = other.getReviewerName();
                                                                                                                        if (this$reviewerName == null
                                                                                                                           ? other$reviewerName == null
                                                                                                                           : this$reviewerName.equals(
                                                                                                                              other$reviewerName
                                                                                                                           )) {
                                                                                                                           Object this$warehouse = this.getWarehouse();
                                                                                                                           Object other$warehouse = other.getWarehouse();
                                                                                                                           if (this$warehouse == null
                                                                                                                              ? other$warehouse == null
                                                                                                                              : this$warehouse.equals(
                                                                                                                                 other$warehouse
                                                                                                                              )) {
                                                                                                                              Object this$rejectSN = this.getRejectSN();
                                                                                                                              Object other$rejectSN = other.getRejectSN();
                                                                                                                              if (this$rejectSN == null
                                                                                                                                 ? other$rejectSN == null
                                                                                                                                 : this$rejectSN.equals(
                                                                                                                                    other$rejectSN
                                                                                                                                 )) {
                                                                                                                                 Object this$classifyName = this.getClassifyName();
                                                                                                                                 Object other$classifyName = other.getClassifyName();
                                                                                                                                 if (this$classifyName == null
                                                                                                                                    ? other$classifyName
                                                                                                                                       == null
                                                                                                                                    : this$classifyName.equals(
                                                                                                                                       other$classifyName
                                                                                                                                    )) {
                                                                                                                                    Object this$remark = this.getRemark();
                                                                                                                                    Object other$remark = other.getRemark();
                                                                                                                                    if (this$remark == null
                                                                                                                                       ? other$remark == null
                                                                                                                                       : this$remark.equals(
                                                                                                                                          other$remark
                                                                                                                                       )) {
                                                                                                                                       Object this$inboundReceipt = this.getInboundReceipt();
                                                                                                                                       Object other$inboundReceipt = other.getInboundReceipt();
                                                                                                                                       if (this$inboundReceipt
                                                                                                                                             == null
                                                                                                                                          ? other$inboundReceipt
                                                                                                                                             == null
                                                                                                                                          : this$inboundReceipt.equals(
                                                                                                                                             other$inboundReceipt
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
                                                                                                                                             Object this$purchaseOrder = this.getPurchaseOrder();
                                                                                                                                             Object other$purchaseOrder = other.getPurchaseOrder();
                                                                                                                                             if (this$purchaseOrder
                                                                                                                                                   == null
                                                                                                                                                ? other$purchaseOrder
                                                                                                                                                   == null
                                                                                                                                                : this$purchaseOrder.equals(
                                                                                                                                                   other$purchaseOrder
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
                                                                                                                                                      )) {
                                                                                                                                                      Object this$amountCount = this.getAmountCount();
                                                                                                                                                      Object other$amountCount = other.getAmountCount();
                                                                                                                                                      if (this$amountCount
                                                                                                                                                            == null
                                                                                                                                                         ? other$amountCount
                                                                                                                                                            == null
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
                                                                                                                                                            Object this$rejectDO = this.getRejectDO();
                                                                                                                                                            Object other$rejectDO = other.getRejectDO();
                                                                                                                                                            return this$rejectDO
                                                                                                                                                                  == null
                                                                                                                                                               ? other$rejectDO
                                                                                                                                                                  == null
                                                                                                                                                               : this$rejectDO.equals(
                                                                                                                                                                  other$rejectDO
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RejectDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $rejectId = this.getRejectId();
      result = result * 59 + ($rejectId == null ? 43 : $rejectId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
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
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $rejectTime = this.getRejectTime();
      result = result * 59 + ($rejectTime == null ? 43 : $rejectTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $rejectSN = this.getRejectSN();
      result = result * 59 + ($rejectSN == null ? 43 : $rejectSN.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $inboundReceipt = this.getInboundReceipt();
      result = result * 59 + ($inboundReceipt == null ? 43 : $inboundReceipt.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $purchaseOrder = this.getPurchaseOrder();
      result = result * 59 + ($purchaseOrder == null ? 43 : $purchaseOrder.hashCode());
      Object $quantityCount = this.getQuantityCount();
      result = result * 59 + ($quantityCount == null ? 43 : $quantityCount.hashCode());
      Object $meteCount = this.getMeteCount();
      result = result * 59 + ($meteCount == null ? 43 : $meteCount.hashCode());
      Object $amountCount = this.getAmountCount();
      result = result * 59 + ($amountCount == null ? 43 : $amountCount.hashCode());
      Object $amountExcludingVatCount = this.getAmountExcludingVatCount();
      result = result * 59 + ($amountExcludingVatCount == null ? 43 : $amountExcludingVatCount.hashCode());
      Object $rejectDO = this.getRejectDO();
      return result * 59 + ($rejectDO == null ? 43 : $rejectDO.hashCode());
   }

   @Override
   public String toString() {
      return "RejectDetailDO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", specification="
         + this.getSpecification()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", unitNet="
         + this.getUnitNet()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", factoryId="
         + this.getFactoryId()
         + ", rejectId="
         + this.getRejectId()
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
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", materialSn="
         + this.getMaterialSn()
         + ", applicantName="
         + this.getApplicantName()
         + ", project="
         + this.getProject()
         + ", rejectTime="
         + this.getRejectTime()
         + ", createTime="
         + this.getCreateTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", reviewerName="
         + this.getReviewerName()
         + ", warehouse="
         + this.getWarehouse()
         + ", rejectSN="
         + this.getRejectSN()
         + ", classifyName="
         + this.getClassifyName()
         + ", remark="
         + this.getRemark()
         + ", inboundReceipt="
         + this.getInboundReceipt()
         + ", supplier="
         + this.getSupplier()
         + ", purchaseOrder="
         + this.getPurchaseOrder()
         + ", quantityCount="
         + this.getQuantityCount()
         + ", meteCount="
         + this.getMeteCount()
         + ", amountCount="
         + this.getAmountCount()
         + ", amountExcludingVatCount="
         + this.getAmountExcludingVatCount()
         + ", rejectDO="
         + this.getRejectDO()
         + ")";
   }

   public RejectDetailDO(
      final Long id,
      final Integer basicClass,
      final Long classifyId,
      final String specification,
      final Integer materialIsWhole,
      final Integer warehouseType,
      final Boolean boolPartyA,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final BigDecimal unitNet,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final Long warehouseId,
      final Long factoryId,
      final Long rejectId,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVAT,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT,
      final BigDecimal taxRate,
      final Integer invoiceType,
      final Long standardId,
      final String standardName,
      final String materialSn,
      final String applicantName,
      final ProjectInfo project,
      final LocalDateTime rejectTime,
      final LocalDateTime createTime,
      final LocalDateTime reviewTime,
      final String reviewerName,
      final BriefIdAndNameDTO warehouse,
      final String rejectSN,
      final String classifyName,
      final String remark,
      final InboundReceiptDTO inboundReceipt,
      final BriefIdAndNameDTO supplier,
      final BriefIdAndSNDTO purchaseOrder,
      final BigDecimal quantityCount,
      final BigDecimal meteCount,
      final BigDecimal amountCount,
      final BigDecimal amountExcludingVatCount,
      final RejectDO rejectDO
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.specification = specification;
      this.materialIsWhole = materialIsWhole;
      this.warehouseType = warehouseType;
      this.boolPartyA = boolPartyA;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.quantity = quantity;
      this.mete = mete;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.unitNet = unitNet;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.warehouseId = warehouseId;
      this.factoryId = factoryId;
      this.rejectId = rejectId;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
      this.taxRate = taxRate;
      this.invoiceType = invoiceType;
      this.standardId = standardId;
      this.standardName = standardName;
      this.materialSn = materialSn;
      this.applicantName = applicantName;
      this.project = project;
      this.rejectTime = rejectTime;
      this.createTime = createTime;
      this.reviewTime = reviewTime;
      this.reviewerName = reviewerName;
      this.warehouse = warehouse;
      this.rejectSN = rejectSN;
      this.classifyName = classifyName;
      this.remark = remark;
      this.inboundReceipt = inboundReceipt;
      this.supplier = supplier;
      this.purchaseOrder = purchaseOrder;
      this.quantityCount = quantityCount;
      this.meteCount = meteCount;
      this.amountCount = amountCount;
      this.amountExcludingVatCount = amountExcludingVatCount;
      this.rejectDO = rejectDO;
   }

   public RejectDetailDO() {
   }

   public static class RejectDetailDOBuilder {
      private Long id;
      private Integer basicClass;
      private Long classifyId;
      private String specification;
      private Integer materialIsWhole;
      private Integer warehouseType;
      private Boolean boolPartyA;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private BigDecimal unitNet;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private Long warehouseId;
      private Long factoryId;
      private Long rejectId;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVAT;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;
      private BigDecimal taxRate;
      private Integer invoiceType;
      private Long standardId;
      private String standardName;
      private String materialSn;
      private String applicantName;
      private ProjectInfo project;
      private LocalDateTime rejectTime;
      private LocalDateTime createTime;
      private LocalDateTime reviewTime;
      private String reviewerName;
      private BriefIdAndNameDTO warehouse;
      private String rejectSN;
      private String classifyName;
      private String remark;
      private InboundReceiptDTO inboundReceipt;
      private BriefIdAndNameDTO supplier;
      private BriefIdAndSNDTO purchaseOrder;
      private BigDecimal quantityCount;
      private BigDecimal meteCount;
      private BigDecimal amountCount;
      private BigDecimal amountExcludingVatCount;
      private RejectDO rejectDO;

      RejectDetailDOBuilder() {
      }

      public RejectDetailDO.RejectDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("basicClass")
      public RejectDetailDO.RejectDetailDOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public RejectDetailDO.RejectDetailDOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("specification")
      public RejectDetailDO.RejectDetailDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public RejectDetailDO.RejectDetailDOBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("warehouseType")
      public RejectDetailDO.RejectDetailDOBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("boolPartyA")
      public RejectDetailDO.RejectDetailDOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("projectId")
      public RejectDetailDO.RejectDetailDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public RejectDetailDO.RejectDetailDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public RejectDetailDO.RejectDetailDOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("quantity")
      public RejectDetailDO.RejectDetailDOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public RejectDetailDO.RejectDetailDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("length")
      public RejectDetailDO.RejectDetailDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public RejectDetailDO.RejectDetailDOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public RejectDetailDO.RejectDetailDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public RejectDetailDO.RejectDetailDOBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("unitNet")
      public RejectDetailDO.RejectDetailDOBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("brand")
      public RejectDetailDO.RejectDetailDOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public RejectDetailDO.RejectDetailDOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public RejectDetailDO.RejectDetailDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("warehouseId")
      public RejectDetailDO.RejectDetailDOBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("factoryId")
      public RejectDetailDO.RejectDetailDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("rejectId")
      public RejectDetailDO.RejectDetailDOBuilder rejectId(final Long rejectId) {
         this.rejectId = rejectId;
         return this;
      }

      @JsonProperty("unitPrice")
      public RejectDetailDO.RejectDetailDOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("unitPriceExcludingVAT")
      public RejectDetailDO.RejectDetailDOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      @JsonProperty("amount")
      public RejectDetailDO.RejectDetailDOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVAT")
      public RejectDetailDO.RejectDetailDOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      @JsonProperty("taxRate")
      public RejectDetailDO.RejectDetailDOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("invoiceType")
      public RejectDetailDO.RejectDetailDOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("standardId")
      public RejectDetailDO.RejectDetailDOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public RejectDetailDO.RejectDetailDOBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("materialSn")
      public RejectDetailDO.RejectDetailDOBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder rejectTime(final LocalDateTime rejectTime) {
         this.rejectTime = rejectTime;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder rejectSN(final String rejectSN) {
         this.rejectSN = rejectSN;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder inboundReceipt(final InboundReceiptDTO inboundReceipt) {
         this.inboundReceipt = inboundReceipt;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder supplier(final BriefIdAndNameDTO supplier) {
         this.supplier = supplier;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder purchaseOrder(final BriefIdAndSNDTO purchaseOrder) {
         this.purchaseOrder = purchaseOrder;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder quantityCount(final BigDecimal quantityCount) {
         this.quantityCount = quantityCount;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder meteCount(final BigDecimal meteCount) {
         this.meteCount = meteCount;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder amountCount(final BigDecimal amountCount) {
         this.amountCount = amountCount;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder amountExcludingVatCount(final BigDecimal amountExcludingVatCount) {
         this.amountExcludingVatCount = amountExcludingVatCount;
         return this;
      }

      public RejectDetailDO.RejectDetailDOBuilder rejectDO(final RejectDO rejectDO) {
         this.rejectDO = rejectDO;
         return this;
      }

      public RejectDetailDO build() {
         return new RejectDetailDO(
            this.id,
            this.basicClass,
            this.classifyId,
            this.specification,
            this.materialIsWhole,
            this.warehouseType,
            this.boolPartyA,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.quantity,
            this.mete,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.unitNet,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.warehouseId,
            this.factoryId,
            this.rejectId,
            this.unitPrice,
            this.unitPriceExcludingVAT,
            this.amount,
            this.amountExcludingVAT,
            this.inputVAT,
            this.taxRate,
            this.invoiceType,
            this.standardId,
            this.standardName,
            this.materialSn,
            this.applicantName,
            this.project,
            this.rejectTime,
            this.createTime,
            this.reviewTime,
            this.reviewerName,
            this.warehouse,
            this.rejectSN,
            this.classifyName,
            this.remark,
            this.inboundReceipt,
            this.supplier,
            this.purchaseOrder,
            this.quantityCount,
            this.meteCount,
            this.amountCount,
            this.amountExcludingVatCount,
            this.rejectDO
         );
      }

      @Override
      public String toString() {
         return "RejectDetailDO.RejectDetailDOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", specification="
            + this.specification
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", warehouseType="
            + this.warehouseType
            + ", boolPartyA="
            + this.boolPartyA
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", theoryThickness="
            + this.theoryThickness
            + ", unitNet="
            + this.unitNet
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", warehouseId="
            + this.warehouseId
            + ", factoryId="
            + this.factoryId
            + ", rejectId="
            + this.rejectId
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
            + ", taxRate="
            + this.taxRate
            + ", invoiceType="
            + this.invoiceType
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", materialSn="
            + this.materialSn
            + ", applicantName="
            + this.applicantName
            + ", project="
            + this.project
            + ", rejectTime="
            + this.rejectTime
            + ", createTime="
            + this.createTime
            + ", reviewTime="
            + this.reviewTime
            + ", reviewerName="
            + this.reviewerName
            + ", warehouse="
            + this.warehouse
            + ", rejectSN="
            + this.rejectSN
            + ", classifyName="
            + this.classifyName
            + ", remark="
            + this.remark
            + ", inboundReceipt="
            + this.inboundReceipt
            + ", supplier="
            + this.supplier
            + ", purchaseOrder="
            + this.purchaseOrder
            + ", quantityCount="
            + this.quantityCount
            + ", meteCount="
            + this.meteCount
            + ", amountCount="
            + this.amountCount
            + ", amountExcludingVatCount="
            + this.amountExcludingVatCount
            + ", rejectDO="
            + this.rejectDO
            + ")";
      }
   }
}
