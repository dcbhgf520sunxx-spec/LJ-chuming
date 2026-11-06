package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InboundReceiptDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class InboundDetailDTO {
   private Long id;
   private boolean boolPartyA;
   @JsonInclude(Include.NON_NULL)
   private Long classifyId;
   @JsonInclude(Include.NON_NULL)
   private String classifyName;
   @JsonInclude(Include.NON_NULL)
   private Integer basicClass;
   @JsonInclude(Include.NON_NULL)
   private String specification;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal quantity;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal thickness;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal length;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal width;
   @JsonInclude(Include.NON_NULL)
   private String brand;
   @JsonInclude(Include.NON_NULL)
   private String heatNoAndBatchNo;
   @JsonInclude(Include.NON_NULL)
   private String measureUnit;
   @JsonInclude(Include.NON_NULL)
   private String accountingUnit;
   @JsonInclude(Include.NON_NULL)
   private String remark;
   @JsonInclude(Include.NON_NULL)
   private String color;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal mete;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPrice;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPriceExcludingVAT;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal amount;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal amountExcludingVAT;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inputVAT;
   @JsonInclude(Include.NON_NULL)
   private ProjectInfo project;
   @JsonInclude(Include.NON_NULL)
   private Long monomerId;
   @JsonInclude(Include.NON_NULL)
   private Long areaId;
   @JsonInclude(Include.NON_NULL)
   private String monomerName;
   @JsonInclude(Include.NON_NULL)
   private String areaName;
   @JsonInclude(Include.NON_NULL)
   private Long workshopId;
   @JsonInclude(Include.NON_NULL)
   private BriefIdAndNameDTO workshop;
   @JsonInclude(Include.NON_NULL)
   private BriefIdAndNameDTO warehouse;
   @JsonInclude(Include.NON_NULL)
   private String nationalStandard;
   @JsonInclude(Include.NON_NULL)
   private Integer invoiceType;
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime inboundTime;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal taxRate;
   @JsonInclude(Include.NON_NULL)
   private Integer rejectStatus;
   @JsonInclude(Include.NON_NULL)
   private Integer qualityTestingEnum;
   @JsonInclude(Include.NON_NULL)
   private List<RejectMaterialDTO> rejectList;
   @JsonInclude(Include.NON_NULL)
   private InboundReceiptDTO inboundReceipt;
   @JsonInclude(Include.NON_NULL)
   private String serialNumber;
   @JsonInclude(Include.NON_NULL)
   private String material;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal netWeight;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal surfaceArea;
   @JsonInclude(Include.NON_NULL)
   private NameInfo structureClassify;
   private List<AdjustDetailsDTO> adjustDetailList;
   private Long purchaseOrderDetailId;
   private Long mergeId;
   private Long applyPurchaseId;
   private Long standardId;
   private String sectionSteelSpec;
   private String doNotSectionSteelSpec;
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
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式[参考枚举 MeasureEnum]")
   private Integer weightMeasurementMode;
   @ApiModelProperty(name = "steelDensity", value = "钢材密度")
   private BigDecimal steelDensity;
   @ApiModelProperty(name = "materialIsWhole", value = "物料是否完整")
   private Integer materialIsWhole;
   private Long materialCodeConfigId;
   private String materialSnNew;
   private Integer inboundWay;
   private LocalDateTime realTime;

   public static InboundDetailDTO.InboundDetailDTOBuilder builder() {
      return new InboundDetailDTO.InboundDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public boolean isBoolPartyA() {
      return this.boolPartyA;
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

   public String getSpecification() {
      return this.specification;
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

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getMete() {
      return this.mete;
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

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public LocalDateTime getInboundTime() {
      return this.inboundTime;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getRejectStatus() {
      return this.rejectStatus;
   }

   public Integer getQualityTestingEnum() {
      return this.qualityTestingEnum;
   }

   public List<RejectMaterialDTO> getRejectList() {
      return this.rejectList;
   }

   public InboundReceiptDTO getInboundReceipt() {
      return this.inboundReceipt;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public NameInfo getStructureClassify() {
      return this.structureClassify;
   }

   public List<AdjustDetailsDTO> getAdjustDetailList() {
      return this.adjustDetailList;
   }

   public Long getPurchaseOrderDetailId() {
      return this.purchaseOrderDetailId;
   }

   public Long getMergeId() {
      return this.mergeId;
   }

   public Long getApplyPurchaseId() {
      return this.applyPurchaseId;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getSectionSteelSpec() {
      return this.sectionSteelSpec;
   }

   public String getDoNotSectionSteelSpec() {
      return this.doNotSectionSteelSpec;
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

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public BigDecimal getSteelDensity() {
      return this.steelDensity;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Long getMaterialCodeConfigId() {
      return this.materialCodeConfigId;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
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

   public void setBoolPartyA(final boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
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

   public void setSpecification(final String specification) {
      this.specification = specification;
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

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
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

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setInboundTime(final LocalDateTime inboundTime) {
      this.inboundTime = inboundTime;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setRejectStatus(final Integer rejectStatus) {
      this.rejectStatus = rejectStatus;
   }

   public void setQualityTestingEnum(final Integer qualityTestingEnum) {
      this.qualityTestingEnum = qualityTestingEnum;
   }

   public void setRejectList(final List<RejectMaterialDTO> rejectList) {
      this.rejectList = rejectList;
   }

   public void setInboundReceipt(final InboundReceiptDTO inboundReceipt) {
      this.inboundReceipt = inboundReceipt;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setStructureClassify(final NameInfo structureClassify) {
      this.structureClassify = structureClassify;
   }

   public void setAdjustDetailList(final List<AdjustDetailsDTO> adjustDetailList) {
      this.adjustDetailList = adjustDetailList;
   }

   public void setPurchaseOrderDetailId(final Long purchaseOrderDetailId) {
      this.purchaseOrderDetailId = purchaseOrderDetailId;
   }

   public void setMergeId(final Long mergeId) {
      this.mergeId = mergeId;
   }

   public void setApplyPurchaseId(final Long applyPurchaseId) {
      this.applyPurchaseId = applyPurchaseId;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   public void setSectionSteelSpec(final String sectionSteelSpec) {
      this.sectionSteelSpec = sectionSteelSpec;
   }

   public void setDoNotSectionSteelSpec(final String doNotSectionSteelSpec) {
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
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

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   public void setSteelDensity(final BigDecimal steelDensity) {
      this.steelDensity = steelDensity;
   }

   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
   }

   public void setMaterialCodeConfigId(final Long materialCodeConfigId) {
      this.materialCodeConfigId = materialCodeConfigId;
   }

   public void setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
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

      if (!(o instanceof InboundDetailDTO)) {
         return false;
      }

      InboundDetailDTO other = (InboundDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isBoolPartyA() != other.isBoolPartyA()) {
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
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$workshopId = this.getWorkshopId();
                     Object other$workshopId = other.getWorkshopId();
                     if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                        Object this$invoiceType = this.getInvoiceType();
                        Object other$invoiceType = other.getInvoiceType();
                        if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                           Object this$rejectStatus = this.getRejectStatus();
                           Object other$rejectStatus = other.getRejectStatus();
                           if (this$rejectStatus == null ? other$rejectStatus == null : this$rejectStatus.equals(other$rejectStatus)) {
                              Object this$qualityTestingEnum = this.getQualityTestingEnum();
                              Object other$qualityTestingEnum = other.getQualityTestingEnum();
                              if (this$qualityTestingEnum == null ? other$qualityTestingEnum == null : this$qualityTestingEnum.equals(other$qualityTestingEnum)
                                 )
                               {
                                 Object this$purchaseOrderDetailId = this.getPurchaseOrderDetailId();
                                 Object other$purchaseOrderDetailId = other.getPurchaseOrderDetailId();
                                 if (this$purchaseOrderDetailId == null
                                    ? other$purchaseOrderDetailId == null
                                    : this$purchaseOrderDetailId.equals(other$purchaseOrderDetailId)) {
                                    Object this$mergeId = this.getMergeId();
                                    Object other$mergeId = other.getMergeId();
                                    if (this$mergeId == null ? other$mergeId == null : this$mergeId.equals(other$mergeId)) {
                                       Object this$applyPurchaseId = this.getApplyPurchaseId();
                                       Object other$applyPurchaseId = other.getApplyPurchaseId();
                                       if (this$applyPurchaseId == null ? other$applyPurchaseId == null : this$applyPurchaseId.equals(other$applyPurchaseId)) {
                                          Object this$standardId = this.getStandardId();
                                          Object other$standardId = other.getStandardId();
                                          if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                             Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                             Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                             if (this$weightMeasurementMode == null
                                                ? other$weightMeasurementMode == null
                                                : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                                Object this$materialIsWhole = this.getMaterialIsWhole();
                                                Object other$materialIsWhole = other.getMaterialIsWhole();
                                                if (this$materialIsWhole == null
                                                   ? other$materialIsWhole == null
                                                   : this$materialIsWhole.equals(other$materialIsWhole)) {
                                                   Object this$materialCodeConfigId = this.getMaterialCodeConfigId();
                                                   Object other$materialCodeConfigId = other.getMaterialCodeConfigId();
                                                   if (this$materialCodeConfigId == null
                                                      ? other$materialCodeConfigId == null
                                                      : this$materialCodeConfigId.equals(other$materialCodeConfigId)) {
                                                      Object this$inboundWay = this.getInboundWay();
                                                      Object other$inboundWay = other.getInboundWay();
                                                      if (this$inboundWay == null ? other$inboundWay == null : this$inboundWay.equals(other$inboundWay)) {
                                                         Object this$classifyName = this.getClassifyName();
                                                         Object other$classifyName = other.getClassifyName();
                                                         if (this$classifyName == null
                                                            ? other$classifyName == null
                                                            : this$classifyName.equals(other$classifyName)) {
                                                            Object this$specification = this.getSpecification();
                                                            Object other$specification = other.getSpecification();
                                                            if (this$specification == null
                                                               ? other$specification == null
                                                               : this$specification.equals(other$specification)) {
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
                                                                           Object this$brand = this.getBrand();
                                                                           Object other$brand = other.getBrand();
                                                                           if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                              Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                              Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                              if (this$heatNoAndBatchNo == null
                                                                                 ? other$heatNoAndBatchNo == null
                                                                                 : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                                 Object this$measureUnit = this.getMeasureUnit();
                                                                                 Object other$measureUnit = other.getMeasureUnit();
                                                                                 if (this$measureUnit == null
                                                                                    ? other$measureUnit == null
                                                                                    : this$measureUnit.equals(other$measureUnit)) {
                                                                                    Object this$accountingUnit = this.getAccountingUnit();
                                                                                    Object other$accountingUnit = other.getAccountingUnit();
                                                                                    if (this$accountingUnit == null
                                                                                       ? other$accountingUnit == null
                                                                                       : this$accountingUnit.equals(other$accountingUnit)) {
                                                                                       Object this$remark = this.getRemark();
                                                                                       Object other$remark = other.getRemark();
                                                                                       if (this$remark == null
                                                                                          ? other$remark == null
                                                                                          : this$remark.equals(other$remark)) {
                                                                                          Object this$color = this.getColor();
                                                                                          Object other$color = other.getColor();
                                                                                          if (this$color == null
                                                                                             ? other$color == null
                                                                                             : this$color.equals(other$color)) {
                                                                                             Object this$mete = this.getMete();
                                                                                             Object other$mete = other.getMete();
                                                                                             if (this$mete == null
                                                                                                ? other$mete == null
                                                                                                : this$mete.equals(other$mete)) {
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
                                                                                                                        : this$areaName.equals(other$areaName)) {
                                                                                                                        Object this$workshop = this.getWorkshop();
                                                                                                                        Object other$workshop = other.getWorkshop();
                                                                                                                        if (this$workshop == null
                                                                                                                           ? other$workshop == null
                                                                                                                           : this$workshop.equals(
                                                                                                                              other$workshop
                                                                                                                           )) {
                                                                                                                           Object this$warehouse = this.getWarehouse();
                                                                                                                           Object other$warehouse = other.getWarehouse();
                                                                                                                           if (this$warehouse == null
                                                                                                                              ? other$warehouse == null
                                                                                                                              : this$warehouse.equals(
                                                                                                                                 other$warehouse
                                                                                                                              )) {
                                                                                                                              Object this$nationalStandard = this.getNationalStandard();
                                                                                                                              Object other$nationalStandard = other.getNationalStandard();
                                                                                                                              if (this$nationalStandard == null
                                                                                                                                 ? other$nationalStandard
                                                                                                                                    == null
                                                                                                                                 : this$nationalStandard.equals(
                                                                                                                                    other$nationalStandard
                                                                                                                                 )) {
                                                                                                                                 Object this$inboundTime = this.getInboundTime();
                                                                                                                                 Object other$inboundTime = other.getInboundTime();
                                                                                                                                 if (this$inboundTime == null
                                                                                                                                    ? other$inboundTime == null
                                                                                                                                    : this$inboundTime.equals(
                                                                                                                                       other$inboundTime
                                                                                                                                    )) {
                                                                                                                                    Object this$taxRate = this.getTaxRate();
                                                                                                                                    Object other$taxRate = other.getTaxRate();
                                                                                                                                    if (this$taxRate == null
                                                                                                                                       ? other$taxRate == null
                                                                                                                                       : this$taxRate.equals(
                                                                                                                                          other$taxRate
                                                                                                                                       )) {
                                                                                                                                       Object this$rejectList = this.getRejectList();
                                                                                                                                       Object other$rejectList = other.getRejectList();
                                                                                                                                       if (this$rejectList
                                                                                                                                             == null
                                                                                                                                          ? other$rejectList
                                                                                                                                             == null
                                                                                                                                          : this$rejectList.equals(
                                                                                                                                             other$rejectList
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
                                                                                                                                             Object this$serialNumber = this.getSerialNumber();
                                                                                                                                             Object other$serialNumber = other.getSerialNumber();
                                                                                                                                             if (this$serialNumber
                                                                                                                                                   == null
                                                                                                                                                ? other$serialNumber
                                                                                                                                                   == null
                                                                                                                                                : this$serialNumber.equals(
                                                                                                                                                   other$serialNumber
                                                                                                                                                )) {
                                                                                                                                                Object this$material = this.getMaterial();
                                                                                                                                                Object other$material = other.getMaterial();
                                                                                                                                                if (this$material
                                                                                                                                                      == null
                                                                                                                                                   ? other$material
                                                                                                                                                      == null
                                                                                                                                                   : this$material.equals(
                                                                                                                                                      other$material
                                                                                                                                                   )) {
                                                                                                                                                   Object this$netWeight = this.getNetWeight();
                                                                                                                                                   Object other$netWeight = other.getNetWeight();
                                                                                                                                                   if (this$netWeight
                                                                                                                                                         == null
                                                                                                                                                      ? other$netWeight
                                                                                                                                                         == null
                                                                                                                                                      : this$netWeight.equals(
                                                                                                                                                         other$netWeight
                                                                                                                                                      )) {
                                                                                                                                                      Object this$surfaceArea = this.getSurfaceArea();
                                                                                                                                                      Object other$surfaceArea = other.getSurfaceArea();
                                                                                                                                                      if (this$surfaceArea
                                                                                                                                                            == null
                                                                                                                                                         ? other$surfaceArea
                                                                                                                                                            == null
                                                                                                                                                         : this$surfaceArea.equals(
                                                                                                                                                            other$surfaceArea
                                                                                                                                                         )) {
                                                                                                                                                         Object this$structureClassify = this.getStructureClassify();
                                                                                                                                                         Object other$structureClassify = other.getStructureClassify();
                                                                                                                                                         if (this$structureClassify
                                                                                                                                                               == null
                                                                                                                                                            ? other$structureClassify
                                                                                                                                                               == null
                                                                                                                                                            : this$structureClassify.equals(
                                                                                                                                                               other$structureClassify
                                                                                                                                                            )) {
                                                                                                                                                            Object this$adjustDetailList = this.getAdjustDetailList();
                                                                                                                                                            Object other$adjustDetailList = other.getAdjustDetailList();
                                                                                                                                                            if (this$adjustDetailList
                                                                                                                                                                  == null
                                                                                                                                                               ? other$adjustDetailList
                                                                                                                                                                  == null
                                                                                                                                                               : this$adjustDetailList.equals(
                                                                                                                                                                  other$adjustDetailList
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$sectionSteelSpec = this.getSectionSteelSpec();
                                                                                                                                                               Object other$sectionSteelSpec = other.getSectionSteelSpec();
                                                                                                                                                               if (this$sectionSteelSpec
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$sectionSteelSpec
                                                                                                                                                                     == null
                                                                                                                                                                  : this$sectionSteelSpec.equals(
                                                                                                                                                                     other$sectionSteelSpec
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
                                                                                                                                                                  Object other$doNotSectionSteelSpec = other.getDoNotSectionSteelSpec();
                                                                                                                                                                  if (this$doNotSectionSteelSpec
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$doNotSectionSteelSpec
                                                                                                                                                                        == null
                                                                                                                                                                     : this$doNotSectionSteelSpec.equals(
                                                                                                                                                                        other$doNotSectionSteelSpec
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
                                                                                                                                                                           Object this$inputVATNoFreight = this.getInputVATNoFreight();
                                                                                                                                                                           Object other$inputVATNoFreight = other.getInputVATNoFreight();
                                                                                                                                                                           if (this$inputVATNoFreight
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$inputVATNoFreight
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$inputVATNoFreight.equals(
                                                                                                                                                                                 other$inputVATNoFreight
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
                                                                                                                                                                                    Object this$steelDensity = this.getSteelDensity();
                                                                                                                                                                                    Object other$steelDensity = other.getSteelDensity();
                                                                                                                                                                                    if (this$steelDensity
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$steelDensity
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$steelDensity.equals(
                                                                                                                                                                                          other$steelDensity
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
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof InboundDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isBoolPartyA() ? 79 : 97);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $rejectStatus = this.getRejectStatus();
      result = result * 59 + ($rejectStatus == null ? 43 : $rejectStatus.hashCode());
      Object $qualityTestingEnum = this.getQualityTestingEnum();
      result = result * 59 + ($qualityTestingEnum == null ? 43 : $qualityTestingEnum.hashCode());
      Object $purchaseOrderDetailId = this.getPurchaseOrderDetailId();
      result = result * 59 + ($purchaseOrderDetailId == null ? 43 : $purchaseOrderDetailId.hashCode());
      Object $mergeId = this.getMergeId();
      result = result * 59 + ($mergeId == null ? 43 : $mergeId.hashCode());
      Object $applyPurchaseId = this.getApplyPurchaseId();
      result = result * 59 + ($applyPurchaseId == null ? 43 : $applyPurchaseId.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $materialCodeConfigId = this.getMaterialCodeConfigId();
      result = result * 59 + ($materialCodeConfigId == null ? 43 : $materialCodeConfigId.hashCode());
      Object $inboundWay = this.getInboundWay();
      result = result * 59 + ($inboundWay == null ? 43 : $inboundWay.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
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
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $inboundTime = this.getInboundTime();
      result = result * 59 + ($inboundTime == null ? 43 : $inboundTime.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $rejectList = this.getRejectList();
      result = result * 59 + ($rejectList == null ? 43 : $rejectList.hashCode());
      Object $inboundReceipt = this.getInboundReceipt();
      result = result * 59 + ($inboundReceipt == null ? 43 : $inboundReceipt.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $structureClassify = this.getStructureClassify();
      result = result * 59 + ($structureClassify == null ? 43 : $structureClassify.hashCode());
      Object $adjustDetailList = this.getAdjustDetailList();
      result = result * 59 + ($adjustDetailList == null ? 43 : $adjustDetailList.hashCode());
      Object $sectionSteelSpec = this.getSectionSteelSpec();
      result = result * 59 + ($sectionSteelSpec == null ? 43 : $sectionSteelSpec.hashCode());
      Object $doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
      result = result * 59 + ($doNotSectionSteelSpec == null ? 43 : $doNotSectionSteelSpec.hashCode());
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
      Object $steelDensity = this.getSteelDensity();
      result = result * 59 + ($steelDensity == null ? 43 : $steelDensity.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      result = result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
      Object $realTime = this.getRealTime();
      return result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
   }

   @Override
   public String toString() {
      return "InboundDetailDTO(id="
         + this.getId()
         + ", boolPartyA="
         + this.isBoolPartyA()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", remark="
         + this.getRemark()
         + ", color="
         + this.getColor()
         + ", mete="
         + this.getMete()
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
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshop="
         + this.getWorkshop()
         + ", warehouse="
         + this.getWarehouse()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", inboundTime="
         + this.getInboundTime()
         + ", taxRate="
         + this.getTaxRate()
         + ", rejectStatus="
         + this.getRejectStatus()
         + ", qualityTestingEnum="
         + this.getQualityTestingEnum()
         + ", rejectList="
         + this.getRejectList()
         + ", inboundReceipt="
         + this.getInboundReceipt()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", material="
         + this.getMaterial()
         + ", netWeight="
         + this.getNetWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", structureClassify="
         + this.getStructureClassify()
         + ", adjustDetailList="
         + this.getAdjustDetailList()
         + ", purchaseOrderDetailId="
         + this.getPurchaseOrderDetailId()
         + ", mergeId="
         + this.getMergeId()
         + ", applyPurchaseId="
         + this.getApplyPurchaseId()
         + ", standardId="
         + this.getStandardId()
         + ", sectionSteelSpec="
         + this.getSectionSteelSpec()
         + ", doNotSectionSteelSpec="
         + this.getDoNotSectionSteelSpec()
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
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", steelDensity="
         + this.getSteelDensity()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", materialCodeConfigId="
         + this.getMaterialCodeConfigId()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ", inboundWay="
         + this.getInboundWay()
         + ", realTime="
         + this.getRealTime()
         + ")";
   }

   public InboundDetailDTO(
      final Long id,
      final boolean boolPartyA,
      final Long classifyId,
      final String classifyName,
      final Integer basicClass,
      final String specification,
      final BigDecimal quantity,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final String brand,
      final String heatNoAndBatchNo,
      final String measureUnit,
      final String accountingUnit,
      final String remark,
      final String color,
      final BigDecimal mete,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVAT,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT,
      final ProjectInfo project,
      final Long monomerId,
      final Long areaId,
      final String monomerName,
      final String areaName,
      final Long workshopId,
      final BriefIdAndNameDTO workshop,
      final BriefIdAndNameDTO warehouse,
      final String nationalStandard,
      final Integer invoiceType,
      final LocalDateTime inboundTime,
      final BigDecimal taxRate,
      final Integer rejectStatus,
      final Integer qualityTestingEnum,
      final List<RejectMaterialDTO> rejectList,
      final InboundReceiptDTO inboundReceipt,
      final String serialNumber,
      final String material,
      final BigDecimal netWeight,
      final BigDecimal surfaceArea,
      final NameInfo structureClassify,
      final List<AdjustDetailsDTO> adjustDetailList,
      final Long purchaseOrderDetailId,
      final Long mergeId,
      final Long applyPurchaseId,
      final Long standardId,
      final String sectionSteelSpec,
      final String doNotSectionSteelSpec,
      final BigDecimal amountExcludingVATNoFreight,
      final BigDecimal unitPriceExcludingVATNoFreight,
      final BigDecimal inputVATNoFreight,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal amountNoFreight,
      final Integer weightMeasurementMode,
      final BigDecimal steelDensity,
      final Integer materialIsWhole,
      final Long materialCodeConfigId,
      final String materialSnNew,
      final Integer inboundWay,
      final LocalDateTime realTime
   ) {
      this.id = id;
      this.boolPartyA = boolPartyA;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.basicClass = basicClass;
      this.specification = specification;
      this.quantity = quantity;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.remark = remark;
      this.color = color;
      this.mete = mete;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
      this.project = project;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.workshopId = workshopId;
      this.workshop = workshop;
      this.warehouse = warehouse;
      this.nationalStandard = nationalStandard;
      this.invoiceType = invoiceType;
      this.inboundTime = inboundTime;
      this.taxRate = taxRate;
      this.rejectStatus = rejectStatus;
      this.qualityTestingEnum = qualityTestingEnum;
      this.rejectList = rejectList;
      this.inboundReceipt = inboundReceipt;
      this.serialNumber = serialNumber;
      this.material = material;
      this.netWeight = netWeight;
      this.surfaceArea = surfaceArea;
      this.structureClassify = structureClassify;
      this.adjustDetailList = adjustDetailList;
      this.purchaseOrderDetailId = purchaseOrderDetailId;
      this.mergeId = mergeId;
      this.applyPurchaseId = applyPurchaseId;
      this.standardId = standardId;
      this.sectionSteelSpec = sectionSteelSpec;
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
      this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
      this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
      this.inputVATNoFreight = inputVATNoFreight;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.weightMeasurementMode = weightMeasurementMode;
      this.steelDensity = steelDensity;
      this.materialIsWhole = materialIsWhole;
      this.materialCodeConfigId = materialCodeConfigId;
      this.materialSnNew = materialSnNew;
      this.inboundWay = inboundWay;
      this.realTime = realTime;
   }

   public InboundDetailDTO() {
   }

   public static class InboundDetailDTOBuilder {
      private Long id;
      private boolean boolPartyA;
      private Long classifyId;
      private String classifyName;
      private Integer basicClass;
      private String specification;
      private BigDecimal quantity;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private String brand;
      private String heatNoAndBatchNo;
      private String measureUnit;
      private String accountingUnit;
      private String remark;
      private String color;
      private BigDecimal mete;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVAT;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;
      private ProjectInfo project;
      private Long monomerId;
      private Long areaId;
      private String monomerName;
      private String areaName;
      private Long workshopId;
      private BriefIdAndNameDTO workshop;
      private BriefIdAndNameDTO warehouse;
      private String nationalStandard;
      private Integer invoiceType;
      private LocalDateTime inboundTime;
      private BigDecimal taxRate;
      private Integer rejectStatus;
      private Integer qualityTestingEnum;
      private List<RejectMaterialDTO> rejectList;
      private InboundReceiptDTO inboundReceipt;
      private String serialNumber;
      private String material;
      private BigDecimal netWeight;
      private BigDecimal surfaceArea;
      private NameInfo structureClassify;
      private List<AdjustDetailsDTO> adjustDetailList;
      private Long purchaseOrderDetailId;
      private Long mergeId;
      private Long applyPurchaseId;
      private Long standardId;
      private String sectionSteelSpec;
      private String doNotSectionSteelSpec;
      private BigDecimal amountExcludingVATNoFreight;
      private BigDecimal unitPriceExcludingVATNoFreight;
      private BigDecimal inputVATNoFreight;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal amountNoFreight;
      private Integer weightMeasurementMode;
      private BigDecimal steelDensity;
      private Integer materialIsWhole;
      private Long materialCodeConfigId;
      private String materialSnNew;
      private Integer inboundWay;
      private LocalDateTime realTime;

      InboundDetailDTOBuilder() {
      }

      public InboundDetailDTO.InboundDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder boolPartyA(final boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder inboundTime(final LocalDateTime inboundTime) {
         this.inboundTime = inboundTime;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder rejectStatus(final Integer rejectStatus) {
         this.rejectStatus = rejectStatus;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder qualityTestingEnum(final Integer qualityTestingEnum) {
         this.qualityTestingEnum = qualityTestingEnum;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder rejectList(final List<RejectMaterialDTO> rejectList) {
         this.rejectList = rejectList;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder inboundReceipt(final InboundReceiptDTO inboundReceipt) {
         this.inboundReceipt = inboundReceipt;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder structureClassify(final NameInfo structureClassify) {
         this.structureClassify = structureClassify;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder adjustDetailList(final List<AdjustDetailsDTO> adjustDetailList) {
         this.adjustDetailList = adjustDetailList;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder purchaseOrderDetailId(final Long purchaseOrderDetailId) {
         this.purchaseOrderDetailId = purchaseOrderDetailId;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder mergeId(final Long mergeId) {
         this.mergeId = mergeId;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder applyPurchaseId(final Long applyPurchaseId) {
         this.applyPurchaseId = applyPurchaseId;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder sectionSteelSpec(final String sectionSteelSpec) {
         this.sectionSteelSpec = sectionSteelSpec;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder doNotSectionSteelSpec(final String doNotSectionSteelSpec) {
         this.doNotSectionSteelSpec = doNotSectionSteelSpec;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder amountExcludingVATNoFreight(final BigDecimal amountExcludingVATNoFreight) {
         this.amountExcludingVATNoFreight = amountExcludingVATNoFreight;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder unitPriceExcludingVATNoFreight(final BigDecimal unitPriceExcludingVATNoFreight) {
         this.unitPriceExcludingVATNoFreight = unitPriceExcludingVATNoFreight;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder inputVATNoFreight(final BigDecimal inputVATNoFreight) {
         this.inputVATNoFreight = inputVATNoFreight;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder steelDensity(final BigDecimal steelDensity) {
         this.steelDensity = steelDensity;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder materialCodeConfigId(final Long materialCodeConfigId) {
         this.materialCodeConfigId = materialCodeConfigId;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder inboundWay(final Integer inboundWay) {
         this.inboundWay = inboundWay;
         return this;
      }

      public InboundDetailDTO.InboundDetailDTOBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      public InboundDetailDTO build() {
         return new InboundDetailDTO(
            this.id,
            this.boolPartyA,
            this.classifyId,
            this.classifyName,
            this.basicClass,
            this.specification,
            this.quantity,
            this.thickness,
            this.length,
            this.width,
            this.brand,
            this.heatNoAndBatchNo,
            this.measureUnit,
            this.accountingUnit,
            this.remark,
            this.color,
            this.mete,
            this.unitPrice,
            this.unitPriceExcludingVAT,
            this.amount,
            this.amountExcludingVAT,
            this.inputVAT,
            this.project,
            this.monomerId,
            this.areaId,
            this.monomerName,
            this.areaName,
            this.workshopId,
            this.workshop,
            this.warehouse,
            this.nationalStandard,
            this.invoiceType,
            this.inboundTime,
            this.taxRate,
            this.rejectStatus,
            this.qualityTestingEnum,
            this.rejectList,
            this.inboundReceipt,
            this.serialNumber,
            this.material,
            this.netWeight,
            this.surfaceArea,
            this.structureClassify,
            this.adjustDetailList,
            this.purchaseOrderDetailId,
            this.mergeId,
            this.applyPurchaseId,
            this.standardId,
            this.sectionSteelSpec,
            this.doNotSectionSteelSpec,
            this.amountExcludingVATNoFreight,
            this.unitPriceExcludingVATNoFreight,
            this.inputVATNoFreight,
            this.unitPriceNoFreight,
            this.amountNoFreight,
            this.weightMeasurementMode,
            this.steelDensity,
            this.materialIsWhole,
            this.materialCodeConfigId,
            this.materialSnNew,
            this.inboundWay,
            this.realTime
         );
      }

      @Override
      public String toString() {
         return "InboundDetailDTO.InboundDetailDTOBuilder(id="
            + this.id
            + ", boolPartyA="
            + this.boolPartyA
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", remark="
            + this.remark
            + ", color="
            + this.color
            + ", mete="
            + this.mete
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
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", workshopId="
            + this.workshopId
            + ", workshop="
            + this.workshop
            + ", warehouse="
            + this.warehouse
            + ", nationalStandard="
            + this.nationalStandard
            + ", invoiceType="
            + this.invoiceType
            + ", inboundTime="
            + this.inboundTime
            + ", taxRate="
            + this.taxRate
            + ", rejectStatus="
            + this.rejectStatus
            + ", qualityTestingEnum="
            + this.qualityTestingEnum
            + ", rejectList="
            + this.rejectList
            + ", inboundReceipt="
            + this.inboundReceipt
            + ", serialNumber="
            + this.serialNumber
            + ", material="
            + this.material
            + ", netWeight="
            + this.netWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", structureClassify="
            + this.structureClassify
            + ", adjustDetailList="
            + this.adjustDetailList
            + ", purchaseOrderDetailId="
            + this.purchaseOrderDetailId
            + ", mergeId="
            + this.mergeId
            + ", applyPurchaseId="
            + this.applyPurchaseId
            + ", standardId="
            + this.standardId
            + ", sectionSteelSpec="
            + this.sectionSteelSpec
            + ", doNotSectionSteelSpec="
            + this.doNotSectionSteelSpec
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
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", steelDensity="
            + this.steelDensity
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", materialCodeConfigId="
            + this.materialCodeConfigId
            + ", materialSnNew="
            + this.materialSnNew
            + ", inboundWay="
            + this.inboundWay
            + ", realTime="
            + this.realTime
            + ")";
      }
   }
}
